package com.didi.nova.assembly.p127ui.banner;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.Fly;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.banner.a */
/* compiled from: BannerPagerAdapter */
class C10277a extends PagerAdapter {

    /* renamed from: a */
    public int f29248a;

    /* renamed from: b */
    public FitType f29249b = FitType.FIT_None;

    /* renamed from: c */
    private List<String> f29250c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WeakReference<Banner> f29251d;

    /* renamed from: e */
    private boolean f29252e;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public C10277a(Banner banner, List<String> list, boolean z) {
        this.f29252e = z;
        m20636b(list);
        this.f29251d = new WeakReference<>(banner);
    }

    public int getCount() {
        return this.f29250c.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        viewGroup.addView(imageView);
        Fly.with(viewGroup.getContext()).load(this.f29249b, this.f29250c.get(i)).placeholder(this.f29248a).error(this.f29248a).centerCrop().into(imageView);
        imageView.setOnClickListener(new BannerPagerAdapter$1(this, i));
        return imageView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    /* renamed from: a */
    public void mo80219a(List<String> list) {
        m20636b(list);
    }

    /* renamed from: b */
    private void m20636b(List<String> list) {
        this.f29250c.clear();
        int size = list.size();
        if (size <= 1 || !this.f29252e) {
            this.f29250c.addAll(list);
            return;
        }
        this.f29250c.add(list.get(size - 1));
        this.f29250c.addAll(list);
        this.f29250c.add(list.get(0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m20635b(int i) {
        if (!this.f29252e) {
            return i;
        }
        if (this.f29250c.size() <= 1) {
            return 0;
        }
        int size = this.f29250c.size() - 2;
        return ((i + size) - 1) % size;
    }

    /* renamed from: a */
    public void mo80218a(int i) {
        this.f29248a = i;
    }

    /* renamed from: a */
    private boolean m20634a(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().endsWith(".gif");
    }
}
