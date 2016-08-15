package omni.sc.model;

import java.util.Date;

public class Patent {

	/**
	 * Patent model class
	 */
	private String id;
	private String title;
	private String status;
	private Date filingDate;
	private String[] investors;

	/*
	 * Getters and Setters
	 */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}
	public String[] getInvestors() {
		return investors;
	}
	public void setInvestors(String[] investors) {
		this.investors = investors;
	}
	
	
}
