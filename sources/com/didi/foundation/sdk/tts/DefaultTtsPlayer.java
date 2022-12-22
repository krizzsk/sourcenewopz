package com.didi.foundation.sdk.tts;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.util.HashMap;

@ServiceProvider({IAudio.class})
public class DefaultTtsPlayer extends AbstractAudio implements TextToSpeech.OnInitListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f21361a = LogService.getLogger(DefaultTtsPlayer.class.getSimpleName());

    /* renamed from: b */
    private TextToSpeech f21362b;

    /* renamed from: c */
    private volatile boolean f21363c = false;

    /* renamed from: d */
    private IPlayListener f21364d;

    /* renamed from: e */
    private OnCompleteListener f21365e = new OnCompleteListener();

    public void resumeSpeaking() {
    }

    public void init(IPlayListener iPlayListener, Context context) {
        this.f21364d = iPlayListener;
        this.f21362b = new TextToSpeech(context, this);
    }

    public boolean isPlaying() {
        return this.f21362b.isSpeaking();
    }

    public void onCompleted() {
        IPlayListener iPlayListener = this.f21364d;
        if (iPlayListener != null) {
            iPlayListener.onCompleted();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ Exception -> 0x000a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c0 A[Catch:{ Exception -> 0x000a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInit(int r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x000d
            android.speech.tts.TextToSpeech r6 = r5.f21362b     // Catch:{ Exception -> 0x000a }
            if (r6 == 0) goto L_0x000d
            r6 = 1
            goto L_0x000e
        L_0x000a:
            r6 = move-exception
            goto L_0x00ca
        L_0x000d:
            r6 = 0
        L_0x000e:
            r5.f21363c = r6     // Catch:{ Exception -> 0x000a }
            if (r6 == 0) goto L_0x00c0
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r2 = "Initialize TTS success"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x000a }
            android.app.Application r6 = com.didi.foundation.sdk.application.FoundationApplicationListener.getApplication()     // Catch:{ Exception -> 0x000a }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x000a }
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch:{ Exception -> 0x000a }
            java.util.Locale r6 = r6.locale     // Catch:{ Exception -> 0x000a }
            if (r6 == 0) goto L_0x006a
            com.didi.sdk.logging.Logger r2 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000a }
            r3.<init>()     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = "tts isLanguageAvailable "
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            android.speech.tts.TextToSpeech r4 = r5.f21362b     // Catch:{ Exception -> 0x000a }
            int r4 = r4.isLanguageAvailable(r6)     // Catch:{ Exception -> 0x000a }
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = "; variant is "
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = r6.getVariant()     // Catch:{ Exception -> 0x000a }
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = "; locale is "
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            r3.append(r6)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = " ; country  is "
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            java.lang.String r4 = r6.getCountry()     // Catch:{ Exception -> 0x000a }
            r3.append(r4)     // Catch:{ Exception -> 0x000a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x000a }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r2.info((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x000a }
        L_0x006a:
            android.speech.tts.TextToSpeech r2 = r5.f21362b     // Catch:{ Exception -> 0x000a }
            if (r6 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x000a }
        L_0x0073:
            int r6 = r2.setLanguage(r6)     // Catch:{ Exception -> 0x000a }
            r2 = -2
            if (r6 == r2) goto L_0x00b6
            r2 = -1
            if (r6 == r2) goto L_0x00ac
            if (r6 == 0) goto L_0x00a2
            if (r6 == r0) goto L_0x0098
            r0 = 2
            if (r6 == r0) goto L_0x008e
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Unknown error"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x008e:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Language country var available"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x0098:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Language country available"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x00a2:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Language available"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x00ac:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Language missing data"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x00b6:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "TTS set language: Language not supported"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x00c0:
            com.didi.sdk.logging.Logger r6 = r5.f21361a     // Catch:{ Exception -> 0x000a }
            java.lang.String r0 = "Initialize TTS error"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000a }
            r6.info((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x000a }
            goto L_0x00de
        L_0x00ca:
            r6.printStackTrace()
            com.didi.sdk.logging.Logger r0 = r5.f21361a
            java.lang.String r2 = r6.getMessage()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.info((java.lang.String) r2, (java.lang.Object[]) r1)
            java.lang.String r0 = "tts"
            r5.m15702a(r0, r6)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.tts.DefaultTtsPlayer.onInit(int):void");
    }

    public void pause() {
        this.f21362b.stop();
    }

    public void play(PlayData playData) {
        synchronized (this.f21362b) {
            if (this.f21362b.isSpeaking()) {
                this.f21362b.stop();
            }
            this.f21362b.setOnUtteranceProgressListener(this.f21365e);
            HashMap hashMap = new HashMap();
            hashMap.put("utteranceId", playData.getTts());
            this.f21362b.speak(playData.getTts(), 0, hashMap);
        }
    }

    public void release() {
        this.f21362b.shutdown();
        this.f21363c = false;
    }

    public void stop() {
        this.f21362b.stop();
    }

    /* renamed from: a */
    private void m15702a(String str, Throwable th) {
        try {
            Tracker.trackError(str, th);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final class OnCompleteListener extends UtteranceProgressListener {
        public void onStart(String str) {
        }

        OnCompleteListener() {
        }

        public void onDone(String str) {
            DefaultTtsPlayer.this.f21361a.info("TTSPlayer OnCompleteListener onDone", new Object[0]);
            DefaultTtsPlayer.this.onCompleted();
        }

        public void onError(String str) {
            DefaultTtsPlayer.this.f21361a.info("TTSPlayer OnCompleteListener onError", new Object[0]);
            DefaultTtsPlayer.this.onCompleted();
        }
    }
}
