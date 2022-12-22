package com.didi.zxing.barcodescanner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.didi.dqr.ResultPoint;
import com.didi.passenger.C10448R;
import com.didi.trackupload.sdk.Constants;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ViewfinderView extends View {
    protected static final long ANIMATION_DELAY = 80;
    protected static final int CURRENT_POINT_OPACITY = 160;
    protected static final int LASER_SCROLLING_DURATION = 1500;
    protected static final int MAX_RESULT_POINTS = 20;
    protected static final int POINT_SIZE = 6;
    protected static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    protected static final String TAG = "ViewfinderView";

    /* renamed from: a */
    private int f45322a;
    protected boolean animeFlag = true;

    /* renamed from: b */
    private ValueAnimator f45323b;

    /* renamed from: c */
    private boolean f45324c = true;
    protected CameraPreview cameraPreview;
    protected int curScrollingStep = 0;

    /* renamed from: d */
    private OnPreviewGet f45325d;
    protected int finderHeight;
    protected int finderMarginTop;
    protected int finderWidth;
    protected Rect framingRect;
    protected CanvasCookie laser;
    protected final int laserColor;
    protected final int laserEndColor;
    protected final int laserGradientRectHeight;
    protected final int laserStartColor;
    protected List<ResultPoint> lastPossibleResultPoints;
    protected CanvasCookie mask;
    protected final int maskColor;
    protected int maskHorizontalMargin;
    protected int maskRound;
    protected int maskVerticalMargin;
    protected CanvasCookie outerRoundCorner;
    protected Path outerRoundCornerPath;
    protected final Paint paint = new Paint(1);
    protected List<ResultPoint> possibleResultPoints;
    protected Rect previewFramingRect;
    protected Bitmap resultBitmap;
    protected final int resultColor;
    protected final int resultPointColor;
    protected CanvasCookie resultPoints;
    protected int round;
    protected final int roundColor;
    protected int scanStyle;
    protected int scannerAlpha;

    private interface CanvasCookie {
        void drawCookie(Canvas canvas);
    }

    public interface OnPreviewGet {
        void onPreviewGet(Rect rect);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.zxing_finder);
        this.maskColor = obtainStyledAttributes.getColor(11, resources.getColor(R.color.zxing_viewfinder_mask));
        int dimension = (int) obtainStyledAttributes.getDimension(5, 0.0f);
        this.maskRound = dimension;
        if (dimension == 0) {
            this.mask = m32540c();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mask = m32536a();
        } else {
            this.mask = m32539b();
        }
        this.maskHorizontalMargin = (int) obtainStyledAttributes.getDimension(4, 0.0f);
        this.maskVerticalMargin = (int) obtainStyledAttributes.getDimension(3, 0.0f);
        this.finderWidth = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.finderHeight = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        this.finderMarginTop = (int) obtainStyledAttributes.getDimension(1, 0.0f);
        this.resultColor = obtainStyledAttributes.getColor(7, resources.getColor(R.color.zxing_result_view));
        int color = obtainStyledAttributes.getColor(9, resources.getColor(R.color.zxing_viewfinder_laser));
        this.laserColor = color;
        this.laserStartColor = Color.argb(0, Color.red(color), Color.green(this.laserColor), Color.blue(this.laserColor));
        this.laserEndColor = Color.argb(102, Color.red(this.laserColor), Color.green(this.laserColor), Color.blue(this.laserColor));
        this.laserGradientRectHeight = (int) obtainStyledAttributes.getDimension(10, 100.0f);
        this.resultPointColor = obtainStyledAttributes.getColor(6, resources.getColor(R.color.zxing_possible_result_points));
        int integer = obtainStyledAttributes.getInteger(8, 0);
        this.scanStyle = integer;
        if (integer == 2) {
            this.laser = m32543f();
        } else if (integer == 1) {
            this.laser = m32544g();
        }
        this.roundColor = obtainStyledAttributes.getColor(13, 0);
        int dimension2 = (int) obtainStyledAttributes.getDimension(12, 0.0f);
        this.round = dimension2;
        if (dimension2 > 0 && Build.VERSION.SDK_INT >= 21) {
            this.outerRoundCorner = m32546i();
        }
        this.resultPoints = m32545h();
        obtainStyledAttributes.recycle();
        this.scannerAlpha = 0;
        this.possibleResultPoints = new ArrayList(5);
        this.lastPossibleResultPoints = null;
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null) {
            this.f45322a = config.cropRedundancy();
        }
    }

    public void setAnimeFlag(boolean z) {
        if (z != this.animeFlag) {
            this.animeFlag = z;
            if (z) {
                invalidate();
                m32541d();
                return;
            }
            invalidate();
            m32542e();
        }
    }

    public void setCameraPreview(CameraPreview cameraPreview2) {
        this.cameraPreview = cameraPreview2;
        cameraPreview2.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void cameraError(Exception exc) {
            }

            public void previewStarted() {
            }

            public void previewStopped() {
            }

            public void previewSized() {
                ViewfinderView.this.refreshSizes();
                ViewfinderView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void refreshSizes() {
        int i;
        CameraPreview cameraPreview2 = this.cameraPreview;
        if (cameraPreview2 != null) {
            this.f45324c = false;
            Rect framingRect2 = cameraPreview2.getFramingRect();
            Rect previewFramingRect2 = this.cameraPreview.getPreviewFramingRect();
            if (this.maskHorizontalMargin > 0 || this.maskVerticalMargin > 0) {
                this.framingRect = new Rect(this.maskHorizontalMargin, this.maskVerticalMargin, getWidth() - this.maskHorizontalMargin, getHeight() - this.maskVerticalMargin);
            } else if (this.finderWidth <= 0 || this.finderHeight <= 0) {
                this.framingRect = framingRect2;
            } else {
                int width = getWidth();
                int i2 = this.finderWidth;
                int i3 = (width - i2) / 2;
                int i4 = i2 + i3;
                int i5 = this.finderMarginTop;
                if (i5 > 0) {
                    i = this.finderHeight;
                } else {
                    int height = getHeight();
                    i = this.finderHeight;
                    i5 = (height - i) / 2;
                }
                this.framingRect = new Rect(i3, i5, i4, i + i5);
            }
            if (previewFramingRect2 != null) {
                this.previewFramingRect = previewFramingRect2;
            }
            if (this.f45325d != null) {
                Rect rect = this.framingRect;
                if (!(previewFramingRect2 == null || framingRect2 == null)) {
                    int dip2px = C14921Util.dip2px(getContext(), (float) this.f45322a);
                    Rect rect2 = new Rect((this.framingRect.left * previewFramingRect2.width()) / framingRect2.width(), (this.framingRect.top * previewFramingRect2.height()) / framingRect2.height(), (this.framingRect.right * previewFramingRect2.width()) / framingRect2.width(), (this.framingRect.bottom * previewFramingRect2.height()) / framingRect2.height());
                    if (rect2.left < dip2px) {
                        dip2px = rect2.left;
                    }
                    if (rect2.top < dip2px) {
                        dip2px = rect2.top;
                    }
                    rect2.set(rect2.left - dip2px, rect2.top - dip2px, rect2.right + dip2px, rect2.bottom + dip2px);
                    rect = rect2;
                }
                m32537a(rect);
                this.f45325d.onPreviewGet(rect);
            }
        }
    }

    /* renamed from: a */
    private void m32537a(Rect rect) {
        rect.set(rect.left, rect.top, rect.right - ((-rect.width()) % 2), rect.bottom - ((-rect.height()) % 3));
    }

    /* renamed from: a */
    private CanvasCookie m32536a() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                Canvas canvas2 = canvas;
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Rect rect = ViewfinderView.this.framingRect;
                ViewfinderView.this.paint.setColor(ViewfinderView.this.resultBitmap != null ? ViewfinderView.this.resultColor : ViewfinderView.this.maskColor);
                ViewfinderView.this.paint.setStyle(Paint.Style.FILL);
                Path path = new Path();
                path.moveTo((float) (rect.left + ViewfinderView.this.maskRound), (float) rect.top);
                path.lineTo((float) (rect.left + ViewfinderView.this.maskRound), 0.0f);
                path.lineTo(0.0f, 0.0f);
                path.lineTo(0.0f, (float) (rect.top + ViewfinderView.this.maskRound));
                path.lineTo((float) rect.left, (float) (rect.top + ViewfinderView.this.maskRound));
                path.arcTo((float) rect.left, (float) rect.top, (float) (rect.left + (ViewfinderView.this.maskRound * 2)), (float) (rect.top + (ViewfinderView.this.maskRound * 2)), 180.0f, 90.0f, false);
                path.close();
                canvas2.drawPath(path, ViewfinderView.this.paint);
                Path path2 = new Path();
                path2.moveTo((float) rect.right, (float) (rect.top + ViewfinderView.this.maskRound));
                float f = (float) width;
                path2.lineTo(f, (float) (rect.top + ViewfinderView.this.maskRound));
                path2.lineTo(f, 0.0f);
                path2.lineTo((float) (rect.right - ViewfinderView.this.maskRound), 0.0f);
                path2.lineTo((float) (rect.right - ViewfinderView.this.maskRound), (float) rect.top);
                path2.arcTo((float) (rect.right - (ViewfinderView.this.maskRound * 2)), (float) rect.top, (float) rect.right, (float) (rect.top + (ViewfinderView.this.maskRound * 2)), -90.0f, 90.0f, false);
                path2.close();
                canvas2.drawPath(path2, ViewfinderView.this.paint);
                Path path3 = new Path();
                path3.moveTo((float) rect.left, (float) (rect.bottom - ViewfinderView.this.maskRound));
                path3.lineTo(0.0f, (float) (rect.bottom - ViewfinderView.this.maskRound));
                float f2 = (float) height;
                path3.lineTo(0.0f, f2);
                path3.lineTo((float) (rect.left + ViewfinderView.this.maskRound), f2);
                path3.lineTo((float) (rect.left + ViewfinderView.this.maskRound), (float) rect.bottom);
                path3.arcTo((float) rect.left, (float) (rect.bottom - (ViewfinderView.this.maskRound * 2)), (float) (rect.left + (ViewfinderView.this.maskRound * 2)), (float) rect.bottom, 90.0f, 90.0f, false);
                path3.close();
                canvas2.drawPath(path3, ViewfinderView.this.paint);
                Path path4 = new Path();
                path4.moveTo((float) (rect.right - ViewfinderView.this.maskRound), (float) rect.bottom);
                path4.lineTo((float) (rect.right - ViewfinderView.this.maskRound), f2);
                path4.lineTo(f, f2);
                path4.lineTo(f, (float) (rect.bottom - ViewfinderView.this.maskRound));
                path4.lineTo((float) rect.right, (float) (rect.bottom - ViewfinderView.this.maskRound));
                path4.arcTo((float) (rect.right - (ViewfinderView.this.maskRound * 2)), (float) (rect.bottom - (ViewfinderView.this.maskRound * 2)), (float) rect.right, (float) rect.bottom, 0.0f, 90.0f, false);
                path4.close();
                canvas2.drawPath(path4, ViewfinderView.this.paint);
                canvas2.drawRect(new Rect(0, rect.top + ViewfinderView.this.maskRound, rect.left, rect.bottom - ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas2.drawRect(new Rect(rect.left + ViewfinderView.this.maskRound, 0, rect.right - ViewfinderView.this.maskRound, rect.top), ViewfinderView.this.paint);
                canvas2.drawRect(new Rect(rect.right, rect.top + ViewfinderView.this.maskRound, width, rect.bottom - ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas2.drawRect(new Rect(rect.left + ViewfinderView.this.maskRound, rect.bottom, rect.right - ViewfinderView.this.maskRound, height), ViewfinderView.this.paint);
                ViewfinderView.this.paint.setColor(-1);
                ViewfinderView.this.paint.setStyle(Paint.Style.STROKE);
                canvas.drawRoundRect((float) (rect.left - 1), (float) (rect.top - 1), (float) (rect.right + 1), (float) (rect.bottom + 1), (float) ViewfinderView.this.maskRound, (float) ViewfinderView.this.maskRound, ViewfinderView.this.paint);
            }
        };
    }

    /* renamed from: b */
    private CanvasCookie m32539b() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Rect rect = ViewfinderView.this.framingRect;
                ViewfinderView.this.paint.setColor(ViewfinderView.this.resultBitmap != null ? ViewfinderView.this.resultColor : ViewfinderView.this.maskColor);
                ViewfinderView.this.paint.setStyle(Paint.Style.FILL);
                canvas.save();
                Path path = new Path();
                path.addCircle((float) (rect.left + ViewfinderView.this.maskRound), (float) (rect.top + ViewfinderView.this.maskRound), (float) ViewfinderView.this.maskRound, Path.Direction.CW);
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawRect(new Rect(0, 0, rect.left + ViewfinderView.this.maskRound, rect.top + ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas.restore();
                canvas.save();
                Path path2 = new Path();
                path2.addCircle((float) (rect.right - ViewfinderView.this.maskRound), (float) (rect.top + ViewfinderView.this.maskRound), (float) ViewfinderView.this.maskRound, Path.Direction.CW);
                canvas.clipPath(path2, Region.Op.DIFFERENCE);
                canvas.drawRect(new Rect(rect.right - ViewfinderView.this.maskRound, 0, width, rect.top + ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas.restore();
                canvas.save();
                Path path3 = new Path();
                path3.addCircle((float) (rect.left + ViewfinderView.this.maskRound), (float) (rect.bottom - ViewfinderView.this.maskRound), (float) ViewfinderView.this.maskRound, Path.Direction.CW);
                canvas.clipPath(path3, Region.Op.DIFFERENCE);
                canvas.drawRect(new Rect(0, rect.bottom - ViewfinderView.this.maskRound, rect.left + ViewfinderView.this.maskRound, height), ViewfinderView.this.paint);
                canvas.restore();
                canvas.save();
                Path path4 = new Path();
                path4.addCircle((float) (rect.right - ViewfinderView.this.maskRound), (float) (rect.bottom - ViewfinderView.this.maskRound), (float) ViewfinderView.this.maskRound, Path.Direction.CW);
                canvas.clipPath(path4, Region.Op.DIFFERENCE);
                canvas.drawRect(new Rect(rect.right - ViewfinderView.this.maskRound, rect.bottom - ViewfinderView.this.maskRound, width, height), ViewfinderView.this.paint);
                canvas.restore();
                canvas.drawRect(new Rect(0, rect.top + ViewfinderView.this.maskRound, rect.left, rect.bottom - ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas.drawRect(new Rect(rect.left + ViewfinderView.this.maskRound, 0, rect.right - ViewfinderView.this.maskRound, rect.top), ViewfinderView.this.paint);
                canvas.drawRect(new Rect(rect.right, rect.top + ViewfinderView.this.maskRound, width, rect.bottom - ViewfinderView.this.maskRound), ViewfinderView.this.paint);
                canvas.drawRect(new Rect(rect.left + ViewfinderView.this.maskRound, rect.bottom, rect.right - ViewfinderView.this.maskRound, height), ViewfinderView.this.paint);
                ViewfinderView.this.paint.setColor(-1);
                ViewfinderView.this.paint.setStyle(Paint.Style.STROKE);
                canvas.drawRoundRect((float) (rect.left - 1), (float) (rect.top - 1), (float) (rect.right + 1), (float) (rect.bottom + 1), (float) ViewfinderView.this.maskRound, (float) ViewfinderView.this.maskRound, ViewfinderView.this.paint);
            }
        };
    }

    /* renamed from: c */
    private CanvasCookie m32540c() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Rect rect = ViewfinderView.this.framingRect;
                ViewfinderView.this.paint.setStyle(Paint.Style.FILL);
                ViewfinderView.this.paint.setColor(ViewfinderView.this.resultBitmap != null ? ViewfinderView.this.resultColor : ViewfinderView.this.maskColor);
                float f = (float) width;
                canvas.drawRect(0.0f, 0.0f, f, (float) rect.top, ViewfinderView.this.paint);
                canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), ViewfinderView.this.paint);
                Canvas canvas2 = canvas;
                float f2 = f;
                canvas2.drawRect((float) (rect.right + 1), (float) rect.top, f2, (float) (rect.bottom + 1), ViewfinderView.this.paint);
                canvas2.drawRect(0.0f, (float) (rect.bottom + 1), f2, (float) height, ViewfinderView.this.paint);
                ViewfinderView.this.paint.setStyle(Paint.Style.STROKE);
                ViewfinderView.this.paint.setColor(-1);
                ViewfinderView.this.paint.setStrokeWidth((float) 8);
                int width2 = rect.width() / 10;
                Canvas canvas3 = canvas;
                canvas3.drawLine((float) (rect.left + 4), (float) (rect.top + 4), (float) (rect.left + 4 + width2), (float) (rect.top + 4), ViewfinderView.this.paint);
                canvas3.drawLine((float) (rect.left + 4), (float) rect.top, (float) (rect.left + 4), (float) (rect.top + 4 + width2), ViewfinderView.this.paint);
                canvas3.drawLine((float) rect.right, (float) (rect.top + 4), (float) ((rect.right - 4) - width2), (float) (rect.top + 4), ViewfinderView.this.paint);
                canvas3.drawLine((float) ((rect.right - 4) + 1), (float) rect.top, (float) ((rect.right - 4) + 1), (float) (rect.top + 4 + width2), ViewfinderView.this.paint);
                canvas3.drawLine((float) rect.left, (float) ((rect.bottom - 4) + 1), (float) (rect.left + 4 + width2), (float) ((rect.bottom - 4) + 1), ViewfinderView.this.paint);
                canvas3.drawLine((float) (rect.left + 4), (float) (rect.bottom - 4), (float) (rect.left + 4), (float) ((rect.bottom - 4) - width2), ViewfinderView.this.paint);
                canvas3.drawLine((float) (rect.right + 1), (float) ((rect.bottom - 4) + 1), (float) (rect.right - width2), (float) ((rect.bottom - 4) + 1), ViewfinderView.this.paint);
                canvas3.drawLine((float) ((rect.right - 4) + 1), (float) rect.bottom, (float) ((rect.right - 4) + 1), (float) ((rect.bottom - 4) - width2), ViewfinderView.this.paint);
                ViewfinderView.this.paint.setStrokeWidth(0.0f);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32541d() {
        Rect rect;
        if (this.animeFlag && (rect = this.framingRect) != null && this.scanStyle == 2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, rect.height() + this.laserGradientRectHeight});
            this.f45323b = ofInt;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewfinderView.this.curScrollingStep = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewfinderView.this.invalidate();
                }
            });
            this.f45323b.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    ViewfinderView.this.m32541d();
                }
            });
            this.f45323b.setInterpolator(new DecelerateInterpolator());
            this.f45323b.setDuration(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            this.f45323b.start();
        }
    }

    /* renamed from: e */
    private void m32542e() {
        ValueAnimator valueAnimator = this.f45323b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: f */
    private CanvasCookie m32543f() {
        return new CanvasCookie() {
            private Bitmap gradientBitmap;

            public void drawCookie(Canvas canvas) {
                ViewfinderView.this.paint.setStyle(Paint.Style.FILL);
                ViewfinderView.this.paint.setColor(ViewfinderView.this.laserColor);
                Rect rect = ViewfinderView.this.framingRect;
                int i = rect.top + ViewfinderView.this.curScrollingStep;
                int i2 = rect.left + 2;
                int i3 = rect.right - 1;
                if (this.gradientBitmap == null) {
                    this.gradientBitmap = createGradientBitmap(i3 - i2, ViewfinderView.this.laserGradientRectHeight);
                }
                canvas.save();
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipRect(rect);
                } else {
                    canvas.clipRect(rect, Region.Op.REPLACE);
                }
                float f = (float) i2;
                canvas.drawBitmap(this.gradientBitmap, f, (float) (i - ViewfinderView.this.laserGradientRectHeight), (Paint) null);
                canvas.drawRect(f, (float) (i - 1), (float) i3, (float) (i + 1), ViewfinderView.this.paint);
                canvas.restore();
            }

            private Bitmap createGradientBitmap(int i, int i2) {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) ViewfinderView.this.laserGradientRectHeight, ViewfinderView.this.laserStartColor, ViewfinderView.this.laserEndColor, Shader.TileMode.MIRROR);
                Paint paint = new Paint();
                paint.setShader(linearGradient);
                new Canvas(createBitmap).drawRect(0.0f, 0.0f, (float) ViewfinderView.this.getWidth(), (float) ViewfinderView.this.getHeight(), paint);
                return createBitmap;
            }
        };
    }

    /* renamed from: g */
    private CanvasCookie m32544g() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                ViewfinderView.this.paint.setColor(ViewfinderView.this.laserColor);
                ViewfinderView.this.paint.setAlpha(ViewfinderView.SCANNER_ALPHA[ViewfinderView.this.scannerAlpha]);
                ViewfinderView viewfinderView = ViewfinderView.this;
                viewfinderView.scannerAlpha = (viewfinderView.scannerAlpha + 1) % ViewfinderView.SCANNER_ALPHA.length;
                int height = (ViewfinderView.this.framingRect.height() / 2) + ViewfinderView.this.framingRect.top;
                canvas.drawRect((float) (ViewfinderView.this.framingRect.left + 2), (float) (height - 1), (float) (ViewfinderView.this.framingRect.right - 1), (float) (height + 2), ViewfinderView.this.paint);
            }
        };
    }

    /* renamed from: h */
    private CanvasCookie m32545h() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                Rect rect = ViewfinderView.this.framingRect;
                Rect rect2 = ViewfinderView.this.previewFramingRect;
                if (rect2 != null) {
                    float width = ((float) rect.width()) / ((float) rect2.width());
                    float height = ((float) rect.height()) / ((float) rect2.height());
                    List<ResultPoint> list = ViewfinderView.this.possibleResultPoints;
                    List<ResultPoint> list2 = ViewfinderView.this.lastPossibleResultPoints;
                    int i = rect.left;
                    int i2 = rect.top;
                    if (list.isEmpty()) {
                        ViewfinderView.this.lastPossibleResultPoints = null;
                    } else {
                        ViewfinderView.this.possibleResultPoints = new ArrayList(5);
                        ViewfinderView.this.lastPossibleResultPoints = list;
                        ViewfinderView.this.paint.setAlpha(160);
                        ViewfinderView.this.paint.setColor(ViewfinderView.this.resultPointColor);
                        for (ResultPoint next : list) {
                            canvas.drawCircle((float) (((int) (next.getX() * width)) + i), (float) (((int) (next.getY() * height)) + i2), 6.0f, ViewfinderView.this.paint);
                        }
                    }
                    if (list2 != null) {
                        ViewfinderView.this.paint.setAlpha(80);
                        ViewfinderView.this.paint.setColor(ViewfinderView.this.resultPointColor);
                        for (ResultPoint next2 : list2) {
                            canvas.drawCircle((float) (((int) (next2.getX() * width)) + i), (float) (((int) (next2.getY() * height)) + i2), 3.0f, ViewfinderView.this.paint);
                        }
                    }
                }
            }
        };
    }

    /* renamed from: i */
    private CanvasCookie m32546i() {
        return new CanvasCookie() {
            public void drawCookie(Canvas canvas) {
                if (ViewfinderView.this.outerRoundCornerPath == null) {
                    ViewfinderView.this.outerRoundCornerPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) ViewfinderView.this.getWidth(), (float) ViewfinderView.this.getHeight());
                    ViewfinderView.this.outerRoundCornerPath.addRoundRect(rectF, new float[]{(float) ViewfinderView.this.round, (float) ViewfinderView.this.round, (float) ViewfinderView.this.round, (float) ViewfinderView.this.round, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
                canvas.save();
                canvas.clipRect(0, 0, ViewfinderView.this.getWidth(), ViewfinderView.this.getHeight());
                canvas.clipPath(ViewfinderView.this.outerRoundCornerPath, Region.Op.DIFFERENCE);
                canvas.drawColor(ViewfinderView.this.roundColor);
                canvas.restore();
            }
        };
    }

    public void onDraw(Canvas canvas) {
        refreshSizes();
        Rect rect = this.framingRect;
        if (rect != null) {
            CanvasCookie canvasCookie = this.mask;
            if (canvasCookie != null) {
                canvasCookie.drawCookie(canvas);
            }
            if (this.resultBitmap != null) {
                this.paint.setAlpha(160);
                canvas.drawBitmap(this.resultBitmap, (Rect) null, rect, this.paint);
                return;
            }
            CanvasCookie canvasCookie2 = this.laser;
            if (canvasCookie2 != null && this.animeFlag) {
                canvasCookie2.drawCookie(canvas);
            }
            CanvasCookie canvasCookie3 = this.resultPoints;
            if (canvasCookie3 != null) {
                canvasCookie3.drawCookie(canvas);
            }
            CanvasCookie canvasCookie4 = this.outerRoundCorner;
            if (canvasCookie4 != null) {
                canvasCookie4.drawCookie(canvas);
            }
            if (this.animeFlag && this.scanStyle != 2) {
                postInvalidateDelayed(ANIMATION_DELAY, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f45324c = true;
    }

    public void drawViewfinder() {
        Bitmap bitmap = this.resultBitmap;
        this.resultBitmap = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
        invalidate();
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        List<ResultPoint> list = this.possibleResultPoints;
        list.add(resultPoint);
        int size = list.size();
        if (size > 20) {
            list.subList(0, size - 10).clear();
        }
    }

    public void setOnPreviewGet(OnPreviewGet onPreviewGet) {
        this.f45325d = onPreviewGet;
    }

    public void setViewPosition(int i, int i2, int i3) {
        this.finderWidth = i;
        this.finderHeight = i2;
        this.finderMarginTop = i3;
        refreshSizes();
    }
}
