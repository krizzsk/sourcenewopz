package com.didi.beatles.p099im.omega;

import android.text.TextUtils;
import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.omega.OmegaUtil */
public class OmegaUtil {
    public static final String TAG = "OmegaUtil";
    public static final boolean isTrack = true;

    public static void trackIMEvent(String str, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, "", map);
    }

    public static void trackCustomWordOmega(String str, Map<String, Object> map) {
        if (map == null) {
            new HashMap();
        }
    }

    public static void trackFloatWindowOmega(String str, IMMessage iMMessage) {
        if (iMMessage != null) {
            trackFloatWindowOmega(str, iMMessage, new HashMap());
        }
    }

    public static void trackFloatWindowOmega(String str, IMMessage iMMessage, Map<String, Object> map) {
        if (iMMessage != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(iMMessage.getBusinessId()));
            map.put("sids", Long.valueOf(iMMessage.getSid()));
            map.put("app", IMContextInfoHelper.getContext().getPackageName());
            trackIMEvent(str, map);
        }
    }

    public static void trackSendMsgOmega(int i, long j, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(i));
        hashMap.put("sids", Long.valueOf(j));
        hashMap.put("app", IMContextInfoHelper.getContext().getPackageName());
        hashMap.put("msg_from", Integer.valueOf(i2));
        trackIMEvent("ddim_msg_all_note_sw", hashMap);
    }

    public static void trackOperationOmega(int i, IMMessage iMMessage) {
        if (iMMessage != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, Integer.valueOf(i));
            hashMap.put("dialogue_type", Integer.valueOf(iMMessage.getSidType()));
            hashMap.put("dialogue_id", Long.valueOf(iMMessage.getSid()));
            if (iMMessage.getMessageExtendInfo() != null) {
                hashMap.put("activity_id", Long.valueOf(iMMessage.getMessageExtendInfo().activity_id));
            } else {
                hashMap.put("activity_id", 0);
            }
            hashMap.put("business_id", Integer.valueOf(iMMessage.getBusinessId()));
            trackIMEvent("tone_p_x_dlgpage_struct_ck", hashMap);
            IMLog.m6631d(TAG, "[trackOperationOmega] uniq_msg_id:" + iMMessage.getCloudUniqueMsgId());
            IMTraceUtil.addBusinessEvent("ddim_service_item_content_ck").add("product_id", Integer.valueOf(iMMessage.getBusinessId())).add("no_appid", Long.valueOf(iMMessage.getSenderUid())).add("send_uid", Long.valueOf(iMMessage.getSenderUid())).add("batchid", iMMessage.batcheid).add("uniq_msg_id", iMMessage.getCloudUniqueMsgId()).add("activity_id", Long.valueOf(iMMessage.getMessageExtendInfo() == null ? 0 : iMMessage.getActivityId())).report();
        }
    }

    public static void trackPushMsgOmega(String str, IMMessage iMMessage) {
        if (iMMessage != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.MessagePayloadKeys.MSGID_SERVER, Long.valueOf(iMMessage.getMid()));
            hashMap.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, Integer.valueOf(iMMessage.getType()));
            if (iMMessage.getMessageExtendInfo() != null) {
                hashMap.put("activity_id", Long.valueOf(iMMessage.getMessageExtendInfo().activity_id));
            } else {
                hashMap.put("activity_id", 0);
            }
            hashMap.put("business_id", Integer.valueOf(iMMessage.getBusinessId()));
            trackIMEvent(str, hashMap);
        }
    }

    public static void trackMsgCenterOmega(int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialogue_type", Integer.valueOf(i));
        hashMap.put("dialogue_id", Long.valueOf(j));
        trackIMEvent("tone_p_x_msgcenter_portal_ck", hashMap);
    }

    public static void trackOperationOmegaNew(IMMessage iMMessage) {
        if (iMMessage != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("activityid", iMMessage.getMessageExtendInfo() != null ? Long.valueOf(iMMessage.getMessageExtendInfo().activity_id) : "");
            hashMap.put("batchid", iMMessage.batcheid + "");
            OmegaSDKAdapter.trackEvent("ddim_msg_all_detail_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackExtendMsg(String str, IMMessage iMMessage, Map<String, Object> map) {
        if (iMMessage != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            int i = 1;
            if (!map.containsKey("ostype")) {
                map.put("ostype", 1);
            }
            map.put("activityid", iMMessage.getMessageExtendInfo() == null ? "" : Long.valueOf(iMMessage.getMessageExtendInfo().activity_id));
            map.put("buttonnum", Integer.valueOf(iMMessage.btns != null ? iMMessage.btns.size() : 0));
            map.put("batchid", iMMessage.batcheid);
            if (iMMessage.getSidType() != 4) {
                i = 2;
            }
            map.put("apptype", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent(str, map);
        }
    }

    public static void trackXiaoMiClick(IMMessage iMMessage, long j) {
        if (iMMessage != null) {
            HashMap hashMap = new HashMap();
            int i = 2;
            hashMap.put("ostype", 2);
            hashMap.put("activityid", Long.valueOf(j));
            hashMap.put("buttonnum", Integer.valueOf(iMMessage.btns != null ? iMMessage.btns.size() : 0));
            hashMap.put("batchid", iMMessage.batcheid);
            if (iMMessage.getSidType() == 4) {
                i = 1;
            }
            hashMap.put("apptype", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent("ddim_msg_all_open_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackTitleNamePath(String str, IMSession iMSession, int i) {
        IMTraceUtil.BusinessParam addBusinessEvent;
        if (iMSession != null && iMSession.getType() == 1 && (addBusinessEvent = IMTraceUtil.addBusinessEvent("ddim_beat_p_im_pos_sw")) != null) {
            if (!TextUtils.isEmpty(str)) {
                addBusinessEvent.add("im_text", str);
            } else {
                addBusinessEvent.add("im_text", iMSession.getSessionName() == null ? "" : iMSession.getSessionName());
            }
            if (iMSession.getPeerUser() != null) {
                addBusinessEvent.add("uid", Long.valueOf(iMSession.getPeerUser().getUid()));
            }
            addBusinessEvent.add("text_source", Integer.valueOf(i));
            addBusinessEvent.add("event_time", Long.valueOf(System.currentTimeMillis()));
            addBusinessEvent.report();
        }
    }
}
