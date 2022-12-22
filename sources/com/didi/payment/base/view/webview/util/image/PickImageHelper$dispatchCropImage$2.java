package com.didi.payment.base.view.webview.util.image;

import android.content.Intent;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PickImageHelper.kt */
final class PickImageHelper$dispatchCropImage$2 extends Lambda implements Function2<Integer, Intent, Unit> {
    final /* synthetic */ File $resultFile;
    final /* synthetic */ PickImageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PickImageHelper$dispatchCropImage$2(File file, PickImageHelper pickImageHelper) {
        super(2);
        this.$resultFile = file;
        this.this$0 = pickImageHelper;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (Intent) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Intent intent) {
        if (i != -1) {
            this.this$0.m21089d();
        } else if (!this.$resultFile.exists() || this.$resultFile.length() <= 0) {
            this.this$0.m21089d();
        } else {
            this.this$0.m21082a(Uri.fromFile(this.$resultFile), 0, 0);
        }
    }
}
