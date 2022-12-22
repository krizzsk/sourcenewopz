package com.didi.beatles.p099im.views.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.beatles.p099im.views.widget.TriangleView;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView */
public class IMSimpleGuideView {
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_CENTER = 2;
    public static final int GRAVITY_END = 3;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 3;
    public static final int GRAVITY_START = 1;
    public static final int GRAVITY_TOP = 0;

    /* renamed from: a */
    private static final String f10488a = "IMSimpleGuideView";

    /* renamed from: j */
    private static final int f10489j = 22;

    /* renamed from: k */
    private static final int f10490k = 18;

    /* renamed from: l */
    private static final int f10491l = 6;

    /* renamed from: b */
    private Context f10492b;

    /* renamed from: c */
    private PopupWindow f10493c;

    /* renamed from: d */
    private RelativeLayout f10494d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Builder f10495e;

    /* renamed from: f */
    private IMForkView f10496f;

    /* renamed from: g */
    private TextView f10497g;

    /* renamed from: h */
    private TriangleView f10498h;

    /* renamed from: i */
    private LinearLayout f10499i;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f10500m;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$Gravity */
    public @interface Gravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$LayoutGravity */
    public @interface LayoutGravity {
    }

    private IMSimpleGuideView(Builder builder) {
        this.f10500m = -1;
        this.f10492b = builder.context;
        this.f10495e = builder;
        m7121a();
        m7126c();
    }

    /* renamed from: a */
    private void m7121a() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f10492b).inflate(R.layout.im_simple_guide_view, (ViewGroup) null);
        this.f10494d = relativeLayout;
        this.f10496f = (IMForkView) relativeLayout.findViewById(R.id.im_simple_guide_forkview);
        TextView textView = (TextView) this.f10494d.findViewById(R.id.im_simple_guide_tv);
        this.f10497g = textView;
        textView.setFitsSystemWindows(false);
        this.f10496f.setFitsSystemWindows(false);
        this.f10499i = (LinearLayout) this.f10494d.findViewById(R.id.im_simple_guide_ll);
        if (this.f10495e.showForkView) {
            m7122a((View) this.f10496f);
        } else {
            m7122a((View) this.f10494d);
        }
        PopupWindow popupWindow = new PopupWindow(this.f10494d, m7128e(), m7130g());
        this.f10493c = popupWindow;
        popupWindow.setOutsideTouchable(this.f10495e.dismissTouchOutside);
        this.f10493c.setFocusable(true);
        if (Build.VERSION.SDK_INT < 21) {
            this.f10493c.setBackgroundDrawable(new BitmapDrawable());
        }
        if (this.f10495e.dismissListener != null) {
            this.f10493c.setOnDismissListener(this.f10495e.dismissListener);
        }
    }

    /* renamed from: a */
    private void m7122a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMSimpleGuideView.this.dismiss();
                    if (IMSimpleGuideView.this.f10495e.listener != null) {
                        IMSimpleGuideView.this.f10495e.listener.onClick(view);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m7123b() {
        this.f10497g.setText(m7120a(this.f10495e.guideText));
    }

    /* renamed from: c */
    private void m7126c() {
        m7123b();
        if (this.f10495e.showForkView) {
            this.f10496f.setVisibility(0);
            if (this.f10495e.forkViewColor != 0) {
                this.f10496f.setViewColor(this.f10495e.forkViewColor);
            }
            this.f10496f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMSimpleGuideView.this.dismiss();
                    if (IMSimpleGuideView.this.f10495e.listener != null) {
                        IMSimpleGuideView.this.f10495e.listener.onClick(view);
                    }
                }
            });
        } else {
            this.f10496f.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10499i.getLayoutParams();
        layoutParams.height = m7117a((m7133j() * 18) + 22);
        this.f10499i.setLayoutParams(layoutParams);
        m7127d();
    }

    /* renamed from: a */
    private String m7120a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f10495e.notAutoBreakLine) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int i = 1;
        while (true) {
            int i2 = i - 1;
            if ((this.f10495e.maxNumSingleLine * i) + i2 >= sb.length()) {
                return sb.toString();
            }
            sb.insert((this.f10495e.maxNumSingleLine * i) + i2, 10);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7127d() {
        int i;
        int i2;
        if (this.f10495e.targetView.getMeasuredWidth() == 0) {
            this.f10495e.targetView.post(new Runnable() {
                public void run() {
                    IMSimpleGuideView.this.m7127d();
                }
            });
            return;
        }
        TriangleView triangleView = new TriangleView(this.f10494d.getContext());
        this.f10498h = triangleView;
        triangleView.setId(R.id.guideview_triangle_id);
        if (this.f10495e.layoutGravity == 0 || this.f10495e.layoutGravity == 2) {
            i2 = m7117a(this.f10495e.triangleSize * 2);
            i = m7117a(this.f10495e.triangleSize);
        } else {
            i2 = m7117a(this.f10495e.triangleSize);
            i = m7117a(this.f10495e.triangleSize * 2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f10499i.getLayoutParams();
        int access$1200 = this.f10495e.layoutGravity;
        if (access$1200 == 0) {
            if (this.f10495e.gravity == 1) {
                layoutParams.setMargins(((this.f10495e.targetView.getMeasuredWidth() - i2) / 2) - m7131h(), 0, 0, 0);
            } else if (this.f10495e.gravity == 3) {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, 0, ((this.f10495e.targetView.getMeasuredWidth() - i2) / 2) + m7131h(), 0);
                layoutParams2.addRule(11);
            } else {
                layoutParams.setMargins(-m7131h(), 0, 0, 0);
                layoutParams.addRule(14);
            }
            this.f10498h.setDirection(TriangleView.Direction.DOWN);
            layoutParams.addRule(3, this.f10499i.getId());
            this.f10494d.addView(this.f10498h, 1, layoutParams);
        } else if (access$1200 == 1) {
            if (this.f10495e.gravity == 1) {
                layoutParams.setMargins(0, ((this.f10495e.targetView.getMeasuredHeight() - i) / 2) - m7131h(), 0, 0);
            } else if (this.f10495e.gravity == 3) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, ((this.f10495e.targetView.getMeasuredHeight() - i) / 2) + m7131h());
                layoutParams2.addRule(12);
            } else {
                layoutParams.setMargins(0, -m7131h(), 0, 0);
                layoutParams.addRule(15);
            }
            this.f10498h.setDirection(TriangleView.Direction.RIGHT);
            layoutParams.addRule(1, this.f10499i.getId());
            this.f10494d.addView(this.f10498h, 1, layoutParams);
        } else if (access$1200 == 2) {
            this.f10498h.setDirection(TriangleView.Direction.UP);
            if (this.f10495e.gravity == 1) {
                layoutParams.setMargins(((this.f10495e.targetView.getMeasuredWidth() - i2) / 2) - m7131h(), 0, 0, 0);
            } else if (this.f10495e.gravity == 3) {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, 0, ((this.f10495e.targetView.getMeasuredWidth() - i2) / 2) + m7131h(), 0);
                layoutParams2.addRule(11);
            } else {
                layoutParams.setMargins(-m7131h(), 0, 0, 0);
                layoutParams.addRule(14);
            }
            this.f10494d.addView(this.f10498h, 0, layoutParams);
            layoutParams2.addRule(3, this.f10498h.getId());
            this.f10499i.setLayoutParams(layoutParams2);
        } else if (access$1200 == 3) {
            if (this.f10495e.gravity == 1) {
                layoutParams.setMargins(0, ((this.f10495e.targetView.getMeasuredHeight() - i) / 2) - m7131h(), 0, 0);
            } else if (this.f10495e.gravity == 3) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, ((this.f10495e.targetView.getMeasuredHeight() - i) / 2) + m7131h());
                layoutParams2.addRule(12);
            } else {
                layoutParams.setMargins(0, -m7131h(), 0, 0);
                layoutParams.addRule(15);
            }
            this.f10498h.setDirection(TriangleView.Direction.LEFT);
            this.f10494d.addView(this.f10498h, 0, layoutParams);
            layoutParams2.addRule(1, this.f10498h.getId());
            this.f10499i.setLayoutParams(layoutParams2);
        }
    }

    public void setGuideText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10497g.setText(str);
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f10493c;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public boolean isShow() {
        PopupWindow popupWindow = this.f10493c;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    /* renamed from: a */
    private int m7117a(int i) {
        return IMViewUtil.dp2px(this.f10494d.getContext(), (float) i);
    }

    public void show() {
        show(0, 0);
    }

    public void show(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        final int i11 = i;
        final int i12 = i2;
        Context context = this.f10492b;
        if (!(context instanceof Activity)) {
            IMLog.m6632e(f10488a, "[show] with invalid context=" + this.f10492b);
        } else if (((Activity) context).isFinishing()) {
            IMLog.m6632e(f10488a, "[show] with activity finished");
        } else {
            View access$1000 = this.f10495e.targetView;
            if (access$1000 != null) {
                if (access$1000.getWindowToken() == null || access$1000.getMeasuredWidth() == 0) {
                    if (this.f10500m < 0) {
                        this.f10500m = System.currentTimeMillis();
                    }
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (System.currentTimeMillis() - IMSimpleGuideView.this.f10500m > 3000) {
                                IMLog.m6637w("show simple guide run out of time", new Object[0]);
                            } else {
                                IMSimpleGuideView.this.show(i11, i12);
                            }
                        }
                    }, 100);
                    return;
                }
                int[] iArr = new int[2];
                access$1000.getLocationOnScreen(iArr);
                int i13 = iArr[0];
                int i14 = iArr[1];
                int access$1200 = this.f10495e.layoutGravity;
                if (access$1200 != 0) {
                    if (access$1200 == 1) {
                        i13 = (int) (((double) iArr[0]) - (((double) (m7134k() + m7128e())) * 0.5d));
                        i11 -= m7117a(6);
                        if (this.f10495e.gravity == 2) {
                            i8 = (int) (((double) i14) + (((double) (access$1000.getMeasuredHeight() - m7130g())) * 0.5d));
                            i7 = m7131h();
                        } else if (this.f10495e.gravity == 3) {
                            i5 = (i14 + access$1000.getMeasuredHeight()) - m7130g();
                            i6 = m7131h();
                            i14 = i5 + i6;
                        }
                    } else if (access$1200 == 2) {
                        i14 += access$1000.getMeasuredHeight();
                        int access$1400 = this.f10495e.gravity;
                        if (access$1400 != 1) {
                            if (access$1400 == 2) {
                                i10 = (int) (((double) iArr[0]) + (((double) (access$1000.getMeasuredWidth() - m7134k())) * 0.5d));
                                i9 = m7131h();
                            } else if (access$1400 == 3) {
                                i10 = (int) ((((double) (access$1000.getMeasuredWidth() + iArr[0])) - (((double) m7134k()) * 0.5d)) - (((double) m7128e()) * 0.5d));
                                i9 = m7131h();
                            }
                            i13 = i10 + i9;
                        } else {
                            i10 = (int) (-(((((double) m7134k()) * 0.5d) - ((double) iArr[0])) - (((double) m7128e()) * 0.5d)));
                            i9 = m7131h();
                            i13 = i10 + i9;
                        }
                        i12 += m7117a(6);
                    } else if (access$1200 == 3) {
                        i13 = (int) (-((((((double) m7134k()) * 0.5d) - ((double) iArr[0])) - ((double) access$1000.getMeasuredWidth())) - (((double) m7128e()) * 0.5d)));
                        i11 += m7117a(6);
                        if (this.f10495e.gravity == 2) {
                            i8 = (int) (((double) i14) + (((double) (access$1000.getMeasuredHeight() - m7130g())) * 0.5d));
                            i7 = m7131h();
                        } else if (this.f10495e.gravity == 3) {
                            i5 = (i14 + access$1000.getMeasuredHeight()) - m7130g();
                            i6 = m7131h();
                            i14 = i5 + i6;
                        }
                    }
                    i14 = i8 + i7;
                } else {
                    i14 -= m7130g();
                    int access$14002 = this.f10495e.gravity;
                    if (access$14002 == 1) {
                        i4 = (int) (-(((((double) m7134k()) * 0.5d) - ((double) iArr[0])) - (((double) m7128e()) * 0.5d)));
                        i3 = m7131h();
                        i13 = i4 + i3;
                    } else if (access$14002 == 2) {
                        i13 = (int) (((double) iArr[0]) + (((double) (access$1000.getMeasuredWidth() - m7134k())) * 0.5d) + ((double) m7131h()));
                    } else if (access$14002 == 3) {
                        i4 = (int) ((((double) (access$1000.getMeasuredWidth() + iArr[0])) - (((double) m7134k()) * 0.5d)) - (((double) m7128e()) * 0.5d));
                        i3 = m7131h();
                        i13 = i4 + i3;
                    }
                    i12 -= m7117a(6);
                }
                try {
                    this.f10493c.showAtLocation(access$1000, 48, i13 + i11, i14 + i12);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: e */
    private int m7128e() {
        int i = 0;
        if (this.f10495e.layoutGravity == 1 || this.f10495e.layoutGravity == 3) {
            i = 0 + m7117a(this.f10495e.triangleSize);
        }
        if (this.f10495e.showForkView) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10496f.getLayoutParams();
            i = i + layoutParams.width + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10497g.getLayoutParams();
        return m7118a(this.f10497g, m7129f()) + i + layoutParams2.leftMargin + layoutParams2.rightMargin;
    }

    /* renamed from: f */
    private String m7129f() {
        return this.f10495e.guideText;
    }

    /* renamed from: g */
    private int m7130g() {
        if (this.f10495e.layoutGravity == 1 || this.f10495e.layoutGravity == 3) {
            return m7117a(m7132i());
        }
        return m7117a(m7132i() + this.f10495e.triangleSize);
    }

    /* renamed from: h */
    private int m7131h() {
        return m7117a(this.f10495e.offset);
    }

    /* renamed from: i */
    private int m7132i() {
        return (m7133j() * 18) + 22;
    }

    /* renamed from: a */
    private int m7118a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f10495e.notAutoBreakLine) {
            TextPaint paint = textView.getPaint();
            int indexOf = str.indexOf(10);
            float f = 0.0f;
            while (indexOf > -1) {
                float measureText = paint.measureText(str.substring(0, indexOf));
                if (measureText > f) {
                    f = measureText;
                }
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(10);
            }
            float measureText2 = paint.measureText(str);
            if (measureText2 > f) {
                f = measureText2;
            }
            return (int) f;
        }
        if (str.length() > this.f10495e.maxNumSingleLine) {
            str = str.substring(0, this.f10495e.maxNumSingleLine);
        }
        return (int) textView.getPaint().measureText(str);
    }

    /* renamed from: j */
    private int m7133j() {
        String f = m7129f();
        int i = 0;
        if (TextUtils.isEmpty(f)) {
            return 0;
        }
        if (this.f10495e.notAutoBreakLine) {
            int indexOf = f.indexOf(10);
            while (indexOf > -1) {
                i++;
                f = f.substring(indexOf + 1);
                indexOf = f.indexOf(10);
            }
            return i + 1;
        }
        if (f.length() % this.f10495e.maxNumSingleLine != 0) {
            i = 1;
        }
        return (f.length() / this.f10495e.maxNumSingleLine) + i;
    }

    /* renamed from: k */
    private int m7134k() {
        return ((WindowManager) this.f10494d.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public View getContentView() {
        return this.f10494d;
    }

    /* renamed from: com.didi.beatles.im.views.widget.IMSimpleGuideView$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public PopupWindow.OnDismissListener dismissListener;
        /* access modifiers changed from: private */
        public boolean dismissTouchOutside = false;
        /* access modifiers changed from: private */
        public int forkViewColor = -1;
        /* access modifiers changed from: private */
        public int gravity = 2;
        /* access modifiers changed from: private */
        public String guideText;
        /* access modifiers changed from: private */
        public int layoutGravity = 2;
        /* access modifiers changed from: private */
        public View.OnClickListener listener;
        /* access modifiers changed from: private */
        public int maxNumSingleLine = 14;
        /* access modifiers changed from: private */
        public boolean notAutoBreakLine = false;
        /* access modifiers changed from: private */
        public int offset;
        /* access modifiers changed from: private */
        public boolean showForkView = true;
        /* access modifiers changed from: private */
        public View targetView;
        /* access modifiers changed from: private */
        public int triangleSize = 6;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder isShowForkView(boolean z) {
            this.showForkView = z;
            return this;
        }

        public Builder setForkViewColor(int i) {
            this.forkViewColor = i;
            return this;
        }

        public Builder setGuideText(String str) {
            this.guideText = str;
            return this;
        }

        public Builder setPopClickListener(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public Builder setDismissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public Builder setOffset(int i) {
            this.offset = i;
            return this;
        }

        public Builder setLayoutGravity(int i) {
            this.layoutGravity = i;
            return this;
        }

        public Builder setTriangleSize(int i) {
            this.triangleSize = i;
            return this;
        }

        public Builder setMaxWordNumSingleLine(int i) {
            this.maxNumSingleLine = i;
            return this;
        }

        public Builder setGrivaty(int i) {
            this.gravity = i;
            return this;
        }

        public Builder setOutsideTouchable(boolean z) {
            this.dismissTouchOutside = z;
            return this;
        }

        public Builder setNotAutoBreakLine(boolean z) {
            this.notAutoBreakLine = z;
            return this;
        }

        public Builder setTargetView(View view) {
            if (view != null) {
                this.targetView = view;
                return this;
            }
            throw new RuntimeException("targetView can't be null !");
        }

        public IMSimpleGuideView create() {
            if (this.targetView != null) {
                return new IMSimpleGuideView(this);
            }
            throw new RuntimeException("did you forget setTargetView ?");
        }
    }
}
