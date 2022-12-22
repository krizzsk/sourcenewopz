package com.jumio.core.network;

import com.jumio.commons.log.LogUtils;
import com.jumio.core.models.ApiCallDataModel;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import jumio.core.C21351f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.jumio.core.network.d */
/* compiled from: SimpleApiCall.kt */
public abstract class C20000d<T> extends ApiCall<T> {

    /* renamed from: d */
    public String f54916d = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C20000d(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public void fillRequest(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        String str = this.f54916d;
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public String getBoundary() {
        return null;
    }

    public abstract String getRequest() throws Exception;

    public int prepareRequest() throws Exception {
        this.f54916d = getRequest();
        LogUtils.logServerRequest(getClass().getSimpleName(), this.f54916d);
        String str = this.f54916d;
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes.length;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
