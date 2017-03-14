package pl.trains.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
@Entity
@Table(name = "trains")
public class Train implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String trainName;;
    @ManyToMany
    @JoinTable(name = "trains_wagons",
    joinColumns = { @JoinColumn(name = "train_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "wagon_id", referencedColumnName = "id")})
    private List<Wagon> wagons;

    @ManyToMany
    @JoinTable(name = "trains_locos",
    joinColumns = {@JoinColumn(name = "train_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "loco_id", referencedColumnName = "id")})
    private List<Loco> locos;


    public List<Loco> getLoco() {
        return locos;
    }

    public void setLoco(List<Loco> loco) {
        this.locos = locos;
    }



    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }


    public Train(){}

    public Train(String trainName, List<Wagon> wagons, List<Loco> locos) {
        this.trainName = trainName;
        this.wagons = wagons;
        this.locos = locos;
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

}
