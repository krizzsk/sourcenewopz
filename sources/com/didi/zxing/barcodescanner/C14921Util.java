package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.dqr.BarcodeFormat;
import java.util.Collection;
import java.util.LinkedHashSet;

/* renamed from: com.didi.zxing.barcodescanner.Util */
public class C14921Util {
    public static void validateMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void addExtraBarcodeFormats(String str, Collection<BarcodeFormat> collection) {
        if (!TextUtils.isEmpty(str) && collection != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                for (String trim : str.split(",")) {
                    String upperCase = trim.trim().toUpperCase();
                    System.out.println("add extra barcode format===<" + upperCase + IMTextUtils.STREET_IMAGE_TAG_END);
                    if (!TextUtils.isEmpty(upperCase)) {
                        try {
                            linkedHashSet.add(BarcodeFormat.valueOf(upperCase));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception unused) {
            }
            collection.addAll(linkedHashSet);
        }
    }
}
