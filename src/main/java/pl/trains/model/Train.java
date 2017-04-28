package pl.trains.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz on 28.02.2017.
 */
@Entity
@Table(name = "trains")
public class Train implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainName;
    private String trainNumber;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "trains_wagons",
            joinColumns = {@JoinColumn(name = "train_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "wagon_id", referencedColumnName = "id")})
    private List<Wagon> wagons;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "trains_locos",
            joinColumns = {@JoinColumn(name = "train_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "loco_id", referencedColumnName = "id")})

    private Set<Loco> locos;

    public Set<Loco> getLocos() {
        return locos;
    }

    public void setLocos(Set<Loco> locos) {
        this.locos = locos;
    }


    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }


    public Train() {
    }

    public Train(String trainName, String trainNumber, List<Wagon> wagons, Set<Loco> locos) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.wagons = wagons;
        this.locos = locos;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (trainName != null ? !trainName.equals(train.trainName) : train.trainName != null) return false;
        return !(trainNumber != null ? !trainNumber.equals(train.trainNumber) : train.trainNumber != null);

    }

    @Override
    public int hashCode() {
        int result = trainName != null ? trainName.hashCode() : 0;
        result = 31 * result + (trainNumber != null ? trainNumber.hashCode() : 0);
        return result;
    }
}
