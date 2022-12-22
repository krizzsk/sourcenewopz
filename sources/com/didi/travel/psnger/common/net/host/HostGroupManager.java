package com.didi.travel.psnger.common.net.host;

import com.didi.travel.psnger.IHostConfig;
import com.didi.travel.psnger.utils.TextUtil;

public class HostGroupManager {

    /* renamed from: g */
    private static HostGroupManager f44055g;

    /* renamed from: a */
    private String f44056a;

    /* renamed from: b */
    private String f44057b;

    /* renamed from: c */
    private String f44058c;

    /* renamed from: d */
    private String f44059d;

    /* renamed from: e */
    private String f44060e;

    /* renamed from: f */
    private String f44061f;

    private HostGroupManager() {
        initDefaultHost();
    }

    public static HostGroupManager getInstance() {
        if (f44055g == null) {
            synchronized (HostGroupManager.class) {
                if (f44055g == null) {
                    f44055g = new HostGroupManager();
                }
            }
        }
        return f44055g;
    }

    public void initDefaultHost() {
        this.f44056a = "https://api.didiglobal.com/";
        this.f44057b = "https://api.didiglobal.com/";
        this.f44058c = "https://common.didiglobal.com/";
        this.f44059d = "https://api.didiglobal.com/";
        this.f44060e = "https://common.didiglobal.com/";
        this.f44061f = "https://esapi.didiglobal.com/";
    }

    public void configTargetHostGroup(IHostConfig iHostConfig) {
        initDefaultHost();
        if (iHostConfig != null) {
            String businessHost = iHostConfig.businessHost();
            if (!TextUtil.isEmpty(businessHost)) {
                this.f44056a = businessHost;
            }
            String evaluateHost = iHostConfig.evaluateHost();
            if (!TextUtil.isEmpty(evaluateHost)) {
                this.f44057b = evaluateHost;
            }
            String activityHost = iHostConfig.activityHost();
            if (!TextUtil.isEmpty(activityHost)) {
                this.f44059d = activityHost;
            }
            String carSlidingHost = iHostConfig.carSlidingHost();
            if (!TextUtil.isEmpty(carSlidingHost)) {
                this.f44058c = carSlidingHost;
            }
            String routeTrackHost = iHostConfig.routeTrackHost();
            if (!TextUtil.isEmpty(routeTrackHost)) {
                this.f44060e = routeTrackHost;
            }
            String enterprisePayHost = iHostConfig.enterprisePayHost();
            if (!TextUtil.isEmpty(enterprisePayHost)) {
                this.f44061f = enterprisePayHost;
            }
        }
    }

    public String getDiDiBizHost() {
        return this.f44056a;
    }

    public String getDiDiEvaluateHost() {
        return this.f44057b;
    }

    public String getDiDiCarslidingHost() {
        return this.f44058c;
    }

    public String getDiDiResourcesHost() {
        return this.f44059d;
    }

    public String getDiDiRouteTrackHost() {
        return this.f44060e;
    }

    public String getDiDiPayEnterpriseHost() {
        return this.f44061f;
    }
}
