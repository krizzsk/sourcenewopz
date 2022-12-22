package com.didi.travel.psnger.core.matchinfo;

import com.didi.travel.psnger.core.model.request.BaseMatchInfoParams;

public abstract class AbsMatchInfoService implements MatchInfoService {

    /* renamed from: a */
    private MatchInfoPollingManager f44070a;

    public void startMatchInfo(boolean z, BaseMatchInfoParams baseMatchInfoParams) {
        if (this.f44070a == null) {
            this.f44070a = new MatchInfoPollingManager(this);
        }
        this.f44070a.startMatchInfo(z, baseMatchInfoParams);
    }

    public void stopMatchInfo() {
        MatchInfoPollingManager matchInfoPollingManager = this.f44070a;
        if (matchInfoPollingManager != null) {
            matchInfoPollingManager.stopOrderMatchInfoPoll();
        }
    }
}
