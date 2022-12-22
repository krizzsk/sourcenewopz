package com.microblink.blinkbarcode.fragment.overlay.components.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.metadata.detection.points.PointsType;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;
import com.microblink.blinkbarcode.view.viewfinder.points.PointSetView;

/* compiled from: line */
public class PointSetFeedbackHandler implements RecognitionFeedbackHandler {
    private PointsType IlIllIlIIl;
    private PointSetView llIIlIlIIl;

    public PointSetFeedbackHandler(PointsType pointsType) {
        this.IlIllIlIIl = pointsType;
    }

    public void clear() {
        this.llIIlIlIIl.clearDisplayedContent();
    }

    public View createView(RecognizerRunnerView recognizerRunnerView, MetadataCallbacks metadataCallbacks) {
        Context context = recognizerRunnerView.getContext();
        if (this.IlIllIlIIl == PointsType.MRTD_DETECTION) {
            this.llIIlIlIIl = new PointSetView(context, (AttributeSet) null, recognizerRunnerView.getHostScreenOrientation(), 7, context.getResources().getColor(R.color.mb_mrz_point_color));
        } else {
            this.llIIlIlIIl = new PointSetView(context, (AttributeSet) null, recognizerRunnerView.getHostScreenOrientation());
        }
        return this.llIIlIlIIl;
    }

    public void onOrientationChange(int i) {
        this.llIIlIlIIl.setHostActivityOrientation(i);
    }

    public void onPointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        if (displayablePointsDetection.getPointsType() == this.IlIllIlIIl) {
            this.llIIlIlIIl.addDisplayablePointsDetection(displayablePointsDetection);
        }
    }
}
