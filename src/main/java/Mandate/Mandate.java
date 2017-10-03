package Mandate;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Mandate {

    public Mandate(){
    }

    List<Position>positions;

    public class Position {

        @SerializedName("ebus_id")
        String ebus_id;
        @SerializedName("position_id")
        String position_id;
        @SerializedName("sort_criterion")
        int sort_criterion;

    }

}
