package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TextLayer extends BaseLayer {

    /* renamed from: e */
    private final StringBuilder f1560e = new StringBuilder(2);

    /* renamed from: f */
    private final RectF f1561f = new RectF();

    /* renamed from: g */
    private final Matrix f1562g = new Matrix();

    /* renamed from: h */
    private final Paint f1563h = new Paint(1) {
        {
            setStyle(Paint.Style.FILL);
        }
    };

    /* renamed from: i */
    private final Paint f1564i = new Paint(1) {
        {
            setStyle(Paint.Style.STROKE);
        }
    };

    /* renamed from: j */
    private final Map<FontCharacter, List<ContentGroup>> f1565j = new HashMap();

    /* renamed from: k */
    private final LongSparseArray<String> f1566k = new LongSparseArray<>();

    /* renamed from: l */
    private final TextKeyframeAnimation f1567l;

    /* renamed from: m */
    private final LottieDrawable f1568m;

    /* renamed from: n */
    private final LottieComposition f1569n;

    /* renamed from: o */
    private BaseKeyframeAnimation<Integer, Integer> f1570o;

    /* renamed from: p */
    private BaseKeyframeAnimation<Integer, Integer> f1571p;

    /* renamed from: q */
    private BaseKeyframeAnimation<Integer, Integer> f1572q;

    /* renamed from: r */
    private BaseKeyframeAnimation<Integer, Integer> f1573r;

    /* renamed from: s */
    private BaseKeyframeAnimation<Float, Float> f1574s;

    /* renamed from: t */
    private BaseKeyframeAnimation<Float, Float> f1575t;

    /* renamed from: u */
    private BaseKeyframeAnimation<Float, Float> f1576u;

    /* renamed from: v */
    private BaseKeyframeAnimation<Float, Float> f1577v;

    /* renamed from: w */
    private BaseKeyframeAnimation<Float, Float> f1578w;

    /* renamed from: x */
    private BaseKeyframeAnimation<Float, Float> f1579x;

    TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.f1568m = lottieDrawable;
        this.f1569n = layer.mo15435a();
        TextKeyframeAnimation createAnimation = layer.mo15454q().createAnimation();
        this.f1567l = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(this.f1567l);
        AnimatableTextProperties r = layer.mo15455r();
        if (!(r == null || r.color == null)) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = r.color.createAnimation();
            this.f1570o = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.f1570o);
        }
        if (!(r == null || r.stroke == null)) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = r.stroke.createAnimation();
            this.f1572q = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.f1572q);
        }
        if (!(r == null || r.strokeWidth == null)) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = r.strokeWidth.createAnimation();
            this.f1574s = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.f1574s);
        }
        if (r != null && r.tracking != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation5 = r.tracking.createAnimation();
            this.f1576u = createAnimation5;
            createAnimation5.addUpdateListener(this);
            addAnimation(this.f1576u);
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, (float) this.f1569n.getBounds().width(), (float) this.f1569n.getBounds().height());
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.f1568m.useTextGlyphs()) {
            canvas.setMatrix(matrix);
        }
        DocumentData documentData = (DocumentData) this.f1567l.getValue();
        Font font = this.f1569n.getFonts().get(documentData.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1571p;
        if (baseKeyframeAnimation != null) {
            this.f1563h.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f1570o;
            if (baseKeyframeAnimation2 != null) {
                this.f1563h.setColor(baseKeyframeAnimation2.getValue().intValue());
            } else {
                this.f1563h.setColor(documentData.color);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.f1573r;
        if (baseKeyframeAnimation3 != null) {
            this.f1564i.setColor(baseKeyframeAnimation3.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.f1572q;
            if (baseKeyframeAnimation4 != null) {
                this.f1564i.setColor(baseKeyframeAnimation4.getValue().intValue());
            } else {
                this.f1564i.setColor(documentData.strokeColor);
            }
        }
        int intValue = ((this.f1501d.getOpacity() == null ? 100 : this.f1501d.getOpacity().getValue().intValue()) * 255) / 100;
        this.f1563h.setAlpha(intValue);
        this.f1564i.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.f1575t;
        if (baseKeyframeAnimation5 != null) {
            this.f1564i.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f1574s;
            if (baseKeyframeAnimation6 != null) {
                this.f1564i.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
            } else {
                this.f1564i.setStrokeWidth(documentData.strokeWidth * Utils.dpScale() * Utils.getScale(matrix));
            }
        }
        if (this.f1568m.useTextGlyphs()) {
            m1362a(documentData, matrix, font, canvas);
        } else {
            m1363a(documentData, font, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m1362a(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1579x;
        if (baseKeyframeAnimation != null) {
            f = baseKeyframeAnimation.getValue().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1578w;
            if (baseKeyframeAnimation2 != null) {
                f = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                f = documentData2.size;
            }
        }
        float f2 = f / 100.0f;
        float scale = Utils.getScale(matrix);
        String str = documentData2.text;
        float dpScale = documentData2.lineHeight * Utils.dpScale();
        List<String> a = m1359a(str);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str2 = a.get(i);
            float a2 = m1356a(str2, font, f2, scale);
            canvas.save();
            m1361a(documentData2.justification, canvas2, a2);
            canvas2.translate(0.0f, (((float) i) * dpScale) - ((((float) (size - 1)) * dpScale) / 2.0f));
            m1368a(str2, documentData, matrix, font, canvas, scale, f2);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m1368a(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = this.f1569n.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                m1364a(fontCharacter, matrix, f2, documentData, canvas);
                float width = ((float) fontCharacter.getWidth()) * f2 * Utils.dpScale() * f;
                float f3 = ((float) documentData.tracking) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1577v;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.getValue().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1576u;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.getValue().floatValue();
                    }
                    canvas.translate(width + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate(width + (f3 * f), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m1363a(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        float f;
        float scale = Utils.getScale(matrix);
        Typeface typeface = this.f1568m.getTypeface(font.getFamily(), font.getStyle());
        if (typeface != null) {
            String str = documentData.text;
            TextDelegate textDelegate = this.f1568m.getTextDelegate();
            if (textDelegate != null) {
                str = textDelegate.getTextInternal(str);
            }
            this.f1563h.setTypeface(typeface);
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1579x;
            if (baseKeyframeAnimation != null) {
                f = baseKeyframeAnimation.getValue().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1578w;
                if (baseKeyframeAnimation2 != null) {
                    f = baseKeyframeAnimation2.getValue().floatValue();
                } else {
                    f = documentData.size;
                }
            }
            this.f1563h.setTextSize(f * Utils.dpScale());
            this.f1564i.setTypeface(this.f1563h.getTypeface());
            this.f1564i.setTextSize(this.f1563h.getTextSize());
            float dpScale = documentData.lineHeight * Utils.dpScale();
            List<String> a = m1359a(str);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                String str2 = a.get(i);
                m1361a(documentData.justification, canvas, this.f1564i.measureText(str2));
                canvas.translate(0.0f, (((float) i) * dpScale) - ((((float) (size - 1)) * dpScale) / 2.0f));
                m1367a(str2, documentData, canvas, scale);
                canvas.setMatrix(matrix);
            }
        }
    }

    /* renamed from: a */
    private List<String> m1359a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", StringUtils.f5622CR).replaceAll("\n", StringUtils.f5622CR).split(StringUtils.f5622CR));
    }

    /* renamed from: a */
    private void m1367a(String str, DocumentData documentData, Canvas canvas, float f) {
        float floatValue;
        int i = 0;
        while (i < str.length()) {
            String a = m1357a(str, i);
            i += a.length();
            m1366a(a, documentData, canvas);
            float measureText = this.f1563h.measureText(a, 0, 1);
            float f2 = ((float) documentData.tracking) / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f1577v;
            if (baseKeyframeAnimation != null) {
                floatValue = baseKeyframeAnimation.getValue().floatValue();
            } else {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1576u;
                if (baseKeyframeAnimation2 != null) {
                    floatValue = baseKeyframeAnimation2.getValue().floatValue();
                } else {
                    canvas.translate(measureText + (f2 * f), 0.0f);
                }
            }
            f2 += floatValue;
            canvas.translate(measureText + (f2 * f), 0.0f);
        }
    }

    /* renamed from: a */
    private float m1356a(String str, Font font, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = this.f1569n.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                f3 = (float) (((double) f3) + (fontCharacter.getWidth() * ((double) f) * ((double) Utils.dpScale()) * ((double) f2)));
            }
        }
        return f3;
    }

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3 */
    static /* synthetic */ class C14943 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.model.DocumentData$Justification[] r0 = com.airbnb.lottie.model.DocumentData.Justification.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = r0
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.C14943.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m1361a(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = C14943.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i == 3) {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    /* renamed from: a */
    private void m1364a(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> a = m1358a(fontCharacter);
        for (int i = 0; i < a.size(); i++) {
            Path path = a.get(i).getPath();
            path.computeBounds(this.f1561f, false);
            this.f1562g.set(matrix);
            this.f1562g.preTranslate(0.0f, (-documentData.baselineShift) * Utils.dpScale());
            this.f1562g.preScale(f, f);
            path.transform(this.f1562g);
            if (documentData.strokeOverFill) {
                m1360a(path, this.f1563h, canvas);
                m1360a(path, this.f1564i, canvas);
            } else {
                m1360a(path, this.f1564i, canvas);
                m1360a(path, this.f1563h, canvas);
            }
        }
    }

    /* renamed from: a */
    private void m1360a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: a */
    private void m1366a(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            m1365a(str, this.f1563h, canvas);
            m1365a(str, this.f1564i, canvas);
            return;
        }
        m1365a(str, this.f1564i, canvas);
        m1365a(str, this.f1563h, canvas);
    }

    /* renamed from: a */
    private void m1365a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    /* renamed from: a */
    private List<ContentGroup> m1358a(FontCharacter fontCharacter) {
        if (this.f1565j.containsKey(fontCharacter)) {
            return this.f1565j.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.f1568m, this, shapes.get(i)));
        }
        this.f1565j.put(fontCharacter, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private String m1357a(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!m1369a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = (long) codePointAt;
        if (this.f1566k.containsKey(j)) {
            return this.f1566k.get(j);
        }
        this.f1560e.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.f1560e.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.f1560e.toString();
        this.f1566k.put(j, sb);
        return sb;
    }

    /* renamed from: a */
    private boolean m1369a(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1571p;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1571p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1571p = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.f1571p);
        } else if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f1573r;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f1573r = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1573r = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.f1573r);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f1575t;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.f1575t = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1575t = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.f1575t);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.f1577v;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.f1577v = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1577v = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.f1577v);
        } else if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.f1579x;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.f1579x = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1579x = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.f1579x);
        }
    }
}
