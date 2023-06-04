package Server;

import Server.commands.Command;
import Server.core.SpaceMarine;
import Server.core.SpaceMarines;
import Server.core.SpaceMarinesComparator;
import Server.parser.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Console {
    public static void main(String[] args) throws FileNotFoundException {
        Reader rd = new Reader(new File("C:\\Users\\real_\\IdeaProjects\\SimpleServer\\src\\main\\java\\Server\\parser\\data.xml"));
        SpaceMarines sps = rd.getPersons();
        Stream<SpaceMarine> helpStream = sps.getSpaceMarine().stream();
        sps = new SpaceMarines(helpStream.sorted(new SpaceMarinesComparator()).collect(Collectors.toCollection(LinkedList::new)));
        CollectionManager cm = new CollectionManager(sps);
        ServerInvoker si = new ServerInvoker(cm);
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать! Введите -help, чтобы узнать о возможностях программы");
        while (sc.hasNext()){
            String[] userInput = sc.nextLine().split(" ");
            String commandName = userInput[0];
            String commandParam = null;
            if (userInput.length == 2){
                commandParam  = userInput[1];
            }
            Command command = si.formCommand(commandName, commandParam);
            System.out.println("================================");
            command.execute();
            System.out.println("================================");

        }
    }
}
