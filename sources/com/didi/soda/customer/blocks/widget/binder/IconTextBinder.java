package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.widget.TextBinder;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "IconText")
@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0014J\u001e\u0010\u0016\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/IconTextBinder;", "Lcom/didi/soda/blocks/widget/TextBinder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "bindProps", "", "props", "Ljava/util/HashMap;", "", "", "createView", "Lcom/didi/rfusion/widget/RFIconView;", "doAfterCheck", "", "content", "block", "Lkotlin/Function1;", "setText", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IconTextBinder.kt */
public final class IconTextBinder extends TextBinder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Pattern f40764a = Pattern.compile("&em#.*?&em#");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconTextBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public RFIconView createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RFIconView(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r3 = r3.get("text");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r3 = r0
            goto L_0x0013
        L_0x0005:
            java.lang.String r1 = "text"
            java.lang.Object r3 = r3.get(r1)
            if (r3 != 0) goto L_0x000f
            goto L_0x0003
        L_0x000f:
            java.lang.String r3 = r3.toString()
        L_0x0013:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0025
            r1 = 2
            boolean r3 = m28940a(r2, r3, r0, r1, r0)
            if (r3 == 0) goto L_0x0025
            r3 = 1
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.binder.IconTextBinder.shouldShow(java.util.HashMap):boolean");
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

    /* access modifiers changed from: protected */
    public void setText(String str) {
        m28941a(str, new IconTextBinder$setText$1(this));
    }

    /* renamed from: a */
    static /* synthetic */ boolean m28940a(IconTextBinder iconTextBinder, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return iconTextBinder.m28941a(str, function1);
    }

    /* renamed from: a */
    private final boolean m28941a(String str, Function1<? super String, Unit> function1) {
        String string;
        if (str == null) {
            return false;
        }
        if (this.f40764a.matcher(str).find()) {
            if (function1 != null) {
                function1.invoke(str);
            }
            return true;
        }
        int identifier = ((TextView) getView()).getContext().getResources().getIdentifier(str, TypedValues.Custom.S_STRING, ((TextView) getView()).getContext().getPackageName());
        if (identifier > 0 && (string = ResourceHelper.getString(identifier)) != null) {
            if (string.length() == 0) {
                string = null;
            }
            if (string != null) {
                if (function1 != null) {
                    function1.invoke(string);
                }
                return true;
            }
        }
        return false;
    }
}
