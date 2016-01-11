/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ShaileshKushwaha
 */
public class AddressModel {

    private String address;
    private String city;
    private String state;
    private Integer zip;
    public AddressModel(){
        
    }
    public AddressModel(String address, String city, String state, Integer zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
