package com.didi.soda.compose.entity;

import com.didi.soda.compose.card.BaseCard;
import com.didi.soda.compose.layout.Style;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/compose/entity/LayoutEntity;", "Ljava/io/Serializable;", "()V", "cards", "", "Lcom/didi/soda/compose/card/BaseCard;", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "style", "Lcom/didi/soda/compose/layout/Style;", "getStyle", "()Lcom/didi/soda/compose/layout/Style;", "setStyle", "(Lcom/didi/soda/compose/layout/Style;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LayoutEntity.kt */
public final class LayoutEntity implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 8292722566012978643L;
    private List<BaseCard> cards;
    private Style style;
    private String type;

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(Style style2) {
        this.style = style2;
    }

    public final List<BaseCard> getCards() {
        return this.cards;
    }

    public final void setCards(List<BaseCard> list) {
        this.cards = list;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/compose/entity/LayoutEntity$Companion;", "", "()V", "serialVersionUID", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LayoutEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
