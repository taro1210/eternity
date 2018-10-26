package beans;

import java.io.Serializable;

public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	private int    id;		// プライマリキー
	private String dptId;	// 部署ID
	private String dptName;	// 部署名

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDptId() {
		return dptId;
	}
	public void setDptId(String dptId) {
		this.dptId = dptId;
	}
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
}
