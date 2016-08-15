package omni.sc.mapping;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {

	@JsonProperty("links")
	private List<Link> links = new ArrayList<Link>();
	
	@JsonProperty("queryResults")
	private QueryResults queryResults;
	
	@JsonProperty("jobStatus")
	private Object jobStatus;
	
	@JsonProperty("queryId")
	private String queryId;
	
	@JsonProperty("page")
	private Integer page;
	
	@JsonProperty("count")
	private Integer count;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The links
	 */
	@JsonProperty("links")
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * 
	 * @param links
	 *            The links
	 */
	@JsonProperty("links")
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	/**
	 * 
	 * @return The queryResults
	 */
	@JsonProperty("queryResults")
	public QueryResults getQueryResults() {
		return queryResults;
	}

	/**
	 * 
	 * @param queryResults
	 *            The queryResults
	 */
	@JsonProperty("queryResults")
	public void setQueryResults(QueryResults queryResults) {
		this.queryResults = queryResults;
	}

	/**
	 * 
	 * @return The jobStatus
	 */
	@JsonProperty("jobStatus")
	public Object getJobStatus() {
		return jobStatus;
	}

	/**
	 * 
	 * @param jobStatus
	 *            The jobStatus
	 */
	@JsonProperty("jobStatus")
	public void setJobStatus(Object jobStatus) {
		this.jobStatus = jobStatus;
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

	/**
	 * 
	 * @return The page
	 */
	@JsonProperty("page")
	public Integer getPage() {
		return page;
	}

	/**
	 * 
	 * @param page
	 *            The page
	 */
	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 
	 * @return The count
	 */
	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	/**
	 * 
	 * @param count
	 *            The count
	 */
	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
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
