package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OrderExtraInfoModel extends BaseObject {
    public AirportGuideInfo airportGuideInfo;
    public BookingAssignInfo bookingAssignInfo;
    public CarPoolMatchInfo carPoolMatchInfo;
    public LineupInfo lineupInfo;
    public String oid;
    public PredictManageInfo predictManageInfo;
    public int queryStep;
    public boolean stopQuery;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oid = optJSONObject.optString("oid");
            this.stopQuery = optJSONObject.optBoolean("stop_query");
            this.queryStep = optJSONObject.optInt("query_step");
            if (optJSONObject.has("carpool_match_info") && (optJSONObject3 = optJSONObject.optJSONObject("carpool_match_info")) != null) {
                CarPoolMatchInfo carPoolMatchInfo2 = new CarPoolMatchInfo();
                this.carPoolMatchInfo = carPoolMatchInfo2;
                carPoolMatchInfo2.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("lineup_match_info");
            if (optJSONObject4 != null) {
                LineupInfo lineupInfo2 = new LineupInfo();
                this.lineupInfo = lineupInfo2;
                lineupInfo2.parse(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("predict_manage_info");
            if (optJSONObject5 != null) {
                PredictManageInfo predictManageInfo2 = new PredictManageInfo();
                this.predictManageInfo = predictManageInfo2;
                predictManageInfo2.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("booking_assign_info");
            if (optJSONObject6 != null) {
                BookingAssignInfo bookingAssignInfo2 = new BookingAssignInfo();
                this.bookingAssignInfo = bookingAssignInfo2;
                bookingAssignInfo2.parse(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("flight_info");
            if (optJSONObject7 != null && (optJSONObject2 = optJSONObject7.optJSONObject("guide_info")) != null) {
                AirportGuideInfo airportGuideInfo2 = new AirportGuideInfo();
                this.airportGuideInfo = airportGuideInfo2;
                airportGuideInfo2.parse(optJSONObject2);
            }
        }
    }
}
