package didihttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface Dns {
    public static final Dns SYSTEM = new Dns() {
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (str != null) {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null) {
                    return Arrays.asList(allByName);
                }
                return Collections.emptyList();
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
