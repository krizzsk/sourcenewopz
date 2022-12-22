package com.squareup.haha.perflib;

import org.apache.commons.p071io.IOUtils;

public class StackFrame {
    public static final int COMPILED_METHOD = -2;
    public static final int NATIVE_METHOD = -3;
    public static final int NO_LINE_NUMBER = 0;
    public static final int UNKNOWN_LOCATION = -1;
    String mFilename;
    long mId;
    int mLineNumber;
    String mMethodName;
    int mSerialNumber;
    String mSignature;

    public StackFrame(long j, String str, String str2, String str3, int i, int i2) {
        this.mId = j;
        this.mMethodName = str;
        this.mSignature = str2;
        this.mFilename = str3;
        this.mSerialNumber = i;
        this.mLineNumber = i2;
    }

    private String lineNumberString() {
        int i = this.mLineNumber;
        if (i == -3) {
            return "Native method";
        }
        if (i == -2) {
            return "Compiled method";
        }
        if (i != -1) {
            return i != 0 ? String.valueOf(i) : "No line number";
        }
        return "Unknown line number";
    }

    public final String toString() {
        return this.mMethodName + this.mSignature.replace(IOUtils.DIR_SEPARATOR_UNIX, '.') + " - " + this.mFilename + ":" + lineNumberString();
    }
}
