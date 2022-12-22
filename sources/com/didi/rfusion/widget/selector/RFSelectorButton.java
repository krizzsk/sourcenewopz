package com.didi.rfusion.widget.selector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public abstract class RFSelectorButton extends LinearLayout implements Checkable {

    /* renamed from: a */
    private static final String f33709a = "RFSelectorButton";

    /* renamed from: b */
    private static final int[] f33710b = {16842912};

    /* renamed from: c */
    private ImageView f33711c;

    /* renamed from: d */
    private RFTextView f33712d;

    /* renamed from: e */
    private RFTextView f33713e;

    /* renamed from: f */
    private RFTextView f33714f;

    /* renamed from: g */
    private int f33715g;

    /* renamed from: h */
    private boolean f33716h;

    /* renamed from: i */
    private boolean f33717i;

    /* renamed from: j */
    private OnCheckedChangeListener f33718j;

    /* renamed from: k */
    private OnCheckedChangeListener f33719k;
    protected boolean mBroadcasting;
    protected RFIconView mRfivLeftChoice;
    protected RFIconView mRfivRightChoice;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(RFSelectorButton rFSelectorButton, boolean z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo88125a();

    /* access modifiers changed from: protected */
    public abstract int getCheckedIcon();

    /* access modifiers changed from: protected */
    public abstract int getUnCheckedIcon();

    public RFSelectorButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSelectorButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSelectorButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33715g = -1;
        this.f33717i = false;
        setOrientation(0);
        setGravity(16);
        m23739b();
        m23738a(attributeSet);
    }

    /* renamed from: b */
    private void m23739b() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_selector, this);
        this.f33711c = (ImageView) findViewById(R.id.rf_iv_icon);
        this.mRfivLeftChoice = (RFIconView) findViewById(R.id.rf_rfci_left);
        this.mRfivRightChoice = (RFIconView) findViewById(R.id.rf_rfci_right);
        this.f33712d = (RFTextView) findViewById(R.id.rf_tv_title);
        this.f33713e = (RFTextView) findViewById(R.id.rf_tv_tips);
        this.f33714f = (RFTextView) findViewById(R.id.rf_tv_emphasize);
        this.mRfivLeftChoice.setClickable(false);
        this.mRfivRightChoice.setClickable(false);
        updateCheckboxUI();
    }

    /* renamed from: a */
    private void m23738a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFSelectorButton);
        String string = obtainStyledAttributes.getString(6);
        String string2 = obtainStyledAttributes.getString(5);
        String string3 = obtainStyledAttributes.getString(1);
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        Drawable drawable = obtainStyledAttributes.getDrawable(3);
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        int i = obtainStyledAttributes.getInt(4, 1);
        obtainStyledAttributes.recycle();
        setTitle(string);
        setTips(string2);
        setEmphasize(string3);
        setType(i);
        setChecked(z2);
        setClickable(true);
        setEnabled(z);
        setIcon(drawable);
    }

    public void setType(int i) {
        if (this.f33715g != i) {
            this.f33715g = i;
            m23740c();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mRfivLeftChoice.setEnabled(z);
        this.mRfivRightChoice.setEnabled(z);
        this.f33712d.setEnabled(z);
        this.f33714f.setEnabled(z);
    }

    /* renamed from: c */
    private void m23740c() {
        if (this.f33715g == 1) {
            this.mRfivRightChoice.setVisibility(0);
            this.f33711c.setVisibility(0);
            this.mRfivLeftChoice.setVisibility(8);
            if (!TextUtils.isEmpty(this.f33713e.getText())) {
                this.f33713e.setVisibility(0);
                return;
            }
            return;
        }
        this.mRfivRightChoice.setVisibility(8);
        this.f33711c.setVisibility(8);
        this.mRfivLeftChoice.setVisibility(0);
        this.f33713e.setVisibility(8);
    }

    public void setIcon(int i) {
        this.f33711c.setVisibility(0);
        this.f33711c.setImageResource(i);
    }

    public void setIcon(Drawable drawable) {
        if (drawable == null) {
            this.f33711c.setVisibility(8);
            return;
        }
        this.f33711c.setVisibility(0);
        this.f33711c.setImageDrawable(drawable);
    }

    public void setIconSrc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f33711c.setVisibility(8);
            return;
        }
        this.f33711c.setVisibility(0);
        Glide.with(getContext()).load(str).into(this.f33711c);
    }

    public void setTitle(String str) {
        this.f33712d.setText(str);
    }

    public void setTips(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f33713e.setVisibility(8);
            return;
        }
        this.f33713e.setText(str);
        this.f33713e.setVisibility(0);
    }

    public void setEmphasize(String str) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRfivRightChoice.getLayoutParams();
        if (TextUtils.isEmpty(str)) {
            this.f33714f.setVisibility(8);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_compound_emphasize_margin_left);
        } else {
            this.f33714f.setText(str);
            this.f33714f.setVisibility(0);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_compound_right_cb_margin_left);
        }
        this.mRfivRightChoice.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: protected */
    public void updateCheckboxUI() {
        int checkedIcon = this.f33716h ? getCheckedIcon() : getUnCheckedIcon();
        this.mRfivLeftChoice.setText(checkedIcon);
        this.mRfivLeftChoice.setSelected(this.f33716h);
        this.mRfivRightChoice.setText(checkedIcon);
        this.mRfivRightChoice.setSelected(this.f33716h);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f33718j = onCheckedChangeListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f33719k = onCheckedChangeListener;
    }

    public void setChecked(boolean z) {
        if (mo88125a() || this.f33716h != z) {
            this.f33716h = z;
            refreshDrawableState();
            if (!this.mBroadcasting) {
                updateCheckboxUI();
                this.mBroadcasting = true;
                OnCheckedChangeListener onCheckedChangeListener = this.f33718j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.f33716h);
                }
                OnCheckedChangeListener onCheckedChangeListener2 = this.f33719k;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(this, this.f33716h);
                }
                this.mBroadcasting = false;
            } else {
                return;
            }
        }
        this.f33712d.setSelected(this.f33716h);
        this.f33714f.setSelected(this.f33716h);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f33710b);
        }
        return onCreateDrawableState;
    }

    public void toggle() {
        setChecked(!this.f33716h);
    }

    public boolean performClick() {
        if (mo88125a()) {
            setChecked(true);
        } else {
            toggle();
        }
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    public boolean isChecked() {
        return this.f33716h;
    }
}
