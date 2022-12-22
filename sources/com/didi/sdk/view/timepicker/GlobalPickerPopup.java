package com.didi.sdk.view.timepicker;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.timepicker.TimePickerPopup;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class GlobalPickerPopup extends SimplePopupBase {

    /* renamed from: a */
    Wheel f38180a;

    /* renamed from: b */
    Wheel f38181b;

    /* renamed from: c */
    Wheel f38182c;

    /* renamed from: d */
    Wheel.OnItemChangedListener f38183d;

    /* renamed from: e */
    Wheel.OnItemChangedListener f38184e;

    /* renamed from: f */
    Wheel.OnItemChangedListener f38185f;

    /* renamed from: g */
    private String[] f38186g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TimePickerView f38187h;

    /* renamed from: i */
    private TimeStrategy f38188i = new TimeStrategy();

    /* renamed from: j */
    private CommonPopupTitleBar f38189j;

    /* renamed from: k */
    private TextView f38190k;

    /* renamed from: l */
    private TextView f38191l;

    /* renamed from: m */
    private View f38192m;

    /* renamed from: n */
    private long f38193n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TimePickerPopup.OnTimeSelectedListener f38194o;

    /* renamed from: p */
    private CharSequence f38195p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<String> f38196q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<String> f38197r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Calendar f38198s = null;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_timepicker_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f38187h = (TimePickerView) this.mRootView.findViewById(R.id.time_picker);
        this.f38180a = (Wheel) this.mRootView.findViewById(R.id.day_picker);
        this.f38181b = (Wheel) this.mRootView.findViewById(R.id.hour_picker);
        this.f38182c = (Wheel) this.mRootView.findViewById(R.id.minute_picker);
        this.f38189j = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f38190k = (TextView) this.mRootView.findViewById(R.id.title_bar2);
        this.f38192m = this.mRootView.findViewById(R.id.rl_root);
        this.f38191l = (TextView) this.mRootView.findViewById(R.id.tv_confirm2);
        this.mRootView.findViewById(R.id.containertitle_bar).setVisibility(0);
        this.f38192m.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        this.f38189j.setVisibility(8);
        this.f38191l.setVisibility(0);
        this.f38181b.setSuffix(getString(R.string.time_picker_hour));
        this.f38182c.setSuffix(getString(R.string.time_picker_min));
        this.f38190k.setText(this.f38195p);
        this.mRootView.findViewById(R.id.imageClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPickerPopup.this.dismiss();
            }
        });
        this.f38184e = new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (GlobalPickerPopup.this.f38180a.getSelectedIndex() == 0 && i == 0) {
                    GlobalPickerPopup.this.f38182c.setVisibility(4);
                } else {
                    GlobalPickerPopup.this.f38182c.setVisibility(0);
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(GlobalPickerPopup.this.getLatestAvailableTime());
                if (GlobalPickerPopup.this.f38180a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f38181b.getSelectedIndex() == 0) {
                    GlobalPickerPopup.this.m26997b(instance.get(12));
                } else if (GlobalPickerPopup.this.f38180a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f38181b.getSelectedIndex() == 1) {
                    GlobalPickerPopup.this.m26997b(instance.get(12));
                } else {
                    GlobalPickerPopup.this.m26997b(0);
                }
                GlobalPickerPopup.this.f38182c.setData(GlobalPickerPopup.this.f38197r);
                GlobalPickerPopup.this.f38187h.setContentDescription(GlobalPickerPopup.this.m26995b());
                GlobalPickerPopup.this.f38187h.sendAccessibilityEvent(128);
            }
        };
        C132533 r0 = new Wheel.OnItemChangedListener() {
            int lastSelectedDate = 0;

            public void onItemChanged(int i) {
                if (i == 0) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(GlobalPickerPopup.this.getLatestAvailableTime());
                    GlobalPickerPopup.this.m26993a(instance.get(11));
                    GlobalPickerPopup.this.f38181b.setData(GlobalPickerPopup.this.f38196q);
                    GlobalPickerPopup.this.f38184e.onItemChanged(0);
                } else if (this.lastSelectedDate == 0) {
                    GlobalPickerPopup.this.m26993a(0);
                    GlobalPickerPopup.this.f38181b.setData(GlobalPickerPopup.this.f38196q);
                    GlobalPickerPopup.this.f38184e.onItemChanged(0);
                }
                this.lastSelectedDate = i;
                GlobalPickerPopup.this.f38187h.setContentDescription(GlobalPickerPopup.this.m26995b());
                GlobalPickerPopup.this.f38187h.sendAccessibilityEvent(128);
            }
        };
        this.f38183d = r0;
        this.f38180a.setOnItemSelectedListener(r0);
        this.f38181b.setOnItemSelectedListener(this.f38184e);
        C132544 r02 = new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                GlobalPickerPopup.this.f38187h.setContentDescription(GlobalPickerPopup.this.m26995b());
                GlobalPickerPopup.this.f38187h.sendAccessibilityEvent(128);
            }
        };
        this.f38185f = r02;
        this.f38182c.setOnItemSelectedListener(r02);
        List<String> day = this.f38188i.getDay(getResources(), m27000c(), false);
        if (day != null) {
            this.f38180a.setData(day);
        }
        this.f38180a.setData(day);
        this.f38180a.setSelectedIndex(0);
        this.f38183d.onItemChanged(0);
        this.mRootView.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                long j = 0;
                if (GlobalPickerPopup.this.f38180a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f38181b.getSelectedIndex() == 0) {
                    GlobalPickerPopup.this.f38194o.onTimeSelected(0);
                    return;
                }
                Calendar instance = GlobalPickerPopup.this.f38198s != null ? (Calendar) GlobalPickerPopup.this.f38198s.clone() : Calendar.getInstance();
                instance.add(5, GlobalPickerPopup.this.f38180a.getSelectedIndex());
                String selectedValue = GlobalPickerPopup.this.f38182c.getSelectedValue();
                String selectedValue2 = GlobalPickerPopup.this.f38181b.getSelectedValue();
                if (TextUtil.isDigit(selectedValue) && TextUtil.isDigit(selectedValue2)) {
                    instance.set(12, Integer.valueOf(selectedValue).intValue());
                    instance.set(11, Integer.valueOf(selectedValue2).intValue());
                    j = instance.getTimeInMillis();
                }
                GlobalPickerPopup.this.f38194o.onTimeSelected(j);
            }
        });
        m26992a();
    }

    /* renamed from: a */
    private void m26992a() {
        if (this.f38193n != 0) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(this.f38193n);
            instance.setTimeInMillis(getLatestAvailableTime());
            int i = 0;
            while (true) {
                if (i >= this.f38180a.getData().size()) {
                    break;
                } else if (instance.get(5) == instance2.get(5)) {
                    this.f38180a.setSelectedIndex(i);
                    this.f38183d.onItemChanged(i);
                    break;
                } else {
                    instance.add(5, 1);
                    i++;
                }
            }
            int i2 = instance2.get(11);
            int i3 = instance2.get(12);
            int i4 = 0;
            while (true) {
                if (i4 >= this.f38181b.getData().size()) {
                    break;
                }
                if (this.f38181b.getData().get(i4).equals(i2 + "")) {
                    this.f38181b.setSelectedIndex(i4);
                    this.f38184e.onItemChanged(i4);
                    if (i4 != 0) {
                        this.f38182c.setVisibility(0);
                    }
                } else {
                    i4++;
                }
            }
            int i5 = ((i3 % 100) / 10) * 10;
            for (int i6 = 0; i6 < this.f38182c.getData().size(); i6++) {
                if (this.f38182c.getData().get(i6).equals(i5 + "")) {
                    this.f38182c.setSelectedIndex(i6);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m26995b() {
        String selectedValue = this.f38180a.getSelectedValue();
        String selectedValue2 = this.f38181b.getSelectedValue();
        String selectedValue3 = this.f38182c.getSelectedValue();
        String str = selectedValue + selectedValue2 + getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min);
        if (this.f38182c.getVisibility() == 0) {
            return str;
        }
        return str.replace(getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min), "");
    }

    public void setTimeListener(TimePickerPopup.OnTimeSelectedListener onTimeSelectedListener) {
        this.f38194o = onTimeSelectedListener;
    }

    public void setBeginHourInDay(int i) {
        this.f38188i.setBeginHourInDay(i);
    }

    public void setBeginMinInDay(int i) {
        this.f38188i.setBeginMinInDay(i);
    }

    public void setEndHourInDay(int i) {
        this.f38188i.setEndHourInDay(i);
    }

    public void setLastSelectedTime(long j) {
        this.f38193n = j;
    }

    public void setAppointmentDay(int i) {
        if (i > 0) {
            this.f38188i.setAppointmentDay(i);
            return;
        }
        throw new IllegalArgumentException("appointmentDay can not negative");
    }

    public void setEarliestDelta(int i) {
        if (i >= 0) {
            this.f38188i.setEarliestDelta(i);
            return;
        }
        throw new IllegalArgumentException("earliestDelta can not negative");
    }

    public long getLatestAvailableTime() {
        return this.f38188i.getLatestAvailableTime();
    }

    public void setTitle(CharSequence charSequence) {
        this.f38195p = charSequence;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26993a(int i) {
        this.f38196q = this.f38188i.getHour(i);
        if (this.f38180a.getSelectedIndex() == 0) {
            this.f38196q.add(0, getResources().getString(R.string.now));
        }
        this.f38181b.setData(this.f38196q);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26997b(int i) {
        List<String> minute = this.f38188i.getMinute(i);
        this.f38197r = minute;
        this.f38182c.setData(minute);
    }

    /* renamed from: c */
    private String[] m27000c() {
        LinkedList linkedList = new LinkedList();
        Calendar instance = Calendar.getInstance();
        int i = 0;
        while (i < 3) {
            instance.setTimeInMillis(System.currentTimeMillis() + ((long) (i * 24 * 3600 * 1000)));
            if (i == 0) {
                Calendar calendar = (Calendar) instance.clone();
                this.f38198s = calendar;
                calendar.add(12, 30);
            }
            linkedList.add(TimeStrategy.formatTimeMillionsToMonthDayWeek(getResources(), instance, ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale(), i == 0));
            i++;
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }
}
