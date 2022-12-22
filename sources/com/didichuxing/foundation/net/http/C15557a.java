package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;

/* renamed from: com.didichuxing.foundation.net.http.a */
/* compiled from: AbstractMultipartBody */
abstract class C15557a extends HttpBody implements MultipartEntity, C15559c {
    private final String mFilename;
    private final MimeType mMimeType;

    public C15557a(MimeType mimeType, String str) {
        this.mMimeType = mimeType;
        this.mFilename = str;
    }

    public String getFilename() {
        return this.mFilename;
    }

    public MimeType getContentType() {
        return this.mMimeType;
    }
}
