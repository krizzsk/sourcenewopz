package com.jumio.core.extraction;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.model.PublisherWithUpdate;
import com.jumio.core.model.StaticModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageFormat;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ExtractionClient extends PublisherWithUpdate<ExtractionUpdate, StaticModel> {

    /* renamed from: b */
    public final AtomicBoolean f54713b;

    /* renamed from: c */
    public final AtomicBoolean f54714c;
    public Context context;

    /* renamed from: d */
    public C19970a f54715d;

    /* renamed from: e */
    public PreviewProperties f54716e;

    /* renamed from: f */
    public Rect f54717f;
    public boolean isTablet;
    public boolean shouldInitAsync = false;

    public static class ExtractionUpdate<T> {

        /* renamed from: a */
        public final T f54718a;

        /* renamed from: b */
        public final int f54719b;

        public ExtractionUpdate(int i, T t) {
            this.f54719b = i;
            this.f54718a = t;
        }

        public T getData() {
            return this.f54718a;
        }

        public int getState() {
            return this.f54719b;
        }
    }

    public class InitThread extends Thread {

        /* renamed from: a */
        public final PreviewProperties f54720a;

        /* renamed from: b */
        public final Rect f54721b;

        public InitThread(PreviewProperties previewProperties, Rect rect) {
            this.f54720a = previewProperties;
            this.f54721b = rect;
        }

        public void run() {
            ExtractionClient.this.init(this.f54720a, this.f54721b);
        }
    }

    /* renamed from: com.jumio.core.extraction.ExtractionClient$a */
    public class C19970a extends Thread {

        /* renamed from: a */
        public final Semaphore f54723a = new Semaphore(0);

        /* renamed from: b */
        public byte[] f54724b;

        public C19970a() {
        }

        /* renamed from: a */
        public void mo162696a(byte[] bArr) {
            if (ExtractionClient.this.f54713b.get() && ExtractionClient.this.shouldFeed() && ExtractionClient.this.f54714c.compareAndSet(false, true)) {
                byte[] bArr2 = this.f54724b;
                if (bArr2 == null || bArr2.length != bArr.length) {
                    this.f54724b = new byte[bArr.length];
                }
                System.arraycopy(bArr, 0, this.f54724b, 0, bArr.length);
                this.f54723a.release();
            }
        }

        public synchronized void run() {
            while (!isInterrupted()) {
                try {
                    this.f54723a.acquire();
                    int i = ExtractionClient.this.f54716e.camera.width;
                    ImageSource CreateFromUncompressedByteArray = ImageSource.CreateFromUncompressedByteArray(this.f54724b, i, ExtractionClient.this.f54716e.camera.height, ImageFormat.YUVNV21, i);
                    ExtractionClient extractionClient = ExtractionClient.this;
                    extractionClient.process(CreateFromUncompressedByteArray, extractionClient.f54716e, ExtractionClient.this.f54717f);
                } catch (InterruptedException unused) {
                    interrupt();
                } catch (Exception e) {
                    Log.printStackTrace(e);
                    ExtractionClient.this.setResult(false);
                }
            }
            notifyAll();
        }
    }

    public ExtractionClient(Context context2) {
        this.context = context2;
        Environment.loadJniJvCoreLib();
        Environment.loadJniImageQualityLib();
        this.f54713b = new AtomicBoolean(false);
        this.f54714c = new AtomicBoolean(false);
    }

    public void cancel() {
        setDataExtractionActive(false);
        System.gc();
    }

    public void cleanImages(ImageSource... imageSourceArr) {
        for (ImageSource imageSource : imageSourceArr) {
            if (imageSource != null) {
                imageSource.delete();
            }
        }
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
    }

    public void destroy() {
        cancel();
        C19970a aVar = this.f54715d;
        if (aVar != null) {
            aVar.interrupt();
            this.f54715d = null;
        }
    }

    public synchronized void feed(byte[] bArr) {
        C19970a aVar = this.f54715d;
        if (aVar != null) {
            aVar.mo162696a(bArr);
        }
    }

    public Size getPreferredPreviewSize() {
        return null;
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
    }

    public boolean isDataExtractionActive() {
        return this.f54713b.get();
    }

    public boolean isProcessing() {
        return this.f54714c.get();
    }

    public abstract void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect);

    public void reinit() {
        if (this.f54717f != null && this.f54716e != null) {
            if (this.f54715d == null) {
                C19970a aVar = new C19970a();
                this.f54715d = aVar;
                aVar.start();
            }
            if (!this.f54713b.get()) {
                if (this.shouldInitAsync) {
                    new InitThread(this.f54716e, this.f54717f).start();
                } else {
                    init(this.f54716e, this.f54717f);
                }
            }
            this.f54714c.set(false);
        }
    }

    public void setDataExtractionActive(boolean z) {
        this.f54713b.set(z);
    }

    public void setExtractionArea(Rect rect) {
        this.f54717f = new Rect(rect);
    }

    public void setPreviewProperties(PreviewProperties previewProperties) {
        if (previewProperties != null) {
            this.f54716e = previewProperties.copy();
        }
    }

    public void setResult(boolean z) {
        this.f54714c.set(z);
    }

    public abstract boolean shouldFeed();

    public void takePicture() {
    }

    public boolean takePictureManually() {
        return false;
    }
}
