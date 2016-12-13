
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehAvailRSCore {

    @SerializedName("VehRentalCore")
    @Expose
    private VehRentalCore vehRentalCore;
    @SerializedName("VehVendorAvails")
    @Expose
    private List<VehVendorAvail> vehVendorAvails = null;

    /**
     * 
     * @return
     *     The vehRentalCore
     */
    public VehRentalCore getVehRentalCore() {
        return vehRentalCore;
    }

    /**
     * 
     * @param vehRentalCore
     *     The VehRentalCore
     */
    public void setVehRentalCore(VehRentalCore vehRentalCore) {
        this.vehRentalCore = vehRentalCore;
    }

    /**
     * 
     * @return
     *     The vehVendorAvails
     */
    public List<VehVendorAvail> getVehVendorAvails() {
        return vehVendorAvails;
    }

    /**
     * 
     * @param vehVendorAvails
     *     The VehVendorAvails
     */
    public void setVehVendorAvails(List<VehVendorAvail> vehVendorAvails) {
        this.vehVendorAvails = vehVendorAvails;
    }

}
