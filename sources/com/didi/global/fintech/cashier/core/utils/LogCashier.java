package com.didi.global.fintech.cashier.core.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/LogCashier;", "", "()V", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogCashier.kt */
public final class LogCashier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f21493a = "CashierLog";

    @JvmStatic
    /* renamed from: d */
    public static final void m15749d(String str) {
        Companion.mo63904d(str);
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/LogCashier$Companion;", "", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "d", "", "msg", "e", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogCashier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public final void mo63903d(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "msg");
        }

        @JvmStatic
        /* renamed from: d */
        public final void mo63904d(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
        }

        /* renamed from: d */
        public final void mo63905d(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(obj, "msg");
        }

        /* renamed from: e */
        public final void mo63906e(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "msg");
        }

        /* renamed from: e */
        public final void mo63907e(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(obj, "msg");
        }

        private Companion() {
        }

        public final String getTag() {
            return LogCashier.f21493a;
        }
    }
}
