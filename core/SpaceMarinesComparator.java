package Server.core;

import java.util.Comparator;
/**
 * Comparator для объектов класса SpaceMarine
 */
public class SpaceMarinesComparator implements Comparator<SpaceMarine> {
    @Override
    public int compare(SpaceMarine o1, SpaceMarine o2) {
        return Float.compare(o1.getHealth(), o2.getHealth());
    }
}
