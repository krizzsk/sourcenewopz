package com.didichuxing.diface.appeal.mexico;

import java.io.Serializable;

public class GlobalSubmitParam implements Serializable {
    public String extra = "{}";
    public String faceSessionId;
    public String language;
    public String token;

    public String getToken() {
        return this.token;
    }

    public String getFaceSessionId() {
        return this.faceSessionId;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getExtra() {
        return this.extra;
    }
}
