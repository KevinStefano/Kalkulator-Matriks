package com.dev2qa.java.basic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class matriks
{
        try
        {
            // Save original out stream.
            PrintStream originalOut = System.out;
            // Save original err stream.
            PrintStream originalErr = System.err;

            // Create a new file output stream.
            PrintStream fileOut = new PrintStream("out.txt");
            // Create a new file error stream. 
            PrintStream fileErr = new PrintStream("./err.txt");

            // Redirect standard out to file.
            System.setOut(fileOut);
            // Redirect standard err to file.
            System.setErr(fileErr);

            // Wrapped Scanner to get user input.
        Scanner sc = new Scanner(System.in); 
        
        public int NBrsEff;
        public int NKolEff;
        float[][]mem= new float[50][50];

        public static final int barmax = 50;
        public static final int kolmax = 50;

        void MakeMATRIKS (int NB, int NK)
        /* Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran NB x NK di "ujung kiri" memori */
        /* I.S. NB dan NK adalah valid untuk memori matriks yang dibuat */
        /* F.S. Matriks M sesuai dengan definisi di atas terbentuk */
        {
        this.NBrsEff= NB;
        this.NKolEff = NK;
        }


        boolean IsIdxValid (int i, int j)
        /* Mengirimkan true jika i, j adalah indeks yang valid untuk matriks apa pun */
        {
        return ((i>=1 && i<=barmax)&&(j>=1 && j<=kolmax));
        }

       
        boolean IsIdxEff (int i, int j)
        /* Mengirimkan true jika i, j adalah indeks efektif bagi M */
        {
        return ((i>=1)&&(i<=NBrsEff)&&(j>=1)&&(j<=NKolEff));
        }
      

        void BacaMATRIKS (int NB, int NK)
        /* I.S. IsIdxValid(NB,NK) */
        /* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
        /* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
        /* Selanjutnya membaca nilai elemen per baris dan kolom */
        /* Contoh: Jika NB = 3 dan NK = 3, maka contoh cara membaca isi matriks :
        1 2 3
        4 5 6
        8 9 10
        */
        {
        MakeMATRIKS(NB,NK);
        int i,j;
        for (i=1;i<=NBrsEff;i++)
        {
                for (j=1;j<=NKolEff;j++)
                {
                mem[i][j]=sc.nextInt();
                }
        }
        
        }

        void BacaMATRIKSAug (int NBAug, int NKAug)
        /* I.S. IsIdxValid(NB,NK) */
        /* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
        /* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
        /* Selanjutnya membaca nilai elemen per baris dan kolom */
        /* Contoh: Jika NB = 3 dan NK = 3, maka contoh cara membaca isi matriks :
        1 2 3
        4 5 6
        8 9 10
        */
        {
        MakeMATRIKS(NBAug,NKAug-1);
        int i,j;
        for (i=1;i<=NBAug;i++)
        {
                for (j=1;j<=NKAug;j++)
                {
                mem[i][j]=sc.nextInt();
                }
        }
        
        }

        void TulisMATRIKS() {
                MakeMATRIKS(NBrsEff,NKolEff);
		System.out.println("\nMatriksnya adalah :");
		for(int i=1; i <=NBrsEff; i++) {
			for(int j=1; j <=NKolEff; j++) {
                                if (mem[i][j]==-0)
                                {
                                        mem[i][j]=mem[i][j]+0;
                                }
				System.out.print("\t" + mem[i][j]);
			}
			System.out.println();
		}
        }
        
        void TulisMATRIKSAug() {
		System.out.println("\nMatriksnya adalah :");
		for(int i=1; i <=NBrsEff; i++) {
			for(int j=1; j <=NKolEff+1; j++) {
                                if (mem[i][j]==-0)
                                {
                                        mem[i][j]=mem[i][j]+0;
                                }
				System.out.print("\t" + mem[i][j]);
			}
			System.out.println();
		}
        }
/*   
        void SolusiSPL (int NBrsAug, int NKolAug) 
         Kol masukan adalah kolom AUGMENTED 
        {
                int i,j;
                char[] alph = new char[]{'t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
                String[] solSPL= new String[NKolAug-1];
                for (i=NBrsAug; i>=1; i--)
                {
                        
                        if ((SumIdxFoundNonZero(i)==0)&&(mem[i][NKolAug]!=0))
                        {
                                System.out.println("Tidak ada solusi SPLnya\n");
                                break;
                        }
                        else if ((SumIdxFoundNonZero(i)==1))
                        {
                                for (j=1;j<=NBrsAug-1;j++)
                                {
                                        if(mem[i][j]!=0)
                                        {
                                                solSPL[j]=mem[i][j];
                                        }
                                }
                        }
                        else if ((SumIdxFoundNonZero(i)>1))
                        {
                                String elmt;
                                for (j=NBrsAug-1;j>=1;j--)
                                {
                                        if(mem[i][j]!=0)
                                        {
                                               if (IsAdaSolSPL(i,j,j))
                                               {
                                                
                                                elmt=elemt+mem[i][NKolAug]-mem[i][j]*solSPL[j];
                                               }
                                        }


                                }
                        }
                        
                }
        }

        boolean IsAdaSolSPL(int acbar, int ackol, int idxarray )
        {
                if (mem[acbar][ackol]!=0 && solSPL[idxarray]!=null)
                {
                        return true;
                }
                else{
                        return false;
                }
        }
*/
        int SumIdxFoundNonZero (int acbar)
        {
                
                int j;
                int sum;
                sum=0;
                for (j=1;j<=NKolEff;j++)
                {
                        if (mem[acbar][j]!=0)
                        {
                                sum=sum+1;
                        }
                }
                return sum;
                
        }

        boolean IsFound1Kolom (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan true jika ditemukannya angka 1 di kol acuan */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==1)
                        {
                                return true;
                        }
                }
                return false;
        }

        int IdxKolom1 (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan indeks baris pertama kali ditemukannya angka 1 di kol acuan, jika tidak ketemu kembaliaannya 0 */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==1)
                        {
                                return i;
                        }
                }
                return 0;
        }

        boolean IsFound0Kolom (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan true jika  ditemukannya angka 0 di kol acuan */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==0)
                        {
                                return true;
                        }
                }
                return false;
        }

        int IdxKolom0 (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan indeks baris pertama kali ditemukannya angka 0 di kol acuan, jika tidak ketemu kembaliaannya 0 */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==0)
                        {
                                return i;
                        }
                }
                return 0;
        }

        void OBEtukar (int bartukar, int acbar)
        {
                int j;
                for (j=1;j<=NKolEff+1;j++)
                {
                        float temp;
                        temp=mem[(acbar)][(j)];
                        mem[(acbar)][(j)]=mem[(bartukar)][(j)];
                        mem[(bartukar)][(j)]=temp;
                }
        }

        void OBEkurang (int barkurang, int kolkurang, int acbar, int ackol)
        {
                int j;
                float ac;
                ac = (float)mem[(barkurang)][(kolkurang)]/mem[(acbar)][(ackol)];
    
                        for (j=1;j<=NKolEff+1;j++)
                        {
                        mem[(barkurang)][(j)]=mem[(barkurang)][(j)]-mem[(acbar)][(j)]*ac; 
                        }
                
        }

        void OBEUtama (int barkurang, int ackol)
        {
                int j,ac1,ac2;
                ac1=barkurang;
                ac2=ackol;
                float ac;
                ac=mem[ac1][ac2];
                for (j=1;j<=NKolEff+1;j++)
                {
                       mem[barkurang][j]=(float)mem[barkurang][j]/ac;
                }
        }

        void GaussSPL ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                for (j=1;j<=NKolEff;j++)
                {
                        if (IsIdxEff(k+1,j))
                        {
                                for (i=1+k;i<=NBrsEff;i++)
                                {
                                        utama=1+k;
                                        if (i==utama)
                                        //saat baris ke i mula2
                                        {
                                                keluar=false;
                                                w=0;
                                                if (IsFound1Kolom(utama,j))
                                                //Kalau dalam baris ke i terdapat 1 maka ditukar dengan baris ke 1+k
                                                {
                                                        OBEtukar(IdxKolom1(i+k,j),i+k);
                                                        
                                                }  
                                                
                                                else
                                                //saat tidak ada 1
                                                {
                                                        if (mem[utama][j]==0 )
                                                        //kalau di baris ke 1+k terdapat 0, maka ditukar sampai bukan 0
                                                        //kalau ternyata 0 semua, maka next langsung ke step berikutnya(tidk dilakukan aksi appun)
                                                        {
                                                                while ((mem[utama][j]==0 )&& (!(keluar)))
                                                                {
                                                                        w=w+1;
                                                                        if ((utama+w)!=NBrsEff)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,i+k);
                                                                                if(mem[i+k][j]==0)
                                                                                {
                                                                                        OBEtukar(utama+w,i+k);
                                                                                }
                                                                                else
                                                                                {
                                                                                        OBEUtama(utama,j);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                        else
                                                        {

                                                                OBEUtama(utama,j);

                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((mem[i][j]!=0 ))
                                                {
                                                        OBEkurang(i,j,utama,j);
                                                }
                                                
                                                

                                        }      
                                }
                        }

                        if (keluar==false)
                        {
                         k=k+1;
                        }
                        
                }

        }

        
        void GaussJordan ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                for (j=1;j<=NKolEff;j++)
                {
                        if (IsIdxEff(k+1,j))
                        {
                                utama=1+k;
                                for (i=1+k;i<=NBrsEff;i++)
                                {
                                        if (i==utama)
                                        //saat baris ke i mula2
                                        {
                                                keluar=false;
                                                w=0;
                                                if (IsFound1Kolom(utama,j))
                                                //Kalau dalam baris ke i terdapat 1 maka ditukar dengan baris ke 1+k
                                                {
                                                        OBEtukar(IdxKolom1(i+k,j),i+k);
                                                        
                                                }  
                                                
                                                else
                                                //saat tidak ada 1
                                                {
                                                        if (mem[utama][j]==0 )
                                                        //kalau di baris ke 1+k terdapat 0, maka ditukar sampai bukan 0
                                                        //kalau ternyata 0 semua, maka next langsung ke step berikutnya(tidk dilakukan aksi appun)
                                                        {
                                                                while ((mem[utama][j]==0 )&& (!(keluar)))
                                                                {
                                                                        w=w+1;
                                                                        if ((utama+w)!=NBrsEff)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,i+k);
                                                                                if(mem[i+k][j]==0)
                                                                                {
                                                                                        OBEtukar(utama+w,i+k);
                                                                                }
                                                                                else
                                                                                {
                                                                                        OBEUtama(utama,j);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                        else
                                                        {

                                                                OBEUtama(utama,j);


                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((mem[i][j]!=0 ))
                                                {
                                                        OBEkurang(i,j,utama,j);
                                                }
                                                                        
                                        }
                                }

                                if (IsFound1Kolom(utama,j))
                                {
                                        i=1;
                                        while (i<utama)
                                        {
                                                if ((mem[i][j]!=0 ))
                                                        {
                                                                OBEkurang(i,j,utama,j);
                                                        }  
                                                i=i+1;

                                        }
                                }   
                                
                        }

                        if (keluar==false)
                        {
                         k=k+1;
                        }
                        
                }

        }
        float Determinan ()
        {
                return 0;       
        }

        void CramerSPL()
        //MATRIKS Harus SINGULAR (n x n)
        //Matriks Augmentednya harus ( n x n+1 )
        {
                
                int j,i;
                float det;
                float[] solSPL= new float[NKolEff];
                det= Determinan();
                for (j=1;j<=NKolEff;j++)
                {
                       for (i=1;i<=NBrsEff;i++)
                       {
                               mem[i][j]=mem[i][NKolEff+1];
                       }
                        solSPL[j]=Determinan()/det;
                        for (i=1;i<=NBrsEff;i++)
                       {
                               mem[i][j]=mem[i][NKolEff+1];
                       }
                       
                }
                
                System.out.println("Ini hasil SPL Cramer");
                for (j=1;j<=NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solSPL[j]);
                }

        }


        void InverseSPL ()
        //MASUKKAN MATRIKS AUGMENTED YANG SUDAH DIINVERS NAMUN NEFF+1 MASI BERISIKAN SOLUSI SPLNYA
        {
                int i,j,k;
                float elmt;
                float [] solInvers = new float[NBrsEff];
                for (i=1;i<=NBrsEff;i++)
                {
                        j=NKolEff+1;
                        {
                        elmt=0;
                        for (k=1;k<=NKolEff;k++)
                        {
                                elmt=elmt+mem[i][k]*mem[k][j];
                        }
                        solInvers[i] = elmt;
                        }
                }
                
                System.out.println("Ini hasil SPL Invers");
                for (j=1;j<=NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solInvers[j]);
                }
        }

        float DeterminanKofaktor (matriks M) {
                int i,j;
                // ALGORITMA //
                if (M.NBrsEff == 2) {
                        return (M.mem[1][1]*M.mem[2][2]-M.mem[1][2]*M.mem[2][1]);
                }
                else {
                        matriks MKof = new matriks();
                        MKof.MakeMATRIKS(NBrsEff-1, NKolEff-1);
                        float det = 0;
                        i = 1;
                        for (j=1; j<=NKolEff; j++) {
                                for (int k=2; k<=NBrsEff; k++) {
                                        for (int l=1; l<=NKolEff; l++) {
                                                if (j<l) {
                                                        return 0;
                                                }
                                        }
                                }
                        }
                        return 0;
                }
        }
        public static void main (String[] args)
        {
                int brs,kol;
                Scanner sc = new Scanner(System.in); 
                System.out.println("Baris :");
                brs = sc.nextInt();
                System.out.println("Kolom :");
                kol = sc.nextInt();

                matriks M = new matriks ();
                M.BacaMATRIKSAug(brs,kol);
                M.GaussSPL();
                M.TulisMATRIKSAug();
    }
}
