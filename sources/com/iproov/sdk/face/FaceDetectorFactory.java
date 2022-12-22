package com.iproov.sdk.face;

import android.content.Context;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.FaceDetectorException;

public interface FaceDetectorFactory {
    FaceDetector getFaceDetector(Context context, IProov.Options.Capture capture) throws FaceDetectorException;
}
