package com.QuantumFinance.net.base;

import java.io.Serializable;

public class RecommendBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -971852327365717705L;
	private String deadline;// "11",
	private String eair;// "14.50%",
	private int id;// 32,
	private String schedule;// "100%",
	private String source;// "aitouzi",
	private String title;// "汽车销售企业新车采购（二..."
	private String logo;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getEair() {
		return eair;
	}

	public void setEair(String eair) {
		this.eair = eair;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
