package com.didichuxing.diface.appeal.mexico.request;

import java.io.Serializable;

public class AppealParam implements Serializable {
    public int bizCode;
    public String language;
    public String sessionId;
    public String token;

    public int getBizCode() {
        return this.bizCode;
    }

    public String getToken() {
        return this.token;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getLanguage() {
        return this.language;
    }
}
