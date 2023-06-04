package Server.commands;

import java.io.Serializable;
/**
 * Интерфейс, который реализует все команды
 */
public interface Command extends Serializable {
    void execute();
    /**
     * Метод возвращающий описание команды
     */
    String descr();
    /**
     * Метод для задания параметров команды
     */
    default void setParamName(String param){};

}
