package com.didi.dimina.container.p106ui.launchview;

import android.content.Context;
import android.view.LayoutInflater;
import com.didi.dimina.container.DMMina;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.launchview.DMDefaultLaunchView */
public class DMDefaultLaunchView extends DMBaseLaunchView {
    public DMDefaultLaunchView(Context context, DMMina dMMina) {
        super(context, dMMina);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_default_launch_view, this, true);
    }
}
