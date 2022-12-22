package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001c\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00063"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "componentId", "", "getComponentId", "()I", "setComponentId", "(I)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "getData", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "setData", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;)V", "defaultContent", "getDefaultContent", "setDefaultContent", "defaultContentHighlight", "getDefaultContentHighlight", "setDefaultContentHighlight", "hint", "getHint", "setHint", "hintType", "getHintType", "setHintType", "isCanRedirect", "setCanRedirect", "leftHint", "getLeftHint", "setLeftHint", "leftIcon", "getLeftIcon", "setLeftIcon", "name", "getName", "setName", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "type", "getType", "setType", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillComponentEntity.kt */
public final class BillComponentEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3171495636539006275L;
    private int componentId;
    private String content;
    private BillComponentDataEntity data;
    private String defaultContent;
    private int defaultContentHighlight;
    private String hint;
    private int hintType;
    private int isCanRedirect;
    private String leftHint;
    private String leftIcon;
    private String name;
    private String redirectUrl;
    private int type;

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getComponentId() {
        return this.componentId;
    }

    public final void setComponentId(int i) {
        this.componentId = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getDefaultContent() {
        return this.defaultContent;
    }

    public final void setDefaultContent(String str) {
        this.defaultContent = str;
    }

    public final int getDefaultContentHighlight() {
        return this.defaultContentHighlight;
    }

    public final void setDefaultContentHighlight(int i) {
        this.defaultContentHighlight = i;
    }

    public final String getHint() {
        return this.hint;
    }

    public final void setHint(String str) {
        this.hint = str;
    }

    public final int getHintType() {
        return this.hintType;
    }

    public final void setHintType(int i) {
        this.hintType = i;
    }

    public final String getLeftHint() {
        return this.leftHint;
    }

    public final void setLeftHint(String str) {
        this.leftHint = str;
    }

    public final int isCanRedirect() {
        return this.isCanRedirect;
    }

    public final void setCanRedirect(int i) {
        this.isCanRedirect = i;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public final BillComponentDataEntity getData() {
        return this.data;
    }

    public final void setData(BillComponentDataEntity billComponentDataEntity) {
        this.data = billComponentDataEntity;
    }

    public final String getLeftIcon() {
        return this.leftIcon;
    }

    public final void setLeftIcon(String str) {
        this.leftIcon = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillComponentEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
