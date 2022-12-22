package com.didi.soda.blocks.parse;

import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.entity.ActionEntity;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.soda.blocks.entity.WidgetNodeEntity;
import com.didi.soda.blocks.model.ActionModel;
import com.didi.soda.blocks.model.CallBackModel;
import com.didi.soda.blocks.model.TemplateModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.parse.NodeBuilderFactory;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.template.TemplateManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001>B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J8\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J@\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J8\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J8\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J.\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J*\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%J>\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010\u00102\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u00101\u001a\u0004\u0018\u00010\u001b2\u0006\u00100\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J'\u00102\u001a\u0004\u0018\u00010/2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00105J'\u00106\u001a\u0004\u0018\u00010\u001b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00107J:\u00108\u001a\u00020'2\u000e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010:\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J:\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\f2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010:\u001a\u00020!H\u0002J2\u0010=\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010:\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006?"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderOld;", "Lcom/didi/soda/blocks/parse/NodeBuilderFactory$iNodeBulder;", "templateManager", "Lcom/didi/soda/blocks/template/TemplateManager;", "(Lcom/didi/soda/blocks/template/TemplateManager;)V", "getTemplateManager", "()Lcom/didi/soda/blocks/template/TemplateManager;", "setTemplateManager", "bindAction", "", "Lcom/didi/soda/blocks/model/ActionModel;", "event", "", "actions", "Lcom/didi/soda/blocks/entity/ActionEntity;", "model", "Lcom/google/gson/JsonObject;", "index", "", "bindCallbacks", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/model/CallBackModel;", "Lkotlin/collections/ArrayList;", "entity", "Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "bindContext", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindParams", "bindProps", "bindStyles", "buildWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "templateId", "rvModel", "blockScope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "createFadeRoot", "", "tempId", "realRoot", "templateVersion", "findJsonMap", "mapJson", "maps", "findModelArray", "Lcom/google/gson/JsonArray;", "templateProp", "findModelValue", "getJsonArray", "keys", "", "([Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonArray;", "getLastKeyModelValue", "([Ljava/lang/String;Lcom/google/gson/JsonObject;)Ljava/lang/Object;", "parseChildren", "children", "nodeModel", "parseLoop", "loop", "parseNode", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NodeBulderOld.kt */
public final class NodeBuilderOld implements NodeBuilderFactory.iNodeBulder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NATIVE_INDEX = "native_index";
    public static final String PROPS_NATIVE_SPLIT_END = "}";
    public static final String PROPS_NATIVE_SPLIT_START = "${";
    private static final String PROPS_SPLIT_END = "}}";
    private static final String PROPS_SPLIT_MIDDLE = ".";
    private static final String PROPS_SPLIT_START = "{{";
    private static final String SOURCE_TIME = "source_time";
    private TemplateManager templateManager;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderOld$Companion;", "", "()V", "NATIVE_INDEX", "", "PROPS_NATIVE_SPLIT_END", "PROPS_NATIVE_SPLIT_START", "PROPS_SPLIT_END", "PROPS_SPLIT_MIDDLE", "PROPS_SPLIT_START", "SOURCE_TIME", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NodeBulderOld.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NodeBuilderOld(TemplateManager templateManager2) {
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

    public WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject, Object obj, IBlockScope iBlockScope) {
        Intrinsics.checkParameterIsNotNull(str, "templateId");
        Intrinsics.checkParameterIsNotNull(jsonObject, "model");
        TemplateModel templateById = this.templateManager.getTemplateById(str);
        WidgetNodeEntity templateInterface = templateById != null ? templateById.getTemplateInterface() : null;
        if (templateInterface != null) {
            System.currentTimeMillis();
            WidgetNodeModel widgetNodeModel = new WidgetNodeModel();
            TemplateModel templateById2 = this.templateManager.getTemplateById(str);
            if (templateById2 != null) {
                createFadeRoot(str, widgetNodeModel, templateById2.getTemplateVersion(), iBlockScope);
                parseNode(templateInterface, jsonObject, obj, widgetNodeModel, -1);
                return widgetNodeModel;
            }
        }
        return null;
    }

    public final void createFadeRoot(String str, WidgetNodeModel widgetNodeModel, String str2, IBlockScope iBlockScope) {
        HashMap<String, Object> hashMap;
        Intrinsics.checkParameterIsNotNull(str, "tempId");
        Intrinsics.checkParameterIsNotNull(str2, "templateVersion");
        WidgetNodeModel widgetNodeModel2 = new WidgetNodeModel();
        widgetNodeModel2.setId(Const.RenderConst.FADE_ROOT_NODE_ID);
        widgetNodeModel2.setVersion(str2);
        if (iBlockScope == null || (hashMap = iBlockScope.getScopeParams()) == null) {
            hashMap = new HashMap<>();
        }
        widgetNodeModel2.setContext(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(SOURCE_TIME, Long.valueOf(System.currentTimeMillis()));
        widgetNodeModel2.setContextParams(hashMap2);
        widgetNodeModel2.setTemplateId(str);
        if (widgetNodeModel != null) {
            widgetNodeModel.setParent(widgetNodeModel2);
        }
    }

    private final void parseNode(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject, Object obj, WidgetNodeModel widgetNodeModel, int i) {
        HashMap<String, Object> hashMap;
        if (i >= 0) {
            widgetNodeModel.setId(widgetNodeEntity.getId() + "_" + i);
        } else {
            widgetNodeModel.setId(widgetNodeEntity.getId());
        }
        widgetNodeModel.setName(widgetNodeEntity.getName());
        widgetNodeModel.setDataModel(obj);
        widgetNodeModel.setContext(bindContext(widgetNodeEntity, jsonObject));
        jsonObject.add("native_index", new JsonPrimitive((Number) Integer.valueOf(i)));
        widgetNodeModel.setProps(bindProps(widgetNodeEntity, jsonObject));
        widgetNodeModel.setStyles(bindStyles(widgetNodeEntity, jsonObject));
        widgetNodeModel.setCallbacks(bindCallbacks(widgetNodeEntity, jsonObject, i));
        HashMap<String, Object> props = widgetNodeModel.getProps();
        if (props != null) {
            props.put("native_index", Integer.valueOf(i));
        }
        WidgetNodeModel parent = widgetNodeModel.getParent();
        widgetNodeModel.setTemplateId(parent != null ? parent.getTemplateId() : null);
        WidgetNodeModel parent2 = widgetNodeModel.getParent();
        if (parent2 == null || (hashMap = parent2.getContextParams()) == null) {
            hashMap = new HashMap<>();
        }
        widgetNodeModel.setContextParams(hashMap);
        if (widgetNodeEntity.getLoop() != null) {
            String loop = widgetNodeEntity.getLoop();
            if (loop == null) {
                Intrinsics.throwNpe();
            }
            parseLoop(loop, widgetNodeEntity.getChildren(), jsonObject, obj, widgetNodeModel);
        } else if (widgetNodeEntity.getChildren() != null) {
            List<WidgetNodeEntity> children = widgetNodeEntity.getChildren();
            if (children == null) {
                Intrinsics.throwNpe();
            }
            parseChildren(children, jsonObject, obj, widgetNodeModel, i);
        }
    }

    private final void parseChildren(List<WidgetNodeEntity> list, JsonObject jsonObject, Object obj, WidgetNodeModel widgetNodeModel, int i) {
        ArrayList arrayList = new ArrayList();
        for (WidgetNodeEntity next : list) {
            if (next != null) {
                WidgetNodeModel widgetNodeModel2 = new WidgetNodeModel();
                widgetNodeModel2.setParent(widgetNodeModel);
                parseNode(next, jsonObject, obj, widgetNodeModel2, i);
                arrayList.add(widgetNodeModel2);
            }
        }
        widgetNodeModel.setChildren(arrayList);
    }

    private final void parseLoop(String str, List<WidgetNodeEntity> list, JsonObject jsonObject, Object obj, WidgetNodeModel widgetNodeModel) {
        ArrayList arrayList = new ArrayList();
        JsonArray findModelArray = findModelArray(str, jsonObject);
        if (findModelArray != null) {
            int i = 0;
            for (Object next : findModelArray) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonElement jsonElement = (JsonElement) next;
                WidgetNodeModel widgetNodeModel2 = new WidgetNodeModel();
                if (list != null && (findModelArray.get(i) instanceof JsonObject)) {
                    widgetNodeModel2.setParent(widgetNodeModel);
                    WidgetNodeEntity widgetNodeEntity = list.get(0);
                    JsonElement jsonElement2 = findModelArray.get(i);
                    if (jsonElement2 != null) {
                        parseNode(widgetNodeEntity, (JsonObject) jsonElement2, obj, widgetNodeModel2, i);
                        arrayList.add(widgetNodeModel2);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                    }
                }
                i = i2;
            }
        }
        widgetNodeModel.setChildren(arrayList);
    }

    private final ArrayList<CallBackModel> bindCallbacks(WidgetNodeEntity widgetNodeEntity, JsonObject jsonObject, int i) {
        ArrayList<CallBackModel> arrayList = new ArrayList<>();
        ArrayList<CallBackEntity> callbacks = widgetNodeEntity.getCallbacks();
        if (callbacks != null) {
            for (CallBackEntity callBackEntity : callbacks) {
                CallBackModel callBackModel = new CallBackModel();
                callBackModel.setType(callBackEntity.getType());
                callBackModel.setActions(bindAction(callBackModel.getType(), callBackEntity.getActions(), jsonObject, i));
                arrayList.add(callBackModel);
            }
        }
        return arrayList;
    }

    private final List<ActionModel> bindAction(String str, List<ActionEntity> list, JsonObject jsonObject, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ActionEntity actionEntity : list) {
                ActionModel actionModel = new ActionModel();
                actionModel.setEvent(str);
                actionModel.setActionType(actionEntity.getActionType());
                actionModel.setParams(bindParams(actionEntity, jsonObject, i));
                actionModel.setOnSuccess(bindAction(str, actionEntity.getOnSuccess(), jsonObject, i));
                actionModel.setOnError(bindAction(str, actionEntity.getOnError(), jsonObject, i));
                arrayList.add(actionModel);
            }
            return arrayList;
        }
        NodeBuilderOld nodeBuilderOld = this;
        return null;
    }

    private final HashMap<String, Object> bindParams(ActionEntity actionEntity, JsonObject jsonObject, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        findJsonMap(actionEntity.getParams(), hashMap, jsonObject);
        hashMap.put("native_index", Integer.valueOf(i));
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
                                asString = findModelValue(asString2, jsonObject2);
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
                                    Object findModelValue = findModelValue(asString3, jsonObject2);
                                    if (findModelValue != null) {
                                        arrayList.add(findModelValue);
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
        if (!StringsKt.startsWith$default(str, "{{", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "}}", false, 2, (Object) null)) {
            return null;
        }
        int length = str.length() - 2;
        if (str != null) {
            String substring = str.substring(2, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object[] array = StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                JsonArray jsonArray = null;
                if (strArr.length != 1) {
                    return getJsonArray(strArr, jsonObject);
                }
                JsonElement jsonElement = jsonObject.get(strArr[0]);
                if (jsonElement instanceof JsonArray) {
                    return (JsonArray) jsonElement;
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOld.getJsonArray(java.lang.String[], com.google.gson.JsonObject):com.google.gson.JsonArray");
    }

    private final Object findModelValue(String str, JsonObject jsonObject) {
        if (!StringsKt.startsWith$default(str, "{{", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "}}", false, 2, (Object) null)) {
            return str;
        }
        int length = str.length() - 2;
        if (str != null) {
            String substring = str.substring(2, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object[] array = StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length != 1) {
                    return getLastKeyModelValue(strArr, jsonObject);
                }
                JsonElement jsonElement = jsonObject.get(strArr[0]);
                return jsonElement instanceof JsonPrimitive ? ((JsonPrimitive) jsonElement).getAsString() : jsonElement;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r11v4, types: [com.google.gson.JsonElement] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object getLastKeyModelValue(java.lang.String[] r10, com.google.gson.JsonObject r11) {
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
            boolean r11 = r10 instanceof com.google.gson.JsonPrimitive
            if (r11 == 0) goto L_0x0086
            com.google.gson.JsonPrimitive r10 = (com.google.gson.JsonPrimitive) r10
            java.lang.String r10 = r10.getAsString()
        L_0x0086:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.NodeBuilderOld.getLastKeyModelValue(java.lang.String[], com.google.gson.JsonObject):java.lang.Object");
    }
}
