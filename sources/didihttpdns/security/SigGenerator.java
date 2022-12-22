package didihttpdns.security;

import java.util.Map;

public interface SigGenerator {
    String genSig(Map<String, String> map);
}
