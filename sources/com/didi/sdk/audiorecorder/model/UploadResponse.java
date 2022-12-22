package com.didi.sdk.audiorecorder.model;

import java.io.Serializable;

public class UploadResponse implements Serializable {
    public String errmsg;
    public int errno;
    public int retry;

    public interface Retry {
        public static final int NEED = 1;
        public static final int NO_NEED = 0;
    }

    public String toString() {
        return "UploadResponse{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", retry=" + this.retry + '}';
    }
}
