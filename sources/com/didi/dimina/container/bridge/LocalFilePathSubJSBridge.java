package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.util.CallBackUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LocalFilePathSubJSBridge {

    /* renamed from: a */
    private final String f16608a = "package";

    /* renamed from: b */
    private final String f16609b = "path";

    /* renamed from: c */
    private final DMMina f16610c;

    public LocalFilePathSubJSBridge(DMMina dMMina) {
        this.f16610c = dMMina;
    }

    public void getFilePath(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("path");
        String optString2 = jSONObject.optString("package");
        if (TextUtils.isEmpty(optString2)) {
            CallBackUtil.onFail("packageName is null", callbackFunction);
        } else if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("path is null", callbackFunction);
        } else {
            if (!optString.startsWith(File.separator)) {
                optString = File.separator + optString;
            }
            String transform2AbsolutePath = BundleManager.getInstance().transform2AbsolutePath(this.f16610c, optString2, optString);
            if (transform2AbsolutePath.startsWith("http")) {
                HashMap hashMap = new HashMap();
                hashMap.put("path", transform2AbsolutePath);
                CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
                return;
            }
            File file = new File(transform2AbsolutePath);
            if (!file.exists()) {
                CallBackUtil.onFail("file not exist", callbackFunction);
                return;
            }
            String str = "file://" + transform2AbsolutePath;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("fileType", file.isDirectory() ? "directory" : "file");
            hashMap2.put("path", str);
            CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap2, callbackFunction);
        }
    }
}
