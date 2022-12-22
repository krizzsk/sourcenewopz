package com.didi.beatles.p099im.plugin.robot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotPraise;
import com.didi.beatles.p099im.plugin.robot.utils.IMRobotTraceUtil;
import com.didi.beatles.p099im.plugin.robot.utils.IMRobotViewUtil;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMAudioHelper;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.views.widget.IMToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotPraiseView */
public class IMRobotPraiseView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9528a = IMRobotPraiseView.class.getSimpleName();

    /* renamed from: b */
    private TextView f9529b;

    /* renamed from: c */
    private TextView f9530c;

    /* renamed from: d */
    private ImageView f9531d;

    /* renamed from: e */
    private View f9532e;

    /* renamed from: f */
    private View f9533f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImageView f9534g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ProgressBar f9535h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMRobotPraise f9536i;

    /* renamed from: j */
    private Context f9537j;

    /* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotPraiseView$PraiseActionListener */
    public interface PraiseActionListener {
        void switchPraise();
    }

    public IMRobotPraiseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRobotPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRobotPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9537j = context;
        LayoutInflater.from(context).inflate(R.layout.im_plugin_robot_praise_view, this);
        this.f9533f = findViewById(R.id.change_view);
        this.f9534g = (ImageView) findViewById(R.id.change_img);
        this.f9531d = (ImageView) findViewById(R.id.start_avatar_image);
        this.f9530c = (TextView) findViewById(R.id.im_plugin_robot_title);
        this.f9529b = (TextView) findViewById(R.id.praise_txt);
        this.f9532e = findViewById(R.id.play_audio_btn);
        this.f9535h = (ProgressBar) findViewById(R.id.robot_avatar_progress_bar);
    }

    public void bind(IMRobotGetConfigureResponse.Robot robot, IMRobotPraise iMRobotPraise, final PraiseActionListener praiseActionListener) {
        BtsImageLoader.getInstance().loadInto((Object) robot.starImgBig, (View) this.f9531d, (Callback) new Callback() {
            public void onFailed() {
            }

            public void onStart() {
                IMRobotViewUtil.show((View) IMRobotPraiseView.this.f9535h);
            }

            public void onSuccess(Bitmap bitmap) {
                IMRobotViewUtil.hide((View) IMRobotPraiseView.this.f9535h);
            }
        });
        this.f9530c.setText(robot.name);
        this.f9536i = iMRobotPraise;
        if (iMRobotPraise != null) {
            this.f9529b.setText(iMRobotPraise.text);
            this.f9532e.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (IMRobotPraiseView.this.f9536i != null) {
                        IMRobotTraceUtil.tracePlayingRobotPraiseClick(IMRobotPraiseView.this.f9536i.robotId, IMRobotPraiseView.this.f9536i.praiseId, IMAudioHelper.isPlayingCurrentAudio(IMRobotPraiseView.this.f9536i.voice, 2) ^ true ? 1 : 0);
                        IMRobotPraiseView iMRobotPraiseView = IMRobotPraiseView.this;
                        iMRobotPraiseView.m6475a(iMRobotPraiseView.f9536i.voice);
                    }
                }
            });
            this.f9533f.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotPraiseView iMRobotPraiseView = IMRobotPraiseView.this;
                    iMRobotPraiseView.m6472a(iMRobotPraiseView.f9534g);
                    praiseActionListener.switchPraise();
                    IMRobotPraiseView.this.stopPlayAudio();
                    if (IMRobotPraiseView.this.f9536i != null) {
                        IMRobotTraceUtil.traceChangeRobotPraiseClick(IMRobotPraiseView.this.f9536i.robotId, IMRobotPraiseView.this.f9536i.praiseId);
                    }
                }
            });
        }
    }

    public IMRobotPraise getCurrentPraise() {
        return this.f9536i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6475a(final String str) {
        if (str == null) {
            IMLog.m6637w(f9528a, C4234I.m6591t("[playAudio] fid = null"));
            return;
        }
        try {
            IMAudioHelper.playFromNet(getContext(), str, 2, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMRobotPraiseView.this.m6477b();
                    IMLog.m6631d(IMRobotPraiseView.f9528a, C4234I.m6591t("[playAudio] #onStarted# fid=", str));
                }

                public void onCompletion() {
                    IMRobotPraiseView.this.m6479c();
                    IMLog.m6631d(IMRobotPraiseView.f9528a, C4234I.m6591t("[playAudio] #onCompletion# fid=", str));
                }

                public void onError(String str) {
                    SystemUtils.showToast(IMToast.makeText(IMRobotPraiseView.this.getContext(), (CharSequence) IMRobotPraiseView.this.getContext().getString(R.string.im_plugin_robot_audio_play_fail), 0));
                    IMLog.m6632e(IMRobotPraiseView.f9528a, C4234I.m6591t("[playAudio] #onError# fid=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMRobotPraiseView.this.m6479c();
                    IMLog.m6631d(IMRobotPraiseView.f9528a, C4234I.m6591t("[playAudio] #onStop# fid=", str));
                }
            });
        } catch (Exception e) {
            m6477b();
            IMLog.m6632e(f9528a, "[playAudio]", e);
        }
    }

    public void stopPlayAudio() {
        if (IMBtsAudioPlayer.isPlaying()) {
            IMAudioHelper.stopPlay(2);
            m6479c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6477b() {
        ((AnimationDrawable) this.f9532e.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6479c() {
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f9532e.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6472a(ImageView imageView) {
        imageView.startAnimation(AnimationUtils.loadAnimation(this.f9537j, R.anim.im_plugin_robot_change_anim));
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (!z) {
            stopPlayAudio();
        }
    }
}
