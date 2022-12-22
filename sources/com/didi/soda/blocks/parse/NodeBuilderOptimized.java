package com.didi.soda.blocks.parse;

import android.text.TextUtils;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.entity.ActionEntity;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.soda.blocks.entity.WidgetNodeEntity;
import com.didi.soda.blocks.model.ActionModel;
import com.didi.soda.blocks.model.CallBackModel;
import com.didi.soda.blocks.model.TemplateModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.optimize.OptimizeController;
import com.didi.soda.blocks.parse.NodeBuilderFactory;
import com.didi.soda.blocks.parse.p162el.ExpressionUtil;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.template.TemplateManager;
import com.didi.soda.blocks.track.BlocksTrackHelper;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 J2\u00020\u0001:\u0001JB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J@\u0010 \u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010!\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J8\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J \u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(J>\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00122\"\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e`\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u00102\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u00103\u001a\u0004\u0018\u0001042\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J'\u00105\u001a\u0004\u0018\u0001042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u00108J'\u00109\u001a\u0004\u0018\u0001042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u00108J%\u0010:\u001a\u0004\u0018\u00010\u001e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010;J%\u0010<\u001a\u0004\u0018\u00010\u001e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010;J2\u0010=\u001a\u00020-2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\r2\u0006\u0010?\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010@\u001a\u00020$H\u0002J\u001a\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u001d2\u0006\u0010?\u001a\u00020\u0012H\u0002J,\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010\u001a2\u0006\u0010?\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010F\u001a\u00020$H\u0002J\u001a\u0010G\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010H\u001a\u0004\u0018\u00010\u001e2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010I\u001a\u0004\u0018\u00010$2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010F\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006K"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderOptimized;", "Lcom/didi/soda/blocks/parse/NodeBuilderFactory$iNodeBulder;", "templateManager", "Lcom/didi/soda/blocks/template/TemplateManager;", "(Lcom/didi/soda/blocks/template/TemplateManager;)V", "expressionTime", "", "nodeBuildingCache", "Lcom/didi/soda/blocks/parse/NodeBuildingCache;", "getTemplateManager", "()Lcom/didi/soda/blocks/template/TemplateManager;", "setTemplateManager", "bindAction", "", "Lcom/didi/soda/blocks/model/ActionModel;", "actions", "Lcom/didi/soda/blocks/entity/ActionEntity;", "model", "Lcom/google/gson/JsonObject;", "index", "", "bindCallbacks", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/model/CallBackModel;", "Lkotlin/collections/ArrayList;", "entity", "Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "bindContext", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "bindParams", "bindProps", "bindStyles", "buildWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "templateId", "rvModel", "blockScope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "createFadeRoot", "tempId", "templateVersion", "findJsonMap", "", "mapJson", "maps", "findKeyPathValue", "templateProp", "findKeyPathValueWithCache", "findModelArray", "Lcom/google/gson/JsonArray;", "getJsonArray", "keys", "", "([Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonArray;", "getJsonArrayNoRegular", "getLastKeyModelValue", "([Ljava/lang/String;Lcom/google/gson/JsonObject;)Ljava/lang/Object;", "getLastKeyModelValueNoRegular", "parseChildren", "children", "peer", "nodeModel", "parseCondition", "", "condition", "parseLoop", "loopWidgetNodeEntity", "parentNode", "parseModelValue", "parseModelValueWithCache", "parseNode", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NodeBuilderOptimized.kt */
public final class NodeBuilderOptimized implements NodeBuilderFactory.iNodeBulder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXPRESSION_END = "}}";
    public static final String EXPRESSION_START = "{{";
    private static final String KEY_PATH_START = "$";
    public static final String NATIVE_START = "$invoke.";
    public static final String OPERATION_GET_LENGTH = "__length";
    public static final String PROPS_NATIVE_SPLIT_END = "}}";
    public static final String PROPS_NATIVE_SPLIT_START = "{{$invoke.";
    private static final String PROPS_SPLIT_END = "}}";
    public static final String PROPS_SPLIT_MIDDLE = ".";
    private static final String PROPS_SPLIT_START = "{{$";
    public static final String REGEX_GET_KEY_PATH_EXP = "\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*";
    public static final String REGEX_KEY_PATH_EXP_ONLY = "^\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*$";
    private static final String TAG = "NodeBuilderOptimized";
    private long expressionTime;
    private NodeBuildingCache nodeBuildingCache = new NodeBuildingCache();
    private TemplateManager templateManager;

    public NodeBuilderOptimized(TemplateManager templateManager2) {
        Intrinsics.checkParameterIsNotNull(templateManager2, "templateManager");
        this.templateManager = templateManager2;
    }

    public final TemplateManager getTemplateManager() {
        return this.templateManager;
    }

    public final void setTemplateManager(TemplateManager templateManager2) {
        Intrinsics.checkParameterIsNotNull(templateManager2, "<set-?>");
        this.templateManager = templateManager2;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderOptimized$Companion;", "", "()V", "EXPRESSION_END", "", "EXPRESSION_START", "KEY_PATH_START", "NATIVE_START", "OPERATION_GET_LENGTH", "PROPS_NATIVE_SPLIT_END", "PROPS_NATIVE_SPLIT_START", "PROPS_SPLIT_END", "PROPS_SPLIT_MIDDLE", "PROPS_SPLIT_START", "REGEX_GET_KEY_PATH_EXP", "REGEX_KEY_PATH_EXP_ONLY", "TAG", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NodeBuilderOptimized.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject, Object obj, IBlockScope iBlockScope) {
        HashMap<String, Object> scopeParams;
        Intrinsics.checkParameterIsNotNull(str, "templateId");
        Intrinsics.checkParameterIsNotNull(jsonObject, "model");
        TemplateModel templateById = this.templateManager.getTemplateById(str);
        if (templateById == null) {
            return null;
        }
        String templateVersion = templateById.getTemplateVersion();
        WidgetNodeEntity templateInterface = templateById.getTemplateInterface();
        Peer peer = templateById.getPeer();
        if (peer == null) {
            Intrinsics.throwNpe();
        }
        peer.setStore(jsonObject);
        HashMap hashMap = new HashMap();
        if (!(iBlockScope == null || (scopeParams = iBlockScope.getScopeParams()) == null)) {
            for (Map.Entry entry : scopeParams.entrySet()) {
                if (!Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT.equals(entry.getKey())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        peer.setScope(hashMap);
        JsonElement parse = new JsonParser().parse(new Gson().toJson((Object) peer));
        if (parse != null) {
            JsonObject jsonObject2 = (JsonObject) parse;
            if (templateInterface == null) {
                return null;
            }
            System.currentTimeMillis();
            WidgetNodeModel parseNode = parseNode(templateInterface, jsonObject2, obj, createFadeRoot(str, templateVersion, iBlockScope), -1);
            this.expressionTime = 0;
            this.nodeBuildingCache.clear();
            return parseNode;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
    }

    public final WidgetNodeModel createFadeRoot(String str, String str2, IBlockScope iBlockScope) {
        HashMap<String, Object> hashMap;
        Intrinsics.checkParameterIsNotNull(str, "tempId");
        Intrinsics.checkParameterIsNotNull(str2, "templateVersion");
        WidgetNodeModel widgetNodeModel = new WidgetNodeModel();
        widgetNodeModel.setId(Const.RenderConst.FADE_ROOT_NODE_ID);
        widgetNodeModel.setVersion(str2);
        if (iBlockScope == null || (hashMap = iBlockScope.getScopeParams()) == null) {
            hashMap = new HashMap<>();
        }
        widgetNodeModel.setContext(hashMap);
        widgetNodeModel.setTemplateId(str);
        widgetNodeModel.setContextParams(new HashMap());
        return widgetNodeModel;
    }

    private final WidgetNodeModel parseNode(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject, Object obj, WidgetNodeModel widgetNodeModel, int i) {
        boolean z;
        Object obj2 = null;
        if (!parseCondition(widgetNodeEntity.getCondition(), jsonObject)) {
            return null;
        }
        WidgetNodeModel widgetNodeModel2 = new WidgetNodeModel();
        widgetNodeModel2.setParent(widgetNodeModel);
        String str = null;
        String componentId = widgetNodeEntity.getComponentId();
        if (componentId != null) {
            Object parseModelValueWithCache = parseModelValueWithCache(componentId, jsonObject);
            if (parseModelValueWithCache == null || !((z = parseModelValueWithCache instanceof String))) {
                BlocksTrackHelper.Companion.trackCriticalInfoError(0, componentId, parseModelValueWithCache);
            } else {
                if (z) {
                    obj2 = parseModelValueWithCache;
                }
                str = (String) obj2;
            }
        }
        if (i >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(widgetNodeEntity.getComponentName());
            sb.append("_");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(i);
            widgetNodeModel2.setId(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(widgetNodeEntity.getComponentName());
            sb2.append("_");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            widgetNodeModel2.setId(sb2.toString());
        }
        widgetNodeModel2.setName(widgetNodeEntity.getComponentName());
        widgetNodeModel2.setDataModel(obj);
        widgetNodeModel2.setContext(bindContext(widgetNodeEntity, jsonObject));
        widgetNodeModel2.setProps(bindProps(widgetNodeEntity, jsonObject));
        widgetNodeModel2.setStyles(bindStyles(widgetNodeEntity, jsonObject));
        widgetNodeModel2.setCallbacks(bindCallbacks(widgetNodeEntity, jsonObject, i));
        HashMap<String, Object> contextParams = widgetNodeModel.getContextParams();
        if (contextParams == null) {
            contextParams = new HashMap<>();
        }
        widgetNodeModel2.setContextParams(contextParams);
        String version = widgetNodeModel.getVersion();
        if (version == null) {
            version = "1";
        }
        widgetNodeModel2.setVersion(version);
        widgetNodeModel2.setTemplateId(widgetNodeModel.getTemplateId());
        if (widgetNodeEntity.getChildren() != null) {
            List<WidgetNodeEntity> children = widgetNodeEntity.getChildren();
            if (children == null) {
                Intrinsics.throwNpe();
            }
            parseChildren(children, jsonObject, obj, widgetNodeModel2);
        }
        return widgetNodeModel2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r1 = r12.getChildren();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void parseChildren(java.util.List<com.didi.soda.blocks.entity.WidgetNodeEntity> r9, com.google.gson.JsonObject r10, java.lang.Object r11, com.didi.soda.blocks.model.WidgetNodeModel r12) {
        /*
            r8 = this;
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0006:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0072
            java.lang.Object r0 = r9.next()
            r2 = r0
            com.didi.soda.blocks.entity.WidgetNodeEntity r2 = (com.didi.soda.blocks.entity.WidgetNodeEntity) r2
            if (r2 == 0) goto L_0x0006
            r0 = 0
            if (r12 == 0) goto L_0x0024
            java.util.ArrayList r1 = r12.getChildren()
            if (r1 == 0) goto L_0x0024
            int r1 = r1.size()
            r6 = r1
            goto L_0x0025
        L_0x0024:
            r6 = 0
        L_0x0025:
            java.lang.String r1 = r2.getLoop()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7 = 1
            if (r1 == 0) goto L_0x0037
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r1 = 0
            goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            if (r1 == 0) goto L_0x006e
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            com.didi.soda.blocks.model.WidgetNodeModel r1 = r1.parseNode(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0006
            java.util.ArrayList r2 = r12.getChildren()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0052
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0053
        L_0x0052:
            r0 = 1
        L_0x0053:
            if (r0 == 0) goto L_0x0061
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r1)
            r12.setChildren(r0)
            goto L_0x0006
        L_0x0061:
            java.util.ArrayList r0 = r12.getChildren()
            if (r0 != 0) goto L_0x006a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006a:
            r0.add(r1)
            goto L_0x0006
        L_0x006e:
            r8.parseLoop(r2, r10, r11, r12)
            goto L_0x0006
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOptimized.parseChildren(java.util.List, com.google.gson.JsonObject, java.lang.Object, com.didi.soda.blocks.model.WidgetNodeModel):void");
    }

    private final boolean parseCondition(String str, JsonObject jsonObject) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str == null) {
            Intrinsics.throwNpe();
        }
        Object parseModelValueWithCache = parseModelValueWithCache(str, jsonObject);
        if (parseModelValueWithCache == null) {
            return false;
        }
        if (parseModelValueWithCache instanceof String) {
            CharSequence charSequence = (CharSequence) parseModelValueWithCache;
            if (TextUtils.equals(charSequence, "true")) {
                return true;
            }
            if (!TextUtils.equals(charSequence, SDKConsts.BOOLEAN_FALSE) && !TextUtils.equals(charSequence, "null") && ((String) parseModelValueWithCache).length() > 0) {
                return true;
            }
            return false;
        } else if (!(parseModelValueWithCache instanceof JsonElement)) {
            return true;
        } else {
            JsonElement jsonElement = (JsonElement) parseModelValueWithCache;
            if (jsonElement.isJsonNull()) {
                return false;
            }
            if (jsonElement.isJsonArray()) {
                return true;
            }
            boolean isJsonObject = jsonElement.isJsonObject();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r22.getChildren();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        if (r5 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x009d, code lost:
        if (r0 != null) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void parseLoop(com.didi.soda.blocks.entity.WidgetNodeEntity r19, com.google.gson.JsonObject r20, java.lang.Object r21, com.didi.soda.blocks.model.WidgetNodeModel r22) {
        /*
            r18 = this;
            r6 = r20
            r7 = r22
            r8 = 0
            if (r7 == 0) goto L_0x0013
            java.util.ArrayList r0 = r22.getChildren()
            if (r0 == 0) goto L_0x0013
            int r0 = r0.size()
            r9 = r0
            goto L_0x0014
        L_0x0013:
            r9 = 0
        L_0x0014:
            r0 = 0
            if (r19 == 0) goto L_0x001c
            java.lang.String r1 = r19.getLoop()
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r1 != 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0022:
            if (r19 == 0) goto L_0x0029
            java.util.List r2 = r19.getLoopArgs()
            goto L_0x002a
        L_0x0029:
            r2 = r0
        L_0x002a:
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.String).substring(startIndex)"
            r10 = 1
            if (r2 == 0) goto L_0x006a
            int r5 = r2.size()
            if (r5 <= r10) goto L_0x0039
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            if (r5 == 0) goto L_0x003e
            r5 = r2
            goto L_0x003f
        L_0x003e:
            r5 = r0
        L_0x003f:
            if (r5 == 0) goto L_0x006a
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x006a
            int r11 = r5.length()
            if (r11 <= r10) goto L_0x0051
            r11 = 1
            goto L_0x0052
        L_0x0051:
            r11 = 0
        L_0x0052:
            if (r11 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r5 = r0
        L_0x0056:
            if (r5 == 0) goto L_0x006a
            if (r5 == 0) goto L_0x0064
            java.lang.String r5 = r5.substring(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r4)
            if (r5 == 0) goto L_0x006a
            goto L_0x006c
        L_0x0064:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r3)
            throw r0
        L_0x006a:
            java.lang.String r5 = "item"
        L_0x006c:
            r11 = r5
            if (r2 == 0) goto L_0x00a6
            int r5 = r2.size()
            if (r5 <= r10) goto L_0x0077
            r5 = 1
            goto L_0x0078
        L_0x0077:
            r5 = 0
        L_0x0078:
            if (r5 == 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r2 = r0
        L_0x007c:
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r2.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00a6
            int r5 = r2.length()
            if (r5 <= r10) goto L_0x008e
            r5 = 1
            goto L_0x008f
        L_0x008e:
            r5 = 0
        L_0x008f:
            if (r5 == 0) goto L_0x0092
            r0 = r2
        L_0x0092:
            if (r0 == 0) goto L_0x00a6
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = r0.substring(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a0:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r3)
            throw r0
        L_0x00a6:
            java.lang.String r0 = "index"
        L_0x00a8:
            r12 = r0
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r14 = r18
            com.google.gson.JsonArray r15 = r14.findModelArray(r1, r6)
            if (r15 == 0) goto L_0x0116
            r0 = r15
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r16 = r0.iterator()
            r0 = 0
        L_0x00be:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x0116
            java.lang.Object r1 = r16.next()
            int r17 = r0 + 1
            if (r0 >= 0) goto L_0x00cf
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00cf:
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            if (r19 == 0) goto L_0x0113
            com.didi.soda.blocks.parse.Peer$Companion r1 = com.didi.soda.blocks.parse.Peer.Companion
            com.google.gson.JsonObject r2 = r1.deepCopy(r6)
            com.google.gson.JsonElement r1 = r15.get(r0)
            boolean r1 = r1 instanceof com.google.gson.JsonObject
            if (r1 == 0) goto L_0x0113
            com.google.gson.JsonElement r1 = r15.get(r0)
            if (r1 == 0) goto L_0x010b
            com.google.gson.JsonObject r1 = (com.google.gson.JsonObject) r1
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            r2.add(r11, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Number r1 = (java.lang.Number) r1
            r2.addProperty((java.lang.String) r12, (java.lang.Number) r1)
            int r5 = r0 + r9
            r0 = r18
            r1 = r19
            r3 = r21
            r4 = r22
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r0.parseNode(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0113
            r13.add(r0)
            goto L_0x0113
        L_0x010b:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type com.google.gson.JsonObject"
            r0.<init>(r1)
            throw r0
        L_0x0113:
            r0 = r17
            goto L_0x00be
        L_0x0116:
            java.util.ArrayList r0 = r22.getChildren()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0124
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0125
        L_0x0124:
            r8 = 1
        L_0x0125:
            if (r8 == 0) goto L_0x012b
            r7.setChildren(r13)
            goto L_0x0139
        L_0x012b:
            java.util.ArrayList r0 = r22.getChildren()
            if (r0 != 0) goto L_0x0134
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0134:
            java.util.Collection r13 = (java.util.Collection) r13
            r0.addAll(r13)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOptimized.parseLoop(com.didi.soda.blocks.entity.WidgetNodeEntity, com.google.gson.JsonObject, java.lang.Object, com.didi.soda.blocks.model.WidgetNodeModel):void");
    }

    private final ArrayList<CallBackModel> bindCallbacks(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject, int i) {
        boolean z;
        ArrayList<CallBackModel> arrayList = new ArrayList<>();
        List<CallBackEntity> actions = widgetNodeEntity.getActions();
        if (actions != null) {
            for (CallBackEntity callBackEntity : actions) {
                CallBackModel callBackModel = new CallBackModel();
                String event = callBackEntity.getEvent();
                if (event != null) {
                    Object parseModelValueWithCache = parseModelValueWithCache(event, jsonObject);
                    if (parseModelValueWithCache == null || !((z = parseModelValueWithCache instanceof String))) {
                        BlocksTrackHelper.Companion.trackCriticalInfoError(1, event, parseModelValueWithCache);
                    } else {
                        if (!z) {
                            parseModelValueWithCache = null;
                        }
                        callBackModel.setType((String) parseModelValueWithCache);
                    }
                }
                if (!TextUtils.isEmpty(callBackModel.getType())) {
                    callBackModel.setActions(bindAction(callBackEntity.getLogics(), jsonObject, i));
                    arrayList.add(callBackModel);
                }
            }
        }
        return arrayList;
    }

    private final List<ActionModel> bindAction(List<ActionEntity> list, JsonObject jsonObject, int i) {
        boolean z;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ActionEntity actionEntity : list) {
                ActionModel actionModel = new ActionModel();
                String method = actionEntity.getMethod();
                if (method != null) {
                    Object parseModelValueWithCache = parseModelValueWithCache(method, jsonObject);
                    if (parseModelValueWithCache == null || !((z = parseModelValueWithCache instanceof String))) {
                        BlocksTrackHelper.Companion.trackCriticalInfoError(2, method, parseModelValueWithCache);
                    } else {
                        if (!z) {
                            parseModelValueWithCache = null;
                        }
                        actionModel.setActionType((String) parseModelValueWithCache);
                    }
                }
                if (!TextUtils.isEmpty(actionModel.getActionType())) {
                    actionModel.setParams(bindParams(actionEntity, jsonObject, i));
                    actionModel.setOnSuccess(bindAction(actionEntity.getOnResolve(), jsonObject, i));
                    actionModel.setOnError(bindAction(actionEntity.getOnReject(), jsonObject, i));
                    arrayList.add(actionModel);
                }
            }
            return arrayList;
        }
        NodeBuilderOptimized nodeBuilderOptimized = this;
        return null;
    }

    private final HashMap<String, Object> bindParams(ActionEntity actionEntity, JsonObject jsonObject, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        findJsonMap(actionEntity.getParams(), hashMap, jsonObject);
        return hashMap;
    }

    private final HashMap<String, Object> bindProps(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        findJsonMap(widgetNodeEntity.getProps(), hashMap, jsonObject);
        return hashMap;
    }

    private final HashMap<String, Object> bindStyles(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        findJsonMap(widgetNodeEntity.getStyle(), hashMap, jsonObject);
        return hashMap;
    }

    private final HashMap<String, Object> bindContext(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        findJsonMap(widgetNodeEntity.getContext(), hashMap, jsonObject);
        return hashMap;
    }

    private final void findJsonMap(JsonObject jsonObject, HashMap<String, Object> hashMap, JsonObject jsonObject2) {
        if (jsonObject != null) {
            for (Map.Entry next : jsonObject.entrySet()) {
                if (!(next.getKey() == null || next.getValue() == null)) {
                    if (next.getValue() instanceof JsonPrimitive) {
                        Object value = next.getValue();
                        Intrinsics.checkExpressionValueIsNotNull(value, "entry.value");
                        Object asString = ((JsonElement) value).getAsString();
                        Object value2 = next.getValue();
                        if (value2 != null) {
                            if (((JsonPrimitive) value2).isString()) {
                                Object value3 = next.getValue();
                                Intrinsics.checkExpressionValueIsNotNull(value3, "entry.value");
                                String asString2 = ((JsonElement) value3).getAsString();
                                Intrinsics.checkExpressionValueIsNotNull(asString2, "entry.value.asString");
                                asString = parseModelValueWithCache(asString2, jsonObject2);
                            }
                            if (asString != null) {
                                Object key = next.getKey();
                                Intrinsics.checkExpressionValueIsNotNull(key, "entry.key");
                                hashMap.put(key, asString);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonPrimitive");
                        }
                    } else if (next.getValue() instanceof JsonObject) {
                        HashMap hashMap2 = new HashMap();
                        Object value4 = next.getValue();
                        if (value4 != null) {
                            findJsonMap((JsonObject) value4, hashMap2, jsonObject2);
                            Object key2 = next.getKey();
                            Intrinsics.checkExpressionValueIsNotNull(key2, "entry.key");
                            hashMap.put(key2, hashMap2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                        }
                    } else if (next.getValue() instanceof JsonArray) {
                        Object value5 = next.getValue();
                        Intrinsics.checkExpressionValueIsNotNull(value5, "entry.value");
                        JsonArray<JsonElement> asJsonArray = ((JsonElement) value5).getAsJsonArray();
                        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "entry.value.asJsonArray");
                        ArrayList arrayList = new ArrayList();
                        for (JsonElement jsonElement : asJsonArray) {
                            if (jsonElement instanceof JsonPrimitive) {
                                String asString3 = ((JsonPrimitive) jsonElement).getAsString();
                                if (asString3 != null) {
                                    Object parseModelValueWithCache = parseModelValueWithCache(asString3, jsonObject2);
                                    if (parseModelValueWithCache != null) {
                                        arrayList.add(parseModelValueWithCache);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (next.getValue() instanceof JsonObject) {
                                HashMap hashMap3 = new HashMap();
                                Object value6 = next.getValue();
                                if (value6 != null) {
                                    findJsonMap((JsonObject) value6, hashMap3, jsonObject2);
                                    arrayList.add(hashMap3);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                                }
                            } else {
                                continue;
                            }
                        }
                        Object key3 = next.getKey();
                        Intrinsics.checkExpressionValueIsNotNull(key3, "entry.key");
                        hashMap.put(key3, arrayList);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private final JsonArray findModelArray(String str, JsonObject jsonObject) {
        if (!StringsKt.startsWith$default(str, PROPS_SPLIT_START, false, 2, (Object) null) || StringsKt.startsWith$default(str, "{{$invoke.", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "}}", false, 2, (Object) null)) {
            return null;
        }
        int length = str.length() - 2;
        if (str != null) {
            String substring = str.substring(3, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object[] array = StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                JsonArray jsonArray = null;
                if (strArr.length == 1) {
                    JsonElement jsonElement = jsonObject.get(strArr[0]);
                    if (jsonElement instanceof JsonArray) {
                        return (JsonArray) jsonElement;
                    }
                    return null;
                } else if (OptimizeController.INSTANCE.isOpenRegularReplace()) {
                    return getJsonArrayNoRegular(strArr, jsonObject);
                } else {
                    return getJsonArray(strArr, jsonObject);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    /* JADX WARNING: type inference failed for: r15v5, types: [com.google.gson.JsonElement] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.gson.JsonArray getJsonArrayNoRegular(java.lang.String[] r14, com.google.gson.JsonObject r15) {
        /*
            r13 = this;
            java.lang.String r0 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            int r1 = r14.length
            r2 = 1
            int r1 = r1 - r2
            r1 = r14[r1]
            int r3 = r14.length
            int r3 = r3 - r2
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r3)
            java.lang.String r3 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r3)
            java.lang.String[] r14 = (java.lang.String[]) r14
            int r3 = r14.length
            r4 = 0
            r5 = 0
        L_0x0017:
            r6 = 0
            if (r5 >= r3) goto L_0x0093
            r7 = r14[r5]
            if (r15 == 0) goto L_0x0092
            if (r7 != 0) goto L_0x0022
            goto L_0x0092
        L_0x0022:
            int r8 = r7.length()
            r9 = 2
            if (r8 <= r9) goto L_0x0083
            int r8 = r7.length()
            int r8 = r8 - r2
            char r8 = r7.charAt(r8)
            r9 = 93
            if (r8 != r9) goto L_0x0083
            int r8 = r7.length()
            int r8 = r8 - r2
            r9 = 1
        L_0x003c:
            r10 = -1
            if (r9 >= r8) goto L_0x007d
            char r11 = r7.charAt(r9)
            r12 = 91
            if (r11 != r12) goto L_0x007a
            int r8 = r9 + 1
            int r11 = r7.length()     // Catch:{ NumberFormatException -> 0x0079 }
            int r11 = r11 - r2
            java.lang.String r8 = r7.substring(r8, r11)     // Catch:{ NumberFormatException -> 0x0079 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)     // Catch:{ NumberFormatException -> 0x0079 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0079 }
            java.lang.String r7 = r7.substring(r4, r9)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
            com.google.gson.JsonElement r7 = r15.get(r7)
            boolean r9 = r7 instanceof com.google.gson.JsonArray
            if (r9 == 0) goto L_0x007e
            if (r8 < 0) goto L_0x007e
            com.google.gson.JsonArray r7 = (com.google.gson.JsonArray) r7
            int r9 = r7.size()
            if (r8 >= r9) goto L_0x007e
            com.google.gson.JsonElement r15 = r7.get(r8)
            com.google.gson.JsonObject r15 = (com.google.gson.JsonObject) r15
            goto L_0x007e
        L_0x0079:
            return r6
        L_0x007a:
            int r9 = r9 + 1
            goto L_0x003c
        L_0x007d:
            r8 = -1
        L_0x007e:
            if (r8 != r10) goto L_0x008f
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x008e
        L_0x0083:
            com.google.gson.JsonElement r15 = r15.get(r7)
            boolean r7 = r15 instanceof com.google.gson.JsonObject
            if (r7 == 0) goto L_0x008e
            r6 = r15
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
        L_0x008e:
            r15 = r6
        L_0x008f:
            int r5 = r5 + 1
            goto L_0x0017
        L_0x0092:
            return r6
        L_0x0093:
            if (r15 != 0) goto L_0x0096
            return r6
        L_0x0096:
            com.google.gson.JsonElement r14 = r15.get(r1)
            boolean r15 = r14 instanceof com.google.gson.JsonArray
            if (r15 == 0) goto L_0x00a1
            r6 = r14
            com.google.gson.JsonArray r6 = (com.google.gson.JsonArray) r6
        L_0x00a1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOptimized.getJsonArrayNoRegular(java.lang.String[], com.google.gson.JsonObject):com.google.gson.JsonArray");
    }

    /* JADX WARNING: type inference failed for: r11v4, types: [com.google.gson.JsonElement] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.gson.JsonArray getJsonArray(java.lang.String[] r10, com.google.gson.JsonObject r11) {
        /*
            r9 = this;
            int r0 = r10.length
            r1 = 1
            int r0 = r0 - r1
            r0 = r10[r0]
            int r2 = r10.length
            int r2 = r2 - r1
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r2)
            java.lang.String r2 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)
            java.lang.String[] r10 = (java.lang.String[]) r10
            int r2 = r10.length
            r3 = 0
            r4 = 0
        L_0x0015:
            r5 = 0
            if (r4 >= r2) goto L_0x0075
            r6 = r10[r4]
            if (r11 == 0) goto L_0x0074
            if (r6 != 0) goto L_0x001f
            goto L_0x0074
        L_0x001f:
            java.lang.String r7 = "\\[(\\d+)\\]"
            java.util.regex.Pattern r7 = java.util.regex.Pattern.compile(r7)
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.util.regex.Matcher r7 = r7.matcher(r8)
            boolean r8 = r7.find()
            if (r8 == 0) goto L_0x0065
            java.lang.String r5 = r7.group(r1)
            java.lang.String r8 = "m.group(1)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r8)
            int r5 = java.lang.Integer.parseInt(r5)
            int r7 = r7.start()
            java.lang.String r6 = r6.substring(r3, r7)
            java.lang.String r7 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            com.google.gson.JsonElement r6 = r11.get(r6)
            boolean r7 = r6 instanceof com.google.gson.JsonArray
            if (r7 == 0) goto L_0x0071
            if (r5 < 0) goto L_0x0071
            com.google.gson.JsonArray r6 = (com.google.gson.JsonArray) r6
            int r7 = r6.size()
            if (r5 >= r7) goto L_0x0071
            com.google.gson.JsonElement r11 = r6.get(r5)
            com.google.gson.JsonObject r11 = (com.google.gson.JsonObject) r11
            goto L_0x0071
        L_0x0065:
            com.google.gson.JsonElement r11 = r11.get(r6)
            boolean r6 = r11 instanceof com.google.gson.JsonObject
            if (r6 == 0) goto L_0x0070
            r5 = r11
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5
        L_0x0070:
            r11 = r5
        L_0x0071:
            int r4 = r4 + 1
            goto L_0x0015
        L_0x0074:
            return r5
        L_0x0075:
            if (r11 != 0) goto L_0x0078
            return r5
        L_0x0078:
            com.google.gson.JsonElement r10 = r11.get(r0)
            boolean r11 = r10 instanceof com.google.gson.JsonArray
            if (r11 == 0) goto L_0x0083
            r5 = r10
            com.google.gson.JsonArray r5 = (com.google.gson.JsonArray) r5
        L_0x0083:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOptimized.getJsonArray(java.lang.String[], com.google.gson.JsonObject):com.google.gson.JsonArray");
    }

    private final Object parseModelValueWithCache(String str, JsonObject jsonObject) {
        if (!StringsKt.startsWith$default(str, "{{", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "}}", false, 2, (Object) null)) {
            return str;
        }
        if (OptimizeController.INSTANCE.isOpenResultCache() && this.nodeBuildingCache.contains(str)) {
            return this.nodeBuildingCache.getCachedValue(str);
        }
        Object parseModelValue = parseModelValue(str, jsonObject);
        if (OptimizeController.INSTANCE.isOpenResultCache()) {
            this.nodeBuildingCache.cacheValue(str, parseModelValue);
        }
        return parseModelValue;
    }

    private final Object parseModelValue(String str, JsonObject jsonObject) {
        Object makeContextAvailable$soda_compose_android_release;
        String str2 = str;
        JsonObject jsonObject2 = jsonObject;
        int i = 2;
        int length = str.length() - 2;
        if (str2 != null) {
            String substring = str2.substring(2, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            CharSequence charSequence = substring;
            if (!Pattern.matches("^\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*$", charSequence)) {
                Matcher matcher = Pattern.compile("\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*").matcher(charSequence);
                List<String> arrayList = new ArrayList<>();
                while (matcher.find()) {
                    String group = matcher.group();
                    Intrinsics.checkExpressionValueIsNotNull(group, "m.group()");
                    arrayList.add(group);
                }
                HashMap hashMap = new HashMap();
                String str3 = str2;
                String str4 = substring;
                boolean z = false;
                for (String str5 : arrayList) {
                    String makeVariableAvailable = ExpressionUtil.Companion.makeVariableAvailable(str5);
                    if ((str5 instanceof String) && StringsKt.startsWith$default(str5, "$invoke.", false, i, (Object) null)) {
                        z = true;
                    } else if (!hashMap.containsKey(str5)) {
                        String str6 = makeVariableAvailable;
                        String str7 = str5;
                        str4 = StringsKt.replace$default(str4, str5, makeVariableAvailable, false, 4, (Object) null);
                        str3 = StringsKt.replace$default(str3, str7, str6, false, 4, (Object) null);
                        String str8 = str7;
                        Object findKeyPathValueWithCache = findKeyPathValueWithCache(str8, jsonObject2);
                        if (findKeyPathValueWithCache == null || (makeContextAvailable$soda_compose_android_release = ExpressionUtil.Companion.makeContextAvailable$soda_compose_android_release(findKeyPathValueWithCache)) == null) {
                            IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                            if (logger != null) {
                                logger.info(TAG, "the value of key-path:\"" + str8 + "\" is null ");
                            }
                        } else {
                            hashMap.put(str6, makeContextAvailable$soda_compose_android_release);
                        }
                    }
                    i = 2;
                }
                if (z) {
                    return str3;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Object evaluateEl = ExpressionUtil.Companion.evaluateEl(str2, str4, hashMap);
                this.expressionTime += System.currentTimeMillis() - currentTimeMillis;
                return evaluateEl;
            } else if (StringsKt.startsWith$default(substring, "$invoke.", false, 2, (Object) null)) {
                return str2;
            } else {
                return findKeyPathValueWithCache(substring, jsonObject2);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final Object findKeyPathValueWithCache(String str, JsonObject jsonObject) {
        if (!StringsKt.startsWith$default(str, KEY_PATH_START, false, 2, (Object) null)) {
            return str;
        }
        if (OptimizeController.INSTANCE.isOpenResultCache() && this.nodeBuildingCache.contains(str)) {
            return this.nodeBuildingCache.getCachedValue(str);
        }
        Object findKeyPathValue = findKeyPathValue(str, jsonObject);
        if (OptimizeController.INSTANCE.isOpenResultCache()) {
            this.nodeBuildingCache.cacheValue(str, findKeyPathValue);
        }
        return findKeyPathValue;
    }

    private final Object findKeyPathValue(String str, JsonObject jsonObject) {
        if (KEY_PATH_START.equals(str)) {
            return str;
        }
        int length = str.length();
        if (str != null) {
            String substring = str.substring(1, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object[] array = StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length == 1) {
                    JsonElement jsonElement = jsonObject.get(strArr[0]);
                    return jsonElement instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement).getAsString() : jsonElement;
                } else if (OptimizeController.INSTANCE.isOpenRegularReplace()) {
                    return getLastKeyModelValueNoRegular(strArr, jsonObject);
                } else {
                    return getLastKeyModelValue(strArr, jsonObject);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final Object getLastKeyModelValueNoRegular(String[] strArr, JsonObject jsonObject) {
        JsonArray asJsonArray;
        int i;
        int i2;
        String[] strArr2 = strArr;
        String str = strArr2[strArr2.length - 1];
        Object[] copyOf = Arrays.copyOf(strArr2, strArr2.length - 1);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr3 = (String[]) copyOf;
        JsonElement jsonElement = jsonObject;
        int length = strArr3.length;
        int i3 = 0;
        while (true) {
            JsonElement jsonElement2 = null;
            if (i3 < length) {
                String str2 = strArr3[i3];
                if (jsonElement != null && str2 != null) {
                    if (str2.length() > 2 && str2.charAt(str2.length() - 1) == ']') {
                        int length2 = str2.length() - 1;
                        int i4 = 1;
                        while (true) {
                            if (i4 >= length2) {
                                i2 = -1;
                                break;
                            } else if (str2.charAt(i4) == '[') {
                                try {
                                    String substring = str2.substring(i4 + 1, str2.length() - 1);
                                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i2 = Integer.parseInt(substring);
                                    String substring2 = str2.substring(0, i4);
                                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (jsonElement.isJsonObject()) {
                                        JsonElement jsonElement3 = jsonElement.getAsJsonObject().get(substring2);
                                        if ((jsonElement3 instanceof JsonArray) && i2 >= 0) {
                                            JsonArray jsonArray = (JsonArray) jsonElement3;
                                            if (i2 < jsonArray.size()) {
                                                jsonElement = (JsonObject) jsonArray.get(i2);
                                            }
                                        }
                                        jsonElement = null;
                                    } else {
                                        jsonElement = null;
                                    }
                                } catch (NumberFormatException unused) {
                                    return null;
                                }
                            } else {
                                i4++;
                            }
                        }
                        if (i2 == -1) {
                            jsonElement2 = null;
                        } else {
                            i3++;
                        }
                    } else if (jsonElement.isJsonObject()) {
                        jsonElement2 = jsonElement.getAsJsonObject().get(str2);
                    }
                    jsonElement = jsonElement2;
                    i3++;
                }
            } else if (str.length() <= 2 || str.charAt(str.length() - 1) != ']') {
                if (!"__length".equals(str)) {
                    if (jsonElement == null || !jsonElement.isJsonObject()) {
                        return null;
                    }
                    JsonElement jsonElement4 = jsonElement.getAsJsonObject().get(str);
                    return jsonElement4 instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement4).getAsString() : jsonElement4;
                } else if (jsonElement == null) {
                    return 0;
                } else {
                    if (jsonElement.isJsonPrimitive()) {
                        String asString = jsonElement.getAsString();
                        if (asString != null) {
                            return Integer.valueOf(asString.length());
                        }
                        return 0;
                    } else if (!jsonElement.isJsonArray() || (asJsonArray = jsonElement.getAsJsonArray()) == null) {
                        return 0;
                    } else {
                        return Integer.valueOf(asJsonArray.size());
                    }
                }
            } else if (jsonElement == null) {
                return null;
            } else {
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                int length3 = str.length() - 1;
                int i5 = 1;
                while (true) {
                    if (i5 >= length3) {
                        i = -1;
                        break;
                    } else if (str.charAt(i5) == '[') {
                        try {
                            String substring3 = str.substring(i5 + 1, str.length() - 1);
                            Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            i = Integer.parseInt(substring3);
                            str = str.substring(0, i5);
                            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            break;
                        } catch (NumberFormatException unused2) {
                            return null;
                        }
                    } else {
                        i5++;
                    }
                }
                if (i != -1 && jsonElement.isJsonObject()) {
                    JsonElement jsonElement5 = jsonElement.getAsJsonObject().get(str);
                    if ((jsonElement5 instanceof JsonArray) && i >= 0) {
                        JsonArray jsonArray2 = (JsonArray) jsonElement5;
                        if (i < jsonArray2.size()) {
                            JsonElement jsonElement6 = jsonArray2.get(i);
                            return jsonElement6 instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement6).getAsString() : jsonElement6;
                        }
                    }
                }
                return null;
            }
        }
        if ("__length".equals(str)) {
            return 0;
        }
        return null;
    }

    private final Object getLastKeyModelValue(String[] strArr, JsonObject jsonObject) {
        JsonArray asJsonArray;
        Pattern compile = Pattern.compile("\\[(\\d+)\\]");
        String str = strArr[strArr.length - 1];
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length - 1);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        JsonElement jsonElement = jsonObject;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            JsonElement jsonElement2 = null;
            if (i < length) {
                String str2 = strArr2[i];
                if (jsonElement != null && str2 != null) {
                    Matcher matcher = compile.matcher(str2);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        Intrinsics.checkExpressionValueIsNotNull(group, "m.group(1)");
                        int parseInt = Integer.parseInt(group);
                        String substring = str2.substring(0, matcher.start());
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (jsonElement.isJsonObject()) {
                            JsonElement jsonElement3 = jsonElement.getAsJsonObject().get(substring);
                            if ((jsonElement3 instanceof JsonArray) && parseInt >= 0) {
                                JsonArray jsonArray = (JsonArray) jsonElement3;
                                if (parseInt < jsonArray.size()) {
                                    jsonElement = (JsonObject) jsonArray.get(parseInt);
                                    i++;
                                }
                            }
                            jsonElement2 = null;
                        } else {
                            jsonElement2 = null;
                        }
                    } else if (jsonElement.isJsonObject()) {
                        jsonElement2 = jsonElement.getAsJsonObject().get(str2);
                    }
                    jsonElement = jsonElement2;
                    i++;
                }
            } else {
                Matcher matcher2 = compile.matcher(str);
                if (matcher2.find()) {
                    if (jsonElement == null) {
                        return null;
                    }
                    String group2 = matcher2.group(1);
                    Intrinsics.checkExpressionValueIsNotNull(group2, "matcher.group(1)");
                    int parseInt2 = Integer.parseInt(group2);
                    int start = matcher2.start();
                    if (str != null) {
                        String substring2 = str.substring(0, start);
                        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (jsonElement.isJsonObject()) {
                            JsonElement jsonElement4 = jsonElement.getAsJsonObject().get(substring2);
                            if ((jsonElement4 instanceof JsonArray) && parseInt2 >= 0) {
                                JsonArray jsonArray2 = (JsonArray) jsonElement4;
                                if (parseInt2 < jsonArray2.size()) {
                                    JsonElement jsonElement5 = jsonArray2.get(parseInt2);
                                    return jsonElement5 instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement5).getAsString() : jsonElement5;
                                }
                            }
                        }
                        return null;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                } else if (!"__length".equals(str)) {
                    if (jsonElement == null || !jsonElement.isJsonObject()) {
                        return null;
                    }
                    JsonElement jsonElement6 = jsonElement.getAsJsonObject().get(str);
                    return jsonElement6 instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement6).getAsString() : jsonElement6;
                } else if (jsonElement == null) {
                    return 0;
                } else {
                    if (jsonElement.isJsonPrimitive()) {
                        String asString = jsonElement.getAsString();
                        if (asString != null) {
                            return Integer.valueOf(asString.length());
                        }
                        return 0;
                    } else if (!jsonElement.isJsonArray() || (asJsonArray = jsonElement.getAsJsonArray()) == null) {
                        return 0;
                    } else {
                        return Integer.valueOf(asJsonArray.size());
                    }
                }
            }
        }
        if ("__length".equals(str)) {
            return 0;
        }
        return null;
    }
}
