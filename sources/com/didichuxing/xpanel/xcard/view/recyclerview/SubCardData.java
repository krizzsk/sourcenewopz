package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f49725a;

    /* renamed from: b */
    private String f49726b;

    /* renamed from: c */
    private long f49727c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f49728d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f49725a = i;
        this.f49726b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f49726b) || this.f49728d) {
            return false;
        }
        this.f49727c = System.currentTimeMillis();
        this.f49728d = true;
        HashMap hashMap = new HashMap();
        m35885a(hashMap);
        XPanelOmegaUtils.trackEvent("xpanel_subcard_sw", hashMap);
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f49726b) || !this.f49728d) {
            return false;
        }
        this.f49728d = false;
        HashMap hashMap = new HashMap();
        m35885a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f49727c));
        XPanelOmegaUtils.trackEvent("xpanel_subcard_sw_time", hashMap);
        return true;
    }

    /* renamed from: a */
    private void m35885a(Map map) {
        map.put("subcard_id", this.f49726b);
        map.put("position", Integer.valueOf(this.f49725a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
