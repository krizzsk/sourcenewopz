package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.sdk.schedule.ScheduleTaskHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FileModule extends BaseHybridModule {
    public static final int REQUEST_CODE_OPEN_FILE = 1000;

    /* renamed from: a */
    private static final String f35987a = "FileModule";

    /* renamed from: b */
    private static final int f35988b = 104;

    /* renamed from: c */
    private static final int f35989c = -1;

    /* renamed from: d */
    private static final int f35990d = -2;

    /* renamed from: e */
    private static final int f35991e = -3;

    /* renamed from: f */
    private static final int f35992f = -4;

    /* renamed from: g */
    private final Activity f35993g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CallbackFunction f35994h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f35995i;

    /* renamed from: j */
    private int f35996j = 0;

    public FileModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f35993g = hybridableContainer.getActivity();
    }

    public Activity getActivity() {
        return this.f35993g;
    }

    public void chooseFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f35994h = callbackFunction;
        m25463a(jSONObject, this.f35993g);
    }

    /* renamed from: a */
    private void m25463a(JSONObject jSONObject, Activity activity) {
        if (jSONObject != null && activity != null) {
            this.f35995i = jSONObject.optString("file_extension");
            String optString = jSONObject.optString("file_path");
            this.f35996j = jSONObject.optInt("max_size");
            HashMap hashMap = new HashMap(3);
            hashMap.put(Constants.JSON_KEY_FILE_TYPE, this.f35995i);
            hashMap.put("file_path", optString);
            hashMap.put("max_size", Integer.valueOf(this.f35996j));
            OmegaSDKAdapter.trackEvent("tech_jsbridge_choose_file", (Map<String, Object>) hashMap);
            if (this.f35995i.isEmpty()) {
                this.f35995i = "application/pdf";
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.addFlags(2097152);
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse(optString));
            }
            intent.setType(this.f35995i);
            try {
                activity.startActivityForResult(intent, 1000);
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put(Constants.JSON_KEY_FILE_TYPE, this.f35995i);
                OmegaSDKAdapter.trackEvent("tech_jsbridge_open_file_browser", (Map<String, Object>) hashMap2);
            } catch (Exception unused) {
                m25461a(-1, (String) null);
            }
        }
    }

    public void handleActivityResult(int i, int i2, Intent intent) {
        m25462a("FileModule:handleActivityResult=>resultCode");
        HashMap hashMap = new HashMap(1);
        hashMap.put(Constants.JSON_KEY_FILE_TYPE, this.f35995i);
        OmegaSDKAdapter.trackEvent("tech_jsbridge_select_file", (Map<String, Object>) hashMap);
        if (i == 1000) {
            final Uri data = intent.getData();
            if (data == null) {
                m25461a(-2, (String) null);
            } else {
                ScheduleTaskHelper.getInstance().schedule(new Runnable() {
                    public void run() {
                        FileModule.this.getBytesFromStore(data);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m25462a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("append_log_msg", str);
        OmegaSDKAdapter.trackEvent("gd_omega_diagnose_track_event", (Map<String, Object>) hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085 A[SYNTHETIC, Splitter:B:43:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0095 A[SYNTHETIC, Splitter:B:52:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a0 A[SYNTHETIC, Splitter:B:59:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ab A[SYNTHETIC, Splitter:B:66:0x00ab] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x0080=Splitter:B:40:0x0080, B:49:0x0090=Splitter:B:49:0x0090, B:56:0x009b=Splitter:B:56:0x009b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getBytesFromStore(android.net.Uri r11) {
        /*
            r10 = this;
            android.app.Activity r0 = r10.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = -2
            r1 = 0
            android.app.Activity r2 = r10.getActivity()     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            java.lang.String r2 = r2.getType(r11)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            java.lang.String r3 = r10.f35995i     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            boolean r2 = android.text.TextUtils.equals(r3, r2)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            if (r2 != 0) goto L_0x0022
            r11 = -4
            r10.m25461a((int) r11, (java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            return
        L_0x0022:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            android.app.Activity r3 = r10.getActivity()     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            java.io.InputStream r11 = r3.openInputStream(r11)     // Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x008e, Exception -> 0x007e, all -> 0x007c }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            r4 = 0
            r5 = 0
        L_0x0039:
            int r6 = r11.read(r3)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            r7 = 104(0x68, float:1.46E-43)
            if (r6 <= 0) goto L_0x0051
            int r5 = r5 + r6
            r2.write(r3, r4, r6)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            int r6 = r10.f35996j     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            if (r6 <= 0) goto L_0x0039
            int r6 = r5 / 1024
            int r8 = r10.f35996j     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            if (r6 <= r8) goto L_0x0039
            r3 = -3
            goto L_0x0053
        L_0x0051:
            r3 = 104(0x68, float:1.46E-43)
        L_0x0053:
            if (r3 != r7) goto L_0x005d
            byte[] r2 = r2.toByteArray()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
            java.lang.String r1 = r10.m25460a((byte[]) r2)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0072, Exception -> 0x006d, all -> 0x0069 }
        L_0x005d:
            if (r11 == 0) goto L_0x0067
            r11.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0067:
            r0 = r3
            goto L_0x00a3
        L_0x0069:
            r0 = move-exception
            r1 = r11
            r11 = r0
            goto L_0x00a9
        L_0x006d:
            r2 = move-exception
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x0080
        L_0x0072:
            r2 = move-exception
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x0090
        L_0x0077:
            r2 = move-exception
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x009b
        L_0x007c:
            r11 = move-exception
            goto L_0x00a9
        L_0x007e:
            r11 = move-exception
            r2 = r1
        L_0x0080:
            r11.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x00a3
        L_0x0089:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x00a3
        L_0x008e:
            r11 = move-exception
            r2 = r1
        L_0x0090:
            r11.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x00a3
        L_0x0099:
            r11 = move-exception
            r2 = r1
        L_0x009b:
            r11.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ IOException -> 0x0089 }
        L_0x00a3:
            r10.m25461a((int) r0, (java.lang.String) r1)
            return
        L_0x00a7:
            r11 = move-exception
            r1 = r2
        L_0x00a9:
            if (r1 == 0) goto L_0x00b3
            r1.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fusionbridge.module.FileModule.getBytesFromStore(android.net.Uri):void");
    }

    /* renamed from: a */
    private String m25460a(byte[] bArr) {
        String str = null;
        if (bArr != null && bArr.length > 0) {
            HashMap hashMap = new HashMap(2);
            hashMap.put(Constants.JSON_KEY_FILE_TYPE, this.f35995i);
            try {
                str = Base64.encodeToString(bArr, 2);
                hashMap.put("success", true);
            } catch (Exception unused) {
                hashMap.put("success", false);
            }
            OmegaSDKAdapter.trackEvent("tech_jsbridge_file_to_base64", (Map<String, Object>) hashMap);
        }
        return str;
    }

    /* renamed from: a */
    private void m25461a(final int i, final String str) {
        if (this.f35994h != null) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Constants.ERROR_CODE, Integer.valueOf(i));
                    hashMap.put("fileBase64String", str);
                    FileModule.this.f35994h.onCallBack(new JSONObject(hashMap));
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("error_code", Integer.valueOf(i));
                    hashMap2.put(Constants.JSON_KEY_FILE_TYPE, FileModule.this.f35995i);
                    OmegaSDKAdapter.trackEvent("tech_jsbridge_choose_callback", (Map<String, Object>) hashMap2);
                }
            });
        }
    }
}
