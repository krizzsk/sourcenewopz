package com.didi.map.global.component.departure.apolllo;

public class ApolloParamsDeparture {
    public boolean isNeedAdsorbControlEnabled;
    public int mMoveDistanceLimit;
    public int mNeedAdsorbMaxDistance;
    public float mNeedAdsorbPercentage;

    public String toString() {
        return "DepartureExtensionApolloParams{isNeedAdsorbControlEnabled=" + this.isNeedAdsorbControlEnabled + ", mNeedAdsorbMaxDistance=" + this.mNeedAdsorbMaxDistance + ", mNeedAdsorbPercentage=" + this.mNeedAdsorbPercentage + ", mMoveDistanceLimit=" + this.mMoveDistanceLimit + '}';
    }
}
