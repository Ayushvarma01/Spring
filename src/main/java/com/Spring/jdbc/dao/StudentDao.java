package com.Spring.jdbc.dao;

import java.util.List;

import com.Spring.jdbc.Student;

public interface StudentDao {
	public int insert(Student student);

	public int update(Student student);

	public int delete(Student student);
	
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();
	
}
