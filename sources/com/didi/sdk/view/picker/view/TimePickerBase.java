package com.didi.sdk.view.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.picker.PickerDataNode;
import com.didi.sdk.view.picker.PickerString;
import com.didi.sdk.view.picker.TimeStrategy;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

abstract class TimePickerBase extends PickerBaseTree<PickerString> {

    /* renamed from: a */
    private boolean f38153a = true;

    /* renamed from: b */
    private boolean f38154b = true;

    /* renamed from: c */
    private TimeZone f38155c = TimeZone.getDefault();
    protected long mFlyToTime;
    protected int mFrontDayRemoveSum;
    protected OnTimeSelectedListener mTimeListener;
    protected TimeStrategy mTimeStrategy = new TimeStrategy();

    public interface OnTimeSelectedListener {
        void onTimeSelected(long j);
    }

    /* access modifiers changed from: protected */
    public abstract List<PickerDataNode<PickerString>> appendCustomData(List<PickerDataNode<PickerString>> list);

    /* access modifiers changed from: protected */
    public int dayOffset() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract long onResultConvert(Calendar calendar, List<PickerString> list, int[] iArr);

    public TimePickerBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        setPickerData(appendCustomData(getDayList()));
        initPickerView();
        this.mHasInit = true;
        m26982a();
    }

    public void setAppointmentDay(int i) {
        if (i > 0) {
            this.mTimeStrategy.setAppointmentDay(i);
            return;
        }
        throw new IllegalArgumentException("appointmentDay can not negative");
    }

    public void setEarliestDelta(int i) {
        if (i >= 0) {
            this.mTimeStrategy.setEarliestDelta(i);
            return;
        }
        throw new IllegalArgumentException("earliestDelta can not negative");
    }

    public void setMinuteDelta(int i) {
        if (i >= 0) {
            this.mTimeStrategy.setMinuteDelta(i);
            return;
        }
        throw new IllegalArgumentException("minuteDelta can not negative");
    }

    public void setBeginHourInDay(int i) {
        this.mTimeStrategy.setBeginHourInDay(i);
    }

    public void setBeginMinInDay(int i) {
        this.mTimeStrategy.setBeginMinInDay(i);
    }

    public void setEndHourInDay(int i) {
        this.mTimeStrategy.setEndHourInDay(i);
    }

    public void setEndMinInDay(int i) {
        this.mTimeStrategy.setEndMinInDay(i);
    }

    public void setLastSelectedTime(long j) {
        this.mFlyToTime = j;
    }

    public void setTimeListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.mTimeListener = onTimeSelectedListener;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f38155c = timeZone;
        this.mTimeStrategy.setTimeZone(timeZone);
    }

    /* access modifiers changed from: protected */
    public List<PickerDataNode<PickerString>> getDayList() {
        List<PickerDataNode<PickerString>> a = m26981a(this.mTimeStrategy.getDay(getResources(), getFirstThreeDays()));
        for (int i = 0; i < a.size(); i++) {
            a.get(i).pointList = getHourList();
        }
        return a;
    }

    private List<PickerDataNode<PickerString>> getHourList() {
        int i;
        if (this.f38153a) {
            Calendar instance = Calendar.getInstance(this.f38155c);
            instance.setTimeInMillis(this.mTimeStrategy.getLatestAvailableTime());
            i = instance.get(11);
            this.f38153a = false;
        } else {
            i = 0;
        }
        List<PickerDataNode<PickerString>> a = m26981a(this.mTimeStrategy.getHour(i));
        for (int i2 = 0; i2 < a.size(); i2++) {
            a.get(i2).pointList = getMinuteList();
        }
        if (a.isEmpty()) {
            this.f38154b = false;
        }
        return a;
    }

    private List<PickerDataNode<PickerString>> getMinuteList() {
        int i = 0;
        if (this.f38154b) {
            Calendar instance = Calendar.getInstance(this.f38155c);
            instance.setTimeInMillis(this.mTimeStrategy.getLatestAvailableTime());
            int i2 = instance.get(12);
            this.f38154b = false;
            i = i2;
        }
        return m26981a(this.mTimeStrategy.getMinute(i));
    }

    private String[] getFirstThreeDays() {
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance(this.f38155c);
        long timeInMillis = instance.getTimeInMillis();
        int i = 0;
        while (i < 3) {
            instance.setTimeInMillis(((long) (i * 24 * 3600 * 1000)) + timeInMillis);
            arrayList.add(this.mTimeStrategy.formatTimeMillionsToMonthDayWeek(getResources(), instance, i == 0));
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public void onSelectConfirm(List<PickerString> list, int[] iArr) {
        long onResultConvert = onResultConvert(this.mTimeStrategy.getLatestAvailableCalendar(), list, iArr);
        OnTimeSelectedListener onTimeSelectedListener = this.mTimeListener;
        if (onTimeSelectedListener != null) {
            onTimeSelectedListener.onTimeSelected(onResultConvert);
        }
    }

    /* access modifiers changed from: protected */
    public void onWheelChanged(List<PickerString> list, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getSimpleData());
            if (i == 1 && TextUtil.isDigit(list.get(i).getSimpleData())) {
                sb.append(getContext().getString(R.string.time_picker_hour));
            }
            if (i == 2 && TextUtil.isDigit(list.get(i).getSimpleData())) {
                sb.append(getContext().getString(R.string.time_picker_min));
            }
        }
        setContentDescription(sb.toString());
        sendAccessibilityEvent(128);
    }

    /* renamed from: a */
    private void m26982a() {
        if (this.mFlyToTime > 0) {
            Calendar instance = Calendar.getInstance(this.f38155c);
            instance.setTimeInMillis(this.mFlyToTime);
            int i = instance.get(11);
            int i2 = instance.get(12);
            int a = m26980a(instance, this.mTimeStrategy.getLatestAvailableCalendar(), this.mTimeStrategy.getLastAvailableCalendar());
            if (a >= 0) {
                int i3 = 0;
                modifyColumn(0, (a - this.mFrontDayRemoveSum) + dayOffset());
                int indexOf = getColumnData(1).indexOf(new PickerString(String.valueOf(i)));
                if (indexOf >= 0) {
                    modifyColumn(1, indexOf);
                    List columnData = getColumnData(2);
                    int i4 = 0;
                    while (true) {
                        if (i4 >= columnData.size()) {
                            break;
                        }
                        PickerString pickerString = (PickerString) columnData.get(i4);
                        if (TextUtil.isDigit(pickerString.getSimpleData()) && Integer.valueOf(pickerString.getSimpleData()).intValue() >= i2) {
                            i3 = i4;
                            break;
                        }
                        i4++;
                    }
                    modifyColumn(2, i3);
                    return;
                }
                modifyColumn(1, 0);
                modifyColumn(2, 0);
            }
        }
    }

    /* renamed from: a */
    private int m26980a(Calendar calendar, Calendar calendar2, Calendar calendar3) {
        Calendar calendar4 = (Calendar) calendar.clone();
        calendar4.set(11, 0);
        calendar4.set(12, 0);
        calendar4.set(13, 0);
        Calendar calendar5 = (Calendar) calendar2.clone();
        calendar5.set(11, 0);
        calendar5.set(12, 0);
        calendar5.set(13, 0);
        Calendar calendar6 = (Calendar) calendar3.clone();
        calendar6.set(11, 0);
        calendar6.set(12, 0);
        calendar6.set(13, 0);
        long timeInMillis = calendar4.getTimeInMillis() - calendar5.getTimeInMillis();
        long timeInMillis2 = calendar6.getTimeInMillis() - calendar4.getTimeInMillis();
        if (timeInMillis < 0 || timeInMillis2 < 0) {
            return -1;
        }
        return (int) (timeInMillis / 86400000);
    }

    /* renamed from: a */
    private static List<PickerDataNode<PickerString>> m26981a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String pickerString : list) {
            arrayList.add(new PickerDataNode(new PickerString(pickerString)));
        }
        return arrayList;
    }
}
