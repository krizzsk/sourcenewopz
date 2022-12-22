package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p118ar.core.BaseDelegate;
import com.didi.hawaii.p118ar.core.DiAREngine;
import com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout;
import com.didi.hawaii.p118ar.jni.DARCPointF;
import com.didi.hawaii.p118ar.jni.DARCRectF;
import com.didi.hawaii.p118ar.jni.DARCSizeF;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager */
public class ZGUIManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int GPSWEAKMSG = 1017;
    public static final int HELPMSG = 10002;
    public static final int REACHENDMSG = 1018;
    public static final int SAFETIPS = 1015;

    /* renamed from: a */
    private static final int f23190a = 40;

    /* renamed from: b */
    private static final int f23191b = 100;

    /* renamed from: c */
    private static final int f23192c = 130;

    /* renamed from: d */
    private static final int f23193d = 20;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f23194e;

    /* renamed from: f */
    private int f23195f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f23196g;

    /* renamed from: h */
    private float f23197h;

    /* renamed from: i */
    private SlidingUpPanelLayout f23198i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ZGUIListener f23199j;

    /* renamed from: k */
    private Context f23200k = null;

    /* renamed from: l */
    private View f23201l = null;

    /* renamed from: m */
    private ViewGroup f23202m = null;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public RelativeLayout f23203n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f23204o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RelativeLayout f23205p;

    /* renamed from: q */
    private Button f23206q;

    /* renamed from: r */
    private Button f23207r;

    /* renamed from: s */
    private FrameLayout f23208s;

    /* renamed from: t */
    private int f23209t;

    /* renamed from: u */
    private ArcLayout f23210u;

    /* renamed from: v */
    private boolean f23211v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Handler f23212w = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i == 1015) {
                    ZGUIManager.this.f23203n.setVisibility(8);
                } else if (i == 1017) {
                    ZGUIManager.this.m16646a(((Boolean) message.obj).booleanValue());
                } else if (i != 1018) {
                    if (i != 10001) {
                        if (i == 10002 && ZGUIManager.this.f23199j != null) {
                            ZGUIManager.this.f23199j.onHelpBtnClick();
                        }
                    } else if (ZGUIManager.this.f23199j != null) {
                        ZGUIManager.this.f23199j.onFinishBtnClick();
                    }
                } else if (ZGUIManager.this.f23199j != null) {
                    ZGUIManager.this.f23199j.onReachDestination();
                }
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager$MsgType */
    public @interface MsgType {
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager$ZGUIListener */
    public interface ZGUIListener {
        void onFinishBtnClick();

        void onHelpBtnClick();

        void onReachDestination();
    }

    public void onDriverArrived(String str) {
    }

    public float getWindowWidthDP() {
        return ((float) this.f23195f) / this.f23197h;
    }

    public float getWindowHeightDP() {
        return ((float) this.f23196g) / this.f23197h;
    }

    public ArcLayout getArcLayout() {
        return this.f23210u;
    }

    public ZGUIManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f23200k = context;
        this.f23202m = viewGroup;
        m16644a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar_zg, (ViewGroup) null);
        this.f23201l = inflate;
        this.f23203n = (RelativeLayout) inflate.findViewById(R.id.safe_alert);
        TextView textView = (TextView) this.f23201l.findViewById(R.id.gps_weak);
        this.f23204o = textView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        f23194e = layoutParams.bottomMargin;
        layoutParams.bottomMargin = (int) (((float) this.f23196g) / 2.3f);
        this.f23204o.setLayoutParams(layoutParams);
        this.f23206q = (Button) this.f23201l.findViewById(R.id.back_btn);
        this.f23207r = (Button) this.f23201l.findViewById(R.id.question_btn);
        this.f23206q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGUIManager.this.f23212w.obtainMessage();
                obtainMessage.what = 10001;
                ZGUIManager.this.f23212w.sendMessage(obtainMessage);
            }
        });
        this.f23207r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGUIManager.this.f23212w.obtainMessage();
                obtainMessage.what = 10002;
                ZGUIManager.this.f23212w.sendMessage(obtainMessage);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) this.f23201l.findViewById(R.id.expand_map);
        this.f23205p = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ZGUIManager.this.expandMapView();
            }
        });
        this.f23205p.setOnTouchListener(new View.OnTouchListener() {
            private int preX;
            private int preY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.preX = (int) motionEvent.getRawX();
                    this.preY = (int) motionEvent.getRawY();
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    int rawX = ((int) motionEvent.getRawX()) - this.preX;
                    int rawY = ((int) motionEvent.getRawY()) - this.preY;
                    if (Math.abs(rawX) >= Math.abs(rawY) || rawY >= 0) {
                        return false;
                    }
                    ZGUIManager.this.expandMapView();
                    return false;
                }
            }
        });
        m16648b();
        m16650c();
        updateZGEffectiveRect();
    }

    /* renamed from: a */
    private void m16644a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.f23195f = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f23196g = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f23197h = displayMetrics.density;
    }

    /* renamed from: b */
    private void m16648b() {
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) this.f23201l.findViewById(R.id.sliding_layout);
        this.f23198i = slidingUpPanelLayout;
        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        this.f23198i.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            SlidingUpPanelLayout.PanelState prevStateWhenChanged;

            public void onPanelSlide(View view, float f) {
            }

            public void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                if (!(panelState == SlidingUpPanelLayout.PanelState.DRAGGING || panelState == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                    this.prevStateWhenChanged = panelState;
                }
                if (SlidingUpPanelLayout.PanelState.DRAGGING == panelState2) {
                    ZGUIManager.this.f23205p.setVisibility(8);
                } else if (SlidingUpPanelLayout.PanelState.ANCHORED == panelState2) {
                    if (this.prevStateWhenChanged == SlidingUpPanelLayout.PanelState.EXPANDED) {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                    } else {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                } else if (SlidingUpPanelLayout.PanelState.EXPANDED == panelState2) {
                    ZGUIManager.this.f23205p.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ZGUIManager.this.f23204o.getLayoutParams();
                    layoutParams.bottomMargin = (int) (((float) ZGUIManager.this.f23196g) / 2.3f);
                    ZGUIManager.this.f23204o.setLayoutParams(layoutParams);
                    AROmega.zgMapARNavDirectMapShow();
                } else if (SlidingUpPanelLayout.PanelState.COLLAPSED == panelState2) {
                    ZGUIManager.this.f23205p.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ZGUIManager.this.f23204o.getLayoutParams();
                    layoutParams2.bottomMargin = ZGUIManager.f23194e;
                    ZGUIManager.this.f23204o.setLayoutParams(layoutParams2);
                    AROmega.zgMapARNavDirectMapHide();
                }
                ZGUIManager.this.updateZGEffectiveRect();
            }
        });
        this.f23209t = ((int) (((float) this.f23196g) / 3.0f)) + DisplayUtils.dip2px(this.f23200k, 40.0f);
        this.f23208s = (FrameLayout) this.f23201l.findViewById(R.id.drag_view);
        this.f23208s.setLayoutParams(new SlidingUpPanelLayout.LayoutParams(-1, this.f23209t));
        LinearLayout linearLayout = (LinearLayout) this.f23201l.findViewById(R.id.map_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = (int) (((float) this.f23196g) / 3.0f);
        linearLayout.setLayoutParams(layoutParams);
        this.f23210u = new ArcLayout(this.f23200k);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f23210u.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f23210u);
        LinearLayout linearLayout2 = (LinearLayout) this.f23201l.findViewById(R.id.map_back_container);
        linearLayout2.setLayoutParams(layoutParams);
        ArcLayout arcLayout = new ArcLayout(this.f23200k);
        arcLayout.setLayoutParams(layoutParams2);
        arcLayout.setClipAreaColor(-1);
        linearLayout2.addView(arcLayout);
    }

    public void updateZGEffectiveRect() {
        DARCPointF dARCPointF = new DARCPointF();
        dARCPointF.setX(20.0f);
        dARCPointF.setY(100.0f);
        DARCSizeF dARCSizeF = new DARCSizeF();
        int i = (int) ((((float) this.f23195f) / this.f23197h) - 40.0f);
        float f = 0.0f;
        dARCSizeF.setW(i > 0 ? (float) i : 0.0f);
        int i2 = (((int) (((float) this.f23196g) / this.f23197h)) - 100) - 130;
        if (SlidingUpPanelLayout.PanelState.EXPANDED == this.f23198i.getPanelState()) {
            i2 = ((int) (((float) (this.f23196g - this.f23209t)) / this.f23197h)) - 100;
        }
        if (i2 > 0) {
            f = (float) i2;
        }
        dARCSizeF.setH(f);
        DARCRectF dARCRectF = new DARCRectF();
        dARCRectF.setOrigin(dARCPointF);
        dARCRectF.setSize(dARCSizeF);
        if (this.mAREngine != null) {
            this.mAREngine.setZGEffectiveRect(dARCRectF);
        }
    }

    /* renamed from: c */
    private void m16650c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f23202m.indexOfChild(this.f23201l) < 0) {
            this.f23202m.addView(this.f23201l, layoutParams);
        } else {
            this.f23202m.updateViewLayout(this.f23201l, layoutParams);
        }
    }

    public void setListener(ZGUIListener zGUIListener) {
        this.f23199j = zGUIListener;
    }

    public void showSafeTips(int i) {
        if (!this.f23211v) {
            this.f23203n.setVisibility(0);
            Message obtainMessage = this.f23212w.obtainMessage();
            obtainMessage.what = 1015;
            this.f23212w.sendMessageDelayed(obtainMessage, (long) i);
            this.f23211v = true;
        }
    }

    public void onGpsWeak(boolean z) {
        Message obtainMessage = this.f23212w.obtainMessage();
        obtainMessage.what = 1017;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f23212w.sendMessage(obtainMessage);
    }

    public void onReachEnd(int i) {
        Message obtainMessage = this.f23212w.obtainMessage();
        obtainMessage.what = 1018;
        this.f23212w.sendMessageDelayed(obtainMessage, (long) i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16646a(boolean z) {
        if (z) {
            this.f23204o.setVisibility(0);
        } else {
            this.f23204o.setVisibility(8);
        }
    }

    public void expandMapView() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f23198i;
        if (slidingUpPanelLayout != null && slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.EXPANDED) {
            this.f23198i.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    public void release() {
        this.f23210u.removeAllViews();
        this.f23212w.removeCallbacksAndMessages((Object) null);
        this.f23199j = null;
    }
}
