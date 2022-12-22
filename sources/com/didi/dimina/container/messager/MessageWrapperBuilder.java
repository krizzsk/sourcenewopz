package com.didi.dimina.container.messager;

import com.didi.dimina.container.util.JSONUtil;
import org.json.JSONObject;

public class MessageWrapperBuilder {
    public static final String ARG_DATA = "data";
    public static final String ARG_STACK_ID = "stackId";
    public static final String ARG_WEB_VIEW_ID = "webViewId";

    /* renamed from: a */
    private Object f16871a = null;

    /* renamed from: b */
    private int f16872b = 0;

    /* renamed from: c */
    private int f16873c = 0;

    public MessageWrapperBuilder data(Object obj) {
        this.f16871a = obj;
        return this;
    }

    public MessageWrapperBuilder stackId(int i) {
        this.f16873c = i;
        return this;
    }

    public MessageWrapperBuilder webViewId(int i) {
        this.f16872b = i;
        return this;
    }

    public JSONObject build() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "data", this.f16871a);
        JSONUtil.put(jSONObject, ARG_STACK_ID, this.f16873c);
        JSONUtil.put(jSONObject, ARG_WEB_VIEW_ID, this.f16872b);
        return jSONObject;
    }
}
