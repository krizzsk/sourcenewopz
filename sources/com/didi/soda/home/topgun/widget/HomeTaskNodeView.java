package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.soda.customer.foundation.rpc.entity.TaskCenterEntity;
import com.didichuxing.drtl.tookit.BitmapSetterKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\nH\u0002¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTaskNodeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindData", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity;", "bindNormarlData", "initView", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTaskNodeView.kt */
public final class HomeTaskNodeView extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TASK_NODE_STATUS_DONE = 4;
    public static final int TASK_NODE_STATUS_DONE_WITHOUT_REWARD = 5;
    public static final int TASK_NODE_STATUS_TODO = 2;
    public static final int TASK_NODE_STATUS_TODO_WITH_COUPON = 1;
    public static final int TASK_NODE_STATUS_WAIT_GET = 3;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTaskNodeView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTaskNodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTaskNodeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTaskNodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        m30531a();
    }

    /* renamed from: a */
    private final void m30531a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_binder_home_task_node, this, true);
    }

    public final void bindData(TaskCenterEntity.TaskNodeEntity taskNodeEntity) {
        Intrinsics.checkNotNullParameter(taskNodeEntity, "entity");
        Integer taskNodeIndex = taskNodeEntity.getTaskNodeIndex();
        if (taskNodeIndex != null && taskNodeIndex.intValue() == 0) {
            ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.id.customer_home_task_node_item_iv);
            Intrinsics.checkNotNullExpressionValue(imageView, "customer_home_task_node_item_iv");
            BitmapSetterKt.setSrc(imageView, (int) R.drawable.customer_skin_icon_task_center_node_todo);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(8);
            return;
        }
        bindNormarlData(taskNodeEntity);
    }

    public final void bindNormarlData(TaskCenterEntity.TaskNodeEntity taskNodeEntity) {
        Intrinsics.checkNotNullParameter(taskNodeEntity, "entity");
        Integer taskStatus = taskNodeEntity.getTaskStatus();
        boolean z = true;
        if (taskStatus != null && taskStatus.intValue() == 1) {
            ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.id.customer_home_task_node_item_iv);
            Intrinsics.checkNotNullExpressionValue(imageView, "customer_home_task_node_item_iv");
            BitmapSetterKt.setSrc(imageView, (int) R.drawable.customer_skin_icon_task_center_node_coupon);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(8);
        } else if (taskStatus != null && taskStatus.intValue() == 2) {
            ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(0);
            ImageView imageView2 = (ImageView) findViewById(R.id.customer_home_task_node_item_iv);
            Intrinsics.checkNotNullExpressionValue(imageView2, "customer_home_task_node_item_iv");
            BitmapSetterKt.setSrc(imageView2, (int) R.drawable.customer_skin_icon_task_center_node_todo);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(8);
        } else if (taskStatus != null && taskStatus.intValue() == 3) {
            ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(8);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(0);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).playAnimation();
        } else {
            if ((taskStatus == null || taskStatus.intValue() != 4) && (taskStatus == null || taskStatus.intValue() != 5)) {
                z = false;
            }
            if (z) {
                ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(0);
                ImageView imageView3 = (ImageView) findViewById(R.id.customer_home_task_node_item_iv);
                Intrinsics.checkNotNullExpressionValue(imageView3, "customer_home_task_node_item_iv");
                BitmapSetterKt.setSrc(imageView3, (int) R.drawable.customer_skin_icon_task_center_node_done);
                ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(8);
                return;
            }
            ((ImageView) findViewById(R.id.customer_home_task_node_item_iv)).setVisibility(8);
            ((LottieAnimationView) findViewById(R.id.customer_home_task_node_item_lottie_iv)).setVisibility(8);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTaskNodeView$Companion;", "", "()V", "TASK_NODE_STATUS_DONE", "", "TASK_NODE_STATUS_DONE_WITHOUT_REWARD", "TASK_NODE_STATUS_TODO", "TASK_NODE_STATUS_TODO_WITH_COUPON", "TASK_NODE_STATUS_WAIT_GET", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTaskNodeView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
