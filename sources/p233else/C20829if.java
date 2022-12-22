package p233else;

import android.content.Context;
import com.iproov.sdk.IProov;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.FaceDetectorFactory;

/* renamed from: else.if */
/* compiled from: ClassicFaceDetectorFactory */
public class C20829if implements FaceDetectorFactory {
    public FaceDetector getFaceDetector(Context context, IProov.Options.Capture capture) {
        return new C20827a();
    }
}
