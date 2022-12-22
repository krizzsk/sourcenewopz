package didihttpdns.security;

import didihttp.DidiHttpClient;
import didihttp.Interceptor;

public interface InterceptorGetter {
    Interceptor get(DidiHttpClient didiHttpClient);
}
