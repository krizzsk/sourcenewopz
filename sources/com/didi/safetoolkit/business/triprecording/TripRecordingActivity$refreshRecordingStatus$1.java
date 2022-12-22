package com.didi.safetoolkit.business.triprecording;

import android.view.View;
import android.widget.Switch;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.drawer.LEGOAbsDrawer;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
final class TripRecordingActivity$refreshRecordingStatus$1 implements View.OnClickListener {
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$refreshRecordingStatus$1(TripRecordingActivity tripRecordingActivity) {
        this.this$0 = tripRecordingActivity;
    }

    public final void onClick(View view) {
        Switch access$getSwitchAutoRecording$p;
        String str;
        String str2;
        String str3;
        String str4;
        AutoTrackHelper.trackViewOnClick(view);
        TripRecordOmageUtils.sendStartBtnClickOmega(this.this$0.f34473a);
        this.this$0.m24370b();
        if (!this.this$0.f34483k || this.this$0.f34482j || (access$getSwitchAutoRecording$p = this.this$0.f34481i) == null || access$getSwitchAutoRecording$p.isChecked()) {
            this.this$0.f34482j = false;
            return;
        }
        SfViewRecordMenuModel access$getSfViewRecordingModel$p = this.this$0.f34480h;
        String str5 = "";
        if (access$getSfViewRecordingModel$p == null || (str = access$getSfViewRecordingModel$p.manualPopTitle) == null) {
            str = str5;
        }
        SfViewRecordMenuModel access$getSfViewRecordingModel$p2 = this.this$0.f34480h;
        if (access$getSfViewRecordingModel$p2 == null || (str2 = access$getSfViewRecordingModel$p2.manualTurnOn) == null) {
            str2 = str5;
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new TripRecordingActivity$refreshRecordingStatus$1$model$1(this)));
        SfViewRecordMenuModel access$getSfViewRecordingModel$p3 = this.this$0.f34480h;
        if (access$getSfViewRecordingModel$p3 == null || (str3 = access$getSfViewRecordingModel$p3.manualPopContent) == null) {
            str3 = str5;
        }
        lEGODrawerModel1.setSubTitle(str3);
        SfViewRecordMenuModel access$getSfViewRecordingModel$p4 = this.this$0.f34480h;
        if (!(access$getSfViewRecordingModel$p4 == null || (str4 = access$getSfViewRecordingModel$p4.manualCancel) == null)) {
            str5 = str4;
        }
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(str5, new LEGOOnAntiShakeClickListener2() {
            public void onClickInDrawer(LEGODrawer lEGODrawer) {
                Intrinsics.checkParameterIsNotNull(lEGODrawer, Const.DRAWER);
                lEGODrawer.dismiss();
                TripRecordOmageUtils.ibt_gp_safety_manualrecord_cancel_ck();
            }
        }));
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(this.this$0, lEGODrawerModel1);
        Intrinsics.checkExpressionValueIsNotNull(showDrawerTemplate, "LEGOUICreator.showDrawer…RecordingActivity, model)");
        LEGOAbsDrawer lEGOAbsDrawer = showDrawerTemplate;
    }
}
