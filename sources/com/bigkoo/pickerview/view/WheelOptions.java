package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.taxis99.R;
import java.util.List;

public class WheelOptions<T> {

    /* renamed from: a */
    private View f2108a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WheelView f2109b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WheelView f2110c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WheelView f2111d;

    /* renamed from: e */
    private List<T> f2112e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<List<T>> f2113f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<List<List<T>>> f2114g;

    /* renamed from: h */
    private boolean f2115h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f2116i;

    /* renamed from: j */
    private OnItemSelectedListener f2117j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnItemSelectedListener f2118k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnOptionsSelectChangeListener f2119l;

    /* renamed from: a */
    private void m1736a() {
    }

    public View getView() {
        return this.f2108a;
    }

    public void setView(View view) {
        this.f2108a = view;
    }

    public WheelOptions(View view, boolean z) {
        this.f2116i = z;
        this.f2108a = view;
        this.f2109b = (WheelView) view.findViewById(R.id.options1);
        this.f2110c = (WheelView) view.findViewById(R.id.options2);
        this.f2111d = (WheelView) view.findViewById(R.id.options3);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f2112e = list;
        this.f2113f = list2;
        this.f2114g = list3;
        this.f2109b.setAdapter(new ArrayWheelAdapter(list));
        this.f2109b.setCurrentItem(0);
        List<List<T>> list4 = this.f2113f;
        if (list4 != null) {
            this.f2110c.setAdapter(new ArrayWheelAdapter(list4.get(0)));
        }
        WheelView wheelView = this.f2110c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f2114g;
        if (list5 != null) {
            this.f2111d.setAdapter(new ArrayWheelAdapter((List) list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.f2111d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f2109b.setIsOptions(true);
        this.f2110c.setIsOptions(true);
        this.f2111d.setIsOptions(true);
        if (this.f2113f == null) {
            this.f2110c.setVisibility(8);
        } else {
            this.f2110c.setVisibility(0);
        }
        if (this.f2114g == null) {
            this.f2111d.setVisibility(8);
        } else {
            this.f2111d.setVisibility(0);
        }
        this.f2117j = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                if (WheelOptions.this.f2113f != null) {
                    if (!WheelOptions.this.f2116i) {
                        i2 = WheelOptions.this.f2110c.getCurrentItem();
                        if (i2 >= ((List) WheelOptions.this.f2113f.get(i)).size() - 1) {
                            i2 = ((List) WheelOptions.this.f2113f.get(i)).size() - 1;
                        }
                    } else {
                        i2 = 0;
                    }
                    WheelOptions.this.f2110c.setAdapter(new ArrayWheelAdapter((List) WheelOptions.this.f2113f.get(i)));
                    WheelOptions.this.f2110c.setCurrentItem(i2);
                    if (WheelOptions.this.f2114g != null) {
                        WheelOptions.this.f2118k.onItemSelected(i2);
                    } else if (WheelOptions.this.f2119l != null) {
                        WheelOptions.this.f2119l.onOptionsSelectChanged(i, i2, 0);
                    }
                } else if (WheelOptions.this.f2119l != null) {
                    WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), 0, 0);
                }
            }
        };
        this.f2118k = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = 0;
                if (WheelOptions.this.f2114g != null) {
                    int currentItem = WheelOptions.this.f2109b.getCurrentItem();
                    if (currentItem >= WheelOptions.this.f2114g.size() - 1) {
                        currentItem = WheelOptions.this.f2114g.size() - 1;
                    }
                    if (i >= ((List) WheelOptions.this.f2113f.get(currentItem)).size() - 1) {
                        i = ((List) WheelOptions.this.f2113f.get(currentItem)).size() - 1;
                    }
                    if (!WheelOptions.this.f2116i) {
                        i2 = WheelOptions.this.f2111d.getCurrentItem() >= ((List) ((List) WheelOptions.this.f2114g.get(currentItem)).get(i)).size() + -1 ? ((List) ((List) WheelOptions.this.f2114g.get(currentItem)).get(i)).size() - 1 : WheelOptions.this.f2111d.getCurrentItem();
                    }
                    WheelOptions.this.f2111d.setAdapter(new ArrayWheelAdapter((List) ((List) WheelOptions.this.f2114g.get(WheelOptions.this.f2109b.getCurrentItem())).get(i)));
                    WheelOptions.this.f2111d.setCurrentItem(i2);
                    if (WheelOptions.this.f2119l != null) {
                        WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), i, i2);
                    }
                } else if (WheelOptions.this.f2119l != null) {
                    WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), i, 0);
                }
            }
        };
        if (list != null && this.f2115h) {
            this.f2109b.setOnItemSelectedListener(this.f2117j);
        }
        if (list2 != null && this.f2115h) {
            this.f2110c.setOnItemSelectedListener(this.f2118k);
        }
        if (list3 != null && this.f2115h && this.f2119l != null) {
            this.f2111d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), WheelOptions.this.f2110c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f2109b.setAdapter(new ArrayWheelAdapter(list));
        this.f2109b.setCurrentItem(0);
        if (list2 != null) {
            this.f2110c.setAdapter(new ArrayWheelAdapter(list2));
        }
        WheelView wheelView = this.f2110c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.f2111d.setAdapter(new ArrayWheelAdapter(list3));
        }
        WheelView wheelView2 = this.f2111d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f2109b.setIsOptions(true);
        this.f2110c.setIsOptions(true);
        this.f2111d.setIsOptions(true);
        if (this.f2119l != null) {
            this.f2109b.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f2119l.onOptionsSelectChanged(i, WheelOptions.this.f2110c.getCurrentItem(), WheelOptions.this.f2111d.getCurrentItem());
                }
            });
        }
        if (list2 == null) {
            this.f2110c.setVisibility(8);
        } else {
            this.f2110c.setVisibility(0);
            if (this.f2119l != null) {
                this.f2110c.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onItemSelected(int i) {
                        WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), i, WheelOptions.this.f2111d.getCurrentItem());
                    }
                });
            }
        }
        if (list3 == null) {
            this.f2111d.setVisibility(8);
            return;
        }
        this.f2111d.setVisibility(0);
        if (this.f2119l != null) {
            this.f2111d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f2119l.onOptionsSelectChanged(WheelOptions.this.f2109b.getCurrentItem(), WheelOptions.this.f2110c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setTextContentSize(int i) {
        float f = (float) i;
        this.f2109b.setTextSize(f);
        this.f2110c.setTextSize(f);
        this.f2111d.setTextSize(f);
    }

    public void setLabels(String str, String str2, String str3) {
        if (str != null) {
            this.f2109b.setLabel(str);
        }
        if (str2 != null) {
            this.f2110c.setLabel(str2);
        }
        if (str3 != null) {
            this.f2111d.setLabel(str3);
        }
    }

    public void setTextXOffset(int i, int i2, int i3) {
        this.f2109b.setTextXOffset(i);
        this.f2110c.setTextXOffset(i2);
        this.f2111d.setTextXOffset(i3);
    }

    public void setCyclic(boolean z) {
        this.f2109b.setCyclic(z);
        this.f2110c.setCyclic(z);
        this.f2111d.setCyclic(z);
    }

    public void setTypeface(Typeface typeface) {
        this.f2109b.setTypeface(typeface);
        this.f2110c.setTypeface(typeface);
        this.f2111d.setTypeface(typeface);
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.f2109b.setCyclic(z);
        this.f2110c.setCyclic(z2);
        this.f2111d.setCyclic(z3);
    }

    public int[] getCurrentItems() {
        int[] iArr = new int[3];
        int i = 0;
        iArr[0] = this.f2109b.getCurrentItem();
        List<List<T>> list = this.f2113f;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f2110c.getCurrentItem();
        } else {
            iArr[1] = this.f2110c.getCurrentItem() > this.f2113f.get(iArr[0]).size() - 1 ? 0 : this.f2110c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f2114g;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f2111d.getCurrentItem();
        } else {
            if (this.f2111d.getCurrentItem() <= ((List) this.f2114g.get(iArr[0]).get(iArr[1])).size() - 1) {
                i = this.f2111d.getCurrentItem();
            }
            iArr[2] = i;
        }
        return iArr;
    }

    public void setCurrentItems(int i, int i2, int i3) {
        if (this.f2115h) {
            m1737a(i, i2, i3);
            return;
        }
        this.f2109b.setCurrentItem(i);
        this.f2110c.setCurrentItem(i2);
        this.f2111d.setCurrentItem(i3);
    }

    /* renamed from: a */
    private void m1737a(int i, int i2, int i3) {
        if (this.f2112e != null) {
            this.f2109b.setCurrentItem(i);
        }
        List<List<T>> list = this.f2113f;
        if (list != null) {
            this.f2110c.setAdapter(new ArrayWheelAdapter(list.get(i)));
            this.f2110c.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f2114g;
        if (list2 != null) {
            this.f2111d.setAdapter(new ArrayWheelAdapter((List) list2.get(i).get(i2)));
            this.f2111d.setCurrentItem(i3);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f2109b.setLineSpacingMultiplier(f);
        this.f2110c.setLineSpacingMultiplier(f);
        this.f2111d.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f2109b.setDividerColor(i);
        this.f2110c.setDividerColor(i);
        this.f2111d.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f2109b.setDividerType(dividerType);
        this.f2110c.setDividerType(dividerType);
        this.f2111d.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f2109b.setTextColorCenter(i);
        this.f2110c.setTextColorCenter(i);
        this.f2111d.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f2109b.setTextColorOut(i);
        this.f2110c.setTextColorOut(i);
        this.f2111d.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f2109b.isCenterLabel(z);
        this.f2110c.isCenterLabel(z);
        this.f2111d.isCenterLabel(z);
    }

    public void setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f2119l = onOptionsSelectChangeListener;
    }

    public void setLinkage(boolean z) {
        this.f2115h = z;
    }

    public void setItemsVisible(int i) {
        this.f2109b.setItemsVisibleCount(i);
        this.f2110c.setItemsVisibleCount(i);
        this.f2111d.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f2109b.setAlphaGradient(z);
        this.f2110c.setAlphaGradient(z);
        this.f2111d.setAlphaGradient(z);
    }
}
