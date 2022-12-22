package com.didi.entrega.home.component.feed.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeTitleRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "mainTitle", "", "getMainTitle", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "subTile", "getSubTile", "setSubTile", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTitleRvModel.kt */
public final class HomeTitleRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f20697a;

    /* renamed from: b */
    private String f20698b;

    public final String getMainTitle() {
        return this.f20697a;
    }

    public final void setMainTitle(String str) {
        this.f20697a = str;
    }

    public final String getSubTile() {
        return this.f20698b;
    }

    public final void setSubTile(String str) {
        this.f20698b = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeTitleRvModel$Companion;", "", "()V", "convertRvModel", "Lcom/didi/entrega/home/component/feed/binder/model/HomeTitleRvModel;", "entity", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTitleRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeTitleRvModel convertRvModel(HomeTitleEntity homeTitleEntity) {
            Intrinsics.checkNotNullParameter(homeTitleEntity, "entity");
            HomeTitleRvModel homeTitleRvModel = new HomeTitleRvModel();
            homeTitleRvModel.setMainTitle(homeTitleEntity.getMainTitle());
            homeTitleRvModel.setSubTile(homeTitleEntity.getSubTitle());
            return homeTitleRvModel;
        }
    }
}
