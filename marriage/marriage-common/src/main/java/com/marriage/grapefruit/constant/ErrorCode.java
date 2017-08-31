package com.marriage.grapefruit.constant;

public class ErrorCode {

    public static final int SERVER_INTERNAL_ERROR = 1000;
    public static final int PARAMETER_MISSING_ERROR = 1001;
    public static final int PARAMETER_ILLEGAL_ERROR = 1002;
    public static final int RESOURCE_NOT_FOUND_ERROR = 1003;
    
    
    public static final int LOGIN_SUCCESS = 0;
    public static final int LOGIN_FAILED = -1;
    public static final int LOGIN_OUT_SUCCESS = -2;
    
    

    /**
     * Prevent instantiation
     */
    private ErrorCode() {
    }

}
