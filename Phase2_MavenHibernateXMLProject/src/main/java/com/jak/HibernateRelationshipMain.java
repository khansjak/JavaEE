package com.jak;

import java.util.Date;

import org.hibernate.Session;

import com.jak.OneToMany.Stock;
import com.jak.OneToMany.StockDailyRecords;

public class HibernateRelationshipMain {

	public static void main(String[] args) {
		Stock stock = new Stock();
		stock.setStockName("HDFC");
		stock.setStockCode("HD001");
		
		StockDailyRecords stockDailyRecords = new StockDailyRecords();
		stockDailyRecords.setDate(new Date());
		stockDailyRecords.setPriceOpen(123.45F);
		stockDailyRecords.setPriceClose(234.45F);
		StockDailyRecords stockDailyRecords2 = new StockDailyRecords();
		stockDailyRecords2.setDate(new Date());
		stockDailyRecords2.setPriceOpen(123.45F);
		stockDailyRecords2.setPriceClose(234.45F);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(stock);
		stockDailyRecords.setStock(stock);
		stockDailyRecords2.setStock(stock);
		session.getTransaction().commit();
		session.close();
		
	}

}
