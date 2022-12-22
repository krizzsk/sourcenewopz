package com.didi.sdk.monitor;

import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didichuxing.omega.sdk.analysis.TrackListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import didihttpdns.statics.HttpDnsStatics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OmegaTrackLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static List<String> f36844a = new ArrayList(Arrays.asList(new String[]{"not_use_httpdns_detail", "map_locsdk_global_general_result_sw", "apollo_log", "OMGUI", "OMGODAT", "omg_np", "http_api_stat", "http_api_user_reqs", "tech_bff_error", "locsdk_ntp_sync", "http_api_err_diag", HttpDnsStatics.ID_HTTP_DNS_RESP_EXCEPTION, "ibt_gp_safetyicon_view_sw", "socket_conn_callback", "startPushSetOptions", "push_dns_stats", "locsdk_ntp_cache", "locsdk_ntp_timediff", "push_quality_stat", "push_multiple_con_stat", "locsdk_get_sim_cgi"}));

    public static void initOmegaTrackLog() {
        if (GlobalApolloUtils.getStatus("global_passenger_log_hook")) {
            AutoTrackHelper.setEnable(true);
            Tracker.addTrackListener(new TrackListener() {
                public void afterTrackEvent(Event event) {
                    if (event != null && ConfProxy.getInstance().getSelectedType() != "soda" && !OmegaTrackLog.f36844a.contains(event.getEventId())) {
                        LoggerFactory.getLogger("GlobalTrack").info(event.getEventId(), (Map<?, ?>) event.getAllAttrs());
                    }
                }
            });
        }
        if (DebugUtils.isDebug()) {
            f36844a.remove("omg_np");
            f36844a.remove("OMGUI");
            com.didichuxing.mas.sdk.quality.report.analysis.Tracker.addTrackListener(new com.didichuxing.mas.sdk.quality.report.analysis.TrackListener() {
                public void afterTrackEvent(com.didichuxing.mas.sdk.quality.report.record.Event event) {
                    LoggerFactory.getLogger("GlobalTrack").info(event.getEventId(), (Map<?, ?>) event.getAllAttrs());
                }
            });
        }
    }
}
