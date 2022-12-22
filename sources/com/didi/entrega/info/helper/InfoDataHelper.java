package com.didi.entrega.info.helper;

import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.ComponentV2;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactListEntity;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.model.MiddleTitleModel;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.entrega.info.model.StuffRuleModel;
import com.didi.entrega.info.model.StuffTypeItemModel;
import com.didi.entrega.info.model.StuffTypeModel;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u000fJX\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001a2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001aJ8\u0010 \u001a\u0004\u0018\u00010\u00182\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00180\"j\b\u0012\u0004\u0012\u00020\u0018`#2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00180\"j\b\u0012\u0004\u0012\u00020\u0018`#J\u0018\u0010%\u001a\u0004\u0018\u00010\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00180\"j\b\u0012\u0004\u0012\u00020\u0018`#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u0016\u0010*\u001a\u00020\u001e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\f0\"j\b\u0012\u0004\u0012\u00020\f`#2\u0006\u0010\u0010\u001a\u00020,J\u0006\u0010-\u001a\u00020\nJ\u0018\u0010.\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004J&\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00180\"j\b\u0012\u0004\u0012\u00020\u0018`#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004J \u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00180\"j\b\u0012\u0004\u0012\u00020\u0018`#2\b\u00102\u001a\u0004\u0018\u000103J\u0018\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004J\u0010\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\b\u001a\u00020\u0007J\u0012\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010:\u001a\u0004\u0018\u00010;2\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010<\u001a\u0004\u0018\u00010,2\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010<\u001a\u0004\u0018\u00010,2\b\u00108\u001a\u0004\u0018\u000109R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006="}, mo175978d2 = {"Lcom/didi/entrega/info/helper/InfoDataHelper;", "", "()V", "SCROLL_HIDE_DISTANCE", "", "SERVICE_RULE_LOOK_NUM", "addUpdateData", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "commonInfoEntity", "areSameTypeItem", "", "oldItem", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "newItem", "convertContactModel2AddressEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "model", "Lcom/didi/entrega/info/model/ContactModel;", "copyAddressEntity", "contractModel", "address", "deleteContact", "", "contactModel", "Lcom/didi/entrega/info/model/HistoryModel;", "success", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "fail", "", "msg", "diffHistoryContact", "source", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "target", "getContactModel", "targetList", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ContactEntity;", "getHistoryContactModel", "getHistoryTitleModel", "getStuffTypeItemDataList", "Lcom/didi/entrega/info/model/StuffTypeModel;", "hasFillSth", "parseContactModel", "currentStep", "parseHistoryModel", "parseHistoryModelByUpdate", "contactListEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactListEntity;", "parseHistoryTitle", "Lcom/didi/entrega/info/model/MiddleTitleModel;", "parseStuffRemarkModel", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "cateInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo;", "parseStuffRuleModel", "Lcom/didi/entrega/info/model/StuffRuleModel;", "parseStuffTypeModel", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoDataHelper.kt */
public final class InfoDataHelper {
    public static final InfoDataHelper INSTANCE = new InfoDataHelper();
    public static final int SCROLL_HIDE_DISTANCE = 10;
    public static final int SERVICE_RULE_LOOK_NUM = 1;

    private InfoDataHelper() {
    }

    public final CommonInfoEntity addUpdateData(CommonInfoEntity commonInfoEntity) {
        Integer tmplType;
        Integer tmplType2;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
        List<CommonInfoEntity.ContactEntity> sender = commonInfoEntity.getSender();
        if (sender == null) {
            sender = new ArrayList<>();
        }
        Iterator<CommonInfoEntity.ContactEntity> it = sender.iterator();
        while (true) {
            boolean z = true;
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            CommonInfoEntity.ContactEntity next = it.next();
            ComponentV2 componentV2 = next.getComponentV2();
            if (componentV2 == null || (tmplType2 = componentV2.getTmplType()) == null || tmplType2.intValue() != 100) {
                z = false;
            }
            if (z) {
                CommonInfoEntity.Contact contact = next.getContact();
                if (contact != null) {
                    contact.setAddress(iCustomerContactManager.getSendContact());
                }
                CommonInfoEntity.Contact contact2 = next.getContact();
                CommonInfoEntity.BuildingAddress buildingAddress = contact2 == null ? null : contact2.getBuildingAddress();
                if (buildingAddress != null) {
                    AddressEntity sendContact = iCustomerContactManager.getSendContact();
                    buildingAddress.setBuildingAddress(sendContact == null ? null : sendContact.houseNumber);
                }
                CommonInfoEntity.Contact contact3 = next.getContact();
                CommonInfoEntity.PhoneNumber phoneNumber = contact3 == null ? null : contact3.getPhoneNumber();
                if (phoneNumber != null) {
                    AddressEntity sendContact2 = iCustomerContactManager.getSendContact();
                    phoneNumber.setPhoneNumber(sendContact2 == null ? null : sendContact2.phone);
                }
                CommonInfoEntity.Contact contact4 = next.getContact();
                CommonInfoEntity.PhoneNumber phoneNumber2 = contact4 == null ? null : contact4.getPhoneNumber();
                if (phoneNumber2 != null) {
                    AddressEntity sendContact3 = iCustomerContactManager.getSendContact();
                    phoneNumber2.setCallingCode(sendContact3 == null ? null : sendContact3.callingCode);
                }
                CommonInfoEntity.Contact contact5 = next.getContact();
                CommonInfoEntity.FirstName firstName = contact5 == null ? null : contact5.getFirstName();
                if (firstName != null) {
                    AddressEntity sendContact4 = iCustomerContactManager.getSendContact();
                    firstName.setFirstName(sendContact4 == null ? null : sendContact4.firstName);
                }
                CommonInfoEntity.Contact contact6 = next.getContact();
                CommonInfoEntity.LastName lastName = contact6 == null ? null : contact6.getLastName();
                if (lastName != null) {
                    AddressEntity sendContact5 = iCustomerContactManager.getSendContact();
                    if (sendContact5 != null) {
                        str = sendContact5.lastName;
                    }
                    lastName.setLastName(str);
                }
            }
        }
        List<CommonInfoEntity.ContactEntity> receiver = commonInfoEntity.getReceiver();
        if (receiver == null) {
            receiver = new ArrayList<>();
        }
        for (CommonInfoEntity.ContactEntity next2 : receiver) {
            ComponentV2 componentV22 = next2.getComponentV2();
            if ((componentV22 == null || (tmplType = componentV22.getTmplType()) == null || tmplType.intValue() != 100) ? false : true) {
                CommonInfoEntity.Contact contact7 = next2.getContact();
                if (contact7 != null) {
                    contact7.setAddress(iCustomerContactManager.getSendContact());
                }
                CommonInfoEntity.Contact contact8 = next2.getContact();
                CommonInfoEntity.BuildingAddress buildingAddress2 = contact8 == null ? null : contact8.getBuildingAddress();
                if (buildingAddress2 != null) {
                    AddressEntity receiveContact = iCustomerContactManager.getReceiveContact();
                    buildingAddress2.setBuildingAddress(receiveContact == null ? null : receiveContact.houseNumber);
                }
                CommonInfoEntity.Contact contact9 = next2.getContact();
                CommonInfoEntity.PhoneNumber phoneNumber3 = contact9 == null ? null : contact9.getPhoneNumber();
                if (phoneNumber3 != null) {
                    AddressEntity receiveContact2 = iCustomerContactManager.getReceiveContact();
                    phoneNumber3.setPhoneNumber(receiveContact2 == null ? null : receiveContact2.phone);
                }
                CommonInfoEntity.Contact contact10 = next2.getContact();
                CommonInfoEntity.PhoneNumber phoneNumber4 = contact10 == null ? null : contact10.getPhoneNumber();
                if (phoneNumber4 != null) {
                    AddressEntity receiveContact3 = iCustomerContactManager.getReceiveContact();
                    phoneNumber4.setCallingCode(receiveContact3 == null ? null : receiveContact3.callingCode);
                }
                CommonInfoEntity.Contact contact11 = next2.getContact();
                CommonInfoEntity.FirstName firstName2 = contact11 == null ? null : contact11.getFirstName();
                if (firstName2 != null) {
                    AddressEntity receiveContact4 = iCustomerContactManager.getReceiveContact();
                    firstName2.setFirstName(receiveContact4 == null ? null : receiveContact4.firstName);
                }
                CommonInfoEntity.Contact contact12 = next2.getContact();
                CommonInfoEntity.LastName lastName2 = contact12 == null ? null : contact12.getLastName();
                if (lastName2 != null) {
                    AddressEntity receiveContact5 = iCustomerContactManager.getReceiveContact();
                    lastName2.setLastName(receiveContact5 == null ? null : receiveContact5.lastName);
                }
            }
        }
        return commonInfoEntity;
    }

    public final ContactModel parseContactModel(CommonInfoEntity commonInfoEntity, int i) {
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        Collection sender = commonInfoEntity.getSender();
        if (sender == null || sender.isEmpty()) {
            return null;
        }
        if (i == 1) {
            List<CommonInfoEntity.ContactEntity> sender2 = commonInfoEntity.getSender();
            if (sender2 == null) {
                sender2 = new ArrayList<>();
            }
            return m15216a(sender2);
        } else if (i != 2) {
            return null;
        } else {
            List<CommonInfoEntity.ContactEntity> receiver = commonInfoEntity.getReceiver();
            if (receiver == null) {
                receiver = new ArrayList<>();
            }
            return m15216a(receiver);
        }
    }

    /* renamed from: a */
    private final ContactModel m15216a(List<CommonInfoEntity.ContactEntity> list) {
        Integer tmplType;
        ContactModel contactModel = null;
        for (CommonInfoEntity.ContactEntity next : list) {
            ComponentV2 componentV2 = next.getComponentV2();
            boolean z = false;
            if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 100)) {
                z = true;
            }
            if (z) {
                contactModel = ContactModel.Companion.newInstant(next.getContact());
            }
        }
        return contactModel;
    }

    public final ArrayList<HistoryModel> parseHistoryModel(CommonInfoEntity commonInfoEntity, int i) {
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        ArrayList<HistoryModel> arrayList = new ArrayList<>();
        if (i == 1) {
            List<CommonInfoEntity.ContactEntity> sender = commonInfoEntity.getSender();
            if (sender == null) {
                sender = new ArrayList<>();
            }
            return m15217b(sender);
        } else if (i != 2) {
            return arrayList;
        } else {
            List<CommonInfoEntity.ContactEntity> receiver = commonInfoEntity.getReceiver();
            if (receiver == null) {
                receiver = new ArrayList<>();
            }
            return m15217b(receiver);
        }
    }

    public final ArrayList<HistoryModel> parseHistoryModelByUpdate(ContactListEntity contactListEntity) {
        ArrayList<HistoryModel> arrayList = new ArrayList<>();
        if (contactListEntity == null) {
            return arrayList;
        }
        List<AddressEntity> addressList = contactListEntity.getAddressList();
        if (addressList == null) {
            addressList = new ArrayList<>();
        }
        for (AddressEntity next : addressList) {
            if (next != null) {
                CommonInfoEntity.HistoryContact historyContact = new CommonInfoEntity.HistoryContact();
                historyContact.setAddress(next);
                historyContact.setButton(new CommonInfoEntity.ButtonDTO());
                CommonInfoEntity.ButtonDTO button = historyContact.getButton();
                if (button != null) {
                    button.setBtnTxt(ResourceHelper.getString(R.string.rf_icon_outlined_delete));
                }
                HistoryModel historyModel = new HistoryModel();
                historyModel.setHistoryEntity(historyContact);
                arrayList.add(historyModel);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private final ArrayList<HistoryModel> m15217b(List<CommonInfoEntity.ContactEntity> list) {
        Integer tmplType;
        ArrayList<HistoryModel> arrayList = new ArrayList<>();
        for (CommonInfoEntity.ContactEntity next : list) {
            ComponentV2 componentV2 = next.getComponentV2();
            boolean z = false;
            if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 300)) {
                z = true;
            }
            if (z) {
                arrayList.add(HistoryModel.Companion.newInstance(next.getHistoryContact()));
            }
        }
        return arrayList;
    }

    public final MiddleTitleModel parseHistoryTitle(CommonInfoEntity commonInfoEntity, int i) {
        String str;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        if (i == 1) {
            List<CommonInfoEntity.ContactEntity> sender = commonInfoEntity.getSender();
            if (sender == null) {
                sender = new ArrayList<>();
            }
            str = m15218c(sender);
        } else if (i != 2) {
            str = "";
        } else {
            List<CommonInfoEntity.ContactEntity> receiver = commonInfoEntity.getReceiver();
            if (receiver == null) {
                receiver = new ArrayList<>();
            }
            str = m15218c(receiver);
        }
        return MiddleTitleModel.Companion.newInstance(str);
    }

    /* renamed from: c */
    private final String m15218c(List<CommonInfoEntity.ContactEntity> list) {
        Integer tmplType;
        Iterator<CommonInfoEntity.ContactEntity> it = list.iterator();
        while (true) {
            String str = "";
            while (true) {
                if (!it.hasNext()) {
                    return str;
                }
                CommonInfoEntity.ContactEntity next = it.next();
                ComponentV2 componentV2 = next.getComponentV2();
                boolean z = false;
                if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 200)) {
                    z = true;
                }
                if (!z || (str = next.getTitle()) != null) {
                }
            }
        }
    }

    public final StuffTypeModel parseStuffTypeModel(CommonInfoEntity commonInfoEntity) {
        Integer tmplType;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        List<CommonInfoEntity.CateInfo> cateInfo = commonInfoEntity.getCateInfo();
        if (cateInfo == null) {
            cateInfo = new ArrayList<>();
        }
        StuffTypeModel stuffTypeModel = null;
        for (CommonInfoEntity.CateInfo next : cateInfo) {
            ComponentV2 componentV2 = next.getComponentV2();
            boolean z = false;
            if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 400)) {
                z = true;
            }
            if (z) {
                stuffTypeModel = StuffTypeModel.Companion.newInstant(next.getCateInfoTag());
            }
        }
        return stuffTypeModel;
    }

    public final StuffTypeModel parseStuffTypeModel(CommonInfoEntity.CateInfo cateInfo) {
        return StuffTypeModel.Companion.newInstant(cateInfo == null ? null : cateInfo.getCateInfoTag());
    }

    public final StuffRemarkModel parseStuffRemarkModel(CommonInfoEntity commonInfoEntity) {
        Integer tmplType;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        List<CommonInfoEntity.CateInfo> cateInfo = commonInfoEntity.getCateInfo();
        if (cateInfo == null) {
            cateInfo = new ArrayList<>();
        }
        StuffRemarkModel stuffRemarkModel = null;
        for (CommonInfoEntity.CateInfo next : cateInfo) {
            ComponentV2 componentV2 = next.getComponentV2();
            boolean z = false;
            if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 500)) {
                z = true;
            }
            if (z) {
                stuffRemarkModel = StuffRemarkModel.Companion.newInstant(next.getRemark());
            }
        }
        return stuffRemarkModel;
    }

    public final StuffRemarkModel parseStuffRemarkModel(CommonInfoEntity.CateInfo cateInfo) {
        return StuffRemarkModel.Companion.newInstant(cateInfo == null ? null : cateInfo.getRemark());
    }

    public final StuffRuleModel parseStuffRuleModel(CommonInfoEntity commonInfoEntity) {
        Integer tmplType;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "commonInfoEntity");
        List<CommonInfoEntity.CateInfo> cateInfo = commonInfoEntity.getCateInfo();
        if (cateInfo == null) {
            cateInfo = new ArrayList<>();
        }
        StuffRuleModel stuffRuleModel = null;
        for (CommonInfoEntity.CateInfo next : cateInfo) {
            ComponentV2 componentV2 = next.getComponentV2();
            boolean z = false;
            if (!(componentV2 == null || (tmplType = componentV2.getTmplType()) == null || tmplType.intValue() != 600)) {
                z = true;
            }
            if (z) {
                stuffRuleModel = StuffRuleModel.Companion.newInstant(next.getServiceRule());
            }
        }
        return stuffRuleModel;
    }

    public final StuffRuleModel parseStuffRuleModel(CommonInfoEntity.CateInfo cateInfo) {
        return StuffRuleModel.Companion.newInstant(cateInfo == null ? null : cateInfo.getServiceRule());
    }

    public final ArrayList<StuffTypeItemModel> getStuffTypeItemDataList(StuffTypeModel stuffTypeModel) {
        Intrinsics.checkNotNullParameter(stuffTypeModel, "model");
        ArrayList<StuffTypeItemModel> arrayList = new ArrayList<>();
        CommonInfoEntity.CateInfoTag stuffEntityData = stuffTypeModel.getStuffEntityData();
        List<CommonInfoEntity.CateInfosItem> cateInfoItems = stuffEntityData == null ? null : stuffEntityData.getCateInfoItems();
        if (cateInfoItems == null) {
            cateInfoItems = new ArrayList<>();
        }
        for (CommonInfoEntity.CateInfosItem stuffEntityData2 : cateInfoItems) {
            StuffTypeItemModel stuffTypeItemModel = new StuffTypeItemModel();
            stuffTypeItemModel.setStuffEntityData(stuffEntityData2);
            arrayList.add(stuffTypeItemModel);
        }
        return arrayList;
    }

    public final void deleteContact(HistoryModel historyModel, Function1<? super HistoryModel, Unit> function1, Function1<? super String, Unit> function12) {
        AddressEntity address;
        Intrinsics.checkNotNullParameter(historyModel, "contactModel");
        Intrinsics.checkNotNullParameter(function1, "success");
        Intrinsics.checkNotNullParameter(function12, "fail");
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        CommonInfoEntity.HistoryContact historyEntity = historyModel.getHistoryEntity();
        String str = null;
        if (!(historyEntity == null || (address = historyEntity.getAddress()) == null)) {
            str = address.aid;
        }
        customerRpcService.deleteContact(str, new InfoDataHelper$deleteContact$1(function1, historyModel, function12));
    }

    public final HistoryModel diffHistoryContact(ArrayList<HistoryModel> arrayList, ArrayList<HistoryModel> arrayList2) {
        Intrinsics.checkNotNullParameter(arrayList, "source");
        Intrinsics.checkNotNullParameter(arrayList2, "target");
        Iterator<HistoryModel> it = arrayList.iterator();
        while (it.hasNext()) {
            HistoryModel next = it.next();
            if (!arrayList2.contains(next)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r1 = r1.getAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.entrega.info.model.ContactModel copyAddressEntity(com.didi.entrega.info.model.ContactModel r3, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r4) {
        /*
            r2 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            if (r3 != 0) goto L_0x000a
            r3 = r0
            goto L_0x005f
        L_0x000a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r3.getContact()
            if (r1 != 0) goto L_0x0012
        L_0x0010:
            r1 = r0
            goto L_0x001b
        L_0x0012:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x0019
            goto L_0x0010
        L_0x0019:
            java.lang.String r1 = r1.callingCode
        L_0x001b:
            r4.callingCode = r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r3.getContact()
            if (r1 != 0) goto L_0x0025
        L_0x0023:
            r1 = r0
            goto L_0x002e
        L_0x0025:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            java.lang.String r1 = r1.phone
        L_0x002e:
            r4.phone = r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r3.getContact()
            if (r1 != 0) goto L_0x0038
        L_0x0036:
            r1 = r0
            goto L_0x0041
        L_0x0038:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x003f
            goto L_0x0036
        L_0x003f:
            java.lang.String r1 = r1.firstName
        L_0x0041:
            r4.firstName = r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r3.getContact()
            if (r1 != 0) goto L_0x004a
            goto L_0x0053
        L_0x004a:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            java.lang.String r0 = r1.lastName
        L_0x0053:
            r4.lastName = r0
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r0 = r3.getContact()
            if (r0 != 0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            r0.setAddress(r4)
        L_0x005f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.helper.InfoDataHelper.copyAddressEntity(com.didi.entrega.info.model.ContactModel, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity):com.didi.entrega.info.model.ContactModel");
    }

    public final AddressEntity convertContactModel2AddressEntity(ContactModel contactModel) {
        AddressEntity.PoiEntity poiEntity;
        String str;
        String str2;
        String str3;
        String str4;
        CommonInfoEntity.Contact contact;
        CommonInfoEntity.LastName lastName;
        CommonInfoEntity.Contact contact2;
        CommonInfoEntity.FirstName firstName;
        CommonInfoEntity.Contact contact3;
        CommonInfoEntity.PhoneNumber phoneNumber;
        CommonInfoEntity.Contact contact4;
        CommonInfoEntity.PhoneNumber phoneNumber2;
        CommonInfoEntity.Contact contact5;
        CommonInfoEntity.BuildingAddress buildingAddress;
        CommonInfoEntity.Contact contact6;
        AddressEntity address;
        AddressEntity.PoiEntity poiEntity2;
        AddressEntity addressEntity = new AddressEntity();
        String str5 = null;
        if (contactModel == null || (contact6 = contactModel.getContact()) == null || (address = contact6.getAddress()) == null || (poiEntity2 = address.poi) == null) {
            poiEntity = null;
        } else {
            poiEntity = poiEntity2.clone();
        }
        addressEntity.poi = poiEntity;
        if (contactModel == null || (contact5 = contactModel.getContact()) == null || (buildingAddress = contact5.getBuildingAddress()) == null) {
            str = null;
        } else {
            str = buildingAddress.getBuildingAddress();
        }
        addressEntity.houseNumber = str;
        if (contactModel == null || (contact4 = contactModel.getContact()) == null || (phoneNumber2 = contact4.getPhoneNumber()) == null) {
            str2 = null;
        } else {
            str2 = phoneNumber2.getPhoneNumber();
        }
        addressEntity.phone = str2;
        if (contactModel == null || (contact3 = contactModel.getContact()) == null || (phoneNumber = contact3.getPhoneNumber()) == null) {
            str3 = null;
        } else {
            str3 = phoneNumber.getCallingCode();
        }
        addressEntity.callingCode = str3;
        if (contactModel == null || (contact2 = contactModel.getContact()) == null || (firstName = contact2.getFirstName()) == null) {
            str4 = null;
        } else {
            str4 = firstName.getFirstName();
        }
        addressEntity.firstName = str4;
        if (!(contactModel == null || (contact = contactModel.getContact()) == null || (lastName = contact.getLastName()) == null)) {
            str5 = lastName.getLastName();
        }
        addressEntity.lastName = str5;
        return addressEntity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r4.getStuffEntityData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areSameTypeItem(com.didi.entrega.info.model.StuffTypeItemModel r4, com.didi.entrega.info.model.StuffTypeItemModel r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0010
        L_0x0005:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r1 = r4.getStuffEntityData()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            java.lang.Boolean r1 = r1.getSelected()
        L_0x0010:
            if (r5 != 0) goto L_0x0014
        L_0x0012:
            r2 = r0
            goto L_0x001f
        L_0x0014:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r2 = r5.getStuffEntityData()
            if (r2 != 0) goto L_0x001b
            goto L_0x0012
        L_0x001b:
            java.lang.Boolean r2 = r2.getSelected()
        L_0x001f:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0092
            if (r4 != 0) goto L_0x0029
        L_0x0027:
            r1 = r0
            goto L_0x0034
        L_0x0029:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r1 = r4.getStuffEntityData()
            if (r1 != 0) goto L_0x0030
            goto L_0x0027
        L_0x0030:
            java.lang.String r1 = r1.getCateID()
        L_0x0034:
            if (r5 != 0) goto L_0x0038
        L_0x0036:
            r2 = r0
            goto L_0x0043
        L_0x0038:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r2 = r5.getStuffEntityData()
            if (r2 != 0) goto L_0x003f
            goto L_0x0036
        L_0x003f:
            java.lang.String r2 = r2.getCateID()
        L_0x0043:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0092
            if (r4 != 0) goto L_0x004d
        L_0x004b:
            r1 = r0
            goto L_0x0058
        L_0x004d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r1 = r4.getStuffEntityData()
            if (r1 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            java.lang.String r1 = r1.getCateImg()
        L_0x0058:
            if (r5 != 0) goto L_0x005c
        L_0x005a:
            r2 = r0
            goto L_0x0067
        L_0x005c:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r2 = r5.getStuffEntityData()
            if (r2 != 0) goto L_0x0063
            goto L_0x005a
        L_0x0063:
            java.lang.String r2 = r2.getCateImg()
        L_0x0067:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0092
            if (r4 != 0) goto L_0x0071
        L_0x006f:
            r4 = r0
            goto L_0x007c
        L_0x0071:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r4 = r4.getStuffEntityData()
            if (r4 != 0) goto L_0x0078
            goto L_0x006f
        L_0x0078:
            java.lang.String r4 = r4.getCateName()
        L_0x007c:
            if (r5 != 0) goto L_0x007f
            goto L_0x008a
        L_0x007f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r5 = r5.getStuffEntityData()
            if (r5 != 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            java.lang.String r0 = r5.getCateName()
        L_0x008a:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0092
            r4 = 1
            goto L_0x0093
        L_0x0092:
            r4 = 0
        L_0x0093:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.helper.InfoDataHelper.areSameTypeItem(com.didi.entrega.info.model.StuffTypeItemModel, com.didi.entrega.info.model.StuffTypeItemModel):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        r2 = r2.getBuildingAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasFillSth() {
        /*
            r5 = this;
            java.lang.Class<com.didi.entrega.info.repo.InfoComponentRepo> r0 = com.didi.entrega.info.repo.InfoComponentRepo.class
            com.didi.app.nova.skeleton.repo.Repo r0 = com.didi.entrega.customer.repo.RepoFactory.getRepo(r0)
            com.didi.entrega.info.repo.InfoComponentRepo r0 = (com.didi.entrega.info.repo.InfoComponentRepo) r0
            com.didi.entrega.info.model.ContactModel r0 = r0.getSender()
            r1 = 0
            if (r0 != 0) goto L_0x0011
            goto L_0x009f
        L_0x0011:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r2 = r0.getContact()
            r3 = 0
            if (r2 != 0) goto L_0x001a
        L_0x0018:
            r2 = r3
            goto L_0x0025
        L_0x001a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r2 = r2.getBuildingAddress()
            if (r2 != 0) goto L_0x0021
            goto L_0x0018
        L_0x0021:
            java.lang.String r2 = r2.getBuildingAddress()
        L_0x0025:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 1
            if (r2 == 0) goto L_0x0033
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = 0
            goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            if (r2 == 0) goto L_0x009e
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r2 = r0.getContact()
            if (r2 != 0) goto L_0x003e
        L_0x003c:
            r2 = r3
            goto L_0x0049
        L_0x003e:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r2 = r2.getPhoneNumber()
            if (r2 != 0) goto L_0x0045
            goto L_0x003c
        L_0x0045:
            java.lang.String r2 = r2.getPhoneNumber()
        L_0x0049:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0056
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r2 = 0
            goto L_0x0057
        L_0x0056:
            r2 = 1
        L_0x0057:
            if (r2 == 0) goto L_0x009e
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r2 = r0.getContact()
            if (r2 != 0) goto L_0x0061
        L_0x005f:
            r2 = r3
            goto L_0x006c
        L_0x0061:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r2 = r2.getFirstName()
            if (r2 != 0) goto L_0x0068
            goto L_0x005f
        L_0x0068:
            java.lang.String r2 = r2.getFirstName()
        L_0x006c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0079
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r2 = 0
            goto L_0x007a
        L_0x0079:
            r2 = 1
        L_0x007a:
            if (r2 == 0) goto L_0x009e
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r0 = r0.getContact()
            if (r0 != 0) goto L_0x0083
            goto L_0x008e
        L_0x0083:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r0 = r0.getLastName()
            if (r0 != 0) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            java.lang.String r3 = r0.getLastName()
        L_0x008e:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x009b
            int r0 = r3.length()
            if (r0 != 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r0 = 0
            goto L_0x009c
        L_0x009b:
            r0 = 1
        L_0x009c:
            if (r0 != 0) goto L_0x009f
        L_0x009e:
            r1 = 1
        L_0x009f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.helper.InfoDataHelper.hasFillSth():boolean");
    }
}
