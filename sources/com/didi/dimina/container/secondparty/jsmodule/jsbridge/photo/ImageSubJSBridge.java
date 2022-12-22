package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.entrega.customer.app.constant.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class ImageSubJSBridge {
    public static final String TAG = "ImageSubJSBridge";

    /* renamed from: a */
    private final Context f17210a;

    /* renamed from: b */
    private final DMConfig f17211b;

    /* renamed from: c */
    private final DMMina f17212c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final DMSandboxHelper f17213d;

    public ImageSubJSBridge(Context context, DMMina dMMina) {
        LogUtil.m13411i("ImageSubJSBridge init");
        this.f17210a = context;
        this.f17212c = dMMina;
        DMConfig config = dMMina.getConfig();
        this.f17211b = config;
        this.f17213d = new DMSandboxHelper(config);
    }

    public static class DiminaChooseImageReq extends ChooseImageReq {
        public DiminaChooseImageReq(DMMina dMMina, Activity activity) {
            super(dMMina, activity);
        }

        public static ChooseImageReq diminaFrom(DMMina dMMina, JSONObject jSONObject, Activity activity) {
            ChooseImageReq chooseImageReq = new ChooseImageReq(dMMina, activity);
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            if (optJSONArray.length() == 2) {
                chooseImageReq.sourceType = "all";
            } else if (optJSONArray.length() == 1) {
                chooseImageReq.sourceType = optJSONArray.optString(0);
            } else {
                chooseImageReq.sourceType = "SOURCE_TYPE_CAMERA";
            }
            chooseImageReq.maxSize = jSONObject.optInt(SDKConstants.PARAM_CONTEXT_MAX_SIZE, 500);
            chooseImageReq.count = jSONObject.optInt(Const.PageParams.COUNT, 1);
            chooseImageReq.count = Math.max(1, Math.min(chooseImageReq.count, 9));
            chooseImageReq.captureType = jSONObject.optInt("captureType", 0);
            return chooseImageReq;
        }
    }

    public void chooseImage(JSONObject jSONObject, final CallbackFunction callbackFunction, Activity activity) {
        PhotoService.chooseImage(DiminaChooseImageReq.diminaFrom(this.f17212c, jSONObject, activity), new SingleCallback<ChooseImageResp>() {
            public void onCallback(ChooseImageResp chooseImageResp) {
                int i = chooseImageResp.code;
                String[] strArr = new String[0];
                if (!(chooseImageResp.data == null || chooseImageResp.data.tempFilePaths == null || chooseImageResp.data.tempFilePaths.length <= 0)) {
                    String[] strArr2 = chooseImageResp.data.tempFilePaths;
                    strArr = new String[strArr2.length];
                    for (int i2 = 0; i2 < strArr2.length; i2++) {
                        String str = strArr2[i2];
                        if (ImageSubJSBridge.this.m12776a(str)) {
                            String replace = str.replace(ChooseImageResp.IMAGE_PATH_PREFIX, "");
                            String b = ImageSubJSBridge.this.m12779b(replace);
                            if (FileUtil.copyFile(replace, b)) {
                                strArr[i2] = b;
                            } else {
                                i = 1003;
                            }
                        }
                    }
                }
                ChooseImageResp buildOne = ChooseImageResp.buildOne(i, strArr);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (buildOne.code == 1000) {
                        jSONObject.put("success", true);
                        jSONObject.put(DMWebSocketListener.KEY_ERR_MSG, "");
                        if (strArr.length > 0) {
                            JSONArray jSONArray = new JSONArray();
                            JSONArray jSONArray2 = new JSONArray();
                            for (String str2 : strArr) {
                                if (!TextUtils.isEmpty(str2)) {
                                    jSONArray.put(ImageSubJSBridge.this.f17213d.filepath2url(str2));
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("path", ImageSubJSBridge.this.f17213d.filepath2url(str2));
                                    jSONObject2.put("size", ImageSubJSBridge.this.f17213d.getFileSize(str2));
                                    jSONArray2.put(jSONObject2);
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("tempFilePaths", jSONArray);
                            jSONObject3.put("tempFiles", jSONArray2);
                            jSONObject.put("data", jSONObject3);
                        } else {
                            jSONObject.put("data", new JSONObject());
                        }
                    } else {
                        jSONObject.put("success", false);
                        jSONObject.put(DMWebSocketListener.KEY_ERR_MSG, buildOne.msg);
                        jSONObject.put("data", new JSONObject());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LogUtil.m13411i("chooseImage resp===" + jSONObject);
                CallbackFunction callbackFunction = callbackFunction;
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(jSONObject);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12776a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(ChooseImageResp.IMAGE_PATH_PREFIX) && str.endsWith(".jpg");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m12779b(java.lang.String r6) {
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
            java.lang.String r6 = com.didi.dimina.webview.util.MD5Util.md5(r6)
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
            com.didi.dimina.container.mina.DMSandboxHelper r0 = r5.f17213d
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.ImageSubJSBridge.m12779b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private int[] m12777a(File file) {
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
}
