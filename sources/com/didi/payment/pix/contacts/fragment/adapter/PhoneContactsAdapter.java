package com.didi.payment.pix.contacts.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.contacts.p134vm.model.PhoneContacts;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003-./B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0016J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "DISPLAY_MODE_NORMAL", "", "DISPLAY_MODE_SEARCH", "VIEW_TYPE_CONTACTS_ITEM", "VIEW_TYPE_SEPRATOR", "contactList", "", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "getContactList", "()Ljava/util/List;", "setContactList", "(Ljava/util/List;)V", "displayMode", "getDisplayMode", "()I", "setDisplayMode", "(I)V", "indexMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mOnItemClickListener", "Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$OnItemClickListener;", "displayAllContacts", "", "filterByInputPrefix", "inputPrefix", "", "getItemCount", "getItemViewType", "visiblePos", "getVisibleItemAt", "posVisible", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "listener", "ContactsGroupHolder", "ContactsViewHolder", "OnItemClickListener", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PhoneContactsAdapter.kt */
public final class PhoneContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnItemClickListener f31042a;

    /* renamed from: b */
    private final int f31043b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f31044c = 1;

    /* renamed from: d */
    private List<PhoneContacts> f31045d = new ArrayList();

    /* renamed from: e */
    private int f31046e = this.f31043b;

    /* renamed from: f */
    private int f31047f;

    /* renamed from: g */
    private int f31048g = 1;

    /* renamed from: h */
    private HashMap<Integer, Integer> f31049h = new HashMap<>();

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$OnItemClickListener;", "", "onContactClicked", "", "contacts", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PhoneContactsAdapter.kt */
    public interface OnItemClickListener {
        void onContactClicked(PhoneContacts phoneContacts);
    }

    public final List<PhoneContacts> getContactList() {
        return this.f31045d;
    }

    public final void setContactList(List<PhoneContacts> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f31045d = list;
    }

    public final int getDisplayMode() {
        return this.f31046e;
    }

    public final void setDisplayMode(int i) {
        this.f31046e = i;
    }

    public final void filterByInputPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "inputPrefix");
        if (TextUtil.isEmpty(str)) {
            this.f31046e = this.f31043b;
            this.f31049h.clear();
        } else {
            this.f31046e = this.f31044c;
            int i = -1;
            int i2 = 0;
            for (PhoneContacts next : this.f31045d) {
                int i3 = i2 + 1;
                if (TextUtil.isEmpty(next.getPhoneNum()) || !StringsKt.contains((CharSequence) next.getName(), (CharSequence) str, true)) {
                    next.setVisibility(8);
                } else {
                    next.setVisibility(0);
                    i++;
                    this.f31049h.put(Integer.valueOf(i), Integer.valueOf(i2));
                }
                i2 = i3;
            }
        }
        notifyDataSetChanged();
    }

    public void displayAllContacts() {
        this.f31046e = this.f31043b;
        for (PhoneContacts visibility : this.f31045d) {
            visibility.setVisibility(0);
        }
        this.f31049h.clear();
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == this.f31048g) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_histrans_contact_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new ContactsViewHolder(this, inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_letter_group, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "groupItemView");
        return new ContactsGroupHolder(this, inflate2);
    }

    public int getItemCount() {
        return this.f31046e == this.f31043b ? CollectionUtil.size((Collection<?>) this.f31045d) : this.f31049h.size();
    }

    public int getItemViewType(int i) {
        if (this.f31046e == this.f31044c) {
            return this.f31048g;
        }
        return TextUtil.isEmpty(this.f31045d.get(i).getPhoneNum()) ? this.f31047f : this.f31048g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final PhoneContacts m21839a(int i) {
        Integer num = this.f31049h.containsKey(Integer.valueOf(i)) ? this.f31049h.get(Integer.valueOf(i)) : null;
        if (num == null) {
            return new PhoneContacts("", "");
        }
        int intValue = num.intValue();
        if (intValue < 0 || intValue >= CollectionUtil.size((Collection<?>) this.f31045d)) {
            return new PhoneContacts("", "");
        }
        return this.f31045d.get(intValue);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (ContactsViewHolder.class.isInstance(viewHolder)) {
            ((ContactsViewHolder) viewHolder).bind(i);
        } else if (ContactsGroupHolder.class.isInstance(viewHolder)) {
            ((ContactsGroupHolder) viewHolder).bind(i);
        }
    }

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\f¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$ContactsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter;Landroid/view/View;)V", "bindedPhoneContacts", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "headIconTv", "Landroid/widget/TextView;", "getHeadIconTv", "()Landroid/widget/TextView;", "setHeadIconTv", "(Landroid/widget/TextView;)V", "headImg", "Landroid/widget/ImageView;", "getHeadImg", "()Landroid/widget/ImageView;", "setHeadImg", "(Landroid/widget/ImageView;)V", "keyTv", "getKeyTv", "setKeyTv", "leftSpaceView", "getLeftSpaceView", "()Landroid/view/View;", "setLeftSpaceView", "(Landroid/view/View;)V", "nameTv", "getNameTv", "setNameTv", "bind", "", "pos", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PhoneContactsAdapter.kt */
    public final class ContactsViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public PhoneContacts bindedPhoneContacts;
        private TextView headIconTv;
        private ImageView headImg;
        private TextView keyTv;
        private View leftSpaceView;
        private TextView nameTv;
        final /* synthetic */ PhoneContactsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContactsViewHolder(PhoneContactsAdapter phoneContactsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(phoneContactsAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = phoneContactsAdapter;
            this.leftSpaceView = view.findViewById(R.id.left_space);
            this.headImg = (ImageView) view.findViewById(R.id.expand_indicator_img);
            this.headIconTv = (TextView) view.findViewById(R.id.pix_contact_head_icon_tv);
            this.nameTv = (TextView) view.findViewById(R.id.pix_contact_name_tv);
            this.keyTv = (TextView) view.findViewById(R.id.pix_key_value_tv);
            final PhoneContactsAdapter phoneContactsAdapter2 = this.this$0;
            view.setOnClickListener(new DoubleCheckOnClickListener() {
                public void doClick(View view) {
                    OnItemClickListener access$getMOnItemClickListener$p = phoneContactsAdapter2.f31042a;
                    if (access$getMOnItemClickListener$p != null) {
                        PhoneContacts access$getBindedPhoneContacts$p = this.bindedPhoneContacts;
                        if (access$getBindedPhoneContacts$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                            access$getBindedPhoneContacts$p = null;
                        }
                        access$getMOnItemClickListener$p.onContactClicked(access$getBindedPhoneContacts$p);
                    }
                }
            });
        }

        public final ImageView getHeadImg() {
            return this.headImg;
        }

        public final void setHeadImg(ImageView imageView) {
            this.headImg = imageView;
        }

        public final TextView getHeadIconTv() {
            return this.headIconTv;
        }

        public final void setHeadIconTv(TextView textView) {
            this.headIconTv = textView;
        }

        public final TextView getNameTv() {
            return this.nameTv;
        }

        public final void setNameTv(TextView textView) {
            this.nameTv = textView;
        }

        public final TextView getKeyTv() {
            return this.keyTv;
        }

        public final void setKeyTv(TextView textView) {
            this.keyTv = textView;
        }

        public final View getLeftSpaceView() {
            return this.leftSpaceView;
        }

        public final void setLeftSpaceView(View view) {
            this.leftSpaceView = view;
        }

        public final void bind(int i) {
            TextView headIconTv2;
            this.this$0.getContactList();
            PhoneContactsAdapter phoneContactsAdapter = this.this$0;
            this.bindedPhoneContacts = phoneContactsAdapter.getDisplayMode() == phoneContactsAdapter.f31044c ? phoneContactsAdapter.m21839a(i) : phoneContactsAdapter.getContactList().get(i);
            View leftSpaceView2 = getLeftSpaceView();
            if (leftSpaceView2 != null) {
                leftSpaceView2.setVisibility(0);
            }
            ImageView headImg2 = getHeadImg();
            if (headImg2 != null) {
                headImg2.setVisibility(8);
            }
            TextView nameTv2 = getNameTv();
            PhoneContacts phoneContacts = null;
            if (nameTv2 != null) {
                PhoneContacts phoneContacts2 = this.bindedPhoneContacts;
                if (phoneContacts2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                    phoneContacts2 = null;
                }
                nameTv2.setText(phoneContacts2.getName());
            }
            TextView keyTv2 = getKeyTv();
            if (keyTv2 != null) {
                PhoneContacts phoneContacts3 = this.bindedPhoneContacts;
                if (phoneContacts3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                    phoneContacts3 = null;
                }
                keyTv2.setText(phoneContacts3.getPhoneNum());
            }
            PhoneContacts phoneContacts4 = this.bindedPhoneContacts;
            if (phoneContacts4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                phoneContacts4 = null;
            }
            if (TextUtil.isEmpty(phoneContacts4.getIconUrl()) && (headIconTv2 = getHeadIconTv()) != null) {
                PhoneContacts phoneContacts5 = this.bindedPhoneContacts;
                if (phoneContacts5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                    phoneContacts5 = null;
                }
                String name = phoneContacts5.getName();
                if (name != null) {
                    String substring = name.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    headIconTv2.setText(substring);
                    headIconTv2.setVisibility(0);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            PhoneContacts phoneContacts6 = this.bindedPhoneContacts;
            if (phoneContacts6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
            } else {
                phoneContacts = phoneContacts6;
            }
            if (phoneContacts.isFirstInGroup()) {
                this.itemView.findViewById(R.id.item_divider_line_view).setVisibility(8);
            } else {
                this.itemView.findViewById(R.id.item_divider_line_view).setVisibility(0);
            }
        }
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "listener");
        this.f31042a = onItemClickListener;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$ContactsGroupHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter;Landroid/view/View;)V", "bindedPhoneContacts", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "bind", "", "pos", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PhoneContactsAdapter.kt */
    public final class ContactsGroupHolder extends RecyclerView.ViewHolder {
        private PhoneContacts bindedPhoneContacts;
        final /* synthetic */ PhoneContactsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContactsGroupHolder(PhoneContactsAdapter phoneContactsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(phoneContactsAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = phoneContactsAdapter;
        }

        public final void bind(int i) {
            this.bindedPhoneContacts = this.this$0.getContactList().size() > i ? this.this$0.getContactList().get(i) : new PhoneContacts("", "");
            TextView textView = (TextView) this.itemView.findViewById(R.id.contact_group_letter_tv);
            PhoneContacts phoneContacts = this.bindedPhoneContacts;
            if (phoneContacts == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindedPhoneContacts");
                phoneContacts = null;
            }
            textView.setText(phoneContacts.getName());
        }
    }
}
