package com.didi.map.global.component.departure.manager;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.view.DepartureCardViewController;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.push.ServerParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import java.util.HashMap;

public class DepartureOmegaManager {

    /* renamed from: a */
    private FenceInfo f25158a;

    /* renamed from: b */
    private String f25159b;

    /* renamed from: c */
    private String f25160c;

    /* renamed from: d */
    private String f25161d;

    /* renamed from: e */
    private float f25162e = 0.0f;

    /* renamed from: f */
    private RpcPoi f25163f;

    public interface OmegaChangePickupPointType {
        public static final int MAP_DRAGG = 1;
        public static final int REC_MARKER_CLICK = 2;
        public static final int TERMINAL_LIST_ITEM_SELECTED = 3;
    }

    public void setDefaultRecTerminalPickupPoi(RpcPoi rpcPoi) {
        this.f25159b = (rpcPoi == null || rpcPoi.base_info == null) ? "" : rpcPoi.base_info.poi_id;
        this.f25163f = rpcPoi;
    }

    public void setPickupPoiDescription(String str) {
        this.f25161d = str;
    }

    public void setSelectedTerminalSPoi(SPoi sPoi) {
        if (sPoi != null && sPoi.area != null) {
            this.f25160c = sPoi.area.f25199id;
        }
    }

    public void setLocationAccuracy(float f) {
        this.f25162e = f;
    }

    public void reportOmegaOnShowTerminalWelcome(DepartureCardViewController departureCardViewController, FenceInfo fenceInfo, boolean z) {
        this.f25158a = fenceInfo;
        if (departureCardViewController != null && fenceInfo != null && departureCardViewController.isWelcomeViewValid()) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", fenceInfo.fenceId);
            hashMap.put("type", Integer.valueOf(z ? 1 : 2));
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_card_sw", hashMap);
        }
    }

    public void reportOmegaOnWelcomeButtonClick() {
        if (this.f25158a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f25158a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_setpickup_ck", hashMap);
        }
    }

    public void reportOmegaOnOtherAreaClick() {
        if (this.f25158a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f25158a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_other_ck", hashMap);
            return;
        }
        m18053a(" reportOmegaOnOtherAreaClick fence is null.");
    }

    public void reportOmegaOnTerminalConfirmButtonClick(RpcPoi rpcPoi) {
        if (rpcPoi == null || this.f25158a == null) {
            m18053a(" reportOmegaOnOtherAreaClick fence is null or rpcPoi is null,rpcPoi=" + rpcPoi);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pudoptid", this.f25159b);
        hashMap.put("pudofinalptid", rpcPoi.base_info != null ? rpcPoi.base_info.poi_id : "");
        hashMap.put("pudozoneid", this.f25158a.fenceId);
        hashMap.put("pudosubdivisionid", this.f25160c);
        hashMap.put(ServerParam.PARAM_ACCURACY, Float.valueOf(this.f25162e));
        hashMap.put("message", this.f25161d);
        GlobalOmegaTracker.trackEvent("ibt_gp_pudoptpanel_setpickup_ck", hashMap);
    }

    public void reportOmegaOnTerminalRecPickupChange(RpcPoi rpcPoi, int i) {
        if (rpcPoi != null && !m18054a(rpcPoi, this.f25163f)) {
            RpcPoi rpcPoi2 = this.f25163f;
            String str = "";
            String str2 = (rpcPoi2 == null || rpcPoi2.base_info == null) ? str : this.f25163f.base_info.poi_id;
            this.f25163f = rpcPoi;
            if (rpcPoi != null && this.f25158a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pudozoneid", this.f25158a.fenceId);
                hashMap.put("pudosubdivisionid", this.f25160c);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("b_pudoptid", str2);
                }
                if (rpcPoi.base_info != null) {
                    str = rpcPoi.base_info.poi_id;
                }
                hashMap.put("pudoptid", str);
                hashMap.put("type", Integer.valueOf(i));
                GlobalOmegaTracker.trackEvent("ibt_gp_changepudopt_ck", hashMap);
            }
        }
    }

    public void reportOmegaStationAreaBroadFromOther() {
        if (this.f25158a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f25158a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_other_ck", hashMap);
            return;
        }
        m18053a("reportOmegaStationAreaBroadFromOther fenceId is null.");
    }

    public void reportOmegaChangeStartCircle(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("ibt_gp_waitresponse_changeorigin_mapdrag_ck", hashMap);
    }

    /* renamed from: a */
    private boolean m18054a(RpcPoi rpcPoi, RpcPoi rpcPoi2) {
        if (rpcPoi == null || rpcPoi.base_info == null || rpcPoi2 == null || rpcPoi2.base_info == null) {
            return false;
        }
        String str = rpcPoi.base_info.poi_id;
        String str2 = rpcPoi2.base_info.poi_id;
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2);
    }

    public void clearTerminalCache() {
        this.f25158a = null;
        this.f25159b = null;
        this.f25160c = null;
        this.f25161d = null;
        this.f25163f = null;
    }

    /* renamed from: a */
    private void m18053a(String str) {
        DLog.m7384d("DepartureOmegaManager", str, new Object[0]);
    }
}
