package adyen.com.adyencse.pojo;

import adyen.com.adyencse.encrypter.ClientSideEncrypter;
import adyen.com.adyencse.encrypter.exception.EncrypterException;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.didi.sdk.apm.SystemUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class Card {

    /* renamed from: a */
    private static final String f43a = Card.class.getSimpleName();

    /* renamed from: b */
    private String f44b;

    /* renamed from: c */
    private String f45c;

    /* renamed from: d */
    private String f46d;

    /* renamed from: e */
    private String f47e;

    /* renamed from: f */
    private String f48f;

    /* renamed from: g */
    private Date f49g;

    public String getNumber() {
        return this.f44b;
    }

    public void setNumber(String str) {
        this.f44b = str;
    }

    public String getExpiryMonth() {
        return this.f45c;
    }

    public void setExpiryMonth(String str) {
        this.f45c = str;
    }

    public String getExpiryYear() {
        return this.f46d;
    }

    public void setExpiryYear(String str) {
        this.f46d = str;
    }

    public String getCardHolderName() {
        return this.f47e;
    }

    public void setCardHolderName(String str) {
        this.f47e = str;
    }

    public String getCvc() {
        return this.f48f;
    }

    public void setCvc(String str) {
        this.f48f = str;
    }

    public Date getGenerationTime() {
        return this.f49g;
    }

    public void setGenerationTime(Date date) {
        this.f49g = date;
    }

    public String serialize(String str) throws EncrypterException {
        JSONObject jSONObject = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LogGenerator.ISO_8601);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            jSONObject.put("generationtime", simpleDateFormat.format(this.f49g));
            jSONObject.put("number", this.f44b);
            jSONObject.put("holderName", this.f47e);
            jSONObject.put("cvc", this.f48f);
            jSONObject.put("expiryMonth", this.f45c);
            jSONObject.put("expiryYear", this.f46d);
            return m76a(jSONObject.toString(), str);
        } catch (JSONException e) {
            JSONException jSONException = e;
            SystemUtils.log(6, f43a, jSONException.getMessage(), jSONException, "adyen.com.adyencse.pojo.Card", 98);
            return null;
        }
    }

    /* renamed from: a */
    private String m76a(String str, String str2) throws EncrypterException {
        try {
            return new ClientSideEncrypter(str2).encrypt(str);
        } catch (EncrypterException e) {
            throw e;
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LogGenerator.ISO_8601);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            jSONObject.put("generationtime", simpleDateFormat.format(this.f49g));
            if (this.f44b.length() >= 4) {
                jSONObject.put("number", this.f44b.substring(0, 3));
            }
            jSONObject.put("holderName", this.f47e);
        } catch (JSONException e) {
            JSONException jSONException = e;
            SystemUtils.log(6, f43a, jSONException.getMessage(), jSONException, "adyen.com.adyencse.pojo.Card", 133);
        }
        return jSONObject.toString();
    }
}
