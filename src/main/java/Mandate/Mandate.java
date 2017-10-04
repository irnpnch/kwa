package Mandate;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Mandate {

    public Mandate(){
    }

    Position [] positions;
    String store_id;

    public class Position {

        @SerializedName("product_id")
        String product_id;
        @SerializedName("position_id")
        String position_id;
        @SerializedName("sort_criterion")
        int sort_criterion;

    }

}
