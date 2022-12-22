package p242io.socket.client;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rui.config.RConfigConstants;

/* renamed from: io.socket.client.Url */
public class Url {

    /* renamed from: a */
    private static Pattern f59533a = Pattern.compile("^http|ws$");

    /* renamed from: b */
    private static Pattern f59534b = Pattern.compile("^(http|ws)s$");

    /* renamed from: c */
    private static Pattern f59535c = Pattern.compile("^(.*@)?([^:]+)(:\\d+)?$");

    private Url() {
    }

    public static URL parse(String str) throws URISyntaxException {
        return parse(new URI(str));
    }

    public static URL parse(URI uri) {
        String str;
        String str2;
        String str3;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if (f59533a.matcher(scheme).matches()) {
                port = 80;
            } else if (f59534b.matcher(scheme).matches()) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        String host = uri.getHost();
        if (host == null) {
            host = m42028a(uri.getRawAuthority());
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme);
            sb.append(HWMapConstant.HTTP.SEPARATOR);
            String str4 = "";
            if (rawUserInfo != null) {
                str = rawUserInfo + "@";
            } else {
                str = str4;
            }
            sb.append(str);
            sb.append(host);
            if (port != -1) {
                str2 = ":" + port;
            } else {
                str2 = str4;
            }
            sb.append(str2);
            sb.append(rawPath);
            if (rawQuery != null) {
                str3 = "?" + rawQuery;
            } else {
                str3 = str4;
            }
            sb.append(str3);
            if (rawFragment != null) {
                str4 = RConfigConstants.KEYWORD_COLOR_SIGN + rawFragment;
            }
            sb.append(str4);
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractId(String str) throws MalformedURLException {
        return extractId(new URL(str));
    }

    public static String extractId(URL url) {
        String protocol = url.getProtocol();
        int port = url.getPort();
        if (port == -1) {
            if (f59533a.matcher(protocol).matches()) {
                port = 80;
            } else if (f59534b.matcher(protocol).matches()) {
                port = 443;
            }
        }
        return protocol + HWMapConstant.HTTP.SEPARATOR + url.getHost() + ":" + port;
    }

    /* renamed from: a */
    private static String m42028a(String str) {
        if (str != null) {
            Matcher matcher = f59535c.matcher(str);
            if (matcher.matches()) {
                return matcher.group(2);
            }
            throw new RuntimeException("unable to parse the host from the authority");
        }
        throw new RuntimeException("unable to parse the host from the authority");
    }
}
