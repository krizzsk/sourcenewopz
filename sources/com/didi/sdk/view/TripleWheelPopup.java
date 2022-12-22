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

public class TripleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f37909a;

    /* renamed from: b */
    private String f37910b;

    /* renamed from: c */
    private String f37911c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f37912d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f37913e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Wheel f37914f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<String> f37915g;

    /* renamed from: h */
    private List<String> f37916h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public HashMap<String, List<String>> f37917i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<String> f37918j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<String> f37919k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public HashMap<String, List<String>> f37920l;

    /* renamed from: m */
    private int f37921m = -1;

    /* renamed from: n */
    private int f37922n = -1;

    /* renamed from: o */
    private int f37923o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View.OnClickListener f37924p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View.OnClickListener f37925q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnTripleWheelSelectListener f37926r;

    /* renamed from: s */
    private SimpleWheelPopup.SimpleWheelAdapter f37927s;

    public interface OnTripleWheelSelectListener {
        void onSelect(int i, Object obj, int i2, Object obj2, int i3, Object obj3);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.triple_wheel_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_first);
        this.f37912d = wheel;
        wheel.setData(this.f37916h);
        this.f37913e = (Wheel) this.mRootView.findViewById(R.id.wheel_second);
        this.f37914f = (Wheel) this.mRootView.findViewById(R.id.wheel_third);
        m26835a();
        m26838b();
    }

    /* renamed from: a */
    private void m26835a() {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f37909a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f37910b);
        if (!TextUtils.isEmpty(this.f37910b)) {
            this.f37909a.setMessage(this.f37911c);
        }
        this.f37909a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TripleWheelPopup.this.f37925q != null) {
                    TripleWheelPopup.this.f37925q.onClick(view);
                }
                TripleWheelPopup.this.dismiss();
            }
        });
        this.f37909a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TripleWheelPopup.this.f37924p != null) {
                    TripleWheelPopup.this.f37924p.onClick(view);
                }
                if (TripleWheelPopup.this.f37926r != null) {
                    int selectedIndex = TripleWheelPopup.this.f37912d.getSelectedIndex();
                    int selectedIndex2 = TripleWheelPopup.this.f37913e.getSelectedIndex();
                    int selectedIndex3 = TripleWheelPopup.this.f37914f.getSelectedIndex();
                    String str = (String) TripleWheelPopup.this.f37915g.get(selectedIndex);
                    String str2 = (String) TripleWheelPopup.this.f37918j.get(selectedIndex2);
                    String str3 = (String) TripleWheelPopup.this.f37919k.get(selectedIndex3);
                    if (TripleWheelPopup.this.f37915g != null) {
                        if (TripleWheelPopup.this.f37918j == null) {
                            TripleWheelPopup.this.f37926r.onSelect(selectedIndex, str, 0, "", 0, "");
                        } else if (TripleWheelPopup.this.f37919k == null) {
                            TripleWheelPopup.this.f37926r.onSelect(selectedIndex, str, selectedIndex2, str2, 0, "");
                        } else {
                            TripleWheelPopup.this.f37926r.onSelect(selectedIndex, str, selectedIndex2, str2, selectedIndex3, str3);
                        }
                    }
                }
                TripleWheelPopup.this.dismiss();
            }
        });
    }

    /* renamed from: b */
    private void m26838b() {
        List<String> list = this.f37915g;
        if (list != null) {
            String str = list.get(0);
            HashMap<String, List<String>> hashMap = this.f37917i;
            if (hashMap != null) {
                List<String> list2 = hashMap.get(str);
                this.f37913e.setData(list2);
                this.f37918j = list2;
                if (this.f37920l != null) {
                    List<String> list3 = this.f37920l.get(list2.get(0));
                    this.f37919k = list3;
                    this.f37914f.setData(list3);
                }
            }
        }
        this.f37912d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                String str = (String) TripleWheelPopup.this.f37915g.get(i);
                if (TripleWheelPopup.this.f37917i != null) {
                    List list = (List) TripleWheelPopup.this.f37917i.get(str);
                    if (list == null) {
                        list = new ArrayList();
                        list.add("");
                    }
                    TripleWheelPopup.this.f37913e.setData(list);
                    List unused = TripleWheelPopup.this.f37918j = list;
                    if (TripleWheelPopup.this.f37920l != null) {
                        List list2 = (List) TripleWheelPopup.this.f37920l.get((String) list.get(0));
                        if (list2 == null) {
                            list2 = new ArrayList();
                            list2.add("");
                        }
                        TripleWheelPopup.this.f37914f.setData(list2);
                    }
                }
                TripleWheelPopup.this.f37912d.setContentDescription(TripleWheelPopup.this.getFirstWheelSelectedValue());
                TripleWheelPopup.this.f37912d.sendAccessibilityEvent(128);
            }
        });
        this.f37913e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (!(TripleWheelPopup.this.f37918j == null || TripleWheelPopup.this.f37920l == null)) {
                    TripleWheelPopup tripleWheelPopup = TripleWheelPopup.this;
                    List unused = tripleWheelPopup.f37919k = (List) tripleWheelPopup.f37920l.get((String) TripleWheelPopup.this.f37918j.get(i));
                    if (TripleWheelPopup.this.f37919k == null) {
                        List unused2 = TripleWheelPopup.this.f37919k = new ArrayList();
                        TripleWheelPopup.this.f37919k.add("");
                    }
                    TripleWheelPopup.this.f37914f.setData(TripleWheelPopup.this.f37919k);
                }
                TripleWheelPopup.this.f37913e.setContentDescription(TripleWheelPopup.this.getSecondWheelSelectedValue());
                TripleWheelPopup.this.f37913e.sendAccessibilityEvent(128);
            }
        });
        this.f37914f.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                TripleWheelPopup.this.f37914f.setContentDescription(TripleWheelPopup.this.getThirdWheelSelectedValue());
                TripleWheelPopup.this.f37914f.sendAccessibilityEvent(128);
            }
        });
        m26840c();
    }

    public void setTitle(String str) {
        this.f37910b = str;
    }

    public void setSubTitle(String str) {
        this.f37911c = str;
    }

    public void setFirstWheelData(SimpleWheelPopup.SimpleWheelAdapter simpleWheelAdapter) {
        this.f37927s = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setFirstWheelData((List<String>) arrayList);
    }

    public void setFirstWheelData(List<String> list) {
        this.f37915g = list;
        this.f37916h = list;
    }

    public void joinDataToSecondWheel(HashMap<String, List<String>> hashMap) {
        this.f37917i = hashMap;
    }

    public void joinDataToThirdWheel(HashMap<String, List<String>> hashMap) {
        this.f37920l = hashMap;
    }

    public void setFirstWheelData(List<String> list, String str, String str2) {
        this.f37915g = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f37916h = list;
        } else if (list != null) {
            this.f37916h = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f37916h;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setFirstWheelLastSelected(int i) {
        this.f37921m = i;
    }

    public void setSecondWheelLastSelected(int i) {
        this.f37922n = i;
    }

    public void setThirdWheelLastSelected(int i) {
        this.f37923o = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f37924p = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f37925q = onClickListener;
    }

    public void setOnSelectListener(OnTripleWheelSelectListener onTripleWheelSelectListener) {
        this.f37926r = onTripleWheelSelectListener;
    }

    public int getFirstWheelSelectedIndex() {
        return this.f37912d.getSelectedIndex();
    }

    public String getFirstWheelSelectedValue() {
        return this.f37915g.get(getFirstWheelSelectedIndex());
    }

    public int getSecondWheelSelectedIndex() {
        return this.f37913e.getSelectedIndex();
    }

    public String getSecondWheelSelectedValue() {
        return this.f37918j.get(getSecondWheelSelectedIndex());
    }

    public int getThirdWheelSelectedIndex() {
        return this.f37914f.getSelectedIndex();
    }

    public String getThirdWheelSelectedValue() {
        return this.f37919k.get(getThirdWheelSelectedIndex());
    }

    /* renamed from: c */
    private void m26840c() {
        int i;
        int i2;
        int i3;
        List<String> list = this.f37915g;
        if (list != null && (i3 = this.f37921m) >= 0 && i3 < list.size()) {
            this.f37912d.setSelectedIndex(this.f37921m);
            List<String> list2 = this.f37917i.get(this.f37915g.get(this.f37921m));
            this.f37918j = list2;
            this.f37913e.setData(list2);
        }
        List<String> list3 = this.f37918j;
        if (list3 != null && (i2 = this.f37922n) >= 0 && i2 < list3.size()) {
            this.f37913e.setSelectedIndex(this.f37922n);
            List<String> list4 = this.f37920l.get(this.f37918j.get(this.f37922n));
            this.f37919k = list4;
            this.f37914f.setData(list4);
        }
        List<String> list5 = this.f37919k;
        if (list5 != null && (i = this.f37923o) >= 0 && i < list5.size()) {
            this.f37914f.setSelectedIndex(this.f37923o);
        }
    }
}
