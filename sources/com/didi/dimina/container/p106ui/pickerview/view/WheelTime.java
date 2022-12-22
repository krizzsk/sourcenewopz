package com.didi.dimina.container.p106ui.pickerview.view;

import android.view.View;
import com.didi.dimina.container.p106ui.pickerview.adapter.ArrayWheelAdapter;
import com.didi.dimina.container.p106ui.pickerview.adapter.NumericWheelAdapter;
import com.didi.dimina.container.p106ui.pickerview.listener.ISelectTimeCallback;
import com.didi.dimina.container.p106ui.pickerview.utils.ChinaDate;
import com.didi.dimina.container.p106ui.pickerview.utils.LunarCalendar;
import com.didi.dimina.container.p106ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p106ui.wheelview.view.WheelView;
import com.taxis99.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.WheelTime */
public class WheelTime {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: k */
    private static final int f17629k = 1900;

    /* renamed from: l */
    private static final int f17630l = 2100;

    /* renamed from: m */
    private static final int f17631m = 1;

    /* renamed from: n */
    private static final int f17632n = 12;

    /* renamed from: o */
    private static final int f17633o = 1;

    /* renamed from: p */
    private static final int f17634p = 31;

    /* renamed from: q */
    private static final int f17635q = 0;

    /* renamed from: r */
    private static final int f17636r = 23;

    /* renamed from: s */
    private static final int f17637s = 0;

    /* renamed from: t */
    private static final int f17638t = 59;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f17639A = 1;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f17640B = 31;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f17641C = 1;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f17642D = 31;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f17643E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f17644F;

    /* renamed from: G */
    private final int f17645G;

    /* renamed from: H */
    private boolean f17646H = false;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public ISelectTimeCallback f17647I;

    /* renamed from: a */
    int f17648a;

    /* renamed from: b */
    private final View f17649b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WheelView f17650c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WheelView f17651d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WheelView f17652e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WheelView f17653f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WheelView f17654g;

    /* renamed from: h */
    private WheelView f17655h;

    /* renamed from: i */
    private final int f17656i;

    /* renamed from: j */
    private final boolean[] f17657j;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f17658u = 1900;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f17659v = 2100;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f17660w = 1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f17661x = 12;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f17662y = 1;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f17663z = 31;

    public WheelTime(View view, boolean[] zArr, int i, int i2) {
        this.f17649b = view;
        this.f17657j = zArr;
        this.f17656i = i;
        this.f17645G = i2;
    }

    public void setLunarMode(boolean z) {
        this.f17646H = z;
    }

    public boolean isLunarMode() {
        return this.f17646H;
    }

    public void setPicker(int i, int i2, int i3) {
        setPicker(i, i2, i3, 0, 0, 0);
    }

    public void setPicker(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f17646H) {
            int[] solarToLunar = LunarCalendar.solarToLunar(i, i2 + 1, i3);
            m13128a(solarToLunar[0], solarToLunar[1] - 1, solarToLunar[2], solarToLunar[3] == 1, i4, i5, i6);
            return;
        }
        m13126a(i, i2, i3, i4, i5, i6);
    }

    /* renamed from: a */
    private void m13128a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.f17649b.findViewById(R.id.year);
        this.f17650c = wheelView;
        wheelView.setAdapter(new ArrayWheelAdapter(ChinaDate.getYears(this.f17658u, this.f17659v)));
        this.f17650c.setLabel("");
        this.f17650c.setCurrentItem(i - this.f17658u);
        this.f17650c.setGravity(this.f17656i);
        WheelView wheelView2 = (WheelView) this.f17649b.findViewById(R.id.month);
        this.f17651d = wheelView2;
        wheelView2.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i)));
        this.f17651d.setLabel("");
        int leapMonth = ChinaDate.leapMonth(i);
        if (leapMonth == 0 || (i2 <= leapMonth - 1 && !z)) {
            this.f17651d.setCurrentItem(i2);
        } else {
            this.f17651d.setCurrentItem(i2 + 1);
        }
        this.f17651d.setGravity(this.f17656i);
        this.f17652e = (WheelView) this.f17649b.findViewById(R.id.day);
        if (ChinaDate.leapMonth(i) == 0) {
            this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i, i2))));
        } else {
            this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i))));
        }
        this.f17652e.setLabel("");
        this.f17652e.setCurrentItem(i3 - 1);
        this.f17652e.setGravity(this.f17656i);
        this.f17650c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int a = i + WheelTime.this.f17658u;
                WheelTime.this.f17651d.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(a)));
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f17651d.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f17651d.setCurrentItem(WheelTime.this.f17651d.getCurrentItem());
                } else {
                    WheelTime.this.f17651d.setCurrentItem(WheelTime.this.f17651d.getCurrentItem() + 1);
                }
                int currentItem = WheelTime.this.f17652e.getCurrentItem();
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f17651d.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f17651d.getCurrentItem() + 1))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f17651d.getCurrentItem() + 1);
                } else if (WheelTime.this.f17651d.getCurrentItem() == ChinaDate.leapMonth(a) + 1) {
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(a))));
                    i2 = ChinaDate.leapDays(a);
                } else {
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f17651d.getCurrentItem()))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f17651d.getCurrentItem());
                }
                int i3 = i2 - 1;
                if (currentItem > i3) {
                    WheelTime.this.f17652e.setCurrentItem(i3);
                }
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
            }
        });
        this.f17651d.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int currentItem = WheelTime.this.f17650c.getCurrentItem() + WheelTime.this.f17658u;
                int currentItem2 = WheelTime.this.f17652e.getCurrentItem();
                if (ChinaDate.leapMonth(currentItem) == 0 || i <= ChinaDate.leapMonth(currentItem) - 1) {
                    int i3 = i + 1;
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i3))));
                    i2 = ChinaDate.monthDays(currentItem, i3);
                } else if (WheelTime.this.f17651d.getCurrentItem() == ChinaDate.leapMonth(currentItem) + 1) {
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(currentItem))));
                    i2 = ChinaDate.leapDays(currentItem);
                } else {
                    WheelTime.this.f17652e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i))));
                    i2 = ChinaDate.monthDays(currentItem, i);
                }
                int i4 = i2 - 1;
                if (currentItem2 > i4) {
                    WheelTime.this.f17652e.setCurrentItem(i4);
                }
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
            }
        });
        this.f17653f = (WheelView) this.f17649b.findViewById(R.id.hour);
        this.f17654g = (WheelView) this.f17649b.findViewById(R.id.min);
        this.f17655h = (WheelView) this.f17649b.findViewById(R.id.second);
        this.f17644F = i4;
        this.f17653f.setAdapter(new NumericWheelAdapter(this.f17639A, this.f17640B));
        this.f17653f.setCurrentItem(i4 - this.f17639A);
        this.f17653f.setGravity(this.f17656i);
        int i7 = this.f17639A;
        int i8 = this.f17640B;
        int i9 = 0;
        if (i7 == i8) {
            this.f17654g.setAdapter(new NumericWheelAdapter(this.f17641C, this.f17642D));
            this.f17654g.setCurrentItem(i5 - this.f17641C);
        } else if (i4 == i7) {
            this.f17654g.setAdapter(new NumericWheelAdapter(this.f17641C, 59));
            this.f17654g.setCurrentItem(i5 - this.f17641C);
        } else if (i4 == i8) {
            this.f17654g.setAdapter(new NumericWheelAdapter(0, this.f17642D));
            this.f17654g.setCurrentItem(i5);
        } else {
            this.f17654g.setAdapter(new NumericWheelAdapter(0, 59));
            this.f17654g.setCurrentItem(i5);
        }
        this.f17654g.setGravity(this.f17656i);
        this.f17655h.setAdapter(new NumericWheelAdapter(0, 59));
        this.f17655h.setCurrentItem(i6);
        this.f17655h.setGravity(this.f17656i);
        this.f17648a = this.f17653f.getCurrentItem();
        this.f17653f.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int f = i + WheelTime.this.f17639A;
                int unused = WheelTime.this.f17644F = f;
                int currentItem = WheelTime.this.f17654g.getCurrentItem();
                if (WheelTime.this.f17648a == 0) {
                    currentItem += WheelTime.this.f17641C;
                }
                if (WheelTime.this.f17639A == WheelTime.this.f17640B) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(WheelTime.this.f17641C, WheelTime.this.f17642D));
                    if (currentItem > WheelTime.this.f17654g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f17654g.getAdapter().getItemsCount();
                    }
                } else if (f == WheelTime.this.f17639A) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(WheelTime.this.f17641C, 59));
                    if (currentItem < WheelTime.this.f17641C) {
                        currentItem = 0;
                    } else {
                        currentItem -= WheelTime.this.f17641C;
                    }
                } else if (f == WheelTime.this.f17640B) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(0, WheelTime.this.f17642D));
                    if (currentItem > WheelTime.this.f17654g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f17654g.getAdapter().getItemsCount();
                    }
                } else {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(0, 59));
                }
                WheelTime.this.f17654g.setCurrentItem(currentItem);
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
                WheelTime wheelTime = WheelTime.this;
                wheelTime.f17648a = wheelTime.f17653f.getCurrentItem();
            }
        });
        m13130a(this.f17652e);
        m13130a(this.f17653f);
        m13130a(this.f17654g);
        m13130a(this.f17655h);
        boolean[] zArr = this.f17657j;
        if (zArr.length == 6) {
            this.f17650c.setVisibility(zArr[0] ? 0 : 8);
            this.f17651d.setVisibility(this.f17657j[1] ? 0 : 8);
            this.f17652e.setVisibility(this.f17657j[2] ? 0 : 8);
            this.f17653f.setVisibility(this.f17657j[3] ? 0 : 8);
            this.f17654g.setVisibility(this.f17657j[4] ? 0 : 8);
            WheelView wheelView3 = this.f17655h;
            if (!this.f17657j[5]) {
                i9 = 8;
            }
            wheelView3.setVisibility(i9);
            m13125a();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m13126a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        final List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", "10", "12"});
        final List asList2 = Arrays.asList(new String[]{"4", "6", "9", "11"});
        this.f17643E = i9;
        WheelView wheelView = (WheelView) this.f17649b.findViewById(R.id.year);
        this.f17650c = wheelView;
        wheelView.setAdapter(new NumericWheelAdapter(this.f17658u, this.f17659v));
        this.f17650c.setCurrentItem(i9 - this.f17658u);
        this.f17650c.setGravity(this.f17656i);
        WheelView wheelView2 = (WheelView) this.f17649b.findViewById(R.id.month);
        this.f17651d = wheelView2;
        int i13 = this.f17658u;
        int i14 = this.f17659v;
        if (i13 == i14) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f17660w, this.f17661x));
            this.f17651d.setCurrentItem((i10 + 1) - this.f17660w);
        } else if (i9 == i13) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f17660w, 12));
            this.f17651d.setCurrentItem((i10 + 1) - this.f17660w);
        } else if (i9 == i14) {
            wheelView2.setAdapter(new NumericWheelAdapter(1, this.f17661x));
            this.f17651d.setCurrentItem(i10);
        } else {
            wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
            this.f17651d.setCurrentItem(i10);
        }
        this.f17651d.setGravity(this.f17656i);
        this.f17652e = (WheelView) this.f17649b.findViewById(R.id.day);
        int i15 = 0;
        boolean z = (i9 % 4 == 0 && i9 % 100 != 0) || i9 % 400 == 0;
        int i16 = 29;
        if (this.f17658u == this.f17659v && this.f17660w == this.f17661x) {
            int i17 = i10 + 1;
            if (asList.contains(String.valueOf(i17))) {
                if (this.f17663z > 31) {
                    this.f17663z = 31;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, this.f17663z));
            } else if (asList2.contains(String.valueOf(i17))) {
                if (this.f17663z > 30) {
                    this.f17663z = 30;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, this.f17663z));
            } else if (z) {
                if (this.f17663z > 29) {
                    this.f17663z = 29;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, this.f17663z));
            } else {
                if (this.f17663z > 28) {
                    this.f17663z = 28;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, this.f17663z));
            }
            this.f17652e.setCurrentItem(i3 - this.f17662y);
        } else if (i9 == this.f17658u && (i8 = i10 + 1) == this.f17660w) {
            if (asList.contains(String.valueOf(i8))) {
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.f17652e.setAdapter(new NumericWheelAdapter(this.f17662y, 30));
            } else {
                WheelView wheelView3 = this.f17652e;
                int i18 = this.f17662y;
                if (!z) {
                    i16 = 28;
                }
                wheelView3.setAdapter(new NumericWheelAdapter(i18, i16));
            }
            this.f17652e.setCurrentItem(i3 - this.f17662y);
        } else if (i9 == this.f17659v && (i7 = i10 + 1) == this.f17661x) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.f17663z > 31) {
                    this.f17663z = 31;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(1, this.f17663z));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.f17663z > 30) {
                    this.f17663z = 30;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(1, this.f17663z));
            } else if (z) {
                if (this.f17663z > 29) {
                    this.f17663z = 29;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(1, this.f17663z));
            } else {
                if (this.f17663z > 28) {
                    this.f17663z = 28;
                }
                this.f17652e.setAdapter(new NumericWheelAdapter(1, this.f17663z));
            }
            this.f17652e.setCurrentItem(i3 - 1);
        } else {
            int i19 = i10 + 1;
            if (asList.contains(String.valueOf(i19))) {
                this.f17652e.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i19))) {
                this.f17652e.setAdapter(new NumericWheelAdapter(1, 30));
            } else {
                WheelView wheelView4 = this.f17652e;
                int i20 = this.f17662y;
                if (!z) {
                    i16 = 28;
                }
                wheelView4.setAdapter(new NumericWheelAdapter(i20, i16));
            }
            this.f17652e.setCurrentItem(i3 - 1);
        }
        this.f17652e.setGravity(this.f17656i);
        this.f17650c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int a = i + WheelTime.this.f17658u;
                int unused = WheelTime.this.f17643E = a;
                int currentItem = WheelTime.this.f17651d.getCurrentItem();
                if (WheelTime.this.f17658u == WheelTime.this.f17659v) {
                    WheelTime.this.f17651d.setAdapter(new NumericWheelAdapter(WheelTime.this.f17660w, WheelTime.this.f17661x));
                    if (currentItem > WheelTime.this.f17651d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f17651d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f17651d.setCurrentItem(currentItem);
                    }
                    int m = currentItem + WheelTime.this.f17660w;
                    if (WheelTime.this.f17660w == WheelTime.this.f17661x) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m13127a(a, m, wheelTime.f17662y, WheelTime.this.f17663z, (List<String>) asList, (List<String>) asList2);
                    } else if (m == WheelTime.this.f17660w) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m13127a(a, m, wheelTime2.f17662y, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (m == WheelTime.this.f17661x) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m13127a(a, m, 1, wheelTime3.f17663z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m13127a(a, m, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f17658u) {
                    WheelTime.this.f17651d.setAdapter(new NumericWheelAdapter(WheelTime.this.f17660w, 12));
                    if (currentItem > WheelTime.this.f17651d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f17651d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f17651d.setCurrentItem(currentItem);
                    }
                    int m2 = currentItem + WheelTime.this.f17660w;
                    if (m2 == WheelTime.this.f17660w) {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m13127a(a, m2, wheelTime4.f17662y, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m13127a(a, m2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f17659v) {
                    WheelTime.this.f17651d.setAdapter(new NumericWheelAdapter(1, WheelTime.this.f17661x));
                    if (currentItem > WheelTime.this.f17651d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f17651d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f17651d.setCurrentItem(currentItem);
                    }
                    int i2 = 1 + currentItem;
                    if (i2 == WheelTime.this.f17661x) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m13127a(a, i2, 1, wheelTime5.f17663z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m13127a(a, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else {
                    WheelTime.this.f17651d.setAdapter(new NumericWheelAdapter(1, 12));
                    WheelTime wheelTime6 = WheelTime.this;
                    wheelTime6.m13127a(a, 1 + wheelTime6.f17651d.getCurrentItem(), 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
            }
        });
        this.f17651d.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = i + 1;
                if (WheelTime.this.f17658u == WheelTime.this.f17659v) {
                    int m = (i2 + WheelTime.this.f17660w) - 1;
                    if (WheelTime.this.f17660w == WheelTime.this.f17661x) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m13127a(wheelTime.f17643E, m, WheelTime.this.f17662y, WheelTime.this.f17663z, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f17660w == m) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m13127a(wheelTime2.f17643E, m, WheelTime.this.f17662y, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f17661x == m) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m13127a(wheelTime3.f17643E, m, 1, WheelTime.this.f17663z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m13127a(wheelTime4.f17643E, m, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f17643E == WheelTime.this.f17658u) {
                    int m2 = (i2 + WheelTime.this.f17660w) - 1;
                    if (m2 == WheelTime.this.f17660w) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m13127a(wheelTime5.f17643E, m2, WheelTime.this.f17662y, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime6 = WheelTime.this;
                        wheelTime6.m13127a(wheelTime6.f17643E, m2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f17643E != WheelTime.this.f17659v) {
                    WheelTime wheelTime7 = WheelTime.this;
                    wheelTime7.m13127a(wheelTime7.f17643E, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                } else if (i2 == WheelTime.this.f17661x) {
                    WheelTime wheelTime8 = WheelTime.this;
                    wheelTime8.m13127a(wheelTime8.f17643E, WheelTime.this.f17651d.getCurrentItem() + 1, 1, WheelTime.this.f17663z, (List<String>) asList, (List<String>) asList2);
                } else {
                    WheelTime wheelTime9 = WheelTime.this;
                    wheelTime9.m13127a(wheelTime9.f17643E, WheelTime.this.f17651d.getCurrentItem() + 1, 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
            }
        });
        this.f17653f = (WheelView) this.f17649b.findViewById(R.id.hour);
        this.f17654g = (WheelView) this.f17649b.findViewById(R.id.min);
        this.f17655h = (WheelView) this.f17649b.findViewById(R.id.second);
        this.f17644F = i11;
        this.f17653f.setAdapter(new NumericWheelAdapter(this.f17639A, this.f17640B));
        this.f17653f.setCurrentItem(i11 - this.f17639A);
        this.f17653f.setGravity(this.f17656i);
        int i21 = this.f17639A;
        int i22 = this.f17640B;
        if (i21 == i22) {
            this.f17654g.setAdapter(new NumericWheelAdapter(this.f17641C, this.f17642D));
            this.f17654g.setCurrentItem(i12 - this.f17641C);
        } else if (i11 == i21) {
            this.f17654g.setAdapter(new NumericWheelAdapter(this.f17641C, 59));
            this.f17654g.setCurrentItem(i12 - this.f17641C);
        } else if (i11 == i22) {
            this.f17654g.setAdapter(new NumericWheelAdapter(0, this.f17642D));
            this.f17654g.setCurrentItem(i12);
        } else {
            this.f17654g.setAdapter(new NumericWheelAdapter(0, 59));
            this.f17654g.setCurrentItem(i12);
        }
        this.f17654g.setGravity(this.f17656i);
        this.f17655h.setAdapter(new NumericWheelAdapter(0, 59));
        this.f17655h.setCurrentItem(i6);
        this.f17655h.setGravity(this.f17656i);
        this.f17648a = this.f17653f.getCurrentItem();
        this.f17653f.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int f = i + WheelTime.this.f17639A;
                int unused = WheelTime.this.f17644F = f;
                int currentItem = WheelTime.this.f17654g.getCurrentItem();
                if (WheelTime.this.f17648a == 0) {
                    currentItem += WheelTime.this.f17641C;
                }
                if (WheelTime.this.f17639A == WheelTime.this.f17640B) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(WheelTime.this.f17641C, WheelTime.this.f17642D));
                    if (currentItem > WheelTime.this.f17654g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f17654g.getAdapter().getItemsCount();
                    }
                } else if (f == WheelTime.this.f17639A) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(WheelTime.this.f17641C, 59));
                    if (currentItem < WheelTime.this.f17641C) {
                        currentItem = 0;
                    } else {
                        currentItem -= WheelTime.this.f17641C;
                    }
                } else if (f == WheelTime.this.f17640B) {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(0, WheelTime.this.f17642D));
                    if (currentItem > WheelTime.this.f17654g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f17654g.getAdapter().getItemsCount();
                    }
                } else {
                    WheelTime.this.f17654g.setAdapter(new NumericWheelAdapter(0, 59));
                }
                WheelTime.this.f17654g.setCurrentItem(currentItem);
                if (WheelTime.this.f17647I != null) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
                WheelTime wheelTime = WheelTime.this;
                wheelTime.f17648a = wheelTime.f17653f.getCurrentItem();
            }
        });
        m13130a(this.f17652e);
        m13130a(this.f17653f);
        m13130a(this.f17654g);
        m13130a(this.f17655h);
        boolean[] zArr = this.f17657j;
        if (zArr.length == 6) {
            this.f17650c.setVisibility(zArr[0] ? 0 : 8);
            this.f17651d.setVisibility(this.f17657j[1] ? 0 : 8);
            this.f17652e.setVisibility(this.f17657j[2] ? 0 : 8);
            this.f17653f.setVisibility(this.f17657j[3] ? 0 : 8);
            this.f17654g.setVisibility(this.f17657j[4] ? 0 : 8);
            WheelView wheelView5 = this.f17655h;
            if (!this.f17657j[5]) {
                i15 = 8;
            }
            wheelView5.setVisibility(i15);
            m13125a();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m13130a(WheelView wheelView) {
        if (this.f17647I != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelTime.this.f17647I.onTimeSelectChanged();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13127a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f17652e.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f17652e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f17652e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f17652e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f17652e.setAdapter(new NumericWheelAdapter(i3, i4));
        }
        if (currentItem > this.f17652e.getAdapter().getItemsCount() - 1) {
            this.f17652e.setCurrentItem(this.f17652e.getAdapter().getItemsCount() - 1);
        }
    }

    /* renamed from: a */
    private void m13125a() {
        this.f17652e.setTextSize((float) this.f17645G);
        this.f17651d.setTextSize((float) this.f17645G);
        this.f17650c.setTextSize((float) this.f17645G);
        this.f17653f.setTextSize((float) this.f17645G);
        this.f17654g.setTextSize((float) this.f17645G);
        this.f17655h.setTextSize((float) this.f17645G);
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.f17646H) {
            if (str != null) {
                this.f17650c.setLabel(str);
            } else {
                this.f17650c.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_year));
            }
            if (str2 != null) {
                this.f17651d.setLabel(str2);
            } else {
                this.f17651d.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_month));
            }
            if (str3 != null) {
                this.f17652e.setLabel(str3);
            } else {
                this.f17652e.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_day));
            }
            if (str4 != null) {
                this.f17653f.setLabel(str4);
            } else {
                this.f17653f.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_hours));
            }
            if (str5 != null) {
                this.f17654g.setLabel(str5);
            } else {
                this.f17654g.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_minutes));
            }
            if (str6 != null) {
                this.f17655h.setLabel(str6);
            } else {
                this.f17655h.setLabel(this.f17649b.getContext().getString(R.string.dimina_pickerview_seconds));
            }
        }
    }

    public void setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f17650c.setTextXOffset(i);
        this.f17651d.setTextXOffset(i2);
        this.f17652e.setTextXOffset(i3);
        this.f17653f.setTextXOffset(i4);
        this.f17654g.setTextXOffset(i5);
        this.f17655h.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.f17650c.setCyclic(z);
        this.f17651d.setCyclic(z);
        this.f17652e.setCyclic(z);
        this.f17653f.setCyclic(z);
        this.f17654g.setCyclic(z);
        this.f17655h.setCyclic(z);
    }

    public String getTime() {
        if (this.f17646H) {
            return m13133b();
        }
        StringBuilder sb = new StringBuilder();
        if (this.f17643E == this.f17658u) {
            int currentItem = this.f17651d.getCurrentItem();
            int i = this.f17660w;
            if (currentItem + i == i) {
                sb.append(this.f17650c.getCurrentItem() + this.f17658u);
                sb.append("-");
                sb.append(this.f17651d.getCurrentItem() + this.f17660w);
                sb.append("-");
                sb.append(this.f17652e.getCurrentItem() + this.f17662y);
                sb.append(" ");
                sb.append(this.f17653f.getCurrentItem() + this.f17639A);
                sb.append(":");
                if (this.f17653f.getCurrentItem() == 0) {
                    sb.append(this.f17654g.getCurrentItem() + this.f17641C);
                    sb.append(":");
                    sb.append(this.f17655h.getCurrentItem());
                } else {
                    sb.append(this.f17654g.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f17655h.getCurrentItem());
                }
            } else {
                sb.append(this.f17650c.getCurrentItem() + this.f17658u);
                sb.append("-");
                sb.append(this.f17651d.getCurrentItem() + this.f17660w);
                sb.append("-");
                sb.append(this.f17652e.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f17653f.getCurrentItem());
                sb.append(":");
                sb.append(this.f17654g.getCurrentItem());
                sb.append(":");
                sb.append(this.f17655h.getCurrentItem());
            }
        } else {
            sb.append(this.f17650c.getCurrentItem() + this.f17658u);
            sb.append("-");
            sb.append(this.f17651d.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f17652e.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f17653f.getCurrentItem());
            sb.append(":");
            sb.append(this.f17654g.getCurrentItem());
            sb.append(":");
            sb.append(this.f17655h.getCurrentItem());
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ab  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m13133b() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f17650c
            int r1 = r1.getCurrentItem()
            int r2 = r7.f17658u
            int r1 = r1 + r2
            int r2 = com.didi.dimina.container.p106ui.pickerview.utils.ChinaDate.leapMonth(r1)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x001f
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
        L_0x001c:
            int r2 = r2 + r4
        L_0x001d:
            r5 = 0
            goto L_0x0051
        L_0x001f:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
            int r2 = r2 + r4
            int r5 = com.didi.dimina.container.p106ui.pickerview.utils.ChinaDate.leapMonth(r1)
            int r2 = r2 - r5
            if (r2 > 0) goto L_0x0034
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
            goto L_0x001c
        L_0x0034:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
            int r2 = r2 + r4
            int r5 = com.didi.dimina.container.p106ui.pickerview.utils.ChinaDate.leapMonth(r1)
            int r2 = r2 - r5
            if (r2 != r4) goto L_0x004a
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
            r5 = 1
            goto L_0x0051
        L_0x004a:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17651d
            int r2 = r2.getCurrentItem()
            goto L_0x001d
        L_0x0051:
            com.didi.dimina.container.ui.wheelview.view.WheelView r6 = r7.f17652e
            int r6 = r6.getCurrentItem()
            int r6 = r6 + r4
            int[] r1 = com.didi.dimina.container.p106ui.pickerview.utils.LunarCalendar.lunarToSolar(r1, r2, r6, r5)
            r2 = r1[r3]
            r0.append(r2)
            java.lang.String r2 = "-"
            r0.append(r2)
            r3 = r1[r4]
            r0.append(r3)
            r0.append(r2)
            r2 = 2
            r1 = r1[r2]
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f17653f
            int r1 = r1.getCurrentItem()
            int r2 = r7.f17639A
            int r1 = r1 + r2
            r0.append(r1)
            java.lang.String r1 = ":"
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17653f
            int r2 = r2.getCurrentItem()
            if (r2 != 0) goto L_0x00ab
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17654g
            int r2 = r2.getCurrentItem()
            int r3 = r7.f17641C
            int r2 = r2 + r3
            r0.append(r2)
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f17655h
            int r1 = r1.getCurrentItem()
            r0.append(r1)
            goto L_0x00c0
        L_0x00ab:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f17654g
            int r2 = r2.getCurrentItem()
            r0.append(r2)
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f17655h
            int r1 = r1.getCurrentItem()
            r0.append(r1)
        L_0x00c0:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.pickerview.view.WheelTime.m13133b():java.lang.String");
    }

    public View getView() {
        return this.f17649b;
    }

    public int getStartYear() {
        return this.f17658u;
    }

    public void setStartYear(int i) {
        this.f17658u = i;
    }

    public int getEndYear() {
        return this.f17659v;
    }

    public void setEndYear(int i) {
        this.f17659v = i;
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.f17658u;
            if (i > i4) {
                this.f17659v = i;
                this.f17661x = i2;
                this.f17663z = i3;
            } else if (i == i4) {
                int i5 = this.f17660w;
                if (i2 > i5) {
                    this.f17659v = i;
                    this.f17661x = i2;
                    this.f17663z = i3;
                } else if (i2 == i5 && i3 > this.f17662y) {
                    this.f17659v = i;
                    this.f17661x = i2;
                    this.f17663z = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.f17659v;
            if (i6 < i9) {
                this.f17660w = i7;
                this.f17662y = i8;
                this.f17658u = i6;
            } else if (i6 == i9) {
                int i10 = this.f17661x;
                if (i7 < i10) {
                    this.f17660w = i7;
                    this.f17662y = i8;
                    this.f17658u = i6;
                } else if (i7 == i10 && i8 < this.f17663z) {
                    this.f17660w = i7;
                    this.f17662y = i8;
                    this.f17658u = i6;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.f17658u = calendar.get(1);
            this.f17659v = calendar2.get(1);
            this.f17660w = calendar.get(2) + 1;
            this.f17661x = calendar2.get(2) + 1;
            this.f17662y = calendar.get(5);
            this.f17663z = calendar2.get(5);
            this.f17639A = calendar.get(11);
            this.f17640B = calendar2.get(11);
            this.f17641C = calendar.get(12);
            this.f17642D = calendar2.get(12);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f17652e.setLineSpacingMultiplier(f);
        this.f17651d.setLineSpacingMultiplier(f);
        this.f17650c.setLineSpacingMultiplier(f);
        this.f17653f.setLineSpacingMultiplier(f);
        this.f17654g.setLineSpacingMultiplier(f);
        this.f17655h.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f17652e.setDividerColor(i);
        this.f17651d.setDividerColor(i);
        this.f17650c.setDividerColor(i);
        this.f17653f.setDividerColor(i);
        this.f17654g.setDividerColor(i);
        this.f17655h.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f17652e.setDividerType(dividerType);
        this.f17651d.setDividerType(dividerType);
        this.f17650c.setDividerType(dividerType);
        this.f17653f.setDividerType(dividerType);
        this.f17654g.setDividerType(dividerType);
        this.f17655h.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f17652e.setTextColorCenter(i);
        this.f17651d.setTextColorCenter(i);
        this.f17650c.setTextColorCenter(i);
        this.f17653f.setTextColorCenter(i);
        this.f17654g.setTextColorCenter(i);
        this.f17655h.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f17652e.setTextColorOut(i);
        this.f17651d.setTextColorOut(i);
        this.f17650c.setTextColorOut(i);
        this.f17653f.setTextColorOut(i);
        this.f17654g.setTextColorOut(i);
        this.f17655h.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f17652e.isCenterLabel(z);
        this.f17651d.isCenterLabel(z);
        this.f17650c.isCenterLabel(z);
        this.f17653f.isCenterLabel(z);
        this.f17654g.isCenterLabel(z);
        this.f17655h.isCenterLabel(z);
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.f17647I = iSelectTimeCallback;
    }

    public void setItemsVisible(int i) {
        this.f17652e.setItemsVisibleCount(i);
        this.f17651d.setItemsVisibleCount(i);
        this.f17650c.setItemsVisibleCount(i);
        this.f17653f.setItemsVisibleCount(i);
        this.f17654g.setItemsVisibleCount(i);
        this.f17655h.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f17652e.setAlphaGradient(z);
        this.f17651d.setAlphaGradient(z);
        this.f17650c.setAlphaGradient(z);
        this.f17653f.setAlphaGradient(z);
        this.f17654g.setAlphaGradient(z);
        this.f17655h.setAlphaGradient(z);
    }
}
