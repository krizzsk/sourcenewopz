package com.didi.soda.compose.layout;

import com.didi.soda.compose.card.BaseCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/compose/layout/BaseLayout;", "", "()V", "mCards", "Ljava/util/ArrayList;", "Lcom/didi/soda/compose/card/BaseCard;", "getMCards", "()Ljava/util/ArrayList;", "setMCards", "(Ljava/util/ArrayList;)V", "style", "Lcom/didi/soda/compose/layout/Style;", "getStyle", "()Lcom/didi/soda/compose/layout/Style;", "setStyle", "(Lcom/didi/soda/compose/layout/Style;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseLayout.kt */
public class BaseLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CARDS = "cards";
    public static final String KEY_ID = "id";
    public static final String KEY_STYLE = "style";
    public static final String KEY_TYPE = "type";

    /* renamed from: a */
    private String f40126a;

    /* renamed from: b */
    private Style f40127b;

    /* renamed from: c */
    private ArrayList<BaseCard> f40128c = new ArrayList<>();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/compose/layout/BaseLayout$Companion;", "", "()V", "KEY_CARDS", "", "KEY_ID", "KEY_STYLE", "KEY_TYPE", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BaseLayout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getType() {
        return this.f40126a;
    }

    public final void setType(String str) {
        this.f40126a = str;
    }

    public final Style getStyle() {
        return this.f40127b;
    }

    public final void setStyle(Style style) {
        this.f40127b = style;
    }

    public final ArrayList<BaseCard> getMCards() {
        return this.f40128c;
    }

    public final void setMCards(ArrayList<BaseCard> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.f40128c = arrayList;
    }
}
