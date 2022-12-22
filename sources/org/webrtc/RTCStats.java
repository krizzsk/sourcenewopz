package org.webrtc;

import java.util.Map;
import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

public class RTCStats {

    /* renamed from: id */
    private final String f6707id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j;
        this.type = str;
        this.f6707id = str2;
        this.members = map;
    }

    public double getTimestampUs() {
        return (double) this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.f6707id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", id: ");
        sb.append(this.f6707id);
        for (Map.Entry next : this.members.entrySet()) {
            sb.append(", ");
            sb.append((String) next.getKey());
            sb.append(": ");
            appendValue(sb, next.getValue());
        }
        sb.append(" }");
        return sb.toString();
    }

    private static void appendValue(StringBuilder sb, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            sb.append(VersionRange.LEFT_CLOSED);
            for (int i = 0; i < objArr.length; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                appendValue(sb, objArr[i]);
            }
            sb.append(VersionRange.RIGHT_CLOSED);
        } else if (obj instanceof String) {
            sb.append(Typography.quote);
            sb.append(obj);
            sb.append(Typography.quote);
        } else {
            sb.append(obj);
        }
    }

    static RTCStats create(long j, String str, String str2, Map map) {
        return new RTCStats(j, str, str2, map);
    }
}
