package com.video.result;


public class RResult<T> {

    private int code;
    private long count;
    private String msg;
    private T data;

    /**
     *  成功时候的调用
     * */
    public static  <T> RResult<T> success(T data){
        return new RResult<T>(data);
    }

    /**
     *  失败时候的调用
     * */
    public static  <T> RResult<T> error(CodeMsg codeMsg){
        return new RResult<T>(codeMsg);
    }

    private RResult(T data) {
        this.data = data;
    }

    private RResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private RResult(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}