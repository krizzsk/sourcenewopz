package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.progress.RFProgress;
import com.didi.soda.customer.foundation.rpc.entity.TaskCenterEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.topgun.binder.HomeTaskCenterBinder;
import com.didi.soda.home.topgun.binder.model.HomeTaskCenterRvModel;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000eR\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\u001e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTaskCenterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$HomeTaskCenterBinderLogic;", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;", "calculateConnectLineWidth", "nodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$TaskNodeEntity;", "calculateTipX", "progressGroupView", "Landroid/widget/LinearLayout;", "lineWidth", "middleNode", "Lcom/didi/soda/customer/foundation/rpc/entity/TaskCenterEntity$MiddleNode;", "createConnectLine", "lineLp", "Landroid/view/ViewGroup$LayoutParams;", "initView", "renderNormalTaskNodes", "renderOnlyOne", "renderTaskNodes", "renderTimer", "renderTitle", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTaskCenterView.kt */
public final class HomeTaskCenterView extends ConstraintLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTaskCenterView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTaskCenterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTaskCenterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTaskCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = DisplayUtils.dip2px(context, 0.0f);
        layoutParams.rightMargin = DisplayUtils.dip2px(context, 0.0f);
        setLayoutParams(layoutParams);
        m30522a();
    }

    /* renamed from: a */
    private final void m30522a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_binder_home_task_center, this, true);
    }

    public final void bindData(HomeTaskCenterRvModel homeTaskCenterRvModel, HomeTaskCenterBinder.HomeTaskCenterBinderLogic homeTaskCenterBinderLogic) {
        Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "rvModel");
        Intrinsics.checkNotNullParameter(homeTaskCenterBinderLogic, "logic");
        if (homeTaskCenterRvModel.isTopicAbove()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.customer_home_task_center_container);
            if (constraintLayout != null) {
                constraintLayout.layout(constraintLayout.getPaddingLeft(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_12), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
            }
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.customer_home_task_center_container);
            if (constraintLayout2 != null) {
                constraintLayout2.layout(constraintLayout2.getPaddingLeft(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_36), constraintLayout2.getPaddingRight(), constraintLayout2.getPaddingBottom());
            }
        }
        if (homeTaskCenterRvModel.isTopicBelow()) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.customer_home_task_center_container);
            if (constraintLayout3 != null) {
                constraintLayout3.layout(constraintLayout3.getPaddingLeft(), constraintLayout3.getPaddingTop(), constraintLayout3.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_12));
            }
        } else {
            ConstraintLayout constraintLayout4 = (ConstraintLayout) findViewById(R.id.customer_home_task_center_container);
            if (constraintLayout4 != null) {
                constraintLayout4.layout(constraintLayout4.getPaddingLeft(), constraintLayout4.getPaddingTop(), constraintLayout4.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_36));
            }
        }
        m30526a(homeTaskCenterRvModel);
        m30528b(homeTaskCenterRvModel);
        m30530c(homeTaskCenterRvModel);
        setOnClickListener(new View.OnClickListener(homeTaskCenterRvModel) {
            public final /* synthetic */ HomeTaskCenterRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeTaskCenterView.m30525a(HomeTaskCenterBinder.HomeTaskCenterBinderLogic.this, this.f$1, view);
            }
        });
        homeTaskCenterBinderLogic.onTaskCenterExposure(homeTaskCenterRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30525a(HomeTaskCenterBinder.HomeTaskCenterBinderLogic homeTaskCenterBinderLogic, HomeTaskCenterRvModel homeTaskCenterRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTaskCenterBinderLogic, "$logic");
        Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "$rvModel");
        homeTaskCenterBinderLogic.onTaskCenterClick(homeTaskCenterRvModel);
    }

    /* renamed from: a */
    private final void m30526a(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        CharSequence title = homeTaskCenterRvModel.getTitle();
        boolean z = true;
        ((RichTextView) findViewById(R.id.customer_home_task_center_title)).setText(!(title == null || title.length() == 0) ? homeTaskCenterRvModel.getTitle() : getContext().getString(R.string.FoodC_C_Mission_Centre_HafM));
        CharSequence taskDesc = homeTaskCenterRvModel.getTaskDesc();
        if (!(taskDesc == null || taskDesc.length() == 0)) {
            z = false;
        }
        if (!z) {
            ((RichTextView) findViewById(R.id.customer_home_task_center_subtitle)).setVisibility(0);
            ((RichTextView) findViewById(R.id.customer_home_task_center_subtitle)).setText(homeTaskCenterRvModel.getTaskDesc());
            return;
        }
        ((RichTextView) findViewById(R.id.customer_home_task_center_subtitle)).setVisibility(8);
    }

    /* renamed from: b */
    private final void m30528b(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        int overdueShowType = homeTaskCenterRvModel.getOverdueShowType();
        if (overdueShowType == 1) {
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) findViewById(R.id.customer_home_task_center_title_layout)).getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.rightMargin = CustomerExtentionKt.getPx(R.dimen.customer_210px);
                ((LinearLayout) findViewById(R.id.customer_home_task_center_title_layout)).setLayoutParams(marginLayoutParams);
                ((CountDownTimer) findViewById(R.id.customer_home_task_center_timer)).setupTime(homeTaskCenterRvModel);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        } else if (overdueShowType != 2) {
            ((CountDownTimer) findViewById(R.id.customer_home_task_center_timer)).setVisibility(8);
        } else {
            ViewGroup.LayoutParams layoutParams2 = ((LinearLayout) findViewById(R.id.customer_home_task_center_title_layout)).getLayoutParams();
            if (layoutParams2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.rightMargin = CustomerExtentionKt.getPx(R.dimen.customer_306px);
                ((LinearLayout) findViewById(R.id.customer_home_task_center_title_layout)).setLayoutParams(marginLayoutParams2);
                ((CountDownTimer) findViewById(R.id.customer_home_task_center_timer)).setupTime(homeTaskCenterRvModel);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    /* renamed from: c */
    private final void m30530c(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        List<TaskCenterEntity.TaskNodeEntity> taskNodeList;
        if (!CollectionsUtil.isEmpty(homeTaskCenterRvModel.getTaskNodeList()) && (taskNodeList = homeTaskCenterRvModel.getTaskNodeList()) != null) {
            if (taskNodeList.size() > 4) {
                taskNodeList = taskNodeList.subList(0, 4);
            }
            taskNodeList.get(taskNodeList.size() - 1).setMiddleNode((TaskCenterEntity.MiddleNode) null);
            if (taskNodeList.size() >= 2) {
                m30527a(homeTaskCenterRvModel, taskNodeList);
            } else if (taskNodeList.size() == 1) {
                m30529b(homeTaskCenterRvModel, taskNodeList);
            }
        }
    }

    /* renamed from: a */
    private final void m30527a(HomeTaskCenterRvModel homeTaskCenterRvModel, List<TaskCenterEntity.TaskNodeEntity> list) {
        ((LinearLayout) findViewById(R.id.ll_only_one)).setVisibility(8);
        ((RichTextView) findViewById(R.id.customer_home_task_center_subtitle)).setVisibility(0);
        ((LinearLayout) findViewById(R.id.customer_home_task_node_list_layout)).setVisibility(0);
        ((LinearLayout) findViewById(R.id.customer_home_task_node_list_layout)).removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10);
        layoutParams.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10);
        layoutParams.gravity = 16;
        layoutParams.width = m30521a(homeTaskCenterRvModel.getTaskNodeList());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64));
        layoutParams2.gravity = 16;
        for (TaskCenterEntity.TaskNodeEntity next : list) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            HomeTaskNodeView homeTaskNodeView = new HomeTaskNodeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            ((LinearLayout) findViewById(R.id.customer_home_task_node_list_layout)).addView(homeTaskNodeView, layoutParams2);
            TaskCenterEntity.MiddleNode middleNode = next.getMiddleNode();
            if (middleNode != null) {
                m30524a(middleNode, (ViewGroup.LayoutParams) layoutParams);
            }
            homeTaskNodeView.bindData(next);
        }
    }

    /* renamed from: b */
    private final void m30529b(HomeTaskCenterRvModel homeTaskCenterRvModel, List<TaskCenterEntity.TaskNodeEntity> list) {
        ((LinearLayout) findViewById(R.id.ll_only_one)).setVisibility(0);
        ((LinearLayout) findViewById(R.id.customer_home_task_node_list_layout)).setVisibility(8);
        ((RichTextView) findViewById(R.id.customer_home_task_center_subtitle)).setVisibility(8);
        ((RichTextView) findViewById(R.id.tv_only_one)).setText(homeTaskCenterRvModel.getTaskDesc());
        ((HomeTaskNodeView) findViewById(R.id.node_view)).bindData(list.get(0));
    }

    /* renamed from: a */
    private final void m30524a(TaskCenterEntity.MiddleNode middleNode, ViewGroup.LayoutParams layoutParams) {
        int i;
        View inflate = View.inflate(getContext(), R.layout.customer_view_home_taskcenter_progress_tip, (ViewGroup) null);
        if (inflate != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            ((LinearLayout) findViewById(R.id.customer_home_task_node_list_layout)).addView(linearLayout, layoutParams);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RFProgress rFProgress = new RFProgress(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            if (middleNode.getTotalNum() != 0) {
                rFProgress.setProgress(((float) middleNode.getCompletedNum()) / ((float) middleNode.getTotalNum()));
            } else {
                rFProgress.setProgress(0.0f);
            }
            linearLayout.addView(rFProgress);
            if (TextUtils.isEmpty(middleNode.getText()) || middleNode.getCompletedNum() == 0 || middleNode.getCompletedNum() == middleNode.getTotalNum()) {
                i = 0;
            } else {
                i = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_45);
                ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).setText(middleNode.getText());
                ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).setMaxWidth(layoutParams.width);
                ((ConstraintLayout) linearLayout.findViewById(R.id.cl_task_bub)).setVisibility(0);
                m30523a(linearLayout, layoutParams.width, middleNode);
                if (((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).getWidth() > layoutParams.width) {
                    ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).setWidth(layoutParams.width);
                }
            }
            linearLayout.setPadding(0, 0, 0, i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    /* renamed from: a */
    private final void m30523a(LinearLayout linearLayout, int i, TaskCenterEntity.MiddleNode middleNode) {
        float measureText = ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).getPaint().measureText(middleNode.getText()) + ((float) ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).getPaddingLeft()) + ((float) ((RFTextView) linearLayout.findViewById(R.id.tv_progress_bub)).getPaddingRight());
        float f = (float) i;
        float completedNum = ((((float) middleNode.getCompletedNum()) / ((float) middleNode.getTotalNum())) * f) - (measureText / 2.0f);
        if (completedNum + measureText > f) {
            completedNum = f - measureText;
            ((ImageView) linearLayout.findViewById(R.id.iv_down_arrow)).setVisibility(4);
        }
        if (completedNum < 0.0f) {
            ((ImageView) linearLayout.findViewById(R.id.iv_down_arrow)).setVisibility(4);
            completedNum = 0.0f;
        }
        ((ConstraintLayout) linearLayout.findViewById(R.id.cl_task_bub)).setX(completedNum);
    }

    /* renamed from: a */
    private final int m30521a(List<TaskCenterEntity.TaskNodeEntity> list) {
        if ((list == null ? 0 : list.size()) == 2) {
            return ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_216);
        }
        if (list == null) {
            return 0;
        }
        int size = list.size() - 1;
        return ((((CustomerSystemUtil.getScreenWidth(getContext()) - (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32) * 2)) - (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24) * 2)) - ((ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10) * 2) * size)) - (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64) * list.size())) / size;
    }
}
