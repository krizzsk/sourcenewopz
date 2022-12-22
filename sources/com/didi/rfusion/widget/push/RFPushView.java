package com.didi.rfusion.widget.push;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFSystemBarUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.SofaAnimatorCompat;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010$\u001a\u00020\u00192\b\b\u0001\u0010'\u001a\u00020\u0007J\u0010\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010*\u001a\u00020\u00192\b\b\u0001\u0010'\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u00192\b\b\u0001\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\u0019R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPushView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearAnimator", "Lcom/didichuxing/sofa/animation/Animator;", "disappearAnimator", "ivIcon", "Landroid/widget/ImageView;", "llContainer", "mDownY", "", "mTouchSlop", "onDismissListener", "Lcom/didi/rfusion/widget/push/RFPushView$OnDismissListener;", "tvText", "Lcom/didi/rfusion/widget/RFTextView;", "viewLine", "Landroid/view/View;", "dismiss", "", "doAppear", "doDisappear", "initView", "onDetachedFromWindow", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setOnDismissListener", "listener", "setText", "content", "", "setType", "type", "show", "Companion", "OnDismissListener", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFPushView.kt */
public final class RFPushView extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final int f33672j = 400;

    /* renamed from: a */
    private LinearLayout f33673a;

    /* renamed from: b */
    private View f33674b;

    /* renamed from: c */
    private ImageView f33675c;

    /* renamed from: d */
    private RFTextView f33676d;

    /* renamed from: e */
    private float f33677e;

    /* renamed from: f */
    private float f33678f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnDismissListener f33679g;

    /* renamed from: h */
    private Animator f33680h;

    /* renamed from: i */
    private Animator f33681i;

    /* renamed from: k */
    private HashMap f33682k;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPushView$OnDismissListener;", "", "onDismiss", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFPushView.kt */
    public interface OnDismissListener {
        void onDismiss();
    }

    public RFPushView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFPushView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33682k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33682k == null) {
            this.f33682k = new HashMap();
        }
        View view = (View) this.f33682k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33682k.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFPushView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFPushView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f33678f = -1.0f;
        setOrientation(1);
        LinearLayout.inflate(context, R.layout.rf_view_push, this);
        m23717a();
        setType(0);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/rfusion/widget/push/RFPushView$Companion;", "", "()V", "ANIMATION_DURATION", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFPushView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final void m23717a() {
        View findViewById = findViewById(R.id.rf_iv_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_iv_icon)");
        this.f33675c = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.rf_tv_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_tv_text)");
        this.f33676d = (RFTextView) findViewById2;
        View findViewById3 = findViewById(R.id.rf_ll_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.rf_ll_container)");
        this.f33673a = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.rf_view_line);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.rf_view_line)");
        this.f33674b = findViewById4;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f33678f >= ((float) 0)) {
            return true;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
        this.f33678f = (float) (viewConfiguration.getScaledTouchSlop() * 3);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "event");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f33677e = motionEvent.getY();
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                float y = motionEvent.getY() - this.f33677e;
                if (y < ((float) 0) && Math.abs(y) > this.f33678f) {
                    m23719c();
                    return false;
                }
            }
        } else if (Math.abs(motionEvent.getY() - this.f33677e) < this.f33678f) {
            performClick();
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f33680h;
        if (animator != null) {
            animator.stop();
        }
        Animator animator2 = this.f33681i;
        if (animator2 != null) {
            animator2.stop();
        }
    }

    public final void show() {
        m23718b();
    }

    public final void dismiss() {
        m23719c();
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f33679g = onDismissListener;
    }

    /* renamed from: b */
    private final void m23718b() {
        Animator animator = this.f33680h;
        if (animator != null) {
            if (animator == null) {
                Intrinsics.throwNpe();
            }
            if (animator.isRunning()) {
                return;
            }
        }
        Animator build = SofaAnimatorCompat.play(this).translateY((float) (getHeight() * -1), (float) 0).duration(400).withListener(new RFPushView$doAppear$listener$1(this)).build();
        this.f33680h = build;
        if (build == null) {
            Intrinsics.throwNpe();
        }
        build.start();
    }

    /* renamed from: c */
    private final void m23719c() {
        Animator animator = this.f33681i;
        if (animator != null) {
            if (animator == null) {
                Intrinsics.throwNpe();
            }
            if (animator.isRunning()) {
                return;
            }
        }
        Animator build = SofaAnimatorCompat.play(this).translateY((float) 0, (float) ((getHeight() + RFSystemBarUtils.getStatusBarHeight(getContext())) * -1)).duration(400).withListener(new RFPushView$doDisappear$listener$1(this)).build();
        this.f33681i = build;
        if (build == null) {
            Intrinsics.throwNpe();
        }
        build.start();
    }

    public final void setIcon(int i) {
        ImageView imageView = this.f33675c;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.f33675c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        imageView2.setImageDrawable(RFResUtils.getDrawable(i));
    }

    public final void setIcon(Drawable drawable) {
        if (drawable == null) {
            ImageView imageView = this.f33675c;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f33675c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        imageView2.setVisibility(0);
        ImageView imageView3 = this.f33675c;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        }
        imageView3.setImageDrawable(drawable);
    }

    public final void setText(int i) {
        RFTextView rFTextView = this.f33676d;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        rFTextView.setText(i);
    }

    public final void setType(int i) {
        if (i != 1) {
            LinearLayout linearLayout = this.f33673a;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llContainer");
            }
            linearLayout.setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_white_100_FFFFFF));
            RFTextView rFTextView = this.f33676d;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvText");
            }
            rFTextView.setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000));
            View view = this.f33674b;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewLine");
            }
            view.setBackground(RFResUtils.getDrawable(getContext(), R.drawable.rf_shape_push_bottom_line_light));
            return;
        }
        LinearLayout linearLayout2 = this.f33673a;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContainer");
        }
        linearLayout2.setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_brands_3_25_333740));
        RFTextView rFTextView2 = this.f33676d;
        if (rFTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        rFTextView2.setTextColor(RFResUtils.getColor(getContext(), R.color.rf_color_white_100_FFFFFF));
        View view2 = this.f33674b;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewLine");
        }
        view2.setBackground(RFResUtils.getDrawable(getContext(), R.drawable.rf_shape_push_bottom_line_dark));
    }

    public final void setText(CharSequence charSequence) {
        RFTextView rFTextView = this.f33676d;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        rFTextView.setText(charSequence);
    }
}
