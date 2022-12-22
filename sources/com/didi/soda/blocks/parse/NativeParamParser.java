package com.didi.soda.blocks.parse;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.parse.p162el.ExpressionUtil;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
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
import org.xidea.p087el.ExpressionFactory;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NativeParamParser;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NativeParamParser.kt */
public final class NativeParamParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "NativeParamParser";
    private static final ExpressionFactory expressionFactory;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0012J<\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0012H\u0002J<\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0012H\u0002JL\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0012H\u0002JL\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NativeParamParser$Companion;", "", "()V", "TAG", "", "expressionFactory", "Lorg/xidea/el/ExpressionFactory;", "findNativeModelValue", "variable", "currentNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "key", "parseNativeParams", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parseNativeParamsNew", "parseNativeParamsOld", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "parseScopeContextParams", "paramsKey", "scopeKey", "parseScopetParams", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NativeParamParser.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void parseNativeParams(WidgetNodeModel widgetNodeModel, IBlockScope iBlockScope, HashMap<String, Object> hashMap) {
            Intrinsics.checkParameterIsNotNull(widgetNodeModel, "currentNode");
            Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
            Intrinsics.checkParameterIsNotNull(hashMap, "params");
            boolean z = !NodeBuilderFactory.Companion.isOldTemplateVersion(widgetNodeModel.getVersion());
            ScopeContext scopeContext = (ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
            if (z) {
                parseNativeParamsNew(widgetNodeModel, iBlockScope, hashMap);
                return;
            }
            Companion companion = this;
            if (scopeContext == null) {
                Intrinsics.throwNpe();
            }
            companion.parseNativeParamsOld(widgetNodeModel, scopeContext, hashMap);
        }

        private final void parseNativeParamsOld(WidgetNodeModel widgetNodeModel, ScopeContext scopeContext, HashMap<String, Object> hashMap) {
            String str;
            ScopeContext scopeContext2 = scopeContext;
            HashMap<String, Object> hashMap2 = hashMap;
            Map map = hashMap2;
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof HashMap) {
                    parseNativeParamsOld(widgetNodeModel, scopeContext2, (HashMap) value);
                } else {
                    WidgetNodeModel widgetNodeModel2 = widgetNodeModel;
                    if (value instanceof String) {
                        String str3 = (String) value;
                        Object obj = null;
                        if (StringsKt.startsWith$default(str3, NodeBuilderOld.PROPS_NATIVE_SPLIT_START, false, 2, (Object) null) && StringsKt.endsWith$default(str3, "}", false, 2, (Object) null)) {
                            String substring = str3.substring(2, str3.length() - 1);
                            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            Object[] array = StringsKt.split$default((CharSequence) substring, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
                            if (array != null) {
                                String[] strArr = (String[]) array;
                                if (strArr.length == 1) {
                                    str = strArr[0];
                                } else {
                                    str = strArr[strArr.length - 1];
                                }
                                HashMap<String, Object> contextParams = widgetNodeModel.getContextParams();
                                Object obj2 = contextParams != null ? contextParams.get(str) : null;
                                if (obj2 != null) {
                                    map.put(str2, obj2);
                                } else {
                                    Companion companion = this;
                                    HashMap<String, Object> context = widgetNodeModel.getContext();
                                    if (context != null) {
                                        obj = context.get(str);
                                    }
                                    if (obj != null) {
                                        if (obj instanceof JsonPrimitive) {
                                            obj = ((JsonPrimitive) obj).getAsString();
                                        }
                                        Intrinsics.checkExpressionValueIsNotNull(obj, "paramsValue");
                                        map.put(str2, obj);
                                    } else if (widgetNodeModel.getParent() != null) {
                                        WidgetNodeModel parent = widgetNodeModel.getParent();
                                        if (parent == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        companion.parseNativeParamsOld(parent, scopeContext2, hashMap2);
                                    } else {
                                        companion.parseScopeContextParams(scopeContext2, str2, str, hashMap2);
                                    }
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        static /* synthetic */ Object parseScopeContextParams$default(Companion companion, ScopeContext scopeContext, String str, String str2, HashMap hashMap, int i, Object obj) {
            if ((i & 8) != 0) {
                hashMap = null;
            }
            return companion.parseScopeContextParams(scopeContext, str, str2, hashMap);
        }

        private final Object parseScopeContextParams(ScopeContext scopeContext, String str, String str2, HashMap<String, Object> hashMap) {
            Object object = scopeContext.getObject(str2);
            if (object == null) {
                return null;
            }
            if (hashMap != null) {
                hashMap.put(str, object);
            }
            return object;
        }

        static /* synthetic */ Object parseScopetParams$default(Companion companion, IBlockScope iBlockScope, String str, String str2, HashMap hashMap, int i, Object obj) {
            if ((i & 8) != 0) {
                hashMap = null;
            }
            return companion.parseScopetParams(iBlockScope, str, str2, hashMap);
        }

        private final Object parseScopetParams(IBlockScope iBlockScope, String str, String str2, HashMap<String, Object> hashMap) {
            ScopeContext scopeContext = (ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
            Object object = iBlockScope.getObject(str2);
            if (object != null) {
                if (hashMap != null) {
                    hashMap.put(str, object);
                }
                return object;
            }
            if (scopeContext == null) {
                Intrinsics.throwNpe();
            }
            Object object2 = scopeContext.getObject(str2);
            if (object2 != null) {
                if (hashMap != null) {
                    hashMap.put(str, object2);
                }
                return object2;
            }
            Void voidR = null;
            return null;
        }

        private final void parseNativeParamsNew(WidgetNodeModel widgetNodeModel, IBlockScope iBlockScope, HashMap<String, Object> hashMap) {
            Object makeContextAvailable$soda_compose_android_release;
            WidgetNodeModel widgetNodeModel2 = widgetNodeModel;
            IBlockScope iBlockScope2 = iBlockScope;
            Map map = hashMap;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof HashMap) {
                    parseNativeParamsNew(widgetNodeModel2, iBlockScope2, (HashMap) value);
                } else if (value instanceof String) {
                    String str2 = (String) value;
                    boolean z = false;
                    int i = 2;
                    if (StringsKt.startsWith$default(str2, "{{", false, 2, (Object) null) && StringsKt.endsWith$default(str2, "}}", false, 2, (Object) null)) {
                        String substring = str2.substring(2, str2.length() - 2);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        CharSequence charSequence = substring;
                        if (Pattern.matches("^\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*$", charSequence)) {
                            Object findNativeModelValue = findNativeModelValue(substring, widgetNodeModel2, iBlockScope2, str);
                            if (findNativeModelValue != null) {
                                map.put(str, findNativeModelValue);
                            }
                        } else {
                            Matcher matcher = Pattern.compile("\\$[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?(\\.[a-zA-Z_][a-zA-Z0-9_]*(\\[[0-9]+\\])?)*").matcher(charSequence);
                            List<String> arrayList = new ArrayList<>();
                            while (matcher.find()) {
                                String group = matcher.group();
                                Intrinsics.checkExpressionValueIsNotNull(group, "m.group()");
                                arrayList.add(group);
                            }
                            HashMap hashMap2 = new HashMap();
                            String str3 = substring;
                            for (String str4 : arrayList) {
                                String makeVariableAvailable = ExpressionUtil.Companion.makeVariableAvailable(str4);
                                if ((str4 instanceof String) && StringsKt.startsWith$default(str4, "$invoke.", z, i, (Object) null) && !hashMap2.containsKey(str4)) {
                                    String str5 = makeVariableAvailable;
                                    String str6 = str4;
                                    str3 = StringsKt.replace$default(str3, str4, makeVariableAvailable, false, 4, (Object) null);
                                    Object findNativeModelValue2 = NativeParamParser.Companion.findNativeModelValue(str6, widgetNodeModel2, iBlockScope2, str);
                                    if (findNativeModelValue2 == null || (makeContextAvailable$soda_compose_android_release = ExpressionUtil.Companion.makeContextAvailable$soda_compose_android_release(findNativeModelValue2)) == null) {
                                        IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                                        if (logger != null) {
                                            logger.info(NativeParamParser.TAG, "the value of key-path:\"" + str6 + "\" is null ");
                                        }
                                    } else {
                                        hashMap2.put(str5, makeContextAvailable$soda_compose_android_release);
                                    }
                                }
                                z = false;
                                i = 2;
                            }
                            Object evaluateEl = ExpressionUtil.Companion.evaluateEl(substring, str3, hashMap2);
                            if (evaluateEl != null) {
                                map.put(str, evaluateEl);
                            }
                        }
                    }
                }
            }
        }

        private final Object findNativeModelValue(String str, WidgetNodeModel widgetNodeModel, IBlockScope iBlockScope, String str2) {
            String str3;
            Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length == 1) {
                    str3 = strArr[0];
                } else {
                    str3 = strArr[strArr.length - 1];
                }
                String str4 = str3;
                HashMap<String, Object> contextParams = widgetNodeModel.getContextParams();
                Object obj = null;
                Object obj2 = contextParams != null ? contextParams.get(str4) : null;
                if (obj2 != null) {
                    return obj2;
                }
                Companion companion = this;
                HashMap<String, Object> context = widgetNodeModel.getContext();
                if (context != null) {
                    obj = context.get(str4);
                }
                if (obj != null) {
                    return obj instanceof JsonPrimitive ? ((JsonPrimitive) obj).getAsString() : obj;
                }
                if (widgetNodeModel.getParent() == null) {
                    return parseScopetParams$default(companion, iBlockScope, str2, str4, (HashMap) null, 8, (Object) null);
                }
                WidgetNodeModel parent = widgetNodeModel.getParent();
                if (parent == null) {
                    Intrinsics.throwNpe();
                }
                return companion.findNativeModelValue(str, parent, iBlockScope, str2);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    static {
        ExpressionFactory instance = ExpressionFactory.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "ExpressionFactory.getInstance()");
        expressionFactory = instance;
    }
}
