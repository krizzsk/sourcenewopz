package com.didiglobal.p205sa.biz.component.activity.omega;

import com.didi.raven.config.RavenKey;
import com.didi.sdk.monitor.SaQualityCheckTrack;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityViewType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.activity.omega.ActivityOmegaTracker */
public class ActivityOmegaTracker {

    /* renamed from: a */
    private static List<ActivityProperty> f50741a = new ArrayList();

    /* renamed from: com.didiglobal.sa.biz.component.activity.omega.ActivityOmegaTracker$DataType */
    public @interface DataType {
        public static final int EMPTY_DATA = 0;
        public static final int FILL_DATA = 1;
    }

    public static void omegaCardShow(ActivityProperty activityProperty) {
        if (activityProperty != null && !f50741a.contains(activityProperty)) {
            f50741a.add(activityProperty);
            HashMap hashMap = new HashMap();
            String str = "ibt_gp_sa_activity_unit_tittle_sw";
            if (!ActivityViewType.ongoing_title.getTypeId().equals(activityProperty.getTypeId())) {
                if (!ActivityViewType.ongoing_card.getTypeId().equals(activityProperty.getTypeId())) {
                    if (!ActivityViewType.recently_title.getTypeId().equals(activityProperty.getTypeId())) {
                        if (!ActivityViewType.recently_card.getTypeId().equals(activityProperty.getTypeId()) && !ActivityViewType.recently_card_last.getTypeId().equals(activityProperty.getTypeId())) {
                            str = ActivityViewType.ongoing_more_card.getTypeId().equals(activityProperty.getTypeId()) ? "ibt_gp_sa_activity_view_all_sw" : "";
                        }
                    }
                }
                str = "ibt_gp_sa_activity_card_sw";
            }
            if (!(activityProperty.getModel() == null || activityProperty.getModel().getLog_data() == null)) {
                hashMap.putAll(activityProperty.getModel().getLog_data());
            }
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
            if (activityProperty.getModel() != null && !CollectionUtil.isEmpty((Collection<?>) activityProperty.getModel().getButtons())) {
                HashMap hashMap2 = new HashMap();
                if (activityProperty.getModel().getButtons().get(0).getLog_data() != null) {
                    hashMap2.putAll(activityProperty.getModel().getButtons().get(0).getLog_data());
                }
                OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_btn_sw", (Map<String, Object>) hashMap2);
            }
        }
    }

    public static void clear() {
        f50741a.clear();
    }

    public static void OmegaActivityVisible(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("style", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_page_sw", (Map<String, Object>) hashMap);
    }

    public static void OmegaActivityShowTime(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(j));
        hashMap.put("style", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_page_time_sw", (Map<String, Object>) hashMap);
    }

    public static void OmegaActivitySlide(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_page_sd", (Map<String, Object>) hashMap);
    }

    public static void OmegaCardClick(ActivityCardModel activityCardModel) {
        HashMap hashMap = new HashMap();
        if (activityCardModel.getLog_data() != null) {
            hashMap.putAll(activityCardModel.getLog_data());
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_card_ck", (Map<String, Object>) hashMap);
    }

    public static void OmegaCardBtnClick(ActivityCardModel activityCardModel, ActivityCardModel.ButtonsBean buttonsBean) {
        HashMap hashMap = new HashMap();
        if (buttonsBean != null) {
            hashMap.putAll(buttonsBean.getLog_data());
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_btn_ck", (Map<String, Object>) hashMap);
    }

    public static void OmegaHistoryClick() {
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_history_ck");
    }

    public static void OmegaActivityNoData(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("style", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_pagenull_sw", (Map<String, Object>) hashMap);
    }

    public static void OmegaViewMoreClick() {
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_activity_view_all_ck");
    }

    public static void OmegaError(int i) {
        SaQualityCheckTrack.trackError("sa_activity", i, new HashMap());
    }

    public static void OmegaSATime(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("nettime", Long.valueOf(j));
        SaQualityCheckTrack.trackError("sa_home_net_time", 10, hashMap);
    }
}
