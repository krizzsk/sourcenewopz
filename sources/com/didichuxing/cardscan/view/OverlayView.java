package com.didichuxing.cardscan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.didichuxing.cardscan.p175a.C15183d;
import com.didichuxing.xpanel.agent.NetworkCheck;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import p242io.card.payment.DetectionInfo;

public class OverlayView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private static final String f46200a = OverlayView.class.getSimpleName();

    /* renamed from: b */
    private static final GradientDrawable.Orientation[] f46201b = {GradientDrawable.Orientation.TOP_BOTTOM, GradientDrawable.Orientation.LEFT_RIGHT, GradientDrawable.Orientation.BOTTOM_TOP, GradientDrawable.Orientation.RIGHT_LEFT};

    /* renamed from: c */
    private WeakReference<CardScanActivity> f46202c;

    /* renamed from: d */
    private DetectionInfo f46203d;

    /* renamed from: e */
    private Rect f46204e;

    /* renamed from: f */
    private int f46205f;

    /* renamed from: g */
    private int f46206g;

    /* renamed from: h */
    private GradientDrawable f46207h;

    /* renamed from: i */
    private Paint f46208i;

    /* renamed from: j */
    private Paint f46209j;

    /* renamed from: k */
    private Paint f46210k;

    /* renamed from: l */
    private Path f46211l;

    /* renamed from: m */
    private Rect f46212m;

    /* renamed from: n */
    private C15188b f46213n;

    /* renamed from: o */
    private Rect f46214o;

    /* renamed from: p */
    private boolean f46215p;

    /* renamed from: q */
    private int f46216q;

    /* renamed from: r */
    private float f46217r;

    /* renamed from: s */
    private long f46218s;

    /* renamed from: t */
    private long f46219t;

    /* renamed from: u */
    private TextView f46220u;

    public OverlayView(Context context) {
        super(context);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private Rect m33191a(int i, int i2, int i3, int i4) {
        int i5 = (int) ((this.f46217r * 5.0f) / 2.0f);
        Rect rect = new Rect();
        rect.left = Math.min(i, i3) - i5;
        rect.right = Math.max(i, i3) + i5;
        rect.top = Math.min(i2, i4) - i5;
        rect.bottom = Math.max(i2, i4) + i5;
        return rect;
    }

    /* renamed from: a */
    public void mo114843a(Rect rect, int i) {
        this.f46205f = i;
        this.f46204e = rect;
        invalidate();
        this.f46216q = this.f46205f % 180 != 0 ? -1 : 1;
        if (this.f46212m != null) {
            Point point = new Point((this.f46212m.left + this.f46212m.right) / 2, (int) (((float) rect.bottom) + (this.f46217r * 60.0f)));
            float f = this.f46217r;
            this.f46214o = C15183d.m33169a(point, (int) (80.0f * f), (int) (f * 50.0f));
            GradientDrawable gradientDrawable = new GradientDrawable(f46201b[(this.f46205f / 90) % 4], new int[]{-1, -16777216});
            this.f46207h = gradientDrawable;
            gradientDrawable.setGradientType(0);
            this.f46207h.setBounds(this.f46204e);
            this.f46207h.setAlpha(50);
            Path path = new Path();
            this.f46211l = path;
            path.addRect(new RectF(this.f46212m), Path.Direction.CW);
            this.f46211l.addRect(new RectF(this.f46204e), Path.Direction.CCW);
        }
    }

    /* renamed from: a */
    public void mo114844a(CardScanActivity cardScanActivity) {
        this.f46219t = System.currentTimeMillis();
        findViewById(R.id.left_top_btn).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.bottom_btn);
        this.f46220u = textView;
        textView.setOnClickListener(this);
        this.f46220u.setText(DidiCardScanner.getInstance().getButtonText());
        this.f46202c = new WeakReference<>(cardScanActivity);
        this.f46216q = 1;
        this.f46217r = getResources().getDisplayMetrics().density;
        this.f46208i = new Paint(1);
        Paint paint = new Paint();
        this.f46209j = paint;
        paint.setColor(-1);
        this.f46209j.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.f46209j.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(1);
        this.f46210k = paint2;
        paint2.clearShadowLayer();
        this.f46210k.setStyle(Paint.Style.FILL);
        this.f46210k.setColor(1711276032);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.left_top_btn) {
            CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
            if (cardScanCallback != null) {
                cardScanCallback.onLeftTopBackBtnClick();
            }
        } else if (id == R.id.bottom_btn) {
            CardScanCallback cardScanCallback2 = DidiCardScanner.getInstance().getCardScanCallback();
            if (cardScanCallback2 != null) {
                cardScanCallback2.onBottomBackBtnClick();
                CardScanResult cardScanResult = new CardScanResult();
                cardScanResult.resultCode = 7;
                cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                cardScanResult.duration = System.currentTimeMillis() - this.f46219t;
                cardScanCallback2.onScanResult(cardScanResult);
                DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
            }
        } else {
            return;
        }
        ((CardScanActivity) this.f46202c.get()).finish();
    }

    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (this.f46204e != null && this.f46212m != null) {
            canvas.save();
            int i3 = this.f46205f;
            if (i3 == 0 || i3 == 180) {
                i2 = this.f46204e.bottom;
                i = this.f46204e.top;
            } else {
                i2 = this.f46204e.right;
                i = this.f46204e.left;
            }
            int i4 = (int) (((double) (i2 - i)) * 0.1318d);
            if (this.f46218s == 0 && this.f46203d.numVisibleEdges() == 4) {
                this.f46218s = System.currentTimeMillis();
                postInvalidateDelayed(NetworkCheck.DURATION_TIME);
            }
            canvas.drawPath(this.f46211l, this.f46210k);
            this.f46208i.clearShadowLayer();
            this.f46208i.setStyle(Paint.Style.FILL);
            this.f46208i.setColor(this.f46206g);
            canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.top, this.f46204e.left + i4, this.f46204e.top), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.top, this.f46204e.left, this.f46204e.top + i4), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.right, this.f46204e.top, this.f46204e.right - i4, this.f46204e.top), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.right, this.f46204e.top, this.f46204e.right, this.f46204e.top + i4), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.bottom, this.f46204e.left + i4, this.f46204e.bottom), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.bottom, this.f46204e.left, this.f46204e.bottom - i4), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.right, this.f46204e.bottom, this.f46204e.right - i4, this.f46204e.bottom), this.f46208i);
            canvas.drawRect(m33191a(this.f46204e.right, this.f46204e.bottom, this.f46204e.right, this.f46204e.bottom - i4), this.f46208i);
            String smallText = DidiCardScanner.getInstance().getSmallText();
            if (!TextUtils.isEmpty(smallText)) {
                canvas.drawText(smallText, (float) (getWidth() / 2), ((float) this.f46204e.bottom) + (this.f46217r * 35.0f), this.f46209j);
            }
            DetectionInfo detectionInfo = this.f46203d;
            if (detectionInfo != null) {
                if (detectionInfo.topEdge) {
                    canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.top, this.f46204e.right, this.f46204e.top), this.f46208i);
                }
                if (this.f46203d.bottomEdge) {
                    canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.bottom, this.f46204e.right, this.f46204e.bottom), this.f46208i);
                }
                if (this.f46203d.leftEdge) {
                    canvas.drawRect(m33191a(this.f46204e.left, this.f46204e.top, this.f46204e.left, this.f46204e.bottom), this.f46208i);
                }
                if (this.f46203d.rightEdge) {
                    canvas.drawRect(m33191a(this.f46204e.right, this.f46204e.top, this.f46204e.right, this.f46204e.bottom), this.f46208i);
                }
                if (this.f46203d.numVisibleEdges() < 3) {
                    float f = this.f46217r;
                    float f2 = 24.0f * f;
                    float f3 = f * 16.0f;
                    C15183d.m33170a(this.f46208i);
                    this.f46208i.setTextAlign(Paint.Align.CENTER);
                    this.f46208i.setTextSize(f3);
                    canvas.translate((float) (this.f46204e.left + (this.f46204e.width() / 2)), (float) (this.f46204e.top + (this.f46204e.height() / 2)));
                    canvas.rotate((float) (this.f46216q * this.f46205f));
                    String centerText = DidiCardScanner.getInstance().getCenterText();
                    if (!TextUtils.isEmpty(centerText)) {
                        String[] split = centerText.split("\n");
                        float f4 = (-(((((float) (split.length - 1)) * f2) - f3) / 2.0f)) - 3.0f;
                        for (String drawText : split) {
                            canvas.drawText(drawText, 0.0f, f4, this.f46208i);
                            f4 += f2;
                        }
                    }
                }
            }
            canvas.restore();
            if (this.f46215p) {
                canvas.save();
                canvas.translate(this.f46214o.exactCenterX(), this.f46214o.exactCenterY());
                canvas.rotate((float) (this.f46216q * this.f46205f));
                this.f46213n.mo114857a(canvas);
                canvas.restore();
            }
            if (this.f46218s > 0 && System.currentTimeMillis() - this.f46218s > 10000) {
                this.f46220u.setTextColor(-1);
                this.f46220u.setBackgroundResource(R.drawable.cardscan_bottom_btn_bg_highlight);
                this.f46218s = -1;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if ((motionEvent.getAction() & 255) != 0) {
                return false;
            }
            ((CardScanActivity) this.f46202c.get()).mo114834b();
            return false;
        } catch (NullPointerException unused) {
            SystemUtils.log(3, f46200a, "NullPointerException caught in onTouchEvent method", (Throwable) null, "com.didichuxing.cardscan.view.OverlayView", -1);
            return false;
        }
    }

    public void setCameraPreviewRect(Rect rect) {
        this.f46212m = rect;
    }

    public void setDetectionInfo(DetectionInfo detectionInfo) {
        DetectionInfo detectionInfo2 = this.f46203d;
        if (detectionInfo2 != null && !detectionInfo2.sameEdgesAs(detectionInfo)) {
            invalidate();
        }
        this.f46203d = detectionInfo;
    }

    public void setGuideColor(int i) {
        this.f46206g = i;
    }

    public void setTorchEnabled(boolean z) {
        C15188b bVar;
        this.f46215p = z;
        if (z && this.f46213n == null) {
            float f = this.f46217r;
            bVar = new C15188b(80.0f * f, f * 50.0f);
        } else if (this.f46213n != null) {
            bVar = null;
        } else {
            return;
        }
        this.f46213n = bVar;
    }

    public void setTorchOn(boolean z) {
        if (this.f46215p) {
            this.f46213n.mo114858a(z);
            invalidate();
        }
    }
}
