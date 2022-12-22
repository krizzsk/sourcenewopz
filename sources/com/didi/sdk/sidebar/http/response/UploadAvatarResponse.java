package com.didi.sdk.sidebar.http.response;

import com.didi.sdk.push.http.BaseObject;

public class UploadAvatarResponse extends BaseObject {
    private String head_url;

    public String getHead_url() {
        return this.head_url;
    }

    public void setHead_url(String str) {
        this.head_url = str;
    }

    public String getAvatarUrl() {
        return this.head_url;
    }
}
