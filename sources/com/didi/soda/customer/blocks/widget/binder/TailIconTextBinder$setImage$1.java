package com.didi.soda.customer.blocks.widget.binder;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.soda.business.widget.TailIconTextView;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.taxis99.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/soda/customer/blocks/widget/binder/TailIconTextBinder$setImage$1", "Lcom/didi/app/nova/skeleton/image/ImageDownloadListener;", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "file", "Ljava/io/File;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TailIconTextBinder.kt */
public final class TailIconTextBinder$setImage$1 implements ImageDownloadListener {
    final /* synthetic */ String $text;
    final /* synthetic */ TailIconTextBinder this$0;

    TailIconTextBinder$setImage$1(TailIconTextBinder tailIconTextBinder, String str) {
        this.this$0 = tailIconTextBinder;
        this.$text = str;
    }

    public void onSuccess(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        UiHandlerUtil.post(new Runnable(this.$text, new BitmapDrawable(BitmapUtil.convertFileToBitmap(file))) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ BitmapDrawable f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                TailIconTextBinder$setImage$1.m46887onSuccess$lambda0(TailIconTextBinder.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m46887onSuccess$lambda0(TailIconTextBinder tailIconTextBinder, String str, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(tailIconTextBinder, "this$0");
        Intrinsics.checkNotNullParameter(str, "$text");
        Intrinsics.checkNotNullParameter(bitmapDrawable, "$drawable");
        View view = tailIconTextBinder.getView();
        TailIconTextView tailIconTextView = view instanceof TailIconTextView ? (TailIconTextView) view : null;
        if (tailIconTextView != null) {
            tailIconTextView.setTextTail(str, bitmapDrawable);
        }
    }

    public void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        UiHandlerUtil.post(new Runnable(this.$text) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                TailIconTextBinder$setImage$1.m46886onFailure$lambda1(TailIconTextBinder.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m46886onFailure$lambda1(TailIconTextBinder tailIconTextBinder, String str) {
        Intrinsics.checkNotNullParameter(tailIconTextBinder, "this$0");
        Intrinsics.checkNotNullParameter(str, "$text");
        Drawable drawable = tailIconTextBinder.getContext().getResources().getDrawable(R.drawable.customer_skin_img_business_goods_item_x11);
        View view = tailIconTextBinder.getView();
        TailIconTextView tailIconTextView = view instanceof TailIconTextView ? (TailIconTextView) view : null;
        if (tailIconTextView != null) {
            tailIconTextView.setTextTail(str, drawable);
        }
    }
}
