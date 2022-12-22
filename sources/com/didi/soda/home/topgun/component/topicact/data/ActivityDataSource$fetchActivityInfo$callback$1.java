package com.didi.soda.home.topgun.component.topicact.data;

import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/data/ActivityDataSource$fetchActivityInfo$callback$1", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "serviceTime", "", "traceId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityDataSource.kt */
public final class ActivityDataSource$fetchActivityInfo$callback$1 extends CRpcCallBackWithTraceId<ActivityInfoEntity> {
    final /* synthetic */ boolean $checkOnly;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ ActivityDataSource this$0;

    ActivityDataSource$fetchActivityInfo$callback$1(boolean z, ActivityDataSource activityDataSource, int i) {
        this.$checkOnly = z;
        this.this$0 = activityDataSource;
        this.$pageIndex = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r7, long r8, java.lang.String r10) {
        /*
            r6 = this;
            java.lang.String r8 = "entity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            java.lang.String r8 = "traceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r8)
            boolean r9 = r6.$checkOnly
            if (r9 != 0) goto L_0x00be
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            r9.setResultEntity(r7)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            java.lang.String r0 = r7.recId
            r9.setMRecId(r0)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            r9.setMTraceId(r10)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            com.didi.app.nova.skeleton.ScopeContext r9 = r9.f42944a
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r10 = r6.this$0
            java.lang.String r10 = r10.getMRecId()
            java.lang.String r0 = "recId"
            r9.attach(r0, r10)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            com.didi.app.nova.skeleton.ScopeContext r9 = r9.f42944a
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r10 = r6.this$0
            java.lang.String r10 = r10.getMTraceId()
            r9.attach(r8, r10)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            com.didi.app.nova.skeleton.ScopeContext r8 = r8.f42944a
            java.lang.String r9 = r7.tabId
            if (r9 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            java.lang.String r9 = ""
        L_0x004e:
            java.lang.String r10 = "tabId"
            r8.attach(r10, r9)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            com.didi.app.nova.skeleton.ScopeContext r8 = r8.f42944a
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            java.lang.String r9 = r9.f42953j
            java.lang.String r10 = "topic_id"
            r8.attach(r10, r9)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            r9 = 0
            r8.m30413a(r7, r9)
            java.util.ArrayList<com.didi.soda.blocks.entity.Template> r8 = r7.mTemplates
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x007b
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r8 = 0
            goto L_0x007c
        L_0x007b:
            r8 = 1
        L_0x007c:
            if (r8 != 0) goto L_0x0085
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            java.util.ArrayList<com.didi.soda.blocks.entity.Template> r10 = r7.mTemplates
            r8.m30414a((java.util.ArrayList<com.didi.soda.blocks.entity.Template>) r10)
        L_0x0085:
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            com.didi.soda.datasource.page.PageController r8 = r8.f42946c
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r10 = r7.mCompList
            if (r10 != 0) goto L_0x0090
            goto L_0x00b9
        L_0x0090:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r9 = r6.this$0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x009f:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00b6
            java.lang.Object r1 = r10.next()
            r2 = r1
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r2
            boolean r2 = r9.m30415a((com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r2)
            if (r2 != 0) goto L_0x009f
            r0.add(r1)
            goto L_0x009f
        L_0x00b6:
            r9 = r0
            java.util.List r9 = (java.util.List) r9
        L_0x00b9:
            int r10 = r6.$pageIndex
            r8.receiveResult(r9, r10)
        L_0x00be:
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            kotlin.jvm.functions.Function5 r0 = r8.getOnPageResultListener()
            if (r0 != 0) goto L_0x00c7
            goto L_0x00de
        L_0x00c7:
            int r8 = r6.$pageIndex
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r8 = r6.this$0
            java.lang.String r2 = r8.f42953j
            r4 = 0
            boolean r8 = r6.$checkOnly
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
            r3 = r7
            r0.invoke(r1, r2, r3, r4, r5)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource$fetchActivityInfo$callback$1.onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity, long, java.lang.String):void");
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        if (!this.$checkOnly) {
            this.this$0.m30413a((ActivityInfoEntity) null, sFRpcException);
        }
        Function5<Integer, String, ActivityInfoEntity, SFRpcException, Boolean, Unit> onPageResultListener = this.this$0.getOnPageResultListener();
        if (onPageResultListener != null) {
            onPageResultListener.invoke(Integer.valueOf(this.$pageIndex), this.this$0.f42953j, null, sFRpcException, Boolean.valueOf(this.$checkOnly));
        }
    }
}
