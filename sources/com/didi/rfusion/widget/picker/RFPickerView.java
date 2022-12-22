package com.didi.rfusion.widget.picker;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFUtils;
import com.didi.rfusion.widget.picker.RFPickerView;
import com.taxis99.R;
import java.util.List;

public class RFPickerView extends View {

    /* renamed from: a */
    static final int f33614a = 1;

    /* renamed from: b */
    private static final boolean f33615b = false;

    /* renamed from: c */
    private static final String f33616c = "PickerView";

    /* renamed from: f */
    private static final int f33617f = 250;

    /* renamed from: g */
    private static final int f33618g = 1000;

    /* renamed from: A */
    private int f33619A;

    /* renamed from: B */
    private int f33620B;

    /* renamed from: C */
    private Typeface f33621C;

    /* renamed from: D */
    private boolean f33622D;

    /* renamed from: E */
    private boolean f33623E;

    /* renamed from: F */
    private boolean f33624F;

    /* renamed from: G */
    private Layout.Alignment f33625G;

    /* renamed from: H */
    private float f33626H;

    /* renamed from: I */
    private Camera f33627I;

    /* renamed from: J */
    private Matrix f33628J;

    /* renamed from: K */
    private RFusionConfig.IRFusionLogger f33629K;

    /* renamed from: L */
    private OnSelectedItemChangedListener f33630L;

    /* renamed from: d */
    private int f33631d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f33632e;

    /* renamed from: h */
    private RFPickerAdapter<? extends RFPickerItem> f33633h;

    /* renamed from: i */
    private Paint f33634i;

    /* renamed from: j */
    private Rect f33635j;

    /* renamed from: k */
    private GestureDetector f33636k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OverScroller f33637l;

    /* renamed from: m */
    private boolean f33638m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f33639n;

    /* renamed from: o */
    private boolean f33640o;

    /* renamed from: p */
    private float f33641p;

    /* renamed from: q */
    private float f33642q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f33643r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f33644s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f33645t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f33646u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f33647v;

    /* renamed from: w */
    private int f33648w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f33649x;

    /* renamed from: y */
    private int f33650y;

    /* renamed from: z */
    private int f33651z;

    public interface OnItemSelectedListener<T extends RFPickerItem> {
        void onItemSelected(T t);
    }

    public interface OnSelectedItemChangedListener {
        void onSelectedItemChanged(RFPickerView rFPickerView, int i, int i2);
    }

    public RFPickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33631d = 1;
        this.f33635j = new Rect();
        this.f33619A = -16777216;
        this.f33620B = -16777216;
        this.f33625G = Layout.Alignment.ALIGN_CENTER;
        this.f33629K = RFusion.getLogger();
        m23686a(context, attributeSet);
    }

    /* renamed from: a */
    private void m23686a(Context context, AttributeSet attributeSet) {
        this.f33636k = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int a = RFPickerView.this.f33644s - (RFPickerView.this.f33649x * RFPickerView.this.f33632e);
                if (a <= RFPickerView.this.f33645t || a >= RFPickerView.this.f33646u) {
                    RFPickerView.this.mo87982a(1000);
                    return true;
                }
                RFPickerView.this.f33637l.fling(0, a, 0, (int) f2, 0, 0, RFPickerView.this.f33645t, RFPickerView.this.f33646u, 0, RFPickerView.this.f33647v);
                RFPickerView rFPickerView = RFPickerView.this;
                int unused = rFPickerView.f33643r = rFPickerView.f33637l.getCurrY();
                boolean unused2 = RFPickerView.this.f33639n = true;
                return true;
            }
        });
        this.f33637l = new OverScroller(getContext());
        this.f33648w = ViewConfiguration.get(context).getScaledTouchSlop();
        if (isInEditMode()) {
            this.f33633h = new RFPickerAdapter<RFPickerItem>() {
                public int getItemCount() {
                    return RFPickerView.this.getMaxCount();
                }

                public RFPickerItem getItem(final int i) {
                    return new RFPickerItem() {
                        public String getText() {
                            return "Item " + i;
                        }
                    };
                }
            };
        }
        this.f33631d = 1;
        this.f33649x = (int) RFResUtils.getDimens(R.dimen.f_04_app_48_pad_32);
        this.f33650y = (int) RFResUtils.getDimens(R.dimen.f_04_app_48_pad_32);
        this.f33651z = (int) RFResUtils.getDimens(getContext(), R.dimen.f_06_app_40_pad_28);
        this.f33619A = RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000);
        this.f33620B = RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5);
        m23694c();
        this.f33627I = new Camera();
        this.f33628J = new Matrix();
    }

    /* renamed from: c */
    private void m23694c() {
        Paint paint = new Paint();
        this.f33634i = paint;
        paint.setAntiAlias(true);
    }

    public <T extends RFPickerItem> void setAdapter(RFPickerAdapter<T> rFPickerAdapter) {
        RFUtils.checkNotNull(rFPickerAdapter, "adapter == null");
        if (rFPickerAdapter.getItemCount() <= Integer.MAX_VALUE / this.f33649x) {
            rFPickerAdapter.setPickerView(this);
            this.f33633h = rFPickerAdapter;
            return;
        }
        throw new RuntimeException("getItemCount() is too large, max count can be PickerView.getMaxCount()");
    }

    public RFPickerAdapter getAdapter() {
        return this.f33633h;
    }

    public <T extends RFPickerItem> void setItems(final List<T> list, OnItemSelectedListener<T> onItemSelectedListener) {
        C115633 r0 = new RFPickerAdapter<T>() {
            public int getItemCount() {
                return list.size();
            }

            public T getItem(int i) {
                return (RFPickerItem) list.get(i);
            }
        };
        setAdapter(r0);
        setOnSelectedItemChangedListener(new OnSelectedItemChangedListener(r0) {
            public final /* synthetic */ RFPickerAdapter f$1;

            {
                this.f$1 = r2;
            }

            public final void onSelectedItemChanged(RFPickerView rFPickerView, int i, int i2) {
                RFPickerView.m23689a(RFPickerView.OnItemSelectedListener.this, this.f$1, rFPickerView, i, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m23689a(OnItemSelectedListener onItemSelectedListener, RFPickerAdapter rFPickerAdapter, RFPickerView rFPickerView, int i, int i2) {
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(rFPickerAdapter.getItem(i2));
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxCount() {
        return Integer.MAX_VALUE / this.f33649x;
    }

    public void notifyDataSetChanged() {
        RFPickerAdapter<? extends RFPickerItem> rFPickerAdapter = this.f33633h;
        if (rFPickerAdapter != null) {
            rFPickerAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87981a() {
        m23685a((int) Math.floor((double) m23699e()), true);
    }

    public int getSelectedItemPosition() {
        return m23697d(this.f33632e);
    }

    /* access modifiers changed from: package-private */
    public OverScroller getScroller() {
        return this.f33637l;
    }

    public void setSelectedItemPosition(int i) {
        RFUtils.checkNotNull(this.f33633h, "adapter must be set first");
        m23692b(i);
        invalidate();
    }

    public <T extends RFPickerItem> T getSelectedItem(Class<T> cls) {
        RFUtils.checkNotNull(this.f33633h, "adapter must be set first");
        Object item = this.f33633h.getItem(getSelectedItemPosition());
        if (!cls.isInstance(item)) {
            return null;
        }
        return (RFPickerItem) cls.cast(item);
    }

    public void setOnSelectedItemChangedListener(OnSelectedItemChangedListener onSelectedItemChangedListener) {
        this.f33630L = onSelectedItemChangedListener;
    }

    /* renamed from: b */
    private void m23692b(int i) {
        m23685a(i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23685a(int r5, boolean r6) {
        /*
            r4 = this;
            int r0 = r4.f33632e
            int r1 = r4.m23697d((int) r5)
            boolean r2 = r4.f33622D
            r3 = 1
            if (r2 == 0) goto L_0x0012
            int r2 = r4.f33632e
            if (r2 == r5) goto L_0x0019
            r4.f33632e = r5
            goto L_0x0018
        L_0x0012:
            int r5 = r4.f33632e
            if (r5 == r1) goto L_0x0019
            r4.f33632e = r1
        L_0x0018:
            r6 = 1
        L_0x0019:
            if (r6 == 0) goto L_0x0022
            com.didi.rfusion.widget.picker.RFPickerView$OnSelectedItemChangedListener r5 = r4.f33630L
            if (r5 == 0) goto L_0x0022
            r5.onSelectedItemChanged(r4, r0, r1)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.picker.RFPickerView.m23685a(int, boolean):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RFUtils.checkNotNull(this.f33633h, "adapter == null");
        int resolveSizeAndState = resolveSizeAndState(m23696d(), i2, 0);
        mo87983b();
        setMeasuredDimension(i, resolveSizeAndState);
    }

    /* renamed from: d */
    private int m23696d() {
        if (!this.f33624F) {
            return ((this.f33631d * 2) + 1) * this.f33649x;
        }
        float sin = ((float) this.f33649x) / ((float) Math.sin(3.141592653589793d / ((double) ((this.f33631d * 2) + 3))));
        this.f33626H = sin;
        return (int) Math.ceil((double) (sin * 2.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RFUtils.checkNotNull(this.f33633h, "adapter == null");
        if (this.f33633h.getItemCount() != 0 && this.f33649x != 0) {
            m23687a(canvas);
        }
    }

    /* renamed from: a */
    private void m23687a(Canvas canvas) {
        float measuredHeight = ((float) this.f33644s) + ((((float) (getMeasuredHeight() - this.f33649x)) * 1.0f) / 2.0f);
        m23688a(canvas, this.f33633h.getText(m23697d(this.f33632e)), measuredHeight);
        float f = measuredHeight - ((float) this.f33649x);
        int i = this.f33632e - 1;
        while (true) {
            if (((float) (this.f33649x * (this.f33624F ? 2 : 1))) + f <= 0.0f || (m23695c(i) && !this.f33622D)) {
                float measuredHeight2 = (float) (this.f33644s + ((getMeasuredHeight() + this.f33649x) / 2));
                int i2 = this.f33632e + 1;
            } else {
                m23688a(canvas, this.f33633h.getText(m23697d(i)), f);
                f -= (float) this.f33649x;
                i--;
            }
        }
        float measuredHeight22 = (float) (this.f33644s + ((getMeasuredHeight() + this.f33649x) / 2));
        int i22 = this.f33632e + 1;
        while (measuredHeight22 - ((float) (this.f33649x * (this.f33624F ? 1 : 0))) < ((float) getMeasuredHeight())) {
            if (!m23695c(i22) || this.f33622D) {
                m23688a(canvas, this.f33633h.getText(m23697d(i22)), measuredHeight22);
                measuredHeight22 += (float) this.f33649x;
                i22++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0200  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23688a(android.graphics.Canvas r17, java.lang.String r18, float r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            android.graphics.Paint r3 = r0.f33634i
            int r4 = r0.f33650y
            float r4 = (float) r4
            r3.setTextSize(r4)
            android.graphics.Paint r3 = r0.f33634i
            int r4 = r18.length()
            android.graphics.Rect r5 = r0.f33635j
            r6 = 0
            r3.getTextBounds(r2, r6, r4, r5)
            boolean r3 = r0.f33623E
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r3 == 0) goto L_0x004e
        L_0x0020:
            int r3 = r16.getMeasuredWidth()
            android.graphics.Rect r5 = r0.f33635j
            int r5 = r5.width()
            if (r3 >= r5) goto L_0x004e
            android.graphics.Paint r3 = r0.f33634i
            float r3 = r3.getTextSize()
            r5 = 1098907648(0x41800000, float:16.0)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x004e
            android.graphics.Paint r3 = r0.f33634i
            float r5 = r3.getTextSize()
            float r5 = r5 - r4
            r3.setTextSize(r5)
            android.graphics.Paint r3 = r0.f33634i
            int r5 = r18.length()
            android.graphics.Rect r7 = r0.f33635j
            r3.getTextBounds(r2, r6, r5, r7)
            goto L_0x0020
        L_0x004e:
            int r3 = r0.f33649x
            android.graphics.Rect r5 = r0.f33635j
            int r5 = r5.height()
            int r3 = r3 + r5
            float r3 = (float) r3
            float r3 = r3 * r4
            r5 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r5
            float r3 = r19 + r3
            android.graphics.Rect r7 = r0.f33635j
            int r7 = r7.height()
            float r7 = (float) r7
            float r7 = r3 - r7
            boolean r8 = r0.f33624F
            r9 = 0
            if (r8 == 0) goto L_0x00ee
            int r8 = r0.f33631d
            float r8 = (float) r8
            float r8 = r5 / r8
            float r10 = r0.f33626H
            int r11 = r0.f33649x
            int r11 = r11 / 2
            float r11 = (float) r11
            float r11 = r19 + r11
            float r11 = r10 - r11
            float r11 = r11 / r10
            double r10 = (double) r11
            double r10 = java.lang.Math.atan(r10)
            double r12 = (double) r8
            double r10 = r10 * r12
            r12 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r12 = r12 * r10
            r14 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r12 = r12 / r14
            float r8 = (float) r12
            android.graphics.Camera r12 = r0.f33627I
            r12.save()
            android.graphics.Camera r12 = r0.f33627I
            r12.rotateX(r8)
            android.graphics.Camera r8 = r0.f33627I
            float r12 = r0.f33626H
            int r13 = r0.f33631d
            int r13 = r13 + 2
            float r13 = (float) r13
            float r12 = r12 / r13
            double r10 = java.lang.Math.sin(r10)
            float r10 = (float) r10
            float r12 = r12 * r10
            float r10 = java.lang.Math.abs(r12)
            float r10 = -r10
            r8.translate(r9, r9, r10)
            android.graphics.Camera r8 = r0.f33627I
            android.graphics.Matrix r10 = r0.f33628J
            r8.getMatrix(r10)
            android.graphics.Matrix r8 = r0.f33628J
            int r10 = r16.getMeasuredWidth()
            int r10 = -r10
            int r10 = r10 / 2
            float r10 = (float) r10
            int r11 = r16.getMeasuredHeight()
            int r11 = -r11
            int r11 = r11 / 2
            float r11 = (float) r11
            r8.preTranslate(r10, r11)
            android.graphics.Matrix r8 = r0.f33628J
            int r10 = r16.getMeasuredWidth()
            int r10 = r10 / 2
            float r10 = (float) r10
            int r11 = r16.getMeasuredHeight()
            int r11 = r11 / 2
            float r11 = (float) r11
            r8.postTranslate(r10, r11)
            r17.save()
            android.graphics.Matrix r8 = r0.f33628J
            r1.concat(r8)
        L_0x00ee:
            android.text.Layout$Alignment r8 = r0.f33625G
            android.text.Layout$Alignment r10 = android.text.Layout.Alignment.ALIGN_CENTER
            if (r8 != r10) goto L_0x0103
            android.graphics.Paint r8 = r0.f33634i
            android.graphics.Paint$Align r9 = android.graphics.Paint.Align.CENTER
            r8.setTextAlign(r9)
            int r8 = r16.getMeasuredWidth()
            int r8 = r8 / 2
        L_0x0101:
            float r9 = (float) r8
            goto L_0x011c
        L_0x0103:
            android.text.Layout$Alignment r8 = r0.f33625G
            android.text.Layout$Alignment r10 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            if (r8 != r10) goto L_0x0115
            android.graphics.Paint r8 = r0.f33634i
            android.graphics.Paint$Align r9 = android.graphics.Paint.Align.RIGHT
            r8.setTextAlign(r9)
            int r8 = r16.getMeasuredWidth()
            goto L_0x0101
        L_0x0115:
            android.graphics.Paint r8 = r0.f33634i
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.LEFT
            r8.setTextAlign(r10)
        L_0x011c:
            int r8 = r16.getMeasuredHeight()
            int r10 = r0.f33649x
            int r8 = r8 - r10
            float r8 = (float) r8
            float r8 = r8 * r4
            float r8 = r8 / r5
            float r4 = (float) r10
            float r4 = r4 + r8
            int r5 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0147
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0147
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33650y
            float r5 = (float) r5
            r4.setTextSize(r5)
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33619A
            r4.setColor(r5)
            android.graphics.Paint r4 = r0.f33634i
            r1.drawText(r2, r9, r3, r4)
            goto L_0x01fc
        L_0x0147:
            int r5 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x0195
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0195
            r17.save()
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33651z
            float r5 = (float) r5
            r4.setTextSize(r5)
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33620B
            r4.setColor(r5)
            int r4 = (int) r7
            int r5 = r16.getMeasuredWidth()
            int r7 = (int) r8
            r1.clipRect(r6, r4, r5, r7)
            android.graphics.Paint r4 = r0.f33634i
            r1.drawText(r2, r9, r3, r4)
            r17.restore()
            r17.save()
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33650y
            float r5 = (float) r5
            r4.setTextSize(r5)
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33619A
            r4.setColor(r5)
            int r4 = r16.getMeasuredWidth()
            int r5 = (int) r3
            r1.clipRect(r6, r7, r4, r5)
            android.graphics.Paint r4 = r0.f33634i
            r1.drawText(r2, r9, r3, r4)
            r17.restore()
            goto L_0x01fc
        L_0x0195:
            int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x01e8
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 < 0) goto L_0x01e8
            r17.save()
            android.graphics.Paint r5 = r0.f33634i
            int r8 = r0.f33650y
            float r8 = (float) r8
            r5.setTextSize(r8)
            android.graphics.Paint r5 = r0.f33634i
            int r8 = r0.f33619A
            r5.setColor(r8)
            int r5 = (int) r7
            int r7 = r16.getMeasuredWidth()
            int r4 = (int) r4
            r1.clipRect(r6, r5, r7, r4)
            android.graphics.Paint r5 = r0.f33634i
            r1.drawText(r2, r9, r3, r5)
            r17.restore()
            r17.save()
            android.graphics.Paint r5 = r0.f33634i
            int r7 = r0.f33651z
            float r7 = (float) r7
            r5.setTextSize(r7)
            android.graphics.Paint r5 = r0.f33634i
            int r7 = r0.f33620B
            r5.setColor(r7)
            android.graphics.Rect r5 = new android.graphics.Rect
            int r7 = r16.getMeasuredWidth()
            int r8 = (int) r3
            r5.<init>(r6, r4, r7, r8)
            r1.clipRect(r5)
            android.graphics.Paint r4 = r0.f33634i
            r1.drawText(r2, r9, r3, r4)
            r17.restore()
            goto L_0x01fc
        L_0x01e8:
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33651z
            float r5 = (float) r5
            r4.setTextSize(r5)
            android.graphics.Paint r4 = r0.f33634i
            int r5 = r0.f33620B
            r4.setColor(r5)
            android.graphics.Paint r4 = r0.f33634i
            r1.drawText(r2, r9, r3, r4)
        L_0x01fc:
            boolean r2 = r0.f33624F
            if (r2 == 0) goto L_0x0208
            r17.restore()
            android.graphics.Camera r1 = r0.f33627I
            r1.restore()
        L_0x0208:
            android.graphics.Paint r1 = r0.f33634i
            int r2 = r0.f33620B
            r1.setColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.picker.RFPickerView.m23688a(android.graphics.Canvas, java.lang.String, float):void");
    }

    public boolean performClick() {
        return super.performClick();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        if ((r8.f33632e + (r9 / r0)) < 0) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.view.GestureDetector r0 = r8.f33636k
            boolean r0 = r0.onTouchEvent(r9)
            r1 = 1
            if (r0 == 0) goto L_0x000d
            r8.invalidate()
            return r1
        L_0x000d:
            float r0 = r9.getY()
            int r9 = r9.getAction()
            r2 = 0
            if (r9 == 0) goto L_0x00d4
            r3 = 2
            if (r9 == r1) goto L_0x004c
            if (r9 == r3) goto L_0x001f
            goto L_0x00eb
        L_0x001f:
            boolean r9 = r8.f33638m
            if (r9 != 0) goto L_0x0034
            float r9 = r8.f33641p
            float r9 = r0 - r9
            float r9 = java.lang.Math.abs(r9)
            int r3 = r8.f33648w
            float r3 = (float) r3
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x0034
            goto L_0x00eb
        L_0x0034:
            boolean r9 = r8.f33638m
            if (r9 != 0) goto L_0x003e
            r8.f33638m = r1
            r8.f33642q = r0
            goto L_0x00eb
        L_0x003e:
            r8.f33639n = r2
            float r9 = r8.f33642q
            float r9 = r0 - r9
            int r9 = (int) r9
            r8.m23701e((int) r9)
            r8.f33642q = r0
            goto L_0x00eb
        L_0x004c:
            boolean r9 = r8.f33640o
            if (r9 != 0) goto L_0x00c3
            boolean r9 = r8.f33638m
            if (r9 != 0) goto L_0x00c3
            float r9 = r8.f33641p
            float r9 = r0 - r9
            float r9 = java.lang.Math.abs(r9)
            int r4 = r8.f33648w
            float r4 = (float) r4
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x00c3
            r8.performClick()
            int r9 = r8.f33644s
            int r2 = r8.f33649x
            int r4 = r8.f33632e
            int r2 = r2 * r4
            int r9 = r9 - r2
            r8.f33643r = r9
            int r9 = r8.getMeasuredHeight()
            int r2 = r8.f33649x
            int r9 = r9 - r2
            int r9 = r9 / r3
            int r2 = r8.getMeasuredHeight()
            int r4 = r8.f33649x
            int r2 = r2 + r4
            int r2 = r2 / r3
            float r3 = (float) r9
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 < 0) goto L_0x008c
            float r4 = (float) r2
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x008c
            goto L_0x00eb
        L_0x008c:
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x009f
            int r9 = (int) r0
            int r9 = r9 - r2
            int r0 = r8.f33649x
            int r9 = r9 / r0
            int r9 = r9 * r0
            int r2 = r8.f33632e
            int r0 = r9 / r0
            int r2 = r2 + r0
            if (r2 >= 0) goto L_0x00b6
            goto L_0x00eb
        L_0x009f:
            int r0 = (int) r0
            int r0 = r0 - r9
            int r9 = r8.f33649x
            int r0 = r0 / r9
            int r0 = r0 * r9
            int r2 = r8.f33632e
            int r9 = r0 / r9
            int r2 = r2 + r9
            com.didi.rfusion.widget.picker.RFPickerAdapter<? extends com.didi.rfusion.widget.picker.RFPickerItem> r9 = r8.f33633h
            int r9 = r9.getItemCount()
            int r9 = r9 - r1
            if (r2 <= r9) goto L_0x00b5
            goto L_0x00eb
        L_0x00b5:
            r9 = r0
        L_0x00b6:
            android.widget.OverScroller r2 = r8.f33637l
            r3 = 0
            int r4 = r8.f33643r
            r5 = 0
            int r6 = -r9
            r7 = 250(0xfa, float:3.5E-43)
            r2.startScroll(r3, r4, r5, r6, r7)
            goto L_0x00eb
        L_0x00c3:
            r8.f33638m = r2
            r8.f33640o = r2
            float r9 = r8.f33642q
            float r0 = r0 - r9
            int r9 = (int) r0
            r8.m23701e((int) r9)
            r9 = 250(0xfa, float:3.5E-43)
            r8.mo87982a((int) r9)
            goto L_0x00eb
        L_0x00d4:
            r8.f33639n = r2
            r8.f33641p = r0
            r8.f33642q = r0
            r8.f33638m = r2
            android.widget.OverScroller r9 = r8.f33637l
            boolean r9 = r9.isFinished()
            if (r9 != 0) goto L_0x00eb
            android.widget.OverScroller r9 = r8.f33637l
            r9.forceFinished(r1)
            r8.f33640o = r1
        L_0x00eb:
            r8.invalidate()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.picker.RFPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void computeScroll() {
        if (this.f33637l.computeScrollOffset()) {
            int currY = this.f33637l.getCurrY();
            m23701e(currY - this.f33643r);
            this.f33643r = currY;
            invalidate();
        } else if (this.f33639n) {
            mo87982a(250);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo87983b() {
        if (this.f33622D) {
            this.f33645t = Integer.MIN_VALUE;
            this.f33646u = Integer.MAX_VALUE;
        } else {
            this.f33645t = (-(this.f33633h.getItemCount() - 1)) * this.f33649x;
            this.f33646u = 0;
        }
        this.f33647v = this.f33649x * 2;
    }

    /* renamed from: c */
    private boolean m23695c(int i) {
        return i < 0 || i >= this.f33633h.getItemCount();
    }

    /* renamed from: d */
    private int m23697d(int i) {
        if (this.f33633h.getItemCount() == 0) {
            return 0;
        }
        if (this.f33622D) {
            if (i < 0) {
                i %= this.f33633h.getItemCount();
                if (i != 0) {
                    i += this.f33633h.getItemCount();
                }
            } else if (i >= this.f33633h.getItemCount()) {
                i %= this.f33633h.getItemCount();
            }
        }
        if (i < 0) {
            return 0;
        }
        return i >= this.f33633h.getItemCount() ? this.f33633h.getItemCount() - 1 : i;
    }

    /* renamed from: e */
    private float m23699e() {
        return (((float) this.f33632e) + 0.5f) - ((float) (this.f33644s / this.f33649x));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87982a(int i) {
        int i2;
        int i3;
        int i4 = this.f33644s;
        if (i4 != 0) {
            int i5 = -i4;
            int i6 = this.f33632e;
            if (!(i6 == 0 || i6 == this.f33633h.getItemCount() - 1)) {
                int i7 = this.f33644s;
                if (i7 > 0) {
                    int i8 = this.f33649x;
                    if (i7 > i8 / 3) {
                        i5 = i8 - i7;
                    }
                } else {
                    int abs = Math.abs(i7);
                    int i9 = this.f33649x;
                    if (abs > i9 / 3) {
                        i5 = -(i9 + this.f33644s);
                    }
                }
            }
            if (this.f33633h.getItemCount() > 1) {
                if (this.f33632e == 0 && (i3 = this.f33644s) < 0) {
                    int abs2 = Math.abs(i3);
                    int i10 = this.f33649x;
                    if (abs2 > i10 / 3) {
                        i5 = -(i10 + this.f33644s);
                    }
                }
                if (this.f33632e == this.f33633h.getItemCount() - 1 && (i2 = this.f33644s) > 0) {
                    int i11 = this.f33649x;
                    if (i2 > i11 / 3) {
                        i5 = i11 - i2;
                    }
                }
            }
            int i12 = this.f33644s - (this.f33649x * this.f33632e);
            this.f33643r = i12;
            this.f33637l.startScroll(0, i12, 0, i5, i);
            invalidate();
        }
        this.f33639n = false;
    }

    /* renamed from: e */
    private void m23701e(int i) {
        int i2 = this.f33644s + i;
        this.f33644s = i2;
        if (Math.abs(i2) < this.f33649x) {
            return;
        }
        if ((this.f33632e != 0 || i < 0) && (this.f33632e != this.f33633h.getItemCount() - 1 || i > 0)) {
            int i3 = this.f33632e;
            m23692b(i3 - (this.f33644s / this.f33649x));
            this.f33644s -= (i3 - this.f33632e) * this.f33649x;
            return;
        }
        int abs = Math.abs(this.f33644s);
        int i4 = this.f33647v;
        if (abs > i4) {
            if (this.f33644s <= 0) {
                i4 = -i4;
            }
            this.f33644s = i4;
        }
    }
}
