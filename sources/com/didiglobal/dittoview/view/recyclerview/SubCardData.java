package com.didiglobal.dittoview.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f50017a;

    /* renamed from: b */
    private String f50018b;

    /* renamed from: c */
    private long f50019c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f50020d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f50017a = i;
        this.f50018b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f50018b) || this.f50020d) {
            return false;
        }
        this.f50019c = System.currentTimeMillis();
        this.f50020d = true;
        m36024a(new HashMap());
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f50018b) || !this.f50020d) {
            return false;
        }
        this.f50020d = false;
        HashMap hashMap = new HashMap();
        m36024a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f50019c));
        return true;
    }

    /* renamed from: a */
    private void m36024a(Map map) {
        map.put("subcard_id", this.f50018b);
        map.put("position", Integer.valueOf(this.f50017a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
