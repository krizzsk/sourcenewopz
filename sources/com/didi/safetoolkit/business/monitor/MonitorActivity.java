package com.didi.safetoolkit.business.monitor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.imageloader.SfImageLoaderHolder;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfListenerManager;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class MonitorActivity extends BaseActivityWithUIStuff {
    public static final String MONITOR_STATE = "monitor_state";

    /* renamed from: a */
    private View f34398a;

    /* renamed from: b */
    private TextView f34399b;

    /* renamed from: c */
    private ImageView f34400c;

    /* renamed from: d */
    private TextView f34401d;

    /* renamed from: e */
    private TextView f34402e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f34403f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ISMonitorDetailsService f34404g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfViewMonitorMenuModel f34405h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f34406i;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_common_dialog_monitor_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34398a = findViewById(R.id.iv_monitor_back);
        this.f34399b = (TextView) findViewById(R.id.sf_monitor_title);
        this.f34400c = (ImageView) findViewById(R.id.sf_monitor_img);
        this.f34401d = (TextView) findViewById(R.id.sf_monitor_content);
        this.f34402e = (TextView) findViewById(R.id.sf_monitor_bottom_tv);
        this.f34403f = (Switch) findViewById(R.id.sf_monitor_switch);
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f34404g = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        this.f34405h = (SfViewMonitorMenuModel) getIntent().getSerializableExtra(MONITOR_STATE);
        SfListenerManager.setMonitorUpdateListener(new SfListenerManager.MonitorDataUpdateListener() {
            public void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
                MonitorActivity.this.m24323a(sfViewMonitorMenuModel);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initData() {
        m24323a(this.f34405h);
        if (this.f34405h != null) {
            SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_view_sw");
            addEventId.addKeyValue("type", Integer.valueOf(this.f34405h.isMonitoring ? 2 : 1));
            if (this.f34405h.driverData != null) {
                addEventId.addKeyValue("order_id", this.f34405h.driverData.orderId);
                addEventId.addKeyValue("trip_id", this.f34405h.driverData.tripId);
            }
            addEventId.report();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f34398a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MonitorActivity.this.onBackPressed();
            }
        });
        this.f34403f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                if (MonitorActivity.this.f34404g != null && compoundButton.isPressed()) {
                    MonitorActivity.this.m24324a(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24323a(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        if (sfViewMonitorMenuModel != null) {
            this.f34406i = sfViewMonitorMenuModel.canMonitor;
            this.f34399b.setText(sfViewMonitorMenuModel.pageTitle);
            this.f34402e.setText(sfViewMonitorMenuModel.monitorStateText);
            this.f34401d.setText(sfViewMonitorMenuModel.monitorDesc);
            this.f34403f.setChecked(sfViewMonitorMenuModel.canMonitor);
            SfImageLoaderHolder.getInstance(this).loadInto(sfViewMonitorMenuModel.imgUrl, this.f34400c, SfAppUtils.isBrazilPackage(this) ? R.drawable.sf_center_place_holder_4_99 : R.drawable.sf_center_place_holder);
            if (!(sfViewMonitorMenuModel.driverData == null || -1 == sfViewMonitorMenuModel.driverData.thumbId)) {
                this.f34403f.setThumbResource(sfViewMonitorMenuModel.driverData.thumbId);
            }
            if (sfViewMonitorMenuModel.driverData != null && -1 != sfViewMonitorMenuModel.driverData.trackId) {
                this.f34403f.setTrackResource(sfViewMonitorMenuModel.driverData.trackId);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24324a(final boolean z) {
        this.f34404g.reportMonitorState(this, 1, z ? 1 : 2, new ISMonitorCallback() {
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("errno") != 0) {
                        MonitorActivity.this.f34403f.setChecked(MonitorActivity.this.f34406i);
                        ToastHelper.showShortInfo(MonitorActivity.this.getContext(), jSONObject.getString("errmsg"));
                        return;
                    }
                    boolean unused = MonitorActivity.this.f34406i = z;
                    MonitorActivity.this.f34404g.refreshBubbleInfo(new MonitorConfigCallback(MonitorActivity.this));
                    SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_notification_change");
                    addEventId.addKeyValue("status", MonitorActivity.this.f34406i ? "open" : "close");
                    if (MonitorActivity.this.f34405h.driverData != null) {
                        addEventId.addKeyValue("order_id", MonitorActivity.this.f34405h.driverData.orderId);
                        addEventId.addKeyValue("trip_id", MonitorActivity.this.f34405h.driverData.tripId);
                    }
                    addEventId.report();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailed(Exception exc) {
                MonitorActivity.this.f34403f.setChecked(MonitorActivity.this.f34406i);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SfListenerManager.removeMonitorUpdateListener();
    }

    private static class MonitorConfigCallback implements ISMonitorConfigCallback {
        private MonitorActivity mActivity;
        private WeakReference<MonitorActivity> mReference;

        MonitorConfigCallback(MonitorActivity monitorActivity) {
            this.mReference = new WeakReference<>(monitorActivity);
        }

        public void onSuccess(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
            MonitorActivity monitorActivity = (MonitorActivity) this.mReference.get();
            this.mActivity = monitorActivity;
            if (monitorActivity != null) {
                monitorActivity.m24323a(sfViewMonitorMenuModel);
            }
        }

        public void onFailed(String str) {
            MonitorActivity monitorActivity = this.mActivity;
            if (monitorActivity != null) {
                ToastHelper.showShortInfo((Context) monitorActivity, str);
            }
        }
    }
}
