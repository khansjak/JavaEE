package com.jak.OneToMany;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StockDailyRecord")
public class StockDailyRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	private Float priceOpen;
	private Float priceClose;
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	private Stock stock;
	
	

	public StockDailyRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public StockDailyRecords(Float priceOpen, Float priceClose, Date date, Stock stock) {
		super();
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.date = date;
		this.stock = stock;
	}



	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Float getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Float getPriceClose() {
		return priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
