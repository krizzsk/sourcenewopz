package com.didi.soda.blocks.action;

import com.didi.soda.blocks.model.WidgetNodeModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ShowActionHelper;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ShowActionHelper.kt */
public final class ShowActionHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> realTimeExposureContainerList = new ArrayList();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ShowActionHelper$Companion;", "", "()V", "realTimeExposureContainerList", "", "", "needRealTimeExposure", "", "node", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "registerRealTimeExposureContainer", "", "containerName", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ShowActionHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void registerRealTimeExposureContainer(String str) {
            Intrinsics.checkParameterIsNotNull(str, "containerName");
            ShowActionHelper.realTimeExposureContainerList.add(str);
        }

        public final boolean needRealTimeExposure(WidgetNodeModel widgetNodeModel) {
            String name;
            Intrinsics.checkParameterIsNotNull(widgetNodeModel, "node");
            WidgetNodeModel parent = widgetNodeModel.getParent();
            if (parent == null || (name = parent.getName()) == null) {
                return false;
            }
            return ShowActionHelper.realTimeExposureContainerList.contains(name);
        }
    }
}
