package com.didichuxing.comp.telecom.core.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0006J\u001c\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper;", "", "()V", "TAG", "", "mIsReady", "", "mQueue", "Ljava/util/Deque;", "Lcom/didichuxing/comp/telecom/core/util/VoipTtsTask;", "mTts", "Landroid/speech/tts/TextToSpeech;", "mTtsListener", "com/didichuxing/comp/telecom/core/util/TtsServiceHelper$mTtsListener$1", "Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper$mTtsListener$1;", "addTask", "", "task", "checkQueueAndTryPlay", "clearTasks", "destroy", "innerPlay", "newTask", "play", "resId", "", "instant", "content", "stop", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TtsServiceHelper.kt */
public final class TtsServiceHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Lazy f46414f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TtsServiceHelper$Companion$sInstance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f46415a = "TtsServiceHelper";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f46416b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextToSpeech f46417c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TtsServiceHelper$mTtsListener$1 f46418d = new TtsServiceHelper$mTtsListener$1(this);

    /* renamed from: e */
    private final Deque<VoipTtsTask> f46419e;

    @JvmStatic
    public static final TtsServiceHelper getInstance() {
        return Companion.getInstance();
    }

    public TtsServiceHelper() {
        Locale locale;
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            Resources resources = appContext.getResources();
            if (Build.VERSION.SDK_INT >= 24) {
                Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
                Configuration configuration = resources.getConfiguration();
                Intrinsics.checkExpressionValueIsNotNull(configuration, "resources.configuration");
                locale = configuration.getLocales().get(0);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
                locale = resources.getConfiguration().locale;
            }
            TextToSpeech textToSpeech = new TextToSpeech(appContext, new TtsServiceHelper$$special$$inlined$let$lambda$1(this));
            this.f46417c = textToSpeech;
            if (!(locale == null || textToSpeech == null)) {
                textToSpeech.setLanguage(locale);
            }
        }
        this.f46419e = new LinkedList();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper;", "getSInstance", "()Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: TtsServiceHelper.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/core/util/TtsServiceHelper;"))};

        private final TtsServiceHelper getSInstance() {
            Lazy access$getSInstance$cp = TtsServiceHelper.f46414f;
            Companion companion = TtsServiceHelper.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (TtsServiceHelper) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TtsServiceHelper getInstance() {
            return getSInstance();
        }
    }

    public static /* synthetic */ void play$default(TtsServiceHelper ttsServiceHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        ttsServiceHelper.play(i, z);
    }

    public final void play(int i, boolean z) {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            String str = null;
            try {
                str = appContext.getString(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            play(str, z);
        }
    }

    public static /* synthetic */ void play$default(TtsServiceHelper ttsServiceHelper, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        ttsServiceHelper.play(str, z);
    }

    public final void play(String str, boolean z) {
        TextToSpeech textToSpeech = this.f46417c;
        if (!TextUtils.isEmpty(str) && textToSpeech != null) {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            VoipTtsTask voipTtsTask = new VoipTtsTask(str);
            if (z) {
                if (textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                }
                clearTasks();
                if (!this.f46416b) {
                    m33293b(voipTtsTask);
                } else {
                    m33292a(voipTtsTask);
                }
            } else if (!this.f46416b || textToSpeech.isSpeaking()) {
                m33293b(voipTtsTask);
            } else {
                m33292a(voipTtsTask);
            }
        }
    }

    public final void stop() {
        TextToSpeech textToSpeech = this.f46417c;
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop();
        }
    }

    public final void destroy() {
        stop();
        TextToSpeech textToSpeech = this.f46417c;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
        this.f46417c = null;
        this.f46416b = false;
    }

    /* renamed from: a */
    private final void m33292a(VoipTtsTask voipTtsTask) {
        TextToSpeech textToSpeech = this.f46417c;
        if (textToSpeech != null && this.f46416b) {
            Bundle bundle = new Bundle();
            bundle.putInt("streamType", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(voipTtsTask.hashCode());
            sb.append('}');
            textToSpeech.speak(voipTtsTask.getText(), 1, bundle, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33291a() {
        synchronized (this) {
            VoipTtsTask pollFirst = this.f46419e.pollFirst();
            if (pollFirst != null) {
                m33292a(pollFirst);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: b */
    private final void m33293b(VoipTtsTask voipTtsTask) {
        synchronized (this) {
            this.f46419e.addLast(voipTtsTask);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearTasks() {
        synchronized (this) {
            this.f46419e.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
