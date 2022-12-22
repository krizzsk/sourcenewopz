package com.didi.soda.blocks.widget;

import android.content.Context;
import android.view.View;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.ActionHandler;
import com.didi.soda.blocks.model.CallBackModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.style.BaseBinder;
import com.facebook.yoga.YogaDisplay;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018J \u0010\u0019\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J.\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J2\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/WidgetRenderer;", "", "widgetFactory", "Lcom/didi/soda/blocks/widget/WidgetFactory;", "actionHandler", "Lcom/didi/soda/blocks/action/ActionHandler;", "(Lcom/didi/soda/blocks/widget/WidgetFactory;Lcom/didi/soda/blocks/action/ActionHandler;)V", "getActionHandler", "()Lcom/didi/soda/blocks/action/ActionHandler;", "setActionHandler", "(Lcom/didi/soda/blocks/action/ActionHandler;)V", "getWidgetFactory", "()Lcom/didi/soda/blocks/widget/WidgetFactory;", "setWidgetFactory", "(Lcom/didi/soda/blocks/widget/WidgetFactory;)V", "bindDataOnWidget", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "currentWidget", "Lcom/didi/soda/blocks/widget/Buildable;", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "hideUnused", "usedIdList", "", "", "recursionChildren", "context", "Landroid/content/Context;", "children", "renderViewWithData", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WidgetRenderer.kt */
public final class WidgetRenderer {
    private ActionHandler actionHandler;
    private WidgetFactory widgetFactory;

    public WidgetRenderer(WidgetFactory widgetFactory2, ActionHandler actionHandler2) {
        Intrinsics.checkParameterIsNotNull(widgetFactory2, "widgetFactory");
        Intrinsics.checkParameterIsNotNull(actionHandler2, "actionHandler");
        this.widgetFactory = widgetFactory2;
        this.actionHandler = actionHandler2;
    }

    public final ActionHandler getActionHandler() {
        return this.actionHandler;
    }

    public final WidgetFactory getWidgetFactory() {
        return this.widgetFactory;
    }

    public final void setActionHandler(ActionHandler actionHandler2) {
        Intrinsics.checkParameterIsNotNull(actionHandler2, "<set-?>");
        this.actionHandler = actionHandler2;
    }

    public final void setWidgetFactory(WidgetFactory widgetFactory2) {
        Intrinsics.checkParameterIsNotNull(widgetFactory2, "<set-?>");
        this.widgetFactory = widgetFactory2;
    }

    public static /* synthetic */ Buildable renderViewWithData$default(WidgetRenderer widgetRenderer, Context context, IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, BinderRootConfig binderRootConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            binderRootConfig = null;
        }
        return widgetRenderer.renderViewWithData(context, iBlockScope, widgetNodeModel, binderRootConfig);
    }

    public final Buildable renderViewWithData(Context context, IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, BinderRootConfig<?> binderRootConfig) {
        String name;
        Buildable createWidget;
        Map map;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Map map2 = null;
        if (widgetNodeModel == null || (name = widgetNodeModel.getName()) == null || (createWidget = this.widgetFactory.createWidget(context, name, widgetNodeModel.getTemplateId())) == null) {
            return null;
        }
        createWidget.setBinderRootConfig(binderRootConfig);
        createWidget.setWidgetNode(widgetNodeModel);
        createWidget.setScope(iBlockScope);
        createWidget.bindStyles(widgetNodeModel.getStyles());
        createWidget.bindProps(widgetNodeModel.getProps());
        ArrayList<CallBackModel> callbacks = widgetNodeModel.getCallbacks();
        if (callbacks != null) {
            this.actionHandler.performTraverse(iBlockScope, widgetNodeModel, createWidget, callbacks);
        }
        List children = widgetNodeModel.getChildren();
        if (children != null) {
            recursionChildren(context, iBlockScope, children, createWidget);
        }
        Iterable values = createWidget.getDynamicChildren().values();
        Intrinsics.checkExpressionValueIsNotNull(values, "widget.dynamicChildren.values");
        createWidget.bindChildren(CollectionsKt.toList(values));
        Map props = widgetNodeModel.getProps();
        if (props != null) {
            map = new LinkedHashMap();
            for (Map.Entry entry : props.entrySet()) {
                if (!"native_index".equals(entry.getKey())) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            map = null;
        }
        if (map instanceof HashMap) {
            map2 = map;
        }
        if (!createWidget.shouldShow((HashMap) map2)) {
            createWidget.getView().setVisibility(8);
            if (createWidget instanceof BaseBinder) {
                ((BaseBinder) createWidget).getYogaNode().setDisplay(YogaDisplay.NONE);
            }
        } else if (createWidget instanceof BaseBinder) {
            BaseBinder baseBinder = (BaseBinder) createWidget;
            if (baseBinder.getYogaNode().getDisplay() == YogaDisplay.NONE) {
                createWidget.getView().setVisibility(8);
            } else {
                baseBinder.getYogaNode().setDisplay(YogaDisplay.FLEX);
                createWidget.getView().setVisibility(0);
            }
        } else {
            createWidget.getView().setVisibility(0);
        }
        createWidget.onBindFinish(widgetNodeModel.getProps());
        return createWidget;
    }

    private final void recursionChildren(Context context, IBlockScope iBlockScope, List<WidgetNodeModel> list, Buildable buildable) {
        for (WidgetNodeModel widgetNodeModel : list) {
            Buildable renderViewWithData$default = renderViewWithData$default(this, context, iBlockScope, widgetNodeModel, (BinderRootConfig) null, 8, (Object) null);
            if (renderViewWithData$default != null) {
                if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug() || (!buildable.getDynamicChildren().containsKey(widgetNodeModel.getId()))) {
                    Buildable put = buildable.getDynamicChildren().put(widgetNodeModel.getId(), renderViewWithData$default);
                } else {
                    throw new IllegalStateException(("add child with duplicate id: " + widgetNodeModel.getId()).toString());
                }
            }
        }
    }

    public static /* synthetic */ void bindDataOnWidget$default(WidgetRenderer widgetRenderer, IBlockScope iBlockScope, Buildable buildable, WidgetNodeModel widgetNodeModel, BinderRootConfig binderRootConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            binderRootConfig = null;
        }
        widgetRenderer.bindDataOnWidget(iBlockScope, buildable, widgetNodeModel, binderRootConfig);
    }

    public final void bindDataOnWidget(IBlockScope iBlockScope, Buildable buildable, WidgetNodeModel widgetNodeModel, BinderRootConfig<?> binderRootConfig) {
        Map map;
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        if (buildable != null && widgetNodeModel != null) {
            buildable.setBinderRootConfig(binderRootConfig);
            buildable.setWidgetNode(widgetNodeModel);
            buildable.setScope(iBlockScope);
            buildable.bindStyles(widgetNodeModel.getStyles());
            buildable.bindProps(widgetNodeModel.getProps());
            ArrayList<CallBackModel> callbacks = widgetNodeModel.getCallbacks();
            if (callbacks != null) {
                this.actionHandler.performTraverse(iBlockScope, widgetNodeModel, buildable, callbacks);
            }
            List arrayList = new ArrayList();
            Iterable<WidgetNodeModel> children = widgetNodeModel.getChildren();
            Map map2 = null;
            if (children != null) {
                for (WidgetNodeModel widgetNodeModel2 : children) {
                    Buildable buildable2 = buildable.getDynamicChildren().get(widgetNodeModel2.getId());
                    if (buildable2 == null) {
                        Context context = buildable.getView().getContext();
                        Intrinsics.checkExpressionValueIsNotNull(context, "currentWidget.getView().context");
                        buildable2 = renderViewWithData$default(this, context, iBlockScope, widgetNodeModel2, (BinderRootConfig) null, 8, (Object) null);
                        if (buildable2 != null) {
                            buildable.bindChildren(CollectionsKt.arrayListOf(buildable2));
                            Buildable put = buildable.getDynamicChildren().put(widgetNodeModel2.getId(), buildable2);
                        }
                    } else {
                        View view = buildable2.getView();
                        widgetNodeModel2.setWidget(buildable2);
                        if (view.getTag(R.id.compose_recycle_tag) != null) {
                            buildable2.getView().setVisibility(0);
                            view.setTag(R.id.compose_recycle_tag, (Object) null);
                        }
                    }
                    Buildable buildable3 = buildable2;
                    if (buildable3 != null) {
                        arrayList.add(widgetNodeModel2.getId());
                    }
                    bindDataOnWidget$default(this, iBlockScope, buildable3, widgetNodeModel2, (BinderRootConfig) null, 8, (Object) null);
                }
            }
            hideUnused(arrayList, buildable);
            Map props = widgetNodeModel.getProps();
            if (props != null) {
                map = new LinkedHashMap();
                for (Map.Entry entry : props.entrySet()) {
                    if (!"native_index".equals(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                map = null;
            }
            if (map instanceof HashMap) {
                map2 = map;
            }
            if (!buildable.shouldShow((HashMap) map2)) {
                if (buildable instanceof BaseBinder) {
                    ((BaseBinder) buildable).getYogaNode().setDisplay(YogaDisplay.NONE);
                }
                buildable.getView().setVisibility(8);
            } else if (!(buildable instanceof BaseBinder)) {
                buildable.getView().setVisibility(0);
            } else if (((BaseBinder) buildable).getYogaNode().getDisplay() == YogaDisplay.NONE) {
                buildable.getView().setVisibility(8);
            } else {
                buildable.getView().setVisibility(0);
            }
            buildable.onBindFinish(widgetNodeModel.getProps());
        }
    }

    private final void hideUnused(List<String> list, Buildable buildable) {
        for (Map.Entry entry : buildable.getDynamicChildren().entrySet()) {
            if (!list.contains(entry.getKey())) {
                Buildable buildable2 = (Buildable) entry.getValue();
                if (buildable2 instanceof BaseBinder) {
                    ((BaseBinder) buildable2).getYogaNode().setDisplay(YogaDisplay.NONE);
                    buildable2.getView().setVisibility(8);
                } else {
                    buildable2.getView().setVisibility(8);
                }
                buildable2.getView().setTag(R.id.compose_recycle_tag, "");
            }
        }
    }
}
