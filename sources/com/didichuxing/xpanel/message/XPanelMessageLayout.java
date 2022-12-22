package com.didichuxing.xpanel.message;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class XPanelMessageLayout extends FrameLayout implements IXPanelMessageContainer {
    public static final String TAG = "XPanelMessageLayout";

    /* renamed from: a */
    static volatile boolean f49549a = false;

    /* renamed from: b */
    private static final int f49550b = 1;

    /* renamed from: c */
    private static final int f49551c = 2;

    /* renamed from: i */
    private static final int f49552i = 300;

    /* renamed from: d */
    private IMessageDataListener f49553d;

    /* renamed from: e */
    private IMessageAnimationListener f49554e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f49555f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f49556g = false;

    /* renamed from: h */
    private boolean f49557h = false;

    /* renamed from: j */
    private final int f49558j = 1000;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f49559k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public XPanelMessageItem f49560l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public XPanelMessageItem f49561m;

    /* renamed from: n */
    private View f49562n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f49563o = new Handler(Looper.getMainLooper());

    /* renamed from: p */
    private AnimatorSet f49564p = new AnimatorSet();

    /* renamed from: q */
    private ValueAnimator f49565q;

    /* renamed from: r */
    private ValueAnimator f49566r;

    /* renamed from: s */
    private ValueAnimator f49567s;

    /* renamed from: t */
    private ValueAnimator f49568t;

    /* renamed from: u */
    private ValueAnimator f49569u;

    /* renamed from: v */
    private LinkedList<XPanelMessageItem> f49570v = new LinkedList<>();

    public interface IMessageAnimationListener {
        void messageAnimating();

        void messageAnimationEnd();
    }

    public View getView() {
        return this;
    }

    public XPanelMessageLayout(Context context) {
        super(context);
        setBackgroundResource(R.drawable.message_bg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addMessageItem(com.didichuxing.xpanel.message.XPanelMessageItem r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0020
            android.view.View r0 = r2.getContentView()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            java.util.LinkedList<com.didichuxing.xpanel.message.XPanelMessageItem> r0 = r1.f49570v     // Catch:{ all -> 0x001d }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            goto L_0x0020
        L_0x0012:
            java.util.LinkedList<com.didichuxing.xpanel.message.XPanelMessageItem> r0 = r1.f49570v     // Catch:{ all -> 0x001d }
            r0.add(r2)     // Catch:{ all -> 0x001d }
            r2 = 1
            r1.m35776a((int) r2)     // Catch:{ all -> 0x001d }
            monitor-exit(r1)
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0020:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.message.XPanelMessageLayout.addMessageItem(com.didichuxing.xpanel.message.XPanelMessageItem):void");
    }

    public void setMessageDataListener(IMessageDataListener iMessageDataListener) {
        this.f49553d = iMessageDataListener;
    }

    public synchronized void removeMessageItem(XPanelMessageItem xPanelMessageItem) {
        m35778a(xPanelMessageItem);
    }

    /* renamed from: a */
    private void m35778a(XPanelMessageItem xPanelMessageItem) {
        m35776a(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35776a(int i) {
        if (this.f49555f || this.f49556g) {
            LogcatUtil.m35796i(TAG, "@doAction, waiting...mWait=" + this.f49555f + ", mIsAnimating=" + this.f49556g);
            return;
        }
        this.f49555f = true;
        if (i == 2) {
            if (this.f49560l != null) {
                XPanelMessageItem xPanelMessageItem = this.f49561m;
                if (xPanelMessageItem != null) {
                    m35786c(xPanelMessageItem);
                }
                m35782b(this.f49560l);
                m35777a(i, this.f49561m, this.f49560l);
            }
        } else if (i == 1) {
            ListIterator listIterator = ((LinkedList) this.f49570v.clone()).listIterator(0);
            if (listIterator.hasNext()) {
                XPanelMessageItem xPanelMessageItem2 = (XPanelMessageItem) listIterator.next();
                this.f49570v.remove(xPanelMessageItem2);
                this.f49561m = this.f49560l;
                this.f49560l = xPanelMessageItem2;
                m35786c(xPanelMessageItem2);
                m35777a(i, this.f49560l, this.f49561m);
                return;
            }
            LogcatUtil.m35795e(TAG, "队列里没有新消息...");
            this.f49555f = false;
        }
    }

    /* renamed from: a */
    private void m35777a(final int i, XPanelMessageItem xPanelMessageItem, XPanelMessageItem xPanelMessageItem2) {
        if (!this.f49557h) {
            m35775a();
        }
        if (xPanelMessageItem == null && xPanelMessageItem2 == null) {
            this.f49556g = false;
            return;
        }
        f49549a = false;
        this.f49556g = true;
        this.f49564p.removeAllListeners();
        this.f49564p.setDuration(300);
        this.f49564p.setInterpolator(new AccelerateInterpolator());
        this.f49564p.addListener(new C16573a() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = XPanelMessageLayout.this.f49556g = false;
                if (i == 2) {
                    XPanelMessageLayout xPanelMessageLayout = XPanelMessageLayout.this;
                    xPanelMessageLayout.removeView(xPanelMessageLayout.f49560l.getContentView());
                    XPanelMessageLayout xPanelMessageLayout2 = XPanelMessageLayout.this;
                    XPanelMessageItem unused2 = xPanelMessageLayout2.f49560l = xPanelMessageLayout2.f49561m;
                } else if (!(XPanelMessageLayout.this.f49561m == null || XPanelMessageLayout.this.f49561m.getContentView() == null)) {
                    XPanelMessageLayout xPanelMessageLayout3 = XPanelMessageLayout.this;
                    xPanelMessageLayout3.removeView(xPanelMessageLayout3.f49561m.getContentView());
                }
                if (XPanelMessageLayout.this.getChildCount() == 0) {
                    int unused3 = XPanelMessageLayout.this.f49559k = 0;
                }
                if (XPanelMessageLayout.this.f49560l != null) {
                    XPanelMessageLayout.this.f49560l.getContentView().setTranslationY(0.0f);
                    if (XPanelMessageLayout.f49549a && XPanelMessageLayout.this.f49560l.getContentView().getBackground() != null) {
                        XPanelMessageLayout.this.f49560l.getContentView().getBackground().setAlpha(255);
                    }
                }
                XPanelMessageLayout.this.f49563o.postDelayed(new Runnable() {
                    public void run() {
                        boolean unused = XPanelMessageLayout.this.f49555f = false;
                        XPanelMessageLayout.this.m35776a(1);
                    }
                }, 1000);
            }
        });
        int i2 = -1;
        int messageType = xPanelMessageItem == null ? -1 : xPanelMessageItem.getMessageType();
        if (xPanelMessageItem2 != null) {
            i2 = xPanelMessageItem2.getMessageType();
        }
        boolean z = xPanelMessageItem2 != null;
        if (i == 2) {
            ArrayList arrayList = new ArrayList();
            if (xPanelMessageItem != null) {
                this.f49566r.addListener(xPanelMessageItem.f49546a);
                this.f49566r.addUpdateListener(xPanelMessageItem.f49546a);
                arrayList.add(this.f49566r);
            }
            if (xPanelMessageItem2 != null) {
                this.f49565q.addListener(xPanelMessageItem2.f49546a);
                this.f49565q.addUpdateListener(xPanelMessageItem2.f49546a);
                arrayList.add(this.f49565q);
            }
            this.f49564p.playTogether(arrayList);
        } else if (i == 1) {
            this.f49566r.addListener(xPanelMessageItem.f49546a);
            this.f49566r.addUpdateListener(xPanelMessageItem.f49546a);
            C16576d dVar = new C16576d(xPanelMessageItem.getContentView());
            this.f49568t.addListener(dVar);
            this.f49568t.addUpdateListener(dVar);
            if (!z) {
                this.f49564p.play(this.f49566r);
            } else if (messageType == i2) {
                f49549a = true;
                if (xPanelMessageItem.getContentView().getBackground() != null) {
                    xPanelMessageItem.getContentView().getBackground().setAlpha(0);
                }
                this.f49567s.addUpdateListener(xPanelMessageItem2.f49546a);
                this.f49567s.addListener(xPanelMessageItem2.f49546a);
                C16576d dVar2 = new C16576d(xPanelMessageItem2.getContentView());
                this.f49569u.addListener(dVar2);
                this.f49569u.addUpdateListener(dVar2);
                this.f49564p.playTogether(new Animator[]{this.f49567s, this.f49566r, this.f49569u, this.f49568t});
            } else {
                this.f49565q.addListener(xPanelMessageItem2.f49546a);
                this.f49565q.addUpdateListener(xPanelMessageItem2.f49546a);
                this.f49564p.playTogether(new Animator[]{this.f49566r, this.f49565q});
            }
        }
        IMessageDataListener iMessageDataListener = this.f49553d;
        if (iMessageDataListener != null) {
            iMessageDataListener.notifyAdd();
        }
        this.f49564p.start();
    }

    /* renamed from: a */
    private void m35775a() {
        this.f49566r = ValueAnimator.ofFloat(new float[]{1.2f, 0.0f});
        this.f49567s = ValueAnimator.ofFloat(new float[]{0.2f, -1.0f});
        this.f49565q = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f49568t = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        this.f49569u = ValueAnimator.ofFloat(new float[]{1.0f, 0.8f});
    }

    /* renamed from: b */
    private synchronized void m35782b(XPanelMessageItem xPanelMessageItem) {
        if (this.f49553d != null) {
            this.f49553d.notifyRemove();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a5, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m35786c(com.didichuxing.xpanel.message.XPanelMessageItem r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "XPanelMessageLayout"
            java.lang.String r1 = "this.setVisibility(View.VISIBLE)...."
            com.didichuxing.xpanel.util.LogcatUtil.m35794d(r0, r1)     // Catch:{ all -> 0x00a6 }
            r0 = 0
            r4.setVisibility(r0)     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = r5.getContentView()     // Catch:{ all -> 0x00a6 }
            r4.f49562n = r1     // Catch:{ all -> 0x00a6 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0022
            java.lang.String r5 = "XPanelMessageLayout"
            java.lang.String r0 = "The specified child already has a parent."
            com.didichuxing.xpanel.util.LogcatUtil.m35795e(r5, r0)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return
        L_0x0022:
            android.view.View r5 = r5.getContentView()     // Catch:{ all -> 0x00a6 }
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch:{ all -> 0x00a6 }
            if (r5 != 0) goto L_0x0034
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00a6 }
            r1 = -1
            r2 = -2
            r5.<init>(r1, r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x003e
        L_0x0034:
            boolean r1 = r5 instanceof android.widget.FrameLayout.LayoutParams     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x003e
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00a6 }
            r1.<init>(r5)     // Catch:{ all -> 0x00a6 }
            r5 = r1
        L_0x003e:
            r1 = r5
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1     // Catch:{ all -> 0x00a6 }
            android.content.Context r2 = r4.getContext()     // Catch:{ all -> 0x00a6 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x00a6 }
            r3 = 2131165184(0x7f070000, float:1.7944578E38)
            int r2 = r2.getDimensionPixelSize(r3)     // Catch:{ all -> 0x00a6 }
            r1.leftMargin = r2     // Catch:{ all -> 0x00a6 }
            r1.rightMargin = r2     // Catch:{ all -> 0x00a6 }
            r1.topMargin = r2     // Catch:{ all -> 0x00a6 }
            r2 = 80
            r1.gravity = r2     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = r4.f49562n     // Catch:{ all -> 0x00a6 }
            r4.addView(r1, r5)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.getMeasuredWidth()     // Catch:{ all -> 0x00a6 }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)     // Catch:{ all -> 0x00a6 }
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)     // Catch:{ all -> 0x00a6 }
            r4.measure(r5, r0)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.getMeasuredHeight()     // Catch:{ all -> 0x00a6 }
            android.view.View r0 = r4.f49562n     // Catch:{ all -> 0x00a6 }
            int r0 = r0.getMeasuredHeight()     // Catch:{ all -> 0x00a6 }
            r4.f49559k = r0     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "XPanelMessageLayout"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "@doAddCurrent, 消息位高度："
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = ", 新增消息位高度："
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.f49559k     // Catch:{ all -> 0x00a6 }
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00a6 }
            com.didichuxing.xpanel.util.LogcatUtil.m35794d(r0, r5)     // Catch:{ all -> 0x00a6 }
            com.didichuxing.xpanel.message.IMessageDataListener r5 = r4.f49553d     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            com.didichuxing.xpanel.message.IMessageDataListener r5 = r4.f49553d     // Catch:{ all -> 0x00a6 }
            r5.notifyAdd()     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r4)
            return
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.message.XPanelMessageLayout.m35786c(com.didichuxing.xpanel.message.XPanelMessageItem):void");
    }

    public int getCurrentHeight() {
        if (getChildCount() == 0) {
            return 0;
        }
        return this.f49562n.getMeasuredHeight();
    }

    /* renamed from: b */
    private void m35781b() {
        IMessageAnimationListener iMessageAnimationListener = this.f49554e;
        if (iMessageAnimationListener != null) {
            iMessageAnimationListener.messageAnimationEnd();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
