package com.didi.soda.home.foster;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.blocks.card.suapp.SaTopicItemWidget;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/home/foster/FosterTrackHelper;", "", "()V", "downX", "", "doTrackScrollEvent", "", "isLeft", "", "componentEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "recId", "", "trackFirstVisibleChildren", "scrollView", "Lcom/didi/soda/customer/blocks/widget/ScrollWidget;", "trackScrollEvent", "Landroid/widget/HorizontalScrollView;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FosterTrackHelper.kt */
public final class FosterTrackHelper {

    /* renamed from: a */
    private int f42649a = -1;

    public final void trackScrollEvent(HorizontalScrollView horizontalScrollView, ComponentEntity componentEntity, String str) {
        Intrinsics.checkNotNullParameter(horizontalScrollView, "scrollView");
        Intrinsics.checkNotNullParameter(componentEntity, "componentEntity");
        horizontalScrollView.setOnTouchListener(new View.OnTouchListener(ViewConfiguration.get(horizontalScrollView.getContext()).getScaledTouchSlop(), componentEntity, str) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ ComponentEntity f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FosterTrackHelper.m30130a(FosterTrackHelper.this, this.f$1, this.f$2, this.f$3, view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r7 != 3) goto L_0x0066;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m30130a(com.didi.soda.home.foster.FosterTrackHelper r3, int r4, com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5, java.lang.String r6, android.view.View r7, android.view.MotionEvent r8) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            java.lang.String r7 = "$componentEntity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            int r7 = r8.getAction()
            r0 = 0
            if (r7 == 0) goto L_0x005f
            r1 = 1
            if (r7 == r1) goto L_0x0028
            r2 = 2
            if (r7 == r2) goto L_0x001c
            r2 = 3
            if (r7 == r2) goto L_0x0028
            goto L_0x0066
        L_0x001c:
            int r4 = r3.f42649a
            if (r4 >= 0) goto L_0x0066
            float r4 = r8.getX()
            int r4 = (int) r4
            r3.f42649a = r4
            goto L_0x0066
        L_0x0028:
            float r7 = r8.getX()
            int r7 = (int) r7
            int r8 = r3.f42649a
            int r7 = r7 - r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "deltaX = "
            r8.append(r2)
            r8.append(r7)
            java.lang.String r2 = " slop="
            r8.append(r2)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            java.lang.String r2 = "TAG"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(r2, r8)
            int r8 = java.lang.Math.abs(r7)
            if (r8 <= r4) goto L_0x005b
            if (r7 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            r3.m30129a((boolean) r1, (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r5, (java.lang.String) r6)
        L_0x005b:
            r4 = -1
            r3.f42649a = r4
            goto L_0x0066
        L_0x005f:
            float r4 = r8.getX()
            int r4 = (int) r4
            r3.f42649a = r4
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.foster.FosterTrackHelper.m30130a(com.didi.soda.home.foster.FosterTrackHelper, int, com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity, java.lang.String, android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private final void m30129a(boolean z, ComponentEntity componentEntity, String str) {
        UIHandler.post(new Runnable(str, componentEntity, z) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ ComponentEntity f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                FosterTrackHelper.m30128a(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r0 = r0.actInfo;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m30128a(java.lang.String r4, com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5, boolean r6) {
        /*
            java.lang.String r0 = "$componentEntity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "sailing_c_x_homepage_top_slide_sw"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r0)
            java.lang.String r1 = ""
            if (r4 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r4 = r1
        L_0x0012:
            java.lang.String r2 = "rec_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r0.addEventParam(r2, r4)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r0 = r5.mTopicComp
            r2 = 0
            if (r0 != 0) goto L_0x0020
        L_0x001e:
            r0 = r2
            goto L_0x0029
        L_0x0020:
            com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r0 = r0.actInfo
            if (r0 != 0) goto L_0x0025
            goto L_0x001e
        L_0x0025:
            java.lang.String r0 = r0.getActId()
        L_0x0029:
            if (r0 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            java.lang.String r3 = "activity_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r3, r0)
            int r0 = r5.mPosition
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "location"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r3, r0)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r0 = r5.mTopicComp
            if (r0 != 0) goto L_0x0045
            r0 = r2
            goto L_0x004b
        L_0x0045:
            int r0 = r0.scene
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x004b:
            int r0 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.getOrZero(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "scene"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r3, r0)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r5 = r5.mTopicComp
            if (r5 != 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            java.lang.String r2 = r5.componentId
        L_0x0061:
            if (r2 == 0) goto L_0x0064
            r1 = r2
        L_0x0064:
            java.lang.String r5 = "topic_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r5, r1)
            r5 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "from_channel"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r1, r0)
            if (r6 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r5 = 2
        L_0x007a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "slide_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            com.didi.soda.customer.foundation.tracker.OmegaTracker r4 = r4.build()
            r4.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.foster.FosterTrackHelper.m30128a(java.lang.String, com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity, boolean):void");
    }

    public final void trackFirstVisibleChildren(ScrollWidget scrollWidget, ComponentEntity componentEntity, String str) {
        String str2;
        int i;
        Integer num;
        HomeTopicEntity homeTopicEntity;
        HomeTopicEntity homeTopicEntity2;
        HomeTopicEntity homeTopicEntity3;
        ActInfoEntity actInfoEntity;
        Intrinsics.checkNotNullParameter(scrollWidget, "scrollView");
        int left = scrollWidget.getLeft();
        int right = scrollWidget.getRight();
        float f = 0.0f;
        for (ItemOperationListener itemOperationListener : scrollWidget.getItemOperationListener()) {
            if (itemOperationListener instanceof SaTopicItemWidget) {
                StringBuilder sb = new StringBuilder();
                sb.append(" >>>> pL = ");
                sb.append(left);
                sb.append(" pR = ");
                sb.append(right);
                sb.append(" item.left = ");
                SaTopicItemWidget saTopicItemWidget = (SaTopicItemWidget) itemOperationListener;
                sb.append(saTopicItemWidget.getLeft());
                sb.append(" item.right = ");
                sb.append(saTopicItemWidget.getRight());
                LogUtil.m29100d("TAG", sb.toString());
                if (saTopicItemWidget.getLeft() >= left && saTopicItemWidget.getRight() <= right) {
                    f += 1.0f;
                } else if ((saTopicItemWidget.getLeft() < left && saTopicItemWidget.getRight() > left) || (saTopicItemWidget.getLeft() < right && saTopicItemWidget.getRight() > right)) {
                    f += 0.5f;
                }
            }
        }
        OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_homepage_top_common_sw");
        String str3 = "";
        if (str == null) {
            str = str3;
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("rec_id", str);
        String str4 = null;
        if (componentEntity == null || (homeTopicEntity3 = componentEntity.mTopicComp) == null || (actInfoEntity = homeTopicEntity3.actInfo) == null) {
            str2 = null;
        } else {
            str2 = actInfoEntity.getActId();
        }
        if (str2 == null) {
            str2 = str3;
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("activity_id", str2);
        if (componentEntity == null) {
            i = -1;
        } else {
            i = componentEntity.mPosition;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("location", Integer.valueOf(i));
        if (componentEntity == null || (homeTopicEntity2 = componentEntity.mTopicComp) == null) {
            num = null;
        } else {
            num = Integer.valueOf(homeTopicEntity2.scene);
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("scene", Integer.valueOf(CustomerExtentionKt.getOrZero(num)));
        if (!(componentEntity == null || (homeTopicEntity = componentEntity.mTopicComp) == null)) {
            str4 = homeTopicEntity.componentId;
        }
        if (str4 != null) {
            str3 = str4;
        }
        addEventParam4.addEventParam("topic_id", str3).addEventParam("from_channel", 1).addEventParam(BlocksConst.BLOCK_EXPOSURE_NUM, Float.valueOf(f)).build().track();
    }
}
