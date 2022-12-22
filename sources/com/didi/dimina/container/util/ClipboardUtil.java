package com.didi.dimina.container.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/dimina/container/util/ClipboardUtil;", "", "()V", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ClipboardUtil.kt */
public final class ClipboardUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void setClipboardData(Context context, String str) {
        Companion.setClipboardData(context, str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/util/ClipboardUtil$Companion;", "", "()V", "setClipboardData", "", "ctx", "Landroid/content/Context;", "content", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ClipboardUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void setClipboardData(Context context, String str) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            if (str != null) {
                Object systemService = context.getSystemService("clipboard");
                if (systemService != null) {
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText((CharSequence) null, str));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
        }
    }
}
