package com.jak;

import org.hibernate.Session;

import com.jak.entity.Student;

public class HibernateMain {
	
	public static int insertStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	

	public static void main(String[] args) {
		
		Student student1= new Student("Prerana","Dave","p@gmail.com");
		int student1_id= insertStudent(student1);
		System.out.println("Student saved with id : "+student1_id);
	}

}
