package Location;

import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.Table;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location implements Serializable {

    public Location() {
    }

    @Id
    @GeneratedValue()
    private Long id;

    @SerializedName("store_id")
    private String store_id;
    @SerializedName("ebus_id")
    private String ebus_id;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("warengruppe")
    private String warengruppe;

    public String toString(){
        return this.id +" "+ this.store_id +" "+ this.ebus_id +" "+ this.lat +" "+ this.lng +" "+ this.warengruppe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
