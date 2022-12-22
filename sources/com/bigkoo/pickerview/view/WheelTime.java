package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.adapter.NumericWheelAdapter;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.bigkoo.pickerview.utils.ChinaDate;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.taxis99.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WheelTime {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: j */
    private static final int f2120j = 1900;

    /* renamed from: k */
    private static final int f2121k = 2100;

    /* renamed from: l */
    private static final int f2122l = 1;

    /* renamed from: m */
    private static final int f2123m = 12;

    /* renamed from: n */
    private static final int f2124n = 1;

    /* renamed from: o */
    private static final int f2125o = 31;

    /* renamed from: a */
    private View f2126a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WheelView f2127b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WheelView f2128c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WheelView f2129d;

    /* renamed from: e */
    private WheelView f2130e;

    /* renamed from: f */
    private WheelView f2131f;

    /* renamed from: g */
    private WheelView f2132g;

    /* renamed from: h */
    private int f2133h;

    /* renamed from: i */
    private boolean[] f2134i;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f2135p = 1900;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f2136q = 2100;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f2137r = 1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f2138s = 12;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f2139t = 1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f2140u = 31;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f2141v;

    /* renamed from: w */
    private int f2142w;

    /* renamed from: x */
    private boolean f2143x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ISelectTimeCallback f2144y;

    public WheelTime(View view, boolean[] zArr, int i, int i2) {
        this.f2126a = view;
        this.f2134i = zArr;
        this.f2133h = i;
        this.f2142w = i2;
    }

    public void setLunarMode(boolean z) {
        this.f2143x = z;
    }

    public boolean isLunarMode() {
        return this.f2143x;
    }

    public void setPicker(int i, int i2, int i3) {
        setPicker(i, i2, i3, 0, 0, 0);
    }

    public void setPicker(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f2143x) {
            int[] solarToLunar = LunarCalendar.solarToLunar(i, i2 + 1, i3);
            m1750a(solarToLunar[0], solarToLunar[1] - 1, solarToLunar[2], solarToLunar[3] == 1, i4, i5, i6);
            return;
        }
        m1748a(i, i2, i3, i4, i5, i6);
    }

    /* renamed from: a */
    private void m1750a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.f2126a.findViewById(R.id.year);
        this.f2127b = wheelView;
        wheelView.setAdapter(new ArrayWheelAdapter(ChinaDate.getYears(this.f2135p, this.f2136q)));
        this.f2127b.setLabel("");
        this.f2127b.setCurrentItem(i - this.f2135p);
        this.f2127b.setGravity(this.f2133h);
        WheelView wheelView2 = (WheelView) this.f2126a.findViewById(R.id.month);
        this.f2128c = wheelView2;
        wheelView2.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i)));
        this.f2128c.setLabel("");
        int leapMonth = ChinaDate.leapMonth(i);
        if (leapMonth == 0 || (i2 <= leapMonth - 1 && !z)) {
            this.f2128c.setCurrentItem(i2);
        } else {
            this.f2128c.setCurrentItem(i2 + 1);
        }
        this.f2128c.setGravity(this.f2133h);
        this.f2129d = (WheelView) this.f2126a.findViewById(R.id.day);
        if (ChinaDate.leapMonth(i) == 0) {
            this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i, i2))));
        } else {
            this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i))));
        }
        this.f2129d.setLabel("");
        this.f2129d.setCurrentItem(i3 - 1);
        this.f2129d.setGravity(this.f2133h);
        WheelView wheelView3 = (WheelView) this.f2126a.findViewById(R.id.hour);
        this.f2130e = wheelView3;
        int i7 = 0;
        wheelView3.setAdapter(new NumericWheelAdapter(0, 23));
        this.f2130e.setCurrentItem(i4);
        this.f2130e.setGravity(this.f2133h);
        WheelView wheelView4 = (WheelView) this.f2126a.findViewById(R.id.min);
        this.f2131f = wheelView4;
        wheelView4.setAdapter(new NumericWheelAdapter(0, 59));
        this.f2131f.setCurrentItem(i5);
        this.f2131f.setGravity(this.f2133h);
        WheelView wheelView5 = (WheelView) this.f2126a.findViewById(R.id.second);
        this.f2132g = wheelView5;
        wheelView5.setAdapter(new NumericWheelAdapter(0, 59));
        this.f2132g.setCurrentItem(i5);
        this.f2132g.setGravity(this.f2133h);
        this.f2127b.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int a = i + WheelTime.this.f2135p;
                WheelTime.this.f2128c.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(a)));
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f2128c.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f2128c.setCurrentItem(WheelTime.this.f2128c.getCurrentItem());
                } else {
                    WheelTime.this.f2128c.setCurrentItem(WheelTime.this.f2128c.getCurrentItem() + 1);
                }
                int currentItem = WheelTime.this.f2129d.getCurrentItem();
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f2128c.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f2128c.getCurrentItem() + 1))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f2128c.getCurrentItem() + 1);
                } else if (WheelTime.this.f2128c.getCurrentItem() == ChinaDate.leapMonth(a) + 1) {
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(a))));
                    i2 = ChinaDate.leapDays(a);
                } else {
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f2128c.getCurrentItem()))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f2128c.getCurrentItem());
                }
                int i3 = i2 - 1;
                if (currentItem > i3) {
                    WheelTime.this.f2129d.setCurrentItem(i3);
                }
                if (WheelTime.this.f2144y != null) {
                    WheelTime.this.f2144y.onTimeSelectChanged();
                }
            }
        });
        this.f2128c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int currentItem = WheelTime.this.f2127b.getCurrentItem() + WheelTime.this.f2135p;
                int currentItem2 = WheelTime.this.f2129d.getCurrentItem();
                if (ChinaDate.leapMonth(currentItem) == 0 || i <= ChinaDate.leapMonth(currentItem) - 1) {
                    int i3 = i + 1;
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i3))));
                    i2 = ChinaDate.monthDays(currentItem, i3);
                } else if (WheelTime.this.f2128c.getCurrentItem() == ChinaDate.leapMonth(currentItem) + 1) {
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(currentItem))));
                    i2 = ChinaDate.leapDays(currentItem);
                } else {
                    WheelTime.this.f2129d.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i))));
                    i2 = ChinaDate.monthDays(currentItem, i);
                }
                int i4 = i2 - 1;
                if (currentItem2 > i4) {
                    WheelTime.this.f2129d.setCurrentItem(i4);
                }
                if (WheelTime.this.f2144y != null) {
                    WheelTime.this.f2144y.onTimeSelectChanged();
                }
            }
        });
        m1752a(this.f2129d);
        m1752a(this.f2130e);
        m1752a(this.f2131f);
        m1752a(this.f2132g);
        boolean[] zArr = this.f2134i;
        if (zArr.length == 6) {
            this.f2127b.setVisibility(zArr[0] ? 0 : 8);
            this.f2128c.setVisibility(this.f2134i[1] ? 0 : 8);
            this.f2129d.setVisibility(this.f2134i[2] ? 0 : 8);
            this.f2130e.setVisibility(this.f2134i[3] ? 0 : 8);
            this.f2131f.setVisibility(this.f2134i[4] ? 0 : 8);
            WheelView wheelView6 = this.f2132g;
            if (!this.f2134i[5]) {
                i7 = 8;
            }
            wheelView6.setVisibility(i7);
            m1747a();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m1748a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        final List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", "10", "12"});
        final List asList2 = Arrays.asList(new String[]{"4", "6", "9", "11"});
        this.f2141v = i9;
        WheelView wheelView = (WheelView) this.f2126a.findViewById(R.id.year);
        this.f2127b = wheelView;
        wheelView.setAdapter(new NumericWheelAdapter(this.f2135p, this.f2136q));
        this.f2127b.setCurrentItem(i9 - this.f2135p);
        this.f2127b.setGravity(this.f2133h);
        WheelView wheelView2 = (WheelView) this.f2126a.findViewById(R.id.month);
        this.f2128c = wheelView2;
        int i11 = this.f2135p;
        int i12 = this.f2136q;
        if (i11 == i12) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f2137r, this.f2138s));
            this.f2128c.setCurrentItem((i10 + 1) - this.f2137r);
        } else if (i9 == i11) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f2137r, 12));
            this.f2128c.setCurrentItem((i10 + 1) - this.f2137r);
        } else if (i9 == i12) {
            wheelView2.setAdapter(new NumericWheelAdapter(1, this.f2138s));
            this.f2128c.setCurrentItem(i10);
        } else {
            wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
            this.f2128c.setCurrentItem(i10);
        }
        this.f2128c.setGravity(this.f2133h);
        this.f2129d = (WheelView) this.f2126a.findViewById(R.id.day);
        int i13 = 0;
        boolean z = (i9 % 4 == 0 && i9 % 100 != 0) || i9 % 400 == 0;
        int i14 = 29;
        if (this.f2135p == this.f2136q && this.f2137r == this.f2138s) {
            int i15 = i10 + 1;
            if (asList.contains(String.valueOf(i15))) {
                if (this.f2140u > 31) {
                    this.f2140u = 31;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, this.f2140u));
            } else if (asList2.contains(String.valueOf(i15))) {
                if (this.f2140u > 30) {
                    this.f2140u = 30;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, this.f2140u));
            } else if (z) {
                if (this.f2140u > 29) {
                    this.f2140u = 29;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, this.f2140u));
            } else {
                if (this.f2140u > 28) {
                    this.f2140u = 28;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, this.f2140u));
            }
            this.f2129d.setCurrentItem(i3 - this.f2139t);
        } else if (i9 == this.f2135p && (i8 = i10 + 1) == this.f2137r) {
            if (asList.contains(String.valueOf(i8))) {
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.f2129d.setAdapter(new NumericWheelAdapter(this.f2139t, 30));
            } else {
                WheelView wheelView3 = this.f2129d;
                int i16 = this.f2139t;
                if (!z) {
                    i14 = 28;
                }
                wheelView3.setAdapter(new NumericWheelAdapter(i16, i14));
            }
            this.f2129d.setCurrentItem(i3 - this.f2139t);
        } else if (i9 == this.f2136q && (i7 = i10 + 1) == this.f2138s) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.f2140u > 31) {
                    this.f2140u = 31;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(1, this.f2140u));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.f2140u > 30) {
                    this.f2140u = 30;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(1, this.f2140u));
            } else if (z) {
                if (this.f2140u > 29) {
                    this.f2140u = 29;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(1, this.f2140u));
            } else {
                if (this.f2140u > 28) {
                    this.f2140u = 28;
                }
                this.f2129d.setAdapter(new NumericWheelAdapter(1, this.f2140u));
            }
            this.f2129d.setCurrentItem(i3 - 1);
        } else {
            int i17 = i10 + 1;
            if (asList.contains(String.valueOf(i17))) {
                this.f2129d.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i17))) {
                this.f2129d.setAdapter(new NumericWheelAdapter(1, 30));
            } else {
                WheelView wheelView4 = this.f2129d;
                int i18 = this.f2139t;
                if (!z) {
                    i14 = 28;
                }
                wheelView4.setAdapter(new NumericWheelAdapter(i18, i14));
            }
            this.f2129d.setCurrentItem(i3 - 1);
        }
        this.f2129d.setGravity(this.f2133h);
        WheelView wheelView5 = (WheelView) this.f2126a.findViewById(R.id.hour);
        this.f2130e = wheelView5;
        wheelView5.setAdapter(new NumericWheelAdapter(0, 23));
        this.f2130e.setCurrentItem(i4);
        this.f2130e.setGravity(this.f2133h);
        WheelView wheelView6 = (WheelView) this.f2126a.findViewById(R.id.min);
        this.f2131f = wheelView6;
        wheelView6.setAdapter(new NumericWheelAdapter(0, 59));
        this.f2131f.setCurrentItem(i5);
        this.f2131f.setGravity(this.f2133h);
        WheelView wheelView7 = (WheelView) this.f2126a.findViewById(R.id.second);
        this.f2132g = wheelView7;
        wheelView7.setAdapter(new NumericWheelAdapter(0, 59));
        this.f2132g.setCurrentItem(i6);
        this.f2132g.setGravity(this.f2133h);
        this.f2127b.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int a = i + WheelTime.this.f2135p;
                int unused = WheelTime.this.f2141v = a;
                int currentItem = WheelTime.this.f2128c.getCurrentItem();
                if (WheelTime.this.f2135p == WheelTime.this.f2136q) {
                    WheelTime.this.f2128c.setAdapter(new NumericWheelAdapter(WheelTime.this.f2137r, WheelTime.this.f2138s));
                    if (currentItem > WheelTime.this.f2128c.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f2128c.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f2128c.setCurrentItem(currentItem);
                    }
                    int g = currentItem + WheelTime.this.f2137r;
                    if (WheelTime.this.f2137r == WheelTime.this.f2138s) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m1749a(a, g, wheelTime.f2139t, WheelTime.this.f2140u, (List<String>) asList, (List<String>) asList2);
                    } else if (g == WheelTime.this.f2137r) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m1749a(a, g, wheelTime2.f2139t, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (g == WheelTime.this.f2138s) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m1749a(a, g, 1, wheelTime3.f2140u, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m1749a(a, g, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f2135p) {
                    WheelTime.this.f2128c.setAdapter(new NumericWheelAdapter(WheelTime.this.f2137r, 12));
                    if (currentItem > WheelTime.this.f2128c.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f2128c.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f2128c.setCurrentItem(currentItem);
                    }
                    int g2 = currentItem + WheelTime.this.f2137r;
                    if (g2 == WheelTime.this.f2137r) {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m1749a(a, g2, wheelTime4.f2139t, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m1749a(a, g2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f2136q) {
                    WheelTime.this.f2128c.setAdapter(new NumericWheelAdapter(1, WheelTime.this.f2138s));
                    if (currentItem > WheelTime.this.f2128c.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f2128c.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f2128c.setCurrentItem(currentItem);
                    }
                    int i2 = 1 + currentItem;
                    if (i2 == WheelTime.this.f2138s) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m1749a(a, i2, 1, wheelTime5.f2140u, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m1749a(a, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else {
                    WheelTime.this.f2128c.setAdapter(new NumericWheelAdapter(1, 12));
                    WheelTime wheelTime6 = WheelTime.this;
                    wheelTime6.m1749a(a, 1 + wheelTime6.f2128c.getCurrentItem(), 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f2144y != null) {
                    WheelTime.this.f2144y.onTimeSelectChanged();
                }
            }
        });
        this.f2128c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = i + 1;
                if (WheelTime.this.f2135p == WheelTime.this.f2136q) {
                    int g = (i2 + WheelTime.this.f2137r) - 1;
                    if (WheelTime.this.f2137r == WheelTime.this.f2138s) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m1749a(wheelTime.f2141v, g, WheelTime.this.f2139t, WheelTime.this.f2140u, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f2137r == g) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m1749a(wheelTime2.f2141v, g, WheelTime.this.f2139t, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f2138s == g) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m1749a(wheelTime3.f2141v, g, 1, WheelTime.this.f2140u, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m1749a(wheelTime4.f2141v, g, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f2141v == WheelTime.this.f2135p) {
                    int g2 = (i2 + WheelTime.this.f2137r) - 1;
                    if (g2 == WheelTime.this.f2137r) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m1749a(wheelTime5.f2141v, g2, WheelTime.this.f2139t, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime6 = WheelTime.this;
                        wheelTime6.m1749a(wheelTime6.f2141v, g2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f2141v != WheelTime.this.f2136q) {
                    WheelTime wheelTime7 = WheelTime.this;
                    wheelTime7.m1749a(wheelTime7.f2141v, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                } else if (i2 == WheelTime.this.f2138s) {
                    WheelTime wheelTime8 = WheelTime.this;
                    wheelTime8.m1749a(wheelTime8.f2141v, WheelTime.this.f2128c.getCurrentItem() + 1, 1, WheelTime.this.f2140u, (List<String>) asList, (List<String>) asList2);
                } else {
                    WheelTime wheelTime9 = WheelTime.this;
                    wheelTime9.m1749a(wheelTime9.f2141v, WheelTime.this.f2128c.getCurrentItem() + 1, 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f2144y != null) {
                    WheelTime.this.f2144y.onTimeSelectChanged();
                }
            }
        });
        m1752a(this.f2129d);
        m1752a(this.f2130e);
        m1752a(this.f2131f);
        m1752a(this.f2132g);
        boolean[] zArr = this.f2134i;
        if (zArr.length == 6) {
            this.f2127b.setVisibility(zArr[0] ? 0 : 8);
            this.f2128c.setVisibility(this.f2134i[1] ? 0 : 8);
            this.f2129d.setVisibility(this.f2134i[2] ? 0 : 8);
            this.f2130e.setVisibility(this.f2134i[3] ? 0 : 8);
            this.f2131f.setVisibility(this.f2134i[4] ? 0 : 8);
            WheelView wheelView8 = this.f2132g;
            if (!this.f2134i[5]) {
                i13 = 8;
            }
            wheelView8.setVisibility(i13);
            m1747a();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m1752a(WheelView wheelView) {
        if (this.f2144y != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelTime.this.f2144y.onTimeSelectChanged();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1749a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f2129d.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f2129d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f2129d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f2129d.setAdapter(new NumericWheelAdapter(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f2129d.setAdapter(new NumericWheelAdapter(i3, i4));
        }
        if (currentItem > this.f2129d.getAdapter().getItemsCount() - 1) {
            this.f2129d.setCurrentItem(this.f2129d.getAdapter().getItemsCount() - 1);
        }
    }

    /* renamed from: a */
    private void m1747a() {
        this.f2129d.setTextSize((float) this.f2142w);
        this.f2128c.setTextSize((float) this.f2142w);
        this.f2127b.setTextSize((float) this.f2142w);
        this.f2130e.setTextSize((float) this.f2142w);
        this.f2131f.setTextSize((float) this.f2142w);
        this.f2132g.setTextSize((float) this.f2142w);
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.f2143x) {
            if (str != null) {
                this.f2127b.setLabel(str);
            } else {
                this.f2127b.setLabel(this.f2126a.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.f2128c.setLabel(str2);
            } else {
                this.f2128c.setLabel(this.f2126a.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.f2129d.setLabel(str3);
            } else {
                this.f2129d.setLabel(this.f2126a.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.f2130e.setLabel(str4);
            } else {
                this.f2130e.setLabel(this.f2126a.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.f2131f.setLabel(str5);
            } else {
                this.f2131f.setLabel(this.f2126a.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.f2132g.setLabel(str6);
            } else {
                this.f2132g.setLabel(this.f2126a.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2127b.setTextXOffset(i);
        this.f2128c.setTextXOffset(i2);
        this.f2129d.setTextXOffset(i3);
        this.f2130e.setTextXOffset(i4);
        this.f2131f.setTextXOffset(i5);
        this.f2132g.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.f2127b.setCyclic(z);
        this.f2128c.setCyclic(z);
        this.f2129d.setCyclic(z);
        this.f2130e.setCyclic(z);
        this.f2131f.setCyclic(z);
        this.f2132g.setCyclic(z);
    }

    public String getTime() {
        if (this.f2143x) {
            return m1754b();
        }
        StringBuilder sb = new StringBuilder();
        if (this.f2141v == this.f2135p) {
            int currentItem = this.f2128c.getCurrentItem();
            int i = this.f2137r;
            if (currentItem + i == i) {
                sb.append(this.f2127b.getCurrentItem() + this.f2135p);
                sb.append("-");
                sb.append(this.f2128c.getCurrentItem() + this.f2137r);
                sb.append("-");
                sb.append(this.f2129d.getCurrentItem() + this.f2139t);
                sb.append(" ");
                sb.append(this.f2130e.getCurrentItem());
                sb.append(":");
                sb.append(this.f2131f.getCurrentItem());
                sb.append(":");
                sb.append(this.f2132g.getCurrentItem());
            } else {
                sb.append(this.f2127b.getCurrentItem() + this.f2135p);
                sb.append("-");
                sb.append(this.f2128c.getCurrentItem() + this.f2137r);
                sb.append("-");
                sb.append(this.f2129d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f2130e.getCurrentItem());
                sb.append(":");
                sb.append(this.f2131f.getCurrentItem());
                sb.append(":");
                sb.append(this.f2132g.getCurrentItem());
            }
        } else {
            sb.append(this.f2127b.getCurrentItem() + this.f2135p);
            sb.append("-");
            sb.append(this.f2128c.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f2129d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f2130e.getCurrentItem());
            sb.append(":");
            sb.append(this.f2131f.getCurrentItem());
            sb.append(":");
            sb.append(this.f2132g.getCurrentItem());
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m1754b() {
        boolean z;
        int i;
        int currentItem;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.f2127b.getCurrentItem() + this.f2135p;
        if (ChinaDate.leapMonth(currentItem2) == 0) {
            currentItem = this.f2128c.getCurrentItem();
        } else if ((this.f2128c.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem2) <= 0) {
            currentItem = this.f2128c.getCurrentItem();
        } else if ((this.f2128c.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem2) == 1) {
            i = this.f2128c.getCurrentItem();
            z = true;
            int[] lunarToSolar = LunarCalendar.lunarToSolar(currentItem2, i, this.f2129d.getCurrentItem() + 1, z);
            sb.append(lunarToSolar[0]);
            sb.append("-");
            sb.append(lunarToSolar[1]);
            sb.append("-");
            sb.append(lunarToSolar[2]);
            sb.append(" ");
            sb.append(this.f2130e.getCurrentItem());
            sb.append(":");
            sb.append(this.f2131f.getCurrentItem());
            sb.append(":");
            sb.append(this.f2132g.getCurrentItem());
            return sb.toString();
        } else {
            i = this.f2128c.getCurrentItem();
            z = false;
            int[] lunarToSolar2 = LunarCalendar.lunarToSolar(currentItem2, i, this.f2129d.getCurrentItem() + 1, z);
            sb.append(lunarToSolar2[0]);
            sb.append("-");
            sb.append(lunarToSolar2[1]);
            sb.append("-");
            sb.append(lunarToSolar2[2]);
            sb.append(" ");
            sb.append(this.f2130e.getCurrentItem());
            sb.append(":");
            sb.append(this.f2131f.getCurrentItem());
            sb.append(":");
            sb.append(this.f2132g.getCurrentItem());
            return sb.toString();
        }
        i = currentItem + 1;
        z = false;
        int[] lunarToSolar22 = LunarCalendar.lunarToSolar(currentItem2, i, this.f2129d.getCurrentItem() + 1, z);
        sb.append(lunarToSolar22[0]);
        sb.append("-");
        sb.append(lunarToSolar22[1]);
        sb.append("-");
        sb.append(lunarToSolar22[2]);
        sb.append(" ");
        sb.append(this.f2130e.getCurrentItem());
        sb.append(":");
        sb.append(this.f2131f.getCurrentItem());
        sb.append(":");
        sb.append(this.f2132g.getCurrentItem());
        return sb.toString();
    }

    public View getView() {
        return this.f2126a;
    }

    public int getStartYear() {
        return this.f2135p;
    }

    public void setStartYear(int i) {
        this.f2135p = i;
    }

    public int getEndYear() {
        return this.f2136q;
    }

    public void setEndYear(int i) {
        this.f2136q = i;
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.f2135p;
            if (i > i4) {
                this.f2136q = i;
                this.f2138s = i2;
                this.f2140u = i3;
            } else if (i == i4) {
                int i5 = this.f2137r;
                if (i2 > i5) {
                    this.f2136q = i;
                    this.f2138s = i2;
                    this.f2140u = i3;
                } else if (i2 == i5 && i3 > this.f2139t) {
                    this.f2136q = i;
                    this.f2138s = i2;
                    this.f2140u = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.f2136q;
            if (i6 < i9) {
                this.f2137r = i7;
                this.f2139t = i8;
                this.f2135p = i6;
            } else if (i6 == i9) {
                int i10 = this.f2138s;
                if (i7 < i10) {
                    this.f2137r = i7;
                    this.f2139t = i8;
                    this.f2135p = i6;
                } else if (i7 == i10 && i8 < this.f2140u) {
                    this.f2137r = i7;
                    this.f2139t = i8;
                    this.f2135p = i6;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.f2135p = calendar.get(1);
            this.f2136q = calendar2.get(1);
            this.f2137r = calendar.get(2) + 1;
            this.f2138s = calendar2.get(2) + 1;
            this.f2139t = calendar.get(5);
            this.f2140u = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f2129d.setLineSpacingMultiplier(f);
        this.f2128c.setLineSpacingMultiplier(f);
        this.f2127b.setLineSpacingMultiplier(f);
        this.f2130e.setLineSpacingMultiplier(f);
        this.f2131f.setLineSpacingMultiplier(f);
        this.f2132g.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f2129d.setDividerColor(i);
        this.f2128c.setDividerColor(i);
        this.f2127b.setDividerColor(i);
        this.f2130e.setDividerColor(i);
        this.f2131f.setDividerColor(i);
        this.f2132g.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f2129d.setDividerType(dividerType);
        this.f2128c.setDividerType(dividerType);
        this.f2127b.setDividerType(dividerType);
        this.f2130e.setDividerType(dividerType);
        this.f2131f.setDividerType(dividerType);
        this.f2132g.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f2129d.setTextColorCenter(i);
        this.f2128c.setTextColorCenter(i);
        this.f2127b.setTextColorCenter(i);
        this.f2130e.setTextColorCenter(i);
        this.f2131f.setTextColorCenter(i);
        this.f2132g.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f2129d.setTextColorOut(i);
        this.f2128c.setTextColorOut(i);
        this.f2127b.setTextColorOut(i);
        this.f2130e.setTextColorOut(i);
        this.f2131f.setTextColorOut(i);
        this.f2132g.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f2129d.isCenterLabel(z);
        this.f2128c.isCenterLabel(z);
        this.f2127b.isCenterLabel(z);
        this.f2130e.isCenterLabel(z);
        this.f2131f.isCenterLabel(z);
        this.f2132g.isCenterLabel(z);
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.f2144y = iSelectTimeCallback;
    }

    public void setItemsVisible(int i) {
        this.f2129d.setItemsVisibleCount(i);
        this.f2128c.setItemsVisibleCount(i);
        this.f2127b.setItemsVisibleCount(i);
        this.f2130e.setItemsVisibleCount(i);
        this.f2131f.setItemsVisibleCount(i);
        this.f2132g.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f2129d.setAlphaGradient(z);
        this.f2128c.setAlphaGradient(z);
        this.f2127b.setAlphaGradient(z);
        this.f2130e.setAlphaGradient(z);
        this.f2131f.setAlphaGradient(z);
        this.f2132g.setAlphaGradient(z);
    }
}
