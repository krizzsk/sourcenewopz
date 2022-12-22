package com.didichuxing.sdk.alphaface.core.liveness;

public interface ILivenessCallback extends IActionCallback, IMirrorCallback {
    public static final int BLINK_EYE = 1;
    public static final int FACE_BLUR = 10;
    public static final int FACE_ILLUM = 11;
    public static final int FACE_LOST = 0;
    public static final int FACE_NORMAL = -1;
    public static final int FACE_NOT_IN_CENTER = 5;
    public static final int FACE_OCC = 9;
    public static final int FACE_POSE = 8;
    public static final int FACE_TOO_CLOSE = 6;
    public static final int FACE_TOO_FAR = 7;
    public static final int NOD = 4;
    public static final int OPEN_MOUTH = 2;
    public static final int SHAKE_HEAD = 3;

    public static class PicWithScore {
        public double attackScore;
        public int height;
        public double qualityOk;
        public double qualityScore;
        public byte[] rgba;
        public int width;
    }

    void onRestart();

    void onSuccess(LivenessResult livenessResult);
}
