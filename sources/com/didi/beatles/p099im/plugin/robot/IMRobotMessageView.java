package com.didi.beatles.p099im.plugin.robot;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotMessageContent;
import com.didi.beatles.p099im.plugin.robot.utils.IMRobotTraceUtil;
import com.didi.beatles.p099im.plugin.robot.utils.IMRobotViewUtil;
import com.didi.beatles.p099im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p099im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMAudioHelper;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.widget.IMToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotMessageView */
public class IMRobotMessageView extends FrameLayout implements IIMPluginCardView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9489a = IMRobotMessageView.class.getSimpleName();

    /* renamed from: b */
    private View f9490b;

    /* renamed from: c */
    private ImageView f9491c;

    /* renamed from: d */
    private TextView f9492d;

    /* renamed from: e */
    private TextView f9493e;

    /* renamed from: f */
    private View f9494f;

    /* renamed from: g */
    private View f9495g;

    /* renamed from: h */
    private View f9496h;

    /* renamed from: i */
    private View f9497i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9498j;

    /* renamed from: k */
    private IMRenderCardEnv f9499k;

    /* renamed from: l */
    private ArraySet<String> f9500l;

    public boolean isShowInMiddle() {
        return false;
    }

    public void onCardClick(View view) {
    }

    public IMRobotMessageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRobotMessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRobotMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9498j = false;
        this.f9500l = new ArraySet<>();
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_plugin_robot_msg_view, this, true);
        this.f9490b = inflate;
        this.f9491c = (ImageView) inflate.findViewById(R.id.robot_msg_avatar_img);
        this.f9494f = this.f9490b.findViewById(R.id.robot_msg_share_layout);
        this.f9495g = this.f9490b.findViewById(R.id.robot_msg_audio_layout);
        this.f9496h = this.f9490b.findViewById(R.id.robot_msg_audio_img);
        this.f9497i = this.f9490b.findViewById(R.id.robot_msg_audio_progress_bar);
        this.f9492d = (TextView) this.f9490b.findViewById(R.id.robot_msg_title_text);
        this.f9493e = (TextView) this.f9490b.findViewById(R.id.robot_msg_content_text);
    }

    public void onBind(int i, IMRenderCardEnv iMRenderCardEnv, String str, IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.f9498j = false;
        final IMRobotMessageContent iMRobotMessageContent = (IMRobotMessageContent) IMJsonUtil.objectFromJson(str, IMRobotMessageContent.class);
        this.f9499k = iMRenderCardEnv;
        if (iMRobotMessageContent != null) {
            if (!TextUtils.isEmpty(iMRobotMessageContent.cardImg)) {
                IMRobotViewUtil.show((View) this.f9491c);
                BtsImageLoader.getInstance().loadInto(iMRobotMessageContent.cardImg, this.f9491c);
            } else {
                IMRobotViewUtil.hide((View) this.f9491c);
            }
            if (!TextUtils.isEmpty(iMRobotMessageContent.title)) {
                IMRobotViewUtil.show((View) this.f9492d);
                this.f9492d.setText(iMRobotMessageContent.title);
            } else {
                IMRobotViewUtil.hide((View) this.f9492d);
            }
            if (!TextUtils.isEmpty(iMRobotMessageContent.text)) {
                IMRobotViewUtil.show((View) this.f9493e);
                this.f9493e.setText(iMRobotMessageContent.text);
            } else {
                IMRobotViewUtil.hide((View) this.f9493e);
            }
            this.f9494f.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotTraceUtil.traceCardShareCk(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, IMRobotMessageView.this.getOrderId(), IMRobotMessageView.this.getExtraTraceMap());
                    if (!IMRobotBridge.navigation(iMRobotMessageContent.shareUrl)) {
                        IMLog.m6632e(IMRobotMessageView.f9489a, "[share] invoke navigation fail");
                    }
                }
            });
            this.f9495g.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotTraceUtil.traceCardVoiceCk(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, IMRobotMessageView.this.getOrderId(), IMRobotMessageView.this.getExtraTraceMap());
                    if (!IMRobotMessageView.this.f9498j) {
                        IMRobotMessageView.this.m6442a(iMRobotMessageContent.voice);
                    }
                }
            });
            if (this.f9500l.add(iMRobotMessageContent.praiseId)) {
                IMRobotTraceUtil.traceCardSw(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, getOrderId(), getExtraTraceMap());
            }
        }
    }

    /* access modifiers changed from: private */
    public String getOrderId() {
        IMRenderCardEnv iMRenderCardEnv = this.f9499k;
        if (iMRenderCardEnv != null) {
            return iMRenderCardEnv.getOrderId();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getExtraTraceMap() {
        IMRenderCardEnv iMRenderCardEnv = this.f9499k;
        if (iMRenderCardEnv != null) {
            return iMRenderCardEnv.getExtraTraceMap();
        }
        return null;
    }

    /* renamed from: b */
    private void m6444b() {
        this.f9498j = true;
        IMRobotViewUtil.hide(this.f9496h);
        IMRobotViewUtil.show(this.f9497i);
    }

    /* renamed from: c */
    private void m6445c() {
        this.f9498j = false;
        IMRobotViewUtil.hide(this.f9497i);
        IMRobotViewUtil.show(this.f9496h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6442a(final String str) {
        if (str == null) {
            IMLog.m6637w(f9489a, C4234I.m6591t("[playAudio] fid = null"));
            return;
        }
        m6444b();
        try {
            IMAudioHelper.playFromNet(getContext(), str, 1, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMRobotMessageView.this.m6447d();
                    IMLog.m6631d(IMRobotMessageView.f9489a, C4234I.m6591t("[playAudio] #onStarted# fid=", str));
                }

                public void onCompletion() {
                    IMRobotMessageView.this.m6449e();
                    IMLog.m6631d(IMRobotMessageView.f9489a, C4234I.m6591t("[playAudio] #onCompletion# fid=", str));
                }

                public void onError(String str) {
                    SystemUtils.showToast(IMToast.makeText(IMRobotMessageView.this.getContext(), (CharSequence) IMRobotMessageView.this.getContext().getString(R.string.im_plugin_robot_audio_play_fail), 0));
                    IMLog.m6632e(IMRobotMessageView.f9489a, C4234I.m6591t("[playAudio] #onError# fid=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMRobotMessageView.this.m6449e();
                    IMLog.m6631d(IMRobotMessageView.f9489a, C4234I.m6591t("[playAudio] #onStop# fid=", str));
                }
            });
        } catch (Exception e) {
            m6449e();
            IMLog.m6632e(f9489a, "[playAudio]", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6447d() {
        m6445c();
        ((AnimationDrawable) this.f9496h.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6449e() {
        m6445c();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f9496h.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }
}
