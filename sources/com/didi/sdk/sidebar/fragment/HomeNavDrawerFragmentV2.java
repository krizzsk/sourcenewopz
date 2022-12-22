package com.didi.sdk.sidebar.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.EventKeys;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class HomeNavDrawerFragmentV2 extends HomeNavDrawerFragment {
    /* access modifiers changed from: protected */
    public int getRootLayoutId() {
        return R.layout.new_slide_bar_view_stub;
    }

    /* access modifiers changed from: protected */
    public void fixBarrierFree(View view) {
        super.fixBarrierFree(view);
        View findViewById = view.findViewById(R.id.drawerBack);
        if (!(view.getWidth() == 0 || findViewById == null || findViewById.getLayoutParams() == null)) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = UIUtils.getScreenWidth(getContext()) - view.getWidth();
            findViewById.setLayoutParams(layoutParams);
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
            }
        });
    }
}
