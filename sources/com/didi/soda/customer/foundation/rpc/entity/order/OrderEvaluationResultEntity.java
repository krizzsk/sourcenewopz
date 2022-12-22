package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "evaluationFeedback", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "getEvaluationFeedback", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "setEvaluationFeedback", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;)V", "Companion", "EvaluationFeedBackEntity", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluationResultEntity.kt */
public final class OrderEvaluationResultEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3363079370724253629L;
    private EvaluationFeedBackEntity evaluationFeedback;

    public final EvaluationFeedBackEntity getEvaluationFeedback() {
        return this.evaluationFeedback;
    }

    public final void setEvaluationFeedback(EvaluationFeedBackEntity evaluationFeedBackEntity) {
        this.evaluationFeedback = evaluationFeedBackEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderEvaluationResultEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "aftersaleUrl", "", "getAftersaleUrl", "()Ljava/lang/String;", "setAftersaleUrl", "(Ljava/lang/String;)V", "feedbackText", "getFeedbackText", "setFeedbackText", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderEvaluationResultEntity.kt */
    public static final class EvaluationFeedBackEntity implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 6000875986082004324L;
        private String aftersaleUrl;
        private String feedbackText;

        public final String getFeedbackText() {
            return this.feedbackText;
        }

        public final void setFeedbackText(String str) {
            this.feedbackText = str;
        }

        public final String getAftersaleUrl() {
            return this.aftersaleUrl;
        }

        public final void setAftersaleUrl(String str) {
            this.aftersaleUrl = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: OrderEvaluationResultEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
