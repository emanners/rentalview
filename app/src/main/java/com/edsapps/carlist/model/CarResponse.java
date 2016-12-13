
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarResponse {

    @SerializedName("VehAvailRSCore")
    @Expose
    private VehAvailRSCore vehAvailRSCore;

    /**
     *
     * @return
     *     The vehAvailRSCore
     */
    public VehAvailRSCore getVehAvailRSCore() {
        return vehAvailRSCore;
    }

    /**
     *
     * @param vehAvailRSCore
     *     The VehAvailRSCore
     */
    public void setVehAvailRSCore(VehAvailRSCore vehAvailRSCore) {
        this.vehAvailRSCore = vehAvailRSCore;
    }

}
