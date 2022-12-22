package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;", "Ljava/io/Serializable;", "()V", "forbiddenRegular", "", "", "getForbiddenRegular", "()[Ljava/lang/String;", "setForbiddenRegular", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "keyId", "getKeyId", "()Ljava/lang/String;", "setKeyId", "(Ljava/lang/String;)V", "keyboardType", "getKeyboardType", "setKeyboardType", "length", "", "getLength", "()I", "setLength", "(I)V", "publicKey", "getPublicKey", "setPublicKey", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GateKeeperResponse.kt */
public final class PasswordSettings implements Serializable {
    @SerializedName("forbidden_regular")
    private String[] forbiddenRegular;
    @SerializedName("key_id")
    private String keyId;
    @SerializedName("keyboard_type")
    private String[] keyboardType;
    @SerializedName("length")
    private int length;
    @SerializedName("public_key")
    private String publicKey;

    public final String[] getKeyboardType() {
        return this.keyboardType;
    }

    public final void setKeyboardType(String[] strArr) {
        this.keyboardType = strArr;
    }

    public final int getLength() {
        return this.length;
    }

    public final void setLength(int i) {
        this.length = i;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final void setPublicKey(String str) {
        this.publicKey = str;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final void setKeyId(String str) {
        this.keyId = str;
    }

    public final String[] getForbiddenRegular() {
        return this.forbiddenRegular;
    }

    public final void setForbiddenRegular(String[] strArr) {
        this.forbiddenRegular = strArr;
    }
}
