package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c) {
        super(Character.valueOf(c));
    }

    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType charType = moduleDescriptor.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }

    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) getValue()).charValue()), m44945a(((Character) getValue()).charValue())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        return format;
    }

    /* renamed from: a */
    private final String m44945a(char c) {
        if (c == 8) {
            return "\\b";
        }
        if (c == 9) {
            return "\\t";
        }
        if (c == 10) {
            return "\\n";
        }
        if (c == 12) {
            return "\\f";
        }
        if (c == 13) {
            return "\\r";
        }
        return m44946b(c) ? String.valueOf(c) : "?";
    }

    /* renamed from: b */
    private final boolean m44946b(char c) {
        byte type = (byte) Character.getType(c);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }
}
