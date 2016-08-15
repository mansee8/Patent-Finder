package omni.sc.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	@JsonProperty("numFound")
	private Integer numFound;

	@JsonProperty("start")
	private Integer start;

	@JsonProperty("docs")
	private List<Doc> docs = new ArrayList<Doc>();

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The numFound
	 */
	@JsonProperty("numFound")
	public Integer getNumFound() {
		return numFound;
	}

	/**
	 * 
	 * @param numFound
	 *            The numFound
	 */
	@JsonProperty("numFound")
	public void setNumFound(Integer numFound) {
		this.numFound = numFound;
	}

	/**
	 * 
	 * @return The start
	 */
	@JsonProperty("start")
	public Integer getStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 *            The start
	 */
	@JsonProperty("start")
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * 
	 * @return The docs
	 */
	@JsonProperty("docs")
	public List<Doc> getDocs() {
		return docs;
	}

	/**
	 * 
	 * @param docs
	 *            The docs
	 */
	@JsonProperty("docs")
	public void setDocs(List<Doc> docs) {
		this.docs = docs;
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