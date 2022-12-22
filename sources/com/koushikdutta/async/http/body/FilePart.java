package com.koushikdutta.async.http.body;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.koushikdutta.async.http.BasicNameValuePair;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FilePart extends StreamPart {

    /* renamed from: a */
    File f55313a;

    public FilePart(String str, final File file) {
        super(str, (long) ((int) file.length()), new ArrayList<NameValuePair>() {
            {
                add(new BasicNameValuePair(SDKConsts.TAG_KEY_FILENAME, file.getName()));
            }
        });
        this.f55313a = file;
    }

    /* access modifiers changed from: protected */
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.f55313a);
    }

    public String toString() {
        return getName();
    }
}
