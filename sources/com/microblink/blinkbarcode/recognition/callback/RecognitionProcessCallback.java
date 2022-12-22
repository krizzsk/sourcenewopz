package com.microblink.blinkbarcode.recognition.callback;

import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;

/* compiled from: line */
public final class RecognitionProcessCallback extends BaseRecognitionProcessCallback {
    public RecognitionProcessCallback(llIIlIlIIl lliililiil, MetadataCallbacks metadataCallbacks, Rectangle rectangle, RecognizerBundle.RecognitionDebugMode recognitionDebugMode) {
        super(lliililiil, rectangle, recognitionDebugMode);
        setMetadataCallbacks(metadataCallbacks);
    }
}
