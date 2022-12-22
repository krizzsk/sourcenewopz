package com.adyen.checkout.components.p058ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0001\u0002\u0007\b¨\u0006\t"}, mo175978d2 = {"Lcom/adyen/checkout/components/ui/Validation;", "", "()V", "isValid", "", "Invalid", "Valid", "Lcom/adyen/checkout/components/ui/Validation$Valid;", "Lcom/adyen/checkout/components/ui/Validation$Invalid;", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.adyen.checkout.components.ui.Validation */
/* compiled from: Validation.kt */
public abstract class Validation {
    public /* synthetic */ Validation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Validation() {
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo175978d2 = {"Lcom/adyen/checkout/components/ui/Validation$Valid;", "Lcom/adyen/checkout/components/ui/Validation;", "()V", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.adyen.checkout.components.ui.Validation$Valid */
    /* compiled from: Validation.kt */
    public static final class Valid extends Validation {
        public static final Valid INSTANCE = new Valid();

        private Valid() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/adyen/checkout/components/ui/Validation$Invalid;", "Lcom/adyen/checkout/components/ui/Validation;", "reason", "", "(I)V", "getReason", "()I", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.adyen.checkout.components.ui.Validation$Invalid */
    /* compiled from: Validation.kt */
    public static final class Invalid extends Validation {
        private final int reason;

        public Invalid(int i) {
            super((DefaultConstructorMarker) null);
            this.reason = i;
        }

        public final int getReason() {
            return this.reason;
        }
    }

    public final boolean isValid() {
        return this instanceof Valid;
    }
}
