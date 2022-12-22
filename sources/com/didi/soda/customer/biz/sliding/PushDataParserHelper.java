package com.didi.soda.customer.biz.sliding;

import com.didi.soda.customer.biz.sliding.p163pb.Coordinate;
import com.didi.soda.customer.biz.sliding.p163pb.DriverLocationInfo;
import com.didi.soda.customer.biz.sliding.p163pb.GulfstreamPassengerDriverLocReq;
import com.didi.soda.customer.biz.sliding.p163pb.LocPoint;
import com.didi.soda.customer.foundation.rpc.sliding.entity.NearDriversEntity;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushDataParserHelper {
    public static NearDriversEntity parseNearDriver(byte[] bArr) {
        GulfstreamPassengerDriverLocReq gulfstreamPassengerDriverLocReq;
        try {
            gulfstreamPassengerDriverLocReq = (GulfstreamPassengerDriverLocReq) new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, GulfstreamPassengerDriverLocReq.class);
        } catch (Exception e) {
            e.printStackTrace();
            gulfstreamPassengerDriverLocReq = null;
        }
        NearDriversEntity nearDriversEntity = new NearDriversEntity();
        nearDriversEntity.eta = ((Integer) Wire.get(gulfstreamPassengerDriverLocReq.eta, GulfstreamPassengerDriverLocReq.DEFAULT_ETA)).intValue();
        nearDriversEntity.etaStr = (String) Wire.get(gulfstreamPassengerDriverLocReq.eta_str, "");
        nearDriversEntity.etaDistance = ((Integer) Wire.get(gulfstreamPassengerDriverLocReq.eta_distance, GulfstreamPassengerDriverLocReq.DEFAULT_ETA_DISTANCE)).intValue();
        nearDriversEntity.redirect = ((Integer) Wire.get(gulfstreamPassengerDriverLocReq.redirect, GulfstreamPassengerDriverLocReq.DEFAULT_REDIRECT)).intValue();
        Iterator it = ((List) Wire.get(gulfstreamPassengerDriverLocReq.loc, GulfstreamPassengerDriverLocReq.DEFAULT_LOC)).iterator();
        while (it.hasNext()) {
            DriverLocationInfo driverLocationInfo = (DriverLocationInfo) it.next();
            Driver driver = new Driver(Wire.get(driverLocationInfo.dirverId, DriverLocationInfo.DEFAULT_DIRVERID) + "");
            VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
            for (Coordinate coordinate : (List) Wire.get(driverLocationInfo.coords, DriverLocationInfo.DEFAULT_COORDS)) {
                Iterator it2 = it;
                VectorCoordinate vectorCoordinate = r8;
                VectorCoordinate vectorCoordinate2 = new VectorCoordinate(((Double) Wire.get(coordinate.f40541x, Coordinate.DEFAULT_X)).doubleValue(), ((Double) Wire.get(coordinate.f40542y, Coordinate.DEFAULT_Y)).doubleValue(), (float) ((double) ((Integer) Wire.get(coordinate.angle, Coordinate.DEFAULT_ANGLE)).intValue()), (long) ((Integer) Wire.get(coordinate.timestamp, Coordinate.DEFAULT_TIMESTAMP)).intValue());
                vectorCoordinateList.add(vectorCoordinate);
                it = it2;
            }
            driver.setVectorCoordinateList(vectorCoordinateList);
            nearDriversEntity.drivers.add(driver);
            it = it;
        }
        return nearDriversEntity;
    }

    public static List<LocPoint> getLocPointsList(double d, double d2) {
        ArrayList arrayList = new ArrayList();
        LocPoint.Builder builder = new LocPoint.Builder();
        builder.lat(Double.valueOf(d));
        builder.lng(Double.valueOf(d2));
        arrayList.add(builder.build());
        return arrayList;
    }

    public static String getLocPointsString(double d, double d2) {
        return "[\"" + d + "|" + d2 + "\"]";
    }
}
