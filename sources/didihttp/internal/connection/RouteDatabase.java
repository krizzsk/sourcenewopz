package didihttp.internal.connection;

import didihttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f56668a = new LinkedHashSet();

    public synchronized void failed(Route route) {
        this.f56668a.add(route);
    }

    public synchronized void connected(Route route) {
        this.f56668a.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f56668a.contains(route);
    }
}
