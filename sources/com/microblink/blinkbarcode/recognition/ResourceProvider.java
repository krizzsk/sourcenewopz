package com.microblink.blinkbarcode.recognition;

import android.content.Context;
import android.content.res.AssetManager;
import com.microblink.blinkbarcode.secured.IIIlIIlIll;
import com.microblink.blinkbarcode.util.IlIllIlIIl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: line */
public class ResourceProvider {
    public static final ResourceProvider INSTANCE = new ResourceProvider();
    private volatile boolean llIIlIlIIl = false;

    static {
        IlIllIlIIl.IllIIIllII();
    }

    private static native void nativeInitialise(AssetManager assetManager);

    private static native void nativeTerminate();

    public void finalize() throws Throwable {
        super.finalize();
        unloadAllResources();
    }

    public void prepareAssertManager(Context context) {
        if (!this.llIIlIlIIl) {
            IlIllIlIIl.llIIlIlIIl();
            nativeInitialise(context.getAssets());
            String[] strArr = IIIlIIlIll.llIIlIlIIl;
            String absolutePath = context.getFilesDir().getAbsolutePath();
            IlIllIlIIl.llIIlIlIIl(new File(absolutePath + File.separator + "null"));
            AssetManager assets = context.getAssets();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < strArr.length; i += 2) {
                hashMap.put(strArr[i], strArr[i + 1]);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!IlIllIlIIl.llIIlIlIIl(assets, (String) entry.getKey(), absolutePath + File.separator + ((String) entry.getValue()))) {
                    throw new RuntimeException("Cannot load asset " + ((String) entry.getKey()));
                }
            }
            this.llIIlIlIIl = true;
        }
    }

    public void unloadAllResources() {
        if (this.llIIlIlIIl) {
            nativeTerminate();
            this.llIIlIlIIl = false;
        }
    }
}
