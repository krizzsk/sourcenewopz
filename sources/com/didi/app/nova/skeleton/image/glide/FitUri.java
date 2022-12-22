package com.didi.app.nova.skeleton.image.glide;

import android.net.Uri;
import com.didi.app.nova.skeleton.image.FitType;

public final class FitUri {
    public FitType fitType;
    public Uri uri;

    public FitUri(FitType fitType2, Uri uri2) {
        this.fitType = fitType2;
        this.uri = uri2;
    }
}
