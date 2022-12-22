package didihttpdns.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DnsResponse implements Serializable {
    private int errno;
    private List<DnsRecord> list;

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public List<DnsRecord> getList() {
        return this.list;
    }

    public void setList(List<DnsRecord> list2) {
        this.list = list2;
    }

    public String toString() {
        return "errno:" + this.errno + ", list:" + this.list;
    }

    public static DnsResponse parseFromJsonObject(JSONObject jSONObject) throws JSONException {
        DnsResponse dnsResponse = new DnsResponse();
        dnsResponse.errno = jSONObject.optInt("errno");
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(DnsRecord.parseFromJsonObject(optJSONObject));
                }
            }
            dnsResponse.list = arrayList;
        }
        return dnsResponse;
    }
}
