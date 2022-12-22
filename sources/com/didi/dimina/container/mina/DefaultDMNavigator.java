package com.didi.dimina.container.mina;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.page.DMFragment;
import com.didi.dimina.container.page.DMLaunchFragment;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DefaultDMNavigator implements IDMNavigator {
    public static final String TAG = "DefaultDMNavigator";
    protected int mContainerViewId;
    protected FragmentManager mFragmentManager;
    protected DMLaunchFragment mLaunchFragment;
    protected LinkedList<IPageHost> mPageStack = new LinkedList<>();

    private static String createTag(String str) {
        return str;
    }

    public DefaultDMNavigator(FragmentManager fragmentManager, int i) {
        this.mFragmentManager = fragmentManager;
        this.mContainerViewId = i;
    }

    public boolean showLaunchView(int i) {
        this.mLaunchFragment = DMLaunchFragment.newInstance(i);
        beginTransactionNoneAnim().add(this.mContainerViewId, (Fragment) this.mLaunchFragment).commitNowAllowingStateLoss();
        return true;
    }

    public boolean hideLaunchView(int i) {
        hideLaunchFragment();
        return true;
    }

    public boolean launch(int i, int i2, final NavigateConfig navigateConfig) {
        hideLaunchFragment();
        final boolean[] zArr = {false};
        final IPageHost newInstance = DMFragment.newInstance(i, i2, navigateConfig);
        beginTransactionNoneAnim().add(this.mContainerViewId, newInstance.getPageHost(), createTag(navigateConfig.url)).runOnCommit(new Runnable() {
            public void run() {
                DefaultDMNavigator.this.mPageStack.addLast(newInstance);
                zArr[0] = true;
                LogUtil.m13411i("launch,runOnCommit completed,url:" + navigateConfig.url);
            }
        }).commitNowAllowingStateLoss();
        return zArr[0];
    }

    public boolean reLaunch(int i, int i2, NavigateConfig navigateConfig) {
        hideLaunchFragment();
        clearAllPages();
        LogUtil.m13411i("reLaunch, newInstance");
        final boolean[] zArr = {false};
        final IPageHost newInstance = DMFragment.newInstance(i, i2, navigateConfig);
        beginTransactionNoneAnim().add(this.mContainerViewId, newInstance.getPageHost(), createTag(navigateConfig.url)).runOnCommit(new Runnable() {
            public void run() {
                LogUtil.m13411i("reLaunch, runOnCommit2 completed,stack size:" + DefaultDMNavigator.this.mPageStack.size());
                DefaultDMNavigator.this.mPageStack.addLast(newInstance);
                zArr[0] = true;
            }
        }).commitNowAllowingStateLoss();
        return zArr[0];
    }

    public boolean redirectTo(int i, int i2, NavigateConfig navigateConfig) {
        hideLaunchFragment();
        final IPageHost newInstance = DMFragment.newInstance(i, i2, navigateConfig);
        FragmentTransaction beginTransactionNoneAnim = beginTransactionNoneAnim();
        if (!this.mPageStack.isEmpty()) {
            IPageHost last = this.mPageStack.getLast();
            if (!(last instanceof ITabBarPageHost)) {
                final String url = last.getPage().getUrl();
                beginTransactionNoneAnim.remove(last.getPageHost()).runOnCommit(new Runnable() {
                    public void run() {
                        LogUtil.m13411i("redirectTo, removeLast: " + url);
                        LogUtil.m13411i("redirectTo, runOnCommit1 completed,stack size: " + DefaultDMNavigator.this.mPageStack.size());
                        DefaultDMNavigator.this.mPageStack.removeLast();
                    }
                });
            } else {
                beginTransactionNoneAnim.hide(last.getPageHost());
            }
        }
        final boolean[] zArr = {false};
        beginTransactionNoneAnim.add(this.mContainerViewId, newInstance.getPageHost(), createTag(navigateConfig.url)).runOnCommit(new Runnable() {
            public void run() {
                DefaultDMNavigator.this.mPageStack.addLast(newInstance);
                zArr[0] = true;
                LogUtil.m13411i("redirectTo, runOnCommit2 completed ,stack size: " + DefaultDMNavigator.this.mPageStack.size());
            }
        }).commitNowAllowingStateLoss();
        return zArr[0];
    }

    public boolean navigateTo(int i, int i2, NavigateConfig navigateConfig) {
        final boolean[] zArr = {false};
        final IPageHost newInstance = DMFragment.newInstance(i, i2, navigateConfig);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.dimina_fragment_enter, R.anim.dimina_no_anim).add(this.mContainerViewId, newInstance.getPageHost(), createTag(navigateConfig.url));
        if (!this.mPageStack.isEmpty()) {
            beginTransaction.hide(this.mPageStack.getLast().getPageHost());
        }
        beginTransaction.runOnCommit(new Runnable() {
            public void run() {
                DefaultDMNavigator.this.mPageStack.addLast(newInstance);
                zArr[0] = true;
                LogUtil.m13411i("navigateTo, runOnCommit completed ,stack size:" + DefaultDMNavigator.this.mPageStack.size());
            }
        }).commitNowAllowingStateLoss();
        return zArr[0];
    }

    public boolean navigateBack(int i, int i2, int i3) {
        FragmentTransaction fragmentTransaction;
        hideLaunchFragment();
        if (i3 > this.mPageStack.size()) {
            return true;
        }
        if (this.mPageStack.isEmpty()) {
            fragmentTransaction = beginTransactionNoneAnim();
        } else {
            fragmentTransaction = this.mFragmentManager.beginTransaction().setCustomAnimations(0, R.anim.dimina_fragment_outer);
        }
        for (int i4 = 0; i4 < i3 && !this.mPageStack.isEmpty(); i4++) {
            fragmentTransaction.remove(this.mPageStack.removeLast().getPageHost());
        }
        if (!this.mPageStack.isEmpty() && this.mPageStack.getLast().getPageHost() != null) {
            fragmentTransaction.show(this.mPageStack.getLast().getPageHost());
        }
        fragmentTransaction.commitNowAllowingStateLoss();
        return true;
    }

    public boolean switchTab(int i, int i2, NavigateConfig navigateConfig) {
        hideLaunchFragment();
        boolean z = false;
        if (this.mPageStack.isEmpty()) {
            return false;
        }
        if (!this.mFragmentManager.isStateSaved() && !this.mFragmentManager.isDestroyed()) {
            z = true;
            if (this.mPageStack.size() > 1) {
                navigateBack(i, i2, this.mPageStack.size() - 1);
                LogUtil.m13411i("close all non-tabBar pages");
            }
            IPageHost first = this.mPageStack.getFirst();
            if (first instanceof ITabBarPageHost) {
                ((ITabBarPageHost) first).switchTab(navigateConfig);
            } else if (first.getPageHost() instanceof DMFragment) {
                return redirectTo(i, i2, navigateConfig);
            }
        }
        return z;
    }

    public boolean closeDimina() {
        clearAllPages();
        return true;
    }

    private void clearAllPages() {
        if (!this.mPageStack.isEmpty()) {
            FragmentTransaction beginTransactionNoneAnim = beginTransactionNoneAnim();
            Iterator it = this.mPageStack.iterator();
            while (it.hasNext()) {
                beginTransactionNoneAnim.remove(((IPageHost) it.next()).getPageHost());
            }
            beginTransactionNoneAnim.runOnCommit(new Runnable() {
                public void run() {
                    LogUtil.m13411i("reLaunch, runOnCommit1 completed,stack size:" + DefaultDMNavigator.this.mPageStack.size());
                    DefaultDMNavigator.this.mPageStack.clear();
                }
            });
            beginTransactionNoneAnim.commitNowAllowingStateLoss();
        }
    }

    public List<IPageHost> getCurrentPages() {
        return Collections.unmodifiableList(this.mPageStack);
    }

    public IPageHost getCurrentPage() {
        try {
            if (!this.mPageStack.isEmpty()) {
                return this.mPageStack.getLast();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public IPageHost getPage(int i) {
        List<IPageHost> currentPages = getCurrentPages();
        for (IPageHost next : currentPages) {
            if (next == null) {
                LogUtil.eRelease(TAG, "pageHost==null, currentPages=" + currentPages);
            } else if (next instanceof ITabBarPageHost) {
                for (IPageHost next2 : ((ITabBarPageHost) next).getCurrentPages()) {
                    if (next2.getPage().getWebViewId() == i) {
                        return next2;
                    }
                }
                continue;
            } else if (i == next.getPage().getWebViewId()) {
                return next;
            }
        }
        return null;
    }

    public IPageHost getPage(String str) {
        List<IPageHost> currentPages = getCurrentPages();
        for (int size = currentPages.size() - 1; size >= 0; size--) {
            IPageHost iPageHost = currentPages.get(size);
            if (iPageHost instanceof ITabBarPageHost) {
                for (IPageHost next : ((ITabBarPageHost) iPageHost).getCurrentPages()) {
                    if (TextUtils.equals(next.getPage().getUrl(), str)) {
                        return next;
                    }
                }
                continue;
            } else if (TextUtils.equals(iPageHost.getPage().getUrl(), str)) {
                return iPageHost;
            }
        }
        return null;
    }

    public IDMNavigator clone() throws CloneNotSupportedException {
        DefaultDMNavigator defaultDMNavigator = (DefaultDMNavigator) super.clone();
        defaultDMNavigator.mPageStack.clear();
        return defaultDMNavigator;
    }

    private void hideLaunchFragment() {
        if (this.mLaunchFragment != null) {
            beginTransactionNoneAnim().remove(this.mLaunchFragment).commitNowAllowingStateLoss();
        }
        this.mLaunchFragment = null;
    }

    private FragmentTransaction beginTransactionNoneAnim() {
        return this.mFragmentManager.beginTransaction();
    }
}
