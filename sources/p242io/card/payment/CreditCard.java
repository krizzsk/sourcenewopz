package p242io.card.payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.cardscan.model.C15185a;
import com.didichuxing.cardscan.model.CardType;
import java.util.UUID;
import kotlin.text.Typography;

/* renamed from: io.card.payment.CreditCard */
public class CreditCard implements Parcelable {
    public static final Parcelable.Creator<CreditCard> CREATOR = new Parcelable.Creator<CreditCard>() {
        /* renamed from: a */
        public CreditCard createFromParcel(Parcel parcel) {
            return new CreditCard(parcel);
        }

        /* renamed from: a */
        public CreditCard[] newArray(int i) {
            return new CreditCard[i];
        }
    };
    public static final int EXPIRY_MAX_FUTURE_YEARS = 15;
    public String cardNumber;
    public String cardholderName;
    public String cvv;
    public int expiryMonth;
    public int expiryYear;
    public boolean flipped;
    public String postalCode;
    String scanId;
    public int[] xoff;
    public int yoff;

    public CreditCard() {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.xoff = new int[16];
        this.scanId = UUID.randomUUID().toString();
    }

    private CreditCard(Parcel parcel) {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.cardNumber = parcel.readString();
        this.expiryMonth = parcel.readInt();
        this.expiryYear = parcel.readInt();
        this.cvv = parcel.readString();
        this.postalCode = parcel.readString();
        this.cardholderName = parcel.readString();
        this.scanId = parcel.readString();
        this.yoff = parcel.readInt();
        this.xoff = parcel.createIntArray();
    }

    public CreditCard(String str, int i, int i2, String str2, String str3, String str4) {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.cardNumber = str;
        this.expiryMonth = i;
        this.expiryYear = i2;
        this.cvv = str2;
        this.postalCode = str3;
        this.cardholderName = str4;
    }

    public int describeContents() {
        return 0;
    }

    public CardType getCardType() {
        return CardType.fromCardNumber(this.cardNumber);
    }

    public String getFormattedCardNumber() {
        return C15185a.m33173a(this.cardNumber);
    }

    public String getLastFourDigitsOfCardNumber() {
        String str = this.cardNumber;
        if (str == null) {
            return "";
        }
        int min = Math.min(4, str.length());
        String str2 = this.cardNumber;
        return str2.substring(str2.length() - min);
    }

    public String getRedactedCardNumber() {
        String str = this.cardNumber;
        String str2 = "";
        if (str == null) {
            return str2;
        }
        if (str.length() > 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(String.format("%" + (this.cardNumber.length() - 4) + RavenKey.STACK, new Object[]{str2}).replace(' ', Typography.bullet));
            str2 = sb.toString();
        }
        return C15185a.m33174a(str2 + getLastFourDigitsOfCardNumber(), false, CardType.fromCardNumber(this.cardNumber));
    }

    public boolean isExpiryValid() {
        return C15185a.m33175a(this.expiryMonth, this.expiryYear);
    }

    public String toString() {
        String str = Const.joLeft + getCardType() + ": " + getRedactedCardNumber();
        if (this.expiryMonth > 0 || this.expiryYear > 0) {
            str = str + "  expiry:" + this.expiryMonth + "/" + this.expiryYear;
        }
        if (this.postalCode != null) {
            str = str + "  postalCode:" + this.postalCode;
        }
        if (this.cardholderName != null) {
            str = str + "  cardholderName:" + this.cardholderName;
        }
        if (this.cvv != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  cvvLength:");
            String str2 = this.cvv;
            sb.append(str2 != null ? str2.length() : 0);
            str = sb.toString();
        }
        return str + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cardNumber);
        parcel.writeInt(this.expiryMonth);
        parcel.writeInt(this.expiryYear);
        parcel.writeString(this.cvv);
        parcel.writeString(this.postalCode);
        parcel.writeString(this.cardholderName);
        parcel.writeString(this.scanId);
        parcel.writeInt(this.yoff);
        parcel.writeIntArray(this.xoff);
    }
}
