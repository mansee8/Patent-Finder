package omni.sc.model;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omni.sc.mapping.Body;
import omni.sc.mapping.Doc;

public class Mapper {

	/*
	 * Logging
	 */
	final static Logger LOG = Logger.getLogger(Mapper.class.getName());

	/*
	 * Patent object
	 */
	static Patent patent = new Patent();
	
	/*
	 * Round 3 Decimals
	 */
	static DecimalFormat df3 = new DecimalFormat("###.###");
	
	/*
	 * App Filing Date
	 */
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	
	/*
	 * Store output docs
	 */
	static JSONArray patentOutput = new JSONArray();
	static JSONObject queryJSONOutput = new JSONObject();
	
	
	public JSONObject getQueryJsonOutput() throws JSONException, JsonParseException, JsonMappingException, IOException, ParseException {

		LOG.info("Starting processing of PAIR Bulk Data Query : Patents from last year");

		String start = "0"; // Parameter used to paginate results.
		int docCount = 0, totalDocCount; // document processed and total number
											// of documents

		/*
		 * Loop until all documents are not processed
		 */
		while (true) {

			String pairQuery = Query.constructQuery(start);
			String queryOutput = Query.retrieveQueryData(pairQuery);

			ObjectMapper mapper = new ObjectMapper();
			Body docBody = mapper.readValue(queryOutput, Body.class);

			List<Doc> docs = docBody.getQueryResults().getSearchResponse().getResponse().getDocs();

			/*
			 * COnvert document to json output
			 */
			for (Doc d : docs) {

				patent.setId(d.getId());
				patent.setTitle(d.getPatentTitle());
				patent.setInvestors( d.getRankAndInventorsListStr().toArray(new String[0]));
				patent.setStatus(d.getAppStatus());

				// convert string to date
				Date date = formatter.parse(d.getAppFilingDate().replaceAll("T", " ").replaceAll("Z", ""));
				patent.setFilingDate(date);

				String jsonStr = mapper.writeValueAsString(patent);
				
				patentOutput.put(jsonStr);
			}

			/*
			 * Get number of documents in current query and total number of
			 * result documents
			 */
			docCount += docs.size();
			totalDocCount = docBody.getQueryResults().getSearchResponse().getResponse().getNumFound();

			/*
			 * Check if number of processed documents is equal to total number
			 * of queried documents
			 */
			if (docCount + 1 >= totalDocCount)
				break;

			LOG.info("Number of Documents processed = " + df3.format(docCount * 100.0 / totalDocCount) + "%");

			start = Integer.toString(docCount);
		}
		
		/*
		 * Construct query json output
		 */
		queryJSONOutput.put("docs", patentOutput);
		queryJSONOutput.put("docsFound", totalDocCount);
		queryJSONOutput.put("query", Query.constructQuery("0"));
		
		return queryJSONOutput;
	}
}
