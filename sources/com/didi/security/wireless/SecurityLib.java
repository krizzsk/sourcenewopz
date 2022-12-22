package com.didi.security.wireless;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.didi.security.uuid.ToolUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import global.didi.pay.newview.pix.IPixView;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SecurityLib {
    private static final long DELAY_TIME = 15000;
    private static final String TAG = SecurityLib.class.getSimpleName();
    private static final long WAIT_TIME = 1;
    private static ISecurityConf configure;
    /* access modifiers changed from: private */
    public static volatile State initState;
    /* access modifiers changed from: private */
    public static volatile int sInitCode;
    /* access modifiers changed from: private */
    public static final Condition sInitCondtition;
    /* access modifiers changed from: private */
    public static final ReentrantLock sInitLock;

    enum State {
        NOT_INIT,
        LOADSO_SUCCESS,
        START_INIT,
        INITING,
        INIT_SUCCESS,
        INIT_FAILED
    }

    @Deprecated
    private static native void nativeCheck(String str);

    private static native String nativeCollect(String str);

    public static native byte[] nativeDecrypt2(byte[] bArr, byte[] bArr2);

    public static native byte[] nativeEncrypt(String str, String str2, byte[] bArr);

    public static native byte[] nativeEncrypt2(byte[] bArr, byte[] bArr2);

    public static native String nativeGetHost();

    public static native String nativeGetRid();

    private static native int nativeInit(Context context);

    public static native void nativeInitRetry(Context context);

    private static native boolean nativeReport(String str, String str2);

    private static native boolean nativeReportByCmd(String str);

    @Deprecated
    private static native String nativeSecKey(String str);

    @Deprecated
    private static native String nativeSecKey2(String str);

    @Deprecated
    private static native String nativeSecKey3(String str);

    protected static native void nativeSetHost(String str);

    private static native String nativeSig(Context context, long j, String str, byte[] bArr);

    public static native void nativeUpdate(String str, String str2, String str3, String str4);

    static {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        sInitLock = reentrantLock;
        sInitCondtition = reentrantLock.newCondition();
        sInitCode = DAQException.WSG_CODE_NOTINIT;
        initState = State.NOT_INIT;
        try {
            System.loadLibrary("didiwsg");
            initState = State.LOADSO_SUCCESS;
        } catch (Throwable unused) {
            initState = State.INIT_FAILED;
            sInitCode = DAQException.WSG_CODE_LOAD_FAIL;
        }
    }

    public static void changNoInitState() {
        initState = State.INIT_FAILED;
        sInitCode = DAQException.WSG_CODE_LOAD_FAIL;
    }

    public static void setConfigure(ISecurityConf iSecurityConf) {
        configure = iSecurityConf;
        if (iSecurityConf != null) {
            SecurityController.setPriorityOn(iSecurityConf.isPriorityOn());
        }
    }

    private static void updateUserInfo() {
        String str;
        String str2;
        String str3 = "";
        try {
            str2 = DAQUtils.getUserPhone();
            try {
                str = DAQUtils.getUserId();
                try {
                    str3 = DAQUtils.getTicket();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = str3;
            }
        } catch (Exception unused3) {
            str2 = str3;
            str = str2;
        }
        nativeUpdate(str, str2, str3, (String) null);
    }

    public static void updateDeviceToken(String str) {
        String str2;
        String str3;
        String str4 = "";
        try {
            str3 = DAQUtils.getUserPhone();
            try {
                str2 = DAQUtils.getUserId();
                try {
                    str4 = DAQUtils.getTicket();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str2 = str4;
            }
        } catch (Exception unused3) {
            str3 = str4;
            str2 = str3;
        }
        nativeUpdate(str2, str3, str4, str);
    }

    /* access modifiers changed from: private */
    public static void initSync(Context context) {
        sInitCode = nativeInit(context);
        if (sInitCode != DAQException.WSG_CODE_OK) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", Integer.valueOf(sInitCode));
            hashMap.put("rid", nativeGetRid());
            OmegaSDKAdapter.trackEvent("tech_wsgsdk_init_exception", (Map<String, Object>) hashMap);
            String str = TAG;
            Logger.m27323e(str, "init error: " + sInitCode);
            initState = State.INIT_FAILED;
        } else {
            updateUserInfo();
            initState = State.INIT_SUCCESS;
            reportInit();
        }
        initConfigure();
    }

    private static void reportInit() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                SecurityController.getInstance().post(SecurityMessage.obtainLocal(IPixView.PAGE_STATUS_INIT, IPixView.PAGE_STATUS_INIT));
            }
        }, 15000);
    }

    private static void initConfigure() {
        if (configure != null) {
            SecurityDots.getInstance().setTouch(configure.isTouchOn());
            SecurityDots.getInstance().setDotsCapacity(configure.touchCapacity());
        }
    }

    protected static void init(Context context) {
        if (initState == State.LOADSO_SUCCESS) {
            initAysnc(context);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(sInitCode));
        hashMap.put("rid", nativeGetRid());
        OmegaSDKAdapter.trackEvent("tech_wsgsdk_init_exception", (Map<String, Object>) hashMap);
        ISecurityDispatcher dispatcher = DAQUtils.getDispatcher();
        if (dispatcher != null) {
            dispatcher.onInit(sInitCode);
        }
    }

    private static void initAysnc(final Context context) {
        initState = State.START_INIT;
        SecurityController.getInstance().post((Runnable) new Runnable() {
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SecurityLib.sInitLock.lock();
                    State unused = SecurityLib.initState = State.INITING;
                    SecurityLib.initSync(context);
                    SecurityLib.sInitCondtition.signalAll();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Logger.m27324i("TIME", "[+][ControllerThread][InitSDK][InitCheck]:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    SecurityLib.sInitLock.unlock();
                    throw th;
                }
                SecurityLib.sInitLock.unlock();
                ISecurityDispatcher dispatcher = DAQUtils.getDispatcher();
                if (dispatcher != null) {
                    dispatcher.onInit(SecurityLib.sInitCode);
                }
            }
        });
    }

    protected static String sign(Context context, byte[] bArr) {
        if (isInitFailed()) {
            return SecurityManager.errSign(sInitCode);
        }
        String str = null;
        long j = 0;
        try {
            str = DAQUtils.getUserPhone();
            j = System.currentTimeMillis();
        } catch (Exception unused) {
        }
        return nativeSig(context, j, str, bArr);
    }

    protected static String collect(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        if (isInitFailed() || str == null) {
            return null;
        }
        try {
            str2 = nativeCollect(str);
        } catch (Throwable unused) {
            changNoInitState();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("[+][MultiThread][Collects]:");
        sb.append(!TextUtils.isEmpty(str2));
        sb.append("  ");
        sb.append(currentTimeMillis2 - currentTimeMillis);
        sb.append("ms");
        Logger.m27324i("TIME", sb.toString());
        return str2;
    }

    protected static boolean report(int i, String str, String str2) {
        if (isInitFailed()) {
            return false;
        }
        ISecurityConf iSecurityConf = configure;
        if (iSecurityConf != null && !iSecurityConf.isAllow(str)) {
            return false;
        }
        Region.updateInfo();
        if (i == 1) {
            try {
                return nativeReport(str, str2);
            } catch (Throwable unused) {
                changNoInitState();
                return true;
            }
        } else if (i != 3) {
            return true;
        } else {
            try {
                return nativeReportByCmd(str2);
            } catch (Throwable unused2) {
                changNoInitState();
                return true;
            }
        }
    }

    @Deprecated
    protected static String secKey(String str) {
        if (isInitFailed()) {
            return null;
        }
        return nativeSecKey(str);
    }

    @Deprecated
    protected static String secKey2(String str) throws DAQException {
        if (str == null || str.length() == 0) {
            throw new DAQException(DAQException.WSG_CODE_INPUTNULL, "empty input");
        } else if (!isInitFailed()) {
            return nativeSecKey2(str);
        } else {
            throw new DAQException(sInitCode, "init failed");
        }
    }

    @Deprecated
    protected static String secKey3(String str) throws DAQException {
        if (str == null || str.length() == 0) {
            throw new DAQException(DAQException.WSG_CODE_INPUTNULL, "empty input");
        } else if (!isInitFailed()) {
            return nativeSecKey3(str);
        } else {
            throw new DAQException(sInitCode, "init failed");
        }
    }

    @Deprecated
    protected static void check(String str) {
        if (initState == State.INIT_SUCCESS && sInitCode == DAQException.WSG_CODE_OK) {
            nativeCheck(str);
        }
    }

    private static boolean isInitFailed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (initState != State.INIT_SUCCESS) {
            Logger.m27323e("INIT", "[+][1][MultiThread][InitCheck],State:" + initState + " lock:" + sInitLock.isLocked());
            try {
                sInitLock.lock();
                if (initState != State.INIT_SUCCESS) {
                    Logger.m27323e("INIT", "[+][2][MultiThread][InitCheck],State:" + initState + " lock:" + sInitLock.isLocked());
                    sInitCondtition.awaitNanos(TimeUnit.SECONDS.toNanos(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                sInitLock.unlock();
                throw th;
            }
            sInitLock.unlock();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger.m27324i("TIME", "[+][MultiThread][InitCheck]:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        return sInitCode != DAQException.WSG_CODE_OK;
    }

    protected static void touchReset() {
        SecurityDots.getInstance().reset();
    }

    protected static void onTouch(MotionEvent motionEvent) {
        SecurityDots.getInstance().onTouch(motionEvent);
    }

    public static Object getFeature(int i) {
        return ToolUtils.getInstance().get(i);
    }

    public static String getTouchData() {
        return TouchManager.getInstance().getData();
    }

    public static void OmegaUpload(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("rid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("code", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("configid", str4);
        }
        if (hashMap.isEmpty()) {
            OmegaSDKAdapter.trackEvent(str);
        } else {
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }
}
