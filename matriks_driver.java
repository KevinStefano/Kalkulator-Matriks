import matriks.java;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


class matriks_driver
{
    public static void main (String[] args)
            {
                        int brs,kol;
                        Scanner sc = new Scanner(System.in); 
                        System.out.println("Baris :");
                        brs = sc.nextInt();
                        System.out.println("Kolom :");
                        kol = sc.nextInt();
                        matriks M = new matriks ();
                                
                    
                    M.BacaMATRIKS(brs,kol);
                    System.out.println(M.DeterminanKofaktor(M));
                    M.BacaMATRIKSAug(brs,kol);
                    M.CramerSPL(M);
                    
                    M.InverseSPL(M);
                /* M.InverseSPL(M);
                    M.InversMatriks(M); */
                    /*M.GaussSPL();
                    M.TulisMATRIKSAug();*/
                    M.DeterminanGaussJordan(M);
                    M.SolusiSPL(M);
                    sc.close();
        }
}