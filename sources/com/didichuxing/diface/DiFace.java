package com.didichuxing.diface;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.dfbasesdk.IAppConfig;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.sdk.alphaface.AFConfig;
import com.didichuxing.sdk.alphaface.AlphaFace;

public class DiFace {
    public static final String DIFACE_RESULT_KEY = "face_result_key";

    public interface IDiFaceCallback {
        void onResult(DiFaceResult diFaceResult);
    }

    public static void initialize(final DiFaceConfig diFaceConfig) {
        DiFaceFacade.getInstance().initialize(diFaceConfig);
        DFAppConfig.getInstance().setAppConfig(new IAppConfig() {
            public Context getAppContext() {
                return diFaceConfig.getAppContext();
            }

            public boolean isDebug() {
                return diFaceConfig.isDebug();
            }

            public String getDebugEnv() {
                return diFaceConfig.getDebugEnv();
            }
        });
        AlphaFace.preInit(new AFConfig.Builder().setAppContext(diFaceConfig.getAppContext()).setDebug(diFaceConfig.isDebug()).create());
    }

    public static void startFaceRecognition(DiFaceParam diFaceParam, IDiFaceCallback iDiFaceCallback) {
        if (TextUtils.isEmpty(diFaceParam.getToken())) {
            iDiFaceCallback.onResult(new DiFaceResult(101, "token is empty!!!"));
        } else if (TextUtils.isEmpty(diFaceParam.getSessionId())) {
            iDiFaceCallback.onResult(new DiFaceResult(101, "sessionId is empty!!!"));
        } else if (!DiFaceFacade.getInstance().isInitialized()) {
            iDiFaceCallback.onResult(new DiFaceResult(111, "sdk not inited!!!"));
        } else {
            DiFaceFacade.getInstance().faceRecognition(diFaceParam, iDiFaceCallback);
        }
    }
}
