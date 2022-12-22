package com.didi.component.expectation.view.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didiglobal.travel.infra.dimens.ValueDimensions;
import com.didiglobal.travel.infra.dimens.ValueDimensionsKt;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 H2\u00020\u0001:\u0001HB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010 \u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020!0#H\bJ&\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0,J0\u0010-\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0001\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020!0,J.\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020$2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!03¢\u0006\u0002\b4H\bJ\u0015\u00105\u001a\u00020!*\u00020\u001c2\u0006\u00106\u001a\u00020/H\bJ<\u00107\u001a\u00020!*\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020!032\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020!03H\u0002J\u001f\u0010;\u001a\u00020!*\u00020\u00062\b\b\u0001\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020/H\bJ5\u0010>\u001a\u00020!*\u00020\u00062\u0006\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020/H\bJ\u0017\u0010D\u001a\u00020!*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u001dH\bJ\u001d\u0010E\u001a\u00020!*\u00020\u00062\u0006\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\bH\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u0019X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u001d8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006I"}, mo175978d2 = {"Lcom/didi/component/expectation/view/animation/ExpectationCardAnimation;", "", "view", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "collapseConstraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "isRunning", "", "()Z", "isShowProgress", "setShowProgress", "(Z)V", "isShowReimburse", "setShowReimburse", "isShowReimburseSubtitle", "setShowReimburseSubtitle", "isShowSubtitle", "setShowSubtitle", "normalConstraintSet", "runTransition", "targetView", "getTargetView", "()Landroid/view/ViewGroup;", "viewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "titleTextSwitcher", "Landroid/widget/TextSwitcher;", "Landroid/view/View;", "getTitleTextSwitcher", "(Landroid/view/View;)Landroid/widget/TextSwitcher;", "checkElement", "", "block", "Lkotlin/Function2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "collapse", "callback", "Lcom/didi/component/business/xpanelnew/IXpCompRefresh$IXpCompRefreshCb;", "duration", "", "onTransitionEnd", "Lkotlin/Function0;", "expand", "height", "", "cloneWith", "target", "apply", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "contentGravity", "gravity", "makeTransition", "onStart", "Landroidx/transition/Transition;", "onEnd", "override", "viewId", "size", "reconnect", "startId", "startSide", "endId", "endSide", "margin", "syncConstraints", "visibleOrGone", "id", "visible", "Companion", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationCardAnimation.kt */
public final class ExpectationCardAnimation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: i */
    private static final int f13719i = 105;

    /* renamed from: j */
    private static final int f13720j = 245;

    /* renamed from: a */
    private boolean f13721a;

    /* renamed from: b */
    private boolean f13722b = true;

    /* renamed from: c */
    private boolean f13723c;

    /* renamed from: d */
    private boolean f13724d;

    /* renamed from: e */
    private final WeakReference<ViewGroup> f13725e;

    /* renamed from: f */
    private final ConstraintSet f13726f;

    /* renamed from: g */
    private final ConstraintSet f13727g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f13728h;

    public ExpectationCardAnimation(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        this.f13725e = new WeakReference<>(viewGroup);
        this.f13726f = new ConstraintSet();
        this.f13727g = new ConstraintSet();
        ConstraintSet constraintSet = this.f13726f;
        View view = viewGroup;
        ConstraintLayout constraintLayout = view instanceof ConstraintLayout ? (ConstraintLayout) view : null;
        if (constraintLayout != null) {
            constraintSet.clone(constraintLayout);
        }
    }

    public final boolean isRunning() {
        return this.f13728h;
    }

    public final boolean isShowSubtitle() {
        return this.f13721a;
    }

    public final void setShowSubtitle(boolean z) {
        this.f13721a = z;
    }

    public final boolean isShowProgress() {
        return this.f13722b;
    }

    public final void setShowProgress(boolean z) {
        this.f13722b = z;
    }

    public final boolean isShowReimburse() {
        return this.f13723c;
    }

    public final void setShowReimburse(boolean z) {
        this.f13723c = z;
    }

    public final boolean isShowReimburseSubtitle() {
        return this.f13724d;
    }

    public final void setShowReimburseSubtitle(boolean z) {
        this.f13724d = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ViewGroup m9476a() {
        return (ViewGroup) this.f13725e.get();
    }

    /* renamed from: a */
    private final void m9485a(Function2<? super ConstraintLayout, ? super Context, Unit> function2) {
        ViewGroup access$getTargetView = m9476a();
        ConstraintLayout constraintLayout = access$getTargetView instanceof ConstraintLayout ? (ConstraintLayout) access$getTargetView : null;
        if (constraintLayout != null) {
            Context context = constraintLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            function2.invoke(constraintLayout, context);
        }
    }

    /* renamed from: a */
    private final void m9484a(ConstraintSet constraintSet, View view) {
        ConstraintLayout constraintLayout = view instanceof ConstraintLayout ? (ConstraintLayout) view : null;
        if (constraintLayout != null) {
            constraintSet.clone(constraintLayout);
        }
    }

    /* renamed from: a */
    private final void m9480a(ConstraintSet constraintSet, int i, int i2) {
        constraintSet.constrainWidth(i, i2);
        constraintSet.constrainHeight(i, i2);
    }

    /* renamed from: a */
    private final ConstraintSet m9478a(ConstraintSet constraintSet, ConstraintLayout constraintLayout, Function1<? super ConstraintSet, Unit> function1) {
        constraintSet.clone(constraintLayout);
        function1.invoke(constraintSet);
        return constraintSet;
    }

    /* renamed from: a */
    private final void m9482a(ConstraintSet constraintSet, int i, boolean z) {
        constraintSet.setVisibility(i, z ? 0 : 8);
    }

    /* renamed from: a */
    private final void m9481a(ConstraintSet constraintSet, int i, int i2, int i3, int i4, int i5) {
        constraintSet.clear(i, i2);
        constraintSet.connect(i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    private final void m9483a(ConstraintSet constraintSet, long j, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12) {
        ViewGroup a = m9476a();
        ConstraintLayout constraintLayout = a instanceof ConstraintLayout ? (ConstraintLayout) a : null;
        if (constraintLayout != null) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(j);
            changeBounds.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            changeBounds.addListener(new ExpectationCardAnimation$makeTransition$1$1$1(this, function1, function12));
            Unit unit = Unit.INSTANCE;
            TransitionManager.beginDelayedTransition(constraintLayout, changeBounds);
            constraintSet.applyTo(constraintLayout);
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9479a(android.widget.TextSwitcher r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r4.getCurrentView()
            boolean r1 = r0 instanceof android.widget.TextView
            r2 = 0
            if (r1 == 0) goto L_0x000c
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 != 0) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r0.setGravity(r5)
        L_0x0013:
            android.view.View r4 = r4.getNextView()
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 == 0) goto L_0x001e
            r2 = r4
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x001e:
            if (r2 != 0) goto L_0x0021
            goto L_0x0024
        L_0x0021:
            r2.setGravity(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.animation.ExpectationCardAnimation.m9479a(android.widget.TextSwitcher, int):void");
    }

    /* renamed from: a */
    private final TextSwitcher m9477a(View view) {
        return (TextSwitcher) view.findViewById(R.id.title_text_ts);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/component/expectation/view/animation/ExpectationCardAnimation$Companion;", "", "()V", "CARD_COLLAPSE_HEIGHT", "", "TITLE_TEXT_COLLAPSED_WIDTH_DP", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ExpectationCardAnimation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void collapse(IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb, long j, Function0<Unit> function0) {
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(function02, "onTransitionEnd");
        ViewGroup access$getTargetView = m9476a();
        ConstraintLayout constraintLayout = access$getTargetView instanceof ConstraintLayout ? (ConstraintLayout) access$getTargetView : null;
        if (constraintLayout != null) {
            Context context = constraintLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            ConstraintSet constraintSet = this.f13727g;
            constraintSet.clone(constraintLayout);
            constraintSet.constrainHeight(R.id.space_prop_up, ValueDimensions.m47078toPxIntimpl(ValueDimensionsKt.getDp(105), context));
            constraintSet.clear(R.id.title_text_ts, 7);
            constraintSet.constrainWidth(R.id.title_text_ts, ValueDimensions.m47078toPxIntimpl(ValueDimensionsKt.getDp(245), context));
            constraintSet.setVisibility(R.id.content_text_ts, 8);
            constraintSet.setVisibility(R.id.title_time_text, 0);
            constraintSet.setVisibility(R.id.time_text, 8);
            constraintSet.clear(R.id.custom_progressBar, 6);
            constraintSet.clear(R.id.custom_progressBar, 7);
            ConstraintSet constraintSet2 = constraintSet;
            constraintSet2.connect(R.id.custom_progressBar, 7, R.id.guideline_end, 7, 0);
            constraintSet.clear(R.id.custom_progressBar, 3);
            constraintSet2.connect(R.id.custom_progressBar, 3, R.id.title_text_ts, 3, 0);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.global_expectation_circle_progress_collapse);
            constraintSet.constrainWidth(R.id.custom_progressBar, dimensionPixelSize);
            constraintSet.constrainHeight(R.id.custom_progressBar, dimensionPixelSize);
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.global_expectation_circle_image_collapse);
            constraintSet.constrainWidth(R.id.webp_imageView, dimensionPixelSize2);
            constraintSet.constrainHeight(R.id.webp_imageView, dimensionPixelSize2);
            constraintSet.setVisibility(R.id.group_circle_progress, 0);
            Unit unit = Unit.INSTANCE;
            m9483a(constraintSet, j, new ExpectationCardAnimation$collapse$1$2(this, constraintLayout), new ExpectationCardAnimation$collapse$1$3(function02));
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{constraintLayout.getHeight(), ValueDimensions.m47078toPxIntimpl(ValueDimensionsKt.getDp(105), context)});
            ofInt.setDuration(j);
            ofInt.addUpdateListener(new ExpectationCardAnimation$collapse$1$4(iXpCompRefreshCb));
            ofInt.start();
        }
    }

    /* JADX WARNING: type inference failed for: r9v20, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void expand(com.didi.component.business.xpanelnew.IXpCompRefresh.IXpCompRefreshCb r19, int r20, long r21, kotlin.jvm.functions.Function0<kotlin.Unit> r23) {
        /*
            r18 = this;
            r6 = r18
            r7 = r20
            r0 = r23
            java.lang.String r1 = "onTransitionEnd"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            android.view.ViewGroup r1 = r18.m9476a()
            boolean r2 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r3 = 0
            if (r2 == 0) goto L_0x0017
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L_0x0018
        L_0x0017:
            r1 = r3
        L_0x0018:
            if (r1 != 0) goto L_0x001c
            goto L_0x017e
        L_0x001c:
            android.content.Context r8 = r1.getContext()
            java.lang.String r2 = "it.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            androidx.constraintlayout.widget.ConstraintSet r2 = r6.f13726f
            r4 = 2131434216(0x7f0b1ae8, float:1.849024E38)
            r2.constrainHeight(r4, r7)
            r12 = 2131431223(0x7f0b0f37, float:1.848417E38)
            r13 = 7
            r14 = 0
            r4 = 2131434618(0x7f0b1c7a, float:1.8491055E38)
            r5 = 7
            r2.clear(r4, r5)
            r10 = 2131434618(0x7f0b1c7a, float:1.8491055E38)
            r11 = 7
            r9 = r2
            r9.connect(r10, r11, r12, r13, r14)
            r12 = 2131431226(0x7f0b0f3a, float:1.8484175E38)
            r13 = 6
            r15 = 6
            r2.clear(r4, r15)
            r11 = 6
            r9.connect(r10, r11, r12, r13, r14)
            r9 = r1
            android.view.View r9 = (android.view.View) r9
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextSwitcher r9 = (android.widget.TextSwitcher) r9
            if (r9 != 0) goto L_0x0059
            goto L_0x007e
        L_0x0059:
            r10 = 17
            android.view.View r11 = r9.getCurrentView()
            boolean r12 = r11 instanceof android.widget.TextView
            if (r12 == 0) goto L_0x0066
            android.widget.TextView r11 = (android.widget.TextView) r11
            goto L_0x0067
        L_0x0066:
            r11 = r3
        L_0x0067:
            if (r11 != 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r11.setGravity(r10)
        L_0x006d:
            android.view.View r9 = r9.getNextView()
            boolean r11 = r9 instanceof android.widget.TextView
            if (r11 == 0) goto L_0x0078
            r3 = r9
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0078:
            if (r3 != 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r3.setGravity(r10)
        L_0x007e:
            r3 = -2
            r2.constrainWidth(r4, r3)
            r3 = 1
            r2.constrainedWidth(r4, r3)
            r4 = 2131428345(0x7f0b03f9, float:1.8478332E38)
            boolean r9 = r18.isShowSubtitle()
            r14 = 8
            r13 = 0
            if (r9 == 0) goto L_0x0094
            r9 = 0
            goto L_0x0096
        L_0x0094:
            r9 = 8
        L_0x0096:
            r2.setVisibility(r4, r9)
            r4 = 2131434619(0x7f0b1c7b, float:1.8491057E38)
            r2.setVisibility(r4, r14)
            r4 = 2131434343(0x7f0b1b67, float:1.8490497E38)
            boolean r9 = r18.isShowReimburseSubtitle()
            if (r9 == 0) goto L_0x00aa
            r9 = 0
            goto L_0x00ac
        L_0x00aa:
            r9 = 8
        L_0x00ac:
            r2.setVisibility(r4, r9)
            r4 = 2131434547(0x7f0b1c33, float:1.849091E38)
            r2.setVisibility(r4, r13)
            r12 = 0
            r4 = 7
            r16 = 0
            r11 = 2131428451(0x7f0b0463, float:1.8478547E38)
            r2.clear(r11, r5)
            r10 = 2131428451(0x7f0b0463, float:1.8478547E38)
            r5 = 7
            r9 = r2
            r3 = 2131428451(0x7f0b0463, float:1.8478547E38)
            r11 = r5
            r17 = 0
            r13 = r4
            r4 = 8
            r14 = r16
            r9.connect(r10, r11, r12, r13, r14)
            r13 = 6
            r14 = 0
            r2.clear(r3, r15)
            r11 = 6
            r9.connect(r10, r11, r12, r13, r14)
            r5 = 3
            r12 = 2131434343(0x7f0b1b67, float:1.8490497E38)
            r13 = 4
            r9 = 24
            long r9 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r9)
            int r14 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r9, r8)
            r2.clear(r3, r5)
            r10 = 2131428451(0x7f0b0463, float:1.8478547E38)
            r11 = 3
            r9 = r2
            r9.connect(r10, r11, r12, r13, r14)
            android.content.res.Resources r5 = r8.getResources()
            r9 = 2131166032(0x7f070350, float:1.7946298E38)
            int r5 = r5.getDimensionPixelSize(r9)
            r2.constrainWidth(r3, r5)
            r2.constrainHeight(r3, r5)
            r3 = 2131435805(0x7f0b211d, float:1.8493463E38)
            android.content.res.Resources r5 = r8.getResources()
            r9 = 2131166030(0x7f07034e, float:1.7946294E38)
            int r5 = r5.getDimensionPixelSize(r9)
            r2.constrainWidth(r3, r5)
            r2.constrainHeight(r3, r5)
            r3 = 2131431193(0x7f0b0f19, float:1.8484108E38)
            boolean r5 = r18.isShowProgress()
            if (r5 == 0) goto L_0x0125
            r14 = 0
            goto L_0x0127
        L_0x0125:
            r14 = 8
        L_0x0127:
            r2.setVisibility(r3, r14)
            r3 = 2131435714(0x7f0b20c2, float:1.8493278E38)
            boolean r5 = r18.isShowReimburse()
            if (r5 == 0) goto L_0x0135
            r14 = 0
            goto L_0x0137
        L_0x0135:
            r14 = 8
        L_0x0137:
            r2.setVisibility(r3, r14)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$2 r3 = new com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$2
            r3.<init>(r6, r1)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$3 r1 = new com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$3
            r1.<init>(r0)
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0 = r18
            r1 = r2
            r9 = 1
            r2 = r21
            r0.m9483a(r1, r2, r4, r5)
            r0 = 2
            int[] r0 = new int[r0]
            r1 = 105(0x69, float:1.47E-43)
            long r1 = com.didiglobal.travel.infra.dimens.ValueDimensionsKt.getDp((int) r1)
            int r1 = com.didiglobal.travel.infra.dimens.ValueDimensions.m47078toPxIntimpl(r1, r8)
            r0[r17] = r1
            r0[r9] = r7
            android.animation.ValueAnimator r0 = android.animation.ValueAnimator.ofInt(r0)
            r1 = r21
            r0.setDuration(r1)
            com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$4 r1 = new com.didi.component.expectation.view.animation.ExpectationCardAnimation$expand$1$4
            r2 = r19
            r1.<init>(r2)
            android.animation.ValueAnimator$AnimatorUpdateListener r1 = (android.animation.ValueAnimator.AnimatorUpdateListener) r1
            r0.addUpdateListener(r1)
            r0.start()
        L_0x017e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.animation.ExpectationCardAnimation.expand(com.didi.component.business.xpanelnew.IXpCompRefresh$IXpCompRefreshCb, int, long, kotlin.jvm.functions.Function0):void");
    }
}
