package com.didi.aoe.library.api.interpreter;

public final class InterpreterInitResult {

    /* renamed from: a */
    private int f8169a;

    /* renamed from: b */
    private String f8170b;

    /* renamed from: a */
    private static String m5297a(int i) {
        switch (i) {
            case -2:
                return "STATUS_INNER_ERROR";
            case -1:
                return "STATUS_UNDEFINE";
            case 0:
                return "STATUS_OK";
            case 1:
                return "STATUS_CONFIG_PARSE_ERROR";
            case 2:
                return "STATUS_CONNECTION_WAITTING";
            case 3:
                return "STATUS_MODEL_DOWNLOAD_WAITING";
            case 4:
                return "STATUS_MODEL_LOAD_FAILED";
            default:
                return "UNKNOWN";
        }
    }

    private InterpreterInitResult(int i, String str) {
        this.f8169a = i;
        this.f8170b = str;
    }

    public int getCode() {
        return this.f8169a;
    }

    public void setCode(int i) {
        this.f8169a = i;
    }

    public String getMsg() {
        return this.f8170b;
    }

    public void setMsg(String str) {
        this.f8170b = str;
    }

    public static InterpreterInitResult create(int i) {
        return create(i, m5297a(i));
    }

    public static InterpreterInitResult create(int i, String str) {
        return new InterpreterInitResult(i, str);
    }

    public String toString() {
        return "InterpreterInitResult{code=" + this.f8169a + ", msg='" + this.f8170b + '\'' + '}';
    }
}
