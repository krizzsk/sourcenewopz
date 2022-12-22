package com.didi.soda.blocks.optimize;

import com.didi.soda.blocks.sdk.BlocksEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/blocks/optimize/OptimizeController;", "", "()V", "mOptimizeModel", "Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;", "getOptimizeInfo", "isOpen", "", "isOpenApiReplace", "isOpenAsyncBuild", "isOpenFixElNumCompare", "isOpenRegularReplace", "isOpenResultCache", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: OptimizeController.kt */
public final class OptimizeController {
    public static final OptimizeController INSTANCE = new OptimizeController();
    private static BlocksOptimizeModel mOptimizeModel;

    private OptimizeController() {
    }

    public final boolean isOpen() {
        return getOptimizeInfo().isOpen();
    }

    public final boolean isOpenResultCache() {
        return getOptimizeInfo().isOpenResultCache();
    }

    public final boolean isOpenRegularReplace() {
        return getOptimizeInfo().isOpenRegularReplace();
    }

    public final boolean isOpenApiReplace() {
        return getOptimizeInfo().isOpenApiReplace();
    }

    public final boolean isOpenAsyncBuild() {
        return getOptimizeInfo().isOpenAsyncBuild();
    }

    public final boolean isOpenFixElNumCompare() {
        return getOptimizeInfo().isOpenFixElNumCompare();
    }

    private final BlocksOptimizeModel getOptimizeInfo() {
        if (mOptimizeModel == null) {
            BlocksOptimizeModel optimizeModel = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getConfig().getOptimizeModel();
            mOptimizeModel = optimizeModel;
            if (optimizeModel == null) {
                mOptimizeModel = new BlocksOptimizeModel();
            }
        }
        BlocksOptimizeModel blocksOptimizeModel = mOptimizeModel;
        if (blocksOptimizeModel == null) {
            Intrinsics.throwNpe();
        }
        return blocksOptimizeModel;
    }
}
