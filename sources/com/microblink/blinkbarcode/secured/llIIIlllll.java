package com.microblink.blinkbarcode.secured;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.microblink.blinkbarcode.geometry.Quadrilateral;

/* compiled from: line */
public class llIIIlllll implements IllIIIIllI {
    private Paint llIIlIlIIl = null;

    public llIIIlllll() {
        Paint paint = new Paint();
        this.llIIlIlIIl = paint;
        paint.setAlpha(100);
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Paint paint = this.llIIlIlIIl;
        Path path = new Path();
        path.moveTo(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY());
        path.lineTo((float) canvas.getWidth(), 0.0f);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY());
        canvas.drawPath(path, paint);
        Path path2 = new Path();
        path2.moveTo(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY());
        path2.lineTo(0.0f, 0.0f);
        path2.lineTo(0.0f, (float) canvas.getHeight());
        path2.lineTo(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY());
        canvas.drawPath(path2, paint);
        Path path3 = new Path();
        path3.moveTo(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY());
        path3.lineTo(0.0f, (float) canvas.getHeight());
        path3.lineTo((float) canvas.getWidth(), (float) canvas.getHeight());
        path3.lineTo(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY());
        canvas.drawPath(path3, paint);
        Path path4 = new Path();
        path4.moveTo(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY());
        path4.lineTo((float) canvas.getWidth(), (float) canvas.getHeight());
        path4.lineTo((float) canvas.getWidth(), 0.0f);
        path4.lineTo(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY());
        canvas.drawPath(path4, paint);
    }

    public Paint llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
