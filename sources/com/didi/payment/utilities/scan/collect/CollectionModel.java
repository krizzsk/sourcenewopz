package com.didi.payment.utilities.scan.collect;

import java.util.HashMap;
import java.util.Map;

public class CollectionModel {

    /* renamed from: a */
    private String f31691a;

    /* renamed from: b */
    private String f31692b;

    /* renamed from: c */
    private int f31693c;

    /* renamed from: d */
    private boolean f31694d;

    /* renamed from: e */
    private boolean f31695e;

    public CollectionModel(String str, String str2, int i, boolean z, boolean z2) {
        this.f31692b = str;
        this.f31691a = str2;
        this.f31693c = i;
        this.f31694d = z;
        this.f31695e = z2;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(CollectionConstant.EVENT_PARAM_ID, this.f31691a);
        hashMap.put(CollectionConstant.EVENT_PARAM_SEQ, Integer.valueOf(this.f31693c));
        String str = "1";
        hashMap.put(CollectionConstant.EVENT_PARAM_ACTION, this.f31694d ? str : "0");
        if (!this.f31695e) {
            str = "0";
        }
        hashMap.put(CollectionConstant.EVENT_PARAM_VALID, str);
        hashMap.put("data", this.f31692b);
        return hashMap;
    }
}
