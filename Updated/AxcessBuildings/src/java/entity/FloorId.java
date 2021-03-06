package entity;
// Generated Jan 11, 2016 8:37:50 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FloorId generated by hbm2java
 */
@Embeddable
public class FloorId  implements java.io.Serializable {


     private int BId;
     private int floorNumber;

    public FloorId() {
    }

    public FloorId(int BId, int floorNumber) {
       this.BId = BId;
       this.floorNumber = floorNumber;
    }
   


    @Column(name="B_Id", nullable=false)
    public int getBId() {
        return this.BId;
    }
    
    public void setBId(int BId) {
        this.BId = BId;
    }


    @Column(name="floorNumber", nullable=false)
    public int getFloorNumber() {
        return this.floorNumber;
    }
    
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FloorId) ) return false;
		 FloorId castOther = ( FloorId ) other; 
         
		 return (this.getBId()==castOther.getBId())
 && (this.getFloorNumber()==castOther.getFloorNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getBId();
         result = 37 * result + this.getFloorNumber();
         return result;
   }   


}


