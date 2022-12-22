package com.didi.drouter.router;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.utils.RouterLogger;
import java.util.WeakHashMap;

public class HolderFragment extends Fragment {

    /* renamed from: a */
    private static final String f19172a = "DRouterEmptyFragment";

    /* renamed from: c */
    private static final WeakHashMap<String, RouterCallback.ActivityCallback> f19173c = new WeakHashMap<>();

    /* renamed from: b */
    private boolean f19174b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f19174b = bundle.getBoolean("attached");
        }
    }

    public static void start(FragmentActivity fragmentActivity, Intent intent, int i, RouterCallback.ActivityCallback activityCallback) {
        HolderFragment holderFragment = new HolderFragment();
        WeakHashMap<String, RouterCallback.ActivityCallback> weakHashMap = f19173c;
        weakHashMap.put(fragmentActivity.hashCode() + "_" + i, activityCallback);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add((Fragment) holderFragment, f19172a);
        beginTransaction.commit();
        RouterLogger.getCoreLogger().mo59000d("ActivityResult HoldFragment commit attach", new Object[0]);
        supportFragmentManager.executePendingTransactions();
        if (Build.VERSION.SDK_INT >= 16) {
            holderFragment.startActivityForResult(intent, i, intent.getBundleExtra(Extend.START_ACTIVITY_OPTIONS));
        } else {
            holderFragment.startActivityForResult(intent, i);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = getActivity().hashCode() + "_" + i;
        RouterCallback.ActivityCallback activityCallback = f19173c.get(str);
        if (activityCallback != null) {
            RouterLogger.getCoreLogger().mo59000d("ActivityResult callback", new Object[0]);
            activityCallback.onActivityResult(i2, intent);
            f19173c.remove(str);
            return;
        }
        RouterLogger.getCoreLogger().mo59000d("ActivityResult callback fail for host activity destroyed", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        if (this.f19174b) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commit();
            this.f19174b = false;
            RouterLogger.getCoreLogger().mo59000d("ActivityResult HoldFragment commit remove", new Object[0]);
        }
        this.f19174b = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("attached", this.f19174b);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
