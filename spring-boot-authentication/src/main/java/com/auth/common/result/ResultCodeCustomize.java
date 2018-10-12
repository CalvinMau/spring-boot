package com.auth.common.result;

/**
 * The enum Result code customize.
 *
 * @ClassName ResultCodeCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
public enum ResultCodeCustomize {

    /**
     * Success result code customize.
     */
    SUCCESS("E000000", "Successful"),

    /**
     * The Fail.
     */
    FAIL("E000001", "Operation failed"),

    /**
     * The Data is have.
     */
    DATA_IS_HAVE("E000002", "Data already exists"),

    /**
     * The Not data.
     */
    NOT_DATA("E000003", "No result"),

    /**
     * Not login result code customize.
     */
    NOT_LOGIN("E000004", "Not"),

    /**
     * The Exception.
     */
    EXCEPTION("E000005", "An exception occurs"),

    /**
     * The Sys error.
     */
    SYS_ERROR("E000006", "System exception"),

    /**
     * The Params error.
     */
    PARAMS_ERROR("E000007", "Parameter exception "),

    /**
     * The Not supported.
     */
    NOT_SUPPORTED("E000008", "Not support"),

    /**
     * The Invalid authcode.
     */
    INVALID_AUTHCODE("E000009", "Invalid AuthCode"),

    /**
     * The Too frequent.
     */
    TOO_FREQUENT("E000010", "Too request calls"),

    /**
     * The Unknown error.
     */
    UNKNOWN_ERROR("E000011", "Unknown mistake"),

    /**
     * The Not method.
     */
    NOT_METHOD("E000012", "Not method found");

    private ResultCodeCustomize(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    /**
     * Val string.
     *
     * @return the string
     */
    public String val() {
        return val;
    }

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
