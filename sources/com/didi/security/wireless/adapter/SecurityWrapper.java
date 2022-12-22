package com.didi.security.wireless.adapter;

import android.content.Context;
import android.view.MotionEvent;
import com.didi.security.uuid.adapter.AccessAlgoModelProcessor;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.security.wireless.DAQException;
import com.didi.security.wireless.SecurityDots;
import com.didi.security.wireless.SecurityManager;
import java.net.URL;
import java.util.Map;

public class SecurityWrapper {
    public static final String WSG_DID_KEY_NAME = "wsgdid";
    public static final String WSG_ENV_KEY_NAME = "wsgenv";
    public static final String WSG_SIGN_KEY_NAME = "wsgsig";

    /* renamed from: a */
    private static final String f38604a = SecurityWrapper.class.getSimpleName();

    /* renamed from: b */
    private static final String f38605b = "tech_wsg_init";
    public static Context sContext;

    public static String getDeviceId() {
        return "";
    }

    public static String getDeviceId(Context context) {
        return "";
    }

    @Deprecated
    public static void triggerInit() {
    }

    public static synchronized void doInit(Context context, ISecurityInfo iSecurityInfo) {
        synchronized (SecurityWrapper.class) {
            if (context != null) {
                if (sContext == null) {
                    sContext = context.getApplicationContext();
                }
                try {
                    DeviceTokenWrapper.getInstance().init(context);
                    SecurityManager.setConfigure(new ApolloConf());
                    SecurityManager.initialize(context, (String) null, iSecurityInfo);
                } catch (DAQException e) {
                    e.printStackTrace();
                }
                C13359b.m27351a(context);
                DiChallengerInitializer.initChallenger(context);
                AccessAlgoModelProcessor.processAlgoModel(context);
            }
        }
    }

    @Deprecated
    public static synchronized void doInit(Context context, ISecurityInfo2 iSecurityInfo2) {
        synchronized (SecurityWrapper.class) {
            if (context != null) {
                if (sContext == null) {
                    sContext = context.getApplicationContext();
                }
                try {
                    DeviceTokenWrapper.getInstance().init(context);
                    SecurityManager.setConfigure(new ApolloConf());
                    SecurityManager.initialize(context, (String) null, iSecurityInfo2);
                } catch (DAQException e) {
                    e.printStackTrace();
                }
                C13359b.m27351a(context);
                DiChallengerInitializer.initChallenger(context);
                AccessAlgoModelProcessor.processAlgoModel(context);
            }
        }
    }

    public static String prepareSign(String str, byte[] bArr) {
        return SecurityManager.prepareSign(str, bArr);
    }

    public static String prepareSign(Map<String, String> map) {
        return SecurityManager.signMapToString(map);
    }

    public static String doSign(String str) {
        return SecurityManager.doSign(str);
    }

    public static String doSign(byte[] bArr) {
        String sign = SecurityManager.sign(bArr);
        return !SecurityManager.checkSign(sign) ? SecurityManager.errSign(DAQException.WSG_CODE_SIGN_CHARACTEREXCEPTION) : sign;
    }

    public static String doSign(Map<String, String> map) {
        return SecurityManager.doSign(prepareSign(map));
    }

    public static String doSign(String str, byte[] bArr) {
        return SecurityManager.doSign(SecurityManager.prepareSign(str, bArr));
    }

    public static String doCollect(String str) {
        try {
            URL url = new URL(str);
            return SecurityManager.collect(url.getHost() + url.getPath());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void doReport(String str, String str2) {
        SecurityManager.report(str, str2);
    }

    @Deprecated
    public static String secKey(String str) {
        return SecurityManager.secKey(str);
    }

    @Deprecated
    public static String secKey2(String str) throws DAQException {
        return SecurityManager.secKey2(str);
    }

    @Deprecated
    public static String secKey3(String str) throws DAQException {
        return SecurityManager.secKey3(str);
    }

    public static void setHost(String str) {
        SecurityManager.setHost(str);
    }

    public static String getHost() {
        return SecurityManager.getHost();
    }

    public static void touchReset() {
        SecurityManager.touchReset();
    }

    public static void onTouch(MotionEvent motionEvent) {
        SecurityManager.onTouch(motionEvent);
    }

    public static void reportTouch(String str) {
        SecurityDots.getInstance().report(str);
    }
}
