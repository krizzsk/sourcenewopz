package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.didi.beatles.p099im.views.bottombar.IMSkinTextView;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpg {
    public final zzdoy zzeuy;
    public final List<zzdot> zzhnq;
    public final List<zzdpf> zzhnr;

    public static zzdpg zza(Reader reader) throws zzdox {
        try {
            zzdpg zzdpg = new zzdpg(new JsonReader(reader));
            IOUtils.closeQuietly((Closeable) reader);
            return zzdpg;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzdox("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }

    private zzdpg(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzdot> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzdoy zzdoy = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzdot(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals(IMSkinTextView.IM_SKIN_COMMON)) {
                        zzdoy = new zzdoy(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            jSONObject = zzbh.zzc(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzdpf(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzhnr = arrayList;
        this.zzhnq = emptyList;
        this.zzeuy = zzdoy == null ? new zzdoy(new JsonReader(new StringReader("{}"))) : zzdoy;
    }
}
