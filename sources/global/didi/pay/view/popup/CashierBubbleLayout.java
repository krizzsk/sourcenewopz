package global.didi.pay.view.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class CashierBubbleLayout extends LinearLayout {
    private static final String ARROW_PLACEHOLDER = "[arrow]";
    private static final int HEIGHT_OFFSET = 5;
    private static final int HORIZONTAL_OFFSET = 2;
    private TextView center_text;
    private ImageView close_btn;
    private Context context;
    private int defaultOffset;
    private int height = 0;
    private FrameLayout left_icon;
    private int lines = 0;
    private Paint mBorderPaint;
    private Point mDatumPoint;
    public String mDirection;
    private int mOffset;
    private Path mPath;
    private int mRadius;
    private RectF mRect;
    private float pivotX;
    private float pivotY;
    private int triangleHeight;
    private int triangleWidth;
    private int width = 0;

    public @interface Direction {
    }

    private boolean checkWitchTaller(int i, int i2) {
        return i <= i2 + 5;
    }

    public CashierBubbleLayout(Context context2) {
        super(context2);
        this.context = context2;
        this.defaultOffset = context2.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_default_offset);
        this.triangleWidth = context2.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_triangle_width);
        this.triangleHeight = context2.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_triangle_height);
        this.mRadius = context2.getResources().getDimensionPixelOffset(R.dimen.g_payment_bubble_default_radius);
        init();
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnVisible(boolean z) {
        this.close_btn.setVisibility(z ? 0 : 8);
    }

    private void init() {
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mPath = new Path();
        this.mRect = new RectF();
        this.mDatumPoint = new Point();
        setWillNotDraw(false);
        inflate(this.context, R.layout.g_payment_layout_bubble, this);
        this.center_text = (TextView) findViewById(R.id.center_text);
        this.close_btn = (ImageView) findViewById(R.id.close_btn);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.left_icon);
        this.left_icon = frameLayout;
        frameLayout.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.close_btn.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.center_text.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void setTextProps(int i, int i2, int i3) {
        if (i > 0) {
            this.center_text.setTextSize(2, (float) i);
        }
        if ((i2 & i3) == 1) {
            this.center_text.setTypeface(Typeface.SANS_SERIF, 3);
        } else if (i2 == 1) {
            this.center_text.setTypeface(Typeface.SANS_SERIF, 1);
        } else if (i3 == 1) {
            this.center_text.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypeface(int i) {
        this.center_text.setTypeface(Typeface.SANS_SERIF, i);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.lines = i;
        this.center_text.setMaxLines(i);
        this.center_text.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.left_icon.getChildCount() > 0) {
                this.left_icon.removeAllViews();
            }
            this.left_icon.setVisibility(0);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.left_icon.addView(imageView);
            Glide.with(this.context).load(str).into(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view) {
        if (view != null) {
            if (this.left_icon.getChildCount() > 0) {
                this.left_icon.removeAllViews();
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.left_icon.addView(view);
            this.left_icon.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view, int i, int i2) {
        if (view != null && i > -2 && i2 > -2) {
            if (this.left_icon.getChildCount() > 0) {
                this.left_icon.removeAllViews();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.left_icon.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.left_icon.setLayoutParams(layoutParams);
            this.left_icon.requestLayout();
            this.left_icon.addView(view);
            this.left_icon.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(int i) {
        try {
            if (this.left_icon.getChildCount() > 0) {
                this.left_icon.removeAllViews();
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.left_icon.addView(imageView);
            imageView.setImageDrawable(getResources().getDrawable(i));
            this.left_icon.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
            this.left_icon.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void setWidthAndHeight(int i, int i2) {
        this.width = i;
        this.height = i2;
        setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
    }

    public void setBubbleBackgroundColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public void setBubbleBackgroundColor(String str) {
        try {
            this.mBorderPaint.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setDirection(String str, int i) {
        this.mDirection = str.replace("left", "right");
        this.mOffset = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        r3 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
        r3 = (float) (-r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r3 = ((float) r3) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b2, code lost:
        setPivot(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setPivot(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -1699597560: goto L_0x004e;
                case -1383228885: goto L_0x0044;
                case -966253391: goto L_0x003a;
                case -609197669: goto L_0x0030;
                case 115029: goto L_0x0026;
                case 3317767: goto L_0x001c;
                case 108511772: goto L_0x0012;
                case 116576946: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "top_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 5
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 2
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 0
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "top"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 1
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "bottom_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 6
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "top_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 4
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "bottom"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 3
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "bottom_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0058
            r3 = 7
            goto L_0x0059
        L_0x0058:
            r3 = -1
        L_0x0059:
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            switch(r3) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x00a4;
                case 2: goto L_0x0099;
                case 3: goto L_0x008b;
                case 4: goto L_0x0083;
                case 5: goto L_0x0076;
                case 6: goto L_0x006e;
                case 7: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            r3 = 0
            goto L_0x00b2
        L_0x0061:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.defaultOffset
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x0096
        L_0x006e:
            int r3 = r2.defaultOffset
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x0096
        L_0x0076:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.defaultOffset
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b0
        L_0x0083:
            int r3 = r2.defaultOffset
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b0
        L_0x008b:
            int r3 = r2.getWidth()
            float r3 = (float) r3
            float r0 = r3 / r1
            int r3 = r2.getLayoutHeight()
        L_0x0096:
            int r3 = -r3
            float r3 = (float) r3
            goto L_0x00b2
        L_0x0099:
            int r3 = r2.getLayoutWidth()
            int r3 = -r3
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b0
        L_0x00a4:
            int r3 = r2.getLayoutWidth()
            float r3 = (float) r3
            float r3 = r3 / r1
            r0 = r3
            goto L_0x005f
        L_0x00ac:
            int r3 = r2.getLayoutHeight()
        L_0x00b0:
            float r3 = (float) r3
            float r3 = r3 / r1
        L_0x00b2:
            r2.setPivot(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.view.popup.CashierBubbleLayout.setPivot(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        drawTopTriangle(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        drawTopTriangle(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0076, code lost:
        drawBottomTriangle(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
        drawBottomTriangle(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0089, code lost:
        drawNoneRect(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r4) {
        /*
            r3 = this;
            super.onDraw(r4)
            android.graphics.Point r0 = r3.mDatumPoint
            int r0 = r0.x
            if (r0 <= 0) goto L_0x008c
            android.graphics.Point r0 = r3.mDatumPoint
            int r0 = r0.y
            if (r0 <= 0) goto L_0x008c
            java.lang.String r0 = r3.mDirection
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1699597560: goto L_0x0060;
                case -1383228885: goto L_0x0056;
                case -966253391: goto L_0x004c;
                case -609197669: goto L_0x0042;
                case 115029: goto L_0x0038;
                case 3317767: goto L_0x002e;
                case 108511772: goto L_0x0024;
                case 116576946: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0069
        L_0x001a:
            java.lang.String r2 = "top_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 5
            goto L_0x0069
        L_0x0024:
            java.lang.String r2 = "right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 2
            goto L_0x0069
        L_0x002e:
            java.lang.String r2 = "left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 0
            goto L_0x0069
        L_0x0038:
            java.lang.String r2 = "top"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 1
            goto L_0x0069
        L_0x0042:
            java.lang.String r2 = "bottom_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 6
            goto L_0x0069
        L_0x004c:
            java.lang.String r2 = "top_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 4
            goto L_0x0069
        L_0x0056:
            java.lang.String r2 = "bottom"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 3
            goto L_0x0069
        L_0x0060:
            java.lang.String r2 = "bottom_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0069
            r1 = 7
        L_0x0069:
            switch(r1) {
                case 0: goto L_0x0085;
                case 1: goto L_0x0081;
                case 2: goto L_0x007d;
                case 3: goto L_0x006d;
                case 4: goto L_0x0070;
                case 5: goto L_0x0073;
                case 6: goto L_0x0076;
                case 7: goto L_0x0079;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x0089
        L_0x006d:
            r3.drawBottomTriangle(r4)
        L_0x0070:
            r3.drawTopTriangle(r4)
        L_0x0073:
            r3.drawTopTriangle(r4)
        L_0x0076:
            r3.drawBottomTriangle(r4)
        L_0x0079:
            r3.drawBottomTriangle(r4)
            goto L_0x0089
        L_0x007d:
            r3.drawRightTriangle(r4)
            goto L_0x008c
        L_0x0081:
            r3.drawTopTriangle(r4)
            goto L_0x008c
        L_0x0085:
            r3.drawLeftTriangle(r4)
            goto L_0x008c
        L_0x0089:
            r3.drawNoneRect(r4)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.view.popup.CashierBubbleLayout.onDraw(android.graphics.Canvas):void");
    }

    private void setPivot(float f, float f2) {
        this.pivotX = f;
        this.pivotY = f2;
    }

    private void drawLeftTriangle(Canvas canvas) {
        Path path = this.mPath;
        RectF rectF = this.mRect;
        int i = this.mRadius;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.mPath.moveTo((float) (this.mDatumPoint.x + 2), ((float) this.mDatumPoint.y) - (((float) this.triangleWidth) / 2.0f));
        this.mPath.lineTo(((float) this.mDatumPoint.x) - (((float) this.triangleHeight) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.lineTo((float) (this.mDatumPoint.x + 2), ((float) this.mDatumPoint.y) + (((float) this.triangleWidth) / 2.0f));
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mBorderPaint);
    }

    private void drawTopTriangle(Canvas canvas) {
        Path path = this.mPath;
        RectF rectF = this.mRect;
        int i = this.mRadius;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.mPath.moveTo(((float) this.mDatumPoint.x) + (((float) this.triangleHeight) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.lineTo((float) this.mDatumPoint.x, ((float) this.mDatumPoint.y) - (((float) this.triangleWidth) / 2.0f));
        this.mPath.lineTo(((float) this.mDatumPoint.x) - (((float) this.triangleHeight) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mBorderPaint);
    }

    private void drawRightTriangle(Canvas canvas) {
        Path path = this.mPath;
        RectF rectF = this.mRect;
        int i = this.mRadius;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        this.mPath.moveTo((float) (this.mDatumPoint.x - 2), ((float) this.mDatumPoint.y) - (((float) this.triangleWidth) / 2.0f));
        this.mPath.lineTo(((float) this.mDatumPoint.x) + (((float) this.triangleWidth) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.lineTo((float) (this.mDatumPoint.x - 2), ((float) this.mDatumPoint.y) + (((float) this.triangleWidth) / 2.0f));
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mBorderPaint);
    }

    private void drawBottomTriangle(Canvas canvas) {
        Path path = this.mPath;
        RectF rectF = this.mRect;
        int i = this.mRadius;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.mPath.moveTo(((float) this.mDatumPoint.x) + (((float) this.triangleHeight) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.lineTo((float) this.mDatumPoint.x, ((float) this.mDatumPoint.y) + (((float) this.triangleWidth) / 2.0f));
        this.mPath.lineTo(((float) this.mDatumPoint.x) - (((float) this.triangleHeight) / 2.0f), (float) this.mDatumPoint.y);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mBorderPaint);
    }

    /* access modifiers changed from: package-private */
    public void setTriangleWidthAndHeight(int i, int i2) {
        this.triangleHeight = i2;
        this.triangleWidth = i;
    }

    private void drawNoneRect(Canvas canvas) {
        if (getPaddingBottom() != 0) {
            Path path = this.mPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSizeChanged(int r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            super.onSizeChanged(r2, r3, r4, r5)
            android.graphics.RectF r4 = r1.mRect
            int r5 = r1.getPaddingLeft()
            float r5 = (float) r5
            r4.left = r5
            android.graphics.RectF r4 = r1.mRect
            int r5 = r1.getPaddingTop()
            float r5 = (float) r5
            r4.top = r5
            android.graphics.RectF r4 = r1.mRect
            int r5 = r1.getPaddingRight()
            int r5 = r2 - r5
            float r5 = (float) r5
            r4.right = r5
            android.graphics.RectF r4 = r1.mRect
            int r5 = r1.getPaddingBottom()
            int r5 = r3 - r5
            float r5 = (float) r5
            r4.bottom = r5
            java.lang.String r4 = r1.mDirection
            int r5 = r4.hashCode()
            r0 = 2
            switch(r5) {
                case -1699597560: goto L_0x007c;
                case -1383228885: goto L_0x0072;
                case -966253391: goto L_0x0068;
                case -609197669: goto L_0x005e;
                case 115029: goto L_0x0054;
                case 3317767: goto L_0x004a;
                case 108511772: goto L_0x0040;
                case 116576946: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0086
        L_0x0036:
            java.lang.String r5 = "top_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 5
            goto L_0x0087
        L_0x0040:
            java.lang.String r5 = "right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 2
            goto L_0x0087
        L_0x004a:
            java.lang.String r5 = "left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 0
            goto L_0x0087
        L_0x0054:
            java.lang.String r5 = "top"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 1
            goto L_0x0087
        L_0x005e:
            java.lang.String r5 = "bottom_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 6
            goto L_0x0087
        L_0x0068:
            java.lang.String r5 = "top_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 4
            goto L_0x0087
        L_0x0072:
            java.lang.String r5 = "bottom"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 3
            goto L_0x0087
        L_0x007c:
            java.lang.String r5 = "bottom_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0086
            r4 = 7
            goto L_0x0087
        L_0x0086:
            r4 = -1
        L_0x0087:
            switch(r4) {
                case 0: goto L_0x00f8;
                case 1: goto L_0x00ea;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cc;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00ad;
                case 6: goto L_0x009d;
                case 7: goto L_0x008c;
                default: goto L_0x008a;
            }
        L_0x008a:
            goto L_0x0105
        L_0x008c:
            android.graphics.Point r4 = r1.mDatumPoint
            int r5 = r1.defaultOffset
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.mDatumPoint
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0105
        L_0x009d:
            android.graphics.Point r2 = r1.mDatumPoint
            int r4 = r1.defaultOffset
            r2.x = r4
            android.graphics.Point r2 = r1.mDatumPoint
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0105
        L_0x00ad:
            android.graphics.Point r3 = r1.mDatumPoint
            int r4 = r1.defaultOffset
            int r2 = r2 - r4
            r3.x = r2
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0105
        L_0x00bd:
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r1.defaultOffset
            r2.x = r3
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0105
        L_0x00cc:
            android.graphics.Point r4 = r1.mDatumPoint
            int r2 = r2 / r0
            r4.x = r2
            android.graphics.Point r2 = r1.mDatumPoint
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0105
        L_0x00db:
            android.graphics.Point r4 = r1.mDatumPoint
            int r5 = r1.getPaddingRight()
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r3 / r0
            r2.y = r3
            goto L_0x0105
        L_0x00ea:
            android.graphics.Point r3 = r1.mDatumPoint
            int r2 = r2 / r0
            r3.x = r2
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0105
        L_0x00f8:
            android.graphics.Point r2 = r1.mDatumPoint
            int r4 = r1.getPaddingLeft()
            r2.x = r4
            android.graphics.Point r2 = r1.mDatumPoint
            int r3 = r3 / r0
            r2.y = r3
        L_0x0105:
            int r2 = r1.mOffset
            if (r2 == 0) goto L_0x010c
            r1.applyOffset()
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.view.popup.CashierBubbleLayout.onSizeChanged(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int getLayoutWidth() {
        int dip2px = UIUtils.dip2px(this.context, 27.0f);
        if (this.left_icon.getVisibility() == 0) {
            dip2px += UIUtils.dip2px(this.context, 24.0f);
        }
        if (this.close_btn.getVisibility() == 0) {
            dip2px += UIUtils.dip2px(this.context, 25.0f);
        }
        int textSize = (int) (((float) dip2px) + (this.center_text.getTextSize() * ((float) this.center_text.getText().length())));
        String name = CashierBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + textSize, (Throwable) null, "global.didi.pay.view.popup.CashierBubbleLayout", 436);
        return textSize;
    }

    /* access modifiers changed from: package-private */
    public int getLayoutHeight() {
        int dip2px = (int) (((float) (UIUtils.dip2px(this.context, 11.0f) * 2)) + this.center_text.getTextSize());
        String name = CashierBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + dip2px, (Throwable) null, "global.didi.pay.view.popup.CashierBubbleLayout", 442);
        return dip2px;
    }

    /* access modifiers changed from: package-private */
    public int[] getMeasureWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int i2 = this.width;
        if (i2 <= 0 || (i = this.height) <= 0) {
            measure(0, 0);
            int measuredWidth = getMeasuredWidth();
            int i3 = getResources().getDisplayMetrics().widthPixels;
            if (measuredWidth > i3) {
                measuredWidth = i3;
            }
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth >= i3) {
                int i4 = (i3 / measuredWidth) + (i3 % measuredWidth) > 0 ? 1 : 0;
                int i5 = this.lines;
                if (i5 > 0 && i5 < i4) {
                    i4 = i5;
                }
                measuredHeight *= i4;
            }
            int measuredHeight2 = this.left_icon.getMeasuredHeight();
            int measuredHeight3 = this.center_text.getMeasuredHeight();
            int measuredHeight4 = this.close_btn.getMeasuredHeight();
            if (checkWitchTaller(measuredHeight2, measuredHeight3) && checkWitchTaller(measuredHeight4, measuredHeight3)) {
                measuredHeight += UIUtils.dip2px(this.context, 10.0f) * 2;
            }
            iArr[0] = measuredWidth;
            iArr[1] = measuredHeight;
            return iArr;
        }
        iArr[0] = i2;
        iArr[1] = i;
        return iArr;
    }

    public void setTriangleOffset(int i) {
        this.mOffset = i;
        applyOffset();
        invalidate();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyOffset() {
        /*
            r3 = this;
            java.lang.String r0 = r3.mDirection
            int r1 = r0.hashCode()
            switch(r1) {
                case -1699597560: goto L_0x0050;
                case -1383228885: goto L_0x0046;
                case -966253391: goto L_0x003c;
                case -609197669: goto L_0x0032;
                case 115029: goto L_0x0028;
                case 3317767: goto L_0x001e;
                case 108511772: goto L_0x0014;
                case 116576946: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x005a
        L_0x000a:
            java.lang.String r1 = "top_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 5
            goto L_0x005b
        L_0x0014:
            java.lang.String r1 = "right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x001e:
            java.lang.String r1 = "left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 0
            goto L_0x005b
        L_0x0028:
            java.lang.String r1 = "top"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 2
            goto L_0x005b
        L_0x0032:
            java.lang.String r1 = "bottom_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 6
            goto L_0x005b
        L_0x003c:
            java.lang.String r1 = "top_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 4
            goto L_0x005b
        L_0x0046:
            java.lang.String r1 = "bottom"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 3
            goto L_0x005b
        L_0x0050:
            java.lang.String r1 = "bottom_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005a
            r0 = 7
            goto L_0x005b
        L_0x005a:
            r0 = -1
        L_0x005b:
            switch(r0) {
                case 0: goto L_0x0069;
                case 1: goto L_0x0069;
                case 2: goto L_0x005f;
                case 3: goto L_0x005f;
                case 4: goto L_0x005f;
                case 5: goto L_0x005f;
                case 6: goto L_0x005f;
                case 7: goto L_0x005f;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x0072
        L_0x005f:
            android.graphics.Point r0 = r3.mDatumPoint
            int r1 = r0.x
            int r2 = r3.mOffset
            int r1 = r1 + r2
            r0.x = r1
            goto L_0x0072
        L_0x0069:
            android.graphics.Point r0 = r3.mDatumPoint
            int r1 = r0.y
            int r2 = r3.mOffset
            int r1 = r1 + r2
            r0.y = r1
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.view.popup.CashierBubbleLayout.applyOffset():void");
    }

    /* access modifiers changed from: package-private */
    public float[] getPivot() {
        return new float[]{this.pivotX, this.pivotY};
    }
}
