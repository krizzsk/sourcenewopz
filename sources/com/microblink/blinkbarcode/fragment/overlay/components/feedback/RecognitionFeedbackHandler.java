package com.microblink.blinkbarcode.fragment.overlay.components.feedback;

import android.view.View;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;

/* compiled from: line */
public interface RecognitionFeedbackHandler {
    public static final RecognitionFeedbackHandler EMPTY = new RecognitionFeedbackHandler() {
        public void clear() {
        }

        public View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks) {
            return null;
        }

        public void onOrientationChange(int i) {
        }

        public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        }
    };

    void clear();

    View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks);

    void onOrientationChange(int i);

    void onPointsDetection(DisplayablePointsDetection displayablePointsDetection);
}
