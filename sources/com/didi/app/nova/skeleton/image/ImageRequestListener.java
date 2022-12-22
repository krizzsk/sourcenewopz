package com.didi.app.nova.skeleton.image;

public interface ImageRequestListener<TranscodeType> {
    boolean onException(Exception exc, boolean z);

    boolean onResourceReady(TranscodeType transcodetype, boolean z, boolean z2);
}
