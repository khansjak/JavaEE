package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.ContractEmp;
import com.hibernate.model.Emp;
import com.hibernate.model.RegularEmp;

public class TPHMain {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Emp e1 = new Emp();
		e1.setName("King");
		
		RegularEmp regemp = new RegularEmp();
		regemp.setSalary(20);
		regemp.setBonus(123);
		
		ContractEmp conemp = new ContractEmp();
		conemp.setPayPerHour(12);
		conemp.setContractDuration("3");
		transaction.commit();
		session.close();
		

	}

}
