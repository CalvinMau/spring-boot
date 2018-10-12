package com.auth.common.result;

import com.google.gson.annotations.Expose;
import java.util.List;

/**
 * The type Result customize.
 *
 * @ClassName ResultCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
public class ResultCustomize {

    @Expose
    private String code;

    @Expose
    private String message;

    @Expose
    private Object data;

    @Expose
    private int total;

    @Expose
    private List<Object> rows;

    /**
     * Instantiates a new Result customize.
     */
    public ResultCustomize() {
        this.setCode(ResultCodeCustomize.SUCCESS);
        this.setMessage("Success ！");
    }

    /**
     * Instantiates a new Result customize.
     *
     * @param code the code
     */
    public ResultCustomize(ResultCodeCustomize code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    /**
     * Instantiates a new Result customize.
     *
     * @param code    the code
     * @param message the message
     */
    public ResultCustomize(ResultCodeCustomize code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets rows.
     *
     * @return the rows
     */
    public List getRows() {
        return rows;
    }

    /**
     * Sets rows.
     *
     * @param rows the rows
     */
    public void setRows(List<Object>  rows) {
        this.rows = rows;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(ResultCodeCustomize code) {
        this.code = code.val();
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Object data) {
        this.data = data;
    }


}
