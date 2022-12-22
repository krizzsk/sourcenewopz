package com.didi.dimina.container.p106ui.pickerview.builder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dimina.container.p106ui.pickerview.configure.PickerOptions;
import com.didi.dimina.container.p106ui.pickerview.listener.CustomListener;
import com.didi.dimina.container.p106ui.pickerview.listener.OnTimeSelectChangeListener;
import com.didi.dimina.container.p106ui.pickerview.listener.OnTimeSelectListener;
import com.didi.dimina.container.p106ui.pickerview.view.TimePickerView;
import com.didi.dimina.container.p106ui.wheelview.view.WheelView;
import java.util.Calendar;

/* renamed from: com.didi.dimina.container.ui.pickerview.builder.TimePickerBuilder */
public class TimePickerBuilder {

    /* renamed from: a */
    private final PickerOptions f17583a;

    public TimePickerBuilder(Context context, OnTimeSelectListener onTimeSelectListener) {
        PickerOptions pickerOptions = new PickerOptions(2);
        this.f17583a = pickerOptions;
        pickerOptions.context = context;
        this.f17583a.timeSelectListener = onTimeSelectListener;
    }

    public TimePickerBuilder setGravity(int i) {
        this.f17583a.textGravity = i;
        return this;
    }

    public TimePickerBuilder addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f17583a.cancelListener = onClickListener;
        return this;
    }

    public TimePickerBuilder setType(boolean[] zArr) {
        this.f17583a.type = zArr;
        return this;
    }

    public TimePickerBuilder setSubmitText(String str) {
        this.f17583a.textContentConfirm = str;
        return this;
    }

    public TimePickerBuilder isDialog(boolean z) {
        this.f17583a.isDialog = z;
        return this;
    }

    public TimePickerBuilder setCancelText(String str) {
        this.f17583a.textContentCancel = str;
        return this;
    }

    public TimePickerBuilder setTitleText(String str) {
        this.f17583a.textContentTitle = str;
        return this;
    }

    public TimePickerBuilder setSubmitColor(int i) {
        this.f17583a.textColorConfirm = i;
        return this;
    }

    public TimePickerBuilder setCancelColor(int i) {
        this.f17583a.textColorCancel = i;
        return this;
    }

    public TimePickerBuilder setDecorView(ViewGroup viewGroup) {
        this.f17583a.decorView = viewGroup;
        return this;
    }

    public TimePickerBuilder setBgColor(int i) {
        this.f17583a.bgColorWheel = i;
        return this;
    }

    public TimePickerBuilder setTitleBgColor(int i) {
        this.f17583a.bgColorTitle = i;
        return this;
    }

    public TimePickerBuilder setTitleColor(int i) {
        this.f17583a.textColorTitle = i;
        return this;
    }

    public TimePickerBuilder setSubCalSize(int i) {
        this.f17583a.textSizeSubmitCancel = i;
        return this;
    }

    public TimePickerBuilder setTitleSize(int i) {
        this.f17583a.textSizeTitle = i;
        return this;
    }

    public TimePickerBuilder setContentTextSize(int i) {
        this.f17583a.textSizeContent = i;
        return this;
    }

    public TimePickerBuilder setItemVisibleCount(int i) {
        this.f17583a.itemsVisibleCount = i;
        return this;
    }

    public TimePickerBuilder isAlphaGradient(boolean z) {
        this.f17583a.isAlphaGradient = z;
        return this;
    }

    public TimePickerBuilder setDate(Calendar calendar) {
        this.f17583a.date = calendar;
        return this;
    }

    public TimePickerBuilder setLayoutRes(int i, CustomListener customListener) {
        this.f17583a.layoutRes = i;
        this.f17583a.customListener = customListener;
        return this;
    }

    public TimePickerBuilder setRangDate(Calendar calendar, Calendar calendar2) {
        this.f17583a.startDate = calendar;
        this.f17583a.endDate = calendar2;
        return this;
    }

    public TimePickerBuilder setLineSpacingMultiplier(float f) {
        this.f17583a.lineSpacingMultiplier = f;
        return this;
    }

    public TimePickerBuilder setDividerColor(int i) {
        this.f17583a.dividerColor = i;
        return this;
    }

    public TimePickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.f17583a.dividerType = dividerType;
        return this;
    }

    @Deprecated
    public TimePickerBuilder setBackgroundId(int i) {
        this.f17583a.outSideColor = i;
        return this;
    }

    public TimePickerBuilder setOutSideColor(int i) {
        this.f17583a.outSideColor = i;
        return this;
    }

    public TimePickerBuilder setTextColorCenter(int i) {
        this.f17583a.textColorCenter = i;
        return this;
    }

    public TimePickerBuilder setTextColorOut(int i) {
        this.f17583a.textColorOut = i;
        return this;
    }

    public TimePickerBuilder isCyclic(boolean z) {
        this.f17583a.cyclic = z;
        return this;
    }

    public TimePickerBuilder setOutSideCancelable(boolean z) {
        this.f17583a.cancelable = z;
        return this;
    }

    public TimePickerBuilder setLunarCalendar(boolean z) {
        this.f17583a.isLunarCalendar = z;
        return this;
    }

    public TimePickerBuilder setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f17583a.label_year = str;
        this.f17583a.label_month = str2;
        this.f17583a.label_day = str3;
        this.f17583a.label_hours = str4;
        this.f17583a.label_minutes = str5;
        this.f17583a.label_seconds = str6;
        return this;
    }

    public TimePickerBuilder setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f17583a.x_offset_year = i;
        this.f17583a.x_offset_month = i2;
        this.f17583a.x_offset_day = i3;
        this.f17583a.x_offset_hours = i4;
        this.f17583a.x_offset_minutes = i5;
        this.f17583a.x_offset_seconds = i6;
        return this;
    }

    public TimePickerBuilder isCenterLabel(boolean z) {
        this.f17583a.isCenterLabel = z;
        return this;
    }

    public TimePickerBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener onTimeSelectChangeListener) {
        this.f17583a.timeSelectChangeListener = onTimeSelectChangeListener;
        return this;
    }

    public TimePickerView build() {
        return new TimePickerView(this.f17583a);
    }
}
