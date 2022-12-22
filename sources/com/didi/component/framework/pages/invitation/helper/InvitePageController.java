package com.didi.component.framework.pages.invitation.helper;

import android.content.Context;
import android.graphics.Paint;
import com.didi.component.common.net.CarRequest;
import com.didi.component.framework.pages.invitation.model.InviteContactsModel;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/InvitePageController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "checkContractIsOrInvite", "", "callback", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackContacts;", "phoneList", "", "", "needCheck", "", "parseThemes", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "theme", "refreshInviteList", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackList;", "currentPage", "", "pageSize", "refreshInvitePage", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackPage;", "resourceChannel", "CallbackContacts", "CallbackList", "CallbackPage", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageController.kt */
public final class InvitePageController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Context f13884a;

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackContacts;", "", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "contactsModel", "Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitePageController.kt */
    public interface CallbackContacts {
        void onError(IOException iOException);

        void onFailure(String str);

        void onSuccess(InviteContactsModel inviteContactsModel);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackList;", "", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "listModel", "Lcom/didi/component/framework/pages/invitation/model/InviteListModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitePageController.kt */
    public interface CallbackList {
        void onError(IOException iOException);

        void onFailure(String str);

        void onSuccess(InviteListModel inviteListModel);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackPage;", "", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "pageData", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "themeData", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitePageController.kt */
    public interface CallbackPage {
        void onError(IOException iOException);

        void onFailure(String str);

        void onSuccess(PageData pageData, InviteTheme inviteTheme);
    }

    public InvitePageController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13884a = context;
    }

    public final Context getContext() {
        return this.f13884a;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$Companion;", "", "()V", "computeHeight", "", "space", "", "textSize", "text", "", "width", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitePageController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float computeHeight(int i, int i2, String str, float f) {
            Intrinsics.checkNotNullParameter(str, "text");
            boolean z = false;
            if (str.length() == 0) {
                return 0.0f;
            }
            Paint paint = new Paint();
            paint.setTextSize((float) i2);
            float measureText = paint.measureText(str);
            float f2 = measureText / f;
            if (measureText % f == 0.0f) {
                z = true;
            }
            if (!z) {
                f2 += (float) 1;
            }
            return ((paint.getFontMetrics().bottom - paint.getFontMetrics().top) * f2) + ((float) i);
        }
    }

    public final void refreshInvitePage(CallbackPage callbackPage, long j) {
        Intrinsics.checkNotNullParameter(callbackPage, "callback");
        CarRequest.getInvitationInfo(this.f13884a, new InvitePageController$refreshInvitePage$1(this, callbackPage), j);
    }

    public static /* synthetic */ void refreshInviteList$default(InvitePageController invitePageController, CallbackList callbackList, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        invitePageController.refreshInviteList(callbackList, j, j2);
    }

    public final void refreshInviteList(CallbackList callbackList, long j, long j2) {
        Intrinsics.checkNotNullParameter(callbackList, "callback");
        CarRequest.getInvitationList(this.f13884a, new InvitePageController$refreshInviteList$1(callbackList), j, j2);
    }

    public final void checkContractIsOrInvite(CallbackContacts callbackContacts, List<String> list, int i) {
        Intrinsics.checkNotNullParameter(callbackContacts, "callback");
        Intrinsics.checkNotNullParameter(list, "phoneList");
        CarRequest.checkContractIsOrInvite(this.f13884a, list, i, new InvitePageController$checkContractIsOrInvite$1(callbackContacts));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final InviteTheme m9642a(String str) {
        if (str == null) {
            return null;
        }
        return (InviteTheme) new Gson().fromJson(str, InviteTheme.class);
    }
}
