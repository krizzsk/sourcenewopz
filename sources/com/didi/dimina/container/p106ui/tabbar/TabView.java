package com.didi.dimina.container.p106ui.tabbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.p106ui.tabbar.BadgeView.Badge;
import com.didi.dimina.container.p106ui.tabbar.BadgeView.QBadgeView;
import com.didi.dimina.container.service.ImageLoaderService;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.dimina.container.ui.tabbar.TabView */
class TabView extends FrameLayout implements Checkable {

    /* renamed from: a */
    public static final int f17837a = -1;

    /* renamed from: b */
    private final FrameLayout f17838b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ImageView f17839c;

    /* renamed from: d */
    private final TextView f17840d;

    /* renamed from: e */
    private Badge f17841e;

    /* renamed from: f */
    private JSAppConfig.TabBar.Item f17842f;

    /* renamed from: g */
    private int f17843g;

    /* renamed from: h */
    private int f17844h;

    /* renamed from: i */
    private boolean f17845i;

    public TabView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflate(getContext(), R.layout.dimina_tab_view, this);
        this.f17839c = (ImageView) findViewById(R.id.iconImage);
        this.f17838b = (FrameLayout) findViewById(R.id.badgeContainer);
        this.f17840d = (TextView) findViewById(R.id.tabTextView);
    }

    public void setData(JSAppConfig.TabBar.Item item) {
        mo56797a(item, -1);
    }

    /* renamed from: a */
    public void mo56797a(JSAppConfig.TabBar.Item item, int i) {
        this.f17842f = item;
        m13350c();
        m13348a(i);
    }

    /* renamed from: a */
    public void mo56796a(int i, int i2) {
        this.f17843g = i;
        this.f17844h = i2;
        m13350c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56798a(String str) {
        m13349b();
        try {
            this.f17841e.setBadgeNumber(Integer.parseInt(str));
        } catch (Exception unused) {
            this.f17841e.setBadgeText(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56795a() {
        Badge badge = this.f17841e;
        if (badge != null) {
            badge.hide(true);
        }
    }

    /* renamed from: b */
    private void m13349b() {
        if (this.f17841e == null) {
            this.f17841e = new QBadgeView(getContext()).bindTarget(this.f17838b).setBadgeTextSize(9.0f, true).setBadgeGravity(BadgeDrawable.TOP_END).setBadgePadding(4.0f, true).setBadgeBackgroundColor(Color.parseColor("#FF525D")).setShowShadow(false);
        }
    }

    public void setChecked(boolean z) {
        this.f17845i = z;
        m13351d();
        m13350c();
    }

    public boolean isChecked() {
        return this.f17845i;
    }

    public void toggle() {
        this.f17845i = !this.f17845i;
        m13351d();
        m13350c();
    }

    /* renamed from: c */
    private void m13350c() {
        if (this.f17842f != null && !TextUtils.equals(this.f17840d.getText(), this.f17842f.text)) {
            this.f17840d.setText(this.f17842f.text);
        }
        this.f17840d.setTextColor(isChecked() ? this.f17844h : this.f17843g);
    }

    /* renamed from: d */
    private void m13351d() {
        m13348a(-1);
    }

    /* renamed from: a */
    private void m13348a(int i) {
        if (i != -1) {
            this.f17839c.setImageResource(i);
            return;
        }
        String str = isChecked() ? this.f17842f.selectedIconPath : this.f17842f.iconPath;
        if (str.startsWith("http")) {
            Dimina.getConfig().getAdapterConfig().getImageLoaderService().load(getContext(), str, (ImageLoaderService.FinishDrawableListener) new ImageLoaderService.FinishDrawableListener() {
                public void onDrawableFinish(Drawable drawable) {
                    TabView.this.f17839c.setImageDrawable(drawable);
                }
            });
        } else {
            Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), new File(str), this.f17839c);
        }
    }
}
