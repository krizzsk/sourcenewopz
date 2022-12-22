package com.didi.component.common.router;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.xengine.request.XEBizParamsImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class XERequestRouter implements IRouterHandler {
    public static final String SCENE = "scene";

    /* renamed from: a */
    private static final String f11711a = "page";

    /* renamed from: b */
    private static final String f11712b = "simple";

    /* renamed from: c */
    private static final String f11713c = "type";

    /* renamed from: d */
    private static final String f11714d = "modules";

    public void handle(Request request, Result result) {
        JsonArray asJsonArray;
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("type");
        String string = request.getString("scene");
        if (TextUtils.isEmpty(string)) {
            string = uri.getQueryParameter("scene");
        }
        if (!TextUtils.isEmpty(queryParameter)) {
            if (queryParameter.equals("page")) {
                XEngineReq.pageRequest(string);
            } else if (queryParameter.equals("simple")) {
                String queryParameter2 = uri.getQueryParameter(f11714d);
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        queryParameter2 = URLDecoder.decode(queryParameter2, StandardCharsets.UTF_8.name());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(queryParameter2) && (asJsonArray = new JsonParser().parse(queryParameter2).getAsJsonArray()) != null && asJsonArray.size() != 0) {
                    int size = asJsonArray.size();
                    String[] strArr = new String[size];
                    for (int i = 0; i < size; i++) {
                        strArr[i] = asJsonArray.get(i).getAsString();
                    }
                    XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
                    xEBizParamsImpl.scene = string;
                    xEBizParamsImpl.requestKeys = strArr;
                    XEngineReq.simpleRequest(xEBizParamsImpl);
                }
            }
        }
    }
}
