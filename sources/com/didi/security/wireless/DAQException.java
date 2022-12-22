package com.didi.security.wireless;

public class DAQException extends Exception {
    public static int WSG_CODE_DATAENC_UNSUPPORTED = 197;
    public static int WSG_CODE_INPUTNULL = 195;
    public static int WSG_CODE_LOAD_FAIL = 198;
    public static int WSG_CODE_NOTINIT = 101;
    public static int WSG_CODE_OK = 0;
    public static int WSG_CODE_SIGN_CHARACTEREXCEPTION = 196;
    private static final long serialVersionUID = 3466003883368143973L;
    private int ecode;

    public DAQException(int i) {
        this.ecode = i;
    }

    public DAQException(int i, String str) {
        super(str);
        this.ecode = i;
    }

    public int getErrorCode() {
        return this.ecode;
    }
}
