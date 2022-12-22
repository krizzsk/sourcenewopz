package com.didi.sdk.sidebar.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/sdk/sidebar/view/Nav2UserInfoComponentNewView$showDidiPass$2", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Nav2UserInfoComponentNewView.kt */
public final class Nav2UserInfoComponentNewView$showDidiPass$2 extends CustomTarget<Bitmap> {
    final /* synthetic */ Nav2UserInfoComponentNewView this$0;

    public void onLoadCleared(Drawable drawable) {
    }

    Nav2UserInfoComponentNewView$showDidiPass$2(Nav2UserInfoComponentNewView nav2UserInfoComponentNewView) {
        this.this$0 = nav2UserInfoComponentNewView;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        RelativeLayout access$getMDidiPassLayout$p = this.this$0.f37484h;
        if (access$getMDidiPassLayout$p != null) {
            access$getMDidiPassLayout$p.setBackground(bitmapDrawable);
        }
    }
}
