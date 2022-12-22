package com.didi.soda.home.topgun.model;

import com.didi.soda.customer.foundation.rpc.entity.SearchHotWordsEntity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006("}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "Ljava/io/Serializable;", "()V", "activityCate", "", "getActivityCate", "()Ljava/lang/String;", "setActivityCate", "(Ljava/lang/String;)V", "activityId", "getActivityId", "setActivityId", "bgColor", "", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "img", "getImg", "setImg", "index", "", "getIndex", "()I", "setIndex", "(I)V", "type", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "url", "getUrl", "setUrl", "word", "getWord", "setWord", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSearchHotWordsModel.kt */
public final class HomeSearchHotWordsModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String activityCate;
    private String activityId;
    private List<String> bgColor;
    private String img;
    private int index;
    private Integer type;
    private String url;
    private String word;

    @JvmStatic
    public static final HomeSearchHotWordsModel convert2Model(SearchHotWordsEntity searchHotWordsEntity) {
        return Companion.convert2Model(searchHotWordsEntity);
    }

    public final String getWord() {
        return this.word;
    }

    public final void setWord(String str) {
        this.word = str;
    }

    public final List<String> getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(List<String> list) {
        this.bgColor = list;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final String getActivityCate() {
        return this.activityCate;
    }

    public final void setActivityCate(String str) {
        this.activityCate = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel$Companion;", "", "()V", "convert2Model", "Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "searchHotWordsEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchHotWordsEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeSearchHotWordsModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HomeSearchHotWordsModel convert2Model(SearchHotWordsEntity searchHotWordsEntity) {
            Intrinsics.checkNotNullParameter(searchHotWordsEntity, "searchHotWordsEntity");
            HomeSearchHotWordsModel homeSearchHotWordsModel = new HomeSearchHotWordsModel();
            homeSearchHotWordsModel.setWord(searchHotWordsEntity.word);
            homeSearchHotWordsModel.setBgColor(searchHotWordsEntity.bgColor);
            homeSearchHotWordsModel.setImg(searchHotWordsEntity.img);
            homeSearchHotWordsModel.setType(searchHotWordsEntity.type);
            homeSearchHotWordsModel.setActivityId(searchHotWordsEntity.activityId);
            homeSearchHotWordsModel.setActivityCate(searchHotWordsEntity.activityCate);
            homeSearchHotWordsModel.setUrl(searchHotWordsEntity.url);
            return homeSearchHotWordsModel;
        }
    }
}
