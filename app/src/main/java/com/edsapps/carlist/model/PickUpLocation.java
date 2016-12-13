
package com.edsapps.carlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickUpLocation {

    @SerializedName("@Name")
    @Expose
    private String name;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The @Name
     */
    public void setName(String name) {
        this.name = name;
    }

}
