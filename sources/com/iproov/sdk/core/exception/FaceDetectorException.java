package com.iproov.sdk.core.exception;

import android.content.Context;
import com.taxis99.R;

public class FaceDetectorException extends IProovException {
    public FaceDetectorException(Context context, String str) {
        super(context.getString(R.string.iproov__error_face_detector), str);
    }
}
