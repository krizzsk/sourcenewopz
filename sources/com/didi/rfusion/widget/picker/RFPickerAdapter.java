package com.didi.rfusion.widget.picker;

import com.didi.rfusion.widget.picker.RFPickerItem;
import java.lang.ref.WeakReference;

public abstract class RFPickerAdapter<T extends RFPickerItem> {
    private WeakReference<RFPickerView> pickerViewRef;

    public abstract T getItem(int i);

    public abstract int getItemCount();

    /* access modifiers changed from: package-private */
    public void setPickerView(RFPickerView rFPickerView) {
        this.pickerViewRef = new WeakReference<>(rFPickerView);
    }

    public void notifyDataSetChanged() {
        RFPickerView rFPickerView;
        WeakReference<RFPickerView> weakReference = this.pickerViewRef;
        if (weakReference != null && (rFPickerView = (RFPickerView) weakReference.get()) != null) {
            rFPickerView.mo87981a();
            rFPickerView.mo87983b();
            if (!rFPickerView.getScroller().isFinished()) {
                rFPickerView.getScroller().forceFinished(true);
            }
            rFPickerView.mo87982a(0);
            rFPickerView.invalidate();
        }
    }

    public T getLastItem() {
        return getItem(getItemCount() - 1);
    }

    public String getText(int i) {
        if (getItem(i) == null) {
            return "null";
        }
        return getItem(i).getText();
    }
}
