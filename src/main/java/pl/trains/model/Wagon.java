package pl.trains.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mateusz on 28.02.2017.
 */
@Entity
@Table(name = "wagons")
public class Wagon implements Serializable{
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String mark;
    private String type;
    private String producer;
    private String owner;
    private String seatingAreas;
    private String quantity;

    @ManyToMany(mappedBy = "wagons")
    private List<Train> trains;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }



    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Wagon(){}

    public Wagon(String mark, String type, String producer, String owner, String seatingAreas, String quantity) {
        this.mark = mark;
        this.type = type;
        this.producer = producer;
        this.owner = owner;
        this.seatingAreas = seatingAreas;
        this.quantity = quantity;
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
}
