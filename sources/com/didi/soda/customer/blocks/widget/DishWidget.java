package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@WidgetNameMeta(widgetName = "right_image_left_text")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J0\u0010\u001c\u001a\u00020\u00192&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016J\b\u0010!\u001a\u00020\"H\u0016J0\u0010#\u001a\u00020\u00192&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016J\u001a\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J0\u0010+\u001a\u00020,2&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R4\u0010\f\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00020\rj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0002`\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/DishWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "businessInfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "mContainer", "Landroid/widget/LinearLayout;", "mImageWidget", "Lcom/didi/soda/customer/blocks/widget/ImageWidget;", "mTitleWidget", "Lcom/didi/soda/customer/blocks/widget/IconAndTextWidget;", "bindChildren", "", "children", "", "bindProps", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getView", "Landroid/view/View;", "onBindFinish", "openBusinessHomePage", "rvModel", "itemModel", "Lcom/didi/soda/customer/widget/search/SearchFoodItemView$SearchFoodItemModel;", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DishWidget.kt */
public final class DishWidget extends ConstraintLayout implements Buildable {

    /* renamed from: a */
    private IconAndTextWidget f40681a;

    /* renamed from: b */
    private ImageWidget f40682b;

    /* renamed from: c */
    private LinearLayout f40683c;

    /* renamed from: d */
    private HomeBusinessInfoRvModel f40684d;

    /* renamed from: e */
    private final LinkedHashMap<String, Buildable> f40685e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DishWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DishWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
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

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    public void setScope(IBlockScope iBlockScope) {
        Buildable.DefaultImpls.setScope(this, iBlockScope);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DishWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_dish_layout, this);
        View findViewById = inflate.findViewById(R.id.customer_custom_dish_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_custom_dish_title)");
        this.f40681a = (IconAndTextWidget) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_ll_container)");
        this.f40683c = (LinearLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_info_tag_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_info_tag_img)");
        this.f40682b = (ImageWidget) findViewById3;
        this.f40685e = new LinkedHashMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DishWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.f40685e;
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Object obj;
        Object obj2;
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = null;
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
        if (obj2 instanceof HomeBusinessInfoRvModel) {
            homeBusinessInfoRvModel = (HomeBusinessInfoRvModel) obj2;
        }
        this.f40684d = homeBusinessInfoRvModel;
    }

    public View getView() {
        return this;
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        Iterable<Buildable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Buildable view : iterable) {
            arrayList.add(view.getView());
        }
        for (View addView : (List) arrayList) {
            this.f40683c.addView(addView);
        }
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        Object obj;
        String str = null;
        if (!(hashMap == null || (obj = hashMap.get("title")) == null)) {
            str = obj.toString();
        }
        return !TextUtils.isEmpty(str);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get("image");
            T t = null;
            if (obj != null) {
                this.f40682b.setMStyle(11);
                this.f40682b.bindProps(obj instanceof HashMap ? (HashMap) obj : null);
            }
            Object obj2 = hashMap.get("title");
            if (obj2 != null) {
                this.f40681a.bindProps(obj2 instanceof HashMap ? (HashMap) obj2 : null);
            }
            String valueOf = String.valueOf(hashMap.get("native_index"));
            HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f40684d;
            boolean z = false;
            if (valueOf.length() > 0) {
                if (homeBusinessInfoRvModel != null && homeBusinessInfoRvModel.mSource == 2) {
                    z = true;
                }
                if (z) {
                    try {
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        List list = homeBusinessInfoRvModel.mFoodItems;
                        if (list != null) {
                            t = (SearchFoodItemView.SearchFoodItemModel) list.get(Integer.parseInt(valueOf));
                        }
                        objectRef.element = t;
                        SearchNewOmegaHelper.getInstance().itemExposureForGoods(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) objectRef.element, true);
                        getView().setOnClickListener(new View.OnClickListener(objectRef, this) {
                            public final /* synthetic */ Ref.ObjectRef f$1;
                            public final /* synthetic */ DishWidget f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                DishWidget.m28900a(HomeBusinessInfoRvModel.this, this.f$1, this.f$2, view);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28900a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, Ref.ObjectRef objectRef, DishWidget dishWidget, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "$itemModel");
        Intrinsics.checkNotNullParameter(dishWidget, "this$0");
        SearchNewOmegaHelper.getInstance().setGoodsGuideParam(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) objectRef.element);
        SearchNewOmegaHelper.getInstance().trackBusinessOrGoodsClick(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) objectRef.element, true);
        dishWidget.m28899a(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) objectRef.element);
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        float f;
        Context context;
        Map linkedHashMap = new LinkedHashMap();
        Iterator it = getDynamicChildren().entrySet().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Buildable) entry.getValue()).getView().getVisibility() == 0) {
                z = true;
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        int i = 0;
        for (Object next : MapsKt.toList(linkedHashMap)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            if (i == 0) {
                context = getContext();
                f = 6.0f;
            } else {
                context = getContext();
                f = 4.0f;
            }
            int dip2px = DisplayUtils.dip2px(context, f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, dip2px, 0, 0);
            ((Buildable) pair.getSecond()).getView().setLayoutParams(layoutParams);
            i = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28899a(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r6, com.didi.soda.customer.widget.search.SearchFoodItemView.SearchFoodItemModel r7) {
        /*
            r5 = this;
            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r0 = r5.f40684d
            java.lang.String r0 = com.didi.soda.search.helper.SearchNewOmegaHelper.genBusinessBiData(r0, r7)
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0051 }
            r2.<init>()     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r3 = "clickItemId"
            if (r7 != 0) goto L_0x0012
            r4 = r1
            goto L_0x0014
        L_0x0012:
            java.lang.String r4 = r7.goodsId     // Catch:{ JSONException -> 0x0050 }
        L_0x0014:
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x0050 }
            java.lang.String r3 = "clickItemStatus"
            if (r7 != 0) goto L_0x001d
            r7 = r1
            goto L_0x0023
        L_0x001d:
            int r7 = r7.status     // Catch:{ JSONException -> 0x0050 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ JSONException -> 0x0050 }
        L_0x0023:
            r2.put(r3, r7)     // Catch:{ JSONException -> 0x0050 }
            java.lang.String r7 = "exactMatchType"
            int r3 = r6.mExactMatchType     // Catch:{ JSONException -> 0x0050 }
            r2.put(r7, r3)     // Catch:{ JSONException -> 0x0050 }
            java.lang.String r7 = "matchItemIds"
            java.lang.String r3 = r6.mMatchItemIds     // Catch:{ JSONException -> 0x0050 }
            r2.put(r7, r3)     // Catch:{ JSONException -> 0x0050 }
            java.lang.Class<com.didi.soda.search.repo.SearchWordRepo> r7 = com.didi.soda.search.repo.SearchWordRepo.class
            com.didi.app.nova.skeleton.repo.Repo r7 = com.didi.soda.customer.repo.RepoFactory.getRepo(r7)     // Catch:{ JSONException -> 0x0050 }
            com.didi.soda.search.repo.SearchWordRepo r7 = (com.didi.soda.search.repo.SearchWordRepo) r7     // Catch:{ JSONException -> 0x0050 }
            com.didi.soda.search.repo.SearchWordModel r7 = r7.getValue()     // Catch:{ JSONException -> 0x0050 }
            if (r7 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            java.lang.String r1 = r7.mSearchTag     // Catch:{ JSONException -> 0x0050 }
        L_0x0045:
            if (r1 == 0) goto L_0x0052
            java.lang.String r1 = "searchWord"
            java.lang.String r7 = r7.mSearchTag     // Catch:{ JSONException -> 0x0050 }
            r2.put(r1, r7)     // Catch:{ JSONException -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            r1 = r2
        L_0x0051:
            r2 = r1
        L_0x0052:
            com.didi.soda.router.Request$Builder r7 = com.didi.soda.router.DiRouter.request()
            java.lang.String r1 = "businessPage"
            com.didi.soda.router.Request$Builder r7 = r7.path(r1)
            java.lang.String r1 = r6.mShopId
            java.lang.String r3 = "shopid"
            com.didi.soda.router.Request$Builder r7 = r7.putString(r3, r1)
            com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet r6 = r6.mTransitionNameSet
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r1 = "transitionname"
            com.didi.soda.router.Request$Builder r6 = r7.putSerializable(r1, r6)
            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r7 = r5.f40684d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.mSource
            java.lang.String r1 = "businessanimationsource"
            com.didi.soda.router.Request$Builder r6 = r6.putInt(r1, r7)
            java.lang.String r7 = "bi_data"
            com.didi.soda.router.Request$Builder r6 = r6.putString(r7, r0)
            java.lang.String r7 = ""
            if (r2 != 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            java.lang.String r0 = r2.toString()
            if (r0 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r7 = r0
        L_0x0090:
            java.lang.String r0 = "searchInfo"
            com.didi.soda.router.Request$Builder r6 = r6.putString(r0, r7)
            r6.open()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.DishWidget.m28899a(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.customer.widget.search.SearchFoodItemView$SearchFoodItemModel):void");
    }
}
