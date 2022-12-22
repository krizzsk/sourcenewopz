package com.didi.beatles.p099im.views.bottombar.recorder;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.audio.IMRecorderManager;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.IMAudioDialog;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p099im.views.bottombar.IMBottomSkinManager;
import com.didi.beatles.p099im.views.bottombar.IMConversationBottomBar;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderAdmin */
public class IMBtmRecorderAdmin implements IMBtmRecorder {

    /* renamed from: b */
    private static final int f10060b = 0;

    /* renamed from: c */
    private static final int f10061c = 1;

    /* renamed from: a */
    private final String f10062a = "IMBtmRecorderAdmin";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMConversationBottomBar f10063d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f10064e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f10065f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMBottomSkinManager f10066g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IMBaseBottomBar.BottomBarListener f10067h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f10068i = 1;

    /* renamed from: j */
    private String f10069j = null;

    /* renamed from: k */
    private IMRecorderManager.Callback f10070k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IMAudioDialog f10071l;

    /* renamed from: m */
    private View.OnTouchListener f10072m = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                IMBtmRecorderAdmin.this.f10064e.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
                IMBtmRecorderAdmin.this.f10064e.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMBtmRecorderAdmin.this.f10064e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_recording));
                IMBtmRecorderAdmin.this.f10065f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_voice));
                IMBtmRecorderAdmin.this.f10066g.showDisableSkin();
                IMBtmRecorderAdmin.this.m6845a();
            } else if (action == 1) {
                IMBtmRecorderAdmin.this.f10063d.resumeInitStatus();
                if (motionEvent.getY() < 0.0f) {
                    IMBtmRecorderAdmin.this.m6853c();
                } else {
                    IMBtmRecorderAdmin.this.m6851b();
                }
            } else if (action != 2) {
                if (action == 3) {
                    IMLog.m6631d("hkc", "cancel");
                    IMBtmRecorderAdmin.this.f10063d.resumeInitStatus();
                    IMBtmRecorderAdmin.this.m6853c();
                }
            } else if (motionEvent.getY() < 0.0f) {
                IMBtmRecorderAdmin.this.f10064e.setText(IMResource.getString(R.string.bts_im_record_cancle_tip));
                IMBtmRecorderAdmin.this.f10064e.setTextColor(IMResource.getColor(R.color.white));
                IMBtmRecorderAdmin.this.f10064e.setBackgroundResource(0);
                IMBtmRecorderAdmin.this.f10065f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_red));
                IMBtmRecorderAdmin.this.f10066g.showCancelSkin();
                IMBtmRecorderAdmin.this.m6854d();
            } else {
                IMBtmRecorderAdmin.this.f10064e.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
                IMBtmRecorderAdmin.this.f10064e.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMBtmRecorderAdmin.this.f10064e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_recording));
                IMBtmRecorderAdmin.this.f10065f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_voice));
                IMBtmRecorderAdmin.this.f10066g.showDisableSkin();
                IMBtmRecorderAdmin.this.m6856e();
            }
            return false;
        }
    };

    public boolean interceptBackPressed() {
        return false;
    }

    public void bindListener(TextView textView, IMBaseBottomBar iMBaseBottomBar) {
        this.f10064e = textView;
        IMConversationBottomBar iMConversationBottomBar = (IMConversationBottomBar) iMBaseBottomBar;
        this.f10063d = iMConversationBottomBar;
        this.f10065f = iMConversationBottomBar.mContentRootView;
        this.f10066g = iMConversationBottomBar.mSkinManager;
        this.f10067h = iMConversationBottomBar.mListener;
        this.f10071l = new IMAudioDialog((Activity) iMBaseBottomBar.context);
        textView.setOnTouchListener(this.f10072m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6845a() {
        IMLog.m6631d("IMBtmRecorderAdmin", this.f10068i + "");
        if (this.f10068i == 1) {
            this.f10068i = 0;
            IMBtsAudioHelper.stopPlaying();
            m6858f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6851b() {
        IMLog.m6631d("IMBtmRecorderAdmin", this.f10068i + "");
        if (this.f10068i == 0) {
            this.f10068i = 1;
            IMRecorderManager.getInstance().stop(this.f10069j, this.f10070k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6853c() {
        if (this.f10068i == 0) {
            this.f10068i = 1;
            IMRecorderManager.getInstance().cancel(this.f10069j, this.f10070k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6854d() {
        this.f10071l.setTip(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6856e() {
        this.f10071l.setTip(false);
    }

    /* renamed from: f */
    private void m6858f() {
        this.f10069j = IMRecorderManager.createFileId();
        this.f10070k = new IMRecorderManager.Callback() {
            public void onError(int i, String str) {
                if (i == 1) {
                    IMBtmRecorderAdmin.this.m6847a((int) R.drawable.im_toast_warm, str);
                    if (IMBtmRecorderAdmin.this.f10063d != null) {
                        IMLog.m6631d("hkc", "onError, resumeBar");
                        IMBtmRecorderAdmin.this.f10063d.resumeInitStatus();
                    }
                } else if (i == 2) {
                    IMBtmRecorderAdmin.this.m6846a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_audio_recorded_so_short);
                } else if (i != 3) {
                    IMLog.m6637w(C4234I.m6591t("startAudioRecorder errNo ", Integer.valueOf(i), " errMsg ", str), new Object[0]);
                } else {
                    IMBtmRecorderAdmin.this.m6846a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_record_error);
                }
            }

            public void onSuccess(String str, long j) {
                if (IMBtmRecorderAdmin.this.f10067h != null) {
                    IMBtmRecorderAdmin.this.f10067h.sendVoiceMessage(str, j);
                }
            }

            public void onStartRecord() {
                IMBtmRecorderAdmin.this.f10071l.show();
                IMBtmRecorderAdmin.this.f10071l.setTip(false);
            }

            public void onSoundLevelChange(int i) {
                if (IMBtmRecorderAdmin.this.f10068i == 0 && IMBtmRecorderAdmin.this.f10071l != null && IMBtmRecorderAdmin.this.f10071l.isShowing()) {
                    IMBtmRecorderAdmin.this.f10071l.changeBackGroundBySound(i);
                }
            }

            public void onResidueTimeChange(String str) {
                IMAudioDialog k = IMBtmRecorderAdmin.this.f10071l;
                k.showResidueTime(str + "");
            }

            public void onEndRecord() {
                if (IMBtmRecorderAdmin.this.f10071l != null) {
                    IMLog.m6631d("IMBtmRecorderAdmin", "dismiss");
                    IMBtmRecorderAdmin.this.f10071l.dissMissAudioDialog();
                }
            }
        };
        IMRecorderManager.getInstance().recorder(this.f10069j, this.f10070k);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6846a(int i, int i2) {
        m6847a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6847a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, i);
        IMTipsToast.setText(makeText, str);
    }
}
