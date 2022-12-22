package com.didi.entrega.info.helper;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/info/helper/InfoStepConfig;", "Ljava/io/Serializable;", "()V", "currentStep", "", "getCurrentStep", "()I", "setCurrentStep", "(I)V", "viewType", "getViewType", "setViewType", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoStepConfig.kt */
public final class InfoStepConfig implements Serializable {
    /* access modifiers changed from: private */
    public static final InfoStepConfig CREATE_PACKAGE_INFO;
    /* access modifiers changed from: private */
    public static final InfoStepConfig CREATE_RECEIVE_ADDRESS;
    /* access modifiers changed from: private */
    public static final InfoStepConfig CREATE_SENDER_ADDRESS;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final InfoStepConfig UPDATE;
    private int currentStep = 1;
    private int viewType = 1;

    public final int getCurrentStep() {
        return this.currentStep;
    }

    public final void setCurrentStep(int i) {
        this.currentStep = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void setViewType(int i) {
        this.viewType = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/info/helper/InfoStepConfig$Companion;", "", "()V", "CREATE_PACKAGE_INFO", "Lcom/didi/entrega/info/helper/InfoStepConfig;", "getCREATE_PACKAGE_INFO", "()Lcom/didi/entrega/info/helper/InfoStepConfig;", "CREATE_RECEIVE_ADDRESS", "getCREATE_RECEIVE_ADDRESS", "CREATE_SENDER_ADDRESS", "getCREATE_SENDER_ADDRESS", "UPDATE", "getUPDATE", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoStepConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InfoStepConfig getUPDATE() {
            return InfoStepConfig.UPDATE;
        }

        public final InfoStepConfig getCREATE_SENDER_ADDRESS() {
            return InfoStepConfig.CREATE_SENDER_ADDRESS;
        }

        public final InfoStepConfig getCREATE_RECEIVE_ADDRESS() {
            return InfoStepConfig.CREATE_RECEIVE_ADDRESS;
        }

        public final InfoStepConfig getCREATE_PACKAGE_INFO() {
            return InfoStepConfig.CREATE_PACKAGE_INFO;
        }
    }

    static {
        InfoStepConfig infoStepConfig = new InfoStepConfig();
        infoStepConfig.setViewType(2);
        UPDATE = infoStepConfig;
        InfoStepConfig infoStepConfig2 = new InfoStepConfig();
        infoStepConfig2.setViewType(1);
        infoStepConfig2.setCurrentStep(1);
        CREATE_SENDER_ADDRESS = infoStepConfig2;
        InfoStepConfig infoStepConfig3 = new InfoStepConfig();
        infoStepConfig3.setViewType(1);
        infoStepConfig3.setCurrentStep(2);
        CREATE_RECEIVE_ADDRESS = infoStepConfig3;
        InfoStepConfig infoStepConfig4 = new InfoStepConfig();
        infoStepConfig4.setViewType(1);
        infoStepConfig4.setCurrentStep(3);
        CREATE_PACKAGE_INFO = infoStepConfig4;
    }
}
