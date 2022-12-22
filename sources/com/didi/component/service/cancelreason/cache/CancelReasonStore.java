package com.didi.component.service.cancelreason.cache;

import android.content.Context;
import android.util.LruCache;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.google.gson.Gson;

public class CancelReasonStore extends BaseStore {

    /* renamed from: d */
    private static final String f15746d = "LID";

    /* renamed from: e */
    private static final String f15747e = "PID";

    /* renamed from: f */
    private static final String f15748f = "DARR";

    /* renamed from: g */
    private static final String f15749g = "CASH";

    /* renamed from: h */
    private static final String f15750h = "V2";

    /* renamed from: a */
    private Context f15751a = DIDIApplication.getAppContext();

    /* renamed from: b */
    private Gson f15752b = new Gson();

    /* renamed from: c */
    private LruCache<String, CancelReasonInfo> f15753c = new LruCache<>(4);

    private CancelReasonStore() {
        super("business-cancelReasonList");
    }

    public static CancelReasonStore getInstance() {
        return (CancelReasonStore) SingletonHolder.getInstance(CancelReasonStore.class);
    }

    /* renamed from: a */
    private CancelReasonInfo m11493a(String str) {
        try {
            CancelReasonInfo cancelReasonInfo = this.f15753c.get(str);
            if (cancelReasonInfo != null) {
                return cancelReasonInfo;
            }
            return (CancelReasonInfo) this.f15752b.fromJson(new String(load(this.f15751a, str).data), CancelReasonInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CancelReasonInfo getCurrCancelReasonInfo() {
        String a = m11494a();
        GLog.m7965d("CancelReasonStore", "getKey:" + a);
        return m11493a(a);
    }

    public void saveCancelReasonInfo(String str, int i, boolean z, boolean z2, CancelReasonInfo cancelReasonInfo) {
        m11496a(m11495a(str, i, z, z2), cancelReasonInfo);
    }

    /* renamed from: a */
    private void m11496a(String str, CancelReasonInfo cancelReasonInfo) {
        this.f15753c.put(str, cancelReasonInfo);
        save(this.f15751a, str, this.f15752b.toJson((Object) cancelReasonInfo).getBytes());
    }

    public void saveCurrCancelReasonInfo(CancelReasonInfo cancelReasonInfo) {
        String a = m11494a();
        GLog.m7965d("CancelReasonStore", "saveKey:" + a);
        m11496a(a, cancelReasonInfo);
    }

    /* renamed from: a */
    private String m11495a(String str, int i, boolean z, boolean z2) {
        return f15746d + str + f15747e + i + f15748f + z + f15749g + z2 + f15750h;
    }

    /* renamed from: a */
    private String m11494a() {
        if (CarOrderHelper.getOrder() == null) {
            return "";
        }
        return m11495a(NationTypeUtil.getNationComponentData().getLocaleCode(), CarOrderHelper.isCarPoolLineHaveOrder() ? CarOrderHelper.getOrder().comboType : CarOrderHelper.getOrder().productid, CancelTripCache.getInstance().isDriverArrived(), CarOrderHelper.getOrder().payType == 1024);
    }
}
