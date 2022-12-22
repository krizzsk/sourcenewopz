package com.didi.sdk.misconfig.model;

import java.io.Serializable;
import java.util.List;

public class MisConfigInfo implements Serializable {
    private String curVersion;
    private long curtime;
    private MisConfigConcreteInfo data;
    private String errmsg;
    private int errno;

    public class MisConfigConcreteInfo implements Serializable {
        private List<CarGrop> baseConf;
        private List<CarIcon> carIcon;
        private int cityId;
        private int countryId;
        private String countryIsoCode;
        private Currency currency;
        private HotInfo hotInfo;
        private String link;
        private List<MapIcon> mapIcon;
        private Smooth smooth;
        private int utcOffset;

        public MisConfigConcreteInfo() {
        }

        public List<CarGrop> getBaseConf() {
            return this.baseConf;
        }

        public void setBaseConf(List<CarGrop> list) {
            this.baseConf = list;
        }

        public int getCityId() {
            return this.cityId;
        }

        public int getCountryId() {
            return this.countryId;
        }

        public String getCountryIsoCode() {
            return this.countryIsoCode;
        }

        public Currency getCurrency() {
            return this.currency;
        }

        public Smooth getSmooth() {
            return this.smooth;
        }

        public List<MapIcon> getMapIcons() {
            return this.mapIcon;
        }

        public List<CarIcon> getCarIcons() {
            return this.carIcon;
        }

        public String getLink() {
            return this.link;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public int getUtcOffSet() {
            return this.utcOffset;
        }

        public void setUtcOffSet(int i) {
            this.utcOffset = i;
        }

        public HotInfo getHotInfo() {
            return this.hotInfo;
        }

        public void setHotInfo(HotInfo hotInfo2) {
            this.hotInfo = hotInfo2;
        }
    }

    public MisConfigConcreteInfo getData() {
        return this.data;
    }

    public String getCurVersion() {
        return this.curVersion;
    }

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public long getCurtime() {
        return this.curtime;
    }
}
