package com.didiglobal.comp.carmodellist.button;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonModel;

public abstract class AnyCarRadioButtonView extends LinearLayout implements View.OnClickListener, Checkable {

    /* renamed from: a */
    private static final String f49786a = AnyCarRadioButtonView.class.getSimpleName();

    /* renamed from: k */
    private static final int[] f49787k = {16842912};

    /* renamed from: b */
    private boolean f49788b;

    /* renamed from: c */
    private boolean f49789c;

    /* renamed from: d */
    private boolean f49790d;

    /* renamed from: e */
    private OnCheckedChangeListener f49791e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f49792f;

    /* renamed from: g */
    private Context f49793g;

    /* renamed from: h */
    private ImageView f49794h;

    /* renamed from: i */
    private TextView f49795i;

    /* renamed from: j */
    private AnyCarRadioButtonModel.ViewModel f49796j;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(AnyCarRadioButtonView anyCarRadioButtonView, boolean z);
    }

    public abstract ImageView getIcon();

    public abstract int getLayoutResId();

    public abstract TextView getTitle();

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public AnyCarRadioButtonView(Context context) {
        super(context);
        this.f49793g = context;
        m35915a(context, (AttributeSet) null);
    }

    public AnyCarRadioButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49793g = context;
        m35915a(context, attributeSet);
    }

    public AnyCarRadioButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35915a(context, attributeSet);
    }

    /* renamed from: a */
    private void m35915a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        this.f49794h = getIcon();
        this.f49795i = getTitle();
        setChecked(false);
        setOnClickListener(this);
    }

    public void setData(AnyCarRadioButtonModel.ViewModel viewModel) {
        this.f49796j = viewModel;
        if (viewModel != null) {
            int i = viewModel.f49785id;
            if (i == -1) {
                i = View.generateViewId();
            }
            this.f49796j.f49785id = i;
            setId(i);
            setChildrenChecked(this.f49796j.isChecked);
        }
    }

    public void setDisable(boolean z) {
        this.f49789c = z;
        if (z) {
            AnyCarRadioButtonModel.ViewModel viewModel = this.f49796j;
            if (viewModel != null) {
                if (viewModel.titleDisable != null) {
                    this.f49795i.setText(this.f49796j.titleDisable.text);
                    this.f49795i.setTextColor(Color.parseColor(this.f49796j.titleDisable.textColor));
                }
                if (this.f49788b) {
                    this.f49794h.setBackground(this.f49796j.iconDisable);
                } else {
                    this.f49794h.setBackground(this.f49796j.iconUnChecked);
                }
                setBackground(this.f49796j.bgDisable);
                return;
            }
            return;
        }
        setChildrenChecked(this.f49788b);
    }

    public void setExtLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f49792f = layoutParams;
    }

    public LinearLayout.LayoutParams getExtLayoutParams() {
        return this.f49792f;
    }

    public void setChecked(boolean z) {
        if (this.f49788b != z) {
            this.f49788b = z;
            setChildrenChecked(z);
            refreshDrawableState();
            if (!this.f49790d) {
                this.f49790d = true;
                OnCheckedChangeListener onCheckedChangeListener = this.f49791e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.f49788b);
                }
                this.f49790d = false;
            }
        }
    }

    public boolean isChecked() {
        return this.f49788b;
    }

    public void toggle() {
        if (!this.f49789c && !this.f49788b) {
            setChecked(true);
        }
    }

    public boolean performClick() {
        toggle();
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f49787k);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f49791e = onCheckedChangeListener;
    }

    private void setChildrenChecked(boolean z) {
        AnyCarRadioButtonModel.ViewModel viewModel = this.f49796j;
        if (viewModel != null) {
            this.f49788b = z;
            if (z) {
                this.f49794h.setBackground(viewModel.iconChecked);
                if (this.f49796j.titleChecked != null) {
                    this.f49795i.setText(this.f49796j.titleChecked.text);
                    this.f49795i.setTextColor(Color.parseColor(this.f49796j.titleChecked.textColor));
                }
                setBackground(this.f49796j.bgChecked);
            } else {
                this.f49794h.setBackground(viewModel.iconUnChecked);
                if (this.f49796j.titleUnChecked != null) {
                    this.f49795i.setText(this.f49796j.titleUnChecked.text);
                    this.f49795i.setTextColor(Color.parseColor(this.f49796j.titleUnChecked.textColor));
                }
                setBackground(this.f49796j.bgUnChecked);
            }
            setChecked(this.f49788b);
        }
    }

    public AnyCarRadioButtonModel.ViewModel getButtonViewModel() {
        return this.f49796j;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean checked;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checked = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.checked));
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.checked + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = isChecked();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
        requestLayout();
    }

    public void autofill(AutofillValue autofillValue) {
        if (isEnabled() && autofillValue.isToggle()) {
            setChecked(autofillValue.getToggleValue());
        }
    }

    public int getAutofillType() {
        return isEnabled() ? 2 : 0;
    }

    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            return AutofillValue.forToggle(isChecked());
        }
        return null;
    }
}
