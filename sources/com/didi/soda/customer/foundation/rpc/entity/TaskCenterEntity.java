package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u0003012B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00063"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "endsInContext", "getEndsInContext", "setEndsInContext", "overdueDays", "getOverdueDays", "setOverdueDays", "overdueShowType", "", "getOverdueShowType", "()Ljava/lang/Integer;", "setOverdueShowType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "overdueTime", "", "getOverdueTime", "()Ljava/lang/Long;", "setOverdueTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "resourceId", "getResourceId", "setResourceId", "taskDesc", "getTaskDesc", "setTaskDesc", "taskEntranceUrl", "getTaskEntranceUrl", "setTaskEntranceUrl", "taskNodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity;", "getTaskNodeList", "()Ljava/util/List;", "setTaskNodeList", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", "Companion", "MiddleNode", "TaskNodeEntity", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TaskCenterEntity.kt */
public final class TaskCenterEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8956052919840381905L;
    private String activityId;
    private String endsInContext;
    private String overdueDays;
    private Integer overdueShowType = 0;
    private Long overdueTime = 0L;
    private String resourceId;
    private String taskDesc;
    private String taskEntranceUrl;
    private List<TaskNodeEntity> taskNodeList;
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getOverdueDays() {
        return this.overdueDays;
    }

    public final void setOverdueDays(String str) {
        this.overdueDays = str;
    }

    public final String getEndsInContext() {
        return this.endsInContext;
    }

    public final void setEndsInContext(String str) {
        this.endsInContext = str;
    }

    public final Long getOverdueTime() {
        return this.overdueTime;
    }

    public final void setOverdueTime(Long l) {
        this.overdueTime = l;
    }

    public final Integer getOverdueShowType() {
        return this.overdueShowType;
    }

    public final void setOverdueShowType(Integer num) {
        this.overdueShowType = num;
    }

    public final String getTaskDesc() {
        return this.taskDesc;
    }

    public final void setTaskDesc(String str) {
        this.taskDesc = str;
    }

    public final String getTaskEntranceUrl() {
        return this.taskEntranceUrl;
    }

    public final void setTaskEntranceUrl(String str) {
        this.taskEntranceUrl = str;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final List<TaskNodeEntity> getTaskNodeList() {
        return this.taskNodeList;
    }

    public final void setTaskNodeList(List<TaskNodeEntity> list) {
        this.taskNodeList = list;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TaskCenterEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "middleNode", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode;", "getMiddleNode", "()Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode;", "setMiddleNode", "(Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode;)V", "taskNodeIndex", "", "getTaskNodeIndex", "()Ljava/lang/Integer;", "setTaskNodeIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "taskStatus", "getTaskStatus", "setTaskStatus", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TaskCenterEntity.kt */
    public static final class TaskNodeEntity implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -8956052919840381915L;
        private MiddleNode middleNode;
        private Integer taskNodeIndex = 0;
        private Integer taskStatus = 0;

        public final Integer getTaskNodeIndex() {
            return this.taskNodeIndex;
        }

        public final void setTaskNodeIndex(Integer num) {
            this.taskNodeIndex = num;
        }

        public final Integer getTaskStatus() {
            return this.taskStatus;
        }

        public final void setTaskStatus(Integer num) {
            this.taskStatus = num;
        }

        public final MiddleNode getMiddleNode() {
            return this.middleNode;
        }

        public final void setMiddleNode(MiddleNode middleNode2) {
            this.middleNode = middleNode2;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: TaskCenterEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "completedNum", "", "getCompletedNum", "()I", "setCompletedNum", "(I)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "totalNum", "getTotalNum", "setTotalNum", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TaskCenterEntity.kt */
    public static final class MiddleNode implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 9044621642930607201L;
        private int completedNum;
        private String text = "";
        private int totalNum;

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: TaskCenterEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final int getTotalNum() {
            return this.totalNum;
        }

        public final void setTotalNum(int i) {
            this.totalNum = i;
        }

        public final int getCompletedNum() {
            return this.completedNum;
        }

        public final void setCompletedNum(int i) {
            this.completedNum = i;
        }
    }
}
