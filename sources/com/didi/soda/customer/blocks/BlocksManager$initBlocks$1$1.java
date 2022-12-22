package com.didi.soda.customer.blocks;

import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksManager.kt */
/* synthetic */ class BlocksManager$initBlocks$1$1 extends FunctionReferenceImpl implements Function0<Map<String, Object>> {
    public static final BlocksManager$initBlocks$1$1 INSTANCE = new BlocksManager$initBlocks$1$1();

    BlocksManager$initBlocks$1$1() {
        super(0, ParamsHelper.class, "getCommonParams", "getCommonParams()Ljava/util/Map;", 0);
    }

    public final Map<String, Object> invoke() {
        return ParamsHelper.getCommonParams();
    }
}
