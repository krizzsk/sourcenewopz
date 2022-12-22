package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum WarningSignKindEnum implements ProtoEnum {
    WarningSignKind_LeftStrongCurve(1),
    WarningSignKind_RightStrongCurve(2),
    WarningSignKind_ReverseCurveLeft(3),
    WarningSignKind_ContinuousCurve(4),
    WarningSignKind_UpperSlope(5),
    WarningSignKind_LowerSlope(6),
    WarningSignKind_BilateralNarrow(7),
    WarningSignKind_RightNarrow(8),
    WarningSignKind_LeftNarrow(9),
    WarningSignKind_NarrowBridge(10),
    WarningSignKind_TwoWayTraffic(11),
    WarningSignKind_AttentionChildren(12),
    WarningSignKind_AttentionLivestock(13),
    WarningSignKind_AttentionLeftFallingRocks(14),
    WarningSignKind_AttentionRightFallingRocks(15),
    WarningSignKind_AttentionWind(16),
    WarningSignKind_EasySlip(17),
    WarningSignKind_LeftNearMountainRoad(18),
    WarningSignKind_RightNearMountainRoad(19),
    WarningSignKind_LeftEmbankmentRoad(20),
    WarningSignKind_RightEmbankmentRoad(21),
    WarningSignKind_Village(22),
    WarningSignKind_HumpBridge(23),
    WarningSignKind_UnevenPavement(24),
    WarningSignKind_WaterCrossingSurface(25),
    WarningSignKind_SomeoneGuardRailwayCrossing(26),
    WarningSignKind_NooneGuardRailwayCrossing(27),
    WarningSignKind_AccidentProneSections(28),
    WarningSignKind_BothSideBypassSround(29),
    WarningSignKind_LeftSideBypassSround(30),
    WarningSignKind_RightSideBypassSround(31),
    WarningSignKind_AttentionDanger(32),
    WarningSignKind_PassingProhibited(33),
    WarningSignKind_RelieveNoOvertaking(34),
    WarningSignKind_Honk(35),
    WarningSignKind_ContinuousDownhill(36),
    WarningSignKind_VerbalWarning(37),
    WarningSignKind_LeftJunction(38),
    WarningSignKind_RightJunction(39),
    WarningSignKind_StopAtIntersection(40),
    WarningSignKind_StopYieldTheCar(41),
    WarningSignKind_SlowYield(42),
    WarningSignKind_TunnelLights(43),
    WarningSignKind_TidalLane(44),
    WarningSignKind_RoadSurfaceConvex(45),
    WarningSignKind_RoadSurfaceLowlying(46),
    WarningSignKind_ReverseCurveRight(47),
    WarningSignKind_TrafficAccidentBlackSpots(48);
    
    private final int value;

    private WarningSignKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
