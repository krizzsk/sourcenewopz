package com.didiglobal.pay.paysecure.base;

import com.didiglobal.pay.paysecure.net.pojo.response.PasswordSettings;
import com.didiglobal.pay.paysecure.net.pojo.response.UserVerificationParams;
import java.io.Serializable;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020\u0000J\b\u0010)\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\t¨\u0006+"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;", "Ljava/io/Serializable;", "", "()V", "amount", "", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "passwordSettings", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;", "getPasswordSettings", "()Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;", "setPasswordSettings", "(Lcom/didiglobal/pay/paysecure/net/pojo/response/PasswordSettings;)V", "paySessionId", "getPaySessionId", "setPaySessionId", "scene", "getScene", "setScene", "sceneType", "", "getSceneType", "()I", "setSceneType", "(I)V", "selectedCheckType", "getSelectedCheckType", "setSelectedCheckType", "userVerificationParams", "Lcom/didiglobal/pay/paysecure/net/pojo/response/UserVerificationParams;", "getUserVerificationParams", "()Lcom/didiglobal/pay/paysecure/net/pojo/response/UserVerificationParams;", "setUserVerificationParams", "(Lcom/didiglobal/pay/paysecure/net/pojo/response/UserVerificationParams;)V", "userVerificationParamsRaw", "getUserVerificationParamsRaw", "setUserVerificationParamsRaw", "cloneObj", "toString", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FragmentMessenger.kt */
public final class FragmentMessenger implements Serializable, Cloneable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Stack<String> scenesStack = new Stack<>();
    private String amount;
    private PasswordSettings passwordSettings;
    private String paySessionId;
    public String scene;
    private int sceneType;
    private String selectedCheckType;
    private UserVerificationParams userVerificationParams;
    private String userVerificationParamsRaw;

    public Object clone() {
        return super.clone();
    }

    public final String getScene() {
        String str = this.scene;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
        }
        return str;
    }

    public final void setScene(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.scene = str;
    }

    public final String getPaySessionId() {
        return this.paySessionId;
    }

    public final void setPaySessionId(String str) {
        this.paySessionId = str;
    }

    public final PasswordSettings getPasswordSettings() {
        return this.passwordSettings;
    }

    public final void setPasswordSettings(PasswordSettings passwordSettings2) {
        this.passwordSettings = passwordSettings2;
    }

    public final String getUserVerificationParamsRaw() {
        return this.userVerificationParamsRaw;
    }

    public final void setUserVerificationParamsRaw(String str) {
        this.userVerificationParamsRaw = str;
    }

    public final UserVerificationParams getUserVerificationParams() {
        return this.userVerificationParams;
    }

    public final void setUserVerificationParams(UserVerificationParams userVerificationParams2) {
        this.userVerificationParams = userVerificationParams2;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    public final void setSceneType(int i) {
        this.sceneType = i;
    }

    public final String getSelectedCheckType() {
        return this.selectedCheckType;
    }

    public final void setSelectedCheckType(String str) {
        this.selectedCheckType = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FragmentMessenger{, scene=");
        String str = this.scene;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public final FragmentMessenger cloneObj() {
        try {
            Object clone = super.clone();
            if (clone != null) {
                return (FragmentMessenger) clone;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.didiglobal.pay.paysecure.base.FragmentMessenger");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new FragmentMessenger();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/FragmentMessenger$Companion;", "", "()V", "scenesStack", "Ljava/util/Stack;", "", "getScenesStack", "()Ljava/util/Stack;", "setScenesStack", "(Ljava/util/Stack;)V", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: FragmentMessenger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Stack<String> getScenesStack() {
            return FragmentMessenger.scenesStack;
        }

        public final void setScenesStack(Stack<String> stack) {
            Intrinsics.checkParameterIsNotNull(stack, "<set-?>");
            FragmentMessenger.scenesStack = stack;
        }
    }
}
