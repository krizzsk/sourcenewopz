package com.didi.entrega.info.binder;

import android.app.Activity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.util.AndroidBug5497Workaround;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.widget.EntregaCustomerInfoContactCardView;
import com.didi.rfusion.widget.RFEditText;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060\u0003R\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020'H\u0016J\u001c\u0010(\u001a\u00060\u0003R\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/EditContactBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/ContactModel;", "Lcom/didi/entrega/info/binder/EditContactBinder$ViewHolder;", "()V", "binderEventSource", "", "getBinderEventSource", "()I", "setBinderEventSource", "(I)V", "binderFusionChannel", "getBinderFusionChannel", "setBinderFusionChannel", "binderPageSource", "getBinderPageSource", "setBinderPageSource", "contactCardClickListener", "Lcom/didi/entrega/info/binder/EditContactBinder$ContactCardClickListener;", "getContactCardClickListener", "()Lcom/didi/entrega/info/binder/EditContactBinder$ContactCardClickListener;", "setContactCardClickListener", "(Lcom/didi/entrega/info/binder/EditContactBinder$ContactCardClickListener;)V", "isSender", "", "()Z", "setSender", "(Z)V", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ContactCardClickListener", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditContactBinder.kt */
public final class EditContactBinder extends ItemBinder<ContactModel, ViewHolder> {

    /* renamed from: a */
    private ContactCardClickListener f20758a;

    /* renamed from: b */
    private boolean f20759b = true;

    /* renamed from: c */
    private int f20760c;

    /* renamed from: d */
    private int f20761d;

    /* renamed from: e */
    private int f20762e;

    /* renamed from: f */
    private ScopeContext f20763f;

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/EditContactBinder$ContactCardClickListener;", "", "onCallingCodeClickListener", "", "callingCode", "", "countryId", "", "onPoiClickListener", "textChangeOnModel", "item", "Lcom/didi/entrega/info/model/ContactModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: EditContactBinder.kt */
    public interface ContactCardClickListener {
        void onCallingCodeClickListener(String str, int i);

        void onPoiClickListener();

        void textChangeOnModel(ContactModel contactModel);
    }

    public Class<ContactModel> bindDataType() {
        return ContactModel.class;
    }

    public final ContactCardClickListener getContactCardClickListener() {
        return this.f20758a;
    }

    public final void setContactCardClickListener(ContactCardClickListener contactCardClickListener) {
        this.f20758a = contactCardClickListener;
    }

    public final boolean isSender() {
        return this.f20759b;
    }

    public final void setSender(boolean z) {
        this.f20759b = z;
    }

    public final int getBinderFusionChannel() {
        return this.f20760c;
    }

    public final void setBinderFusionChannel(int i) {
        this.f20760c = i;
    }

    public final int getBinderPageSource() {
        return this.f20761d;
    }

    public final void setBinderPageSource(int i) {
        this.f20761d = i;
    }

    public final int getBinderEventSource() {
        return this.f20762e;
    }

    public final void setBinderEventSource(int i) {
        this.f20762e = i;
    }

    public final ScopeContext getScopeContext() {
        return this.f20763f;
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        this.f20763f = scopeContext;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.entrega_info_edit_ctact_binder, viewGroup, false);
        ScopeContext scopeContext = this.f20763f;
        if (scopeContext != null) {
            AndroidBug5497Workaround.getInstance((Activity) viewGroup.getContext()).assistComponent(scopeContext, inflate);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(this, inflate);
    }

    public void bind(ViewHolder viewHolder, ContactModel contactModel) {
        Unit unit;
        Unit unit2;
        CommonInfoEntity.Contact contact;
        CommonInfoEntity.LastName lastName;
        String lastName2;
        CommonInfoEntity.Contact contact2;
        CommonInfoEntity.FirstName firstName;
        String firstName2;
        String str;
        CommonInfoEntity.Contact contact3;
        CommonInfoEntity.PhoneNumber phoneNumber;
        CommonInfoEntity.Contact contact4;
        CommonInfoEntity.PhoneNumber phoneNumber2;
        CommonInfoEntity.Contact contact5;
        CommonInfoEntity.BuildingAddress buildingAddress;
        String buildingAddress2;
        AddressEntity address;
        AddressEntity.PoiEntity poiEntity;
        ContactCardClickListener contactCardClickListener;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (contactModel != null) {
            ((EntregaCustomerInfoContactCardView) viewHolder.itemView.findViewById(R.id.contact_card)).setPageParams(getBinderPageSource(), getBinderEventSource());
            ((EntregaCustomerInfoContactCardView) viewHolder.itemView.findViewById(R.id.contact_card)).setUpWidgetEntity(contactModel.getContact(), isSender(), getBinderFusionChannel());
            CommonInfoEntity.Contact contact6 = contactModel.getContact();
            if (!(contact6 == null || (address = contact6.getAddress()) == null || (poiEntity = address.poi) == null || poiEntity.poiId == null || (contactCardClickListener = getContactCardClickListener()) == null)) {
                contactCardClickListener.textChangeOnModel(contactModel);
            }
            ((EntregaCustomerInfoContactCardView) viewHolder.itemView.findViewById(R.id.contact_card)).setPoiClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditContactBinder.m15178a(EditContactBinder.this, view);
                }
            });
            ((EntregaCustomerInfoContactCardView) viewHolder.itemView.findViewById(R.id.contact_card)).setCallingCodeClickListener(new View.OnClickListener(contactModel) {
                public final /* synthetic */ ContactModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    EditContactBinder.m15179a(EditContactBinder.this, this.f$1, view);
                }
            });
            RFEditText rFEditText = (RFEditText) viewHolder.itemView.findViewById(R.id.etv_building);
            rFEditText.addTextChangedListener(new EditContactBinder$bind$1$4$1(contactModel, this));
            Unit unit3 = null;
            if (contactModel == null || (contact5 = contactModel.getContact()) == null || (buildingAddress = contact5.getBuildingAddress()) == null || (buildingAddress2 = buildingAddress.getBuildingAddress()) == null) {
                unit = null;
            } else {
                rFEditText.setText(buildingAddress2);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                rFEditText.setText("");
            }
            Editable text = rFEditText.getText();
            int i = 0;
            rFEditText.setSelection(text == null ? 0 : text.length());
            RFEditText rFEditText2 = (RFEditText) viewHolder.itemView.findViewById(R.id.etv_phone);
            rFEditText2.addTextChangedListener(new EditContactBinder$bind$1$5$1(contactModel, this, viewHolder));
            CharSequence phoneNumber3 = (contactModel == null || (contact4 = contactModel.getContact()) == null || (phoneNumber2 = contact4.getPhoneNumber()) == null) ? null : phoneNumber2.getPhoneNumber();
            if (!(phoneNumber3 == null || phoneNumber3.length() == 0)) {
                if (contactModel == null || (contact3 = contactModel.getContact()) == null || (phoneNumber = contact3.getPhoneNumber()) == null) {
                    str = null;
                } else {
                    str = phoneNumber.getPhoneNumber();
                }
                rFEditText2.setText(str);
            } else if (isSender()) {
                String phone = LoginUtil.getPhone();
                if (phone == null) {
                    phone = "";
                }
                rFEditText2.setText(phone);
            } else {
                rFEditText2.setText("");
            }
            Editable text2 = rFEditText2.getText();
            rFEditText2.setSelection(text2 == null ? 0 : text2.length());
            RFEditText rFEditText3 = (RFEditText) viewHolder.itemView.findViewById(R.id.etv_first_name);
            rFEditText3.addTextChangedListener(new EditContactBinder$bind$1$6$1(contactModel, this));
            if (contactModel == null || (contact2 = contactModel.getContact()) == null || (firstName = contact2.getFirstName()) == null || (firstName2 = firstName.getFirstName()) == null) {
                unit2 = null;
            } else {
                rFEditText3.setText(firstName2);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                rFEditText3.setText("");
            }
            Editable text3 = rFEditText3.getText();
            rFEditText3.setSelection(text3 == null ? 0 : text3.length());
            RFEditText rFEditText4 = (RFEditText) viewHolder.itemView.findViewById(R.id.etv_last_name);
            rFEditText4.addTextChangedListener(new EditContactBinder$bind$1$7$1(contactModel, this));
            if (!(contactModel == null || (contact = contactModel.getContact()) == null || (lastName = contact.getLastName()) == null || (lastName2 = lastName.getLastName()) == null)) {
                rFEditText4.setText(lastName2);
                unit3 = Unit.INSTANCE;
            }
            if (unit3 == null) {
                rFEditText4.setText("");
            }
            Editable text4 = rFEditText4.getText();
            if (text4 != null) {
                i = text4.length();
            }
            rFEditText4.setSelection(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15178a(EditContactBinder editContactBinder, View view) {
        Intrinsics.checkNotNullParameter(editContactBinder, "this$0");
        ContactCardClickListener contactCardClickListener = editContactBinder.getContactCardClickListener();
        if (contactCardClickListener != null) {
            contactCardClickListener.onPoiClickListener();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15179a(EditContactBinder editContactBinder, ContactModel contactModel, View view) {
        CommonInfoEntity.PhoneNumber phoneNumber;
        Intrinsics.checkNotNullParameter(editContactBinder, "this$0");
        Intrinsics.checkNotNullParameter(contactModel, "$model");
        ContactCardClickListener contactCardClickListener = editContactBinder.getContactCardClickListener();
        if (contactCardClickListener != null) {
            CommonInfoEntity.Contact contact = contactModel.getContact();
            String str = null;
            if (!(contact == null || (phoneNumber = contact.getPhoneNumber()) == null)) {
                str = phoneNumber.getCallingCode();
            }
            contactCardClickListener.onCallingCodeClickListener(str, LoginUtil.getCountryId());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/EditContactBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/ContactModel;", "rootView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/EditContactBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: EditContactBinder.kt */
    public final class ViewHolder extends ItemViewHolder<ContactModel> {
        final /* synthetic */ EditContactBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(EditContactBinder editContactBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(editContactBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = editContactBinder;
        }
    }
}
