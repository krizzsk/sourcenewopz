package com.didi.component.framework.pages.invitation.fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.didi.component.framework.pages.invitation.model.LunBoConfig;
import com.didi.component.framework.pages.invitation.model.LunBoItemInfo;
import com.didi.component.framework.pages.invitation.model.PageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationNewPageFragment$initBanner$runnable$1", "Ljava/lang/Runnable;", "run", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNewPageFragment.kt */
public final class InvitationNewPageFragment$initBanner$runnable$1 implements Runnable {
    final /* synthetic */ List<LunBoItemInfo> $bannerList;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ long $time;
    final /* synthetic */ ViewSwitcher $viewSwitcher;
    final /* synthetic */ InvitationNewPageFragment this$0;

    InvitationNewPageFragment$initBanner$runnable$1(ViewSwitcher viewSwitcher, Ref.IntRef intRef, List<LunBoItemInfo> list, InvitationNewPageFragment invitationNewPageFragment, long j) {
        this.$viewSwitcher = viewSwitcher;
        this.$index = intRef;
        this.$bannerList = list;
        this.this$0 = invitationNewPageFragment;
        this.$time = j;
    }

    public void run() {
        Object obj;
        String str;
        LunBoConfig lunboConfig;
        String lunboText;
        String replace$default;
        ViewSwitcher viewSwitcher = this.$viewSwitcher;
        View nextView = viewSwitcher == null ? null : viewSwitcher.getNextView();
        if (nextView != null) {
            TextView textView = (TextView) nextView;
            if (this.$index.element >= this.$bannerList.size() || this.$index.element <= 0) {
                this.$index.element = 0;
            }
            if (!TextUtils.isEmpty(this.$bannerList.get(this.$index.element).getAmountFormat())) {
                obj = this.$bannerList.get(this.$index.element).getAmountFormat();
            } else {
                obj = this.$bannerList.get(this.$index.element).getAmount();
                if (obj == null) {
                    obj = "0";
                }
            }
            if (!this.this$0.f13831r) {
                str = Intrinsics.stringPlus(this.this$0.f13832s, obj);
            } else {
                str = obj + this.this$0.f13832s;
            }
            PageData access$getPageInfo$p = this.this$0.f13824k;
            String str2 = "";
            if (!(access$getPageInfo$p == null || (lunboConfig = access$getPageInfo$p.getLunboConfig()) == null || (lunboText = lunboConfig.getLunboText()) == null)) {
                String referrer_name = InvitationNewPageFragment.Companion.getREFERRER_NAME();
                String name = this.$bannerList.get(this.$index.element).getName();
                String replace$default2 = StringsKt.replace$default(lunboText, referrer_name, name == null ? str2 : name, false, 4, (Object) null);
                if (!(replace$default2 == null || (replace$default = StringsKt.replace$default(replace$default2, InvitationNewPageFragment.Companion.getREFERRER_REWARD(), str, false, 4, (Object) null)) == null)) {
                    str2 = replace$default;
                }
            }
            textView.setText(this.this$0.m9590a(str2, str));
            this.$index.element++;
            this.$viewSwitcher.showNext();
            Handler access$getHandler$p = this.this$0.f13828o;
            if (access$getHandler$p != null) {
                access$getHandler$p.postDelayed(this, this.$time * ((long) 1000));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
