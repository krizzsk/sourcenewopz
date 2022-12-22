package com.didi.drouter.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.page.IPageBean;

public class RouterPageReplace extends RouterPageAbs {

    /* renamed from: a */
    private final FragmentManager f19118a;

    /* renamed from: b */
    private final int f19119b;

    /* renamed from: c */
    private Fragment f19120c;

    public RouterPageReplace(FragmentManager fragmentManager, int i) {
        this.f19118a = fragmentManager;
        this.f19119b = i;
    }

    public void showPage(IPageBean iPageBean) {
        Fragment newFragment = newFragment(iPageBean.getPageUri());
        this.f19120c = newFragment;
        addArgsForFragment(newFragment, iPageBean.getPageInfo());
        this.f19118a.beginTransaction().replace(this.f19119b, this.f19120c).commitAllowingStateLoss();
        notifyPageChanged(iPageBean);
    }

    public void popPage() {
        if (this.f19120c != null) {
            this.f19118a.beginTransaction().remove(this.f19120c).commitAllowingStateLoss();
            notifyPageChanged(new IPageBean.EmptyPageBean());
            this.f19120c = null;
        }
    }
}
