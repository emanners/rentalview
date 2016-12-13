package com.edsapps.carlist.model;

/**
 * Created by Ed on 07/12/2016.
 */

public class VehVendorDTO {
    private Vendor vendor;
    private VehAvail vendorAvail;

    public String getVehVendorId() {
        return vehVendorId;
    }

    public void setVehVendorId(String vehVendorId) {
        this.vehVendorId = vehVendorId;
    }

    private String vehVendorId;

    public VehVendorDTO(String vehVendorId, Vendor vendor, VehAvail part) {
        setVendor(vendor);
        setVendorAvail(part);
        setVehVendorId(vehVendorId);
    }

    public VehAvail getVendorAvail() {
        return vendorAvail;
    }

    public void setVendorAvail(VehAvail vendorAvail) {
        this.vendorAvail = vendorAvail;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
