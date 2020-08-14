package com.jak;



import java.util.Date;

import org.hibernate.Session;

import com.jak.OneToManyRelationship.Stock;
import com.jak.OneToManyRelationship.StockDailyRecord;

public class HibernateRelationshipMain {

	public static void main(String[] args) {
		Stock stock = new Stock();
		stock.setStockName("HDFC");
		stock.setStockCode("HD001");
		
		StockDailyRecord stockDailyRecord1 = new StockDailyRecord();
		stockDailyRecord1.setDate(new Date());
		stockDailyRecord1.setPriceOpen(123.45F);
		stockDailyRecord1.setPriceClose(124.45F);


		StockDailyRecord stockDailyRecord2 = new StockDailyRecord();
		stockDailyRecord2.setDate(new Date());
		stockDailyRecord2.setPriceOpen(123.45F);
		stockDailyRecord2.setPriceClose(124.45F);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(stock);
		stockDailyRecord1.setStock(stock);
		stockDailyRecord2.setStock(stock);
		session.save(stockDailyRecord1);
		session.save(stockDailyRecord2);
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
		

	}

}
