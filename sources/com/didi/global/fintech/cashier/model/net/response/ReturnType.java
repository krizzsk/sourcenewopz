package com.didi.global.fintech.cashier.model.net.response;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/ReturnType;", "", "Ljava/io/Serializable;", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "REDIRECT_SCHEMA", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuccessInfoResponse.kt */
public enum ReturnType implements Serializable {
    REDIRECT_SCHEMA("redirect_schema");
    
    private final String type;

    private ReturnType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
