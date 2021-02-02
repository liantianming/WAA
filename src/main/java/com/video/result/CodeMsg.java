package com.video.result;

public class CodeMsg {

    private int code;
    private String msg;

    //视频错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg VIDEO_IS_EMPTY = new CodeMsg(500100, "视频文件为空");
    public static CodeMsg VIDEO_SiZE_LESS = new CodeMsg(500101, "视频文件大小有问题");
    public static CodeMsg VIDEO_SERVER_ERROR = new CodeMsg(500102, "服务器异常");
    public static CodeMsg VIDEO_ERROR = new CodeMsg(500103, "文件异常");

    // 5002XX

    private CodeMsg() {
    }

    private CodeMsg( int code,String msg ) {
        this.code = code;
        this.msg = msg;
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

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}