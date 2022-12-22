package com.didi.entrega.info.model;

import com.didi.entrega.info.helper.InfoStepConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/info/model/InfoHeaderModel;", "Lcom/didi/entrega/info/model/BaseContactModel;", "()V", "currentStep", "", "getCurrentStep", "()I", "setCurrentStep", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoHeaderModel.kt */
public final class InfoHeaderModel implements BaseContactModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f20797a = 1;

    /* renamed from: b */
    private String f20798b;

    public final int getCurrentStep() {
        return this.f20797a;
    }

    public final void setCurrentStep(int i) {
        this.f20797a = i;
    }

    public final String getTitle() {
        return this.f20798b;
    }

    public final void setTitle(String str) {
        this.f20798b = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/info/model/InfoHeaderModel$Companion;", "", "()V", "newInstance", "Lcom/didi/entrega/info/model/InfoHeaderModel;", "infoStep", "Lcom/didi/entrega/info/helper/InfoStepConfig;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InfoHeaderModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InfoHeaderModel newInstance(InfoStepConfig infoStepConfig) {
            Intrinsics.checkNotNullParameter(infoStepConfig, "infoStep");
            InfoHeaderModel infoHeaderModel = new InfoHeaderModel();
            infoHeaderModel.setCurrentStep(infoStepConfig.getCurrentStep());
            return infoHeaderModel;
        }
    }
}
