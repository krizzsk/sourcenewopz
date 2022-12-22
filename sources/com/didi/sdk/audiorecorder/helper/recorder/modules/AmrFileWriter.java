package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class AmrFileWriter extends AudioProcessModule implements Supporter.AmrConsumer, Supporter.FileProvider {

    /* renamed from: a */
    private static final String f35371a = "AmrFileWriter -> ";

    /* renamed from: b */
    private static final byte[] f35372b = {35, 33, 65, 77, 82, 10};

    /* renamed from: c */
    private Supporter.FileConsumer f35373c;

    /* renamed from: d */
    private volatile DataOutputStream f35374d;

    /* renamed from: e */
    private File f35375e;

    /* access modifiers changed from: protected */
    public boolean performStart() {
        if (this.f35374d == null) {
            return m25062a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        if (this.f35374d != null) {
            try {
                this.f35374d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Supporter.FileConsumer fileConsumer = this.f35373c;
            if (fileConsumer != null) {
                fileConsumer.onFileFeed(this.f35375e);
            }
        }
        this.f35374d = null;
        this.f35375e = null;
    }

    public void onAmrFeed(byte[] bArr, int i) {
        try {
            if (this.f35374d != null) {
                this.f35374d.write(bArr, 0, i);
            }
        } catch (IOException e) {
            File file = this.f35375e;
            if (file == null || !file.exists() || !this.f35375e.canWrite() || !this.f35375e.canRead()) {
                LogUtil.log("AmrFileWriter -> onAmrFeed -> Failed to write data stream, switch data stream. ", e.getLocalizedMessage());
                m25062a();
            }
        }
    }

    public void setFileConsumer(Supporter.FileConsumer fileConsumer) {
        this.f35373c = fileConsumer;
    }

    public void sliceFile() {
        if (isStarted()) {
            m25062a();
        }
    }

    /* renamed from: a */
    private boolean m25062a() {
        m25065b();
        return m25063a(m25067c());
    }

    /* renamed from: b */
    private void m25065b() {
        if (this.f35374d != null) {
            try {
                this.f35374d.close();
                if (this.f35373c != null) {
                    this.f35373c.onFileFeed(this.f35375e);
                }
            } catch (IOException e) {
                LogUtil.log("AmrFileWriter -> closeCurrentDataStream failed. ", e);
            } catch (Throwable th) {
                this.f35374d = null;
                throw th;
            }
            this.f35374d = null;
        }
    }

    /* renamed from: a */
    private boolean m25063a(File file) {
        if (file == null) {
            LogUtil.log(f35371a, "createDataStreamToCacheDir -> Failed to getCacheDir");
            notifyError(1);
            return false;
        }
        File b = m25064b(file);
        if (b != null) {
            try {
                DataOutputStream c = m25066c(b);
                try {
                    c.write(f35372b);
                    this.f35375e = b;
                    this.f35374d = c;
                    Supporter.FileConsumer fileConsumer = this.f35373c;
                    if (fileConsumer != null) {
                        fileConsumer.onTmpFileCreated(b);
                    }
                    return true;
                } catch (Exception e) {
                    LogUtil.log("AmrFileWriter -> createDataStreamToCacheDir -> failed to write amr FILE_HEADER to file: " + b.getAbsolutePath(), e);
                    if (this.f35373c.isDefaultDir(file)) {
                        notifyError(4);
                        return false;
                    }
                    LogUtil.log(f35371a, "createDataStreamToCacheDir -> failed to write amr FILE_HEADER to file, change dir to default.");
                    b.delete();
                    return m25063a(this.f35373c.getDefaultDir());
                }
            } catch (Exception e2) {
                LogUtil.log("AmrFileWriter -> createDataStreamToCacheDir -> failed to create stream. ", e2);
                if (this.f35373c.isDefaultDir(file)) {
                    notifyError(3);
                    return false;
                }
                LogUtil.log(f35371a, "createDataStreamToCacheDir -> failed to create stream, change dir to default.");
                b.delete();
                return m25063a(this.f35373c.getDefaultDir());
            }
        } else if (this.f35373c.isDefaultDir(file)) {
            LogUtil.log(f35371a, "createDataStreamToCacheDir -> Failed to create File");
            notifyError(2);
            return false;
        } else {
            LogUtil.log(f35371a, "createDataStreamToCacheDir -> Failed to create File, change dir to default.");
            return m25063a(this.f35373c.getDefaultDir());
        }
    }

    /* renamed from: c */
    private File m25067c() {
        File cacheDir = this.f35373c.getCacheDir();
        if (cacheDir != null) {
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            if (cacheDir.canRead() && cacheDir.canWrite()) {
                LogUtil.log(f35371a, "getCacheDir -> target dir available: ", cacheDir.getAbsolutePath());
                return cacheDir;
            }
        }
        if (this.f35373c.isDefaultDir(cacheDir)) {
            return null;
        }
        LogUtil.log(f35371a, "getCacheDir -> default dir available: ", this.f35373c.getDefaultDir().getAbsolutePath());
        return this.f35373c.getDefaultDir();
    }

    /* renamed from: b */
    private File m25064b(File file) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        File file2 = new File(file, replace + ".amr");
        if (file2.exists()) {
            LogUtil.log(f35371a, "createTempFile -> success: ", file2.getAbsolutePath());
            return file2;
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            LogUtil.log(f35371a, "createTempFile -> failed to create new file: ", file2.getAbsolutePath());
            return null;
        } catch (IOException e) {
            LogUtil.log(f35371a, "createTempFile -> exception in creating new file: ", file2.getAbsolutePath(), e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: c */
    private DataOutputStream m25066c(File file) throws FileNotFoundException {
        return new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }
}
