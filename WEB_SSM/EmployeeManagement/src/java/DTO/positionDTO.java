/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ngoct
 */
public class positionDTO {

    private String positionID;
    private String positionName;

    public positionDTO() {
    }

    public positionDTO(String positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
