package org.bouncycastle.asn1.x500.style;

import com.facebook.appevents.UserDataStore;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

public class RFC4519Style extends AbstractX500NameStyle {
    private static final Hashtable DefaultLookUp = new Hashtable();
    private static final Hashtable DefaultSymbols = new Hashtable();
    public static final X500NameStyle INSTANCE = new RFC4519Style();
    public static final ASN1ObjectIdentifier businessCategory = new ASN1ObjectIdentifier("2.5.4.15").intern();

    /* renamed from: c */
    public static final ASN1ObjectIdentifier f5682c = new ASN1ObjectIdentifier("2.5.4.6").intern();

    /* renamed from: cn */
    public static final ASN1ObjectIdentifier f5683cn = new ASN1ObjectIdentifier("2.5.4.3").intern();

    /* renamed from: dc */
    public static final ASN1ObjectIdentifier f5684dc = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").intern();
    public static final ASN1ObjectIdentifier description = new ASN1ObjectIdentifier("2.5.4.13").intern();
    public static final ASN1ObjectIdentifier destinationIndicator = new ASN1ObjectIdentifier("2.5.4.27").intern();
    public static final ASN1ObjectIdentifier distinguishedName = new ASN1ObjectIdentifier("2.5.4.49").intern();
    public static final ASN1ObjectIdentifier dnQualifier = new ASN1ObjectIdentifier("2.5.4.46").intern();
    public static final ASN1ObjectIdentifier enhancedSearchGuide = new ASN1ObjectIdentifier("2.5.4.47").intern();
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber = new ASN1ObjectIdentifier("2.5.4.23").intern();
    public static final ASN1ObjectIdentifier generationQualifier = new ASN1ObjectIdentifier("2.5.4.44").intern();
    public static final ASN1ObjectIdentifier givenName = new ASN1ObjectIdentifier("2.5.4.42").intern();
    public static final ASN1ObjectIdentifier houseIdentifier = new ASN1ObjectIdentifier("2.5.4.51").intern();
    public static final ASN1ObjectIdentifier initials = new ASN1ObjectIdentifier("2.5.4.43").intern();
    public static final ASN1ObjectIdentifier internationalISDNNumber = new ASN1ObjectIdentifier("2.5.4.25").intern();

    /* renamed from: l */
    public static final ASN1ObjectIdentifier f5685l = new ASN1ObjectIdentifier("2.5.4.7").intern();
    public static final ASN1ObjectIdentifier member = new ASN1ObjectIdentifier("2.5.4.31").intern();
    public static final ASN1ObjectIdentifier name = new ASN1ObjectIdentifier("2.5.4.41").intern();

    /* renamed from: o */
    public static final ASN1ObjectIdentifier f5686o = new ASN1ObjectIdentifier("2.5.4.10").intern();

    /* renamed from: ou */
    public static final ASN1ObjectIdentifier f5687ou = new ASN1ObjectIdentifier("2.5.4.11").intern();
    public static final ASN1ObjectIdentifier owner = new ASN1ObjectIdentifier("2.5.4.32").intern();
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName = new ASN1ObjectIdentifier("2.5.4.19").intern();
    public static final ASN1ObjectIdentifier postOfficeBox = new ASN1ObjectIdentifier("2.5.4.18").intern();
    public static final ASN1ObjectIdentifier postalAddress = new ASN1ObjectIdentifier("2.5.4.16").intern();
    public static final ASN1ObjectIdentifier postalCode = new ASN1ObjectIdentifier("2.5.4.17").intern();
    public static final ASN1ObjectIdentifier preferredDeliveryMethod = new ASN1ObjectIdentifier("2.5.4.28").intern();
    public static final ASN1ObjectIdentifier registeredAddress = new ASN1ObjectIdentifier("2.5.4.26").intern();
    public static final ASN1ObjectIdentifier roleOccupant = new ASN1ObjectIdentifier("2.5.4.33").intern();
    public static final ASN1ObjectIdentifier searchGuide = new ASN1ObjectIdentifier("2.5.4.14").intern();
    public static final ASN1ObjectIdentifier seeAlso = new ASN1ObjectIdentifier("2.5.4.34").intern();
    public static final ASN1ObjectIdentifier serialNumber = new ASN1ObjectIdentifier("2.5.4.5").intern();

    /* renamed from: sn */
    public static final ASN1ObjectIdentifier f5688sn = new ASN1ObjectIdentifier("2.5.4.4").intern();

    /* renamed from: st */
    public static final ASN1ObjectIdentifier f5689st = new ASN1ObjectIdentifier("2.5.4.8").intern();
    public static final ASN1ObjectIdentifier street = new ASN1ObjectIdentifier("2.5.4.9").intern();
    public static final ASN1ObjectIdentifier telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20").intern();
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier = new ASN1ObjectIdentifier("2.5.4.22").intern();
    public static final ASN1ObjectIdentifier telexNumber = new ASN1ObjectIdentifier("2.5.4.21").intern();
    public static final ASN1ObjectIdentifier title = new ASN1ObjectIdentifier("2.5.4.12").intern();
    public static final ASN1ObjectIdentifier uid = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").intern();
    public static final ASN1ObjectIdentifier uniqueMember = new ASN1ObjectIdentifier("2.5.4.50").intern();
    public static final ASN1ObjectIdentifier userPassword = new ASN1ObjectIdentifier("2.5.4.35").intern();
    public static final ASN1ObjectIdentifier x121Address = new ASN1ObjectIdentifier("2.5.4.24").intern();
    public static final ASN1ObjectIdentifier x500UniqueIdentifier = new ASN1ObjectIdentifier("2.5.4.45").intern();
    protected final Hashtable defaultLookUp = copyHashTable(DefaultLookUp);
    protected final Hashtable defaultSymbols = copyHashTable(DefaultSymbols);

    static {
        DefaultSymbols.put(businessCategory, "businessCategory");
        DefaultSymbols.put(f5682c, "c");
        DefaultSymbols.put(f5683cn, "cn");
        DefaultSymbols.put(f5684dc, "dc");
        DefaultSymbols.put(description, "description");
        DefaultSymbols.put(destinationIndicator, "destinationIndicator");
        DefaultSymbols.put(distinguishedName, "distinguishedName");
        DefaultSymbols.put(dnQualifier, "dnQualifier");
        DefaultSymbols.put(enhancedSearchGuide, "enhancedSearchGuide");
        DefaultSymbols.put(facsimileTelephoneNumber, "facsimileTelephoneNumber");
        DefaultSymbols.put(generationQualifier, "generationQualifier");
        DefaultSymbols.put(givenName, "givenName");
        DefaultSymbols.put(houseIdentifier, "houseIdentifier");
        DefaultSymbols.put(initials, "initials");
        DefaultSymbols.put(internationalISDNNumber, "internationalISDNNumber");
        DefaultSymbols.put(f5685l, "l");
        DefaultSymbols.put(member, "member");
        DefaultSymbols.put(name, "name");
        DefaultSymbols.put(f5686o, "o");
        DefaultSymbols.put(f5687ou, "ou");
        DefaultSymbols.put(owner, "owner");
        DefaultSymbols.put(physicalDeliveryOfficeName, "physicalDeliveryOfficeName");
        DefaultSymbols.put(postalAddress, "postalAddress");
        DefaultSymbols.put(postalCode, "postalCode");
        DefaultSymbols.put(postOfficeBox, "postOfficeBox");
        DefaultSymbols.put(preferredDeliveryMethod, "preferredDeliveryMethod");
        DefaultSymbols.put(registeredAddress, "registeredAddress");
        DefaultSymbols.put(roleOccupant, "roleOccupant");
        DefaultSymbols.put(searchGuide, "searchGuide");
        DefaultSymbols.put(seeAlso, "seeAlso");
        DefaultSymbols.put(serialNumber, "serialNumber");
        DefaultSymbols.put(f5688sn, "sn");
        DefaultSymbols.put(f5689st, UserDataStore.STATE);
        DefaultSymbols.put(street, "street");
        DefaultSymbols.put(telephoneNumber, "telephoneNumber");
        DefaultSymbols.put(teletexTerminalIdentifier, "teletexTerminalIdentifier");
        DefaultSymbols.put(telexNumber, "telexNumber");
        DefaultSymbols.put(title, "title");
        DefaultSymbols.put(uid, "uid");
        DefaultSymbols.put(uniqueMember, "uniqueMember");
        DefaultSymbols.put(userPassword, "userPassword");
        DefaultSymbols.put(x121Address, "x121Address");
        DefaultSymbols.put(x500UniqueIdentifier, "x500UniqueIdentifier");
        DefaultLookUp.put("businesscategory", businessCategory);
        DefaultLookUp.put("c", f5682c);
        DefaultLookUp.put("cn", f5683cn);
        DefaultLookUp.put("dc", f5684dc);
        DefaultLookUp.put("description", description);
        DefaultLookUp.put("destinationindicator", destinationIndicator);
        DefaultLookUp.put("distinguishedname", distinguishedName);
        DefaultLookUp.put("dnqualifier", dnQualifier);
        DefaultLookUp.put("enhancedsearchguide", enhancedSearchGuide);
        DefaultLookUp.put("facsimiletelephonenumber", facsimileTelephoneNumber);
        DefaultLookUp.put("generationqualifier", generationQualifier);
        DefaultLookUp.put("givenname", givenName);
        DefaultLookUp.put("houseidentifier", houseIdentifier);
        DefaultLookUp.put("initials", initials);
        DefaultLookUp.put("internationalisdnnumber", internationalISDNNumber);
        DefaultLookUp.put("l", f5685l);
        DefaultLookUp.put("member", member);
        DefaultLookUp.put("name", name);
        DefaultLookUp.put("o", f5686o);
        DefaultLookUp.put("ou", f5687ou);
        DefaultLookUp.put("owner", owner);
        DefaultLookUp.put("physicaldeliveryofficename", physicalDeliveryOfficeName);
        DefaultLookUp.put("postaladdress", postalAddress);
        DefaultLookUp.put("postalcode", postalCode);
        DefaultLookUp.put("postofficebox", postOfficeBox);
        DefaultLookUp.put("preferreddeliverymethod", preferredDeliveryMethod);
        DefaultLookUp.put("registeredaddress", registeredAddress);
        DefaultLookUp.put("roleoccupant", roleOccupant);
        DefaultLookUp.put("searchguide", searchGuide);
        DefaultLookUp.put("seealso", seeAlso);
        DefaultLookUp.put("serialnumber", serialNumber);
        DefaultLookUp.put("sn", f5688sn);
        DefaultLookUp.put(UserDataStore.STATE, f5689st);
        DefaultLookUp.put("street", street);
        DefaultLookUp.put("telephonenumber", telephoneNumber);
        DefaultLookUp.put("teletexterminalidentifier", teletexTerminalIdentifier);
        DefaultLookUp.put("telexnumber", telexNumber);
        DefaultLookUp.put("title", title);
        DefaultLookUp.put("uid", uid);
        DefaultLookUp.put("uniquemember", uniqueMember);
        DefaultLookUp.put("userpassword", userPassword);
        DefaultLookUp.put("x121address", x121Address);
        DefaultLookUp.put("x500uniqueidentifier", x500UniqueIdentifier);
    }

    protected RFC4519Style() {
    }

    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    /* access modifiers changed from: protected */
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return aSN1ObjectIdentifier.equals((ASN1Primitive) f5684dc) ? new DERIA5String(str) : (aSN1ObjectIdentifier.equals((ASN1Primitive) f5682c) || aSN1ObjectIdentifier.equals((ASN1Primitive) serialNumber) || aSN1ObjectIdentifier.equals((ASN1Primitive) dnQualifier) || aSN1ObjectIdentifier.equals((ASN1Primitive) telephoneNumber)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    public RDN[] fromString(String str) {
        RDN[] rDNsFromString = IETFUtils.rDNsFromString(str, this);
        int length = rDNsFromString.length;
        RDN[] rdnArr = new RDN[length];
        for (int i = 0; i != rDNsFromString.length; i++) {
            rdnArr[(length - i) - 1] = rDNsFromString[i];
        }
        return rdnArr;
    }

    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) DefaultSymbols.get(aSN1ObjectIdentifier);
    }

    public String toString(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int length = rDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, rDNs[length], this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}
