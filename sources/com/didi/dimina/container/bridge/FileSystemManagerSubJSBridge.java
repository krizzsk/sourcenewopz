package com.didi.dimina.container.bridge;

import android.util.Base64;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public class FileSystemManagerSubJSBridge {

    /* renamed from: a */
    private final DMConfig f16568a;

    /* renamed from: b */
    private final DMSandboxHelper f16569b;

    public FileSystemManagerSubJSBridge(DMMina dMMina) {
        DMConfig config = dMMina.getConfig();
        this.f16568a = config;
        this.f16569b = new DMSandboxHelper(config);
        LogUtil.m13411i("FileSystemManagerSubJSBridge init");
    }

    public void unlink(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("FileSystemManagerSubJSBridge unlink: " + jSONObject);
        if (jSONObject.has(FlutterShareMethod.filePathKey)) {
            String url2filepath = this.f16569b.url2filepath(jSONObject.optString(FlutterShareMethod.filePathKey, ""));
            if (new File(url2filepath).isDirectory()) {
                CallBackUtil.onFail(url2filepath + "是一个目录", callbackFunction);
            }
            if (!FileUtil.exists(1, url2filepath)) {
                CallBackUtil.onFail("文件不存在", callbackFunction);
            } else if (FileUtil.delete(url2filepath)) {
                CallBackUtil.onSuccess(callbackFunction);
            } else {
                CallBackUtil.onFail("文件删除失败", callbackFunction);
            }
        } else {
            CallBackUtil.onFail("filePath为空", callbackFunction);
        }
    }

    public void readFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            CallBackUtil.onSuccess(readFileSync(jSONObject), callbackFunction);
        } catch (Exception e) {
            CallBackUtil.onFail(e.getMessage(), callbackFunction);
        }
    }

    public JSONObject readFileSync(JSONObject jSONObject) {
        String url2filepathWithoutDifile = this.f16569b.url2filepathWithoutDifile(jSONObject.optString(FlutterShareMethod.filePathKey, ""));
        try {
            String optString = jSONObject.optString("encoding", "utf-8");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", fileEncoder(url2filepathWithoutDifile, optString));
            return jSONObject2;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[SYNTHETIC, Splitter:B:22:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047 A[SYNTHETIC, Splitter:B:28:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileEncoder(java.lang.String r3, java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
            int r3 = r0.available()     // Catch:{ Exception -> 0x0034 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0034 }
            r0.read(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "base64"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x0034 }
            if (r4 == 0) goto L_0x0025
            r4 = 2
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r4)     // Catch:{ Exception -> 0x0034 }
            r1 = r3
            goto L_0x002b
        L_0x0025:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0034 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0034 }
            r1 = r4
        L_0x002b:
            r0.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0042
        L_0x002f:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0042
        L_0x0034:
            r3 = move-exception
            goto L_0x003a
        L_0x0036:
            r3 = move-exception
            goto L_0x0045
        L_0x0038:
            r3 = move-exception
            r0 = r1
        L_0x003a:
            r3.printStackTrace()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x0042:
            return r1
        L_0x0043:
            r3 = move-exception
            r1 = r0
        L_0x0045:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.FileSystemManagerSubJSBridge.fileEncoder(java.lang.String, java.lang.String):java.lang.String");
    }

    public void writeFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            if (!jSONObject.has("data") || !jSONObject.has(FlutterShareMethod.filePathKey)) {
                CallBackUtil.onFail("参数错误", callbackFunction);
            } else if (writeFileSync(jSONObject)) {
                CallBackUtil.onSuccess(callbackFunction);
            } else {
                CallBackUtil.onFail("文件写入失败", callbackFunction);
            }
        } catch (Exception e) {
            CallBackUtil.onFail(e.getMessage(), callbackFunction);
        }
    }

    public boolean writeFileSync(JSONObject jSONObject) {
        byte[] bArr;
        String optString = jSONObject.optString("data", "");
        String optString2 = jSONObject.optString(FlutterShareMethod.filePathKey, "");
        String optString3 = jSONObject.optString("encoding", "utf-8");
        String url2filepathWithoutDifile = this.f16569b.url2filepathWithoutDifile(optString2);
        if ("base64".equals(optString3)) {
            bArr = Base64.decode(optString, 2);
        } else {
            bArr = optString.getBytes();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url2filepathWithoutDifile);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
