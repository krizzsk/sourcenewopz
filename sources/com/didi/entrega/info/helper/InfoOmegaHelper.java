package com.didi.entrega.info.helper;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.component.StuffConstract;
import com.didi.entrega.info.component.receive.ReceiveContactUpdatePresenter;
import com.didi.entrega.info.component.send.SendContactUpdatePresenter;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.model.OmegaCommonModel;
import com.didi.entrega.info.repo.InfoComponentRepo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002JH\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020 J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020 J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020 ¨\u0006#"}, mo175978d2 = {"Lcom/didi/entrega/info/helper/InfoOmegaHelper;", "", "()V", "buildModel", "Lcom/didi/entrega/info/model/OmegaCommonModel;", "presenter", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "classCallBack", "", "sendCreateBlock", "Lkotlin/Function0;", "sendUpdateBlock", "receiveCreateBlock", "receiveUpdateBlock", "trackConfirmCk", "trackContactCommonCK", "trackContactCommonShow", "trackHistoryCk", "index", "", "trackHistorySw", "trackReceiverPhoneClearCK", "pageSource", "eventSource", "trackReceiverPhoneInputCK", "trackReceiverToAddressListCK", "trackSenderNameCK", "clickType", "trackSenderPhoneClearCK", "trackSenderPhoneInputCK", "trackSenderToAddressListCK", "trackStufSw", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;", "trackStuffConfirmCk", "trackStuffReturnCk", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoOmegaHelper.kt */
public final class InfoOmegaHelper {
    public static final InfoOmegaHelper INSTANCE = new InfoOmegaHelper();

    private InfoOmegaHelper() {
    }

    public final void trackContactCommonShow(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        Intrinsics.checkNotNullParameter(absEditContactPresenter, "presenter");
        if (absEditContactPresenter.getContractModel() != null && !OmegaUtils.INSTANCE.isFastSwTrack()) {
            OmegaCommonModel a = m15219a(absEditContactPresenter);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = "";
            m15220a(absEditContactPresenter, new InfoOmegaHelper$trackContactCommonShow$1(objectRef, objectRef2, objectRef3, a), new InfoOmegaHelper$trackContactCommonShow$2(objectRef, objectRef2, objectRef3, a), new InfoOmegaHelper$trackContactCommonShow$3(objectRef, objectRef2, objectRef3, a), new InfoOmegaHelper$trackContactCommonShow$4(objectRef, objectRef2, objectRef3, a));
            OmegaTracker.Builder.create((String) objectRef.element).addEventParam((String) objectRef2.element, a.getPoiId()).addEventParam((String) objectRef3.element, a.getCityId()).addEventParam("page_source", Integer.valueOf(a.getPageSource())).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(a.getEventSource())).build().track();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        r5 = (r5 = r5.getContact()).getFirstName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0133, code lost:
        if (r7 == false) goto L_0x0137;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackContactCommonCK(com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter r12) {
        /*
            r11 = this;
            java.lang.String r0 = "presenter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.didi.entrega.info.model.OmegaCommonModel r0 = r11.m15219a(r12)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            java.lang.String r2 = ""
            r1.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            r4.element = r2
            java.util.HashMap r5 = r0.getExtentionMap()
            java.util.Map r5 = (java.util.Map) r5
            com.didi.entrega.info.model.ContactModel r6 = r12.getContractModel()
            if (r6 != 0) goto L_0x002f
        L_0x002d:
            r6 = r2
            goto L_0x0044
        L_0x002f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r6 = r6.getContact()
            if (r6 != 0) goto L_0x0036
            goto L_0x002d
        L_0x0036:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r6 = r6.getBuildingAddress()
            if (r6 != 0) goto L_0x003d
            goto L_0x002d
        L_0x003d:
            java.lang.String r6 = r6.getBuildingAddress()
            if (r6 != 0) goto L_0x0044
            goto L_0x002d
        L_0x0044:
            java.lang.String r7 = "building_info"
            r5.put(r7, r6)
            java.util.HashMap r5 = r0.getExtentionMap()
            java.util.Map r5 = (java.util.Map) r5
            com.didi.entrega.info.model.ContactModel r6 = r12.getContractModel()
            if (r6 != 0) goto L_0x0056
            goto L_0x006f
        L_0x0056:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r6 = r6.getContact()
            if (r6 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.getAddress()
            if (r6 != 0) goto L_0x0064
            goto L_0x006f
        L_0x0064:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r6 = r6.poi
            if (r6 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            java.lang.String r6 = r6.displayName
            if (r6 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r2 = r6
        L_0x006f:
            java.lang.String r6 = "address_info"
            r5.put(r6, r2)
            java.util.HashMap r2 = r0.getExtentionMap()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            r6 = 0
            if (r5 != 0) goto L_0x0083
        L_0x0081:
            r5 = r6
            goto L_0x0095
        L_0x0083:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x008a
            goto L_0x0081
        L_0x008a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r5 = r5.getFirstName()
            if (r5 != 0) goto L_0x0091
            goto L_0x0081
        L_0x0091:
            java.lang.String r5 = r5.getFirstName()
        L_0x0095:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x00a4
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            r9 = 2
            if (r5 == 0) goto L_0x00d5
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x00b0
        L_0x00ae:
            r5 = r6
            goto L_0x00c2
        L_0x00b0:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x00b7
            goto L_0x00ae
        L_0x00b7:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r5 = r5.getLastName()
            if (r5 != 0) goto L_0x00be
            goto L_0x00ae
        L_0x00be:
            java.lang.String r5 = r5.getLastName()
        L_0x00c2:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00cf
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00cd
            goto L_0x00cf
        L_0x00cd:
            r5 = 0
            goto L_0x00d0
        L_0x00cf:
            r5 = 1
        L_0x00d0:
            if (r5 != 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r5 = 2
            goto L_0x00d6
        L_0x00d5:
            r5 = 1
        L_0x00d6:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r10 = "has_name"
            r2.put(r10, r5)
            java.util.HashMap r2 = r0.getExtentionMap()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x00ed
        L_0x00eb:
            r5 = r6
            goto L_0x00ff
        L_0x00ed:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x00f4
            goto L_0x00eb
        L_0x00f4:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00fb
            goto L_0x00eb
        L_0x00fb:
            java.lang.String r5 = r5.getPhoneNumber()
        L_0x00ff:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x010c
            int r5 = r5.length()
            if (r5 != 0) goto L_0x010a
            goto L_0x010c
        L_0x010a:
            r5 = 0
            goto L_0x010d
        L_0x010c:
            r5 = 1
        L_0x010d:
            if (r5 != 0) goto L_0x0136
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x0116
            goto L_0x0128
        L_0x0116:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x011d
            goto L_0x0128
        L_0x011d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x0124
            goto L_0x0128
        L_0x0124:
            java.lang.String r6 = r5.getCallingCode()
        L_0x0128:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0132
            int r5 = r6.length()
            if (r5 != 0) goto L_0x0133
        L_0x0132:
            r7 = 1
        L_0x0133:
            if (r7 != 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r8 = 2
        L_0x0137:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            java.lang.String r6 = "has_phone"
            r2.put(r6, r5)
            com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$1 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$1
            r2.<init>(r0, r3, r4, r1)
            r7 = r2
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$2 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$2
            r2.<init>(r0, r3, r4, r1)
            r8 = r2
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$3 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$3
            r2.<init>(r0, r3, r4, r1)
            r9 = r2
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$4 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackContactCommonCK$4
            r2.<init>(r0, r3, r4, r1)
            r10 = r2
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r5 = r11
            r6 = r12
            r5.m15220a(r6, r7, r8, r9, r10)
            T r12 = r1.element
            java.lang.String r12 = (java.lang.String) r12
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = com.didi.entrega.customer.foundation.tracker.OmegaTracker.Builder.create(r12)
            T r1 = r3.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r0.getPoiId()
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r1, r2)
            T r1 = r4.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r0.getCityId()
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r1, r2)
            int r1 = r0.getPageSource()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "page_source"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r2, r1)
            int r1 = r0.getEventSource()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "event_source"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r2, r1)
            java.util.HashMap r0 = r0.getExtentionMap()
            java.util.Map r0 = (java.util.Map) r0
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addAllEventParam(r0)
            com.didi.entrega.customer.foundation.tracker.OmegaTracker r12 = r12.build()
            r12.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.helper.InfoOmegaHelper.trackContactCommonCK(com.didi.entrega.info.component.ContactConstract$AbsEditContactPresenter):void");
    }

    public final void trackHistorySw(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        Intrinsics.checkNotNullParameter(absEditContactPresenter, "presenter");
        OmegaCommonModel a = m15219a(absEditContactPresenter);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        ArrayList<HistoryModel> historyContactList = absEditContactPresenter.getHistoryContactList();
        int size = historyContactList == null ? 0 : historyContactList.size();
        m15220a(absEditContactPresenter, new InfoOmegaHelper$trackHistorySw$1(objectRef, a), new InfoOmegaHelper$trackHistorySw$2(objectRef, a), new InfoOmegaHelper$trackHistorySw$3(objectRef, a), new InfoOmegaHelper$trackHistorySw$4(objectRef, a));
        OmegaTracker.Builder.create((String) objectRef.element).addEventParam("page_source", Integer.valueOf(a.getPageSource())).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(a.getEventSource())).addEventParam(ParamConst.InfoOmega.RECORD_NUM, String.valueOf(size)).build().track();
    }

    public final void trackHistoryCk(ContactConstract.AbsEditContactPresenter absEditContactPresenter, int i) {
        Intrinsics.checkNotNullParameter(absEditContactPresenter, "presenter");
        OmegaCommonModel a = m15219a(absEditContactPresenter);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        m15220a(absEditContactPresenter, new InfoOmegaHelper$trackHistoryCk$1(objectRef, a), new InfoOmegaHelper$trackHistoryCk$2(objectRef, a), new InfoOmegaHelper$trackHistoryCk$3(objectRef, a), new InfoOmegaHelper$trackHistoryCk$4(objectRef, a));
        OmegaTracker.Builder.create((String) objectRef.element).addEventParam("page_source", Integer.valueOf(a.getPageSource())).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(a.getEventSource())).build().track();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        r5 = (r5 = r5.getContact()).getFirstName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0133, code lost:
        if (r7 == false) goto L_0x0137;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackConfirmCk(com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter r12) {
        /*
            r11 = this;
            java.lang.String r0 = "presenter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.didi.entrega.info.model.OmegaCommonModel r0 = r11.m15219a(r12)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            java.lang.String r2 = ""
            r1.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r3.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            r4.element = r2
            java.util.HashMap r5 = r0.getExtentionMap()
            java.util.Map r5 = (java.util.Map) r5
            com.didi.entrega.info.model.ContactModel r6 = r12.getContractModel()
            if (r6 != 0) goto L_0x002f
        L_0x002d:
            r6 = r2
            goto L_0x0044
        L_0x002f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r6 = r6.getContact()
            if (r6 != 0) goto L_0x0036
            goto L_0x002d
        L_0x0036:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r6 = r6.getBuildingAddress()
            if (r6 != 0) goto L_0x003d
            goto L_0x002d
        L_0x003d:
            java.lang.String r6 = r6.getBuildingAddress()
            if (r6 != 0) goto L_0x0044
            goto L_0x002d
        L_0x0044:
            java.lang.String r7 = "building_info"
            r5.put(r7, r6)
            java.util.HashMap r5 = r0.getExtentionMap()
            java.util.Map r5 = (java.util.Map) r5
            com.didi.entrega.info.model.ContactModel r6 = r12.getContractModel()
            if (r6 != 0) goto L_0x0056
            goto L_0x006f
        L_0x0056:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r6 = r6.getContact()
            if (r6 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.getAddress()
            if (r6 != 0) goto L_0x0064
            goto L_0x006f
        L_0x0064:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r6 = r6.poi
            if (r6 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            java.lang.String r6 = r6.displayName
            if (r6 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r2 = r6
        L_0x006f:
            java.lang.String r6 = "address_info"
            r5.put(r6, r2)
            java.util.HashMap r2 = r0.getExtentionMap()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            r6 = 0
            if (r5 != 0) goto L_0x0083
        L_0x0081:
            r5 = r6
            goto L_0x0095
        L_0x0083:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x008a
            goto L_0x0081
        L_0x008a:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r5 = r5.getFirstName()
            if (r5 != 0) goto L_0x0091
            goto L_0x0081
        L_0x0091:
            java.lang.String r5 = r5.getFirstName()
        L_0x0095:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x00a4
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            r9 = 2
            if (r5 == 0) goto L_0x00d5
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x00b0
        L_0x00ae:
            r5 = r6
            goto L_0x00c2
        L_0x00b0:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x00b7
            goto L_0x00ae
        L_0x00b7:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r5 = r5.getLastName()
            if (r5 != 0) goto L_0x00be
            goto L_0x00ae
        L_0x00be:
            java.lang.String r5 = r5.getLastName()
        L_0x00c2:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00cf
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00cd
            goto L_0x00cf
        L_0x00cd:
            r5 = 0
            goto L_0x00d0
        L_0x00cf:
            r5 = 1
        L_0x00d0:
            if (r5 != 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r5 = 2
            goto L_0x00d6
        L_0x00d5:
            r5 = 1
        L_0x00d6:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r10 = "has_name"
            r2.put(r10, r5)
            java.util.HashMap r2 = r0.getExtentionMap()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x00ed
        L_0x00eb:
            r5 = r6
            goto L_0x00ff
        L_0x00ed:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x00f4
            goto L_0x00eb
        L_0x00f4:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00fb
            goto L_0x00eb
        L_0x00fb:
            java.lang.String r5 = r5.getPhoneNumber()
        L_0x00ff:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x010c
            int r5 = r5.length()
            if (r5 != 0) goto L_0x010a
            goto L_0x010c
        L_0x010a:
            r5 = 0
            goto L_0x010d
        L_0x010c:
            r5 = 1
        L_0x010d:
            if (r5 != 0) goto L_0x0136
            com.didi.entrega.info.model.ContactModel r5 = r12.getContractModel()
            if (r5 != 0) goto L_0x0116
            goto L_0x0128
        L_0x0116:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r5.getContact()
            if (r5 != 0) goto L_0x011d
            goto L_0x0128
        L_0x011d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x0124
            goto L_0x0128
        L_0x0124:
            java.lang.String r6 = r5.getCallingCode()
        L_0x0128:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0132
            int r5 = r6.length()
            if (r5 != 0) goto L_0x0133
        L_0x0132:
            r7 = 1
        L_0x0133:
            if (r7 != 0) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r8 = 2
        L_0x0137:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            java.lang.String r6 = "has_phone"
            r2.put(r6, r5)
            com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$1 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$1
            r2.<init>(r0, r3, r4, r1)
            r7 = r2
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$2 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$2
            r2.<init>(r0, r3, r4, r1)
            r8 = r2
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$3 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$3
            r2.<init>(r0, r3, r4, r1)
            r9 = r2
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$4 r2 = new com.didi.entrega.info.helper.InfoOmegaHelper$trackConfirmCk$4
            r2.<init>(r0, r3, r4, r1)
            r10 = r2
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r5 = r11
            r6 = r12
            r5.m15220a(r6, r7, r8, r9, r10)
            T r12 = r1.element
            java.lang.String r12 = (java.lang.String) r12
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = com.didi.entrega.customer.foundation.tracker.OmegaTracker.Builder.create(r12)
            T r1 = r3.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r0.getPoiId()
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r1, r2)
            T r1 = r4.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r0.getCityId()
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r1, r2)
            int r1 = r0.getPageSource()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "page_source"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r2, r1)
            int r1 = r0.getEventSource()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "event_source"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addEventParam(r2, r1)
            java.util.HashMap r0 = r0.getExtentionMap()
            java.util.Map r0 = (java.util.Map) r0
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r12 = r12.addAllEventParam(r0)
            com.didi.entrega.customer.foundation.tracker.OmegaTracker r12 = r12.build()
            r12.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.helper.InfoOmegaHelper.trackConfirmCk(com.didi.entrega.info.component.ContactConstract$AbsEditContactPresenter):void");
    }

    public final void trackStufSw(StuffConstract.AbsCommonStuffPresenter absCommonStuffPresenter) {
        Intrinsics.checkNotNullParameter(absCommonStuffPresenter, "presenter");
        if (!(absCommonStuffPresenter.getStuffTypeModel() == null && absCommonStuffPresenter.getStuffRemarkModel() == null && absCommonStuffPresenter.getStuffRuleModel() == null) && !OmegaUtils.INSTANCE.isFastSwTrack()) {
            OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_GOODS_COMMON_SW).addEventParam("page_source", "201").build().track();
        }
    }

    public final void trackStuffReturnCk(StuffConstract.AbsCommonStuffPresenter absCommonStuffPresenter) {
        String str;
        CommonInfoEntity.CateInfosItem selectedItem;
        Intrinsics.checkNotNullParameter(absCommonStuffPresenter, "presenter");
        InfoComponentRepo componentRepo = absCommonStuffPresenter.getComponentRepo();
        String str2 = null;
        if (!(componentRepo == null || (selectedItem = componentRepo.getSelectedItem()) == null)) {
            str2 = selectedItem.getCateID();
        }
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_GOODS_RETURN_CK).addEventParam("page_source", "201");
        String str3 = "0";
        if (!(str2 == null || (str = str2.toString()) == null)) {
            str3 = str;
        }
        addEventParam.addEventParam("cate_id", str3).build().track();
    }

    public final void trackStuffConfirmCk(StuffConstract.AbsCommonStuffPresenter absCommonStuffPresenter) {
        String str;
        CommonInfoEntity.CateInfosItem selectedItem;
        Intrinsics.checkNotNullParameter(absCommonStuffPresenter, "presenter");
        InfoComponentRepo componentRepo = absCommonStuffPresenter.getComponentRepo();
        String str2 = null;
        if (!(componentRepo == null || (selectedItem = componentRepo.getSelectedItem()) == null)) {
            str2 = selectedItem.getCateID();
        }
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_GOODS_CONFIRM_CK).addEventParam("page_source", "201");
        String str3 = "0";
        if (!(str2 == null || (str = str2.toString()) == null)) {
            str3 = str;
        }
        addEventParam.addEventParam("cate_id", str3).build().track();
    }

    public final void trackReceiverToAddressListCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_RECEIVER_PHONE_ADDRESS_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackSenderToAddressListCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_ADDRESS_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackReceiverPhoneClearCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_RECEIVER_PHONE_CLEAR_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackSenderPhoneClearCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_PHONE_CLEAR_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackReceiverPhoneInputCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_RECEIVER_PHONE_INPUT_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackSenderPhoneInputCK(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_PHONE_INPUT_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).build().track();
    }

    public final void trackSenderNameCK(int i, int i2, int i3) {
        OmegaTracker.Builder.create(EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_NAME_CK).addEventParam("page_source", Integer.valueOf(i)).addEventParam(ParamConst.InfoOmega.EVENT_SOURCE, Integer.valueOf(i2)).addEventParam("click_type", Integer.valueOf(i3)).build().track();
    }

    /* renamed from: a */
    private final OmegaCommonModel m15219a(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        String str;
        CommonInfoEntity.Contact contact;
        AddressEntity address;
        AddressEntity.PoiEntity poiEntity;
        String num;
        CommonInfoEntity.Contact contact2;
        AddressEntity address2;
        AddressEntity.PoiEntity poiEntity2;
        OmegaCommonModel omegaCommonModel = new OmegaCommonModel((String) null, (String) null, 0, 0, 0, (HashMap) null, 63, (DefaultConstructorMarker) null);
        ContactModel contractModel = absEditContactPresenter.getContractModel();
        String str2 = "";
        if (contractModel == null || (contact2 = contractModel.getContact()) == null || (address2 = contact2.getAddress()) == null || (poiEntity2 = address2.poi) == null || (str = poiEntity2.poiId) == null) {
            str = str2;
        }
        omegaCommonModel.setPoiId(str);
        ContactModel contractModel2 = absEditContactPresenter.getContractModel();
        if (!(contractModel2 == null || (contact = contractModel2.getContact()) == null || (address = contact.getAddress()) == null || (poiEntity = address.poi) == null || (num = Integer.valueOf(poiEntity.cityId).toString()) == null)) {
            str2 = num;
        }
        omegaCommonModel.setCityId(str2);
        omegaCommonModel.setPageSource(absEditContactPresenter.getPageSource());
        omegaCommonModel.setEventSource(absEditContactPresenter.getEventSource());
        return omegaCommonModel;
    }

    /* renamed from: a */
    private final void m15220a(ContactConstract.AbsEditContactPresenter absEditContactPresenter, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        if (absEditContactPresenter instanceof SendContactUpdatePresenter) {
            function02.invoke();
        } else if (absEditContactPresenter instanceof ReceiveContactUpdatePresenter) {
            function04.invoke();
        }
    }
}
