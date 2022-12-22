package com.didi.sdk.push;

import android.content.Context;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.log.AvailableRateLogEvent;
import com.didi.sdk.push.log.ConnEvent;
import com.didi.sdk.push.log.ConnEventV2;
import com.didi.sdk.push.log.ExtendConnEvent;
import com.didi.sdk.push.log.LoadErrorEvent;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.MsgAckLogEvent;
import com.didi.sdk.push.log.MsgFluxLogEvent;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.log.PushQualityLogEvent;
import com.didi.sdk.push.log.TransactionEvent;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.Map;

public class BaseLogEventHandler extends LogEventAdapter {
    private static final String NET_CHANGE_TAG = "net_status_change";
    private static final String TAG = "push-debug";
    private final Logger logger = LoggerFactory.getLogger("pushSdk", "didiPush");

    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
        Map<String, Object> map = loadErrorEvent.toMap();
        if (map != null) {
            EventTracker.getInstance().trackEvent("push_selector_error", map);
        }
    }

    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
        Map<String, Object> map = networkChangeEvent.toMap();
        if (map != null) {
            this.logger.infoEvent("push-debug", (Map<?, ?>) map);
            EventTracker.getInstance().trackEvent(NET_CHANGE_TAG, map);
        }
    }

    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
        Logger logger2 = this.logger;
        logger2.info("push-debug||native log||" + nativeLogEvent.getMsg(), new Object[0]);
    }

    public void onTrackTransaction(TransactionEvent transactionEvent) {
        Map<String, Object> map = transactionEvent.toMap();
        if (map != null) {
            map.put("puship", PushClient.getClient().getConnectIp());
            map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
            map.put("ver", PushSelector.getDefault().getPushVer());
            OmegaSDK.trackSocketTransactionEvent(map);
        }
    }

    public void onTrackConnection(ConnEvent connEvent) {
        Map<String, Object> map = connEvent.toMap();
        if (map == null) {
            return;
        }
        if (connEvent instanceof ExtendConnEvent) {
            map.put("puship", PushClient.getClient().getConnectIp());
            map.put("ver", PushSelector.getDefault().getPushVer());
            OmegaSDK.trackSocketConnectionEvent(map);
            return;
        }
        PushOption option = PushClient.getClient().getOption();
        map.put("puship", PushClient.getClient().getConnectIp());
        map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
        map.put("pushver", PushSelector.getDefault().getPushVer());
        map.put("tls", Integer.valueOf(PushSelector.getDefault().isTLSOpen() ? 2 : 1));
        map.put("net", Integer.valueOf(calculateNetworkId(option.getContext())));
        EventTracker.getInstance().trackEvent("socket_conn_callback", map);
    }

    public void onTrackConnectionV2(ConnEventV2 connEventV2) {
        Map<String, Object> map = connEventV2.toMap();
        if (map != null) {
            map.put("pushver", PushSelector.getDefault().getPushVer());
            EventTracker.getInstance().trackEvent("push_multiple_con_stat", map);
        }
    }

    public void onTrackAvailableRateEvent(AvailableRateLogEvent availableRateLogEvent) {
        Map<String, Object> map = availableRateLogEvent.toMap();
        if (map != null) {
            map.put("puship", PushClient.getClient().getConnectIp());
            map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
            map.put("pushver", PushSelector.getDefault().getPushVer());
            EventTracker.getInstance().trackEvent("push_summary", map);
        }
    }

    public void onTrackMsgAckEvent(MsgAckLogEvent msgAckLogEvent) {
        Map<String, Object> map = msgAckLogEvent.toMap();
        PushOption option = PushClient.getClient().getOption();
        if (option != null) {
            map.put("carrier", Utils.getMobileOperator(option.getContext()));
            map.put("net_type", Utils.getNetworkTypeName(option.getContext()));
        }
        map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
        map.put("pushver", PushSelector.getDefault().getPushVer());
        EventTracker.getInstance().trackEvent("push_msg_ack_duration_stat", map);
    }

    public void onTrackMsgFluxEvent(MsgFluxLogEvent msgFluxLogEvent) {
        if (Apollo.getToggle("isReportPushFlux").allow()) {
            Map<String, Object> map = msgFluxLogEvent.toMap();
            map.put("puship", PushClient.getClient().getConnectIp());
            map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
            map.put("pushver", PushSelector.getDefault().getPushVer());
            EventTracker.getInstance().trackEvent("push_message_flux", map);
        }
    }

    public void onTrackPushQualityEvent(PushQualityLogEvent pushQualityLogEvent) {
        Map<String, Object> map = pushQualityLogEvent.toMap();
        PushOption option = PushClient.getClient().getOption();
        if (option != null) {
            map.put("carrier", Utils.getMobileOperator(option.getContext()));
            map.put("net_type", Utils.getNetworkTypeName(option.getContext()));
        }
        map.put("pushport", Integer.valueOf(PushClient.getClient().getConnectPort()));
        map.put("pushver", PushSelector.getDefault().getPushVer());
        EventTracker.getInstance().trackEvent("push_quality_stat", map);
    }

    private static int calculateNetworkId(Context context) {
        try {
            int networkType = Utils.getNetworkType(context);
            if (networkType == 0) {
                return 0;
            }
            return networkType == 1 ? 2 : 1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
