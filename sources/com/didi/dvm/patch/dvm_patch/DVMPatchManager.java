package com.didi.dvm.patch.dvm_patch;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.FileUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.ddmirror.monitor.PrismConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class DVMPatchManager {

    /* renamed from: a */
    static String f19295a = "dvm_patch_control";

    /* renamed from: b */
    static File f19296b;

    /* renamed from: c */
    static File f19297c;

    /* renamed from: d */
    static C7968b f19298d = new C7967a();

    /* renamed from: e */
    static WeakReference<DvmPatchPlugin> f19299e;

    /* renamed from: f */
    static File f19300f;

    /* renamed from: g */
    static File f19301g;

    /* renamed from: h */
    static String f19302h;

    /* renamed from: i */
    static String f19303i;

    /* renamed from: j */
    static Context f19304j;

    /* renamed from: k */
    static Set<String> f19305k = new HashSet();

    /* renamed from: l */
    static JSONObject f19306l = new JSONObject();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static Logger f19307m = LoggerFactory.getLogger("DVMPatchManager");

    /* renamed from: n */
    private static String f19308n;

    /* renamed from: d */
    private static boolean m14424d() {
        return false;
    }

    public static void setEventTracker(C7968b bVar) {
        if (bVar != null) {
            f19298d = bVar;
        }
    }

    public static void setDebugContent(String str) {
        f19308n = str;
    }

    public static File getDvmPatchDir(String str) {
        return new File(f19297c, str);
    }

    public static void init(Context context, String str) {
        f19304j = context;
        f19295a = str;
        f19296b = new File(f19304j.getFilesDir(), "dvm");
        f19297c = new File(f19296b, "patches");
        f19300f = new File(f19296b, "patches.json");
        f19301g = new File(f19304j.getCacheDir(), "dvm");
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(f19304j.getPackageManager(), f19304j.getPackageName(), 0);
            f19302h = "" + packageInfo.versionCode;
            f19303i = packageInfo.versionName;
            new Thread(new Runnable() {
                public void run() {
                    DVMPatchManager.m14423c();
                }
            }).start();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m14423c() {
        String str = (String) getParam(f19295a, "patches", "");
        if (m14424d()) {
            str = f19308n;
        }
        Logger logger = f19307m;
        logger.debug("responseContent：" + str, new Object[0]);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject readFile2JSON = readFile2JSON(f19300f);
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                jSONObject.remove("data");
                f19306l = jSONObject;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    DVMPatchDownloader dVMPatchDownloader = new DVMPatchDownloader();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        DVMPatchBean from = DVMPatchBean.from(optJSONArray.getJSONObject(i));
                        if (from.f19282d == DVMPatchBean.ACTION_ADD_AND_UPDATE) {
                            if (!from.isVersionMatch()) {
                                Logger logger2 = f19307m;
                                logger2.debug(from.f19279a + " is not Version Match", new Object[0]);
                            } else if (from.isDownloaded(readFile2JSON)) {
                                Logger logger3 = f19307m;
                                logger3.debug(from.f19279a + " is Downloaded", new Object[0]);
                            } else {
                                dVMPatchDownloader.addTask(from);
                            }
                        } else if (from.f19282d == DVMPatchBean.ACTION_ROLLBACK) {
                            from.rollback();
                        }
                    }
                    dVMPatchDownloader.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
                HashMap hashMap = new HashMap();
                hashMap.put("response", str);
                hashMap.put("vn", f19303i);
                hashMap.put(PrismConstants.Symbol.VIEW_CLASS, f19302h);
                hashMap.put("e", e.toString());
                hashMap.put(RavenKey.STACK, C7968b.m14426a(e));
                f19298d.mo59023a("tech_dvm_patch_request_error", hashMap);
            }
        }
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            f19307m.error(e.getMessage(), new Object[0]);
            return t;
        }
    }

    /* renamed from: a */
    static JSONObject m14419a(DvmPatchPlugin dvmPatchPlugin) {
        f19299e = new WeakReference<>(dvmPatchPlugin);
        if (m14424d() || Apollo.getToggle(f19295a).allow()) {
            File file = f19300f;
            if (file == null || !file.exists()) {
                f19307m.debug("getPatchesInfo patchControlFile is not exists", new Object[0]);
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = f19306l.keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
                JSONObject jSONObject = new JSONObject(f19306l, (String[]) arrayList.toArray(new String[0]));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("data", jSONObject2);
                JSONObject readFile2JSON = readFile2JSON(f19300f);
                if (readFile2JSON != null) {
                    Iterator<String> keys2 = readFile2JSON.keys();
                    boolean z = false;
                    while (keys2.hasNext()) {
                        String next = keys2.next();
                        DVMPatchBean from = DVMPatchBean.from(next, readFile2JSON.optJSONObject(next));
                        if (!from.selfChecking().f19290ok) {
                            f19305k.add(next);
                            keys2.remove();
                            z = true;
                        } else {
                            JSONArray optJSONArray = jSONObject2.optJSONArray(from.f19286h);
                            if (optJSONArray == null) {
                                optJSONArray = new JSONArray();
                                jSONObject2.put(from.f19286h, optJSONArray);
                            }
                            optJSONArray.put(from.getPatchInfo());
                        }
                    }
                    if (z) {
                        m14421a(readFile2JSON);
                    }
                }
                f19307m.debug(jSONObject.toString(), new Object[0]);
                return jSONObject;
            } catch (Exception e) {
                f19307m.error("getPatchesInfo error", (Throwable) e);
                return null;
            }
        } else {
            f19307m.debug("getPatchesInfo ab is not allow", new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[SYNTHETIC, Splitter:B:27:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject readFile2JSON(java.io.File r4) {
        /*
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033, JSONException -> 0x0031, all -> 0x002f }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0033, JSONException -> 0x0031, all -> 0x002f }
            int r4 = r0.available()     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r0.read(r4)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r0.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            return r4
        L_0x002b:
            r4 = move-exception
            goto L_0x0035
        L_0x002d:
            r4 = move-exception
            goto L_0x0035
        L_0x002f:
            r4 = move-exception
            goto L_0x004a
        L_0x0031:
            r4 = move-exception
            goto L_0x0034
        L_0x0033:
            r4 = move-exception
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.didi.sdk.logging.Logger r2 = f19307m     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "readFile2JSON error"
            r2.error((java.lang.String) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0047:
            return r1
        L_0x0048:
            r4 = move-exception
            r1 = r0
        L_0x004a:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0054:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchManager.readFile2JSON(java.io.File):org.json.JSONObject");
    }

    /* renamed from: a */
    private static void m14421a(final JSONObject jSONObject) {
        f19307m.debug("try updatePatchInfoFiles", new Object[0]);
        new Thread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[SYNTHETIC, Splitter:B:26:0x0070] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x007b A[SYNTHETIC, Splitter:B:34:0x007b] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    java.util.Set<java.lang.String> r0 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19305k
                    monitor-enter(r0)
                    r1 = 0
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
                    java.io.File r4 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19300f     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
                    r3.<init>(r4)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
                    r2.<init>(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0062 }
                    org.json.JSONObject r1 = r3     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0060 }
                    r2.write(r1)     // Catch:{ IOException -> 0x0060 }
                    com.didi.sdk.logging.Logger r3 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19307m     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r4 = "updatePatchInfoFiles"
                    r5 = 0
                    java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0060 }
                    r3.debug((java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ IOException -> 0x0060 }
                    com.didi.sdk.logging.Logger r3 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19307m     // Catch:{ IOException -> 0x0060 }
                    java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0060 }
                    r3.debug((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ IOException -> 0x0060 }
                    java.util.Set<java.lang.String> r1 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19305k     // Catch:{ IOException -> 0x0060 }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0060 }
                L_0x0035:
                    boolean r3 = r1.hasNext()     // Catch:{ IOException -> 0x0060 }
                    if (r3 == 0) goto L_0x0052
                    java.lang.Object r3 = r1.next()     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0060 }
                    java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0060 }
                    java.io.File r5 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19297c     // Catch:{ IOException -> 0x0060 }
                    r4.<init>(r5, r3)     // Catch:{ IOException -> 0x0060 }
                    boolean r3 = r4.exists()     // Catch:{ IOException -> 0x0060 }
                    if (r3 == 0) goto L_0x0035
                    r4.delete()     // Catch:{ IOException -> 0x0060 }
                    goto L_0x0035
                L_0x0052:
                    java.util.Set<java.lang.String> r1 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19305k     // Catch:{ IOException -> 0x0060 }
                    r1.clear()     // Catch:{ IOException -> 0x0060 }
                    r2.close()     // Catch:{ IOException -> 0x005b }
                    goto L_0x0076
                L_0x005b:
                    r1 = move-exception
                L_0x005c:
                    r1.printStackTrace()     // Catch:{ all -> 0x0084 }
                    goto L_0x0076
                L_0x0060:
                    r1 = move-exception
                    goto L_0x006b
                L_0x0062:
                    r2 = move-exception
                    r7 = r2
                    r2 = r1
                    r1 = r7
                    goto L_0x0079
                L_0x0067:
                    r2 = move-exception
                    r7 = r2
                    r2 = r1
                    r1 = r7
                L_0x006b:
                    r1.printStackTrace()     // Catch:{ all -> 0x0078 }
                    if (r2 == 0) goto L_0x0076
                    r2.close()     // Catch:{ IOException -> 0x0074 }
                    goto L_0x0076
                L_0x0074:
                    r1 = move-exception
                    goto L_0x005c
                L_0x0076:
                    monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                    return
                L_0x0078:
                    r1 = move-exception
                L_0x0079:
                    if (r2 == 0) goto L_0x0083
                    r2.close()     // Catch:{ IOException -> 0x007f }
                    goto L_0x0083
                L_0x007f:
                    r2 = move-exception
                    r2.printStackTrace()     // Catch:{ all -> 0x0084 }
                L_0x0083:
                    throw r1     // Catch:{ all -> 0x0084 }
                L_0x0084:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0084 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchManager.C79562.run():void");
            }
        }).start();
    }

    public static void takeEffect(DVMPatchBean dVMPatchBean) {
        synchronized (f19305k) {
            JSONObject readFile2JSON = readFile2JSON(f19300f);
            if (readFile2JSON == null) {
                readFile2JSON = new JSONObject();
            }
            if (dVMPatchBean.f19282d == DVMPatchBean.ACTION_ADD_AND_UPDATE) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : dVMPatchBean.f19281c) {
                        jSONArray.put(put);
                    }
                    jSONObject.put("appVersion", jSONArray);
                    jSONObject.put("version", dVMPatchBean.f19280b);
                    readFile2JSON.put(dVMPatchBean.f19279a, jSONObject);
                    FileUtil.writeString(f19300f.getAbsolutePath(), readFile2JSON.toString());
                    f19307m.debug("takeEffect success [" + dVMPatchBean.f19279a + Const.jaRight, new Object[0]);
                } catch (Exception e) {
                    f19307m.error("takeEffect error", (Throwable) e);
                }
            } else if (dVMPatchBean.f19282d == DVMPatchBean.ACTION_ROLLBACK && dVMPatchBean.f19288j != null) {
                for (String remove : dVMPatchBean.f19288j) {
                    readFile2JSON.remove(remove);
                }
                FileUtil.writeString(f19300f.getAbsolutePath(), readFile2JSON.toString());
                f19307m.debug("rollback success", new Object[0]);
            }
        }
    }

    public static boolean isVersionMatch(String[] strArr) {
        boolean z;
        if (strArr != null) {
            z = false;
            for (String split : strArr) {
                String[] split2 = split.split("@");
                if (split2[0].equals(f19303i)) {
                    z = split2.length == 2 ? split2[1].equals(f19302h) : true;
                    if (z) {
                        break;
                    }
                }
            }
        } else {
            z = false;
        }
        f19307m.debug("isVersionMatch：" + z, new Object[0]);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.didi.dvm.patch.dvm_patch.DvmPatchPlugin) r0.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void tryRefresh() {
        /*
            java.lang.ref.WeakReference<com.didi.dvm.patch.dvm_patch.DvmPatchPlugin> r0 = f19299e
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r0.get()
            com.didi.dvm.patch.dvm_patch.DvmPatchPlugin r0 = (com.didi.dvm.patch.dvm_patch.DvmPatchPlugin) r0
            if (r0 == 0) goto L_0x001d
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            com.didi.dvm.patch.dvm_patch.DVMPatchManager$3 r2 = new com.didi.dvm.patch.dvm_patch.DVMPatchManager$3
            r2.<init>()
            r1.post(r2)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchManager.tryRefresh():void");
    }
}
