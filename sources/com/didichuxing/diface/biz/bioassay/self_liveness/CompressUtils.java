package com.didichuxing.diface.biz.bioassay.self_liveness;

import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.didichuxing.sdk.alphaface.core.BioassayManager;
import com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.io.File;

public class CompressUtils {
    public static void compressRGBA(File file, BioassayManager.PicWithScore picWithScore, int i, int i2, int i3, int i4) {
        do {
            AlphaFaceFacade.getInstance().getAfNative().compressRGBA(picWithScore.rgba, picWithScore.width, picWithScore.height, i, file.getAbsolutePath().getBytes(), true);
            i -= i2;
            if (file.length() / 1024 <= ((long) i4)) {
                return;
            }
        } while (i >= i3);
    }

    public static void compressRGBA(File file, BioassayManager.PicWithScore picWithScore) {
        compressRGBA(file, picWithScore, 75, 5, 20, 500);
    }

    public static void compressRGBA(File file, ColorfulLivenessManager.PicWithScore picWithScore, int i, int i2, int i3, int i4) {
        do {
            AlphaFaceFacade.getInstance().getAfNative().compressRGBA(picWithScore.rgba, picWithScore.width, picWithScore.height, i, file.getAbsolutePath().getBytes(), true);
            i -= i2;
            if (file.length() / 1024 <= ((long) i4)) {
                return;
            }
        } while (i >= i3);
    }

    public static void compressRGBA(File file, ColorfulLivenessManager.PicWithScore picWithScore) {
        compressRGBA(file, picWithScore, 75, 5, 20, 500);
    }

    public static void compressRGBA(File file, ILivenessCallback.PicWithScore picWithScore, int i, int i2, int i3, int i4) {
        do {
            AlphaFaceFacade.getInstance().getAfNative().compressRGBA(picWithScore.rgba, picWithScore.width, picWithScore.height, i, file.getAbsolutePath().getBytes(), true);
            i -= i2;
            if (file.length() / 1024 <= ((long) i4)) {
                return;
            }
        } while (i >= i3);
    }

    public static void compressRGBA(File file, ILivenessCallback.PicWithScore picWithScore) {
        compressRGBA(file, picWithScore, 75, 5, 20, 500);
    }
}
