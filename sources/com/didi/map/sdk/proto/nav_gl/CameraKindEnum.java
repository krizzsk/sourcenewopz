package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum CameraKindEnum implements ProtoEnum {
    CameraKind_Unknown(0),
    CameraKind_RedLight(1),
    CameraKind_ElectronicMonitoring(2),
    CameraKind_FixedSpeedTraps(3),
    CameraKind_MobileSpeedZone(4),
    CameraKind_BusOnlyWay(5),
    CameraKind_OneWay(6),
    CameraKind_EmergencyWay(7),
    CameraKind_NoneMotorWay(8),
    CameraKind_QujianEnter(9),
    CameraKind_QujianExit(10),
    CameraKind_LianxuEnter(11),
    CameraKind_LianxuExit(12),
    CameraKind_GoToBeijing(13),
    CameraKind_TailNumber(14),
    CameraKind_Other(15),
    CameraKind_HOV(16),
    CameraKind_LaLian(17),
    CameraKind_IllegalPark(18),
    CameraKind_NumberLimit(19);
    
    private final int value;

    private CameraKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
