
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehAvail {

    @SerializedName("@Status")
    @Expose
    private String status;
    @SerializedName("Vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("TotalCharge")
    @Expose
    private TotalCharge totalCharge;

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The @Status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * 
     * @param vehicle
     *     The Vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * 
     * @return
     *     The totalCharge
     */
    public TotalCharge getTotalCharge() {
        return totalCharge;
    }

    /**
     * 
     * @param totalCharge
     *     The TotalCharge
     */
    public void setTotalCharge(TotalCharge totalCharge) {
        this.totalCharge = totalCharge;
    }

}
