package com.didichuxing.omega.sdk.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.p154ms.p155ad.IAdOperation;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Record;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdHelper {
    private static final long GET_GAID_TIMEOUT = 500000;
    private static final String SP_KEY_GAID = "gaid";
    private static final String SP_KEY_HAID = "haid";
    private static final String TAG = "SEEE_THIS";
    private static AdvertisingIdHelper instance;
    /* access modifiers changed from: private */
    public String mGAId = "";
    /* access modifiers changed from: private */
    public String mHAId = "";
    private SavedState mSavedState;
    private final ExecutorService mSinglePool = Executors.newFixedThreadPool(2);

    public String getGPVersion(Context context) {
        return "";
    }

    public static AdvertisingIdHelper getInstance() {
        if (instance == null) {
            synchronized (AdvertisingIdHelper.class) {
                if (instance == null) {
                    instance = new AdvertisingIdHelper();
                }
            }
        }
        return instance;
    }

    private AdvertisingIdHelper() {
    }

    public String getGAIdTimeOut(Context context) {
        try {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mGAId = this.mSavedState.getString("gaid");
            SystemUtils.log(3, TAG, "getGAIdTimeOut-mGAId=" + this.mGAId, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 92);
            if (TextUtils.isEmpty(this.mGAId)) {
                FutureTask futureTask = new FutureTask(new GetGAIDTask(context));
                this.mSinglePool.execute(futureTask);
                this.mGAId = (String) futureTask.get(GET_GAID_TIMEOUT, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable th) {
            SystemUtils.log(6, TAG, "getGAIdTimeOut error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 100);
        }
        return this.mGAId;
    }

    public String getGAID() {
        return this.mGAId;
    }

    public String initGAIdByAsyc(Context context) {
        try {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mGAId = this.mSavedState.getString("gaid");
            SystemUtils.log(3, TAG, "getGAIdTimeOut-mGAId=" + this.mGAId, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 121);
            if (TextUtils.isEmpty(this.mGAId)) {
                this.mSinglePool.execute(new FutureTask(new GetGAIDTask(context)));
            }
        } catch (Throwable th) {
            SystemUtils.log(6, TAG, "initGAIdByAsyc error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 128);
        }
        return this.mGAId;
    }

    private class GetGAIDTask implements Callable<String> {
        private Context context;

        public GetGAIDTask(Context context2) {
            this.context = context2;
        }

        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                IAdOperation iAdOperation = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.GMS);
                if (iAdOperation != null) {
                    String unused = AdvertisingIdHelper.this.mGAId = iAdOperation.getAdvertisingId(this.context);
                    AdvertisingIdHelper.this.updateAdvertisingId(this.context, AdvertisingIdHelper.this.mGAId);
                    LogUtil.m26099i(AdvertisingIdHelper.TAG, "call : gmsOperation is load, mGAid = " + AdvertisingIdHelper.this.mGAId);
                } else {
                    LogUtil.m26099i(AdvertisingIdHelper.TAG, "call : gmsOperation is null");
                }
            } catch (Throwable th) {
                SystemUtils.log(6, AdvertisingIdHelper.TAG, "getAdvertisingIdInfo error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper$GetGAIDTask", 155);
            }
            SystemUtils.log(3, AdvertisingIdHelper.TAG, "mGAId:" + AdvertisingIdHelper.this.mGAId + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis), (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper$GetGAIDTask", 170);
            return AdvertisingIdHelper.this.mGAId;
        }
    }

    /* access modifiers changed from: private */
    public void updateAdvertisingId(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mSavedState.saveString("gaid", str);
        }
    }

    public String getHAIdTimeOut(Context context) {
        try {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mHAId = this.mSavedState.getString("haid");
            SystemUtils.log(3, TAG, "getHAIdTimeOut-mHAId=" + this.mHAId, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 196);
            if (TextUtils.isEmpty(this.mHAId)) {
                FutureTask futureTask = new FutureTask(new GetHAIDTask(context));
                this.mSinglePool.execute(futureTask);
                this.mHAId = (String) futureTask.get(GET_GAID_TIMEOUT, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable th) {
            SystemUtils.log(6, TAG, "getHAIdTimeOut error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 204);
        }
        return this.mHAId;
    }

    public String getHAID() {
        return this.mHAId;
    }

    public String initHAIdByAsyc(Context context) {
        try {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mHAId = this.mSavedState.getString("haid");
            SystemUtils.log(3, TAG, "getHAIdTimeOut-mHAId=" + this.mHAId, (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 224);
            if (TextUtils.isEmpty(this.mHAId)) {
                this.mSinglePool.execute(new FutureTask(new GetHAIDTask(context)));
            }
        } catch (Throwable th) {
            SystemUtils.log(6, TAG, "initHAIdByAsyc error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper", 231);
        }
        return this.mHAId;
    }

    private class GetHAIDTask implements Callable<String> {
        private Context context;

        public GetHAIDTask(Context context2) {
            this.context = context2;
        }

        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                IAdOperation iAdOperation = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.HMS);
                if (iAdOperation != null) {
                    String unused = AdvertisingIdHelper.this.mHAId = iAdOperation.getAdvertisingId(this.context);
                    AdvertisingIdHelper.this.updateHMSAdvertisingId(this.context, AdvertisingIdHelper.this.mHAId);
                    LogUtil.m26099i(AdvertisingIdHelper.TAG, "call : hmsOperation is load, mHAid = " + AdvertisingIdHelper.this.mHAId);
                } else {
                    LogUtil.m26099i(AdvertisingIdHelper.TAG, "call : hmsOperation is null");
                }
            } catch (Throwable th) {
                SystemUtils.log(6, AdvertisingIdHelper.TAG, "getAdvertisingIdInfo error", th, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper$GetHAIDTask", 257);
            }
            SystemUtils.log(3, AdvertisingIdHelper.TAG, "mHAId:" + AdvertisingIdHelper.this.mHAId + " , get haid consume time :" + (System.currentTimeMillis() - currentTimeMillis), (Throwable) null, "com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper$GetHAIDTask", 260);
            return AdvertisingIdHelper.this.mHAId;
        }
    }

    /* access modifiers changed from: private */
    public void updateHMSAdvertisingId(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mSavedState == null) {
                this.mSavedState = new SavedState(context);
            }
            this.mSavedState.saveString("haid", str);
        }
    }

    public static void putGaidInfo(Record record) {
        String gaid = getInstance().getGAID();
        if (!TextUtils.isEmpty(gaid)) {
            record.put("gaid", gaid);
            if (TextUtils.isEmpty(OmegaConfig.OMEGA_OAID)) {
                OmegaConfig.OMEGA_OAID = gaid;
            }
        }
    }

    public static void putHaidInfo(Record record) {
        String haid = getInstance().getHAID();
        if (!TextUtils.isEmpty(haid)) {
            record.put("haid", haid);
            if (TextUtils.isEmpty(OmegaConfig.OMEGA_OAID)) {
                OmegaConfig.OMEGA_OAID = haid;
            }
        }
    }

    public static void initHaidAndGaid(Context context) {
        getInstance().initGAIdByAsyc(context);
        getInstance().initHAIdByAsyc(context);
    }
}
