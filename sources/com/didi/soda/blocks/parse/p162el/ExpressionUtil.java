package com.didi.soda.blocks.parse.p162el;

import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xidea.p087el.json.JSONDecoder;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/el/ExpressionUtil;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.soda.blocks.parse.el.ExpressionUtil */
/* compiled from: ExpressionUtil.kt */
public final class ExpressionUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ExpressionUtil";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/el/ExpressionUtil$Companion;", "", "()V", "TAG", "", "evaluateEl", "originExpression", "expression", "contextMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "makeVariableAvailable", "originString", "makeContextAvailable", "makeContextAvailable$soda_compose_android_release", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: com.didi.soda.blocks.parse.el.ExpressionUtil$Companion */
    /* compiled from: ExpressionUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r12 = r7.toString();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0051 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object evaluateEl(java.lang.String r12, java.lang.String r13, java.util.HashMap<java.lang.String, java.lang.Object> r14) {
            /*
                r11 = this;
                java.lang.String r0 = ", the contextMap is "
                java.lang.String r1 = "\" failed with "
                java.lang.String r2 = "ExpressionUtil"
                java.lang.String r3 = ""
                java.lang.String r4 = "originExpression"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r4)
                java.lang.String r4 = "expression"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r4)
                java.lang.String r4 = "contextMap"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r4)
                r4 = 58
                r5 = 1
                r6 = 0
                org.xidea.el.ExpressionFactory r7 = org.xidea.p087el.ExpressionFactory.getInstance()     // Catch:{ Exception -> 0x00f2 }
                org.xidea.el.Expression r7 = r7.create(r13)     // Catch:{ Exception -> 0x00f2 }
                if (r7 == 0) goto L_0x00cb
                java.lang.Object r7 = r7.evaluate((java.lang.Object) r14)     // Catch:{ IOException -> 0x0057 }
                if (r7 == 0) goto L_0x00cb
                boolean r8 = r7 instanceof java.lang.String     // Catch:{ IOException -> 0x0057 }
                if (r8 == 0) goto L_0x0031
                goto L_0x0056
            L_0x0031:
                boolean r8 = r7 instanceof java.lang.Number     // Catch:{ IOException -> 0x0057 }
                if (r8 == 0) goto L_0x003a
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0057 }
                goto L_0x0056
            L_0x003a:
                boolean r8 = r7 instanceof java.lang.Boolean     // Catch:{ IOException -> 0x0057 }
                if (r8 == 0) goto L_0x0043
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0057 }
                goto L_0x0056
            L_0x0043:
                com.google.gson.JsonParser r8 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0051 }
                r8.<init>()     // Catch:{ Exception -> 0x0051 }
                java.lang.String r9 = r7.toString()     // Catch:{ Exception -> 0x0051 }
                com.google.gson.JsonElement r12 = r8.parse((java.lang.String) r9)     // Catch:{ Exception -> 0x0051 }
                goto L_0x0055
            L_0x0051:
                java.lang.String r12 = r7.toString()     // Catch:{ IOException -> 0x0057 }
            L_0x0055:
                r7 = r12
            L_0x0056:
                return r7
            L_0x0057:
                r7 = move-exception
                r8 = r6
                java.lang.String r8 = (java.lang.String) r8
                com.google.gson.Gson r9 = new com.google.gson.Gson     // Catch:{ IOException -> 0x0065 }
                r9.<init>()     // Catch:{ IOException -> 0x0065 }
                java.lang.String r8 = r9.toJson((java.lang.Object) r14)     // Catch:{ IOException -> 0x0065 }
                goto L_0x0069
            L_0x0065:
                r14 = move-exception
                r14.printStackTrace()
            L_0x0069:
                com.didi.soda.blocks.sdk.BlocksEngine$Companion r14 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
                com.didi.soda.blocks.sdk.BlocksEngine r14 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r14, r6, r5, r6)
                com.didi.soda.blocks.sdk.config.IBlocksLogger r14 = r14.getLogger()
                if (r14 == 0) goto L_0x00af
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "execute jsel:\""
                r9.append(r10)
                r9.append(r13)
                r9.append(r1)
                java.lang.Class r1 = r7.getClass()
                java.lang.String r1 = r1.getName()
                r9.append(r1)
                r9.append(r4)
                java.lang.String r1 = r7.getMessage()
                if (r1 == 0) goto L_0x009a
                goto L_0x009b
            L_0x009a:
                r1 = r3
            L_0x009b:
                r9.append(r1)
                r9.append(r0)
                if (r8 == 0) goto L_0x00a4
                goto L_0x00a5
            L_0x00a4:
                r8 = r3
            L_0x00a5:
                r9.append(r8)
                java.lang.String r0 = r9.toString()
                r14.error(r2, r0)
            L_0x00af:
                com.didi.soda.blocks.track.BlocksTrackHelper$Companion r14 = com.didi.soda.blocks.track.BlocksTrackHelper.Companion
                java.lang.String r0 = r7.getMessage()
                if (r0 == 0) goto L_0x00b8
                r3 = r0
            L_0x00b8:
                r14.trackExpressionExecuteError(r12, r13, r3)
                com.didi.soda.blocks.sdk.BlocksEngine$Companion r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
                com.didi.soda.blocks.sdk.BlocksEngine r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r12, r6, r5, r6)
                boolean r12 = r12.isDebug()
                if (r12 != 0) goto L_0x00c8
                goto L_0x00cb
            L_0x00c8:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                throw r7
            L_0x00cb:
                com.didi.soda.blocks.sdk.BlocksEngine$Companion r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
                com.didi.soda.blocks.sdk.BlocksEngine r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r12, r6, r5, r6)
                com.didi.soda.blocks.sdk.config.IBlocksLogger r12 = r12.getLogger()
                if (r12 == 0) goto L_0x00f1
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r0 = "the result of jsel:\""
                r14.append(r0)
                r14.append(r13)
                java.lang.String r13 = "\" is null"
                r14.append(r13)
                java.lang.String r13 = r14.toString()
                r12.info(r2, r13)
            L_0x00f1:
                return r6
            L_0x00f2:
                r7 = move-exception
                r8 = r6
                java.lang.String r8 = (java.lang.String) r8
                com.google.gson.Gson r9 = new com.google.gson.Gson     // Catch:{ IOException -> 0x0100 }
                r9.<init>()     // Catch:{ IOException -> 0x0100 }
                java.lang.String r8 = r9.toJson((java.lang.Object) r14)     // Catch:{ IOException -> 0x0100 }
                goto L_0x0104
            L_0x0100:
                r14 = move-exception
                r14.printStackTrace()
            L_0x0104:
                com.didi.soda.blocks.sdk.BlocksEngine$Companion r14 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
                com.didi.soda.blocks.sdk.BlocksEngine r14 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r14, r6, r5, r6)
                com.didi.soda.blocks.sdk.config.IBlocksLogger r14 = r14.getLogger()
                if (r14 == 0) goto L_0x014b
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "parse jsel:\""
                r9.append(r10)
                r9.append(r13)
                r9.append(r1)
                java.lang.Class r1 = r7.getClass()
                java.lang.String r1 = r1.getName()
                r9.append(r1)
                r9.append(r4)
                java.lang.String r1 = r7.getMessage()
                if (r1 == 0) goto L_0x0136
                goto L_0x0137
            L_0x0136:
                r1 = r3
            L_0x0137:
                r9.append(r1)
                r9.append(r0)
                if (r8 == 0) goto L_0x0140
                goto L_0x0141
            L_0x0140:
                r8 = r3
            L_0x0141:
                r9.append(r8)
                java.lang.String r0 = r9.toString()
                r14.error(r2, r0)
            L_0x014b:
                com.didi.soda.blocks.track.BlocksTrackHelper$Companion r14 = com.didi.soda.blocks.track.BlocksTrackHelper.Companion
                java.lang.String r0 = r7.getMessage()
                if (r0 == 0) goto L_0x0154
                r3 = r0
            L_0x0154:
                r14.trackExpressionExecuteError(r12, r13, r3)
                com.didi.soda.blocks.sdk.BlocksEngine$Companion r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
                com.didi.soda.blocks.sdk.BlocksEngine r12 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r12, r6, r5, r6)
                boolean r12 = r12.isDebug()
                if (r12 != 0) goto L_0x0164
                return r6
            L_0x0164:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.parse.p162el.ExpressionUtil.Companion.evaluateEl(java.lang.String, java.lang.String, java.util.HashMap):java.lang.Object");
        }

        public final String makeVariableAvailable(String str) {
            Intrinsics.checkParameterIsNotNull(str, "originString");
            return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, ".", "_", false, 4, (Object) null), Const.jaLeft, "_", false, 4, (Object) null), Const.jaRight, "", false, 4, (Object) null);
        }

        public final Object makeContextAvailable$soda_compose_android_release(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "$this$makeContextAvailable");
            if (obj instanceof String) {
                return obj;
            }
            if (obj instanceof JsonElement) {
                JsonElement jsonElement = (JsonElement) obj;
                if (jsonElement.isJsonObject() || jsonElement.isJsonArray()) {
                    return JSONDecoder.decode(obj.toString());
                }
                if (jsonElement.isJsonPrimitive()) {
                    return jsonElement.getAsString();
                }
                if (jsonElement.isJsonNull()) {
                    return null;
                }
            } else if (obj instanceof Integer) {
                return obj;
            }
            IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
            if (logger != null) {
                logger.error(ExpressionUtil.TAG, "findModelValue unknown result type: " + obj);
            }
            return obj;
        }
    }
}
