package com.didichuxing.dfbasesdk.interceptor;

import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class AbsContentTypeParse {
    public abstract HttpRpcRequest sign(HttpRpcRequest httpRpcRequest) throws IOException;

    /* access modifiers changed from: protected */
    public Map<String, Object> getQueryParam(String str) {
        return HttpParamUtils.getQueryParam(str);
    }

    public static String readFullyNoClose(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
