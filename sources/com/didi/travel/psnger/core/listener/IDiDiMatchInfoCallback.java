package com.didi.travel.psnger.core.listener;

import com.didi.travel.psnger.core.model.response.IMatchInfo;

public interface IDiDiMatchInfoCallback {
    void onMatchInfoRefresh(boolean z, IMatchInfo iMatchInfo);
}
