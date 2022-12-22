package com.didi.component.framework.pages.invitation.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.framework.pages.invitation.model.Swiper;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationNewPageFragment$initIntroductionView$adapter$1", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/framework/pages/invitation/model/Swiper;", "bindData", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "position", "", "getLayoutResourceId", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNewPageFragment.kt */
public final class InvitationNewPageFragment$initIntroductionView$adapter$1 extends CommonRvAdapter<Swiper> {
    final /* synthetic */ List<Swiper> $introDatas;

    public int getLayoutResourceId(int i) {
        return R.layout.global_invitation_intro_rec_item;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvitationNewPageFragment$initIntroductionView$adapter$1(List<Swiper> list, FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.$introDatas = list;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "requireActivity()");
    }

    /* JADX WARNING: type inference failed for: r4v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(com.didi.component.common.adapter.CommonRvVH r4, int r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000c
        L_0x0005:
            r1 = 2131431608(0x7f0b10b8, float:1.848495E38)
            android.widget.TextView r1 = r4.getTextView(r1)
        L_0x000c:
            if (r4 != 0) goto L_0x0010
            r2 = r0
            goto L_0x0017
        L_0x0010:
            r2 = 2131431604(0x7f0b10b4, float:1.8484942E38)
            android.widget.TextView r2 = r4.getTextView(r2)
        L_0x0017:
            if (r4 != 0) goto L_0x001a
            goto L_0x0024
        L_0x001a:
            r0 = 2131431605(0x7f0b10b5, float:1.8484944E38)
            android.view.View r4 = r4.getTargetView(r0)
            r0 = r4
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0024:
            if (r1 != 0) goto L_0x0027
            goto L_0x0038
        L_0x0027:
            java.util.List<com.didi.component.framework.pages.invitation.model.Swiper> r4 = r3.$introDatas
            java.lang.Object r4 = r4.get(r5)
            com.didi.component.framework.pages.invitation.model.Swiper r4 = (com.didi.component.framework.pages.invitation.model.Swiper) r4
            java.lang.String r4 = r4.getSwiperTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x0038:
            if (r2 != 0) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            java.util.List<com.didi.component.framework.pages.invitation.model.Swiper> r4 = r3.$introDatas
            java.lang.Object r4 = r4.get(r5)
            com.didi.component.framework.pages.invitation.model.Swiper r4 = (com.didi.component.framework.pages.invitation.model.Swiper) r4
            java.lang.String r4 = r4.getSwiperContent()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x004c:
            if (r5 == 0) goto L_0x0069
            r4 = 1
            if (r5 == r4) goto L_0x005f
            r4 = 2
            if (r5 == r4) goto L_0x0055
            goto L_0x0072
        L_0x0055:
            if (r0 != 0) goto L_0x0058
            goto L_0x0072
        L_0x0058:
            r4 = 2131233272(0x7f0809f8, float:1.8082677E38)
            r0.setImageResource(r4)
            goto L_0x0072
        L_0x005f:
            if (r0 != 0) goto L_0x0062
            goto L_0x0072
        L_0x0062:
            r4 = 2131233273(0x7f0809f9, float:1.8082679E38)
            r0.setImageResource(r4)
            goto L_0x0072
        L_0x0069:
            if (r0 != 0) goto L_0x006c
            goto L_0x0072
        L_0x006c:
            r4 = 2131233271(0x7f0809f7, float:1.8082675E38)
            r0.setImageResource(r4)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationNewPageFragment$initIntroductionView$adapter$1.bindData(com.didi.component.common.adapter.CommonRvVH, int):void");
    }
}
