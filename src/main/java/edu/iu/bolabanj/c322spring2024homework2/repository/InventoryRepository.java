package edu.iu.bolabanj.c322spring2024homework2.respository;

import edu.iu.bolabanj.c322spring2024homework2.model.Guitar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InventoryRepository {
    public final String  DATABASE_NAME = "guitars.txt";
    public void addGuitar(Guitar guitar) throws IOException{


        File file = new File(DATABASE_NAME);
        try(PrintWriter printWriter = new PrintWriter(file)){
            printWriter.println(guitar.getSerialNumber() + "," + guitar.getPrice() + "," + guitar.getBuilder() + "," + guitar.getModel() + "," + guitar.getType() + "," + guitar.getBackWood() + "," + guitar.getTopWood());


        }
        catch(Exception e ){
            throw new IOException();
        }


    }
    public Guitar getGuitar(String serialNumber){
        //need to read the guitars.txt file and return the guitar object
        Path path = Paths.get(DATABASE_NAME);
        File file = new File(String.valueOf(path));
        ArrayList<Guitar> guitars = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] guitar = line.split(",");
                Guitar guitar1 = new Guitar(guitar[0], Double.parseDouble(guitar[1]), guitar[2], guitar[3], guitar[4], guitar[5], guitar[6]);
                guitars.add(guitar1);
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
        for(Guitar guitar : guitars){
            if(guitar.getSerialNumber().equals(serialNumber)){
                return guitar;
            }
        }
        return null;



    }
    public List<Guitar> search(Guitar guitar){
        Path path = Paths.get(DATABASE_NAME);
        File file = new File(String.valueOf(path));
        ArrayList<Guitar> guitars = new ArrayList<>();
        ArrayList<Guitar> result = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] guitar1 = line.split(",");
                Guitar guitar2 = new Guitar(guitar1[0], Double.parseDouble(guitar1[1]), guitar1[2], guitar1[3], guitar1[4], guitar1[5], guitar1[6]);
                guitars.add(guitar2);
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
        for(Guitar guitar1 : guitars){
            if(guitar1.getSerialNumber().equals(guitar.getSerialNumber()) || guitar1.getPrice() == guitar.getPrice() || guitar1.getBuilder().equals(guitar.getBuilder()) || guitar1.getModel().equals(guitar.getModel()) || guitar1.getType().equals(guitar.getType()) || guitar1.getBackWood().equals(guitar.getBackWood()) || guitar1.getTopWood().equals(guitar.getTopWood())){
                result.add(guitar1);
            }
        }
        return result;
    }




}
