package com.bonc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MD5Util {
	private static Log logger = LogFactory.getLog(MD5Util.class);
    /**
     * 根据字符串生成MD5码
     * @param str
     * @return
     * @author zydev293
     */
    public  String StringToMD5(String str){
    	String MD5="";
    	MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			
			byte []b=md.digest();
			int i=0;
			StringBuffer sb=new StringBuffer("");
			for(int j=0;j<b.length;j++){
				i=b[j];
				if(i<16){
					i+=256;
				}
				if(i<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(i));
			}
			MD5=sb.toString();
			
			
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(),e);
		}
		return MD5;
    }
    
    
    
    
    /**
     * 密码加密，用于验证文件上传等，校验登录密码
     * @param content
     * @return string
     * @author zydev293
     */
	public static String stringToMD5(String content) {
		if(content==null){
			return null;
		}
		char[] array = content.toCharArray();
		for (int i = 0; i < array.length; i++) {
			int singlec = (int)array[i];
			array[i] = (char)(singlec + 2);
		}
		byte[] b = Base64.encodeBase64(new String(array).getBytes(), false);
		return new String(b);
    }
    
}
