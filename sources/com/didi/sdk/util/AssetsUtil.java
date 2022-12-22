package com.didi.sdk.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

public class AssetsUtil {
    public static String getAssetsFile(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return new String(bArr, "utf-8");
        } catch (IOException e) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            e.printStackTrace();
            return "";
        }
    }
}
