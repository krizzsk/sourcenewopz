package com.microblink.blinkbarcode.view.viewfinder.points;

import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.view.viewfinder.IDetectionView;

/* compiled from: line */
public interface IDisplayablePointsView extends IDetectionView {
    void addDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection);

    void setDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection);
}
