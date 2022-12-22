package com.didi.security.uuid;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.security.uuid.share.ShareManager;
import com.didi.security.wireless.SecurityController;
import com.didi.security.wireless.SecurityLib;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceTokenManager {
    private static final String API_VERSION = "1.0.0";
    private static final String APP_KEY = "300000";
    private static final String APP_KEY_SECRET = "EB7FF9356764B163A23969E6C04CE226524132DA";
    private ApolloCallBack apolloCallBack;
    private volatile boolean isInit;
    private Context mContext;
    /* access modifiers changed from: private */
    public volatile boolean mRequesting;
    /* access modifiers changed from: private */
    public Runnable mSyncTask;
    private Timer mTimer;
    private DeviceToken mToken;
    /* access modifiers changed from: private */
    public volatile boolean open;

    private static class SingletonClassInstance {
        /* access modifiers changed from: private */
        public static final DeviceTokenManager INSTANCE = new DeviceTokenManager();

        private SingletonClassInstance() {
        }
    }

    private DeviceTokenManager() {
        this.mSyncTask = new Runnable() {
            public void run() {
                if (DeviceTokenManager.this.open) {
                    DeviceTokenManager.this.syncServer();
                }
            }
        };
        this.mRequesting = false;
        this.mToken = null;
        this.open = false;
        this.isInit = false;
    }

    public static DeviceTokenManager getInstance() {
        return SingletonClassInstance.INSTANCE;
    }

    public void init(Context context) {
        if (SingletonClassInstance.INSTANCE.mContext == null) {
            SingletonClassInstance.INSTANCE.mContext = context;
            ShareManager.getInstance().init(context);
            this.isInit = true;
            ApolloCallBack apolloCallBack2 = this.apolloCallBack;
            if (apolloCallBack2 == null) {
                return;
            }
            if (apolloCallBack2.isOn()) {
                open();
            } else {
                close();
            }
        }
    }

    public void setApolloCallBack(ApolloCallBack apolloCallBack2) {
        this.apolloCallBack = apolloCallBack2;
    }

    public String getDeviceToken() {
        if (!this.isInit) {
            this.mToken = degrade(3, genExpireTime(6000));
        } else if (this.open) {
            check();
            DeviceToken deviceToken = this.mToken;
            if (deviceToken != null) {
                return deviceToken.toString();
            }
        } else {
            this.mToken = degrade(2, genExpireTime(6000));
        }
        DeviceToken deviceToken2 = this.mToken;
        if (deviceToken2 != null) {
            return deviceToken2.toString();
        }
        return null;
    }

    private long genExpireTime(long j) {
        return System.currentTimeMillis() + j;
    }

    public String getDegradeNoInitToken() {
        return degrade(3, genExpireTime(6000)).toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.mContext     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x0007:
            r0 = 0
            r1.open = r0     // Catch:{ all -> 0x0018 }
            java.util.Timer r0 = r1.mTimer     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            java.util.Timer r0 = r1.mTimer     // Catch:{ all -> 0x0018 }
            r0.cancel()     // Catch:{ all -> 0x0018 }
            r0 = 0
            r1.mTimer = r0     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.security.uuid.DeviceTokenManager.close():void");
    }

    public void open() {
        synchronized (this) {
            if (this.mContext != null) {
                this.open = true;
                initDeviceToken();
            }
        }
    }

    public boolean isOpen() {
        return this.open;
    }

    private void initDeviceToken() {
        DeviceToken load = DeviceToken.load(this.mContext);
        if (load != null) {
            SecurityLib.updateDeviceToken(load.toString());
        }
        if (load == null) {
            load = providerTokenGet();
            updateStorage(load);
        }
        updateMemory(degradeLocal(load));
        tokenSync();
    }

    private DeviceToken degradeLocal(DeviceToken deviceToken) {
        if (deviceToken == null) {
            if (this.open) {
                deviceToken = degrade(0, genExpireTime(6000));
            } else {
                deviceToken = degrade(2, genExpireTime(6000));
            }
            updateStorage(deviceToken);
        }
        return deviceToken;
    }

    private void check() {
        if (this.open) {
            DeviceToken deviceToken = this.mToken;
            if (deviceToken == null || !deviceToken.isValid()) {
                syncServer();
            }
        }
    }

    private String getAndroidID() {
        String str;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), "android_id");
        } catch (Exception unused) {
            str = null;
        }
        return str != null ? str : "0000";
    }

    private String toHexString(String str) {
        if (str == null || str.length() <= 0) {
            return "0000";
        }
        StringBuilder sb = new StringBuilder();
        for (byte hexString : str.getBytes()) {
            sb.append(Integer.toHexString(hexString));
        }
        return sb.toString();
    }

    private String degradeDeviceToken() {
        return getAndroidID() + "_" + toHexString(Build.MODEL) + "_" + Long.toHexString(Build.TIME);
    }

    private DeviceToken degrade(int i, long j) {
        return DeviceToken.create(j, "20-" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}) + "-" + degradeDeviceToken());
    }

    private DeviceToken degrade(int i, long j, String str) {
        return DeviceToken.create(j, str);
    }

    private DeviceToken degradeNet(DeviceTokenResponse deviceTokenResponse) {
        return this.mToken;
    }

    private static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : instance.digest()) {
                sb.append(Integer.toHexString((b >> 4) & 15).toUpperCase());
                sb.append(Integer.toHexString(b & Ascii.f53593SI).toUpperCase());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|4|5|6|7|8|9|10|(3:12|(2:13|(1:15)(1:33))|16)(1:17)|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c8, code lost:
        if (r9 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ca, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = com.didi.security.uuid.DeviceTokenResponse.parse(0, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d5, code lost:
        if (r9 == null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d8, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00da, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dd, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00d1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didi.security.uuid.DeviceTokenResponse requestServer(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "data"
            r1 = 0
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r3.<init>()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r3.put(r0, r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r4.<init>()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r4.append(r0)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r4.append(r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r9 = "&"
            r4.append(r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r9 = "EB7FF9356764B163A23969E6C04CE226524132DA"
            r4.append(r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r9 = r4.toString()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r9 = md5(r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r0.<init>()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r4 = com.didi.security.wireless.SecurityLib.nativeGetHost()     // Catch:{ all -> 0x003a }
            r0.append(r4)     // Catch:{ all -> 0x003a }
            goto L_0x003d
        L_0x003a:
            com.didi.security.wireless.SecurityLib.changNoInitState()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
        L_0x003d:
            java.lang.String r4 = "risk_devicetoken_apply?apiVersion="
            r0.append(r4)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r4 = "1.0.0"
            r0.append(r4)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r4 = "&appKey="
            r0.append(r4)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r4 = "300000"
            r0.append(r4)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r4 = "&sign="
            r0.append(r4)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r0.append(r9)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.net.Proxy r0 = java.net.Proxy.NO_PROXY     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.net.URLConnection r9 = r9.openConnection(r0)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            java.lang.String r0 = "POST"
            r9.setRequestMethod(r0)     // Catch:{ Exception -> 0x00d1 }
            r0 = 20000(0x4e20, float:2.8026E-41)
            r9.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00d1 }
            r0 = 60000(0xea60, float:8.4078E-41)
            r9.setReadTimeout(r0)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r4 = "application/json"
            r9.setRequestProperty(r0, r4)     // Catch:{ Exception -> 0x00d1 }
            r0 = 1
            r9.setDoOutput(r0)     // Catch:{ Exception -> 0x00d1 }
            java.io.OutputStream r0 = r9.getOutputStream()     // Catch:{ Exception -> 0x00d1 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x00d1 }
            r0.write(r3)     // Catch:{ Exception -> 0x00d1 }
            r0.close()     // Catch:{ Exception -> 0x00d1 }
            r9.connect()     // Catch:{ Exception -> 0x00d1 }
            int r0 = r9.getResponseCode()     // Catch:{ Exception -> 0x00d1 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x00c3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d1 }
            r3.<init>()     // Catch:{ Exception -> 0x00d1 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x00d1 }
            java.io.InputStream r5 = r9.getInputStream()     // Catch:{ Exception -> 0x00d1 }
        L_0x00ac:
            int r6 = r5.read(r4)     // Catch:{ Exception -> 0x00d1 }
            if (r6 <= 0) goto L_0x00bb
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00d1 }
            r7.<init>(r4, r1, r6)     // Catch:{ Exception -> 0x00d1 }
            r3.append(r7)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00ac
        L_0x00bb:
            r5.close()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00c4
        L_0x00c3:
            r3 = r2
        L_0x00c4:
            com.didi.security.uuid.DeviceTokenResponse r0 = com.didi.security.uuid.DeviceTokenResponse.parse(r0, r3)     // Catch:{ Exception -> 0x00d1 }
            if (r9 == 0) goto L_0x00d8
        L_0x00ca:
            r9.disconnect()
            goto L_0x00d8
        L_0x00ce:
            r0 = move-exception
            goto L_0x00db
        L_0x00d0:
            r9 = r2
        L_0x00d1:
            com.didi.security.uuid.DeviceTokenResponse r0 = com.didi.security.uuid.DeviceTokenResponse.parse(r1, r2)     // Catch:{ all -> 0x00d9 }
            if (r9 == 0) goto L_0x00d8
            goto L_0x00ca
        L_0x00d8:
            return r0
        L_0x00d9:
            r0 = move-exception
            r2 = r9
        L_0x00db:
            if (r2 == 0) goto L_0x00e0
            r2.disconnect()
        L_0x00e0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.security.uuid.DeviceTokenManager.requestServer(java.lang.String):com.didi.security.uuid.DeviceTokenResponse");
    }

    /* access modifiers changed from: private */
    public void syncServer() {
        if (!this.mRequesting) {
            this.mRequesting = true;
            SecurityController.getInstance().post((Runnable) new Runnable() {
                public void run() {
                    DeviceTokenManager.this.handleRequest();
                    boolean unused = DeviceTokenManager.this.mRequesting = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleRequest() {
        /*
            r9 = this;
            com.didi.security.uuid.ApolloCallBack r0 = r9.apolloCallBack
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.isDeviceTokenUploadOn()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            r0 = 0
            r1 = 0
        L_0x000d:
            java.lang.String r2 = "token/apply"
            java.lang.String r2 = com.didi.security.wireless.SecurityManager.collect(r2)
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L_0x0019
            goto L_0x001c
        L_0x0019:
            int r1 = r1 + r4
            if (r1 < r3) goto L_0x000d
        L_0x001c:
            if (r2 != 0) goto L_0x002b
            r5 = 6000(0x1770, double:2.9644E-320)
            long r5 = r9.genExpireTime(r5)
            com.didi.security.uuid.DeviceToken r1 = r9.degrade(r4, r5)
            r9.updateMemory(r1)
        L_0x002b:
            r5 = 0
        L_0x002c:
            com.didi.security.uuid.DeviceTokenResponse r1 = r9.requestServer(r2)
            int r6 = r1.apiCode
            r7 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r8 = ""
            if (r6 != r7) goto L_0x0049
            java.lang.String r6 = r1.deviceToken
            if (r6 == 0) goto L_0x0049
            java.lang.String r6 = r1.deviceToken
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0049
            int r0 = r1.apiCode
            r5 = r1
            goto L_0x0056
        L_0x0049:
            int r1 = r1.apiCode
            r6 = 3000(0xbb8, double:1.482E-320)
            java.lang.Thread.sleep(r6)     // Catch:{ all -> 0x0051 }
            goto L_0x0052
        L_0x0051:
        L_0x0052:
            int r0 = r0 + r4
            if (r0 < r3) goto L_0x002c
            r0 = r1
        L_0x0056:
            if (r5 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = r1.toString()
            r9.upDataFailedInfo(r0)
            return
        L_0x006b:
            long r0 = r5.expire
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0076
            long r0 = r5.expire
            goto L_0x007d
        L_0x0076:
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            long r0 = r9.genExpireTime(r0)
        L_0x007d:
            java.lang.String r2 = r5.deviceToken
            com.didi.security.uuid.DeviceToken r0 = com.didi.security.uuid.DeviceToken.create(r0, r2)
            r9.updateStorage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.security.uuid.DeviceTokenManager.handleRequest():void");
    }

    /* access modifiers changed from: package-private */
    public void upDataFailedInfo(String str) {
        DeviceToken degrade = degrade(1, genExpireTime(6000));
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put("did", degrade.toString());
        OmegaSDKAdapter.trackEvent("tech_wsg_did_generate_failed", (Map<String, Object>) hashMap);
    }

    private void tokenSync() {
        if (this.mTimer == null) {
            C133413 r2 = new TimerTask() {
                public void run() {
                    if (DeviceTokenManager.this.open) {
                        SecurityController.getInstance().post(DeviceTokenManager.this.mSyncTask);
                    }
                }
            };
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.schedule(r2, 0, Constants.SYNC_TOKEN_DURATION);
        }
    }

    private void updateMemory(DeviceToken deviceToken) {
        this.mToken = deviceToken;
    }

    private void updateStorage(DeviceToken deviceToken) {
        if (deviceToken != null && deviceToken.isValid()) {
            updateMemory(deviceToken);
            deviceToken.save(this.mContext);
            providerTokenSave();
            SecurityLib.updateDeviceToken(deviceToken.toString());
        }
    }

    private DeviceToken providerTokenGet() {
        String token = ShareManager.getInstance().getToken();
        if (TextUtils.isEmpty(token)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(token, 0)));
            return DeviceToken.create(jSONObject.optLong(Constants.CREATE_NAME), jSONObject.optLong("expire"), jSONObject.optString("token"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void providerTokenSave() {
        if (this.mToken != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", this.mToken.toString());
                jSONObject.put(Constants.CREATE_NAME, this.mToken.getCreateTime());
                jSONObject.put("expire", this.mToken.getExpireTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ShareManager.getInstance().setToken(Base64.encodeToString(jSONObject.toString().getBytes(), 0));
        }
    }
}
