package com.didi.global.globalresource;

import android.content.Context;
import com.didi.global.globalresource.utils.GRUtils;

public abstract class GRBaseResourceLoader {
    public abstract String hasResource(Context context, String str);

    /* access modifiers changed from: protected */
    public String getResourceNameWithoutSuffix(String str) {
        return GRUtils.getResourceNameWithoutSuffix(str);
    }
}
