package com.didi.component.substitute.call.addPassenger;

import android.view.View;
import com.didi.component.business.data.form.FormStore;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/component/substitute/call/addPassenger/AddPassengerActivity$showPopRemindNoSeat$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPassengerActivity.kt */
public final class AddPassengerActivity$showPopRemindNoSeat$model$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ AddPassengerActivity this$0;

    AddPassengerActivity$showPopRemindNoSeat$model$1(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public void onAntiShakeClick(View view) {
        LEGODrawer mLegoDrawer = this.this$0.getMLegoDrawer();
        if (mLegoDrawer != null) {
            mLegoDrawer.dismiss();
        }
        FormStore.getInstance().setSkipEstimateGet(true);
        this.this$0.finish();
        this.this$0.m11785c("ibt_gp_interpret_pop_right_btn_ck", "right_btn");
    }
}
