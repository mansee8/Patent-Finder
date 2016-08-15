package omni.sc.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Main {
	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, JSONException, IOException, ParseException {

		/*
		 * Get json output of query
		 */
		Mapper mapper = new Mapper();
		JSONObject jsonOutput = mapper.getQueryJsonOutput();

		/*
		 * Save json output to file
		 */
		try (PrintWriter out = new PrintWriter("queryOutput.json")) {
			out.println(jsonOutput.toString(2).replaceAll("\\\\\"", "\""));
		}
	}
}
