package com.lab.housing.model;

public class City {

	private String abbr;
	private String name;

	public City() {
	}

	public City(String abbr, String name) {
		super();
		this.abbr = abbr;
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [abbr=" + abbr + ", name=" + name + "]";
	}

}
