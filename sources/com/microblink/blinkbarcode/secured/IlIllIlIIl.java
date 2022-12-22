package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.microblink.blinkbarcode.geometry.Quadrilateral;

/* compiled from: line */
public class IlIllIlIIl implements IllIIIIllI {
    private Paint IlIllIlIIl;
    private llIIlIIlll llIIlIlIIl;

    public IlIllIlIIl(llIIlIIlll lliiliilll, Context context) {
        this.llIIlIlIIl = lliiliilll;
        Paint paint = new Paint(1);
        this.IlIllIlIIl = paint;
        paint.setColor(-1);
        this.IlIllIlIIl.setStrokeWidth((float) ((context.getResources().getDisplayMetrics().densityDpi + 49) / 50));
        this.IlIllIlIIl.setStrokeCap(Paint.Cap.ROUND);
        this.IlIllIlIIl.setStyle(Paint.Style.STROKE);
    }

    public llIIlIIlll IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Quadrilateral sortedQuad = ((IIlIIIllIl) this.llIIlIlIIl).llIIlIlIIl(quadrilateral).getSortedQuad();
        canvas.drawRoundRect(new RectF(sortedQuad.getUpperLeft().getX(), sortedQuad.getUpperLeft().getY(), sortedQuad.getLowerRight().getX(), sortedQuad.getLowerRight().getY()), 30.0f, 30.0f, this.IlIllIlIIl);
    }

    public Paint llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
