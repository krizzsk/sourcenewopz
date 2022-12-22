package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.style.BlockLayout;
import com.didi.soda.blocks.style.DynamicContainerBinder;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.utils.DPUtil;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@WidgetNameMeta(widgetName = "TouchableMask")
@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH\u0016J0\u0010\u000e\u001a\u00020\b2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/TouchableMaskBinder;", "Lcom/didi/soda/blocks/style/DynamicContainerBinder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "maskColor", "", "bindProps", "", "props", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "bindStyles", "styles", "convert2Num", "", "num", "isDPStyle", "", "createView", "Lcom/didi/soda/blocks/style/BlockLayout;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TouchableMaskBinder.kt */
public final class TouchableMaskBinder extends DynamicContainerBinder {

    /* renamed from: a */
    private int f40765a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchableMaskBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public BlockLayout createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new BlockLayoutWrap(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        super.bindProps(hashMap);
        if (hashMap != null) {
            Object obj = hashMap.get("maskColor");
            String obj2 = obj == null ? null : obj.toString();
            CharSequence charSequence = obj2;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0) && (!Intrinsics.areEqual((Object) charSequence, (Object) "null"))) {
                z = true;
            }
            if (z) {
                this.f40765a = ColorUtils.parseColor(obj2);
                ((BlockLayoutWrap) getView()).setMaskColor(this.f40765a);
            }
        }
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Object obj;
        super.bindStyles(hashMap);
        if (hashMap != null && (obj = hashMap.get("borderRadius")) != null) {
            ((BlockLayoutWrap) getView()).setMaskRadius(m28944a(obj, true));
        }
    }

    /* renamed from: a */
    private final float m28944a(Object obj, boolean z) {
        String obj2 = obj.toString();
        if (StringsKt.endsWith$default(obj2, "px", false, 2, (Object) null)) {
            int length = obj2.length() - 2;
            if (obj2 != null) {
                String substring = obj2.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(substring) / 2.0f);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (z) {
            return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(obj2));
        } else {
            return Float.parseFloat(obj2);
        }
    }
}
