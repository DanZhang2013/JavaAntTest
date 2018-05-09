package com.bonc.model;

import java.util.List;

/**
* @author
*/
public class BatchInfo {

	/**
	 * 批次号
	 */
	private String batchNo;
	
	/**
	 * 版本号
	 */
	private String versionNo;
	
	/**
	 * 批次用户自定义
	 */
	private String batchUserDefined;
	
	private List<FileInfo> fileInfos;

	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getBatchUserDefined() {
		return batchUserDefined;
	}

	public void setBatchUserDefined(String batchUserDefined) {
		this.batchUserDefined = batchUserDefined;
	}
	
	
}
