package com.didi.component.dispatchfee.newui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.didi.sdk.view.picker.OnPickerListener;
import com.didi.sdk.view.picker.PickerString;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DispatchFeeNewUiPicker extends FeePicker {

    /* renamed from: a */
    private TextView f12798a;

    /* renamed from: b */
    private TextView f12799b;

    /* renamed from: c */
    private String f12800c;

    /* access modifiers changed from: protected */
    public void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_dispatch_fee_picker_titlebar_new_ui, (ViewGroup) null);
        setHeadView(inflate);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.global_dispatch_fee_picker_bottom_new_ui, (ViewGroup) null);
        setBottomView(inflate2);
        this.f12798a = (TextView) inflate.findViewById(R.id.tv_dialog_title);
        this.f12799b = (TextView) inflate2.findViewById(R.id.tv_dialog_confirm);
        inflate.findViewById(R.id.iv_dialog_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DispatchFeeNewUiPicker.this.dismiss();
            }
        });
        this.f12799b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DispatchFeeNewUiPicker.this.confirmSelectAndCallback();
                DispatchFeeNewUiPicker.this.dismiss();
            }
        });
        super.initView();
        m8749a();
    }

    public void setWheelData(List<String> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String pickerString : list) {
                arrayList.add(new PickerString(pickerString));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(arrayList);
            setPickerData(arrayList2);
        }
    }

    public void setOnSelectListener(final SimpleWheelPopup.OnSelectListener onSelectListener) {
        setPickerListener(new OnPickerListener<PickerString>() {
            public void onResult(List<PickerString> list, int[] iArr) {
                SimpleWheelPopup.OnSelectListener onSelectListener;
                if (list.size() > 0 && iArr.length > 0 && (onSelectListener = onSelectListener) != null) {
                    onSelectListener.onSelect(iArr[0], list.get(0).getSimpleData());
                }
            }
        });
    }

    public void setTitle(String str) {
        this.f12800c = str;
        m8749a();
    }

    /* renamed from: a */
    private void m8749a() {
        if (this.f12798a != null && !TextUtil.isEmpty(this.f12800c)) {
            this.f12798a.setText(this.f12800c);
        }
    }
}
