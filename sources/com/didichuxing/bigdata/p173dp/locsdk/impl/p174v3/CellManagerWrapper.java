package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.Cgi;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.LocDataDef;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManagerWrapper */
public class CellManagerWrapper {

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CellManagerWrapper$SingletonHolder */
    private static class SingletonHolder {
        static final CellManagerWrapper sInstance = new CellManagerWrapper();

        private SingletonHolder() {
        }
    }

    public static CellManagerWrapper getInstance() {
        return SingletonHolder.sInstance;
    }

    public LocDataDef.LocCellInfo getCurrentCellInfo(Context context) {
        if (context == null) {
            return null;
        }
        LocationServiceRequest locationServiceRequest = new LocationServiceRequest();
        m32808a(context);
        m32809a(context, CellManager.getInstance(), locationServiceRequest);
        return locationServiceRequest.cell;
    }

    /* renamed from: a */
    private void m32808a(Context context) {
        CellManager instance = CellManager.getInstance();
        if (instance.cgiNeedUpdate(Utils.airPlaneModeOn(context))) {
            instance.requestCgiLocationUpdate();
        }
        instance.refresh();
    }

    /* renamed from: a */
    private void m32809a(Context context, CellManager cellManager, LocationServiceRequest locationServiceRequest) {
        if (Utils.airPlaneModeOn(context)) {
            DLog.m32737d("air plane mode on");
            cellManager.reset();
        } else {
            cellManager.refineCellT();
        }
        List<Cgi> detectedCgiList = cellManager.getDetectedCgiList();
        Cgi lastDetectedCgiInfo = cellManager.getLastDetectedCgiInfo();
        if (detectedCgiList != null && !detectedCgiList.isEmpty()) {
            locationServiceRequest.cell.neighcells.clear();
            for (int i = 0; i < detectedCgiList.size(); i++) {
                Cgi cgi = detectedCgiList.get(i);
                if (cgi != null) {
                    LocDataDef.LocCellInfo locCellInfo = locationServiceRequest.cell;
                    if (locCellInfo.mnc_sid == 0 && locCellInfo.mcc == 0 && locCellInfo.cellid_bsid == 0 && locCellInfo.lac_nid == 0) {
                        locationServiceRequest.cell.mcc = Long.parseLong(cgi.mcc);
                        locationServiceRequest.cell.mnc_sid = Long.parseLong(cgi.mnc_sid);
                        locationServiceRequest.cell.lac_nid = (long) cgi.lac_nid;
                        locationServiceRequest.cell.cellid_bsid = (long) cgi.cid_bid;
                        locationServiceRequest.cell.rssi = (long) cgi.sig;
                        locationServiceRequest.cell.type = (long) cgi.type;
                    } else {
                        LocDataDef.LocNeighboringCellInfo locNeighboringCellInfo = new LocDataDef.LocNeighboringCellInfo();
                        locNeighboringCellInfo.lac = (long) cgi.lac_nid;
                        locNeighboringCellInfo.cid = (long) cgi.cid_bid;
                        locNeighboringCellInfo.rssi = (long) cgi.sig;
                        locationServiceRequest.cell.neighcells.add(locNeighboringCellInfo);
                    }
                }
            }
            if (lastDetectedCgiInfo != null && lastDetectedCgiInfo.detectedTs != detectedCgiList.get(0).detectedTs) {
                locationServiceRequest.cell.pre_cell.clear();
                LocDataDef.LocPreCellInfo locPreCellInfo = new LocDataDef.LocPreCellInfo();
                long currentTimeMillis = (System.currentTimeMillis() / 1000) - lastDetectedCgiInfo.detectedTs;
                if (currentTimeMillis > 0 && currentTimeMillis <= 300) {
                    locPreCellInfo.mcc = Long.parseLong(lastDetectedCgiInfo.mcc);
                    locPreCellInfo.mnc_sid = Long.parseLong(lastDetectedCgiInfo.mnc_sid);
                    locPreCellInfo.lac_nid = (long) lastDetectedCgiInfo.lac_nid;
                    locPreCellInfo.cellid_bsid = (long) lastDetectedCgiInfo.cid_bid;
                    locPreCellInfo.type = (long) lastDetectedCgiInfo.type;
                    locPreCellInfo.f45707dt = currentTimeMillis;
                    locPreCellInfo.rssi = (long) lastDetectedCgiInfo.sig;
                    locationServiceRequest.cell.pre_cell.add(locPreCellInfo);
                }
            }
        }
    }
}
