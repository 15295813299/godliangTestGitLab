package com.god.common.resp;

import com.alibaba.fastjson.JSONObject;
import com.god.common.constant.ResponseCodeConstants;
import com.god.common.constant.ResponseMsgConstants;

import java.io.Serializable;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/7/18 17:35
 * @description： TODO
 */
public class ResponseCode implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public ResponseCode() {
    }

    public ResponseCode(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseCode(int code, String msg) {
        this(code,msg,null);
    }

    /**
     * 自定义全部参数
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseCode customize(int code,String msg,Object data) {
        return new ResponseCode(code,msg,data);
    }

    public static ResponseCode success() {
        return new ResponseCode(ResponseCodeConstants.SUCCESS, ResponseMsgConstants.SUCCESS,null);
    }

    public static ResponseCode success(String msg) {
        return new ResponseCode(ResponseCodeConstants.SUCCESS, msg,null);
    }


    public static ResponseCode success(Object data) {
        return new ResponseCode(ResponseCodeConstants.SUCCESS, ResponseMsgConstants.SUCCESS,data);
    }

    public static ResponseCode success(String msg,Object data) {
        return new ResponseCode(ResponseCodeConstants.SUCCESS, msg,data);
    }

    public static ResponseCode error(String msg) {
        return new ResponseCode(ResponseCodeConstants.ERROR, msg,null);
    }

    public static ResponseCode error(int code, String msg) {
        return new ResponseCode(code, msg,null);
    }

    public static ResponseCode error(Object data) {
        return new ResponseCode(ResponseCodeConstants.ERROR, ResponseMsgConstants.ERROR,data);
    }

    public static ResponseCode error() {
        return new ResponseCode(ResponseCodeConstants.ERROR, ResponseMsgConstants.ERROR,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
