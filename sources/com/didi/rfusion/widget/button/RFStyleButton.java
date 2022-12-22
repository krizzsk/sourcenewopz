package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.taxis99.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class RFStyleButton extends RFButton {

    /* renamed from: a */
    private static final String f33379a = "RFStyleButton";

    /* renamed from: b */
    private static final int f33380b = 0;

    /* renamed from: c */
    private static final int f33381c = 1;

    /* renamed from: d */
    private static final int f33382d = 2;

    /* renamed from: e */
    private RFShadowLayout f33383e;

    /* renamed from: f */
    private FrameLayout f33384f;

    /* renamed from: g */
    private ConstraintLayout f33385g;

    /* renamed from: h */
    private RFIconView f33386h;

    /* renamed from: i */
    private ImageView f33387i;

    /* renamed from: j */
    private RFIconView f33388j;

    /* renamed from: k */
    private ImageView f33389k;

    /* renamed from: l */
    private RFTextView f33390l;

    /* renamed from: m */
    private RFLottieLoadingView f33391m;

    /* renamed from: n */
    private View.OnClickListener f33392n;

    /* renamed from: o */
    private View.OnClickListener f33393o;

    /* renamed from: p */
    private final View.OnClickListener f33394p = new View.OnClickListener() {
        public final void onClick(View view) {
            RFStyleButton.this.m23469a(view);
        }
    };

    /* renamed from: q */
    private boolean f33395q = false;

    /* renamed from: r */
    private int f33396r = -1;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.rf_btn_style;
    }

    /* access modifiers changed from: protected */
    public abstract int getLoadingRes();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23469a(View view) {
        if (!isEnabled()) {
            View.OnClickListener onClickListener = this.f33392n;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (this.f33393o != null && !isLoading()) {
            this.f33393o.onClick(view);
        }
    }

    public RFStyleButton(Context context) {
        super(context);
    }

    public RFStyleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFStyleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f33383e = (RFShadowLayout) findViewById(R.id.rf_sl_shadow);
        this.f33384f = (FrameLayout) findViewById(R.id.rf_fl_frame);
        this.f33385g = (ConstraintLayout) findViewById(R.id.rf_cl_content);
        this.f33386h = (RFIconView) findViewById(R.id.rf_iv_left_icon);
        this.f33388j = (RFIconView) findViewById(R.id.rf_iv_right_icon);
        this.f33387i = (ImageView) findViewById(R.id.rf_iv_left_drawable);
        this.f33389k = (ImageView) findViewById(R.id.rf_iv_right_drawable);
        this.f33390l = (RFTextView) findViewById(R.id.rf_tv_text);
        this.f33391m = (RFLottieLoadingView) findViewById(R.id.rf_llv_loading);
        setLoadingRes(getLoadingRes());
    }

    /* access modifiers changed from: protected */
    public void setLoadingRes(int i) {
        if (this.f33391m.isRunning()) {
            this.f33391m.stop();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(i)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    this.f33391m.setAnimationFromJson(sb.toString(), (String) null);
                    return;
                }
            }
        } catch (Resources.NotFoundException | IOException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFStyleButton);
        boolean z = obtainStyledAttributes.getBoolean(2, false);
        String string = obtainStyledAttributes.getString(1);
        String string2 = obtainStyledAttributes.getString(3);
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        setSpec(i);
        setIcon(1, string2);
        setIcon(0, string);
        setLoading(z);
    }

    /* renamed from: a */
    private int m23467a(int i) {
        float f;
        if (i == 0) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_large);
        } else if (i == 1) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_small);
        } else if (i != 2) {
            return 0;
        } else {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_height_max);
        }
        return (int) f;
    }

    /* access modifiers changed from: protected */
    public void updateText(CharSequence charSequence) {
        this.f33390l.setText(charSequence);
        m23468a();
    }

    /* access modifiers changed from: protected */
    public void updateSpec(int i) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_large);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_large);
            this.f33390l.setTypeface(1);
        } else if (i == 1) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_10_app_28_pad_16);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_small);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_small);
        } else if (i != 2) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_loading_size_large);
            i4 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_size_large);
            this.f33390l.setTypeface(2);
        }
        this.f33384f.getLayoutParams().height = m23467a(i);
        this.f33390l.setTextSize(0, (float) i2);
        ViewGroup.LayoutParams layoutParams = this.f33391m.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.f33391m.setLayoutParams(layoutParams);
        float f = (float) i4;
        this.f33386h.setTextSize(0, f);
        this.f33388j.setTextSize(0, f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33386h.getLayoutParams();
        marginLayoutParams.width = i4;
        marginLayoutParams.height = i4;
        this.f33387i.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f33388j.getLayoutParams();
        marginLayoutParams2.width = i4;
        marginLayoutParams2.height = i4;
        this.f33389k.setLayoutParams(marginLayoutParams2);
        m23468a();
    }

    /* renamed from: a */
    private void m23468a() {
        int i;
        boolean isEmpty = TextUtils.isEmpty(this.f33390l.getText());
        int i2 = 0;
        if (isEmpty) {
            i = 0;
        } else {
            i = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_style_icon_margin_size);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33386h.getLayoutParams();
        if (!isEmpty) {
            i2 = i;
        }
        marginLayoutParams.rightMargin = i2;
        ((ViewGroup.MarginLayoutParams) this.f33388j.getLayoutParams()).leftMargin = i;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f33386h.getLayoutParams();
        marginLayoutParams2.rightMargin = i;
        this.f33387i.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f33388j.getLayoutParams();
        marginLayoutParams3.leftMargin = i;
        this.f33389k.setLayoutParams(marginLayoutParams3);
    }

    /* access modifiers changed from: protected */
    public void setTextColor(int i) {
        this.f33390l.setTextColor(i);
    }

    /* access modifiers changed from: protected */
    public void setTextColor(ColorStateList colorStateList) {
        this.f33390l.setTextColor(colorStateList);
    }

    public void setContentBackground(Drawable drawable) {
        this.f33384f.setBackground(drawable);
    }

    public Drawable getContentBackground() {
        return this.f33384f.getBackground();
    }

    /* access modifiers changed from: protected */
    public void setShadow(int i, int i2, int i3, int i4, int i5) {
        this.f33383e.setShadow(i, i2, i3, i4, i5);
    }

    public void setEnabled(boolean z) {
        this.f33384f.setEnabled(z);
        this.f33390l.setEnabled(z);
    }

    public boolean isEnabled() {
        return this.f33384f.isEnabled();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f33393o = onClickListener;
        m23470b();
    }

    public void setOnDisableClickListener(View.OnClickListener onClickListener) {
        this.f33392n = onClickListener;
        m23470b();
    }

    /* renamed from: b */
    private void m23470b() {
        if (this.f33393o == null && this.f33392n == null) {
            super.setOnClickListener((View.OnClickListener) null);
        } else {
            super.setOnClickListener(this.f33394p);
        }
    }

    public void setSpec(int i) {
        if (this.f33396r != i) {
            this.f33396r = i;
            updateSpec(i);
        }
    }

    public void setLoading(boolean z) {
        if (this.f33395q != z) {
            this.f33395q = z;
            if (z) {
                this.f33391m.show();
                this.f33385g.setVisibility(4);
                return;
            }
            this.f33391m.hide();
            this.f33385g.setVisibility(0);
        }
    }

    public void setLeftIcon(String str) {
        setIcon(0, str);
    }

    public void setLeftIcon(Drawable drawable) {
        setIcon(0, drawable);
    }

    public void setRightIcon(String str) {
        setIcon(1, str);
    }

    public void setRightIcon(Drawable drawable) {
        setIcon(1, drawable);
    }

    public void setIcon(int i, String str) {
        this.f33387i.setVisibility(8);
        this.f33389k.setVisibility(8);
        if (i == 0) {
            if (TextUtils.isEmpty(str)) {
                this.f33386h.setVisibility(8);
                return;
            }
            this.f33388j.setVisibility(8);
            this.f33386h.setVisibility(0);
            this.f33386h.setText(str);
        } else if (TextUtils.isEmpty(str)) {
            this.f33388j.setVisibility(8);
        } else {
            this.f33386h.setVisibility(8);
            this.f33388j.setVisibility(0);
            this.f33388j.setText(str);
        }
    }

    public void setIcon(int i, Drawable drawable) {
        this.f33386h.setVisibility(8);
        this.f33388j.setVisibility(8);
        if (i == 0) {
            if (drawable == null) {
                this.f33387i.setVisibility(8);
                return;
            }
            this.f33389k.setVisibility(8);
            this.f33387i.setVisibility(0);
            this.f33387i.setImageDrawable(drawable);
        } else if (drawable == null) {
            this.f33389k.setVisibility(8);
        } else {
            this.f33387i.setVisibility(8);
            this.f33389k.setVisibility(0);
            this.f33389k.setImageDrawable(drawable);
        }
    }

    public int getSpec() {
        return this.f33396r;
    }

    public boolean isLoading() {
        return this.f33395q;
    }
}
