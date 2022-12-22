package p242io.flutter.plugin.platform;

import android.content.Context;
import p242io.flutter.plugin.common.MessageCodec;

/* renamed from: io.flutter.plugin.platform.PlatformViewFactory */
public abstract class PlatformViewFactory {

    /* renamed from: a */
    private final MessageCodec<Object> f57857a;

    public abstract PlatformView create(Context context, int i, Object obj);

    public PlatformViewFactory(MessageCodec<Object> messageCodec) {
        this.f57857a = messageCodec;
    }

    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.f57857a;
    }
}
