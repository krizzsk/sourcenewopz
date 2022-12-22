package com.didi.soda.home.topgun.binder.model;

import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.dynamic.DynamicDataMapFunction;
import com.didi.soda.customer.foundation.rpc.entity.TaskCenterEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\b¨\u00066"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "endsInContext", "getEndsInContext", "setEndsInContext", "isTopicAbove", "", "()Z", "setTopicAbove", "(Z)V", "isTopicBelow", "setTopicBelow", "overdueDays", "getOverdueDays", "setOverdueDays", "overdueShowType", "", "getOverdueShowType", "()I", "setOverdueShowType", "(I)V", "overdueTime", "", "getOverdueTime", "()J", "setOverdueTime", "(J)V", "resourceId", "getResourceId", "setResourceId", "taskDesc", "getTaskDesc", "setTaskDesc", "taskEntranceUrl", "getTaskEntranceUrl", "setTaskEntranceUrl", "taskNodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity;", "getTaskNodeList", "()Ljava/util/List;", "setTaskNodeList", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTaskCenterRvModel.kt */
public final class HomeTaskCenterRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42771a;

    /* renamed from: b */
    private String f42772b;

    /* renamed from: c */
    private String f42773c;

    /* renamed from: d */
    private long f42774d;

    /* renamed from: e */
    private int f42775e;

    /* renamed from: f */
    private String f42776f;

    /* renamed from: g */
    private String f42777g;

    /* renamed from: h */
    private String f42778h;

    /* renamed from: i */
    private String f42779i;

    /* renamed from: j */
    private List<TaskCenterEntity.TaskNodeEntity> f42780j;

    /* renamed from: k */
    private boolean f42781k;

    /* renamed from: l */
    private boolean f42782l;

    public final String getTitle() {
        return this.f42771a;
    }

    public final void setTitle(String str) {
        this.f42771a = str;
    }

    public final String getOverdueDays() {
        return this.f42772b;
    }

    public final void setOverdueDays(String str) {
        this.f42772b = str;
    }

    public final String getEndsInContext() {
        return this.f42773c;
    }

    public final void setEndsInContext(String str) {
        this.f42773c = str;
    }

    public final long getOverdueTime() {
        return this.f42774d;
    }

    public final void setOverdueTime(long j) {
        this.f42774d = j;
    }

    public final int getOverdueShowType() {
        return this.f42775e;
    }

    public final void setOverdueShowType(int i) {
        this.f42775e = i;
    }

    public final String getTaskDesc() {
        return this.f42776f;
    }

    public final void setTaskDesc(String str) {
        this.f42776f = str;
    }

    public final String getTaskEntranceUrl() {
        return this.f42777g;
    }

    public final void setTaskEntranceUrl(String str) {
        this.f42777g = str;
    }

    public final String getActivityId() {
        return this.f42778h;
    }

    public final void setActivityId(String str) {
        this.f42778h = str;
    }

    public final String getResourceId() {
        return this.f42779i;
    }

    public final void setResourceId(String str) {
        this.f42779i = str;
    }

    public final List<TaskCenterEntity.TaskNodeEntity> getTaskNodeList() {
        return this.f42780j;
    }

    public final void setTaskNodeList(List<TaskCenterEntity.TaskNodeEntity> list) {
        this.f42780j = list;
    }

    public final boolean isTopicAbove() {
        return this.f42781k;
    }

    public final void setTopicAbove(boolean z) {
        this.f42781k = z;
    }

    public final boolean isTopicBelow() {
        return this.f42782l;
    }

    public final void setTopicBelow(boolean z) {
        this.f42782l = z;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel$Companion;", "", "()V", "convertTaskCenterModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTaskCenterRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeTaskCenterRvModel convertTaskCenterModel(JsonObject jsonObject, FeedPayload feedPayload) {
            String str;
            JsonObject jsonObject2;
            String str2;
            String asString;
            String str3 = "";
            if (jsonObject == null) {
                jsonObject2 = null;
                str = str3;
            } else {
                jsonObject2 = jsonObject.getAsJsonObject("data");
                JsonElement jsonElement = jsonObject.get(DynamicDataMapFunction.PRE_TYPE);
                if (jsonElement == null || (str2 = jsonElement.getAsString()) == null) {
                    str2 = str3;
                }
                JsonElement jsonElement2 = jsonObject.get(DynamicDataMapFunction.NEXT_TYPE);
                if (!(jsonElement2 == null || (asString = jsonElement2.getAsString()) == null)) {
                    str3 = asString;
                }
                str = str3;
                str3 = str2;
            }
            TaskCenterEntity taskCenterEntity = (TaskCenterEntity) GsonUtil.fromJson((JsonElement) jsonObject2, (Type) TaskCenterEntity.class);
            if (taskCenterEntity == null) {
                Companion companion = this;
                return null;
            }
            HomeTaskCenterRvModel homeTaskCenterRvModel = new HomeTaskCenterRvModel();
            homeTaskCenterRvModel.setTitle(taskCenterEntity.getTitle());
            homeTaskCenterRvModel.setOverdueDays(taskCenterEntity.getOverdueDays());
            homeTaskCenterRvModel.setEndsInContext(taskCenterEntity.getEndsInContext());
            Long overdueTime = taskCenterEntity.getOverdueTime();
            homeTaskCenterRvModel.setOverdueTime(overdueTime == null ? 0 : overdueTime.longValue());
            Integer overdueShowType = taskCenterEntity.getOverdueShowType();
            homeTaskCenterRvModel.setOverdueShowType(overdueShowType == null ? 0 : overdueShowType.intValue());
            homeTaskCenterRvModel.setTaskDesc(taskCenterEntity.getTaskDesc());
            homeTaskCenterRvModel.setTaskEntranceUrl(taskCenterEntity.getTaskEntranceUrl());
            homeTaskCenterRvModel.setActivityId(taskCenterEntity.getActivityId());
            homeTaskCenterRvModel.setResourceId(taskCenterEntity.getResourceId());
            homeTaskCenterRvModel.setTaskNodeList(taskCenterEntity.getTaskNodeList());
            homeTaskCenterRvModel.setTopicAbove(TextUtils.equals(str3, "200"));
            homeTaskCenterRvModel.setTopicBelow(TextUtils.equals(str, "200"));
            return homeTaskCenterRvModel;
        }
    }
}
