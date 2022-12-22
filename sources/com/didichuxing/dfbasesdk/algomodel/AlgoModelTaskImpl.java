package com.didichuxing.dfbasesdk.algomodel;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigResult;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelTaskManager;
import com.didichuxing.dfbasesdk.downloader.FileDownloader;
import com.didichuxing.dfbasesdk.downloader.FileDownloaderListener;
import com.didichuxing.dfbasesdk.utils.FileUtils;
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.dfbasesdk.view.ProgressbarActivity;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AlgoModelTaskImpl {
    public static final int ERR_DOWNLOAD_MODEL = 20;
    public static final int ERR_DOWNLOAD_MODEL_FAIL = 22;
    public static final int ERR_DOWNLOAD_MODEL_SUCCESS = 21;
    public static final int ERR_ENQUEUE_MODEL_TASK = 1;
    public static final int ERR_LOAD_MODEL_FAIL = 50;
    public static final int ERR_LOAD_MODEL_SUCCESS = 100;
    public static final int ERR_REQUEST_CONFIG = 10;
    public static final int ERR_REQUEST_CONFIG_FAIL = 13;
    public static final int ERR_REQUEST_CONFIG_SUCCESS = 11;

    /* renamed from: e */
    private static Map<Integer, Pair<Integer, String>> f46488e = new HashMap();

    /* renamed from: i */
    private static SPHelper f46489i;

    /* renamed from: a */
    Context f46490a;

    /* renamed from: b */
    int f46491b;

    /* renamed from: c */
    String f46492c;

    /* renamed from: d */
    int f46493d;

    /* renamed from: f */
    private Callback f46494f;

    /* renamed from: g */
    private ConfigDelegate f46495g;

    /* renamed from: h */
    private DownloadDelegate f46496h;

    /* renamed from: j */
    private boolean f46497j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f46498k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f46499l;

    public interface Callback {
        void onFail(int i);

        void onMessage(int i, int i2, String str);

        void onSuccess(int i, String str);
    }

    interface ConfigListener {
        void onException(Throwable th);

        void onSuccess(Config config);
    }

    public AlgoModelTaskImpl(Context context, int i, String str, int i2) {
        this(context, i, str, i2, (Callback) null);
    }

    public AlgoModelTaskImpl(Context context, int i, String str, int i2, Callback callback) {
        this.f46495g = new ConfigDelegate();
        this.f46496h = new DownloadDelegate();
        this.f46490a = context;
        if (f46489i == null) {
            f46489i = new SPHelper(context, "access_algo_models_sp");
        }
        this.f46491b = i;
        this.f46492c = str;
        this.f46493d = i2;
        this.f46494f = callback;
    }

    @Deprecated
    public AlgoModelTaskImpl(Context context, int i, String str, int i2, AlgoModelResourceExtractor algoModelResourceExtractor) {
        this(context, i, str, i2, (Callback) null);
    }

    @Deprecated
    public AlgoModelTaskImpl(Context context, int i, String str, int i2, AlgoModelResourceExtractor algoModelResourceExtractor, Callback callback) {
        this(context, i, str, i2, callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m33318a(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m33325a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return "";
        }
        if (1 == objArr.length) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(objArr[0]));
        for (int i = 1; i < objArr.length; i++) {
            sb.append('|');
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m33347c() {
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory == null) {
            return "-1k";
        }
        StatFs statFs = new StatFs(dataDirectory.getPath());
        return ((((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize())) / 1024) + "k";
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m33351d() {
        return WsgSecInfo.networkType(this.f46490a);
    }

    public void prepareModels() {
        if (!this.f46497j) {
            this.f46497j = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.f46499l = currentTimeMillis;
            this.f46498k = currentTimeMillis;
            m33326a(this.f46491b, 1, "开始加载模型");
            m33336a("资源下载中 0%");
            m33339a(true);
            m33326a(this.f46491b, 10, "请求config");
            this.f46495g.getConfig(m33353e());
        }
    }

    /* renamed from: a */
    private void m33339a(boolean z) {
        if (this.f46493d == 0) {
            ProgressbarActivity.setProgressVisible(this.f46490a, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33336a(String str) {
        if (this.f46493d == 0) {
            ProgressbarActivity.setProgressContent(str);
        }
    }

    /* renamed from: e */
    private ConfigListener m33353e() {
        return new ConfigListener() {
            public void onSuccess(Config config) {
                String str = (config == null || !config.cache) ? "远程配置" : "缓存配置";
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                int i = algoModelTaskImpl.f46491b;
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m33326a(i, 11, algoModelTaskImpl2.m33325a("config请求成功", str, algoModelTaskImpl2.m33318a(algoModelTaskImpl2.f46499l), AlgoModelTaskImpl.this.m33351d(), String.valueOf(config)));
                String str2 = "已更新模型";
                if (config == null || TextUtils.isEmpty(config.url) || TextUtils.isEmpty(config.md5)) {
                    String c = AlgoModelTaskImpl.this.m33356f();
                    if (!TextUtils.isEmpty(c)) {
                        AlgoModelTaskImpl algoModelTaskImpl3 = AlgoModelTaskImpl.this;
                        int i2 = algoModelTaskImpl3.f46491b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("使用缓存模型|");
                        if (config == null || !config.cache) {
                            str2 = "config接口没下发配置";
                        }
                        sb.append(str2);
                        String sb2 = sb.toString();
                        AlgoModelTaskImpl algoModelTaskImpl4 = AlgoModelTaskImpl.this;
                        algoModelTaskImpl3.m33328a(i2, c, sb2, algoModelTaskImpl4.m33344b(AlgoModelTaskImpl.m33354e(algoModelTaskImpl4.f46490a, AlgoModelTaskImpl.this.f46491b)));
                        return;
                    }
                    AlgoModelTaskImpl algoModelTaskImpl5 = AlgoModelTaskImpl.this;
                    algoModelTaskImpl5.m33327a(algoModelTaskImpl5.f46491b, "config接口配置为空");
                    return;
                }
                if (config.md5.equalsIgnoreCase(AlgoModelTaskImpl.this.mo115443a())) {
                    String c2 = AlgoModelTaskImpl.this.m33356f();
                    if (!TextUtils.isEmpty(c2)) {
                        AlgoModelTaskImpl algoModelTaskImpl6 = AlgoModelTaskImpl.this;
                        int i3 = algoModelTaskImpl6.f46491b;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("使用缓存模型|");
                        if (!config.cache) {
                            str2 = "config接口下发配置和缓存一致";
                        }
                        sb3.append(str2);
                        String sb4 = sb3.toString();
                        AlgoModelTaskImpl algoModelTaskImpl7 = AlgoModelTaskImpl.this;
                        algoModelTaskImpl6.m33328a(i3, c2, sb4, algoModelTaskImpl7.m33344b(AlgoModelTaskImpl.m33354e(algoModelTaskImpl7.f46490a, AlgoModelTaskImpl.this.f46491b)));
                        return;
                    }
                }
                String a = AlgoModelTaskImpl.this.m33324a(new File(AlgoModelTaskImpl.m33358g(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b)), config.md5);
                if (!TextUtils.isEmpty(a)) {
                    AlgoModelTaskImpl.this.m33338a(a, config.url, config.md5);
                    return;
                }
                String str3 = "md5_" + config.md5 + PmFileConstant.ZIP_SUFFIX;
                if (1 == AlgoModelTaskImpl.this.f46493d) {
                    AlgoModelTaskImpl algoModelTaskImpl8 = AlgoModelTaskImpl.this;
                    algoModelTaskImpl8.m33329a(algoModelTaskImpl8.f46491b, config.url, config.md5, str3, 0);
                    return;
                }
                long currentTimeMillis = 15000 - (System.currentTimeMillis() - AlgoModelTaskImpl.this.f46498k);
                long j = currentTimeMillis < 100 ? 100 : currentTimeMillis;
                AlgoModelTaskImpl algoModelTaskImpl9 = AlgoModelTaskImpl.this;
                algoModelTaskImpl9.m33329a(algoModelTaskImpl9.f46491b, config.url, config.md5, str3, j);
            }

            public void onException(Throwable th) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                int i = algoModelTaskImpl.f46491b;
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m33326a(i, 13, algoModelTaskImpl2.m33325a("config请求失败", algoModelTaskImpl2.m33318a(algoModelTaskImpl2.f46499l), AlgoModelTaskImpl.this.m33351d(), String.valueOf(th)));
                AlgoModelTaskImpl algoModelTaskImpl3 = AlgoModelTaskImpl.this;
                int i2 = algoModelTaskImpl3.f46491b;
                algoModelTaskImpl3.m33327a(i2, "config接口失败|" + th);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo115443a() {
        String d;
        if (!TextUtils.isEmpty(m33356f()) && (d = m33352d(this.f46490a, this.f46491b)) != null) {
            return d;
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AlgoModelTaskManager.ConfigCallback mo115444b() {
        return this.f46495g.getFacadeConfigCallback();
    }

    /* renamed from: d */
    private static String m33352d(Context context, int i) {
        SPHelper b = m33341b(context);
        return (String) b.get("model_zip_md5_type" + i, "");
    }

    /* renamed from: a */
    private static void m33330a(Context context, int i, String str) {
        SPHelper b = m33341b(context);
        b.put("model_zip_md5_type" + i, str).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static String m33354e(Context context, int i) {
        SPHelper b = m33341b(context);
        return (String) b.get("model_zip_url_type" + i, "");
    }

    /* renamed from: b */
    private static void m33345b(Context context, int i, String str) {
        SPHelper b = m33341b(context);
        b.put("model_zip_url_type" + i, str).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SPHelper m33341b(Context context) {
        if (f46489i == null) {
            f46489i = new SPHelper(context, "access_algo_models_sp");
        }
        return f46489i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33328a(int i, String str, String str2, String str3) {
        m33326a(i, 100, m33325a("模型加载成功", str2, m33318a(this.f46498k), m33344b(str3)));
        if (this.f46494f != null) {
            m33339a(false);
            this.f46494f.onSuccess(i, str);
        }
        this.f46497j = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33327a(int i, String str) {
        m33326a(i, 50, m33325a("模型加载失败", str, m33318a(this.f46498k), m33347c()));
        if (this.f46494f != null) {
            m33339a(false);
            this.f46494f.onFail(i);
        }
        this.f46497j = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33326a(int i, int i2, String str) {
        Pair pair;
        if (this.f46494f != null) {
            if (50 == i2 && (pair = f46488e.get(Integer.valueOf(i))) != null) {
                str = str + "|(后台更新模型失败)" + ((String) pair.second);
                f46488e.remove(Integer.valueOf(i));
            }
            this.f46494f.onMessage(i, i2, str);
        } else if (i2 == 13 || i2 == 22) {
            f46488e.put(Integer.valueOf(i), new Pair(Integer.valueOf(i2), str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33329a(final int i, String str, final String str2, String str3, long j) {
        this.f46499l = System.currentTimeMillis();
        m33326a(i, 20, m33325a("开始下载模型", m33351d(), m33344b(str)));
        this.f46496h.download(this.f46490a, i, this.f46493d, str, str2, str3, j, new FileDownloaderListener() {
            public void success(String str, String str2) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m33326a(i, 21, algoModelTaskImpl.m33325a("模型下载成功", algoModelTaskImpl.m33318a(algoModelTaskImpl.f46499l), AlgoModelTaskImpl.this.m33344b(str), AlgoModelTaskImpl.this.m33351d()));
                AlgoModelTaskImpl.this.m33338a(str2, str, str2);
            }

            public void progress(int i) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m33336a("资源下载中 " + i + "%");
            }

            public void failed(Throwable th) {
                String b = AlgoModelTaskImpl.m33354e(AlgoModelTaskImpl.this.f46490a, i);
                String a = !TextUtils.isEmpty(b) ? AlgoModelTaskImpl.this.m33344b(b) : "";
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m33326a(i, 22, algoModelTaskImpl.m33325a("模型下载失败", algoModelTaskImpl.m33318a(algoModelTaskImpl.f46499l), AlgoModelTaskImpl.this.m33344b(b), AlgoModelTaskImpl.this.m33351d(), th, AlgoModelTaskImpl.this.m33347c(), a));
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                int i = i;
                algoModelTaskImpl2.m33327a(i, "模型下载失败|" + th);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m33324a(File file, String str) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile() && FileUtils.fileToMD5(file2).equalsIgnoreCase(str)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33338a(String str, String str2, String str3) {
        String f = m33357f(this.f46490a, this.f46491b);
        if (!new File(f).mkdirs()) {
            m33327a(this.f46491b, "创建解压目录失败");
            return;
        }
        try {
            m33337a(str, f);
            String a = m33319a(this.f46490a, this.f46491b);
            if (!m33340a(new File(a))) {
                m33327a(this.f46491b, "删除老模型失败");
                return;
            }
            if (new File(f).renameTo(new File(a))) {
                m33330a(this.f46490a, this.f46491b, str3);
                m33345b(this.f46490a, this.f46491b, str2);
                m33328a(this.f46491b, a, "使用下载模型", m33344b(str2));
            } else {
                m33327a(this.f46491b, "重命名解压目录失败");
            }
            m33340a(new File(m33358g(this.f46490a, this.f46491b)));
        } catch (Throwable unused) {
            m33340a(new File(m33358g(this.f46490a, this.f46491b)));
            m33327a(this.f46491b, "zip文件解压失败");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m33356f() {
        File[] listFiles;
        String a = m33319a(this.f46490a, this.f46491b);
        File file = new File(a);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m33340a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile() && file.delete()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return file.delete();
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    return false;
                }
            } else if (file2.isDirectory() && !m33340a(file2)) {
                return false;
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    private void m33337a(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            String name = zipEntry.getName();
            File file = new File(str2 + "/" + name);
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            IOUtils.copy(inputStream, fileOutputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m33344b(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(47)) >= 0) {
            int i = lastIndexOf + 1;
            int indexOf = str.indexOf(63);
            if (indexOf > i) {
                return str.substring(i, indexOf);
            }
            if (indexOf < 0) {
                return str.substring(i);
            }
        }
        return "";
    }

    /* renamed from: f */
    private static String m33357f(Context context, int i) {
        return m33358g(context, i) + "/unzip" + System.nanoTime();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static String m33358g(Context context, int i) {
        return m33359h(context, i) + "/temp";
    }

    /* renamed from: a */
    static String m33319a(Context context, int i) {
        return m33359h(context, i) + "/model";
    }

    /* renamed from: h */
    private static String m33359h(Context context, int i) {
        return context.getFilesDir().getAbsolutePath() + "/accessAlgoModels/type" + i;
    }

    class ConfigDelegate {
        ConfigListener configListener;
        AlgoModelTaskManager.ConfigCallback facadeConfigCallback;

        ConfigDelegate() {
        }

        /* access modifiers changed from: package-private */
        public void getConfig(ConfigListener configListener2) {
            if (!getConfigSdkVersion(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b).equalsIgnoreCase(AlgoModelTaskImpl.this.f46492c) || System.currentTimeMillis() - getRequestConfigTime(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b) >= 86400000) {
                this.configListener = configListener2;
                AlgoModelTaskManager.m33366a(AlgoModelTaskImpl.this);
                return;
            }
            Config config = new Config();
            config.md5 = getConfigModelMd5(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b);
            config.url = getConfigModelUrl(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b);
            config.cache = true;
            configListener2.onSuccess(config);
        }

        /* access modifiers changed from: package-private */
        public AlgoModelTaskManager.ConfigCallback getFacadeConfigCallback() {
            if (this.facadeConfigCallback == null) {
                this.facadeConfigCallback = new AlgoModelTaskManager.ConfigCallback() {
                    public void onSuccess(AlgoModelConfigResult.ResultModel resultModel) {
                        Config config = new Config();
                        config.cache = false;
                        if (resultModel != null && resultModel.type == AlgoModelTaskImpl.this.f46491b) {
                            config.url = resultModel.url;
                            config.md5 = resultModel.md5;
                            ConfigDelegate configDelegate = ConfigDelegate.this;
                            configDelegate.setRequestConfigTime(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b, System.currentTimeMillis());
                            if (!TextUtils.isEmpty(resultModel.url)) {
                                ConfigDelegate configDelegate2 = ConfigDelegate.this;
                                configDelegate2.setConfigModelMd5(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b, resultModel.md5);
                                ConfigDelegate configDelegate3 = ConfigDelegate.this;
                                configDelegate3.setConfigModelUrl(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b, resultModel.url);
                            }
                            ConfigDelegate configDelegate4 = ConfigDelegate.this;
                            configDelegate4.setConfigSdkVersion(AlgoModelTaskImpl.this.f46490a, AlgoModelTaskImpl.this.f46491b, AlgoModelTaskImpl.this.f46492c);
                        }
                        ConfigDelegate.this.configListener.onSuccess(config);
                    }

                    public void onFailure(Exception exc) {
                        ConfigDelegate.this.configListener.onException(exc);
                    }
                };
            }
            return this.facadeConfigCallback;
        }

        private long getRequestConfigTime(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            Long l = (Long) a.get("request_config_time_type" + i, 0L);
            if (l != null) {
                return l.longValue();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        public void setRequestConfigTime(Context context, int i, long j) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            a.put("request_config_time_type" + i, Long.valueOf(j)).apply();
        }

        private String getConfigModelUrl(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            return (String) a.get("config_model_url_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigModelUrl(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            String str2 = "config_model_url_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }

        private String getConfigModelMd5(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            return (String) a.get("config_model_md5_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigModelMd5(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            String str2 = "config_model_md5_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }

        private String getConfigSdkVersion(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            return (String) a.get("config_sdk_version_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigSdkVersion(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m33341b(context);
            String str2 = "config_sdk_version_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }
    }

    class Config {
        boolean cache;
        String md5;
        String url;

        Config() {
        }
    }

    static class DownloadDelegate {
        static Map<Integer, DownloadTask> sDownloadListeners = new ConcurrentHashMap();
        static Handler sHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                DownloadTask downloadTask = DownloadDelegate.sDownloadListeners.get(Integer.valueOf(message.what - 100));
                if (downloadTask != null && downloadTask.downloadListener != null) {
                    downloadTask.timeout = true;
                    downloadTask.downloadListener.failed(new Exception("time out!!"));
                }
            }
        };

        DownloadDelegate() {
        }

        /* access modifiers changed from: package-private */
        public int getProgress(int i) {
            DownloadTask downloadTask = sDownloadListeners.get(Integer.valueOf(i));
            if (downloadTask != null) {
                return downloadTask.progress;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void download(Context context, final int i, int i2, String str, String str2, String str3, long j, FileDownloaderListener fileDownloaderListener) {
            int i3 = i + 100;
            sHandler.removeMessages(i3);
            if (i2 == 0 && j > 0) {
                sHandler.sendEmptyMessageDelayed(i3, j);
            }
            DownloadTask downloadTask = new DownloadTask(fileDownloaderListener);
            DownloadTask put = sDownloadListeners.put(Integer.valueOf(i), downloadTask);
            if (put == null) {
                FileDownloader.download(context, new FileDownloader.ParamBuilder().setUrl(str).setDirectory(AlgoModelTaskImpl.m33358g(context, i)).setFileName(str3).setRetryTime(1 == i2 ? 2 : 0).setRetryDelayInMills(3000).setUseRange(true).build(), new FileDownloaderListener() {
                    int currentPrg = 0;

                    public void success(String str, String str2) {
                        DownloadTask remove = DownloadDelegate.sDownloadListeners.remove(Integer.valueOf(i));
                        if (remove != null && remove.downloadListener != null && !remove.timeout) {
                            remove.downloadListener.success(str, str2);
                        }
                    }

                    public void progress(int i) {
                        DownloadTask downloadTask = DownloadDelegate.sDownloadListeners.get(Integer.valueOf(i));
                        if (downloadTask != null && downloadTask.downloadListener != null && !downloadTask.timeout) {
                            downloadTask.progress = i;
                            downloadTask.downloadListener.progress(i);
                        }
                    }

                    public void failed(Throwable th) {
                        DownloadTask remove = DownloadDelegate.sDownloadListeners.remove(Integer.valueOf(i));
                        if (remove != null && remove.downloadListener != null && !remove.timeout) {
                            remove.downloadListener.failed(th);
                        }
                    }
                });
            } else {
                downloadTask.progress = put.progress;
            }
            if (downloadTask.downloadListener != null) {
                downloadTask.downloadListener.progress(downloadTask.progress);
            }
        }
    }

    private static class DownloadTask {
        FileDownloaderListener downloadListener;
        int progress = 0;
        boolean timeout = false;

        public DownloadTask(FileDownloaderListener fileDownloaderListener) {
            this.downloadListener = fileDownloaderListener;
        }
    }
}
