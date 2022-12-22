package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.global.globaluikit.datepicker.LEGOWheelPicker;
import com.global.didi.elvish.Elvish;
import java.text.NumberFormat;
import java.util.ArrayList;

public class LEGOHourPicker extends LEGOWheelPicker<C8646b> {
    public static final int sBeginHourInDay = 0;
    public static final int sEndHourInDay = 23;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnHourSelectedListener f22464a;

    /* renamed from: b */
    private int f22465b;

    /* renamed from: c */
    private int f22466c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C8646b f22467d;

    /* renamed from: e */
    private boolean f22468e;

    public interface OnHourSelectedListener {
        void onHourSelected(int i);
    }

    public LEGOHourPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOHourPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOHourPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22467d = new C8646b(0);
        m16178a();
        setOnWheelChangeListener(new LEGOWheelPicker.OnWheelChangeListener<C8646b>() {
            public void onWheelSelected(C8646b bVar, int i) {
                C8646b unused = LEGOHourPicker.this.f22467d = bVar;
                if (LEGOHourPicker.this.f22464a != null) {
                    LEGOHourPicker.this.f22464a.onHourSelected(bVar.mo66888a());
                }
            }
        });
    }

    /* renamed from: a */
    private void m16178a() {
        setItemMaximumWidthText(C8645a.f22475b);
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(2);
        setDataFormat(numberInstance);
        this.f22465b = 0;
        this.f22466c = 23;
        this.f22467d = new C8646b(Elvish.Companion.getInstance().getDateTimeCalendar(System.currentTimeMillis()).get(11));
        updateHour();
    }

    public void updateHour(boolean z) {
        ArrayList arrayList = new ArrayList();
        C8646b bVar = new C8646b(-1);
        if (this.f22468e && !z) {
            arrayList.add(bVar);
        }
        int i = this.f22465b;
        if (i != this.f22466c) {
            while (i <= this.f22466c) {
                arrayList.add(new C8646b(i));
                i++;
            }
        } else if (i != bVar.mo66888a()) {
            arrayList.add(new C8646b(this.f22465b));
        }
        setDataList(arrayList);
    }

    public void updateHour() {
        updateHour(false);
    }

    public int getSelectedHour() {
        return this.f22467d.mo66888a();
    }

    public void setBeginHourInDay(int i, boolean z, boolean z2) {
        this.f22468e = z;
        this.f22465b = i;
        C8646b bVar = this.f22467d;
        if (z) {
            i = -1;
        }
        bVar.mo66889a(i);
        if (z2) {
            this.f22467d.mo66889a(this.f22465b);
        }
    }

    public void setEndHourInDay(int i) {
        this.f22466c = i;
    }

    public void setSelectedHour(int i) {
        setSelectedHour(i, false);
    }

    public void setSelectedHour(int i, boolean z) {
        this.f22467d.mo66889a(i);
        setCurrentItem(this.f22467d, z);
    }

    public void setOnHourSelectedListener(OnHourSelectedListener onHourSelectedListener) {
        this.f22464a = onHourSelectedListener;
    }
}
