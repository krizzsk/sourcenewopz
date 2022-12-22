package com.didi.soda.customer.coordshop;

import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;
import com.didi.soda.customer.base.pages.CustomerPage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoordShopManager.kt */
final class CoordShopManager$triggerEnterBusinessEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CustomerPage $page;
    final /* synthetic */ CoordShopManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoordShopManager$triggerEnterBusinessEvent$1(CustomerPage customerPage, CoordShopManager coordShopManager) {
        super(0);
        this.$page = customerPage;
        this.this$0 = coordShopManager;
    }

    public final void invoke() {
        Controller controller = this.$page.controller;
        final CoordShopManager coordShopManager = this.this$0;
        controller.addLifecycleListener(new Controller.LifecycleListener() {
            public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
                CoordHost access$getCoordHost$p;
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(controllerChangeHandler, "changeHandler");
                Intrinsics.checkNotNullParameter(controllerChangeType, "changeType");
                super.onChangeEnd(controller, controllerChangeHandler, controllerChangeType);
                if (controllerChangeType == ControllerChangeType.POP_EXIT && (access$getCoordHost$p = coordShopManager.f40843c) != null) {
                    access$getCoordHost$p.listenBackFromBusiness();
                }
            }
        });
    }
}
