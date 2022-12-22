package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/ViewMoreModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "iconBgColor", "getIconBgColor", "setIconBgColor", "text", "getText", "setText", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewMoreModel.kt */
public final class ViewMoreModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42801a;

    /* renamed from: b */
    private String f42802b;

    /* renamed from: c */
    private String f42803c;

    /* renamed from: d */
    private String f42804d;

    public final String getBgColor() {
        return this.f42801a;
    }

    public final void setBgColor(String str) {
        this.f42801a = str;
    }

    public final String getText() {
        return this.f42802b;
    }

    public final void setText(String str) {
        this.f42802b = str;
    }

    public final String getIcon() {
        return this.f42803c;
    }

    public final void setIcon(String str) {
        this.f42803c = str;
    }

    public final String getIconBgColor() {
        return this.f42804d;
    }

    public final void setIconBgColor(String str) {
        this.f42804d = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/ViewMoreModel$Companion;", "", "()V", "convertModel", "Lcom/didi/soda/home/topgun/binder/model/ViewMoreModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ViewMoreModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewMoreModel convertModel(ViewMoreEntity viewMoreEntity) {
            ViewMoreModel viewMoreModel = new ViewMoreModel();
            if (viewMoreEntity != null) {
                viewMoreModel.setBgColor(viewMoreEntity.getBgColor());
                viewMoreModel.setText(viewMoreEntity.getText());
                viewMoreModel.setIcon(viewMoreEntity.getIcon());
                viewMoreModel.setIconBgColor(viewMoreEntity.getIconBgColor());
            }
            return viewMoreModel;
        }
    }
}
