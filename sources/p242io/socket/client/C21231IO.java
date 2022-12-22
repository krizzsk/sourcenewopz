package p242io.socket.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;
import p242io.socket.client.Manager;

/* renamed from: io.socket.client.IO */
public class C21231IO {

    /* renamed from: a */
    private static final Logger f59496a = Logger.getLogger(C21231IO.class.getName());

    /* renamed from: b */
    private static final ConcurrentHashMap<String, Manager> f59497b = new ConcurrentHashMap<>();
    public static int protocol = 4;

    /* renamed from: io.socket.client.IO$Options */
    public static class Options extends Manager.Options {
        public boolean forceNew;
        public boolean multiplex = true;
    }

    public static void setDefaultOkHttpWebSocketFactory(WebSocket.Factory factory) {
        Manager.f59498a = factory;
    }

    public static void setDefaultOkHttpCallFactory(Call.Factory factory) {
        Manager.f59499b = factory;
    }

    private C21231IO() {
    }

    public static Socket socket(String str) throws URISyntaxException {
        return socket(str, (Options) null);
    }

    public static Socket socket(String str, Options options) throws URISyntaxException {
        return socket(new URI(str), options);
    }

    public static Socket socket(URI uri) {
        return socket(uri, (Options) null);
    }

    public static Socket socket(URI uri, Options options) {
        Manager manager;
        if (options == null) {
            options = new Options();
        }
        URL parse = Url.parse(uri);
        try {
            URI uri2 = parse.toURI();
            String extractId = Url.extractId(parse);
            if (options.forceNew || !options.multiplex || (f59497b.containsKey(extractId) && f59497b.get(extractId).f59503e.containsKey(parse.getPath()))) {
                if (f59496a.isLoggable(Level.FINE)) {
                    f59496a.fine(String.format("ignoring socket cache for %s", new Object[]{uri2}));
                }
                manager = new Manager(uri2, options);
            } else {
                if (!f59497b.containsKey(extractId)) {
                    if (f59496a.isLoggable(Level.FINE)) {
                        f59496a.fine(String.format("new io instance for %s", new Object[]{uri2}));
                    }
                    f59497b.putIfAbsent(extractId, new Manager(uri2, options));
                }
                manager = f59497b.get(extractId);
            }
            String query = parse.getQuery();
            if (query != null && (options.query == null || options.query.isEmpty())) {
                options.query = query;
            }
            return manager.socket(parse.getPath(), options);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
