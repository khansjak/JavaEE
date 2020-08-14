package com.jak;

import java.util.List;

import org.hibernate.Session;

import com.jak.beans.Student;

public class HibernateMain {
	
	public static int insertStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int) session.save(student);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	
	public static List<Student> getAllStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> studentList = session.createQuery("FROM Student").list();
		session.getTransaction().commit();
		session.close();
		return studentList;
		
	}
	
	public static void updateStudent(int id,Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student stud = session.get(Student.class, 7);
		stud.getFirstName();
		stud.getLastName();
		//we not need to update manually as it willl be updated automatically on transaction close
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	public static void deleteStudent(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student stud = session.get(Student.class, 1);
		session.delete(stud);
		session.getTransaction().commit();
		session.close();
	}
	

	public static void main(String[] args) {
		//Student student = new Student("Ramya","Shetty");

		
		//int id1 = insertStudent(student);
		//System.out.println("Student details daved with Id: "+id1);
		


		
		/*List<Student> students = getAllStudent();
		for(Student student : students ) {
			System.out.println(student.getFirstName());
		}
		
		Student student1 = new Student("Billie","Fernando");
		updateStudent(7,student1);
		*/
		
		deleteStudent(2);
		
		

	}

}
