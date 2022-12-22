package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.locator.GoogleFusionFilter */
public class GoogleFusionFilter {

    /* renamed from: a */
    DIDILocation f45986a;

    /* renamed from: b */
    OSLocationWrapper f45987b;

    /* renamed from: c */
    DIDILocation f45988c;

    /* renamed from: d */
    DIDILocation f45989d;

    /* renamed from: e */
    private int f45990e = ApolloProxy.getInstance().getDataSourceFilterType();

    /* renamed from: f */
    private DIDILocation f45991f;

    public GoogleFusionFilter() {
        DLog.m32737d("fusion filter type = " + this.f45990e);
    }

    public DIDILocation getTargetLocation(DIDILocation dIDILocation, OSLocationWrapper oSLocationWrapper, DIDILocation dIDILocation2, DIDILocation dIDILocation3) {
        DIDILocation dIDILocation4;
        this.f45986a = dIDILocation;
        this.f45987b = oSLocationWrapper;
        this.f45988c = dIDILocation2;
        this.f45989d = dIDILocation3;
        int i = this.f45990e;
        if (i == 1) {
            dIDILocation4 = m33007b();
        } else if (i != 2) {
            dIDILocation4 = m33005a();
        } else {
            dIDILocation4 = m33008c();
        }
        this.f45991f = dIDILocation4;
        return dIDILocation4;
    }

    public void destroy() {
        this.f45990e = 0;
        this.f45991f = null;
        this.f45986a = null;
        this.f45987b = null;
        this.f45988c = null;
        this.f45989d = null;
    }

    /* renamed from: a */
    private DIDILocation m33005a() {
        DIDILocation dIDILocation = this.f45986a;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        OSLocationWrapper oSLocationWrapper = this.f45987b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation2 = this.f45988c;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        DIDILocation dIDILocation3 = this.f45989d;
        if (dIDILocation3 != null) {
            return dIDILocation3;
        }
        return null;
    }

    /* renamed from: b */
    private DIDILocation m33007b() {
        DIDILocation dIDILocation = this.f45986a;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        DIDILocation dIDILocation2 = this.f45988c;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        OSLocationWrapper oSLocationWrapper = this.f45987b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation3 = this.f45989d;
        if (dIDILocation3 != null) {
            return dIDILocation3;
        }
        return null;
    }

    /* renamed from: c */
    private DIDILocation m33008c() {
        if (this.f45986a != null) {
            return m33009d();
        }
        DIDILocation dIDILocation = this.f45988c;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        OSLocationWrapper oSLocationWrapper = this.f45987b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation2 = this.f45989d;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        return null;
    }

    /* renamed from: d */
    private DIDILocation m33009d() {
        DIDILocation dIDILocation;
        DIDILocation dIDILocation2 = this.f45986a;
        DLog.m32737d("try to replace cur gps = " + this.f45988c);
        DLog.m32737d("try last location = " + this.f45991f);
        if (this.f45991f == null || !ETraceSource.googleflp.toString().equals(this.f45991f.getSource()) || !m33006a(dIDILocation2, this.f45991f) || (dIDILocation = this.f45988c) == null || m33006a(dIDILocation2, dIDILocation)) {
            return dIDILocation2;
        }
        DLog.m32737d("replace googleFLP = " + dIDILocation2 + " gps = " + this.f45988c);
        return this.f45988c;
    }

    /* renamed from: a */
    private boolean m33006a(DIDILocation dIDILocation, DIDILocation dIDILocation2) {
        if (dIDILocation != null && dIDILocation2 != null && dIDILocation.getLatitude() == dIDILocation2.getLatitude() && dIDILocation.getLongitude() == dIDILocation2.getLongitude() && dIDILocation.getTime() == dIDILocation2.getTime()) {
            return true;
        }
        return false;
    }
}
