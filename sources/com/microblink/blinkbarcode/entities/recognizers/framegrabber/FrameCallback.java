package com.microblink.blinkbarcode.entities.recognizers.framegrabber;

import android.os.Parcelable;
import com.microblink.blinkbarcode.image.Image;

/* compiled from: line */
public interface FrameCallback extends Parcelable {
    void onFrameAvailable(Image image, boolean z, double d);
}
