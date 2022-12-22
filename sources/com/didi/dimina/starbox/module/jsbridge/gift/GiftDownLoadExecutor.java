package com.didi.dimina.starbox.module.jsbridge.gift;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.module.StarBoxDockerActivity;
import com.didi.dimina.starbox.module.jsbridge.bean.GiftBean;
import global.didi.pay.newview.pix.IPixView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.osgi.framework.AdminPermission;

public abstract class GiftDownLoadExecutor {
    /* access modifiers changed from: private */
    public String GIFT_PCK_BASIC;
    private final Context application;
    private ExecutorService executorService;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Interceptor> interceptors;
    private Handler mHandler;

    public abstract void onComplete();

    public abstract void onFail(String str);

    public abstract void onStart();

    public abstract <T> void onSuccess(T t);

    public GiftDownLoadExecutor(Context context) {
        this.application = context.getApplicationContext();
    }

    public GiftDownLoadExecutor execute(String str) {
        try {
            if (!str.contains("newCode")) {
                onDestroy();
                init();
                onStart();
                onNext(str);
            } else {
                onDestroy();
                initNew();
                onStart();
                onNextNew(str);
            }
        } catch (Exception e) {
            LogUtil.m13408d("=GiftDownLoadExecutor=", "execute: " + e.getMessage());
            onFail(e.getMessage());
            onDestroy();
        }
        return this;
    }

    private void initNew() {
        LogUtil.m13408d("=GiftDownLoadExecutor=", "initNew");
        String str = PmFileUtil.getInternalFilesDirectory(this.application, "").toString() + File.separator + StarBoxDockerActivity.VALUE_DEV_MODE_GIFT + File.separator;
        this.GIFT_PCK_BASIC = str;
        PmFileUtil.mkdirs(str);
        if (this.mHandler == null) {
            this.mHandler = new MyHandler(this, this.application);
        }
        if (this.interceptors == null) {
            this.interceptors = new ConcurrentHashMap<>();
        }
        this.interceptors.clear();
        this.interceptors.put("NewUrlInterceptor", new NewUrlInterceptor());
        this.interceptors.put("FileDownloadInterceptor-Dev", new FileDownloadInterceptor());
        this.interceptors.put("FileDownloadInterceptor-Build", new FileDownloadInterceptor());
    }

    private void onNextNew(String str) throws Exception {
        ConcurrentHashMap<String, Interceptor> concurrentHashMap;
        LogUtil.m13408d("=GiftDownLoadExecutor=", "onNextNew");
        if (this.mHandler == null || (concurrentHashMap = this.interceptors) == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(this.GIFT_PCK_BASIC)) {
            throw new Exception("初始化失败！");
        }
        if (this.executorService == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        }
        this.executorService.execute(getTaskNew(str));
    }

    private Runnable getTaskNew(String str) {
        return new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GiftDownLoadExecutor.this.lambda$getTaskNew$0$GiftDownLoadExecutor(this.f$1);
            }
        };
    }

    public /* synthetic */ void lambda$getTaskNew$0$GiftDownLoadExecutor(String str) {
        InterceptorResult interceptorResult = new InterceptorResult();
        LogUtil.m13408d("=GiftDownLoadExecutor=", AdminPermission.EXECUTE);
        try {
            InterceptorResult onExecute = this.interceptors.get("NewUrlInterceptor").onExecute(str);
            LogUtil.m13408d("=GiftDownLoadExecutor=", "urlResult: " + onExecute.toString());
            T t = (GiftBean) onExecute.data;
            String str2 = this.GIFT_PCK_BASIC + t.getAppId() + File.separator + "build" + File.separator + t.getJssdkversion() + File.separator + t.getEnv() + File.separator + t.getVersionId() + File.separator;
            t.setFilePath(str2);
            String[] listDirFiles = FileUtil.listDirFiles(str2);
            if (listDirFiles == null || listDirFiles.length <= 0) {
                PmFileUtil.deleteFile(str2);
                PmFileUtil.mkdirs(str2);
                HashMap hashMap = new HashMap();
                hashMap.put("downUrl", t.getSdkUrl());
                hashMap.put("dirPath", str2);
                hashMap.put("zipFilePath", str2 + "temp.zip");
                InterceptorResult onExecute2 = this.interceptors.get("FileDownloadInterceptor-Dev").onExecute(hashMap);
                LogUtil.m13408d("=GiftDownLoadExecutor=", "devResult: " + onExecute2.toString());
                printFileInfo(str2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("downUrl", t.getAppUrl());
                hashMap2.put("dirPath", str2);
                hashMap2.put("zipFilePath", str2 + PmFileConstant.ZIP_SUFFIX);
                InterceptorResult onExecute3 = this.interceptors.get("FileDownloadInterceptor-Build").onExecute(hashMap2);
                LogUtil.m13408d("=GiftDownLoadExecutor=", "buildResult: " + onExecute3.toString());
                printFileInfo(str2);
                interceptorResult.data = t;
                interceptorResult.dCode = 1;
                sendMsg(interceptorResult);
                interceptorResult.dCode = 3;
                sendMsg(interceptorResult);
                return;
            }
            interceptorResult.data = t;
            interceptorResult.dCode = 1;
            sendMsg(interceptorResult);
            interceptorResult.dCode = 3;
            sendMsg(interceptorResult);
        } catch (Exception e) {
            interceptorResult.dCode = 2;
            interceptorResult.message = e.getMessage();
            sendMsg(interceptorResult);
            e.printStackTrace();
        } catch (Throwable th) {
            interceptorResult.dCode = 3;
            sendMsg(interceptorResult);
            throw th;
        }
    }

    private void init() {
        LogUtil.m13408d("=GiftDownLoadExecutor=", IPixView.PAGE_STATUS_INIT);
        String str = PmFileUtil.getInternalFilesDirectory(this.application, "").toString() + File.separator + StarBoxDockerActivity.VALUE_DEV_MODE_GIFT + File.separator;
        this.GIFT_PCK_BASIC = str;
        PmFileUtil.mkdirs(str);
        if (this.mHandler == null) {
            this.mHandler = new MyHandler(this, this.application);
        }
        if (this.interceptors == null) {
            this.interceptors = new ConcurrentHashMap<>();
        }
        this.interceptors.clear();
        this.interceptors.put(UrlInterceptor.TAG, new UrlInterceptor());
        this.interceptors.put("JsSdkListNetInterceptor", new JsSdkListNetInterceptor());
        this.interceptors.put("DevPathNetInterceptor", new DevPathNetInterceptor());
        this.interceptors.put("FileDownloadInterceptor-Dev", new FileDownloadInterceptor());
        this.interceptors.put("FileDownloadInterceptor-Build", new FileDownloadInterceptor());
    }

    private void onNext(String str) throws Exception {
        ConcurrentHashMap<String, Interceptor> concurrentHashMap;
        LogUtil.m13408d("=GiftDownLoadExecutor=", "onNext");
        if (this.mHandler == null || (concurrentHashMap = this.interceptors) == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(this.GIFT_PCK_BASIC)) {
            throw new Exception("初始化失败！");
        }
        if (this.executorService == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        }
        this.executorService.execute(getTask(str));
    }

    /* access modifiers changed from: private */
    public void sendMsg(InterceptorResult<GiftBean> interceptorResult) {
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = interceptorResult.dCode;
            int i = interceptorResult.dCode;
            if (i == 1) {
                obtain.obj = interceptorResult.data;
                this.mHandler.sendMessage(obtain);
            } else if (i == 2) {
                obtain.obj = interceptorResult.message;
                this.mHandler.sendMessage(obtain);
            } else if (i == 3) {
                this.mHandler.sendEmptyMessage(interceptorResult.dCode);
            }
        }
    }

    public void onDestroy() {
        ExecutorService executorService2 = this.executorService;
        if (executorService2 != null && !executorService2.isShutdown()) {
            this.executorService.shutdownNow();
            this.executorService = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }

    private static class MyHandler extends Handler {
        WeakReference<GiftDownLoadExecutor> mWeak;

        MyHandler(GiftDownLoadExecutor giftDownLoadExecutor, Context context) {
            super(Looper.getMainLooper());
            this.mWeak = new WeakReference<>(giftDownLoadExecutor);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<GiftDownLoadExecutor> weakReference = this.mWeak;
            if (weakReference != null && weakReference.get() != null && message.obj != null) {
                int i = message.what;
                if (i == 1) {
                    ((GiftDownLoadExecutor) this.mWeak.get()).onSuccess(message.obj);
                    ((GiftDownLoadExecutor) this.mWeak.get()).onDestroy();
                } else if (i == 2) {
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "handleMessage：" + message.obj.toString());
                    ((GiftDownLoadExecutor) this.mWeak.get()).onFail(message.obj.toString());
                    ((GiftDownLoadExecutor) this.mWeak.get()).onDestroy();
                } else if (i == 3) {
                    ((GiftDownLoadExecutor) this.mWeak.get()).onComplete();
                    ((GiftDownLoadExecutor) this.mWeak.get()).onDestroy();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        onDestroy();
    }

    /* access modifiers changed from: private */
    public void printFileInfo(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            LogUtil.m13408d("=GiftDownLoadExecutor=", "printFileInfo: " + file.getAbsolutePath() + " Size：" + file.length());
            return;
        }
        for (File file2 : file.listFiles()) {
            LogUtil.m13408d("=GiftDownLoadExecutor=", "printFileInfo: " + file2.getAbsolutePath() + " Size：" + file2.length());
            if (!file2.isFile()) {
                printFileInfo(file2.getAbsolutePath());
            }
        }
    }

    private Runnable getTask(final String str) {
        return new Runnable() {
            public void run() {
                String str;
                InterceptorResult interceptorResult = new InterceptorResult();
                LogUtil.m13408d("=GiftDownLoadExecutor=", AdminPermission.EXECUTE);
                try {
                    InterceptorResult onExecute = ((Interceptor) GiftDownLoadExecutor.this.interceptors.get(UrlInterceptor.TAG)).onExecute(str);
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "urlResult: " + onExecute.toString());
                    T t = (GiftBean) onExecute.data;
                    InterceptorResult onExecute2 = ((Interceptor) GiftDownLoadExecutor.this.interceptors.get("JsSdkListNetInterceptor")).onExecute(onExecute.data);
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "jsSdkListResult: " + onExecute2.toString());
                    InterceptorResult onExecute3 = ((Interceptor) GiftDownLoadExecutor.this.interceptors.get("DevPathNetInterceptor")).onExecute(onExecute2.data);
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "devPathResult: " + onExecute3.toString());
                    if (TextUtils.isEmpty(t.getAppId())) {
                        str = GiftDownLoadExecutor.this.GIFT_PCK_BASIC + "global" + File.separator + "build" + File.separator + t.getJssdkversion() + File.separator;
                    } else {
                        str = GiftDownLoadExecutor.this.GIFT_PCK_BASIC + t.getAppId() + File.separator + "build" + File.separator + t.getJssdkversion() + File.separator;
                    }
                    PmFileUtil.deleteFile(str);
                    PmFileUtil.mkdirs(str);
                    t.setFilePath(str);
                    HashMap hashMap = new HashMap();
                    hashMap.put("downUrl", (String) onExecute3.data);
                    hashMap.put("dirPath", str);
                    hashMap.put("zipFilePath", str + "temp.zip");
                    InterceptorResult onExecute4 = ((Interceptor) GiftDownLoadExecutor.this.interceptors.get("FileDownloadInterceptor-Dev")).onExecute(hashMap);
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "devResult: " + onExecute4.toString());
                    GiftDownLoadExecutor.this.printFileInfo(str);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("downUrl", str);
                    hashMap2.put("dirPath", str);
                    hashMap2.put("zipFilePath", str + t.getJsSdkId() + PmFileConstant.ZIP_SUFFIX);
                    InterceptorResult onExecute5 = ((Interceptor) GiftDownLoadExecutor.this.interceptors.get("FileDownloadInterceptor-Build")).onExecute(hashMap2);
                    LogUtil.m13408d("=GiftDownLoadExecutor=", "buildResult: " + onExecute5.toString());
                    GiftDownLoadExecutor.this.printFileInfo(str);
                    interceptorResult.data = t;
                    interceptorResult.dCode = 1;
                    GiftDownLoadExecutor.this.sendMsg(interceptorResult);
                } catch (Exception e) {
                    interceptorResult.dCode = 2;
                    interceptorResult.message = e.getMessage();
                    GiftDownLoadExecutor.this.sendMsg(interceptorResult);
                    e.printStackTrace();
                } catch (Throwable th) {
                    interceptorResult.dCode = 3;
                    GiftDownLoadExecutor.this.sendMsg(interceptorResult);
                    throw th;
                }
                interceptorResult.dCode = 3;
                GiftDownLoadExecutor.this.sendMsg(interceptorResult);
            }
        };
    }
}
