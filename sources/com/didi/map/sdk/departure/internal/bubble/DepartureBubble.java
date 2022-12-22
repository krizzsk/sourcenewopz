package com.didi.map.sdk.departure.internal.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

public abstract class DepartureBubble {
    public static final int BUBBLE_MOVE_HEIGHT = 30;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f28136a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f28137b = false;

    /* renamed from: c */
    private int f28138c = 1;

    /* renamed from: d */
    private int f28139d = (1 * 400);

    /* renamed from: e */
    private int f28140e = (1 * 400);

    /* access modifiers changed from: protected */
    public abstract View getView(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract void setContentInvisible();

    /* access modifiers changed from: protected */
    public abstract void setContentVisible();

    public DepartureBubble(ViewGroup viewGroup) {
        this.f28136a = viewGroup;
    }

    public synchronized void show() {
        show(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void show(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.view.ViewGroup r0 = r4.f28136a     // Catch:{ all -> 0x005e }
            android.view.View r0 = r4.getView(r0)     // Catch:{ all -> 0x005e }
            android.view.ViewGroup r1 = r4.f28136a     // Catch:{ all -> 0x005e }
            int r1 = r1.getChildCount()     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r1 <= 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0033
            boolean r5 = r4.f28137b     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0027
            android.view.ViewGroup r5 = r4.f28136a     // Catch:{ all -> 0x005e }
            com.didi.map.sdk.departure.internal.bubble.DepartureBubble$1 r1 = new com.didi.map.sdk.departure.internal.bubble.DepartureBubble$1     // Catch:{ all -> 0x005e }
            r1.<init>(r0)     // Catch:{ all -> 0x005e }
            int r0 = r4.f28139d     // Catch:{ all -> 0x005e }
            long r2 = (long) r0     // Catch:{ all -> 0x005e }
            r5.postDelayed(r1, r2)     // Catch:{ all -> 0x005e }
            goto L_0x0031
        L_0x0027:
            android.view.ViewGroup r5 = r4.f28136a     // Catch:{ all -> 0x005e }
            r4.m20013a((android.view.ViewGroup) r5)     // Catch:{ all -> 0x005e }
            android.view.ViewGroup r5 = r4.f28136a     // Catch:{ all -> 0x005e }
            r5.addView(r0)     // Catch:{ all -> 0x005e }
        L_0x0031:
            monitor-exit(r4)
            return
        L_0x0033:
            android.view.ViewGroup r1 = r4.f28136a     // Catch:{ all -> 0x005e }
            r1.addView(r0)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005c
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)     // Catch:{ all -> 0x005e }
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2)     // Catch:{ all -> 0x005e }
            r0.measure(r5, r1)     // Catch:{ all -> 0x005e }
            int r5 = r0.getMeasuredWidth()     // Catch:{ all -> 0x005e }
            int r1 = r0.getMeasuredHeight()     // Catch:{ all -> 0x005e }
            com.didi.map.sdk.departure.internal.bubble.DepartureBubble$2 r2 = new com.didi.map.sdk.departure.internal.bubble.DepartureBubble$2     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            android.view.animation.AnimationSet r5 = r4.m20012a(r5, r1, r2)     // Catch:{ all -> 0x005e }
            r4.setContentInvisible()     // Catch:{ all -> 0x005e }
            r0.startAnimation(r5)     // Catch:{ all -> 0x005e }
        L_0x005c:
            monitor-exit(r4)
            return
        L_0x005e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.departure.internal.bubble.DepartureBubble.show(boolean):void");
    }

    public boolean isInAnimation() {
        return this.f28137b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20013a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).clearAnimation();
        }
        viewGroup.removeAllViews();
    }

    /* renamed from: a */
    private AnimationSet m20012a(int i, int i2, Animation.AnimationListener animationListener) {
        float f = (float) i2;
        ScaleAnimation scaleAnimation = new ScaleAnimation((0.66f * f) / ((float) i), 1.0f, 0.66f, 1.0f, (float) (i / 2), f);
        scaleAnimation.setDuration((long) this.f28139d);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) this.f28140e);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(animationListener);
        return animationSet;
    }
}
