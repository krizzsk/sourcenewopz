package com.jumio.core.models;

import android.os.Build;
import com.jumio.commons.log.Log;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.enums.JumioDataCenter;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0019\u001a\u00060\u0012R\u00020\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001b\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000e¨\u0006 "}, mo175978d2 = {"Lcom/jumio/core/models/AuthorizationModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/sdk/enums/JumioDataCenter;", "a", "Lcom/jumio/sdk/enums/JumioDataCenter;", "getDataCenter", "()Lcom/jumio/sdk/enums/JumioDataCenter;", "setDataCenter", "(Lcom/jumio/sdk/enums/JumioDataCenter;)V", "dataCenter", "", "b", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "token", "Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "c", "Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "getSessionKey", "()Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "setSessionKey", "(Lcom/jumio/core/models/AuthorizationModel$SessionKey;)V", "sessionKey", "getAuthorization", "authorization", "<init>", "()V", "Companion", "SessionKey", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: AuthorizationModel.kt */
public final class AuthorizationModel implements StaticModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public JumioDataCenter f54805a = JumioDataCenter.US;

    /* renamed from: b */
    public String f54806b = "";

    /* renamed from: c */
    public SessionKey f54807c = new SessionKey(this);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, mo175978d2 = {"Lcom/jumio/core/models/AuthorizationModel$Companion;", "", "", "AES_KEY_SIZE", "I", "GCM_IV_LENGTH", "GCM_TAG_LENGTH", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: AuthorizationModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0013\u0010\u000b\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0010\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, mo175978d2 = {"Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "Ljava/io/Serializable;", "", "generate", "clear", "", "o", "", "equals", "", "hashCode", "isValid", "()Z", "Ljavax/crypto/Cipher;", "getDecryptCipher", "()Ljavax/crypto/Cipher;", "decryptCipher", "getEncryptCipher", "encryptCipher", "<init>", "(Lcom/jumio/core/models/AuthorizationModel;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: AuthorizationModel.kt */
    public final class SessionKey implements Serializable {

        /* renamed from: a */
        public SecretKey f54808a;

        /* renamed from: b */
        public byte[] f54809b;

        /* renamed from: c */
        public final /* synthetic */ AuthorizationModel f54810c;

        public SessionKey(AuthorizationModel authorizationModel) {
            Intrinsics.checkNotNullParameter(authorizationModel, "this$0");
            this.f54810c = authorizationModel;
        }

        /* renamed from: a */
        public final AlgorithmParameterSpec mo162823a() {
            if (Build.VERSION.SDK_INT < 21) {
                return new IvParameterSpec(this.f54810c.getSessionKey().f54809b);
            }
            return new GCMParameterSpec(128, this.f54810c.getSessionKey().f54809b);
        }

        public final void clear() {
            this.f54808a = null;
            byte[] bArr = this.f54809b;
            if (bArr != null) {
                ArraysKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
            }
            this.f54809b = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (Intrinsics.areEqual((Object) SessionKey.class, (Object) obj.getClass())) {
                    SessionKey sessionKey = (SessionKey) obj;
                    if (!Objects.equals(this.f54808a, sessionKey.f54808a) || !Arrays.equals(this.f54809b, sessionKey.f54809b)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public final void generate() {
            try {
                KeyGenerator instance = KeyGenerator.getInstance("AES");
                instance.init(256);
                this.f54808a = instance.generateKey();
                byte[] bArr = new byte[12];
                new SecureRandom().nextBytes(bArr);
                this.f54809b = bArr;
            } catch (NoSuchAlgorithmException e) {
                Log.printStackTrace(e);
            }
        }

        public final Cipher getDecryptCipher() {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKey secretKey = this.f54810c.getSessionKey().f54808a;
            instance.init(2, new SecretKeySpec(secretKey == null ? null : secretKey.getEncoded(), "AES"), mo162823a());
            Intrinsics.checkNotNullExpressionValue(instance, "cipher");
            return instance;
        }

        public final Cipher getEncryptCipher() {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKey secretKey = this.f54810c.getSessionKey().f54808a;
            instance.init(1, new SecretKeySpec(secretKey == null ? null : secretKey.getEncoded(), "AES"), mo162823a());
            Intrinsics.checkNotNullExpressionValue(instance, "cipher");
            return instance;
        }

        public int hashCode() {
            SecretKey secretKey = this.f54808a;
            return Arrays.hashCode(secretKey == null ? null : secretKey.getEncoded()) + Arrays.hashCode(this.f54809b);
        }

        public final boolean isValid() {
            return (this.f54808a == null || this.f54809b == null) ? false : true;
        }
    }

    public final String getAuthorization() {
        return Intrinsics.stringPlus("Bearer ", this.f54806b);
    }

    public final JumioDataCenter getDataCenter() {
        return this.f54805a;
    }

    public final SessionKey getSessionKey() {
        return this.f54807c;
    }

    public final String getToken() {
        return this.f54806b;
    }

    public final void setDataCenter(JumioDataCenter jumioDataCenter) {
        Intrinsics.checkNotNullParameter(jumioDataCenter, "<set-?>");
        this.f54805a = jumioDataCenter;
    }

    public final void setSessionKey(SessionKey sessionKey) {
        Intrinsics.checkNotNullParameter(sessionKey, "<set-?>");
        this.f54807c = sessionKey;
    }

    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f54806b = str;
    }
}
