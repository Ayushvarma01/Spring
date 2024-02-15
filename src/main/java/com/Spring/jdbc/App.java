package com.Spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Spring.jdbc.dao.StudentDao;

public class App {
	public static void main(String[] args) {
//		JdbcTemplate jdbctemplate;
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/Spring/jdbc/jdbc.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
		JdbcTemplate JdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

// 		String Query = "insert into student(id,name,city) values(?,?,?)";
//		int result = template.update(Query, 1, "Ayush", "mumbai");
//		int result = template.update(Query, 2, "ayush varma", "maharashtra");
//		int result = template.update(Query, 3, "aadi", "malad east");
//		int result = template.update(Query, 4, "sakshi", "malad");
//		int result1 = template.update(Query, 5, "aadi varma", "malad west");

		StudentDao studentdao = context.getBean("studentDao", StudentDao.class);

		/* insert row into database */
//		Student student = new Student();
//		student.setId(12);
//		student.setName("john");
//		student.setCity("new york");
//		int insert = studentdao.insert(student);
//		System.out.println("one row is inserted "+insert);

		/* update row to database */
//		Student student = new Student();
//		student.setId(11);
//		student.setName("Ayush varma");
//		student.setCity("mumbai");
//		int update = studentdao.update(student);
//		System.out.println("one row data in updated "+update);

		/* delete row from database */
//		Student student = new Student();
//		student.setId(5);
//		int delete = studentdao.delete(student);
//		System.out.println(delete);

		/* fetch single row from database */
//		Student select = studentdao.getStudent(1);
//		System.out.println(select);

		/* fetch all row from database */
		List<Student> selectAll = studentdao.getAllStudent();
		for (Student result : selectAll) {
			System.out.println(result);
		}
	}
}
