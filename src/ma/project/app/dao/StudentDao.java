package ma.project.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import ma.project.app.models.Student;

public class StudentDao {
	
	private ResultSet rs = null;
	private PreparedStatement statement = null;
	
	private final String jdbcURL = "jdbc:mysql://localhost:3306/tpjee";
	private final String username = "root";
	private final String password = "";
		
	private final String SELECT_ALL_STUDENTS = "SELECT * FROM students;";
	private final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?;";
	private final String SELECT_STUDENT_BY_NAME = "SELECT * FROM students WHERE first_name = ? or last_name = ?;";
	
	private final String CREATE_NEW_STUDENT = "INSERT INTO students(student_id, first_name, last_name, school, study_option, registration_year) VALUES(?, ?, ?, ?, ?, ?);";
	private final String DELETE_STUDENT_BY_ID = "DELETE FROM students WHERE id = ?;";
	private final String UPDATE_STUDENT_BY_ID = "UPDATE students SET student_id = ?, first_name = ?, last_name = ?, school = ?, study_option = ?, registration_year = ? WHERE id = ?;"; 
	
	public StudentDao(){
		
	}
	
	private Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
		
//	Create New Student
	public void createNewStudent(Student student){
		try {
			Connection connection = getConnection();
			statement = connection.prepareStatement(this.CREATE_NEW_STUDENT);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getFirstname());
			statement.setString(3, student.getLastname());
			statement.setString(4, student.getSchool());
			statement.setString(5, student.getStudyOption());
			statement.setString(6, student.getRegistrationYear());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	Get All Students
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		try {
			Connection connection = getConnection();
			statement = connection.prepareStatement(SELECT_ALL_STUDENTS);
			rs = statement.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String studentId = rs.getString("student_id");
				String school = rs.getString("school");
				String studyOption = rs.getString("study_option");
				String registratioYear = rs.getString("registration_year");
				students.add(new Student(id, studentId, firstName, lastName, school, studyOption, registratioYear));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

//	Get Student By ID
	public Student getStudentById(int id){
		if (id <= 0) new RuntimeException("Id doit etre superieur a 0");
		
		Connection connection = getConnection();
		int s_id = -1;
		String firstName = null;
		String lastName = null;
		String studentId = null;
		String school = null;
		String studyOption = null;
		String registratioYear = null;
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			
			while(rs.next()){
				s_id = rs.getInt("id");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				studentId = rs.getString("student_id");
				school = rs.getString("school");
				studyOption = rs.getString("study_option");
				registratioYear = rs.getString("registration_year");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student(s_id, studentId, firstName, lastName, school, studyOption, registratioYear);
	}

//	Delete Student By ID
	public Boolean deleteSudent(int id){
		Boolean delete = null;
		Student student = this.getStudentById(id);
		if (student == null) new RuntimeException("Student Not Found.");
		Connection connection = getConnection();
		try {
			statement = connection.prepareStatement(this.DELETE_STUDENT_BY_ID);
			statement.setInt(1, id);
			delete = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}

//	Update Student
	public Boolean update(Student student){
		Boolean update =null;
		Connection connection = getConnection();
		try {
			statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
			statement.setString(1, student.getStudentId());
			statement.setString(2, student.getFirstname());
			statement.setString(3, student.getLastname());
			statement.setString(4, student.getSchool());
			statement.setString(5, student.getStudyOption());
			statement.setString(6, student.getRegistrationYear());
			statement.setInt(7, student.getId());
			update = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
//	Search By Name
	public List<Student> searchByName(String search){
		List<Student> students = new ArrayList<>();
		Connection connection = getConnection();
		try {
			if (search != "") {
				statement = connection.prepareStatement(SELECT_STUDENT_BY_NAME);
				statement.setString(1, search);
				statement.setString(2, search);
			}else{
				statement = connection.prepareStatement(this.SELECT_ALL_STUDENTS);
			}
			rs = statement.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String studentId = rs.getString("student_id");
				String school = rs.getString("school");
				String studyOption = rs.getString("study_option");
				String registratioYear = rs.getString("registration_year");
				students.add(new Student(id, studentId, firstName, lastName, school, studyOption, registratioYear));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
}



