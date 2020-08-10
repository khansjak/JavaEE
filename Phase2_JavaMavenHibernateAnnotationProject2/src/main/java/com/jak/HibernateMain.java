package com.jak;

import org.hibernate.Session;

import com.jak.entity.Student;

public class HibernateMain {
	
	//Insert new student
	public static int insertStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id= (int) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	

	public static void main(String[] args) {
		
		Student student_one = new Student("King","Kocher","kk@gmail.com");
		int student_one_id = insertStudent(student_one);
		System.out.println("Student saved with id :"+student_one_id);
	}

}
