package com.didichuxing.diface.appeal.mexico.model;

import java.io.Serializable;
import java.util.List;

public class AppealParameters implements Serializable {
    private List<AppealAdditionTypesBean> appealAdditionTypes;
    private String appealFailPageFineBody;
    private int bizCode;
    private String sessionId;
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getBizCode() {
        return this.bizCode;
    }

    public void setBizCode(int i) {
        this.bizCode = i;
    }

    public String getAppealFailPageFineBody() {
        return this.appealFailPageFineBody;
    }

    public void setAppealFailPageFineBody(String str) {
        this.appealFailPageFineBody = str;
    }

    public List<AppealAdditionTypesBean> getAppealAdditionTypes() {
        return this.appealAdditionTypes;
    }

    public void setAppealAdditionTypes(List<AppealAdditionTypesBean> list) {
        this.appealAdditionTypes = list;
    }
}
