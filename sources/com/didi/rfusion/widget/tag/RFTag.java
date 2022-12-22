package com.didi.rfusion.widget.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFTag extends FrameLayout {

    /* renamed from: a */
    private static final int f33767a = 0;

    /* renamed from: b */
    private static final int f33768b = 1;

    /* renamed from: c */
    private int f33769c;

    /* renamed from: d */
    private boolean f33770d;

    /* renamed from: e */
    private boolean f33771e;

    /* renamed from: f */
    private boolean f33772f;

    /* renamed from: g */
    private String f33773g;

    /* renamed from: h */
    private FrameLayout f33774h;

    /* renamed from: i */
    private RFTextView f33775i;

    /* renamed from: j */
    private FrameLayout f33776j;

    /* renamed from: k */
    private RFIconView f33777k;

    /* renamed from: l */
    private OnTagClickEventListener f33778l;

    /* renamed from: m */
    private OnTagStateChangeListener f33779m;

    /* renamed from: n */
    private Drawable f33780n;

    public interface OnTagClickEventListener {
        void onDeleteClick();

        void onTagClick(View view);
    }

    public interface OnTagStateChangeListener {
        void onSelectedChanged(boolean z);
    }

    public RFTag(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33769c = 0;
        m23776a(context, attributeSet);
        m23775a(context);
    }

    /* renamed from: a */
    private void m23776a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFTag);
        this.f33769c = obtainStyledAttributes.getInt(2, 0);
        this.f33770d = obtainStyledAttributes.getBoolean(1, false);
        this.f33771e = obtainStyledAttributes.getBoolean(3, false);
        this.f33772f = obtainStyledAttributes.getBoolean(0, false);
        this.f33773g = obtainStyledAttributes.getString(4);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m23775a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.rf_tag, this);
        this.f33774h = (FrameLayout) findViewById(R.id.rf_tag_left_view);
        this.f33775i = (RFTextView) findViewById(R.id.rf_tag_content);
        this.f33776j = (FrameLayout) findViewById(R.id.rf_tag_right_view);
        this.f33777k = (RFIconView) findViewById(R.id.rf_tag_delete_icon);
        this.f33780n = getResources().getDrawable(R.drawable.rf_shape_bg_tag);
        setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
        setTagSpec(this.f33769c);
        setDisable(this.f33770d);
        setSelected(this.f33771e);
        setCheckable(this.f33772f);
        setTagText(this.f33773g);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFTag.this.m23778b(view);
            }
        });
        this.f33777k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFTag.this.m23777a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23778b(View view) {
        if (!this.f33770d) {
            if (this.f33772f) {
                setSelected(!this.f33771e);
            }
            OnTagClickEventListener onTagClickEventListener = this.f33778l;
            if (onTagClickEventListener != null) {
                onTagClickEventListener.onTagClick(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23777a(View view) {
        setVisibility(8);
        OnTagClickEventListener onTagClickEventListener = this.f33778l;
        if (onTagClickEventListener != null) {
            onTagClickEventListener.onDeleteClick();
        }
    }

    public void setTagText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f33775i.setText(str);
            this.f33773g = str;
        }
    }

    public void setSelected(boolean z) {
        if (this.f33769c == 1) {
            this.f33771e = false;
            return;
        }
        if (z) {
            setBackGroundColor(R.color.rf_color_background_1_100);
            this.f33775i.setTextColor(RFResUtils.getColor(R.color.rf_color_brands_1_100));
        } else {
            setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
            this.f33775i.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        }
        this.f33771e = z;
        OnTagStateChangeListener onTagStateChangeListener = this.f33779m;
        if (onTagStateChangeListener != null) {
            onTagStateChangeListener.onSelectedChanged(z);
        }
    }

    public void setDisable(boolean z) {
        if (this.f33769c == 1) {
            this.f33770d = false;
            return;
        }
        if (z) {
            setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
            this.f33775i.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        } else {
            setSelected(this.f33771e);
        }
        this.f33770d = z;
    }

    public void setCheckable(boolean z) {
        if (this.f33769c == 1) {
            this.f33772f = false;
        } else {
            this.f33772f = z;
        }
    }

    public String getTagText() {
        return this.f33773g;
    }

    public boolean isTagSelected() {
        return this.f33771e;
    }

    public boolean isDisable() {
        return this.f33770d;
    }

    public boolean isCheckable() {
        return this.f33772f;
    }

    public void setOnTagClickEventListener(OnTagClickEventListener onTagClickEventListener) {
        this.f33778l = onTagClickEventListener;
    }

    public void setOnTagStateChangeListener(OnTagStateChangeListener onTagStateChangeListener) {
        this.f33779m = onTagStateChangeListener;
    }

    public void addLeftView(View view) {
        if (view != null) {
            this.f33774h.addView(view);
            setLeftViewVisible(true);
            return;
        }
        setLeftViewVisible(false);
    }

    public void setLeftViewVisible(boolean z) {
        int i = 8;
        if (this.f33769c == 1) {
            this.f33774h.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = this.f33774h;
        if (z) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    public void addRightView(View view) {
        if (view != null) {
            this.f33776j.addView(view);
            setRightViewVisible(true);
            return;
        }
        setRightViewVisible(false);
    }

    public void setRightViewVisible(boolean z) {
        int i = 8;
        if (this.f33769c == 1) {
            this.f33776j.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = this.f33776j;
        if (z) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    private void setTagSpec(int i) {
        if (i == 0) {
            this.f33777k.setVisibility(8);
        } else if (i == 1) {
            this.f33777k.setVisibility(0);
        }
    }

    private void setBackGroundColor(int i) {
        Drawable drawable = this.f33780n;
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(RFResUtils.getColor(i));
        }
        setBackground(this.f33780n);
    }
}
