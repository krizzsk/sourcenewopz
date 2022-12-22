package com.didi.beatles.p099im.access.player;

import android.content.Context;
import android.media.AudioManager;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p099im.module.IIMMessageModule;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.impl.IMModelProvider;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.player.IMOpenPlayer */
public class IMOpenPlayer {

    /* renamed from: a */
    private static final String f8838a = "IMOpenPlayer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f8839b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final IMMessage f8840c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMOpenPlayerCallback f8841d;

    public IMOpenPlayer(Context context, IMMessage iMMessage) {
        this.f8839b = context;
        this.f8840c = iMMessage;
    }

    public void setCallback(IMOpenPlayerCallback iMOpenPlayerCallback) {
        this.f8841d = iMOpenPlayerCallback;
    }

    public void stop() {
        IMBtsAudioHelper.stopPlaying();
        IMBtsAudioHelper.releaseSensorModle();
    }

    public void play() {
        if (!IMEngine.getInstance(this.f8839b).hasInit()) {
            IMLog.m6632e(f8838a, C4234I.m6591t("[playAudio] im init fail"));
            IMOpenPlayerCallback iMOpenPlayerCallback = this.f8841d;
            if (iMOpenPlayerCallback != null) {
                iMOpenPlayerCallback.onError();
                return;
            }
            return;
        }
        IMBtsAudioHelper.initSensorModle((IMBtsAudioPlayer.onVoiceChannelChangeListener) null);
        String file_name = this.f8840c.getFile_name();
        boolean isRead = this.f8840c.isRead();
        if (IMTextUtil.isEmpty(file_name)) {
            if (IMManager.getInstance().getMessageModel() == null) {
                IMLog.m6632e(f8838a, C4234I.m6591t("[playAudio] NULL message model"));
                IMOpenPlayerCallback iMOpenPlayerCallback2 = this.f8841d;
                if (iMOpenPlayerCallback2 != null) {
                    iMOpenPlayerCallback2.onError();
                    return;
                }
                return;
            }
            IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            IMMessage iMMessage = this.f8840c;
            messageModel.loadAudioMessage(iMMessage, iMMessage.getSid(), new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    IMLog.m6631d(IMOpenPlayer.f8838a, C4234I.m6591t("[playAudio] #loadAudioMessage# Fid=", iMMessage.getFid(), " |status=", Integer.valueOf(i)));
                    if (i == 301) {
                        IMOpenPlayer.this.play();
                    } else if (IMOpenPlayer.this.f8841d != null) {
                        IMOpenPlayer.this.f8841d.onError();
                    }
                }
            });
        } else if (!new File(file_name).exists()) {
            IMLog.m6632e(f8838a, C4234I.m6591t("[playAudio] unable to find the audio file"));
            Context context = this.f8839b;
            SystemUtils.showToast(Toast.makeText(context, context.getString(R.string.bts_im_notfound_audio_file), 1));
            IMOpenPlayerCallback iMOpenPlayerCallback3 = this.f8841d;
            if (iMOpenPlayerCallback3 != null) {
                iMOpenPlayerCallback3.onError();
            }
        } else {
            if (!isRead && IMModelProvider.getInstance().getMessageModule() != null) {
                IMModelProvider.getInstance().getMessageModule().updateMessageAsync(this.f8840c);
            }
            m5907a();
            boolean z = this.f8840c.getSenderUid() == IMContextInfoHelper.getUid();
            if (!this.f8840c.isRead() && !z) {
                this.f8840c.setIsRead(true);
                IMMessageReadStatusManager.getInstance().addHasReadMsg(this.f8840c);
            }
            try {
                IMBtsAudioHelper.play(this.f8840c.getFile_name(), new IMBtsAudioPlayer.OnAudioPlayingListener() {
                    public void onStarted() {
                        IMLog.m6631d(IMOpenPlayer.f8838a, C4234I.m6591t("[playAudio] #onStarted# fid=", IMOpenPlayer.this.f8840c.getFid()));
                        if (IMOpenPlayer.this.f8841d != null) {
                            IMOpenPlayer.this.f8841d.onStart();
                        }
                    }

                    public void onCompletion() {
                        IMLog.m6631d(IMOpenPlayer.f8838a, C4234I.m6591t("[playAudio] #onCompletion# Fid=", IMOpenPlayer.this.f8840c.getFid()));
                        if (IMOpenPlayer.this.f8841d != null) {
                            IMOpenPlayer.this.f8841d.onCompletion();
                        }
                    }

                    public void onError(String str) {
                        IMToastHelper.showShortError(IMOpenPlayer.this.f8839b, IMOpenPlayer.this.f8839b.getString(R.string.bts_im_audio_play_fail));
                        IMLog.m6632e(IMOpenPlayer.f8838a, C4234I.m6591t("[playAudio] #onError# Fid=", IMOpenPlayer.this.f8840c.getFid(), " |FileName=", IMOpenPlayer.this.f8840c.getFile_name()));
                        if (IMOpenPlayer.this.f8841d != null) {
                            IMOpenPlayer.this.f8841d.onError();
                        }
                    }

                    public void onStop() {
                        IMLog.m6631d(IMOpenPlayer.f8838a, C4234I.m6591t("[playAudio] #onStop# Fid=", IMOpenPlayer.this.f8840c.getFid()));
                        if (IMOpenPlayer.this.f8841d != null) {
                            IMOpenPlayer.this.f8841d.onStop();
                        }
                    }
                });
            } catch (Exception e) {
                IMLog.m6632e(f8838a, "[playAudio]", e);
                IMOpenPlayerCallback iMOpenPlayerCallback4 = this.f8841d;
                if (iMOpenPlayerCallback4 != null) {
                    iMOpenPlayerCallback4.onError();
                }
            }
        }
    }

    /* renamed from: a */
    private void m5907a() {
        AudioManager audioManager = (AudioManager) this.f8839b.getSystemService("audio");
        if (audioManager != null) {
            int streamType = IMContextInfoHelper.getAudioConfig().getStreamType();
            int streamVolume = audioManager.getStreamVolume(streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(streamType);
            if (streamVolume == 0) {
                m5908a(R.drawable.bts_im_volume_tip, R.string.bts_im_audio_min_tip);
            } else if (((double) streamVolume) < ((double) streamMaxVolume) * 0.4d) {
                m5908a(R.drawable.im_volume_icon, R.string.bts_im_audio_min_tip);
            }
            IMLog.m6631d(f8838a, C4234I.m6591t(" [isAudioVoiceMin] currVolume=", Integer.valueOf(streamVolume), " |maxVolume=", Integer.valueOf(streamMaxVolume)));
        }
    }

    /* renamed from: a */
    private void m5908a(int i, int i2) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), i2, 0);
        SystemUtils.showToast(makeText);
        try {
            IMTipsToast.setIcon(makeText, i);
            IMTipsToast.setText(makeText, this.f8839b.getString(i2));
        } catch (Exception e) {
            IMLog.m6632e(f8838a, "[showTips]", e);
        }
    }
}
