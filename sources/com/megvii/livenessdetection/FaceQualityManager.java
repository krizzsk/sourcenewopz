package com.megvii.livenessdetection;

import android.graphics.RectF;
import com.megvii.livenessdetection.bean.FaceInfo;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class FaceQualityManager {
    public boolean LimitRect = true;

    /* renamed from: a */
    private float f55782a = 0.5f;

    /* renamed from: b */
    private float f55783b = 0.5f;

    /* renamed from: c */
    private int f55784c = 0;
    public float eyeLeftOcclusion = 0.5f;
    public float faceMaxSizeRatioThreshold = 0.4f;
    public float faceWidthThreshold = 150.0f;
    public float gaussianBlurThreshold = 0.15f;
    public float integrityThreshold = 0.99f;
    public float maxBrightnessThreshold = 230.0f;
    public float minBrightnessThreshold = 70.0f;
    public float motionBlurThreshold = 0.2f;
    public float mouthOcclusion = 0.5f;
    public int needHolding = 3;
    public float pitchThreshold = 0.17f;
    public float yawThreshold = 0.17f;

    public enum FaceQualityErrorType {
        NONE,
        FRAME_NEED_HOLDING,
        FACE_NOT_FOUND,
        FACE_POS_DEVIATED,
        FACE_NONINTEGRITY,
        FACE_TOO_DARK,
        FACE_TOO_BRIGHT,
        FACE_TOO_SMALL,
        FACE_TOO_LARGE,
        FACE_TOO_BLURRY,
        FACE_OUT_OF_RECT,
        FACE_EYE_OCCLUSIVE,
        FACE_MOUTH_OCCLUSIVE
    }

    public FaceQualityManager(float f, float f2) {
        this.f55782a = f;
        this.f55783b = f2;
    }

    public synchronized List<FaceQualityErrorType> feedFrame(DetectionFrame detectionFrame) {
        LinkedList linkedList;
        int i;
        int i2;
        linkedList = new LinkedList();
        if (detectionFrame != null) {
            if (detectionFrame.getRotation() % 180 == 0) {
                i = detectionFrame.getImageWidth();
            } else {
                i = detectionFrame.getImageHeight();
            }
            if (detectionFrame.getRotation() % 180 == 0) {
                i2 = detectionFrame.getImageHeight();
            } else {
                i2 = detectionFrame.getImageWidth();
            }
            FaceInfo faceInfo = detectionFrame.getFaceInfo();
            if (faceInfo == null) {
                linkedList.add(FaceQualityErrorType.FACE_NOT_FOUND);
            } else {
                RectF facePos = detectionFrame.getFacePos();
                float sqrt = (float) Math.sqrt(Math.pow((double) ((facePos.centerX() - this.f55782a) * ((float) i)), 2.0d) + Math.pow((double) ((facePos.centerY() - this.f55783b) * ((float) i2)), 2.0d));
                if (this.LimitRect && sqrt / ((float) faceInfo.faceSize.width()) > 0.5f) {
                    linkedList.add(FaceQualityErrorType.FACE_OUT_OF_RECT);
                }
                if (Math.abs(faceInfo.yaw) > this.yawThreshold || Math.abs(faceInfo.pitch) > this.pitchThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_POS_DEVIATED);
                }
                if (faceInfo.integrity < this.integrityThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_NONINTEGRITY);
                }
                if (faceInfo.brightness < this.minBrightnessThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_TOO_DARK);
                }
                if (faceInfo.brightness > this.maxBrightnessThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_TOO_BRIGHT);
                }
                if (((float) faceInfo.faceSize.width()) < this.faceWidthThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_TOO_SMALL);
                }
                if (facePos.width() > this.faceMaxSizeRatioThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_TOO_LARGE);
                }
                if (faceInfo.motionBlur > this.motionBlurThreshold || faceInfo.gaussianBlur > this.gaussianBlurThreshold) {
                    linkedList.add(FaceQualityErrorType.FACE_TOO_BLURRY);
                }
                if (faceInfo.eyeLeftOcclusion > this.eyeLeftOcclusion || faceInfo.eyeRightOcclusion > this.eyeLeftOcclusion) {
                    linkedList.add(FaceQualityErrorType.FACE_EYE_OCCLUSIVE);
                }
                if (faceInfo.mouthOcclusion > this.mouthOcclusion) {
                    linkedList.add(FaceQualityErrorType.FACE_MOUTH_OCCLUSIVE);
                }
            }
            if (linkedList.size() == 0) {
                int i3 = this.f55784c;
                this.f55784c = i3 + 1;
                if (i3 < this.needHolding) {
                    linkedList.add(FaceQualityErrorType.FRAME_NEED_HOLDING);
                }
            } else {
                this.f55784c = 0;
            }
        } else {
            throw new InvalidParameterException("detectionFrame could not be null");
        }
        return new LinkedList(linkedList);
    }
}
