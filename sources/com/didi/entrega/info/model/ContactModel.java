package com.didi.entrega.info.model;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/info/model/ContactModel;", "Lcom/didi/entrega/info/model/BaseContactModel;", "()V", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "getContact", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "setContact", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;)V", "contactType", "", "getContactType", "()I", "setContactType", "(I)V", "clone", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ContactModel.kt */
public final class ContactModel implements BaseContactModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CommonInfoEntity.Contact f20793a;

    /* renamed from: b */
    private int f20794b;

    @JvmStatic
    public static final ContactModel newInstant(CommonInfoEntity.Contact contact) {
        return Companion.newInstant(contact);
    }

    public final CommonInfoEntity.Contact getContact() {
        return this.f20793a;
    }

    public final void setContact(CommonInfoEntity.Contact contact) {
        this.f20793a = contact;
    }

    public final int getContactType() {
        return this.f20794b;
    }

    public final void setContactType(int i) {
        this.f20794b = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r3 = r3.getAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.entrega.info.model.ContactModel clone() {
        /*
            r5 = this;
            com.didi.entrega.info.model.ContactModel r0 = new com.didi.entrega.info.model.ContactModel
            r0.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = new com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact
            r1.<init>()
            r0.f20793a = r1
            r2 = 0
            if (r1 != 0) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r3 = r5.f20793a
            if (r3 != 0) goto L_0x0016
        L_0x0014:
            r3 = r2
            goto L_0x0021
        L_0x0016:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r3 = r3.getAddress()
            if (r3 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r3 = r3.clone()
        L_0x0021:
            r1.setAddress(r3)
        L_0x0024:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r0.f20793a
            if (r1 != 0) goto L_0x002a
            goto L_0x008c
        L_0x002a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r3 = new com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress
            r3.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0037
        L_0x0035:
            r4 = r2
            goto L_0x0042
        L_0x0037:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r4 = r4.getBuildingAddress()
            if (r4 != 0) goto L_0x003e
            goto L_0x0035
        L_0x003e:
            java.lang.String r4 = r4.getPlaceHolder()
        L_0x0042:
            r3.setPlaceHolder(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x004d
        L_0x004b:
            r4 = r2
            goto L_0x0058
        L_0x004d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r4 = r4.getBuildingAddress()
            if (r4 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            java.lang.String r4 = r4.getIconFont()
        L_0x0058:
            r3.setIconFont(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0063
        L_0x0061:
            r4 = r2
            goto L_0x006e
        L_0x0063:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r4 = r4.getBuildingAddress()
            if (r4 != 0) goto L_0x006a
            goto L_0x0061
        L_0x006a:
            java.lang.String r4 = r4.getBuildingAddress()
        L_0x006e:
            r3.setBuildingAddress(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0079
        L_0x0077:
            r4 = r2
            goto L_0x0084
        L_0x0079:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r4 = r4.getBuildingAddress()
            if (r4 != 0) goto L_0x0080
            goto L_0x0077
        L_0x0080:
            java.lang.Boolean r4 = r4.getRequired()
        L_0x0084:
            r3.setRequired(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r1.setBuildingAddress(r3)
        L_0x008c:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r0.f20793a
            if (r1 != 0) goto L_0x0092
            goto L_0x010a
        L_0x0092:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r3 = new com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber
            r3.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x009f
        L_0x009d:
            r4 = r2
            goto L_0x00aa
        L_0x009f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r4 = r4.getPhoneNumber()
            if (r4 != 0) goto L_0x00a6
            goto L_0x009d
        L_0x00a6:
            java.lang.String r4 = r4.getPlaceHolder()
        L_0x00aa:
            r3.setPlaceHolder(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x00b5
        L_0x00b3:
            r4 = r2
            goto L_0x00c0
        L_0x00b5:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r4 = r4.getPhoneNumber()
            if (r4 != 0) goto L_0x00bc
            goto L_0x00b3
        L_0x00bc:
            java.lang.String r4 = r4.getIconFont()
        L_0x00c0:
            r3.setIconFont(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x00cb
        L_0x00c9:
            r4 = r2
            goto L_0x00d6
        L_0x00cb:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r4 = r4.getPhoneNumber()
            if (r4 != 0) goto L_0x00d2
            goto L_0x00c9
        L_0x00d2:
            java.lang.String r4 = r4.getPhoneNumber()
        L_0x00d6:
            r3.setPhoneNumber(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x00e1
        L_0x00df:
            r4 = r2
            goto L_0x00ec
        L_0x00e1:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r4 = r4.getPhoneNumber()
            if (r4 != 0) goto L_0x00e8
            goto L_0x00df
        L_0x00e8:
            java.lang.String r4 = r4.getCallingCode()
        L_0x00ec:
            r3.setCallingCode(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x00f7
        L_0x00f5:
            r4 = r2
            goto L_0x0102
        L_0x00f7:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r4 = r4.getPhoneNumber()
            if (r4 != 0) goto L_0x00fe
            goto L_0x00f5
        L_0x00fe:
            java.lang.Boolean r4 = r4.getRequired()
        L_0x0102:
            r3.setRequired(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r1.setPhoneNumber(r3)
        L_0x010a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r0.f20793a
            if (r1 != 0) goto L_0x0110
            goto L_0x0172
        L_0x0110:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r3 = new com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName
            r3.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x011d
        L_0x011b:
            r4 = r2
            goto L_0x0128
        L_0x011d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r4 = r4.getFirstName()
            if (r4 != 0) goto L_0x0124
            goto L_0x011b
        L_0x0124:
            java.lang.String r4 = r4.getPlaceHolder()
        L_0x0128:
            r3.setPlaceHolder(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0133
        L_0x0131:
            r4 = r2
            goto L_0x013e
        L_0x0133:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r4 = r4.getFirstName()
            if (r4 != 0) goto L_0x013a
            goto L_0x0131
        L_0x013a:
            java.lang.String r4 = r4.getIconFont()
        L_0x013e:
            r3.setIconFont(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0149
        L_0x0147:
            r4 = r2
            goto L_0x0154
        L_0x0149:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r4 = r4.getFirstName()
            if (r4 != 0) goto L_0x0150
            goto L_0x0147
        L_0x0150:
            java.lang.String r4 = r4.getFirstName()
        L_0x0154:
            r3.setFirstName(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x015f
        L_0x015d:
            r4 = r2
            goto L_0x016a
        L_0x015f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r4 = r4.getFirstName()
            if (r4 != 0) goto L_0x0166
            goto L_0x015d
        L_0x0166:
            java.lang.Boolean r4 = r4.getRequired()
        L_0x016a:
            r3.setRequired(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r1.setFirstName(r3)
        L_0x0172:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r0.f20793a
            if (r1 != 0) goto L_0x0178
            goto L_0x01d9
        L_0x0178:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r3 = new com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName
            r3.<init>()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x0185
        L_0x0183:
            r4 = r2
            goto L_0x0190
        L_0x0185:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r4 = r4.getLastName()
            if (r4 != 0) goto L_0x018c
            goto L_0x0183
        L_0x018c:
            java.lang.String r4 = r4.getPlaceHolder()
        L_0x0190:
            r3.setPlaceHolder(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x019b
        L_0x0199:
            r4 = r2
            goto L_0x01a6
        L_0x019b:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r4 = r4.getLastName()
            if (r4 != 0) goto L_0x01a2
            goto L_0x0199
        L_0x01a2:
            java.lang.String r4 = r4.getIconFont()
        L_0x01a6:
            r3.setIconFont(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x01b1
        L_0x01af:
            r4 = r2
            goto L_0x01bc
        L_0x01b1:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r4 = r4.getLastName()
            if (r4 != 0) goto L_0x01b8
            goto L_0x01af
        L_0x01b8:
            java.lang.String r4 = r4.getLastName()
        L_0x01bc:
            r3.setLastName(r4)
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r4 = r5.getContact()
            if (r4 != 0) goto L_0x01c6
            goto L_0x01d1
        L_0x01c6:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r4 = r4.getLastName()
            if (r4 != 0) goto L_0x01cd
            goto L_0x01d1
        L_0x01cd:
            java.lang.Boolean r2 = r4.getRequired()
        L_0x01d1:
            r3.setRequired(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r1.setLastName(r3)
        L_0x01d9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.model.ContactModel.clone():com.didi.entrega.info.model.ContactModel");
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/info/model/ContactModel$Companion;", "", "()V", "newInstant", "Lcom/didi/entrega/info/model/ContactModel;", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ContactModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ContactModel newInstant(CommonInfoEntity.Contact contact) {
            ContactModel contactModel = new ContactModel();
            contactModel.setContact(contact);
            return contactModel;
        }
    }
}
