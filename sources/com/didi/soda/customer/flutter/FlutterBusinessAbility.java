package com.didi.soda.customer.flutter;

import com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister;
import com.didi.soda.order.flutterpage.NewOrderServicePlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.BinaryMessenger;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/FlutterBusinessAbility;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterBusinessAbility.kt */
public final class FlutterBusinessAbility {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/FlutterBusinessAbility$Companion;", "", "()V", "registerService", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FlutterBusinessAbility.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void registerService(BinaryMessenger binaryMessenger) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            OrderServiceRegister.setup(binaryMessenger, new NewOrderServicePlugin());
        }
    }
}
