package Server.commands;

import Server.CollectionManager;
/**
 * Класс реализующий команду exit
 * Прерывает работу программы
 */
public class ExitCommand implements Command{
    CollectionManager cm;

    public ExitCommand(CollectionManager cm){
        this.cm = cm;
    }

    @Override
    public void execute() {
        SaveCommand sv = new SaveCommand(cm);
        sv.execute();
        System.exit(0);
    }

    @Override
    public String descr() {
        return null;
    }
}
