package com.didi.beatles.p099im.views.bottombar.recorder;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.drawable.DrawableCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.activity.IMMessageActivity;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.audio.IMRecorderManager;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p099im.views.bottombar.IMConversationBottomBar;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg */
public class IMBtmRecorderGlobalPsg implements IMBtmRecorder {

    /* renamed from: b */
    private static final int f10073b = 0;

    /* renamed from: c */
    private static final int f10074c = 1;

    /* renamed from: d */
    private static final int f10075d = 0;

    /* renamed from: e */
    private static final int f10076e = 1;

    /* renamed from: f */
    private static final int f10077f = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f10078A = 0;

    /* renamed from: B */
    private int f10079B = 1;

    /* renamed from: C */
    private String f10080C = null;

    /* renamed from: D */
    private IMRecorderManager.Callback f10081D = null;

    /* renamed from: E */
    private View.OnTouchListener f10082E = new View.OnTouchListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            if (r4 != 3) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r5.getAction()
                r0 = 1
                if (r4 == 0) goto L_0x0066
                r1 = 2
                if (r4 == r0) goto L_0x0035
                if (r4 == r1) goto L_0x0011
                r5 = 3
                if (r4 == r5) goto L_0x0035
                goto L_0x0085
            L_0x0011:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f10078A
                if (r4 != 0) goto L_0x001a
                return r0
            L_0x001a:
                float r4 = r5.getRawX()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r5 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r5 = r5.f10084g
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x002f
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6868a((int) r0)
                goto L_0x0085
            L_0x002f:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6868a((int) r1)
                goto L_0x0085
            L_0x0035:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f10090m
                r4.cancelAnimation()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f10078A
                r5 = 0
                if (r4 != 0) goto L_0x0048
                return r5
            L_0x0048:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f10078A
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r2 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                if (r4 != r0) goto L_0x0053
                r5 = 1
            L_0x0053:
                r2.m6875a((boolean) r5)
                if (r4 != r0) goto L_0x005e
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6885f()
                goto L_0x0085
            L_0x005e:
                if (r4 != r1) goto L_0x0085
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6886g()
                goto L_0x0085
            L_0x0066:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6867a()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f10090m
                boolean r4 = r4.isAnimating()
                if (r4 != 0) goto L_0x0080
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f10090m
                r4.playAnimation()
            L_0x0080:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m6882e()
            L_0x0085:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.C43122.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };

    /* renamed from: a */
    private final String f10083a = "IMBtmRecorderGlobalPsg";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f10084g = IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 100.0f);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f10085h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ViewGroup f10086i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ConstraintLayout f10087j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMBaseBottomBar.BottomBarListener f10088k;

    /* renamed from: l */
    private TextView f10089l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public LottieAnimationView f10090m;

    /* renamed from: n */
    private View f10091n;

    /* renamed from: o */
    private View f10092o;

    /* renamed from: p */
    private View f10093p;

    /* renamed from: q */
    private View f10094q;

    /* renamed from: r */
    private View f10095r;

    /* renamed from: s */
    private View f10096s;

    /* renamed from: t */
    private Drawable f10097t;

    /* renamed from: u */
    private GradientDrawable f10098u;

    /* renamed from: v */
    private GradientDrawable f10099v;

    /* renamed from: w */
    private GradientDrawable f10100w;

    /* renamed from: x */
    private Drawable f10101x;

    /* renamed from: y */
    private ConstraintSet f10102y;

    /* renamed from: z */
    private ConstraintSet f10103z;

    public void bindListener(TextView textView, IMBaseBottomBar iMBaseBottomBar) {
        this.f10085h = (Activity) iMBaseBottomBar.context;
        this.f10088k = ((IMConversationBottomBar) iMBaseBottomBar).mListener;
        this.f10086i = (ViewGroup) ((IMMessageActivity) iMBaseBottomBar.context).findViewById(R.id.bts_im_layout_root);
        textView.setOnTouchListener(this.f10082E);
    }

    public boolean interceptBackPressed() {
        if (this.f10078A == 0) {
            return false;
        }
        m6875a(false);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6867a() {
        m6877b();
        ConstraintLayout constraintLayout = this.f10087j;
        if (constraintLayout != null) {
            if (this.f10086i.indexOfChild(constraintLayout) < 0) {
                this.f10086i.addView(this.f10087j, new ViewGroup.LayoutParams(-1, -1));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f10085h, R.anim.im_record_in_global_psg);
            this.f10087j.clearAnimation();
            this.f10087j.setAnimation(loadAnimation);
            loadAnimation.start();
            m6868a(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6875a(final boolean z) {
        if (this.f10078A != 0) {
            this.f10078A = 0;
            if (this.f10087j != null) {
                this.f10086i.post(new Runnable() {
                    public void run() {
                        Animation animation;
                        if (IMBtmRecorderGlobalPsg.this.f10078A == 0) {
                            IMBtmRecorderGlobalPsg.this.f10087j.clearAnimation();
                            if (z) {
                                animation = AnimationUtils.loadAnimation(IMBtmRecorderGlobalPsg.this.f10085h, R.anim.im_record_out_global_psg);
                            } else {
                                animation = AnimationUtils.loadAnimation(IMBtmRecorderGlobalPsg.this.f10085h, R.anim.im_record_cancel_global_psg);
                            }
                            IMBtmRecorderGlobalPsg.this.f10087j.setAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                public void onAnimationRepeat(Animation animation) {
                                }

                                public void onAnimationStart(Animation animation) {
                                }

                                public void onAnimationEnd(Animation animation) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (IMBtmRecorderGlobalPsg.this.f10078A == 0) {
                                                IMBtmRecorderGlobalPsg.this.f10086i.removeView(IMBtmRecorderGlobalPsg.this.f10087j);
                                            }
                                        }
                                    });
                                }
                            });
                            animation.start();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    private void m6877b() {
        if (this.f10087j == null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(this.f10086i.getContext()).inflate(R.layout.im_layout_recorder_global_psg, this.f10086i, false);
            this.f10087j = constraintLayout;
            this.f10089l = (TextView) constraintLayout.findViewById(R.id.im_record_tip_text);
            this.f10091n = this.f10087j.findViewById(R.id.im_record_icon_icon);
            this.f10092o = this.f10087j.findViewById(R.id.im_record_icon_bg);
            this.f10093p = this.f10087j.findViewById(R.id.im_record_tip_shape);
            this.f10094q = this.f10087j.findViewById(R.id.im_record_tip_triangle);
            this.f10095r = this.f10087j.findViewById(R.id.im_record_del);
            this.f10096s = this.f10087j.findViewById(R.id.im_record_del_bg);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f10087j.findViewById(R.id.im_record_sound);
            this.f10090m = lottieAnimationView;
            lottieAnimationView.setAnimation("im/im_recording_global_psg.json");
            this.f10090m.setRepeatCount(-1);
            ConstraintSet constraintSet = new ConstraintSet();
            this.f10102y = constraintSet;
            constraintSet.clone(this.f10087j);
            ConstraintSet constraintSet2 = new ConstraintSet();
            this.f10103z = constraintSet2;
            constraintSet2.clone(this.f10086i.getContext(), R.layout.im_layout_recorder_cancel_global_psg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6868a(int i) {
        if (i != this.f10078A && this.f10087j != null) {
            this.f10078A = i;
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition(this.f10087j, (Transition) null);
            }
            int i2 = this.f10078A;
            if (i2 == 1) {
                m6879c();
                this.f10102y.applyTo(this.f10087j);
            } else if (i2 == 2) {
                m6881d();
                this.f10103z.applyTo(this.f10087j);
            }
        }
    }

    /* renamed from: c */
    private void m6879c() {
        this.f10089l.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
        this.f10091n.setBackgroundResource(R.drawable.im_icon_record_global_psg);
        if (this.f10098u == null) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.f10092o.getResources().getDrawable(R.drawable.im_default_circle_mask).mutate();
            this.f10098u = gradientDrawable;
            gradientDrawable.setColor(-1);
        }
        this.f10092o.setBackgroundDrawable(this.f10098u);
        this.f10093p.setBackgroundResource(R.drawable.im_record_tip_shape_global_psg);
        this.f10094q.setBackgroundResource(R.drawable.im_record_tip_triangle_global_psg);
        this.f10096s.setBackgroundResource(R.drawable.im_trans_fun_shaped_mask);
        this.f10095r.setBackgroundResource(R.drawable.im_icon_del_global_psg);
    }

    /* renamed from: d */
    private void m6881d() {
        this.f10089l.setText(IMResource.getString(R.string.bts_im_record_cancle_tip));
        if (this.f10097t == null) {
            Drawable wrap = DrawableCompat.wrap(this.f10091n.getResources().getDrawable(R.drawable.im_icon_record_global_psg).mutate());
            this.f10097t = wrap;
            wrap.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        this.f10091n.setBackgroundDrawable(this.f10097t);
        if (this.f10099v == null) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.f10092o.getResources().getDrawable(R.drawable.im_default_circle_mask).mutate();
            this.f10099v = gradientDrawable;
            gradientDrawable.setColor(Color.parseColor("#660A121A"));
        }
        this.f10092o.setBackgroundDrawable(this.f10099v);
        if (this.f10100w == null) {
            GradientDrawable gradientDrawable2 = (GradientDrawable) this.f10093p.getResources().getDrawable(R.drawable.im_record_tip_shape_global_psg).mutate();
            this.f10100w = gradientDrawable2;
            gradientDrawable2.setColor(Color.parseColor(ColorUtils.DIDI_RED));
        }
        this.f10093p.setBackgroundDrawable(this.f10100w);
        if (this.f10101x == null) {
            Drawable mutate = this.f10093p.getResources().getDrawable(R.drawable.im_record_tip_triangle_global_psg).mutate();
            this.f10101x = mutate;
            mutate.setColorFilter(Color.parseColor(ColorUtils.DIDI_RED), PorterDuff.Mode.SRC_ATOP);
        }
        this.f10094q.setBackgroundDrawable(this.f10101x);
        this.f10096s.setBackgroundResource(R.drawable.im_default_fun_shaped_mask);
        this.f10095r.setBackgroundResource(R.drawable.im_icon_open_del_global_psg);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6882e() {
        IMLog.m6631d("IMBtmRecorderGlobalPsg", this.f10079B + "");
        if (this.f10079B == 1) {
            this.f10079B = 0;
            IMBtsAudioHelper.stopPlaying();
            m6889h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6885f() {
        IMLog.m6631d("IMBtmRecorderGlobalPsg", this.f10079B + "");
        if (this.f10079B == 0) {
            this.f10079B = 1;
            IMRecorderManager.getInstance().stop(this.f10080C, this.f10081D);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6886g() {
        IMLog.m6631d("IMBtmRecorderGlobalPsg", this.f10079B + "");
        if (this.f10079B == 0) {
            this.f10079B = 1;
            IMRecorderManager.getInstance().cancel(this.f10080C, this.f10081D);
        }
    }

    /* renamed from: h */
    private void m6889h() {
        this.f10080C = IMRecorderManager.createFileId();
        this.f10081D = new IMRecorderManager.Callback() {
            public void onResidueTimeChange(String str) {
            }

            public void onSoundLevelChange(int i) {
            }

            public void onStartRecord() {
            }

            public void onError(int i, String str) {
                if (i == 1) {
                    IMBtmRecorderGlobalPsg.this.m6870a((int) R.drawable.im_toast_warm, str);
                } else if (i == 2) {
                    IMBtmRecorderGlobalPsg.this.m6869a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_audio_recorded_so_short);
                } else if (i != 3) {
                    IMLog.m6637w(C4234I.m6591t("startAudioRecorder errNo ", Integer.valueOf(i), " errMsg ", str), new Object[0]);
                } else {
                    IMBtmRecorderGlobalPsg.this.m6869a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_record_error);
                }
            }

            public void onSuccess(String str, long j) {
                if (IMBtmRecorderGlobalPsg.this.f10088k != null) {
                    IMBtmRecorderGlobalPsg.this.f10088k.sendVoiceMessage(str, j);
                }
            }

            public void onEndRecord() {
                IMBtmRecorderGlobalPsg.this.m6875a(true);
            }
        };
        IMRecorderManager.getInstance().recorder(this.f10080C, this.f10081D);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6869a(int i, int i2) {
        m6870a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6870a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIconKeepSize(makeText, i);
        IMTipsToast.setText(makeText, str);
    }
}
