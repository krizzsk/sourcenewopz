package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.didi.common.map.MapVendor;
import com.didi.hawaii.p118ar.core.BaseDelegate;
import com.didi.hawaii.p118ar.core.DiAREngine;
import com.didi.hawaii.p118ar.core.p119zg.slidingup.SlidingUpPanelLayout;
import com.didi.hawaii.p118ar.jni.DARCPointF;
import com.didi.hawaii.p118ar.jni.DARCRectF;
import com.didi.hawaii.p118ar.jni.DARCSizeF;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.ARSharePref;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.didi.hawaii.p118ar.utils.MapVenderUtil;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalUIManager */
public class ZGGlobalUIManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int BEHINDTIPSMSG = 1021;
    public static final int DRIVERARRIVEMSG = 1020;
    public static final int GPSWEAKMSG = 1017;
    public static final int GUIDESHOWMSG = 1019;
    public static final int HELPMSG = 10002;
    public static final int REACHENDMSG = 1018;
    public static final int SAFETIPS = 1015;

    /* renamed from: a */
    private static final int f23157a = 40;

    /* renamed from: b */
    private static final int f23158b = 100;

    /* renamed from: c */
    private static final int f23159c = 130;

    /* renamed from: d */
    private static final int f23160d = 20;

    /* renamed from: e */
    private static final int f23161e = 10000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f23162f;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f23163A = false;

    /* renamed from: B */
    private Bitmap f23164B;

    /* renamed from: C */
    private boolean f23165C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Handler f23166D = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i == 1015) {
                    ZGGlobalUIManager.this.f23176o.setVisibility(8);
                } else if (i != 10001) {
                    if (i != 10002) {
                        switch (i) {
                            case 1017:
                                boolean unused = ZGGlobalUIManager.this.f23163A = ((Boolean) message.obj).booleanValue();
                                ZGGlobalUIManager.this.m16637e();
                                return;
                            case 1018:
                                if (ZGGlobalUIManager.this.f23172k != null) {
                                    ZGGlobalUIManager.this.f23172k.onReachDestination();
                                    return;
                                }
                                return;
                            case 1019:
                                ZGGlobalUIManager.this.m16633d();
                                return;
                            case 1020:
                                ZGGlobalUIManager.this.m16624a((String) message.obj);
                                return;
                            case 1021:
                                ZGGlobalUIManager.this.m16625a(((Boolean) message.obj).booleanValue());
                                return;
                            default:
                                return;
                        }
                    } else if (ZGGlobalUIManager.this.f23172k != null) {
                        ZGGlobalUIManager.this.f23172k.onHelpBtnClick();
                    }
                } else if (ZGGlobalUIManager.this.f23172k != null) {
                    ZGGlobalUIManager.this.f23172k.onFinishBtnClick();
                }
            }
        }
    };

    /* renamed from: E */
    private Runnable f23167E = new Runnable() {
        public void run() {
            ZGGlobalUIManager.this.f23177p.setVisibility(8);
            boolean unused = ZGGlobalUIManager.this.f23187z = false;
            ZGGlobalUIManager.this.m16637e();
        }
    };

    /* renamed from: g */
    private int f23168g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f23169h;

    /* renamed from: i */
    private float f23170i;

    /* renamed from: j */
    private SlidingUpPanelLayout f23171j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ZGUIListener f23172k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Context f23173l = null;

    /* renamed from: m */
    private View f23174m = null;

    /* renamed from: n */
    private ViewGroup f23175n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RelativeLayout f23176o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LinearLayout f23177p;

    /* renamed from: q */
    private TextView f23178q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public RelativeLayout f23179r;

    /* renamed from: s */
    private Button f23180s;

    /* renamed from: t */
    private Button f23181t;

    /* renamed from: u */
    private FrameLayout f23182u;

    /* renamed from: v */
    private LinearLayout f23183v;

    /* renamed from: w */
    private int f23184w;

    /* renamed from: x */
    private FrameLayout f23185x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f23186y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f23187z = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalUIManager$MsgType */
    public @interface MsgType {
    }

    public float getWindowWidthDP() {
        return ((float) this.f23168g) / this.f23170i;
    }

    public float getWindowHeightDP() {
        return ((float) this.f23169h) / this.f23170i;
    }

    public FrameLayout getArcLayout() {
        return this.f23185x;
    }

    public ZGGlobalUIManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f23173l = context;
        this.f23175n = viewGroup;
        m16621a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar_zg_global, (ViewGroup) null);
        this.f23174m = inflate;
        this.f23176o = (RelativeLayout) inflate.findViewById(R.id.safe_alert);
        this.f23177p = (LinearLayout) this.f23174m.findViewById(R.id.common_toast);
        this.f23178q = (TextView) this.f23174m.findViewById(R.id.common_toast_tv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f23177p.getLayoutParams();
        f23162f = layoutParams.bottomMargin;
        layoutParams.bottomMargin = ((int) (((float) this.f23169h) / 3.0f)) + DisplayUtils.dip2px(this.f23173l, 30.0f);
        this.f23177p.setLayoutParams(layoutParams);
        this.f23180s = (Button) this.f23174m.findViewById(R.id.back_btn);
        this.f23181t = (Button) this.f23174m.findViewById(R.id.question_btn);
        this.f23180s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGGlobalUIManager.this.f23166D.obtainMessage();
                obtainMessage.what = 10001;
                ZGGlobalUIManager.this.f23166D.sendMessage(obtainMessage);
            }
        });
        this.f23181t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGGlobalUIManager.this.f23166D.obtainMessage();
                obtainMessage.what = 10002;
                ZGGlobalUIManager.this.f23166D.sendMessage(obtainMessage);
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.f23174m.findViewById(R.id.behind_tips);
        this.f23183v = linearLayout;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams2.topMargin = (int) (((float) this.f23169h) / 3.0f);
        this.f23183v.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout = (RelativeLayout) this.f23174m.findViewById(R.id.expand_map);
        this.f23179r = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ZGGlobalUIManager.this.expandMapView();
            }
        });
        this.f23179r.setOnTouchListener(new View.OnTouchListener() {
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
                    ZGGlobalUIManager.this.expandMapView();
                    return false;
                }
            }
        });
        m16628b();
        m16631c();
        updateZGEffectiveRect();
    }

    /* renamed from: a */
    private void m16621a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.f23168g = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f23169h = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f23170i = displayMetrics.density;
    }

    /* renamed from: b */
    private void m16628b() {
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) this.f23174m.findViewById(R.id.sliding_layout);
        this.f23171j = slidingUpPanelLayout;
        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        this.f23171j.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            SlidingUpPanelLayout.PanelState prevStateWhenChanged;

            public void onPanelSlide(View view, float f) {
            }

            public void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                if (!(panelState == SlidingUpPanelLayout.PanelState.DRAGGING || panelState == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                    this.prevStateWhenChanged = panelState;
                }
                if (SlidingUpPanelLayout.PanelState.DRAGGING == panelState2) {
                    ZGGlobalUIManager.this.f23179r.setVisibility(8);
                } else if (SlidingUpPanelLayout.PanelState.ANCHORED == panelState2) {
                    if (this.prevStateWhenChanged == SlidingUpPanelLayout.PanelState.EXPANDED) {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                    } else {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                } else if (SlidingUpPanelLayout.PanelState.EXPANDED == panelState2) {
                    ZGGlobalUIManager.this.f23179r.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ZGGlobalUIManager.this.f23177p.getLayoutParams();
                    layoutParams.bottomMargin = ((int) (((float) ZGGlobalUIManager.this.f23169h) / 3.0f)) + DisplayUtils.dip2px(ZGGlobalUIManager.this.f23173l, 30.0f);
                    ZGGlobalUIManager.this.f23177p.setLayoutParams(layoutParams);
                    AROmega.zgMapARNavDirectMapShow();
                } else if (SlidingUpPanelLayout.PanelState.COLLAPSED == panelState2) {
                    ZGGlobalUIManager.this.f23179r.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ZGGlobalUIManager.this.f23177p.getLayoutParams();
                    layoutParams2.bottomMargin = ZGGlobalUIManager.f23162f;
                    ZGGlobalUIManager.this.f23177p.setLayoutParams(layoutParams2);
                    AROmega.zgMapARNavDirectMapHide();
                }
                ZGGlobalUIManager.this.updateZGEffectiveRect();
            }
        });
        this.f23184w = ((int) (((float) this.f23169h) / 3.0f)) + DisplayUtils.dip2px(this.f23173l, 40.0f);
        this.f23182u = (FrameLayout) this.f23174m.findViewById(R.id.drag_view);
        this.f23182u.setLayoutParams(new SlidingUpPanelLayout.LayoutParams(-1, this.f23184w));
        FrameLayout frameLayout = (FrameLayout) this.f23174m.findViewById(R.id.map_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.height = (int) (((float) this.f23169h) / 3.0f);
        frameLayout.setLayoutParams(layoutParams);
        if (MapVenderUtil.getCurrentMapType(this.f23173l) == MapVendor.DIDI) {
            this.f23185x = new ArcLayout(this.f23173l);
            frameLayout.addView(this.f23185x, new FrameLayout.LayoutParams(-1, -1));
            ArcLayout arcLayout = (ArcLayout) this.f23174m.findViewById(R.id.map_back_container);
            arcLayout.setVisibility(0);
            arcLayout.setClipAreaColor(-1);
            arcLayout.setLayoutParams(layoutParams);
            return;
        }
        this.f23174m.findViewById(R.id.map_back_container).setVisibility(8);
        int dip2px = DisplayUtils.dip2px(this.f23173l, 14.0f);
        View view = new View(this.f23173l);
        view.setBackgroundColor(-1);
        this.f23185x = new FrameLayout(this.f23173l);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) ((((float) this.f23169h) / 3.0f) - ((float) dip2px)));
        layoutParams2.gravity = 80;
        frameLayout.addView(this.f23185x, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, dip2px);
        layoutParams3.gravity = 48;
        frameLayout.addView(view, layoutParams3);
    }

    public void updateZGEffectiveRect() {
        DARCPointF dARCPointF = new DARCPointF();
        dARCPointF.setX(20.0f);
        dARCPointF.setY(100.0f);
        DARCSizeF dARCSizeF = new DARCSizeF();
        int i = (int) ((((float) this.f23168g) / this.f23170i) - 40.0f);
        float f = 0.0f;
        dARCSizeF.setW(i > 0 ? (float) i : 0.0f);
        int i2 = (((int) (((float) this.f23169h) / this.f23170i)) - 100) - 130;
        if (SlidingUpPanelLayout.PanelState.EXPANDED == this.f23171j.getPanelState()) {
            i2 = ((int) (((float) (this.f23169h - this.f23184w)) / this.f23170i)) - 100;
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
    private void m16631c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f23175n.indexOfChild(this.f23174m) < 0) {
            this.f23175n.addView(this.f23174m, layoutParams);
        } else {
            this.f23175n.updateViewLayout(this.f23174m, layoutParams);
        }
    }

    public void setListener(ZGUIListener zGUIListener) {
        this.f23172k = zGUIListener;
    }

    public void showSafeTips(int i) {
        if (!this.f23165C) {
            this.f23176o.setVisibility(0);
            Message obtainMessage = this.f23166D.obtainMessage();
            obtainMessage.what = 1015;
            this.f23166D.sendMessageDelayed(obtainMessage, (long) i);
            this.f23165C = true;
        }
    }

    public void onDriverArrived(String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f23166D.obtainMessage();
            obtainMessage.what = 1020;
            obtainMessage.obj = str;
            this.f23166D.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16624a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23187z = false;
            this.f23166D.removeCallbacks(this.f23167E);
            this.f23186y = true;
            this.f23178q.setText(str);
            this.f23177p.setVisibility(0);
            this.f23166D.postDelayed(new Runnable() {
                public void run() {
                    ZGGlobalUIManager.this.f23177p.setVisibility(8);
                    boolean unused = ZGGlobalUIManager.this.f23186y = false;
                    ZGGlobalUIManager.this.m16637e();
                }
            }, 10000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16633d() {
        if (!ARSharePref.isARZGFirstLaunch()) {
            ARSharePref.setARZGLaunched();
            this.f23187z = true;
            m16637e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16637e() {
        if (!this.f23186y) {
            if (this.f23187z) {
                this.f23178q.setText(this.f23173l.getString(R.string.GRider_guide_Follow_the_iJTd));
                this.f23177p.setVisibility(0);
                this.f23166D.postDelayed(this.f23167E, 10000);
            } else if (this.f23163A) {
                this.f23178q.setText(this.f23173l.getString(R.string.GRider_guide_The_satellite_cwIE));
                this.f23177p.setVisibility(0);
            } else {
                this.f23177p.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16625a(boolean z) {
        if (z) {
            this.f23183v.setVisibility(0);
        } else {
            this.f23183v.setVisibility(8);
        }
    }

    public void onShowEndGuideNode() {
        Message obtainMessage = this.f23166D.obtainMessage();
        obtainMessage.what = 1019;
        this.f23166D.sendMessage(obtainMessage);
    }

    public void onBehindTipsMsg(boolean z) {
        Message obtainMessage = this.f23166D.obtainMessage();
        obtainMessage.what = 1021;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f23166D.sendMessage(obtainMessage);
    }

    public void onGpsWeak(boolean z) {
        Message obtainMessage = this.f23166D.obtainMessage();
        obtainMessage.what = 1017;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f23166D.sendMessage(obtainMessage);
    }

    public void onReachEnd(int i) {
        Message obtainMessage = this.f23166D.obtainMessage();
        obtainMessage.what = 1018;
        this.f23166D.sendMessageDelayed(obtainMessage, (long) i);
    }

    public void expandMapView() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f23171j;
        if (slidingUpPanelLayout != null && slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.EXPANDED) {
            this.f23171j.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    public void release() {
        this.f23185x.removeAllViews();
        this.f23166D.removeCallbacksAndMessages((Object) null);
        this.f23172k = null;
    }
}
