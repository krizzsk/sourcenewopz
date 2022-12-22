package com.compatible.old.topbar;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.impl.CityChangedNotifier;
import com.didi.sdk.misconfig.p153v2.model.PriConfModel;
import com.didi.sdk.misconfig.p153v2.store.PriConfRepository;
import com.didi.sdk.misconfig.p153v2.utils.ConfUtil;
import com.didi.sdk.oneconf.OneConfStore;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/compatible/old/topbar/PriConfManager;", "", "()V", "cityChangedNotifier", "Lcom/didi/sdk/misconfig/v2/impl/CityChangedNotifier;", "confRepository", "Lcom/didi/sdk/misconfig/v2/store/PriConfRepository;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "seqId", "", "handResponse", "", "priConfModel", "Lcom/didi/sdk/misconfig/v2/model/PriConfModel;", "handleFail", "cityId", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriConfManager.kt */
public final class PriConfManager {
    public static final PriConfManager INSTANCE = new PriConfManager();

    /* renamed from: a */
    private static final Logger f3280a = LoggerFactory.getLogger("PriConfManager");

    /* renamed from: b */
    private static final int f3281b = 0;

    /* renamed from: c */
    private static final PriConfRepository f3282c = new PriConfRepository();

    /* renamed from: d */
    private static final CityChangedNotifier f3283d = new CityChangedNotifier();

    private PriConfManager() {
    }

    public final void handResponse(PriConfModel priConfModel) {
        boolean z;
        if (priConfModel == null) {
            f3280a.info("sa顶导数据返回为空，走缓存逻辑", new Object[0]);
            m2228a(OneConfStore.getInstance().getCityId(), 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errno", 0);
        jSONObject.put("errmsg", "");
        jSONObject.put("data", new JSONObject(new Gson().toJson((Object) priConfModel)));
        if (!Intrinsics.areEqual((Object) f3282c.getCurVersion(), (Object) priConfModel.getCurVersion())) {
            f3282c.saveConfig(priConfModel, jSONObject.toString());
            if (f3282c.getCityId() != priConfModel.getCityId()) {
                f3283d.dispatchCityChangeEvent(f3282c.getCityId(), priConfModel.getCityId());
                f3282c.saveCityId(priConfModel.getCityId());
            }
            z = true;
        } else {
            z = false;
        }
        ConfUtil.dispatchCarInfoUpdate(1, 0, z);
        f3280a.info("sa顶导兼容数据更新成功", new Object[0]);
    }

    /* renamed from: a */
    private final void m2228a(int i, int i2) {
        if (f3282c.getConfigFromCache(i) != null) {
            ConfUtil.dispatchMisFromUpdate(2, i2, true);
        } else {
            ConfUtil.dispatchCarInfoUpdate(-1, i2, false);
        }
    }
}
