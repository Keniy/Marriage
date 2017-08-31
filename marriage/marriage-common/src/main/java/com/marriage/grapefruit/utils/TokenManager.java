package com.marriage.grapefruit.utils;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class TokenManager {
	
	public static String generate(String password, String salt){
		if(!StringUtils.isBlank(password) && !StringUtils.isBlank(salt)){
			return MD5Util.encode(password, salt);
		}
		return null;
	}
	
	public String generateNewToken() {
		return UUID.randomUUID().toString();
	}
}
