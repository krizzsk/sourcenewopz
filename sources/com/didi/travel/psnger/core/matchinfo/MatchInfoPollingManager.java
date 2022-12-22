package com.didi.travel.psnger.core.matchinfo;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.IDiDiMatchInfoCallback;
import com.didi.travel.psnger.core.model.request.BaseMatchInfoParams;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IMatchInfo;
import com.didi.travel.psnger.core.poll.BasePoller;
import com.didi.travel.psnger.core.poll.IPollCallbackProtocol;
import com.didi.travel.psnger.core.poll.adapter.PollCallbackAdapter;
import com.didi.travel.psnger.core.poll.impl.DefaultPoller;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;

public class MatchInfoPollingManager {

    /* renamed from: a */
    private static final int f44071a = 86400000;

    /* renamed from: b */
    private BasePoller f44072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BaseMatchInfoParams f44073c;

    /* renamed from: d */
    private MatchInfoService f44074d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDiDiMatchInfoCallback f44075e;

    /* renamed from: f */
    private IPollCallbackProtocol f44076f = new PollCallbackAdapter() {
        public void onSendRequest(int i) {
            if (TextUtil.isEmpty(TravelSDK.travelParam() != null ? TravelSDK.travelParam().token() : null)) {
                MatchInfoPollingManager.this.stopOrderMatchInfoPoll();
                return;
            }
            ICarOrder order = DDTravelOrderStore.getOrder();
            if (order != null && !TextUtil.isEmpty(order.getOid()) && order.getStartAddress() != null) {
                MatchInfoPollingManager.this.m31365a(false);
            }
        }
    };

    public MatchInfoPollingManager(MatchInfoService matchInfoService) {
        this.f44074d = matchInfoService;
    }

    public void startMatchInfo(boolean z, BaseMatchInfoParams baseMatchInfoParams) {
        this.f44073c = baseMatchInfoParams;
        m31365a(z);
    }

    public void setMatchCallback(IDiDiMatchInfoCallback iDiDiMatchInfoCallback) {
        this.f44075e = iDiDiMatchInfoCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31362a(long j) {
        if (j <= 1000) {
            j = 5000;
        }
        long j2 = j;
        long j3 = (long) 86399999;
        long j4 = (long) 1000;
        LogUtil.m31432fi("startOrderMatchInfoPoll maxTimeThreshold=" + j3 + ", frequencyTime=" + j2 + ", diffMaxTime=" + j4);
        if (this.f44072b == null) {
            this.f44072b = new DefaultPoller();
        }
        if (this.f44072b.checkPollerRunning()) {
            this.f44072b.stopPoll();
        }
        this.f44072b.registerPollCallback(this.f44076f);
        this.f44072b.startPoll(j3, j2, j4, true);
    }

    public void stopOrderMatchInfoPoll() {
        BasePoller basePoller = this.f44072b;
        if (basePoller != null) {
            basePoller.stopPoll();
            this.f44072b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m31366a() {
        return this.f44072b.checkPollerRunning();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31365a(final boolean z) {
        LogUtil.m31432fi("doQueryMatchInfo isInit " + z);
        if (this.f44073c == null) {
            LogUtil.m31432fi("doQueryMatchInfo mMatchInfoParams == null");
            return;
        }
        LogUtil.m31432fi("doQueryMatchInfo mMatchInfoParams != null");
        this.f44074d.getMatchInfo(TravelSDK.appContext(), this.f44073c, new ResponseListener<IMatchInfo>() {
            public void onSuccess(IMatchInfo iMatchInfo) {
                super.onSuccess(iMatchInfo);
                if (!TextUtils.equals(MatchInfoPollingManager.this.f44073c.getOid(), iMatchInfo.getOid()) && !TravelSDK.isDebug()) {
                    return;
                }
                if (z || MatchInfoPollingManager.this.m31366a()) {
                    if (iMatchInfo.isStopQuery()) {
                        if (!z) {
                            MatchInfoPollingManager.this.stopOrderMatchInfoPoll();
                        }
                    } else if (z) {
                        MatchInfoPollingManager.this.m31362a((long) (iMatchInfo.getQueryStep() * 1000));
                    }
                    if (MatchInfoPollingManager.this.f44075e != null) {
                        MatchInfoPollingManager.this.f44075e.onMatchInfoRefresh(z, iMatchInfo);
                    }
                }
            }

            public void onFail(IMatchInfo iMatchInfo) {
                super.onFail(iMatchInfo);
                if (z) {
                    MatchInfoPollingManager.this.m31362a(5000);
                }
            }

            public void onError(IMatchInfo iMatchInfo) {
                super.onError(iMatchInfo);
                if (z) {
                    MatchInfoPollingManager.this.m31362a(5000);
                }
            }
        });
    }
}
