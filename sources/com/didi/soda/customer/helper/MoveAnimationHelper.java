package com.didi.soda.customer.helper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/MoveAnimationHelper;", "", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "parentView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Lcom/didi/app/nova/skeleton/ScopeContext;Landroid/view/ViewGroup;)V", "baseSpeedY", "", "offsetSpeedY", "translationX", "", "translationY", "createGoodViewMoveAnimation", "", "startPosition", "", "endPosition", "virtualGoodsView", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MoveAnimationHelper.kt */
public final class MoveAnimationHelper {

    /* renamed from: a */
    private Context f41348a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ScopeContext f41349b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewGroup f41350c;

    /* renamed from: d */
    private final float f41351d = -0.5f;

    /* renamed from: e */
    private final float f41352e = 0.1f;

    /* renamed from: f */
    private final String f41353f = "translationY";

    /* renamed from: g */
    private final String f41354g = "translationX";

    public MoveAnimationHelper(Context context, ScopeContext scopeContext, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        this.f41348a = context;
        this.f41349b = scopeContext;
        this.f41350c = viewGroup;
    }

    public final void createGoodViewMoveAnimation(int[] iArr, int[] iArr2, View view) {
        Intrinsics.checkNotNullParameter(iArr2, "endPosition");
        Intrinsics.checkNotNullParameter(view, "virtualGoodsView");
        if (iArr != null && iArr.length == 2) {
            this.f41350c.addView(view);
            float f = (float) iArr[0];
            float f2 = (float) iArr[1];
            float f3 = (float) iArr2[0];
            float f4 = (float) iArr2[1];
            float screenHeight = ((float) CustomerSystemUtil.getScreenHeight(this.f41348a)) / 3.0f;
            long j = 700;
            if (f2 < screenHeight) {
                j = 800;
            } else if (f2 > ((float) 2) * screenHeight) {
                j = 600;
            }
            ResourceHelper.getDimensionPixelSize(R.dimen.customer_520px);
            CustomerSystemUtil.getScreenHeight(this.f41348a);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f41353f, new float[]{f2, f4});
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.5f, 0.0f, 0.5f, 1.0f));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, this.f41354g, new float[]{f, f3});
            ofFloat2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.68f, 0.49f, 1.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.play(ofFloat2).with(ofFloat);
            animatorSet.addListener(new MoveAnimationHelper$createGoodViewMoveAnimation$1$1(this, view));
            animatorSet.start();
        }
    }
}
