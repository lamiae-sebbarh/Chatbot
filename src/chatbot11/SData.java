package chatbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class SData extends FileController{
    
    private static final String DATABASE = "./data.txt";
    
   
    private RandomAccessFile fileReader;
    

    
    public SData() {
        super(DATABASE);
        try {
            fileReader = new RandomAccessFile(file, "r");
           
        } catch (FileNotFoundException e) {
             JOptionPane.showMessageDialog(
                null,
                "The translation database was not found",
                "Translation Database Error",
                JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
        }
    }
    
    public String translate(String word)
    {
        String translation = "ok";
        String savedword="";
        
        int counter=0, counter2=0;
 
        try
        {
            String line = fileReader.readLine();
            boolean meeting=false;
            while(line != null && meeting != true)
            {
                String[] doubl = line.split("#");
                String[] doubldos =word.split(" ");

                for (int i=0;i<=doubldos.length-1;i++){ 
                for(int j=0;j<=doubl.length-1;j++){
                if (doubldos[i].equalsIgnoreCase(doubl[j]))
                {
                translation = doubl[doubl.length-1];
                counter++;
                }
                }
                }
               if (counter>=counter2){
                   counter2=counter;
                   savedword=translation;
               }
                counter=0;
                line = fileReader.readLine();
            }
           //  System.out.println("palbra acumulada : "+ savedword);
        }

        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(
                null,
                "42/5000\n" +
"Error reading the word database",
                "Translation Database Error",
                JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }

        finally
        {
            try
            {
                fileReader.close();
            }

            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Error closing word database",
                    "Translation Database Error",
                    JOptionPane.ERROR_MESSAGE);
                ioe.printStackTrace();
            }
        }

        return savedword;
    }
   
    
}
