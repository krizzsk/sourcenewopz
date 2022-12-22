package com.didi.entrega.customer.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00172\u00020\u0001:\u000f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006 "}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateInfo", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo;", "getCateInfo", "()Ljava/util/List;", "setCateInfo", "(Ljava/util/List;)V", "receiver", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ContactEntity;", "getReceiver", "setReceiver", "sender", "getSender", "setSender", "BuildingAddress", "ButtonDTO", "CateInfo", "CateInfoEntity", "CateInfoTag", "CateInfosItem", "Companion", "Contact", "ContactEntity", "FirstName", "HistoryContact", "LastName", "PhoneNumber", "Remark", "ServiceRule", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonInfoEntity.kt */
public final class CommonInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -916471213847671051L;
    @SerializedName("cateInfo")
    private List<CateInfo> cateInfo;
    @SerializedName("receiver")
    private List<ContactEntity> receiver;
    @SerializedName("sender")
    private List<ContactEntity> sender;

    public final List<ContactEntity> getSender() {
        return this.sender;
    }

    public final void setSender(List<ContactEntity> list) {
        this.sender = list;
    }

    public final List<ContactEntity> getReceiver() {
        return this.receiver;
    }

    public final void setReceiver(List<ContactEntity> list) {
        this.receiver = list;
    }

    public final List<CateInfo> getCateInfo() {
        return this.cateInfo;
    }

    public final void setCateInfo(List<CateInfo> list) {
        this.cateInfo = list;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ContactEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "componentV2", "Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "getComponentV2", "()Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "setComponentV2", "(Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;)V", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "getContact", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "setContact", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;)V", "historyContact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "getHistoryContact", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "setHistoryContact", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class ContactEntity implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -437146169916127442L;
        @SerializedName("componentV2")
        private ComponentV2 componentV2;
        @SerializedName("contact")
        private Contact contact;
        @SerializedName("historyContact")
        private HistoryContact historyContact;
        @SerializedName("title")
        private String title;

        public final ComponentV2 getComponentV2() {
            return this.componentV2;
        }

        public final void setComponentV2(ComponentV2 componentV22) {
            this.componentV2 = componentV22;
        }

        public final Contact getContact() {
            return this.contact;
        }

        public final void setContact(Contact contact2) {
            this.contact = contact2;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final HistoryContact getHistoryContact() {
            return this.historyContact;
        }

        public final void setHistoryContact(HistoryContact historyContact2) {
            this.historyContact = historyContact2;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ContactEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "button", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ButtonDTO;", "getButton", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ButtonDTO;", "setButton", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ButtonDTO;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class HistoryContact implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 9091700206045426498L;
        @SerializedName("address")
        private AddressEntity address;
        @SerializedName("button")
        private ButtonDTO button;

        public final AddressEntity getAddress() {
            return this.address;
        }

        public final void setAddress(AddressEntity addressEntity) {
            this.address = addressEntity;
        }

        public final ButtonDTO getButton() {
            return this.button;
        }

        public final void setButton(ButtonDTO buttonDTO) {
            this.button = buttonDTO;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ButtonDTO;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "btnTxt", "", "getBtnTxt", "()Ljava/lang/String;", "setBtnTxt", "(Ljava/lang/String;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class ButtonDTO implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 5023560037643492571L;
        @SerializedName("btnTxt")
        private String btnTxt;

        public final String getBtnTxt() {
            return this.btnTxt;
        }

        public final void setBtnTxt(String str) {
            this.btnTxt = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ButtonDTO$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "buildingAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$BuildingAddress;", "getBuildingAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$BuildingAddress;", "setBuildingAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$BuildingAddress;)V", "firstName", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$FirstName;", "getFirstName", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$FirstName;", "setFirstName", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$FirstName;)V", "lastName", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$LastName;", "getLastName", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$LastName;", "setLastName", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$LastName;)V", "phoneNumber", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$PhoneNumber;", "getPhoneNumber", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$PhoneNumber;", "setPhoneNumber", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$PhoneNumber;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class Contact implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 5974740019224478846L;
        @SerializedName("address")
        private AddressEntity address;
        @SerializedName("buildingAddress")
        private BuildingAddress buildingAddress;
        @SerializedName("firstName")
        private FirstName firstName;
        @SerializedName("lastName")
        private LastName lastName;
        @SerializedName("phoneNumber")
        private PhoneNumber phoneNumber;

        public final AddressEntity getAddress() {
            return this.address;
        }

        public final void setAddress(AddressEntity addressEntity) {
            this.address = addressEntity;
        }

        public final BuildingAddress getBuildingAddress() {
            return this.buildingAddress;
        }

        public final void setBuildingAddress(BuildingAddress buildingAddress2) {
            this.buildingAddress = buildingAddress2;
        }

        public final PhoneNumber getPhoneNumber() {
            return this.phoneNumber;
        }

        public final void setPhoneNumber(PhoneNumber phoneNumber2) {
            this.phoneNumber = phoneNumber2;
        }

        public final FirstName getFirstName() {
            return this.firstName;
        }

        public final void setFirstName(FirstName firstName2) {
            this.firstName = firstName2;
        }

        public final LastName getLastName() {
            return this.lastName;
        }

        public final void setLastName(LastName lastName2) {
            this.lastName = lastName2;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Contact$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$BuildingAddress;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "buildingAddress", "", "getBuildingAddress", "()Ljava/lang/String;", "setBuildingAddress", "(Ljava/lang/String;)V", "iconFont", "getIconFont", "setIconFont", "placeHolder", "getPlaceHolder", "setPlaceHolder", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class BuildingAddress implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -3714160099608659766L;
        private String buildingAddress;
        @SerializedName("iconFont")
        private String iconFont;
        @SerializedName("placeHolder")
        private String placeHolder;
        @SerializedName("required")
        private Boolean required;

        public final String getIconFont() {
            return this.iconFont;
        }

        public final void setIconFont(String str) {
            this.iconFont = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        public final void setPlaceHolder(String str) {
            this.placeHolder = str;
        }

        public final String getBuildingAddress() {
            return this.buildingAddress;
        }

        public final void setBuildingAddress(String str) {
            this.buildingAddress = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$BuildingAddress$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$PhoneNumber;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "callingCode", "", "getCallingCode", "()Ljava/lang/String;", "setCallingCode", "(Ljava/lang/String;)V", "countryId", "", "getCountryId", "()I", "setCountryId", "(I)V", "iconFont", "getIconFont", "setIconFont", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "placeHolder", "getPlaceHolder", "setPlaceHolder", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class PhoneNumber implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 2017989665290217940L;
        @SerializedName("callingCode")
        private String callingCode;
        @SerializedName("countryId")
        private int countryId;
        @SerializedName("iconFont")
        private String iconFont;
        private String phoneNumber;
        @SerializedName("placeHolder")
        private String placeHolder;
        @SerializedName("required")
        private Boolean required;

        public final String getIconFont() {
            return this.iconFont;
        }

        public final void setIconFont(String str) {
            this.iconFont = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getCallingCode() {
            return this.callingCode;
        }

        public final void setCallingCode(String str) {
            this.callingCode = str;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        public final void setCountryId(int i) {
            this.countryId = i;
        }

        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        public final void setPlaceHolder(String str) {
            this.placeHolder = str;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$PhoneNumber$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$FirstName;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "firstName", "", "getFirstName", "()Ljava/lang/String;", "setFirstName", "(Ljava/lang/String;)V", "iconFont", "getIconFont", "setIconFont", "placeHolder", "getPlaceHolder", "setPlaceHolder", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class FirstName implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 8492445091330945551L;
        private String firstName;
        @SerializedName("iconFont")
        private String iconFont;
        @SerializedName("placeHolder")
        private String placeHolder;
        @SerializedName("required")
        private Boolean required;

        public final String getIconFont() {
            return this.iconFont;
        }

        public final void setIconFont(String str) {
            this.iconFont = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        public final void setPlaceHolder(String str) {
            this.placeHolder = str;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final void setFirstName(String str) {
            this.firstName = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$FirstName$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$LastName;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "iconFont", "", "getIconFont", "()Ljava/lang/String;", "setIconFont", "(Ljava/lang/String;)V", "lastName", "getLastName", "setLastName", "placeHolder", "getPlaceHolder", "setPlaceHolder", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class LastName implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -5123516287889277924L;
        @SerializedName("iconFont")
        private String iconFont;
        private String lastName;
        @SerializedName("placeHolder")
        private String placeHolder;
        @SerializedName("required")
        private Boolean required;

        public final String getIconFont() {
            return this.iconFont;
        }

        public final void setIconFont(String str) {
            this.iconFont = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        public final void setPlaceHolder(String str) {
            this.placeHolder = str;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final void setLastName(String str) {
            this.lastName = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$LastName$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateInfoTag", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoTag;", "getCateInfoTag", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoTag;", "setCateInfoTag", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoTag;)V", "componentV2", "Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "getComponentV2", "()Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "setComponentV2", "(Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;)V", "remark", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Remark;", "getRemark", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Remark;", "setRemark", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Remark;)V", "serviceRule", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "getServiceRule", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "setServiceRule", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class CateInfo implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -1204195532246244829L;
        @SerializedName("cateInfoTag")
        private CateInfoTag cateInfoTag;
        @SerializedName("componentV2")
        private ComponentV2 componentV2;
        @SerializedName("remark")
        private Remark remark;
        @SerializedName("serviceRule")
        private ServiceRule serviceRule;

        public final ComponentV2 getComponentV2() {
            return this.componentV2;
        }

        public final void setComponentV2(ComponentV2 componentV22) {
            this.componentV2 = componentV22;
        }

        public final CateInfoTag getCateInfoTag() {
            return this.cateInfoTag;
        }

        public final void setCateInfoTag(CateInfoTag cateInfoTag2) {
            this.cateInfoTag = cateInfoTag2;
        }

        public final Remark getRemark() {
            return this.remark;
        }

        public final void setRemark(Remark remark2) {
            this.remark = remark2;
        }

        public final ServiceRule getServiceRule() {
            return this.serviceRule;
        }

        public final void setServiceRule(ServiceRule serviceRule2) {
            this.serviceRule = serviceRule2;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateInfo", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo;", "getCateInfo", "()Ljava/util/List;", "setCateInfo", "(Ljava/util/List;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class CateInfoEntity implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -4465273832189941718L;
        @SerializedName("cateInfo")
        private List<CateInfo> cateInfo;

        public final List<CateInfo> getCateInfo() {
            return this.cateInfo;
        }

        public final void setCateInfo(List<CateInfo> list) {
            this.cateInfo = list;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoTag;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateInfoItems", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem;", "getCateInfoItems", "()Ljava/util/List;", "setCateInfoItems", "(Ljava/util/List;)V", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class CateInfoTag implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 2076900293889766993L;
        @SerializedName("cateInfos")
        private List<CateInfosItem> cateInfoItems;
        @SerializedName("required")
        private Boolean required;
        @SerializedName("title")
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final List<CateInfosItem> getCateInfoItems() {
            return this.cateInfoItems;
        }

        public final void setCateInfoItems(List<CateInfosItem> list) {
            this.cateInfoItems = list;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfoTag$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateID", "", "getCateID", "()Ljava/lang/String;", "setCateID", "(Ljava/lang/String;)V", "cateImg", "getCateImg", "setCateImg", "cateName", "getCateName", "setCateName", "selected", "", "getSelected", "()Ljava/lang/Boolean;", "setSelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class CateInfosItem implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -8555807416532195818L;
        @SerializedName("cateId")
        private String cateID;
        @SerializedName("cateImg")
        private String cateImg;
        @SerializedName("cateName")
        private String cateName;
        @SerializedName("selected")
        private Boolean selected;

        public final String getCateID() {
            return this.cateID;
        }

        public final void setCateID(String str) {
            this.cateID = str;
        }

        public final String getCateImg() {
            return this.cateImg;
        }

        public final void setCateImg(String str) {
            this.cateImg = str;
        }

        public final Boolean getSelected() {
            return this.selected;
        }

        public final void setSelected(Boolean bool) {
            this.selected = bool;
        }

        public final String getCateName() {
            return this.cateName;
        }

        public final void setCateName(String str) {
            this.cateName = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Remark;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "placeHolder", "getPlaceHolder", "setPlaceHolder", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "getTitle", "setTitle", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class Remark implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 2052899142782965314L;
        @SerializedName("content")
        private String content;
        @SerializedName("placeHolder")
        private String placeHolder;
        @SerializedName("required")
        private Boolean required;
        @SerializedName("title")
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        public final void setPlaceHolder(String str) {
            this.placeHolder = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Remark$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "linkContent", "getLinkContent", "setLinkContent", "required", "", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "textUrl", "getTextUrl", "setTextUrl", "title", "getTitle", "setTitle", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class ServiceRule implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -2070628544852668031L;
        @SerializedName("content")
        private String content;
        @SerializedName("imageUrl")
        private String imageUrl;
        @SerializedName("linkContent")
        private String linkContent;
        @SerializedName("required")
        private Boolean required;
        @SerializedName("linkUrl")
        private String textUrl;
        @SerializedName("title")
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Boolean getRequired() {
            return this.required;
        }

        public final void setRequired(Boolean bool) {
            this.required = bool;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getLinkContent() {
            return this.linkContent;
        }

        public final void setLinkContent(String str) {
            this.linkContent = str;
        }

        public final String getTextUrl() {
            return this.textUrl;
        }

        public final void setTextUrl(String str) {
            this.textUrl = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CommonInfoEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CommonInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
