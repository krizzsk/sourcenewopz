package com.didichuxing.apollo.sdk.dataprovider;

import android.content.Context;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.IAppInfoDelegate;
import com.didichuxing.apollo.sdk.IUserInfoDelegate;
import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.model.ResponseObj;
import com.didichuxing.apollo.sdk.model.ToggleData;
import com.didichuxing.apollo.sdk.net.HttpRequest;
import com.didichuxing.apollo.sdk.net.ObjectCallback;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.utils.HotPatchUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataProvider implements IDataProvider<ToggleData> {

    /* renamed from: a */
    private static final String f45603a = "cache_key_last_response";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ExecutorService f45604b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private String f45605c = "";

    /* renamed from: d */
    private IUserInfoDelegate f45606d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IAppInfoDelegate f45607e;

    /* renamed from: f */
    private RequestHandler f45608f;

    /* renamed from: g */
    private UpdatePolicy f45609g = new UpdatePolicy();

    /* renamed from: h */
    private ILogDelegate f45610h;

    /* renamed from: i */
    private long f45611i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ResponseObj f45612j;

    /* renamed from: k */
    private Context f45613k;

    public static class UpdatePolicy {
        public long minUpdateInterval;
    }

    public DataProvider(Context context, String str, IUserInfoDelegate iUserInfoDelegate, IAppInfoDelegate iAppInfoDelegate, RequestHandler requestHandler) {
        this.f45613k = context;
        if (str != null) {
            this.f45605c = str;
        }
        this.f45606d = iUserInfoDelegate;
        this.f45607e = iAppInfoDelegate;
        this.f45608f = requestHandler;
        DCache.init(this.f45613k);
    }

    public void setUpdatePolicy(UpdatePolicy updatePolicy) {
        if (updatePolicy != null) {
            this.f45609g = updatePolicy;
        }
    }

    public void setLogDelegate(ILogDelegate iLogDelegate) {
        this.f45610h = iLogDelegate;
    }

    public void getData(IDataProvider.IGetCallback<ToggleData> iGetCallback) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "dp getData start");
        if (HotPatchUtil.enable()) {
            ResponseObj responseObj = (ResponseObj) DCache.getObject(f45603a, ResponseObj.class);
            if (responseObj == null || responseObj.getToggleMap().size() <= 0) {
                iGetCallback.onFail();
            } else {
                if (LogUtils.DEBUG) {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "getData " + responseObj);
                }
                this.f45612j = responseObj;
                iGetCallback.onGetData(new ToggleData(responseObj.key, responseObj.getToggleMap()));
                return;
            }
        }
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "dp getData end");
    }

    public void update(final IDataProvider.IUpdateCallback<ToggleData> iUpdateCallback) {
        if (!m32686b()) {
            iUpdateCallback.onFail();
            return;
        }
        if (this.f45612j == null) {
            this.f45612j = (ResponseObj) DCache.getObject(f45603a, ResponseObj.class);
        }
        ResponseObj responseObj = this.f45612j;
        HttpRequest.getApolloConfig(this.f45613k, this.f45605c, (responseObj == null || responseObj.code != 0) ? "" : this.f45612j.md5, this.f45606d, this.f45607e, this.f45608f, new ObjectCallback<ResponseObj>(ResponseObj.class) {
            public void onComplete(ResponseObj responseObj) {
                LogUtils.m32690d("ObjectCallback#onComplete ResponseObj: " + responseObj);
                if (responseObj == null) {
                    iUpdateCallback.onFail();
                } else if (responseObj.code == 0) {
                    ResponseObj unused = DataProvider.this.f45612j = responseObj;
                    if (DataProvider.this.f45607e != null) {
                        responseObj.appFullVersion = DataProvider.this.f45607e.getFullVersion();
                    }
                    DataProvider.f45604b.execute(new OneShotDumpTask(responseObj));
                    iUpdateCallback.onUpdate(new ToggleData(responseObj.key, responseObj.getToggleMap()));
                } else if (responseObj.code == -1) {
                    iUpdateCallback.onFail();
                } else if (responseObj.code == 304) {
                    iUpdateCallback.onNoChange();
                } else {
                    iUpdateCallback.onFail();
                }
            }

            public void onError(Exception exc) {
                LogUtils.m32690d("ObjectCallback#onError");
                exc.printStackTrace();
                iUpdateCallback.onFail();
            }
        });
        this.f45611i = System.currentTimeMillis();
    }

    /* renamed from: b */
    private boolean m32686b() {
        if (this.f45609g != null && System.currentTimeMillis() - this.f45611i <= this.f45609g.minUpdateInterval) {
            return false;
        }
        return true;
    }

    public void setmRequestHandler(RequestHandler requestHandler) {
        this.f45608f = requestHandler;
    }

    public String getFullAppVersionWhenCached() {
        ResponseObj responseObj = this.f45612j;
        if (responseObj == null) {
            return "";
        }
        return responseObj.appFullVersion;
    }

    private class OneShotDumpTask implements Runnable {

        /* renamed from: r */
        ResponseObj f45614r;

        OneShotDumpTask(ResponseObj responseObj) {
            this.f45614r = responseObj;
        }

        public void run() {
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "dump cache to file" + this.f45614r);
            DCache.putObject(DataProvider.f45603a, this.f45614r);
        }
    }
}
