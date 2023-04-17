//Name = Youssef Wael Hamdy Ibrahim
//id = 2001430
import java.io.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            String fileName = args[0];//the file name of the ARXML file
            if (!fileName.endsWith(".arxml")){
                throw new NotVaildAutosarFileException("Wrong file extension the file extension needs to be of type .arxml");
            }
            //Get the input file
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            //Check if file was empty
            if(file.length()==0){
                throw new EmptyAutosarFileException("File is empty");
            }
            int input;
            StringBuilder s = new StringBuilder();
            while((input = inputStream.read()) != -1){
                s.append((char)input);
            }
            String data = s.toString();
            Scanner in = new Scanner(data);
            ArrayList<SortContianer> contianers = new ArrayList<>();
            while (in.hasNextLine()){
                String line = in.nextLine();
                if(line.contains("<CONTAINER")){
                    //to get the id of the container
                    String id = line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    //to get the short name tag and its contents
                    String shortName = in.nextLine();
                    String n = shortName.substring(shortName.indexOf(">")+1, shortName.indexOf("</"));
                    String longName = in.nextLine();
                    String l = longName.substring(longName.indexOf(">") + 1, longName.indexOf("</"));
                    SortContianer c = new SortContianer();
                    c.setLongNameTag(l);
                    c.setUuId(id);
                    c.setShortNameTag(n);
                    contianers.add(c);
                }

            }
            //to sort ArrayList containers
            Collections.sort(contianers);
            String outName = fileName.substring(0,fileName.indexOf(".")) + "_mod.arxml";
            FileOutputStream outputStream = new FileOutputStream(outName);
            //to write the onto the new arxml file
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());
            for (int i=0 ; i < contianers.size();i++)
            {
                outputStream.write(contianers.get(i).toString().getBytes());
            }
            outputStream.write("</AUTOSAR>".getBytes());
        }
        catch (NotVaildAutosarFileException e) {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e) {
            e = new FileNotFoundException("File not found");
        } catch (IOException e) {
            e = new IOException("IO Exception");
        }
        catch (EmptyAutosarFileException e){
            System.out.println((e.getMessage()));
        }
    }
}