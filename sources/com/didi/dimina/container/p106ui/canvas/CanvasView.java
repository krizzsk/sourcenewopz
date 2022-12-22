package com.didi.dimina.container.p106ui.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.dimina.container.util.PixUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.dimina.container.ui.canvas.CanvasView */
public class CanvasView extends AppCompatImageView {

    /* renamed from: a */
    private final Paint f17485a;

    /* renamed from: b */
    private final Paint f17486b;

    /* renamed from: c */
    private final Bitmap f17487c;

    /* renamed from: d */
    private Canvas f17488d;

    /* renamed from: e */
    private final Path f17489e;

    /* renamed from: f */
    private final Paint f17490f;

    /* renamed from: g */
    private final Paint f17491g;

    /* renamed from: h */
    private final Matrix f17492h;

    /* renamed from: i */
    private final float f17493i;

    /* renamed from: j */
    private float f17494j = 1.0f;

    /* renamed from: k */
    private float f17495k = 10.0f;

    /* renamed from: l */
    private float f17496l = 0.0f;

    /* renamed from: m */
    private float f17497m = 0.0f;

    /* renamed from: n */
    private float f17498n = 0.0f;

    /* renamed from: o */
    private int f17499o = -16777216;

    /* renamed from: p */
    private int f17500p = 0;

    /* renamed from: q */
    private int f17501q = 0;

    /* renamed from: r */
    private float f17502r = 10.0f;

    /* renamed from: s */
    private boolean f17503s = false;

    /* renamed from: t */
    private int f17504t = 300;

    /* renamed from: u */
    private int f17505u = 150;

    /* renamed from: v */
    private float f17506v = 300.0f;

    /* renamed from: w */
    private float f17507w = 150.0f;

    /* renamed from: a */
    private float m13005a(float f) {
        return (float) (((double) f) * 57.29577951308232d);
    }

    public CanvasView(Context context, int i, int i2) {
        super(context);
        this.f17504t = i;
        this.f17505u = i2;
        float f = context.getResources().getDisplayMetrics().density;
        this.f17493i = f;
        this.f17506v *= f;
        this.f17507w *= f;
        this.f17485a = new Paint(1);
        this.f17486b = new Paint(1);
        this.f17487c = Bitmap.createBitmap(PixUtil.dip2px(context, (float) i), PixUtil.dip2px(context, (float) i2), Bitmap.Config.ARGB_8888);
        this.f17488d = new Canvas(this.f17487c);
        this.f17489e = new Path();
        this.f17490f = new Paint(1);
        this.f17491g = new Paint(1);
        this.f17492h = new Matrix();
        m13008a();
    }

    /* renamed from: a */
    private void m13008a() {
        this.f17485a.setStyle(Paint.Style.FILL);
        this.f17486b.setStyle(Paint.Style.STROKE);
        this.f17486b.setStrokeCap(Paint.Cap.BUTT);
        this.f17486b.setStrokeJoin(Paint.Join.MITER);
        this.f17486b.setStrokeWidth(this.f17494j * this.f17493i);
        this.f17486b.setStrokeMiter(this.f17495k * this.f17493i);
        this.f17486b.setColor(-16777216);
        this.f17485a.setColor(-16777216);
    }

    /* renamed from: b */
    private void m13010b() {
        this.f17488d.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f17485a.reset();
        this.f17486b.reset();
        m13008a();
        this.f17489e.reset();
    }

    public void width(float f) {
        Canvas canvas = new Canvas(this.f17487c);
        this.f17488d = canvas;
        this.f17506v = f * this.f17493i;
        canvas.scale(((float) this.f17487c.getWidth()) / this.f17506v, ((float) this.f17487c.getHeight()) / this.f17507w);
        m13010b();
    }

    public void height(float f) {
        Canvas canvas = new Canvas(this.f17487c);
        this.f17488d = canvas;
        this.f17507w = f * this.f17493i;
        canvas.scale(((float) this.f17487c.getWidth()) / this.f17506v, ((float) this.f17487c.getHeight()) / this.f17507w);
        m13010b();
    }

    public void fillRect(float f, float f2, float f3, float f4) {
        float f5 = this.f17493i;
        float f6 = f * f5;
        float f7 = f2 * f5;
        this.f17488d.drawRect(f6, f7, f6 + (f3 * f5), f7 + (f4 * f5), this.f17485a);
        draw();
    }

    public void strokeRect(float f, float f2, float f3, float f4) {
        float f5 = this.f17493i;
        float f6 = f * f5;
        float f7 = f2 * f5;
        this.f17488d.drawRect(f6, f7, f6 + (f3 * f5), f7 + (f4 * f5), this.f17486b);
        draw();
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        float f = this.f17493i;
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Canvas canvas = this.f17488d;
        float f2 = this.f17493i;
        canvas.scale(f2, f2);
        this.f17488d.drawBitmap(createBitmap, (float) ((int) (((float) i) * f)), (float) ((int) (((float) i2) * f)), paint);
        Canvas canvas2 = this.f17488d;
        float f3 = this.f17493i;
        canvas2.scale(1.0f / f3, 1.0f / f3);
        draw();
    }

    /* renamed from: a */
    private int[] m13009a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    public void fillText(String str, float f, float f2, float f3) {
        float f4 = this.f17493i;
        float f5 = f * f4;
        float f6 = f2 * f4;
        Rect rect = new Rect();
        this.f17485a.getTextBounds(str, 0, str.length(), rect);
        Path path = new Path();
        this.f17485a.getTextPath(str, 0, str.length(), f5 - ((float) rect.top), f6 - ((float) rect.left), path);
        if (!Float.isNaN(f3)) {
            float f7 = f3 * this.f17493i;
            if (f7 < ((float) rect.width())) {
                float width = f7 / ((float) rect.width());
                Matrix matrix = new Matrix();
                matrix.postScale(width, 1.0f, f5 - ((float) rect.top), f6 - ((float) rect.left));
                path.transform(matrix);
            }
        }
        this.f17488d.drawPath(path, this.f17485a);
        draw();
    }

    public void strokeText(String str, float f, float f2, float f3) {
        float f4 = this.f17493i;
        float f5 = f * f4;
        float f6 = f2 * f4;
        Rect rect = new Rect();
        this.f17486b.getTextBounds(str, 0, str.length(), rect);
        Path path = new Path();
        this.f17486b.getTextPath(str, 0, str.length(), f5 - ((float) rect.top), f6 - ((float) rect.left), path);
        if (!Float.isNaN(f3)) {
            float f7 = f3 * this.f17493i;
            if (f7 < ((float) rect.width())) {
                float width = f7 / ((float) rect.width());
                Matrix matrix = new Matrix();
                matrix.postScale(width, 1.0f, f5 - ((float) rect.top), f6 - ((float) rect.left));
                path.transform(matrix);
            }
        }
        this.f17488d.drawPath(path, this.f17486b);
        draw();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String lineCap(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -894674659(0xffffffffcaac591d, float:-5647502.5)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 3035667(0x2e5213, float:4.253876E-39)
            if (r0 == r1) goto L_0x0020
            r1 = 108704142(0x67ab18e, float:4.715022E-35)
            if (r0 == r1) goto L_0x0016
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "round"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0035
            r5 = 0
            goto L_0x0036
        L_0x0020:
            java.lang.String r0 = "butt"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0035
            r5 = 2
            goto L_0x0036
        L_0x002a:
            java.lang.String r0 = "square"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0035
            r5 = 1
            goto L_0x0036
        L_0x0035:
            r5 = -1
        L_0x0036:
            if (r5 == 0) goto L_0x0051
            if (r5 == r3) goto L_0x004e
            if (r5 == r2) goto L_0x004b
            android.graphics.Paint r5 = r4.f17486b
            android.graphics.Paint$Cap r5 = r5.getStrokeCap()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toLowerCase()
            return r5
        L_0x004b:
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.BUTT
            goto L_0x0053
        L_0x004e:
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.SQUARE
            goto L_0x0053
        L_0x0051:
            android.graphics.Paint$Cap r5 = android.graphics.Paint.Cap.ROUND
        L_0x0053:
            android.graphics.Paint r0 = r4.f17486b
            r0.setStrokeCap(r5)
            android.graphics.Paint r5 = r4.f17486b
            android.graphics.Paint$Cap r5 = r5.getStrokeCap()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toLowerCase()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.canvas.CanvasView.lineCap(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String lineJoin(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 93630586(0x594b07a, float:1.398268E-35)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 103906565(0x6317d05, float:3.338185E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 108704142(0x67ab18e, float:4.715022E-35)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "round"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "miter"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "bevel"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0050
            if (r5 == r3) goto L_0x004d
            if (r5 == r2) goto L_0x004a
            android.graphics.Paint r5 = r4.f17486b
            android.graphics.Paint$Join r5 = r5.getStrokeJoin()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toLowerCase()
            return r5
        L_0x004a:
            android.graphics.Paint$Join r5 = android.graphics.Paint.Join.MITER
            goto L_0x0052
        L_0x004d:
            android.graphics.Paint$Join r5 = android.graphics.Paint.Join.ROUND
            goto L_0x0052
        L_0x0050:
            android.graphics.Paint$Join r5 = android.graphics.Paint.Join.BEVEL
        L_0x0052:
            android.graphics.Paint r0 = r4.f17486b
            r0.setStrokeJoin(r5)
            android.graphics.Paint r5 = r4.f17486b
            android.graphics.Paint$Join r5 = r5.getStrokeJoin()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toLowerCase()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.canvas.CanvasView.lineJoin(java.lang.String):java.lang.String");
    }

    public Float lineWidth(float f) {
        if (!Float.isNaN(f)) {
            this.f17494j = f;
            this.f17486b.setStrokeWidth(f * this.f17493i);
        }
        return Float.valueOf(this.f17494j);
    }

    public Float miterLimit(float f) {
        if (!Float.isNaN(f)) {
            this.f17495k = f;
            this.f17486b.setStrokeMiter(f);
        }
        return Float.valueOf(this.f17495k);
    }

    public String font(String str) {
        Matcher matcher = Pattern.compile("(-|\\+?)\\d+(\\.\\d+)?px").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(0);
            String[] strArr = new String[0];
            if (group != null) {
                strArr = group.split("px", 2);
            }
            float parseInt = (float) Integer.parseInt(strArr[0]);
            this.f17502r = parseInt;
            this.f17485a.setTextSize(this.f17493i * parseInt);
            this.f17486b.setTextSize(parseInt * this.f17493i);
            return group;
        }
        return this.f17502r + "px";
    }

    /* renamed from: a */
    private String m13007a(int i) {
        return String.format("#%06X", new Object[]{Integer.valueOf(i & 16777215)});
    }

    public String fillStyle(String str) {
        if (str.charAt(0) == '#') {
            this.f17485a.setColor(Color.parseColor(str));
        }
        return m13007a(this.f17485a.getColor());
    }

    public String strokeStyle(String str) {
        if (str.charAt(0) == '#') {
            this.f17486b.setColor(Color.parseColor(str));
        }
        return m13007a(this.f17486b.getColor());
    }

    public String shadowColor(String str) {
        if (str.charAt(0) == '#') {
            this.f17499o = Color.parseColor(str);
            m13011c();
        }
        return m13007a(this.f17485a.getShadowLayerColor());
    }

    public float shadowBlur(float f) {
        if (!Float.isNaN(f)) {
            this.f17496l = f;
            m13011c();
        }
        return this.f17496l;
    }

    public float shadowOffsetX(float f) {
        if (!Float.isNaN(f)) {
            this.f17497m = f;
            m13011c();
        }
        return this.f17497m;
    }

    public float shadowOffsetY(float f) {
        if (!Float.isNaN(f)) {
            this.f17498n = f;
            m13011c();
        }
        return this.f17498n;
    }

    /* renamed from: c */
    private void m13011c() {
        Paint paint = this.f17486b;
        float f = this.f17496l;
        float f2 = this.f17493i;
        paint.setShadowLayer(f * f2, this.f17497m * f2, this.f17498n * f2, this.f17499o);
        Paint paint2 = this.f17485a;
        float f3 = this.f17496l;
        float f4 = this.f17493i;
        paint2.setShadowLayer(f3 * f4, this.f17497m * f4, this.f17498n * f4, this.f17499o);
    }

    public void moveTo(float f, float f2) {
        float f3 = this.f17493i;
        this.f17503s = true;
        this.f17489e.moveTo(f * f3, f2 * f3);
    }

    public void closePath() {
        this.f17489e.close();
    }

    public void lineTo(float f, float f2) {
        float f3 = this.f17493i;
        float f4 = f * f3;
        float f5 = f2 * f3;
        if (!this.f17503s) {
            this.f17489e.moveTo(f4, f5);
            this.f17503s = true;
            return;
        }
        this.f17489e.lineTo(f4, f5);
    }

    public void clip() {
        if (!this.f17489e.isEmpty()) {
            this.f17488d.clipPath(this.f17489e);
        }
    }

    public void quadraticCurveTo(float f, float f2, float f3, float f4) {
        float f5 = this.f17493i;
        float f6 = f * f5;
        float f7 = f2 * f5;
        this.f17489e.rQuadTo(f6, f7, f3 * f5, f4 * f5);
    }

    public void bezierCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.f17493i;
        this.f17489e.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
    }

    public void arc(float f, float f2, float f3, float f4, float f5, boolean z) {
        float f6 = f4;
        float f7 = f5;
        float f8 = this.f17493i;
        float f9 = f * f8;
        float f10 = f2 * f8;
        float f11 = f8 * f3;
        if (z) {
            this.f17489e.addArc(f9 - f11, f10 - f11, f9 + f11, f10 + f11, m13005a(f7), m13005a((6.2831855f - f7) + f6));
        } else {
            this.f17489e.addArc(f9 - f11, f10 - f11, f9 + f11, f10 + f11, m13005a(f6), m13005a(f7 - f6));
        }
    }

    public void rect(float f, float f2, float f3, float f4) {
        float f5 = this.f17493i;
        float f6 = f * f5;
        float f7 = f2 * f5;
        this.f17489e.addRect(f6, f7, f6 + (f3 * f5), f7 + (f4 * f5), Path.Direction.CW);
        this.f17489e.close();
    }

    public void fill() {
        this.f17488d.drawPath(this.f17489e, this.f17485a);
        draw();
    }

    public void stroke() {
        this.f17488d.drawPath(this.f17489e, this.f17486b);
        draw();
    }

    public boolean isPointInPath(int i, int i2) {
        float f = this.f17493i;
        RectF rectF = new RectF();
        this.f17489e.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(this.f17489e, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int) (((float) i) * f), (int) (((float) i2) * f));
    }

    public void scale(float f, float f2) {
        this.f17488d.scale(f, f2);
    }

    public void rotate(float f) {
        this.f17488d.rotate(m13005a(f));
    }

    public void translate(float f, float f2) {
        float f3 = this.f17493i;
        this.f17488d.translate(f * f3, f2 * f3);
    }

    public void transform(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.f17493i;
        this.f17488d.skew(-f2, -f3);
        this.f17488d.translate(f5 * f7, f6 * f7);
        this.f17488d.scale(f, f4);
    }

    public void setTransform(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.f17493i;
        this.f17488d.setMatrix(this.f17492h);
        this.f17488d.skew(-f2, -f3);
        this.f17488d.translate(f5 * f7, f6 * f7);
        this.f17488d.scale(f, f4);
    }

    public void drawImage(String str, int i, int i2, int i3, int i4) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Canvas canvas = this.f17488d;
        float f = this.f17493i;
        canvas.scale(f, f);
        this.f17488d.drawBitmap(decodeFile, (Rect) null, new RectF((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4)), this.f17485a);
        Canvas canvas2 = this.f17488d;
        float f2 = this.f17493i;
        canvas2.scale(1.0f / f2, 1.0f / f2);
        draw();
    }

    public void drawImage(String str, int i, int i2) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Canvas canvas = this.f17488d;
        float f = this.f17493i;
        canvas.scale(f, f);
        this.f17488d.drawBitmap(decodeFile, (float) i, (float) i2, this.f17485a);
        Canvas canvas2 = this.f17488d;
        float f2 = this.f17493i;
        canvas2.scale(1.0f / f2, 1.0f / f2);
        draw();
    }

    public void drawImage(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Rect rect = new Rect(i, i6, i3 + i, i2 + i4);
        RectF rectF = new RectF((float) i5, (float) i6, (float) (i5 + i7), (float) (i6 + i8));
        Canvas canvas = this.f17488d;
        float f = this.f17493i;
        canvas.scale(f, f);
        this.f17488d.drawBitmap(decodeFile, rect, rectF, this.f17485a);
        Canvas canvas2 = this.f17488d;
        float f2 = this.f17493i;
        canvas2.scale(1.0f / f2, 1.0f / f2);
        draw();
    }

    /* renamed from: a */
    private static Bitmap m13006a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public void save() {
        this.f17500p++;
        this.f17488d.save();
        this.f17491g.set(this.f17486b);
        this.f17490f.set(this.f17485a);
    }

    public void restore() {
        int i = this.f17501q + 1;
        this.f17501q = i;
        if (i <= this.f17500p) {
            this.f17488d.restore();
            this.f17485a.set(this.f17490f);
            this.f17486b.set(this.f17491g);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String textAlign(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x0035;
                case 100571: goto L_0x002b;
                case 3317767: goto L_0x0021;
                case 108511772: goto L_0x0017;
                case 109757538: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003f
        L_0x000c:
            java.lang.String r0 = "start"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 4
            goto L_0x0040
        L_0x0017:
            java.lang.String r0 = "right"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 2
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "left"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 3
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "end"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "center"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 0
            goto L_0x0040
        L_0x003f:
            r6 = -1
        L_0x0040:
            if (r6 == 0) goto L_0x005f
            if (r6 == r4) goto L_0x005c
            if (r6 == r3) goto L_0x005c
            if (r6 == r2) goto L_0x0059
            if (r6 == r1) goto L_0x0059
            android.graphics.Paint r6 = r5.f17485a
            android.graphics.Paint$Align r6 = r6.getTextAlign()
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toLowerCase()
            return r6
        L_0x0059:
            android.graphics.Paint$Align r6 = android.graphics.Paint.Align.LEFT
            goto L_0x0061
        L_0x005c:
            android.graphics.Paint$Align r6 = android.graphics.Paint.Align.RIGHT
            goto L_0x0061
        L_0x005f:
            android.graphics.Paint$Align r6 = android.graphics.Paint.Align.CENTER
        L_0x0061:
            android.graphics.Paint r0 = r5.f17485a
            r0.setTextAlign(r6)
            android.graphics.Paint r0 = r5.f17486b
            r0.setTextAlign(r6)
            android.graphics.Paint r6 = r5.f17485a
            android.graphics.Paint$Align r6 = r6.getTextAlign()
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r6.toLowerCase()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.canvas.CanvasView.textAlign(java.lang.String):java.lang.String");
    }

    public void beginPath() {
        this.f17503s = false;
        this.f17489e.reset();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A[Catch:{ IOException -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8 A[Catch:{ IOException -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9 A[SYNTHETIC, Splitter:B:40:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4 A[Catch:{ IOException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f0 A[SYNTHETIC, Splitter:B:50:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fb A[Catch:{ IOException -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toDataURL(java.lang.String r9, double r10) {
        /*
            r8 = this;
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            float r0 = r8.f17493i
            r1 = 1065353216(0x3f800000, float:1.0)
            float r2 = r1 / r0
            float r3 = r8.f17506v
            float r3 = r3 / r0
            float r2 = r2 * r3
            int r3 = r8.f17504t
            float r3 = (float) r3
            float r2 = r2 / r3
            float r1 = r1 / r0
            float r3 = r8.f17507w
            float r3 = r3 / r0
            float r1 = r1 * r3
            int r0 = r8.f17505u
            float r0 = (float) r0
            float r1 = r1 / r0
            r5.postScale(r2, r1)
            android.graphics.Bitmap r0 = r8.f17487c
            int r3 = r0.getWidth()
            android.graphics.Bitmap r1 = r8.f17487c
            int r4 = r1.getHeight()
            r1 = 0
            r2 = 0
            r6 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            r1 = 0
            if (r0 == 0) goto L_0x0103
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
            r2.<init>()     // Catch:{ IOException -> 0x00d2, all -> 0x00d0 }
            r3 = -1
            int r4 = r9.hashCode()     // Catch:{ IOException -> 0x00ce }
            r5 = -1487394660(0xffffffffa758289c, float:-2.9998036E-15)
            r6 = 1
            if (r4 == r5) goto L_0x0057
            r5 = -1487018032(0xffffffffa75de7d0, float:-3.0795577E-15)
            if (r4 == r5) goto L_0x004d
            goto L_0x0060
        L_0x004d:
            java.lang.String r4 = "image/webp"
            boolean r4 = r9.equals(r4)     // Catch:{ IOException -> 0x00ce }
            if (r4 == 0) goto L_0x0060
            r3 = 1
            goto L_0x0060
        L_0x0057:
            java.lang.String r4 = "image/jpeg"
            boolean r4 = r9.equals(r4)     // Catch:{ IOException -> 0x00ce }
            if (r4 == 0) goto L_0x0060
            r3 = 0
        L_0x0060:
            java.lang.String r4 = ";base64,"
            java.lang.String r5 = "data:"
            if (r3 == 0) goto L_0x0082
            if (r3 == r6) goto L_0x006d
            android.graphics.Bitmap$CompressFormat r9 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x00ce }
            java.lang.String r3 = "data:image/png;base64,"
            goto L_0x0099
        L_0x006d:
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ IOException -> 0x00ce }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ce }
            r6.<init>()     // Catch:{ IOException -> 0x00ce }
            r6.append(r5)     // Catch:{ IOException -> 0x00ce }
            r6.append(r9)     // Catch:{ IOException -> 0x00ce }
            r6.append(r4)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00ce }
            goto L_0x0096
        L_0x0082:
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x00ce }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ce }
            r6.<init>()     // Catch:{ IOException -> 0x00ce }
            r6.append(r5)     // Catch:{ IOException -> 0x00ce }
            r6.append(r9)     // Catch:{ IOException -> 0x00ce }
            r6.append(r4)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00ce }
        L_0x0096:
            r7 = r3
            r3 = r9
            r9 = r7
        L_0x0099:
            r4 = 0
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a8
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a8
            double r10 = r10 * r4
            goto L_0x00aa
        L_0x00a8:
            r10 = 4636174341401214976(0x4057000000000000, double:92.0)
        L_0x00aa:
            int r10 = (int) r10     // Catch:{ IOException -> 0x00ce }
            r0.compress(r9, r10, r2)     // Catch:{ IOException -> 0x00ce }
            r2.flush()     // Catch:{ IOException -> 0x00ce }
            r2.close()     // Catch:{ IOException -> 0x00ce }
            byte[] r9 = r2.toByteArray()     // Catch:{ IOException -> 0x00ce }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ce }
            r10.<init>()     // Catch:{ IOException -> 0x00ce }
            r10.append(r3)     // Catch:{ IOException -> 0x00ce }
            r11 = 2
            java.lang.String r9 = android.util.Base64.encodeToString(r9, r11)     // Catch:{ IOException -> 0x00ce }
            r10.append(r9)     // Catch:{ IOException -> 0x00ce }
            java.lang.String r9 = r10.toString()     // Catch:{ IOException -> 0x00ce }
            r1 = r2
            goto L_0x0104
        L_0x00ce:
            r9 = move-exception
            goto L_0x00d4
        L_0x00d0:
            r9 = move-exception
            goto L_0x00ee
        L_0x00d2:
            r9 = move-exception
            r2 = r1
        L_0x00d4:
            r9.printStackTrace()     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x00e2
            r2.flush()     // Catch:{ IOException -> 0x00e0 }
            r2.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e2
        L_0x00e0:
            r9 = move-exception
            goto L_0x00e8
        L_0x00e2:
            if (r0 == 0) goto L_0x0119
            r0.recycle()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x0119
        L_0x00e8:
            r9.printStackTrace()
            goto L_0x0119
        L_0x00ec:
            r9 = move-exception
            r1 = r2
        L_0x00ee:
            if (r1 == 0) goto L_0x00f9
            r1.flush()     // Catch:{ IOException -> 0x00f7 }
            r1.close()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x00f9
        L_0x00f7:
            r10 = move-exception
            goto L_0x00ff
        L_0x00f9:
            if (r0 == 0) goto L_0x0102
            r0.recycle()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x0102
        L_0x00ff:
            r10.printStackTrace()
        L_0x0102:
            throw r9
        L_0x0103:
            r9 = r1
        L_0x0104:
            if (r1 == 0) goto L_0x010f
            r1.flush()     // Catch:{ IOException -> 0x010d }
            r1.close()     // Catch:{ IOException -> 0x010d }
            goto L_0x010f
        L_0x010d:
            r10 = move-exception
            goto L_0x0115
        L_0x010f:
            if (r0 == 0) goto L_0x0118
            r0.recycle()     // Catch:{ IOException -> 0x010d }
            goto L_0x0118
        L_0x0115:
            r10.printStackTrace()
        L_0x0118:
            r1 = r9
        L_0x0119:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.canvas.CanvasView.toDataURL(java.lang.String, double):java.lang.String");
    }

    public void draw() {
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f17487c, 0.0f, 0.0f, (Paint) null);
    }
}
