package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "ambientImg", "", "getAmbientImg", "()Ljava/lang/String;", "setAmbientImg", "(Ljava/lang/String;)V", "countDown", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "getCountDown", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "setCountDown", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;)V", "img", "getImg", "setImg", "localDeadline", "", "getLocalDeadline", "()J", "setLocalDeadline", "(J)V", "platLogo", "getPlatLogo", "setPlatLogo", "ruleLink", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "getRuleLink", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "setRuleLink", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;)V", "subTitle", "getSubTitle", "setSubTitle", "tab", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getTab", "()Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "setTab", "(Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;)V", "tabs", "", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingHeaderRvModel.kt */
public final class LandingHeaderRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42791a;

    /* renamed from: b */
    private String f42792b;

    /* renamed from: c */
    private ActivityInfoEntity.RuleLink f42793c;

    /* renamed from: d */
    private String f42794d;

    /* renamed from: e */
    private CountDownEntity f42795e;

    /* renamed from: f */
    private String f42796f;

    /* renamed from: g */
    private String f42797g;

    /* renamed from: h */
    private TabInfoEntity f42798h;

    /* renamed from: i */
    private List<TabInfoEntity> f42799i;

    /* renamed from: j */
    private long f42800j;

    public final String getImg() {
        return this.f42791a;
    }

    public final void setImg(String str) {
        this.f42791a = str;
    }

    public final String getTitle() {
        return this.f42792b;
    }

    public final void setTitle(String str) {
        this.f42792b = str;
    }

    public final ActivityInfoEntity.RuleLink getRuleLink() {
        return this.f42793c;
    }

    public final void setRuleLink(ActivityInfoEntity.RuleLink ruleLink) {
        this.f42793c = ruleLink;
    }

    public final String getPlatLogo() {
        return this.f42794d;
    }

    public final void setPlatLogo(String str) {
        this.f42794d = str;
    }

    public final CountDownEntity getCountDown() {
        return this.f42795e;
    }

    public final void setCountDown(CountDownEntity countDownEntity) {
        this.f42795e = countDownEntity;
    }

    public final String getAmbientImg() {
        return this.f42796f;
    }

    public final void setAmbientImg(String str) {
        this.f42796f = str;
    }

    public final String getSubTitle() {
        return this.f42797g;
    }

    public final void setSubTitle(String str) {
        this.f42797g = str;
    }

    public final TabInfoEntity getTab() {
        return this.f42798h;
    }

    public final void setTab(TabInfoEntity tabInfoEntity) {
        this.f42798h = tabInfoEntity;
    }

    public final List<TabInfoEntity> getTabs() {
        return this.f42799i;
    }

    public final void setTabs(List<TabInfoEntity> list) {
        this.f42799i = list;
    }

    public final long getLocalDeadline() {
        return this.f42800j;
    }

    public final void setLocalDeadline(long j) {
        this.f42800j = j;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel$Companion;", "", "()V", "convertModel", "Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "componentEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LandingHeaderRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LandingHeaderRvModel convertModel(ComponentEntity componentEntity, FeedPayload feedPayload) {
            ActivityInfoEntity.HeaderInfo headerInfo;
            Intrinsics.checkNotNullParameter(componentEntity, "componentEntity");
            Intrinsics.checkNotNullParameter(feedPayload, "payload");
            ActivityInfoEntity.HeaderInfo headerInfo2 = componentEntity.header;
            if (headerInfo2 == null && componentEntity.data != null) {
                try {
                    headerInfo = (ActivityInfoEntity.HeaderInfo) GsonUtil.fromJson((JsonElement) componentEntity.data, (Type) ActivityInfoEntity.HeaderInfo.class);
                } catch (Exception unused) {
                    headerInfo = null;
                }
                headerInfo2 = headerInfo;
            }
            if (headerInfo2 == null) {
                Companion companion = this;
                return null;
            }
            LandingHeaderRvModel landingHeaderRvModel = new LandingHeaderRvModel();
            landingHeaderRvModel.setImg(headerInfo2.img);
            landingHeaderRvModel.setTitle(headerInfo2.title);
            landingHeaderRvModel.setRuleLink(headerInfo2.ruleLink);
            landingHeaderRvModel.setPlatLogo(headerInfo2.platLogo);
            landingHeaderRvModel.setCountDown(headerInfo2.countDown);
            landingHeaderRvModel.setAmbientImg(headerInfo2.ambientImg);
            landingHeaderRvModel.setSubTitle(headerInfo2.subTitle);
            landingHeaderRvModel.setTab(headerInfo2.tab);
            landingHeaderRvModel.setTabs(headerInfo2.tabs);
            return landingHeaderRvModel;
        }
    }
}
