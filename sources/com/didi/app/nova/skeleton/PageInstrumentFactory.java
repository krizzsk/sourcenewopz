package com.didi.app.nova.skeleton;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.conductor.Conductor;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl;

public final class PageInstrumentFactory {
    public static PageInstrument install(FragmentActivity fragmentActivity, ViewGroup viewGroup, Bundle bundle) {
        return create(Conductor.attachRouter(fragmentActivity, viewGroup, bundle));
    }

    public static FragmentLifecycle install(Fragment fragment) {
        return Conductor.install(fragment);
    }

    public static PageInstrument create(Fragment fragment, ViewGroup viewGroup, Bundle bundle) {
        return create(Conductor.attachRouter(fragment, viewGroup, bundle));
    }

    public static PageInstrument create(Router router2) {
        return new PageInstrumentImpl(router2);
    }
}
