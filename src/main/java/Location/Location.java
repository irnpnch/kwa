package Location;

import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue()
    private Long id;
    @SerializedName("store_id")
    private String store_id;
    @SerializedName("product_id")
    private String product_id;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("warengruppe")
    private String warengruppe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getWarengruppe() {
        return warengruppe;
    }

    public void setWarengruppe(String warengruppe) {
        this.warengruppe = warengruppe;
    }

    public String toString() {
        return this.id + " " + this.store_id + " " + this.product_id + " " + this.lat + " " + this.lng + " " + this.warengruppe;
    }

    public void recalcCenter() {

        LocationDAO lDao = new LocationDAOImpl();
        Location formerLocation = lDao.getLocation(this.product_id, this.store_id);
        if (formerLocation != null) {
            this.lat = getMean(this.lat, formerLocation.lat);
            this.lng = getMean(this.lng, formerLocation.lng);
        }

    }

    private String getMean(String currentS, String formerS) {
        System.out.println("("+Double.parseDouble(currentS) +"+" +Double.parseDouble(formerS)+")/2");
        Double result = (Double.parseDouble(currentS) + Double.parseDouble(formerS)) / 2;
        return result.toString();

    }
}
