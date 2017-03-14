package pl.trains.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 12.03.2017.
 */
@Entity
@Table(name = "locos")
public class Loco implements Serializable{
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer maxSpeed;
    private String powerType;
    private Double weight;
    @ManyToMany(mappedBy = "locos")
    private List<Train> trains;
    public List<Train> getTrains() {
        return trains;
    }
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Loco(){}

    public Loco(String name, Integer maxSpeed, String powerType, Double weight) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.powerType = powerType;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Loco{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", powerType='" + powerType + '\'' +
                ", weight=" + weight +
                ", trains=" + trains +
                '}';
    }
}
