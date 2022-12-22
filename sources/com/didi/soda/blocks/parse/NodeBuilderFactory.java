package com.didi.soda.blocks.parse;

import com.didi.soda.blocks.model.TemplateModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.optimize.OptimizeController;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.template.TemplateManager;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderFactory;", "", "()V", "Companion", "iNodeBulder", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NodeBuilderFactory.kt */
public final class NodeBuilderFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderFactory$iNodeBulder;", "", "buildWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "templateId", "", "model", "Lcom/google/gson/JsonObject;", "rvModel", "blockScope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NodeBuilderFactory.kt */
    public interface iNodeBulder {
        WidgetNodeModel buildWidgetNode(String str, JsonObject jsonObject, Object obj, IBlockScope iBlockScope);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuilderFactory$Companion;", "", "()V", "createNodeBulder", "Lcom/didi/soda/blocks/parse/NodeBuilderFactory$iNodeBulder;", "templateManager", "Lcom/didi/soda/blocks/template/TemplateManager;", "templateId", "", "isOldTemplateVersion", "", "version", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NodeBuilderFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final iNodeBulder createNodeBulder(TemplateManager templateManager, String str) {
            String str2;
            Intrinsics.checkParameterIsNotNull(templateManager, "templateManager");
            Intrinsics.checkParameterIsNotNull(str, "templateId");
            TemplateModel templateById = templateManager.getTemplateById(str);
            if (templateById == null || (str2 = templateById.getTemplateVersion()) == null) {
                str2 = "1";
            }
            if (isOldTemplateVersion(str2)) {
                return new NodeBuilderOld(templateManager);
            }
            if (OptimizeController.INSTANCE.isOpen()) {
                return new NodeBuilderOptimized(templateManager);
            }
            return new NodeBuilder(templateManager);
        }

        public final boolean isOldTemplateVersion(String str) {
            Intrinsics.checkParameterIsNotNull(str, "version");
            return Integer.parseInt(str) <= 1;
        }
    }
}
