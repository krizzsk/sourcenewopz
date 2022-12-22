package diditransreq;

import didihttp.Headers;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.internal.http.RealResponseBody;
import diditransreq.p231pb.ReqPack;
import diditransreq.p231pb.TransHttpRsp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;

/* renamed from: diditransreq.a */
/* compiled from: Convert */
class C20808a {
    C20808a() {
    }

    /* renamed from: a */
    public static ReqPack m40998a(Request request) throws IOException {
        ReqPack.Builder builder = new ReqPack.Builder();
        builder.url(request.url().toString()).method(request.method()).header(m40999a(request.headers()));
        if (request.body() != null) {
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            builder.body(buffer.readByteString());
        }
        return builder.build();
    }

    /* renamed from: a */
    public static Response m40997a(Request request, TransHttpRsp transHttpRsp) {
        Response.Builder builder = new Response.Builder();
        builder.protocol(Protocol.HTTP_1_1);
        builder.request(request);
        builder.code(transHttpRsp.f57194sc.intValue());
        if (transHttpRsp.header == null || transHttpRsp.body == null) {
            return null;
        }
        Headers.Builder builder2 = new Headers.Builder();
        for (String add : transHttpRsp.header) {
            builder2.add(add);
        }
        Headers build = builder2.build();
        builder.headers(build);
        builder.body(new RealResponseBody(build, new Buffer().write(transHttpRsp.body.toByteArray())));
        return builder.build();
    }

    /* renamed from: a */
    private static List<String> m40999a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        if (headers != null) {
            for (int i = 0; i < headers.size(); i++) {
                arrayList.add(headers.name(i) + ": " + headers.value(i));
            }
        }
        return arrayList;
    }
}
