package com.didichuxing.dfbasesdk.interceptor;

import android.net.Uri;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import java.io.IOException;
import java.util.Map;

public class JsonParse extends AbsContentTypeParse {
    public HttpRpcRequest sign(HttpRpcRequest httpRpcRequest) throws IOException {
        String readFullyNoClose = readFullyNoClose(httpRpcRequest.getEntity().getContent());
        Uri.Builder buildUpon = Uri.parse(httpRpcRequest.getUrl()).buildUpon();
        for (Map.Entry next : getQueryParam(readFullyNoClose).entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), String.valueOf(next.getValue()));
        }
        return httpRpcRequest.newBuilder().setUrl(buildUpon.build().toString()).build();
    }
}
