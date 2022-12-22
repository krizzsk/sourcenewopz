package com.jumio.core.extraction.manual;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManualPictureClient extends ExtractionClient {

    /* renamed from: g */
    public final AtomicBoolean f54791g = new AtomicBoolean(false);

    /* renamed from: h */
    public final AtomicBoolean f54792h = new AtomicBoolean(false);

    public ManualPictureClient(Context context) {
        super(context);
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        this.f54791g.set(false);
        this.f54792h.set(false);
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect) {
        boolean z = true;
        try {
            if (!this.f54791g.get() || this.f54792h.get()) {
                this.f54791g.set(false);
                z = false;
                imageSource.delete();
                setResult(z);
            }
            this.f54792h.set(true);
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(1.0f)));
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.saveImage, CameraUtils.yuv2bitmap(imageSource, previewProperties.isPortrait, previewProperties, rect, -1)));
            publishResult(null);
            System.gc();
            imageSource.delete();
            setResult(z);
        } catch (Exception e) {
            Log.m39477w("ImageCheck", "computeFocusConfidence failed!", (Throwable) e);
        }
    }

    public boolean shouldFeed() {
        return !this.f54792h.get();
    }

    public void takePicture() {
        this.f54791g.set(true);
    }

    public boolean takePictureManually() {
        return true;
    }
}
