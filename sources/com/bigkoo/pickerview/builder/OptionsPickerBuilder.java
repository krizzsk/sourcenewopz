package com.bigkoo.pickerview.builder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.contrarywind.view.WheelView;

public class OptionsPickerBuilder {

    /* renamed from: a */
    private PickerOptions f2073a;

    public OptionsPickerBuilder(Context context, OnOptionsSelectListener onOptionsSelectListener) {
        PickerOptions pickerOptions = new PickerOptions(1);
        this.f2073a = pickerOptions;
        pickerOptions.context = context;
        this.f2073a.optionsSelectListener = onOptionsSelectListener;
    }

    public OptionsPickerBuilder setSubmitText(String str) {
        this.f2073a.textContentConfirm = str;
        return this;
    }

    public OptionsPickerBuilder setCancelText(String str) {
        this.f2073a.textContentCancel = str;
        return this;
    }

    public OptionsPickerBuilder setTitleText(String str) {
        this.f2073a.textContentTitle = str;
        return this;
    }

    public OptionsPickerBuilder isDialog(boolean z) {
        this.f2073a.isDialog = z;
        return this;
    }

    public OptionsPickerBuilder addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f2073a.cancelListener = onClickListener;
        return this;
    }

    public OptionsPickerBuilder setSubmitColor(int i) {
        this.f2073a.textColorConfirm = i;
        return this;
    }

    public OptionsPickerBuilder setCancelColor(int i) {
        this.f2073a.textColorCancel = i;
        return this;
    }

    @Deprecated
    public OptionsPickerBuilder setBackgroundId(int i) {
        this.f2073a.outSideColor = i;
        return this;
    }

    public OptionsPickerBuilder setOutSideColor(int i) {
        this.f2073a.outSideColor = i;
        return this;
    }

    public OptionsPickerBuilder setDecorView(ViewGroup viewGroup) {
        this.f2073a.decorView = viewGroup;
        return this;
    }

    public OptionsPickerBuilder setLayoutRes(int i, CustomListener customListener) {
        this.f2073a.layoutRes = i;
        this.f2073a.customListener = customListener;
        return this;
    }

    public OptionsPickerBuilder setBgColor(int i) {
        this.f2073a.bgColorWheel = i;
        return this;
    }

    public OptionsPickerBuilder setTitleBgColor(int i) {
        this.f2073a.bgColorTitle = i;
        return this;
    }

    public OptionsPickerBuilder setTitleColor(int i) {
        this.f2073a.textColorTitle = i;
        return this;
    }

    public OptionsPickerBuilder setSubCalSize(int i) {
        this.f2073a.textSizeSubmitCancel = i;
        return this;
    }

    public OptionsPickerBuilder setTitleSize(int i) {
        this.f2073a.textSizeTitle = i;
        return this;
    }

    public OptionsPickerBuilder setContentTextSize(int i) {
        this.f2073a.textSizeContent = i;
        return this;
    }

    public OptionsPickerBuilder setOutSideCancelable(boolean z) {
        this.f2073a.cancelable = z;
        return this;
    }

    public OptionsPickerBuilder setLabels(String str, String str2, String str3) {
        this.f2073a.label1 = str;
        this.f2073a.label2 = str2;
        this.f2073a.label3 = str3;
        return this;
    }

    public OptionsPickerBuilder setLineSpacingMultiplier(float f) {
        this.f2073a.lineSpacingMultiplier = f;
        return this;
    }

    public OptionsPickerBuilder setDividerColor(int i) {
        this.f2073a.dividerColor = i;
        return this;
    }

    public OptionsPickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.f2073a.dividerType = dividerType;
        return this;
    }

    public OptionsPickerBuilder setTextColorCenter(int i) {
        this.f2073a.textColorCenter = i;
        return this;
    }

    public OptionsPickerBuilder setTextColorOut(int i) {
        this.f2073a.textColorOut = i;
        return this;
    }

    public OptionsPickerBuilder setTypeface(Typeface typeface) {
        this.f2073a.font = typeface;
        return this;
    }

    public OptionsPickerBuilder setCyclic(boolean z, boolean z2, boolean z3) {
        this.f2073a.cyclic1 = z;
        this.f2073a.cyclic2 = z2;
        this.f2073a.cyclic3 = z3;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i) {
        this.f2073a.option1 = i;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i, int i2) {
        this.f2073a.option1 = i;
        this.f2073a.option2 = i2;
        return this;
    }

    public OptionsPickerBuilder setSelectOptions(int i, int i2, int i3) {
        this.f2073a.option1 = i;
        this.f2073a.option2 = i2;
        this.f2073a.option3 = i3;
        return this;
    }

    public OptionsPickerBuilder setTextXOffset(int i, int i2, int i3) {
        this.f2073a.x_offset_one = i;
        this.f2073a.x_offset_two = i2;
        this.f2073a.x_offset_three = i3;
        return this;
    }

    public OptionsPickerBuilder isCenterLabel(boolean z) {
        this.f2073a.isCenterLabel = z;
        return this;
    }

    public OptionsPickerBuilder setItemVisibleCount(int i) {
        this.f2073a.itemsVisibleCount = i;
        return this;
    }

    public OptionsPickerBuilder isAlphaGradient(boolean z) {
        this.f2073a.isAlphaGradient = z;
        return this;
    }

    public OptionsPickerBuilder isRestoreItem(boolean z) {
        this.f2073a.isRestoreItem = z;
        return this;
    }

    public OptionsPickerBuilder setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f2073a.optionsSelectChangeListener = onOptionsSelectChangeListener;
        return this;
    }

    public <T> OptionsPickerView<T> build() {
        return new OptionsPickerView<>(this.f2073a);
    }
}
