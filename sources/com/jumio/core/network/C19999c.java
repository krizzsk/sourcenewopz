package com.jumio.core.network;

import androidx.core.util.Pair;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.IOUtils;
import com.jumio.core.models.ApiCallDataModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jumio.core.C21351f;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.jumio.core.network.c */
/* compiled from: MultipartApiCall.kt */
public abstract class C19999c<T> extends ApiCall<T> {

    /* renamed from: d */
    public List<Pair<String[], Object>> f54910d = new ArrayList();

    /* renamed from: e */
    public final String f54911e = "--";

    /* renamed from: f */
    public final String f54912f = "\r\n";

    /* renamed from: g */
    public final String f54913g;

    /* renamed from: h */
    public final String f54914h;

    /* renamed from: i */
    public final String f54915i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19999c(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        String str = "+++Android_JMSDK_mobile_" + UUID.randomUUID() + "+++";
        this.f54913g = str;
        this.f54914h = "--" + str + "\r\n";
        this.f54915i = "--" + str + "--" + "\r\n";
    }

    public static /* synthetic */ void addPart$default(C19999c cVar, String[] strArr, Object obj, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            cVar.addPart(strArr, obj, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPart");
    }

    public final void addPart(String[] strArr, Object obj, int i) {
        Intrinsics.checkNotNullParameter(strArr, ErrorConst.ErrorParam.HEADERS);
        Intrinsics.checkNotNullParameter(obj, "data");
        boolean z = true;
        if (!(obj instanceof InputStream ? true : obj instanceof File ? true : obj instanceof String)) {
            z = obj instanceof byte[];
        }
        if (!z) {
            throw new Exception(Intrinsics.stringPlus(obj.getClass().getSimpleName(), " is not supported"));
        } else if (i == -1) {
            this.f54910d.add(new Pair(strArr, obj));
        } else {
            this.f54910d.add(i, new Pair(strArr, obj));
        }
    }

    public void fillRequest(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        for (Pair next : this.f54910d) {
            String str = this.f54914h;
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            if (str != null) {
                byte[] bytes = str.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                F f = next.first;
                Intrinsics.checkNotNullExpressionValue(f, "part.first");
                String[] strArr = (String[]) f;
                int i = 0;
                int length = strArr.length;
                while (i < length) {
                    String str2 = strArr[i];
                    i++;
                    Charset forName2 = Charset.forName("UTF-8");
                    Intrinsics.checkNotNullExpressionValue(forName2, "Charset.forName(charsetName)");
                    if (str2 != null) {
                        byte[] bytes2 = str2.getBytes(forName2);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream.write(bytes2);
                        String str3 = this.f54912f;
                        Charset forName3 = Charset.forName("UTF-8");
                        Intrinsics.checkNotNullExpressionValue(forName3, "Charset.forName(charsetName)");
                        if (str3 != null) {
                            byte[] bytes3 = str3.getBytes(forName3);
                            Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                            outputStream.write(bytes3);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String str4 = this.f54912f;
                Charset forName4 = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName4, "Charset.forName(charsetName)");
                if (str4 != null) {
                    byte[] bytes4 = str4.getBytes(forName4);
                    Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes4);
                    S s = next.second;
                    if (s instanceof InputStream) {
                        if (s != null) {
                            IOUtils.copy((InputStream) s, outputStream);
                            S s2 = next.second;
                            if (s2 != null) {
                                IOUtils.closeQuietly((InputStream) s2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.io.InputStream");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.io.InputStream");
                        }
                    } else if (s instanceof File) {
                        S s3 = next.second;
                        if (s3 != null) {
                            FileInputStream fileInputStream = new FileInputStream((File) s3);
                            IOUtils.copy(fileInputStream, outputStream);
                            IOUtils.closeQuietly(fileInputStream);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.io.File");
                        }
                    } else if (s instanceof String) {
                        if (s != null) {
                            Charset forName5 = Charset.forName("UTF-8");
                            Intrinsics.checkNotNullExpressionValue(forName5, "Charset.forName(charsetName)");
                            byte[] bytes5 = ((String) s).getBytes(forName5);
                            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
                            outputStream.write(bytes5);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (s instanceof byte[]) {
                        if (s != null) {
                            outputStream.write((byte[]) s);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                    }
                    String str5 = this.f54912f;
                    Charset forName6 = Charset.forName("UTF-8");
                    Intrinsics.checkNotNullExpressionValue(forName6, "Charset.forName(charsetName)");
                    if (str5 != null) {
                        byte[] bytes6 = str5.getBytes(forName6);
                        Intrinsics.checkNotNullExpressionValue(bytes6, "(this as java.lang.String).getBytes(charset)");
                        outputStream.write(bytes6);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        String str6 = this.f54915i;
        Charset forName7 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName7, "Charset.forName(charsetName)");
        if (str6 != null) {
            byte[] bytes7 = str6.getBytes(forName7);
            Intrinsics.checkNotNullExpressionValue(bytes7, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes7);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String getBoundary() {
        return this.f54913g;
    }

    public abstract void prepareData() throws Exception;

    public int prepareRequest() throws Exception {
        this.f54910d.clear();
        prepareData();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Pair next : this.f54910d) {
            int length = i + this.f54914h.length();
            sb.append(this.f54914h);
            F f = next.first;
            Intrinsics.checkNotNullExpressionValue(f, "part.first");
            String[] strArr = (String[]) f;
            int length2 = strArr.length;
            int i2 = 0;
            while (i2 < length2) {
                String str = strArr[i2];
                i2++;
                length = length + str.length() + this.f54912f.length();
                sb.append(str);
                sb.append(this.f54912f);
            }
            int length3 = length + this.f54912f.length();
            sb.append(this.f54912f);
            S s = next.second;
            if (s instanceof InputStream) {
                if (s != null) {
                    try {
                        length3 += ((InputStream) s).available();
                        sb.append("<InputStream>");
                    } catch (IOException e) {
                        Log.m39463e(this.TAG, (Throwable) e);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.io.InputStream");
                }
            } else if (s instanceof File) {
                if (s != null) {
                    length3 += (int) ((File) s).length();
                    sb.append("<File>");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File");
                }
            } else if (s instanceof String) {
                if (s != null) {
                    length3 += ((String) s).length();
                    S s2 = next.second;
                    if (s2 != null) {
                        sb.append((String) s2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (!(s instanceof byte[])) {
                continue;
            } else if (s != null) {
                length3 += ((byte[]) s).length;
                sb.append("<byte[]>");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
            }
            i = length3 + this.f54912f.length();
            sb.append(this.f54912f);
        }
        int length4 = i + this.f54915i.length();
        sb.append(this.f54915i);
        LogUtils.logServerRequest(getClass().getSimpleName(), sb.toString());
        return length4;
    }
}
