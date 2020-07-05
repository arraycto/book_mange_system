package com.bm.book_manage_system.utils.result;

/**
 * 响应前台的方法
 */
public class RetResponse {
    private final static String SUCCESS = "success";

    private final static String FAIL = "failed";

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> Result<T> makeErrRsp(String message) {
        return new Result<T>().setCode(ResultCode.FAIL).setMsg(message);
    }

    public static <T> Result<T> makeRsp(int code, String msg) {
        return new Result<T>().setCode(code).setMsg(msg);
    }

    public static <T> Result<T> makeRsp(int code, String msg, T data) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data);
    }
}
