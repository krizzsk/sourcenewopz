package com.didi.consume.phone.view.picker;

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

public class WheelView extends ScrollView {
    public static final int OFF_SET_DEFAULT = 1;
    public static final String TAG = WheelView.class.getSimpleName();

    /* renamed from: o */
    private static final int f16343o = 0;

    /* renamed from: p */
    private static final int f16344p = 1;

    /* renamed from: a */
    List<String> f16345a;

    /* renamed from: b */
    int f16346b = 1;

    /* renamed from: c */
    int f16347c;

    /* renamed from: d */
    int f16348d = 1;

    /* renamed from: e */
    int f16349e;

    /* renamed from: f */
    Runnable f16350f;

    /* renamed from: g */
    int f16351g = 50;

    /* renamed from: h */
    int f16352h = 0;

    /* renamed from: i */
    int[] f16353i;

    /* renamed from: j */
    Paint f16354j;

    /* renamed from: k */
    int f16355k;

    /* renamed from: l */
    private Context f16356l;

    /* renamed from: m */
    private LinearLayout f16357m;

    /* renamed from: n */
    private int f16358n = -1;

    /* renamed from: q */
    private OnWheelViewListener f16359q;

    public static class OnWheelViewListener {
        public void onSelected(int i, String str) {
        }
    }

    public WheelView(Context context) {
        super(context);
        m11979a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11979a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11979a(context);
    }

    private List<String> getItems() {
        return this.f16345a;
    }

    public void setItems(List<String> list) {
        if (this.f16345a == null) {
            this.f16345a = new ArrayList();
        }
        this.f16345a.clear();
        this.f16345a.addAll(list);
        for (int i = 0; i < this.f16346b; i++) {
            this.f16345a.add(0, "");
            this.f16345a.add("");
        }
        m11977a();
    }

    public int getOffset() {
        return this.f16346b;
    }

    public void setOffset(int i) {
        this.f16346b = i;
    }

    /* renamed from: a */
    private void m11979a(Context context) {
        this.f16356l = context;
        String str = TAG;
        SystemUtils.log(3, str, "parent: " + getParent(), (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 100);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f16357m = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f16357m);
        this.f16350f = new Runnable() {
            public void run() {
                if (WheelView.this.f16349e - WheelView.this.getScrollY() == 0) {
                    final int i = WheelView.this.f16349e % WheelView.this.f16352h;
                    final int i2 = WheelView.this.f16349e / WheelView.this.f16352h;
                    if (i == 0) {
                        WheelView wheelView = WheelView.this;
                        wheelView.f16348d = i2 + wheelView.f16346b;
                        WheelView.this.m11983c();
                    } else if (i > WheelView.this.f16352h / 2) {
                        WheelView.this.post(new Runnable() {
                            public void run() {
                                WheelView.this.smoothScrollTo(0, (WheelView.this.f16349e - i) + WheelView.this.f16352h);
                                WheelView.this.f16348d = i2 + WheelView.this.f16346b + 1;
                                WheelView.this.m11983c();
                            }
                        });
                    } else {
                        WheelView.this.post(new Runnable() {
                            public void run() {
                                WheelView.this.smoothScrollTo(0, WheelView.this.f16349e - i);
                                WheelView.this.f16348d = i2 + WheelView.this.f16346b;
                                WheelView.this.m11983c();
                            }
                        });
                    }
                } else {
                    WheelView wheelView2 = WheelView.this;
                    wheelView2.f16349e = wheelView2.getScrollY();
                    WheelView wheelView3 = WheelView.this;
                    wheelView3.postDelayed(wheelView3.f16350f, (long) WheelView.this.f16351g);
                }
            }
        };
    }

    public void startScrollerTask() {
        this.f16349e = getScrollY();
        postDelayed(this.f16350f, (long) this.f16351g);
    }

    /* renamed from: a */
    private void m11977a() {
        this.f16347c = (this.f16346b * 2) + 1;
        for (String a : this.f16345a) {
            this.f16357m.addView(m11976a(a));
        }
        m11978a(0);
    }

    /* renamed from: a */
    private TextView m11976a(String str) {
        TextView textView = new TextView(this.f16356l);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 18.0f);
        textView.setText(str);
        textView.setGravity(17);
        int a = m11974a(15.0f);
        textView.setPadding(a, a, a, a);
        if (this.f16352h == 0) {
            this.f16352h = m11975a((View) textView);
            String str2 = TAG;
            SystemUtils.log(3, str2, "itemHeight: " + this.f16352h, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 191);
            this.f16357m.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f16352h * this.f16347c));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.f16352h * this.f16347c));
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m11978a(i2);
        if (i2 > i4) {
            this.f16358n = 1;
        } else {
            this.f16358n = 0;
        }
    }

    /* renamed from: a */
    private void m11978a(int i) {
        int i2 = this.f16352h;
        int i3 = this.f16346b;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f16357m.getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            TextView textView = (TextView) this.f16357m.getChildAt(i7);
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
    public int[] m11981b() {
        if (this.f16353i == null) {
            int[] iArr = new int[2];
            this.f16353i = iArr;
            int i = this.f16352h;
            int i2 = this.f16346b;
            iArr[0] = i * i2;
            iArr[1] = i * (i2 + 1);
        }
        return this.f16353i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f16355k == 0) {
            this.f16355k = ((Activity) this.f16356l).getWindowManager().getDefaultDisplay().getWidth();
            String str = TAG;
            SystemUtils.log(3, str, "viewWidth: " + this.f16355k, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 314);
        }
        if (this.f16354j == null) {
            Paint paint = new Paint();
            this.f16354j = paint;
            paint.setColor(Color.parseColor("#10000000"));
            this.f16354j.setStrokeWidth((float) m11974a(1.0f));
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
                canvas2.drawLine((float) ((WheelView.this.f16355k * 1) / 6), (float) WheelView.this.m11981b()[0], (float) ((WheelView.this.f16355k * 5) / 6), (float) WheelView.this.m11981b()[0], WheelView.this.f16354j);
                canvas2.drawLine((float) ((WheelView.this.f16355k * 1) / 6), (float) WheelView.this.m11981b()[1], (float) ((WheelView.this.f16355k * 5) / 6), (float) WheelView.this.m11981b()[1], WheelView.this.f16354j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        String str = TAG;
        SystemUtils.log(3, str, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 354);
        this.f16355k = i;
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11983c() {
        OnWheelViewListener onWheelViewListener = this.f16359q;
        if (onWheelViewListener != null) {
            int i = this.f16348d;
            onWheelViewListener.onSelected(i, this.f16345a.get(i));
        }
    }

    public void setSeletion(final int i) {
        this.f16348d = this.f16346b + i;
        post(new Runnable() {
            public void run() {
                WheelView wheelView = WheelView.this;
                wheelView.smoothScrollTo(0, i * wheelView.f16352h);
            }
        });
    }

    public String getSeletedItem() {
        return this.f16345a.get(this.f16348d);
    }

    public int getSeletedIndex() {
        return this.f16348d - this.f16346b;
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
        return this.f16359q;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.f16359q = onWheelViewListener;
    }

    /* renamed from: a */
    private int m11974a(float f) {
        return (int) ((f * this.f16356l.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private int m11975a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
