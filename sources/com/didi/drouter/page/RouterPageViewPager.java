package com.didi.drouter.page;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.didi.drouter.page.IPageBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouterPageViewPager extends RouterPageAbs {

    /* renamed from: a */
    private final ViewPager f19125a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FragmentManager f19126b;

    /* renamed from: c */
    private final ViewPagerAdapter f19127c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<String> f19128d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<IPageBean> f19129e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f19130f = new ArrayList();

    public RouterPageViewPager(FragmentManager fragmentManager, ViewPager viewPager) {
        this.f19126b = fragmentManager;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        this.f19127c = viewPagerAdapter;
        this.f19125a = viewPager;
        viewPager.setAdapter(viewPagerAdapter);
        this.f19125a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                RouterPageViewPager.this.m14324a(i);
            }
        });
    }

    public void update(IPageBean... iPageBeanArr) {
        update((List<IPageBean>) Arrays.asList(iPageBeanArr));
    }

    public void update(List<IPageBean> list) {
        this.f19130f = (List) ((ArrayList) this.f19128d).clone();
        this.f19128d.clear();
        this.f19129e.clear();
        for (int i = 0; i < list.size(); i++) {
            this.f19128d.add(list.get(i).getPageUri());
            this.f19129e.add(list.get(i));
        }
        this.f19127c.notifyDataSetChanged();
        m14324a(this.f19125a.getCurrentItem());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14324a(int i) {
        notifyPageChanged(i < this.f19129e.size() ? this.f19129e.get(i) : new IPageBean.EmptyPageBean());
    }

    public void showPage(IPageBean iPageBean) {
        int indexOf = this.f19128d.indexOf(iPageBean.getPageUri());
        if (indexOf != -1) {
            this.f19125a.setCurrentItem(indexOf, false);
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public int getItemPosition(Object obj) {
            return -2;
        }

        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            RouterPageViewPager routerPageViewPager = RouterPageViewPager.this;
            Fragment newFragment = routerPageViewPager.newFragment((String) routerPageViewPager.f19128d.get(i));
            RouterPageViewPager.this.addArgsForFragment(newFragment, (RouterPageViewPager.this.f19129e.get(i) == null || ((IPageBean) RouterPageViewPager.this.f19129e.get(i)).getPageInfo() == null) ? null : ((IPageBean) RouterPageViewPager.this.f19129e.get(i)).getPageInfo());
            return newFragment;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < RouterPageViewPager.this.f19128d.size() && i < RouterPageViewPager.this.f19130f.size() && !((String) RouterPageViewPager.this.f19128d.get(i)).equals(RouterPageViewPager.this.f19130f.get(i))) {
                FragmentTransaction beginTransaction = RouterPageViewPager.this.f19126b.beginTransaction();
                Fragment findFragmentByTag = RouterPageViewPager.this.f19126b.findFragmentByTag(RouterPageViewPager.m14326b(viewGroup.getId(), (long) i));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                    beginTransaction.commitNowAllowingStateLoss();
                }
            }
            return super.instantiateItem(viewGroup, i);
        }

        public int getCount() {
            return RouterPageViewPager.this.f19128d.size();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m14326b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
