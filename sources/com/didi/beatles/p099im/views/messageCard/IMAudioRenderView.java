package com.didi.beatles.p099im.views.messageCard;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.impl.IMModelProvider;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.resource.IMThemeConstant;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMRTLUtils;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.List;
import kotlin.text.Typography;

/* renamed from: com.didi.beatles.im.views.messageCard.IMAudioRenderView */
public class IMAudioRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private static final int f10303a = 0;

    /* renamed from: b */
    private static final int f10304b = 1;

    /* renamed from: c */
    private static final int f10305c = 2;

    /* renamed from: d */
    private static final int f10306d = 3;

    /* renamed from: e */
    private View f10307e;

    /* renamed from: f */
    private View f10308f;

    /* renamed from: g */
    private View f10309g;

    /* renamed from: h */
    private TextView f10310h;

    /* renamed from: i */
    private boolean f10311i;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMAudioRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            return this.inflater.inflate(this.isMine ? R.layout.bts_im_mine_audio_message_item_global_psg : R.layout.bts_im_other_audio_message_item_global_psg, viewGroup, false);
        }
        return this.inflater.inflate(this.isMine ? R.layout.bts_im_mine_audio_message_item : R.layout.bts_im_other_audio_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10307e = findViewById(R.id.message_layout);
        this.f10308f = findViewById(R.id.audio_antt_view);
        this.f10310h = (TextView) findViewById(R.id.audio_duration);
        this.f10309g = findViewById(R.id.audio_unread_notify);
        if (this.isMine) {
            this.f10307e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_black_bubble_selector));
            return;
        }
        this.f10307e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        this.f10307e.setPadding(IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 10.0f), IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 10.0f));
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        this.adapter.audioRenderViewStore.add(this);
        if (IMStyleManager.getCurBusinessStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            this.f10308f.setBackgroundResource(this.isMine ? R.anim.bts_im_voice_play_mine : R.anim.bts_im_voice_play_other);
        } else if ((this.f10308f instanceof LottieAnimationView) && !this.f10311i) {
            if (this.isMine) {
                if (IMRTLUtils.isRTLLayout()) {
                    ((LottieAnimationView) this.f10308f).setAnimation("im/im_audio_play_mine_global_rtl_psg.json");
                } else {
                    ((LottieAnimationView) this.f10308f).setAnimation("im/im_audio_play_mine_global_psg.json");
                }
            } else if (IMRTLUtils.isRTLLayout()) {
                ((LottieAnimationView) this.f10308f).setAnimation("im/im_audio_play_other_global_rtl_psg.json");
            } else {
                ((LottieAnimationView) this.f10308f).setAnimation("im/im_audio_play_other_global_psg.json");
            }
            ((LottieAnimationView) this.f10308f).setRepeatCount(-1);
            this.f10311i = true;
        }
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getSidType(), this.message.getBusinessId());
        if (this.isMine) {
            if (currentBusinessConfig.isUber()) {
                this.f10307e.setBackgroundResource(R.drawable.ub_other_imme_right_bg);
            } else if (currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG) != -1) {
                this.f10307e.setBackgroundResource(currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG));
            }
        }
        int sec = this.message.getSec();
        if (sec <= 0) {
            sec = 1;
        }
        TextView textView = this.f10310h;
        textView.setText(String.valueOf(sec) + Typography.quote);
        if (this.contentLayout != null) {
            this.contentLayout.setContentDescription(String.format(IMResource.getString(R.string.im_accessibility_audio_sencond), new Object[]{Integer.valueOf(sec)}));
        }
        int audioBkSize = IMCommonUtil.getAudioBkSize(sec, this.context);
        if (audioBkSize < IMViewUtil.dp2px(this.context, 70.0f)) {
            audioBkSize = IMViewUtil.dp2px(this.context, 70.0f);
        }
        if (audioBkSize > IMViewUtil.dp2px(this.context, 250.0f)) {
            audioBkSize = IMViewUtil.dp2px(this.context, 250.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10307e.getLayoutParams();
        layoutParams.width = audioBkSize;
        if (this.adapter.isUberMode && this.isMine) {
            this.f10307e.setBackgroundResource(R.drawable.ub_other_imme_right_bg);
        }
        this.f10307e.setLayoutParams(layoutParams);
        m7037f();
        if (!this.isMine) {
            getMessageFailed().setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        mo44285a(this.message);
    }

    /* renamed from: a */
    private static void m7025a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamType = IMContextInfoHelper.getAudioConfig().getStreamType();
            int streamVolume = audioManager.getStreamVolume(streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(streamType);
            if (streamVolume == 0) {
                m7026a(context, (int) R.drawable.bts_im_volume_tip, (int) R.string.bts_im_audio_min_tip);
            } else if (((double) streamVolume) < ((double) streamMaxVolume) * 0.4d) {
                m7026a(context, (int) R.drawable.im_volume_icon, (int) R.string.bts_im_audio_min_tip);
            }
            IMLog.m6631d(TAG, C4234I.m6591t(" [isAudioVoiceMin] currVolume=", Integer.valueOf(streamVolume), " |maxVolume=", Integer.valueOf(streamMaxVolume)));
        }
    }

    /* renamed from: a */
    private static void m7026a(Context context, int i, int i2) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), i2, 0);
        SystemUtils.showToast(makeText);
        try {
            IMTipsToast.setIcon(makeText, i);
            IMTipsToast.setText(makeText, context.getString(i2));
        } catch (Exception e) {
            IMLog.m6632e(TAG, "[showTips]", e);
        }
    }

    public void startAnimation() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            View view = this.f10308f;
            if ((view instanceof LottieAnimationView) && !((LottieAnimationView) view).isAnimating()) {
                ((LottieAnimationView) this.f10308f).playAnimation();
                return;
            }
            return;
        }
        ((AnimationDrawable) this.f10308f.getBackground()).start();
    }

    public void stopAnimation() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            View view = this.f10308f;
            if ((view instanceof LottieAnimationView) && ((LottieAnimationView) view).isAnimating()) {
                ((LottieAnimationView) this.f10308f).cancelAnimation();
                ((LottieAnimationView) this.f10308f).setProgress(0.0f);
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f10308f.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    /* renamed from: a */
    private void m7024a() {
        if (this.isMine) {
            this.f10309g.setVisibility(8);
        } else {
            this.f10309g.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m7030b() {
        this.f10309g.setVisibility(8);
    }

    /* renamed from: c */
    private void m7033c() {
        this.f10309g.setVisibility(8);
        getLoadingProgressBar().setVisibility(0);
    }

    /* renamed from: d */
    private void m7035d() {
        this.f10309g.setVisibility(8);
        getLoadingProgressBar().setVisibility(8);
        if (!this.isMine) {
            getMessageFailed().setVisibility(8);
        }
    }

    /* renamed from: e */
    private void m7036e() {
        this.f10309g.setVisibility(8);
        getLoadingProgressBar().setVisibility(8);
        getMessageFailed().setVisibility(0);
    }

    /* renamed from: f */
    private void m7037f() {
        int i;
        Integer num = this.adapter.audioRenderStatusStore.get(Long.valueOf(this.message.getMid()));
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        if (i == 1) {
            m7033c();
            stopAnimation();
            m7030b();
        } else if (i == 2) {
            m7036e();
            stopAnimation();
            m7030b();
        } else if (i != 3) {
            m7035d();
            stopAnimation();
            if (this.message.isRead()) {
                m7030b();
            } else {
                m7024a();
            }
        } else {
            m7035d();
            startAnimation();
            m7030b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7027a(IMMessage iMMessage, Integer num) {
        IMLog.m6631d(TAG, C4234I.m6591t("[playAudio] updatePlayStatus ", Long.valueOf(iMMessage.getMid()), " ", num));
        this.adapter.audioRenderStatusStore.put(Long.valueOf(iMMessage.getMid()), num);
        if (iMMessage.getMid() == this.message.getMid()) {
            m7037f();
            return;
        }
        for (IMAudioRenderView next : this.adapter.audioRenderViewStore) {
            if (next.message.getMid() == iMMessage.getMid()) {
                next.m7037f();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44285a(final IMMessage iMMessage) {
        if (!IMTextUtil.isEmpty(iMMessage.getFile_name())) {
            m7031b(iMMessage);
        } else if (IMManager.getInstance().getMessageModel() == null) {
            IMLog.m6632e(TAG, C4234I.m6591t("[playAudio] NULL message model"));
        } else {
            m7027a(iMMessage, (Integer) 1);
            IMManager.getInstance().getMessageModel().loadAudioMessage(iMMessage, iMMessage.getSid(), new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    IMLog.m6631d(IMBaseRenderView.TAG, C4234I.m6591t("[playAudio] #loadAudioMessage# Fid=", iMMessage.getFid(), " |status=", Integer.valueOf(i)));
                    if (i == 301) {
                        IMAudioRenderView.this.m7031b(iMMessage);
                    } else {
                        IMAudioRenderView.this.m7027a(iMMessage, (Integer) 2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7031b(final IMMessage iMMessage) {
        String file_name = iMMessage.getFile_name();
        boolean z = iMMessage.getSenderUid() == IMContextInfoHelper.getUid();
        boolean isRead = iMMessage.isRead();
        if (!new File(file_name).exists()) {
            IMLog.m6632e(TAG, C4234I.m6591t("[playAudio] unable to find the audio file"));
            SystemUtils.showToast(Toast.makeText(this.context, this.context.getString(R.string.bts_im_notfound_audio_file), 1));
            m7027a(iMMessage, (Integer) 0);
            return;
        }
        if (!isRead && IMModelProvider.getInstance().getMessageModule() != null) {
            IMModelProvider.getInstance().getMessageModule().updateMessageAsync(iMMessage);
        }
        m7025a(this.context);
        if (!iMMessage.isRead() && !z) {
            iMMessage.setIsRead(true);
            m7027a(iMMessage, this.adapter.audioRenderStatusStore.get(Long.valueOf(iMMessage.getMid())));
            IMMessageReadStatusManager.getInstance().addHasReadMsg(iMMessage);
        }
        try {
            IMBtsAudioHelper.play(iMMessage.getFile_name(), new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMAudioRenderView.this.m7027a(iMMessage, (Integer) 3);
                    IMLog.m6631d(IMBaseRenderView.TAG, C4234I.m6591t("[playAudio] #onStarted# fid=", iMMessage.getFid()));
                }

                public void onCompletion() {
                    IMAudioRenderView.this.m7027a(iMMessage, (Integer) 0);
                    IMLog.m6631d(IMBaseRenderView.TAG, C4234I.m6591t("[playAudio] #onCompletion# Fid=", iMMessage.getFid()));
                    IMAudioRenderView.this.m7034c(iMMessage);
                    IMAudioRenderView.this.adapter.notifyDataSetChanged();
                }

                public void onError(String str) {
                    IMAudioRenderView.this.m7027a(iMMessage, (Integer) 0);
                    IMToastHelper.showShortError(IMAudioRenderView.this.context, IMAudioRenderView.this.context.getString(R.string.bts_im_audio_play_fail));
                    IMLog.m6632e(IMBaseRenderView.TAG, C4234I.m6591t("[playAudio] #onError# Fid=", iMMessage.getFid(), " |FileName=", iMMessage.getFile_name()));
                }

                public void onStop() {
                    IMAudioRenderView.this.m7027a(iMMessage, (Integer) 0);
                    IMLog.m6631d(IMBaseRenderView.TAG, C4234I.m6591t("[playAudio] #onStop# Fid=", iMMessage.getFid()));
                }
            });
        } catch (Exception e) {
            m7027a(iMMessage, (Integer) 0);
            IMLog.m6632e(TAG, "[playAudio]", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7034c(IMMessage iMMessage) {
        IMMessage itemNext = this.adapter.getItemNext(iMMessage);
        if (itemNext != null) {
            boolean z = itemNext.getSenderUid() == IMContextInfoHelper.getUid();
            if (itemNext.getType() == 131072 && !itemNext.isRead() && !z) {
                try {
                    itemNext.setIsRead(true);
                    IMMessageReadStatusManager.getInstance().addHasReadMsg(itemNext);
                    mo44285a(itemNext);
                } catch (Exception e) {
                    IMLog.m6632e(TAG, "[playNextAudio]", e);
                }
            }
        }
    }
}
