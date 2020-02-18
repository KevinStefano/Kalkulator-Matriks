import java.io.FileWriter;  

public static void PrintWriter() throws IOException
{
    String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
     
    FileWriter fileWriter = new FileWriter("samplefile3.txt");
    PrintWriter printWriter = new PrintWriter("samplefile3.txt");
    printWriter.print("samplefile3.txt");
    printWriter.printf("Blog name is %s", "howtodoinjava.com");
    printWriter.close();
}