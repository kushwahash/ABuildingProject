package entity;
// Generated Jan 11, 2016 8:37:50 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Building generated by hbm2java
 */
@Entity
@Table(name="building"
    ,catalog="buildings_schema"
)
public class Building  implements java.io.Serializable {


     private Integer BId;
     private String name;
     private String address;
     private String city;
     private String state;
     private Integer zip;

    public Building() {
    }

	
    public Building(String name) {
        this.name = name;
    }
    public Building(String name, String address, String city, String state, Integer zip) {
       this.name = name;
       this.address = address;
       this.city = city;
       this.state = state;
       this.zip = zip;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="B_Id", unique=true, nullable=false)
    public Integer getBId() {
        return this.BId;
    }
    
    public void setBId(Integer BId) {
        this.BId = BId;
    }

    
    @Column(name="Name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Address", length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="City", length=30)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="State", length=25)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="Zip")
    public Integer getZip() {
        return this.zip;
    }
    
    public void setZip(Integer zip) {
        this.zip = zip;
    }




}


