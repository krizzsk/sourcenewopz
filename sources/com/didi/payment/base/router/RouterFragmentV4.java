package com.didi.payment.base.router;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import com.didi.payment.base.router.ActivityLauncher;
import java.util.Random;

public class RouterFragmentV4 extends Fragment {

    /* renamed from: a */
    private SparseArray<ActivityLauncher.Callback> f29931a = new SparseArray<>();

    /* renamed from: b */
    private Random f29932b = new Random();

    public static RouterFragmentV4 newInstance() {
        return new RouterFragmentV4();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, ActivityLauncher.Callback callback) {
        int a = m20990a();
        this.f29931a.put(a, callback);
        startActivityForResult(intent, a);
    }

    /* renamed from: a */
    private int m20990a() {
        int nextInt;
        int i = 0;
        do {
            nextInt = this.f29932b.nextInt(65535);
            i++;
            if (this.f29931a.indexOfKey(nextInt) < 0 || i >= 10) {
                return nextInt;
            }
            nextInt = this.f29932b.nextInt(65535);
            i++;
            break;
        } while (i >= 10);
        return nextInt;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ActivityLauncher.Callback callback = this.f29931a.get(i);
        this.f29931a.remove(i);
        if (callback != null) {
            callback.onActivityResult(i2, intent);
        }
    }
}
