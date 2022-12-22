package didihttpdns.log;

import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didinet.Logger;
import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        long nanoTime = System.nanoTime();
        Request request = chain.request();
        Logger.m40928d("HttpDnsManager", String.format("[query] Sending request %s", new Object[]{request.url().toString()}));
        try {
            Response proceed = chain.proceed(request);
            Logger.m40928d("HttpDnsManager", String.format("[query] Received response for %s in %.1fms%n%s", new Object[]{request.url(), Double.valueOf(((double) (System.nanoTime() - nanoTime)) / 1000000.0d), proceed.headers()}));
            return proceed;
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
