package com.didi.component.common.helper;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.didi.component.common.util.ZipUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Car3dHelper {

    /* renamed from: b */
    private static Car3dHelper f11599b;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f11600a = LoggerFactory.getLogger("Car3dHelper");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f11601c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<String, List<String>> f11602d = new HashMap();

    public interface LoadCallBack {
        void onFailed();

        void onSuccess(List<String> list);
    }

    private Car3dHelper() {
    }

    public static Car3dHelper getInstance() {
        if (f11599b == null) {
            synchronized (Car3dHelper.class) {
                if (f11599b == null) {
                    f11599b = new Car3dHelper();
                }
            }
        }
        return f11599b;
    }

    public synchronized void loadIconList(final String str, final Context context, final LoadCallBack loadCallBack) {
        Logger logger = this.f11600a;
        logger.debug("loadIconList: " + str, new Object[0]);
        if (loadCallBack != null) {
            if (!this.f11601c) {
                ThreadPoolHelper.getInstance().execute(new Runnable() {
                    public void run() {
                        String a = Car3dHelper.this.m7855a(str);
                        if (a == null) {
                            loadCallBack.onFailed();
                        } else if (Car3dHelper.this.f11602d.containsKey(a)) {
                            Car3dHelper car3dHelper = Car3dHelper.this;
                            car3dHelper.m7860a(loadCallBack, (List<String>) (List) car3dHelper.f11602d.get(a));
                        } else {
                            List a2 = Car3dHelper.this.m7856a(context, ZipUtils.getZipName(a));
                            if (a2 == null || a2.size() <= 0) {
                                boolean unused = Car3dHelper.this.f11601c = true;
                                Car3dHelper car3dHelper2 = Car3dHelper.this;
                                Context context = context;
                                car3dHelper2.m7859a(context, str, car3dHelper2.m7852a(context), a, loadCallBack);
                                return;
                            }
                            Car3dHelper.this.m7860a(loadCallBack, (List<String>) a2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7860a(final LoadCallBack loadCallBack, final List<String> list) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                loadCallBack.onSuccess(list);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7855a(String str) {
        try {
            String file = new URL(str).getFile();
            return file.substring(file.lastIndexOf("/") + 2);
        } catch (Exception e) {
            e.printStackTrace();
            Logger logger = this.f11600a;
            logger.debug("loadIconList: failed " + e.toString(), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7859a(Context context, String str, String str2, String str3, LoadCallBack loadCallBack) {
        Logger logger = this.f11600a;
        logger.debug("downLoadZip: filedir = " + str2 + "   fileName = " + str3, new Object[0]);
        final String str4 = str2;
        final String str5 = str3;
        final String str6 = str;
        final Context context2 = context;
        final LoadCallBack loadCallBack2 = loadCallBack;
        new OkHttpClient().newCall(new Request.Builder().url(str).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Logger b = Car3dHelper.this.f11600a;
                b.debug("onFailure: " + iOException.toString(), new Object[0]);
                boolean unused = Car3dHelper.this.f11601c = false;
            }

            /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|7|(1:9)|10|(3:11|12|(1:14)(1:58))|15|(1:19)|(2:21|22)|42|43|44|46) */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
                if (r3 == null) goto L_0x00c4;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00c1 */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba A[SYNTHETIC, Splitter:B:38:0x00ba] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A[SYNTHETIC, Splitter:B:49:0x00cd] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x00d4 A[SYNTHETIC, Splitter:B:53:0x00d4] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(okhttp3.Call r6, okhttp3.Response r7) throws java.io.IOException {
                /*
                    r5 = this;
                    okhttp3.ResponseBody r6 = r7.body()
                    if (r6 != 0) goto L_0x0007
                    return
                L_0x0007:
                    r6 = 2048(0x800, float:2.87E-42)
                    byte[] r6 = new byte[r6]
                    r0 = 0
                    r1 = 0
                    okhttp3.ResponseBody r7 = r7.body()     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                    java.io.InputStream r7 = r7.byteStream()     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    java.lang.String r4 = r4     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    r2.<init>(r3, r4)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    boolean r3 = r2.exists()     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    if (r3 != 0) goto L_0x0027
                    r2.createNewFile()     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                L_0x0027:
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
                L_0x002c:
                    int r0 = r7.read(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r2 = -1
                    if (r0 == r2) goto L_0x0037
                    r3.write(r6, r1, r0)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    goto L_0x002c
                L_0x0037:
                    r3.flush()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    com.didi.component.common.helper.Car3dHelper r6 = com.didi.component.common.helper.Car3dHelper.this     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    com.didi.sdk.logging.Logger r6 = r6.f11600a     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r0.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r2 = "download success,url = "
                    r0.append(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r2 = r5     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r0.append(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r6.debug((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    com.didi.component.common.helper.Car3dHelper r6 = com.didi.component.common.helper.Car3dHelper.this     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r2 = r4     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r6.m7864a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    com.didi.component.common.helper.Car3dHelper r6 = com.didi.component.common.helper.Car3dHelper.this     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    android.content.Context r0 = r6     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r2 = r4     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.lang.String r2 = com.didi.component.common.util.ZipUtils.getZipName(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    java.util.List r6 = r6.m7856a((android.content.Context) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    if (r6 == 0) goto L_0x007e
                    int r0 = r6.size()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    if (r0 <= 0) goto L_0x007e
                    com.didi.component.common.helper.Car3dHelper r0 = com.didi.component.common.helper.Car3dHelper.this     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    com.didi.component.common.helper.Car3dHelper$LoadCallBack r2 = r7     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                    r0.m7860a((com.didi.component.common.helper.Car3dHelper.LoadCallBack) r2, (java.util.List<java.lang.String>) r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
                L_0x007e:
                    if (r7 == 0) goto L_0x00c1
                    r7.close()     // Catch:{ IOException -> 0x00c1 }
                    goto L_0x00c1
                L_0x0084:
                    r6 = move-exception
                    goto L_0x008a
                L_0x0086:
                    r6 = move-exception
                    goto L_0x008e
                L_0x0088:
                    r6 = move-exception
                    r3 = r0
                L_0x008a:
                    r0 = r7
                    goto L_0x00cb
                L_0x008c:
                    r6 = move-exception
                    r3 = r0
                L_0x008e:
                    r0 = r7
                    goto L_0x0095
                L_0x0090:
                    r6 = move-exception
                    r3 = r0
                    goto L_0x00cb
                L_0x0093:
                    r6 = move-exception
                    r3 = r0
                L_0x0095:
                    com.didi.component.common.helper.Car3dHelper r7 = com.didi.component.common.helper.Car3dHelper.this     // Catch:{ all -> 0x00ca }
                    com.didi.sdk.logging.Logger r7 = r7.f11600a     // Catch:{ all -> 0x00ca }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
                    r2.<init>()     // Catch:{ all -> 0x00ca }
                    java.lang.String r4 = "download Exception: "
                    r2.append(r4)     // Catch:{ all -> 0x00ca }
                    java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00ca }
                    r2.append(r4)     // Catch:{ all -> 0x00ca }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ca }
                    java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00ca }
                    r7.error((java.lang.String) r2, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00ca }
                    r6.printStackTrace()     // Catch:{ all -> 0x00ca }
                    if (r0 == 0) goto L_0x00bf
                    r0.close()     // Catch:{ IOException -> 0x00be }
                    goto L_0x00bf
                L_0x00be:
                L_0x00bf:
                    if (r3 == 0) goto L_0x00c4
                L_0x00c1:
                    r3.close()     // Catch:{ IOException -> 0x00c4 }
                L_0x00c4:
                    com.didi.component.common.helper.Car3dHelper r6 = com.didi.component.common.helper.Car3dHelper.this
                    boolean unused = r6.f11601c = r1
                    return
                L_0x00ca:
                    r6 = move-exception
                L_0x00cb:
                    if (r0 == 0) goto L_0x00d2
                    r0.close()     // Catch:{ IOException -> 0x00d1 }
                    goto L_0x00d2
                L_0x00d1:
                L_0x00d2:
                    if (r3 == 0) goto L_0x00d7
                    r3.close()     // Catch:{ IOException -> 0x00d7 }
                L_0x00d7:
                    com.didi.component.common.helper.Car3dHelper r7 = com.didi.component.common.helper.Car3dHelper.this
                    boolean unused = r7.f11601c = r1
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.helper.Car3dHelper.C47783.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7864a(String str, String str2) {
        ZipUtils.unpackZip(str + "/", str2);
        Logger logger = this.f11600a;
        logger.debug("unZipFile success, fileName is " + str2, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7852a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getPath() + "/car3d");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e) {
                Logger logger = this.f11600a;
                logger.debug("getBaseFilePath: " + e.toString(), new Object[0]);
                e.printStackTrace();
            }
        }
        return file.getPath();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<String> m7856a(Context context, String str) {
        String a = m7852a(context);
        File file = new File(a, str);
        if (!file.exists()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.f11600a.debug(str + ": contains cache file, local path is" + file.getAbsolutePath(), new Object[0]);
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String str2 : list) {
                if (str2.endsWith("png")) {
                    arrayList.add(a + "/" + str + "/" + str2);
                }
            }
        }
        if (arrayList.size() > 0) {
            Collections.sort(arrayList);
            for (String str3 : arrayList) {
                this.f11600a.info("loadIconList: " + str3, new Object[0]);
            }
        }
        return arrayList;
    }
}
