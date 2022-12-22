package com.didiglobal.travel.biz.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.didi.component.business.util.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u001a-\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u001b\u0010\u0003\u001a\u0017\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0004¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u001a;\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u000b*\u00020\b*\u0004\u0018\u0001H\u000b2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\fH\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, mo175978d2 = {"glideRequest", "", "Landroid/view/View;", "block", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestManager;", "Lkotlin/ExtensionFunctionType;", "withGlide", "Landroid/widget/ImageView;", "Lcom/bumptech/glide/RequestBuilder;", "withGlideRequest", "T", "Lkotlin/Function2;", "(Landroid/widget/ImageView;Lkotlin/jvm/functions/Function2;)V", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlideUtils.kt */
public final class GlideUtilsKt {
    public static final void glideRequest(View view, Function1<? super RequestManager, Unit> function1) {
        RequestManager with;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Context context = view.getContext();
        if (!(!Utils.isDestroy(context))) {
            context = null;
        }
        if (context != null && (with = Glide.with(context)) != null) {
            function1.invoke(with);
        }
    }

    public static final void withGlide(ImageView imageView, Function1<? super RequestManager, ? extends RequestBuilder<?>> function1) {
        RequestManager with;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Context context = imageView.getContext();
        if (!(!Utils.isDestroy(context))) {
            context = null;
        }
        if (context != null && (with = Glide.with(context)) != null) {
            ((RequestBuilder) function1.invoke(with)).into(imageView);
        }
    }

    public static final <T extends ImageView> void withGlideRequest(T t, Function2<? super RequestManager, ? super T, Unit> function2) {
        RequestManager with;
        Intrinsics.checkNotNullParameter(function2, "block");
        if (t != null) {
            Context context = t.getContext();
            if (!(!Utils.isDestroy(context))) {
                context = null;
            }
            if (context != null && (with = Glide.with(context)) != null) {
                function2.invoke(with, t);
            }
        }
    }
}
