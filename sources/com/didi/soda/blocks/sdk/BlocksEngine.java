package com.didi.soda.blocks.sdk;

import android.content.Context;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.ActionFactory;
import com.didi.soda.blocks.action.ActionHandler;
import com.didi.soda.blocks.action.ActionPool;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.parse.NodeBuilderFactory;
import com.didi.soda.blocks.parse.Peer;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.config.BlocksConfig;
import com.didi.soda.blocks.sdk.config.BlocksLogger;
import com.didi.soda.blocks.sdk.config.IBlocksFontHandler;
import com.didi.soda.blocks.sdk.config.IBlocksImageLoader;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.sdk.config.IBlocksTracker;
import com.didi.soda.blocks.style.DynamicContainerBinder;
import com.didi.soda.blocks.template.TemplateManager;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.TextBinder;
import com.didi.soda.blocks.widget.WidgetFactory;
import com.didi.soda.blocks.widget.WidgetPool;
import com.didi.soda.blocks.widget.WidgetRenderer;
import com.didi.soda.blocks.widget.image.ImageBinder;
import com.didi.soda.blocks.widget.scroller.HorizontalScroller;
import com.didi.soda.blocks.widget.scroller.VerticalScroller;
import com.facebook.soloader.SoLoader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0002HIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010*J2\u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010$H\u0007J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\fJ\b\u00105\u001a\u0004\u0018\u00010\u000eJ\b\u00106\u001a\u0004\u0018\u00010\u0014J\b\u00107\u001a\u0004\u0018\u00010\u0010J\b\u00108\u001a\u0004\u0018\u00010\u0012J\b\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010;\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\"H\u0002J\"\u0010=\u001a\u00020\"2\u001a\u0010>\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010@0?j\n\u0012\u0006\u0012\u0004\u0018\u00010@`AJ\u0006\u0010B\u001a\u00020CJ\u0010\u0010D\u001a\u00020C2\b\u0010,\u001a\u0004\u0018\u00010\u0014J2\u0010E\u001a\u0004\u0018\u00010&2\u0006\u0010F\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010*J\u000e\u0010G\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u0006J"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/BlocksEngine;", "", "()V", "mActionFactory", "Lcom/didi/soda/blocks/action/ActionFactory;", "mActionHandler", "Lcom/didi/soda/blocks/action/ActionHandler;", "mActionPool", "Lcom/didi/soda/blocks/action/ActionPool;", "mConfig", "Lcom/didi/soda/blocks/sdk/config/BlocksConfig;", "mContext", "Landroid/content/Context;", "mFontHandler", "Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;", "mImageLoader", "Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "mLogger", "Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "mNameSpace", "", "mPeer", "Lcom/didi/soda/blocks/parse/Peer;", "mTemplateManager", "Lcom/didi/soda/blocks/template/TemplateManager;", "mTracker", "Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "mWidgetFactory", "Lcom/didi/soda/blocks/widget/WidgetFactory;", "mWidgetPool", "Lcom/didi/soda/blocks/widget/WidgetPool;", "mWidgetRenderer", "Lcom/didi/soda/blocks/widget/WidgetRenderer;", "bindDataOnWidget", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "currentWidget", "Lcom/didi/soda/blocks/widget/Buildable;", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "buildWidgetNode", "templateId", "dataJsonObject", "Lcom/google/gson/JsonObject;", "rvModel", "blockScope", "createBlockScope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "getConfig", "getContext", "getFontHandler", "getFontsAssetsPath", "getImageLoader", "getLogger", "getPeer", "getTracker", "initConfig", "initInnerBlock", "initTemplate", "templates", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/entity/Template;", "Lkotlin/collections/ArrayList;", "isDebug", "", "isTemplateIdEffective", "renderViewWithData", "context", "startUp", "Companion", "EngineListHolder", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BlocksEngine.kt */
public final class BlocksEngine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "BlocksEngine";
    private ActionFactory mActionFactory;
    private ActionHandler mActionHandler;
    private ActionPool mActionPool;
    private BlocksConfig mConfig;
    /* access modifiers changed from: private */
    public Context mContext;
    private IBlocksFontHandler mFontHandler;
    private IBlocksImageLoader mImageLoader;
    private IBlocksLogger mLogger;
    private String mNameSpace;
    private Peer mPeer;
    private TemplateManager mTemplateManager;
    private IBlocksTracker mTracker;
    private WidgetFactory mWidgetFactory;
    private WidgetPool mWidgetPool;
    private WidgetRenderer mWidgetRenderer;

    public final WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject) {
        return buildWidgetNode$default(this, str, jsonObject, (Object) null, (IBlockScope) null, 12, (Object) null);
    }

    public final WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject, Object obj) {
        return buildWidgetNode$default(this, str, jsonObject, obj, (IBlockScope) null, 8, (Object) null);
    }

    private BlocksEngine() {
    }

    public /* synthetic */ BlocksEngine(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ Context access$getMContext$p(BlocksEngine blocksEngine) {
        Context context = blocksEngine.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    public final void startUp(BlocksConfig blocksConfig) {
        Intrinsics.checkParameterIsNotNull(blocksConfig, "config");
        Context context = blocksConfig.getContext();
        if (context != null) {
            if (this.mContext == null) {
                SoLoader.init(context, false);
            }
            this.mContext = context;
        }
        initConfig(blocksConfig);
        initInnerBlock();
    }

    private final void initConfig(BlocksConfig blocksConfig) {
        this.mNameSpace = blocksConfig.getNameSpace();
        this.mConfig = blocksConfig;
        IBlocksLogger logger = blocksConfig.getLogger();
        if (logger != null) {
            this.mLogger = logger;
        }
        IBlocksTracker tracker = blocksConfig.getTracker();
        if (tracker != null) {
            this.mTracker = tracker;
        }
        IBlocksFontHandler fontHandler = blocksConfig.getFontHandler();
        if (fontHandler != null) {
            this.mFontHandler = fontHandler;
        }
        IBlocksImageLoader imageLoader = blocksConfig.getImageLoader();
        if (imageLoader != null) {
            this.mImageLoader = imageLoader;
        }
        Peer peer = new Peer();
        Map<String, String> widget = blocksConfig.getWidget();
        if (widget != null) {
            peer.setWidget(widget);
        }
        Map<String, String> event = blocksConfig.getEvent();
        if (event != null) {
            peer.setEvent(event);
        }
        Map<String, String> logic = blocksConfig.getLogic();
        if (logic != null) {
            peer.setLogic(logic);
        }
        this.mPeer = peer;
        TemplateManager templateManager = new TemplateManager();
        templateManager.attachPeer(getPeer());
        this.mTemplateManager = templateManager;
        WidgetPool widgetPool = new WidgetPool();
        ArrayList<Class<? extends Buildable>> widgetList2Regist = blocksConfig.getWidgetList2Regist();
        if (widgetList2Regist != null) {
            for (Class registWidget : widgetList2Regist) {
                widgetPool.registWidget(registWidget);
            }
        }
        this.mWidgetPool = widgetPool;
        ActionPool actionPool = new ActionPool();
        ArrayList<Class<? extends BaseAction>> actionList2Regist = blocksConfig.getActionList2Regist();
        if (actionList2Regist != null) {
            for (Class registAction : actionList2Regist) {
                actionPool.registAction(registAction);
            }
        }
        this.mActionPool = actionPool;
        WidgetPool widgetPool2 = this.mWidgetPool;
        if (widgetPool2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        this.mWidgetFactory = new WidgetFactory(widgetPool2);
        ActionPool actionPool2 = this.mActionPool;
        if (actionPool2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionPool");
        }
        ActionFactory actionFactory = new ActionFactory(actionPool2);
        this.mActionFactory = actionFactory;
        if (actionFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionFactory");
        }
        this.mActionHandler = new ActionHandler(actionFactory);
        WidgetFactory widgetFactory = this.mWidgetFactory;
        if (widgetFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetFactory");
        }
        ActionHandler actionHandler = this.mActionHandler;
        if (actionHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionHandler");
        }
        this.mWidgetRenderer = new WidgetRenderer(widgetFactory, actionHandler);
    }

    public final BlocksConfig getConfig() {
        BlocksConfig blocksConfig = this.mConfig;
        if (blocksConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfig");
        }
        return blocksConfig;
    }

    private final Peer getPeer() {
        Peer peer = this.mPeer;
        if (peer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPeer");
        }
        BlocksConfig blocksConfig = this.mConfig;
        if (blocksConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfig");
        }
        Function0<Map<String, Object>> global2 = blocksConfig.getGlobal();
        if (global2 != null) {
            JsonElement parse = new JsonParser().parse(new Gson().toJson((Object) global2.invoke()));
            if (parse != null) {
                peer.setGlobal((JsonObject) parse);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
            }
        }
        BlocksConfig blocksConfig2 = this.mConfig;
        if (blocksConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfig");
        }
        Map<String, Map<String, String>> local = blocksConfig2.getLocal();
        if (local != null) {
            JsonElement parse2 = new JsonParser().parse(new Gson().toJson((Object) local));
            if (parse2 != null) {
                peer.setLocal((JsonObject) parse2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
            }
        }
        return peer;
    }

    public final Context getContext() {
        boolean z = true;
        if (Companion.getInstance$default(Companion, (String) null, 1, (Object) null).isDebug()) {
            if (this.mContext == null) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("BlocksEngine hasn't startUp with effective config".toString());
            }
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    public final String getFontsAssetsPath() {
        BlocksConfig blocksConfig = this.mConfig;
        if (blocksConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfig");
        }
        return blocksConfig.getFontsAssetsPath();
    }

    public final boolean isDebug() {
        BlocksConfig blocksConfig = this.mConfig;
        if (blocksConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfig");
        }
        return blocksConfig.getDebug();
    }

    public final void initTemplate(ArrayList<Template> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "templates");
        TemplateManager templateManager = this.mTemplateManager;
        if (templateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateManager");
        }
        templateManager.initTemplate(arrayList);
    }

    public final boolean isTemplateIdEffective(String str) {
        TemplateManager templateManager = this.mTemplateManager;
        if (templateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateManager");
        }
        return templateManager.isTemplateIdEffective(str);
    }

    public static /* synthetic */ WidgetNodeModel buildWidgetNode$default(BlocksEngine blocksEngine, String str, JsonObject jsonObject, Object obj, IBlockScope iBlockScope, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        if ((i & 8) != 0) {
            iBlockScope = null;
        }
        return blocksEngine.buildWidgetNode(str, jsonObject, obj, iBlockScope);
    }

    public final WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject, Object obj, IBlockScope iBlockScope) {
        Intrinsics.checkParameterIsNotNull(str, "templateId");
        Intrinsics.checkParameterIsNotNull(jsonObject, "dataJsonObject");
        NodeBuilderFactory.Companion companion = NodeBuilderFactory.Companion;
        TemplateManager templateManager = this.mTemplateManager;
        if (templateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateManager");
        }
        return companion.createNodeBulder(templateManager, str).buildWidgetNode(str, jsonObject, obj, iBlockScope);
    }

    public static /* synthetic */ Buildable renderViewWithData$default(BlocksEngine blocksEngine, Context context, IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, BinderRootConfig binderRootConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            binderRootConfig = null;
        }
        return blocksEngine.renderViewWithData(context, iBlockScope, widgetNodeModel, binderRootConfig);
    }

    public final Buildable renderViewWithData(Context context, IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, BinderRootConfig<?> binderRootConfig) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        System.currentTimeMillis();
        WidgetRenderer widgetRenderer = this.mWidgetRenderer;
        if (widgetRenderer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetRenderer");
        }
        return widgetRenderer.renderViewWithData(context, iBlockScope, widgetNodeModel, binderRootConfig);
    }

    public static /* synthetic */ void bindDataOnWidget$default(BlocksEngine blocksEngine, IBlockScope iBlockScope, Buildable buildable, WidgetNodeModel widgetNodeModel, BinderRootConfig binderRootConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            binderRootConfig = null;
        }
        blocksEngine.bindDataOnWidget(iBlockScope, buildable, widgetNodeModel, binderRootConfig);
    }

    public final void bindDataOnWidget(IBlockScope iBlockScope, Buildable buildable, WidgetNodeModel widgetNodeModel, BinderRootConfig<?> binderRootConfig) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        System.currentTimeMillis();
        WidgetRenderer widgetRenderer = this.mWidgetRenderer;
        if (widgetRenderer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetRenderer");
        }
        widgetRenderer.bindDataOnWidget(iBlockScope, buildable, widgetNodeModel, binderRootConfig);
    }

    private final void initInnerBlock() {
        WidgetPool widgetPool = this.mWidgetPool;
        if (widgetPool == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        widgetPool.registWidget(DynamicContainerBinder.class);
        WidgetPool widgetPool2 = this.mWidgetPool;
        if (widgetPool2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        widgetPool2.registWidget(ImageBinder.class);
        WidgetPool widgetPool3 = this.mWidgetPool;
        if (widgetPool3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        widgetPool3.registWidget(HorizontalScroller.class);
        WidgetPool widgetPool4 = this.mWidgetPool;
        if (widgetPool4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        widgetPool4.registWidget(VerticalScroller.class);
        WidgetPool widgetPool5 = this.mWidgetPool;
        if (widgetPool5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidgetPool");
        }
        widgetPool5.registWidget(TextBinder.class);
    }

    public final IBlocksLogger getLogger() {
        IBlocksLogger iBlocksLogger = this.mLogger;
        return iBlocksLogger != null ? iBlocksLogger : BlocksLogger.Companion.getLogger();
    }

    public final IBlocksTracker getTracker() {
        return this.mTracker;
    }

    public final IBlocksFontHandler getFontHandler() {
        return this.mFontHandler;
    }

    public final IBlocksImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public final BlockScopeBase createBlockScope() {
        return new BlockScopeBase();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/BlocksEngine$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/didi/soda/blocks/sdk/BlocksEngine;", "namespace", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BlocksEngine.kt */
    public static final class Companion {
        public final BlocksEngine getInstance() {
            return getInstance$default(this, (String) null, 1, (Object) null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ BlocksEngine getInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = Const.ConfigConst.DEFAULT_NAMESPACE;
            }
            return companion.getInstance(str);
        }

        public final BlocksEngine getInstance(String str) {
            Intrinsics.checkParameterIsNotNull(str, "namespace");
            if (EngineListHolder.INSTANCE.getInstanceMap().containsKey(str)) {
                BlocksEngine blocksEngine = EngineListHolder.INSTANCE.getInstanceMap().get(str);
                if (blocksEngine == null) {
                    Intrinsics.throwNpe();
                }
                return blocksEngine;
            }
            BlocksEngine blocksEngine2 = new BlocksEngine((DefaultConstructorMarker) null);
            EngineListHolder.INSTANCE.getInstanceMap().put(str, blocksEngine2);
            return blocksEngine2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/BlocksEngine$EngineListHolder;", "", "()V", "instanceMap", "", "", "Lcom/didi/soda/blocks/sdk/BlocksEngine;", "getInstanceMap", "()Ljava/util/Map;", "setInstanceMap", "(Ljava/util/Map;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BlocksEngine.kt */
    private static final class EngineListHolder {
        public static final EngineListHolder INSTANCE = new EngineListHolder();
        private static Map<String, BlocksEngine> instanceMap = new LinkedHashMap();

        private EngineListHolder() {
        }

        public final Map<String, BlocksEngine> getInstanceMap() {
            return instanceMap;
        }

        public final void setInstanceMap(Map<String, BlocksEngine> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            instanceMap = map;
        }
    }
}
