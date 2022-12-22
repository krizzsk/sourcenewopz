package com.didi.travel.psnger.core.matchinfo;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.BaseMatchInfoParams;
import com.didi.travel.psnger.core.model.response.IMatchInfo;

public interface MatchInfoService {
    void getMatchInfo(Context context, BaseMatchInfoParams baseMatchInfoParams, ResponseListener<? extends IMatchInfo> responseListener);

    void startMatchInfo(boolean z, BaseMatchInfoParams baseMatchInfoParams);

    void stopMatchInfo();
}
