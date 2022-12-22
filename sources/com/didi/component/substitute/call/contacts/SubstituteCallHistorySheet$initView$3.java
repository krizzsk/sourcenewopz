package com.didi.component.substitute.call.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.substitute.call.addPassenger.AddPassengerActivity;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.travel.psnger.model.response.estimate.daijiao.AddAnother;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/component/substitute/call/contacts/SubstituteCallHistorySheet$initView$3", "Lcom/didi/component/common/util/OnAntiShakeClickListener;", "onAntiShakeClick", "", "v", "Landroid/view/View;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallHistorySheet.kt */
public final class SubstituteCallHistorySheet$initView$3 extends OnAntiShakeClickListener {
    final /* synthetic */ SubstituteCallHistorySheet this$0;

    SubstituteCallHistorySheet$initView$3(SubstituteCallHistorySheet substituteCallHistorySheet) {
        this.this$0 = substituteCallHistorySheet;
    }

    public void onAntiShakeClick(View view) {
        Resources resources;
        AddAnother addAnother;
        SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
        boolean z = false;
        if (!(substituteCallModel == null || (addAnother = substituteCallModel.getAddAnother()) == null || addAnother.getCanAdd() != 0)) {
            z = true;
        }
        if (z) {
            Context context = this.this$0.getContext();
            String str = null;
            if (!(context == null || (resources = context.getResources()) == null)) {
                str = resources.getString(R.string.GRider_Req_You_have_RkTB);
            }
            if (str != null) {
                LEGOToastHelper.showLongNagToast(this.this$0.getContext(), str);
                return;
            }
            return;
        }
        Context context2 = this.this$0.getContext();
        if (context2 != null) {
            this.this$0.startActivityForResult(AddPassengerActivity.Companion.getIntent(context2), 100);
        }
    }
}
