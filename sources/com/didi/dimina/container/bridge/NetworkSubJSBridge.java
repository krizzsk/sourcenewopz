package com.didi.dimina.container.bridge;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.DomainComplianceUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.Scopes;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkSubJSBridge {

    /* renamed from: c */
    private static final String f16617c = "NetworkSubJSBridge";

    /* renamed from: d */
    private static final String f16618d = "onRequestTaskStateChange";

    /* renamed from: e */
    private static final String f16619e = "onUploadTaskStateChange";

    /* renamed from: f */
    private static final String f16620f = "onDownloadTaskStateChange";

    /* renamed from: a */
    NetworkService f16621a;

    /* renamed from: b */
    DMSandboxHelper f16622b;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final DMMina f16623g;

    /* renamed from: h */
    private final String f16624h;

    /* renamed from: i */
    private final NetWorkStateReceiver.NetWorkStateListener f16625i = new NetWorkStateReceiver.NetWorkStateListener() {
        public void onNetworkChange() {
            try {
                FragmentActivity activity = NetworkSubJSBridge.this.f16623g.getActivity();
                if (activity != null) {
                    String access$100 = NetworkStatus.getNetworkType(activity);
                    boolean access$300 = NetworkStatus.isAvailable(activity);
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "isConnected", access$300);
                    JSONUtil.put(jSONObject, "networkType", (Object) access$100);
                    NetworkSubJSBridge.this.f16623g.getMessageTransfer().sendMessageToServiceFromNative(InternalJSMethod.ON_NETWORK_STATUS_CHANGE, new MessageWrapperBuilder().data(jSONObject).build());
                    LogUtil.iRelease(NetworkSubJSBridge.f16617c, "networkType = " + access$100);
                }
            } catch (Exception e) {
                LogUtil.iRelease(InternalJSMethod.ON_NETWORK_STATUS_CHANGE, e.toString());
            }
        }
    };

    private interface NetworkType {
        public static final String TYPE_2G = "2g";
        public static final String TYPE_3G = "3g";
        public static final String TYPE_4G = "4g";
        public static final String TYPE_5G = "5g";
        public static final String TYPE_NONE = "none";
        public static final String TYPE_UNKNOWN = "unknown";
        public static final String TYPE_WIFI = "wifi";
    }

    public NetworkSubJSBridge(DMMina dMMina) {
        this.f16623g = dMMina;
        this.f16621a = Dimina.getConfig().getAdapterConfig().getHttpService();
        this.f16622b = new DMSandboxHelper(this.f16623g.getConfig());
        this.f16624h = m12251a();
        listenNetworkStatusChange();
        LogUtil.m13411i("NetworkSubJSBridge init");
    }

    public void createRequestTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        final String optString = jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("taskId 不能为空", callbackFunction);
            return;
        }
        this.f16621a.createRequestTask(optString, m12256b(jSONObject.optJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DMWebSocketListener.KEY_ERR_MSG, exc.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16618d, new ResponseBuilder().setTaskId(optString).setState("fail").setData(jSONObject).build());
            }

            public void onSuccess(JSONObject jSONObject) {
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16618d, new ResponseBuilder().setTaskId(optString).setState("success").setData(jSONObject).setHeader(jSONObject.optJSONObject("header")).build());
            }
        });
        CallBackUtil.onSuccess(new JSONObject(), callbackFunction);
    }

    public void operateRequestTask(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        this.f16621a.operateRequestTask(jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, ""), jSONObject.optString("operationType", ""), jSONObject.optJSONObject("extra"), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }
        });
    }

    @Deprecated
    public void request(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        this.f16621a.request(m12256b(jSONObject), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }
        });
    }

    public void createUploadTask(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        final String optString = jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("taskId 不能为空", callbackFunction);
            return;
        }
        this.f16621a.createUploadTask(optString, m12257c(jSONObject.optJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DMWebSocketListener.KEY_ERR_MSG, exc.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16619e, new ResponseBuilder().setTaskId(optString).setState("fail").setData(jSONObject).build());
            }

            public void onSuccess(JSONObject jSONObject) {
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16619e, new ResponseBuilder().setTaskId(optString).setState("success").setData(jSONObject).setHeader(jSONObject.optJSONObject("header")).build());
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }

            public void onProgressUpdate(long j, float f) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("progress", (int) ((((float) j) / f) * 100.0f));
                    jSONObject.put("totalBytesWritten", j);
                    jSONObject.put("totalBytesExpectedToWrite", (double) f);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16619e, new ResponseBuilder().setTaskId(optString).setState(ResponseBuilder.STATE_PROGRESS_UPDATE).setData(jSONObject).build());
            }
        });
        CallBackUtil.onSuccess(new JSONObject(), callbackFunction);
    }

    public void operateUploadTask(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        this.f16621a.operateUploadTask(jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, ""), jSONObject.optString("operationType", ""), jSONObject.optJSONObject("extra"), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }
        });
    }

    @Deprecated
    public void uploadFile(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        this.f16621a.uploadFile(m12257c(jSONObject), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "data", (Object) jSONObject.optString("data"));
                JSONUtil.put(jSONObject2, "statusCode", jSONObject.optInt("statusCode"));
                CallBackUtil.onSuccess(jSONObject2, callbackFunction);
            }
        });
    }

    public void createDownloadTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        final String optString = jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("taskId 不能为空", callbackFunction);
            return;
        }
        final JSONObject optJSONObject = jSONObject.optJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        final NetworkService.NetworkTaskModel.Download d = m12258d(optJSONObject);
        this.f16621a.createDownloadTask(optString, d, new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DMWebSocketListener.KEY_ERR_MSG, exc.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16620f, new ResponseBuilder().setTaskId(optString).setState("fail").setData(jSONObject).build());
            }

            public void onSuccess(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                if (TextUtil.isEmpty(optJSONObject.optString(FlutterShareMethod.filePathKey))) {
                    JSONUtil.put(jSONObject2, "tempFilePath", (Object) NetworkSubJSBridge.this.f16622b.filepath2url(d.filePath));
                } else {
                    JSONUtil.put(jSONObject2, FlutterShareMethod.filePathKey, (Object) NetworkSubJSBridge.this.f16622b.filepath2url(jSONObject.optString(FlutterShareMethod.filePathKey)));
                }
                JSONUtil.put(jSONObject2, "statusCode", jSONObject.optInt("statusCode"));
                JSONUtil.put(jSONObject2, Scopes.PROFILE, jSONObject.optLong(Scopes.PROFILE));
                NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16620f, new ResponseBuilder().setTaskId(optString).setState("success").setData(jSONObject2).setHeader(jSONObject.optJSONObject("header")).build());
            }

            public void onProgressUpdate(long j, float f) {
                if (j != -1 && f != -1.0f) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("progress", (int) ((((float) j) / f) * 100.0f));
                        jSONObject.put("totalBytesWritten", j);
                        jSONObject.put("totalBytesExpectedToWrite", (double) f);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    NetworkSubJSBridge.this.m12255a(NetworkSubJSBridge.f16620f, new ResponseBuilder().setTaskId(optString).setState(ResponseBuilder.STATE_PROGRESS_UPDATE).setData(jSONObject).build());
                }
            }
        });
        CallBackUtil.onSuccess(new JSONObject(), callbackFunction);
    }

    public void operateDownloadTask(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        this.f16621a.operateDownloadTask(jSONObject.optString(DMWebSocketListener.KEY_TASK_ID, ""), jSONObject.optString("operationType", ""), jSONObject.optJSONObject("extra"), new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }
        });
    }

    @Deprecated
    public void downloadFile(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        final NetworkService.NetworkTaskModel.Download d = m12258d(jSONObject);
        this.f16621a.downloadFile(d, new NetworkService.ITaskCallback() {
            public void onFailure(Exception exc) {
                CallBackUtil.onFail(exc.getMessage(), callbackFunction);
            }

            public void onSuccess(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                if (TextUtil.isEmpty(jSONObject.optString(FlutterShareMethod.filePathKey))) {
                    JSONUtil.put(jSONObject2, "tempFilePath", (Object) NetworkSubJSBridge.this.f16622b.filepath2url(d.filePath));
                } else {
                    JSONUtil.put(jSONObject2, FlutterShareMethod.filePathKey, (Object) NetworkSubJSBridge.this.f16622b.filepath2url(jSONObject.optString(FlutterShareMethod.filePathKey)));
                }
                JSONUtil.put(jSONObject2, "statusCode", jSONObject.optInt("statusCode"));
                JSONUtil.put(jSONObject2, Scopes.PROFILE, jSONObject.optLong(Scopes.PROFILE));
                CallBackUtil.onSuccess(jSONObject2, callbackFunction);
            }
        });
    }

    public void listenNetworkStatusChange() {
        NetWorkStateReceiver.getInstance().registerNetworkState(this.f16625i);
    }

    public void getNetworkType(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            String access$100 = NetworkStatus.getNetworkType(this.f16623g.getActivity());
            HashMap hashMap = new HashMap();
            hashMap.put("networkType", access$100);
            CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
            LogUtil.iRelease(f16617c, "networkType = " + access$100);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail("获取网络类型失败", callbackFunction);
        }
    }

    /* renamed from: a */
    private String m12251a() {
        String appId = this.f16623g.getConfig().getLaunchConfig().getAppId();
        String str = "0";
        if (TextUtils.isEmpty(appId)) {
            appId = "devtools";
        } else {
            try {
                AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this.f16623g, "app");
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.version)) {
                    str = appPackageInfo.version;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.format(DomainComplianceUtil.getHttpsColonDoubleSlash() + "servicedimina.com/%s/%s/page-frame.html", new Object[]{appId, str});
    }

    public void onDestroy() {
        NetWorkStateReceiver.getInstance().unregisterNetworkState(this.f16625i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12255a(String str, JSONObject jSONObject) {
        DMMina dMMina;
        if (!TextUtils.isEmpty(str) && jSONObject != null && (dMMina = this.f16623g) != null && dMMina.getMessageTransfer() != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                this.f16623g.getMessageTransfer().sendMessageToServiceFromNative(str, jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private Map<String, Object> m12253a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            hashMap.put(valueOf, jSONObject.opt(valueOf));
        }
        return hashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.data = com.didi.dimina.container.util.HttpUtil.parseQuery(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.data = com.didi.dimina.container.util.HttpUtil.parseQuery(r2);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0095 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x004a=Splitter:B:11:0x004a, B:23:0x007c=Splitter:B:23:0x007c} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didi.dimina.container.service.NetworkService.NetworkTaskModel.Request m12256b(org.json.JSONObject r6) {
        /*
            r5 = this;
            com.didi.dimina.container.service.NetworkService$NetworkTaskModel$Request r0 = new com.didi.dimina.container.service.NetworkService$NetworkTaskModel$Request
            r0.<init>()
            java.lang.String r1 = "url"
            java.lang.String r1 = r6.optString(r1)
            r0.url = r1
            java.lang.String r1 = "method"
            java.lang.String r1 = r6.optString(r1)
            r0.method = r1
            java.lang.String r1 = "dataType"
            java.lang.String r1 = r6.optString(r1)
            r0.dataType = r1
            java.lang.String r1 = "data"
            org.json.JSONObject r2 = r6.optJSONObject(r1)
            if (r2 == 0) goto L_0x002d
            java.util.Map r1 = r5.m12253a((org.json.JSONObject) r2)
            r0.data = r1
            goto L_0x00b8
        L_0x002d:
            org.json.JSONArray r2 = r6.optJSONArray(r1)
            if (r2 == 0) goto L_0x0037
            r0.data2 = r2
            goto L_0x00b8
        L_0x0037:
            java.lang.String r2 = r6.optString(r1)     // Catch:{ Exception -> 0x00a3 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a3 }
            r4 = 0
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "{"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x00a3 }
            if (r3 == 0) goto L_0x006a
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0063 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0063 }
            boolean r4 = r3.equals(r4)     // Catch:{ JSONException -> 0x0063 }
            if (r4 != 0) goto L_0x005c
            java.util.Map r3 = r5.m12253a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0063 }
            r0.data = r3     // Catch:{ JSONException -> 0x0063 }
            goto L_0x00aa
        L_0x005c:
            java.util.Map r3 = com.didi.dimina.container.util.HttpUtil.parseQuery(r2)     // Catch:{ JSONException -> 0x0063 }
            r0.data = r3     // Catch:{ JSONException -> 0x0063 }
            goto L_0x00aa
        L_0x0063:
            java.util.Map r2 = com.didi.dimina.container.util.HttpUtil.parseQuery(r2)     // Catch:{ Exception -> 0x00a3 }
            r0.data = r2     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00aa
        L_0x006a:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a3 }
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = "%7B"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x00a3 }
            if (r3 == 0) goto L_0x009c
            java.lang.String r2 = com.didi.dimina.container.util.HttpUtil.decode(r2)     // Catch:{ Exception -> 0x00a3 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0095 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x0095 }
            boolean r4 = r3.equals(r4)     // Catch:{ JSONException -> 0x0095 }
            if (r4 != 0) goto L_0x008e
            java.util.Map r3 = r5.m12253a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0095 }
            r0.data = r3     // Catch:{ JSONException -> 0x0095 }
            goto L_0x00aa
        L_0x008e:
            java.util.Map r3 = com.didi.dimina.container.util.HttpUtil.parseQuery(r2)     // Catch:{ JSONException -> 0x0095 }
            r0.data = r3     // Catch:{ JSONException -> 0x0095 }
            goto L_0x00aa
        L_0x0095:
            java.util.Map r2 = com.didi.dimina.container.util.HttpUtil.parseQuery(r2)     // Catch:{ Exception -> 0x00a3 }
            r0.data = r2     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00aa
        L_0x009c:
            java.util.Map r2 = com.didi.dimina.container.util.HttpUtil.parseQuery(r2)     // Catch:{ Exception -> 0x00a3 }
            r0.data = r2     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00aa
        L_0x00a3:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.data = r2
        L_0x00aa:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r0.data
            int r2 = r2.size()
            if (r2 != 0) goto L_0x00b8
            java.lang.Object r1 = r6.opt(r1)
            r0.data2 = r1
        L_0x00b8:
            java.lang.String r1 = "header"
            org.json.JSONObject r6 = r6.optJSONObject(r1)
            if (r6 == 0) goto L_0x00ee
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Iterator r2 = r6.keys()
        L_0x00c9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00df
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = r6.optString(r3)
            r1.put(r3, r4)
            goto L_0x00c9
        L_0x00df:
            java.lang.String r6 = "referer"
            boolean r2 = r1.containsKey(r6)
            if (r2 != 0) goto L_0x00ec
            java.lang.String r2 = r5.f16624h
            r1.put(r6, r2)
        L_0x00ec:
            r0.headers = r1
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.NetworkSubJSBridge.m12256b(org.json.JSONObject):com.didi.dimina.container.service.NetworkService$NetworkTaskModel$Request");
    }

    /* renamed from: c */
    private NetworkService.NetworkTaskModel.Upload m12257c(JSONObject jSONObject) {
        NetworkService.NetworkTaskModel.Upload upload = new NetworkService.NetworkTaskModel.Upload();
        upload.filePath = this.f16622b.url2filepath(jSONObject.optString(FlutterShareMethod.filePathKey));
        upload.fileName = jSONObject.optString("name");
        upload.url = jSONObject.optString("url");
        upload.timeout = jSONObject.optLong("timeout");
        upload.formData = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("formData");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                upload.formData.put(next, optJSONObject.optString(next));
            }
        }
        upload.headers = new HashMap();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                upload.headers.put(next2, optJSONObject2.optString(next2));
            }
        }
        if (!upload.headers.containsKey("referer")) {
            upload.headers.put("referer", this.f16624h);
        }
        return upload;
    }

    /* renamed from: d */
    private NetworkService.NetworkTaskModel.Download m12258d(JSONObject jSONObject) {
        NetworkService.NetworkTaskModel.Download download = new NetworkService.NetworkTaskModel.Download();
        download.url = jSONObject.optString("url");
        download.filePath = jSONObject.optString(FlutterShareMethod.filePathKey);
        download.timeout = jSONObject.optLong("timeout");
        if (TextUtil.isEmpty(download.filePath)) {
            download.filePath = m12252a(download.url);
        } else {
            download.filePath = this.f16622b.url2filepath(download.filePath);
        }
        download.headers = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                download.headers.put(next, optJSONObject.optString(next));
            }
        }
        if (!download.headers.containsKey("referer")) {
            download.headers.put("referer", this.f16624h);
        }
        return download;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m12252a(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = "\\."
            java.lang.String r2 = ""
            r3 = 1
            if (r0 != 0) goto L_0x002d
            java.lang.String r0 = "http"
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L_0x002d
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0028 }
            r0.<init>(r6)     // Catch:{ MalformedURLException -> 0x0028 }
            java.lang.String r0 = r0.getPath()     // Catch:{ MalformedURLException -> 0x0028 }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ MalformedURLException -> 0x0028 }
            int r1 = r0.length     // Catch:{ MalformedURLException -> 0x0028 }
            if (r1 <= r3) goto L_0x0039
            int r1 = r0.length     // Catch:{ MalformedURLException -> 0x0028 }
            int r1 = r1 - r3
            r0 = r0[r1]     // Catch:{ MalformedURLException -> 0x0028 }
            goto L_0x003a
        L_0x0028:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0039
        L_0x002d:
            java.lang.String[] r0 = r6.split(r1)     // Catch:{ Exception -> 0x0039 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0039 }
            if (r1 <= r3) goto L_0x0039
            int r1 = r0.length     // Catch:{ Exception -> 0x0039 }
            int r1 = r1 - r3
            r0 = r0[r1]     // Catch:{ Exception -> 0x0039 }
            goto L_0x003a
        L_0x0039:
            r0 = r2
        L_0x003a:
            java.lang.String r6 = com.didi.dimina.container.util.MD5Util.md5(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r6 = "."
            r1.append(r6)
            r1.append(r0)
            java.lang.String r6 = r1.toString()
        L_0x0058:
            com.didi.dimina.container.mina.DMSandboxHelper r0 = r5.f16622b
            java.lang.String r0 = r0.getSandboxTmpDir()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0081
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0081
            r1 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            boolean r1 = com.didi.dimina.container.util.FileUtil.exists(r1, r3)
            if (r1 != 0) goto L_0x0077
            goto L_0x0081
        L_0x0077:
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r6)
            java.lang.String r6 = r1.getAbsolutePath()
            return r6
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.NetworkSubJSBridge.m12252a(java.lang.String):java.lang.String");
    }

    private static class NetworkStatus {
        private NetworkStatus() {
        }

        /* access modifiers changed from: private */
        public static String getNetworkType(Context context) {
            TelephonyManager telephonyManager;
            if (!isAvailable(context)) {
                return "none";
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                if (typeName.equalsIgnoreCase("WIFI")) {
                    return "wifi";
                }
                if (!typeName.equalsIgnoreCase("MOBILE") || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                    return "unknown";
                }
                int networkType = telephonyManager.getNetworkType();
                if (networkType == 18) {
                    return NetworkType.TYPE_4G;
                }
                if (networkType == 20) {
                    return NetworkType.TYPE_5G;
                }
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return NetworkType.TYPE_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return NetworkType.TYPE_3G;
                    case 13:
                        return NetworkType.TYPE_4G;
                    default:
                        return "unknown";
                }
            }
            return "unknown";
        }

        /* access modifiers changed from: private */
        public static boolean isAvailable(Context context) {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        }
    }

    public static class ResponseBuilder {
        public static final String STATE_FAIL = "fail";
        public static final String STATE_PROGRESS_UPDATE = "progressUpdate";
        public static final String STATE_SUCCESS = "success";
        private JSONObject data;
        private JSONObject header;
        private String state;
        private String taskId;

        public ResponseBuilder setTaskId(String str) {
            this.taskId = str;
            return this;
        }

        public ResponseBuilder setState(String str) {
            this.state = str;
            return this;
        }

        public ResponseBuilder setData(JSONObject jSONObject) {
            this.data = jSONObject;
            return this;
        }

        public ResponseBuilder setHeader(JSONObject jSONObject) {
            this.header = jSONObject;
            return this;
        }

        public JSONObject build() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.taskId)) {
                    jSONObject.put(DMWebSocketListener.KEY_TASK_ID, this.taskId);
                    if (!TextUtils.isEmpty(this.state)) {
                        jSONObject.put("state", this.state);
                    }
                    if (this.data != null) {
                        jSONObject.put("data", this.data);
                        if ("success".equals(this.state)) {
                            this.data.put(Scopes.PROFILE, new JSONObject());
                        }
                    }
                    if (this.header != null) {
                        jSONObject.put("header", this.header);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
