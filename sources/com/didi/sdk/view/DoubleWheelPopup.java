package com.didi.sdk.view;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoubleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f37775a;

    /* renamed from: b */
    private String f37776b;

    /* renamed from: c */
    private String f37777c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f37778d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f37779e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f37780f;

    /* renamed from: g */
    private List<String> f37781g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<String> f37782h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public HashMap<String, List<String>> f37783i;

    /* renamed from: j */
    private int f37784j = -1;

    /* renamed from: k */
    private int f37785k = -1;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View.OnClickListener f37786l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View.OnClickListener f37787m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnDoubleWheelSelectListener f37788n;

    /* renamed from: o */
    private SimpleWheelPopup.SimpleWheelAdapter f37789o;

    public interface OnDoubleWheelSelectListener {
        void onSelect(int i, Object obj, int i2, Object obj2);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.double_wheel_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_first);
        this.f37778d = wheel;
        wheel.setData(this.f37781g);
        this.f37779e = (Wheel) this.mRootView.findViewById(R.id.wheel_second);
        m26761a();
        m26763b();
        m26765c();
    }

    /* renamed from: a */
    private void m26761a() {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f37775a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f37776b);
        if (!TextUtils.isEmpty(this.f37776b) && !TextUtils.isEmpty(this.f37777c)) {
            this.f37775a.setMessage(this.f37777c);
        }
        this.f37775a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DoubleWheelPopup.this.f37787m != null) {
                    DoubleWheelPopup.this.f37787m.onClick(view);
                }
                DoubleWheelPopup.this.dismiss();
            }
        });
        this.f37775a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DoubleWheelPopup.this.f37786l != null) {
                    DoubleWheelPopup.this.f37786l.onClick(view);
                }
                if (DoubleWheelPopup.this.f37788n != null) {
                    int selectedIndex = DoubleWheelPopup.this.f37778d.getSelectedIndex();
                    int selectedIndex2 = DoubleWheelPopup.this.f37779e.getSelectedIndex();
                    if (DoubleWheelPopup.this.f37780f != null) {
                        if (DoubleWheelPopup.this.f37782h != null) {
                            DoubleWheelPopup.this.f37788n.onSelect(selectedIndex, DoubleWheelPopup.this.f37780f.get(selectedIndex), selectedIndex2, DoubleWheelPopup.this.f37782h.get(selectedIndex2));
                        } else {
                            DoubleWheelPopup.this.f37788n.onSelect(selectedIndex, DoubleWheelPopup.this.f37780f.get(selectedIndex), 0, (Object) null);
                        }
                    }
                }
                DoubleWheelPopup.this.dismiss();
            }
        });
    }

    /* renamed from: b */
    private void m26763b() {
        this.f37778d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                List list = (List) DoubleWheelPopup.this.f37783i.get((String) DoubleWheelPopup.this.f37780f.get(i));
                if (list == null) {
                    list = new ArrayList();
                    list.add("");
                }
                DoubleWheelPopup.this.f37779e.setData(list);
                List unused = DoubleWheelPopup.this.f37782h = list;
                DoubleWheelPopup.this.f37778d.setContentDescription(DoubleWheelPopup.this.getFirstWheelSelectedValue());
                DoubleWheelPopup.this.f37778d.sendAccessibilityEvent(128);
            }
        });
        List<String> list = this.f37783i.get(this.f37780f.get(0));
        this.f37779e.setData(list);
        this.f37782h = list;
        this.f37779e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                DoubleWheelPopup.this.f37779e.setContentDescription(DoubleWheelPopup.this.getSecondWheelSelectedValue());
                DoubleWheelPopup.this.f37779e.sendAccessibilityEvent(128);
            }
        });
    }

    public void setTitle(String str) {
        this.f37776b = str;
    }

    public void setSubTitle(String str) {
        this.f37777c = str;
    }

    public void setFirstWheelData(SimpleWheelPopup.SimpleWheelAdapter simpleWheelAdapter) {
        this.f37789o = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setFirstWheelData((List<String>) arrayList);
    }

    public void setFirstWheelData(List<String> list) {
        this.f37780f = list;
        this.f37781g = list;
    }

    public void joinData(HashMap<String, List<String>> hashMap) {
        this.f37783i = hashMap;
    }

    public void setFirstWheelData(List<String> list, String str, String str2) {
        this.f37780f = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f37781g = list;
        } else if (list != null) {
            this.f37781g = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f37781g;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setFirstWheelLastSelected(int i) {
        this.f37784j = i;
    }

    public void setSecondWheelLastSelected(int i) {
        this.f37785k = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f37786l = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f37787m = onClickListener;
    }

    public void setOnSelectListener(OnDoubleWheelSelectListener onDoubleWheelSelectListener) {
        this.f37788n = onDoubleWheelSelectListener;
    }

    public String getFirstWheelSelectedValue() {
        return this.f37780f.get(getFirstWheelSelectedIndex());
    }

    public String getSecondWheelSelectedValue() {
        List<String> list = this.f37782h;
        if (list == null) {
            return "";
        }
        return list.get(getSecondWheelSelectedIndex());
    }

    public int getFirstWheelSelectedIndex() {
        return this.f37778d.getSelectedIndex();
    }

    public int getSecondWheelSelectedIndex() {
        return this.f37779e.getSelectedIndex();
    }

    /* renamed from: c */
    private void m26765c() {
        int i;
        int i2;
        List<String> list = this.f37780f;
        if (list != null && (i2 = this.f37784j) >= 0 && i2 < list.size()) {
            this.f37778d.setSelectedIndex(this.f37784j);
            List<String> list2 = this.f37783i.get(this.f37780f.get(this.f37784j));
            this.f37782h = list2;
            this.f37779e.setData(list2);
        }
        List<String> list3 = this.f37782h;
        if (list3 != null && (i = this.f37785k) >= 0 && i < list3.size()) {
            this.f37779e.setSelectedIndex(this.f37785k);
        }
    }
}
