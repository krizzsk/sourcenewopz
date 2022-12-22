package com.didi.entrega.customer.flutter;

import com.didi.entrega.bill.plugin.BillServiceImp;
import com.didi.entrega.customer.flutter.service.AppApolloServiceImp;
import com.didi.entrega.customer.flutter.service.CommonServiceImp;
import com.didi.entrega.customer.flutter.service.LocationServiceImp;
import com.didi.entrega.customer.flutter.service.LoginServiceImp;
import com.didi.entrega.customer.flutter.service.PrivacyServiceImp;
import com.didi.entrega.customer.flutter.service.RouterServiceImp;
import com.didi.entrega.order.plugin.OrderServicePlugin;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister;
import com.didi.entrega.uni_entrega_business.common.GLEUniCommonServiceRegister;
import com.didi.entrega.uni_entrega_business.login.GLEUniLoginServiceRegister;
import com.didi.entrega.uni_entrega_business.map.GLEUniMapServiceRegister;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderDataService;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivacyChangeService;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyServiceRegister;
import com.didi.entrega.uni_entrega_business.router.GLEUniRouterServiceRegister;
import com.didi.rlab.uni_foundation.apollo.ApolloServiceRegister;
import com.didi.rlab.uni_foundation.location.LocationServiceRegister;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.BinaryMessenger;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/FlutterBusinessAbility;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterBusinessAbility.kt */
public final class FlutterBusinessAbility {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/FlutterBusinessAbility$Companion;", "", "()V", "registerService", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FlutterBusinessAbility.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void registerService(BinaryMessenger binaryMessenger) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            new GLEUniOrderDataService().setup(binaryMessenger);
            new GLEUniPrivacyChangeService().setup(binaryMessenger);
            new GLEUniBillFlutterModuleService().setup(binaryMessenger);
            GLEUniOrderServiceRegister.setup(binaryMessenger, new OrderServicePlugin());
            ApolloServiceRegister.setup(binaryMessenger, new AppApolloServiceImp());
            GLEUniPrivcyServiceRegister.setup(binaryMessenger, new PrivacyServiceImp());
            GLEUniCommonServiceRegister.setup(binaryMessenger, new CommonServiceImp());
            GLEUniLoginServiceRegister.setup(binaryMessenger, new LoginServiceImp());
            GLEUniRouterServiceRegister.setup(binaryMessenger, new RouterServiceImp());
            BillServiceImp billServiceImp = new BillServiceImp();
            GLEUniBillNativeModuleServiceRegister.setup(binaryMessenger, billServiceImp);
            GLEUniMapServiceRegister.setup(binaryMessenger, billServiceImp);
            LocationServiceRegister.setup(binaryMessenger, new LocationServiceImp());
        }
    }
}
