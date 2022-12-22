package com.didichuxing.dfbasesdk.logupload;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class UploadObj {
    public final List<Object> ids = new ArrayList();
    public String jsonBody;

    public boolean needUpload() {
        return !TextUtils.isEmpty(this.jsonBody);
    }
}
