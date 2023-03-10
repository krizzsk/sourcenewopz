package org.webrtc;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.List;

public class MediaConstraints {
    public final List<KeyValuePair> mandatory = new ArrayList();
    public final List<KeyValuePair> optional = new ArrayList();

    public static class KeyValuePair {
        private final String key;
        private final String value;

        public KeyValuePair(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return this.key + ": " + this.value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            KeyValuePair keyValuePair = (KeyValuePair) obj;
            if (!this.key.equals(keyValuePair.key) || !this.value.equals(keyValuePair.value)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.key.hashCode() + this.value.hashCode();
        }
    }

    private static String stringifyKeyValuePairList(List<KeyValuePair> list) {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        for (KeyValuePair next : list) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(next.toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public String toString() {
        return "mandatory: " + stringifyKeyValuePairList(this.mandatory) + ", optional: " + stringifyKeyValuePairList(this.optional);
    }

    /* access modifiers changed from: package-private */
    public List<KeyValuePair> getMandatory() {
        return this.mandatory;
    }

    /* access modifiers changed from: package-private */
    public List<KeyValuePair> getOptional() {
        return this.optional;
    }
}
