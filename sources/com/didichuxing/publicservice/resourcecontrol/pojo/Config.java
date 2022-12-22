package com.didichuxing.publicservice.resourcecontrol.pojo;

public class Config {
    public int adid;
    public ViewPagerTravellingConfig travellingConfig;
    public ViewPagerWaitingConfig waitingConfig;

    public class ViewPagerWaitingConfig {
        public String configDesc;
        public String configKey;
        public int configValue;

        public ViewPagerWaitingConfig() {
        }
    }

    public class ViewPagerTravellingConfig {
        public String configDesc;
        public String configKey;
        public int configValue;

        public ViewPagerTravellingConfig() {
        }
    }
}
