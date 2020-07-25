package com.jak;

import java.util.List;

import org.hibernate.Session;

import com.jak.model.Student;

public class HibernateMain {
	private static int id;


	public static int insertStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		id = (int) session.save(student);
		session.getTransaction().commit();
		session.close();
		return 0;
	}
	
	public static void  updateStudent(int id, Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student stud = session.get(Student.class, 2);
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Student> getAllStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> studentList = session.createQuery("FROM students").list();
		session.getTransaction().commit();
		session.close();
		return studentList;
	}
	
	
	public static void main(String[] args) {
		
		/*
		Student studen1 = new Student("King","Kocher");
		int student_id = insertStudent(studen1);
		System.out.println("Student details are inserted with id :"+student_id);
		*/
		
		/*
		List<Student> students = getAllStudent();
		for(Student student : students) {
			System.out.println(student.getFirstName());
		}
		*/
		
		Student student1 = new Student("John","Travolta");
		updateStudent(2,student1);
	}
}
