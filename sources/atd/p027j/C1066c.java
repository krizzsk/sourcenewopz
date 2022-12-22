package atd.p027j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.j.c */
public class C1066c extends C1065b {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31061656816302L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public JSONArray mo13785c(Context context) throws C1051c {
        Set<BluetoothDevice> bondedDevices;
        JSONArray jSONArray = new JSONArray();
        BluetoothAdapter d = mo13794d(context);
        if (!(d == null || (bondedDevices = d.getBondedDevices()) == null)) {
            for (BluetoothDevice a : bondedDevices) {
                jSONArray.put(m469a(a));
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private JSONObject m469a(BluetoothDevice bluetoothDevice) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1172a.m764a(-31083131652782L), bluetoothDevice.getName());
            jSONObject.put(C1172a.m764a(-31104606489262L), bluetoothDevice.getAddress());
            if (Build.VERSION.SDK_INT >= 18) {
                jSONObject.put(C1172a.m764a(-31138966227630L), bluetoothDevice.getType());
            }
            jSONObject.put(C1172a.m764a(-31160441064110L), bluetoothDevice.getBondState());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(C1172a.m764a(-31203390737070L), e);
        }
    }
}
