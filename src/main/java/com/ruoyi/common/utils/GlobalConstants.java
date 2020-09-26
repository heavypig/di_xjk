package com.ruoyi.common.utils;

public class GlobalConstants {

	//未处理的案件类型
	public static final String IS_OUT_WITHOUT = "0";
	//已处理的案件类型
	public static final String IS_OUT_ALREADY = "1";

	//流程类型
	public static final String IS_NOT_PULL = "10";//待签收
	public static final String IS_NOT_DEAL = "20";//已签收
	public static final String IS_OK_REACH = "30";//已到达
	public static final String IS_OK_DEAL = "40";//已完成
	public static final String IS_OK_BACK = "50";//已退回

	/*//流程类型
	public static final String IS_NOT_PULL = "0";//待签收
	public static final String IS_NOT_DEAL = "1";//已签收
	public static final String IS_OK_DEAL = "2";//已完成
	public static final String IS_OK_BACK = "3";//已退回
	public static final String IS_OK_REACH = "4";//已到达*/

	//派单状态
	public static final String OK_SEND_ORDERS = "0";//未派单
	public static final String NOT_SEND_ORDERS = "1";//已派单
}
