package com.bonc.model;

public class FileInfo {
	
	/**
	 * 文件名
	 */
	private String fileName;
	
	/**
	 * 文件类型
	 */
	private String fileType;
	
	/**
	 * 文件大小
	 */
	private String fileSize;
	
	/**
	 * 自定义属性
	 */
	private String userDefined;
	
	/**
	 * 文件校验码
	 */
	private String fileMD5;
	
	/**
	 * 文件版本号
	 */
	private String fileVersionNO;
	

	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileInfo(String fileName, String fileType, String fileSize, String userDefined, String fileVersionNO) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.userDefined = userDefined;
		this.fileVersionNO = fileVersionNO;
	}
	public FileInfo(String fileName, String fileType, String fileSize, String userDefined,
			String fileMD5,String fileVersionNO) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.userDefined = userDefined;
		this.fileMD5=fileMD5;
		this.fileVersionNO = fileVersionNO;
	}

	public String getFileVersionNO() {
		return fileVersionNO;
	}
	
	public void setFileVersionNO(String fileVersionNO) {
		this.fileVersionNO = fileVersionNO;
	}
	public String getFileMD5() {
		return fileMD5;
	}

	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getUserDefined() {
		return userDefined;
	}

	public void setUserDefined(String userDefined) {
		this.userDefined = userDefined;
	}
	
}
