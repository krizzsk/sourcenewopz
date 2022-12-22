package p233else;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import com.iproov.sdk.IProov;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.FaceFeatureSmoother;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import p093switch.C3126this;

/* renamed from: else.a */
/* compiled from: ClassicFaceDetector */
class C20827a implements FaceDetector {

    /* renamed from: a */
    private static final String f57223a = ("👱 " + C20827a.class.getSimpleName());

    /* renamed from: b */
    private final FaceFeatureSmoother f57224b = new FaceFeatureSmoother(0.2d);

    /* renamed from: c */
    private android.media.FaceDetector f57225c;

    C20827a() {
        new C3126this(0.8d);
    }

    public FaceFeature detectFace(Bitmap bitmap) {
        if (this.f57225c == null) {
            this.f57225c = new android.media.FaceDetector(bitmap.getWidth(), bitmap.getHeight(), 1);
        }
        FaceDetector.Face[] faceArr = new FaceDetector.Face[1];
        Bitmap copy = bitmap.copy(Bitmap.Config.RGB_565, false);
        System.currentTimeMillis();
        this.f57225c.findFaces(copy, faceArr);
        System.currentTimeMillis();
        if (faceArr[0] == null) {
            this.f57224b.reset();
            return null;
        } else if (faceArr[0].eyesDistance() == 0.0f) {
            this.f57224b.reset();
            return null;
        } else {
            double eyesDistance = ((double) (faceArr[0].eyesDistance() / ((float) FaceDetector.CC.calculateNormalisationFactor(bitmap.getWidth(), bitmap.getHeight())))) * 2.4d;
            PointF pointF = new PointF();
            faceArr[0].getMidPoint(pointF);
            float f = pointF.x;
            float eyesDistance2 = ((float) (((double) faceArr[0].eyesDistance()) * 2.4d)) / 2.0f;
            float f2 = pointF.y;
            RectF rectF = new RectF(f - eyesDistance2, f2 - eyesDistance2, f + eyesDistance2, f2 + eyesDistance2);
            StringBuilder sb = new StringBuilder();
            sb.append("Face found of size ");
            sb.append(eyesDistance);
            return this.f57224b.smooth(new FaceFeature(eyesDistance, rectF, (Pose) null));
        }
    }

    public IProov.FaceDetector getFaceDetector() {
        return IProov.FaceDetector.CLASSIC;
    }

    public void release() {
    }

    public void setOmega(double d) {
    }
}
