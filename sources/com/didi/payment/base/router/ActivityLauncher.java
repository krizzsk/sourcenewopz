package com.didi.payment.base.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class ActivityLauncher {

    /* renamed from: a */
    private static final String f29925a = "ActivityLauncher";

    /* renamed from: b */
    private Context f29926b;

    /* renamed from: c */
    private RouterFragmentV4 f29927c;

    /* renamed from: d */
    private RouterFragment f29928d;

    public interface Callback {
        void onActivityResult(int i, Intent intent);
    }

    public static ActivityLauncher init(Fragment fragment) {
        return init(fragment.getActivity());
    }

    public static ActivityLauncher init(FragmentActivity fragmentActivity) {
        return new ActivityLauncher(fragmentActivity);
    }

    public static ActivityLauncher init(Activity activity) {
        return new ActivityLauncher(activity);
    }

    private ActivityLauncher(FragmentActivity fragmentActivity) {
        this.f29926b = fragmentActivity;
        this.f29927c = m20986a(fragmentActivity);
    }

    private ActivityLauncher(Activity activity) {
        this.f29926b = activity;
        this.f29928d = m20985a(activity);
    }

    /* renamed from: a */
    private RouterFragmentV4 m20986a(FragmentActivity fragmentActivity) {
        RouterFragmentV4 b = m20988b(fragmentActivity);
        if (b != null) {
            return b;
        }
        RouterFragmentV4 newInstance = RouterFragmentV4.newInstance();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add((Fragment) newInstance, f29925a).commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return newInstance;
    }

    /* renamed from: b */
    private RouterFragmentV4 m20988b(FragmentActivity fragmentActivity) {
        return (RouterFragmentV4) fragmentActivity.getSupportFragmentManager().findFragmentByTag(f29925a);
    }

    /* renamed from: a */
    private RouterFragment m20985a(Activity activity) {
        RouterFragment b = m20987b(activity);
        if (b != null) {
            return b;
        }
        RouterFragment newInstance = RouterFragment.newInstance();
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(newInstance, f29925a).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return newInstance;
    }

    /* renamed from: b */
    private RouterFragment m20987b(Activity activity) {
        return (RouterFragment) activity.getFragmentManager().findFragmentByTag(f29925a);
    }

    public void startActivityForResult(Class<?> cls, Callback callback) {
        startActivityForResult(new Intent(this.f29926b, cls), callback);
    }

    public void startActivityForResult(Intent intent, Callback callback) {
        RouterFragmentV4 routerFragmentV4 = this.f29927c;
        if (routerFragmentV4 != null) {
            routerFragmentV4.startActivityForResult(intent, callback);
            return;
        }
        RouterFragment routerFragment = this.f29928d;
        if (routerFragment != null) {
            routerFragment.startActivityForResult(intent, callback);
            return;
        }
        throw new RuntimeException("please do init first!");
    }
}
