package com.didi.sdk.view.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.picker.PickerDataNode;
import com.didi.sdk.view.picker.PickerString;
import com.didi.sdk.view.picker.Style;
import com.didi.sdk.view.picker.view.TimePickerBase;
import com.taxis99.R;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class TimePickerLocalView extends TimePickerBase {

    /* renamed from: a */
    private boolean f38156a;

    public /* bridge */ /* synthetic */ void setAppointmentDay(int i) {
        super.setAppointmentDay(i);
    }

    public /* bridge */ /* synthetic */ void setBeginHourInDay(int i) {
        super.setBeginHourInDay(i);
    }

    public /* bridge */ /* synthetic */ void setBeginMinInDay(int i) {
        super.setBeginMinInDay(i);
    }

    public /* bridge */ /* synthetic */ void setEarliestDelta(int i) {
        super.setEarliestDelta(i);
    }

    public /* bridge */ /* synthetic */ void setEndHourInDay(int i) {
        super.setEndHourInDay(i);
    }

    public /* bridge */ /* synthetic */ void setEndMinInDay(int i) {
        super.setEndMinInDay(i);
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(int[] iArr) {
        super.setInitialSelect(iArr);
    }

    public /* bridge */ /* synthetic */ void setLastSelectedTime(long j) {
        super.setLastSelectedTime(j);
    }

    public /* bridge */ /* synthetic */ void setMinuteDelta(int i) {
        super.setMinuteDelta(i);
    }

    public /* bridge */ /* synthetic */ void setPickerData(List list) {
        super.setPickerData(list);
    }

    public /* bridge */ /* synthetic */ void setTimeListener(TimePickerBase.OnTimeSelectedListener onTimeSelectedListener) {
        super.setTimeListener(onTimeSelectedListener);
    }

    public /* bridge */ /* synthetic */ void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
    }

    public TimePickerLocalView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TimePickerLocalView(Context context, AttributeSet attributeSet) {
        this(context, (AttributeSet) null, 0);
    }

    public TimePickerLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mHasInit) {
            setStyleInner(new Style.Builder().setWeight(2, 1, 1).setSuffix("", getContext().getString(R.string.time_picker_hour), getContext().getString(R.string.time_picker_min)).setSuffixScope("", "^[0-9]*$", "^[0-9]*$").build());
            initView();
        }
    }

    public void setIsSupportNow(boolean z) {
        this.f38156a = z;
    }

    /* access modifiers changed from: protected */
    public List<PickerDataNode<PickerString>> appendCustomData(List<PickerDataNode<PickerString>> list) {
        if (!list.isEmpty() && (list.get(0).pointList == null || list.get(0).pointList.isEmpty())) {
            this.mFrontDayRemoveSum = 1;
            setAppointmentDay(this.mTimeStrategy.getAppointmentDay() + 1);
            list = getDayList();
            list.remove(0);
        }
        if (this.f38156a) {
            list.add(0, new PickerDataNode(new PickerString(getResources().getString(R.string.now)), Collections.singletonList(new PickerDataNode(new PickerString("--"), Collections.singletonList(new PickerDataNode(new PickerString("--")))))));
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public long onResultConvert(Calendar calendar, List<PickerString> list, int[] iArr) {
        if (this.f38156a && iArr[0] == 0) {
            return 0;
        }
        calendar.add(5, (iArr[0] + this.mFrontDayRemoveSum) - dayOffset());
        if (list.size() > 1 && TextUtil.isDigit(list.get(1).getSimpleData())) {
            calendar.set(11, Integer.valueOf(list.get(1).getSimpleData()).intValue());
        }
        if (list.size() > 2 && TextUtil.isDigit(list.get(2).getSimpleData())) {
            calendar.set(12, Integer.valueOf(list.get(2).getSimpleData()).intValue());
        }
        return calendar.getTimeInMillis();
    }

    /* access modifiers changed from: protected */
    public int dayOffset() {
        return this.f38156a ? 1 : 0;
    }
}
