package com.didi.aoe.extensions.support.common;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/common/DataType;", "", "value", "", "(Ljava/lang/String;II)V", "byteSize", "FLOAT32", "INT32", "UINT8", "INT64", "STRING", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DataType.kt */
public enum DataType {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[DataType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DataType.FLOAT32.ordinal()] = 1;
            $EnumSwitchMapping$0[DataType.INT32.ordinal()] = 2;
            $EnumSwitchMapping$0[DataType.UINT8.ordinal()] = 3;
            $EnumSwitchMapping$0[DataType.INT64.ordinal()] = 4;
            $EnumSwitchMapping$0[DataType.STRING.ordinal()] = 5;
        }
    }

    private DataType(int i) {
    }

    public final int byteSize() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return 4;
        }
        if (i == 3) {
            return 1;
        }
        if (i == 4) {
            return 8;
        }
        if (i == 5) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
