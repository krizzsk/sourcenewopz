package com.didi.sdk.app;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class BusinessContextHelper implements KeyEvent.Callback {
    public static final String TAG = "BusinessContextHelper";

    /* renamed from: a */
    private static final Logger f35139a = LoggerFactory.getLogger(TAG);
    @Deprecated

    /* renamed from: b */
    private static final String f35140b = "PAGE_URI";

    /* renamed from: c */
    private static Logger f35141c = LoggerFactory.getLogger(TAG);

    /* renamed from: d */
    private ReceiverDelegateManager f35142d;

    /* renamed from: e */
    private FragmentActivity f35143e;

    /* renamed from: f */
    private FragmentManager f35144f;

    /* renamed from: g */
    private NavigationImpl f35145g;

    /* renamed from: h */
    private HashMap<String, BaseBusinessContext> f35146h = new HashMap<>();

    /* renamed from: i */
    private int f35147i;

    /* renamed from: j */
    private Class<? extends BaseBusinessContext> f35148j;

    /* renamed from: k */
    private ITitleBarDelegate f35149k;

    /* renamed from: l */
    private IStatusBarDelegate f35150l;

    /* renamed from: m */
    private IBizNavBarDelegate f35151m;

    /* renamed from: n */
    private INavigationListener f35152n;

    /* renamed from: o */
    private IBusinessContextChangedListener f35153o;

    /* renamed from: p */
    private OnBackResultListener f35154p;

    public Class<? extends BaseBusinessContext> getBusinessContextImpl() {
        return this.f35148j;
    }

    public BusinessContextHelper(FragmentActivity fragmentActivity, ITitleBarDelegate iTitleBarDelegate, IStatusBarDelegate iStatusBarDelegate, IBizNavBarDelegate iBizNavBarDelegate, Class<? extends BaseBusinessContext> cls, int i, Map<Integer, Class<? extends Fragment>> map) {
        this.f35143e = fragmentActivity;
        this.f35144f = fragmentActivity.getSupportFragmentManager();
        this.f35149k = iTitleBarDelegate;
        this.f35150l = iStatusBarDelegate;
        this.f35151m = iBizNavBarDelegate;
        this.f35142d = new ReceiverDelegateManager(this);
        this.f35147i = i;
        this.f35148j = cls;
        this.f35145g = new NavigationImpl(this.f35144f, i, iStatusBarDelegate, map);
    }

    public void addListeners(IBusinessContextChangedListener iBusinessContextChangedListener) {
        BusinessContextManager.getInstance().mo90611a(iBusinessContextChangedListener);
        this.f35153o = iBusinessContextChangedListener;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Fragment currentFragment = this.f35145g.getCurrentFragment(this.f35143e.getSupportFragmentManager());
        if (currentFragment != null) {
            currentFragment.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public <T extends BaseBusinessContext> T getBusinessContext(String str, Class<? extends BaseBusinessContext> cls) {
        T t = (BaseBusinessContext) this.f35146h.get(str);
        if (t != null) {
            return t;
        }
        try {
            t = (BaseBusinessContext) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        t.assemble(this.f35143e, this.f35145g, this.f35149k, this.f35150l, this.f35151m);
        this.f35146h.put(str, t);
        return t;
    }

    public <T extends BaseBusinessContext> T getBusinessContext(Uri uri) {
        return getBusinessContext(uri.getHost(), this.f35148j);
    }

    public void onResume() {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.onResume();
        }
    }

    public void onPause() {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.onPause();
        }
    }

    public void setOnBackResultListener(OnBackResultListener onBackResultListener) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.setOnBackResultListener(onBackResultListener);
            this.f35154p = onBackResultListener;
        }
    }

    public void safePost(Runnable runnable) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.safePost(runnable);
        }
    }

    public void setNavigationListener(INavigationListener iNavigationListener) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.setNavigationListener(iNavigationListener);
            this.f35152n = iNavigationListener;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyUp(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyLongPress(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            return navigationImpl.onKeyMultiple(i, i2, keyEvent);
        }
        return false;
    }

    public void transition(BaseBusinessContext baseBusinessContext, Intent intent) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.transition(baseBusinessContext, intent);
        }
    }

    public Fragment matchPage(BaseBusinessContext baseBusinessContext, Intent intent) {
        return this.f35145g.matchPage(baseBusinessContext, intent);
    }

    public void registerStaticReceivers(Class<? extends AbsDidiBroadcastReceiver> cls) {
        this.f35142d.loadDelegates(cls);
    }

    public void removeStaticReceivers() {
        this.f35142d.unloadDelegates();
    }

    public void showDialog(DialogFragment dialogFragment) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.showDialog(dialogFragment);
        }
    }

    public void dismissDialog(DialogFragment dialogFragment) {
        NavigationImpl navigationImpl = this.f35145g;
        if (navigationImpl != null) {
            navigationImpl.dismissDialog(dialogFragment);
        }
    }

    public void popBackStack(int i) {
        this.f35145g.popBackStack(i);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public void mo90588a() {
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(this.f35143e.getPackageManager(), this.f35143e.getPackageName(), 128).metaData;
            for (String str : bundle.keySet()) {
                if (str.startsWith(f35140b)) {
                    m24838a(bundle.getString(str));
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            f35141c.error("", (Throwable) e);
        }
    }

    @Deprecated
    /* renamed from: a */
    private void m24838a(String str) {
        String str2;
        IntentFilter intentFilter = new IntentFilter();
        try {
            String[] split = str.split(";");
            int indexOf = split[0].indexOf(58);
            intentFilter.addDataScheme(split[0].substring(0, indexOf));
            int i = indexOf + 3;
            int indexOf2 = split[0].indexOf(47, i);
            if (indexOf2 == -1) {
                str2 = split[0].substring(i);
            } else {
                String substring = split[0].substring(i, indexOf2);
                intentFilter.addDataPath(split[0].substring(indexOf2), 1);
                str2 = substring;
            }
            intentFilter.addDataAuthority(str2, (String) null);
            this.f35145g.registerFilter(intentFilter, Class.forName(split[1]));
        } catch (Exception e) {
            f35141c.error("", (Throwable) e);
        }
    }
}
