package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "actions", "", "", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "identifier", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "retainInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo;", "getRetainInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo;", "setRetainInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo;)V", "Companion", "RetainInfo", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionEntity.kt */
public final class ComposeActionEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 4926526051683684217L;
    private List<String> actions;
    private String identifier;
    private RetainInfo retainInfo;

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final RetainInfo getRetainInfo() {
        return this.retainInfo;
    }

    public final void setRetainInfo(RetainInfo retainInfo2) {
        this.retainInfo = retainInfo2;
    }

    public final List<String> getActions() {
        return this.actions;
    }

    public final void setActions(List<String> list) {
        this.actions = list;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "actions", "", "", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "btnList", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$BtnList;", "getBtnList", "setBtnList", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "strategy", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy;", "getStrategy", "()Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy;", "setStrategy", "(Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy;)V", "title", "getTitle", "setTitle", "BtnList", "Companion", "Strategy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComposeActionEntity.kt */
    public static final class RetainInfo implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 2280748581362732609L;
        private List<String> actions;
        private List<BtnList> btnList;
        private String content;
        private Strategy strategy;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final Strategy getStrategy() {
            return this.strategy;
        }

        public final void setStrategy(Strategy strategy2) {
            this.strategy = strategy2;
        }

        public final List<String> getActions() {
            return this.actions;
        }

        public final void setActions(List<String> list) {
            this.actions = list;
        }

        public final List<BtnList> getBtnList() {
            return this.btnList;
        }

        public final void setBtnList(List<BtnList> list) {
            this.btnList = list;
        }

        @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "cycle", "", "getCycle", "()I", "setCycle", "(I)V", "num", "getNum", "setNum", "uniqueId", "", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ComposeActionEntity.kt */
        public static final class Strategy implements IEntity {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private static final long serialVersionUID = -91811982245539548L;
            private int cycle;
            private int num;
            private String uniqueId;

            public final int getCycle() {
                return this.cycle;
            }

            public final void setCycle(int i) {
                this.cycle = i;
            }

            public final int getNum() {
                return this.num;
            }

            public final void setNum(int i) {
                this.num = i;
            }

            public final String getUniqueId() {
                return this.uniqueId;
            }

            public final void setUniqueId(String str) {
                this.uniqueId = str;
            }

            @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Strategy$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
            /* compiled from: ComposeActionEntity.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$BtnList;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "actions", "", "", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ComposeActionEntity.kt */
        public static final class BtnList implements IEntity {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private static final long serialVersionUID = 7611991645145579520L;
            private List<String> actions;
            private String title;

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                this.title = str;
            }

            public final List<String> getActions() {
                return this.actions;
            }

            public final void setActions(List<String> list) {
                this.actions = list;
            }

            @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$BtnList$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
            /* compiled from: ComposeActionEntity.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$RetainInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ComposeActionEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComposeActionEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
