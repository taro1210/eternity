package model;

public class UserAccount {
	private String userId;
	private String name;
	private int age;
	private String gender;
	private String tellNumber;
	private String mail;
	private String pass;
	private String belong;

	public UserAccount(String userId, String name, int age, String gender, String tellNumber, String mail, String pass,
			String belong) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tellNumber = tellNumber;
		this.mail = mail;
		this.pass = pass;
		this.belong = belong;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}
}
