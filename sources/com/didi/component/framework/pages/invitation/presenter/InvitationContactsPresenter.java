package com.didi.component.framework.pages.invitation.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.invitation.helper.ICheckInvite;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.model.ContactsData;
import com.didi.component.framework.pages.invitation.model.InviteContactInfo;
import com.didi.component.framework.pages.invitation.view.IInvitationContactsView;
import com.didi.component.splitfare.contactmanage.GlobalContactsModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010 \u001a\u00020\u000bJ\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007H\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/presenter/InvitationContactsPresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationContactsView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactsInfoList", "", "Lcom/didi/component/framework/pages/invitation/model/InviteContactInfo;", "contactsMap", "", "", "getContext", "()Landroid/content/Context;", "invalidFriendList", "leftedContactsList", "uploadLists", "validFriendList", "checkContactIsOrInvite", "", "checkListener", "Lcom/didi/component/framework/pages/invitation/helper/ICheckInvite;", "phoneList", "", "contains", "", "textMain", "textSub", "convertToInfo", "contactsData", "Lcom/didi/component/framework/pages/invitation/model/ContactsData;", "getMatchList", "text", "getPhoneList", "contacts", "Lcom/didi/component/splitfare/contactmanage/GlobalContactsModel;", "trackContactsShow", "hasContacts", "", "activityId", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsPresenter.kt */
public final class InvitationContactsPresenter extends IPresenter<IInvitationContactsView> {

    /* renamed from: a */
    private final Context f13913a;

    /* renamed from: b */
    private Map<String, String> f13914b;

    /* renamed from: c */
    private List<InviteContactInfo> f13915c = new ArrayList();

    /* renamed from: d */
    private List<String> f13916d;

    /* renamed from: e */
    private List<String> f13917e;

    /* renamed from: f */
    private final List<InviteContactInfo> f13918f = new ArrayList();

    /* renamed from: g */
    private final List<InviteContactInfo> f13919g = new ArrayList();

    public final Context getContext() {
        return this.f13913a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvitationContactsPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13913a = context;
    }

    public final void checkContactIsOrInvite(ICheckInvite iCheckInvite, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "phoneList");
        new InvitePageController(this.f13913a).checkContractIsOrInvite(new InvitationContactsPresenter$checkContactIsOrInvite$1(iCheckInvite), list, 1);
    }

    /* renamed from: a */
    private final List<InviteContactInfo> m9643a(ContactsData contactsData) {
        List<String> list;
        String str;
        List<String> invalidPhoneList;
        String str2;
        List<String> validPhoneList;
        String str3;
        List<InviteContactInfo> arrayList = new ArrayList<>();
        if (!(contactsData == null || (validPhoneList = contactsData.getValidPhoneList()) == null)) {
            for (String str4 : validPhoneList) {
                Map<String, String> map = this.f13914b;
                if (map == null || (str3 = map.get(str4)) == null) {
                    str3 = str4;
                }
                InviteContactInfo inviteContactInfo = new InviteContactInfo(2000, str3, str4);
                arrayList.add(inviteContactInfo);
                this.f13918f.add(inviteContactInfo);
            }
        }
        if (contactsData == null) {
            list = null;
        } else {
            list = contactsData.getInvalidPhoneList();
        }
        Collection collection = list;
        boolean z = false;
        if (collection == null || collection.isEmpty()) {
            Collection collection2 = this.f13917e;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            if (z) {
                return arrayList;
            }
        }
        if (arrayList.size() != 0) {
            arrayList.add(new InviteContactInfo(2002, (String) null, (String) null, 6, (DefaultConstructorMarker) null));
        }
        if (!(contactsData == null || (invalidPhoneList = contactsData.getInvalidPhoneList()) == null)) {
            for (String str5 : invalidPhoneList) {
                Map<String, String> map2 = this.f13914b;
                if (map2 == null || (str2 = map2.get(str5)) == null) {
                    str2 = str5;
                }
                InviteContactInfo inviteContactInfo2 = new InviteContactInfo(2001, str2, str5);
                arrayList.add(inviteContactInfo2);
                this.f13919g.add(inviteContactInfo2);
            }
        }
        List<String> list2 = this.f13917e;
        if (list2 != null) {
            for (String str6 : list2) {
                Map<String, String> map3 = this.f13914b;
                if (map3 == null || (str = map3.get(str6)) == null) {
                    str = str6;
                }
                InviteContactInfo inviteContactInfo3 = new InviteContactInfo(2000, str, str6);
                arrayList.add(inviteContactInfo3);
                this.f13919g.add(inviteContactInfo3);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private final List<String> m9644a(List<GlobalContactsModel> list) {
        List<String> arrayList = new ArrayList<>();
        List arrayList2 = new ArrayList();
        if (this.f13914b == null) {
            this.f13914b = new LinkedHashMap();
        }
        for (GlobalContactsModel globalContactsModel : list) {
            CharSequence charSequence = globalContactsModel.phone;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                String str = globalContactsModel.phone;
                Intrinsics.checkNotNullExpressionValue(str, "it.phone");
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\\u00A0", "", false, 4, (Object) null), "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
                if (!new Regex("[^(0-9+)]").containsMatchIn(replace$default) && !arrayList2.contains(replace$default)) {
                    arrayList2.add(replace$default);
                    String str2 = globalContactsModel.phone;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.phone");
                    arrayList.add(str2);
                    String str3 = globalContactsModel.name;
                    CharSequence charSequence2 = globalContactsModel.name;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        str3 = globalContactsModel.phone;
                    }
                    Map<String, String> map = this.f13914b;
                    if (map != null) {
                        String str4 = globalContactsModel.phone;
                        Intrinsics.checkNotNullExpressionValue(str4, "it.phone");
                        Intrinsics.checkNotNullExpressionValue(str3, "name");
                        String put = map.put(str4, str3);
                    }
                }
            }
        }
        arrayList2.clear();
        return arrayList;
    }

    public final List<InviteContactInfo> getMatchList(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "text");
        List<InviteContactInfo> arrayList = new ArrayList<>();
        Iterator<InviteContactInfo> it = this.f13918f.iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            InviteContactInfo next = it.next();
            String name = next.getName();
            if (name == null) {
                name = str2;
            }
            if (!m9646a(name, str)) {
                String phone = next.getPhone();
                if (phone != null) {
                    str2 = phone;
                }
                if (!m9646a(str2, str)) {
                }
            }
            arrayList.add(next);
        }
        boolean z = true;
        for (InviteContactInfo next2 : this.f13919g) {
            if (arrayList.isEmpty()) {
                z = false;
            }
            String name2 = next2.getName();
            if (name2 == null) {
                name2 = str2;
            }
            if (!m9646a(name2, str)) {
                String phone2 = next2.getPhone();
                if (phone2 == null) {
                    phone2 = str2;
                }
                if (!m9646a(phone2, str)) {
                }
            }
            if (z) {
                arrayList.add(new InviteContactInfo(2002, (String) null, (String) null, 6, (DefaultConstructorMarker) null));
                z = false;
            }
            arrayList.add(next2);
        }
        return arrayList;
    }

    /* renamed from: a */
    private final boolean m9646a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String lowerCase2 = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
    }

    /* renamed from: a */
    private final void m9645a(int i, long j) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("activity_id", Long.valueOf(j));
        linkedHashMap.put("type", Integer.valueOf(i));
        GlobalOmegaUtils.trackEvent("gp_PromoCode_Concats_sw", (Map<String, Object>) linkedHashMap);
    }
}
