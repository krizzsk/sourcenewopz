package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f60710e;

    /* renamed from: f */
    private static final List<String> f60711f;

    /* renamed from: g */
    private static final Map<String, Integer> f60712g;

    /* renamed from: a */
    private final JvmProtoBuf.StringTableTypes f60713a;

    /* renamed from: b */
    private final String[] f60714b;

    /* renamed from: c */
    private final Set<Integer> f60715c;

    /* renamed from: d */
    private final List<JvmProtoBuf.StringTableTypes.Record> f60716d;

    /* compiled from: JvmNameResolver.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolver(JvmProtoBuf.StringTableTypes stringTableTypes, String[] strArr) {
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(stringTableTypes, "types");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        this.f60713a = stringTableTypes;
        this.f60714b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNullExpressionValue(localNameList, "");
            set = CollectionsKt.toSet(localNameList);
        }
        this.f60715c = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record next : recordList) {
            int range = next.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(next);
            }
        }
        arrayList.trimToSize();
        Unit unit = Unit.INSTANCE;
        this.f60716d = arrayList;
    }

    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.f60713a;
    }

    public String getString(int i) {
        String str;
        int i2 = i;
        JvmProtoBuf.StringTableTypes.Record record = this.f60716d.get(i2);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                int size = f60711f.size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = f60711f.get(record.getPredefinedIndex());
                }
            }
            str = this.f60714b[i2];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, TypedValues.Custom.S_STRING);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(str2, TypedValues.Custom.S_STRING);
            str2 = StringsKt.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i3 == 2) {
            Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
            str3 = StringsKt.replace$default(str3, '$', '.', false, 4, (Object) null);
        } else if (i3 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            Intrinsics.checkNotNullExpressionValue(str4, TypedValues.Custom.S_STRING);
            str3 = StringsKt.replace$default(str4, '$', '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
        return str3;
    }

    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    public boolean isLocalClassName(int i) {
        return this.f60715c.contains(Integer.valueOf(i));
    }

    /* compiled from: JvmNameResolver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        f60710e = joinToString$default;
        List<String> listOf = CollectionsKt.listOf(Intrinsics.stringPlus(joinToString$default, "/Any"), Intrinsics.stringPlus(f60710e, "/Nothing"), Intrinsics.stringPlus(f60710e, "/Unit"), Intrinsics.stringPlus(f60710e, "/Throwable"), Intrinsics.stringPlus(f60710e, "/Number"), Intrinsics.stringPlus(f60710e, "/Byte"), Intrinsics.stringPlus(f60710e, "/Double"), Intrinsics.stringPlus(f60710e, "/Float"), Intrinsics.stringPlus(f60710e, "/Int"), Intrinsics.stringPlus(f60710e, "/Long"), Intrinsics.stringPlus(f60710e, "/Short"), Intrinsics.stringPlus(f60710e, "/Boolean"), Intrinsics.stringPlus(f60710e, "/Char"), Intrinsics.stringPlus(f60710e, "/CharSequence"), Intrinsics.stringPlus(f60710e, "/String"), Intrinsics.stringPlus(f60710e, "/Comparable"), Intrinsics.stringPlus(f60710e, "/Enum"), Intrinsics.stringPlus(f60710e, "/Array"), Intrinsics.stringPlus(f60710e, "/ByteArray"), Intrinsics.stringPlus(f60710e, "/DoubleArray"), Intrinsics.stringPlus(f60710e, "/FloatArray"), Intrinsics.stringPlus(f60710e, "/IntArray"), Intrinsics.stringPlus(f60710e, "/LongArray"), Intrinsics.stringPlus(f60710e, "/ShortArray"), Intrinsics.stringPlus(f60710e, "/BooleanArray"), Intrinsics.stringPlus(f60710e, "/CharArray"), Intrinsics.stringPlus(f60710e, "/Cloneable"), Intrinsics.stringPlus(f60710e, "/Annotation"), Intrinsics.stringPlus(f60710e, "/collections/Iterable"), Intrinsics.stringPlus(f60710e, "/collections/MutableIterable"), Intrinsics.stringPlus(f60710e, "/collections/Collection"), Intrinsics.stringPlus(f60710e, "/collections/MutableCollection"), Intrinsics.stringPlus(f60710e, "/collections/List"), Intrinsics.stringPlus(f60710e, "/collections/MutableList"), Intrinsics.stringPlus(f60710e, "/collections/Set"), Intrinsics.stringPlus(f60710e, "/collections/MutableSet"), Intrinsics.stringPlus(f60710e, "/collections/Map"), Intrinsics.stringPlus(f60710e, "/collections/MutableMap"), Intrinsics.stringPlus(f60710e, "/collections/Map.Entry"), Intrinsics.stringPlus(f60710e, "/collections/MutableMap.MutableEntry"), Intrinsics.stringPlus(f60710e, "/collections/Iterator"), Intrinsics.stringPlus(f60710e, "/collections/MutableIterator"), Intrinsics.stringPlus(f60710e, "/collections/ListIterator"), Intrinsics.stringPlus(f60710e, "/collections/MutableListIterator"));
        f60711f = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(listOf);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        f60712g = linkedHashMap;
    }
}
