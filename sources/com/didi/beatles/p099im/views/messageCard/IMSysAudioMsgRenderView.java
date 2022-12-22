package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMSysAudioMsgBody;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMAudioHelper;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMSysAudioMsgRenderView */
public class IMSysAudioMsgRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10370a = IMSysAudioMsgRenderView.class.getSimpleName();

    /* renamed from: b */
    private static final int f10371b = 1;

    /* renamed from: l */
    private static final boolean f10372l;

    /* renamed from: m */
    private static int f10373m = 0;

    /* renamed from: c */
    private ImageView f10374c;

    /* renamed from: d */
    private ImageView f10375d;

    /* renamed from: e */
    private View f10376e;

    /* renamed from: f */
    private View f10377f;

    /* renamed from: g */
    private TextView f10378g;

    /* renamed from: h */
    private TextView f10379h;

    /* renamed from: i */
    private IMSysAudioMsgBody f10380i;

    /* renamed from: j */
    private boolean f10381j;

    /* renamed from: k */
    private IMRenderCardEnv f10382k;

    /* renamed from: n */
    private ArraySet<Long> f10383n = new ArraySet<>();

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    static {
        IToggle toggle = Apollo.getToggle("IM_Config_Sys_Audio_Auto_Play");
        f10372l = toggle != null && toggle.allow();
        String str = f10370a;
        IMLog.m6635i(str, "apollo auto play=" + f10372l);
    }

    public IMSysAudioMsgRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
        if (messageAdapter != null) {
            this.f10382k = messageAdapter.getRenderCardEnv();
        }
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_message_sys_audio_layout, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10374c = (ImageView) findViewById(R.id.sys_audio_avatar_img);
        this.f10375d = (ImageView) findViewById(R.id.sys_audio_bg_img);
        this.f10376e = findViewById(R.id.sys_audio_play_view);
        this.f10377f = findViewById(R.id.sys_audio_progress_bar);
        this.f10378g = (TextView) findViewById(R.id.sys_audio_msg_content_text);
        this.f10379h = (TextView) findViewById(R.id.sys_audio_msg_hint_text);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (this.message != null && this.message.getType() == 393224) {
            IMSysAudioMsgBody iMSysAudioMsgBody = (IMSysAudioMsgBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMSysAudioMsgBody.class);
            this.f10380i = iMSysAudioMsgBody;
            if (iMSysAudioMsgBody != null) {
                if (this.f10383n.add(Long.valueOf(iMMessage.getMid()))) {
                    traceCardSw();
                }
                if (!TextUtils.isEmpty(this.f10380i.cardImg)) {
                    this.f10374c.setVisibility(0);
                    BtsImageLoader.getInstance().loadInto(this.f10380i.cardImg, this.f10374c);
                } else {
                    this.f10374c.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f10380i.bgImg)) {
                    this.f10375d.setVisibility(0);
                    BtsImageLoader.getInstance().loadInto(this.f10380i.bgImg, this.f10375d);
                } else {
                    this.f10375d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f10380i.text)) {
                    this.f10378g.setVisibility(0);
                    this.f10378g.setText(this.f10380i.text);
                    if (!TextUtils.isEmpty(this.f10380i.titleColor)) {
                        this.f10378g.setTextColor(IMParseUtil.parseColor(this.f10380i.titleColor));
                    }
                } else {
                    this.f10378g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f10380i.hint)) {
                    this.f10379h.setVisibility(0);
                    this.f10379h.setText(this.f10380i.hint);
                } else {
                    this.f10379h.setVisibility(8);
                }
            }
            this.f10381j = false;
            m7075b();
        }
    }

    /* renamed from: b */
    private void m7075b() {
        if (!f10372l) {
            IMLog.m6631d(f10370a, "[handleAutoPlay] not in apollo.");
        } else if (f10373m < 1) {
            int sysAudioAutoPlayCount = IMPreference.getInstance(IMContextInfoHelper.getContext()).getSysAudioAutoPlayCount(IMContextInfoHelper.getUid());
            f10373m = sysAudioAutoPlayCount;
            if (sysAudioAutoPlayCount >= 1) {
                String str = f10370a;
                IMLog.m6631d(str, "[handleAutoPlay] #sp# reach max play count:" + f10373m);
            } else if (this.f10380i != null) {
                int i = sysAudioAutoPlayCount + 1;
                IMPreference.getInstance(IMContextInfoHelper.getContext()).setSysAudioAutoPlayCount(IMContextInfoHelper.getUid(), i);
                f10373m = i;
                traceCardCk(true);
                m7074a(this.f10380i.voice);
                IMLog.m6631d(f10370a, "[handleAutoPlay] start auto play...");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (this.message != null) {
            traceCardCk(false);
        }
        if (!this.f10381j) {
            m7074a(this.f10380i.voice);
        }
    }

    /* renamed from: a */
    private void m7074a(final String str) {
        if (str == null) {
            IMLog.m6637w(f10370a, C4234I.m6591t("[playAudio] fid = null"));
            return;
        }
        m7077c();
        try {
            IMAudioHelper.playFromUrl(getContext(), str, 1, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMSysAudioMsgRenderView.this.m7079e();
                    IMLog.m6631d(IMSysAudioMsgRenderView.f10370a, C4234I.m6591t("[playAudio] #onStarted# url=", str));
                }

                public void onCompletion() {
                    IMSysAudioMsgRenderView.this.m7080f();
                    IMLog.m6631d(IMSysAudioMsgRenderView.f10370a, C4234I.m6591t("[playAudio] #onCompletion# url=", str));
                }

                public void onError(String str) {
                    IMToastHelper.showShortError(IMSysAudioMsgRenderView.this.getContext(), IMSysAudioMsgRenderView.this.getContext().getString(R.string.bts_im_audio_play_fail));
                    IMLog.m6632e(IMSysAudioMsgRenderView.f10370a, C4234I.m6591t("[playAudio] #onError# url=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMSysAudioMsgRenderView.this.m7080f();
                    IMLog.m6631d(IMSysAudioMsgRenderView.f10370a, C4234I.m6591t("[playAudio] #onStop# url=", str));
                }
            });
        } catch (Exception e) {
            IMLog.m6632e(f10370a, "[playAudio]", e);
            m7078d();
        }
    }

    /* renamed from: c */
    private void m7077c() {
        this.f10381j = true;
        IMViewUtil.hide(this.f10376e);
        IMViewUtil.show(this.f10377f);
    }

    /* renamed from: d */
    private void m7078d() {
        this.f10381j = false;
        IMViewUtil.show(this.f10376e);
        IMViewUtil.hide(this.f10377f);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7079e() {
        m7078d();
        ((AnimationDrawable) this.f10376e.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m7080f() {
        m7078d();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f10376e.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    public void traceCardSw() {
        IMTraceUtil.BusinessParam addBusinessEvent = IMTraceUtil.addBusinessEvent("ddim_service_springholiday_kkcard_sw");
        IMRenderCardEnv iMRenderCardEnv = this.f10382k;
        IMTraceUtil.BusinessParam add = addBusinessEvent.add("order_id", iMRenderCardEnv != null ? iMRenderCardEnv.getOrderId() : "");
        IMRenderCardEnv iMRenderCardEnv2 = this.f10382k;
        add.add(iMRenderCardEnv2 != null ? iMRenderCardEnv2.getExtraTraceMap() : null).report();
    }

    public void traceCardCk(boolean z) {
        IMTraceUtil.BusinessParam addBusinessEvent = IMTraceUtil.addBusinessEvent("ddim_service_springholiday_kkcardhot_ck");
        IMRenderCardEnv iMRenderCardEnv = this.f10382k;
        IMTraceUtil.BusinessParam add = addBusinessEvent.add("order_id", iMRenderCardEnv != null ? iMRenderCardEnv.getOrderId() : "").add("is_auto_broadcast", Integer.valueOf(z ? 1 : 0));
        IMRenderCardEnv iMRenderCardEnv2 = this.f10382k;
        add.add(iMRenderCardEnv2 != null ? iMRenderCardEnv2.getExtraTraceMap() : null).report();
    }
}
