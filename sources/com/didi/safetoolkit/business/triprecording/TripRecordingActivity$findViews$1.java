package com.didi.safetoolkit.business.triprecording;

import android.widget.CompoundButton;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.drawer.LEGOAbsDrawer;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.safetoolkit.business.record.request.SfAutoRecordRequest;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
final class TripRecordingActivity$findViews$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$findViews$1(TripRecordingActivity tripRecordingActivity) {
        this.this$0 = tripRecordingActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        AutoTrackHelper.trackViewOnClick(compoundButton, z);
        Intrinsics.checkExpressionValueIsNotNull(compoundButton, "buttonView");
        if (compoundButton.isPressed()) {
            TripRecordOmageUtils.ibt_gp_safetymonitoring_autorecord_ck(z);
            if (z) {
                SfAutoRecordRequest.autoRecordReport(1, 1);
                this.this$0.f34482j = true;
                TextView access$getMBtnStart$p = this.this$0.f34477e;
                if (access$getMBtnStart$p != null) {
                    access$getMBtnStart$p.performClick();
                    return;
                }
                return;
            }
            SfViewRecordMenuModel access$getSfViewRecordingModel$p = this.this$0.f34480h;
            String str5 = "";
            if (access$getSfViewRecordingModel$p == null || (str = access$getSfViewRecordingModel$p.autoPopTitle) == null) {
                str = str5;
            }
            SfViewRecordMenuModel access$getSfViewRecordingModel$p2 = this.this$0.f34480h;
            if (access$getSfViewRecordingModel$p2 == null || (str2 = access$getSfViewRecordingModel$p2.autoKeepOn) == null) {
                str2 = str5;
            }
            LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new TripRecordingActivity$findViews$1$model$1(this)));
            SfViewRecordMenuModel access$getSfViewRecordingModel$p3 = this.this$0.f34480h;
            if (access$getSfViewRecordingModel$p3 == null || (str3 = access$getSfViewRecordingModel$p3.autoPopContent) == null) {
                str3 = str5;
            }
            lEGODrawerModel1.setSubTitle(str3);
            SfViewRecordMenuModel access$getSfViewRecordingModel$p4 = this.this$0.f34480h;
            if (!(access$getSfViewRecordingModel$p4 == null || (str4 = access$getSfViewRecordingModel$p4.autoTurnOff) == null)) {
                str5 = str4;
            }
            lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(str5, new LEGOOnAntiShakeClickListener2() {
                public void onClickInDrawer(LEGODrawer lEGODrawer) {
                    Intrinsics.checkParameterIsNotNull(lEGODrawer, Const.DRAWER);
                    SfAutoRecordRequest.autoRecordReport(2, 0);
                    lEGODrawer.dismiss();
                    TripRecordOmageUtils.ibt_gp_autorecord_close_turnoff_ck();
                }
            }));
            LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(this.this$0, lEGODrawerModel1);
            Intrinsics.checkExpressionValueIsNotNull(showDrawerTemplate, "LEGOUICreator.showDrawer…RecordingActivity, model)");
            LEGOAbsDrawer lEGOAbsDrawer = showDrawerTemplate;
        }
    }
}
