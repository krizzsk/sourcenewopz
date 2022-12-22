package com.didi.dimina.container.p106ui.tabbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.soda.blocks.constant.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar */
public class BottomTabBar extends FrameLayout {
    public static final int LINE_HEIGHT = 2;

    /* renamed from: a */
    private View f17829a;

    /* renamed from: b */
    private LinearLayout f17830b;

    /* renamed from: c */
    private JSAppConfig.TabBar f17831c;

    /* renamed from: d */
    private DMConfig.OnTabSelectInterceptor f17832d;

    /* renamed from: e */
    private onItemSelectedListener f17833e;

    /* renamed from: f */
    private int f17834f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f17835g;

    /* renamed from: h */
    private boolean f17836h;

    /* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar$onItemSelectedListener */
    public interface onItemSelectedListener {
        void onSelected(int i, int i2, JSAppConfig.TabBar.Item item, boolean z);
    }

    /* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar$onTabSelectInterceptorCallBack */
    public interface onTabSelectInterceptorCallBack {
        void onNext();
    }

    public BottomTabBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f17834f = -1;
        this.f17835g = -1;
    }

    public void setTabBarData(JSAppConfig.TabBar tabBar, int i, ArrayList<Integer> arrayList) {
        this.f17831c = tabBar;
        setBackgroundColor(tabBar.getBackgroundColor());
        m13343b();
        m13341a();
        this.f17830b.removeAllViews();
        List<JSAppConfig.TabBar.Item> list = tabBar.list;
        int i2 = 0;
        while (i2 < list.size()) {
            JSAppConfig.TabBar.Item item = list.get(i2);
            TabView tabView = new TabView(getContext());
            tabView.mo56796a(this.f17831c.getNormalColor(), this.f17831c.getSelectedColor());
            tabView.mo56797a(item, (arrayList == null || arrayList.size() <= i2) ? -1 : arrayList.get(i2).intValue());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.f17830b.addView(tabView, layoutParams);
            tabView.setOnClickListener(new View.OnClickListener(i2, item) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ JSAppConfig.TabBar.Item f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    BottomTabBar.this.m13342a(this.f$1, this.f$2, view);
                }
            });
            i2++;
        }
        setSelectIndex(false, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13342a(int i, JSAppConfig.TabBar.Item item, View view) {
        if (this.f17836h) {
            DMConfig.OnTabSelectInterceptor onTabSelectInterceptor = this.f17832d;
            if (onTabSelectInterceptor != null) {
                onTabSelectInterceptor.onInterceptor(this.f17835g, i, item, new onTabSelectInterceptorCallBack(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onNext() {
                        BottomTabBar.this.m13345c(this.f$1);
                    }
                });
            } else {
                setSelectIndex(true, i);
            }
        } else if (this.f17835g == -1) {
            this.f17835g = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m13345c(int i) {
        setSelectIndex(true, i);
    }

    public void setTabBarData(JSAppConfig.TabBar tabBar, int i) {
        setTabBarData(tabBar, i, (ArrayList<Integer>) null);
    }

    public void setSelectIndex(boolean z, int i) {
        int i2 = this.f17834f;
        if (i2 != -1) {
            ((TabView) this.f17830b.getChildAt(i2)).setChecked(false);
        }
        ((TabView) this.f17830b.getChildAt(i)).setChecked(true);
        int i3 = this.f17834f;
        this.f17834f = i;
        onItemSelectedListener onitemselectedlistener = this.f17833e;
        if (onitemselectedlistener != null) {
            onitemselectedlistener.onSelected(i3, i, this.f17831c.list.get(i), z);
        }
    }

    /* renamed from: a */
    private void m13341a() {
        if (this.f17830b == null) {
            this.f17830b = new LinearLayout(getContext());
            this.f17830b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f17830b.setOrientation(0);
            addView(this.f17830b);
        }
    }

    /* renamed from: b */
    private void m13343b() {
        int borderColor = this.f17831c.getBorderColor();
        if (this.f17829a == null) {
            this.f17829a = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 2);
            layoutParams.gravity = 48;
            this.f17829a.setLayoutParams(layoutParams);
            addView(this.f17829a);
        }
        this.f17829a.setBackgroundColor(borderColor);
    }

    public boolean setTabBarStyle(JSONObject jSONObject) {
        if (this.f17830b.getChildCount() != this.f17831c.list.size()) {
            return false;
        }
        String optString = jSONObject.optString("color");
        String optString2 = jSONObject.optString("selectedColor");
        String optString3 = jSONObject.optString("backgroundColor");
        String optString4 = jSONObject.optString(Const.StyleConst.BORDER_STYLE);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            this.f17831c.color = optString;
            this.f17831c.selectedColor = optString2;
            int childCount = this.f17830b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo56781a(i).mo56796a(this.f17831c.getNormalColor(), this.f17831c.getSelectedColor());
            }
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.f17831c.backgroundColor = optString3;
            setBackgroundColor(this.f17831c.getBackgroundColor());
        }
        if (TextUtils.isEmpty(optString4)) {
            return true;
        }
        this.f17831c.borderStyle = optString4;
        this.f17829a.setBackgroundColor(this.f17831c.getBorderColor());
        return true;
    }

    public boolean setTabBarItem(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index", -1);
        if (m13344b(optInt)) {
            return false;
        }
        String optString = jSONObject.optString("text");
        String optString2 = jSONObject.optString("iconPath");
        String optString3 = jSONObject.optString("selectedIconPath");
        JSAppConfig.TabBar.Item item = this.f17831c.list.get(optInt);
        if (!TextUtils.isEmpty(optString)) {
            item.text = optString;
        }
        if (!TextUtils.isEmpty(optString2)) {
            item.iconPath = optString2;
        }
        if (!TextUtils.isEmpty(optString3)) {
            item.selectedIconPath = optString3;
        }
        TabView a = mo56781a(optInt);
        if (a == null) {
            return true;
        }
        a.setData(item);
        return true;
    }

    public boolean showTabBarRedDot(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index", -1);
        if (m13344b(optInt)) {
            return false;
        }
        TabView a = mo56781a(optInt);
        if (a == null) {
            return true;
        }
        a.mo56798a("");
        return true;
    }

    public boolean hideTabBarRedDot(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m13344b(optInt)) {
            return false;
        }
        TabView a = mo56781a(optInt);
        if (a == null) {
            return true;
        }
        a.mo56795a();
        return true;
    }

    public boolean setTabBarBadge(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m13344b(optInt)) {
            return false;
        }
        String optString = jSONObject.optString("text", "");
        TabView a = mo56781a(optInt);
        if (a == null) {
            return true;
        }
        if ("0".equals(optString)) {
            a.mo56795a();
            return true;
        }
        a.mo56798a(optString);
        return true;
    }

    public boolean removeTabBarBadge(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m13344b(optInt)) {
            return false;
        }
        TabView a = mo56781a(optInt);
        if (a == null) {
            return true;
        }
        a.mo56795a();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TabView mo56781a(int i) {
        if (i < 0 || i > this.f17830b.getChildCount() - 1) {
            return null;
        }
        return (TabView) this.f17830b.getChildAt(i);
    }

    /* renamed from: b */
    private boolean m13344b(int i) {
        if (i == -1 || i >= this.f17831c.list.size() || this.f17830b.getChildCount() != this.f17831c.list.size()) {
            return true;
        }
        return false;
    }

    public void setOnItemSelectedListener(onItemSelectedListener onitemselectedlistener) {
        this.f17833e = onitemselectedlistener;
    }

    public void enable(boolean z) {
        this.f17836h = z;
        if (z && this.f17835g != -1) {
            UIHandlerUtil.post(new Runnable() {
                public void run() {
                    BottomTabBar bottomTabBar = BottomTabBar.this;
                    bottomTabBar.setSelectIndex(true, bottomTabBar.f17835g);
                    int unused = BottomTabBar.this.f17835g = -1;
                }
            });
        }
    }

    public void setOnTabSelectInterceptor(DMConfig.OnTabSelectInterceptor onTabSelectInterceptor) {
        this.f17832d = onTabSelectInterceptor;
    }
}
