package fileComparatorModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by ASUS on 11-03-2017.
 */
public class Comparator
{
    private String base, decrypt;

    public void takeInput()
    {
        try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in));)
        {
            System.out.print("\nEnter original plain text file name : ");
            base = r.readLine();
            System.out.print("\nEnter decrypted plain text file name : ");
            decrypt = r.readLine();
        }catch(Exception e)
        {
            System.out.println("\nError Code : "+e);
            System.exit(-1);
        }
        compareModule();
    }

    public void compareModule()
    {
        try(FileInputStream f1 = new FileInputStream(new File(base));
        FileInputStream f2 = new FileInputStream(new File(decrypt));)
        {
            int ch1 = -1, ch2 = -1;
            boolean flag = true;
            while(true)
            {
                ch1 = f1.read();
                ch2 = f2.read();
                if(ch1 == ch2)
                {
                    if(ch1 == -1 && ch2 == -1)
                        break;
                    else
                        continue;
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                System.out.println("\nBoth files are same\n");
            else
                System.out.println("\nFiles are different\n");
        }catch(Exception e)
        {
            System.out.println("\nError Code : "+e);
            System.exit(-2);
        }
    }
}
