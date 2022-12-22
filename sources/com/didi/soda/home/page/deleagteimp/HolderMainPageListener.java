package com.didi.soda.home.page.deleagteimp;

import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/page/deleagteimp/HolderMainPageListener;", "Lcom/didi/app/nova/skeleton/conductor/Controller$LifecycleListener;", "()V", "onChangeEnd", "", "controller", "Lcom/didi/app/nova/skeleton/conductor/Controller;", "changeHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "changeType", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeType;", "onChangeStart", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HolderMainPageListener.kt */
public final class HolderMainPageListener extends Controller.LifecycleListener {
    public void onChangeStart(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(controllerChangeHandler, "changeHandler");
        Intrinsics.checkNotNullParameter(controllerChangeType, "changeType");
        super.onChangeStart(controller, controllerChangeHandler, controllerChangeType);
        LogUtil.m29100d("MyLifecleListener", ">>>>>>> onChangeStart controller = " + controller + " changeHandler = " + controllerChangeHandler + " changeType = " + controllerChangeType);
    }

    public void onChangeEnd(Controller controller, ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(controllerChangeHandler, "changeHandler");
        Intrinsics.checkNotNullParameter(controllerChangeType, "changeType");
        super.onChangeEnd(controller, controllerChangeHandler, controllerChangeType);
        LogUtil.m29100d("MyLifecleListener", ">>>>>>> onChangeEnd controller = " + controller + " changeHandler = " + controllerChangeHandler + " changeType = " + controllerChangeType);
        if (controllerChangeType == ControllerChangeType.POP_ENTER) {
            LogUtil.m29100d("HolderMainPage", " >>>>>>> pop <<<<<< ");
            GlobalContext.getBusinessContext().getNavigation().popBackStack();
        }
    }
}
