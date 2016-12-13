
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("@AirConditionInd")
    @Expose
    private String airConditionInd;
    @SerializedName("@TransmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("@FuelType")
    @Expose
    private String fuelType;
    @SerializedName("@DriveType")
    @Expose
    private String driveType;
    @SerializedName("@PassengerQuantity")
    @Expose
    private String passengerQuantity;
    @SerializedName("@BaggageQuantity")
    @Expose
    private String baggageQuantity;
    @SerializedName("@Code")
    @Expose
    private String code;
    @SerializedName("@CodeContext")
    @Expose
    private String codeContext;
    @SerializedName("@DoorCount")
    @Expose
    private String doorCount;
    @SerializedName("VehMakeModel")
    @Expose
    private VehMakeModel vehMakeModel;
    @SerializedName("PictureURL")
    @Expose
    private String pictureURL;
    @SerializedName("@Size")
    @Expose
    private String size;

    /**
     * 
     * @return
     *     The airConditionInd
     */
    public String getAirConditionInd() {
        return airConditionInd;
    }

    /**
     * 
     * @param airConditionInd
     *     The @AirConditionInd
     */
    public void setAirConditionInd(String airConditionInd) {
        this.airConditionInd = airConditionInd;
    }

    /**
     * 
     * @return
     *     The transmissionType
     */
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     * 
     * @param transmissionType
     *     The @TransmissionType
     */
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    /**
     * 
     * @return
     *     The fuelType
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * 
     * @param fuelType
     *     The @FuelType
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * 
     * @return
     *     The driveType
     */
    public String getDriveType() {
        return driveType;
    }

    /**
     * 
     * @param driveType
     *     The @DriveType
     */
    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    /**
     * 
     * @return
     *     The passengerQuantity
     */
    public String getPassengerQuantity() {
        return passengerQuantity;
    }

    /**
     * 
     * @param passengerQuantity
     *     The @PassengerQuantity
     */
    public void setPassengerQuantity(String passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }

    /**
     * 
     * @return
     *     The baggageQuantity
     */
    public String getBaggageQuantity() {
        return baggageQuantity;
    }

    /**
     * 
     * @param baggageQuantity
     *     The @BaggageQuantity
     */
    public void setBaggageQuantity(String baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The @Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The codeContext
     */
    public String getCodeContext() {
        return codeContext;
    }

    /**
     * 
     * @param codeContext
     *     The @CodeContext
     */
    public void setCodeContext(String codeContext) {
        this.codeContext = codeContext;
    }

    /**
     * 
     * @return
     *     The doorCount
     */
    public String getDoorCount() {
        return doorCount;
    }

    /**
     * 
     * @param doorCount
     *     The @DoorCount
     */
    public void setDoorCount(String doorCount) {
        this.doorCount = doorCount;
    }

    /**
     * 
     * @return
     *     The vehMakeModel
     */
    public VehMakeModel getVehMakeModel() {
        return vehMakeModel;
    }

    /**
     * 
     * @param vehMakeModel
     *     The VehMakeModel
     */
    public void setVehMakeModel(VehMakeModel vehMakeModel) {
        this.vehMakeModel = vehMakeModel;
    }

    /**
     * 
     * @return
     *     The pictureURL
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * 
     * @param pictureURL
     *     The PictureURL
     */
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    /**
     * 
     * @return
     *     The size
     */
    public String getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The @Size
     */
    public void setSize(String size) {
        this.size = size;
    }

}
