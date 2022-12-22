package com.didi.dimina.webview.resource.offline;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.FusionInitConfig;
import com.didi.dimina.webview.resource.FusionAsynDispatcher;
import com.didi.dimina.webview.resource.FusionHttpClient;
import com.didi.dimina.webview.util.C7819Util;
import com.didi.dimina.webview.util.DeviceUtil;
import com.didi.dimina.webview.util.HttpUtil;
import com.didi.dimina.webview.util.NetworkUtil;
import com.didi.dimina.webview.util.WsgSafeUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineBundleManager {

    /* renamed from: a */
    private static final String f18367a = "bundles";

    /* renamed from: b */
    private static final String f18368b = "app_version";

    /* renamed from: c */
    private static final String f18369c = "app_key";

    /* renamed from: d */
    private static final String f18370d = "device_type";

    /* renamed from: e */
    private static final String f18371e = "device_id";

    /* renamed from: f */
    private static final String f18372f = "os_type";

    /* renamed from: g */
    private static final String f18373g = "phone";

    /* renamed from: h */
    private static final String f18374h = "city";

    /* renamed from: i */
    private static final String f18375i = "fusion_hybrid";

    /* renamed from: j */
    private static final String f18376j = "download_temp";

    /* renamed from: k */
    private static OfflineBundleManager f18377k;

    /* renamed from: z */
    private static final AtomicBoolean f18378z = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f18379A = false;

    /* renamed from: B */
    private FusionOfflineEventBroadcastReceiver f18380B;

    /* renamed from: l */
    private final Context f18381l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final BundleInfoDao f18382m;

    /* renamed from: n */
    private String f18383n;

    /* renamed from: o */
    private final int f18384o;

    /* renamed from: p */
    private final String f18385p;

    /* renamed from: q */
    private final String f18386q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public File f18387r;

    /* renamed from: s */
    private File f18388s;

    /* renamed from: t */
    private ConcurrentHashMap<String, HashMap<String, ArrayList<OfflineBundleInfo>>> f18389t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CopyOnWriteArrayList<OfflineBundleInfo> f18390u;

    /* renamed from: v */
    private final UrlTrieTree f18391v = new UrlTrieTree();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f18392w = false;

    /* renamed from: x */
    private int f18393x = Integer.MAX_VALUE;

    /* renamed from: y */
    private NetworkChangedReceiver f18394y;

    public static synchronized void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (OfflineBundleManager.class) {
            if (f18377k == null) {
                f18377k = new OfflineBundleManager(application, fusionInitConfig);
                f18378z.getAndSet(true);
            }
            f18377k.m13639a();
        }
    }

    public static OfflineBundleManager getInstance() {
        return f18377k;
    }

    public static boolean isInitialized() {
        return f18378z.get();
    }

    private OfflineBundleManager(Context context, FusionInitConfig fusionInitConfig) {
        this.f18381l = context;
        this.f18382m = new BundleInfoDao(context);
        this.f18386q = fusionInitConfig.getHybridUrl();
        this.f18385p = fusionInitConfig.getAppKey();
        this.f18383n = fusionInitConfig.getPhone();
        this.f18384o = fusionInitConfig.getCityId();
    }

    /* renamed from: a */
    private void m13639a() {
        this.f18387r = this.f18381l.getDir(f18375i, 0);
        File file = new File(this.f18387r, f18376j);
        this.f18388s = file;
        if (!file.exists()) {
            this.f18388s.mkdirs();
        }
    }

    public File findBundleFileEx(String str) {
        OfflineBundleInfo searchUrlEx;
        if (str.length() >= this.f18393x && (searchUrlEx = this.f18391v.searchUrlEx(str)) != null && searchUrlEx.isValid()) {
            File file = new File(new File(this.f18387r, searchUrlEx.getBundleDirName()), str.substring(searchUrlEx.getOriginUrl().length()));
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public void startUpdate() {
        if (TextUtils.isEmpty(this.f18383n)) {
            this.f18383n = FusionEngine.getBusinessAgent().getUserPhone();
        }
        if (TextUtils.isEmpty(this.f18383n)) {
            this.f18383n = "";
        }
        if (!TextUtils.isEmpty(this.f18386q) && !TextUtils.isEmpty(this.f18385p)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    OfflineBundleManager offlineBundleManager = OfflineBundleManager.this;
                    CopyOnWriteArrayList unused = offlineBundleManager.f18390u = offlineBundleManager.m13647c();
                    HashMap hashMap = new HashMap();
                    Iterator it = OfflineBundleManager.this.f18390u.iterator();
                    while (it.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                        hashMap.put(offlineBundleInfo.getBundleName(), offlineBundleInfo);
                    }
                    CopyOnWriteArrayList c = OfflineBundleManager.this.m13650d();
                    Iterator it2 = c.iterator();
                    while (it2.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo2 = (OfflineBundleInfo) it2.next();
                        if (hashMap.containsKey(offlineBundleInfo2.getBundleName())) {
                            ((OfflineBundleInfo) hashMap.get(offlineBundleInfo2.getBundleName())).setState(0);
                        }
                    }
                    boolean unused2 = OfflineBundleManager.this.f18379A = true;
                    Iterator it3 = c.iterator();
                    while (it3.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo3 = (OfflineBundleInfo) it3.next();
                        if (hashMap.containsKey(offlineBundleInfo3.getBundleName())) {
                            if (offlineBundleInfo3.isDelete() || offlineBundleInfo3.isRollback()) {
                                OfflineBundleInfo offlineBundleInfo4 = (OfflineBundleInfo) hashMap.get(offlineBundleInfo3.getBundleName());
                                File file = new File(OfflineBundleManager.this.f18387r, offlineBundleInfo4.getBundleDirName());
                                if (file.exists()) {
                                    file.delete();
                                }
                                offlineBundleInfo4.updateInfo(offlineBundleInfo3);
                                OfflineBundleManager.this.f18382m.deleteBundleInfo(offlineBundleInfo4);
                            } else if (offlineBundleInfo3.isComplete()) {
                                OfflineBundleManager.this.m13641a(offlineBundleInfo3, 1);
                                OfflineBundleInfo offlineBundleInfo5 = (OfflineBundleInfo) hashMap.get(offlineBundleInfo3.getBundleName());
                                File file2 = new File(OfflineBundleManager.this.f18387r, offlineBundleInfo5.getBundleDirName());
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                offlineBundleInfo5.updateInfo(offlineBundleInfo3);
                                OfflineBundleManager.this.f18382m.updateBundleInfo(offlineBundleInfo5);
                            }
                        } else if (!offlineBundleInfo3.isDelete() && !offlineBundleInfo3.isRollback() && offlineBundleInfo3.isComplete()) {
                            OfflineBundleManager.this.m13641a(offlineBundleInfo3, 1);
                            OfflineBundleManager.this.f18390u.add(offlineBundleInfo3);
                            OfflineBundleManager.this.f18382m.addBundleInfo(offlineBundleInfo3);
                        }
                    }
                    OfflineBundleManager.this.f18382m.destroy();
                    OfflineBundleManager.this.m13645b();
                    if (OfflineBundleManager.this.f18392w) {
                        OfflineBundleManager.this.m13653f();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13645b() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.f18390u;
        if (copyOnWriteArrayList != null) {
            Iterator<OfflineBundleInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                m13640a(it.next());
            }
        }
    }

    /* renamed from: a */
    private void m13640a(OfflineBundleInfo offlineBundleInfo) {
        if (offlineBundleInfo.isValid()) {
            if (offlineBundleInfo.getOriginUrl().length() < this.f18393x) {
                this.f18393x = offlineBundleInfo.getOriginUrl().length();
            }
            this.f18391v.addNode(offlineBundleInfo.getOriginUrl(), offlineBundleInfo);
        }
    }

    /* renamed from: b */
    private void m13646b(OfflineBundleInfo offlineBundleInfo) {
        Uri parse = Uri.parse(offlineBundleInfo.getOriginUrl());
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (offlineBundleInfo.getOriginUrl().length() < this.f18393x) {
            this.f18393x = offlineBundleInfo.getOriginUrl().length();
        }
        if (!this.f18389t.containsKey(scheme)) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(offlineBundleInfo);
            hashMap.put(host, arrayList);
            this.f18389t.put(scheme, hashMap);
        } else if (this.f18389t.get(scheme).containsKey(host)) {
            ((ArrayList) this.f18389t.get(scheme).get(host)).add(offlineBundleInfo);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(offlineBundleInfo);
            this.f18389t.get(scheme).put(host, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public CopyOnWriteArrayList<OfflineBundleInfo> m13647c() {
        return new CopyOnWriteArrayList<>(this.f18382m.loadAllBundleInfos());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public CopyOnWriteArrayList<OfflineBundleInfo> m13650d() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", this.f18385p);
        hashMap.put("app_version", C7819Util.getVersionNameAndCode(this.f18381l));
        hashMap.put("device_type", WsgSafeUtil.getModel(this.f18381l));
        hashMap.put("device_id", DeviceUtil.getUUID(this.f18381l));
        hashMap.put("os_type", Build.VERSION.SDK_INT + "");
        hashMap.put("phone", this.f18383n);
        hashMap.put("city", this.f18384o + "");
        hashMap.put(f18367a, m13652e());
        try {
            String executeGetRequest = new FusionHttpClient(HttpUtil.appendQueryParams(this.f18386q, hashMap), (Map<String, String>) null).executeGetRequest();
            if (!TextUtils.isEmpty(executeGetRequest)) {
                JSONArray jSONArray = new JSONObject(executeGetRequest).getJSONArray(f18367a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    OfflineBundleInfo fromJson = OfflineBundleInfo.fromJson(jSONArray.getJSONObject(i));
                    if (fromJson != null) {
                        copyOnWriteArrayList.add(fromJson);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* renamed from: e */
    private String m13652e() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.f18390u;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<OfflineBundleInfo> it = this.f18390u.iterator();
        while (it.hasNext()) {
            OfflineBundleInfo next = it.next();
            sb.append(String.format("%s:%s;", new Object[]{next.getBundleName(), next.getBundleVersion()}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ad, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m13641a(com.didi.dimina.webview.resource.offline.OfflineBundleInfo r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x00ac
            boolean r0 = r8.isRollback()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x000b
            goto L_0x00ac
        L_0x000b:
            android.content.Context r0 = r7.f18381l     // Catch:{ all -> 0x00a9 }
            boolean r0 = com.didi.dimina.webview.util.NetworkUtil.isNetworkWifi(r0)     // Catch:{ all -> 0x00a9 }
            r1 = 2
            r2 = 1
            if (r0 != 0) goto L_0x0023
            int r0 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0023
            r9 = 4
            r8.setState(r9)     // Catch:{ all -> 0x00a9 }
            r7.f18392w = r2     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x0023:
            r0 = 3
            if (r9 == r0) goto L_0x002e
            int r9 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r9 != r0) goto L_0x002e
            monitor-exit(r7)
            return
        L_0x002e:
            r8.setState(r2)     // Catch:{ all -> 0x00a9 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r3 = r7.f18388s     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = r8.getBundleFileName()     // Catch:{ all -> 0x00a9 }
            r9.<init>(r3, r4)     // Catch:{ all -> 0x00a9 }
            boolean r3 = r9.exists()     // Catch:{ all -> 0x00a9 }
            r4 = 0
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = com.didi.dimina.webview.util.MD5Util.fileMD5(r9)     // Catch:{ IOException -> 0x0063 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0063 }
            if (r5 != 0) goto L_0x0058
            java.lang.String r5 = r8.getMd5()     // Catch:{ IOException -> 0x0063 }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0058
            goto L_0x0068
        L_0x0058:
            boolean r2 = r9.delete()     // Catch:{ IOException -> 0x0063 }
            if (r2 != 0) goto L_0x0067
            r8.setState(r0)     // Catch:{ IOException -> 0x0063 }
            monitor-exit(r7)
            return
        L_0x0063:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00a9 }
        L_0x0067:
            r2 = 0
        L_0x0068:
            if (r2 != 0) goto L_0x0077
            com.didi.dimina.webview.resource.FusionHttpClient r2 = new com.didi.dimina.webview.resource.FusionHttpClient     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r8.getDownloadUrl()     // Catch:{ all -> 0x00a9 }
            r2.<init>(r3)     // Catch:{ all -> 0x00a9 }
            boolean r2 = r2.executeDownload(r9)     // Catch:{ all -> 0x00a9 }
        L_0x0077:
            if (r2 == 0) goto L_0x009f
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r5 = r7.f18387r     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r8.getBundleDirName()     // Catch:{ all -> 0x00a9 }
            r3.<init>(r5, r6)     // Catch:{ all -> 0x00a9 }
            boolean r5 = r3.exists()     // Catch:{ all -> 0x00a9 }
            if (r5 == 0) goto L_0x008d
            r3.delete()     // Catch:{ all -> 0x00a9 }
        L_0x008d:
            r3.mkdirs()     // Catch:{ all -> 0x00a9 }
            com.didi.dimina.webview.util.ZipUtil.unzip(r9, r3)     // Catch:{ IOException -> 0x009d }
            boolean r3 = r9.exists()     // Catch:{ IOException -> 0x009d }
            if (r3 == 0) goto L_0x009f
            r9.delete()     // Catch:{ IOException -> 0x009d }
            goto L_0x009f
        L_0x009d:
            goto L_0x00a0
        L_0x009f:
            r4 = r2
        L_0x00a0:
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r1 = 3
        L_0x00a4:
            r8.setState(r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x00a9:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00ac:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.resource.offline.OfflineBundleManager.m13641a(com.didi.dimina.webview.resource.offline.OfflineBundleInfo, int):void");
    }

    public void registerEventListener() {
        this.f18380B = new FusionOfflineEventBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fusion_offline_event");
        LocalBroadcastManager.getInstance(this.f18381l.getApplicationContext()).registerReceiver(this.f18380B, intentFilter);
    }

    public void unregisterEventListener() {
        LocalBroadcastManager.getInstance(this.f18381l.getApplicationContext()).unregisterReceiver(this.f18380B);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m13653f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        this.f18394y = new NetworkChangedReceiver();
        try {
            this.f18381l.getApplicationContext().registerReceiver(this.f18394y, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m13655g() {
        try {
            this.f18381l.getApplicationContext().unregisterReceiver(this.f18394y);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public boolean isAllOfflineItemLoaded() {
        return this.f18379A;
    }

    public synchronized void downloadOfflineWhenEvent(final String str) {
        if (NetworkUtil.isAvailable(this.f18381l)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    if (OfflineBundleManager.this.f18390u != null && OfflineBundleManager.this.f18390u.size() > 0) {
                        Iterator it = OfflineBundleManager.this.f18390u.iterator();
                        while (it.hasNext()) {
                            OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                            if (offlineBundleInfo.getBundleName().equalsIgnoreCase(str)) {
                                OfflineBundleManager.this.m13641a(offlineBundleInfo, 3);
                                OfflineBundleManager.this.f18382m.updateBundleInfo(offlineBundleInfo);
                                return;
                            }
                        }
                    }
                }
            });
            this.f18382m.destroy();
        }
    }

    private class NetworkChangedReceiver extends BroadcastReceiver {
        private NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context) && NetworkUtil.isAvailable(context)) {
                FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                    public void run() {
                        if (OfflineBundleManager.this.f18390u != null && OfflineBundleManager.this.f18390u.size() > 0) {
                            Iterator it = OfflineBundleManager.this.f18390u.iterator();
                            while (it.hasNext()) {
                                OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                                if (offlineBundleInfo.getState() == 4) {
                                    OfflineBundleManager.this.m13641a(offlineBundleInfo, 2);
                                    OfflineBundleManager.this.f18382m.updateBundleInfo(offlineBundleInfo);
                                }
                            }
                        }
                    }
                });
                OfflineBundleManager.this.f18382m.destroy();
                OfflineBundleManager.this.m13655g();
            }
        }
    }
}
