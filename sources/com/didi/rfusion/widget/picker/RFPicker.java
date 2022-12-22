package com.didi.rfusion.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.rfusion.widget.picker.RFPickerView;
import java.util.ArrayList;
import java.util.List;

public class RFPicker extends RFPickerViewGroup {

    /* renamed from: a */
    private final List<RFPickerView> f33612a = new ArrayList();

    /* renamed from: b */
    private OnSelectedValueChangedListener f33613b;

    public interface OnSelectedValueChangedListener {
        void onSelectedItemChanged(List<RFPickerItem> list);
    }

    public RFPicker(Context context) {
        super(context);
    }

    public RFPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPicker(List<RFPickerAdapter<? extends RFPickerItem>> list) {
        clear();
        for (RFPickerAdapter<? extends RFPickerItem> addPicker : list) {
            addPicker(addPicker);
        }
    }

    public void setPicker(RFPickerAdapter<? extends RFPickerItem>... rFPickerAdapterArr) {
        clear();
        for (RFPickerAdapter<? extends RFPickerItem> addPicker : rFPickerAdapterArr) {
            addPicker(addPicker);
        }
    }

    public void addPicker(RFPickerAdapter<? extends RFPickerItem> rFPickerAdapter) {
        addPicker(this.f33612a.size(), rFPickerAdapter);
    }

    public void addPicker(int i, RFPickerAdapter<? extends RFPickerItem> rFPickerAdapter) {
        RFPickerView rFPickerView = new RFPickerView(getContext());
        this.f33612a.add(i, rFPickerView);
        rFPickerView.setAdapter(rFPickerAdapter);
        rFPickerView.setOnSelectedItemChangedListener(new RFPickerView.OnSelectedItemChangedListener() {
            public final void onSelectedItemChanged(RFPickerView rFPickerView, int i, int i2) {
                RFPicker.this.m23682a(rFPickerView, i, i2);
            }
        });
        addPickerView(rFPickerView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23682a(RFPickerView rFPickerView, int i, int i2) {
        OnSelectedValueChangedListener onSelectedValueChangedListener = this.f33613b;
        if (onSelectedValueChangedListener != null) {
            onSelectedValueChangedListener.onSelectedItemChanged(getSelectedItems());
        }
    }

    public void removePicker(int i) {
        removePickerView(this.f33612a.remove(i));
    }

    public void setSelectedItem(int i, int i2) {
        this.f33612a.get(i).setSelectedItemPosition(i2);
    }

    public void clear() {
        this.f33612a.clear();
        removeAllPickerViews();
    }

    public void setSelectedItems(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            setSelectedItem(i, list.get(i).intValue());
        }
    }

    public List<RFPickerItem> getSelectedItems() {
        ArrayList arrayList = new ArrayList(this.f33612a.size());
        for (RFPickerView selectedItem : this.f33612a) {
            arrayList.add(selectedItem.getSelectedItem(RFPickerItem.class));
        }
        return arrayList;
    }

    public void setOnSelectedValueChangeListener(OnSelectedValueChangedListener onSelectedValueChangedListener) {
        this.f33613b = onSelectedValueChangedListener;
    }
}
