package com.didi.jacoco.runtime;

import android.util.Base64;
import com.didi.jacoco.p120ec.JenkinsInfo;
import com.didi.jacoco.runtime.module.role.Data;
import com.didi.jacoco.store.expand.DidiExecFileLoader;
import com.didi.jacoco.store.expand.DidiExecutionDataReader;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;
import com.google.gson.Gson;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.FilesKt;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/HttpClient;", "", "host", "", "(Ljava/lang/String;)V", "coverageAddUrl", "getHost", "()Ljava/lang/String;", "setHost", "okHttpClient", "Lokhttp3/OkHttpClient;", "uploadFile", "", "file", "Ljava/io/File;", "roleData", "Lcom/didi/jacoco/runtime/module/role/Data;", "callback", "Lcom/didi/jacoco/runtime/HttpCallback;", "Companion", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HttpClient.kt */
public final class HttpClient {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String coverageAddUrl = (this.host + "/quality/coverage/output/add");
    private String host;
    private final OkHttpClient okHttpClient;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7095617439579254304L, "com/didi/jacoco/runtime/HttpClient", 54);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[53] = true;
    }

    public HttpClient(String str) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "host");
        $jacocoInit[45] = true;
        this.host = str;
        $jacocoInit[46] = true;
        $jacocoInit[47] = true;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        $jacocoInit[48] = true;
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        $jacocoInit[49] = true;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        $jacocoInit[50] = true;
        OkHttpClient.Builder addInterceptor = builder.addInterceptor(httpLoggingInterceptor);
        $jacocoInit[51] = true;
        OkHttpClient build = addInterceptor.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OkHttpClient.Builder()\n …tor)\n            .build()");
        this.okHttpClient = build;
        $jacocoInit[52] = true;
    }

    public final String getHost() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.host;
        $jacocoInit[43] = true;
        return str;
    }

    public final void setHost(String str) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.host = str;
        $jacocoInit[44] = true;
    }

    public final void uploadFile(File file, Data data, HttpCallback httpCallback) {
        boolean z;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(data, "roleData");
        Intrinsics.checkParameterIsNotNull(httpCallback, "callback");
        boolean z3 = false;
        $jacocoInit[0] = true;
        FormBody.Builder builder = new FormBody.Builder();
        $jacocoInit[1] = true;
        String parseBase64 = Companion.parseBase64(file);
        $jacocoInit[2] = true;
        DidiExecFileLoader didiExecFileLoader = new DidiExecFileLoader();
        $jacocoInit[3] = true;
        DidiExecutionDataReader load = didiExecFileLoader.load(file);
        $jacocoInit[4] = true;
        builder.add("deviceInfo", load.getDeviceInfo());
        $jacocoInit[5] = true;
        builder.add("outputContent", parseBase64);
        $jacocoInit[6] = true;
        builder.add("userId", data.getId());
        $jacocoInit[7] = true;
        builder.add("user", load.getUserInfo());
        $jacocoInit[8] = true;
        builder.add("appId", load.getAppId());
        $jacocoInit[9] = true;
        builder.add("branchName", load.getBranchName());
        $jacocoInit[10] = true;
        builder.add("buildTime", String.valueOf(load.getBuildTime()));
        $jacocoInit[11] = true;
        builder.add("commitInfo", load.getCommitInfo());
        $jacocoInit[12] = true;
        if (load.getJenkinsInfo().length() > 0) {
            $jacocoInit[13] = true;
            z = true;
        } else {
            $jacocoInit[14] = true;
            z = false;
        }
        if (!z) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            JenkinsInfo jenkinsInfo = (JenkinsInfo) new Gson().fromJson(load.getJenkinsInfo(), JenkinsInfo.class);
            $jacocoInit[17] = true;
            if (jenkinsInfo.getBuild_id().length() > 0) {
                $jacocoInit[18] = true;
                z2 = true;
            } else {
                $jacocoInit[19] = true;
                z2 = false;
            }
            if (!z2) {
                $jacocoInit[20] = true;
            } else {
                $jacocoInit[21] = true;
                if (jenkinsInfo.getBuild_url().length() > 0) {
                    $jacocoInit[22] = true;
                    z3 = true;
                } else {
                    $jacocoInit[23] = true;
                }
                if (!z3) {
                    $jacocoInit[24] = true;
                } else {
                    $jacocoInit[25] = true;
                    builder.add("jenkinsInfo", load.getJenkinsInfo());
                    $jacocoInit[26] = true;
                }
            }
        }
        builder.add("versionCode", load.getVersionCode());
        $jacocoInit[27] = true;
        builder.add("versionName", load.getVersionName());
        $jacocoInit[28] = true;
        builder.add(DIDIDbTables.BaseSideBarNewColumn.START_TIME, String.valueOf(load.getStartTime()));
        $jacocoInit[29] = true;
        builder.add("endTime", String.valueOf(load.getEndTime()));
        $jacocoInit[30] = true;
        builder.add("appFlavor", load.getFlavor());
        $jacocoInit[31] = true;
        builder.add("appBuildType", load.getBuildType());
        try {
            $jacocoInit[32] = true;
            $jacocoInit[33] = true;
            Request.Builder builder2 = new Request.Builder();
            $jacocoInit[34] = true;
            Request.Builder post = builder2.post(builder.build());
            $jacocoInit[35] = true;
            Request.Builder url = post.url(this.coverageAddUrl);
            $jacocoInit[36] = true;
            Request build = url.build();
            $jacocoInit[37] = true;
            Call newCall = this.okHttpClient.newCall(build);
            $jacocoInit[38] = true;
            newCall.enqueue(new HttpClient$uploadFile$1(httpCallback));
            $jacocoInit[39] = true;
        } catch (Exception e) {
            $jacocoInit[40] = true;
            e.printStackTrace();
            $jacocoInit[41] = true;
        }
        $jacocoInit[42] = true;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/HttpClient$Companion;", "", "()V", "parseBase64", "", "file", "Ljava/io/File;", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: HttpClient.kt */
    public static final class Companion {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-6348064687822172822L, "com/didi/jacoco/runtime/HttpClient$Companion", 4);
            $jacocoData = probes;
            return probes;
        }

        private Companion() {
            $jacocoInit()[2] = true;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[3] = true;
        }

        public final String parseBase64(File file) {
            boolean[] $jacocoInit = $jacocoInit();
            Intrinsics.checkParameterIsNotNull(file, "file");
            $jacocoInit[0] = true;
            String encodeToString = Base64.encodeToString(FilesKt.readBytes(file), 11);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(fi…DDING or Base64.URL_SAFE)");
            $jacocoInit[1] = true;
            return encodeToString;
        }
    }
}
