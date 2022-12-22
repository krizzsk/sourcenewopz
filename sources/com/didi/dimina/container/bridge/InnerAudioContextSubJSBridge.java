package com.didi.dimina.container.bridge;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.MediaPlayerManager;
import com.didi.dimina.container.util.ViewUtil;
import com.didi.sdk.component.search.city.p148db.DIDIDbTables;
import com.didi.soda.blocks.constant.Const;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class InnerAudioContextSubJSBridge {

    /* renamed from: a */
    private static final String f16579a = "InnerAudioContext";

    /* renamed from: b */
    private static final NetworkService f16580b = Dimina.getConfig().getAdapterConfig().getHttpService();

    /* renamed from: c */
    private final String f16581c = (FileUtil.getDownloadDir() + File.separator + "Audio" + File.separator);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MediaPlayerManager f16582d;

    /* renamed from: e */
    private final DMMina f16583e;

    /* renamed from: f */
    private String f16584f = "";

    /* renamed from: g */
    private boolean f16585g = false;

    /* renamed from: h */
    private Long f16586h = 0L;

    /* renamed from: i */
    private Long f16587i = 0L;

    /* renamed from: j */
    private Long f16588j = 0L;

    /* renamed from: k */
    private boolean f16589k = false;

    /* renamed from: l */
    private boolean f16590l = false;

    /* renamed from: m */
    private boolean f16591m = false;

    /* renamed from: n */
    private final float f16592n = 1.0f;

    /* renamed from: o */
    private final Integer f16593o = 0;

    /* renamed from: p */
    private String f16594p = "";

    /* renamed from: q */
    private String f16595q = "";

    /* renamed from: r */
    private final long f16596r = 200;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Set<String> f16597s = new HashSet();

    public InnerAudioContextSubJSBridge(DMMina dMMina) {
        LogUtil.m13408d(f16579a, "InnerAudioContextSubJSBridge init ");
        this.f16583e = dMMina;
        this.f16582d = new MediaPlayerManager();
    }

    public void updateAudioState(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13408d(f16579a, "updateAudioState " + jSONObject);
        this.f16584f = jSONObject.optString("audioId");
        this.f16585g = jSONObject.optBoolean("paused");
        this.f16586h = Long.valueOf(jSONObject.optLong(DIDIDbTables.BaseSideBarNewColumn.START_TIME));
        this.f16587i = Long.valueOf(jSONObject.optLong("currentTime"));
        this.f16588j = Long.valueOf(jSONObject.optLong("duration"));
        this.f16589k = jSONObject.optBoolean("obeyMuteSwitch");
        this.f16590l = jSONObject.optBoolean("autoplay");
        this.f16591m = jSONObject.optBoolean("loop");
        this.f16594p = jSONObject.optString(Const.BlockParamConst.SRC);
    }

    public void play(JSONObject jSONObject, CallbackFunction callbackFunction) {
        updateAudioState(jSONObject, callbackFunction);
        final String str = this.f16581c + FileUtil.getFileName(this.f16594p);
        LogUtil.m13408d(f16579a, "filePath " + str);
        if (m12201a(str)) {
            LogUtil.m13408d(f16579a, "音频文件已经存在");
            onPlay(str);
        } else {
            LogUtil.m13408d(f16579a, "音频文件不存在，开始下载");
            final String str2 = this.f16594p;
            if (this.f16597s.contains(str2)) {
                LogUtil.m13408d(f16579a, "已经在下载音频url：" + str2);
                return;
            }
            this.f16597s.add(str2);
            m12200a(this.f16594p, str, new NetworkService.ITaskCallback() {
                public void onFailure(Exception exc) {
                    LogUtil.m13408d(InnerAudioContextSubJSBridge.f16579a, "downloadFile onFailure " + exc.toString());
                    InnerAudioContextSubJSBridge.this.f16597s.remove(str2);
                    InnerAudioContextSubJSBridge.this.onPlay(str2);
                }

                public void onSuccess(JSONObject jSONObject) {
                    LogUtil.m13408d(InnerAudioContextSubJSBridge.f16579a, "downloadFile onSuccess");
                    InnerAudioContextSubJSBridge.this.f16597s.remove(str2);
                    InnerAudioContextSubJSBridge.this.onPlay(str);
                }
            });
        }
        this.f16582d.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                LogUtil.m13408d(InnerAudioContextSubJSBridge.f16579a, "onCompletion stopPlay " + InnerAudioContextSubJSBridge.this.f16582d.isPlaying());
                InnerAudioContextSubJSBridge.this.onEnded();
            }
        });
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void onPlay(String str) {
        if (!TextUtils.equals(this.f16595q, str) || !ViewUtil.isFastDoubleInvoke(200)) {
            this.f16595q = str;
            this.f16582d.startPlay(str, new MediaPlayerManager.OnMusicStartPlayListener() {
                public final void onStartPlay() {
                    InnerAudioContextSubJSBridge.this.m12199a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12199a() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onPlay");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f16584f);
        this.f16583e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void onEnded() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onEnded");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f16584f);
        this.f16583e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void onStop() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "emitFunctionName", (Object) "onStop");
        JSONUtil.put(jSONObject, "audioId", (Object) this.f16584f);
        this.f16583e.getMessageTransfer().sendMessageToServiceFromNative("audioInstanceStateChanged", new MessageWrapperBuilder().data(jSONObject).build());
    }

    public void stop(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f16582d.stopPlay();
        onStop();
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void onDestroy() {
        MediaPlayerManager mediaPlayerManager = this.f16582d;
        if (mediaPlayerManager != null) {
            mediaPlayerManager.stopPlay();
            this.f16582d.release();
        }
    }

    /* renamed from: a */
    private void m12200a(String str, String str2, NetworkService.ITaskCallback iTaskCallback) {
        NetworkService.NetworkTaskModel.Download download = new NetworkService.NetworkTaskModel.Download();
        download.url = str;
        download.timeout = 3000;
        download.filePath = str2;
        f16580b.downloadFile(download, iTaskCallback);
    }

    /* renamed from: a */
    private boolean m12201a(String str) {
        File file = new File(this.f16581c);
        File file2 = new File(str);
        if (file.exists() && file2.exists()) {
            return true;
        }
        FileUtil.mkdirs(this.f16581c);
        return false;
    }
}
