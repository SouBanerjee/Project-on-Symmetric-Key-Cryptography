package decrypt1;

import array.Array_int;
import array.Array_int_2d;
import binary_decimal_conversion.Binary_decimal;
import cryptographicInverseCalculator.InverseCalculator;
import decryptTimeMatrixHandler.MatrixHandler;
import transposition.DataTranspositionHandler;

import java.io.*;

/**
 * Created by ASUS on 09-03-2017.
 */
public class Init
{
    private String ct, sym, dpt, rnm;
    //private int index;

    public long take_input()
    {
        try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("\nEnter name of cipher text file : ");
            ct = r.readLine();
            System.out.print("\nEnter name of symmetric key file : ");
            sym = r.readLine();
        }catch(IOException e){
            System.out.println("\nUnable to read plain text file name");
            System.exit(-1);
        }
        //System.out.println("\nPlain text - "+pl);
        String s = copy_name();
        dpt = s + "_dpt.txt";
        rnm = s + "_dpt";
        file_create();
        return file_operation();
    }

    public long file_operation()
    {
        final long start = System.currentTimeMillis();
        Array_int input = new Array_int(8), one = new Array_int(8), two = new Array_int(8),
                keyByte = new Array_int(8), combine = new Array_int(16);
        Array_int_2d spiral = new Array_int_2d(4), newSpiral = new Array_int_2d(4);
        Decrypt ob1 = new Decrypt(); Binary_decimal ob2 = new Binary_decimal();
        InverseCalculator ob3 = new InverseCalculator();
        DataTranspositionHandler ob4 = new DataTranspositionHandler();
        MatrixHandler ob5 = new MatrixHandler();
        String extension = "";
        try(FileInputStream f1 = new FileInputStream(new File(ct));
                FileInputStream f2 = new FileInputStream(new File(sym));
                FileOutputStream f3 = new FileOutputStream(new File(dpt));)
        {
            int ch = -1, k = 0, j = -1;
            ch = f1.read();
            do
            {
                input.arr[k++] = ch;
                //System.out.println("\nCipher : "+input.arr[k - 1]+"\n");
                for(int i = 0; i < 7; i++)
                {
                    input.arr[k++] = f2.read();
                    //System.out.println("Sym - "+(i+1)+" : "+input.arr[k - 1]);
                }
                ob1.decrypt(one, two, keyByte, combine, input, ob2, ob3, ob4, ob5, spiral, newSpiral);
                k = 0;
                if((ch = f1.read()) == -1) // file size is odd
                {
                    if((char)input.arr[7] == 'O')
                    {
                        f3.write(input.arr[0]);
                        //System.out.println(input.arr[0]);
                    }
                    break;
                }
                else
                {
                    f3.write(input.arr[0]);
                    f3.write(input.arr[7]);
                }
            }while(true);
            while((ch = f2.read()) != -1)
            {
                extension += Character.toString((char)ch);
            }
        }catch(Exception e){
            System.out.println("\nError Code : "+e);
            System.exit(0);
        }
        rnm += extension;
        System.out.println("\nNew name : "+rnm);
        try{
            File f1 = new File(dpt);
            File f2 = new File(rnm);
            boolean flag = f1.renameTo(f2);
            if(flag == false)
                System.out.println("\nFile rename failed");
            else
                System.out.println("\nFile rename successfull");
        }catch(Exception e){
            System.out.println("\nError Code : "+e);
            System.exit(1);
        }
        return start;
    }

    public void file_create()
    {
        File f1 = new File(dpt);
        try{
            f1.createNewFile();
        }catch(Exception e){
            System.out.println("\n\nUnable to create file : "+dpt+"\n\nError Code : "+e+"\n");
            System.exit(0);
        }
    }

    public String copy_name()
    {
        int index = -1;
        for(int i = ct.length()-1; i >= 0; i--)
        {
            if(ct.charAt(i) == '_')
            {
                index = i;
                break;
            }
        }
        String s;
        if(index == -1)
            s = ct;
        else
            s = ct.substring(0, index);//excluding the last index
        //this.index = index;
        return s;
    }
}
