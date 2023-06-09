package Server.commands;

import Server.CollectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс реализующий команду execute_script
 */
public class ExecuteScriptCommand implements Command, Serializable {
    CollectionManager cm;

    File file;

    public ExecuteScriptCommand(CollectionManager cm){
        this.cm = cm;
    }

    @Override
    public void execute() {
        Map<String, Command> commandList = new HashMap<>();
        commandList.put("show", new ShowCommand(this.cm));
        commandList.put("info", new InfoCommand(this.cm));
        commandList.put("help", new HelpCommand(this.cm));
        commandList.put("add", new AddCommand(this.cm));
        commandList.put("update", new UpdateIdCommand(this.cm));
        commandList.put("remove_by_id", new RemoveById(this.cm));
        commandList.put("clear", new ClearCommand(this.cm));
        commandList.put("save", new SaveCommand(this.cm));
        commandList.put("execute_script", new ExecuteScriptCommand(this.cm));
        commandList.put("add_if_max", new AddIfMaxCommand(this.cm));
        commandList.put("remove_greater", new RemoveGreaterCommand(this.cm));
        commandList.put("remove_lower", new RemoveLowerCommand(this.cm));
        commandList.put("remove_all_by_chapter", new RemoveAllByChapter(this.cm));
        commandList.put("filter_contains_name" , new FilterContainsNameCommand(this.cm));
        commandList.put("print_unique_chapter", new PrintUniqueChapter(this.cm));
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String l = sc.nextLine();
                String[] parts = l.split(" ");
                if (parts[0].equals("exit")){
                    System.out.println("exit...");
                    break;
                }
                if (commandList.containsKey(parts[0])){
                    System.out.println("Found new command: " + parts[0]);
                    Command command = commandList.get(parts[0]);
                    if (parts.length > 1){
                        command.setParamName(parts[1]);
                        if (parts[0].equals("execute_script") && (parts[1].equals(file.getName()))){
                            continue;
                        } else{
                            System.out.println("Server's response:\n----------------------------------------");
                            command.execute();
                            System.out.println("----------------------------------------\n");
                        }
                    } else{
                        System.out.println("Server's response:\n----------------------------------------");
                        command.execute();
                        System.out.println("----------------------------------------\n");
                    }
                } else{
                    System.out.println("No sush command as " + parts[0]);
                }

            }
        } catch(FileNotFoundException e){
            System.out.println(e + "!");
        }
    }

    @Override
    public String descr() {
        return null;
    }

    @Override
    public void setParamName(String fileName) {
        this.file = new File(fileName); //TODO try...catch
    }
}
