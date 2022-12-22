package com.didichuxing.comp.telecom.core.util;

import android.media.MediaPlayer;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.util.MediaServiceHelper;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared", "com/didichuxing/comp/telecom/core/util/MediaServiceHelper$RingtonePlayTask$1$1"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.core.util.MediaServiceHelper$RingtonePlayTask$$special$$inlined$let$lambda$1 */
/* compiled from: MediaServiceHelper.kt */
final class C15233x695e14af implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ MediaPlayer.OnCompletionListener $callback$inlined;
    final /* synthetic */ boolean $needLoop$inlined;
    final /* synthetic */ int $streamType$inlined;
    final /* synthetic */ MediaServiceHelper.RingtonePlayTask this$0;

    C15233x695e14af(MediaServiceHelper.RingtonePlayTask ringtonePlayTask, int i, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
        this.this$0 = ringtonePlayTask;
        this.$streamType$inlined = i;
        this.$needLoop$inlined = z;
        this.$callback$inlined = onCompletionListener;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        CallLogUtil.logI(this.this$0.TAG, "media prepared");
    }
}
