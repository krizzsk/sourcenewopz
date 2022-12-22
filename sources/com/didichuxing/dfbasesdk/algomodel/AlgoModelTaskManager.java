package com.didichuxing.dfbasesdk.algomodel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.BuildConfig;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigParam;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AlgoModelTaskManager {
    public static final int MSG_REQUEST_CONFIG = 100;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile String f46500a = null;

    /* renamed from: b */
    private static volatile String f46501b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static int f46502c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f46503d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Handler f46504e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (100 == message.what) {
                LinkedList linkedList = new LinkedList();
                AlgoModelConfigService algoModelConfigService = null;
                Context context = null;
                AlgoModelConfigParam algoModelConfigParam = null;
                boolean z = false;
                while (!AlgoModelTaskManager.f46505f.isEmpty()) {
                    AlgoModelTaskImpl algoModelTaskImpl = (AlgoModelTaskImpl) AlgoModelTaskManager.f46505f.remove(0);
                    if (algoModelTaskImpl.f46490a != null) {
                        context = algoModelTaskImpl.f46490a;
                    }
                    AlgoModelConfigParam.ParamModel paramModel = new AlgoModelConfigParam.ParamModel();
                    paramModel.type = algoModelTaskImpl.f46491b;
                    paramModel.md5 = algoModelTaskImpl.mo115443a();
                    paramModel.sdkVer = algoModelTaskImpl.f46492c;
                    paramModel.background = algoModelTaskImpl.f46493d;
                    if (paramModel.background == 0) {
                        z = true;
                    }
                    if (algoModelConfigParam == null) {
                        algoModelConfigParam = new AlgoModelConfigParam();
                        algoModelConfigParam.appPac = WsgSecInfo.packageName(algoModelTaskImpl.f46490a);
                        algoModelConfigParam.appVer = WsgSecInfo.appVersionName(algoModelTaskImpl.f46490a);
                        algoModelConfigParam.f46487os = 1;
                        algoModelConfigParam.baseSdkVer = BuildConfig.VERSION_NAME;
                        algoModelConfigParam.models = new ArrayList();
                    }
                    algoModelConfigParam.models.add(paramModel);
                    CallbackParam callbackParam = new CallbackParam();
                    callbackParam.type = algoModelTaskImpl.f46491b;
                    callbackParam.configCallback = algoModelTaskImpl.mo115444b();
                    linkedList.add(callbackParam);
                    if (algoModelConfigService == null) {
                        algoModelConfigService = (AlgoModelConfigService) new RpcServiceFactory(algoModelTaskImpl.f46490a).newRpcService(AlgoModelConfigService.class, AlgoModelTaskManager.f46500a);
                    }
                }
                if (algoModelConfigService != null) {
                    AlgoModelTaskManager.m33369b(context, algoModelConfigService, algoModelConfigParam, z, linkedList);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static List<AlgoModelTaskImpl> f46505f = new LinkedList();

    public interface ConfigCallback {
        void onFailure(Exception exc);

        void onSuccess(AlgoModelConfigResult.ResultModel resultModel);
    }

    /* renamed from: c */
    static /* synthetic */ int m33370c() {
        int i = f46503d;
        f46503d = i + 1;
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ int m33373f() {
        int i = f46502c;
        f46502c = i - 1;
        return i;
    }

    @Deprecated
    public static void execute(AlgoModelTaskImpl algoModelTaskImpl) {
        if (f46500a != null && f46501b != null) {
            algoModelTaskImpl.prepareModels();
        }
    }

    public static void execute(AlgoModelTaskImpl algoModelTaskImpl, String str, String str2) {
        f46500a = str;
        f46501b = str2;
        algoModelTaskImpl.prepareModels();
    }

    public static String getModelDir(Context context, int i) {
        return AlgoModelTaskImpl.m33319a(context, i);
    }

    /* renamed from: a */
    static void m33366a(AlgoModelTaskImpl algoModelTaskImpl) {
        f46504e.removeMessages(100);
        if (!f46505f.contains(algoModelTaskImpl)) {
            f46505f.add(algoModelTaskImpl);
        }
        f46504e.sendMessageDelayed(f46504e.obtainMessage(100), 200);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33369b(Context context, AlgoModelConfigService algoModelConfigService, AlgoModelConfigParam algoModelConfigParam, boolean z, List<CallbackParam> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "1.0.0");
        final boolean z2 = z;
        final List<CallbackParam> list2 = list;
        final Context context2 = context;
        final AlgoModelConfigParam algoModelConfigParam2 = algoModelConfigParam;
        final AlgoModelConfigService algoModelConfigService2 = algoModelConfigService;
        algoModelConfigService.getConfig(hashMap, algoModelConfigParam, new RpcService.Callback<AlgoModelConfigResult>() {
            public void onSuccess(AlgoModelConfigResult algoModelConfigResult) {
                boolean z;
                if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100002 != algoModelConfigResult.data.code) {
                    int unused = AlgoModelTaskManager.f46503d = 0;
                    if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100000 != algoModelConfigResult.data.code) {
                        for (CallbackParam callbackParam : list2) {
                            callbackParam.configCallback.onFailure(new Exception(String.valueOf(algoModelConfigResult)));
                        }
                        return;
                    }
                    for (CallbackParam callbackParam2 : list2) {
                        if (algoModelConfigResult.data.result != null) {
                            z = false;
                            for (AlgoModelConfigResult.ResultModel next : algoModelConfigResult.data.result) {
                                if (callbackParam2.type == next.type) {
                                    z = true;
                                    callbackParam2.configCallback.onSuccess(next);
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            callbackParam2.configCallback.onSuccess((AlgoModelConfigResult.ResultModel) null);
                        }
                    }
                    return;
                }
                if (z2) {
                    AlgoModelTaskManager.m33370c();
                }
                onFailure(new ServerBrokenExp("server response 100002"));
            }

            public void onFailure(IOException iOException) {
                if (z2 && AlgoModelTaskManager.f46503d >= 3) {
                    AlgoModelTaskManager.m33368b(context2, algoModelConfigParam2, list2);
                } else if (z2 || AlgoModelTaskManager.f46502c <= 0) {
                    for (CallbackParam callbackParam : list2) {
                        callbackParam.configCallback.onFailure(iOException);
                    }
                } else {
                    AlgoModelTaskManager.m33373f();
                    AlgoModelTaskManager.f46504e.postDelayed(new Runnable() {
                        public void run() {
                            AlgoModelTaskManager.m33369b(context2, algoModelConfigService2, algoModelConfigParam2, z2, list2);
                        }
                    }, 2000);
                }
            }
        });
    }

    private static class ServerBrokenExp extends IOException {
        public ServerBrokenExp() {
        }

        public ServerBrokenExp(String str) {
            super(str);
        }

        public ServerBrokenExp(String str, Throwable th) {
            super(str, th);
        }

        public ServerBrokenExp(Throwable th) {
            super(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33368b(Context context, AlgoModelConfigParam algoModelConfigParam, final List<CallbackParam> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "1.0.0");
        ((AlgoModelConfigService) new RpcServiceFactory(context).newRpcService(AlgoModelConfigService.class, f46501b)).requestReserve(hashMap, algoModelConfigParam, new RpcService.Callback<AlgoModelConfigResult>() {
            public void onSuccess(AlgoModelConfigResult algoModelConfigResult) {
                if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100000 != algoModelConfigResult.data.code) {
                    onFailure(new IOException(String.valueOf(algoModelConfigResult)));
                    return;
                }
                for (CallbackParam callbackParam : list) {
                    boolean z = false;
                    if (algoModelConfigResult.data.result != null) {
                        for (AlgoModelConfigResult.ResultModel next : algoModelConfigResult.data.result) {
                            if (callbackParam.type == next.type) {
                                z = true;
                                callbackParam.configCallback.onSuccess(next);
                            }
                        }
                    }
                    if (!z) {
                        callbackParam.configCallback.onSuccess((AlgoModelConfigResult.ResultModel) null);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                for (CallbackParam callbackParam : list) {
                    callbackParam.configCallback.onFailure(iOException);
                }
            }
        });
    }

    private static class CallbackParam {
        ConfigCallback configCallback;
        int type;

        private CallbackParam() {
        }
    }
}
