package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.widget.TextView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.widget.TextBinder;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.widget.text.RichTextView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "SodaText")
@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/SodaTextBinder;", "Lcom/didi/soda/blocks/widget/TextBinder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindProps", "", "props", "Ljava/util/HashMap;", "", "", "createView", "Landroid/widget/TextView;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SodaTextBinder.kt */
public final class SodaTextBinder extends TextBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SodaTextBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public TextView createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RichTextView(context);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        Map map;
        HashMap hashMap2 = null;
        if (hashMap == null) {
            map = null;
        } else {
            map = new LinkedHashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!Const.BlockParamConst.FONT_FAMILY.equals(entry.getKey())) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (map instanceof HashMap) {
            hashMap2 = (HashMap) map;
        }
        super.bindProps(hashMap2);
    }
}
