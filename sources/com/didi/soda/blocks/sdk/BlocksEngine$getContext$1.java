package com.didi.soda.blocks.sdk;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: BlocksEngine.kt */
final /* synthetic */ class BlocksEngine$getContext$1 extends MutablePropertyReference0 {
    BlocksEngine$getContext$1(BlocksEngine blocksEngine) {
        super(blocksEngine);
    }

    public String getName() {
        return "mContext";
    }

    public KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(BlocksEngine.class);
    }

    public String getSignature() {
        return "getMContext()Landroid/content/Context;";
    }

    public Object get() {
        return BlocksEngine.access$getMContext$p((BlocksEngine) this.receiver);
    }

    public void set(Object obj) {
        ((BlocksEngine) this.receiver).mContext = (Context) obj;
    }
}
