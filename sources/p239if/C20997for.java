package p239if;

import com.didi.unifylogin.utils.LoginOmegaUtil;

/* renamed from: if.for */
/* compiled from: ClaimType */
public enum C20997for {
    ENROL {
        public String toString() {
            return "enrol";
        }
    },
    VERIFY {
        public String toString() {
            return LoginOmegaUtil.NEED_VERIFY_EMAIL;
        }
    },
    ID_MATCH {
        public String toString() {
            return "id_match";
        }
    };

    /* renamed from: do */
    public static C20997for m41061do(String str) {
        for (C20997for forR : values()) {
            if (forR.name().equalsIgnoreCase(str)) {
                return forR;
            }
        }
        return VERIFY;
    }
}
