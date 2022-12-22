package com.didi.component.business.secondconf;

import com.didi.component.business.secondconf.model.RideConfBizModel;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.misconfig.model.WarmupActivity;
import com.didi.sdk.misconfig.p153v2.ISecondConf;
import java.util.List;

public class RideConfImpl implements ISecondConf {

    /* renamed from: a */
    private RideConfRepository f11336a = new RideConfRepository();

    /* renamed from: b */
    private int f11337b = 0;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final RideConfImpl instance = new RideConfImpl();

        private SingletonHolder() {
        }
    }

    RideConfImpl() {
    }

    public static RideConfImpl getInstance() {
        return SingletonHolder.instance;
    }

    public void getSecConfigFromNet(double d, double d2, int i) {
        RideConfRequest rideConfRequest = new RideConfRequest(this.f11336a);
        int i2 = this.f11337b;
        this.f11337b = i2 + 1;
        rideConfRequest.request(d, d2, i, i2);
    }

    public boolean isPreHeat() {
        RideConfModel confModel = this.f11336a.getConfModel();
        return confModel != null && confModel.getShowStatus() == 0;
    }

    public int getDefaultBusinessId() {
        RideConfBizModel rideConfBizModel;
        RideConfModel confModel = this.f11336a.getConfModel();
        if (confModel == null || confModel.getSecondaryMenu() == null || confModel.getSecondaryMenu().size() <= 0 || (rideConfBizModel = confModel.getSecondaryMenu().get(0)) == null) {
            return 0;
        }
        return rideConfBizModel.getBusinessNumId();
    }

    public String getCarNameByBid(int i) {
        RideConfBizModel confBizModel = getConfBizModel(i);
        if (confBizModel != null) {
            return confBizModel.getName();
        }
        return null;
    }

    public boolean isCityOpen(String str) {
        RideConfModel confModel = this.f11336a.getConfModel();
        return (confModel == null || confModel.getSecondaryMenu() == null || confModel.getSecondaryMenu().size() <= 0) ? false : true;
    }

    public String getMapIcon(int i) {
        RideConfBizModel confBizModel = getConfBizModel(i);
        if (confBizModel != null) {
            return confBizModel.getMapIcon();
        }
        return null;
    }

    public int getCarLevel(int i) {
        RideConfBizModel confBizModel = getConfBizModel(i);
        if (confBizModel != null) {
            return confBizModel.getCarLevel();
        }
        return 0;
    }

    public int getComboType(int i) {
        RideConfBizModel confBizModel = getConfBizModel(i);
        if (confBizModel != null) {
            return confBizModel.getComboType();
        }
        return 0;
    }

    public List<CarInfo> getCarInfo() {
        return this.f11336a.getCarInfo();
    }

    public RideConfBizModel getConfBizModel(int i) {
        RideConfModel confModel = this.f11336a.getConfModel();
        if (confModel == null || confModel.getSecondaryMenu() == null || confModel.getSecondaryMenu().size() <= 0) {
            return null;
        }
        for (RideConfBizModel next : confModel.getSecondaryMenu()) {
            if (next.getBusinessNumId() == i) {
                return next;
            }
        }
        return null;
    }

    public boolean isShowCarIcon() {
        RideConfModel confModel = this.f11336a.getConfModel();
        if (confModel == null || confModel.getShowStatus() != 1) {
            return false;
        }
        return true;
    }

    public WarmupActivity getWarmupActivity() {
        RideConfModel confModel = this.f11336a.getConfModel();
        if (confModel != null) {
            return confModel.getWarmupActivity();
        }
        return null;
    }
}
