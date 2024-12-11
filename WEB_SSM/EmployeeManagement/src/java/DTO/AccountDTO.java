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
public class AccountDTO {
    private Integer accountID;
    private String accountName;
    private String accountPass;

    public AccountDTO() {
    }

    public AccountDTO(Integer accountID, String accountName, String accountPass) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPass = accountPass;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }
    
    
    
}
