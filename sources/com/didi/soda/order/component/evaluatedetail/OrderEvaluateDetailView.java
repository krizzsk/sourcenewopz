package com.didi.soda.order.component.evaluatedetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CircleImageView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.component.evaluatedetail.Contract;
import com.didi.soda.order.view.EvaluateDetailBusinessItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010*H\u0002J\u001c\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\n2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0016J\u000e\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020\nJ\b\u0010>\u001a\u000203H\u0014J\u0012\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010*H\u0002J\b\u0010A\u001a\u000203H\u0002J\u001a\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010*H\u0002J\u001a\u0010E\u001a\u0002032\u0010\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010GH\u0002J\u0012\u0010H\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010*H\u0002J\u0012\u0010I\u001a\u0002032\b\u0010J\u001a\u0004\u0018\u00010*H\u0002J\u001a\u0010K\u001a\u0002032\u0006\u0010C\u001a\u00020&2\b\u0010D\u001a\u0004\u0018\u00010*H\u0002J\"\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010*2\u0006\u0010N\u001a\u00020&H\u0002J \u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020\f2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010GH\u0002J\u0012\u0010R\u001a\u0002032\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X.¢\u0006\u0002\n\u0000¨\u0006T"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatedetail/OrderEvaluateDetailView;", "Lcom/didi/soda/order/component/evaluatedetail/Contract$AbsOrderEvaluateDetailView;", "()V", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "backBtn", "Lcom/didi/soda/customer/widget/text/IconTextView;", "businessCommentTv", "Lcom/didi/rfusion/widget/RFTextView;", "businessDivider", "Landroid/view/View;", "businessFlowLayout", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "businessHeaderIv", "Lcom/didi/soda/customer/widget/CircleImageView;", "businessNameTv", "businessRootContainer", "contentContainer", "deliveryDescTv", "faceIv", "Lcom/didi/rfusion/widget/RFIconView;", "faceLayout", "faceTipTv", "itemEvaluateLinear", "Landroid/widget/LinearLayout;", "photoLayout", "riderCommentTv", "riderDivider", "riderFlowLayout", "riderHeaderIv", "riderNameTv", "riderRootContainer", "starContainer", "starLayout", "starTipTv", "Landroid/widget/TextView;", "titleTv", "calculatePhotoViewBorder", "", "createAbnormalViewModel", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "errorMsg", "", "createCheckedTextView", "Landroid/widget/CheckedTextView;", "tag", "createPhotoImageView", "Landroid/widget/ImageView;", "imageUrl", "position", "hideAbnormalView", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initEvaluationView", "orderEvaluationEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationEntity;", "initView", "root", "onCreate", "renderBusinessComment", "comment", "renderBusinessDivider", "renderFaceView", "score", "scoreTip", "renderPhotoView", "imageList", "", "renderRiderComment", "renderRiderDeliveryDesc", "deliveryDesc", "renderStarView", "setHeaderImage", "headerView", "defaultImage", "setTagList", "flowLayout", "tagList", "showErrorNetView", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluateDetailView.kt */
public final class OrderEvaluateDetailView extends Contract.AbsOrderEvaluateDetailView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GOOD_STAR_COUNT = 4;
    public static final int MAX_PHOTO_COUNT = 5;
    public static final int MAX_STAR_COUNT = 5;
    public static final float PHOTO_MARGIN = 9.0f;

    /* renamed from: a */
    private IconTextView f43403a;

    /* renamed from: b */
    private TextView f43404b;

    /* renamed from: c */
    private View f43405c;

    /* renamed from: d */
    private View f43406d;

    /* renamed from: e */
    private CircleImageView f43407e;

    /* renamed from: f */
    private RFTextView f43408f;

    /* renamed from: g */
    private View f43409g;

    /* renamed from: h */
    private LinearLayout f43410h;

    /* renamed from: i */
    private TextView f43411i;

    /* renamed from: j */
    private NovaFlowLayout f43412j;

    /* renamed from: k */
    private View f43413k;

    /* renamed from: l */
    private RFTextView f43414l;

    /* renamed from: m */
    private LinearLayout f43415m;

    /* renamed from: n */
    private LinearLayout f43416n;

    /* renamed from: o */
    private View f43417o;

    /* renamed from: p */
    private CircleImageView f43418p;

    /* renamed from: q */
    private RFTextView f43419q;

    /* renamed from: r */
    private RFTextView f43420r;

    /* renamed from: s */
    private View f43421s;

    /* renamed from: t */
    private RFIconView f43422t;

    /* renamed from: u */
    private RFTextView f43423u;

    /* renamed from: v */
    private NovaFlowLayout f43424v;

    /* renamed from: w */
    private View f43425w;

    /* renamed from: x */
    private RFTextView f43426x;

    /* renamed from: y */
    private TopGunAbnormalView f43427y;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_order_evaluate_detail, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initView(it)\n        }");
        return inflate;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_iv_page_back)");
        this.f43403a = (IconTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_tv_title_label)");
        this.f43404b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_sv_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…mer_sv_content_container)");
        this.f43405c = findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_business_evaluate_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…iness_evaluate_container)");
        this.f43406d = findViewById4;
        View findViewById5 = view.findViewById(R.id.customer_iv_business_header_image);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…iv_business_header_image)");
        this.f43407e = (CircleImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.customer_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.customer_business_name)");
        this.f43408f = (RFTextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.customer_star_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.customer_star_layout)");
        this.f43409g = findViewById7;
        View findViewById8 = view.findViewById(R.id.customer_ll_star_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.customer_ll_star_container)");
        this.f43410h = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.customer_star_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.customer_star_tip)");
        this.f43411i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.customer_nfl_business_evaluate_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.c…fl_business_evaluate_tag)");
        this.f43412j = (NovaFlowLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.middle_business_line);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "root.findViewById(R.id.middle_business_line)");
        this.f43413k = findViewById11;
        View findViewById12 = view.findViewById(R.id.customer_evaluate_photo_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "root.findViewById(R.id.customer_evaluate_photo_ll)");
        this.f43415m = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.customer_business_evaluate_comment);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "root.findViewById(R.id.c…usiness_evaluate_comment)");
        this.f43414l = (RFTextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.customer_evaluate_item);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "root.findViewById(R.id.customer_evaluate_item)");
        this.f43416n = (LinearLayout) findViewById14;
        View findViewById15 = view.findViewById(R.id.customer_rider_evaluate_container);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "root.findViewById(R.id.c…rider_evaluate_container)");
        this.f43417o = findViewById15;
        View findViewById16 = view.findViewById(R.id.customer_iv_rider_header_image);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "root.findViewById(R.id.c…er_iv_rider_header_image)");
        this.f43418p = (CircleImageView) findViewById16;
        View findViewById17 = view.findViewById(R.id.customer_rider_name);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "root.findViewById(R.id.customer_rider_name)");
        this.f43419q = (RFTextView) findViewById17;
        View findViewById18 = view.findViewById(R.id.customer_delivery_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "root.findViewById(R.id.customer_delivery_desc)");
        this.f43420r = (RFTextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.customer_face_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "root.findViewById(R.id.customer_face_layout)");
        this.f43421s = findViewById19;
        View findViewById20 = view.findViewById(R.id.customer_iv_face);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "root.findViewById(R.id.customer_iv_face)");
        this.f43422t = (RFIconView) findViewById20;
        View findViewById21 = view.findViewById(R.id.customer_face_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "root.findViewById(R.id.customer_face_tip)");
        this.f43423u = (RFTextView) findViewById21;
        View findViewById22 = view.findViewById(R.id.customer_nfl_rider_evaluate_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "root.findViewById(R.id.c…r_nfl_rider_evaluate_tag)");
        this.f43424v = (NovaFlowLayout) findViewById22;
        View findViewById23 = view.findViewById(R.id.middle_rider_line);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "root.findViewById(R.id.middle_rider_line)");
        this.f43425w = findViewById23;
        View findViewById24 = view.findViewById(R.id.customer_rider_evaluate_comment);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "root.findViewById(R.id.c…r_rider_evaluate_comment)");
        this.f43426x = (RFTextView) findViewById24;
        View findViewById25 = view.findViewById(R.id.customer_custom_evaluation_abnormal);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "root.findViewById(R.id.c…stom_evaluation_abnormal)");
        this.f43427y = (TopGunAbnormalView) findViewById25;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        IconTextView iconTextView = this.f43403a;
        TextView textView = null;
        if (iconTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            iconTextView = null;
        }
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateDetailView.m30734a(OrderEvaluateDetailView.this, view);
            }
        });
        TextView textView2 = this.f43404b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        } else {
            textView = textView2;
        }
        textView.setText(getString(R.string.FoodC_evaluation_Order_evaluation_DIJO));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30734a(OrderEvaluateDetailView orderEvaluateDetailView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).closePage();
    }

    public void initEvaluationView(OrderEvaluationEntity orderEvaluationEntity) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(orderEvaluationEntity, "orderEvaluationEntity");
        View view = this.f43405c;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setVisibility(0);
        ShopEvaluationEntity shopEvaluationEntity = orderEvaluationEntity.shop;
        if (shopEvaluationEntity == null || !shopEvaluationEntity.hasEval) {
            View view2 = this.f43406d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessRootContainer");
                view2 = null;
            }
            view2.setVisibility(8);
        } else {
            CircleImageView circleImageView = this.f43407e;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessHeaderIv");
                circleImageView = null;
            }
            m30732a(circleImageView, shopEvaluationEntity.shopImg, R.drawable.customer_img_business_default_logo);
            RFTextView rFTextView = this.f43408f;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessNameTv");
                rFTextView = null;
            }
            String str = shopEvaluationEntity.shopName;
            if (str == null) {
                charSequence2 = "";
            } else {
                charSequence2 = str;
            }
            rFTextView.setText(charSequence2);
            if (shopEvaluationEntity.score != 0) {
                m30731a(shopEvaluationEntity.score, shopEvaluationEntity.scoreDesc);
                NovaFlowLayout novaFlowLayout = this.f43412j;
                if (novaFlowLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessFlowLayout");
                    novaFlowLayout = null;
                }
                m30733a(novaFlowLayout, shopEvaluationEntity.tags);
                m30736a(shopEvaluationEntity.imgs);
                m30741c(shopEvaluationEntity.content);
                m30738b();
            }
        }
        RiderEvaluationEntity riderEvaluationEntity = orderEvaluationEntity.rider;
        if (riderEvaluationEntity == null || !riderEvaluationEntity.hasEval) {
            View view3 = this.f43417o;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderRootContainer");
                view3 = null;
            }
            view3.setVisibility(8);
        } else {
            CircleImageView circleImageView2 = this.f43418p;
            if (circleImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderHeaderIv");
                circleImageView2 = null;
            }
            m30732a(circleImageView2, riderEvaluationEntity.riderImg, R.drawable.customer_icon_default_delivery);
            RFTextView rFTextView2 = this.f43419q;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("riderNameTv");
                rFTextView2 = null;
            }
            String str2 = riderEvaluationEntity.riderName;
            if (str2 != null) {
                charSequence = str2;
            }
            rFTextView2.setText(charSequence);
            if (riderEvaluationEntity.score != 0) {
                m30742d(riderEvaluationEntity.orderFinishTime);
                m30739b(riderEvaluationEntity.score, riderEvaluationEntity.scoreDesc);
                NovaFlowLayout novaFlowLayout2 = this.f43424v;
                if (novaFlowLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("riderFlowLayout");
                    novaFlowLayout2 = null;
                }
                m30733a(novaFlowLayout2, riderEvaluationEntity.tags);
                m30743e(riderEvaluationEntity.content);
            }
        }
        if (CollectionsUtil.isEmpty(orderEvaluationEntity.items)) {
            LinearLayout linearLayout2 = this.f43416n;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.f43416n;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = this.f43416n;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
            linearLayout4 = null;
        }
        linearLayout4.removeAllViews();
        List<OrderEvaluationItemsListEntity> list = orderEvaluationEntity.items;
        if (list != null) {
            for (OrderEvaluationItemsListEntity orderEvaluationItemsListEntity : list) {
                LinearLayout linearLayout5 = this.f43416n;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
                    linearLayout5 = null;
                }
                Context context = linearLayout5.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemEvaluateLinear.context");
                EvaluateDetailBusinessItemView evaluateDetailBusinessItemView = new EvaluateDetailBusinessItemView(context, orderEvaluationItemsListEntity.getItemId(), orderEvaluationItemsListEntity.getItemName(), orderEvaluationItemsListEntity.getScore());
                LinearLayout linearLayout6 = this.f43416n;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemEvaluateLinear");
                    linearLayout6 = null;
                }
                linearLayout6.addView(evaluateDetailBusinessItemView);
            }
        }
    }

    public void showErrorNetView(String str) {
        View view = this.f43405c;
        TopGunAbnormalView topGunAbnormalView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setVisibility(8);
        TopGunAbnormalView topGunAbnormalView2 = this.f43427y;
        if (topGunAbnormalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView2 = null;
        }
        boolean z = false;
        topGunAbnormalView2.setVisibility(0);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            str = "";
        }
        TopGunAbnormalView topGunAbnormalView3 = this.f43427y;
        if (topGunAbnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        } else {
            topGunAbnormalView = topGunAbnormalView3;
        }
        topGunAbnormalView.show(m30730a(str));
    }

    public void hideAbnormalView() {
        TopGunAbnormalView topGunAbnormalView = this.f43427y;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
    }

    /* renamed from: a */
    private final TopGunAbnormalViewModel m30730a(String str) {
        $$Lambda$OrderEvaluateDetailView$vR2TSp8zkAX2Wzr1D0fymOrPHAU r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateDetailView.m30740b(OrderEvaluateDetailView.this, view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30740b(OrderEvaluateDetailView orderEvaluateDetailView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        orderEvaluateDetailView.hideAbnormalView();
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).retryRequest();
    }

    /* renamed from: a */
    private final void m30732a(ImageView imageView, String str, int i) {
        imageView.setBackground(getResources().getDrawable(i));
        if (!TextUtils.isEmpty(str)) {
            FlyImageLoader.loadImageUnspecified(getContext(), str).placeholder(i).into(imageView);
        }
    }

    /* renamed from: a */
    private final void m30731a(int i, String str) {
        View view = null;
        if (i >= 100) {
            View view2 = this.f43409g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            LinearLayout linearLayout = this.f43410h;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.f43410h;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            int i2 = i / 100;
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                TextView textView = this.f43411i;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView = null;
                }
                textView.setText(charSequence);
                TextView textView2 = this.f43411i;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView2 = null;
                }
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.f43411i;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            }
            if (i2 >= 4) {
                TextView textView4 = this.f43411i;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView4 = null;
                }
                textView4.setTextColor(SkinUtil.getBrandPrimaryColor());
            } else {
                TextView textView5 = this.f43411i;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starTipTv");
                    textView5 = null;
                }
                textView5.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            }
            int i3 = i2 >= 4 ? R.drawable.customer_skin_ic_evaluation_star : R.drawable.customer_icon_evaluation_star_gray;
            int i4 = 1;
            while (true) {
                int i5 = i4 + 1;
                ImageView imageView = new ImageView(getContext());
                if (i2 >= i4) {
                    imageView.setImageResource(i3);
                } else {
                    imageView.setImageResource(R.drawable.customer_icon_evaluation_star_hollow);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ResourceHelper.getDimensionPixelSize(R.dimen.customer_28px), ResourceHelper.getDimensionPixelSize(R.dimen.customer_28px));
                if (i4 > 1) {
                    layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_10px);
                }
                imageView.setLayoutParams(layoutParams);
                LinearLayout linearLayout3 = this.f43410h;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("starContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(imageView);
                if (i5 <= 5) {
                    i4 = i5;
                } else {
                    return;
                }
            }
        } else {
            View view3 = this.f43409g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("starLayout");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m30733a(NovaFlowLayout novaFlowLayout, List<String> list) {
        Collection collection = list;
        int i = 0;
        if (!(collection == null || collection.isEmpty())) {
            novaFlowLayout.setVisibility(0);
            novaFlowLayout.removeAllViews();
            List arrayList = new ArrayList();
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(m30737b(str));
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            novaFlowLayout.addView(arrayList);
            return;
        }
        novaFlowLayout.setVisibility(8);
    }

    /* renamed from: a */
    private final void m30736a(List<String> list) {
        List<String> list2 = list;
        Collection collection = list2;
        LinearLayout linearLayout = null;
        if (!(collection == null || collection.isEmpty())) {
            LinearLayout linearLayout2 = this.f43415m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            int size = list.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String str = list2.get(i);
                    CharSequence charSequence = str;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        ImageView a = m30729a(str, i);
                        if (a != null) {
                            a.setOnClickListener(new View.OnClickListener(a, str) {
                                public final /* synthetic */ ImageView f$1;
                                public final /* synthetic */ String f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    OrderEvaluateDetailView.m30735a(OrderEvaluateDetailView.this, this.f$1, this.f$2, view);
                                }
                            });
                        }
                        LinearLayout linearLayout3 = this.f43415m;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
                            linearLayout3 = null;
                        }
                        linearLayout3.addView(a);
                        FlyImageLoader.loadImage1x1(getContext(), str).placeholder((int) R.drawable.customer_skin_icon_business_round_logo).error((int) R.drawable.customer_skin_icon_business_round_logo).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(a);
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            LinearLayout linearLayout4 = this.f43415m;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
            } else {
                linearLayout = linearLayout4;
            }
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30735a(OrderEvaluateDetailView orderEvaluateDetailView, ImageView imageView, String str, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateDetailView, "this$0");
        ((Contract.AbsOrderEvaluateDetailPresenter) orderEvaluateDetailView.getPresenter()).onImageItemClick(imageView, str);
    }

    /* renamed from: b */
    private final CheckedTextView m30737b(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        CheckedTextView checkedTextView = new CheckedTextView(getContext());
        checkedTextView.setText(charSequence);
        checkedTextView.setGravity(17);
        checkedTextView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.customer_24px));
        checkedTextView.setMaxWidth(CustomerSystemUtil.getScreenWidth(getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px));
        checkedTextView.setSingleLine();
        checkedTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        checkedTextView.setBackground(getResources().getDrawable(R.drawable.customer_shape_evaluation_tag_background));
        checkedTextView.setEllipsize(TextUtils.TruncateAt.END);
        checkedTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.customer_24px);
        checkedTextView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(checkedTextView, IToolsService.FontType.LIGHT);
        return checkedTextView;
    }

    /* renamed from: a */
    private final ImageView m30729a(String str, int i) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        int a = m30728a();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 9.0f);
        }
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* renamed from: a */
    private final int m30728a() {
        return ((CustomerSystemUtil.getScreenWidth(getContext()) - (DisplayUtils.dip2px(getContext(), 20.0f) * 2)) - (DisplayUtils.dip2px(getContext(), 9.0f) * 4)) / 5;
    }

    /* renamed from: c */
    private final void m30741c(String str) {
        CharSequence charSequence = str;
        RFTextView rFTextView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RFTextView rFTextView2 = this.f43414l;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
                rFTextView2 = null;
            }
            rFTextView2.setVisibility(0);
            RFTextView rFTextView3 = this.f43414l;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
            } else {
                rFTextView = rFTextView3;
            }
            rFTextView.setText(charSequence);
            return;
        }
        RFTextView rFTextView4 = this.f43414l;
        if (rFTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
        } else {
            rFTextView = rFTextView4;
        }
        rFTextView.setVisibility(8);
    }

    /* renamed from: b */
    private final void m30738b() {
        LinearLayout linearLayout = this.f43415m;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoLayout");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() == 8) {
            RFTextView rFTextView = this.f43414l;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessCommentTv");
                rFTextView = null;
            }
            if (rFTextView.getVisibility() == 8) {
                View view2 = this.f43413k;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("businessDivider");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                return;
            }
        }
        View view3 = this.f43413k;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessDivider");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    /* renamed from: d */
    private final void m30742d(String str) {
        CharSequence charSequence = str;
        RFTextView rFTextView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RFTextView rFTextView2 = this.f43420r;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
                rFTextView2 = null;
            }
            rFTextView2.setVisibility(0);
            RFTextView rFTextView3 = this.f43420r;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
            } else {
                rFTextView = rFTextView3;
            }
            rFTextView.setText(charSequence);
            return;
        }
        RFTextView rFTextView4 = this.f43420r;
        if (rFTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryDescTv");
        } else {
            rFTextView = rFTextView4;
        }
        rFTextView.setVisibility(8);
    }

    /* renamed from: b */
    private final void m30739b(int i, String str) {
        View view = null;
        if (i >= 100) {
            View view2 = this.f43421s;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        } else if (i != 0) {
            if (i == 2) {
                RFIconView rFIconView = this.f43422t;
                if (rFIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView = null;
                }
                rFIconView.setVisibility(0);
                RFIconView rFIconView2 = this.f43422t;
                if (rFIconView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView2 = null;
                }
                rFIconView2.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
                RFIconView rFIconView3 = this.f43422t;
                if (rFIconView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView3 = null;
                }
                rFIconView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
                RFTextView rFTextView = this.f43423u;
                if (rFTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView = null;
                }
                rFTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
            } else if (i != 10) {
                RFIconView rFIconView4 = this.f43422t;
                if (rFIconView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView4 = null;
                }
                rFIconView4.setVisibility(8);
            } else {
                RFIconView rFIconView5 = this.f43422t;
                if (rFIconView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView5 = null;
                }
                rFIconView5.setVisibility(0);
                RFIconView rFIconView6 = this.f43422t;
                if (rFIconView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView6 = null;
                }
                rFIconView6.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
                RFIconView rFIconView7 = this.f43422t;
                if (rFIconView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                    rFIconView7 = null;
                }
                rFIconView7.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                RFTextView rFTextView2 = this.f43423u;
                if (rFTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView2 = null;
                }
                rFTextView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
            }
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                RFTextView rFTextView3 = this.f43423u;
                if (rFTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView3 = null;
                }
                rFTextView3.setText(charSequence);
                RFTextView rFTextView4 = this.f43423u;
                if (rFTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView4 = null;
                }
                rFTextView4.setVisibility(0);
            } else {
                RFTextView rFTextView5 = this.f43423u;
                if (rFTextView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView5 = null;
                }
                rFTextView5.setVisibility(8);
            }
            RFIconView rFIconView8 = this.f43422t;
            if (rFIconView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceIv");
                rFIconView8 = null;
            }
            if (rFIconView8.getVisibility() == 8) {
                RFTextView rFTextView6 = this.f43423u;
                if (rFTextView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faceTipTv");
                    rFTextView6 = null;
                }
                if (rFTextView6.getVisibility() == 8) {
                    View view3 = this.f43421s;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
                    } else {
                        view = view3;
                    }
                    view.setVisibility(8);
                    return;
                }
            }
            View view4 = this.f43421s;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("faceLayout");
            } else {
                view = view4;
            }
            view.setVisibility(0);
        }
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m30743e(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0 = 0
            if (r6 == 0) goto L_0x000e
            int r1 = r6.length()
            if (r1 != 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = 1
        L_0x000f:
            java.lang.String r2 = "riderDivider"
            java.lang.String r3 = "riderCommentTv"
            r4 = 0
            if (r1 != 0) goto L_0x003b
            com.didi.rfusion.widget.RFTextView r1 = r5.f43426x
            if (r1 != 0) goto L_0x0020
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r4
        L_0x0020:
            r1.setVisibility(r0)
            android.view.View r1 = r5.f43425w
            if (r1 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r4
        L_0x002b:
            r1.setVisibility(r0)
            com.didi.rfusion.widget.RFTextView r0 = r5.f43426x
            if (r0 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0037
        L_0x0036:
            r4 = r0
        L_0x0037:
            r4.setText(r6)
            goto L_0x0054
        L_0x003b:
            com.didi.rfusion.widget.RFTextView r6 = r5.f43426x
            if (r6 != 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r6 = r4
        L_0x0043:
            r0 = 8
            r6.setVisibility(r0)
            android.view.View r6 = r5.f43425w
            if (r6 != 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0051
        L_0x0050:
            r4 = r6
        L_0x0051:
            r4.setVisibility(r0)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.evaluatedetail.OrderEvaluateDetailView.m30743e(java.lang.String):void");
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatedetail/OrderEvaluateDetailView$Companion;", "", "()V", "GOOD_STAR_COUNT", "", "MAX_PHOTO_COUNT", "MAX_STAR_COUNT", "PHOTO_MARGIN", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderEvaluateDetailView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
