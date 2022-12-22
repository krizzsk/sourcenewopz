package com.didi.dqr.task.decoder;

import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.DetectorResult;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.qrcode.decoder.Decoder;
import com.didi.dqr.qrcode.detector.Detector;
import com.didi.dqr.qrcode.detector.FinderPattern;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;
import com.didi.dqr.task.base.DqrTask;
import com.didi.dqr.task.base.DqrTaskData;
import com.didi.dqr.task.base.DqrTaskType;
import com.didi.dqrutil.DqrConfigHelper;

public class DecoderTask extends DqrTask {
    public DqrTaskType getTaskType() {
        return DqrTaskType.TASK_DECODE;
    }

    public DqrTaskData run(DqrTaskData dqrTaskData) throws Exception {
        Detector detector = new Detector(dqrTaskData.getBinaryBitmap().getBlackMatrix());
        Decoder decoder = new Decoder();
        if (dqrTaskData.getDetectorResult() == null) {
            return dqrTaskData;
        }
        DqrTaskData dqrTaskData2 = dqrTaskData;
        for (DetectorResult next : dqrTaskData.getDetectorResult().detectorResults) {
            dqrTaskData2 = m14320a(next, detector, decoder, dqrTaskData2, dqrTaskData2.getDetectorResult().fromAutoCompete || dqrTaskData2.getDetectorResult().fromAutoCorrect);
            if (dqrTaskData2 != null && dqrTaskData2.isFinished()) {
                MultiDetectorResult multiDetectorResult = new MultiDetectorResult();
                multiDetectorResult.addDetectorResult(next);
                dqrTaskData2.setDetectorResult(multiDetectorResult);
                return dqrTaskData2;
            }
        }
        return dqrTaskData2;
    }

    /* renamed from: a */
    private DqrTaskData m14320a(DetectorResult detectorResult, Detector detector, Decoder decoder, DqrTaskData dqrTaskData, boolean z) {
        DecoderResult decoderResult;
        try {
            FinderPatternInfo finderPatternInfo = detectorResult.info;
            if (DqrConfigHelper.caculateIncline() && z) {
                decoderResult = null;
                int i = 0;
                boolean z2 = true;
                loop0:
                while (true) {
                    if (i >= 3) {
                        break;
                    }
                    for (int i2 = 0; i2 < 3; i2++) {
                        if (i != i2 || z2) {
                            if (!z2) {
                                try {
                                    detectorResult = detector.processFinderPatternInfo(new FinderPatternInfo(m14321a(finderPatternInfo, i, i2), true), detectorResult.reCaculateMoudleSize);
                                } catch (Exception unused) {
                                }
                            } else {
                                try {
                                    detectorResult = detector.processFinderPatternInfo(detectorResult.info, detectorResult.reCaculateMoudleSize);
                                    z2 = false;
                                } catch (Exception unused2) {
                                    z2 = false;
                                }
                            }
                            decoderResult = decoder.decode(detectorResult.getBits(), dqrTaskData.getDecodeOptions().baseHints);
                            if (decoderResult != null) {
                                if (decoderResult.getText() != null && decoderResult.getText().length() > 0) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    i++;
                }
            } else {
                decoderResult = decoder.decode(detector.processFinderPatternInfo(detectorResult.info, detectorResult.reCaculateMoudleSize).getBits(), dqrTaskData.getDecodeOptions().baseHints);
            }
            dqrTaskData.setDecoderResult(decoderResult);
            return dqrTaskData;
        } catch (Exception unused3) {
            return null;
        }
    }

    /* renamed from: a */
    private FinderPattern[] m14321a(FinderPatternInfo finderPatternInfo, int i, int i2) {
        FinderPattern[] finderPatternArr = new FinderPattern[3];
        System.arraycopy(finderPatternInfo.getPatternCenters(), 0, finderPatternArr, 0, 3);
        FinderPattern finderPattern = finderPatternArr[i];
        finderPatternArr[i] = finderPatternArr[i2];
        finderPatternArr[i2] = finderPattern;
        return finderPatternArr;
    }
}
