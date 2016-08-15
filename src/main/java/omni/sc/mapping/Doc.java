package omni.sc.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Doc {

	@JsonProperty("id")
	private String id;

	@JsonProperty("patentTitle")
	private String patentTitle;

	@JsonProperty("applId")
	private String applId;

	@JsonProperty("appFilingDate")
	private String appFilingDate;

	@JsonProperty("appType")
	private String appType;

	@JsonProperty("rankAndInventorsList_str")
	private List<String> rankAndInventorsListStr = new ArrayList<String>();

	@JsonProperty("appStatus")
	private String appStatus;

	@JsonProperty("appLocation")
	private String appLocation;

	@JsonProperty("appFilingYear")
	private Integer appFilingYear;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The patentTitle
	 */
	@JsonProperty("patentTitle")
	public String getPatentTitle() {
		return patentTitle;
	}

	/**
	 * 
	 * @param patentTitle
	 *            The patentTitle
	 */
	@JsonProperty("patentTitle")
	public void setPatentTitle(String patentTitle) {
		this.patentTitle = patentTitle;
	}

	/**
	 * 
	 * @return The applId
	 */
	@JsonProperty("applId")
	public String getApplId() {
		return applId;
	}

	/**
	 * 
	 * @param applId
	 *            The applId
	 */
	@JsonProperty("applId")
	public void setApplId(String applId) {
		this.applId = applId;
	}

	/**
	 * 
	 * @return The appFilingDate
	 */
	@JsonProperty("appFilingDate")
	public String getAppFilingDate() {
		return appFilingDate;
	}

	/**
	 * 
	 * @param appFilingDate
	 *            The appFilingDate
	 */
	@JsonProperty("appFilingDate")
	public void setAppFilingDate(String appFilingDate) {
		this.appFilingDate = appFilingDate;
	}

	/**
	 * 
	 * @return The appType
	 */
	@JsonProperty("appType")
	public String getAppType() {
		return appType;
	}

	/**
	 * 
	 * @param appType
	 *            The appType
	 */
	@JsonProperty("appType")
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * 
	 * @return The rankAndInventorsListStr
	 */
	@JsonProperty("rankAndInventorsList_str")
	public List<String> getRankAndInventorsListStr() {
		return rankAndInventorsListStr;
	}

	/**
	 * 
	 * @param rankAndInventorsListStr
	 *            The rankAndInventorsList_str
	 */
	@JsonProperty("rankAndInventorsList_str")
	public void setRankAndInventorsListStr(List<String> rankAndInventorsListStr) {
		this.rankAndInventorsListStr = rankAndInventorsListStr;
	}

	/**
	 * 
	 * @return The appStatus
	 */
	@JsonProperty("appStatus")
	public String getAppStatus() {
		return appStatus;
	}

	/**
	 * 
	 * @param appStatus
	 *            The appStatus
	 */
	@JsonProperty("appStatus")
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	/**
	 * 
	 * @return The appLocation
	 */
	@JsonProperty("appLocation")
	public String getAppLocation() {
		return appLocation;
	}

	/**
	 * 
	 * @param appLocation
	 *            The appLocation
	 */
	@JsonProperty("appLocation")
	public void setAppLocation(String appLocation) {
		this.appLocation = appLocation;
	}

	/**
	 * 
	 * @return The appFilingYear
	 */
	@JsonProperty("appFilingYear")
	public Integer getAppFilingYear() {
		return appFilingYear;
	}

	/**
	 * 
	 * @param appFilingYear
	 *            The appFilingYear
	 */
	@JsonProperty("appFilingYear")
	public void setAppFilingYear(Integer appFilingYear) {
		this.appFilingYear = appFilingYear;
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