package com.jumio.core.extraction.facemanual;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.MobileContext;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.extraction.liveness.extraction.LivenessSavingTask;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.atomic.AtomicBoolean;

public class FaceManualClient extends ExtractionClient {

    /* renamed from: g */
    public final AtomicBoolean f54762g = new AtomicBoolean(false);

    /* renamed from: h */
    public final AtomicBoolean f54763h = new AtomicBoolean(false);

    /* renamed from: i */
    public LivenessSavingTask f54764i;

    public FaceManualClient(Context context) {
        super(context);
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        SettingsModel settingsModel = (SettingsModel) dataManager.get(SettingsModel.class);
        if (settingsModel != null) {
            Context context = this.context;
            this.f54764i = new LivenessSavingTask(context, ((MobileContext) context).getSessionKey(), settingsModel.getMaxLivenessImages(), 60);
        }
    }

    public void destroy() {
        super.destroy();
    }

    public Size getPreferredPreviewSize() {
        return new Size(1280, 720);
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        this.f54762g.set(false);
        this.f54763h.set(false);
        this.f54764i.init(previewProperties, rect, previewProperties.isPortrait);
        this.f54764i.setActive(true);
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect) {
        boolean z = true;
        try {
            LivenessSavingTask livenessSavingTask = this.f54764i;
            if (livenessSavingTask != null) {
                livenessSavingTask.addSync(imageSource);
            }
            if (!this.f54762g.get() || this.f54763h.get()) {
                this.f54762g.set(false);
                z = false;
                System.gc();
                setResult(z);
            }
            this.f54763h.set(true);
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(1.0f)));
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.saveImage, CameraUtils.yuv2bitmap(imageSource, previewProperties.isPortrait, previewProperties, rect, -1)));
            LivenessDataModel livenessDataModel = new LivenessDataModel();
            livenessDataModel.setType(ScanMode.FACE_MANUAL);
            livenessDataModel.setPassed((Boolean) null);
            LivenessSavingTask livenessSavingTask2 = this.f54764i;
            if (livenessSavingTask2 != null) {
                livenessDataModel.setFrames(livenessSavingTask2.finish());
            }
            publishResult(livenessDataModel);
            System.gc();
            System.gc();
            setResult(z);
        } catch (Exception e) {
            Log.m39477w("ImageCheck", "computeFocusConfidence failed!", (Throwable) e);
        }
    }

    public boolean shouldFeed() {
        return !this.f54763h.get();
    }

    public void takePicture() {
        this.f54762g.set(true);
    }

    public boolean takePictureManually() {
        return true;
    }
}
