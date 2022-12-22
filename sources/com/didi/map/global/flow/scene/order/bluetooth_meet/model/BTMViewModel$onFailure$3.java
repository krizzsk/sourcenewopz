package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGODialogFragment;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$onFailure$3", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel$onFailure$3 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ Ref.ObjectRef<LEGODialogFragment> $dialog;
    final /* synthetic */ BTMViewModel this$0;

    BTMViewModel$onFailure$3(Ref.ObjectRef<LEGODialogFragment> objectRef, BTMViewModel bTMViewModel) {
        this.$dialog = objectRef;
        this.this$0 = bTMViewModel;
    }

    public void onAntiShakeClick(View view) {
        LEGODialogFragment lEGODialogFragment = (LEGODialogFragment) this.$dialog.element;
        if (lEGODialogFragment != null) {
            lEGODialogFragment.dismiss();
        }
        this.this$0.f26500j = null;
        this.this$0.tryAgain(false);
        BTMOmegaHelper.onPairedFailureDialogClick$default(this.this$0.f26502l, true, false, 2, (Object) null);
    }
}
