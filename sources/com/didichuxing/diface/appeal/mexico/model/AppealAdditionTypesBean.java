package com.didichuxing.diface.appeal.mexico.model;

import java.io.Serializable;
import java.util.List;

public class AppealAdditionTypesBean implements Serializable {
    private String desc;
    private List<DocumentCardsBean> documentCards;
    private String sessionId;
    private String title;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<DocumentCardsBean> getDocumentCards() {
        return this.documentCards;
    }

    public void setDocumentCards(List<DocumentCardsBean> list) {
        this.documentCards = list;
    }
}
