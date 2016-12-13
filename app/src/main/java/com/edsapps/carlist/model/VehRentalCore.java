
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehRentalCore {

    @SerializedName("@PickUpDateTime")
    @Expose
    private String pickUpDateTime;
    @SerializedName("@ReturnDateTime")
    @Expose
    private String returnDateTime;
    @SerializedName("PickUpLocation")
    @Expose
    private PickUpLocation pickUpLocation;
    @SerializedName("ReturnLocation")
    @Expose
    private ReturnLocation returnLocation;

    /**
     * 
     * @return
     *     The pickUpDateTime
     */
    public String getPickUpDateTime() {
        return pickUpDateTime;
    }

    /**
     * 
     * @param pickUpDateTime
     *     The @PickUpDateTime
     */
    public void setPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    /**
     * 
     * @return
     *     The returnDateTime
     */
    public String getReturnDateTime() {
        return returnDateTime;
    }

    /**
     * 
     * @param returnDateTime
     *     The @ReturnDateTime
     */
    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    /**
     * 
     * @return
     *     The pickUpLocation
     */
    public PickUpLocation getPickUpLocation() {
        return pickUpLocation;
    }

    /**
     * 
     * @param pickUpLocation
     *     The PickUpLocation
     */
    public void setPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    /**
     * 
     * @return
     *     The returnLocation
     */
    public ReturnLocation getReturnLocation() {
        return returnLocation;
    }

    /**
     * 
     * @param returnLocation
     *     The ReturnLocation
     */
    public void setReturnLocation(ReturnLocation returnLocation) {
        this.returnLocation = returnLocation;
    }

}
