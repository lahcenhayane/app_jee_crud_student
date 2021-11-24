package ma.project.app.models;

public class Student {

	private int id;
	private String studentId;
	private String firstname;
	private String lastname;
	private String school;
	private String studyOption;
	private String registrationYear;
	
	public Student() {
		super();
	}
	public Student(int id, String studentId, String firstname, String lastname, String school, String studyOption,
			String registrationYear) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.school = school;
		this.studyOption = studyOption;
		this.registrationYear = registrationYear;
	}
	public Student( String studentId, String firstname, String lastname, String school, String studyOption, String registrationYear) {
		super();
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.school = school;
		this.studyOption = studyOption;
		this.registrationYear = registrationYear;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStudyOption() {
		return studyOption;
	}
	public void setStudyOption(String studyOption) {
		this.studyOption = studyOption;
	}
	public String getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}
	
	
	
}
