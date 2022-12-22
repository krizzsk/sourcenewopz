package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.microblink.blinkbarcode.geometry.Point;
import com.microblink.blinkbarcode.geometry.Quadrilateral;

/* compiled from: line */
public class lIlIIIIlIl implements IllIIIIllI {
    private int IlIllIlIIl = -1;
    private Paint IllIIIllII = new Paint(1);
    private float llIIlIlIIl = 0.3f;

    public lIlIIIIlIl(Context context) {
        this.IllIIIllII.setStrokeWidth((float) ((context.getResources().getDisplayMetrics().densityDpi + 49) / 50));
        this.IllIIIllII.setStrokeCap(Paint.Cap.ROUND);
    }

    public Paint llIIlIlIIl() {
        return this.IllIIIllII;
    }

    public void llIIlIlIIl(int i) {
        this.IlIllIlIIl = i;
    }

    public void llIIlIlIIl(float f) {
        this.llIIlIlIIl = f;
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Point point;
        Point point2;
        Point point3;
        Point point4;
        float max = (float) Math.max(canvas.getWidth() / 8, canvas.getHeight() / 8);
        Point operatorMultiply = quadrilateral.getUpperRight().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl);
        Point operatorMultiply2 = quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl);
        Point operatorMultiply3 = quadrilateral.getLowerRight().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl);
        Point operatorMultiply4 = quadrilateral.getLowerRight().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl);
        int i = this.IlIllIlIIl;
        if (i > 0) {
            point4 = operatorMultiply.normalize((float) i);
            point3 = operatorMultiply2.normalize((float) this.IlIllIlIIl);
            point2 = operatorMultiply4.normalize((float) this.IlIllIlIIl);
            point = operatorMultiply3.normalize((float) this.IlIllIlIIl);
        } else {
            float min = Math.min(Math.min(Math.min(Math.min(max, operatorMultiply.norm()), operatorMultiply2.norm()), operatorMultiply3.norm()), operatorMultiply4.norm());
            Point clamp = operatorMultiply.clamp(min);
            Point clamp2 = operatorMultiply2.clamp(min);
            Point clamp3 = operatorMultiply4.clamp(min);
            point = operatorMultiply3.clamp(min);
            point4 = clamp;
            point3 = clamp2;
            point2 = clamp3;
        }
        this.IllIIIllII.setColor(quadrilateral.getColor());
        Point operatorPlus = quadrilateral.getUpperLeft().operatorPlus(point4);
        Point operatorPlus2 = quadrilateral.getUpperLeft().operatorPlus(point3);
        canvas.drawLine(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY(), operatorPlus.getX(), operatorPlus.getY(), this.IllIIIllII);
        Canvas canvas2 = canvas;
        canvas2.drawLine(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY(), operatorPlus2.getX(), operatorPlus2.getY(), this.IllIIIllII);
        Point operatorMinus = quadrilateral.getUpperRight().operatorMinus(point4);
        Point operatorPlus3 = quadrilateral.getUpperRight().operatorPlus(point2);
        canvas2.drawLine(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY(), operatorMinus.getX(), operatorMinus.getY(), this.IllIIIllII);
        Canvas canvas3 = canvas;
        canvas3.drawLine(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY(), operatorPlus3.getX(), operatorPlus3.getY(), this.IllIIIllII);
        Point operatorMinus2 = quadrilateral.getLowerLeft().operatorMinus(point3);
        Point operatorPlus4 = quadrilateral.getLowerLeft().operatorPlus(point);
        canvas3.drawLine(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY(), operatorMinus2.getX(), operatorMinus2.getY(), this.IllIIIllII);
        canvas.drawLine(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY(), operatorPlus4.getX(), operatorPlus4.getY(), this.IllIIIllII);
        Point operatorMinus3 = quadrilateral.getLowerRight().operatorMinus(point2);
        Point operatorMinus4 = quadrilateral.getLowerRight().operatorMinus(point);
        canvas.drawLine(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY(), operatorMinus3.getX(), operatorMinus3.getY(), this.IllIIIllII);
        canvas.drawLine(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY(), operatorMinus4.getX(), operatorMinus4.getY(), this.IllIIIllII);
    }
}
