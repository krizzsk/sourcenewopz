package com.didichuxing.sdk.alphaface.core.liveness;

import android.graphics.Point;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.Arrays;
import java.util.List;

public interface IMirrorCallback {
    void onDetectFace(FaceInfo faceInfo);

    void onFaceError(int i);

    void onMirrorFaceQualityError();

    void onMirrorProcess(long j);

    void onMirrorReset();

    void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3);

    public static class FaceInfo {
        public Point[] keyPoints;
        public Point leftTop;
        public Point rightBottom;

        public String toString() {
            return "FaceInfo{leftTop=" + this.leftTop + ", rightBottom=" + this.rightBottom + ", keyPoints=" + Arrays.toString(this.keyPoints) + '}';
        }
    }
}
