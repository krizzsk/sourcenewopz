package com.didi.dimina.container.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.service.ImageLoaderService;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.ImageUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.customer.app.constant.Const;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ImageSubJSBridge {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f16575a;

    /* renamed from: b */
    private final DMConfig f16576b;

    /* renamed from: c */
    private final DMMina f16577c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final DMSandboxHelper f16578d;

    public ImageSubJSBridge(Context context, DMMina dMMina) {
        LogUtil.m13411i("ImageSubJSBridge init");
        this.f16575a = context;
        this.f16577c = dMMina;
        DMConfig config = dMMina.getConfig();
        this.f16576b = config;
        this.f16578d = new DMSandboxHelper(config);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54441a(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        LogUtil.m13411i("ImageSubJSBridge getImageInfo: " + jSONObject);
        if (jSONObject.has(Const.BlockParamConst.SRC)) {
            final String optString = jSONObject.optString(Const.BlockParamConst.SRC);
            if (TextUtils.isEmpty(optString)) {
                CallBackUtil.onFail("", callbackFunction);
            } else if (optString.startsWith(DMSandboxHelper.VIRTUAL_DOMAIN_URL)) {
                String url2filepath = this.f16578d.url2filepath(optString);
                if (FileUtil.exists(1, url2filepath)) {
                    int[] a = m12193a(new File(url2filepath));
                    int i = a[1];
                    int i2 = a[0];
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtil.put(jSONObject2, "width", i);
                    JSONUtil.put(jSONObject2, "height", i2);
                    JSONUtil.put(jSONObject2, "path", (Object) optString);
                    CallBackUtil.onSuccess(jSONObject2, callbackFunction);
                    return;
                }
                CallBackUtil.onFail("file is not exist", callbackFunction);
            } else if (optString.startsWith("http://") || optString.startsWith("https://")) {
                final String a2 = m12191a(optString);
                if (TextUtils.isEmpty(a2)) {
                    CallBackUtil.onFail("destPath is not exist", callbackFunction);
                    return;
                }
                if (FileUtil.exists(1, a2)) {
                    int[] a3 = m12193a(new File(a2));
                    int i3 = a3[1];
                    int i4 = a3[0];
                    String filepath2url = this.f16578d.filepath2url(a2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONUtil.put(jSONObject3, "width", i3);
                    JSONUtil.put(jSONObject3, "height", i4);
                    JSONUtil.put(jSONObject3, "path", (Object) filepath2url);
                    CallBackUtil.onSuccess(jSONObject3, callbackFunction);
                    return;
                }
                UIHandlerUtil.getHandler().post(new Runnable() {
                    public void run() {
                        Dimina.getConfig().getAdapterConfig().getImageLoaderService().download(ImageSubJSBridge.this.f16575a, optString, new ImageLoaderService.FinishFileListener() {
                            public void onFileFinish(File file) {
                                if (file != null && FileUtil.copyFile(file.getAbsolutePath(), a2)) {
                                    File file2 = new File(a2);
                                    if (file2.exists() && file2.isFile()) {
                                        int[] a = ImageSubJSBridge.this.m12193a(file2);
                                        int i = a[1];
                                        int i2 = a[0];
                                        String filepath2url = ImageSubJSBridge.this.f16578d.filepath2url(a2);
                                        JSONObject jSONObject = new JSONObject();
                                        JSONUtil.put(jSONObject, "width", i);
                                        JSONUtil.put(jSONObject, "height", i2);
                                        JSONUtil.put(jSONObject, "path", (Object) filepath2url);
                                        CallBackUtil.onSuccess(jSONObject, callbackFunction);
                                        return;
                                    }
                                }
                                CallBackUtil.onFail("", callbackFunction);
                            }
                        });
                    }
                });
            } else if (optString.startsWith("data:") && optString.indexOf(Const.ImageUpload.STR_PREFIX) > 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                try {
                    byte[] decode = Base64.decode(optString.substring(optString.indexOf(44) + 1), 0);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                    if (decodeByteArray == null) {
                        CallBackUtil.onFail("base64 stream parse error!", callbackFunction);
                        return;
                    }
                    String sandboxTmpDir = this.f16578d.getSandboxTmpDir();
                    File file = new File(sandboxTmpDir, System.currentTimeMillis() + ".img");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        JSONObject jSONObject4 = new JSONObject();
                        JSONUtil.put(jSONObject4, "width", decodeByteArray.getWidth());
                        JSONUtil.put(jSONObject4, "height", decodeByteArray.getHeight());
                        JSONUtil.put(jSONObject4, "path", (Object) this.f16578d.filepath2url(file.getPath()));
                        CallBackUtil.onSuccess(jSONObject4, callbackFunction);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IllegalArgumentException unused) {
                    CallBackUtil.onFail("base64 stream parse error!", callbackFunction);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m12191a(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = "\\."
            java.lang.String r2 = ""
            r3 = 1
            if (r0 != 0) goto L_0x002d
            java.lang.String r0 = "http"
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L_0x002d
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0028 }
            r0.<init>(r6)     // Catch:{ MalformedURLException -> 0x0028 }
            java.lang.String r0 = r0.getPath()     // Catch:{ MalformedURLException -> 0x0028 }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ MalformedURLException -> 0x0028 }
            int r1 = r0.length     // Catch:{ MalformedURLException -> 0x0028 }
            if (r1 <= r3) goto L_0x0039
            int r1 = r0.length     // Catch:{ MalformedURLException -> 0x0028 }
            int r1 = r1 - r3
            r0 = r0[r1]     // Catch:{ MalformedURLException -> 0x0028 }
            goto L_0x003a
        L_0x0028:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0039
        L_0x002d:
            java.lang.String[] r0 = r6.split(r1)     // Catch:{ Exception -> 0x0039 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0039 }
            if (r1 <= r3) goto L_0x0039
            int r1 = r0.length     // Catch:{ Exception -> 0x0039 }
            int r1 = r1 - r3
            r0 = r0[r1]     // Catch:{ Exception -> 0x0039 }
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            java.lang.String r6 = com.didi.dimina.container.util.MD5Util.md5(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r6 = "."
            r1.append(r6)
            r1.append(r0)
            java.lang.String r6 = r1.toString()
        L_0x0058:
            com.didi.dimina.container.mina.DMSandboxHelper r0 = r5.f16578d
            java.lang.String r0 = r0.getSandboxTmpDir()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0081
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0081
            r1 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            boolean r1 = com.didi.dimina.container.util.FileUtil.exists(r1, r3)
            if (r1 != 0) goto L_0x0077
            goto L_0x0081
        L_0x0077:
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r6)
            java.lang.String r6 = r1.getAbsolutePath()
            return r6
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.ImageSubJSBridge.m12191a(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int[] m12193a(File file) {
        int[] iArr = new int[2];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            iArr[0] = options.outHeight;
            iArr[1] = options.outWidth;
        } catch (Exception unused) {
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54442b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!jSONObject.has(FlutterShareMethod.filePathKey)) {
            CallBackUtil.onFail("params error", callbackFunction);
        } else if (!Environment.getExternalStorageState().equals("mounted")) {
            CallBackUtil.onFail("env error", callbackFunction);
        } else {
            String url2filepath = this.f16578d.url2filepath(jSONObject.optString(FlutterShareMethod.filePathKey));
            File absoluteFile = this.f16575a.getExternalCacheDir().getAbsoluteFile();
            if (!absoluteFile.exists()) {
                absoluteFile.mkdir();
            }
            String str = System.currentTimeMillis() + ".jpg";
            File file = new File(absoluteFile, str);
            FileUtil.copyFile(url2filepath, new File(absoluteFile, str).getAbsolutePath());
            MediaScannerConnection.scanFile(this.f16575a, new String[]{file.toString()}, new String[]{file.getName()}, (MediaScannerConnection.OnScanCompletedListener) null);
            CallBackUtil.onSuccess(callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54443c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("ImageSubJSBridge compressImage: " + jSONObject);
        String optString = jSONObject.optString(Const.BlockParamConst.SRC);
        int optInt = jSONObject.optInt(CollectionConstant.APOLLO_PARAM_QUALITY, 80);
        if (TextUtils.isEmpty(optString)) {
            if (callbackFunction != null) {
                CallBackUtil.onFail("src is empty!", callbackFunction);
            }
        } else if (optString.startsWith(DMSandboxHelper.VIRTUAL_DOMAIN_URL)) {
            String str = this.f16578d.getSandboxTmpDir() + File.separator + System.currentTimeMillis() + ".jpg";
            FileUtil.stream2file(new ByteArrayInputStream(ImageUtil.compressByQuality(ImageUtil.getBitmap(this.f16578d.url2filepath(optString)), optInt)), str);
            HashMap hashMap = new HashMap();
            hashMap.put("tempFilePath", this.f16578d.filepath2url(str));
            if (callbackFunction != null) {
                CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
            }
        }
    }
}
