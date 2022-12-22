package com.jumio.core.extraction.liveness.extraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LivenessSavingTask extends Thread {

    /* renamed from: a */
    public final Queue<ImageSource> f54768a = new ConcurrentLinkedQueue();

    /* renamed from: b */
    public final LinkedList<ImageData> f54769b = new LinkedList<>();

    /* renamed from: c */
    public final int f54770c;

    /* renamed from: d */
    public final int f54771d;

    /* renamed from: e */
    public final File f54772e;

    /* renamed from: f */
    public long f54773f;

    /* renamed from: g */
    public boolean f54774g;

    /* renamed from: h */
    public boolean f54775h;

    /* renamed from: i */
    public PreviewProperties f54776i;

    /* renamed from: j */
    public Rect f54777j;

    /* renamed from: k */
    public int f54778k;

    /* renamed from: l */
    public final AuthorizationModel.SessionKey f54779l;

    public LivenessSavingTask(Context context, AuthorizationModel.SessionKey sessionKey, int i, int i2) {
        this.f54772e = Environment.getDataDirectory(context);
        this.f54779l = sessionKey;
        this.f54770c = i;
        this.f54771d = i2;
        reset();
    }

    /* renamed from: a */
    public final void mo162774a(ImageSource imageSource) {
        if (imageSource != null) {
            try {
                Locale locale = Locale.ENGLISH;
                int i = this.f54778k;
                this.f54778k = i + 1;
                String format = String.format(locale, "tmp_%04d", new Object[]{Integer.valueOf(i)});
                Bitmap yuv2bitmap = CameraUtils.yuv2bitmap(imageSource, this.f54775h, this.f54776i, this.f54777j, 640);
                File file = new File(this.f54772e, format);
                CameraUtils.saveBitmap(yuv2bitmap, file, Bitmap.CompressFormat.JPEG, 70, this.f54779l);
                ImageData imageData = new ImageData();
                imageData.getImage().setPath(file.getAbsolutePath());
                imageData.getImage().getSize().width = yuv2bitmap.getWidth();
                imageData.getImage().getSize().height = yuv2bitmap.getHeight();
                imageData.getImage().setType(ImageData.FileType.JPG);
                this.f54769b.addFirst(imageData);
                if (this.f54769b.size() > this.f54771d) {
                    new File(this.f54772e, this.f54769b.removeLast().getImage().getPath()).delete();
                }
                System.gc();
            } catch (Exception | OutOfMemoryError e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void add(ImageSource imageSource) {
        try {
            if (this.f54770c != 0 && this.f54776i != null) {
                if (this.f54777j != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!isInterrupted() && currentTimeMillis - this.f54773f >= 500) {
                        if (isActive()) {
                            this.f54773f = currentTimeMillis;
                            this.f54768a.add(imageSource);
                        }
                    }
                }
            }
        } catch (OutOfMemoryError e) {
            this.f54768a.clear();
            Log.printStackTrace(e);
            System.gc();
        }
    }

    public void addSync(ImageSource imageSource) {
        try {
            if (this.f54770c != 0 && this.f54776i != null) {
                if (this.f54777j != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!isInterrupted() && currentTimeMillis - this.f54773f >= 500) {
                        if (isActive()) {
                            this.f54773f = currentTimeMillis;
                            mo162774a(imageSource);
                        }
                    }
                }
            }
        } catch (OutOfMemoryError e) {
            Log.printStackTrace(e);
            System.gc();
        }
    }

    public ImageData[] finish() {
        int i = 0;
        setActive(false);
        int size = this.f54769b.size();
        int i2 = this.f54770c;
        if (size <= i2) {
            ImageData[] imageDataArr = new ImageData[this.f54769b.size()];
            while (i < this.f54769b.size()) {
                imageDataArr[(this.f54769b.size() - 1) - i] = this.f54769b.get(i);
                i++;
            }
            return imageDataArr;
        }
        ImageData[] imageDataArr2 = new ImageData[i2];
        int i3 = i2 / 2;
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 < i3) {
            imageDataArr2[i4] = this.f54769b.get(i5);
            i5++;
            i4--;
        }
        int i6 = this.f54770c;
        int i7 = (i6 / 2) + (i6 % 2);
        int size2 = ((this.f54769b.size() - 1) - i7) / i7;
        int size3 = this.f54769b.size() - 1;
        while (size3 >= i7 && i < i7) {
            imageDataArr2[i] = this.f54769b.get(size3);
            size3 -= size2;
            i++;
        }
        return imageDataArr2;
    }

    public void init(PreviewProperties previewProperties, Rect rect, boolean z) {
        this.f54776i = previewProperties;
        this.f54777j = rect;
        this.f54775h = z;
    }

    public synchronized boolean isActive() {
        return this.f54774g;
    }

    public void reset() {
        this.f54768a.clear();
        this.f54769b.clear();
        System.gc();
        this.f54778k = 0;
    }

    public void run() {
        while (!isInterrupted()) {
            mo162774a(this.f54768a.poll());
        }
        reset();
    }

    public synchronized void setActive(boolean z) {
        this.f54774g = z;
    }
}
