package com.google.android.cameraview;

import java.util.Iterator;
import java.util.SortedSet;

public class BestPreviewSizeUtil {
    private static final double MAX_ASPECT_DISTORTION = 0.15d;
    private static final int MIN_PREVIEW_PIXELS = 153600;

    public static Size findBestPreviewSizeValue(SortedSet<Size> sortedSet, Size size, Size size2) {
        Iterator it;
        if (sortedSet != null) {
            double width = ((double) size2.getWidth()) / ((double) size2.getHeight());
            int i = 0;
            boolean z = size2.getWidth() < size2.getHeight();
            Size size3 = null;
            Iterator it2 = sortedSet.iterator();
            while (it2.hasNext()) {
                Size size4 = (Size) it2.next();
                int width2 = size4.getWidth();
                int height = size4.getHeight();
                int i2 = width2 * height;
                if (i2 < MIN_PREVIEW_PIXELS) {
                    it = it2;
                } else {
                    int i3 = z ? height : width2;
                    int i4 = z ? width2 : height;
                    it = it2;
                    Size size5 = size4;
                    if (Math.abs((((double) i3) / ((double) i4)) - width) > MAX_ASPECT_DISTORTION) {
                        continue;
                    } else if (i3 == size2.getWidth() && i4 == size2.getHeight()) {
                        return new Size(width2, height);
                    } else {
                        if (i2 > i) {
                            i = i2;
                            size3 = size5;
                        }
                    }
                }
                it2 = it;
            }
            if (size3 != null) {
                return new Size(size3.getWidth(), size3.getHeight());
            }
            if (size != null) {
                return size;
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        } else if (size != null) {
            return size;
        } else {
            throw new IllegalStateException("Parameters contained no preview size!");
        }
    }
}
