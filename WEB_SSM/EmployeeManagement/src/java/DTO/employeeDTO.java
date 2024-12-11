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
public class employeeDTO {

    private Integer employeeID;
    private String employeeName;
    private String positionID;
    private String phone;
    private String mail;
    private Long salary;
    private positionDTO position;

    public employeeDTO() {
    }

    public employeeDTO(Integer employeeID, String employeeName, String positionID, String phone, String mail, Long salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.positionID = positionID;
        this.phone = phone;
        this.mail = mail;
        this.salary = salary;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
