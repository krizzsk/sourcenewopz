package com.didi.soda.blocks.style;

import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.utils.DPUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\t\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\n\u001a\u00020\u0005*\u00020\u0003H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0005*\u00020\u0003H\u0000¨\u0006\f"}, mo175978d2 = {"convert2Num", "", "num", "", "isDPStyle", "", "key", "", "convert2Percent", "convert2YogaEnumString", "isAutoValue", "isPercentValue", "soda-compose-android_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: ValueManager.kt */
public final class ValueManagerKt {
    public static final boolean isAutoValue(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$isAutoValue");
        String obj2 = obj.toString();
        if (obj2 != null) {
            String lowerCase = obj2.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(lowerCase);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean isPercentValue(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$isPercentValue");
        return StringsKt.endsWith$default(obj.toString(), "%", false, 2, (Object) null);
    }

    public static final float convert2Percent(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$convert2Percent");
        if (!isPercentValue(obj)) {
            return 0.0f;
        }
        String obj2 = obj.toString();
        if (obj2.length() == 1) {
            return 0.0f;
        }
        int length = obj2.length() - 1;
        if (obj2 != null) {
            String substring = obj2.substring(0, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return Float.parseFloat(substring);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String convert2YogaEnumString(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$convert2YogaEnumString");
        String obj2 = obj.toString();
        if (obj2 != null) {
            String upperCase = obj2.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            return StringsKt.replace$default(upperCase, "-", "_", false, 4, (Object) null);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final float convert2Num(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$convert2Num");
        return convert2Num(obj, true);
    }

    public static final float convert2Num(Object obj, String str) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$convert2Num");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return convert2Num(obj, ValueManager.Companion.isDPStyle(str));
    }

    public static final float convert2Num(Object obj, boolean z) {
        String message;
        Intrinsics.checkParameterIsNotNull(obj, "num");
        if ((obj instanceof String) && "undefined".equals(obj)) {
            return FloatCompanionObject.INSTANCE.getNaN();
        }
        String obj2 = obj.toString();
        try {
            if (StringsKt.endsWith$default(obj2, "px", false, 2, (Object) null)) {
                int length = obj2.length() - 2;
                if (obj2 != null) {
                    String substring = obj2.substring(0, length);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(substring) / 2.0f);
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else if (z) {
                return DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(obj2));
            } else {
                return Float.parseFloat(obj2);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
            if (logger != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("convert2Num failed with NumberFormatException:");
                String message2 = e.getMessage();
                String str = "";
                if (message2 == null) {
                    message2 = str;
                }
                sb.append(message2);
                sb.append(' ');
                Throwable cause = e.getCause();
                if (cause == null || (message = cause.getMessage()) == null) {
                    str = null;
                } else if (message != null) {
                    str = message;
                }
                sb.append(str);
                sb.append(",num is ");
                sb.append(obj);
                sb.append(" and isDPStyle is ");
                sb.append(z);
                logger.error(ValueManager.TAG, sb.toString());
            }
            if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
                return 0.0f;
            }
            throw e;
        }
    }
}
