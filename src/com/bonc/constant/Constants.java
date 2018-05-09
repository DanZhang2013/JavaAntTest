package com.bonc.constant;
/**
 * 常用字符串 代表成功及失败
 * @author zydev293
 * @date 20170922
 */
public class Constants {

	//总体成功和错误标示
	public static final String SUCCESS_CODE="0000";//成功标示
	
	public static final String ERROR_CODE_NULL="E001";//必传项为空错误标示
	
	public static final String ERROR_CODE_NOT_SAME="E002";//必传项不匹配
	
	public static final String ERROR_CODE_NOT_EXIST="E003";//不存在错误
	
	public static final String ERROR_CODE_ERROR_INPUT="E004";//报文信息输入错误
	
	public static final String ERROR_CODE="E005";//其他具体错误
	
	//---------------------登录相关：登录失败原因-------------------
	
	public static final String ERRORR_ESMSG="请求失败";
	
	public static final String ERROR_DROWSSAP ="密码错误";
	
	public static final String ERROR_USERNAME ="用户名不存在";
	
	public static final String ERROR_USERNAMEDROWSSAP = "用户名或密码为空";
	
	public static final String ERRORR_EASIONHTABLE = "业务表不存在";
	
	//------------------------hbase业务表信息--------------------------
	
	public static final String HBASE_FAMILY="family_xml";
	
	public static final String HBASE_TABLE="tab_xml";
	
	public static final String HBASE_COLUMN="col_xml";
	
	public static final String TRANSTABNAME="tab_trans";
	
	public static final String TRANSFAMILY="trans_family";
	
	public static final String TRANSCOL="col_val";
	
	public static final String VERSION_COLUMN="version_column";
	
	public static final String HBASE_QUERY_VALUE="value";
	
	public static final String TRANS_IS_BUSY="busy now";
	
	//-----------------------批次信息上传---------------------
	
	public static final String BATCH_ERRORMESSAGE = "批次信息上传失败";
	
	public static final String BATCH_UPDATE_ERRORMESSAGE = "批次信息更新失败";
	
	public static final String BATCH_SUCCESS_MESSAGE = "批次信息上传成功";
	
	public static final String LOGIN_SUCCESS_MESSAGE = "登录成功";
	
	public static final String DELETE_SUCCESS = "删除成功";
	
	public static final String BATCH_UPDATE_SUCCESS_MSG = "批次信息更新成功";
	//失败原因
	public static final String ERROR_METHOD = "请求方法不存在";
	
	public static final String NULL_METHOD = "请求方法为空";
	
	public static final String UUID_NULL_ERROR="UUID为空";
	
	public static final String TYPE_NULL_ERROR="必传项有空";
	
	public static final String UUID_INVALID="UUID已失效 请重新登录";
	
	public static final String YEWU_NULL_ERROR="业务系统标示为空";
	
	public static final String BATCHNO_NULL_ERROR="批次号为空";
	
	public static final String VERSIONNO_NULL_ERROR="版本号为空";
	
	public static final String VERSIONNO_TOO_LOW="版本号小于2";
	
	public static final String OPERATIONFLAG_NULL_ERROR="操作标示为空";
	
	public static final String FILENAME_NULL_ERROR="文件名为空";
	
	public static final String FILETYPE_NULL_ERROR="文件类型为空";
	
	public static final String OPERAFLAG_NULL_ERROR="操作标示为空";
	
	public static final String OPERAFLAG_NOT_SAME="操作标示不匹配";
	
	public static final String OPERAFLAG_ERROR="操作标示错误";
	
	public static final String OPERATIONFLAG_ERRORR="操作标示非0或1";
	
	public static final String BATCH_EXIST_ERROR="批次信息已存在";
	
	public static final String BATCH_EXIST_E="该批次已上传完成，不要重复操作";
	
	public static final String BATCH_NO_EXIST_ERROR="批次信息不存在";
	
	public static final String HBASE_NO_EXIST_ERRO="Hbase中无信息";
	
	public static final String SYSTEM_TYPE_ERROR="业务系统标示输入错误";
	
	public static final String FILESIZE_NULL_ERROR="文件大小为空";
	
	public static final String BATCH_STORE_ERROR="批次信息存储失败";
	
	public static final String HBASE_NULL_TAB_ERROR="HBase业务表不存在";
	
	public static final String NULL_PERMISSION="您没有权限操作";
	
	public static final String ERROR_BATCHNO_VERNO="批次号或版本号有误";
	
	public static final String ERROR_HBASE_FILEINFO="HBASE要更新的文件不存在";
	
	public static final String ERROR_ES_FILEINFO="ES要更新的文件不存在";
	
	public static final String FILEINFO_UPDATE="文件属性更新成功";
	
	public static final String FILEINFO_UPDATE_FILED="属性更新失败";
	
	//----------------------上传文件-------------------------------
	//匹配信息相关
	public static final String FILE_ERRORMESSAGE="批次文件上传失败";
	
	public static final String UNKNOW_ERROR="未知异常";
	
	public static final String FILE_SUCCESSMESSAGE="批次文件上传成功";
	
	public static final String BATCHNO_NOT_SAME="批次号不匹配";
	
	public static final String VERSIONMO_NOT_SAME="版本号不匹配";
	
	public static final String SYS_BATCH_VER_ERROR="业务系统标示 批次号或版本号有错误";
	
	public static final String UUID_NOT_SAME="UUID不匹配";
	
	public static final String OPERATIONFLAG_NOT_SAME="操作标识不匹配";
	
	public static final String YEWUSYSTEM_NOT_SAME="业务系统标识不匹配";
	
	public static final String FILENAME_NOT_SAME="文件名称不一致";
	
	public static final String BATCH_NOT_PERMISSION="当前批次不允许操作";
	
	public static final String OPERATION_FLAG_NOT0="操作标示不正确";
		
	public static final String VERSION_NOT_EXIST="被更新版本不存在或已删除";
	
	public static final String UPDATE_ERROR="更新失败";
	
	public static final String NOT_NEW_VERSION="要更新的不是最新版本";
	
	public static final String VERSION_NOT_EXIST_FILE="文件不存在请先上传";
	
	public static final String ERROR_OPERATION="操作失败";
	
	public static final String UUID_ERROR="UUID失效或没有权限";

	//查询文件相关--成功标志

	public static final String QUERY_SUCCMSG = "查询成功";

	//查询文件相关--错误标志

	public static final String ERROR_MSG = "查询失败";
	
	public static final String FILEREADFAIED_MSG = "文件读取失败";
	
	public static final String FILENOTEXISTS_MSG = "该文件不存在";
	
	public static final String ERROR_INPUT="报文信息错误";
	
	public static final String FILE_NAME_ERROR = "文件名错误";
	
	public static final String SERVER_ERROR="服务器返回流失败";
	
	public static final String BATCH_NOT_EXISTS="该批次不存在";
	
	public static final String ISPAGED_NULL_ERROR = "分页标志为空";
	
	public static final String ISPAGED_ERROR_VALUE="分页标志非0且非1";
	
	public static final String PAGESIZE_NULL_ERROR = "分页大小为空";
	
	public static final String PAGENO_NULL_ERROR = "当前页码为空";
			
	public static final String PAGENO_ERROR_VALUE = "当前页码无效";
	
	public static final String PAGESIZE_ERROR_VALUE = "分页大小无效";
	
	public static final String NO_RESULT = "查询无结果";
			
	//----------------删除文件相关
	public static final String DELETE_ERROR_MSG = "删除失败";
	
	public static final String DELETE_SUCCESS_MSG ="删除成功";

	public static final String NO_FILENAME = "缺少文件名";
	
	public static final String NO_VERSIONNO = "缺少版本号";
	
	public static final String NO_FILE = "该版本下无文件";
	
	public static final String NOT_LATEST_VERSIONNO ="不是最新版本";
	
	public static final String BATCH_NO_ERROR ="要更新批次不存在";
	
	public static final String FILE_NOT_EXIST ="要删除的文件不存在";
	
	public static final String BATCHNO_OR_SYSTEMTYPE_ERROR ="批次号或业务系统标识错误";
	
	public static final String NO_FILE_DELETE ="没有可删除文件";
	
	//ES查询相关
	public static final int  PAGESIZE = 50;

	//--------------------Hbase定义---------------------------
	public static final String HBASE_TAB="tab_";
	
	public static final String HBASE_FAMILYY_CF1="CF1";
	
	public static final String HBASE_FAMILYY_CF2="CF2";
	
	public static final String HBASE_COLUMN_B="B";
	
	public static final String HBASE_COLUMN_S="S";
	
	public static final String HBASE_COLUMN_F="F";
	
	public static final String HBASE_COLUMN_CF="C/F";
	
	public static final String HBASE_COLUMN_L="L";
	
	public static final String HBASE_COLUMN_E="E";
	
	//destoryKey
	public static final String INVALID_SESSION_MSG="session已经失效";
	
	public static final String DESTORY_KEY_ERROR="结束会话失败";

	public static final String DESTORY_KEY_SUCCESS="结束会话成功";
	
	//-------------------------------分隔符----------------------------
	
	public static final String SPLIT="~";//文件之间分隔符
	
	public static final String SPLITF="_";//文件版本号之间分隔符

	//配置相关
	public static final String ESCLUSTERNAME="cluster.name";
	
	public static final String ESIPKEY="ESIP";
	
	public static final String CLUSTERNAME="clusterName";
	
}