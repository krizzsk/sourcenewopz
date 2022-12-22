package com.didi.soda.blocks.utils;

import android.graphics.drawable.Drawable;
import com.didi.soda.blocks.sdk.BlocksEngine;

public class ResUtils {
    public static int getResourceId(String str, String str2, String str3) throws RuntimeException {
        if (str3 == null) {
            try {
                str3 = BlocksEngine.Companion.getInstance().getContext().getPackageName();
            } catch (Exception e) {
                throw new RuntimeException("Error getResourceId by NJContextUtil.getContext()", e);
            }
        }
        return BlocksEngine.Companion.getInstance().getContext().getResources().getIdentifier(str, str2, str3);
    }

    public static Drawable getResourcesDrawable(String str, String str2, String str3) {
        int resourceId = getResourceId(str, str2, str3);
        if (resourceId <= 0) {
            return null;
        }
        return BlocksEngine.Companion.getInstance().getContext().getResources().getDrawable(resourceId);
    }
}
