package org.apache.commons.codec2.language;

import androidx.exifinterface.media.ExifInterface;
import com.didi.dimina.container.bridge.NetworkSubJSBridge;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didiglobal.domainservice.utils.DomainConstants;
import java.util.Locale;

public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        return (String.valueOf(str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll("c", "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll(RavenKey.VERSION, "f").replaceAll("dg", NetworkSubJSBridge.NetworkType.TYPE_2G).replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll("d", RavenKey.TYPE).replaceAll("ph", "fh").replaceAll("b", RavenConfigKey.PHONE).replaceAll("sh", "s2").replaceAll("z", RavenKey.STACK).replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("j", SameLayerRenderingUtil.KEY_COMP_Y).replaceAll("^y3", "Y3").replaceAll("^y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(SameLayerRenderingUtil.KEY_COMP_Y, "3").replaceAll("3gh3", "3kh3").replaceAll("gh", ScarShareReportModel.CHANNEL_WHATSAPP).replaceAll(DomainConstants.DOMAIN_SUFFIX_G, "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", "T").replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", "3").replaceAll("w", "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("h", "2").replaceAll("r3", "R3").replaceAll("r$", "3").replaceAll("r", "2").replaceAll("l3", "L3").replaceAll("l$", "3").replaceAll("l", "2").replaceAll("2", "").replaceAll("3$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("3", "")) + TEN_1).substring(0, 10);
    }
}
