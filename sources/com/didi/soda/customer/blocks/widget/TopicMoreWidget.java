package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.taxis99.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "topic_has_more_v1")
@Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u00102\u001a\u0002032\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000205\u0018\u00010\fH\u0016J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\b\u0010:\u001a\u00020\tH\u0016J\b\u0010;\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020=H\u0016J\u0006\u0010>\u001a\u00020\tJ\b\u0010?\u001a\u00020\tH\u0016J\b\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u000203H\u0016J\u0012\u0010B\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u00010(H\u0016J\u001e\u0010D\u001a\u0002082\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000205\u0018\u00010\fH\u0016J\b\u0010E\u001a\u000208H\u0016J\b\u0010F\u001a\u000208H\u0016J\u001c\u0010G\u001a\u0002032\b\u0010H\u001a\u0004\u0018\u00010\r2\b\u0010I\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010J\u001a\u0002032\b\u0010I\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010K\u001a\u0002032\b\u0010I\u001a\u0004\u0018\u00010\rH\u0002R\"\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006L"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/TopicMoreWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/customer/blocks/ItemOperationListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dynamicChildren", "Ljava/util/HashMap;", "", "getDynamicChildren", "()Ljava/util/HashMap;", "mDescWidget", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getMDescWidget", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "setMDescWidget", "(Lcom/didi/soda/customer/widget/text/RichTextView;)V", "mHeight", "getMHeight", "()I", "setMHeight", "(I)V", "mIconWidget", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "getMIconWidget", "()Lcom/didi/soda/customer/widget/text/IconRichTextView;", "setMIconWidget", "(Lcom/didi/soda/customer/widget/text/IconRichTextView;)V", "mTopicRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "getMTopicRvModel", "()Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;", "setMTopicRvModel", "(Lcom/didi/soda/home/topgun/binder/model/HomeHorizontalScrollTopicRvModel;)V", "mWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "getMWidgetNode", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setMWidgetNode", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "mWidgetType", "getMWidgetType", "()Ljava/lang/String;", "setMWidgetType", "(Ljava/lang/String;)V", "bindProps", "", "props", "", "doWrapButton", "needWrap", "", "doWrapTextLine", "getImageHeight", "getResId", "getView", "Landroid/view/View;", "getWidgetHeight", "getWidgetType", "initView", "onAppear", "setWidgetNode", "widgetNode", "shouldShow", "shouldWarpButton", "shouldWarpTextLine", "updateBackgroundColor", "bgColor", "widgetType", "updateHeight", "updateRadius", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicMoreWidget.kt */
public final class TopicMoreWidget extends ConstraintLayout implements Buildable, ItemOperationListener {

    /* renamed from: a */
    private final HashMap<String, Buildable> f40740a;

    /* renamed from: b */
    private WidgetNodeModel f40741b;

    /* renamed from: c */
    private HomeHorizontalScrollTopicRvModel f40742c;

    /* renamed from: d */
    private int f40743d;

    /* renamed from: e */
    private String f40744e;
    public RichTextView mDescWidget;
    public IconRichTextView mIconWidget;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicMoreWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopicMoreWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getResId() {
        return R.layout.customer_item_topic_view_more_blocks;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void doWrapButton(boolean z) {
    }

    public void doWrapTextLine(boolean z) {
    }

    public int getImageHeight() {
        return 0;
    }

    public boolean shouldWarpButton() {
        return false;
    }

    public boolean shouldWarpTextLine() {
        return false;
    }

    public void bindChildren(List<? extends Buildable> list) {
        Buildable.DefaultImpls.bindChildren(this, list);
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.bindStyles(this, hashMap);
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        return Buildable.DefaultImpls.findWidgetByComponentId(this, str, i);
    }

    public Buildable getParentWidget() {
        return Buildable.DefaultImpls.getParentWidget(this);
    }

    public Buildable getRoot() {
        return Buildable.DefaultImpls.getRoot(this);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
    }

    public boolean isRoot() {
        return Buildable.DefaultImpls.isRoot(this);
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
    }

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    public void setScope(IBlockScope iBlockScope) {
        Buildable.DefaultImpls.setScope(this, iBlockScope);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopicMoreWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicMoreWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(DisplayUtils.dip2px(getContext(), 151.0f), -2));
        setBackgroundResource(R.drawable.customer_shape_topic_view_more_bg);
        m28920a();
        this.f40740a = new LinkedHashMap();
        this.f40743d = -2;
        this.f40744e = "";
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f40740a;
    }

    public final IconRichTextView getMIconWidget() {
        IconRichTextView iconRichTextView = this.mIconWidget;
        if (iconRichTextView != null) {
            return iconRichTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIconWidget");
        return null;
    }

    public final void setMIconWidget(IconRichTextView iconRichTextView) {
        Intrinsics.checkNotNullParameter(iconRichTextView, "<set-?>");
        this.mIconWidget = iconRichTextView;
    }

    public final RichTextView getMDescWidget() {
        RichTextView richTextView = this.mDescWidget;
        if (richTextView != null) {
            return richTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDescWidget");
        return null;
    }

    public final void setMDescWidget(RichTextView richTextView) {
        Intrinsics.checkNotNullParameter(richTextView, "<set-?>");
        this.mDescWidget = richTextView;
    }

    public final WidgetNodeModel getMWidgetNode() {
        return this.f40741b;
    }

    public final void setMWidgetNode(WidgetNodeModel widgetNodeModel) {
        this.f40741b = widgetNodeModel;
    }

    public final HomeHorizontalScrollTopicRvModel getMTopicRvModel() {
        return this.f40742c;
    }

    public final void setMTopicRvModel(HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel) {
        this.f40742c = homeHorizontalScrollTopicRvModel;
    }

    public final int getMHeight() {
        return this.f40743d;
    }

    public final void setMHeight(int i) {
        this.f40743d = i;
    }

    public final String getMWidgetType() {
        return this.f40744e;
    }

    public final void setMWidgetType(String str) {
        this.f40744e = str;
    }

    /* renamed from: a */
    private final void m28920a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_icon_topic_view_more);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_icon_topic_view_more)");
        setMIconWidget((IconRichTextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_tv_topic_view_more);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_topic_view_more)");
        setMDescWidget((RichTextView) findViewById2);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Object obj;
        Object obj2;
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        this.f40741b = widgetNodeModel;
        HomeHorizontalScrollTopicRvModel homeHorizontalScrollTopicRvModel = null;
        if (widgetNodeModel == null) {
            obj = null;
        } else {
            obj = widgetNodeModel.getDataModel();
        }
        ComponentModel componentModel = obj instanceof ComponentModel ? (ComponentModel) obj : null;
        if (componentModel == null) {
            obj2 = null;
        } else {
            obj2 = componentModel.getDataModel();
        }
        if (obj2 instanceof HomeHorizontalScrollTopicRvModel) {
            homeHorizontalScrollTopicRvModel = (HomeHorizontalScrollTopicRvModel) obj2;
        }
        this.f40742c = homeHorizontalScrollTopicRvModel;
    }

    public View getView() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r3.get("icon");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0012
        L_0x0005:
            java.lang.String r1 = "icon"
            java.lang.Object r1 = r3.get(r1)
            if (r1 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r1 = r1.toString()
        L_0x0012:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0034
            if (r3 != 0) goto L_0x001d
            goto L_0x002a
        L_0x001d:
            java.lang.String r1 = "content"
            java.lang.Object r3 = r3.get(r1)
            if (r3 != 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.lang.String r0 = r3.toString()
        L_0x002a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0034
            r3 = 1
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.TopicMoreWidget.shouldShow(java.util.HashMap):boolean");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(BlocksConst.WIDGET_PARAMS_TYPE_WIDGET_TYPE);
            String str = null;
            setMWidgetType(obj == null ? null : obj.toString());
            m28922a(getMWidgetType());
            m28924b(getMWidgetType());
            Object obj2 = hashMap.get(BlocksConst.WIDGET_PARAMS_BG_COLOR);
            m28923a(obj2 == null ? null : obj2.toString(), getMWidgetType());
            Object obj3 = hashMap.get("icon");
            CharSequence obj4 = obj3 == null ? null : obj3.toString();
            boolean z = false;
            if (!(obj4 == null || obj4.length() == 0)) {
                getMIconWidget().setText(obj4);
            }
            Object obj5 = hashMap.get("content");
            CharSequence obj6 = obj5 == null ? null : obj5.toString();
            if (!(obj6 == null || obj6.length() == 0)) {
                RichTextView mDescWidget2 = getMDescWidget();
                Object obj7 = hashMap.get("content");
                mDescWidget2.setText(obj7 == null ? null : obj7.toString());
            }
            Object obj8 = hashMap.get(BlocksConst.WIDGET_PARAMS_ICON_BG_COLOR);
            if (obj8 != null) {
                str = obj8.toString();
            }
            try {
                CharSequence charSequence = str;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    Drawable background = getMIconWidget().getBackground();
                    if (background != null) {
                        ((GradientDrawable) background).setColor(Color.parseColor(str));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TopicMoreWidget.m28921a(TopicMoreWidget.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28921a(TopicMoreWidget topicMoreWidget, View view) {
        Intrinsics.checkNotNullParameter(topicMoreWidget, "this$0");
        Request.Builder path = DiRouter.request().path(RoutePath.BLOCKS_LANDING_PAGE);
        HomeHorizontalScrollTopicRvModel mTopicRvModel = topicMoreWidget.getMTopicRvModel();
        String str = null;
        Request.Builder putString = path.putString(Const.PageParams.COMPONENT_ID, mTopicRvModel == null ? null : mTopicRvModel.mComponentId);
        HomeHorizontalScrollTopicRvModel mTopicRvModel2 = topicMoreWidget.getMTopicRvModel();
        Request.Builder putString2 = putString.putString("recid", mTopicRvModel2 == null ? null : mTopicRvModel2.mRecId);
        HomeHorizontalScrollTopicRvModel mTopicRvModel3 = topicMoreWidget.getMTopicRvModel();
        Request.Builder putString3 = putString2.putString("scene", String.valueOf(mTopicRvModel3 == null ? 0 : mTopicRvModel3.mScene));
        HomeHorizontalScrollTopicRvModel mTopicRvModel4 = topicMoreWidget.getMTopicRvModel();
        if (mTopicRvModel4 != null) {
            str = mTopicRvModel4.mTopicTitle;
        }
        putString3.putString(Const.PageParams.TOPIC_TITLE, str).open();
        HomeOmegaHelper.getInstance().trackShowAllClick();
    }

    public int getWidgetType() {
        String str = this.f40744e;
        if (str != null) {
            if (str != null && Integer.parseInt(str) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public void onAppear() {
        LogUtil.m29100d("TopicMoreWidget", "onAppearedWhenScroll >>>> ");
    }

    /* renamed from: a */
    private final void m28922a(String str) {
        int i;
        if (str == null || Integer.parseInt(str) != 1) {
            i = DisplayUtils.dip2px(getContext(), 4.0f);
        } else {
            i = DisplayUtils.dip2px(getContext(), 6.0f);
        }
        Drawable background = getBackground();
        if (background != null) {
            ((GradientDrawable) background).setCornerRadius((float) i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* renamed from: b */
    private final void m28924b(String str) {
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        if (str == null || Integer.parseInt(str) != 0) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = (int) (((double) DisplayUtils.dip2px(getContext(), 151.0f)) * 0.75d);
        }
        this.f40743d = layoutParams.height;
        setLayoutParams(layoutParams);
    }

    public final int getWidgetHeight() {
        return this.f40743d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[Catch:{ Exception -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ Exception -> 0x0052 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28923a(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            android.graphics.drawable.Drawable r0 = r3.getBackground()     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x004a
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0     // Catch:{ Exception -> 0x0052 }
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0052 }
            r2 = 1
            if (r1 == 0) goto L_0x0017
            int r1 = r1.length()     // Catch:{ Exception -> 0x0052 }
            if (r1 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = 0
            goto L_0x0018
        L_0x0017:
            r1 = 1
        L_0x0018:
            if (r1 != 0) goto L_0x001f
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0046
        L_0x001f:
            if (r5 == 0) goto L_0x0037
            int r4 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0052 }
            if (r4 != r2) goto L_0x0037
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x0052 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x0052 }
            r5 = 2131101470(0x7f06071e, float:1.781535E38)
            int r4 = r4.getColor(r5)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0046
        L_0x0037:
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x0052 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x0052 }
            r5 = 2131101502(0x7f06073e, float:1.7815416E38)
            int r4 = r4.getColor(r5)     // Catch:{ Exception -> 0x0052 }
        L_0x0046:
            r0.setColor(r4)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0056
        L_0x004a:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0052 }
            throw r4     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.TopicMoreWidget.m28923a(java.lang.String, java.lang.String):void");
    }
}
