package com.didi.component.dispatchfee.pickview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.didi.sdk.view.picker.FreePicker;
import com.didi.sdk.view.picker.OnPickerListener;
import com.didi.sdk.view.picker.PickerString;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DispatchFeePicker extends FreePicker {

    /* renamed from: a */
    private TextView f12807a;

    /* renamed from: b */
    private TextView f12808b;

    /* renamed from: c */
    private String f12809c;

    /* access modifiers changed from: protected */
    public void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_dispatch_fee_picker_titlebar, (ViewGroup) null);
        setHeadView(inflate);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.global_dispatch_fee_picker_bottom, (ViewGroup) null);
        setBottomView(inflate2);
        this.f12807a = (TextView) inflate.findViewById(R.id.tv_dialog_title);
        this.f12808b = (TextView) inflate2.findViewById(R.id.tv_dialog_confirm);
        inflate.findViewById(R.id.iv_dialog_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DispatchFeePicker.this.dismiss();
            }
        });
        this.f12808b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DispatchFeePicker.this.confirmSelectAndCallback();
                DispatchFeePicker.this.dismiss();
            }
        });
        super.initView();
        m8759a();
    }

    public void setWheelData(List<String> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String pickerString : list) {
                arrayList.add(new PickerString(pickerString));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(arrayList);
            setPickerData((List) arrayList2);
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
        this.f12809c = str;
        m8759a();
    }

    /* renamed from: a */
    private void m8759a() {
        if (this.f12807a != null && !TextUtil.isEmpty(this.f12809c)) {
            this.f12807a.setText(this.f12809c);
        }
    }
}
