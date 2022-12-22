package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/GateKeeperResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/BaseData;", "()V", "isSet", "", "()I", "setSet", "(I)V", "passwordSettings", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;", "getPasswordSettings", "()Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;", "setPasswordSettings", "(Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;)V", "userVerificationParamsRaw", "Lcom/google/gson/JsonObject;", "getUserVerificationParamsRaw", "()Lcom/google/gson/JsonObject;", "setUserVerificationParamsRaw", "(Lcom/google/gson/JsonObject;)V", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GateKeeperResponse.kt */
public final class GateKeeperResponse extends BaseData {
    @SerializedName("is_set")
    private int isSet;
    @SerializedName("password_settings")
    private PasswordSettings passwordSettings;
    @SerializedName("user_verification_params")
    private JsonObject userVerificationParamsRaw;

    public final int isSet() {
        return this.isSet;
    }

    public final void setSet(int i) {
        this.isSet = i;
    }

    public final JsonObject getUserVerificationParamsRaw() {
        return this.userVerificationParamsRaw;
    }

    public final void setUserVerificationParamsRaw(JsonObject jsonObject) {
        this.userVerificationParamsRaw = jsonObject;
    }

    public final PasswordSettings getPasswordSettings() {
        return this.passwordSettings;
    }

    public final void setPasswordSettings(PasswordSettings passwordSettings2) {
        this.passwordSettings = passwordSettings2;
    }
}
