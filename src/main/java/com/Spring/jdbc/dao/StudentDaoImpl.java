package com.Spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Spring.jdbc.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int insert(Student student) {
		String insert = "insert into student(id, name, city) values(?,?,?)";
		int result = this.jdbctemplate.update(insert, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int update(Student student) {
		String update = "update student set name = ? , city = ? where id = ? ";
		int result = this.jdbctemplate.update(update, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int delete(Student student) {
		String delete = "delete from student where id = ?";
		int result = this.jdbctemplate.update(delete, student.getId());
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
		// selecting multiple student
		String qurey = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student studnet = this.jdbctemplate.queryForObject(qurey, rowMapper, studentId);
		return studnet;
	}

	@Override
	public List<Student> getAllStudent() {
		// selecting multiple rows from database
		String select = "select * from student ";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> student = this.jdbctemplate.query(select, rowMapper);
		return student;
	}

}
