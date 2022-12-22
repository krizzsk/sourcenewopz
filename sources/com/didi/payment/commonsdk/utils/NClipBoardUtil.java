package com.didi.payment.commonsdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NClipBoardUtil;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NClipBoardUtil.kt */
public final class NClipBoardUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void clearClipboard(Context context) {
        Companion.clearClipboard(context);
    }

    @JvmStatic
    public static final String getClipboardText(Context context) {
        return Companion.getClipboardText(context);
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NClipBoardUtil$Companion;", "", "()V", "clearClipboard", "", "context", "Landroid/content/Context;", "getClipboardText", "", "setClipboard", "text", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NClipBoardUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setClipboard(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "text");
            Object systemService = context.getSystemService("clipboard");
            if (systemService != null) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }

        @JvmStatic
        public final String getClipboardText(Context context) {
            ClipData.Item itemAt;
            ClipData clipData = null;
            Object systemService = context == null ? null : context.getSystemService("clipboard");
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager != null) {
                try {
                    clipData = clipboardManager.getPrimaryClip();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            boolean z = true;
            if (clipboardManager == null || !clipboardManager.hasPrimaryClip()) {
                z = false;
            }
            if (!z || clipData == null || clipData.getItemCount() <= 0 || (itemAt = clipData.getItemAt(0)) == null || itemAt.getText() == null) {
                return "";
            }
            return itemAt.getText().toString();
        }

        @JvmStatic
        public final void clearClipboard(Context context) {
            ClipboardManager clipboardManager = null;
            Object systemService = context == null ? null : context.getSystemService("clipboard");
            if (systemService instanceof ClipboardManager) {
                clipboardManager = (ClipboardManager) systemService;
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (clipboardManager != null) {
                        clipboardManager.clearPrimaryClip();
                    }
                } else if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
