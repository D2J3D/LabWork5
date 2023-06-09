package Server.core;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.LinkedList;
/**
 * Коллекция объектов класса SpaceMarine
 */
public class SpaceMarines implements Serializable{
    private LinkedList<SpaceMarine> spaceMarine;
    /**
     * Дата создания коллекции
     */
    private final ZonedDateTime creationDate = ZonedDateTime.now();
    public SpaceMarines(){}
    public SpaceMarines(LinkedList<SpaceMarine> spaceMarine){
        this.spaceMarine = spaceMarine;
    }

    public LinkedList<SpaceMarine> getSpaceMarine() {
        return spaceMarine;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setSpaceMarine(LinkedList<SpaceMarine> spaceMarine) {
        this.spaceMarine = spaceMarine;
    }

}
