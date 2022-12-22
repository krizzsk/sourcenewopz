package com.didi.entrega.customer.foundation.map.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.sdk.poibase.model.poi.GeoFence;

public class AddressModel implements Parcelable {
    public static final Parcelable.Creator<AddressModel> CREATOR = new Parcelable.Creator<AddressModel>() {
        public AddressModel createFromParcel(Parcel parcel) {
            return new AddressModel(parcel);
        }

        public AddressModel[] newArray(int i) {
            return new AddressModel[i];
        }
    };
    public String address;
    public String canonicalCountryCode;
    public String city;
    public int cityId = 0;
    public String countryCode;
    public String countryId;
    public String countryName;
    public String displayName;
    public GeoFence geoFence;
    public String[] geofence;
    public String language;
    public double latitude;
    public double longitude;
    public String poi_id;

    public int describeContents() {
        return 0;
    }

    public AddressModel() {
    }

    protected AddressModel(Parcel parcel) {
        this.displayName = parcel.readString();
        this.address = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.city = parcel.readString();
        this.cityId = parcel.readInt();
        this.countryId = parcel.readString();
        this.countryCode = parcel.readString();
        this.canonicalCountryCode = parcel.readString();
        this.countryName = parcel.readString();
        this.poi_id = parcel.readString();
        this.geofence = parcel.createStringArray();
        this.language = parcel.readString();
    }

    public static boolean validateCityId(AddressModel addressModel) {
        return addressModel != null && addressModel.cityId > 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.displayName);
        parcel.writeString(this.address);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.city);
        parcel.writeInt(this.cityId);
        parcel.writeString(this.countryId);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.canonicalCountryCode);
        parcel.writeString(this.countryName);
        parcel.writeString(this.poi_id);
        parcel.writeStringArray(this.geofence);
        parcel.writeString(this.language);
    }
}
