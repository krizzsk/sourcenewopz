package com.didi.sdk.view.timepicker;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.Logger;
import com.didi.sdk.log.Printer;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.TimePickerMode;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Deprecated
public class TimePickerPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f38199a = "miracle-debug";

    /* renamed from: b */
    private static final int f38200b = 0;

    /* renamed from: c */
    private static final int f38201c = 1;

    /* renamed from: d */
    private Wheel f38202d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f38203e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Wheel f38204f;

    /* renamed from: g */
    private String[] f38205g;

    /* renamed from: h */
    private boolean f38206h = false;

    /* renamed from: i */
    private OnTimeSelectedListener f38207i;

    /* renamed from: j */
    private long f38208j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f38209k;

    /* renamed from: l */
    private Locale f38210l = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: m */
    private CommonPopupTitleBar f38211m;

    /* renamed from: n */
    private CharSequence f38212n;

    /* renamed from: o */
    private String f38213o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TimePickerView f38214p;

    /* renamed from: q */
    private View.OnClickListener f38215q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View.OnClickListener f38216r;

    /* renamed from: s */
    private TimeStrategy f38217s = new TimeStrategy();

    /* renamed from: t */
    private TextView f38218t;

    /* renamed from: u */
    private TextView f38219u;

    /* renamed from: v */
    private View f38220v;

    public interface OnTimeSelectedListener {
        void onTimeSelected(long j);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.timepicker_popup;
    }

    public CommonPopupTitleBar getmTitleBar() {
        return this.f38211m;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m27005a();
        m27008a(this.mRootView);
        m27024f();
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f38215q = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f38216r = onClickListener;
    }

    public void setEarliestDelta(int i) {
        if (i >= 0) {
            this.f38217s.setEarliestDelta(i);
            return;
        }
        throw new IllegalArgumentException("earliestDelta can not negative");
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f38211m;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f38212n = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f38211m == null || TextUtils.isEmpty(str)) {
            this.f38213o = str;
        } else {
            this.f38211m.setMessage(str);
        }
    }

    public void setLastSelectedTime(long j) {
        this.f38208j = j;
    }

    public void setBeginHourInDay(int i) {
        this.f38217s.setBeginHourInDay(i);
    }

    public void setBeginMinInDay(int i) {
        this.f38217s.setBeginMinInDay(i);
    }

    public void setEndHourInDay(int i) {
        this.f38217s.setEndHourInDay(i);
    }

    public void setEndMinInDay(int i) {
        this.f38217s.setEndMinInDay(i);
    }

    /* renamed from: a */
    private void m27005a() {
        this.f38205g = m27015b();
    }

    /* renamed from: b */
    private String[] m27015b() {
        LinkedList linkedList = new LinkedList();
        if (this.f38209k) {
            linkedList.add(getResources().getString(R.string.now));
        }
        Calendar instance = Calendar.getInstance();
        int i = 0;
        while (i < 3) {
            instance.setTimeInMillis(System.currentTimeMillis() + ((long) (i * 24 * 3600 * 1000)));
            linkedList.add(TimeStrategy.formatTimeMillionsToMonthDayWeek(getResources(), instance, this.f38210l, i == 0));
            i++;
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public void setIsSupportNow(boolean z) {
        this.f38209k = z;
        this.f38217s.setIsSupportNow(z);
    }

    public void setAppointmentDay(int i) {
        if (i > 0) {
            this.f38217s.setAppointmentDay(i);
            return;
        }
        throw new IllegalArgumentException("appointmentDay can not negative");
    }

    /* renamed from: a */
    private void m27008a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.dismiss();
            }
        });
        this.f38211m = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f38218t = (TextView) view.findViewById(R.id.title_bar2);
        this.f38220v = view.findViewById(R.id.rl_root);
        View findViewById = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f38212n;
        if (charSequence != null) {
            this.f38211m.setTitle(charSequence.toString());
            this.f38218t.setText(this.f38212n.toString());
        }
        if (!TextUtils.isEmpty(this.f38213o)) {
            this.f38211m.setMessage(this.f38213o);
        }
        this.f38211m.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.m27013b(view);
            }
        });
        this.f38219u = (TextView) view.findViewById(R.id.tv_confirm2);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getTimePickerMode() == TimePickerMode.Global) {
            this.f38211m.setVisibility(8);
            this.f38219u.setVisibility(0);
            findViewById.setVisibility(0);
            this.f38220v.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        } else {
            this.f38211m.setVisibility(0);
            this.f38219u.setVisibility(8);
            findViewById.setVisibility(8);
            this.f38220v.setBackgroundResource(R.drawable.common_dialog_bg);
        }
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.m27013b(view);
            }
        });
        this.f38211m.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TraceLogUtil.addLogWithTab("theone_ppx_call01_ck", new String[0]);
                if (TimePickerPopup.this.f38216r != null) {
                    TimePickerPopup.this.f38216r.onClick(view);
                }
                TimePickerPopup.this.dismiss();
            }
        });
        this.f38214p = (TimePickerView) view.findViewById(R.id.time_picker);
        this.f38202d = (Wheel) view.findViewById(R.id.day_picker);
        this.f38203e = (Wheel) view.findViewById(R.id.hour_picker);
        this.f38204f = (Wheel) view.findViewById(R.id.minute_picker);
        this.f38202d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    if (!TimePickerPopup.this.f38209k || i != 0) {
                        TimePickerPopup.this.f38203e.setSuffix(TimePickerPopup.this.getString(R.string.time_picker_hour));
                        TimePickerPopup.this.f38204f.setSuffix(TimePickerPopup.this.getString(R.string.time_picker_min));
                        TimePickerPopup.this.m27006a(0);
                    } else {
                        TimePickerPopup.this.f38203e.setSuffix("");
                        TimePickerPopup.this.f38204f.setSuffix("");
                        TimePickerPopup.this.m27021e();
                    }
                    TimePickerPopup.this.f38214p.setContentDescription(TimePickerPopup.this.m27017c());
                    TimePickerPopup.this.f38214p.sendAccessibilityEvent(128);
                }
            }
        });
        this.f38203e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    TimePickerPopup.this.m27006a(1);
                    TimePickerPopup.this.f38214p.setContentDescription(TimePickerPopup.this.m27017c());
                    TimePickerPopup.this.f38214p.sendAccessibilityEvent(128);
                }
            }
        });
        this.f38204f.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    TimePickerPopup.this.f38214p.setContentDescription(TimePickerPopup.this.m27017c());
                    TimePickerPopup.this.f38214p.sendAccessibilityEvent(128);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27013b(View view) {
        TraceLogUtil.addLogWithTab("theone_ppx_call02_ck", new String[0]);
        if (this.f38207i != null) {
            m27020d();
        }
        View.OnClickListener onClickListener = this.f38215q;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m27017c() {
        String selectedValue = this.f38202d.getSelectedValue();
        String selectedValue2 = this.f38203e.getSelectedValue();
        String selectedValue3 = this.f38204f.getSelectedValue();
        return selectedValue + selectedValue2 + getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m27020d() {
        /*
            r4 = this;
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            com.didi.sdk.view.wheel.Wheel r1 = r4.f38202d
            int r1 = r1.getSelectedIndex()
            boolean r2 = r4.f38209k
            if (r2 == 0) goto L_0x0010
            if (r1 == 0) goto L_0x0050
        L_0x0010:
            com.didi.sdk.view.wheel.Wheel r1 = r4.f38202d
            int r1 = r1.getSelectedIndex()
            r4.m27011a((java.util.Calendar) r0, (int) r1)
            com.didi.sdk.view.wheel.Wheel r1 = r4.f38204f
            java.lang.String r1 = r1.getSelectedValue()
            com.didi.sdk.view.wheel.Wheel r2 = r4.f38203e
            java.lang.String r2 = r2.getSelectedValue()
            boolean r3 = com.didi.sdk.util.TextUtil.isDigit(r1)
            if (r3 == 0) goto L_0x0050
            boolean r3 = com.didi.sdk.util.TextUtil.isDigit(r2)
            if (r3 == 0) goto L_0x0050
            r3 = 12
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
            r0.set(r3, r1)
            r1 = 11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r2 = r2.intValue()
            r0.set(r1, r2)
            long r0 = r0.getTimeInMillis()
            goto L_0x0052
        L_0x0050:
            r0 = 0
        L_0x0052:
            com.didi.sdk.view.timepicker.TimePickerPopup$OnTimeSelectedListener r2 = r4.f38207i
            if (r2 == 0) goto L_0x0059
            r2.onTimeSelected(r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.timepicker.TimePickerPopup.m27020d():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m27021e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.time_picker_now));
        this.f38203e.setData(arrayList);
        this.f38204f.setData(arrayList);
        this.f38203e.setSelectedIndex(0);
        this.f38204f.setSelectedIndex(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27006a(int i) {
        String selectedValue = this.f38203e.getSelectedValue();
        String selectedValue2 = this.f38204f.getSelectedValue();
        if (i == 0 && getString(R.string.time_picker_now).equals(selectedValue)) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(getLatestAvailableTime());
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(System.currentTimeMillis());
            m27011a(instance2, this.f38202d.getSelectedIndex());
            instance2.set(11, instance.get(11));
            instance2.set(12, instance.get(12));
            m27007a(instance.get(11), instance.get(12), instance2);
        } else if (!getString(R.string.time_picker_now).equals(selectedValue) && TextUtil.isDigit(selectedValue) && TextUtil.isDigit(selectedValue2)) {
            Calendar instance3 = Calendar.getInstance();
            m27011a(instance3, this.f38202d.getSelectedIndex());
            instance3.set(12, Integer.valueOf(selectedValue2).intValue());
            instance3.set(11, Integer.valueOf(selectedValue).intValue());
            if (isInvalid(instance3.getTimeInMillis())) {
                m27028i();
                this.f38202d.setSelectedIndex(this.f38209k ? 1 : 0);
                return;
            }
            m27007a(Integer.valueOf(selectedValue).intValue(), Integer.valueOf(selectedValue2).intValue(), instance3);
        }
    }

    /* renamed from: a */
    private void m27011a(Calendar calendar, int i) {
        calendar.add(5, this.f38209k ? ((m27025g() - 1) + i) - 1 : (m27025g() - 1) + i);
    }

    /* renamed from: a */
    private void m27007a(int i, int i2, Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        int i3 = this.f38209k;
        while (true) {
            if (i3 >= this.f38202d.getData().size()) {
                break;
            } else if (instance.get(5) == calendar.get(5)) {
                this.f38202d.setSelectedIndex(i3);
                break;
            } else {
                instance.add(5, 1);
                i3++;
            }
        }
        instance.setTimeInMillis(getLatestAvailableTime());
        if (instance.get(5) == calendar.get(5)) {
            int i4 = instance.get(11);
            m27012b(i4);
            int intValue = Integer.valueOf(this.f38203e.getSelectedValue()).intValue() - Integer.valueOf(i).intValue();
            if (intValue < 0) {
                this.f38203e.setSelectedIndex(-intValue);
            }
            if (i4 == calendar.get(11)) {
                m27018c(instance.get(12));
            } else {
                m27018c(0);
            }
            int intValue2 = Integer.valueOf(this.f38204f.getSelectedValue()).intValue() - Integer.valueOf(i2).intValue();
            if (intValue2 < 0) {
                this.f38204f.setSelectedIndex((-intValue2) / 10);
                return;
            }
            return;
        }
        m27012b(0);
        m27018c(0);
        int intValue3 = Integer.valueOf(this.f38203e.getSelectedValue()).intValue() - Integer.valueOf(i).intValue();
        if (intValue3 < 0) {
            this.f38203e.setSelectedIndex(-intValue3);
        }
        int intValue4 = Integer.valueOf(this.f38204f.getSelectedValue()).intValue() - Integer.valueOf(i2).intValue();
        if (intValue4 < 0) {
            this.f38204f.setSelectedIndex((-intValue4) / 10);
        }
    }

    public void setTimeListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.f38207i = onTimeSelectedListener;
    }

    public long getLatestAvailableTime() {
        return this.f38217s.getLatestAvailableTime();
    }

    /* renamed from: f */
    private void m27024f() {
        long j = this.f38208j;
        if (j != 0 && !isInvalid(j)) {
            this.f38203e.setSuffix(getString(R.string.time_picker_hour));
            this.f38204f.setSuffix(getString(R.string.time_picker_min));
            m27028i();
            long j2 = this.f38208j;
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            m27007a(instance.get(11), instance.get(12), instance);
        } else if (this.f38208j == 0 && this.f38209k) {
            m27027h();
            m27021e();
        } else if (isInvalid(this.f38208j)) {
            this.f38203e.setSuffix(getString(R.string.time_picker_hour));
            this.f38204f.setSuffix(getString(R.string.time_picker_min));
            m27028i();
            this.f38202d.setSelectedIndex(this.f38209k ? 1 : 0);
        }
        this.f38214p.setContentDescription(m27017c());
    }

    /* renamed from: b */
    private void m27012b(int i) {
        List<String> hour = this.f38217s.getHour(i);
        Printer t = Logger.m25813t(f38199a);
        t.mo92477d("init hours = " + hour.toString(), new Object[0]);
        this.f38203e.setData(hour);
    }

    /* renamed from: c */
    private void m27018c(int i) {
        List<String> minute = this.f38217s.getMinute(i);
        Printer t = Logger.m25813t(f38199a);
        t.mo92477d("init minutes = " + minute.toString(), new Object[0]);
        this.f38204f.setData(minute);
    }

    public boolean isInvalid(long j) {
        return this.f38217s.isInvalid(j);
    }

    /* renamed from: g */
    private int m27025g() {
        return this.f38217s.getEarliesDay();
    }

    /* renamed from: h */
    private void m27027h() {
        List<String> day = this.f38217s.getDay(getResources(), this.f38205g, this.f38209k);
        if (day != null) {
            this.f38202d.setData(day);
        }
    }

    /* renamed from: i */
    private void m27028i() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        int i = instance.get(11);
        int i2 = instance.get(12);
        m27027h();
        m27012b(i);
        m27018c(i2);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
