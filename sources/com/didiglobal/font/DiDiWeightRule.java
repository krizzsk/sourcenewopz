package com.didiglobal.font;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DiDiWeightRule implements Serializable {
    public List<DiDiWeight> rules = new ArrayList();

    public void parse(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                DiDiWeight diDiWeight = new DiDiWeight();
                diDiWeight.parse(optJSONArray.getString(i));
                this.rules.add(diDiWeight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getWeightType(int i) {
        int i2 = 2;
        for (DiDiWeight next : this.rules) {
            if (next != null && i >= next.min) {
                i2 = next.type;
            }
        }
        return i2;
    }

    static class DiDiWeight implements Serializable {
        public int max;
        public int min;
        public int type;

        DiDiWeight() {
        }

        public void parse(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.type = jSONObject.optInt("type");
                JSONObject optJSONObject = jSONObject.optJSONObject("range");
                if (optJSONObject != null) {
                    this.min = optJSONObject.optInt("min");
                    this.max = optJSONObject.optInt("max");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
