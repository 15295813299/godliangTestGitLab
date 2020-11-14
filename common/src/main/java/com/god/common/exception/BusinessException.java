package com.god.common.exception;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/7/18 17:35
 * @description： 自定义异常类
 */
public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    protected final String message;

    public BusinessException(String message)
    {
        this.message = message;
    }

    public BusinessException(String message, Throwable e)
    {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
