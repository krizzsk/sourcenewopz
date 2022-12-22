package com.microblink.blinkbarcode.secured;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.microblink.blinkbarcode.geometry.Point;
import com.microblink.blinkbarcode.geometry.Quadrilateral;

/* compiled from: line */
public class IllIIIllII implements IllIIIIllI {
    private Paint IlIllIlIIl = new Paint();
    private Paint llIIlIlIIl = new Paint();

    public IllIIIllII() {
        this.llIIlIlIIl.setStrokeWidth(5.0f);
        this.llIIlIlIIl.setAntiAlias(true);
        this.llIIlIlIIl.setStyle(Paint.Style.STROKE);
        this.IlIllIlIIl.setStyle(Paint.Style.FILL);
    }

    public Paint llIIlIlIIl() {
        return null;
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        if (!quadrilateral.isDefaultQuad()) {
            int color = quadrilateral.getColor();
            this.llIIlIlIIl.setColor(color);
            this.IlIllIlIIl.setColor(color);
            this.IlIllIlIIl.setAlpha(Math.min(Color.alpha(color), 75));
            Point upperLeft = quadrilateral.getUpperLeft();
            Point upperRight = quadrilateral.getUpperRight();
            Point lowerLeft = quadrilateral.getLowerLeft();
            Point lowerRight = quadrilateral.getLowerRight();
            Path path = new Path();
            path.moveTo(upperLeft.getX(), upperLeft.getY());
            path.lineTo(upperRight.getX(), upperRight.getY());
            path.lineTo(lowerRight.getX(), lowerRight.getY());
            path.lineTo(lowerLeft.getX(), lowerLeft.getY());
            path.close();
            canvas.drawPath(path, this.llIIlIlIIl);
            canvas.drawPath(path, this.IlIllIlIIl);
        }
    }
}
