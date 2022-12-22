package com.didi.sdk.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.utils.TimeUtil;
import com.didi.sdk.push.log.ConnEvent;
import com.didi.sdk.push.log.LoadErrorEvent;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.log.RequestEvent;
import com.didi.sdk.push.log.TransactionEvent;
import com.didi.sdk.push.proxy.LogupBindListener;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Transportation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseLogUploadHandler extends LogEventAdapter implements LogupBindListener {
    private static final String CERT = "asset://mobilenet.crt";
    private static final int LOG_CACHE_MAX_COUNT = 5;
    private static final int LOG_CACHE_MAX_DELAY = 2000;
    private static final String LOG_TEXT_SEPARATOR = "\\n";
    private static final int RESULT_CLOSE_UPLOAD = -2;
    /* access modifiers changed from: private */
    public static final String TAG = BaseLogUploadHandler.class.getSimpleName();
    private static final String TOGGLE_PREFERENCE_IP = "target_ip";
    private static final String TOGGLE_PREFERENCE_NAME = "log2web";
    private static final String TOGGLE_PREFERENCE_WS = "target_ws";
    /* access modifiers changed from: private */
    public AtomicBoolean busy = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AtomicInteger count = new AtomicInteger(0);
    private boolean hasPeek;
    private String mTargetIp;
    private String mTargetWs;
    /* access modifiers changed from: private */
    public final Queue<String> queue = new LinkedList();
    private Timer timer = new Timer();

    @Transportation(cert = "asset://mobilenet.crt")
    @Path("/")
    interface LogBindService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/mobilebind")
        @Deserialization(GsonDeserializer.class)
        void mobileBind(@QueryParameter("ws_id") String str, @QueryParameter("mobile_uid") String str2, @TargetThread(ThreadType.MAIN) RpcService.Callback<Result> callback);
    }

    @Transportation(cert = "asset://mobilenet.crt")
    @Path("/")
    interface LogUploadService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/uplog")
        @Post
        @Deserialization(GsonDeserializer.class)
        void upload(@BodyParameter("targetWs") String str, @BodyParameter("log") String str2, @TargetThread(ThreadType.MAIN) RpcService.Callback<Result> callback);
    }

    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
    }

    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
    }

    public void onPushRequest(RequestEvent requestEvent) {
    }

    public void onTrackConnection(ConnEvent connEvent) {
    }

    public void onTrackTransaction(TransactionEvent transactionEvent) {
    }

    public BaseLogUploadHandler() {
        PushLog.m26280d(TAG, "BaseLogUploadHandler create()");
    }

    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
        if (PushClient.getClient().getOption() != null && PushClient.getClient().getOption().getContext() != null) {
            Context context = PushClient.getClient().getOption().getContext();
            if (validate(this.mTargetIp, this.mTargetWs) || (!this.hasPeek && getToggleFromLocal(context))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtil.YMD_HMSS);
                readyUpload(context, this.mTargetIp, this.mTargetWs, simpleDateFormat.format(new Date(System.currentTimeMillis())) + " " + nativeLogEvent.getMsg());
            }
        }
    }

    private boolean validate(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !"https".equals(new URL(str).getProtocol())) {
                return false;
            }
            return true;
        } catch (MalformedURLException e) {
            PushLog.m26280d(TAG, e.toString());
            return false;
        }
    }

    public void onBind(Context context, Uri uri) {
        String queryParameter = uri.getQueryParameter(TOGGLE_PREFERENCE_IP);
        String queryParameter2 = uri.getQueryParameter(TOGGLE_PREFERENCE_WS);
        PushLog.m26280d(TAG, String.format("target_ip=[%s], target_ws=[%s]", new Object[]{queryParameter, queryParameter2}));
        if (validate(queryParameter, queryParameter2)) {
            saveToggleToLocal(context, queryParameter, queryParameter2);
            ((LogBindService) new RpcServiceFactory(context).newRpcService(LogBindService.class, queryParameter)).mobileBind(queryParameter2, "", new RpcService.Callback<Result>() {
                public void onSuccess(Result result) {
                    String access$000 = BaseLogUploadHandler.TAG;
                    PushLog.m26282e(access$000, "mobileBind result =>" + result.toString());
                }

                public void onFailure(IOException iOException) {
                    String access$000 = BaseLogUploadHandler.TAG;
                    PushLog.m26282e(access$000, "mobileBind IOException => " + iOException.toString());
                }
            });
        }
    }

    private boolean getToggleFromLocal(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, TOGGLE_PREFERENCE_NAME, 0);
        this.mTargetIp = sharedPreferences.getString(TOGGLE_PREFERENCE_IP, "");
        this.mTargetWs = sharedPreferences.getString(TOGGLE_PREFERENCE_WS, "");
        this.hasPeek = true;
        String str = TAG;
        PushLog.m26284i(str, "getToggleFromLocal => target_ip:" + this.mTargetIp + ", target_ws:" + this.mTargetWs);
        return validate(this.mTargetIp, this.mTargetWs);
    }

    static void saveToggleToLocal(Context context, String str, String str2) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, TOGGLE_PREFERENCE_NAME, 0).edit();
        edit.putString(TOGGLE_PREFERENCE_IP, str);
        edit.putString(TOGGLE_PREFERENCE_WS, str2);
        edit.commit();
        String str3 = TAG;
        PushLog.m26284i(str3, "saveToggleToLocal => target_ip:" + str + ", target_ws:" + str2);
    }

    /* access modifiers changed from: private */
    public void clearToggleFile(Context context) {
        this.mTargetIp = null;
        this.mTargetWs = null;
        saveToggleToLocal(context, (String) null, (String) null);
        PushLog.m26284i(TAG, "clearToggleFile");
    }

    private void readyUpload(final Context context, final String str, final String str2, String str3) {
        synchronized (this.queue) {
            this.queue.offer(str3);
        }
        if (this.count.incrementAndGet() >= 5) {
            String str4 = TAG;
            PushLog.m26284i(str4, "doUpload(count>=5) => count:" + this.count.get() + ", queue.size:" + this.queue.size());
            doUpload(context, str, str2);
            AtomicInteger atomicInteger = this.count;
            atomicInteger.compareAndSet(atomicInteger.get(), 0);
        } else if (!this.busy.get()) {
            String str5 = TAG;
            PushLog.m26284i(str5, "readyUpload(timer.schedule) => count:" + this.count.get() + ", queue.size:" + this.queue.size());
            this.timer.schedule(new TimerTask() {
                public void run() {
                    BaseLogUploadHandler.this.busy.getAndSet(false);
                    if (!BaseLogUploadHandler.this.queue.isEmpty()) {
                        String access$000 = BaseLogUploadHandler.TAG;
                        PushLog.m26284i(access$000, "doUpload(timer.schedule) => count:" + BaseLogUploadHandler.this.count.get() + ", queue.size:" + BaseLogUploadHandler.this.queue.size());
                        BaseLogUploadHandler.this.doUpload(context, str, str2);
                        BaseLogUploadHandler.this.count.compareAndSet(BaseLogUploadHandler.this.count.get(), 0);
                    }
                }
            }, 2000);
            this.busy.getAndSet(true);
        }
    }

    /* access modifiers changed from: private */
    public void doUpload(final Context context, String str, String str2) {
        LogUploadService logUploadService = (LogUploadService) new RpcServiceFactory(context).newRpcService(LogUploadService.class, str);
        StringBuilder sb = new StringBuilder();
        synchronized (this.queue) {
            while (!this.queue.isEmpty()) {
                sb.append(this.queue.poll());
                sb.append(LOG_TEXT_SEPARATOR);
            }
        }
        logUploadService.upload(str2, sb.toString(), new RpcService.Callback<Result>() {
            public void onSuccess(Result result) {
                PushLog.m26284i(BaseLogUploadHandler.TAG, result.toString());
                if (result.errno == -2) {
                    BaseLogUploadHandler.this.clearToggleFile(context);
                }
            }

            public void onFailure(IOException iOException) {
                String access$000 = BaseLogUploadHandler.TAG;
                PushLog.m26282e(access$000, "IOException -> " + iOException.toString());
            }
        });
    }

    class Result {
        String errmsg;
        int errno;

        Result() {
        }

        public String toString() {
            return "Result{errno=" + this.errno + " & errmsg='" + this.errmsg + "'" + '}';
        }
    }
}
