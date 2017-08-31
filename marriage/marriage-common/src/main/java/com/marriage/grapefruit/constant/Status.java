package com.marriage.grapefruit.constant;

public class Status {
	
	public static enum LOGIN{
		IN(1000, "登录成功"),
		FAILED(1001, "登录失败"),
		OUT(1002, "登出成功"),
		UNLOGIN(1003, "未登录")
		;
		
		private final Integer code;
		private final String name;
		
		private LOGIN(Integer code, String name) {
			this.code = code;
			this.name = name;
		}

		public Integer getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}
}
