package com.didiglobal.scan.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/scan/util/DecodeUtil;", "", "()V", "isDecoding", "", "()Z", "setDecoding", "(Z)V", "getPhotoOutputFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "quickDecodeFromPath", "", "uri", "Landroid/net/Uri;", "callback", "Lcom/didiglobal/scan/util/DecodeUtil$DecodeCallback;", "DecodeCallback", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DecodeUtil.kt */
public final class DecodeUtil {
    public static final DecodeUtil INSTANCE = new DecodeUtil();

    /* renamed from: a */
    private static boolean f51364a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/scan/util/DecodeUtil$DecodeCallback;", "", "onError", "", "onSuccess", "str", "", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DecodeUtil.kt */
    public interface DecodeCallback {
        void onError();

        void onSuccess(String str);
    }

    private DecodeUtil() {
    }

    public final boolean isDecoding() {
        return f51364a;
    }

    public final void setDecoding(boolean z) {
        f51364a = z;
    }

    public static /* synthetic */ void quickDecodeFromPath$default(DecodeUtil decodeUtil, Context context, Uri uri, DecodeCallback decodeCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            decodeCallback = null;
        }
        decodeUtil.quickDecodeFromPath(context, uri, decodeCallback);
    }

    public final void quickDecodeFromPath(Context context, Uri uri, DecodeCallback decodeCallback) {
        if (!f51364a) {
            if ((uri == null || context == null) && decodeCallback != null) {
                decodeCallback.onError();
            }
            try {
                new Thread(new DecodeUtil$quickDecodeFromPath$1(context, uri, decodeCallback)).start();
            } catch (Exception e) {
                e.printStackTrace();
                if (decodeCallback != null) {
                    decodeCallback.onError();
                }
                f51364a = false;
            }
        }
    }

    public final File getPhotoOutputFile(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new File(context.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "IMG_SCAN.jpg");
    }
}
