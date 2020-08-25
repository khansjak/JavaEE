package com.hibernate.util;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AppMain {
	public static void main(String args[]) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		//System.out.println("Find all employees :::");
		
		
		//Query query= session.createSQLQuery("call findAllEmployees()");
		//List result = query.list();
		
		//StoredProcedureQuery allEmployees = session.createStoredProcedureQuery("findAllEmployees");
		StoredProcedureQuery department = session.createStoredProcedureQuery("findEmployeesByDept");
		department.registerStoredProcedureParameter("emp_department",String.class,ParameterMode.IN);
		department.setParameter("emp_department", "Technology");
		department.execute();
		List  dlist= department.getResultList();
		for(Object employee : dlist) {
			System.out.println(employee);
		}
		

		StoredProcedureQuery desig_count = session.createStoredProcedureQuery("employeesCountByDesignation");
		desig_count.registerStoredProcedureParameter("emp_designation",String.class,ParameterMode.IN);
		desig_count.registerStoredProcedureParameter("designation_count",Integer.class,ParameterMode.OUT);
		desig_count.setParameter("emp_designation", "Associate");
		desig_count.execute();
		Integer result1 = (Integer) desig_count.getOutputParameterValue("designation_count");

		System.out.println("No of Employee :"+result1);

	}

}
