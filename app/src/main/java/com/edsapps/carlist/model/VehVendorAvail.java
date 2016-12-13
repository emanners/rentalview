
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehVendorAvail {

    @SerializedName("Vendor")
    @Expose
    private Vendor vendor;
    @SerializedName("VehAvails")
    @Expose
    private List<VehAvail> vehAvails = null;

    /**
     * 
     * @return
     *     The vendor
     */
    public Vendor getVendor() {
        return vendor;
    }

    /**
     * 
     * @param vendor
     *     The Vendor
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    /**
     * 
     * @return
     *     The vehAvails
     */
    public List<VehAvail> getVehAvails() {
        return vehAvails;
    }

    /**
     * 
     * @param vehAvails
     *     The VehAvails
     */
    public void setVehAvails(List<VehAvail> vehAvails) {
        this.vehAvails = vehAvails;
    }

}
