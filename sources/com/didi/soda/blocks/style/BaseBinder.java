package com.didi.soda.blocks.style;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.action.RealTimeExposure;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.utils.YogaNodeUtil;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.image.BackgroundHelper;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u001f\u001a\u00020 2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J0\u0010%\u001a\u00020 2&\u0010&\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J0\u0010'\u001a\u00020 2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\u0015\u0010(\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020 H\u0016J\u0016\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010,\u001a\u00020\nH\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020 H\u0002J\u0006\u00100\u001a\u00020\u000fJ\b\u00101\u001a\u0004\u0018\u00010\u001aJ\u0006\u00102\u001a\u00020\u0006J\n\u00103\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0003H\u0016J\r\u00105\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J\b\u00107\u001a\u0004\u0018\u00010\u0018J\u0006\u00108\u001a\u00020\u001cJ\u0001\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u00182\u0010\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010>2]\u0010@\u001aY\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010>\u0012\u0004\u0012\u00020 0AH\u0016J\b\u0010F\u001a\u00020 H\u0016J\b\u0010G\u001a\u00020:H\u0016J0\u0010H\u001a\u00020 2&\u0010&\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\b\u0010I\u001a\u00020 H\u0002J\b\u0010J\u001a\u00020 H\u0016J\u0010\u0010K\u001a\u00020 2\u0006\u0010;\u001a\u00020\u001aH\u0016J\u0012\u0010L\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\u0018H\u0016R4\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0003`\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/BaseBinder;", "T", "Landroid/view/View;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/blocks/action/RealTimeExposure;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dynamicChildren", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getDynamicChildren", "()Ljava/util/LinkedHashMap;", "mBackgroundHelper", "Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "getMBackgroundHelper", "()Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "setMBackgroundHelper", "(Lcom/didi/soda/blocks/widget/image/BackgroundHelper;)V", "mBlockView", "Landroid/view/View;", "mContext", "mNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "mScope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "mYogaNode", "Lcom/facebook/yoga/YogaNode;", "trackSwBean", "Lcom/didi/soda/blocks/style/TrackSwBean;", "bindInterceptedStyles", "", "styles", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindProps", "props", "bindStyles", "createView", "(Landroid/content/Context;)Landroid/view/View;", "doRealTimeExpose", "findWidgetByComponentId", "id", "upLevel", "", "generateYogaNode", "getBackGroundHelper", "getBlockScope", "getContext", "getParentWidget", "getRoot", "getView", "()Landroid/view/View;", "getVirtualNode", "getYogaNode", "handleShownTrigger", "", "scope", "widgetNodeModel", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "widgetNode", "widget", "initView", "isRoot", "onBindFinish", "outputNodeInfo", "refreshLayout", "setScope", "setWidgetNode", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseBinder.kt */
public abstract class BaseBinder<T extends View> implements RealTimeExposure, Buildable {
    private final LinkedHashMap<String, Buildable> dynamicChildren;
    protected BackgroundHelper mBackgroundHelper;
    private T mBlockView;
    private Context mContext;
    private WidgetNodeModel mNode;
    private IBlockScope mScope;
    private YogaNode mYogaNode;
    private TrackSwBean trackSwBean;

    public void bindInterceptedStyles(HashMap<String, Object> hashMap) {
    }

    public abstract T createView(Context context);

    public void initView() {
    }

    public BaseBinder(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        this.mBlockView = createView(context);
        generateYogaNode();
        T t = this.mBlockView;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockView");
        }
        this.mBackgroundHelper = new BackgroundHelper(context, t);
        initView();
        this.dynamicChildren = new LinkedHashMap<>();
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkParameterIsNotNull(list, "children");
        Buildable.DefaultImpls.bindChildren(this, list);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    /* access modifiers changed from: protected */
    public final BackgroundHelper getMBackgroundHelper() {
        BackgroundHelper backgroundHelper = this.mBackgroundHelper;
        if (backgroundHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundHelper");
        }
        return backgroundHelper;
    }

    /* access modifiers changed from: protected */
    public final void setMBackgroundHelper(BackgroundHelper backgroundHelper) {
        Intrinsics.checkParameterIsNotNull(backgroundHelper, "<set-?>");
        this.mBackgroundHelper = backgroundHelper;
    }

    public LinkedHashMap<String, Buildable> getDynamicChildren() {
        return this.dynamicChildren;
    }

    public T getView() {
        T t = this.mBlockView;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockView");
        }
        return t;
    }

    public final BackgroundHelper getBackGroundHelper() {
        BackgroundHelper backgroundHelper = this.mBackgroundHelper;
        if (backgroundHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundHelper");
        }
        return backgroundHelper;
    }

    private final void generateYogaNode() {
        YogaNode yogaNode;
        View view = getView();
        if (view instanceof YogaLayout) {
            yogaNode = ((YogaLayout) view).getYogaNode();
            Intrinsics.checkExpressionValueIsNotNull(yogaNode, "view.yogaNode");
        } else {
            YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
            createYogaNode.setData(view);
            createYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
            Intrinsics.checkExpressionValueIsNotNull(createYogaNode, "YogaNodeUtil.createYogaN…Function())\n            }");
            yogaNode = createYogaNode;
        }
        this.mYogaNode = yogaNode;
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
        this.mNode = widgetNodeModel;
        if (widgetNodeModel != null) {
            YogaNode yogaNode = this.mYogaNode;
            if (yogaNode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYogaNode");
            }
            widgetNodeModel.setYogaNode(yogaNode);
        }
        WidgetNodeModel widgetNodeModel2 = this.mNode;
        if (widgetNodeModel2 != null) {
            widgetNodeModel2.setWidget(this);
        }
        YogaNode yogaNode2 = this.mYogaNode;
        if (yogaNode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYogaNode");
        }
        yogaNode2.setData(getView());
    }

    public void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Buildable.DefaultImpls.setScope(this, iBlockScope);
        this.mScope = iBlockScope;
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        String[] strArr;
        if (hashMap != null) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            if (getClass().isAnnotationPresent(StyleInterceptor.class)) {
                StyleInterceptor styleInterceptor = (StyleInterceptor) getClass().getAnnotation(StyleInterceptor.class);
                boolean z = false;
                if (styleInterceptor == null || (strArr = styleInterceptor.interceptList()) == null) {
                    strArr = new String[0];
                }
                if (strArr.length == 0) {
                    z = true;
                }
                if (!(!z)) {
                    strArr = null;
                }
                if (strArr != null) {
                    Map map = hashMap2;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        entry.getValue();
                        if (!ArraysKt.contains((T[]) strArr, (String) entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                    HashMap hashMap3 = (HashMap) map;
                }
            } else {
                hashMap2 = hashMap;
            }
            StyleProcessor.INSTANCE.applyStyles(getContext(), this, hashMap2);
        }
        bindInterceptedStyles(hashMap);
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (getYogaNode().isMeasureDefined()) {
            getYogaNode().dirty();
        }
    }

    public void doRealTimeExpose() {
        TrackSwBean trackSwBean2 = this.trackSwBean;
        if (trackSwBean2 != null) {
            trackSwBean2.getHandler().invoke(trackSwBean2.getScope(), trackSwBean2.getWidgetNodeModel(), this, trackSwBean2.getActions());
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        if (BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
            getView().setOnLongClickListener(new BaseBinder$onBindFinish$1(this));
        }
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        this.trackSwBean = new TrackSwBean(iBlockScope, widgetNodeModel, list, function4);
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
    }

    /* access modifiers changed from: private */
    public final void outputNodeInfo() {
        String tree2String = YogaNodeUtil.tree2String(this.mNode);
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            String str = null;
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText((CharSequence) null, tree2String));
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("复制id:");
            WidgetNodeModel virtualNode = getVirtualNode();
            String id = virtualNode != null ? virtualNode.getId() : null;
            if (id == null) {
                id = "";
            }
            sb.append(id);
            sb.append("到粘贴板");
            SystemUtils.showToast(Toast.makeText(context2, sb.toString(), 0));
            IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
            if (logger != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("YogaNodeInfo-");
                WidgetNodeModel widgetNodeModel = this.mNode;
                if (widgetNodeModel != null) {
                    str = widgetNodeModel.getId();
                }
                sb2.append(str);
                sb2.append(10);
                String sb3 = sb2.toString();
                Intrinsics.checkExpressionValueIsNotNull(tree2String, "nodeTreeString");
                logger.debug(sb3, tree2String);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public void refreshLayout() {
        getView().requestLayout();
    }

    public boolean isRoot() {
        WidgetNodeModel widgetNodeModel = this.mNode;
        if (widgetNodeModel != null) {
            return widgetNodeModel.isRoot();
        }
        return false;
    }

    public Buildable getRoot() {
        WidgetNodeModel root;
        WidgetNodeModel widgetNodeModel = this.mNode;
        if (widgetNodeModel == null || (root = widgetNodeModel.getRoot()) == null) {
            return null;
        }
        return root.getWidget();
    }

    public Buildable getParentWidget() {
        WidgetNodeModel widgetNodeModel;
        WidgetNodeModel parent;
        if (isRoot() || (widgetNodeModel = this.mNode) == null || (parent = widgetNodeModel.getParent()) == null) {
            return null;
        }
        return parent.getWidget();
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        Buildable buildable;
        String id;
        WidgetNodeModel upLevelNode;
        Intrinsics.checkParameterIsNotNull(str, "id");
        WidgetNodeModel widgetNodeModel = this.mNode;
        if (widgetNodeModel == null || (upLevelNode = widgetNodeModel.getUpLevelNode(i)) == null || (buildable = upLevelNode.getWidget()) == null) {
            buildable = getRoot();
        }
        if (!(buildable instanceof BaseBinder)) {
            return null;
        }
        BaseBinder baseBinder = (BaseBinder) buildable;
        WidgetNodeModel widgetNodeModel2 = baseBinder.mNode;
        if (widgetNodeModel2 == null || (id = widgetNodeModel2.getId()) == null || !id.equals(str)) {
            return baseBinder.findWidgetByComponentId(str);
        }
        return buildable;
    }

    private final BaseBinder<?> findWidgetByComponentId(String str) {
        BaseBinder<?> baseBinder;
        BaseBinder<?> baseBinder2 = null;
        if (getDynamicChildren().size() > 0) {
            if (getDynamicChildren().containsKey(str)) {
                Object obj = getDynamicChildren().get(str);
                if (obj instanceof BaseBinder) {
                    baseBinder2 = obj;
                }
                return baseBinder2;
            }
            BaseBinder baseBinder3 = null;
            for (Map.Entry value : getDynamicChildren().entrySet()) {
                Object value2 = value.getValue();
                if (!(value2 instanceof BaseBinder)) {
                    value2 = null;
                }
                BaseBinder baseBinder4 = (BaseBinder) value2;
                if (baseBinder4 != null) {
                    baseBinder = baseBinder4.findWidgetByComponentId(str);
                    continue;
                } else {
                    baseBinder = null;
                    continue;
                }
                if (baseBinder != null) {
                    return baseBinder;
                }
            }
        }
        return null;
    }

    public final YogaNode getYogaNode() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYogaNode");
        }
        return yogaNode;
    }

    public final WidgetNodeModel getVirtualNode() {
        return this.mNode;
    }

    public final IBlockScope getBlockScope() {
        return this.mScope;
    }

    public final Context getContext() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }
}
