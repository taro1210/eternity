package beans;

import java.io.InputStream;
import java.io.Serializable;

public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String photoId;
	private InputStream photo;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
}
