package com.didi.sdk.misconfig.p153v2.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p153v2.model.PriConfModel;
import com.didi.sdk.misconfig.p153v2.model.PriConfRsp;
import com.didi.sdk.misconfig.p153v2.utils.ConfUtil;
import com.google.gson.Gson;
import java.util.List;

/* renamed from: com.didi.sdk.misconfig.v2.store.PriConfRepository */
public class PriConfRepository {

    /* renamed from: b */
    private static final String f36826b = "primary_config_store";

    /* renamed from: c */
    private static final String f36827c = "city_id";

    /* renamed from: d */
    private static final String f36828d = "selected_type";

    /* renamed from: e */
    private static final String f36829e = "latest_city_key";

    /* renamed from: f */
    private static final String f36830f = "primary_cfg_cityid_";

    /* renamed from: a */
    private Logger f36831a = LoggerFactory.getLogger("PriConfRepository");

    /* renamed from: g */
    private Context f36832g = DIDIApplication.getAppContext();

    /* renamed from: h */
    private SharedPreferences f36833h;

    /* renamed from: i */
    private PriConfStore f36834i = new PriConfStore();

    /* renamed from: j */
    private String f36835j;

    /* renamed from: k */
    private int f36836k;

    /* renamed from: l */
    private String f36837l;

    /* renamed from: m */
    private String f36838m;

    /* renamed from: n */
    private PriConfModel f36839n;

    /* renamed from: o */
    private TopBarData f36840o;

    /* renamed from: p */
    private List<CarGrop> f36841p;

    /* renamed from: q */
    private CountryInfo f36842q;

    public PriConfRepository() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f36832g, f36826b, 0);
        this.f36833h = sharedPreferences;
        this.f36836k = sharedPreferences.getInt("city_id", 0);
        this.f36835j = "";
        this.f36838m = m26087a();
    }

    public void updateConfigFromCache() {
        this.f36831a.debug("updateMisConfigFromCache begin", new Object[0]);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                PriConfRepository priConfRepository = PriConfRepository.this;
                priConfRepository.getConfigFromCache(priConfRepository.m26091b());
            }
        });
    }

    public PriConfModel getConfigFromCache(int i) {
        Logger logger = this.f36831a;
        logger.debug("updateMisConfigFromCache getSpLatestCityKey = " + i, new Object[0]);
        int i2 = this.f36836k;
        PriConfModel priConfModel = null;
        if (!(i2 == 0 && i2 == -1)) {
            String a = m26088a(f36830f + i);
            if (!TextUtils.isEmpty(a)) {
                try {
                    PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson(a, PriConfRsp.class);
                    if (priConfRsp != null) {
                        priConfModel = priConfRsp.getData();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (priConfModel != null) {
            m26090a(priConfModel);
        }
        return priConfModel;
    }

    public void saveConfig(PriConfModel priConfModel, String str) {
        PriConfStore priConfStore = this.f36834i;
        Context context = this.f36832g;
        priConfStore.putAndSave(context, f36830f + priConfModel.getCityId(), str);
        m26090a(priConfModel);
        m26089a(priConfModel.getCityId());
    }

    public void saveCityId(int i) {
        this.f36836k = i;
        SharedPreferences.Editor edit = this.f36833h.edit();
        edit.putInt("city_id", i);
        edit.apply();
    }

    /* renamed from: a */
    private String m26088a(String str) {
        Object inner = this.f36834i.getInner(this.f36832g, str);
        if (inner == null) {
            return null;
        }
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        if (inner instanceof String) {
            return (String) inner;
        }
        return null;
    }

    public String getCurVersion() {
        return this.f36835j;
    }

    public int getCityId() {
        return this.f36836k;
    }

    public PriConfModel getPriConfData() {
        return this.f36839n;
    }

    public TopBarData getTopBarData() {
        return this.f36840o;
    }

    public CountryInfo getCountryInfo() {
        return this.f36842q;
    }

    public List<CarGrop> getCarGrops() {
        return this.f36841p;
    }

    public void setSelectedType(String str) {
        this.f36838m = str;
        TopBarData topBarData = this.f36840o;
        if (topBarData != null) {
            topBarData.setSelectedGroup(str);
        }
        this.f36833h.edit().putString(f36828d, str).apply();
    }

    public String getSelectedType() {
        if (TextUtils.isEmpty(this.f36838m)) {
            this.f36838m = "ride";
        }
        return this.f36838m;
    }

    /* renamed from: a */
    private String m26087a() {
        String string = this.f36833h.getString(f36828d, (String) null);
        this.f36837l = string;
        if (string == null) {
            this.f36837l = "ride";
        }
        return this.f36837l;
    }

    public String getDefaultSelectedType() {
        return this.f36837l;
    }

    /* renamed from: a */
    private void m26089a(int i) {
        this.f36833h.edit().putInt(f36829e, i).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m26091b() {
        return this.f36833h.getInt(f36829e, 0);
    }

    /* renamed from: a */
    private synchronized void m26090a(PriConfModel priConfModel) {
        this.f36835j = priConfModel.getCurVersion();
        this.f36839n = priConfModel;
        List<CarGrop> castToCarGrops = ConfUtil.castToCarGrops(priConfModel.getPrimaryMenu());
        this.f36841p = castToCarGrops;
        this.f36840o = new TopBarData(castToCarGrops, getSelectedType());
        this.f36842q = m26092b(priConfModel);
    }

    public int getSelectedGroupId() {
        TopBarData topBarData = this.f36840o;
        if (topBarData != null) {
            return topBarData.covertTypeToGroupId(this.f36838m);
        }
        return 0;
    }

    /* renamed from: b */
    private CountryInfo m26092b(PriConfModel priConfModel) {
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setCountryIsoCode(priConfModel.getCountryIsoCode());
        countryInfo.setCountryId(priConfModel.getCountryId());
        countryInfo.setCityId(priConfModel.getCityId());
        countryInfo.setUtcOffSet(priConfModel.getUtcOffset());
        return countryInfo;
    }
}
