package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.global.globaluikit.datepicker.LEGOWheelPicker;
import java.text.NumberFormat;
import java.util.ArrayList;

public class LEGOMinutePicker extends LEGOWheelPicker<Integer> {
    public static final int sBeginMinuteInHour = 0;
    public static final int sEndMinuteInHour = 59;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnMinuteSelectedListener f22469a;

    /* renamed from: b */
    private int f22470b;

    /* renamed from: c */
    private int f22471c;

    /* renamed from: d */
    private int f22472d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22473e;

    public interface OnMinuteSelectedListener {
        void onMinuteSelected(int i);
    }

    public LEGOMinutePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOMinutePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOMinutePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22470b = 1;
        m16181a();
        setOnWheelChangeListener(new LEGOWheelPicker.OnWheelChangeListener<Integer>() {
            public void onWheelSelected(Integer num, int i) {
                int unused = LEGOMinutePicker.this.f22473e = num.intValue();
                if (LEGOMinutePicker.this.f22469a != null) {
                    LEGOMinutePicker.this.f22469a.onMinuteSelected(num.intValue());
                }
            }
        });
    }

    /* renamed from: a */
    private void m16181a() {
        setItemMaximumWidthText("00");
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(2);
        setDataFormat(numberInstance);
        this.f22471c = 0;
        this.f22472d = 59;
        updateMinute();
    }

    public void updateMinute() {
        ArrayList arrayList = new ArrayList();
        int i = this.f22471c / this.f22470b;
        while (true) {
            int i2 = this.f22472d;
            int i3 = this.f22470b;
            if (i <= i2 / i3) {
                arrayList.add(Integer.valueOf(i3 * i));
                i++;
            } else {
                setDataList(arrayList);
                return;
            }
        }
    }

    public void setBeginMinuteInHour(int i) {
        this.f22471c = i;
        this.f22473e = i;
    }

    public void setEndMinuteInHour(int i) {
        if (i > 59) {
            i = 59;
        }
        this.f22472d = i;
    }

    public int getSelectedMinute() {
        return this.f22473e;
    }

    public void setDelta(int i) {
        this.f22470b = i;
    }

    public void setSelectedMinute(int i) {
        setSelectedMinute(i, false);
    }

    public void setSelectedMinute(int i, boolean z) {
        if (getDataList().indexOf(Integer.valueOf(i)) < 0) {
            this.f22473e = ((Integer) getDataList().get(0)).intValue();
        } else {
            this.f22473e = i;
        }
        setCurrentItem(Integer.valueOf(i), z);
    }

    public void setOnMinuteSelectedListener(OnMinuteSelectedListener onMinuteSelectedListener) {
        this.f22469a = onMinuteSelectedListener;
    }
}
