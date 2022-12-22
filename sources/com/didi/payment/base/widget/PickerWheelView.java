package com.didi.payment.base.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class PickerWheelView extends ScrollView {
    public static final int OFF_SET_DEFAULT = 1;
    public static final String TAG = PickerWheelView.class.getSimpleName();

    /* renamed from: o */
    private static final int f30122o = 0;

    /* renamed from: p */
    private static final int f30123p = 1;

    /* renamed from: a */
    List<String> f30124a;

    /* renamed from: b */
    int f30125b = 1;

    /* renamed from: c */
    int f30126c;

    /* renamed from: d */
    int f30127d = 1;

    /* renamed from: e */
    int f30128e;

    /* renamed from: f */
    Runnable f30129f;

    /* renamed from: g */
    int f30130g = 50;

    /* renamed from: h */
    int f30131h = 0;

    /* renamed from: i */
    int[] f30132i;

    /* renamed from: j */
    Paint f30133j;

    /* renamed from: k */
    int f30134k;

    /* renamed from: l */
    private Context f30135l;

    /* renamed from: m */
    private LinearLayout f30136m;

    /* renamed from: n */
    private int f30137n = -1;

    /* renamed from: q */
    private OnWheelViewListener f30138q;

    public static class OnWheelViewListener {
        public void onSelected(int i, String str) {
        }
    }

    public PickerWheelView(Context context) {
        super(context);
        m21105a(context);
    }

    public PickerWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21105a(context);
    }

    public PickerWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21105a(context);
    }

    private List<String> getItems() {
        return this.f30124a;
    }

    public void setItems(List<String> list) {
        if (this.f30124a == null) {
            this.f30124a = new ArrayList();
        }
        this.f30124a.clear();
        this.f30124a.addAll(list);
        for (int i = 0; i < this.f30125b; i++) {
            this.f30124a.add(0, "");
            this.f30124a.add("");
        }
        m21103a();
    }

    public int getOffset() {
        return this.f30125b;
    }

    public void setOffset(int i) {
        this.f30125b = i;
    }

    /* renamed from: a */
    private void m21105a(Context context) {
        this.f30135l = context;
        String str = TAG;
        SystemUtils.log(3, str, "parent: " + getParent(), (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 105);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f30136m = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f30136m);
        this.f30129f = new Runnable() {
            public void run() {
                if (PickerWheelView.this.f30128e - PickerWheelView.this.getScrollY() == 0) {
                    final int i = PickerWheelView.this.f30128e % PickerWheelView.this.f30131h;
                    final int i2 = PickerWheelView.this.f30128e / PickerWheelView.this.f30131h;
                    if (i == 0) {
                        PickerWheelView pickerWheelView = PickerWheelView.this;
                        pickerWheelView.f30127d = i2 + pickerWheelView.f30125b;
                        PickerWheelView.this.m21109c();
                    } else if (i > PickerWheelView.this.f30131h / 2) {
                        PickerWheelView.this.post(new Runnable() {
                            public void run() {
                                PickerWheelView.this.smoothScrollTo(0, (PickerWheelView.this.f30128e - i) + PickerWheelView.this.f30131h);
                                PickerWheelView.this.f30127d = i2 + PickerWheelView.this.f30125b + 1;
                                PickerWheelView.this.m21109c();
                            }
                        });
                    } else {
                        PickerWheelView.this.post(new Runnable() {
                            public void run() {
                                PickerWheelView.this.smoothScrollTo(0, PickerWheelView.this.f30128e - i);
                                PickerWheelView.this.f30127d = i2 + PickerWheelView.this.f30125b;
                                PickerWheelView.this.m21109c();
                            }
                        });
                    }
                } else {
                    PickerWheelView pickerWheelView2 = PickerWheelView.this;
                    pickerWheelView2.f30128e = pickerWheelView2.getScrollY();
                    PickerWheelView pickerWheelView3 = PickerWheelView.this;
                    pickerWheelView3.postDelayed(pickerWheelView3.f30129f, (long) PickerWheelView.this.f30130g);
                }
            }
        };
    }

    public void startScrollerTask() {
        this.f30128e = getScrollY();
        postDelayed(this.f30129f, (long) this.f30130g);
    }

    /* renamed from: a */
    private void m21103a() {
        this.f30126c = (this.f30125b * 2) + 1;
        for (String a : this.f30124a) {
            this.f30136m.addView(m21102a(a));
        }
        m21104a(0);
    }

    /* renamed from: a */
    private TextView m21102a(String str) {
        TextView textView = new TextView(this.f30135l);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 18.0f);
        textView.setText(str);
        textView.setGravity(17);
        int a = m21100a(15.0f);
        textView.setPadding(a, a, a, a);
        if (this.f30131h == 0) {
            this.f30131h = m21101a((View) textView);
            String str2 = TAG;
            SystemUtils.log(3, str2, "itemHeight: " + this.f30131h, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 196);
            this.f30136m.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f30131h * this.f30126c));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.f30131h * this.f30126c));
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m21104a(i2);
        if (i2 > i4) {
            this.f30137n = 1;
        } else {
            this.f30137n = 0;
        }
    }

    /* renamed from: a */
    private void m21104a(int i) {
        int i2 = this.f30131h;
        int i3 = this.f30125b;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f30136m.getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            TextView textView = (TextView) this.f30136m.getChildAt(i7);
            if (textView != null) {
                if (i4 == i7) {
                    textView.setTextColor(Color.parseColor("#000000"));
                } else {
                    textView.setTextColor(Color.parseColor("#999999"));
                }
                i7++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int[] m21107b() {
        if (this.f30132i == null) {
            int[] iArr = new int[2];
            this.f30132i = iArr;
            int i = this.f30131h;
            int i2 = this.f30125b;
            iArr[0] = i * i2;
            iArr[1] = i * (i2 + 1);
        }
        return this.f30132i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f30134k == 0) {
            this.f30134k = ((Activity) this.f30135l).getWindowManager().getDefaultDisplay().getWidth();
            String str = TAG;
            SystemUtils.log(3, str, "viewWidth: " + this.f30134k, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 319);
        }
        if (this.f30133j == null) {
            Paint paint = new Paint();
            this.f30133j = paint;
            paint.setColor(Color.parseColor("#10000000"));
            this.f30133j.setStrokeWidth((float) m21100a(1.0f));
        }
        super.setBackgroundDrawable(new Drawable() {
            public int getOpacity() {
                return 0;
            }

            public void setAlpha(int i) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }

            public void draw(Canvas canvas) {
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) ((PickerWheelView.this.f30134k * 1) / 6), (float) PickerWheelView.this.m21107b()[0], (float) ((PickerWheelView.this.f30134k * 5) / 6), (float) PickerWheelView.this.m21107b()[0], PickerWheelView.this.f30133j);
                canvas2.drawLine((float) ((PickerWheelView.this.f30134k * 1) / 6), (float) PickerWheelView.this.m21107b()[1], (float) ((PickerWheelView.this.f30134k * 5) / 6), (float) PickerWheelView.this.m21107b()[1], PickerWheelView.this.f30133j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        String str = TAG;
        SystemUtils.log(3, str, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 359);
        this.f30134k = i;
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21109c() {
        OnWheelViewListener onWheelViewListener = this.f30138q;
        if (onWheelViewListener != null) {
            int i = this.f30127d;
            onWheelViewListener.onSelected(i, this.f30124a.get(i));
        }
    }

    public void setSeletion(final int i) {
        this.f30127d = this.f30125b + i;
        post(new Runnable() {
            public void run() {
                PickerWheelView pickerWheelView = PickerWheelView.this;
                pickerWheelView.smoothScrollTo(0, i * pickerWheelView.f30131h);
            }
        });
    }

    public String getSeletedItem() {
        return this.f30124a.get(this.f30127d);
    }

    public int getSeletedIndex() {
        return this.f30127d - this.f30125b;
    }

    public void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    public OnWheelViewListener getOnWheelViewListener() {
        return this.f30138q;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.f30138q = onWheelViewListener;
    }

    /* renamed from: a */
    private int m21100a(float f) {
        return (int) ((f * this.f30135l.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private int m21101a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
