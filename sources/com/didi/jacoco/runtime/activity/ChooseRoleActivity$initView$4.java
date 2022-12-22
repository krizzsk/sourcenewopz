package com.didi.jacoco.runtime.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.jacoco.runtime.JacocoRuntime;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
final class ChooseRoleActivity$initView$4 implements View.OnClickListener {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8741200836890699757L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$4", 10);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$initView$4(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity;
        $jacocoInit[9] = true;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        boolean[] $jacocoInit = $jacocoInit();
        if (ChooseRoleActivity.access$getRoleData$li(this.this$0) == null) {
            $jacocoInit[0] = true;
        } else if (!(!Intrinsics.areEqual((Object) ChooseRoleActivity.access$getRoleData$p(this.this$0).getName(), (Object) this.this$0.getResources().getString(R.string.name)))) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            JacocoRuntime.jacocoRuntime.generator.generate(ChooseRoleActivity.access$getAuto$p(this.this$0), ChooseRoleActivity.access$getRoleData$p(this.this$0));
            $jacocoInit[3] = true;
            String access$getTAG$p = ChooseRoleActivity.access$getTAG$p(this.this$0);
            SystemUtils.log(4, access$getTAG$p, "name = " + ChooseRoleActivity.access$getRoleData$p(this.this$0).getName(), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity$initView$4", 124);
            $jacocoInit[4] = true;
            SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.this$0, "data", 0).edit();
            $jacocoInit[5] = true;
            edit.putString("id", ChooseRoleActivity.access$getRoleData$p(this.this$0).getId()).putString("name", ChooseRoleActivity.access$getRoleData$p(this.this$0).getName()).apply();
            $jacocoInit[6] = true;
            $jacocoInit[8] = true;
        }
        SystemUtils.showToast(Toast.makeText(this.this$0, "请先选择提交人员信息", 0));
        $jacocoInit[7] = true;
        $jacocoInit[8] = true;
    }
}
