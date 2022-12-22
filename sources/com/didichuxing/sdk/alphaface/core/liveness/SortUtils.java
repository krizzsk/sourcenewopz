package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.List;

public class SortUtils {
    public static void sortPicList(double d, double d2, double d3, byte[] bArr, int i, int i2, int i3, List<ILivenessCallback.PicWithScore> list) {
        ILivenessCallback.PicWithScore picWithScore = new ILivenessCallback.PicWithScore();
        picWithScore.qualityScore = d;
        picWithScore.qualityOk = d2;
        picWithScore.attackScore = d3;
        picWithScore.rgba = bArr;
        picWithScore.width = i;
        picWithScore.height = i2;
        if (list.size() < i3) {
            list.add(picWithScore);
            return;
        }
        int i4 = 0;
        double d4 = list.get(0).attackScore;
        double d5 = d4;
        int i5 = 0;
        for (ILivenessCallback.PicWithScore next : list) {
            if (next.attackScore < d5) {
                d5 = next.attackScore;
                i4 = i5;
            }
            i5++;
        }
        if (picWithScore.attackScore > d5) {
            list.set(i4, picWithScore);
        }
    }
}
