package com.bonc.model;

public class FileStoreInfo {

	private String file_U_Name;//本次文件名
	private String file_Sign;//操作标志
	private String file_N_Name;//最新文件名
	private String version_No;//最新版本号
	public FileStoreInfo() {
		super();
	}
	public FileStoreInfo(String file_U_Name, String file_Sign, String file_N_Name, String version_No) {
		super();
		this.file_U_Name = file_U_Name;
		this.file_Sign = file_Sign;
		this.file_N_Name = file_N_Name;
		this.version_No = version_No;
	}
	public String getFile_U_Name() {
		return file_U_Name;
	}
	public void setFile_U_Name(String file_U_Name) {
		this.file_U_Name = file_U_Name;
	}
	public String getFile_Sign() {
		return file_Sign;
	}
	public void setFile_Sign(String file_Sign) {
		this.file_Sign = file_Sign;
	}
	public String getFile_N_Name() {
		return file_N_Name;
	}
	public void setFile_N_Name(String file_N_Name) {
		this.file_N_Name = file_N_Name;
	}
	public String getVersion_No() {
		return version_No;
	}
	public void setVersion_No(String version_No) {
		this.version_No = version_No;
	}
	
	
	
	
}
