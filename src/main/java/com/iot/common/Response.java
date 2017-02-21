
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.database.bean
* @file XmlResult.java
* 
* @date 2014-2-25-上午10:29:54
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/

package com.iot.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.BindingResult;


public class Response<T> implements Serializable {
	/**
	 * 创建一个新的实例 XmlResult.
	 *
	 */
	public Response() {
	}

	public Response(BindingResult bindingResult) {
		this.description = bindingResult.getAllErrors().get(0).getDefaultMessage();
		this.status = "error";
		this.code = -100;
	}

	public Response(CustomException customException) {
		this.setCode(customException.getExceptionCode());
		this.setStatus(customException.getType());
		this.setDescription(customException.getMessage());
		// this.setExceptionType(customException.getClass().getSimpleName());
	}

	// 异常类型
	// private String exceptionType;

	/**
	 * status: success error
	 */
	private String status;

	/**
	 * description 描述失败的原因
	 */
	private String description;

	/** code 接口调用返回状态码 */
	private int code;

	/**
	 * numReturn 返回的对象的个数，如果返回的是list，则是list的中的对象个数
	 */
	private int numReturn;

	/**
	 * result 返回的对象
	 */
	private T result;

	/**
	 * result
	 *
	 * @return the result
	 * @since 1.0.0
	 */

	public T getResult() {
		return result;
	}

	/**
	 * @param status
	 *            the status to set
	 */

	/**
	 * @param result
	 *            the result to set
	 */

	public void setResult(T result) {
		this.result = result;
		if (result instanceof List) {
			this.numReturn = ((List) result).size();// 如果result为列表数据，numReturn设为列表长度
		}
		setInfos(ReturnCode.No_Err);
	}

	/**
	 * numReturn
	 *
	 * @return the numReturn
	 * @since 1.0.0
	 */

	public int getNumReturn() {
		return numReturn;
	}

	/**
	 * @param numReturn
	 *            the numReturn to set
	 */

	public void setNumReturn(int numReturn) {
		this.numReturn = numReturn;
	}

	/**
	 * status
	 *
	 * @return the status
	 * @since 1.0.0
	 */

	public String getStatus() {
		return status;
	}

	/**
	 * description
	 *
	 * @return the description
	 * @since 1.0.0
	 */

	public String getDescription() {
		return description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param description
	 *            the description to set
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public void setInfos(ReturnCode returnCode) {
		this.code = returnCode.getCode();
		this.description = returnCode.getDescription();
		this.status = returnCode.getType();
		if (returnCode.equals(ReturnCode.Err_RequestFailed)) {// 请求失败，result设为空
			this.result = null;
		}
	}

}
