package com.didi.component.framework.pages.invitation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.component.framework.pages.invitation.model.AddressBookAuthorization;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J-\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationNoPermissonFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activityId", "", "addressBookAuthorization", "Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;", "getAddressBookAuthorization", "()Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;", "addressBookAuthorization$delegate", "Lkotlin/Lazy;", "firstQuest", "", "mListener", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "getMListener", "()Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "mListener$delegate", "mRootView", "Landroid/view/View;", "showSystemUi", "init", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNoPermissonFragment.kt */
public final class InvitationNoPermissonFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f13833g = 1000;

    /* renamed from: a */
    private View f13834a;

    /* renamed from: b */
    private final Lazy f13835b = LazyKt.lazy(new InvitationNoPermissonFragment$mListener$2(this));

    /* renamed from: c */
    private boolean f13836c;

    /* renamed from: d */
    private boolean f13837d = true;

    /* renamed from: e */
    private long f13838e;

    /* renamed from: f */
    private final Lazy f13839f = LazyKt.lazy(new InvitationNoPermissonFragment$addressBookAuthorization$2(this));

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final IInvitationListener m9601a() {
        return (IInvitationListener) this.f13835b.getValue();
    }

    /* renamed from: b */
    private final AddressBookAuthorization m9603b() {
        return (AddressBookAuthorization) this.f13839f.getValue();
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationNoPermissonFragment$Companion;", "", "()V", "REQUEST_CODE_CONTACTS", "", "getREQUEST_CODE_CONTACTS", "()I", "newInstance", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitationNoPermissonFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getREQUEST_CODE_CONTACTS() {
            return InvitationNoPermissonFragment.f13833g;
        }

        public final Fragment newInstance(Bundle bundle) {
            InvitationNoPermissonFragment invitationNoPermissonFragment = new InvitationNoPermissonFragment();
            invitationNoPermissonFragment.setArguments(bundle);
            return invitationNoPermissonFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.f13834a = layoutInflater.inflate(R.layout.global_fragment_invite_no_permisson, viewGroup, false);
        m9604c();
        GlobalOmegaUtils.trackEvent("gp_PromoCode_Sync_sw", "activity_id", String.valueOf(this.f13838e));
        return this.f13834a;
    }

    /* renamed from: c */
    private final void m9604c() {
        Bundle arguments = getArguments();
        this.f13838e = arguments == null ? 0 : arguments.getLong("activityId");
        GlobalSPUtil.setFirstOpenInvitePage(getContext(), false);
        View view = this.f13834a;
        String str = null;
        AppCompatTextView appCompatTextView = view == null ? null : (AppCompatTextView) view.findViewById(R.id.global_invite_permisson_request);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    InvitationNoPermissonFragment.m9602a(InvitationNoPermissonFragment.this, view);
                }
            });
        }
        View view2 = this.f13834a;
        ImageView imageView = view2 == null ? null : (CircleImageView) view2.findViewById(R.id.iv_invite_permission_picture);
        AddressBookAuthorization b = m9603b();
        ViewExKt.loadImage(imageView, b == null ? null : b.getPictureUrl());
        View view3 = this.f13834a;
        TextView textView = view3 == null ? null : (AppCompatTextView) view3.findViewById(R.id.tv_invite_permission_title);
        AddressBookAuthorization b2 = m9603b();
        ViewExKt.text(textView, b2 == null ? null : b2.getTitle());
        View view4 = this.f13834a;
        TextView textView2 = view4 == null ? null : (AppCompatTextView) view4.findViewById(R.id.tv_invite_permission_content);
        AddressBookAuthorization b3 = m9603b();
        ViewExKt.text(textView2, b3 == null ? null : b3.getText());
        View view5 = this.f13834a;
        TextView textView3 = view5 == null ? null : (AppCompatTextView) view5.findViewById(R.id.global_invite_permisson_request);
        AddressBookAuthorization b4 = m9603b();
        if (b4 != null) {
            str = b4.getButtonText();
        }
        ViewExKt.text(textView3, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9602a(InvitationNoPermissonFragment invitationNoPermissonFragment, View view) {
        Intrinsics.checkNotNullParameter(invitationNoPermissonFragment, "this$0");
        GlobalOmegaUtils.trackEvent("gp_PromoCode_Sync_ck", "activity_id", String.valueOf(invitationNoPermissonFragment.f13838e));
        IInvitationListener a = invitationNoPermissonFragment.m9601a();
        if (a == null ? false : a.checkContactsPermission()) {
            IInvitationListener a2 = invitationNoPermissonFragment.m9601a();
            if (a2 != null) {
                a2.switchToTargetPage(InvitationPageActivity.CONTACTS_NOBACK);
                return;
            }
            return;
        }
        boolean shouldShowRequestPermissionRationale = invitationNoPermissonFragment.shouldShowRequestPermissionRationale(Permission.READ_CONTACTS);
        invitationNoPermissonFragment.f13836c = shouldShowRequestPermissionRationale;
        if (shouldShowRequestPermissionRationale || invitationNoPermissonFragment.f13837d) {
            invitationNoPermissonFragment.f13837d = false;
            invitationNoPermissonFragment.requestPermissions(new String[]{Permission.READ_CONTACTS}, f13833g);
            return;
        }
        IInvitationListener a3 = invitationNoPermissonFragment.m9601a();
        if (a3 != null) {
            String string = ResourcesHelper.getString(invitationNoPermissonFragment.getContext(), R.string.Global_Rider_MgM_new_campaign_page_Address_book_CbMx);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …                        )");
            String string2 = ResourcesHelper.getString(invitationNoPermissonFragment.getContext(), R.string.Global_Rider_MgM_new_campaign_page_Contacts_permitted_Oozx);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …                        )");
            a3.showErrorDialog(string, string2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IInvitationListener a;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == f13833g && iArr[0] == 0 && (a = m9601a()) != null) {
            a.switchToTargetPage(InvitationPageActivity.CONTACTS_NOBACK);
        }
    }
}
