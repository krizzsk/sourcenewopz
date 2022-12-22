package com.didi.global.globalresource;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.globalresource.utils.GRUtils;
import java.io.IOException;

public class GRXMLResourceLoader extends GRBaseResourceLoader {
    public String hasResource(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return GRUtils.hasResource(context.getAssets().list("xml"), getResourceNameWithoutSuffix(str).trim());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
