package com.didichuxing.request;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bean.CubeResponse;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSystemUtil;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import org.json.JSONException;
import org.json.JSONObject;

class CubeRequester extends UpgradeBaseRequest {

    /* renamed from: a */
    public static final int f48492a = 1;

    /* renamed from: b */
    public static final int f48493b = 2;

    /* renamed from: c */
    private static final String f48494c = "UpgradeSDK_Cube";

    public interface CubeCallback {
        void onFailed(int i);

        void onSuccess(int i, int i2);
    }

    CubeRequester() {
    }

    /* renamed from: a */
    public static void m34783a(final Context context, final CubeCallback cubeCallback) {
        new Thread("CubeRequester request") {
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00e4 A[Catch:{ all -> 0x00f1 }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5  */
            /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    java.lang.String r0 = "UpgradeSDK_Cube"
                    r1 = 0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r2.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r3 = com.didichuxing.request.UpgradeBaseRequest.getHost()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r2.append(r3)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r3 = "/muse/update/switch"
                    r2.append(r3)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    android.content.Context r3 = r2     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r3 = com.didichuxing.request.CubeRequester.m34785b((android.content.Context) r3)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r4.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r5 = "request cube url = "
                    r4.append(r5)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r4.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r4.append(r3)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    com.didichuxing.util.UpLogger.m35522d(r0, r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r5.<init>()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r5.append(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r5.append(r3)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    r4.<init>(r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.net.URLConnection r2 = r4.openConnection()     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00c1, all -> 0x00bf }
                    java.lang.String r1 = "GET"
                    r2.setRequestMethod(r1)     // Catch:{ Exception -> 0x00bd }
                    r1 = 15000(0x3a98, float:2.102E-41)
                    r2.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00bd }
                    r2.connect()     // Catch:{ Exception -> 0x00bd }
                    int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x00bd }
                    r3 = 200(0xc8, float:2.8E-43)
                    if (r1 != r3) goto L_0x00b1
                    java.io.InputStream r1 = r2.getInputStream()     // Catch:{ Exception -> 0x00bd }
                    r3 = 1024(0x400, float:1.435E-42)
                    byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00bd }
                    java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00bd }
                    r4.<init>()     // Catch:{ Exception -> 0x00bd }
                L_0x0071:
                    int r5 = r1.read(r3)     // Catch:{ Exception -> 0x00bd }
                    r6 = -1
                    if (r5 == r6) goto L_0x007d
                    r6 = 0
                    r4.write(r3, r6, r5)     // Catch:{ Exception -> 0x00bd }
                    goto L_0x0071
                L_0x007d:
                    java.lang.String r3 = "utf-8"
                    java.lang.String r3 = r4.toString(r3)     // Catch:{ Exception -> 0x00bd }
                    r4.close()     // Catch:{ Exception -> 0x00bd }
                    r1.close()     // Catch:{ Exception -> 0x00bd }
                    com.didichuxing.bean.CubeResponse r1 = com.didichuxing.request.CubeRequester.m34784b((java.lang.String) r3)     // Catch:{ Exception -> 0x00bd }
                    com.didichuxing.request.CubeRequester$CubeCallback r3 = r3     // Catch:{ Exception -> 0x00bd }
                    if (r3 == 0) goto L_0x00ba
                    if (r1 == 0) goto L_0x00aa
                    int r3 = r1.getErrno()     // Catch:{ Exception -> 0x00bd }
                    if (r3 != 0) goto L_0x00aa
                    boolean r3 = r1.isUpdate()     // Catch:{ Exception -> 0x00bd }
                    if (r3 == 0) goto L_0x00aa
                    com.didichuxing.request.CubeRequester$CubeCallback r3 = r3     // Catch:{ Exception -> 0x00bd }
                    r4 = 1
                    int r1 = r1.getInterval()     // Catch:{ Exception -> 0x00bd }
                    r3.onSuccess(r4, r1)     // Catch:{ Exception -> 0x00bd }
                    goto L_0x00ba
                L_0x00aa:
                    com.didichuxing.request.CubeRequester$CubeCallback r1 = r3     // Catch:{ Exception -> 0x00bd }
                    r3 = 2
                    r1.onFailed(r3)     // Catch:{ Exception -> 0x00bd }
                    goto L_0x00ba
                L_0x00b1:
                    com.didichuxing.request.CubeRequester$CubeCallback r3 = r3     // Catch:{ Exception -> 0x00bd }
                    if (r3 == 0) goto L_0x00ba
                    com.didichuxing.request.CubeRequester$CubeCallback r3 = r3     // Catch:{ Exception -> 0x00bd }
                    r3.onFailed(r1)     // Catch:{ Exception -> 0x00bd }
                L_0x00ba:
                    if (r2 == 0) goto L_0x00f0
                    goto L_0x00ed
                L_0x00bd:
                    r1 = move-exception
                    goto L_0x00c5
                L_0x00bf:
                    r0 = move-exception
                    goto L_0x00f3
                L_0x00c1:
                    r2 = move-exception
                    r7 = r2
                    r2 = r1
                    r1 = r7
                L_0x00c5:
                    r1.printStackTrace()     // Catch:{ all -> 0x00f1 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
                    r3.<init>()     // Catch:{ all -> 0x00f1 }
                    java.lang.String r4 = "request cube exception = "
                    r3.append(r4)     // Catch:{ all -> 0x00f1 }
                    java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00f1 }
                    r3.append(r1)     // Catch:{ all -> 0x00f1 }
                    java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00f1 }
                    com.didichuxing.util.UpLogger.m35523e(r0, r1)     // Catch:{ all -> 0x00f1 }
                    com.didichuxing.request.CubeRequester$CubeCallback r0 = r3     // Catch:{ all -> 0x00f1 }
                    if (r0 == 0) goto L_0x00eb
                    com.didichuxing.request.CubeRequester$CubeCallback r0 = r3     // Catch:{ all -> 0x00f1 }
                    r1 = 99
                    r0.onFailed(r1)     // Catch:{ all -> 0x00f1 }
                L_0x00eb:
                    if (r2 == 0) goto L_0x00f0
                L_0x00ed:
                    r2.disconnect()
                L_0x00f0:
                    return
                L_0x00f1:
                    r0 = move-exception
                    r1 = r2
                L_0x00f3:
                    if (r1 == 0) goto L_0x00f8
                    r1.disconnect()
                L_0x00f8:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.request.CubeRequester.C162781.run():void");
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m34785b(Context context) {
        if (context == null) {
            return "";
        }
        return "?" + "version_code=" + UpgradeSystemUtil.getVersionCode(context) + ParamKeys.SIGN_AND + "version=" + UpgradeSystemUtil.getVersionName(context) + ParamKeys.SIGN_AND + "app_name=" + context.getPackageName() + ParamKeys.SIGN_AND + "os_type=" + "android";
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static CubeResponse m34784b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_no");
            String optString = jSONObject.optString("err_msg");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            boolean optBoolean = jSONObject2.optBoolean(XEParseConst.CHILD_UPDATE_MODE_TAG);
            CubeResponse build = new CubeResponse.Builder().setErrNo(optInt).setErrMsg(optString).setUpdate(optBoolean).setInterval(jSONObject2.optInt("interval")).build();
            UpLogger.m35522d(f48494c, "cube response = " + build.toString());
            return build;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
