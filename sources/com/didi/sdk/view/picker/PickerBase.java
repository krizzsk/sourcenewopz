package com.didi.sdk.view.picker;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.picker.IPickerData;
import java.util.List;

public abstract class PickerBase<T extends IPickerData> extends SimplePopupBase {
    protected int mColumnCount;
    /* access modifiers changed from: protected */
    public int[] mCurAllIndex;
    protected boolean mHasInit;
    protected int[] mInitialIndex;
    protected T[] mInitialSelect;
    /* access modifiers changed from: protected */
    public boolean mIsResultRealTime;
    protected LinearLayout mPickerLayout;
    protected OnPickerListener<T> mPickerListener;
    protected NumberPickerView[] mPickerViews;
    protected OnRawSelectedListener<T> mRawSelectedListener;
    protected Style mStyle;
    protected Style mStyleInner;
    protected int mVisibility;
    protected int[] mVisibilityColumns;

    @Deprecated
    public interface OnRawSelectedListener<T extends IPickerData> {
        void onSelectedResult(List<T> list, int[] iArr);
    }

    /* access modifiers changed from: protected */
    public abstract List<T> getSelectedData();

    /* access modifiers changed from: protected */
    public abstract int[] getSelectedIndex();

    /* access modifiers changed from: protected */
    public void onSelectConfirm(List<T> list, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public void onWheelChanged(List<T> list, int[] iArr) {
    }

    public abstract void setInitialSelect(int... iArr);

    public abstract void setInitialSelect(T... tArr);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.mPickerLayout = new LinearLayout(getContext());
    }

    /* access modifiers changed from: protected */
    public void applyStyle(Style style) {
        if (style != null && this.mPickerViews != null && this.mPickerLayout != null) {
            for (int i = 0; i < this.mColumnCount; i++) {
                NumberPickerView numberPickerView = this.mPickerViews[i];
                if (style.suffix != null) {
                    numberPickerView.setSuffixText(style.suffix[i]);
                }
                if (style.suffixScope != null) {
                    numberPickerView.setSuffixScope(style.suffixScope[i]);
                }
                if (style.textColor != -1) {
                    numberPickerView.setDividerColor(style.textColor);
                }
                if (style.lineColor != -1) {
                    numberPickerView.setSelectedTextColor(style.lineColor);
                }
                if (style.weight != null && style.weight.length == this.mColumnCount) {
                    ((LinearLayout.LayoutParams) numberPickerView.getLayoutParams()).weight = (float) style.weight[i];
                }
            }
            if (!(style.paddingTop == -1 && style.paddingBottom == -1)) {
                this.mPickerLayout.setPaddingRelative(0, style.paddingTop, 0, style.paddingBottom);
            }
            if (style.backgroundResource != -1) {
                this.mRootView.setBackgroundResource(style.backgroundResource);
            }
        }
    }

    public List<T> confirmSelectAndCallback() {
        List<T> selectedData = getSelectedData();
        int[] selectedIndex = getSelectedIndex();
        onSelectConfirm(selectedData, selectedIndex);
        OnRawSelectedListener<T> onRawSelectedListener = this.mRawSelectedListener;
        if (onRawSelectedListener != null) {
            onRawSelectedListener.onSelectedResult(selectedData, selectedIndex);
        }
        OnPickerListener<T> onPickerListener = this.mPickerListener;
        if (onPickerListener != null) {
            onPickerListener.onResult(selectedData, selectedIndex);
        }
        return selectedData;
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    /* access modifiers changed from: protected */
    public void setStyleInner(Style style) {
        this.mStyleInner = style;
    }

    public void setVisibility(int i, int... iArr) {
        if (!isAdded()) {
            this.mVisibility = i;
            this.mVisibilityColumns = iArr;
        } else if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 < this.mPickerViews.length) {
                    if (i == 8) {
                        i = 4;
                    }
                    this.mPickerViews[i2].setVisibility(i);
                }
            }
        }
    }

    public void setPickerListener(OnPickerListener<T> onPickerListener) {
        this.mPickerListener = onPickerListener;
    }

    public void setResultRealTime(boolean z) {
        this.mIsResultRealTime = z;
    }

    @Deprecated
    public void setRawSelectedListener(OnRawSelectedListener<T> onRawSelectedListener) {
        this.mRawSelectedListener = onRawSelectedListener;
    }

    protected static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: protected */
    public void checkInit() {
        if (this.mHasInit) {
            throw new IllegalStateException("please don't set argument after dialog used");
        }
    }
}
