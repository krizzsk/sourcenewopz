package p242io.socket.parseqs;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;
import p242io.socket.global.Global;

/* renamed from: io.socket.parseqs.ParseQS */
public class ParseQS {
    private ParseQS() {
    }

    public static String encode(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(Global.encodeURIComponent((String) next.getKey()));
            sb.append("=");
            sb.append(Global.encodeURIComponent((String) next.getValue()));
        }
        return sb.toString();
    }

    public static Map<String, String> decode(String str) {
        HashMap hashMap = new HashMap();
        for (String split : str.split(ParamKeys.SIGN_AND)) {
            String[] split2 = split.split("=");
            hashMap.put(Global.decodeURIComponent(split2[0]), split2.length > 1 ? Global.decodeURIComponent(split2[1]) : "");
        }
        return hashMap;
    }
}
