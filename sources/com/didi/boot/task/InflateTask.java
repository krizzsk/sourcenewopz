package com.didi.boot.task;

import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;

public class InflateTask implements Runnable {
    public static String NAME = InflateTask.class.getName();

    public InflateTask() {
        AsyncLayoutFactory.getInstance().init(DIDIApplicationDelegate.getAppContext());
    }

    public void run() {
        SystemUtils.log(3, "task", "start to inflate", (Throwable) null, "com.didi.boot.task.InflateTask", 25);
        AsyncLayoutFactory.getInstance().inflateAsync(R.layout.f_new_titlebar, (ViewGroup) null);
        AsyncLayoutFactory.getInstance().inflateAsync(R.layout.new_ui_f_biz_bar, (ViewGroup) null);
        AsyncLayoutFactory.getInstance().inflateAsync(R.layout.oc_x_panel_view, (ViewGroup) null);
        AsyncLayoutFactory.getInstance().inflateAsync(R.layout.global_home_destination_view_layout_new_ui_plan_b, (ViewGroup) null);
        IToggle toggle = Apollo.getToggle("global_app_apm_async_inflate_v2");
        if (toggle.allow()) {
            SystemUtils.log(3, "task", "start to inflate v2", (Throwable) null, "com.didi.boot.task.InflateTask", 36);
            AsyncLayoutFactory.getInstance().inflateAsync(R.layout.sf_safe_toolkit_entrance, (ViewGroup) null);
            int intValue = ((Integer) toggle.getExperiment().getParam("delay", 10000)).intValue();
            if (intValue > 0) {
                ApmThreadPool.postDelayOnUiThread(new Runnable() {
                    public void run() {
                        SystemUtils.log(3, "task", "start to delay inflate v2", (Throwable) null, "com.didi.boot.task.InflateTask$1", 44);
                        AsyncLayoutFactory.getInstance().inflateAsync(R.layout.global_comfirm_broading_point_layout, (ViewGroup) null);
                    }
                }, intValue);
            }
        }
    }
}
