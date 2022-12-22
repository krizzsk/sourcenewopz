package jumio.core;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.common.net.HttpHeaders;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALEHeader;
import com.jumio.ale.swig.ALEInputStream;
import com.jumio.ale.swig.ALEOutputStream;
import com.jumio.ale.swig.ALERequest;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.IOUtils;
import com.jumio.core.network.C19998b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/* renamed from: jumio.core.c */
/* compiled from: AleEncryptionProvider */
public class C21342c implements C19998b {

    /* renamed from: a */
    public final String f59599a;

    /* renamed from: b */
    public final ALECore f59600b;

    /* renamed from: c */
    public ALERequest f59601c;

    public C21342c(ALECore aLECore, String str) {
        this.f59599a = str;
        this.f59600b = aLECore;
    }

    /* renamed from: a */
    public OutputStream mo163034a(OutputStream outputStream, int i, String str) throws Exception {
        try {
            this.f59601c = this.f59600b.createRequest();
            Log.m39456d("AleEncryptionProvider", "encrypting plaintext");
            ALEHeader aLEHeader = new ALEHeader();
            if (str != null) {
                aLEHeader.add("Content-Type", "multipart/form-data; boundary=" + str);
            } else {
                aLEHeader.add("Content-Type", "application/json");
            }
            aLEHeader.add(HttpHeaders.AUTHORIZATION, this.f59599a);
            return new ALEOutputStream(new BufferedOutputStream(outputStream), this.f59601c, aLEHeader, i);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public String mo175785b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public String mo163035a(InputStream inputStream) throws C21339a0, C21380s0 {
        String str;
        Log.m39456d("AleEncryptionProvider", "decrypting response stream");
        ALEInputStream aLEInputStream = new ALEInputStream(new BufferedInputStream(inputStream), this.f59601c);
        try {
            str = mo175785b(aLEInputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("Response ");
            sb.append(this.f59601c.isVerified() ? "valid" : "invalid");
            Log.m39471v("Network/ALE", sb.toString());
            Log.m39471v("Network/ALE", "Errorcode " + this.f59601c.getErrorCode());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KeyUpdate ");
            sb2.append(this.f59601c.isKeyUpdate() ? "true" : SDKConsts.BOOLEAN_FALSE);
            Log.m39471v("Network/ALE", sb2.toString());
            IOUtils.closeQuietly(aLEInputStream);
        } catch (IOException unused) {
            IOUtils.closeQuietly(aLEInputStream);
            str = null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(aLEInputStream);
            throw th;
        }
        try {
            if (!this.f59601c.isVerified()) {
                if (this.f59601c.getErrorCode() != 0) {
                    throw new C21380s0(this.f59601c.getErrorCode(), "Response returned " + this.f59601c.getErrorCode());
                }
                throw new C21380s0(0, "Response not verified");
            } else if (!this.f59601c.isKeyUpdate()) {
                return str;
            } else {
                throw new C21345d("keyupdate - re-execute call!");
            }
        } finally {
            this.f59600b.destroyRequest(this.f59601c);
            this.f59601c = null;
        }
    }
}
