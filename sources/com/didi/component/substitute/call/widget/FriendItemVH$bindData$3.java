package com.didi.component.substitute.call.widget;

import android.view.View;
import com.didi.component.substitute.call.contacts.HistoryItemCallback;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FriendItemVH.kt */
final class FriendItemVH$bindData$3 implements View.OnLongClickListener {
    final /* synthetic */ FriendItem $data;
    final /* synthetic */ FriendItemVH this$0;

    FriendItemVH$bindData$3(FriendItemVH friendItemVH, FriendItem friendItem) {
        this.this$0 = friendItemVH;
        this.$data = friendItem;
    }

    public final boolean onLongClick(View view) {
        HistoryItemCallback access$getMCallback$p = this.this$0.f16106e;
        if (access$getMCallback$p == null) {
            return false;
        }
        return access$getMCallback$p.longClick(this.$data);
    }
}
