package com.didi.beatles.p099im.api.entity;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.Serializable;
import java.lang.reflect.Field;

/* renamed from: com.didi.beatles.im.api.entity.IMLocationEntity */
public class IMLocationEntity implements Serializable {
    public String address;
    public int cityId = -1;
    public String cityName;
    public String country_iso_code;
    public String displayname;
    public double lat;
    public double lng;

    public String toString() {
        return "displayname=" + this.displayname + "&address=" + this.address + "&cityName=" + this.cityName + "&cityId=" + this.cityId + "&lng=" + this.lng + "&lat=" + this.lat;
    }

    public static IMLocationEntity toLocatinEntity(String str) {
        IMLocationEntity iMLocationEntity = new IMLocationEntity();
        String[] split = str.split(ParamKeys.SIGN_AND);
        if (split.length == 6) {
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                String str2 = split3[0];
                String str3 = split3[1];
                try {
                    for (Field field : iMLocationEntity.getClass().getFields()) {
                        if (field.getName().equals(str2)) {
                            Class<?> type = field.getType();
                            field.setAccessible(true);
                            if (type == String.class) {
                                field.set(iMLocationEntity, String.valueOf(str3));
                            } else if (type == Double.TYPE) {
                                field.set(iMLocationEntity, Double.valueOf(Double.parseDouble(str3)));
                            } else if (type == Integer.TYPE) {
                                field.set(iMLocationEntity, Integer.valueOf(Integer.parseInt(str3)));
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return iMLocationEntity;
    }
}
