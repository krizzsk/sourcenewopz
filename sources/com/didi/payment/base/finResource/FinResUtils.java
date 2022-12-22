package com.didi.payment.base.finResource;

import android.content.Context;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/base/finResource/FinResUtils;", "", "()V", "showFinSysPopUpDlg", "", "context", "Landroid/content/Context;", "popUpStates", "", "Lcom/didi/payment/base/finResource/ResourceStateData;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinResUtils.kt */
public final class FinResUtils {
    public static final FinResUtils INSTANCE = new FinResUtils();

    private FinResUtils() {
    }

    public final void showFinSysPopUpDlg(Context context, List<ResourceStateData> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        ResourceStateData resourceStateData = list == null ? null : (ResourceStateData) CollectionsKt.firstOrNull(list);
        if (resourceStateData != null) {
            ((Request) ((Request) ((Request) ((Request) ((Request) ((Request) ((Request) DRouter.build("99OneTravel://one/fintech_resources_page").putExtra(InvitationPageActivity.RESOURCE_ID, resourceStateData.getResourceId())).putExtra("planId", resourceStateData.getPlanId())).putExtra("resourceType", resourceStateData.getResourceType())).putExtra("activityId", resourceStateData.getActivityId())).putExtra("title", resourceStateData.getTitle())).putExtra("link", resourceStateData.getLink())).putExtra("image", resourceStateData.getImage())).start(context);
        }
    }
}
