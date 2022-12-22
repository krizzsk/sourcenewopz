package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.request.model.CallList;
import com.didichuxing.comp.telecom.core.request.model.CallListModel;
import com.didichuxing.comp.telecom.core.request.model.CallMethodItem;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J.\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u001a\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\u001b\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J@\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\r2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!`\"2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006#"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/SimpleCallEventTickHandler;", "Lcom/didichuxing/comp/telecom/core/CallManagerAssist$CallEventTickHandler;", "()V", "onCallListItemClick", "", "itemModel", "Lcom/didichuxing/comp/telecom/core/request/model/CallMethodItem;", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "onCallListShow", "Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;", "onCallPageBtnClick", "action", "", "pageState", "role", "onCallPageShow", "onCollapseClick", "onFloatWindowClick", "onFloatWindowShow", "onRequestAudioResult", "isGranted", "", "onRequestAudioShow", "onRequestFloatWindowClick", "yes", "onRequestFloatWindowShow", "onToastShow", "content", "tickEventWithCommonParams", "eventId", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: SimpleEventTickHandler.kt */
public final class SimpleCallEventTickHandler implements CallManagerAssist.CallEventTickHandler {
    public void onCallListShow(CallListModel callListModel) {
        boolean z;
        CallList callList;
        List<CallMethodItem> items;
        HashMap hashMap = new HashMap();
        String str = null;
        boolean z2 = false;
        if (callListModel == null || (callList = callListModel.getCallList()) == null || (items = callList.getItems()) == null) {
            z = false;
        } else {
            z = false;
            for (CallMethodItem callMethodItem : items) {
                Integer type = callMethodItem.getType();
                if (type != null && type.intValue() == 2) {
                    z2 = true;
                } else if (type != null && type.intValue() == 1) {
                    str = !callMethodItem.isEnable() ? callMethodItem.getReason() : null;
                    z = true;
                }
            }
        }
        Map map = hashMap;
        map.put("style", (!z2 || !z) ? z2 ? "Cellular" : "Free" : "Cellular_Free");
        if (str != null) {
            map.put("reason", str);
        }
        m33297a("ibt_choose_callmode_sw", hashMap, callListModel);
    }

    public void onCallListItemClick(CallMethodItem callMethodItem, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Integer type = callMethodItem != null ? callMethodItem.getType() : null;
        if (type != null && type.intValue() == 1) {
            hashMap.put("type", "Free");
        } else if (type != null && type.intValue() == 2) {
            hashMap.put("type", "Cellular");
        }
        m33297a("ibt_choose_callmode_btn_ck", hashMap, voipCallModel);
    }

    public void onCallPageShow(String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33297a("ibt_call_page_sw", hashMap, voipCallModel);
    }

    public void onCallPageBtnClick(String str, String str2, String str3, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str == null) {
            str = "";
        }
        map.put("type", str);
        if (str3 == null) {
            str3 = "";
        }
        map.put("style", str3);
        if (str2 == null) {
            str2 = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str2);
        m33297a("ibt_call_page_btn_ck", hashMap, voipCallModel);
    }

    public void onRequestAudioShow() {
        m33296a(this, "ibt_micro_permit_sw", new HashMap(), (VoipCallModel) null, 4, (Object) null);
    }

    public void onRequestAudioResult(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z ? "Confirm" : "Reject");
        m33296a(this, "ibt_micro_permit_btn_ck", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    public void onToastShow(String str, String str2, String str3, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str3 == null) {
            str3 = "";
        }
        map.put("content", str3);
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33297a("ibt_call_toast_sw", hashMap, voipCallModel);
    }

    public void onCollapseClick(String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33296a(this, "ibt_call_float_foldup_btn_ck", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    public void onRequestFloatWindowShow(String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33296a(this, "ibt_micro_uplayer_sw", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    public void onRequestFloatWindowClick(boolean z, String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("type", z ? "Confirm" : "Reject");
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33296a(this, "ibt_micro_uplayer_permit_btn_ck", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    public void onFloatWindowShow(String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33296a(this, "ibt_call_float_sw", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    public void onFloatWindowClick(String str, String str2, VoipCallModel voipCallModel) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        if (str2 == null) {
            str2 = "";
        }
        map.put("style", str2);
        if (str == null) {
            str = "";
        }
        map.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        m33296a(this, "ibt_call_float_ck", hashMap, (VoipCallModel) null, 4, (Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m33296a(SimpleCallEventTickHandler simpleCallEventTickHandler, String str, HashMap hashMap, VoipCallModel voipCallModel, int i, Object obj) {
        if ((i & 4) != 0) {
            voipCallModel = null;
        }
        simpleCallEventTickHandler.m33297a(str, hashMap, voipCallModel);
    }

    /* renamed from: a */
    private final void m33297a(String str, HashMap<String, Object> hashMap, VoipCallModel voipCallModel) {
        CallManagerAssist.AppServiceProvider appServiceProvider;
        String roomId;
        if (voipCallModel != null) {
            Map map = hashMap;
            String voipSessionId = voipCallModel.getVoipSessionId();
            String str2 = "";
            if (voipSessionId == null) {
                voipSessionId = str2;
            }
            map.put("voip_session_id", voipSessionId);
            RoomInfo roomInfo = voipCallModel.getRoomInfo();
            if (!(roomInfo == null || (roomId = roomInfo.getRoomId()) == null)) {
                str2 = roomId;
            }
            map.put("room_id", str2);
        }
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config != null && (appServiceProvider = config.getAppServiceProvider()) != null) {
            appServiceProvider.tickEvent(str, hashMap);
        }
    }
}
