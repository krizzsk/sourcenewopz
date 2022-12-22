package p242io.socket.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.socket.parser.Binary */
public class Binary {

    /* renamed from: a */
    private static final String f59550a = "_placeholder";

    /* renamed from: b */
    private static final String f59551b = "num";

    /* renamed from: c */
    private static final Logger f59552c = Logger.getLogger(Binary.class.getName());

    /* renamed from: io.socket.parser.Binary$DeconstructedPacket */
    public static class DeconstructedPacket {
        public byte[][] buffers;
        public Packet packet;
    }

    public static DeconstructedPacket deconstructPacket(Packet packet) {
        ArrayList arrayList = new ArrayList();
        packet.data = m42064a((Object) packet.data, (List<byte[]>) arrayList);
        packet.attachments = arrayList.size();
        DeconstructedPacket deconstructedPacket = new DeconstructedPacket();
        deconstructedPacket.packet = packet;
        deconstructedPacket.buffers = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return deconstructedPacket;
    }

    /* renamed from: a */
    private static Object m42064a(Object obj, List<byte[]> list) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f59550a, true);
                jSONObject.put(f59551b, list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e) {
                f59552c.log(Level.WARNING, "An error occured while putting data to JSONObject", e);
                return null;
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, m42064a(jSONArray2.get(i), list));
                    i++;
                } catch (JSONException e2) {
                    f59552c.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e2);
                    return null;
                }
            }
            return jSONArray;
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = (JSONObject) obj;
            Iterator<String> keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, m42064a(jSONObject3.get(next), list));
                } catch (JSONException e3) {
                    f59552c.log(Level.WARNING, "An error occured while putting data to JSONObject", e3);
                    return null;
                }
            }
            return jSONObject2;
        }
    }

    public static Packet reconstructPacket(Packet packet, byte[][] bArr) {
        packet.data = m42065a((Object) packet.data, bArr);
        packet.attachments = -1;
        return packet;
    }

    /* renamed from: a */
    private static Object m42065a(Object obj, byte[][] bArr) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, m42065a(jSONArray.get(i), bArr));
                    i++;
                } catch (JSONException e) {
                    f59552c.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e);
                    return null;
                }
            }
            return jSONArray;
        }
        boolean z = obj instanceof JSONObject;
        JSONObject jSONObject = obj;
        if (z) {
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2.optBoolean(f59550a)) {
                int optInt = jSONObject2.optInt(f59551b, -1);
                if (optInt < 0 || optInt >= bArr.length) {
                    return null;
                }
                return bArr[optInt];
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, m42065a(jSONObject2.get(next), bArr));
                } catch (JSONException e2) {
                    f59552c.log(Level.WARNING, "An error occured while putting data to JSONObject", e2);
                    return null;
                }
            }
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }
}
