
package chatbot;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class FileController
{
    public File file;
    public FileController(String fileName)
    {
        file = new File(fileName);
    }
    public FileController(File file)
    {
        this.file = file;
    }

     public String getFileContent()
    {
        StringBuilder fileContent = new StringBuilder();
        try
        {
            RandomAccessFile fileReader = new RandomAccessFile(file, "r");
            String line = fileReader.readLine();

            while (line != null)
            {
                fileContent.append("\n").append(line);
                line = fileReader.readLine();
            }

        }
        catch (FileNotFoundException fne)
        {
            JOptionPane.showMessageDialog(
                null,
               "The file does not exists",
"ERROR IN FILE",
                JOptionPane.ERROR_MESSAGE);
            fne.printStackTrace();
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(
                null,
                "Error reading file",
                "ERROR IN FILE",
                JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }

        return fileContent.toString();
    }

    public void save(String fileContent)
    {
        try
        {
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.println(fileContent);
            printStream.flush();
            printStream.close();
        }
        catch (FileNotFoundException fne)
        {
            JOptionPane.showMessageDialog(
                null,
                "The file does not exists",
"ERROR IN FILE",
                JOptionPane.ERROR_MESSAGE);
            fne.printStackTrace();
        }
    }
}