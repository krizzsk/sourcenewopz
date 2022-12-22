package com.didi.soda.home.foster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.InitOnceUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.blocks.BlocksManager;
import com.didi.soda.customer.blocks.card.suapp.IShadow;
import com.didi.soda.customer.blocks.card.suapp.SaOmegaHelper;
import com.didi.soda.customer.blocks.card.suapp.SaTopicModel;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.SuAppEntity;
import com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\bH\u0002¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/home/foster/Foster;", "", "()V", "addGlobalLayoutListener", "", "view", "Landroid/view/View;", "convertJsonToEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/SuAppEntity;", "jsonObject", "Lcom/google/gson/JsonObject;", "createSuSupportView", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/soda/home/foster/FosterScopeContext;", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "findTargetItemView", "parent", "Landroid/view/ViewGroup;", "targetList", "", "Lcom/didi/soda/customer/blocks/card/suapp/IShadow;", "fixItemHeight", "getSaTopicRvModel", "Lcom/didi/soda/customer/blocks/card/suapp/SaTopicModel;", "suAppEntity", "getView", "init", "initTemplate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Foster.kt */
public final class Foster {
    public static final Foster INSTANCE = new Foster();

    private Foster() {
    }

    /* renamed from: a */
    private final void m30118a(Context context) {
        BlocksManager.INSTANCE.initBlocks(context);
        InitOnceUtils.Companion.initOnce(Foster$init$1.INSTANCE);
    }

    public final SuAppEntity convertJsonToEntity(JsonObject jsonObject) {
        String str;
        if (jsonObject == null) {
            return null;
        }
        if (jsonObject.has("bizData")) {
            JsonElement jsonElement = jsonObject.get("bizData");
            str = jsonElement == null ? null : jsonElement.getAsString();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            return (SuAppEntity) GsonUtil.fromJson(str, SuAppEntity.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private final SaTopicModel m30117a(SuAppEntity suAppEntity) {
        String str;
        Integer num;
        String str2;
        String str3;
        HomeTopicEntity homeTopicEntity;
        List<BusinessInfoEntity> list;
        HomeTopicEntity homeTopicEntity2;
        ActInfoEntity actInfoEntity;
        HomeTopicEntity homeTopicEntity3;
        HomeTopicEntity homeTopicEntity4;
        List arrayList = new ArrayList();
        List<ComponentEntity> compList = suAppEntity.getCompList();
        int i = 0;
        String str4 = "";
        if (CustomerExtentionKt.getOrZero(compList == null ? null : Integer.valueOf(compList.size())) > 0) {
            List<ComponentEntity> compList2 = suAppEntity.getCompList();
            ComponentEntity componentEntity = compList2 == null ? null : compList2.get(0);
            if (componentEntity == null || (homeTopicEntity4 = componentEntity.mTopicComp) == null) {
                num = null;
            } else {
                num = Integer.valueOf(homeTopicEntity4.scene);
            }
            int orZero = CustomerExtentionKt.getOrZero(num);
            if (componentEntity == null || (homeTopicEntity3 = componentEntity.mTopicComp) == null) {
                str2 = null;
            } else {
                str2 = homeTopicEntity3.componentId;
            }
            if (str2 == null) {
                str2 = str4;
            }
            if (componentEntity == null || (homeTopicEntity2 = componentEntity.mTopicComp) == null || (actInfoEntity = homeTopicEntity2.actInfo) == null) {
                str3 = null;
            } else {
                str3 = actInfoEntity.getActId();
            }
            if (str3 != null) {
                str4 = str3;
            }
            if (!(componentEntity == null || (homeTopicEntity = componentEntity.mTopicComp) == null || (list = homeTopicEntity.mShopList) == null)) {
                for (Object next : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    HomeBusinessInfoRvModel convertBusinessInfoEntity = HomeBusinessInfoRvModel.convertBusinessInfoEntity((BusinessInfoEntity) next);
                    convertBusinessInfoEntity.mRecId = suAppEntity.getRecId();
                    convertBusinessInfoEntity.mPageId = "SA";
                    convertBusinessInfoEntity.mColumnInModule = i;
                    Intrinsics.checkNotNullExpressionValue(convertBusinessInfoEntity, "model");
                    arrayList.add(convertBusinessInfoEntity);
                    i = i2;
                }
            }
            str = str4;
            i = orZero;
            str4 = str2;
        } else {
            str = str4;
        }
        if (arrayList.size() == 0) {
            return null;
        }
        SaTopicModel saTopicModel = new SaTopicModel();
        saTopicModel.setAddressInfo(suAppEntity.getAddressInfo());
        saTopicModel.setShopRvList(arrayList);
        saTopicModel.setScene(i);
        saTopicModel.setComponentId(str4);
        saTopicModel.setActId(str);
        return saTopicModel;
    }

    public final View getView(Context context, SuAppEntity suAppEntity) {
        TemplateTagEntity templateTagEntity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(suAppEntity, "suAppEntity");
        m30118a(context);
        m30122b(suAppEntity);
        Collection compList = suAppEntity.getCompList();
        View view = null;
        if (!(compList == null || compList.isEmpty())) {
            List<ComponentEntity> compList2 = suAppEntity.getCompList();
            ComponentEntity componentEntity = compList2 == null ? null : compList2.get(0);
            if (componentEntity == null) {
                templateTagEntity = null;
            } else {
                templateTagEntity = componentEntity.mComponentV2;
            }
            if (templateTagEntity != null) {
                ComponentModel componentModel = new ComponentModel();
                componentModel.setDataModel(m30117a(suAppEntity));
                if (componentModel.getDataModel() != null) {
                    SaOmegaHelper.Companion.getInstance().attach();
                }
                JsonParser jsonParser = new JsonParser();
                if (componentEntity.mComponentV2.getTmplId() != null) {
                    BlocksEngine instance$default = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null);
                    String tmplId = componentEntity.mComponentV2.getTmplId();
                    Intrinsics.checkNotNull(tmplId);
                    JsonElement parse = jsonParser.parse(GsonUtil.toJson(componentEntity));
                    if (parse != null) {
                        componentModel.setWidgetNodeModel(BlocksEngine.buildWidgetNode$default(instance$default, tmplId, (JsonObject) parse, componentModel, (IBlockScope) null, 8, (Object) null));
                        FosterScopeContext fosterScopeContext = new FosterScopeContext();
                        fosterScopeContext.attach("addressInfo", suAppEntity.getAddressInfo());
                        fosterScopeContext.attach("recId", suAppEntity.getRecId());
                        view = m30116a(context, fosterScopeContext, componentModel);
                        if (view instanceof ScrollWidget) {
                            new FosterTrackHelper().trackScrollEvent((HorizontalScrollView) view, componentEntity, suAppEntity.getRecId());
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.google.gson.JsonObject");
                    }
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30119a(View view) {
        List arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            m30120a((ViewGroup) view, arrayList);
        }
        if (arrayList.size() != 0) {
            int i = 0;
            Iterable<IShadow> iterable = arrayList;
            for (IShadow iShadow : iterable) {
                if (iShadow instanceof View) {
                    i = Math.max(i, iShadow.getContentView().getMeasuredHeight());
                }
            }
            if (i > 0) {
                for (IShadow fixContentHeight : iterable) {
                    fixContentHeight.fixContentHeight(i);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m30120a(ViewGroup viewGroup, List<IShadow> list) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof IShadow) && childAt.getVisibility() == 0) {
                    list.add(childAt);
                } else if (childAt instanceof ViewGroup) {
                    m30120a((ViewGroup) childAt, list);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private final void m30121b(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new Foster$addGlobalLayoutListener$lis$1(view));
    }

    /* renamed from: a */
    private final View m30116a(Context context, FosterScopeContext fosterScopeContext, ComponentModel componentModel) {
        View view = null;
        BlockScopeBase createBlockScope = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).createBlockScope();
        createBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, fosterScopeContext);
        Buildable renderViewWithData = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).renderViewWithData(context, createBlockScope, componentModel.getWidgetNodeModel(), (BinderRootConfig<?>) null);
        if (renderViewWithData != null) {
            view = renderViewWithData.getView();
        }
        if (view == null) {
            Context context2 = GlobalContext.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            view = new ScrollWidget(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        m30121b(view);
        if (view instanceof ScrollWidget) {
            ScrollWidget scrollWidget = (ScrollWidget) view;
            int paddingLeft = scrollWidget.getContentView().getPaddingLeft() - DisplayUtils.dip2px(context, 9.0f);
            if (paddingLeft > 0) {
                scrollWidget.getContentView().setPadding(paddingLeft, 0, paddingLeft, 0);
            }
        }
        return view;
    }

    /* renamed from: b */
    private final void m30122b(SuAppEntity suAppEntity) {
        ArrayList<Template> templates = suAppEntity.getTemplates();
        Collection collection = templates;
        if (!(collection == null || collection.isEmpty())) {
            BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(templates);
        }
    }
}
