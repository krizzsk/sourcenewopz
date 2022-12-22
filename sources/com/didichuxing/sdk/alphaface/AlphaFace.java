package com.didichuxing.sdk.alphaface;

import android.app.Application;
import android.content.Context;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.didichuxing.sdk.alphaface.utils.ICrash;

public class AlphaFace {
    public static final String MODEL_FILES_DIR = "dfalpha_models";

    /* renamed from: a */
    private static ICrash f48603a;
    public static Context context;

    public interface IInitCallback {
        public static final int CODE_FAILED = 100001;
        public static final int CODE_SUCCESS = 100000;

        void onResult(int i, String str);
    }

    public static void unInit() {
    }

    public static void preInit(AFConfig aFConfig) {
        Context appContext;
        if (!(aFConfig == null || (appContext = aFConfig.getAppContext()) == null)) {
            if (appContext instanceof Application) {
                context = appContext;
            } else {
                context = appContext.getApplicationContext();
            }
        }
        AlphaFaceFacade.getInstance().preInit(aFConfig);
    }

    public static void initialize(IInitCallback iInitCallback) {
        AlphaFaceFacade.getInstance().initialize(iInitCallback);
    }

    public static void setCrash(ICrash iCrash) {
        f48603a = iCrash;
    }

    public static void throwable(Throwable th) {
        ICrash iCrash = f48603a;
        if (iCrash != null) {
            iCrash.throwable(th);
        }
    }
}
