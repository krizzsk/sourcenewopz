package com.didi.sdk.util;

import android.content.Context;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.getkeepsafe.relinker.ReLinker;
import com.getkeepsafe.relinker.ReLinkerInstance;

public class DiDiLinkerInstance implements ReLinker.Logger {
    private static final String TAG = "library-debug";
    private static DiDiLinkerInstance diDiLinkerInstance = new DiDiLinkerInstance();
    ReLinkerInstance reLinkerInstance = ReLinker.log(this);
    private Logger sLogger = LoggerFactory.getLogger("DiDiLinkerInstance");

    private DiDiLinkerInstance() {
    }

    public static DiDiLinkerInstance getLinkerInstance() {
        return diDiLinkerInstance;
    }

    public void loadLibrary(Context context, String str) {
        this.reLinkerInstance.force().loadLibrary(context.getApplicationContext(), str);
    }

    public void log(String str) {
        try {
            Logger logger = this.sLogger;
            logger.infoEvent(TAG, "relinker: " + str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
