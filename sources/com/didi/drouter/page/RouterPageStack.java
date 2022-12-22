package com.didi.drouter.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.page.IPageBean;
import java.util.ArrayList;
import java.util.List;

public class RouterPageStack extends RouterPageAbs {

    /* renamed from: a */
    private final FragmentManager f19121a;

    /* renamed from: b */
    private final int f19122b;

    /* renamed from: c */
    private final List<Fragment> f19123c = new ArrayList();

    /* renamed from: d */
    private final List<IPageBean> f19124d = new ArrayList();

    public RouterPageStack(FragmentManager fragmentManager, int i) {
        this.f19121a = fragmentManager;
        this.f19122b = i;
    }

    public void showPage(IPageBean iPageBean) {
        Fragment newFragment = newFragment(iPageBean.getPageUri());
        addArgsForFragment(newFragment, iPageBean.getPageInfo());
        this.f19121a.beginTransaction().add(this.f19122b, newFragment).commitAllowingStateLoss();
        notifyPageChanged(iPageBean);
        this.f19123c.add(newFragment);
        this.f19124d.add(iPageBean);
    }

    public void popPage() {
        if (!this.f19123c.isEmpty()) {
            int size = this.f19123c.size() - 1;
            this.f19124d.remove(size);
            this.f19121a.beginTransaction().remove(this.f19123c.remove(size)).commitAllowingStateLoss();
            int i = size - 1;
            notifyPageChanged((i < 0 || i >= this.f19124d.size()) ? new IPageBean.EmptyPageBean() : this.f19124d.get(i));
        }
    }

    public IPageBean getCurPage() {
        return super.getCurPage();
    }
}
