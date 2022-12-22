package com.bigkoo.pickerview.builder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.view.WheelView;
import java.util.Calendar;

public class TimePickerBuilder {

    /* renamed from: a */
    private PickerOptions f2074a;

    public TimePickerBuilder(Context context, OnTimeSelectListener onTimeSelectListener) {
        PickerOptions pickerOptions = new PickerOptions(2);
        this.f2074a = pickerOptions;
        pickerOptions.context = context;
        this.f2074a.timeSelectListener = onTimeSelectListener;
    }

    public TimePickerBuilder setGravity(int i) {
        this.f2074a.textGravity = i;
        return this;
    }

    public TimePickerBuilder addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f2074a.cancelListener = onClickListener;
        return this;
    }

    public TimePickerBuilder setType(boolean[] zArr) {
        this.f2074a.type = zArr;
        return this;
    }

    public TimePickerBuilder setSubmitText(String str) {
        this.f2074a.textContentConfirm = str;
        return this;
    }

    public TimePickerBuilder isDialog(boolean z) {
        this.f2074a.isDialog = z;
        return this;
    }

    public TimePickerBuilder setCancelText(String str) {
        this.f2074a.textContentCancel = str;
        return this;
    }

    public TimePickerBuilder setTitleText(String str) {
        this.f2074a.textContentTitle = str;
        return this;
    }

    public TimePickerBuilder setSubmitColor(int i) {
        this.f2074a.textColorConfirm = i;
        return this;
    }

    public TimePickerBuilder setCancelColor(int i) {
        this.f2074a.textColorCancel = i;
        return this;
    }

    public TimePickerBuilder setDecorView(ViewGroup viewGroup) {
        this.f2074a.decorView = viewGroup;
        return this;
    }

    public TimePickerBuilder setBgColor(int i) {
        this.f2074a.bgColorWheel = i;
        return this;
    }

    public TimePickerBuilder setTitleBgColor(int i) {
        this.f2074a.bgColorTitle = i;
        return this;
    }

    public TimePickerBuilder setTitleColor(int i) {
        this.f2074a.textColorTitle = i;
        return this;
    }

    public TimePickerBuilder setSubCalSize(int i) {
        this.f2074a.textSizeSubmitCancel = i;
        return this;
    }

    public TimePickerBuilder setTitleSize(int i) {
        this.f2074a.textSizeTitle = i;
        return this;
    }

    public TimePickerBuilder setContentTextSize(int i) {
        this.f2074a.textSizeContent = i;
        return this;
    }

    public TimePickerBuilder setItemVisibleCount(int i) {
        this.f2074a.itemsVisibleCount = i;
        return this;
    }

    public TimePickerBuilder isAlphaGradient(boolean z) {
        this.f2074a.isAlphaGradient = z;
        return this;
    }

    public TimePickerBuilder setDate(Calendar calendar) {
        this.f2074a.date = calendar;
        return this;
    }

    public TimePickerBuilder setLayoutRes(int i, CustomListener customListener) {
        this.f2074a.layoutRes = i;
        this.f2074a.customListener = customListener;
        return this;
    }

    public TimePickerBuilder setRangDate(Calendar calendar, Calendar calendar2) {
        this.f2074a.startDate = calendar;
        this.f2074a.endDate = calendar2;
        return this;
    }

    public TimePickerBuilder setLineSpacingMultiplier(float f) {
        this.f2074a.lineSpacingMultiplier = f;
        return this;
    }

    public TimePickerBuilder setDividerColor(int i) {
        this.f2074a.dividerColor = i;
        return this;
    }

    public TimePickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.f2074a.dividerType = dividerType;
        return this;
    }

    @Deprecated
    public TimePickerBuilder setBackgroundId(int i) {
        this.f2074a.outSideColor = i;
        return this;
    }

    public TimePickerBuilder setOutSideColor(int i) {
        this.f2074a.outSideColor = i;
        return this;
    }

    public TimePickerBuilder setTextColorCenter(int i) {
        this.f2074a.textColorCenter = i;
        return this;
    }

    public TimePickerBuilder setTextColorOut(int i) {
        this.f2074a.textColorOut = i;
        return this;
    }

    public TimePickerBuilder isCyclic(boolean z) {
        this.f2074a.cyclic = z;
        return this;
    }

    public TimePickerBuilder setOutSideCancelable(boolean z) {
        this.f2074a.cancelable = z;
        return this;
    }

    public TimePickerBuilder setLunarCalendar(boolean z) {
        this.f2074a.isLunarCalendar = z;
        return this;
    }

    public TimePickerBuilder setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f2074a.label_year = str;
        this.f2074a.label_month = str2;
        this.f2074a.label_day = str3;
        this.f2074a.label_hours = str4;
        this.f2074a.label_minutes = str5;
        this.f2074a.label_seconds = str6;
        return this;
    }

    public TimePickerBuilder setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2074a.x_offset_year = i;
        this.f2074a.x_offset_month = i2;
        this.f2074a.x_offset_day = i3;
        this.f2074a.x_offset_hours = i4;
        this.f2074a.x_offset_minutes = i5;
        this.f2074a.x_offset_seconds = i6;
        return this;
    }

    public TimePickerBuilder isCenterLabel(boolean z) {
        this.f2074a.isCenterLabel = z;
        return this;
    }

    public TimePickerBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener onTimeSelectChangeListener) {
        this.f2074a.timeSelectChangeListener = onTimeSelectChangeListener;
        return this;
    }

    public TimePickerView build() {
        return new TimePickerView(this.f2074a);
    }
}
