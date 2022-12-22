package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.conductor.internal.FragmentLifecycleHandler;
import com.didi.app.nova.skeleton.conductor.internal.LifecycleHandler;
import com.didi.app.nova.skeleton.conductor.internal.ThreadUtils;

public final class Conductor {
    private Conductor() {
    }

    public static Router attachRouter(FragmentActivity fragmentActivity, ViewGroup viewGroup, Bundle bundle) {
        ThreadUtils.ensureMainThread();
        Router router2 = LifecycleHandler.install(fragmentActivity).getRouter(viewGroup, bundle);
        router2.rebindIfNeeded();
        return router2;
    }

    public static FragmentLifecycle install(Fragment fragment) {
        ThreadUtils.ensureMainThread();
        return FragmentLifecycleHandler.install(fragment);
    }

    public static Router attachRouter(Fragment fragment, ViewGroup viewGroup, Bundle bundle) {
        ThreadUtils.ensureMainThread();
        Router fragmentRouter = FragmentLifecycleHandler.getFragmentRouter(fragment, viewGroup, bundle);
        fragmentRouter.rebindIfNeeded();
        return fragmentRouter;
    }
}
