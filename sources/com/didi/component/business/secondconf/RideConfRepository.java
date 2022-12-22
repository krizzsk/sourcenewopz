package com.didi.component.business.secondconf;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.secondconf.model.RideConfBizModel;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.component.business.secondconf.model.RideConfRsp;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.config.ComponentsConfig;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.AppUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class RideConfRepository extends BaseStore {

    /* renamed from: a */
    private static final String f11340a = "ride_conf";

    /* renamed from: b */
    private String f11341b = "";

    /* renamed from: c */
    private RideConfModel f11342c;

    /* renamed from: d */
    private List<CarInfo> f11343d;

    public RideConfRepository() {
        super("framework-RideConfStore");
        updateConfigFromCache();
    }

    public String getCurVersion() {
        return this.f11341b;
    }

    public RideConfModel getConfModel() {
        return this.f11342c;
    }

    public void saveConfig(RideConfModel rideConfModel, String str) {
        m7655a(rideConfModel);
        putAndSave((Context) DIDIApplication.getAppContext(), f11340a, str);
    }

    public void updateConfigFromCache() {
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                RideConfRepository.this.getConfigFromCache();
            }
        });
    }

    public RideConfModel getConfigFromCache() {
        String a = m7653a(f11340a);
        RideConfModel rideConfModel = null;
        if (!TextUtils.isEmpty(a)) {
            try {
                RideConfRsp rideConfRsp = (RideConfRsp) new Gson().fromJson(a, RideConfRsp.class);
                if (rideConfRsp != null) {
                    rideConfModel = rideConfRsp.getData();
                }
                m7655a(rideConfModel);
            } catch (Throwable unused) {
            }
        }
        return rideConfModel;
    }

    /* renamed from: a */
    private String m7653a(String str) {
        Object inner = getInner(DIDIApplication.getAppContext(), str);
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

    /* renamed from: a */
    private synchronized void m7655a(RideConfModel rideConfModel) {
        if (rideConfModel != null) {
            this.f11341b = rideConfModel.getCurVersion();
            this.f11342c = rideConfModel;
            m7656a(rideConfModel.getSecondaryMenu());
        }
    }

    /* renamed from: a */
    private void m7656a(List<RideConfBizModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (RideConfBizModel next : list) {
                CarInfo carInfo = new CarInfo();
                carInfo.setBusinessId(next.getBusinessId());
                carInfo.setBusinessNumId(next.getBusinessNumId());
                carInfo.setMapIcon(next.getMapIcon());
                carInfo.setCarId(next.getCarId());
                carInfo.setCarLevel(next.getCarLevel());
                carInfo.setComboType(next.getComboType());
                arrayList.add(carInfo);
                m7654a(next.getBusinessNumId());
            }
        }
        this.f11343d = arrayList;
        if (FormStore.getInstance().Bid == 0 && this.f11343d.size() > 0 && this.f11343d.get(0) != null) {
            CarInfo carInfo2 = this.f11343d.get(0);
            FormStore.getInstance().initData(carInfo2.getBusinessId(), carInfo2.getBusinessNumId(), carInfo2.getComboType());
        }
    }

    /* renamed from: a */
    private void m7654a(int i) {
        ComponentsConfig.get().checkOrAddComponent(i, AppUtils.isBrazilApp(DIDIApplication.getAppContext()) ? GlobalComponentConfig.BRAZIL_COMMON : GlobalComponentConfig.MEXICO_COMMON);
    }

    public List<CarInfo> getCarInfo() {
        return this.f11343d;
    }
}
