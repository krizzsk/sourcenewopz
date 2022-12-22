package com.didi.component.substitute.call.widget;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.substitute.call.contacts.HistoryItemCallback;
import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FriendItemVH.kt */
final class FriendItemVH$bindData$2 implements View.OnClickListener {
    final /* synthetic */ FriendItem $data;
    final /* synthetic */ FriendItemVH this$0;

    FriendItemVH$bindData$2(FriendItemVH friendItemVH, FriendItem friendItem) {
        this.this$0 = friendItemVH;
        this.$data = friendItem;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        HistoryItemCallback access$getMCallback$p = this.this$0.f16106e;
        if (access$getMCallback$p != null) {
            access$getMCallback$p.click(this.$data);
        }
        Map hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "change_caller");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "history_list_page");
        GlobalOmegaUtils.trackEvent("ibt_gp_change_caller_ck", (Map<String, Object>) hashMap);
    }
}
