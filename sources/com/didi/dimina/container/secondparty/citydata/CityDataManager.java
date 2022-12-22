package com.didi.dimina.container.secondparty.citydata;

import android.app.Application;
import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J-\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/citydata/CityDataManager;", "", "()V", "DIMINA_CXYX_PICKER_PROVINCE", "", "DIMINA_CXYX_PICKER_PROVINCE_FILE_MD5", "PROVINCE_DOWNLOAD_PATH", "TAG", "downloadFile", "", "url", "filePath", "callback", "Lcom/didi/dimina/container/service/NetworkService$ITaskCallback;", "getApolloValue", "T", "toggle", "key", "def", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getCityData", "getProvinceDataMd5", "getProvinceDataUpdateUrl", "getProvinceDataVersion", "", "updateCityData", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CityDataManager.kt */
public final class CityDataManager {
    public static final CityDataManager INSTANCE = new CityDataManager();

    /* renamed from: a */
    private static final String f17103a = "CityDataManager";

    /* renamed from: b */
    private static final String f17104b;

    /* renamed from: c */
    private static final String f17105c = "dimina_cxyx_picker_province";

    /* renamed from: d */
    private static final String f17106d = "7230b52d3ff719b95942800c6d33f772";

    static {
        StringBuilder sb = new StringBuilder();
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        Intrinsics.checkExpressionValueIsNotNull(app, "Dimina.getConfig().app");
        File filesDir = app.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "Dimina.getConfig().app.filesDir");
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(DMSandboxHelper.DIMINA);
        sb.append(File.separator);
        sb.append("picker");
        sb.append(File.separator);
        f17104b = sb.toString();
    }

    private CityDataManager() {
    }

    @JvmStatic
    public static final String getCityData() {
        String c = INSTANCE.m12678c();
        String str = f17104b + FileUtil.getFileName(c);
        if (FileUtil.isFileExists(str)) {
            String readFile2String = FileUtil.readFile2String(new File(str));
            Intrinsics.checkExpressionValueIsNotNull(readFile2String, "FileUtil.readFile2String(File(filePath))");
            LogUtil.iRelease(f17103a, "获取缓存目录下的json文件数据");
            return readFile2String;
        }
        String readAssets2String = FileUtil.readAssets2String("dimina/province.json");
        Intrinsics.checkExpressionValueIsNotNull(readAssets2String, "FileUtil.readAssets2String(\"dimina/province.json\")");
        LogUtil.iRelease(f17103a, "获取assets目录下的json文件数据, 同时网络下载最新的数据");
        INSTANCE.m12675a();
        return readAssets2String;
    }

    /* renamed from: a */
    private final void m12675a() {
        Object obj = MMKVUtil.getInstance().get("province_version", 0);
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            int b = m12677b();
            if (b > intValue) {
                String c = m12678c();
                if (TextUtils.isEmpty(c)) {
                    LogUtil.iRelease(f17103a, "没有得到下载的url地址, 直接返回");
                    return;
                }
                String str = f17104b + FileUtil.getFileName(c);
                LogUtil.iRelease(f17103a, "updateCityData filePath " + str);
                LogUtil.iRelease(f17103a, "isFileExists " + FileUtil.isFileExists(str));
                File file = new File(f17104b);
                FileUtil.delete(file);
                if (!file.exists()) {
                    LogUtil.iRelease(f17103a, "下载目录不存在，先创建 " + f17104b);
                    FileUtil.mkdirs(f17104b);
                }
                m12676a(c, str, new CityDataManager$updateCityData$1(c, str, b));
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: a */
    private final void m12676a(String str, String str2, NetworkService.ITaskCallback iTaskCallback) {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        NetworkService httpService = adapterConfig.getHttpService();
        NetworkService.NetworkTaskModel.Download download = new NetworkService.NetworkTaskModel.Download();
        download.url = str;
        download.timeout = 3000;
        download.filePath = str2;
        httpService.downloadFile(download, iTaskCallback);
    }

    public final <T> T getApolloValue(String str, String str2, T t) {
        IToggle toggle = Apollo.getToggle(str);
        return (toggle == null || !toggle.allow()) ? t : toggle.getExperiment().getParam(str2, t);
    }

    /* renamed from: b */
    private final int m12677b() {
        return ((Number) getApolloValue(f17105c, "version", 0)).intValue();
    }

    /* renamed from: c */
    private final String m12678c() {
        return (String) getApolloValue(f17105c, "url", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final String m12679d() {
        return (String) getApolloValue(f17105c, "md5", f17106d);
    }
}
