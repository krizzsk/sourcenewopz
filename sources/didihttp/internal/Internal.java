package didihttp.internal;

import didihttp.Address;
import didihttp.Call;
import didihttp.ConnectionPool;
import didihttp.ConnectionSpec;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.HttpUrl;
import didihttp.Request;
import didihttp.Response;
import didihttp.internal.cache.InternalCache;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.RouteDatabase;
import didihttp.internal.connection.StreamAllocation;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;

public abstract class Internal {
    public static Internal instance;

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException;

    public abstract Call newWebSocketCall(DidiHttpClient didiHttpClient, Request request);

    public abstract void put(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase routeDatabase(ConnectionPool connectionPool);

    public abstract void setCache(DidiHttpClient.Builder builder, InternalCache internalCache);

    public abstract StreamAllocation streamAllocation(Call call);

    public static void initializeInstanceForTests() {
        new DidiHttpClient();
    }
}
