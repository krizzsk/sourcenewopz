package com.didi.jacoco.runtime;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.didi.jacoco.api.ICoverageConfig;
import com.didi.jacoco.runtime.activity.ChooseRoleActivity;
import java.io.File;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlinx.coroutines.DebugKt;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

public class JacocoRuntime {
    private static transient /* synthetic */ boolean[] $jacocoData = null;

    /* renamed from: EC */
    private static final String f24384EC = "coverage";
    public static JacocoRuntime jacocoRuntime;
    public UploadCallback callback;
    public final Context context;
    public ICoverageConfig coverageConfig;
    public final JacocoGenerator generator;
    public File outPutDir;
    public long startTime = System.currentTimeMillis();

    public interface UploadCallback {
        void onFailure(String str);

        void onSuccess();
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2459987570936059703L, "com/didi/jacoco/runtime/JacocoRuntime", 25);
        $jacocoData = probes;
        return probes;
    }

    public JacocoRuntime(Builder builder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.outPutDir = Builder.access$000(builder);
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        this.context = Builder.access$100(builder);
        $jacocoInit[3] = true;
        this.coverageConfig = Builder.access$200(builder);
        if (this.outPutDir != null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            this.outPutDir = new File(this.context.getExternalCacheDir(), f24384EC);
            $jacocoInit[6] = true;
        }
        this.generator = new JacocoGenerator(this);
        $jacocoInit[7] = true;
        this.callback = Builder.access$300(builder);
        $jacocoInit[8] = true;
        try {
            this.context.registerReceiver(new JacocoReceiver(this.generator), JacocoReceiver.getJacocoIntentFilter());
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        jacocoRuntime = this;
        $jacocoInit[9] = true;
    }

    public void generateCoverageFile(boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this.context, ChooseRoleActivity.class);
        $jacocoInit[10] = true;
        intent.putExtra(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, z);
        $jacocoInit[11] = true;
        intent.setFlags(268435456);
        $jacocoInit[12] = true;
        this.context.startActivity(intent);
        $jacocoInit[13] = true;
    }

    public void init() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.outPutDir.listFiles() == null) {
            $jacocoInit[14] = true;
        } else if (this.outPutDir.listFiles().length == 0) {
            $jacocoInit[15] = true;
        } else {
            File[] listFiles = this.outPutDir.listFiles();
            int length = listFiles.length;
            int i = 0;
            $jacocoInit[17] = true;
            while (i < length) {
                File file = listFiles[i];
                $jacocoInit[18] = true;
                this.generator.uploadFiles(file.listFiles());
                i++;
                $jacocoInit[19] = true;
            }
            $jacocoInit[20] = true;
            return;
        }
        $jacocoInit[16] = true;
    }

    private void loadConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Iterator<S> it = ServiceLoader.load(ICoverageConfig.class).iterator();
        $jacocoInit[21] = true;
        if (it.hasNext()) {
            this.coverageConfig = (ICoverageConfig) it.next();
            $jacocoInit[24] = true;
            return;
        }
        $jacocoInit[22] = true;
        RuntimeException runtimeException = new RuntimeException("未找到jacoco配置信息");
        $jacocoInit[23] = true;
        throw runtimeException;
    }

    public static class Builder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private UploadCallback callback;
        private Context context;
        private ICoverageConfig coverageConfig;
        private File outPutDir;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8700191395535845242L, "com/didi/jacoco/runtime/JacocoRuntime$Builder", 13);
            $jacocoData = probes;
            return probes;
        }

        public Builder() {
            $jacocoInit()[0] = true;
        }

        static /* synthetic */ File access$000(Builder builder) {
            boolean[] $jacocoInit = $jacocoInit();
            File file = builder.outPutDir;
            $jacocoInit[9] = true;
            return file;
        }

        static /* synthetic */ Context access$100(Builder builder) {
            boolean[] $jacocoInit = $jacocoInit();
            Context context2 = builder.context;
            $jacocoInit[10] = true;
            return context2;
        }

        static /* synthetic */ ICoverageConfig access$200(Builder builder) {
            boolean[] $jacocoInit = $jacocoInit();
            ICoverageConfig iCoverageConfig = builder.coverageConfig;
            $jacocoInit[11] = true;
            return iCoverageConfig;
        }

        static /* synthetic */ UploadCallback access$300(Builder builder) {
            boolean[] $jacocoInit = $jacocoInit();
            UploadCallback uploadCallback = builder.callback;
            $jacocoInit[12] = true;
            return uploadCallback;
        }

        public Builder outPutDir(File file) {
            boolean[] $jacocoInit = $jacocoInit();
            if (file != null) {
                this.outPutDir = file;
                $jacocoInit[2] = true;
                return this;
            }
            NullPointerException nullPointerException = new NullPointerException("dir == null");
            $jacocoInit[1] = true;
            throw nullPointerException;
        }

        public Builder context(Context context2) {
            boolean[] $jacocoInit = $jacocoInit();
            if (context2 != null) {
                this.context = context2;
                $jacocoInit[4] = true;
                return this;
            }
            NullPointerException nullPointerException = new NullPointerException("context == null");
            $jacocoInit[3] = true;
            throw nullPointerException;
        }

        public Builder coverageConfig(ICoverageConfig iCoverageConfig) {
            boolean[] $jacocoInit = $jacocoInit();
            this.coverageConfig = iCoverageConfig;
            $jacocoInit[5] = true;
            return this;
        }

        public Builder uploadCallback(UploadCallback uploadCallback) {
            boolean[] $jacocoInit = $jacocoInit();
            if (uploadCallback != null) {
                this.callback = uploadCallback;
                $jacocoInit[7] = true;
                return this;
            }
            NullPointerException nullPointerException = new NullPointerException("callback == null");
            $jacocoInit[6] = true;
            throw nullPointerException;
        }

        public JacocoRuntime build() {
            boolean[] $jacocoInit = $jacocoInit();
            JacocoRuntime jacocoRuntime = new JacocoRuntime(this);
            $jacocoInit[8] = true;
            return jacocoRuntime;
        }
    }
}
