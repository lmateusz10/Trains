package pl.trains.services;

import pl.trains.model.Loco;

import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
public interface ILocoService {
    public void addLoco(Loco loco);

    public Loco getLocoById(Long id);

    public void removeLoco(Loco loco);

    public void removeLocoById(Long id);

    public List<Loco> getAllLocos();
}
