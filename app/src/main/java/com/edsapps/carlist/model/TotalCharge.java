
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalCharge {

    @SerializedName("@RateTotalAmount")
    @Expose
    private String rateTotalAmount;
    @SerializedName("@EstimatedTotalAmount")
    @Expose
    private String estimatedTotalAmount;
    @SerializedName("@CurrencyCode")
    @Expose
    private String currencyCode;

    /**
     * 
     * @return
     *     The rateTotalAmount
     */
    public String getRateTotalAmount() {
        return rateTotalAmount;
    }

    /**
     * 
     * @param rateTotalAmount
     *     The @RateTotalAmount
     */
    public void setRateTotalAmount(String rateTotalAmount) {
        this.rateTotalAmount = rateTotalAmount;
    }

    /**
     * 
     * @return
     *     The estimatedTotalAmount
     */
    public String getEstimatedTotalAmount() {
        return estimatedTotalAmount;
    }

    /**
     * 
     * @param estimatedTotalAmount
     *     The @EstimatedTotalAmount
     */
    public void setEstimatedTotalAmount(String estimatedTotalAmount) {
        this.estimatedTotalAmount = estimatedTotalAmount;
    }

    /**
     * 
     * @return
     *     The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 
     * @param currencyCode
     *     The @CurrencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
