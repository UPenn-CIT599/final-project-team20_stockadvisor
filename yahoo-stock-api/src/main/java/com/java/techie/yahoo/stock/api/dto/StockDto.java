package com.java.techie.yahoo.stock.api.dto;

import java.math.BigDecimal;

public class StockDto {
	private String name;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	private BigDecimal bid;
	
	public StockDto(String name, BigDecimal price, BigDecimal change, String currency, BigDecimal bid) {
		this.name = name;
		this.price = price;
		this.change = change;
		this.currency = currency;
		this.bid = bid;
	}
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public BigDecimal getChange() {
		return change;
	}
	public String getCurrency() {
		return currency;
	}
	public BigDecimal getBid() {
		return bid;
	}
}
