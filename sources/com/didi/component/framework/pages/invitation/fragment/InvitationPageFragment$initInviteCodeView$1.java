package com.didi.component.framework.pages.invitation.fragment;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.RelativeLayout;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationPageFragment$initInviteCodeView$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "onLoadCleared", "", "placeholder", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationPageFragment.kt */
public final class InvitationPageFragment$initInviteCodeView$1 extends CustomTarget<Drawable> {
    final /* synthetic */ boolean $hasCache;
    final /* synthetic */ String $inviteCodeBgUrl;
    final /* synthetic */ RelativeLayout $inviteCodeView;
    final /* synthetic */ long $startTime;

    public void onLoadCleared(Drawable drawable) {
    }

    InvitationPageFragment$initInviteCodeView$1(RelativeLayout relativeLayout, String str, boolean z, long j) {
        this.$inviteCodeView = relativeLayout;
        this.$inviteCodeBgUrl = str;
        this.$hasCache = z;
        this.$startTime = j;
    }

    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        RelativeLayout relativeLayout = this.$inviteCodeView;
        if (relativeLayout != null) {
            if (relativeLayout != null) {
                relativeLayout.setBackgroundDrawable(drawable);
            }
            String simpleName = InvitationPageFragment.class.getSimpleName();
            LogUtil.m26314i(simpleName, "initInviteCodeView.onResourceReady:url = " + this.$inviteCodeBgUrl + ", hasCache = " + this.$hasCache);
            if (!this.$hasCache) {
                OmegaUtil.loadUrlIfNeedDownloadSuccessEvent(this.$inviteCodeBgUrl, SystemClock.elapsedRealtime() - this.$startTime);
            }
        }
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        String simpleName = InvitationPageFragment.class.getSimpleName();
        LogUtil.m26314i(simpleName, "initInviteCodeView.onLoadFailed:url = " + this.$inviteCodeBgUrl + ", hasCache = " + this.$hasCache + ", errorDrawable = " + drawable);
        OmegaUtil.loadUrlIfNeedDownloadFailEvent(this.$inviteCodeBgUrl, SystemClock.elapsedRealtime() - this.$startTime, Intrinsics.stringPlus("errorDrawable = ", drawable));
    }
}
