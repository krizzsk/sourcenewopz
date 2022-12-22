package com.didi.safetoolkit.business.share.controller;

import android.app.Activity;
import android.content.Context;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.BroadcastUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/share/controller/SfShareOptController;", "", "()V", "share", "", "context", "Landroid/content/Context;", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfShareOptController.kt */
public final class SfShareOptController {
    public final void share(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SafeToolKit ins = SafeToolKit.getIns();
        Intrinsics.checkExpressionValueIsNotNull(ins, "SafeToolKit.getIns()");
        ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, ins.getBusinessType()).get();
        if (iSfContactCallbackService != null) {
            iSfContactCallbackService.onNewTrustedContactAdded(true);
        }
        BroadcastUtil.sendBroadcast(context, SfConstant.SfAction.ACTION_ADD_CONTACTS_SUCCESS);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
