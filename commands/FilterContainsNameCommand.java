package Server.commands;

import Server.CollectionManager;

import java.io.Serializable;
/**
 * Класс реализующий команду filter_contains_name
 * Возвращает объекты значение поля name которых содержит заданную подстроку
 */
public class FilterContainsNameCommand implements Command, Serializable {
    CollectionManager cm;
    String nameParam;

    public FilterContainsNameCommand(CollectionManager cm, String nameParam){
        this.cm = cm;
        this.nameParam = nameParam;
    }

    public FilterContainsNameCommand(CollectionManager cm){
        this.cm = cm;
    }

    @Override
    public void setParamName(String nameParam) {
        this.nameParam = nameParam;
    }

    @Override
    public void execute() {
        cm.filterContainsName(nameParam);
    }

    @Override
    public String descr() {
        return "filter";
    }
}
