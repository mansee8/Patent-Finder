package omni.sc.mapping;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeader {

	@JsonProperty("status")
	private Integer status;
	
	@JsonProperty("QTime")
	private Integer qTime;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The status
	 */
	@JsonProperty("status")
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	@JsonProperty("status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The qTime
	 */
	@JsonProperty("QTime")
	public Integer getQTime() {
		return qTime;
	}

	/**
	 * 
	 * @param qTime
	 *            The QTime
	 */
	@JsonProperty("QTime")
	public void setQTime(Integer qTime) {
		this.qTime = qTime;
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