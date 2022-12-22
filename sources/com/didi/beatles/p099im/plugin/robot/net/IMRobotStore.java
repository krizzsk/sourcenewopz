package com.didi.beatles.p099im.plugin.robot.net;

import com.didi.beatles.p099im.net.IMHttpManager;
import com.didi.beatles.p099im.net.IMNetCallback;
import com.didi.beatles.p099im.plugin.robot.net.callback.IMRobotConfigureCallback;
import com.didi.beatles.p099im.plugin.robot.net.callback.IMRobotPraiseListCallback;
import com.didi.beatles.p099im.plugin.robot.net.callback.IMRobotUnlockCallback;
import com.didi.beatles.p099im.plugin.robot.net.request.IMRobotGetConfigureRequest;
import com.didi.beatles.p099im.plugin.robot.net.request.IMRobotPraiseListRequest;
import com.didi.beatles.p099im.plugin.robot.net.request.IMRobotUnlockRobotRequest;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotPraiseListResponse;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotUnlockRobotResponse;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.net.IMRobotStore */
public class IMRobotStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9517a = IMRobotStore.class.getSimpleName();

    /* renamed from: b */
    private final int f9518b;

    /* renamed from: c */
    private final long f9519c;

    /* renamed from: d */
    private final String f9520d;

    /* renamed from: e */
    private final String f9521e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMRobotGetConfigureResponse.Body f9522f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Map<Integer, String> f9523g = new HashMap();

    public IMRobotStore(int i, long j, String str, String str2) {
        this.f9518b = i;
        this.f9519c = j;
        this.f9520d = str;
        this.f9521e = str2;
    }

    public void loadConfigure(final IMRobotConfigureCallback iMRobotConfigureCallback) {
        this.f9522f = null;
        this.f9523g.clear();
        IMHttpManager.getInstance().performCommonPost(new IMRobotGetConfigureRequest(this.f9518b, this.f9519c, this.f9520d, this.f9521e), new IMNetCallback<IMRobotGetConfigureResponse>() {
            public void success(final IMRobotGetConfigureResponse iMRobotGetConfigureResponse) {
                if (iMRobotGetConfigureResponse == null || !iMRobotGetConfigureResponse.isSuccess() || iMRobotGetConfigureResponse.body == null) {
                    IMLog.m6632e(IMRobotStore.f9517a, "[loadConfigure] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotConfigureCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        IMRobotGetConfigureResponse.Body unused = IMRobotStore.this.f9522f = iMRobotGetConfigureResponse.body;
                        if (IMRobotStore.this.f9522f.praiseBtnConfigList != null) {
                            for (IMRobotGetConfigureResponse.PraiseBtnConfig next : IMRobotStore.this.f9522f.praiseBtnConfigList) {
                                IMRobotStore.this.f9523g.put(Integer.valueOf(next.type), next.btnText);
                            }
                        }
                        iMRobotConfigureCallback.onSucceed(iMRobotGetConfigureResponse.body);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m6632e(IMRobotStore.f9517a, "[loadConfigure] #failure# ", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotConfigureCallback.onFailed();
                    }
                });
            }
        });
    }

    public void loadPraiseList(String str, final IMRobotPraiseListCallback iMRobotPraiseListCallback) {
        IMHttpManager.getInstance().performCommonPost(new IMRobotPraiseListRequest(this.f9518b, str, this.f9519c, this.f9520d), new IMNetCallback<IMRobotPraiseListResponse>() {
            public void success(final IMRobotPraiseListResponse iMRobotPraiseListResponse) {
                if (iMRobotPraiseListResponse == null || !iMRobotPraiseListResponse.isSuccess() || iMRobotPraiseListResponse.body == null) {
                    IMLog.m6632e(IMRobotStore.f9517a, "[loadPraiseList] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotPraiseListCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotPraiseListCallback.onSucceed(iMRobotPraiseListResponse.body.praiseList);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m6632e(IMRobotStore.f9517a, "[loadPraiseList] #failure#", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotPraiseListCallback.onFailed();
                    }
                });
            }
        });
    }

    public void unlockRobot(String str, final IMRobotUnlockCallback iMRobotUnlockCallback) {
        IMHttpManager.getInstance().performCommonPost(new IMRobotUnlockRobotRequest(this.f9518b, str), new IMNetCallback<IMRobotUnlockRobotResponse>() {
            public void success(final IMRobotUnlockRobotResponse iMRobotUnlockRobotResponse) {
                if (iMRobotUnlockRobotResponse == null || !iMRobotUnlockRobotResponse.isSuccess() || iMRobotUnlockRobotResponse.body == null) {
                    IMLog.m6632e(IMRobotStore.f9517a, "[unlockRobot] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotUnlockCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotUnlockCallback.onSucceed(iMRobotUnlockRobotResponse.body);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m6632e(IMRobotStore.f9517a, "[unlockRobot] #failure#", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotUnlockCallback.onFailed();
                    }
                });
            }
        });
    }

    public IMRobotGetConfigureResponse.Robot getRobot(int i) {
        IMRobotGetConfigureResponse.Body body = this.f9522f;
        if (body == null || body.robotList == null || i < 0 || i >= this.f9522f.robotList.size()) {
            return null;
        }
        return this.f9522f.robotList.get(i);
    }

    public String getPraiseBtnText(int i) {
        Map<Integer, String> map = this.f9523g;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public String getShareBtnText() {
        IMRobotGetConfigureResponse.Body body = this.f9522f;
        if (body != null) {
            return body.shareBtnText;
        }
        return null;
    }
}
