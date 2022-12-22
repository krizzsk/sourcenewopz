package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class llllllIllI extends View {
    private int IIlIIIllIl = -1;
    private float IlIllIlIIl = -1.0f;
    private int IllIIIIllI = -1;
    private double IllIIIllII = 0.11d;
    public llIlIIIIIl lIIIIIllll = new llIlIIIIIl();
    private int lIlIIIIlIl = -1;
    private double llIIIlllll = 0.11d;
    private int llIIlIIlll = -1;
    private Paint llIIlIlIIl;
    public llllIIIllI lllIIIlIlI = new llllIIIllI();

    public llllllIllI(Context context, AttributeSet attributeSet) {
        super(context, (AttributeSet) null);
        setBackgroundColor(0);
        Paint paint = new Paint(1);
        this.llIIlIlIIl = paint;
        paint.setColor(-12012824);
    }

    public void onDraw(Canvas canvas) {
        if (this.IllIIIIllI == -1) {
            this.IllIIIIllI = getWidth();
        }
        if (this.lIlIIIIlIl == -1) {
            this.lIlIIIIlIl = getHeight();
        }
        int i = this.IllIIIIllI;
        int i2 = (int) (((double) i) * (1.0d - this.IllIIIllII));
        int i3 = this.lIlIIIIlIl;
        int i4 = (int) (((double) i3) * (1.0d - this.llIIIlllll));
        int i5 = (i3 - i4) / 2;
        this.llIIlIIlll = i5;
        this.IIlIIIllIl = (i - i2) / 2;
        float f = (float) i2;
        float f2 = 0.5f * f;
        float f3 = (226.0f * f2) / 2168.0f;
        float f4 = f3 * 2.0f;
        float f5 = f2 / 10.0f;
        float f6 = (f - ((f4 + f5) + f2)) / 2.0f;
        float random = ((float) i5) + (((float) Math.random()) * (((float) i4) - f4));
        int i6 = (int) f4;
        this.lIIIIIllll.llIIlIlIIl(canvas, (int) (((float) this.IIlIIIllIl) + f6), (int) random, i6, i6);
        this.lllIIIlIlI.llIIlIlIIl(canvas, (int) (((float) this.IIlIIIllIl) + f6 + f4 + f5), (int) (random + f3), (int) f2, (int) f3);
        this.IlIllIlIIl = random;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IllIIIIllI = getWidth();
        this.lIlIIIIlIl = getHeight();
        Log.m40233v(this, "LogoOverlayView layouting to size: {}x{}", Integer.valueOf(this.IllIIIIllI), Integer.valueOf(this.lIlIIIIlIl));
    }
}
