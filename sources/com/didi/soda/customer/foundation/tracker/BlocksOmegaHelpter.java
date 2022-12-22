package com.didi.soda.customer.foundation.tracker;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/BlocksOmegaHelpter;", "", "()V", "trackBusinessDataError", "", "businessData", "", "trackNoMatchTemplate", "templateId", "trackTemplateWithoutId", "template", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksOmegaHelpter.kt */
public final class BlocksOmegaHelpter {
    public static final BlocksOmegaHelpter INSTANCE = new BlocksOmegaHelpter();

    private BlocksOmegaHelpter() {
    }

    public final void trackTemplateWithoutId(String str) {
        Intrinsics.checkNotNullParameter(str, "template");
        OmegaTracker.Builder.create(EventConst.Blocks.TECH_SAILING_C_X_AETHER_TEMPLATE_NO_ID).addEventParam("template", str).build().track();
    }

    public final void trackNoMatchTemplate(String str) {
        Intrinsics.checkNotNullParameter(str, "templateId");
        OmegaTracker.Builder.create(EventConst.Blocks.TECH_SAILING_C_X_AETHER_TEMPLATE_NOT_FOUND).addEventParam("template_id", str).build().track();
    }

    public final void trackBusinessDataError(String str) {
        Intrinsics.checkNotNullParameter(str, "businessData");
        OmegaTracker.Builder.create(EventConst.Blocks.TECH_SAILING_C_X_AETHER_BUSINESS_DATA_ERROR).addEventParam("data", str).build().track();
    }
}
