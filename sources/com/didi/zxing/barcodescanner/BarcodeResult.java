package com.didi.zxing.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.Result;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import java.util.Map;

public class BarcodeResult {

    /* renamed from: a */
    private static final float f45201a = 4.0f;

    /* renamed from: b */
    private static final float f45202b = 10.0f;

    /* renamed from: c */
    private final int f45203c = 2;
    protected Result mResult;
    protected long sessionId;
    protected SourceData sourceData;

    public int getBitmapScaleFactor() {
        return 2;
    }

    public BarcodeResult(Result result, SourceData sourceData2, long j) {
        this.mResult = result;
        this.sourceData = sourceData2;
        this.sessionId = j;
    }

    /* renamed from: a */
    private static void m32466a(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        if (resultPoint != null && resultPoint2 != null) {
            float f = (float) i;
            canvas.drawLine(resultPoint.getX() / f, resultPoint.getY() / f, resultPoint2.getX() / f, resultPoint2.getY() / f, paint);
        }
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public Result getResult() {
        return this.mResult;
    }

    public Bitmap getBitmap() {
        return this.sourceData.getBitmap(2);
    }

    public Bitmap getBitmapWithResultPoints(int i) {
        Bitmap bitmap = getBitmap();
        ResultPoint[] resultPoints = this.mResult.getResultPoints();
        if (resultPoints == null || resultPoints.length <= 0 || bitmap == null) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(i);
        if (resultPoints.length == 2) {
            paint.setStrokeWidth(4.0f);
            m32466a(canvas, paint, resultPoints[0], resultPoints[1], 2);
        } else if (resultPoints.length == 4 && (this.mResult.getBarcodeFormat() == BarcodeFormat.UPC_A || this.mResult.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
            m32466a(canvas, paint, resultPoints[0], resultPoints[1], 2);
            m32466a(canvas, paint, resultPoints[2], resultPoints[3], 2);
        } else {
            paint.setStrokeWidth(10.0f);
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    canvas.drawPoint(resultPoint.getX() / 2.0f, resultPoint.getY() / 2.0f, paint);
                }
            }
        }
        return createBitmap;
    }

    public String getText() {
        return this.mResult.getText();
    }

    public byte[] getRawBytes() {
        return this.mResult.getRawBytes();
    }

    public ResultPoint[] getResultPoints() {
        return this.mResult.getResultPoints();
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.mResult.getBarcodeFormat();
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.mResult.getResultMetadata();
    }

    public long getTimestamp() {
        return this.mResult.getTimestamp();
    }

    public String toString() {
        return this.mResult.getText();
    }
}
