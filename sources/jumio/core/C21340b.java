package jumio.core;

import android.location.Address;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.util.ArrayList;

@PersistWith("AddressModel")
/* renamed from: jumio.core.b */
/* compiled from: AddressModel */
public class C21340b implements StaticModel {

    /* renamed from: a */
    public ArrayList<String> f59592a;

    /* renamed from: b */
    public String f59593b;

    /* renamed from: c */
    public String f59594c;

    /* renamed from: d */
    public String f59595d;

    /* renamed from: a */
    public void mo175781a(Address address) {
        address.getLocale();
        address.getFeatureName();
        this.f59592a = new ArrayList<>();
        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            this.f59592a.add(address.getAddressLine(i));
        }
        this.f59593b = address.getAdminArea();
        address.getSubAdminArea();
        address.getLocality();
        address.getSubLocality();
        address.getThoroughfare();
        address.getSubThoroughfare();
        address.getPremises();
        this.f59594c = address.getPostalCode();
        this.f59595d = address.getCountryCode();
        address.getCountryName();
        address.getLatitude();
        address.getLongitude();
        address.getPhone();
        address.getUrl();
    }

    /* renamed from: b */
    public String mo175782b() {
        return this.f59593b;
    }

    /* renamed from: c */
    public String mo175783c() {
        return this.f59595d;
    }

    /* renamed from: d */
    public String mo175784d() {
        return this.f59594c;
    }

    /* renamed from: a */
    public ArrayList<String> mo175780a() {
        return this.f59592a;
    }
}
