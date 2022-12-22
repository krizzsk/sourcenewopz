package com.didiglobal.mew.framework.widget.p202vp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.vp.MViewPager */
public class MViewPager extends RelativeLayout {

    /* renamed from: a */
    private ViewPager2 f50282a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewPager2.OnPageChangeCallback f50283b;

    /* renamed from: c */
    private RelativeLayout f50284c;

    /* renamed from: d */
    private MVpAdapter f50285d;

    /* renamed from: e */
    private ViewPager2.OnPageChangeCallback f50286e = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
            if (MViewPager.this.f50283b != null) {
                MViewPager.this.f50283b.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (MViewPager.this.f50283b != null) {
                MViewPager.this.f50283b.onPageSelected(i);
            }
        }
    };

    public MViewPager(Context context) {
        super(context);
        m36221a(context, (AttributeSet) null, 0);
    }

    public MViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36221a(context, attributeSet, 0);
    }

    public MViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36221a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m36221a(Context context, AttributeSet attributeSet, int i) {
        View.inflate(context, R.layout.mew_widget_vp, this);
        this.f50284c = (RelativeLayout) findViewById(R.id.mew_vp_ext);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.mew_vp);
        this.f50282a = viewPager2;
        viewPager2.setOrientation(0);
        this.f50282a.registerOnPageChangeCallback(this.f50286e);
        MVpAdapter mVpAdapter = new MVpAdapter();
        this.f50285d = mVpAdapter;
        this.f50282a.setAdapter(mVpAdapter);
    }

    public void clear() {
        this.f50285d.clear();
    }

    public void setData(List<MVPCardProperty> list) {
        this.f50285d.setCardPropertyList(list);
    }

    public void addData(List<MVPCardProperty> list) {
        this.f50285d.addCardPropertyList(list);
    }

    public void addData(int i, MVPCardProperty mVPCardProperty) {
        this.f50285d.addCardProperty(i, mVPCardProperty);
    }

    public void setPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f50283b = onPageChangeCallback;
    }

    public void setViewPagerExtView(View view, int i) {
        this.f50284c.removeAllViews();
        this.f50284c.addView(view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50284c.getLayoutParams();
        layoutParams.topMargin = i;
        this.f50284c.setLayoutParams(layoutParams);
    }
}
