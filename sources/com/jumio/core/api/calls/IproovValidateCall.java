package com.jumio.core.api.calls;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.IproovValidateModel;
import com.jumio.core.network.C20000d;
import jumio.core.C21351f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0014R\u0016\u0010\t\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/core/api/calls/IproovValidateCall;", "Lcom/jumio/core/network/d;", "Lcom/jumio/core/models/IproovValidateModel;", "", "plainTextAnswer", "parseResponse", "getRequest", "getUri", "()Ljava/lang/String;", "uri", "Ljumio/core/f;", "apiCallSettings", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "<init>", "(Ljumio/core/f;Lcom/jumio/core/models/ApiCallDataModel;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: IproovValidateCall.kt */
public final class IproovValidateCall extends C20000d<IproovValidateModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IproovValidateCall(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public String getRequest() throws Exception {
        if (getApiCallSettings().getDataManager().has(IproovTokenModel.class)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", ((IproovTokenModel) getApiCallSettings().getDataManager().get(IproovTokenModel.class)).getToken());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "request.toString()");
            return jSONObject2;
        }
        throw new IllegalStateException("iproovTokenModel not available!".toString());
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{-9, 107, 49, 115, 56, -102, 106, 58, 60, 73, -119, 118, 2, -52, -23}, -115293174980108824L);
    }

    public IproovValidateModel parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        if (str.length() == 0) {
            return null;
        }
        try {
            IproovValidateModel fromString = IproovValidateModel.Companion.fromString(str);
            getApiCallSettings().getDataManager().put(IproovValidateModel.class, fromString);
            return fromString;
        } catch (Exception e) {
            Log.m39477w(this.TAG, "Exception", (Throwable) e);
            return null;
        }
    }
}
