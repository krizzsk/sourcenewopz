package p239if;

/* renamed from: if.do */
/* compiled from: AssuranceType */
public enum C20994do {
    GENUINE_PRESENCE_ASSURANCE {
        public String toString() {
            return "genuine_presence";
        }
    },
    LIVENESS {
        public String toString() {
            return "liveness";
        }
    };

    /* renamed from: do */
    public static C20994do m41060do(String str) {
        if (str != null && !str.isEmpty()) {
            for (C20994do doVar : values()) {
                if (doVar.name().equalsIgnoreCase(str)) {
                    return doVar;
                }
            }
        }
        return null;
    }
}
