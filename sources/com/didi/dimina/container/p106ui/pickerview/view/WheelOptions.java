package com.didi.dimina.container.p106ui.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.didi.dimina.container.p106ui.pickerview.adapter.ArrayWheelAdapter;
import com.didi.dimina.container.p106ui.pickerview.listener.OnOptionsSelectChangeListener;
import com.didi.dimina.container.p106ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p106ui.wheelview.view.WheelView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.WheelOptions */
public class WheelOptions<T> {

    /* renamed from: a */
    private View f17617a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final WheelView f17618b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WheelView f17619c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WheelView f17620d;

    /* renamed from: e */
    private List<T> f17621e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<List<T>> f17622f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<List<List<T>>> f17623g;

    /* renamed from: h */
    private boolean f17624h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final boolean f17625i;

    /* renamed from: j */
    private OnItemSelectedListener f17626j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnItemSelectedListener f17627k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnOptionsSelectChangeListener f17628l;

    /* renamed from: a */
    private void m13114a() {
    }

    public View getView() {
        return this.f17617a;
    }

    public void setView(View view) {
        this.f17617a = view;
    }

    public WheelOptions(View view, boolean z) {
        this.f17625i = z;
        this.f17617a = view;
        this.f17618b = (WheelView) view.findViewById(R.id.options1);
        this.f17619c = (WheelView) view.findViewById(R.id.options2);
        this.f17620d = (WheelView) view.findViewById(R.id.options3);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f17621e = list;
        this.f17622f = list2;
        this.f17623g = list3;
        this.f17618b.setAdapter(new ArrayWheelAdapter(list));
        this.f17618b.setCurrentItem(0);
        List<List<T>> list4 = this.f17622f;
        if (list4 != null) {
            this.f17619c.setAdapter(new ArrayWheelAdapter(list4.get(0)));
        }
        WheelView wheelView = this.f17619c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f17623g;
        if (list5 != null) {
            this.f17620d.setAdapter(new ArrayWheelAdapter((List) list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.f17620d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f17618b.setIsOptions(true);
        this.f17619c.setIsOptions(true);
        this.f17620d.setIsOptions(true);
        if (this.f17622f == null) {
            this.f17619c.setVisibility(8);
        } else {
            this.f17619c.setVisibility(0);
        }
        if (this.f17623g == null) {
            this.f17620d.setVisibility(8);
        } else {
            this.f17620d.setVisibility(0);
        }
        this.f17626j = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                if (WheelOptions.this.f17622f != null) {
                    int min = !WheelOptions.this.f17625i ? Math.min(WheelOptions.this.f17619c.getCurrentItem(), ((List) WheelOptions.this.f17622f.get(i)).size() - 1) : 0;
                    WheelOptions.this.f17619c.setAdapter(new ArrayWheelAdapter((List) WheelOptions.this.f17622f.get(i)));
                    WheelOptions.this.f17619c.setCurrentItem(min);
                    if (WheelOptions.this.f17623g != null) {
                        WheelOptions.this.f17627k.onItemSelected(min);
                    } else if (WheelOptions.this.f17628l != null) {
                        WheelOptions.this.f17628l.onOptionsSelectChanged(i, min, 0);
                    }
                } else if (WheelOptions.this.f17628l != null) {
                    WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), 0, 0);
                }
            }
        };
        this.f17627k = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = 0;
                if (WheelOptions.this.f17623g != null) {
                    int min = Math.min(WheelOptions.this.f17618b.getCurrentItem(), WheelOptions.this.f17623g.size() - 1);
                    int min2 = Math.min(i, ((List) WheelOptions.this.f17622f.get(min)).size() - 1);
                    if (!WheelOptions.this.f17625i) {
                        i2 = Math.min(WheelOptions.this.f17620d.getCurrentItem(), ((List) ((List) WheelOptions.this.f17623g.get(min)).get(min2)).size() - 1);
                    }
                    WheelOptions.this.f17620d.setAdapter(new ArrayWheelAdapter((List) ((List) WheelOptions.this.f17623g.get(WheelOptions.this.f17618b.getCurrentItem())).get(min2)));
                    WheelOptions.this.f17620d.setCurrentItem(i2);
                    if (WheelOptions.this.f17628l != null) {
                        WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), min2, i2);
                    }
                } else if (WheelOptions.this.f17628l != null) {
                    WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), i, 0);
                }
            }
        };
        if (list != null && this.f17624h) {
            this.f17618b.setOnItemSelectedListener(this.f17626j);
        }
        if (list2 != null && this.f17624h) {
            this.f17619c.setOnItemSelectedListener(this.f17627k);
        }
        if (list3 != null && this.f17624h && this.f17628l != null) {
            this.f17620d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), WheelOptions.this.f17619c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f17618b.setAdapter(new ArrayWheelAdapter(list));
        this.f17618b.setCurrentItem(0);
        if (list2 != null) {
            this.f17619c.setAdapter(new ArrayWheelAdapter(list2));
        }
        WheelView wheelView = this.f17619c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.f17620d.setAdapter(new ArrayWheelAdapter(list3));
        }
        WheelView wheelView2 = this.f17620d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f17618b.setIsOptions(true);
        this.f17619c.setIsOptions(true);
        this.f17620d.setIsOptions(true);
        if (this.f17628l != null) {
            this.f17618b.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f17628l.onOptionsSelectChanged(i, WheelOptions.this.f17619c.getCurrentItem(), WheelOptions.this.f17620d.getCurrentItem());
                }
            });
        }
        if (list2 == null) {
            this.f17619c.setVisibility(8);
        } else {
            this.f17619c.setVisibility(0);
            if (this.f17628l != null) {
                this.f17619c.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onItemSelected(int i) {
                        WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), i, WheelOptions.this.f17620d.getCurrentItem());
                    }
                });
            }
        }
        if (list3 == null) {
            this.f17620d.setVisibility(8);
            return;
        }
        this.f17620d.setVisibility(0);
        if (this.f17628l != null) {
            this.f17620d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f17628l.onOptionsSelectChanged(WheelOptions.this.f17618b.getCurrentItem(), WheelOptions.this.f17619c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setTextContentSize(int i) {
        float f = (float) i;
        this.f17618b.setTextSize(f);
        this.f17619c.setTextSize(f);
        this.f17620d.setTextSize(f);
    }

    public void setLabels(String str, String str2, String str3) {
        if (str != null) {
            this.f17618b.setLabel(str);
        }
        if (str2 != null) {
            this.f17619c.setLabel(str2);
        }
        if (str3 != null) {
            this.f17620d.setLabel(str3);
        }
    }

    public void setTextXOffset(int i, int i2, int i3) {
        this.f17618b.setTextXOffset(i);
        this.f17619c.setTextXOffset(i2);
        this.f17620d.setTextXOffset(i3);
    }

    public void setCyclic(boolean z) {
        this.f17618b.setCyclic(z);
        this.f17619c.setCyclic(z);
        this.f17620d.setCyclic(z);
    }

    public void setTypeface(Typeface typeface) {
        this.f17618b.setTypeface(typeface);
        this.f17619c.setTypeface(typeface);
        this.f17620d.setTypeface(typeface);
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.f17618b.setCyclic(z);
        this.f17619c.setCyclic(z2);
        this.f17620d.setCyclic(z3);
    }

    public int[] getCurrentItems() {
        int[] iArr = new int[3];
        int i = 0;
        iArr[0] = this.f17618b.getCurrentItem();
        List<List<T>> list = this.f17622f;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f17619c.getCurrentItem();
        } else {
            iArr[1] = this.f17619c.getCurrentItem() > this.f17622f.get(iArr[0]).size() - 1 ? 0 : this.f17619c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f17623g;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f17620d.getCurrentItem();
        } else {
            if (this.f17620d.getCurrentItem() <= ((List) this.f17623g.get(iArr[0]).get(iArr[1])).size() - 1) {
                i = this.f17620d.getCurrentItem();
            }
            iArr[2] = i;
        }
        return iArr;
    }

    public void setCurrentItems(int i, int i2, int i3) {
        if (this.f17624h) {
            m13115a(i, i2, i3);
            return;
        }
        this.f17618b.setCurrentItem(i);
        this.f17619c.setCurrentItem(i2);
        this.f17620d.setCurrentItem(i3);
    }

    /* renamed from: a */
    private void m13115a(int i, int i2, int i3) {
        if (this.f17621e != null) {
            this.f17618b.setCurrentItem(i);
        }
        List<List<T>> list = this.f17622f;
        if (list != null) {
            this.f17619c.setAdapter(new ArrayWheelAdapter(list.get(i)));
            this.f17619c.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f17623g;
        if (list2 != null) {
            this.f17620d.setAdapter(new ArrayWheelAdapter((List) list2.get(i).get(i2)));
            this.f17620d.setCurrentItem(i3);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f17618b.setLineSpacingMultiplier(f);
        this.f17619c.setLineSpacingMultiplier(f);
        this.f17620d.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f17618b.setDividerColor(i);
        this.f17619c.setDividerColor(i);
        this.f17620d.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f17618b.setDividerType(dividerType);
        this.f17619c.setDividerType(dividerType);
        this.f17620d.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f17618b.setTextColorCenter(i);
        this.f17619c.setTextColorCenter(i);
        this.f17620d.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f17618b.setTextColorOut(i);
        this.f17619c.setTextColorOut(i);
        this.f17620d.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f17618b.isCenterLabel(z);
        this.f17619c.isCenterLabel(z);
        this.f17620d.isCenterLabel(z);
    }

    public void setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f17628l = onOptionsSelectChangeListener;
    }

    public void setLinkage(boolean z) {
        this.f17624h = z;
    }

    public void setItemsVisible(int i) {
        this.f17618b.setItemsVisibleCount(i);
        this.f17619c.setItemsVisibleCount(i);
        this.f17620d.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f17618b.setAlphaGradient(z);
        this.f17619c.setAlphaGradient(z);
        this.f17620d.setAlphaGradient(z);
    }
}
