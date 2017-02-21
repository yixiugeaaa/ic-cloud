package com.iot.common;

/**
 * @Description:返回值及返回描述
 * @author xiuge
 * @date 2016年7月11日上午9:27:33
 */
public enum ReturnCode {
	No_Err(1,"请求成功","success"),
	No_SendMsgOK(1,"短信发送成功","success"),
	No_CheckMsgCodeOK(1,"短信验证成功","success"),
	No_ChangePwdOK(1,"修改密码成功","success"),
	No_RegisterOK(1,"注册成功","success"),
	No_UpLoadOK(1,"上传成功","success"),
	No_SetAlarmPhoneOK(1,"设置报警手机号成功","success"),
	Err_RequestFailed(-1,"请求失败","error"),
	Err_AccessTokenExpire(-2,"用户登录信息失效","warn"),
	Err_AccessTokenNotExist(-3,"用户登录信息不存在，请重新登录","warn"), 
	Err_UserNotExist(-4,"用户不存在","error"),
	Err_PwdError(-5,"密码错误","warn"),
	Err_NoMatchingData(-6,"没有匹配数据","error"),
	Err_IllegalNullParam(-7,"必须参数不可以为空","error"),
	Err_PhoneExist(-8,"手机号已存在","error"),
	Err_ErrPhoneFormat(-9,"手机格式不正确","warn"),
	Err_DatabaseError(-10,"数据库错误","error"),
	Err_DeviceNotFound(-11,"设备不存在","warn"),
	Err_NotOnlyOneDeviceFound(-12,"设备不唯一","warn"),
	Err_NoPower(-13,"权限不足","error"),
	Err_AddDeviceFailor(-14,"添加设备失败","error"),
	Err_AddSettingFailor(-15,"添加设备设置失败","error"),
	Err_DeviceAlreadyBound(-16,"设备已经被绑定","warn"),
	Err_NoDateOfChannel(-17,"该通道没有数据","warn"),
	Err_UserRegisterAlready(-18,"用户手机号已注册","warn"),
	Err_ChNoNotExit(-19,"通道编号不存在","error"),
	Err_recordTypeNotExit(-20,"数据类型不存在","error"),
	Err_SendMsgFailor(-21,"短信发送失败","error"),
	Err_CheckMsgCodeFailor(-22,"短信验证失败","error"),
	Err_RegisterFailor(-23,"注册失败","error"),
	Err_UpdateUserFailor(-24,"修改用户失败","error"),
	Err_SettingIllegal(-25,"上限必须高于下限","error"),
	Err_UploadMax(-26,"上传文件大小超过限制","error"),
	Err_UploadTypeError(-27,"上传文件类型错误","error"),
	Err_SetAlarmPhoneFailor(-28,"设置报警手机号失败","error"),
	Err_DeviceListIsNull(-29,"设备列表为空","warn"),
	Err_DeviceManageListIsNull(-30,"未查询到设备管理信息","error"),
	;
	
	private int code;
	
	private String description;
	
	private String type;
	
	ReturnCode(int code,String description,String type) {
		this.code=code;
		this.description=description;
		this.type=type;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getType(){
		return this.type;
	}
	
	public static ReturnCode stateOf(int index) {
		
		for (ReturnCode state:values()) {
			if (state.getCode()==index) {
				return state;
			}
		}
		return null;
	}
}
