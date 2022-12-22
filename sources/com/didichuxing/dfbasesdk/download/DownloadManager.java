package com.didichuxing.dfbasesdk.download;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.File;

@Deprecated
public class DownloadManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Handler f46574a = new Handler(Looper.getMainLooper());

    public static class Param {
        public String directory;
        public String fileName;
        public int fileSize = -1;
        public int retryDelayInMills = 3000;
        public int retryTime = 0;
        public int timeoutInMills = 0;
        public String url;
    }

    @Deprecated
    public static void download(Context context, String str, String str2, String str3, IDownloadListener iDownloadListener) {
        download(context, iDownloadListener, new ParamBuilder().setUrl(str).setDirectory(str2).setFileName(str3).setTimeoutInMills(10000).build());
    }

    @Deprecated
    public static void download(Context context, String str, int i, String str2, String str3, int i2, IDownloadListener iDownloadListener) {
        download(context, iDownloadListener, new ParamBuilder().setUrl(str).setDirectory(str2).setFileName(str3).setFileSize(i).setTimeoutInMills(i2).build());
    }

    public static void download(Context context, final IDownloadListener iDownloadListener, Param param) {
        final BooleanHolder booleanHolder = new BooleanHolder();
        C152851 r1 = new Runnable() {
            public void run() {
                if (!booleanHolder.get()) {
                    booleanHolder.set(true);
                    IDownloadListener iDownloadListener = iDownloadListener;
                    if (iDownloadListener != null) {
                        iDownloadListener.failed(new Exception("time out!!"));
                    }
                }
            }
        };
        if (param.timeoutInMills > 0) {
            f46574a.postDelayed(r1, (long) param.timeoutInMills);
        }
        m33422b(context, iDownloadListener, param, booleanHolder, r1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33422b(Context context, IDownloadListener iDownloadListener, Param param, BooleanHolder booleanHolder, Runnable runnable) {
        Param param2 = param;
        try {
            new File(param2.directory, param2.fileName).delete();
            Context context2 = context;
            try {
                RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context);
                Uri parse = Uri.parse(param2.url);
                final BooleanHolder booleanHolder2 = booleanHolder;
                final Runnable runnable2 = runnable;
                final IDownloadListener iDownloadListener2 = iDownloadListener;
                final Context context3 = context;
                final Param param3 = param;
                ((HttpRpcClient) rpcServiceFactory.getRpcClient(parse != null ? parse.getScheme() : "http")).newRpc(new HttpRpcRequest.Builder().get(param2.url).build()).enqueue(new DownloadCallBack(param2.url, param2.fileSize, param2.directory, param2.fileName, new IDownloadListener() {
                    public void success(String str, String str2) {
                        if (!booleanHolder2.get()) {
                            booleanHolder2.set(true);
                            DownloadManager.f46574a.removeCallbacks(runnable2);
                            IDownloadListener iDownloadListener = iDownloadListener2;
                            if (iDownloadListener != null) {
                                iDownloadListener.success(str, str2);
                            }
                        }
                    }

                    public void progress(int i) {
                        IDownloadListener iDownloadListener;
                        if (!booleanHolder2.get() && (iDownloadListener = iDownloadListener2) != null) {
                            iDownloadListener.progress(i);
                        }
                    }

                    public void failed(Exception exc) {
                        DownloadManager.m33423b(context3, iDownloadListener2, param3, booleanHolder2, runnable2, exc);
                    }
                }));
            } catch (Exception e) {
                e = e;
                m33423b(context, iDownloadListener, param, booleanHolder, runnable, e);
            }
        } catch (Exception e2) {
            e = e2;
            Context context4 = context;
            m33423b(context, iDownloadListener, param, booleanHolder, runnable, e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33423b(Context context, IDownloadListener iDownloadListener, Param param, BooleanHolder booleanHolder, Runnable runnable, Exception exc) {
        if (!booleanHolder.get()) {
            if (param.retryTime > 0) {
                param.retryTime--;
                final BooleanHolder booleanHolder2 = booleanHolder;
                final Context context2 = context;
                final IDownloadListener iDownloadListener2 = iDownloadListener;
                final Param param2 = param;
                final Runnable runnable2 = runnable;
                f46574a.postDelayed(new Runnable() {
                    public void run() {
                        if (!booleanHolder2.get()) {
                            DownloadManager.m33422b(context2, iDownloadListener2, param2, booleanHolder2, runnable2);
                        }
                    }
                }, (long) param.retryDelayInMills);
                return;
            }
            booleanHolder.set(true);
            f46574a.removeCallbacks(runnable);
            if (iDownloadListener != null) {
                iDownloadListener.failed(exc);
            }
        }
    }

    private static class BooleanHolder {
        boolean value;

        private BooleanHolder() {
            this.value = false;
        }

        public void set(boolean z) {
            this.value = z;
        }

        public boolean get() {
            return this.value;
        }
    }

    public static class ParamBuilder {
        private Param param = new Param();

        public Param build() {
            return this.param;
        }

        public ParamBuilder setUrl(String str) {
            this.param.url = str;
            return this;
        }

        public ParamBuilder setFileSize(int i) {
            this.param.fileSize = i;
            return this;
        }

        public ParamBuilder setDirectory(String str) {
            this.param.directory = str;
            return this;
        }

        public ParamBuilder setFileName(String str) {
            this.param.fileName = str;
            return this;
        }

        public ParamBuilder setTimeoutInMills(int i) {
            this.param.timeoutInMills = i;
            return this;
        }

        public ParamBuilder setRetryTime(int i) {
            this.param.retryTime = i;
            return this;
        }

        public ParamBuilder setRetryDelayInMills(int i) {
            this.param.retryDelayInMills = i;
            return this;
        }
    }
}
