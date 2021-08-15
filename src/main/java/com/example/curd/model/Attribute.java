package com.example.curd.model;

import java.net.URL;

import javax.persistence.Embeddable;

@Embeddable
public class Attribute {

	private String number;
	private String short_desc;
	private String long_desc;
	private URL url;

	public Attribute(String number, String short_desc, String long_desc, URL url) {
		super();
		this.number = number;
		this.short_desc = short_desc;
		this.long_desc = long_desc;
		this.url = url;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getShort_desc() {
		return short_desc;
	}

	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}

	public String getLong_desc() {
		return long_desc;
	}

	public void setLong_desc(String long_desc) {
		this.long_desc = long_desc;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Attribute() {
		super();
	}

	@Override
	public String toString() {
		return "Attribute [number=" + number + ", short_desc=" + short_desc + ", long_desc=" + long_desc + ", url="
				+ url + "]";
	}

}
