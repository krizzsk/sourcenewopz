package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.a */
/* compiled from: FileSubJSBridge */
class C7430a {

    /* renamed from: a */
    private final DMConfig f16680a;

    /* renamed from: b */
    private final DMSandboxHelper f16681b;

    /* renamed from: c */
    private final long f16682c = 209715200;

    public C7430a(DMConfig dMConfig) {
        LogUtil.m13411i("FileSubJSBridge init");
        this.f16680a = dMConfig;
        this.f16681b = new DMSandboxHelper(dMConfig);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54563a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("FileSubJSBridge saveFile: " + jSONObject);
        if (jSONObject.has("tempFilePath")) {
            String url2filepath = this.f16681b.url2filepath(jSONObject.optString("tempFilePath", ""));
            if (FileUtil.exists(1, url2filepath)) {
                String str = this.f16681b.getSandboxStoreDir() + "/" + this.f16681b.extractFilename(url2filepath);
                if (FileUtil.getFileSize(url2filepath) + FileUtil.getFolderSize(this.f16681b.getSandboxStoreDir()) > 209715200) {
                    CallBackUtil.onFail("文件存储空间不足", callbackFunction);
                } else if (FileUtil.m13394mv(url2filepath, str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtil.put(jSONObject2, "savedFilePath", (Object) this.f16681b.filepath2url(str));
                    CallBackUtil.onSuccess(jSONObject2, callbackFunction);
                } else {
                    CallBackUtil.onFail("文件存储失败", callbackFunction);
                }
            } else {
                CallBackUtil.onFail("需存储的文件不存在", callbackFunction);
            }
        } else {
            CallBackUtil.onFail("tempFilePath为空", callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54564b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("FileSubJSBridge removeSavedFile: " + jSONObject);
        if (jSONObject.has(FlutterShareMethod.filePathKey)) {
            String url2filepath = this.f16681b.url2filepath(jSONObject.optString(FlutterShareMethod.filePathKey, ""));
            if (!FileUtil.exists(1, url2filepath)) {
                CallBackUtil.onFail("需删除的文件不存在", callbackFunction);
            } else if (FileUtil.delete(url2filepath)) {
                CallBackUtil.onSuccess(callbackFunction);
            } else {
                CallBackUtil.onFail("文件删除失败", callbackFunction);
            }
        } else {
            CallBackUtil.onFail("filePath为空", callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54565c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        boolean z;
        File[] listFiles;
        LogUtil.m13411i("FileSubJSBridge getSavedFileList: " + jSONObject);
        JSONArray jSONArray = new JSONArray();
        File file = new File(this.f16681b.getSandboxStoreDir());
        LinkedList linkedList = new LinkedList();
        linkedList.add(file);
        while (!linkedList.isEmpty()) {
            try {
                File file2 = (File) linkedList.removeFirst();
                if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                    for (File file3 : listFiles) {
                        if (file3.isFile()) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONUtil.put(jSONObject2, FlutterShareMethod.filePathKey, (Object) this.f16681b.filepath2url(file3.getAbsolutePath()));
                            JSONUtil.put(jSONObject2, "size", file3.length());
                            JSONUtil.put(jSONObject2, "createTime", file3.lastModified());
                            jSONArray.put(jSONObject2);
                        } else if (file3.isDirectory()) {
                            linkedList.addLast(file3);
                        }
                    }
                }
            } catch (Exception unused) {
                z = false;
            }
        }
        z = true;
        if (z) {
            JSONObject jSONObject3 = new JSONObject();
            JSONUtil.put(jSONObject3, "success", true);
            JSONUtil.put(jSONObject3, "fileList", (Object) jSONArray);
            callbackFunction.onCallBack(jSONObject3);
            return;
        }
        CallBackUtil.onFail("", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo54566d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("FileSubJSBridge getSavedFileInfo: " + jSONObject);
        if (jSONObject.has(FlutterShareMethod.filePathKey)) {
            String url2filepath = this.f16681b.url2filepath(jSONObject.optString(FlutterShareMethod.filePathKey, ""));
            if (FileUtil.exists(1, url2filepath)) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "success", true);
                JSONObject jSONObject3 = new JSONObject();
                JSONUtil.put(jSONObject3, "size", new File(url2filepath).length());
                JSONUtil.put(jSONObject3, "createTime", new File(url2filepath).lastModified());
                JSONUtil.put(jSONObject2, "data", (Object) jSONObject3);
                callbackFunction.onCallBack(jSONObject2);
                return;
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONUtil.put(jSONObject4, "success", false);
            JSONUtil.put(jSONObject4, Constants.ERROR_CODE, -1001);
            JSONUtil.put(jSONObject4, ParamConst.PARAM_ERROR_MESSAGE, (Object) "文件不存在");
            JSONUtil.put(jSONObject4, FlutterShareMethod.filePathKey, (Object) url2filepath);
            callbackFunction.onCallBack(jSONObject4);
            return;
        }
        CallBackUtil.onFail("filePath为空", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo54567e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("FileSubJSBridge getFileInfo: " + jSONObject);
        if (jSONObject.has(FlutterShareMethod.filePathKey)) {
            String optString = jSONObject.optString(FlutterShareMethod.filePathKey, "");
            String optString2 = jSONObject.optString("digestAlgorithm", "md5");
            String url2filepath = this.f16681b.url2filepath(optString);
            if (FileUtil.exists(1, url2filepath)) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "size", new File(url2filepath).length());
                if (TextUtils.equals(optString2, "md5")) {
                    JSONUtil.put(jSONObject2, "digest", (Object) FileUtil.md5(url2filepath));
                } else if (TextUtils.equals(optString2, "sha1")) {
                    JSONUtil.put(jSONObject2, "digest", (Object) FileUtil.sha1(url2filepath));
                }
                CallBackUtil.onSuccess(jSONObject2, callbackFunction);
                return;
            }
            CallBackUtil.onFail("文件不存在", callbackFunction);
            return;
        }
        CallBackUtil.onFail("filePath为空", callbackFunction);
    }
}
