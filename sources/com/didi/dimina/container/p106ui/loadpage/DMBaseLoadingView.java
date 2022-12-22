package com.didi.dimina.container.p106ui.loadpage;

import android.content.Context;
import android.widget.FrameLayout;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.page.DMPage;
import java.io.Serializable;

/* renamed from: com.didi.dimina.container.ui.loadpage.DMBaseLoadingView */
public abstract class DMBaseLoadingView extends FrameLayout implements Serializable {
    private void init() {
    }

    public DMBaseLoadingView(Context context, DMMina dMMina, DMPage dMPage) {
        super(context);
        init();
    }
}
