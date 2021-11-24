package ma.project.app.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.project.app.dao.StudentDao;
import ma.project.app.models.Student;
import ma.project.app.shared.ViewsAppConst;

@WebServlet(urlPatterns={"/students", "/student"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao;
	private RequestDispatcher dispatcher;
//	private List<Student> students;
	
	
    @Override
	public void init() throws ServletException {
    	
    	this.studentDao = new StudentDao();
	}

	public StudentController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/students")) {
			HomeStudent(response, request);
			return;
		}
		String action = request.getParameter("page");
		switch (action) {
			case "search":
				searchStudent(response, request);
				break;
			
			case "create":
				createStudent(response, request);
				break;
			
			case "edit":
				editStudent(response, request);
				break;
			
			case "delete":
				deleteStudent(response, request);
				break;
			
			case "confdelete":
				confDeleteStudent(response, request);
				break;
				
			case "update":
				updateStudent(response, request);
				break;
			
			case "add":
				addStudent(response, request);
				break;
			
			default:
				HomeStudent(response, request);
				break;
		}
	}

	private void searchStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		String search = request.getParameter("search");
		List<Student> students = studentDao.searchByName(search);
		request.setAttribute("students", students);
		request.getRequestDispatcher(ViewsAppConst.VIEWS_STUDENTS + "index.jsp").forward(request, response);
	}

	private void confDeleteStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean delete = studentDao.deleteSudent(id);
		if (delete == true) {
			response.sendRedirect("students");
		}
	}

	private void HomeStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		List<Student> students = studentDao.getAllStudents();
		request.setAttribute("students", students);
		request.getRequestDispatcher(ViewsAppConst.VIEWS_STUDENTS + "index.jsp").forward(request, response);
	}

	private void deleteStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		request.getRequestDispatcher(ViewsAppConst.VIEWS_STUDENTS+"delete.jsp").forward(request, response);
	}

	private void createStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String school = request.getParameter("school");
		String studyOption = request.getParameter("studyOption");
		String registrationYear = request.getParameter("registrationYear");
		
		Student student = new Student(studentId, firstname, lastname, school, studyOption, registrationYear);
		System.out.println(student.getLastname());
		studentDao.createNewStudent(student);
		
		response.sendRedirect("students");
	}

	private void addStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.getRequestDispatcher(ViewsAppConst.VIEWS_STUDENTS + "create.jsp").forward(request, response);
	}

	private void updateStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String studentId = request.getParameter("studentId");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String school = request.getParameter("school");
		String studyOption = request.getParameter("studyOption");
		String registrationYear = request.getParameter("registrationYear");
		Student student = new Student(id, studentId, firstname, lastname, school, studyOption, registrationYear);
		
		Boolean update = studentDao.update(student);
		
		if (update == true) {
			response.sendRedirect("students");
		}
	}

	private void editStudent(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentDao.getStudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher(ViewsAppConst.VIEWS_STUDENTS + "edit.jsp").forward(request, response);
	}
}
