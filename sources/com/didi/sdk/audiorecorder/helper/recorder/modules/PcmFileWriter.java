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

public class PcmFileWriter extends AudioProcessModule implements Supporter.FileProvider, Supporter.Pcm16kConsumer, Supporter.Pcm8kConsumer {
    public static final String FILE_FLAG_PCM_16K = "_16k";
    public static final String FILE_FLAG_PCM_8K = "_8k";

    /* renamed from: a */
    private static final String f35389a = "PcmFileWriter -> ";

    /* renamed from: b */
    private Supporter.FileConsumer f35390b;

    /* renamed from: c */
    private volatile DataOutputStream f35391c;

    /* renamed from: d */
    private File f35392d;

    /* renamed from: e */
    private int f35393e;

    public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
    }

    public PcmFileWriter(String str) {
        if (FILE_FLAG_PCM_8K.equals(str)) {
            this.f35393e = 0;
        } else if (FILE_FLAG_PCM_16K.equals(str)) {
            this.f35393e = 1;
        } else {
            throw new IllegalArgumentException("Illegal file flag (must be '_8k' or '_16k'");
        }
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        if (this.f35391c == null) {
            return m25076a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        if (this.f35391c != null) {
            try {
                this.f35391c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Supporter.FileConsumer fileConsumer = this.f35390b;
            if (fileConsumer != null) {
                fileConsumer.onFileFeed(this.f35392d);
            }
        }
        this.f35391c = null;
        this.f35392d = null;
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        if (this.f35393e == 0) {
            m25075a(bArr, i);
        }
    }

    public void onPcm16kFeed(byte[] bArr, int i) {
        if (this.f35393e == 1) {
            m25075a(bArr, i);
        }
    }

    /* renamed from: a */
    private void m25075a(byte[] bArr, int i) {
        try {
            if (this.f35391c != null) {
                this.f35391c.write(bArr, 0, i);
            }
        } catch (IOException e) {
            File file = this.f35392d;
            if (file == null || !file.exists() || !this.f35392d.canWrite() || !this.f35392d.canRead()) {
                LogUtil.log("PcmFileWriter -> pcmToFile -> Failed to write data stream, switch data stream. ", e.getLocalizedMessage());
                m25076a();
            }
        }
    }

    public void setFileConsumer(Supporter.FileConsumer fileConsumer) {
        this.f35390b = fileConsumer;
    }

    public void sliceFile() {
        if (isStarted()) {
            m25076a();
        }
    }

    /* renamed from: a */
    private boolean m25076a() {
        m25079b();
        return m25077a(m25081c());
    }

    /* renamed from: b */
    private void m25079b() {
        if (this.f35391c != null) {
            try {
                this.f35391c.close();
                if (this.f35390b != null) {
                    this.f35390b.onFileFeed(this.f35392d);
                }
            } catch (IOException e) {
                LogUtil.log("PcmFileWriter -> closeCurrentDataStream failed. ", e);
            } catch (Throwable th) {
                this.f35391c = null;
                throw th;
            }
            this.f35391c = null;
        }
    }

    /* renamed from: a */
    private boolean m25077a(File file) {
        if (file == null) {
            LogUtil.log(f35389a, "createDataStreamToCacheDir -> Failed to getCacheDir");
            notifyError(1);
            return false;
        }
        File b = m25078b(file);
        if (b != null) {
            try {
                DataOutputStream c = m25080c(b);
                this.f35392d = b;
                this.f35391c = c;
                Supporter.FileConsumer fileConsumer = this.f35390b;
                if (fileConsumer != null) {
                    fileConsumer.onTmpFileCreated(b);
                }
                return true;
            } catch (Exception e) {
                LogUtil.log("PcmFileWriter -> createDataStreamToCacheDir -> failed to create stream. ", e);
                if (this.f35390b.isDefaultDir(file)) {
                    notifyError(3);
                    return false;
                }
                LogUtil.log(f35389a, "createDataStreamToCacheDir -> failed to create stream, change dir to default.");
                b.delete();
                return m25077a(this.f35390b.getDefaultDir());
            }
        } else if (this.f35390b.isDefaultDir(file)) {
            LogUtil.log(f35389a, "createDataStreamToCacheDir -> Failed to create File");
            notifyError(2);
            return false;
        } else {
            LogUtil.log(f35389a, "createDataStreamToCacheDir -> Failed to create File, change dir to default.");
            return m25077a(this.f35390b.getDefaultDir());
        }
    }

    /* renamed from: c */
    private File m25081c() {
        File cacheDir = this.f35390b.getCacheDir();
        if (cacheDir != null) {
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            if (cacheDir.canRead() && cacheDir.canWrite()) {
                LogUtil.log(f35389a, "getCacheDir -> target dir available: ", cacheDir.getAbsolutePath());
                return cacheDir;
            }
        }
        if (this.f35390b.isDefaultDir(cacheDir)) {
            return null;
        }
        LogUtil.log(f35389a, "getCacheDir -> default dir available: ", this.f35390b.getDefaultDir().getAbsolutePath());
        return this.f35390b.getDefaultDir();
    }

    /* renamed from: b */
    private File m25078b(File file) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append(this.f35393e == 0 ? FILE_FLAG_PCM_8K : FILE_FLAG_PCM_16K);
        sb.append(".pcm");
        File file2 = new File(file, sb.toString());
        if (file2.exists()) {
            LogUtil.log(f35389a, "createTempFile -> success: ", file2.getAbsolutePath());
            return file2;
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            LogUtil.log(f35389a, "createTempFile -> failed to create new file: ", file2.getAbsolutePath());
            return null;
        } catch (IOException e) {
            LogUtil.log(f35389a, "createTempFile -> exception in creating new file: ", file2.getAbsolutePath(), e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: c */
    private DataOutputStream m25080c(File file) throws FileNotFoundException {
        return new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }
}
