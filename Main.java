package DSProjectThree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        CSVParser parser = new CSVParser("input.csv");
        parser.parse();
        
        FamilyTree ft = new FamilyTree();
        ft.initialize(parser.results);
        
        ft.makeQuery("STEFFON BARATHEON", "STANNIS BARATHEON");
        ft.makeQuery("SELYSE BARATHEON", "SHIREEN BARATHEON");
        ft.makeQuery("SELYSE BARATHEON", "TOMMEN BARATHEON");
        ft.makeQuery("GENDRY", "SHIREEN BARATHEON");
        ft.makeQuery("GENDRY", "STEFFON BARATHEON");
        ft.makeQuery("CASSANA ESTERMONT", "GENDRY");
        ft.makeQuery("SHIREEN BARATHEON", "CASSANA ESTERMONT");
        ft.makeQuery("ROBERT BARATHEON", "CERSEI LANNISTER");
        ft.makeQuery("SELYSE BARATHEON", "STANNIS BARATHEON");
        ft.makeQuery("ROBERT BARATHEON", "SHIREEN BARATHEON");
        ft.makeQuery("SELYSE BARATHEON", "GENDRY");
        ft.makeQuery("SHIREEN BARATHEON", "RENLY BARATHEON");
        ft.makeQuery("GENDRY", "STANNIS BARATHEON");
        ft.makeQuery("SHIREEN BARATHEON", "GENDRY");
        
        Scanner sc = new Scanner(System.in);    
        System.out.println("Type first person's full name: ");  
        String firstPerson = sc.nextLine();
        System.out.println("Type second person's full name: ");
        String secondPerson = sc.nextLine();

        ft.makeQuery(firstPerson, secondPerson);
        
    }
}
