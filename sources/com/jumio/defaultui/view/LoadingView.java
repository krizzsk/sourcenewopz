package com.jumio.defaultui.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.text.HtmlCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.sdk.error.JumioError;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \\2\u00020\u0001:\u0005]\\^_`B\u0019\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J.\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0013J&\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\"\u0010\"\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016J*\u0010%\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\u001a\u0010&\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u0006H\u0016J*\u0010'\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00100R\"\u00102\u001a\u00020\u001b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bI\u0010HR\u0016\u0010J\u001a\u00020F8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010O\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\bO\u0010=\u001a\u0004\bO\u0010PR*\u0010R\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\u000e8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bR\u0010=\u001a\u0004\bS\u0010P\"\u0004\bT\u0010UR\u0013\u0010Y\u001a\u00020V8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006a"}, mo175978d2 = {"Lcom/jumio/defaultui/view/LoadingView;", "Landroidx/constraintlayout/motion/widget/MotionLayout$TransitionListener;", "", "inflateLayout", "startExecution", "updateUi", "", "stringId", "", "getHtmlStringFromId", "(Ljava/lang/Integer;)Ljava/lang/CharSequence;", "", "stringValue", "getHtmlStringFromString", "", "show", "Landroid/animation/AnimatorListenerAdapter;", "animatorListenerAdapter", "duration", "", "startDelay", "showLoading", "updateState", "animateLoadingIcon", "message", "log", "hide", "Lcom/jumio/defaultui/view/LoadingView$State;", "state", "update", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "p0", "p1", "p2", "onTransitionStarted", "", "p3", "onTransitionChange", "onTransitionCompleted", "onTransitionTrigger", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/widget/FrameLayout;", "loadingViewContainer", "Landroid/widget/FrameLayout;", "", "nextStateLock", "Ljava/lang/Object;", "currentStateLock", "currentState", "Lcom/jumio/defaultui/view/LoadingView$State;", "getCurrentState$jumio_defaultui_release", "()Lcom/jumio/defaultui/view/LoadingView$State;", "setCurrentState$jumio_defaultui_release", "(Lcom/jumio/defaultui/view/LoadingView$State;)V", "nextState", "Lcom/jumio/defaultui/view/LoadingView$a;", "animationState", "Lcom/jumio/defaultui/view/LoadingView$a;", "isActive", "Z", "loadingViewLayout", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "description", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/ImageView;", "ivLoadingGradient", "Landroid/widget/ImageView;", "ivLoadingPlain", "ivLoadingIcon", "Lcom/google/android/material/button/MaterialButton;", "retryButton", "Lcom/google/android/material/button/MaterialButton;", "<set-?>", "isShowing", "()Z", "value", "pause", "getPause", "setPause", "(Z)V", "Lcom/jumio/defaultui/view/LoadingView$ViewState;", "getViewState", "()Lcom/jumio/defaultui/view/LoadingView$ViewState;", "viewState", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;)V", "Companion", "a", "ErrorState", "State", "ViewState", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: LoadingView.kt */
public final class LoadingView implements MotionLayout.TransitionListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = LoadingView.class.getSimpleName();
    /* access modifiers changed from: private */
    public C20075a animationState = C20075a.START;
    private final Context context;
    private State currentState;
    /* access modifiers changed from: private */
    public final Object currentStateLock;
    private AppCompatTextView description;
    /* access modifiers changed from: private */
    public boolean isActive;
    private boolean isShowing;
    private ImageView ivLoadingGradient;
    private ImageView ivLoadingIcon;
    private ImageView ivLoadingPlain;
    /* access modifiers changed from: private */
    public final FrameLayout loadingViewContainer;
    /* access modifiers changed from: private */
    public MotionLayout loadingViewLayout;
    /* access modifiers changed from: private */
    public State nextState;
    /* access modifiers changed from: private */
    public final Object nextStateLock;
    private boolean pause = true;
    private MaterialButton retryButton;
    private TextView title;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/LoadingView$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: LoadingView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/defaultui/view/LoadingView$ErrorState;", "Lcom/jumio/defaultui/view/LoadingView$State;", "Lcom/jumio/sdk/error/JumioError;", "error", "Lcom/jumio/sdk/error/JumioError;", "getError", "()Lcom/jumio/sdk/error/JumioError;", "", "buttonTextId", "I", "getButtonTextId", "()I", "Landroid/view/View$OnClickListener;", "errorClickListener", "<init>", "(Lcom/jumio/sdk/error/JumioError;Landroid/view/View$OnClickListener;)V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: LoadingView.kt */
    public static final class ErrorState extends State {
        private final int buttonTextId;
        private final JumioError error;

        public ErrorState(JumioError jumioError, View.OnClickListener onClickListener) {
            super(ViewState.ERROR, R.string.jumio_error_connection_title, (String) null, 0, onClickListener, 12, (DefaultConstructorMarker) null);
            this.error = jumioError;
            boolean z = true;
            this.buttonTextId = (jumioError == null || !jumioError.isRetryable()) ? false : z ? R.string.jumio_button_retry : R.string.jumio_button_cancel;
        }

        public int getButtonTextId() {
            return this.buttonTextId;
        }

        public final JumioError getError() {
            return this.error;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/LoadingView$ViewState;", "", "<init>", "(Ljava/lang/String;I)V", "STOPPED", "PROGRESS", "SUCCESS", "ERROR", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: LoadingView.kt */
    public enum ViewState {
        STOPPED,
        PROGRESS,
        SUCCESS,
        ERROR
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: LoadingView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ViewState.values().length];
            iArr[ViewState.PROGRESS.ordinal()] = 1;
            iArr[ViewState.ERROR.ordinal()] = 2;
            iArr[ViewState.SUCCESS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[C20075a.values().length];
            iArr2[C20075a.START.ordinal()] = 1;
            iArr2[C20075a.END.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: com.jumio.defaultui.view.LoadingView$a */
    /* compiled from: LoadingView.kt */
    public enum C20075a {
        START,
        END
    }

    public LoadingView(Context context2, FrameLayout frameLayout) {
        ViewState viewState;
        Intrinsics.checkNotNullParameter(frameLayout, "loadingViewContainer");
        this.context = context2;
        this.loadingViewContainer = frameLayout;
        Object obj = new Object();
        this.nextStateLock = obj;
        Object obj2 = new Object();
        this.currentStateLock = obj2;
        inflateLayout();
        synchronized (obj2) {
            viewState = ViewState.STOPPED;
            setCurrentState$jumio_defaultui_release(new State(viewState, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null));
            Unit unit = Unit.INSTANCE;
        }
        synchronized (obj) {
            this.nextState = new State(viewState, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void animateLoadingIcon() {
        SpringForce springForce = new SpringForce(1.0f);
        springForce.setDampingRatio(0.3f);
        ImageView imageView = this.ivLoadingIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
            imageView = null;
        }
        SpringAnimation springAnimation = new SpringAnimation(imageView, DynamicAnimation.SCALE_X);
        ImageView imageView3 = this.ivLoadingIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
            imageView3 = null;
        }
        SpringAnimation springAnimation2 = new SpringAnimation(imageView3, DynamicAnimation.SCALE_Y);
        springAnimation.setSpring(springForce);
        ((SpringAnimation) springAnimation.setStartValue(0.0f)).start();
        springAnimation2.setSpring(springForce);
        ((SpringAnimation) springAnimation2.setStartValue(0.0f)).start();
        ImageView imageView4 = this.ivLoadingIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setAlpha(1.0f);
    }

    private final CharSequence getHtmlStringFromId(Integer num) {
        return (this.context == null || num == null || num.intValue() == 0) ? "" : getHtmlStringFromString(this.context.getString(num.intValue()));
    }

    private final CharSequence getHtmlStringFromString(String str) {
        if (str == null) {
            return "";
        }
        Spanned fromHtml = HtmlCompat.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n\t\t\tHtmlCompat.fromHtml…ROM_HTML_MODE_LEGACY)\n\t\t}");
        return fromHtml;
    }

    public static /* synthetic */ void hide$default(LoadingView loadingView, AnimatorListenerAdapter animatorListenerAdapter, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            animatorListenerAdapter = null;
        }
        if ((i2 & 2) != 0) {
            i = 300;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        loadingView.hide(animatorListenerAdapter, i, j);
    }

    private final void inflateLayout() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.jumio_loading_view, this.loadingViewContainer, false);
        View findViewById = inflate.findViewById(R.id.ml_loading_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.ml_loading_view)");
        MotionLayout motionLayout = (MotionLayout) findViewById;
        this.loadingViewLayout = motionLayout;
        MotionLayout motionLayout2 = null;
        if (motionLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
            motionLayout = null;
        }
        View findViewById2 = motionLayout.findViewById(R.id.tv_loading_title);
        if (findViewById2 != null) {
            this.title = (AppCompatTextView) findViewById2;
            MotionLayout motionLayout3 = this.loadingViewLayout;
            if (motionLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                motionLayout3 = null;
            }
            View findViewById3 = motionLayout3.findViewById(R.id.tv_loading_description);
            if (findViewById3 != null) {
                this.description = (AppCompatTextView) findViewById3;
                MotionLayout motionLayout4 = this.loadingViewLayout;
                if (motionLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    motionLayout4 = null;
                }
                View findViewById4 = motionLayout4.findViewById(R.id.iv_loading_gradient);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "loadingViewLayout.findVi…R.id.iv_loading_gradient)");
                this.ivLoadingGradient = (ImageView) findViewById4;
                MotionLayout motionLayout5 = this.loadingViewLayout;
                if (motionLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    motionLayout5 = null;
                }
                View findViewById5 = motionLayout5.findViewById(R.id.iv_loading_plain);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "loadingViewLayout.findVi…Id(R.id.iv_loading_plain)");
                this.ivLoadingPlain = (ImageView) findViewById5;
                MotionLayout motionLayout6 = this.loadingViewLayout;
                if (motionLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    motionLayout6 = null;
                }
                View findViewById6 = motionLayout6.findViewById(R.id.iv_loading_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "loadingViewLayout.findVi…yId(R.id.iv_loading_icon)");
                this.ivLoadingIcon = (ImageView) findViewById6;
                MotionLayout motionLayout7 = this.loadingViewLayout;
                if (motionLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                } else {
                    motionLayout2 = motionLayout7;
                }
                View findViewById7 = motionLayout2.findViewById(R.id.btn_retry);
                Intrinsics.checkNotNullExpressionValue(findViewById7, "loadingViewLayout.findViewById(R.id.btn_retry)");
                this.retryButton = (MaterialButton) findViewById7;
                this.loadingViewContainer.addView(inflate);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
    }

    /* access modifiers changed from: private */
    public final void log(String str) {
        Log.m39466i(TAG, String.valueOf(str));
    }

    public static /* synthetic */ void show$default(LoadingView loadingView, AnimatorListenerAdapter animatorListenerAdapter, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            animatorListenerAdapter = null;
        }
        if ((i2 & 2) != 0) {
            i = 300;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        loadingView.show(animatorListenerAdapter, i, j);
    }

    private final void showLoading(boolean z, AnimatorListenerAdapter animatorListenerAdapter, int i, long j) {
        if (this.isShowing != z) {
            this.isShowing = z;
            MotionLayout motionLayout = this.loadingViewLayout;
            MotionLayout motionLayout2 = null;
            if (motionLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                motionLayout = null;
            }
            float f = 1.0f;
            motionLayout.setTranslationY(1.0f);
            MotionLayout motionLayout3 = this.loadingViewLayout;
            if (motionLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
            } else {
                motionLayout2 = motionLayout3;
            }
            float[] fArr = new float[2];
            fArr[0] = z ? 0.0f : 1.0f;
            if (!z) {
                f = 0.0f;
            }
            fArr[1] = f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(motionLayout2, "alpha", fArr);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(\n\t\t\tloadingViewL…f (show) 1f else 0.0f\n\t\t)");
            ofFloat.setDuration((long) i);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            animatorSet.addListener(new LoadingView$showLoading$1(this));
            animatorSet.setStartDelay(j);
            animatorSet.start();
        }
    }

    public static /* synthetic */ void showLoading$default(LoadingView loadingView, boolean z, AnimatorListenerAdapter animatorListenerAdapter, int i, long j, int i2, Object obj) {
        int i3 = (i2 & 4) != 0 ? 300 : i;
        if ((i2 & 8) != 0) {
            j = 0;
        }
        loadingView.showLoading(z, animatorListenerAdapter, i3, j);
    }

    private final void startExecution() {
        synchronized (this.currentStateLock) {
            if (!this.isActive && !getPause()) {
                this.isActive = true;
                log("isActive true update");
                MotionLayout motionLayout = this.loadingViewLayout;
                MotionLayout motionLayout2 = null;
                if (motionLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    motionLayout = null;
                }
                motionLayout.setTransitionListener(this);
                log(Intrinsics.stringPlus("transition listener was set with state ", getCurrentState$jumio_defaultui_release().getViewState().name()));
                if (updateState()) {
                    MotionLayout motionLayout3 = this.loadingViewLayout;
                    if (motionLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    } else {
                        motionLayout2 = motionLayout3;
                    }
                    motionLayout2.transitionToEnd();
                } else {
                    MotionLayout motionLayout4 = this.loadingViewLayout;
                    if (motionLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    } else {
                        motionLayout2 = motionLayout4;
                    }
                    onTransitionCompleted(motionLayout2, 0);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        updateUi();
        r1 = r8.title;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0026, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("title");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        r1.sendAccessibilityEvent(8);
        r1 = r8.title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("title");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        r3 = r8.title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r3 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("title");
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        r1.announceForAccessibility(r3.getText());
        r1 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0[getCurrentState$jumio_defaultui_release().getViewState().ordinal()];
        r5 = com.taxis99.R.id.progress_start;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r1 == 1) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        if (r1 == 2) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006c, code lost:
        if (r1 == 3) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        r1 = r8.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r1 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        if (r8.animationState != com.jumio.defaultui.view.LoadingView.C20075a.f55036a) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0082, code lost:
        r5 = com.taxis99.R.id.progress_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0085, code lost:
        r2.setTransition(r5, com.taxis99.R.id.success);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008c, code lost:
        r1 = r8.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008e, code lost:
        if (r1 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0096, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009b, code lost:
        if (r8.animationState != com.jumio.defaultui.view.LoadingView.C20075a.f55036a) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009e, code lost:
        r5 = com.taxis99.R.id.progress_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a1, code lost:
        r2.setTransition(r5, com.taxis99.R.id.error);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a8, code lost:
        r1 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$1[r8.animationState.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        if (r1 == 1) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b4, code lost:
        if (r1 == 2) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b7, code lost:
        r8.animationState = com.jumio.defaultui.view.LoadingView.C20075a.f55036a;
        r1 = r8.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bd, code lost:
        if (r1 != null) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bf, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c5, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c6, code lost:
        r2.setTransition(com.taxis99.R.id.progress_end, com.taxis99.R.id.progress_start);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ca, code lost:
        r8.animationState = com.jumio.defaultui.view.LoadingView.C20075a.f55037b;
        r1 = r8.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d0, code lost:
        if (r1 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d2, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d8, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d9, code lost:
        r2.setTransition(com.taxis99.R.id.progress_start, com.taxis99.R.id.progress_end);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dc, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00df, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateState() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.currentStateLock
            monitor-enter(r0)
            java.lang.Object r1 = r8.nextStateLock     // Catch:{ all -> 0x00e3 }
            monitor-enter(r1)     // Catch:{ all -> 0x00e3 }
            com.jumio.defaultui.view.LoadingView$State r2 = r8.getCurrentState$jumio_defaultui_release()     // Catch:{ all -> 0x00e0 }
            com.jumio.defaultui.view.LoadingView$State r3 = r8.nextState     // Catch:{ all -> 0x00e0 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x0016
            r2 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)
            return r2
        L_0x0016:
            com.jumio.defaultui.view.LoadingView$State r2 = r8.nextState     // Catch:{ all -> 0x00e0 }
            r8.setCurrentState$jumio_defaultui_release(r2)     // Catch:{ all -> 0x00e0 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e0 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e3 }
            r8.updateUi()     // Catch:{ all -> 0x00e3 }
            android.widget.TextView r1 = r8.title     // Catch:{ all -> 0x00e3 }
            r2 = 0
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "title"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            r1 = r2
        L_0x002d:
            r3 = 8
            r1.sendAccessibilityEvent(r3)     // Catch:{ all -> 0x00e3 }
            android.widget.TextView r1 = r8.title     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "title"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            r1 = r2
        L_0x003d:
            android.widget.TextView r3 = r8.title     // Catch:{ all -> 0x00e3 }
            if (r3 != 0) goto L_0x0048
            java.lang.String r3 = "title"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ all -> 0x00e3 }
            r3 = r2
        L_0x0048:
            java.lang.CharSequence r3 = r3.getText()     // Catch:{ all -> 0x00e3 }
            r1.announceForAccessibility(r3)     // Catch:{ all -> 0x00e3 }
            com.jumio.defaultui.view.LoadingView$State r1 = r8.getCurrentState$jumio_defaultui_release()     // Catch:{ all -> 0x00e3 }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r1.getViewState()     // Catch:{ all -> 0x00e3 }
            int[] r3 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00e3 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x00e3 }
            r1 = r3[r1]     // Catch:{ all -> 0x00e3 }
            r3 = 2
            r4 = 1
            r5 = 2131433465(0x7f0b17f9, float:1.8488716E38)
            r6 = 2131433462(0x7f0b17f6, float:1.848871E38)
            if (r1 == r4) goto L_0x00a8
            if (r1 == r3) goto L_0x008c
            r3 = 3
            if (r1 == r3) goto L_0x0070
            goto L_0x00dc
        L_0x0070:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r8.loadingViewLayout     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x007a
            java.lang.String r1 = "loadingViewLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x007b
        L_0x007a:
            r2 = r1
        L_0x007b:
            com.jumio.defaultui.view.LoadingView$a r1 = r8.animationState     // Catch:{ all -> 0x00e3 }
            com.jumio.defaultui.view.LoadingView$a r3 = com.jumio.defaultui.view.LoadingView.C20075a.START     // Catch:{ all -> 0x00e3 }
            if (r1 != r3) goto L_0x0082
            goto L_0x0085
        L_0x0082:
            r5 = 2131433462(0x7f0b17f6, float:1.848871E38)
        L_0x0085:
            r1 = 2131434344(0x7f0b1b68, float:1.84905E38)
            r2.setTransition(r5, r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x00dc
        L_0x008c:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r8.loadingViewLayout     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x0096
            java.lang.String r1 = "loadingViewLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x0097
        L_0x0096:
            r2 = r1
        L_0x0097:
            com.jumio.defaultui.view.LoadingView$a r1 = r8.animationState     // Catch:{ all -> 0x00e3 }
            com.jumio.defaultui.view.LoadingView$a r3 = com.jumio.defaultui.view.LoadingView.C20075a.START     // Catch:{ all -> 0x00e3 }
            if (r1 != r3) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r5 = 2131433462(0x7f0b17f6, float:1.848871E38)
        L_0x00a1:
            r1 = 2131430533(0x7f0b0c85, float:1.848277E38)
            r2.setTransition(r5, r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x00dc
        L_0x00a8:
            com.jumio.defaultui.view.LoadingView$a r1 = r8.animationState     // Catch:{ all -> 0x00e3 }
            int[] r7 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$1     // Catch:{ all -> 0x00e3 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x00e3 }
            r1 = r7[r1]     // Catch:{ all -> 0x00e3 }
            if (r1 == r4) goto L_0x00ca
            if (r1 == r3) goto L_0x00b7
            goto L_0x00dc
        L_0x00b7:
            com.jumio.defaultui.view.LoadingView$a r1 = com.jumio.defaultui.view.LoadingView.C20075a.START     // Catch:{ all -> 0x00e3 }
            r8.animationState = r1     // Catch:{ all -> 0x00e3 }
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r8.loadingViewLayout     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x00c5
            java.lang.String r1 = "loadingViewLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x00c6
        L_0x00c5:
            r2 = r1
        L_0x00c6:
            r2.setTransition(r6, r5)     // Catch:{ all -> 0x00e3 }
            goto L_0x00dc
        L_0x00ca:
            com.jumio.defaultui.view.LoadingView$a r1 = com.jumio.defaultui.view.LoadingView.C20075a.END     // Catch:{ all -> 0x00e3 }
            r8.animationState = r1     // Catch:{ all -> 0x00e3 }
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r8.loadingViewLayout     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x00d8
            java.lang.String r1 = "loadingViewLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x00d9
        L_0x00d8:
            r2 = r1
        L_0x00d9:
            r2.setTransition(r5, r6)     // Catch:{ all -> 0x00e3 }
        L_0x00dc:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)
            return r4
        L_0x00e0:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e3 }
            throw r2     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.LoadingView.updateState():boolean");
    }

    private final void updateUi() {
        CharSequence charSequence;
        synchronized (this.currentStateLock) {
            TextView textView = this.title;
            AppCompatTextView appCompatTextView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setText(getHtmlStringFromId(Integer.valueOf(getCurrentState$jumio_defaultui_release().getTitleTextId())));
            AppCompatTextView appCompatTextView2 = this.description;
            if (appCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
                appCompatTextView2 = null;
            }
            if (getCurrentState$jumio_defaultui_release() instanceof ErrorState) {
                JumioError error = ((ErrorState) getCurrentState$jumio_defaultui_release()).getError();
                if (error == null || this.context == null) {
                    charSequence = "";
                } else {
                    charSequence = error.getMessage() + "\n(" + error.getCode() + VersionRange.RIGHT_OPEN;
                }
            } else {
                charSequence = getHtmlStringFromString(getCurrentState$jumio_defaultui_release().getDescriptionTextString());
            }
            appCompatTextView2.setText(charSequence);
            int i = WhenMappings.$EnumSwitchMapping$0[getCurrentState$jumio_defaultui_release().getViewState().ordinal()];
            if (i == 2) {
                ImageView imageView = this.ivLoadingGradient;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingGradient");
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.jumio_ic_loading_gradient_error);
                ImageView imageView2 = this.ivLoadingIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
                    imageView2 = null;
                }
                imageView2.setAlpha(1.0f);
            } else if (i != 3) {
                ImageView imageView3 = this.ivLoadingGradient;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingGradient");
                    imageView3 = null;
                }
                imageView3.setImageResource(R.drawable.jumio_ic_loading_gradient);
                ImageView imageView4 = this.ivLoadingIcon;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
                    imageView4 = null;
                }
                imageView4.setAlpha(0.0f);
                ImageView imageView5 = this.ivLoadingIcon;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
                    imageView5 = null;
                }
                imageView5.setScaleX(0.0f);
                ImageView imageView6 = this.ivLoadingIcon;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
                    imageView6 = null;
                }
                imageView6.setScaleY(0.0f);
                ImageView imageView7 = this.ivLoadingPlain;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingPlain");
                    imageView7 = null;
                }
                imageView7.setTranslationY(0.0f);
            } else {
                ImageView imageView8 = this.ivLoadingGradient;
                if (imageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingGradient");
                    imageView8 = null;
                }
                imageView8.setImageResource(R.drawable.jumio_ic_loading_gradient);
                ImageView imageView9 = this.ivLoadingIcon;
                if (imageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivLoadingIcon");
                    imageView9 = null;
                }
                imageView9.setAlpha(1.0f);
            }
            if (getCurrentState$jumio_defaultui_release().getButtonTextId() != 0) {
                MaterialButton materialButton = this.retryButton;
                if (materialButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retryButton");
                    materialButton = null;
                }
                materialButton.setText(getCurrentState$jumio_defaultui_release().getButtonTextId());
                MaterialButton materialButton2 = this.retryButton;
                if (materialButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retryButton");
                    materialButton2 = null;
                }
                materialButton2.setOnClickListener(getCurrentState$jumio_defaultui_release().getButtonOnClickListener());
            }
            MotionLayout motionLayout = this.loadingViewLayout;
            if (motionLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                motionLayout = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n\t        \t");
            TextView textView2 = this.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            sb.append(textView2.getText());
            sb.append("\n\t        \t");
            AppCompatTextView appCompatTextView3 = this.description;
            if (appCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
            } else {
                appCompatTextView = appCompatTextView3;
            }
            sb.append(appCompatTextView.getText());
            sb.append("\n\t        \t");
            motionLayout.setContentDescription(StringsKt.trimIndent(sb.toString()));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final State getCurrentState$jumio_defaultui_release() {
        return this.currentState;
    }

    public final boolean getPause() {
        return this.pause;
    }

    public final ViewState getViewState() {
        ViewState viewState;
        synchronized (this.nextStateLock) {
            viewState = this.nextState.getViewState();
        }
        return viewState;
    }

    public final synchronized void hide(AnimatorListenerAdapter animatorListenerAdapter, int i, long j) {
        showLoading(false, animatorListenerAdapter, i, j);
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        synchronized (this.currentStateLock) {
            log("onTransitionCompleted ; state: " + getCurrentState$jumio_defaultui_release().getViewState().name() + " ; and animationState: " + this.animationState.name() + " ; isActive: " + this.isActive);
            if (this.isActive) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[getCurrentState$jumio_defaultui_release().getViewState().ordinal()];
                MotionLayout motionLayout2 = null;
                if (i2 == 1) {
                    int i3 = WhenMappings.$EnumSwitchMapping$1[this.animationState.ordinal()];
                    if (i3 == 1) {
                        this.animationState = C20075a.END;
                        MotionLayout motionLayout3 = this.loadingViewLayout;
                        if (motionLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                            motionLayout3 = null;
                        }
                        motionLayout3.setTransition(R.id.progress_start, R.id.progress_end);
                    } else if (i3 == 2) {
                        this.animationState = C20075a.START;
                        MotionLayout motionLayout4 = this.loadingViewLayout;
                        if (motionLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                            motionLayout4 = null;
                        }
                        motionLayout4.setTransition(R.id.progress_end, R.id.progress_start);
                    }
                } else if (i2 == 2) {
                    this.isActive = false;
                    log("isActive false onTransitionComplete ERROR");
                    MaterialButton materialButton = this.retryButton;
                    if (materialButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("retryButton");
                        materialButton = null;
                    }
                    materialButton.setEnabled(true);
                    animateLoadingIcon();
                } else if (i2 == 3) {
                    this.isActive = false;
                    log("isActive false onTransitionComplete SUCCESS");
                    animateLoadingIcon();
                }
                updateState();
                if (this.isActive) {
                    log("after transition completion state: " + getCurrentState$jumio_defaultui_release().getViewState().name() + " ; and animationState: " + this.animationState.name() + ", animation still active");
                    MotionLayout motionLayout5 = this.loadingViewLayout;
                    if (motionLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                    } else {
                        motionLayout2 = motionLayout5;
                    }
                    motionLayout2.transitionToEnd();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
        synchronized (this.currentStateLock) {
            log("onTransitionStarted ; state: " + getCurrentState$jumio_defaultui_release().getViewState().name() + " ; and animationState: " + this.animationState.name() + " ; isActive: " + this.isActive);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
        synchronized (this.currentStateLock) {
            log("onTransitionTriggered ; state: " + getCurrentState$jumio_defaultui_release().getViewState().name() + " ; isActive: " + this.isActive);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setCurrentState$jumio_defaultui_release(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.currentState = state;
    }

    public final void setPause(boolean z) {
        this.pause = z;
        if (this.nextState.getViewState() != ViewState.STOPPED) {
            startExecution();
        }
    }

    public final synchronized void show(AnimatorListenerAdapter animatorListenerAdapter, int i, long j) {
        showLoading(true, animatorListenerAdapter, i, j);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.google.android.material.button.MaterialButton] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void update(com.jumio.defaultui.view.LoadingView.State r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r0.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "update called with state "
            r0.append(r1)     // Catch:{ all -> 0x00ac }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r6.getViewState()     // Catch:{ all -> 0x00ac }
            r0.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = ", current state is "
            r0.append(r1)     // Catch:{ all -> 0x00ac }
            com.jumio.defaultui.view.LoadingView$State r1 = r5.currentState     // Catch:{ all -> 0x00ac }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r1.getViewState()     // Catch:{ all -> 0x00ac }
            r0.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ac }
            r5.log(r0)     // Catch:{ all -> 0x00ac }
            java.lang.Object r0 = r5.currentStateLock     // Catch:{ all -> 0x00ac }
            monitor-enter(r0)     // Catch:{ all -> 0x00ac }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r6.getViewState()     // Catch:{ all -> 0x00a9 }
            int[] r2 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00a9 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x00a9 }
            r1 = r2[r1]     // Catch:{ all -> 0x00a9 }
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L_0x0079
            r4 = 2
            if (r1 == r4) goto L_0x005a
            r2 = 3
            if (r1 == r2) goto L_0x0048
            goto L_0x0096
        L_0x0048:
            android.widget.ImageView r1 = r5.ivLoadingIcon     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0052
            java.lang.String r1 = "ivLoadingIcon"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x0053
        L_0x0052:
            r3 = r1
        L_0x0053:
            r1 = 2131234166(0x7f080d76, float:1.808449E38)
            r3.setImageResource(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x0096
        L_0x005a:
            com.google.android.material.button.MaterialButton r1 = r5.retryButton     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0064
            java.lang.String r1 = "retryButton"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a9 }
            r1 = r3
        L_0x0064:
            r1.setEnabled(r2)     // Catch:{ all -> 0x00a9 }
            android.widget.ImageView r1 = r5.ivLoadingIcon     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0071
            java.lang.String r1 = "ivLoadingIcon"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x0072
        L_0x0071:
            r3 = r1
        L_0x0072:
            r1 = 2131234167(0x7f080d77, float:1.8084492E38)
            r3.setImageResource(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x0096
        L_0x0079:
            com.google.android.material.button.MaterialButton r1 = r5.retryButton     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0083
            java.lang.String r1 = "retryButton"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a9 }
            r1 = r3
        L_0x0083:
            r2 = 0
            r1.setEnabled(r2)     // Catch:{ all -> 0x00a9 }
            com.google.android.material.button.MaterialButton r1 = r5.retryButton     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0091
            java.lang.String r1 = "retryButton"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x0092
        L_0x0091:
            r3 = r1
        L_0x0092:
            r1 = 0
            r3.setAlpha(r1)     // Catch:{ all -> 0x00a9 }
        L_0x0096:
            java.lang.Object r1 = r5.nextStateLock     // Catch:{ all -> 0x00a9 }
            monitor-enter(r1)     // Catch:{ all -> 0x00a9 }
            r5.nextState = r6     // Catch:{ all -> 0x00a6 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            r5.startExecution()     // Catch:{ all -> 0x00a9 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            monitor-exit(r5)
            return
        L_0x00a6:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            throw r6     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            throw r6     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.LoadingView.update(com.jumio.defaultui.view.LoadingView$State):void");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, mo175978d2 = {"Lcom/jumio/defaultui/view/LoadingView$State;", "Ljava/io/Serializable;", "", "other", "", "equals", "Lcom/jumio/defaultui/view/LoadingView$ViewState;", "viewState", "Lcom/jumio/defaultui/view/LoadingView$ViewState;", "getViewState", "()Lcom/jumio/defaultui/view/LoadingView$ViewState;", "", "titleTextId", "I", "getTitleTextId", "()I", "", "descriptionTextString", "Ljava/lang/String;", "getDescriptionTextString", "()Ljava/lang/String;", "setDescriptionTextString", "(Ljava/lang/String;)V", "buttonTextId", "getButtonTextId", "Landroid/view/View$OnClickListener;", "buttonOnClickListener", "Landroid/view/View$OnClickListener;", "getButtonOnClickListener", "()Landroid/view/View$OnClickListener;", "<init>", "(Lcom/jumio/defaultui/view/LoadingView$ViewState;ILjava/lang/String;ILandroid/view/View$OnClickListener;)V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: LoadingView.kt */
    public static class State implements Serializable {
        private final transient View.OnClickListener buttonOnClickListener;
        private final int buttonTextId;
        private String descriptionTextString;
        private final int titleTextId;
        private final ViewState viewState;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public State(ViewState viewState2) {
            this(viewState2, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(viewState2, "viewState");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public State(ViewState viewState2, int i) {
            this(viewState2, i, (String) null, 0, (View.OnClickListener) null, 28, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(viewState2, "viewState");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public State(ViewState viewState2, int i, String str) {
            this(viewState2, i, str, 0, (View.OnClickListener) null, 24, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(viewState2, "viewState");
            Intrinsics.checkNotNullParameter(str, "descriptionTextString");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public State(ViewState viewState2, int i, String str, int i2) {
            this(viewState2, i, str, i2, (View.OnClickListener) null, 16, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(viewState2, "viewState");
            Intrinsics.checkNotNullParameter(str, "descriptionTextString");
        }

        public State(ViewState viewState2, int i, String str, int i2, View.OnClickListener onClickListener) {
            Intrinsics.checkNotNullParameter(viewState2, "viewState");
            Intrinsics.checkNotNullParameter(str, "descriptionTextString");
            this.viewState = viewState2;
            this.titleTextId = i;
            this.descriptionTextString = str;
            this.buttonTextId = i2;
            this.buttonOnClickListener = onClickListener;
        }

        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State state = (State) obj;
                return this.viewState == state.viewState && this.titleTextId == state.titleTextId && Intrinsics.areEqual((Object) this.descriptionTextString, (Object) state.descriptionTextString) && getButtonTextId() == state.getButtonTextId();
            }
        }

        public final View.OnClickListener getButtonOnClickListener() {
            return this.buttonOnClickListener;
        }

        public int getButtonTextId() {
            return this.buttonTextId;
        }

        public final String getDescriptionTextString() {
            return this.descriptionTextString;
        }

        public final int getTitleTextId() {
            return this.titleTextId;
        }

        public final ViewState getViewState() {
            return this.viewState;
        }

        public final void setDescriptionTextString(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.descriptionTextString = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(ViewState viewState2, int i, String str, int i2, View.OnClickListener onClickListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewState2, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? null : onClickListener);
        }
    }
}
