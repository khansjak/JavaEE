package com.jak.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private String stockCode;
	private String stockName;
	@OneToMany(mappedBy = "stock", fetch = FetchType.LAZY )
	private Set<StockDailyRecords> stockDailyRecords = new HashSet<StockDailyRecords>(0);
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String stockCode, String stockName) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
	}
	
	

	public Stock(String stockCode, String stockName, Set<StockDailyRecords> stockDailyRecords) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}



	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	@Column(name = "Stock_Code", nullable = false)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "Stock_Name", nullable = false)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Set<StockDailyRecords> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecords> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	


}