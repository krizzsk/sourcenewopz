package com.didichuxing.alpha.crash.dump;

import java.io.Serializable;
import java.util.List;

public final class LeakTrace implements Serializable {
    public final List<LeakTraceElement> elements;
    public final List<Reachability> expectedReachability;

    LeakTrace(List<LeakTraceElement> list, List<Reachability> list2) {
        this.elements = list;
        this.expectedReachability = list2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.elements.size(); i++) {
            LeakTraceElement leakTraceElement = this.elements.get(i);
            sb.append("* ");
            if (i != 0) {
                sb.append("↳ ");
            }
            Reachability reachability = this.expectedReachability.get(i);
            boolean z = true;
            if (reachability != Reachability.UNKNOWN && (reachability != Reachability.REACHABLE || (i < this.elements.size() - 1 && this.expectedReachability.get(i + 1) == Reachability.REACHABLE))) {
                z = false;
            }
            sb.append(leakTraceElement.toString(z));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toDetailedString() {
        String str = "";
        for (LeakTraceElement detailedString : this.elements) {
            str = str + detailedString.toDetailedString();
        }
        return str;
    }
}
