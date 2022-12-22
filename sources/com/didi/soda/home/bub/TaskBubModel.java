package com.didi.soda.home.bub;

import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedSuspendBallEntity;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.widget.HomeTaskBubStateEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/bub/TaskBubModel;", "", "()V", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TaskBubModel.kt */
public final class TaskBubModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42548a;

    /* renamed from: b */
    private String f42549b;

    /* renamed from: c */
    private String f42550c;

    /* renamed from: d */
    private String f42551d;

    /* renamed from: e */
    private int f42552e = HomeTaskBubStateEnum.INSTANCE.getLAND();

    @JvmStatic
    public static final TaskBubModel newInstance(HomeFeedSuspendBallEntity homeFeedSuspendBallEntity) {
        return Companion.newInstance(homeFeedSuspendBallEntity);
    }

    public final String getTitle() {
        return this.f42548a;
    }

    public final void setTitle(String str) {
        this.f42548a = str;
    }

    public final String getSubTitle() {
        return this.f42549b;
    }

    public final void setSubTitle(String str) {
        this.f42549b = str;
    }

    public final String getRedirectUrl() {
        return this.f42550c;
    }

    public final void setRedirectUrl(String str) {
        this.f42550c = str;
    }

    public final String getIcon() {
        return this.f42551d;
    }

    public final void setIcon(String str) {
        this.f42551d = str;
    }

    public final int getCurrentState() {
        return this.f42552e;
    }

    public final void setCurrentState(int i) {
        this.f42552e = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/bub/TaskBubModel$Companion;", "", "()V", "newInstance", "Lcom/didi/soda/home/bub/TaskBubModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeFeedSuspendBallEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TaskBubModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TaskBubModel newInstance(HomeFeedSuspendBallEntity homeFeedSuspendBallEntity) {
            int i;
            Intrinsics.checkNotNullParameter(homeFeedSuspendBallEntity, "entity");
            TaskBubModel taskBubModel = new TaskBubModel();
            taskBubModel.setTitle(homeFeedSuspendBallEntity.getTitle());
            taskBubModel.setSubTitle(homeFeedSuspendBallEntity.getSubTitle());
            taskBubModel.setRedirectUrl(homeFeedSuspendBallEntity.getRedirectUrl());
            taskBubModel.setIcon(homeFeedSuspendBallEntity.getIcon());
            TaskBubModel taskBubModel2 = (TaskBubModel) ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).getValue();
            if (taskBubModel2 == null) {
                i = HomeTaskBubStateEnum.INSTANCE.getLAND();
            } else {
                i = taskBubModel2.getCurrentState();
            }
            taskBubModel.setCurrentState(i);
            return taskBubModel;
        }
    }
}
