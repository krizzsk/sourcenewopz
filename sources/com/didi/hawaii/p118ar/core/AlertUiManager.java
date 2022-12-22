package com.didi.hawaii.p118ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p118ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p118ar.utils.ARNavGlobal;
import com.didi.hawaii.p118ar.utils.BatteryUtil;
import com.didi.hawaii.p118ar.utils.SensorUtil;
import com.didi.hawaii.p118ar.view.AutoVerticalScrollTextView;
import com.didi.hawaii.p118ar.view.LocationView;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* renamed from: com.didi.hawaii.ar.core.AlertUiManager */
public class AlertUiManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int BATTERYLOWERMSG = 10003;
    public static final int ExcessiveMotionMSG = 10006;
    public static final int ExcessiveMotionMSGHIDE = 1008;
    public static final int HELPMSG = 10002;
    public static final int LOCATIONRUNNING = 2;
    public static final int LOCATONING = 0;
    public static final int LOCATONSUCCESS = 1;
    public static final int MOVEORSTABLEMSG = 10005;
    public static final int NAVIGATIONHINTDISSMISSMSG = 1012;
    public static final int NAVIGATIONPITCHMSG = 1011;
    public static final int NOSTATUS = -1;
    public static final int PitchAviableMSG = 10004;
    public static final int REACHDESTINATIONMSG = 1010;
    public static final int RECOVERYMSG = 10007;
    public static final int REFESHDELAYOFAUTOTEXT = 100001;
    public static final int REFESHMSG = 1013;
    public static final int REFESHMSGDelay = 1014;
    public static final int SAFETIPS = 1015;
    public static final int SDKALERTMSG = 1009;

    /* renamed from: b */
    private static final int f22977b = 0;

    /* renamed from: c */
    private static final int f22978c = 1;

    /* renamed from: d */
    private static final int f22979d = -2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f22980A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public DARCNAVEDShowAlert f22981B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public HandleButton f22982C = new HandleButton();

    /* renamed from: D */
    private boolean f22983D = true;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Handler f22984E = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i != 100001) {
                    switch (i) {
                        case 1008:
                            if (AlertUiManager.this.f23000p != null) {
                                AlertUiManager.this.f23000p.setVisibility(8);
                            }
                            boolean unused = AlertUiManager.this.f22986G = false;
                            return;
                        case 1009:
                            ALertContent aLertContent = (ALertContent) message.obj;
                            if (AlertUiManager.this.f23006v != null && aLertContent.buttons.size() <= 2) {
                                AlertUiManager.this.m16534b();
                                AlertUiManager.this.f23006v.onALertFromSDK((ALertContent) message.obj, AlertUiManager.this.f22982C);
                                return;
                            }
                            return;
                        case 1010:
                            String str = (String) message.obj;
                            if (AlertUiManager.this.f23006v != null) {
                                AlertUiManager.this.m16534b();
                                AlertUiManager.this.f23006v.onALertReachDestination(str);
                                return;
                            }
                            return;
                        case 1011:
                            AlertUiManager.this.checkPitchAviableForNavigation(((Boolean) message.obj).booleanValue());
                            return;
                        case 1012:
                            if (AlertUiManager.this.f22989e == 2) {
                                AlertUiManager.this.f22998n.setVisibility(8);
                                AlertUiManager.this.f22996l.setVisibility(8);
                                boolean unused2 = AlertUiManager.this.f22985F = false;
                                AlertUiManager.this.m16541d();
                                return;
                            }
                            return;
                        case 1013:
                        case 1014:
                            int intValue = ((Integer) message.obj).intValue();
                            if (intValue == -1) {
                                AlertUiManager.this.refeshForNotStatus();
                                return;
                            } else if (intValue == 0) {
                                AlertUiManager.this.m16527a();
                                return;
                            } else if (intValue == 1) {
                                AlertUiManager.this.m16532a(false);
                                return;
                            } else if (intValue == 2) {
                                AlertUiManager.this.m16535b(false);
                                return;
                            } else {
                                return;
                            }
                        case 1015:
                            if (AlertUiManager.this.f22989e == 2) {
                                AlertUiManager.this.f22997m.setVisibility(8);
                                return;
                            }
                            return;
                        default:
                            switch (i) {
                                case 10001:
                                    AlertUiManager.this.m16534b();
                                    if (AlertUiManager.this.f23006v != null) {
                                        AlertUiManager.this.f23006v.onFinishBtnClick();
                                        return;
                                    }
                                    return;
                                case 10002:
                                    AlertUiManager.this.m16534b();
                                    if (AlertUiManager.this.f23006v != null) {
                                        AlertUiManager.this.f23006v.onHelpBtnClick();
                                        return;
                                    }
                                    return;
                                case 10003:
                                    AlertUiManager.this.m16534b();
                                    if (AlertUiManager.this.f23006v != null) {
                                        AlertUiManager.this.f23006v.onBatteryStateLower();
                                        return;
                                    }
                                    return;
                                case 10004:
                                    AlertUiManager.this.checkPitchAviable(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10005:
                                    AlertUiManager.this.checkMoveOrNot(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10006:
                                    AlertUiManager.this.m16540c(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10007:
                                    boolean unused3 = AlertUiManager.this.f23010z = false;
                                    int c = AlertUiManager.this.f22989e;
                                    if (c == -1) {
                                        AlertUiManager.this.refeshForNotStatus();
                                        return;
                                    } else if (c == 0) {
                                        AlertUiManager.this.m16527a();
                                        return;
                                    } else if (c == 2) {
                                        AlertUiManager.this.m16535b(true);
                                        return;
                                    } else {
                                        return;
                                    }
                                default:
                                    return;
                            }
                    }
                } else if (AlertUiManager.this.f22989e == 0) {
                    if (!AlertUiManager.this.f23010z && AlertUiManager.this.f23008x) {
                        AlertUiManager.this.f22993i.setVisibility(0);
                        AlertUiManager.this.f22994j.setVisibility(0);
                    }
                    boolean unused4 = AlertUiManager.this.f22987H = true;
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f22985F = true;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public volatile boolean f22986G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f22987H = false;

    /* renamed from: a */
    int f22988a = -2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22989e = -1;

    /* renamed from: f */
    private Context f22990f = null;

    /* renamed from: g */
    private ViewGroup f22991g = null;

    /* renamed from: h */
    private LocationView f22992h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public RelativeLayout f22993i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AutoVerticalScrollTextView f22994j;

    /* renamed from: k */
    private LinearLayout f22995k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LinearLayout f22996l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RelativeLayout f22997m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f22998n;

    /* renamed from: o */
    private TextView f22999o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f23000p;

    /* renamed from: q */
    private TextView f23001q;

    /* renamed from: r */
    private TextView f23002r;

    /* renamed from: s */
    private Button f23003s;

    /* renamed from: t */
    private Button f23004t;

    /* renamed from: u */
    private View f23005u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public UIListener f23006v;

    /* renamed from: w */
    private ImageView f23007w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile boolean f23008x = true;

    /* renamed from: y */
    private volatile boolean f23009y = true;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f23010z = true;

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$ALertContent */
    public static class ALertContent {
        public HashMap<String, String> buttons = new HashMap<>();
        public String msg;
        public String title;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$MsgType */
    public @interface MsgType {
    }

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$UIListener */
    public interface UIListener {
        void onALertFromSDK(ALertContent aLertContent, HandleButton handleButton);

        void onALertReachDestination(String str);

        void onBatteryStateLower();

        void onFinishBtnClick();

        void onHelpBtnClick();

        void onLocationSuccess();

        void onLocationing();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$locationSpeed */
    public @interface locationSpeed {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$status */
    public @interface C8859status {
    }

    public AlertUiManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f22990f = context;
        this.f22991g = viewGroup;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar, (ViewGroup) null);
        this.f23005u = inflate;
        this.f22992h = (LocationView) inflate.findViewById(R.id.location);
        this.f22993i = (RelativeLayout) this.f23005u.findViewById(R.id.location_tip);
        this.f22994j = (AutoVerticalScrollTextView) this.f23005u.findViewById(R.id.auto_text);
        this.f22998n = (TextView) this.f23005u.findViewById(R.id.alert);
        this.f23001q = (TextView) this.f23005u.findViewById(R.id.alert_sucloc);
        this.f23003s = (Button) this.f23005u.findViewById(R.id.back_btn);
        this.f23004t = (Button) this.f23005u.findViewById(R.id.question_btn);
        this.f23007w = (ImageView) this.f23005u.findViewById(R.id.pitch);
        this.f22999o = (TextView) this.f23005u.findViewById(R.id.pitch_hint);
        this.f23000p = (TextView) this.f23005u.findViewById(R.id.hint_move);
        this.f22995k = (LinearLayout) this.f23005u.findViewById(R.id.mask);
        this.f22994j.setDataList(ARNavGlobal.list);
        this.f22996l = (LinearLayout) this.f23005u.findViewById(R.id.top_nav);
        this.f22997m = (RelativeLayout) this.f23005u.findViewById(R.id.safe_alert);
        this.f23002r = (TextView) this.f23005u.findViewById(R.id.nav_content);
        m16538c();
        this.f23003s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = AlertUiManager.this.f22984E.obtainMessage();
                obtainMessage.what = 10001;
                AlertUiManager.this.f22984E.sendMessage(obtainMessage);
            }
        });
        this.f23004t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = AlertUiManager.this.f22984E.obtainMessage();
                obtainMessage.what = 10002;
                AlertUiManager.this.f22984E.sendMessage(obtainMessage);
            }
        });
        SensorUtil.getInstance().setPostureChangeListener(new SensorUtil.PostureChangeListener() {
            public void onPitchAviableChange(boolean z) {
                Message obtainMessage = AlertUiManager.this.f22984E.obtainMessage();
                obtainMessage.what = 10004;
                obtainMessage.obj = Boolean.valueOf(z);
                AlertUiManager.this.f22984E.sendMessage(obtainMessage);
            }

            public void onStableOrMoveHanppen(boolean z) {
                Message obtainMessage = AlertUiManager.this.f22984E.obtainMessage();
                obtainMessage.what = 10005;
                obtainMessage.obj = Boolean.valueOf(z);
                AlertUiManager.this.f22984E.sendMessage(obtainMessage);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16527a() {
        this.f22989e = 0;
        if (!this.f23010z) {
            UIListener uIListener = this.f23006v;
            if (uIListener != null) {
                uIListener.onLocationing();
            }
            if (this.f23005u == null) {
                return;
            }
            if (this.f23008x) {
                this.f22999o.setVisibility(8);
                this.f23007w.setVisibility(8);
                this.f23001q.setVisibility(8);
                this.f22992h.setVisibility(0);
                if (this.f22987H) {
                    this.f22993i.setVisibility(0);
                    this.f22994j.setVisibility(0);
                }
                this.f23000p.setVisibility(8);
                this.f22998n.setText(R.string.locationing);
                this.f22995k.setVisibility(8);
                this.f22996l.setVisibility(8);
                this.f22998n.setVisibility(0);
                this.f22997m.setVisibility(8);
                this.f22992h.startScan();
                return;
            }
            this.f22995k.setVisibility(0);
            this.f22999o.setVisibility(0);
            this.f23007w.setVisibility(0);
            this.f23001q.setVisibility(8);
            this.f22996l.setVisibility(8);
            this.f22992h.setVisibility(8);
            this.f22993i.setVisibility(8);
            this.f22994j.setVisibility(8);
            this.f23000p.setVisibility(8);
            this.f22997m.setVisibility(8);
            this.f22998n.setText(R.string.locationing);
            this.f22998n.setVisibility(8);
            this.f22992h.stopScan();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16532a(boolean z) {
        this.f22989e = 1;
        if (this.f23005u != null) {
            UIListener uIListener = this.f23006v;
            if (uIListener != null) {
                uIListener.onLocationSuccess();
            }
            this.f22999o.setVisibility(8);
            this.f23007w.setVisibility(8);
            this.f22996l.setVisibility(8);
            this.f22995k.setVisibility(8);
            this.f23001q.setVisibility(8);
            this.f23000p.setVisibility(8);
            this.f22998n.setVisibility(8);
            this.f22997m.setVisibility(8);
            this.f22994j.setVisibility(8);
            this.f22993i.setVisibility(8);
            this.f22992h.stopScan();
            this.f22992h.setVisibility(0);
            this.f22992h.exeDisAppearAnimator();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16535b(boolean z) {
        this.f22989e = 2;
        if (!this.f23010z && this.f23005u != null) {
            this.f22992h.stopScan();
            this.f22999o.setVisibility(8);
            this.f23007w.setVisibility(8);
            this.f22995k.setVisibility(8);
            this.f23001q.setVisibility(8);
            this.f22992h.setVisibility(8);
            this.f22993i.setVisibility(8);
            this.f22994j.setVisibility(8);
            this.f23000p.setVisibility(8);
            if (!z) {
                this.f22998n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f22998n.setVisibility(0);
                this.f22996l.setVisibility(0);
                this.f22997m.setVisibility(8);
                this.f23002r.setText(ARNavGlobal.destSpotName);
                this.f22985F = true;
            } else if (!this.f22985F) {
                this.f22998n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f22998n.setVisibility(8);
                this.f22996l.setVisibility(8);
                if (!this.f23009y) {
                    this.f23001q.setVisibility(0);
                }
            } else {
                this.f22998n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f22998n.setVisibility(0);
                this.f22996l.setVisibility(0);
                this.f23002r.setText(ARNavGlobal.destSpotName);
            }
        }
    }

    public void refeshForNotStatus() {
        this.f22989e = -1;
        if (!this.f23010z && this.f23005u != null) {
            this.f22992h.stopScan();
            this.f22999o.setVisibility(8);
            this.f23007w.setVisibility(8);
            this.f22995k.setVisibility(8);
            this.f22992h.setVisibility(8);
            this.f22993i.setVisibility(8);
            this.f22994j.setVisibility(8);
            this.f23001q.setVisibility(8);
            this.f22998n.setVisibility(8);
            this.f23000p.setVisibility(8);
            this.f22996l.setVisibility(8);
            this.f22997m.setVisibility(8);
        }
    }

    public void checkPitchAviable(boolean z) {
        if (this.f23010z || this.f22989e != 0) {
            return;
        }
        if (!z) {
            if (this.f23008x) {
                this.f23008x = false;
                if (this.f23005u != null) {
                    this.f22992h.stopScan();
                    this.f22992h.setVisibility(8);
                    this.f22993i.setVisibility(8);
                    this.f22994j.setVisibility(8);
                    this.f22998n.setVisibility(8);
                    this.f23001q.setVisibility(8);
                    this.f23007w.setVisibility(0);
                    this.f22999o.setVisibility(0);
                    this.f22995k.setVisibility(0);
                    this.f23000p.setVisibility(8);
                    this.f22996l.setVisibility(8);
                }
            }
        } else if (!this.f23008x) {
            this.f23008x = true;
            m16527a();
        }
    }

    public void checkPitchAviableForNavigation(boolean z) {
        if (!this.f23010z && !this.f22985F && this.f22989e == 2) {
            if (!z) {
                if (this.f23009y) {
                    this.f23009y = false;
                    if (this.f23005u != null) {
                        this.f22992h.stopScan();
                        this.f22992h.setVisibility(8);
                        this.f22993i.setVisibility(8);
                        this.f22994j.setVisibility(8);
                        this.f23007w.setVisibility(8);
                        this.f22999o.setVisibility(8);
                        this.f22995k.setVisibility(8);
                        this.f23000p.setVisibility(8);
                        this.f22996l.setVisibility(8);
                        this.f22998n.setVisibility(8);
                        this.f23001q.setVisibility(0);
                        if (this.f22983D) {
                            m16544d(false);
                            this.f22983D = false;
                        }
                    }
                }
            } else if (!this.f23009y) {
                this.f23009y = true;
                if (!this.f22983D) {
                    m16544d(true);
                    this.f22983D = true;
                }
                m16535b(true);
            }
        }
    }

    public void checkMoveOrNot(boolean z) {
        if (!this.f23010z && this.f23008x && this.f22989e == 0 && !this.f22986G) {
            if (!z) {
                this.f22988a = 0;
                if (this.f23005u != null) {
                    this.f23000p.setText(R.string.move_phone);
                    this.f23000p.setVisibility(0);
                    return;
                }
                return;
            }
            this.f22988a = -2;
            this.f23000p.setVisibility(8);
        }
    }

    public int getCurARStatus() {
        return this.f22989e;
    }

    public void hintForExcessiveMotion(boolean z) {
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 10006;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f22984E.sendMessage(obtainMessage);
    }

    public void checkPitchForNavigation(boolean z) {
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 1011;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f22984E.sendMessage(obtainMessage);
    }

    public void dissMissHintForNavigation(boolean z) {
        if (z) {
            Message obtainMessage = this.f22984E.obtainMessage();
            obtainMessage.what = 1012;
            this.f22984E.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16540c(boolean z) {
        if (!this.f23010z && this.f23008x && this.f22989e == 0 && z) {
            this.f22988a = 1;
            if (this.f23005u != null) {
                this.f23000p.setText(R.string.jiansu);
                this.f23000p.setVisibility(0);
                this.f22986G = true;
            }
            this.f22984E.removeMessages(1008);
            Message obtainMessage = this.f22984E.obtainMessage();
            obtainMessage.what = 1008;
            this.f22984E.sendMessageDelayed(obtainMessage, 1000);
        }
    }

    public void recoveryUI() {
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 10007;
        this.f22984E.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16534b() {
        this.f23010z = true;
        if (this.f22989e != 1 && this.f23005u != null) {
            this.f22992h.stopScan();
            this.f22999o.setVisibility(8);
            this.f23007w.setVisibility(8);
            this.f22995k.setVisibility(8);
            this.f22992h.setVisibility(8);
            this.f22998n.setVisibility(8);
            this.f23000p.setVisibility(8);
            this.f22996l.setVisibility(8);
            this.f22993i.setVisibility(8);
            this.f22994j.setVisibility(8);
        }
    }

    public void start() {
        startCheckMoveOrNot();
        startBatteryCheck();
    }

    public void startCheckMoveOrNot() {
        SensorUtil.getInstance().startMoveStatusCheck();
    }

    public void startBatteryCheck() {
        BatteryUtil.startListenBatteryState(new BatteryUtil.BatteryChangeListener() {
            public void onBatteryChange(float f) {
                if (!AlertUiManager.this.f22980A && f < ((float) ARNavGlobal.BATTERY_MOSTLOW_STATE)) {
                    Message obtainMessage = AlertUiManager.this.f22984E.obtainMessage();
                    obtainMessage.what = 10003;
                    AlertUiManager.this.f22984E.sendMessage(obtainMessage);
                    boolean unused = AlertUiManager.this.f22980A = true;
                }
            }
        });
    }

    public void onALertFromSDK(DARCNAVEDShowAlert dARCNAVEDShowAlert, String str, String str2, HashMap<String, String> hashMap) {
        this.f22981B = dARCNAVEDShowAlert;
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 1009;
        ALertContent aLertContent = new ALertContent();
        aLertContent.title = str;
        aLertContent.msg = str2;
        aLertContent.buttons = hashMap;
        obtainMessage.obj = aLertContent;
        this.f22984E.sendMessage(obtainMessage);
    }

    public void alertReachDestination(String str) {
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 1010;
        obtainMessage.obj = str;
        this.f22984E.sendMessage(obtainMessage);
    }

    public void setUIListener(UIListener uIListener) {
        this.f23006v = uIListener;
    }

    /* renamed from: c */
    private void m16538c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f22991g.indexOfChild(this.f23005u) < 0) {
            this.f22991g.addView(this.f23005u, layoutParams);
        } else {
            this.f22991g.updateViewLayout(this.f23005u, layoutParams);
        }
    }

    public void release() {
        this.f22984E.removeCallbacksAndMessages((Object) null);
        BatteryUtil.stopListenBatteryState();
        this.f23006v = null;
    }

    public void exitOfOrderCancell() {
        m16534b();
        this.f23006v = null;
    }

    public void hideARNavUI() {
        m16534b();
    }

    /* renamed from: d */
    private void m16544d(boolean z) {
        if (this.mAREngine != null) {
            this.mAREngine.setCorrectNodeVisible(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16531a(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        if (this.mAREngine != null) {
            this.mAREngine.eventShowAlertReply(dARCNAVEDShowAlert, i);
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$HandleButton */
    public class HandleButton {
        public HandleButton() {
        }

        public void handleClick(int i) {
            if (AlertUiManager.this.f22981B != null) {
                AlertUiManager alertUiManager = AlertUiManager.this;
                alertUiManager.m16531a(alertUiManager.f22981B, i);
            }
        }
    }

    public void refeshStatus(int i) {
        this.f22984E.removeMessages(100001);
        this.f22987H = false;
        this.f22984E.removeMessages(1015);
        this.f22984E.removeMessages(1014);
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 1013;
        obtainMessage.obj = Integer.valueOf(i);
        if (i == 0) {
            Message obtainMessage2 = this.f22984E.obtainMessage();
            obtainMessage2.what = 100001;
            this.f22984E.sendMessageDelayed(obtainMessage2, 5000);
        }
        if (i == 2) {
            obtainMessage.what = 1014;
            this.f22984E.sendMessageDelayed(obtainMessage, 2400);
            return;
        }
        this.f22984E.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16541d() {
        this.f22997m.setVisibility(0);
        Message obtainMessage = this.f22984E.obtainMessage();
        obtainMessage.what = 1015;
        this.f22984E.sendMessageDelayed(obtainMessage, 5000);
    }
}
