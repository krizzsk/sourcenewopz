package com.didi.dqr.task.detector;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.qrcode.decoder.AutoCompleDetector;
import com.didi.dqr.qrcode.detector.Detector;
import com.didi.dqr.task.base.DqrTask;
import com.didi.dqr.task.base.DqrTaskData;
import com.didi.dqr.task.base.DqrTaskType;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.util.Map;

public class DetectorTask extends DqrTask {
    public DqrTaskType getTaskType() {
        return DqrTaskType.TASK_DETECTOR;
    }

    public DqrTaskData run(DqrTaskData dqrTaskData) throws Exception {
        ResultPoint[] points;
        DecodeOptions decodeOptions = dqrTaskData.getDecodeOptions();
        Map<DecodeHintType, ?> map = decodeOptions.baseHints;
        BitMatrix blackMatrix = dqrTaskData.getBinaryBitmap().getBlackMatrix();
        MultiDetectorResult detect = new Detector(blackMatrix).detect(map);
        DecodeOptions.IAutoZoomListener iAutoZoomListener = decodeOptions.autoZoomListener;
        if (iAutoZoomListener != null && detect.success() && (points = detect.detectorResults.get(0).getPoints()) != null && points.length == 3) {
            if (iAutoZoomListener.autoZoom(decodeOptions.prevRect, ResultPoint.distance(points[0], points[1]))) {
                return null;
            }
        }
        if (detect.success() || !DqrConfigHelper.usePatternAutoComple()) {
            AnalysisManager.report(EventId.DQR_SCAN_GET_QR);
        } else {
            try {
                AutoCompleDetector autoCompleDetector = new AutoCompleDetector(blackMatrix);
                System.currentTimeMillis();
                detect = autoCompleDetector.decode(detect.detectorResults.get(0), map);
                System.currentTimeMillis();
            } catch (Exception unused) {
                AnalysisManager.report(EventId.DQR_SCAN_GET_QR);
            }
        }
        dqrTaskData.setDetectorResult(detect);
        return dqrTaskData;
    }
}
