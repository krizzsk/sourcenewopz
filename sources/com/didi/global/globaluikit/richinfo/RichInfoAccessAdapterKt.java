package com.didi.global.globaluikit.richinfo;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didiglobal.travel.infra.value.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b*\u00020\t\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, mo175978d2 = {"fontSizeDp", "", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo$RichInfo;", "getFontSizeDp", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo$RichInfo;)F", "style", "Lcom/didi/global/globaluikit/richinfo/RichInfoStyle;", "styleList", "", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RichInfoAccessAdapter.kt */
public final class RichInfoAccessAdapterKt {
    public static final float getFontSizeDp(LEGORichInfo.RichInfo richInfo) {
        Intrinsics.checkNotNullParameter(richInfo, "<this>");
        return ((float) richInfo.fontSize) / 2.0f;
    }

    public static final RichInfoStyle style(LEGORichInfo.RichInfo richInfo) {
        Intrinsics.checkNotNullParameter(richInfo, "<this>");
        int i = richInfo.start;
        int i2 = richInfo.length;
        Color.Companion companion = Color.Companion;
        String str = richInfo.color;
        Intrinsics.checkNotNullExpressionValue(str, "this.color");
        return new RichInfoStyle(i, i2, companion.of-Ba4jWBc(str), getFontSizeDp(richInfo), richInfo.bold == 1, richInfo.italic == 1, richInfo.through == 1, richInfo.script == 1, richInfo.link, (DefaultConstructorMarker) null);
    }

    public static final List<RichInfoStyle> styleList(LEGORichInfo lEGORichInfo) {
        Intrinsics.checkNotNullParameter(lEGORichInfo, "<this>");
        List<LEGORichInfo.RichInfo> infoList = lEGORichInfo.getInfoList();
        Intrinsics.checkNotNullExpressionValue(infoList, "this.infoList");
        Iterable<LEGORichInfo.RichInfo> iterable = infoList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (LEGORichInfo.RichInfo richInfo : iterable) {
            Intrinsics.checkNotNullExpressionValue(richInfo, "it");
            arrayList.add(style(richInfo));
        }
        return (List) arrayList;
    }
}
