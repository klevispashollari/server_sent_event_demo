package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class StockPrice {

	private String companyName;
	private String price;
	private String change;
	private String value;
	private String status;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StockPrice(String companyName, String price, String change, String value, String status) {
		super();
		this.companyName = companyName;
		this.price = price;
		this.change = change;
		this.value = value;
		this.status = status;
	}

	@Override
	public String toString() {
		return "StockPrice [companyName=" + companyName + ", price=" + price + ", change=" + change + ", value=" + value
				+ ", status=" + status + "]";
	}

}
