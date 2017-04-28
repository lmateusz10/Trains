package pl.trains.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
@Entity
@Table(name = "wagons")
@NamedQuery(name = "Wagons.findAll", query = "SELECT w FROM Wagon w")
public class Wagon implements Serializable{
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String type;
    private String producer;
    private String owner;
    private String seatingAreas;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "wagons")
    @JsonBackReference
    private List<Train> trains;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Wagon(){}

    public Wagon(String mark, String type, String producer, String owner, String seatingAreas, List<Train> trains) {
        this.mark = mark;
        this.type = type;
        this.producer = producer;
        this.owner = owner;
        this.seatingAreas = seatingAreas;
        this.trains = trains;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSeatingAreas() {
        return seatingAreas;
    }

    public void setSeatingAreas(String seatingAreas) {
        this.seatingAreas = seatingAreas;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", owner='" + owner + '\'' +
                ", seatingAreas='" + seatingAreas + '\'' +
                ", trains=" + trains +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wagon wagon = (Wagon) o;

        if (mark != null ? !mark.equals(wagon.mark) : wagon.mark != null) return false;
        if (type != null ? !type.equals(wagon.type) : wagon.type != null) return false;
        if (producer != null ? !producer.equals(wagon.producer) : wagon.producer != null) return false;
        if (owner != null ? !owner.equals(wagon.owner) : wagon.owner != null) return false;
        return !(seatingAreas != null ? !seatingAreas.equals(wagon.seatingAreas) : wagon.seatingAreas != null);

    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (seatingAreas != null ? seatingAreas.hashCode() : 0);
        return result;
    }
}
