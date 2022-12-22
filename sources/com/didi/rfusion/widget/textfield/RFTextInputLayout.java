package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.didi.app.nova.support.util.ViewUtils;
import com.didi.passenger.C10448R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.material.internal.RFCheckableImageButton;
import com.didi.rfusion.material.internal.RFCollapsingTextHelper;
import com.didi.rfusion.material.internal.RFDescendantOffsetUtils;
import com.didi.rfusion.utils.RFFontUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.textfield.drawable.RFCutoutDrawable;
import com.didi.rfusion.widget.textfield.drawable.RFUnderlineDrawable;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RFTextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int BOX_BACKGROUND_UNDERLINE = 1;
    public static final int COUNTER_INNER = 0;
    public static final int COUNTER_OUTER = 1;
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
        public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SavedState(parcel, classLoader);
        }

        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel, (ClassLoader) null);
        }

        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    };
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;

    /* renamed from: c */
    private static final String f33785c = "RFTextField";

    /* renamed from: d */
    private static final int f33786d = -1;

    /* renamed from: e */
    private static final float f33787e = 0.75f;

    /* renamed from: f */
    private static final int f33788f = 167;

    /* renamed from: g */
    private static final int f33789g = -1;

    /* renamed from: h */
    private static final int f33790h = 0;

    /* renamed from: A */
    private final SparseArray<C11578b> f33791A;

    /* renamed from: B */
    private final LinkedHashSet<OnEndIconChangedListener> f33792B;

    /* renamed from: C */
    private ValueAnimator f33793C;

    /* renamed from: D */
    private final Rect f33794D;

    /* renamed from: E */
    private final Rect f33795E;

    /* renamed from: F */
    private final RectF f33796F;

    /* renamed from: G */
    private boolean f33797G;

    /* renamed from: H */
    private boolean f33798H;

    /* renamed from: I */
    private boolean f33799I;

    /* renamed from: J */
    private boolean f33800J;

    /* renamed from: K */
    private boolean f33801K;

    /* renamed from: L */
    private boolean f33802L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f33803M;

    /* renamed from: N */
    private boolean f33804N;

    /* renamed from: O */
    private Drawable f33805O;

    /* renamed from: P */
    private int f33806P;

    /* renamed from: Q */
    private Drawable f33807Q;

    /* renamed from: R */
    private Drawable f33808R;

    /* renamed from: S */
    private int f33809S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public boolean f33810T;

    /* renamed from: U */
    private int f33811U;

    /* renamed from: V */
    private int f33812V;

    /* renamed from: W */
    private int f33813W;

    /* renamed from: X */
    private int f33814X;

    /* renamed from: Y */
    private int f33815Y;

    /* renamed from: Z */
    private int f33816Z;

    /* renamed from: a */
    EditText f33817a;

    /* renamed from: aA */
    private CharSequence f33818aA;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public boolean f33819aB;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public boolean f33820aC;

    /* renamed from: aD */
    private int f33821aD;

    /* renamed from: aE */
    private boolean f33822aE;

    /* renamed from: aF */
    private boolean f33823aF;

    /* renamed from: aG */
    private CharSequence f33824aG;

    /* renamed from: aH */
    private CharSequence f33825aH;

    /* renamed from: aI */
    private CharSequence f33826aI;

    /* renamed from: aJ */
    private CharSequence f33827aJ;

    /* renamed from: aK */
    private int f33828aK;

    /* renamed from: aL */
    private View.OnLongClickListener f33829aL;

    /* renamed from: aM */
    private Drawable f33830aM;

    /* renamed from: aN */
    private boolean f33831aN;

    /* renamed from: aa */
    private int f33832aa;

    /* renamed from: ab */
    private int f33833ab;

    /* renamed from: ac */
    private int f33834ac;

    /* renamed from: ad */
    private int f33835ad;

    /* renamed from: ae */
    private int f33836ae;

    /* renamed from: af */
    private int f33837af;

    /* renamed from: ag */
    private int f33838ag;

    /* renamed from: ah */
    private int f33839ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public GradientDrawable f33840ai;

    /* renamed from: aj */
    private ValueAnimator f33841aj;

    /* renamed from: ak */
    private ColorStateList f33842ak;

    /* renamed from: al */
    private ColorStateList f33843al;

    /* renamed from: am */
    private ColorStateList f33844am;

    /* renamed from: an */
    private int f33845an;

    /* renamed from: ao */
    private int f33846ao;

    /* renamed from: ap */
    private ColorStateList f33847ap;

    /* renamed from: aq */
    private int f33848aq;

    /* renamed from: ar */
    private int f33849ar;

    /* renamed from: as */
    private int f33850as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public int f33851at;

    /* renamed from: au */
    private ColorStateList f33852au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public int f33853av;

    /* renamed from: aw */
    private int f33854aw;

    /* renamed from: ax */
    private ColorStateList f33855ax;

    /* renamed from: ay */
    private ColorStateList f33856ay;

    /* renamed from: az */
    private ColorStateList f33857az;

    /* renamed from: b */
    final RFCollapsingTextHelper f33858b;

    /* renamed from: i */
    private LinearLayout f33859i;

    /* renamed from: j */
    private FrameLayout f33860j;

    /* renamed from: k */
    private LinearLayout f33861k;

    /* renamed from: l */
    private FrameLayout f33862l;

    /* renamed from: m */
    private LinearLayout f33863m;

    /* renamed from: n */
    private FrameLayout f33864n;

    /* renamed from: o */
    private LinearLayout f33865o;

    /* renamed from: p */
    private RFCheckableImageButton f33866p;

    /* renamed from: q */
    private RFCheckableIconButton f33867q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public RFCheckableIconButton f33868r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RFCheckableImageButton f33869s;

    /* renamed from: t */
    private RFTextView f33870t;

    /* renamed from: u */
    private RFTextView f33871u;

    /* renamed from: v */
    private RFTextView f33872v;

    /* renamed from: w */
    private RFTextView f33873w;

    /* renamed from: x */
    private final C11579c f33874x;

    /* renamed from: y */
    private final LinkedHashSet<OnEditTextAttachedListener> f33875y;

    /* renamed from: z */
    private C11577a f33876z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CounterLocation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(RFTextInputLayout rFTextInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(RFTextInputLayout rFTextInputLayout, int i);
    }

    public RFTextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.f33874x = new C11579c(this);
        this.f33858b = new RFCollapsingTextHelper(this);
        this.f33875y = new LinkedHashSet<>();
        this.f33791A = new SparseArray<>();
        this.f33792B = new LinkedHashSet<>();
        this.f33794D = new Rect();
        this.f33795E = new Rect();
        this.f33796F = new RectF();
        this.f33811U = -1;
        this.f33812V = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        inflate(getContext(), R.layout.rf_text_input, this);
        m23839j();
        m23840k();
        m23838i();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFTextInputLayout);
        String string = obtainStyledAttributes.getString(14);
        String string2 = obtainStyledAttributes.getString(15);
        String string3 = obtainStyledAttributes.getString(13);
        String string4 = obtainStyledAttributes.getString(3);
        String string5 = obtainStyledAttributes.getString(11);
        boolean z = obtainStyledAttributes.getBoolean(7, false);
        int i2 = obtainStyledAttributes.getInt(8, 1);
        int i3 = obtainStyledAttributes.getInt(9, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(12, false);
        boolean z3 = obtainStyledAttributes.getBoolean(6, true);
        int i4 = obtainStyledAttributes.getInt(5, 1);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(4);
        setInnerEndIconMode(z2 ? 1 : 0);
        setEnableClearText(z3);
        setHint((CharSequence) string4);
        setDefaultHintTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setHintTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_1_0_000000));
        setHelperTextEnabled(false);
        setHelperTextTextAppearance(R.style.rf_text_field_helper);
        setHelperTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setHelperText(string5);
        setErrorIconEnabled(true);
        setErrorEnabled(false);
        setErrorTextAppearance(R.style.rf_text_field_error);
        setErrorTextColor(RFResUtils.getColorStateList(R.color.rf_color_alert_red_100_FF4E45));
        setCounterEnabled(z);
        setCounterLocation(i2);
        setCounterTextAppearance(R.style.rf_text_field_counter);
        setCounterMaxLength(i3);
        setCounterTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setCounterOverflowTextColor(RFResUtils.getColorStateList(R.color.rf_color_alert_red_100_FF4E45));
        setCounterOverflowTextAppearance(R.style.rf_text_field_counter_overflow);
        setPlaceholderTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setPlaceholderTextAppearance(R.style.rf_text_field_placeholder);
        setPlaceholderText(string3);
        setPrefixText(string);
        setPrefixTextAppearance(R.style.rf_text_field_prefix);
        setPrefixTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setSuffixText(string2);
        setSuffixTextAppearance(R.style.rf_text_field_suffix);
        setSuffixTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setMinWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(1, -1));
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        setBoxBackgroundMode(i4);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.f33815Y = defaultColor;
            this.f33814X = defaultColor;
            this.f33816Z = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f33832aa = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
            this.f33833ab = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        } else {
            this.f33814X = 0;
            this.f33815Y = 0;
            this.f33816Z = 0;
            this.f33832aa = 0;
            this.f33833ab = 0;
        }
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
        Drawable drawable = RFResUtils.getDrawable(context2, R.drawable.rf_icon_tip);
        this.f33830aM = drawable;
        drawable.setBounds(0, 0, (int) RFResUtils.getDimens(context2, R.dimen.rf_dimen_32), (int) RFResUtils.getDimens(context2, R.dimen.rf_dimen_32));
    }

    /* renamed from: i */
    private void m23838i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f33841aj = ofFloat;
        ofFloat.setDuration(100);
        this.f33841aj.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ((RFUnderlineDrawable) RFTextInputLayout.this.f33840ai).setStreamProgress(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                RFTextInputLayout rFTextInputLayout = RFTextInputLayout.this;
                int unused = rFTextInputLayout.f33853av = rFTextInputLayout.f33851at;
                boolean unused2 = RFTextInputLayout.this.f33810T = true;
                ((RFUnderlineDrawable) RFTextInputLayout.this.f33840ai).completeStream();
            }
        });
        this.f33841aj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFTextInputLayout.this.m23813a(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23813a(ValueAnimator valueAnimator) {
        ((RFUnderlineDrawable) this.f33840ai).setStreamProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: j */
    private void m23839j() {
        this.f33859i = (LinearLayout) findViewById(R.id.rf_ll_frame);
        this.f33860j = (FrameLayout) findViewById(R.id.rf_fl_input_frame);
        this.f33861k = (LinearLayout) findViewById(R.id.rf_ll_start_layout);
        this.f33862l = (FrameLayout) findViewById(R.id.rf_fl_start_outer_frame);
        this.f33863m = (LinearLayout) findViewById(R.id.rf_ll_end_layout);
        this.f33864n = (FrameLayout) findViewById(R.id.rf_fl_inner_end_icon_frame);
        this.f33865o = (LinearLayout) findViewById(R.id.rf_ll_normal_end_icon_container);
        this.f33866p = (RFCheckableImageButton) findViewById(R.id.rf_cib_error_icon);
        this.f33869s = (RFCheckableImageButton) findViewById(R.id.rf_cib_outer_end_icon);
        this.f33870t = (RFTextView) findViewById(R.id.rf_tv_prefix);
        this.f33871u = (RFTextView) findViewById(R.id.rf_tv_suffix);
        this.f33867q = (RFCheckableIconButton) findViewById(R.id.rf_cib_clear_icon);
        this.f33868r = (RFCheckableIconButton) findViewById(R.id.rf_cib_inner_end_icon);
        this.f33859i.setAddStatesFromChildren(true);
        this.f33860j.setAddStatesFromChildren(true);
        ViewCompat.setAccessibilityLiveRegion(this.f33870t, 1);
        ViewCompat.setAccessibilityLiveRegion(this.f33871u, 1);
    }

    /* renamed from: k */
    private void m23840k() {
        this.f33799I = true;
        this.f33798H = true;
        this.f33797G = true;
        this.f33823aF = true;
        this.f33837af = 1;
        this.f33838ag = 1;
        this.f33836ae = 1;
        this.f33834ac = getContext().getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        RFResUtils.getColorStateList(getContext(), R.color.rf_color_gery_17_0_33000000);
        this.f33851at = RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000);
        this.f33849ar = RFResUtils.getColor(getContext(), R.color.rf_color_gery_17_0_33000000);
        this.f33854aw = RFResUtils.getColor(getContext(), R.color.rf_color_gery_3_60);
        this.f33850as = RFResUtils.getColor(getContext(), R.color.rf_color_gery_13_0_B3000000);
        setBoxStrokeErrorColor(RFResUtils.getColorStateList(getContext(), R.color.rf_color_alert_red_100_FF4E45));
        this.f33791A.append(1, new C11581e(this));
        this.f33791A.append(0, new C11580d(this));
        this.f33876z = new C11577a(this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f33817a;
        if (editText != null) {
            Rect rect = this.f33794D;
            RFDescendantOffsetUtils.getDescendantRect(this, editText, rect);
            if (this.f33823aF) {
                this.f33858b.setCollapsedTextSize(this.f33817a.getTextSize() * 0.75f);
                this.f33858b.setTypefaces(RFFontUtils.getFontTypeFace(getContext(), 3));
                this.f33858b.setExpandedTextSize(this.f33817a.getTextSize());
                m23850u();
                int gravity = this.f33817a.getGravity();
                this.f33858b.setCollapsedTextGravity((gravity & Const.iDefCgiSig) | 48);
                this.f33858b.setExpandedTextGravity(gravity);
                this.f33858b.setCollapsedBounds(m23811a(rect));
                this.f33858b.setExpandedBounds(m23825b(rect));
                this.f33858b.recalculate();
                if (m23796O() && !this.f33800J) {
                    m23797P();
                }
            }
        }
    }

    /* renamed from: a */
    private Rect m23811a(Rect rect) {
        if (this.f33817a != null) {
            Rect rect2 = this.f33795E;
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i = this.f33813W;
            if (i == 1) {
                rect2.left = m23807a(rect.left, z);
                rect2.top = rect.top - m23841l();
                rect2.right = m23823b(rect.right, z);
            } else if (i != 2) {
                rect2.left = m23807a(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = m23823b(rect.right, z);
            } else {
                rect2.left = rect.left + this.f33817a.getPaddingLeft();
                rect2.top = rect.top - m23841l();
                rect2.right = rect.right - this.f33817a.getPaddingRight();
            }
            return rect2;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    private Rect m23825b(Rect rect) {
        if (this.f33817a != null) {
            Rect rect2 = this.f33795E;
            float expandedTextHeight = this.f33858b.getExpandedTextHeight();
            rect2.left = rect.left + this.f33817a.getCompoundPaddingLeft();
            rect2.top = m23808a(rect, expandedTextHeight);
            rect2.right = rect.right - this.f33817a.getCompoundPaddingRight();
            rect2.bottom = m23809a(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    /* renamed from: l */
    private int m23841l() {
        float collapsedTextHeight;
        if (!this.f33823aF) {
            return 0;
        }
        int i = this.f33813W;
        if (i == 1) {
            collapsedTextHeight = this.f33858b.getCollapsedTextHeight();
        } else if (i != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.f33858b.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    /* renamed from: a */
    private int m23808a(Rect rect, float f) {
        return rect.top + this.f33817a.getCompoundPaddingTop();
    }

    /* renamed from: a */
    private int m23809a(Rect rect, Rect rect2, float f) {
        return rect.bottom - this.f33817a.getCompoundPaddingBottom();
    }

    /* renamed from: m */
    private boolean m23842m() {
        return this.f33817a.getMinLines() <= 1;
    }

    /* renamed from: a */
    private int m23807a(int i, boolean z) {
        return i + this.f33817a.getPaddingLeft();
    }

    /* renamed from: b */
    private int m23823b(int i, boolean z) {
        return i - this.f33817a.getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        ViewGroup.LayoutParams layoutParams = this.f33859i.getLayoutParams();
        if (mode == 1073741824) {
            if (layoutParams.height != 0) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
                layoutParams2.weight = 1.0f;
                layoutParams2.height = 0;
                this.f33859i.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams.height != -2) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(layoutParams);
            layoutParams3.weight = 0.0f;
            layoutParams3.height = -2;
            this.f33859i.setLayoutParams(layoutParams3);
        }
        super.onMeasure(i, i2);
        boolean n = m23843n();
        boolean V = m23803V();
        if (n || V) {
            this.f33817a.post(new Runnable() {
                public final void run() {
                    RFTextInputLayout.this.m23806Y();
                }
            });
        }
        m23844o();
        m23852w();
        m23853x();
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void m23806Y() {
        this.f33817a.requestLayout();
    }

    /* renamed from: n */
    private boolean m23843n() {
        int max;
        if (this.f33817a == null || this.f33817a.getMeasuredHeight() >= (max = Math.max(this.f33863m.getMeasuredHeight(), this.f33861k.getMeasuredHeight()))) {
            return false;
        }
        this.f33817a.setMinimumHeight(max);
        return true;
    }

    /* renamed from: o */
    private void m23844o() {
        EditText editText;
        if (this.f33873w != null && (editText = this.f33817a) != null) {
            this.f33873w.setGravity(editText.getGravity());
            this.f33873w.setPadding(this.f33817a.getCompoundPaddingLeft(), this.f33817a.getCompoundPaddingTop(), this.f33817a.getCompoundPaddingRight(), this.f33817a.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.f33804N) {
            boolean z = true;
            this.f33804N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            RFCollapsingTextHelper rFCollapsingTextHelper = this.f33858b;
            boolean state = rFCollapsingTextHelper != null ? rFCollapsingTextHelper.setState(drawableState) | false : false;
            if (this.f33817a != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z = false;
                }
                mo88278a(z);
            }
            mo88272a();
            mo88289e();
            if (state) {
                invalidate();
            }
            this.f33804N = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88272a() {
        if (m23845p()) {
            ViewCompat.setBackground(this.f33859i, this.f33840ai);
        }
    }

    /* renamed from: p */
    private boolean m23845p() {
        EditText editText = this.f33817a;
        return (editText == null || this.f33840ai == null || editText.getBackground() != null) ? false : true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m23814a(canvas);
    }

    /* renamed from: a */
    private void m23814a(Canvas canvas) {
        if (!this.f33823aF) {
            return;
        }
        if (isCollapsedHintEnabled() || this.f33800J) {
            this.f33858b.draw(canvas);
        }
    }

    public int getBaseline() {
        EditText editText = this.f33817a;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + m23841l();
        }
        return super.getBaseline();
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & Const.iDefCgiSig) | 16;
            this.f33860j.addView(view, layoutParams2);
            this.f33859i.setLayoutParams(layoutParams);
            m23850u();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setEnabled(boolean z) {
        m23816a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    /* renamed from: a */
    private static void m23816a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m23816a((ViewGroup) childAt, z);
            }
        }
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.f33813W) {
            this.f33813W = i;
            if (this.f33817a != null) {
                m23846q();
            }
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f33814X != i) {
            this.f33814X = i;
            this.f33815Y = i;
            this.f33832aa = i;
            this.f33833ab = i;
            m23790I();
        }
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f33815Y = defaultColor;
        this.f33814X = defaultColor;
        this.f33816Z = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f33832aa = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f33833ab = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        m23790I();
    }

    public int getBoxBackgroundMode() {
        return this.f33813W;
    }

    public int getBoxBackgroundColor() {
        return this.f33814X;
    }

    public void setCounterLocation(int i) {
        if (i != this.f33839ah) {
            if (!isCounterEnabled()) {
                this.f33839ah = i;
                return;
            }
            setCounterEnabled(false);
            this.f33839ah = i;
            setCounterEnabled(true);
        }
    }

    public int getCounterLocation() {
        return this.f33839ah;
    }

    /* renamed from: q */
    private void m23846q() {
        m23847r();
        mo88272a();
        mo88289e();
        m23848s();
        m23850u();
    }

    /* renamed from: r */
    private void m23847r() {
        int i = this.f33813W;
        if (i == 1) {
            this.f33840ai = new RFUnderlineDrawable();
        } else if (i != 2) {
            throw new IllegalArgumentException(this.f33813W + " is illegal; only @BoxBackgroundMode constants are supported.");
        } else if (!this.f33823aF || (this.f33840ai instanceof RFCutoutDrawable)) {
            this.f33840ai = new GradientDrawable();
        } else {
            this.f33840ai = new RFCutoutDrawable();
        }
    }

    /* renamed from: s */
    private void m23848s() {
        EditText editText = this.f33817a;
        if (editText != null) {
            int i = this.f33813W;
            if (i == 1) {
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_16), ViewCompat.getPaddingEnd(this.f33817a), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_20));
            } else if (i == 2) {
                ViewCompat.setPaddingRelative(editText, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24));
            }
        }
    }

    private void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f33852au != colorStateList) {
            this.f33852au = colorStateList;
            mo88289e();
        }
    }

    private void setHelperTextTextAppearance(int i) {
        this.f33874x.mo88404c(i);
    }

    private void setHelperTextColor(ColorStateList colorStateList) {
        this.f33874x.mo88399b(colorStateList);
    }

    private void setErrorTextAppearance(int i) {
        this.f33874x.mo88398b(i);
    }

    private void setErrorTextColor(ColorStateList colorStateList) {
        this.f33874x.mo88391a(colorStateList);
    }

    private void setCounterTextAppearance(int i) {
        if (this.f33845an != i) {
            this.f33845an = i;
            m23849t();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f33843al != colorStateList) {
            this.f33843al = colorStateList;
            m23849t();
        }
    }

    /* renamed from: t */
    private void m23849t() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        RFTextView rFTextView = this.f33872v;
        if (rFTextView != null) {
            mo88275a(rFTextView, this.f33822aE ? this.f33846ao : this.f33845an);
            if (!this.f33822aE && (colorStateList2 = this.f33843al) != null) {
                this.f33872v.setTextColor(colorStateList2);
            }
            if (this.f33822aE && (colorStateList = this.f33844am) != null) {
                this.f33872v.setTextColor(colorStateList);
            }
        }
    }

    private void setCounterOverflowTextAppearance(int i) {
        if (this.f33846ao != i) {
            this.f33846ao = i;
            m23849t();
        }
    }

    private void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f33844am != colorStateList) {
            this.f33844am = colorStateList;
            m23849t();
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintTextAppearance(int i) {
        this.f33858b.setCollapsedTextAppearance(i);
        this.f33855ax = this.f33858b.getCollapsedTextColor();
        if (this.f33817a != null) {
            mo88278a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f33855ax != colorStateList) {
            if (this.f33842ak == null) {
                this.f33858b.setCollapsedTextColor(colorStateList);
            }
            this.f33855ax = colorStateList;
            if (this.f33817a != null) {
                mo88278a(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f33842ak = colorStateList;
        this.f33855ax = colorStateList;
        if (this.f33817a != null) {
            mo88278a(false);
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f33817a;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintAnimationEnabled(boolean z) {
        this.f33799I = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo88282b() {
        return this.f33797G;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHintEnabled(boolean z) {
        if (this.f33797G != z) {
            this.f33797G = z;
            mo88278a(false);
        }
    }

    public boolean isHintAnimationEnabled() {
        return this.f33799I;
    }

    /* access modifiers changed from: protected */
    public void setCollapsedHintEnabled(boolean z) {
        if (this.f33798H != z) {
            this.f33798H = z;
            mo88278a(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCollapsedHintEnabled() {
        return this.f33798H;
    }

    private void setEditText(EditText editText) {
        if (this.f33817a == null) {
            this.f33817a = editText;
            setMinWidth(this.f33811U);
            setMaxWidth(this.f33812V);
            m23846q();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.f33858b.setTypefaces(this.f33817a.getTypeface());
            this.f33858b.setExpandedTextSize(this.f33817a.getTextSize());
            int gravity = this.f33817a.getGravity();
            this.f33858b.setCollapsedTextGravity((gravity & Const.iDefCgiSig) | 48);
            this.f33858b.setExpandedTextGravity(gravity);
            this.f33817a.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    RFTextInputLayout rFTextInputLayout = RFTextInputLayout.this;
                    rFTextInputLayout.mo88278a(!rFTextInputLayout.f33803M);
                    if (RFTextInputLayout.this.f33820aC) {
                        RFTextInputLayout.this.mo88274a(editable.length());
                    }
                    if (RFTextInputLayout.this.f33819aB) {
                        RFTextInputLayout.this.m23826b(editable.length());
                    }
                }
            });
            if (this.f33842ak == null) {
                this.f33842ak = this.f33817a.getHintTextColors();
            }
            if (this.f33823aF) {
                if (TextUtils.isEmpty(this.f33825aH)) {
                    CharSequence hint = this.f33817a.getHint();
                    this.f33824aG = hint;
                    setHint(hint);
                    this.f33817a.setHint((CharSequence) null);
                }
                this.f33802L = true;
            }
            if (this.f33872v != null) {
                mo88274a(this.f33817a.getText().length());
            }
            mo88272a();
            this.f33874x.mo88406d();
            this.f33861k.bringToFront();
            this.f33863m.bringToFront();
            m23851v();
            m23852w();
            m23853x();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            m23820a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    /* renamed from: u */
    private void m23850u() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f33859i.getLayoutParams();
        int l = m23841l();
        if (l != layoutParams.topMargin) {
            layoutParams.topMargin = l;
            requestLayout();
        }
    }

    /* renamed from: v */
    private void m23851v() {
        Iterator it = this.f33875y.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
        }
    }

    public EditText getEditText() {
        return this.f33817a;
    }

    public void setMaxWidth(int i) {
        this.f33812V = i;
        EditText editText = this.f33817a;
        if (editText != null && i != -1) {
            editText.setMaxWidth(i);
        }
    }

    public int getMaxWidth() {
        return this.f33812V;
    }

    public void setMinWidth(int i) {
        this.f33811U = i;
        EditText editText = this.f33817a;
        if (editText != null && i != -1) {
            editText.setMinWidth(i);
        }
    }

    public int getMinWidth() {
        return this.f33811U;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.f33828aK != 1) {
            setInnerEndIconMode(1);
        } else if (!z) {
            setInnerEndIconMode(0);
        }
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.f33828aK == 1;
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f33826aI = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f33870t.setText(charSequence);
        m23801T();
    }

    /* renamed from: w */
    private void m23852w() {
        if (this.f33817a != null) {
            ViewCompat.setPaddingRelative(this.f33861k, m23854y() ? 0 : ViewCompat.getPaddingStart(this.f33817a), this.f33817a.getCompoundPaddingTop(), (int) RFResUtils.getDimens(R.dimen.rf_dimen_8), this.f33817a.getCompoundPaddingBottom());
        }
    }

    public CharSequence getPrefixText() {
        return this.f33826aI;
    }

    /* access modifiers changed from: package-private */
    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f33870t.setTextColor(colorStateList);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f33827aJ = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f33871u.setText(charSequence);
        m23802U();
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f33871u, i);
    }

    /* renamed from: x */
    private void m23853x() {
        if (this.f33817a != null) {
            LinearLayout linearLayout = this.f33863m;
            ViewCompat.setPaddingRelative(linearLayout, linearLayout.getPaddingLeft(), this.f33817a.getPaddingTop(), ViewCompat.getPaddingEnd(this.f33817a), this.f33817a.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f33871u.setTextColor(colorStateList);
    }

    public CharSequence getSuffixText() {
        return this.f33827aJ;
    }

    public void setStartView(View view, FrameLayout.LayoutParams layoutParams) {
        this.f33862l.removeAllViews();
        this.f33862l.addView(view, layoutParams);
        m23803V();
    }

    /* renamed from: y */
    private boolean m23854y() {
        return this.f33862l.getChildCount() > 0;
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f33869s.setVisibility(8);
            return;
        }
        this.f33869s.setVisibility(0);
        this.f33869s.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setEndIconCheckable(boolean z) {
        this.f33869s.setCheckable(z);
    }

    public boolean isEndIconCheckable() {
        return this.f33869s.isCheckable();
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        m23818a(this.f33869s, onClickListener, this.f33829aL);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f33829aL = onLongClickListener;
        m23819a(this.f33869s, onLongClickListener);
    }

    public void refreshEndIconDrawableState() {
        m23817a(this.f33869s, this.f33856ay);
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f33823aF) {
            this.f33823aF = z;
            if (!z) {
                this.f33802L = false;
                if (!TextUtils.isEmpty(this.f33825aH) && TextUtils.isEmpty(this.f33817a.getHint())) {
                    this.f33817a.setHint(this.f33825aH);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f33817a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f33825aH)) {
                        setHint(hint);
                    }
                    this.f33817a.setHint((CharSequence) null);
                }
                this.f33802L = true;
            }
            if (this.f33817a != null) {
                m23850u();
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f33823aF) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f33825aH)) {
            this.f33825aH = charSequence;
            this.f33858b.setText(charSequence);
        }
    }

    public CharSequence getHint() {
        if (this.f33823aF) {
            return this.f33825aH;
        }
        return null;
    }

    public boolean isHintEnabled() {
        return this.f33823aF;
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f33819aB != z) {
            if (z) {
                RFTextView rFTextView = new RFTextView(getContext());
                this.f33873w = rFTextView;
                ViewCompat.setAccessibilityLiveRegion(rFTextView, 1);
                setPlaceholderTextAppearance(this.f33848aq);
                setPlaceholderTextColor(this.f33847ap);
                m23855z();
            } else {
                m23782A();
                this.f33873w = null;
            }
            this.f33819aB = z;
        }
    }

    /* renamed from: z */
    private void m23855z() {
        RFTextView rFTextView = this.f33873w;
        if (rFTextView != null) {
            this.f33860j.addView(rFTextView);
            this.f33873w.setVisibility(0);
        }
    }

    /* renamed from: A */
    private void m23782A() {
        RFTextView rFTextView = this.f33873w;
        if (rFTextView != null) {
            rFTextView.setVisibility(8);
        }
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.f33819aB || !TextUtils.isEmpty(charSequence)) {
            if (!this.f33819aB) {
                setPlaceholderTextEnabled(true);
            }
            this.f33818aA = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        m23783B();
    }

    public CharSequence getPlaceholderText() {
        if (this.f33819aB) {
            return this.f33818aA;
        }
        return null;
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f33847ap != colorStateList) {
            this.f33847ap = colorStateList;
            RFTextView rFTextView = this.f33873w;
            if (rFTextView != null && colorStateList != null) {
                rFTextView.setTextColor(colorStateList);
            }
        }
    }

    private void setPlaceholderTextAppearance(int i) {
        this.f33848aq = i;
        RFTextView rFTextView = this.f33873w;
        if (rFTextView != null) {
            TextViewCompat.setTextAppearance(rFTextView, i);
        }
    }

    private void setPrefixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f33870t, i);
    }

    /* renamed from: B */
    private void m23783B() {
        EditText editText = this.f33817a;
        m23826b(editText == null ? 0 : editText.getText().length());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23826b(int i) {
        if (i != 0 || this.f33800J) {
            m23785D();
        } else {
            m23784C();
        }
    }

    /* renamed from: C */
    private void m23784C() {
        RFTextView rFTextView = this.f33873w;
        if (rFTextView != null && this.f33819aB) {
            rFTextView.setText(this.f33818aA);
            this.f33873w.setVisibility(0);
            this.f33873w.bringToFront();
        }
    }

    /* renamed from: D */
    private void m23785D() {
        RFTextView rFTextView = this.f33873w;
        if (rFTextView != null && this.f33819aB) {
            rFTextView.setText((CharSequence) null);
            this.f33873w.setVisibility(4);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        this.f33874x.mo88402b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.f33874x.mo88394a(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public CharSequence getHelperText() {
        if (this.f33874x.mo88408f()) {
            return this.f33874x.mo88414l();
        }
        return null;
    }

    public boolean isHelperTextEnabled() {
        return this.f33874x.mo88408f();
    }

    private void setErrorEnabled(boolean z) {
        this.f33874x.mo88395a(z);
    }

    public void setErrorIconEnabled(boolean z) {
        this.f33831aN = z;
        mo88289e();
    }

    public void setError(CharSequence charSequence) {
        if (!this.f33874x.mo88407e()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f33874x.mo88401b(charSequence);
            return;
        }
        this.f33874x.mo88397b();
        setErrorEnabled(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo88283c() {
        m23817a(this.f33866p, this.f33857az);
    }

    public CharSequence getError() {
        if (this.f33874x.mo88407e()) {
            return this.f33874x.mo88413k();
        }
        return null;
    }

    public boolean getErrorIconEnabled() {
        return this.f33831aN;
    }

    public void setCounterEnabled(boolean z) {
        if (this.f33820aC != z) {
            if (z) {
                RFTextView rFTextView = new RFTextView(getContext());
                this.f33872v = rFTextView;
                rFTextView.setMaxLines(1);
                int i = this.f33839ah;
                if (i == 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = GravityCompat.END;
                    layoutParams.rightMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18);
                    layoutParams.bottomMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24);
                    this.f33859i.addView(this.f33872v, layoutParams);
                } else if (i == 1) {
                    this.f33874x.mo88393a((TextView) this.f33872v, 2);
                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f33872v.getLayoutParams(), (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_16));
                }
                m23787F();
                m23786E();
            } else {
                int i2 = this.f33839ah;
                if (i2 == 0) {
                    this.f33859i.removeView(this.f33872v);
                } else if (i2 == 1) {
                    this.f33874x.mo88400b(this.f33872v, 2);
                }
                this.f33872v = null;
            }
            this.f33820aC = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f33821aD != i) {
            if (i > 0) {
                this.f33821aD = i;
            } else {
                this.f33821aD = -1;
            }
            if (this.f33820aC) {
                m23786E();
            }
        }
    }

    /* renamed from: E */
    private void m23786E() {
        if (this.f33872v != null) {
            EditText editText = this.f33817a;
            mo88274a(editText == null ? 0 : editText.getText().length());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88274a(int i) {
        boolean z = this.f33822aE;
        int i2 = this.f33821aD;
        if (i2 == -1) {
            this.f33872v.setText(String.valueOf(i));
            this.f33872v.setContentDescription((CharSequence) null);
            this.f33822aE = false;
        } else {
            boolean z2 = i > i2;
            this.f33822aE = z2;
            if (z != z2) {
                m23787F();
            }
            this.f33872v.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.rf_text_input_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f33821aD)})));
        }
        if (this.f33817a != null && z != this.f33822aE) {
            mo88278a(false);
            mo88289e();
            mo88272a();
        }
    }

    /* renamed from: F */
    private void m23787F() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        RFTextView rFTextView = this.f33872v;
        if (rFTextView != null) {
            mo88275a(rFTextView, this.f33822aE ? this.f33846ao : this.f33845an);
            if (!this.f33822aE && (colorStateList2 = this.f33843al) != null) {
                this.f33872v.setTextColor(colorStateList2);
            }
            if (this.f33822aE && (colorStateList = this.f33844am) != null) {
                this.f33872v.setTextColor(colorStateList);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f33821aD;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        RFTextView rFTextView;
        if (!this.f33820aC || !this.f33822aE || (rFTextView = this.f33872v) == null) {
            return null;
        }
        return rFTextView.getContentDescription();
    }

    public boolean isCounterEnabled() {
        return this.f33820aC;
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f33875y.add(onEditTextAttachedListener);
        if (this.f33817a != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f33875y.remove(onEditTextAttachedListener);
    }

    public void clearOnEditTextAttachedListeners() {
        this.f33875y.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo88285d() {
        return this.f33800J;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88275a(RFTextView rFTextView, int i) {
        try {
            TextViewCompat.setTextAppearance(rFTextView, i);
            if (Build.VERSION.SDK_INT >= 23) {
                int defaultColor = rFTextView.getTextColors().getDefaultColor();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88278a(boolean z) {
        m23820a(z, false);
    }

    /* renamed from: a */
    private void m23820a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        boolean isEnabled = isEnabled();
        EditText editText = this.f33817a;
        boolean z3 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f33817a;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean h = this.f33874x.mo88410h();
        ColorStateList colorStateList2 = this.f33842ak;
        if (colorStateList2 != null) {
            this.f33858b.setCollapsedTextColor(colorStateList2);
            this.f33858b.setExpandedTextColor(this.f33842ak);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f33842ak;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f33854aw) : this.f33854aw;
            this.f33858b.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.f33858b.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (h) {
            this.f33858b.setCollapsedTextColor(this.f33842ak);
        } else if (this.f33822aE && this.f33872v != null) {
            this.f33858b.setCollapsedTextColor(this.f33842ak);
        } else if (z4 && (colorStateList = this.f33855ax) != null) {
            this.f33858b.setCollapsedTextColor(colorStateList);
        }
        if (z3 || !this.f33797G || (isEnabled() && z4)) {
            if (z2 || this.f33800J) {
                m23829b(z);
            }
        } else if (z2 || !this.f33800J) {
            m23832c(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r5.f33817a;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo88289e() {
        /*
            r5 = this;
            android.graphics.drawable.GradientDrawable r0 = r5.f33840ai
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001a
            android.widget.EditText r0 = r5.f33817a
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L_0x002e
            android.widget.EditText r3 = r5.f33817a
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r3 = 0
            goto L_0x002f
        L_0x002e:
            r3 = 1
        L_0x002f:
            boolean r4 = r5.isEnabled()
            if (r4 != 0) goto L_0x003d
            r5.m23789H()
            int r4 = r5.f33854aw
            r5.f33853av = r4
            goto L_0x0099
        L_0x003d:
            com.didi.rfusion.widget.textfield.c r4 = r5.f33874x
            boolean r4 = r4.mo88410h()
            if (r4 == 0) goto L_0x0059
            r5.m23789H()
            android.content.res.ColorStateList r4 = r5.f33852au
            if (r4 == 0) goto L_0x0050
            r5.m23830b((boolean) r0, (boolean) r3)
            goto L_0x0099
        L_0x0050:
            com.didi.rfusion.widget.textfield.c r4 = r5.f33874x
            int r4 = r4.mo88415m()
            r5.f33853av = r4
            goto L_0x0099
        L_0x0059:
            boolean r4 = r5.f33822aE
            if (r4 == 0) goto L_0x0075
            com.didi.rfusion.widget.RFTextView r4 = r5.f33872v
            if (r4 == 0) goto L_0x0075
            r5.m23789H()
            android.content.res.ColorStateList r4 = r5.f33852au
            if (r4 == 0) goto L_0x006c
            r5.m23830b((boolean) r0, (boolean) r3)
            goto L_0x0099
        L_0x006c:
            com.didi.rfusion.widget.RFTextView r4 = r5.f33872v
            int r4 = r4.getCurrentTextColor()
            r5.f33853av = r4
            goto L_0x0099
        L_0x0075:
            if (r0 == 0) goto L_0x0086
            int r4 = r5.f33813W
            if (r4 != r2) goto L_0x0081
            boolean r4 = r5.m23788G()
            if (r4 != 0) goto L_0x0099
        L_0x0081:
            int r4 = r5.f33851at
            r5.f33853av = r4
            goto L_0x0099
        L_0x0086:
            if (r3 == 0) goto L_0x0090
            r5.m23789H()
            int r4 = r5.f33850as
            r5.f33853av = r4
            goto L_0x0099
        L_0x0090:
            r5.m23789H()
            int r4 = r5.f33849ar
            r5.f33853av = r4
            r5.f33810T = r1
        L_0x0099:
            com.didi.rfusion.widget.textfield.c r4 = r5.f33874x
            boolean r4 = r4.mo88407e()
            if (r4 == 0) goto L_0x00ae
            com.didi.rfusion.widget.textfield.c r4 = r5.f33874x
            boolean r4 = r4.mo88410h()
            if (r4 == 0) goto L_0x00ae
            boolean r4 = r5.f33831aN
            if (r4 == 0) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            r5.setErrorIconVisible(r1)
            r5.refreshEndIconDrawableState()
            if (r0 == 0) goto L_0x00c1
            boolean r1 = r5.isEnabled()
            if (r1 == 0) goto L_0x00c1
            int r1 = r5.f33838ag
            r5.f33836ae = r1
            goto L_0x00c5
        L_0x00c1:
            int r1 = r5.f33837af
            r5.f33836ae = r1
        L_0x00c5:
            int r1 = r5.f33813W
            r4 = 2
            if (r1 != r4) goto L_0x00cd
            r5.m23798Q()
        L_0x00cd:
            int r1 = r5.f33813W
            if (r1 != r2) goto L_0x00f0
            boolean r1 = r5.isEnabled()
            if (r1 != 0) goto L_0x00dc
            int r0 = r5.f33816Z
            r5.f33814X = r0
            goto L_0x00f0
        L_0x00dc:
            if (r3 == 0) goto L_0x00e5
            if (r0 != 0) goto L_0x00e5
            int r0 = r5.f33833ab
            r5.f33814X = r0
            goto L_0x00f0
        L_0x00e5:
            if (r0 == 0) goto L_0x00ec
            int r0 = r5.f33832aa
            r5.f33814X = r0
            goto L_0x00f0
        L_0x00ec:
            int r0 = r5.f33815Y
            r5.f33814X = r0
        L_0x00f0:
            r5.m23790I()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.textfield.RFTextInputLayout.mo88289e():void");
    }

    /* renamed from: G */
    private boolean m23788G() {
        if (this.f33841aj.isRunning()) {
            return true;
        }
        if (this.f33810T) {
            return false;
        }
        this.f33841aj.start();
        return true;
    }

    /* renamed from: H */
    private void m23789H() {
        if (this.f33841aj.isRunning()) {
            this.f33841aj.end();
        }
    }

    /* renamed from: b */
    private void m23830b(boolean z, boolean z2) {
        m23789H();
        int defaultColor = this.f33852au.getDefaultColor();
        int colorForState = this.f33852au.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f33852au.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.f33853av = colorForState2;
        } else if (z2) {
            this.f33853av = colorForState;
        } else {
            this.f33853av = defaultColor;
        }
    }

    /* renamed from: I */
    private void m23790I() {
        if (this.f33840ai != null) {
            if (m23792K()) {
                this.f33840ai.setStroke(this.f33836ae, this.f33853av);
                this.f33840ai.setCornerRadius(RFResUtils.getDimens(R.dimen.rf_dimen_8));
            }
            if (m23793L()) {
                this.f33840ai.setStroke(this.f33836ae, this.f33853av);
                ((RFUnderlineDrawable) this.f33840ai).setStreamColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
            }
            this.f33840ai.setColor(this.f33814X);
            invalidate();
        }
    }

    /* renamed from: J */
    private void m23791J() {
        invalidate();
    }

    /* renamed from: K */
    private boolean m23792K() {
        return this.f33813W == 2 && m23794M();
    }

    /* renamed from: L */
    private boolean m23793L() {
        return this.f33813W == 1 && m23794M();
    }

    /* renamed from: M */
    private boolean m23794M() {
        return this.f33836ae > -1 && this.f33853av != 0;
    }

    public void setEnableClearText(boolean z) {
        if (this.f33801K != z) {
            if (z) {
                this.f33876z.mo88388a();
            } else {
                this.f33876z.mo88389b();
                setClearIconVisible(false);
            }
            this.f33801K = z;
        }
    }

    public boolean isEnableClearText() {
        return this.f33801K;
    }

    /* renamed from: N */
    private boolean m23795N() {
        return this.f33865o.getVisibility() == 0 && this.f33867q.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void setClearIconVisible(boolean z) {
        if (ViewUtils.isVisible(this.f33867q) != z) {
            this.f33867q.setVisibility(z ? 0 : 8);
            m23803V();
        }
    }

    /* access modifiers changed from: package-private */
    public void setClearIconCheckable(boolean z) {
        this.f33867q.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    public void setClearIconOnClickListener(View.OnClickListener onClickListener) {
        this.f33867q.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public RFCheckableIconButton getClearIcon() {
        return this.f33867q;
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconMode(int i) {
        int i2 = this.f33828aK;
        this.f33828aK = i;
        m23831c(i2);
        setInnerEndIconVisible(i != 0);
        getInnerEndIconDelegate().mo88388a();
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f33868r.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public RFCheckableIconButton getInnerEndIconView() {
        return this.f33868r;
    }

    private C11578b getInnerEndIconDelegate() {
        C11578b bVar = this.f33791A.get(this.f33828aK);
        return bVar != null ? bVar : this.f33791A.get(0);
    }

    /* renamed from: c */
    private void m23831c(int i) {
        Iterator it = this.f33792B.iterator();
        while (it.hasNext()) {
            ((OnEndIconChangedListener) it.next()).onEndIconChanged(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconCheckable(boolean z) {
        this.f33868r.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo88290f() {
        return this.f33868r.isCheckable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88277a(String str, String str2) {
        this.f33868r.setIcon(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconVisible(boolean z) {
        if (mo88291g() != z) {
            this.f33868r.setVisibility(z ? 0 : 8);
            m23803V();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo88291g() {
        return this.f33865o.getVisibility() == 0 && this.f33868r.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88276a(OnEndIconChangedListener onEndIconChangedListener) {
        this.f33792B.add(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88281b(OnEndIconChangedListener onEndIconChangedListener) {
        this.f33792B.remove(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo88310h() {
        this.f33792B.clear();
    }

    /* renamed from: b */
    private void m23829b(boolean z) {
        ValueAnimator valueAnimator = this.f33793C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f33793C.cancel();
        }
        if (!z || !this.f33799I) {
            this.f33858b.setExpansionFraction(1.0f);
        } else {
            mo88273a(1.0f);
        }
        if (m23796O()) {
            m23797P();
        }
        this.f33800J = false;
        m23783B();
        m23801T();
        m23802U();
    }

    /* renamed from: c */
    private void m23832c(boolean z) {
        GradientDrawable gradientDrawable;
        ValueAnimator valueAnimator = this.f33793C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f33793C.cancel();
        }
        if (!z || !this.f33799I) {
            this.f33858b.setExpansionFraction(0.0f);
        } else {
            mo88273a(0.0f);
        }
        if (m23796O() && (gradientDrawable = this.f33840ai) != null && ((RFCutoutDrawable) gradientDrawable).hasCutout()) {
            m23799R();
        }
        this.f33800J = true;
        m23785D();
        m23801T();
        m23802U();
    }

    /* renamed from: O */
    private boolean m23796O() {
        return this.f33823aF && !TextUtils.isEmpty(this.f33825aH) && (this.f33840ai instanceof RFCutoutDrawable) && isCollapsedHintEnabled();
    }

    /* renamed from: P */
    private void m23797P() {
        if (m23796O()) {
            RectF rectF = this.f33796F;
            this.f33858b.getCollapsedTextActualBounds(rectF, this.f33817a.getWidth(), this.f33817a.getGravity());
            this.f33835ad = this.f33836ae;
            rectF.bottom = rectF.top + ((float) this.f33835ad);
            m23815a(rectF);
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            ((RFCutoutDrawable) this.f33840ai).setCutout(rectF);
        }
    }

    /* renamed from: Q */
    private void m23798Q() {
        if (m23796O() && !this.f33800J && this.f33835ad != this.f33836ae) {
            m23799R();
            m23797P();
        }
    }

    /* renamed from: R */
    private void m23799R() {
        GradientDrawable gradientDrawable;
        if (m23796O() && (gradientDrawable = this.f33840ai) != null) {
            ((RFCutoutDrawable) gradientDrawable).removeCutout();
        }
    }

    /* renamed from: a */
    private void m23815a(RectF rectF) {
        rectF.left -= (float) this.f33834ac;
        rectF.right += (float) this.f33834ac;
    }

    public boolean isProvidingHint() {
        return this.f33802L;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88273a(float f) {
        if (this.f33858b.getExpansionFraction() != f) {
            if (this.f33793C == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f33793C = valueAnimator;
                valueAnimator.setInterpolator(RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.f33793C.setDuration(167);
                this.f33793C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RFTextInputLayout.this.f33858b.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.f33793C.setFloatValues(new float[]{this.f33858b.getExpansionFraction(), f});
            this.f33793C.start();
        }
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.f33866p.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = this.f33865o;
        if (z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        m23803V();
    }

    /* renamed from: S */
    private boolean m23800S() {
        return this.f33866p.getVisibility() == 0;
    }

    /* renamed from: T */
    private void m23801T() {
        this.f33870t.setVisibility((this.f33826aI == null || mo88285d()) ? 8 : 0);
        m23803V();
    }

    /* renamed from: U */
    private void m23802U() {
        this.f33871u.getVisibility();
        int i = 0;
        boolean z = this.f33827aJ != null && !mo88285d();
        RFTextView rFTextView = this.f33871u;
        if (!z) {
            i = 8;
        }
        rFTextView.setVisibility(i);
        m23803V();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bf  */
    /* renamed from: V */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m23803V() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f33817a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.m23804W()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0049
            android.widget.LinearLayout r0 = r10.f33861k
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.f33817a
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.f33805O
            if (r6 == 0) goto L_0x0025
            int r6 = r10.f33806P
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.f33805O = r6
            r10.f33806P = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.f33817a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.f33805O
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.f33817a
            r8 = r0[r5]
            r9 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.f33805O
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.f33817a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            android.widget.EditText r6 = r10.f33817a
            r7 = r0[r5]
            r8 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r2, r7, r8, r0)
            r10.f33805O = r2
        L_0x0060:
            r0 = 1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            boolean r6 = r10.m23805X()
            if (r6 == 0) goto L_0x00bf
            android.widget.LinearLayout r2 = r10.f33863m
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.f33817a
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            android.widget.EditText r6 = r10.f33817a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            android.graphics.drawable.Drawable r7 = r10.f33807Q
            if (r7 == 0) goto L_0x0097
            int r8 = r10.f33809S
            if (r8 == r2) goto L_0x0097
            r10.f33809S = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.f33817a
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r4 = r10.f33807Q
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r4, r3)
            goto L_0x00e0
        L_0x0097:
            android.graphics.drawable.Drawable r7 = r10.f33807Q
            if (r7 != 0) goto L_0x00a7
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.f33807Q = r7
            r10.f33809S = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00a7:
            r2 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f33807Q
            if (r2 == r7) goto L_0x00bd
            r0 = r6[r4]
            r10.f33808R = r0
            android.widget.EditText r0 = r10.f33817a
            r1 = r6[r1]
            r2 = r6[r5]
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r7, r3)
            goto L_0x00e0
        L_0x00bd:
            r5 = r0
            goto L_0x00e0
        L_0x00bf:
            android.graphics.drawable.Drawable r6 = r10.f33807Q
            if (r6 == 0) goto L_0x00e1
            android.widget.EditText r6 = r10.f33817a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            r4 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f33807Q
            if (r4 != r7) goto L_0x00dd
            android.widget.EditText r0 = r10.f33817a
            r1 = r6[r1]
            r4 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.f33808R
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r4, r7, r3)
            goto L_0x00de
        L_0x00dd:
            r5 = r0
        L_0x00de:
            r10.f33807Q = r2
        L_0x00e0:
            r0 = r5
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.textfield.RFTextInputLayout.m23803V():boolean");
    }

    /* renamed from: W */
    private boolean m23804W() {
        return (this.f33862l.getChildCount() > 0 || this.f33826aI != null) && this.f33861k.getMeasuredWidth() > 0;
    }

    /* renamed from: X */
    private boolean m23805X() {
        return (m23800S() || m23795N() || mo88291g() || this.f33869s.getVisibility() == 0 || this.f33827aJ != null) && this.f33863m.getMeasuredWidth() > 0;
    }

    /* renamed from: a */
    private void m23817a(RFCheckableImageButton rFCheckableImageButton, ColorStateList colorStateList) {
        Drawable drawable = rFCheckableImageButton.getDrawable();
        if (rFCheckableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(m23822a(rFCheckableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            rFCheckableImageButton.setImageDrawable(mutate);
        }
    }

    /* renamed from: a */
    private int[] m23822a(RFCheckableImageButton rFCheckableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = rFCheckableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f33874x.mo88410h()) {
            savedState.error = getError();
        }
        boolean z = true;
        savedState.isOuterEndIconChecked = this.f33869s.getVisibility() == 0 && this.f33869s.isChecked();
        if (this.f33868r.getVisibility() != 0 || !this.f33868r.isChecked()) {
            z = false;
        }
        savedState.isInnerEndIconChecked = z;
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isOuterEndIconChecked) {
            this.f33869s.post(new Runnable() {
                public void run() {
                    RFTextInputLayout.this.f33869s.performClick();
                    RFTextInputLayout.this.f33869s.jumpDrawablesToCurrentState();
                }
            });
        }
        if (savedState.isInnerEndIconChecked) {
            this.f33868r.post(new Runnable() {
                public void run() {
                    RFTextInputLayout.this.f33868r.performClick();
                    RFTextInputLayout.this.f33868r.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f33803M = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f33803M = false;
    }

    /* renamed from: a */
    private static void m23818a(RFCheckableImageButton rFCheckableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        rFCheckableImageButton.setOnClickListener(onClickListener);
        m23827b(rFCheckableImageButton, onLongClickListener);
    }

    /* renamed from: a */
    private static void m23819a(RFCheckableImageButton rFCheckableImageButton, View.OnLongClickListener onLongClickListener) {
        rFCheckableImageButton.setOnLongClickListener(onLongClickListener);
        m23827b(rFCheckableImageButton, onLongClickListener);
    }

    /* renamed from: b */
    private static void m23827b(RFCheckableImageButton rFCheckableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(rFCheckableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        rFCheckableImageButton.setFocusable(z);
        rFCheckableImageButton.setClickable(hasOnClickListeners);
        rFCheckableImageButton.setPressed(hasOnClickListeners);
        rFCheckableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        ViewCompat.setImportantForAccessibility(rFCheckableImageButton, i);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        CharSequence helperText;
        CharSequence hintText;
        boolean isInnerEndIconChecked;
        boolean isOuterEndIconChecked;
        CharSequence placeholderText;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z = false;
            this.isOuterEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isInnerEndIconChecked = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isOuterEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
            parcel.writeInt(this.isInnerEndIconChecked ? 1 : 0);
        }

        public String toString() {
            return "RFTextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }
    }

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final RFTextInputLayout layout;

        public AccessibilityDelegate(RFTextInputLayout rFTextInputLayout) {
            this.layout = rFTextInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.layout.mo88285d();
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = text + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
        }
    }
}
