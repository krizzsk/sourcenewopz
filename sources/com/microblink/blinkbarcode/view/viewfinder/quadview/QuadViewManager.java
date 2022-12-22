package com.microblink.blinkbarcode.view.viewfinder.quadview;

import android.content.res.Configuration;
import com.microblink.blinkbarcode.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.blinkbarcode.view.recognition.DetectionStatus;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;

/* compiled from: line */
public class QuadViewManager {
    public IllIIIllII llIIlIlIIl;

    public QuadViewManager(IllIIIllII illIIIllII) {
        this.llIIlIlIIl = illIIIllII;
    }

    public void animateQuadToDefaultPosition() {
        this.llIIlIlIIl.llIIlIlIIl(DetectionStatus.FAIL);
    }

    public void animateQuadToDetectionPosition(DisplayableQuadDetection displayableQuadDetection) {
        if (displayableQuadDetection.getDisplayLocation().isEmpty()) {
            this.llIIlIlIIl.llIIlIlIIl(displayableQuadDetection.getDetectionStatus());
        } else {
            this.llIIlIlIIl.llIIlIlIIl(displayableQuadDetection.getTransformedDisplayLocation(), displayableQuadDetection.getDetectionStatus());
        }
    }

    public void configurationChanged(RecognizerRunnerView recognizerRunnerView, Configuration configuration) {
        if (recognizerRunnerView.getContext().getResources().getConfiguration().orientation == configuration.orientation) {
            this.llIIlIlIIl.setHostActivityOrientation(recognizerRunnerView.getHostScreenOrientation());
            return;
        }
        throw new IllegalStateException("You must first call changeConfiguration on recognizerView and then on QuadViewManager");
    }

    public boolean isAnimationInProgress() {
        return this.llIIlIlIIl.llIIlIlIIl();
    }

    public void setAnimationDuration(long j) {
        this.llIIlIlIIl.setAnimationDuration(j);
    }

    public void setAnimationListener(QuadViewAnimationListener quadViewAnimationListener) {
        this.llIIlIlIIl.setAnimationListener(quadViewAnimationListener);
    }

    public void setInitialHostActivityOrientation(int i) {
        this.llIIlIlIIl.setHostActivityOrientation(i);
    }

    public QuadViewManager() {
    }
}
