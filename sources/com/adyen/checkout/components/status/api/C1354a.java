package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adyen.checkout.components.status.api.a */
/* compiled from: StatusConnection */
class C1354a extends Connection<StatusResponse> {

    /* renamed from: a */
    private static final String f888a = LogUtil.getTag();

    /* renamed from: b */
    private final StatusRequest f889b;

    C1354a(String str, StatusRequest statusRequest) {
        super(str);
        this.f889b = statusRequest;
    }

    /* renamed from: a */
    public StatusResponse call() throws IOException, JSONException {
        String str = f888a;
        Logger.m1082v(str, "call - " + getUrl());
        return StatusResponse.SERIALIZER.deserialize(new JSONObject(new String(post(CONTENT_TYPE_JSON_HEADER, StatusRequest.SERIALIZER.serialize(this.f889b).toString().getBytes(Charset.defaultCharset())), Charset.defaultCharset())));
    }
}
