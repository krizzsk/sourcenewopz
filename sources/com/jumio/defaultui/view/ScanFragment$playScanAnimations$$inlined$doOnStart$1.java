package com.jumio.defaultui.view;

import android.animation.Animator;
import android.widget.ImageView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\n"}, mo175978d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnStart$$inlined$addListener$1"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Animator.kt */
public final class ScanFragment$playScanAnimations$$inlined$doOnStart$1 implements Animator.AnimatorListener {
    public final /* synthetic */ ScanFragment this$0;

    public ScanFragment$playScanAnimations$$inlined$doOnStart$1(ScanFragment scanFragment) {
        this.this$0 = scanFragment;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        ImageView access$getAnimationIcon$p = this.this$0.animationIcon;
        if (access$getAnimationIcon$p != null) {
            access$getAnimationIcon$p.setRotationY(0.0f);
        }
        ImageView access$getAnimationIcon$p2 = this.this$0.animationIcon;
        if (access$getAnimationIcon$p2 != null) {
            access$getAnimationIcon$p2.setImageResource(R.drawable.jumio_ic_focus);
        }
        ImageView access$getAnimationScrim$p = this.this$0.animationScrim;
        if (access$getAnimationScrim$p != null) {
            access$getAnimationScrim$p.setImageResource(R.drawable.jumio_ic_scrim_rect_light);
        }
    }
}
