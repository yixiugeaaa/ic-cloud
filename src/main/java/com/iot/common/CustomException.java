/**
 * <p>Title: ShundrException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: shundr</p>
 * @author Wei.Guo
 * @date 2015-7-18
 * @version 1.0
 */

package com.iot.common;

/**
 * 自定义异常
 * @author xiuge
 * 2016年7月18日下午7:22:46
 */
public class CustomException extends RuntimeException {

	private ReturnCode returnCode=null;
	
	private static final long serialVersionUID = 4394654420077125815L;
	
	public CustomException(ReturnCode returnCode) {
		super(returnCode.getDescription());
		this.returnCode = returnCode;
	}
	
	public CustomException(String msg) {
		super(msg);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	public CustomException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public String getExceptionCause(){
		return returnCode.getDescription();
	}
	
	public Integer getExceptionCode(){
		if (returnCode==null) {
			return 0;
		}else {
			return returnCode.getCode();
		}
	}
	
	public String getType(){
		if (returnCode==null) {
			return "error";
		}else {
			return returnCode.getType();
		}
	}

}

