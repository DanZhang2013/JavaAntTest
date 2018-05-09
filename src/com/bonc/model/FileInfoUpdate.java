package com.bonc.model;

public class FileInfoUpdate {
	
	private String fileName;//文件名
	private String fileSize;//文件大小
	private String fileType;//文件类型
	private String fileVersionNo;//文件版本号
	private String userDefined;//文件自定义信息
	public FileInfoUpdate(String fileName, String fileSize, String fileType, String fileVersionNo, String userDefined) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileVersionNo = fileVersionNo;
		this.userDefined = userDefined;
	}
	
	public FileInfoUpdate() {
		super();
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileVersionNo() {
		return fileVersionNo;
	}
	public void setFileVersionNo(String fileVersionNo) {
		this.fileVersionNo = fileVersionNo;
	}
	public String getUserDefined() {
		return userDefined;
	}
	public void setUserDefined(String userDefined) {
		this.userDefined = userDefined;
	}

	@Override
	public String toString() {
		return "FileInfoUpdate [fileName=" + fileName + ", fileSize=" + fileSize + ", fileType=" + fileType
				+ ", fileVersionNo=" + fileVersionNo + ", userDefined=" + userDefined + "]";
	}
	
	
	
}
