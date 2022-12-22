package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.push.MessageParser;
import com.didi.travel.psnger.gson.PostProcessable;
import com.didi.travel.psnger.model.response.NearDriversRaw;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;

public class NearDrivers extends NearDriversRaw implements PostProcessable<NearDrivers> {
    public static final MessageParser<NearDrivers> MESSAGE_PARSER = new MessageParser<>(NearDrivers.class);
    public transient DriverCollection drivers = new DriverCollection();
    public transient boolean isShowEta;

    public NearDrivers gsonPostProcess() {
        NearDriversRaw.Loc loc;
        this.isShowEta = this.showEta == 1;
        if (this.driverLocations != null && !this.driverLocations.isEmpty()) {
            for (NearDriversRaw.Loc loc2 : this.driverLocations) {
                if (loc2 != null) {
                    CarDriverModel carDriverModel = new CarDriverModel(loc2.driverId);
                    VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
                    if (loc2.coords != null) {
                        for (NearDriversRaw.Coordinate next : loc2.coords) {
                            VectorCoordinate vectorCoordinate = r8;
                            VectorCoordinate vectorCoordinate2 = new VectorCoordinate(next.f44220x, next.f44221y, (float) next.angle, (long) next.timestamp);
                            vectorCoordinateList.add(vectorCoordinate);
                            loc2 = loc2;
                        }
                    }
                    NearDriversRaw.Loc loc3 = loc2;
                    carDriverModel.setVectorCoordinateList(vectorCoordinateList);
                    if (this.isDebugOpen == 1) {
                        loc = loc3;
                        carDriverModel.setDebugStatus(loc.debugStatus);
                        carDriverModel.setDebugStatusDetail(loc.debugStatusDetail);
                    } else {
                        loc = loc3;
                    }
                    carDriverModel.setCarLevel(loc.carLevel);
                    this.drivers.add(carDriverModel);
                }
            }
        }
        return this.data != null ? this.data : this;
    }

    public String toString() {
        return "NearDrivers{productId=" + this.productId + ", eta=" + this.eta + ", etaDistance=" + this.etaDistance + ", etaStr='" + this.etaStr + '\'' + ", drivers=" + this.drivers + ", pqInfo =" + this.pqInfo + ", t_eta =" + this.mDestEta + ", isshow_eta=" + this.isShowEta + '}';
    }
}
