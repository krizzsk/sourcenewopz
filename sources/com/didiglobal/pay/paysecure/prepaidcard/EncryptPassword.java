package com.didiglobal.pay.paysecure.prepaidcard;

import com.didiglobal.pay.paysecure.util.CipherUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "", "()V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "encryptKey", "getEncryptKey", "setEncryptKey", "encryptedPwdString", "getEncryptedPwdString", "setEncryptedPwdString", "iv", "getIv", "setIv", "publicKey", "prepareEncrypt", "", "pwd", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: EncryptPassword.kt */
public final class EncryptPassword {

    /* renamed from: a */
    private String f50379a;

    /* renamed from: b */
    private String f50380b;

    /* renamed from: c */
    private String f50381c;

    /* renamed from: d */
    private String f50382d;

    /* renamed from: e */
    private final String f50383e = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC4hfVVnxS7jU8nop/u4uO+RlQu4QhBgs9VnAwIIk3lsmLkrdOO1tfCkm+JCTbkifjxGevVND69CuunKj0woTIveXfe/C/d1AUzdYDIgUDUeW5g/tOneSyMk/j4eYCn+1IxftO8IL3y/IdjVeGWZS7jdydwZz422ed8YWNZ2EEcwIDAQAB";

    public final String getAesKey() {
        return this.f50379a;
    }

    public final void setAesKey(String str) {
        this.f50379a = str;
    }

    public final String getIv() {
        return this.f50380b;
    }

    public final void setIv(String str) {
        this.f50380b = str;
    }

    public final String getEncryptedPwdString() {
        return this.f50381c;
    }

    public final void setEncryptedPwdString(String str) {
        this.f50381c = str;
    }

    public final String getEncryptKey() {
        return this.f50382d;
    }

    public final void setEncryptKey(String str) {
        this.f50382d = str;
    }

    public final void prepareEncrypt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pwd");
        this.f50379a = CipherUtil.INSTANCE.getAESKey();
        this.f50380b = CipherUtil.INSTANCE.getAESIv();
        CipherUtil cipherUtil = CipherUtil.INSTANCE;
        String str2 = this.f50379a;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        this.f50381c = cipherUtil.aesEncrypt(str, str2);
        CipherUtil cipherUtil2 = CipherUtil.INSTANCE;
        String str3 = this.f50379a;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        this.f50382d = cipherUtil2.encryptRSAToString(str3, this.f50383e);
    }
}
