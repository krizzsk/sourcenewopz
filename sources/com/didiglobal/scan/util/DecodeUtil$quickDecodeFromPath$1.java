package com.didiglobal.scan.util;

import android.content.Context;
import android.net.Uri;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.util.ImageDecoder;
import com.didiglobal.scan.util.DecodeUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DecodeUtil.kt */
final class DecodeUtil$quickDecodeFromPath$1 implements Runnable {
    final /* synthetic */ DecodeUtil.DecodeCallback $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;

    DecodeUtil$quickDecodeFromPath$1(Context context, Uri uri, DecodeUtil.DecodeCallback decodeCallback) {
        this.$context = context;
        this.$uri = uri;
        this.$callback = decodeCallback;
    }

    public final void run() {
        DecodeUtil.INSTANCE.setDecoding(true);
        String path = FileUtil.getPath(this.$context, this.$uri);
        if (TextUtil.isEmpty(path)) {
            DecodeUtil.INSTANCE.setDecoding(false);
            DecodeUtil.DecodeCallback decodeCallback = this.$callback;
            if (decodeCallback != null) {
                decodeCallback.onError();
                return;
            }
            return;
        }
        DecodeUtil decodeUtil = DecodeUtil.INSTANCE;
        Context context = this.$context;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        File photoOutputFile = decodeUtil.getPhotoOutputFile(context);
        if (photoOutputFile != null) {
            if (photoOutputFile.exists()) {
                photoOutputFile.delete();
            }
            if (photoOutputFile == null) {
                Intrinsics.throwNpe();
            }
            String absolutePath = photoOutputFile.getAbsolutePath();
            FileUtil.copyFile(path, absolutePath);
            final String quickDecode = ImageDecoder.quickDecode(absolutePath);
            UiThreadHandler.getsUiHandler().post(new Runnable(this) {
                final /* synthetic */ DecodeUtil$quickDecodeFromPath$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    if (!TextUtil.isEmpty(quickDecode)) {
                        DecodeUtil.DecodeCallback decodeCallback = this.this$0.$callback;
                        if (decodeCallback != null) {
                            String str = quickDecode;
                            if (str == null) {
                                Intrinsics.throwNpe();
                            }
                            decodeCallback.onSuccess(str);
                        }
                    } else {
                        DecodeUtil.DecodeCallback decodeCallback2 = this.this$0.$callback;
                        if (decodeCallback2 != null) {
                            decodeCallback2.onError();
                        }
                    }
                    DecodeUtil.INSTANCE.setDecoding(false);
                }
            });
        }
    }
}
