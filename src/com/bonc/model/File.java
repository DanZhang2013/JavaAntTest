package com.bonc.model;

public class File {

	private String fileName;
	private String versionNo;
	public File(String fileName, String versionNo) {
		super();
		this.fileName = fileName;
		this.versionNo = versionNo;
	}
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	
}
