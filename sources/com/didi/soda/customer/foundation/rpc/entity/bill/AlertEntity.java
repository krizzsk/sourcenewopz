package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "btnList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertBtnEntity;", "getBtnList", "()Ljava/util/List;", "setBtnList", "(Ljava/util/List;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentType", "", "getContentType", "()I", "setContentType", "(I)V", "extra", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertExtraEntity;", "getExtra", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertExtraEntity;", "setExtra", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertExtraEntity;)V", "img", "getImg", "setImg", "title", "getTitle", "setTitle", "type", "getType", "setType", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AlertEntity.kt */
public final class AlertEntity implements IEntity {
    public static final int CREATE_ORDER_NO_PAYMENT_METHOD_GUIDE = 100;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAY_ERROR_GUIDE = 7;
    private static final long serialVersionUID = -7101381679653457438L;
    private List<AlertBtnEntity> btnList;
    private String content;
    private int contentType;
    private AlertExtraEntity extra;
    private String img;
    private String title;
    private int type;

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final void setContentType(int i) {
        this.contentType = i;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<AlertBtnEntity> getBtnList() {
        return this.btnList;
    }

    public final void setBtnList(List<AlertBtnEntity> list) {
        this.btnList = list;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final AlertExtraEntity getExtra() {
        return this.extra;
    }

    public final void setExtra(AlertExtraEntity alertExtraEntity) {
        this.extra = alertExtraEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity$Companion;", "", "()V", "CREATE_ORDER_NO_PAYMENT_METHOD_GUIDE", "", "PAY_ERROR_GUIDE", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AlertEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
