package omni.sc.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Query {

	/*
	 * Logging
	 */
	final static Logger LOG = Logger.getLogger(Query.class.getName());

	/*
	 * Retrieve patents filed in the previous year with respect to today
	 */
	final static int PREVIOUS_YEAR = Calendar.getInstance().get(Calendar.YEAR) - 1;

	/*
	 * PAIR BULK URL to issue a query against the underlying Solr search engine
	 */
	private static String API_URL = "https://pbd-prod-elb.uspto.gov/api/queries";

	/**
	 * Returns the JSON output of a PAIR Bulk Data API query which is passed to
	 * the underlying Solr search engine.
	 * 
	 * @param query
	 *            PAIR Bulk Data API query
	 * 
	 * @return JSON results of the query
	 */
	public static String retrieveQueryData(String query) {

		LOG.info("Retrieving JSON data using PBD API");

		StringBuilder sb = new StringBuilder();

		try {
			URL url = new URL(API_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(query.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String tmp = null;
			while ((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			LOG.warning("Malformed URL exception encountered. Verify URL: " + e.toString());
		} catch (IOException e) {
			LOG.warning("Input Output exception encountered. Verify code: " + e.toString());
		}

		return sb.toString();
		
	}

	/**
	 * Construct a PAIR Bulk Data query to parse patents with previous year as
	 * filing year
	 * 
	 * @param start
	 *            Parameter used to paginate results.
	 * 
	 * @return PAIR Bulk Data query which is passed to
	 *         {@link #retrieveQueryData(String)}
	 * @throws JSONException
	 */
	public static String constructQuery(String start) throws JSONException {
		
		/*
		 * Construct json object for PAIR query
		 */
		JSONObject query = new JSONObject();
		query.put("searchText", Integer.toString(PREVIOUS_YEAR));	// query to be issued
		query.put("qf", "appFilingYear");							// search fields
		query.put("facet", "false");	
		query.put("start", start);									// paginate results

		/*
		 * Construct json array for PAIR filter query
		 */
		String filterQuery = "appFilingYear: " + Integer.toString(PREVIOUS_YEAR);
		JSONArray filter = new JSONArray();
		filter.put(filterQuery);

		query.put("fq", filter);

		return query.toString();
		
	}
}
