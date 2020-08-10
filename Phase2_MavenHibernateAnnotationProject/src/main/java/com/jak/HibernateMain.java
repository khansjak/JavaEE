package com.jak;

import org.hibernate.Session;

import com.jak.entities.Student;

public class HibernateMain {
	
	public static int insertStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (Integer) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	

	public static void main(String[] args) {
		
		Student student_one = new Student("King","Kocher","kkocher@gmail.com");
		int student_one_id = insertStudent(student_one);
		System.out.println("Student information saved with id :"+student_one_id);
		
	}

}
