package com.didi.soda.customer.blocks.binderpool;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\t\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0006\u0010\u001f\u001a\u00020\u0004J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!J\b\u0010)\u001a\u00020\u0013H\u0016J(\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u0006\u00101\u001a\u00020\u001eR>\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/binderpool/RecyclerViewHolder;", "T", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "itemParentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "<set-?>", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/blocks/widget/Buildable;", "binderRoot", "getBinderRoot", "()Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "mDeleteView", "Landroid/view/View;", "getMDeleteView", "()Landroid/view/View;", "setMDeleteView", "(Landroid/view/View;)V", "mIsDraggedOut", "", "mIsInAnimation", "slideContainer", "getSlideContainer", "setSlideContainer", "slideable", "getSlideable", "()Z", "setSlideable", "(Z)V", "addToItemView", "", "getItemParentView", "getMaxMoveX", "", "getMoveDirections", "getRecoverAnimator", "Landroid/animation/ValueAnimator;", "dragOut", "beginX", "endX", "maxX", "isMovable", "onMove", "horizontalDirection", "absMoveX", "", "verticalDirection", "absMoveY", "onMoveFinished", "removeFromItemView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RecyclerBinder.kt */
public final class RecyclerViewHolder<T> extends ItemViewHolder<T> {

    /* renamed from: a */
    private final ViewGroup f40564a;

    /* renamed from: b */
    private View f40565b;

    /* renamed from: c */
    private View f40566c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f40567d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f40568e;

    /* renamed from: f */
    private BinderRoot<? extends Buildable, T> f40569f;

    /* renamed from: g */
    private boolean f40570g;

    public int getMoveDirections() {
        return 12;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "itemParentView");
        this.f40564a = viewGroup;
    }

    public final View getMDeleteView() {
        return this.f40565b;
    }

    public final void setMDeleteView(View view) {
        this.f40565b = view;
    }

    public final View getSlideContainer() {
        return this.f40566c;
    }

    public final void setSlideContainer(View view) {
        this.f40566c = view;
    }

    public final BinderRoot<? extends Buildable, T> getBinderRoot() {
        return this.f40569f;
    }

    public final boolean getSlideable() {
        return this.f40570g;
    }

    public final void setSlideable(boolean z) {
        this.f40570g = z;
    }

    public final ViewGroup getItemParentView() {
        return this.f40564a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.didi.soda.blocks.widget.Buildable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.didi.soda.blocks.widget.Buildable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.didi.soda.blocks.widget.Buildable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.didi.soda.blocks.widget.Buildable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.didi.soda.blocks.widget.Buildable} */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r0.getConfigs();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addToItemView(com.didi.soda.customer.blocks.binderpool.BinderRoot<? extends com.didi.soda.blocks.widget.Buildable, T> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "binderRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.f40569f = r4
            com.didi.soda.blocks.BinderRootConfig r0 = r4.getConfig()
            r1 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x001e
        L_0x0010:
            java.util.Map r0 = r0.getConfigs()
            if (r0 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            java.lang.String r2 = "slideable"
            java.lang.Object r0 = r0.get(r2)
        L_0x001e:
            boolean r2 = r0 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x0025
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x0025:
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            r3.f40570g = r0
            if (r0 == 0) goto L_0x0054
            com.didi.soda.blocks.widget.Buildable r0 = r4.getView()
            android.view.View r0 = r0.getView()
            r1 = 2131428502(0x7f0b0496, float:1.847865E38)
            android.view.View r0 = r0.findViewById(r1)
            r3.f40566c = r0
            com.didi.soda.blocks.widget.Buildable r0 = r4.getView()
            android.view.View r0 = r0.getView()
            r1 = 2131428503(0x7f0b0497, float:1.8478652E38)
            android.view.View r0 = r0.findViewById(r1)
            r3.f40565b = r0
        L_0x0054:
            android.view.ViewGroup r0 = r3.f40564a
            boolean r0 = r0 instanceof com.didi.soda.blocks.style.BlockLayout
            if (r0 == 0) goto L_0x0070
            com.didi.soda.blocks.widget.Buildable r0 = r4.getView()
            boolean r0 = r0 instanceof com.didi.soda.blocks.style.BaseBinder
            if (r0 == 0) goto L_0x0070
            android.view.ViewGroup r0 = r3.f40564a
            com.didi.soda.blocks.style.BlockLayout r0 = (com.didi.soda.blocks.style.BlockLayout) r0
            com.didi.soda.blocks.widget.Buildable r4 = r4.getView()
            com.didi.soda.blocks.style.BaseBinder r4 = (com.didi.soda.blocks.style.BaseBinder) r4
            r0.addView(r4)
            goto L_0x007d
        L_0x0070:
            android.view.ViewGroup r0 = r3.f40564a
            com.didi.soda.blocks.widget.Buildable r4 = r4.getView()
            android.view.View r4 = r4.getView()
            r0.addView(r4)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.binderpool.RecyclerViewHolder.addToItemView(com.didi.soda.customer.blocks.binderpool.BinderRoot):void");
    }

    public final void removeFromItemView() {
        this.f40564a.removeAllViews();
        this.f40569f = null;
    }

    public int getMaxMoveX() {
        View view = this.f40565b;
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public boolean isMovable() {
        return super.isMovable() && this.f40570g && !this.f40568e;
    }

    public void onMove(int i, float f, int i2, float f2) {
        View view;
        View view2;
        if (this.f40570g) {
            if (i != 4) {
                if (i == 8 && this.f40567d && (view2 = this.f40566c) != null) {
                    view2.scrollTo(getMaxMoveX() - ((int) f), 0);
                }
            } else if (!this.f40567d && (view = this.f40566c) != null) {
                view.scrollTo((int) f, 0);
            }
        }
    }

    public void onMoveFinished() {
        BinderRootConfig<T> config;
        Map<String, Function1<T, Unit>> commonCallBacks;
        Function1 function1;
        if (this.f40570g) {
            int maxMoveX = getMaxMoveX();
            View view = this.f40566c;
            int i = 0;
            int scrollX = view == null ? 0 : view.getScrollX();
            boolean z = true;
            if (!this.f40567d ? scrollX <= maxMoveX / 4 : scrollX <= (maxMoveX * 3) / 4) {
                z = false;
            }
            if (z) {
                BinderRoot<? extends Buildable, T> binderRoot = this.f40569f;
                if (!(binderRoot == null || (config = binderRoot.getConfig()) == null || (commonCallBacks = config.getCommonCallBacks()) == null || (function1 = commonCallBacks.get(BlocksConst.CALLBACK_NAME_SLIDEFINISH)) == null)) {
                    function1.invoke(getItem());
                }
                i = maxMoveX;
            }
            getRecoverAnimator(z, scrollX, i, maxMoveX).start();
        }
    }

    public final ValueAnimator getRecoverAnimator(boolean z, int i, int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setDuration(((long) (Math.abs(i2 - i) * 1000)) / ((long) i3));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RecyclerViewHolder.m28808a(RecyclerViewHolder.this, valueAnimator);
            }
        });
        ofInt.addListener(new RecyclerViewHolder$getRecoverAnimator$2(this, z));
        Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28808a(RecyclerViewHolder recyclerViewHolder, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(recyclerViewHolder, "this$0");
        View slideContainer = recyclerViewHolder.getSlideContainer();
        if (slideContainer != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                slideContainer.scrollTo(((Integer) animatedValue).intValue(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }
}
