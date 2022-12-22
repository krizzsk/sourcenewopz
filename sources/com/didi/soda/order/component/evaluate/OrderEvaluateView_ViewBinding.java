package com.didi.soda.order.component.evaluate;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.order.view.OrderEvaluateCommentTagView;
import com.didi.soda.order.view.OrderEvaluateFaceView;
import com.didi.soda.order.view.OrderEvaluateHeaderInfoView;
import com.didi.soda.order.view.OrderEvaluateScoreView;
import com.taxis99.R;

public class OrderEvaluateView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OrderEvaluateView f43401a;

    public OrderEvaluateView_ViewBinding(OrderEvaluateView orderEvaluateView, View view) {
        this.f43401a = orderEvaluateView;
        orderEvaluateView.mBusinessCommentTagView = (OrderEvaluateCommentTagView) Utils.findRequiredViewAsType(view, R.id.customer_business_comment_tag_container, "field 'mBusinessCommentTagView'", OrderEvaluateCommentTagView.class);
        orderEvaluateView.mBusinessSupplementTip = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_business_choose_supplement, "field 'mBusinessSupplementTip'", TextView.class);
        orderEvaluateView.mRiderSupplementTip = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_rider_choose_supplement, "field 'mRiderSupplementTip'", TextView.class);
        orderEvaluateView.mBusinessHeaderInfoView = (OrderEvaluateHeaderInfoView) Utils.findRequiredViewAsType(view, R.id.customer_business_header_info, "field 'mBusinessHeaderInfoView'", OrderEvaluateHeaderInfoView.class);
        orderEvaluateView.mRiderCommentTagView = (OrderEvaluateCommentTagView) Utils.findRequiredViewAsType(view, R.id.customer_rider_comment_tag_container, "field 'mRiderCommentTagView'", OrderEvaluateCommentTagView.class);
        orderEvaluateView.mRiderHeaderInfoView = (OrderEvaluateHeaderInfoView) Utils.findRequiredViewAsType(view, R.id.customer_rider_header_info, "field 'mRiderHeaderInfoView'", OrderEvaluateHeaderInfoView.class);
        orderEvaluateView.mRiderFaceView = (OrderEvaluateFaceView) Utils.findRequiredViewAsType(view, R.id.customer_rider_face_container, "field 'mRiderFaceView'", OrderEvaluateFaceView.class);
        orderEvaluateView.mBusinessScoreView = (OrderEvaluateScoreView) Utils.findRequiredViewAsType(view, R.id.customer_business_score_container, "field 'mBusinessScoreView'", OrderEvaluateScoreView.class);
        orderEvaluateView.mSubmitBtn = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_bt_submit, "field 'mSubmitBtn'", RFMainButton.class);
        orderEvaluateView.mAbnormalView = (TopGunAbnormalView) Utils.findRequiredViewAsType(view, R.id.customer_custom_evaluation_abnormal, "field 'mAbnormalView'", TopGunAbnormalView.class);
        orderEvaluateView.mContentContainer = (ScrollView) Utils.findRequiredViewAsType(view, R.id.customer_sv_content_container, "field 'mContentContainer'", ScrollView.class);
        orderEvaluateView.mRootContainer = Utils.findRequiredView(view, R.id.customer_ll_root_container, "field 'mRootContainer'");
        orderEvaluateView.mBackView = Utils.findRequiredView(view, R.id.customer_iv_page_back, "field 'mBackView'");
        orderEvaluateView.mButtonContainer = Utils.findRequiredView(view, R.id.customer_fl_button_container, "field 'mButtonContainer'");
        orderEvaluateView.itemEvaluateLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_business_item_evaluation, "field 'itemEvaluateLinear'", LinearLayout.class);
    }

    public void unbind() {
        OrderEvaluateView orderEvaluateView = this.f43401a;
        if (orderEvaluateView != null) {
            this.f43401a = null;
            orderEvaluateView.mBusinessCommentTagView = null;
            orderEvaluateView.mBusinessSupplementTip = null;
            orderEvaluateView.mRiderSupplementTip = null;
            orderEvaluateView.mBusinessHeaderInfoView = null;
            orderEvaluateView.mRiderCommentTagView = null;
            orderEvaluateView.mRiderHeaderInfoView = null;
            orderEvaluateView.mRiderFaceView = null;
            orderEvaluateView.mBusinessScoreView = null;
            orderEvaluateView.mSubmitBtn = null;
            orderEvaluateView.mAbnormalView = null;
            orderEvaluateView.mContentContainer = null;
            orderEvaluateView.mRootContainer = null;
            orderEvaluateView.mBackView = null;
            orderEvaluateView.mButtonContainer = null;
            orderEvaluateView.itemEvaluateLinear = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
