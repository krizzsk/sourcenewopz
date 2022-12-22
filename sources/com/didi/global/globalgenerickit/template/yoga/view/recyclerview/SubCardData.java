package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f22327a;

    /* renamed from: b */
    private String f22328b;

    /* renamed from: c */
    private long f22329c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f22330d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f22327a = i;
        this.f22328b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f22328b) || this.f22330d) {
            return false;
        }
        this.f22329c = System.currentTimeMillis();
        this.f22330d = true;
        m16103a(new HashMap());
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f22328b) || !this.f22330d) {
            return false;
        }
        this.f22330d = false;
        HashMap hashMap = new HashMap();
        m16103a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f22329c));
        return true;
    }

    /* renamed from: a */
    private void m16103a(Map map) {
        map.put("subcard_id", this.f22328b);
        map.put("position", Integer.valueOf(this.f22327a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
