package com.didi.soda.blocks.widget;

import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.image.ImageBinder;
import com.didi.soda.blocks.widget.scroller.HorizontalScroller;
import com.didi.soda.blocks.widget.scroller.VerticalScroller;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0016J0\u0010\f\u001a\u00020\t2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H&J0\u0010\u000e\u001a\u00020\t2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0016H&Jj\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b2F\u0010\u001d\u001aB\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\u001eH\u0016Jt\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b2F\u0010\u001d\u001aB\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\u001eH\u0016J\u0001\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b2]\u0010\u001d\u001aY\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0'H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J0\u0010*\u001a\u00020\t2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\u0016\u0010,\u001a\u00020\t2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u00100\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J0\u00101\u001a\u00020\u00182&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H&R2\u0010\u0002\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00000\u0003j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0000`\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/Buildable;", "", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "bindChildren", "", "children", "", "bindProps", "props", "bindStyles", "findWidgetByComponentId", "id", "upLevel", "", "getParentWidget", "getRoot", "getView", "Landroid/view/View;", "handleClickTrigger", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "widget", "handleOtherTrigger", "callBackType", "handleShownTrigger", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "Lkotlin/Function4;", "widgetNode", "isRoot", "onBindFinish", "refreshLayout", "setBinderRootConfig", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "setScope", "setWidgetNode", "shouldShow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Buildable.kt */
public interface Buildable {
    void bindChildren(List<? extends Buildable> list);

    void bindProps(HashMap<String, Object> hashMap);

    void bindStyles(HashMap<String, Object> hashMap);

    Buildable findWidgetByComponentId(String str, int i);

    HashMap<String, Buildable> getDynamicChildren();

    Buildable getParentWidget();

    Buildable getRoot();

    View getView();

    boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3);

    boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3);

    boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4);

    boolean isRoot();

    void onBindFinish(HashMap<String, Object> hashMap);

    void refreshLayout();

    void setBinderRootConfig(BinderRootConfig<?> binderRootConfig);

    void setScope(IBlockScope iBlockScope);

    void setWidgetNode(WidgetNodeModel widgetNodeModel);

    boolean shouldShow(HashMap<String, Object> hashMap);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: Buildable.kt */
    public static final class DefaultImpls {
        public static void bindStyles(Buildable buildable, HashMap<String, Object> hashMap) {
        }

        public static Buildable findWidgetByComponentId(Buildable buildable, String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            return null;
        }

        public static Buildable getParentWidget(Buildable buildable) {
            return null;
        }

        public static Buildable getRoot(Buildable buildable) {
            return buildable;
        }

        public static boolean handleClickTrigger(Buildable buildable, IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
            Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
            Intrinsics.checkParameterIsNotNull(function3, "handler");
            return false;
        }

        public static boolean handleOtherTrigger(Buildable buildable, IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
            Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
            Intrinsics.checkParameterIsNotNull(function3, "handler");
            return false;
        }

        public static boolean handleShownTrigger(Buildable buildable, IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
            Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
            Intrinsics.checkParameterIsNotNull(widgetNodeModel, "widgetNodeModel");
            Intrinsics.checkParameterIsNotNull(function4, "handler");
            return false;
        }

        public static boolean isRoot(Buildable buildable) {
            return false;
        }

        public static void onBindFinish(Buildable buildable, HashMap<String, Object> hashMap) {
        }

        public static void refreshLayout(Buildable buildable) {
        }

        public static void setBinderRootConfig(Buildable buildable, BinderRootConfig<?> binderRootConfig) {
        }

        public static void setScope(Buildable buildable, IBlockScope iBlockScope) {
            Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        }

        public static void setWidgetNode(Buildable buildable, WidgetNodeModel widgetNodeModel) {
        }

        public static void bindChildren(Buildable buildable, List<? extends Buildable> list) {
            Intrinsics.checkParameterIsNotNull(list, "children");
            for (Buildable buildable2 : list) {
                ViewGroup viewGroup = null;
                if ((buildable2 instanceof ImageBinder) || (buildable2 instanceof VerticalScroller) || (buildable2 instanceof HorizontalScroller)) {
                    View view = buildable.getView();
                    if (!(view instanceof ViewGroup)) {
                        view = null;
                    }
                    ViewGroup viewGroup2 = (ViewGroup) view;
                    if (viewGroup2 != null) {
                        viewGroup2.setClipChildren(true);
                    }
                }
                View view2 = buildable.getView();
                if (view2 instanceof ViewGroup) {
                    viewGroup = view2;
                }
                ViewGroup viewGroup3 = viewGroup;
                if (viewGroup3 != null) {
                    viewGroup3.addView(buildable2.getView());
                }
            }
        }

        public static /* synthetic */ Buildable findWidgetByComponentId$default(Buildable buildable, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return buildable.findWidgetByComponentId(str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWidgetByComponentId");
        }
    }
}
