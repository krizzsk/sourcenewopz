package com.didi.jacoco.runtime;

import android.content.Context;
import android.os.Build;
import com.didi.jacoco.p120ec.CommitInfo;
import com.didi.jacoco.p120ec.DeviceInfo;
import com.didi.jacoco.p120ec.EcInfo;
import com.didi.jacoco.p120ec.JenkinsInfo;
import com.didi.jacoco.p120ec.UserInfo;
import com.didi.jacoco.runtime.module.role.Data;
import com.didi.jacoco.store.expand.DidiExecFileLoader;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001b\u0010\u0017\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/JacocoGenerator;", "", "runtime", "Lcom/didi/jacoco/runtime/JacocoRuntime;", "(Lcom/didi/jacoco/runtime/JacocoRuntime;)V", "getRuntime", "()Lcom/didi/jacoco/runtime/JacocoRuntime;", "setRuntime", "coverageFileMd5", "", "createEcInfo", "Lcom/didi/jacoco/ec/EcInfo;", "createFile", "Ljava/io/File;", "root", "generate", "auto", "", "roleData", "Lcom/didi/jacoco/runtime/module/role/Data;", "uploadFile", "", "file", "uploadFiles", "files", "", "([Ljava/io/File;)V", "Companion", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: JacocoGenerator.kt */
public final class JacocoGenerator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String format = "yyyy-MM-dd-HH-mm-ss";
    private static final String postfix = ".ec";
    private JacocoRuntime runtime;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3575958363541265766L, "com/didi/jacoco/runtime/JacocoGenerator", 75);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[74] = true;
    }

    public JacocoGenerator(JacocoRuntime jacocoRuntime) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(jacocoRuntime, "runtime");
        $jacocoInit[72] = true;
        this.runtime = jacocoRuntime;
        $jacocoInit[73] = true;
    }

    public final JacocoRuntime getRuntime() {
        boolean[] $jacocoInit = $jacocoInit();
        JacocoRuntime jacocoRuntime = this.runtime;
        $jacocoInit[70] = true;
        return jacocoRuntime;
    }

    public final void setRuntime(JacocoRuntime jacocoRuntime) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(jacocoRuntime, "<set-?>");
        this.runtime = jacocoRuntime;
        $jacocoInit[71] = true;
    }

    public final File generate(boolean z, Data data) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(data, "roleData");
        File file = null;
        try {
            $jacocoInit[0] = true;
            $jacocoInit[1] = true;
            File createFile = createFile(this.runtime.outPutDir);
            if (createFile != null) {
                $jacocoInit[2] = true;
                EntityKt.createEcFile(createFile);
                $jacocoInit[6] = true;
                new DidiExecFileLoader().rewrite(createFile, createEcInfo(), createFile);
                if (!z) {
                    $jacocoInit[7] = true;
                } else {
                    $jacocoInit[8] = true;
                    uploadFile(createFile, data);
                    $jacocoInit[9] = true;
                }
                $jacocoInit[10] = true;
                return createFile;
            }
            if (!z) {
                $jacocoInit[3] = true;
            } else {
                $jacocoInit[4] = true;
            }
            $jacocoInit[5] = true;
            return null;
        } catch (Exception e) {
            $jacocoInit[11] = true;
            e.printStackTrace();
            if (!z) {
                $jacocoInit[12] = true;
            } else if (file == null) {
                $jacocoInit[13] = true;
            } else {
                $jacocoInit[14] = true;
                uploadFile(file, data);
                $jacocoInit[15] = true;
            }
            $jacocoInit[21] = true;
            return null;
        } catch (Throwable th) {
            if (!z) {
                $jacocoInit[16] = true;
            } else if (file == null) {
                $jacocoInit[17] = true;
            } else {
                $jacocoInit[18] = true;
                uploadFile(file, data);
                $jacocoInit[19] = true;
            }
            $jacocoInit[20] = true;
            throw th;
        }
    }

    public final void uploadFiles(File[] fileArr) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (fileArr == null) {
            $jacocoInit[22] = true;
        } else {
            if (fileArr.length == 0) {
                $jacocoInit[23] = true;
                z = true;
            } else {
                $jacocoInit[24] = true;
                z = false;
            }
            if (z) {
                $jacocoInit[25] = true;
            } else if (fileArr.length == 1) {
                $jacocoInit[27] = true;
                uploadFile(fileArr[0], new Data("", ""));
                $jacocoInit[28] = true;
                return;
            } else {
                String parent = fileArr[0].getParent();
                $jacocoInit[29] = true;
                DidiExecFileLoader didiExecFileLoader = new DidiExecFileLoader();
                int length = fileArr.length;
                $jacocoInit[30] = true;
                int i = 0;
                while (i < length) {
                    File file = fileArr[i];
                    $jacocoInit[31] = true;
                    didiExecFileLoader.load(file);
                    $jacocoInit[32] = true;
                    file.delete();
                    i++;
                    $jacocoInit[33] = true;
                }
                $jacocoInit[34] = true;
                didiExecFileLoader.save(new File(parent, "merge.ec"), false);
                $jacocoInit[35] = true;
                return;
            }
        }
        $jacocoInit[26] = true;
    }

    private final void uploadFile(File file, Data data) {
        boolean[] $jacocoInit = $jacocoInit();
        String url = this.runtime.coverageConfig.url();
        Intrinsics.checkExpressionValueIsNotNull(url, "runtime.coverageConfig.url()");
        new HttpClient(url).uploadFile(file, data, new JacocoGenerator$uploadFile$1(this, file));
        $jacocoInit[36] = true;
    }

    private final EcInfo createEcInfo() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[37] = true;
        String appId = this.runtime.coverageConfig.appId();
        String str = appId;
        Intrinsics.checkExpressionValueIsNotNull(appId, "runtime.coverageConfig.appId()");
        $jacocoInit[38] = true;
        long buildTime = this.runtime.coverageConfig.buildTime();
        $jacocoInit[39] = true;
        Context context = this.runtime.context;
        Intrinsics.checkExpressionValueIsNotNull(context, "runtime.context");
        String str2 = HttpClientKt.getPackageInfo(context).versionName;
        String str3 = str2;
        Intrinsics.checkExpressionValueIsNotNull(str2, "runtime.context.getPackageInfo().versionName");
        $jacocoInit[40] = true;
        Context context2 = this.runtime.context;
        Intrinsics.checkExpressionValueIsNotNull(context2, "runtime.context");
        String valueOf = String.valueOf(HttpClientKt.getPackageInfo(context2).versionCode);
        $jacocoInit[41] = true;
        String branchName = this.runtime.coverageConfig.branchName();
        String str4 = branchName;
        Intrinsics.checkExpressionValueIsNotNull(branchName, "runtime.coverageConfig.branchName()");
        $jacocoInit[42] = true;
        DeviceInfo deviceInfo = r11;
        String str5 = Build.BRAND;
        Intrinsics.checkExpressionValueIsNotNull(str5, "Build.BRAND");
        String str6 = Build.MODEL;
        Intrinsics.checkExpressionValueIsNotNull(str6, "Build.MODEL");
        String str7 = Build.DEVICE;
        Intrinsics.checkExpressionValueIsNotNull(str7, "Build.DEVICE");
        int i = Build.VERSION.SDK_INT;
        String str8 = Build.VERSION.RELEASE;
        Intrinsics.checkExpressionValueIsNotNull(str8, "Build.VERSION.RELEASE");
        DeviceInfo deviceInfo2 = new DeviceInfo(str5, str6, str7, i, str8);
        $jacocoInit[43] = true;
        Object fromJson = new Gson().fromJson(this.runtime.coverageConfig.commitInfo(), CommitInfo.class);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(runtime.…, CommitInfo::class.java)");
        long j = this.runtime.startTime;
        $jacocoInit[44] = true;
        long currentTimeMillis = System.currentTimeMillis();
        $jacocoInit[45] = true;
        Object fromJson2 = new Gson().fromJson(this.runtime.coverageConfig.jenkinsInfo(), JenkinsInfo.class);
        Intrinsics.checkExpressionValueIsNotNull(fromJson2, "Gson().fromJson(runtime.… JenkinsInfo::class.java)");
        $jacocoInit[46] = true;
        UserInfo userInfo = r2;
        String userName = this.runtime.coverageConfig.userName();
        String str9 = str;
        Intrinsics.checkExpressionValueIsNotNull(userName, "runtime.coverageConfig.userName()");
        String userEmail = this.runtime.coverageConfig.userEmail();
        Intrinsics.checkExpressionValueIsNotNull(userEmail, "runtime.coverageConfig.userEmail()");
        UserInfo userInfo2 = new UserInfo(userName, userEmail);
        $jacocoInit[47] = true;
        String flavor = this.runtime.coverageConfig.flavor();
        String str10 = flavor;
        Intrinsics.checkExpressionValueIsNotNull(flavor, "runtime.coverageConfig.flavor()");
        $jacocoInit[48] = true;
        String buildType = this.runtime.coverageConfig.buildType();
        Intrinsics.checkExpressionValueIsNotNull(buildType, "runtime.coverageConfig.buildType()");
        $jacocoInit[49] = true;
        EcInfo ecInfo = new EcInfo(str9, buildTime, str3, valueOf, str4, userInfo, deviceInfo, "", (CommitInfo) fromJson, j, currentTimeMillis, (JenkinsInfo) fromJson2, str10, buildType);
        $jacocoInit[50] = true;
        return ecInfo;
    }

    private final String coverageFileMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        long buildTime = this.runtime.coverageConfig.buildTime();
        $jacocoInit[51] = true;
        String format2 = new SimpleDateFormat(format, Locale.getDefault()).format(new Date(buildTime));
        Intrinsics.checkExpressionValueIsNotNull(format2, "SimpleDateFormat(format,…format(Date(versionName))");
        $jacocoInit[52] = true;
        return format2;
    }

    private final File createFile(File file) {
        boolean[] $jacocoInit = $jacocoInit();
        if (file == null) {
            $jacocoInit[53] = true;
            return null;
        }
        if (file.exists()) {
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[55] = true;
            file.mkdirs();
            $jacocoInit[56] = true;
        }
        File file2 = new File(file, coverageFileMd5());
        $jacocoInit[57] = true;
        if (file2.exists()) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            file2.mkdirs();
            $jacocoInit[60] = true;
        }
        Context context = this.runtime.context;
        Intrinsics.checkExpressionValueIsNotNull(context, "runtime.context");
        String str = HttpClientKt.getPackageInfo(context).versionName;
        $jacocoInit[61] = true;
        File file3 = new File(file2, RavenKey.VERSION + str + "_" + new SimpleDateFormat(format, Locale.getDefault()).format(new Date()) + postfix);
        $jacocoInit[62] = true;
        if (file3.exists()) {
            $jacocoInit[63] = true;
        } else {
            try {
                $jacocoInit[64] = true;
                $jacocoInit[65] = true;
                file3.createNewFile();
                $jacocoInit[66] = true;
            } catch (IOException e) {
                $jacocoInit[67] = true;
                e.printStackTrace();
                $jacocoInit[68] = true;
            }
        }
        SystemUtils.log(6, "ec", "generate: " + file3.getAbsolutePath(), (Throwable) null, "com.didi.jacoco.runtime.JacocoGenerator", 118);
        $jacocoInit[69] = true;
        return file3;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/JacocoGenerator$Companion;", "", "()V", "format", "", "postfix", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: JacocoGenerator.kt */
    public static final class Companion {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6098568865810397434L, "com/didi/jacoco/runtime/JacocoGenerator$Companion", 2);
            $jacocoData = probes;
            return probes;
        }

        private Companion() {
            $jacocoInit()[0] = true;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[1] = true;
        }
    }
}
