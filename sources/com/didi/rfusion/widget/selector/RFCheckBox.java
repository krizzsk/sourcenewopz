package com.didi.rfusion.widget.selector;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;

public class RFCheckBox extends RFSelectorButton {

    /* renamed from: a */
    private boolean f33701a = false;

    /* access modifiers changed from: protected */
    public final int getCheckedIcon() {
        return R.string.rf_icon_checkbox;
    }

    /* access modifiers changed from: protected */
    public final int getUnCheckedIcon() {
        return R.string.rf_icon_checkbox_line;
    }

    public RFCheckBox(Context context) {
        super(context);
    }

    public RFCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setIndeterminate() {
        this.f33701a = true;
        this.mRfivLeftChoice.setText(R.string.rf_icon_checkbox_indeterminate);
        this.mRfivRightChoice.setText(R.string.rf_icon_checkbox_indeterminate);
        this.mRfivLeftChoice.setSelected(true);
        this.mRfivRightChoice.setSelected(true);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        this.f33701a = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo88125a() {
        return this.f33701a;
    }
}
