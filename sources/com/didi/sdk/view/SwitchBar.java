package com.didi.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

public class SwitchBar extends ImageButton implements View.OnClickListener {

    /* renamed from: a */
    private OnChangedListener f37908a;

    public interface OnChangedListener {
        void OnChanged(SwitchBar switchBar, boolean z);
    }

    public SwitchBar(Context context) {
        super(context);
        init();
    }

    public SwitchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonSwitchSelector() == 0) {
            setBackgroundResource(R.drawable.common_switch_selector);
        } else {
            setBackgroundResource(ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonSwitchSelector());
        }
        setOnClickListener(this);
    }

    public void setOnChangedListener(OnChangedListener onChangedListener) {
        this.f37908a = onChangedListener;
    }

    public boolean getChecked() {
        return isSelected();
    }

    public void setChecked(boolean z) {
        setSelected(z);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        setSelected(!isSelected());
        OnChangedListener onChangedListener = this.f37908a;
        if (onChangedListener != null) {
            onChangedListener.OnChanged(this, isSelected());
        }
    }
}
