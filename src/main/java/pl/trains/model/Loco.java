package pl.trains.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 12.03.2017.
 */
@Entity
@Table(name = "locos")
@NamedQuery(name = "locos.findAll", query = "SELECT l FROM Loco l")
public class Loco implements Serializable{
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer maxSpeed;
    private String powerType;
    private Double weight;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "locos")
    private List<Train> trains;
    public List<Train> getTrains() {
        return trains;
    }
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Loco(){}

    public Loco(String name, Integer maxSpeed, String powerType, Double weight, List<Train> trains) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.powerType = powerType;
        this.weight = weight;
        this.trains = trains;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loco loco = (Loco) o;

        if (name != null ? !name.equals(loco.name) : loco.name != null) return false;
        if (maxSpeed != null ? !maxSpeed.equals(loco.maxSpeed) : loco.maxSpeed != null) return false;
        if (powerType != null ? !powerType.equals(loco.powerType) : loco.powerType != null) return false;
        return !(weight != null ? !weight.equals(loco.weight) : loco.weight != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (maxSpeed != null ? maxSpeed.hashCode() : 0);
        result = 31 * result + (powerType != null ? powerType.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
