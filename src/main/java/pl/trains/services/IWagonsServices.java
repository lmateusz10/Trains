package pl.trains.services;

import pl.trains.model.Wagon;

import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
public interface IWagonsServices {
    public void addWagon(Wagon wagon);
    public Wagon getWagonById(Long id);
    public List<Wagon> getAllWagons();
    public void removeWagon(Wagon wagon);
    public void removeWagonById(Long id);
}
