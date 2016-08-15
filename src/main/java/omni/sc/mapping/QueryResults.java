package omni.sc.mapping;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryResults {

	@JsonProperty("indexLastUpdatedDate")
	private String indexLastUpdatedDate;

	@JsonProperty("searchResponse")
	private SearchResponse searchResponse;
	
	@JsonProperty("queryId")
	private String queryId;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The indexLastUpdatedDate
	 */
	@JsonProperty("indexLastUpdatedDate")
	public String getIndexLastUpdatedDate() {
		return indexLastUpdatedDate;
	}

	/**
	 * 
	 * @param indexLastUpdatedDate
	 *            The indexLastUpdatedDate
	 */
	@JsonProperty("indexLastUpdatedDate")
	public void setIndexLastUpdatedDate(String indexLastUpdatedDate) {
		this.indexLastUpdatedDate = indexLastUpdatedDate;
	}

	/**
	 * 
	 * @return The searchResponse
	 */
	@JsonProperty("searchResponse")
	public SearchResponse getSearchResponse() {
		return searchResponse;
	}

	/**
	 * 
	 * @param searchResponse
	 *            The searchResponse
	 */
	@JsonProperty("searchResponse")
	public void setSearchResponse(SearchResponse searchResponse) {
		this.searchResponse = searchResponse;
	}

	/**
	 * 
	 * @return The queryId
	 */
	@JsonProperty("queryId")
	public String getQueryId() {
		return queryId;
	}

	/**
	 * 
	 * @param queryId
	 *            The queryId
	 */
	@JsonProperty("queryId")
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}