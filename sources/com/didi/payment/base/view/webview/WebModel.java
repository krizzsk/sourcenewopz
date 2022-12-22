package com.didi.payment.base.view.webview;

import java.io.Serializable;

public class WebModel implements Serializable {
    public CustomNavModel param;
    public String title;
    public String url;

    public WebModel() {
        this.title = "";
        this.url = "";
    }

    public WebModel(String str, String str2) {
        this.title = str;
        this.url = str2;
    }

    public WebModel(String str, CustomNavModel customNavModel) {
        this.url = str;
        this.param = customNavModel;
    }
}
