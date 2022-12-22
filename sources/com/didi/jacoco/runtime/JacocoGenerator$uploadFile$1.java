package com.didi.jacoco.runtime;

import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import kotlin.Metadata;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/jacoco/runtime/JacocoGenerator$uploadFile$1", "Lcom/didi/jacoco/runtime/HttpCallback;", "onFailure", "", "msg", "", "onSuccess", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: JacocoGenerator.kt */
public final class JacocoGenerator$uploadFile$1 implements HttpCallback {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ File $file;
    final /* synthetic */ JacocoGenerator this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5944344170609242111L, "com/didi/jacoco/runtime/JacocoGenerator$uploadFile$1", 14);
        $jacocoData = probes;
        return probes;
    }

    JacocoGenerator$uploadFile$1(JacocoGenerator jacocoGenerator, File file) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = jacocoGenerator;
        this.$file = file;
        $jacocoInit[13] = true;
    }

    public void onSuccess() {
        boolean[] $jacocoInit = $jacocoInit();
        SystemUtils.log(6, "ec", "上传成功删除ec文件 " + this.$file.getAbsolutePath(), (Throwable) null, "com.didi.jacoco.runtime.JacocoGenerator$uploadFile$1", 58);
        $jacocoInit[0] = true;
        this.$file.delete();
        $jacocoInit[1] = true;
        if (this.this$0.getRuntime().callback == null) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            this.this$0.getRuntime().callback.onSuccess();
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
    }

    public void onFailure(String str) {
        String str2;
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("onFailure ");
        if (str != null) {
            $jacocoInit[6] = true;
            str2 = str;
        } else {
            $jacocoInit[7] = true;
            str2 = "";
        }
        sb.append(str2);
        SystemUtils.log(6, "ec", sb.toString(), (Throwable) null, "com.didi.jacoco.runtime.JacocoGenerator$uploadFile$1", 66);
        $jacocoInit[8] = true;
        if (this.this$0.getRuntime().callback == null) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            this.this$0.getRuntime().callback.onFailure(str);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }
}
