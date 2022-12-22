package com.didiglobal.p205sa.biz.component.sapanel.omega;

import android.graphics.Rect;
import android.os.Handler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.omega.PanelOmegaTracker */
public class PanelOmegaTracker {

    /* renamed from: b */
    private static final String f51109b = PanelOmegaTracker.class.toString();

    /* renamed from: a */
    private Logger f51110a = LoggerFactory.getLogger("PanelOmegaTracker");

    /* renamed from: c */
    private Handler f51111c = new Handler();

    /* renamed from: d */
    private final List<SACardProperty> f51112d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e */
    private final List<SACardProperty> f51113e = Collections.synchronizedList(new ArrayList());

    public void setCurrentCardProperties(List<SACardProperty> list) {
        this.f51112d.clear();
        this.f51113e.clear();
        this.f51112d.addAll(list);
        this.f51111c.post(new Runnable() {
            public void run() {
                PanelOmegaTracker.this.m36601a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36601a() {
        try {
            getShowingViesWhenScrollStopped(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void omegaScrollTrack() {
        try {
            getShowingViesWhenScrollStopped(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getShowingViesWhenScrollStopped(boolean z) {
        if (!this.f51112d.isEmpty()) {
            m36604a(this.f51112d, z);
            for (int i = 0; i < this.f51112d.size(); i++) {
                SACardProperty sACardProperty = this.f51112d.get(i);
                if (!(sACardProperty == null || sACardProperty.getView() == null)) {
                    Rect rect = new Rect();
                    sACardProperty.getView().getGlobalVisibleRect(rect);
                    SACardTrackProperty sACardTrackProperty = new SACardTrackProperty();
                    sACardTrackProperty.property = sACardProperty;
                    sACardTrackProperty.f51114id = sACardProperty.getId();
                    if (sACardProperty.getView().getHeight() != 0) {
                        sACardTrackProperty.height = (((float) (rect.bottom - rect.top)) * 1.0f) / ((float) sACardProperty.getView().getHeight());
                    }
                    Logger logger = this.f51110a;
                    logger.info("onViewVisible: cardId: " + sACardProperty.getId() + "cardWidth: " + sACardProperty.getView().getWidth() + "cardHeight: " + sACardProperty.getView().getHeight(), new Object[0]);
                    if (sACardTrackProperty.height > 0.0f && !this.f51113e.contains(sACardProperty)) {
                        this.f51113e.add(sACardProperty);
                        m36603a(sACardTrackProperty, z);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m36603a(SACardTrackProperty sACardTrackProperty, boolean z) {
        SACardProperty sACardProperty = sACardTrackProperty.property;
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_MODULE_ID, sACardTrackProperty.f51114id);
        if (z) {
            hashMap.put("type", Float.valueOf(sACardTrackProperty.height));
        }
        try {
            Map<String, Object> extension = sACardProperty.getExtension();
            if (extension != null) {
                hashMap.putAll(extension);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_act_module_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m36604a(List<SACardProperty> list, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            HashMap hashMap = new HashMap();
            for (SACardProperty next : list) {
                sb.append(next.getId());
                sb.append(",");
                sb2.append(next.getView().getHeight());
                sb2.append(",");
                sb3.append(next.getView().getLocalVisibleRect(new Rect()));
                sb3.append(",");
            }
            hashMap.put(ParamConst.PARAM_MODULE_ID, sb.toString());
            hashMap.put("heights", sb2.toString());
            hashMap.put("visible", sb3.toString());
            hashMap.put("isfirstenter", Boolean.valueOf(z));
            OmegaSDKAdapter.trackEvent("tech_sa_pax_event_xpanel_module_sw", (Map<String, Object>) hashMap);
            String str = f51109b;
            SystemUtils.log(4, str, "omegaAllCardReport: " + hashMap.toString(), (Throwable) null, "com.didiglobal.sa.biz.component.sapanel.omega.PanelOmegaTracker", 159);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
