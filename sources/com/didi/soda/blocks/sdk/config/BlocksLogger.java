package com.didi.soda.blocks.sdk.config;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksLogger;", "Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "()V", "debug", "", "msg", "", "tag", "error", "info", "Companion", "SingletonHolder", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BlocksLogger.kt */
public final class BlocksLogger implements IBlocksLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "Blocks";

    @JvmStatic
    public static final BlocksLogger getLogger() {
        return Companion.getLogger();
    }

    private BlocksLogger() {
    }

    public /* synthetic */ BlocksLogger(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void debug(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        debug(TAG, str);
    }

    public final void info(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        info(TAG, str);
    }

    public final void error(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        error(TAG, str);
    }

    public void debug(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(str2, "msg");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s - debug：%s", Arrays.copyOf(new Object[]{str, str2}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        System.out.println(format);
    }

    public void info(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(str2, "msg");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s - info：%s", Arrays.copyOf(new Object[]{str, str2}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        System.out.println(format);
    }

    public void error(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(str2, "msg");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s - error：%s", Arrays.copyOf(new Object[]{str, str2}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        System.out.println(format);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksLogger$Companion;", "", "()V", "TAG", "", "getLogger", "Lcom/didi/soda/blocks/sdk/config/BlocksLogger;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BlocksLogger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final BlocksLogger getLogger() {
            return SingletonHolder.INSTANCE.getInstance();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksLogger$SingletonHolder;", "", "()V", "instance", "Lcom/didi/soda/blocks/sdk/config/BlocksLogger;", "getInstance", "()Lcom/didi/soda/blocks/sdk/config/BlocksLogger;", "setInstance", "(Lcom/didi/soda/blocks/sdk/config/BlocksLogger;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BlocksLogger.kt */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static BlocksLogger instance = new BlocksLogger((DefaultConstructorMarker) null);

        private SingletonHolder() {
        }

        public final BlocksLogger getInstance() {
            return instance;
        }

        public final void setInstance(BlocksLogger blocksLogger) {
            Intrinsics.checkParameterIsNotNull(blocksLogger, "<set-?>");
            instance = blocksLogger;
        }
    }
}
