package com.didi.dimina.container.p106ui.pickerview.builder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dimina.container.p106ui.pickerview.configure.PickerOptions;
import com.didi.dimina.container.p106ui.pickerview.listener.CustomListener;
import com.didi.dimina.container.p106ui.pickerview.listener.OnOptionsSelectChangeListener;
import com.didi.dimina.container.p106ui.pickerview.listener.OnOptionsSelectListener;
import com.didi.dimina.container.p106ui.pickerview.view.OptionsPickerView;
import com.didi.dimina.container.p106ui.wheelview.view.WheelView;

/* renamed from: com.didi.dimina.container.ui.pickerview.builder.OptionsPickerBuilder */
public class OptionsPickerBuilder {

    /* renamed from: a */
    private final PickerOptions f17582a;

    public OptionsPickerBuilder(Context context, OnOptionsSelectListener onOptionsSelectListener) {
        PickerOptions pickerOptions = new PickerOptions(1);
        this.f17582a = pickerOptions;
        pickerOptions.context = context;
        this.f17582a.optionsSelectListener = onOptionsSelectListener;
    }

    public OptionsPickerBuilder setSubmitText(String str) {
        this.f17582a.textContentConfirm = str;
        return this;
    }

    public OptionsPickerBuilder setCancelText(String str) {
        this.f17582a.textContentCancel = str;
        return this;
    }

    public OptionsPickerBuilder setTitleText(String str) {
        this.f17582a.textContentTitle = str;
        return this;
    }

    public OptionsPickerBuilder isDialog(boolean z) {
        this.f17582a.isDialog = z;
        return this;
    }

    public OptionsPickerBuilder addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f17582a.cancelListener = onClickListener;
        return this;
    }

    public OptionsPickerBuilder setSubmitColor(int i) {
        this.f17582a.textColorConfirm = i;
        return this;
    }

    public OptionsPickerBuilder setCancelColor(int i) {
        this.f17582a.textColorCancel = i;
        return this;
    }

    @Deprecated
    public OptionsPickerBuilder setBackgroundId(int i) {
        this.f17582a.outSideColor = i;
        return this;
    }

    public OptionsPickerBuilder setOutSideColor(int i) {
        this.f17582a.outSideColor = i;
        return this;
    }

    public OptionsPickerBuilder setDecorView(ViewGroup viewGroup) {
        this.f17582a.decorView = viewGroup;
        return this;
    }

    public OptionsPickerBuilder setLayoutRes(int i, CustomListener customListener) {
        this.f17582a.layoutRes = i;
        this.f17582a.customListener = customListener;
        return this;
    }

    public OptionsPickerBuilder setBgColor(int i) {
        this.f17582a.bgColorWheel = i;
        return this;
    }

    public OptionsPickerBuilder setTitleBgColor(int i) {
        this.f17582a.bgColorTitle = i;
        return this;
    }

    public OptionsPickerBuilder setTitleColor(int i) {
        this.f17582a.textColorTitle = i;
        return this;
    }

    public OptionsPickerBuilder setSubCalSize(int i) {
        this.f17582a.textSizeSubmitCancel = i;
        return this;
    }

    public OptionsPickerBuilder setTitleSize(int i) {
        this.f17582a.textSizeTitle = i;
        return this;
    }

    public OptionsPickerBuilder setContentTextSize(int i) {
        this.f17582a.textSizeContent = i;
        return this;
    }

    public OptionsPickerBuilder setOutSideCancelable(boolean z) {
        this.f17582a.cancelable = z;
        return this;
    }

    public OptionsPickerBuilder setLabels(String str, String str2, String str3) {
        this.f17582a.label1 = str;
        this.f17582a.label2 = str2;
        this.f17582a.label3 = str3;
        return this;
    }

    public OptionsPickerBuilder setLineSpacingMultiplier(float f) {
        this.f17582a.lineSpacingMultiplier = f;
        return this;
    }

    public OptionsPickerBuilder setDividerColor(int i) {
        this.f17582a.dividerColor = i;
        return this;
    }

    public OptionsPickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.f17582a.dividerType = dividerType;
        return this;
    }

    public OptionsPickerBuilder setTextColorCenter(int i) {
        this.f17582a.textColorCenter = i;
        return this;
    }

    public OptionsPickerBuilder setTextColorOut(int i) {
        this.f17582a.textColorOut = i;
        return this;
    }

    public OptionsPickerBuilder setTypeface(Typeface typeface) {
        this.f17582a.font = typeface;
        return this;
    }

    public OptionsPickerBuilder setCyclic(boolean z, boolean z2, boolean z3) {
        this.f17582a.cyclic1 = z;
        this.f17582a.cyclic2 = z2;
        this.f17582a.cyclic3 = z3;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i) {
        this.f17582a.option1 = i;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i, int i2) {
        this.f17582a.option1 = i;
        this.f17582a.option2 = i2;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i, int i2, int i3) {
        this.f17582a.option1 = i;
        this.f17582a.option2 = i2;
        this.f17582a.option3 = i3;
        return this;
    }

    public OptionsPickerBuilder setTextXOffset(int i, int i2, int i3) {
        this.f17582a.x_offset_one = i;
        this.f17582a.x_offset_two = i2;
        this.f17582a.x_offset_three = i3;
        return this;
    }

    public OptionsPickerBuilder isCenterLabel(boolean z) {
        this.f17582a.isCenterLabel = z;
        return this;
    }

    public OptionsPickerBuilder setItemVisibleCount(int i) {
        this.f17582a.itemsVisibleCount = i;
        return this;
    }

    public OptionsPickerBuilder isAlphaGradient(boolean z) {
        this.f17582a.isAlphaGradient = z;
        return this;
    }

    public OptionsPickerBuilder isRestoreItem(boolean z) {
        this.f17582a.isRestoreItem = z;
        return this;
    }

    public OptionsPickerBuilder setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f17582a.optionsSelectChangeListener = onOptionsSelectChangeListener;
        return this;
    }

    public <T> OptionsPickerView<T> build() {
        return new OptionsPickerView<>(this.f17582a);
    }
}
