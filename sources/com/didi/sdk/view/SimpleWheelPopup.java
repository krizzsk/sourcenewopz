package com.didi.sdk.view;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SimpleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f37877a;

    /* renamed from: b */
    private String f37878b;

    /* renamed from: c */
    private String f37879c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f37880d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<String> f37881e;

    /* renamed from: f */
    private List<String> f37882f;

    /* renamed from: g */
    private int f37883g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f37884h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f37885i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnSelectListener f37886j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SimpleWheelAdapter f37887k;

    /* renamed from: l */
    private String f37888l;

    /* renamed from: m */
    private String f37889m;

    public interface OnSelectListener {
        void onSelect(int i, Object obj);
    }

    public interface SimpleWheelAdapter {
        int getCount();

        String getItemForUI(int i);

        Object getItemForUse(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.simple_wheel_popup;
    }

    public CommonPopupTitleBar getTitleBar() {
        return this.f37877a;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_simple);
        this.f37880d = wheel;
        wheel.setData(this.f37882f);
        m26813a();
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f37877a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f37878b);
        if (!TextUtils.isEmpty(this.f37879c)) {
            this.f37877a.setMessage(this.f37879c);
        }
        this.f37880d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                SimpleWheelPopup.this.f37880d.setContentDescription(SimpleWheelPopup.this.f37880d.getSelectedValue());
                SimpleWheelPopup.this.f37880d.sendAccessibilityEvent(128);
            }
        });
        this.f37877a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SimpleWheelPopup.this.f37885i != null) {
                    SimpleWheelPopup.this.f37885i.onClick(view);
                }
                SimpleWheelPopup.this.dismiss();
            }
        });
        if (!TextUtil.isEmpty(this.f37888l)) {
            this.f37877a.setLeftText(this.f37888l);
        }
        if (!TextUtil.isEmpty(this.f37889m)) {
            this.f37877a.setRightText(this.f37889m);
        }
        this.f37877a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SimpleWheelPopup.this.f37884h != null) {
                    SimpleWheelPopup.this.f37884h.onClick(view);
                }
                if (SimpleWheelPopup.this.f37886j != null) {
                    int selectedIndex = SimpleWheelPopup.this.f37880d.getSelectedIndex();
                    if (SimpleWheelPopup.this.f37887k != null) {
                        SimpleWheelPopup.this.f37886j.onSelect(selectedIndex, SimpleWheelPopup.this.f37887k.getItemForUse(selectedIndex));
                    } else if (SimpleWheelPopup.this.f37881e != null) {
                        SimpleWheelPopup.this.f37886j.onSelect(selectedIndex, SimpleWheelPopup.this.f37881e.get(selectedIndex));
                    }
                }
                SimpleWheelPopup.this.dismiss();
            }
        });
    }

    public void setLeftText(String str) {
        this.f37888l = str;
    }

    public void setRightText(String str) {
        this.f37889m = str;
    }

    public void setTitle(String str) {
        this.f37878b = str;
    }

    public void setMessage(String str) {
        this.f37879c = str;
    }

    public void setWheelData(SimpleWheelAdapter simpleWheelAdapter) {
        this.f37887k = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setWheelData((List<String>) arrayList);
    }

    public void setWheelData(List<String> list) {
        this.f37881e = list;
        this.f37882f = list;
    }

    public void setWheelData(List<String> list, String str, String str2) {
        this.f37881e = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f37882f = list;
        } else if (list != null) {
            this.f37882f = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f37882f;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setLastSelected(int i) {
        this.f37883g = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f37884h = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f37885i = onClickListener;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.f37886j = onSelectListener;
    }

    public String getSelectedValue() {
        return this.f37881e.get(getSelectedIndex());
    }

    public int getSelectedIndex() {
        Wheel wheel = this.f37880d;
        if (wheel != null) {
            return wheel.getSelectedIndex();
        }
        int i = this.f37883g;
        if (i > -1) {
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    private void m26813a() {
        Wheel wheel;
        if (m26814b() > -1 && (wheel = this.f37880d) != null) {
            wheel.setSelectedIndex(this.f37883g);
        }
    }

    /* renamed from: b */
    private int m26814b() {
        int i;
        List<String> list = this.f37881e;
        if (list == null || (i = this.f37883g) < 0 || i >= list.size()) {
            return -1;
        }
        return this.f37883g;
    }
}
