
package chatbot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Read {
    File file = new File("data.txt");
    public String readtxt(String direccion){
        String text="";
        try {
            BufferedReader bf=new BufferedReader(new FileReader(direccion));
            String temporal="";
            String bfread;
            while ((bfread=bf.readLine()) !=null){
                temporal=temporal+bfread+"\r\n";
            }
            text=temporal;
        } catch (Exception e) {
        }
        return text;
    }
    public String newask(String ask,String answer){
        
        
        String newword="";
        String[] doubl3=ask.split(" ");
       System.out.println(doubl3[0]);
        for (int i=0;i<=doubl3.length-1;i++){
            if(i==doubl3.length-1){
                 newword=newword+doubl3[i]+"#"+doubl3[i]+"?"+"#"+answer;
            }else if (doubl3[i].equalsIgnoreCase("that")|| doubl3[i].equalsIgnoreCase("is")||doubl3[i].equalsIgnoreCase("a")||doubl3[i].equalsIgnoreCase("of")||doubl3[i].equalsIgnoreCase("me")){
                continue;
            }else {
            newword=newword+doubl3[i]+"#";}
        }
        System.out.println(newword);
       // palabra.guardar(palabra.leertxt("fileName1.txt"), nuevaPalabra);
        return newword;
    }
    public void save(String contentTxt, String newword){
        try {
		if(!file.exists()) {
				file.createNewFile();	
		}
		
		PrintWriter pw = new PrintWriter(file);
               // pw.write(leertxt("fileName1.txt"));
                //String palabra=leertxt("fileName1.txt");
                pw.append(contentTxt + newword);
                
               // pw.append(leertxt("fileName1.txt"))
		
                
		pw.close();
		System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

   
}

