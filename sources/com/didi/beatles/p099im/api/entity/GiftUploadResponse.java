package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.GiftUploadResponse */
public class GiftUploadResponse implements Serializable {
    public String download_url_https;
    public int file_size;
    public String md5;
    public String resource_key;
    public String status;
    public int status_code;

    public boolean isSuccess() {
        return this.status_code == 200;
    }
}
