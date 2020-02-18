import java.math.BigDecimal;
import java.math.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;




public class matriks
{
        Scanner sc = new Scanner(System.in); 
        
        public int NBrsEff;
        public int NKolEff;
        float[][]mem= new float[50][50];
        BigDecimal[][]hem= new BigDecimal[50][50];

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

        boolean DIsIdxEff (int k, int l)
        /* Mengirimkan true jika i, j adalah indeks efektif bagi M */
        {
        BigDecimal i,j;
        i = BigDecimal.valueOf(k);
        j= BigDecimal.valueOf(l);       
        return (((i.compareTo(BigDecimal.valueOf(0)) > 0) )&&((i.compareTo(BigDecimal.valueOf(NBrsEff+1)) < 0))&&((j.compareTo(BigDecimal.valueOf(0)) > 0))&&((j.compareTo(BigDecimal.valueOf(NKolEff+1)) < 0)));
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
                mem[i][j]=sc.nextFloat();
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
                mem[i][j]=sc.nextFloat();
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

        void TulisMATRIKSAugBigD() {
		System.out.println("\nMatriksnya adalah :");
		for(int i=1; i <=NBrsEff; i++) {
			for(int j=1; j <=NKolEff+1; j++) {
				System.out.print("\t" + hem[i][j]);
			}
			System.out.println();
		}
        }

        boolean AdaBukanSolSPL (matriks m)
        {
                int i;
                for (i=m.NBrsEff;i>=1;i--)
                {
                        if ((IsKirinya0semua (m, i, m.NKolEff+1))&&m.mem[i][m.NKolEff+1]!=0)
                        {
                                return true;
                        }
                }
                return false;
        }
        int IdxBrsSebelum0semua(matriks m)
        {
                int i,j;
                for (i=m.NBrsEff;i>=1;i--)
                {
                        for (j=1;j<=m.NKolEff+1;j++)
                        {
                                if (m.mem[i][j]!=0)
                                {
                                        return i;
                                }
                        }
                }
                System.out.println("MATRIKS KOSONG!!!\n");
                return i;

        }


        void SPLParametrik(matriks m)
        {
                int i,j,w,ha;
                ha=0;
                w=1;
                matriks koef = new matriks();
                char[] alph = new char[]{'w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
                koef.MakeMATRIKS(m.NBrsEff,m.NKolEff);
                int a= IdxBrsSebelum0semua(m);
                if (AdaBukanSolSPL(m))
                {
                        System.out.println("Tidak ada solusi SPL\n");
                        m.SaveString("Tidak ada solusi SPL");

                }
                else {
                for (i=a-1; i>=1; i--)
                {   
                        for (j=m.NKolEff;j>=1;j--)
                        {
                                if ((m.mem[IdXPalingBawah(m,j)][j]==1)&&(!(IsSatuUtama(m,i,j)))&&(i<IdXPalingBawah(m,j)))
                                {
                                        DiRekursifin(m,i,j);
                                }
                        }
                }

                int k;
                k=1;
                float simp;
                String str1,str2;
                for (j=m.NKolEff;j>=1;j--)
                {
                        ha=1;
                        if (IsSatuUtama(m,IdXPalingBawah(m,j),j))
                        {
                                System.out.print("x"+j+" = ");
                                m.SaveString("x"+j+"=");
                                
                                if (((j+1)!=m.NKolEff+1) && (m.mem[IdXPalingBawah(m,j)][j+1]!=0))
                                {        simp = m.mem[IdXPalingBawah(m,j)][j+1]*(-1);
                                        str1=String.valueOf(simp);
                                        str2 = String.valueOf(alph[j+1]);
                                        System.out.print(str1+str2);
                                        m.SaveString(str1+str2);
                                        ha++;
                                }
                                else if(((j+1)==m.NKolEff+1) && (m.mem[IdXPalingBawah(m,j)][j+1]!=0))
                                {
                                        simp = m.mem[IdXPalingBawah(m,j)][j+1];
                                        str1=String.valueOf(simp);
                                        System.out.print(str1);
                                        m.SaveString(str1);
                                        ha++;
                                }
                                        
                                k=j+2;
                                while (k<=m.NKolEff+1)
                                {
                                        
                                        
                                        if((m.mem[IdXPalingBawah(m,j)][k]*(-1))>0)
                                        {
                                                if ((k)!=m.NKolEff+1) 
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k]*(-1);
                                                        str1=String.valueOf(simp);
                                                        str2 = String.valueOf(alph[k]);
                                                        if (ha!=1)
                                                        {
                                                                System.out.print("+"+str1+str2);
                                                                m.SaveString(str1+str2);
                                                                ha++;
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1+str2);
                                                                m.SaveString(str1+str2);
                                                                ha++;
                                                        }
                                                        
                                                }
                                                else
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k];
                                                        str1=String.valueOf(simp);
                                                        if (m.mem[IdXPalingBawah(m,j)][k]>0)
                                                        {
                                                                if (ha!=1)
                                                                {
                                                                        System.out.print("+"+str1);
                                                                        m.SaveString(str1);
                                                                        ha++;
                                                                }
                                                                else
                                                                {
                                                                        System.out.print(str1);
                                                                        m.SaveString(str1);
                                                                        ha++;
                                                                }
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1);
                                                                m.SaveString(str1);
                                                        }
                                                }
                                        }
                                        else if((m.mem[IdXPalingBawah(m,j)][k]*(-1))<0)
                                        {
                                                if ((k)!=m.NKolEff+1) 
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k]*(-1);
                                                        str1=String.valueOf(simp);
                                                        str2 = String.valueOf(alph[k]);
                        
                                                        System.out.print(str1+str2);
                                                        m.SaveString(str1+str2);
                                                        ha++;
                                                }
                                                else
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k];
                                                        str1=String.valueOf(simp);
                                                        if (m.mem[IdXPalingBawah(m,j)][k]>0)
                                                        {
                                                                if (ha!=1)
                                                                {
                                                                        System.out.print("+"+str1);
                                                                        m.SaveString(str1);
                                                                        ha++;
                                                                }
                                                                else
                                                                {
                                                                        System.out.print(str1);
                                                                        m.SaveString(str1);
                                                                        ha++;
                                                                }
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1);
                                                                m.SaveString(str1);
                                                                ha++;
                                                        }
                                                }
                                        }
                                        /*
                                        
                                        */
                                        
                                                
                                        
                                k++;
                                 
                                }
                                
                                if (m.mem[IdXPalingBawah(m,j)][k]==0)
                                        {
                                                simp = m.mem[IdXPalingBawah(m,j)][k];
                                                str1=String.valueOf(simp);
                                                if (m.mem[IdXPalingBawah(m,j)][k]==0)
                                                {
                                                        if (ha==1)
                                                        {
                                                                System.out.print(0);
                                                        }       
                                                }
                                        }
                                System.out.println();
                        }
                        else if ((!IsSatuUtama(m,IdXPalingBawah(m,j),j)))
                        {

                                System.out.print("x"+j+" = "+alph[j]);
                                m.SaveString("x"+j+" = "+alph[j]);
                                System.out.println();
                                
                        }
                }
                
        }
        }
        void DiRekursifin (matriks m, int acbar, int ackol)
        {
                int i,j;
                float ac;
                ac=m.mem[acbar][ackol];
                i=IdXPalingBawah(m,ackol);
                if (acbar!=m.NBrsEff)
                {
                        for (j=ackol+1;j<=m.NKolEff+1;j++)
                        {
                                m.mem[acbar][j]=m.mem[acbar][j]-(m.mem[i][j]*ac);
                        }
                        m.mem[acbar][ackol]=0;
                }
        }

   

        int IdXPalingBawah (matriks m, int kol)
        {
                int i;
                for (i=1;i<=m.NBrsEff;i++)
                {
                        if ((m.mem[i][kol]==0)&&(IsBawahnya0semua(m,i,kol))&&(IsKirinya0semua(m,i,kol)))
                        {
                                return i-1;
                        }
                }
                return i-1;
        }
        boolean IsSatuUtama (matriks m, int bar, int kol)
        {
                return ((m.mem[bar][kol]==1)&&(IsBawahnya0semua(m,bar,kol)&&IsKirinya0semua(m,bar,kol)));
        }

        boolean IsBawahnya0semua(matriks m, int bar, int kol)
        {
                int i;
                if (bar!=m.NBrsEff)
                {
                        for (i=bar+1;i<=m.NBrsEff;i++)
                        {
                                if (m.mem[i][kol]!=0)
                                {
                                        return false;
                                }
                        }
                        return true;
                }
                else
                {
                        return true;
                }
        }

        boolean IsKirinya0semua (matriks m, int bar, int kol)
        {
                int j;
                if (kol!=1)
                {
                        for (j=1;j<kol;j++)
                        {
                                if (m.mem[bar][j]!=0)
                                {
                                        return false;
                                }
                        }
                        return true;
                }
                else
                {
                        return true;
                }
        }
 
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

        boolean DIsFound1Kolom (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan true jika ditemukannya angka 1 di kol acuan */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if ((hem[i][ackol].compareTo(BigDecimal.valueOf(1)) == 0 ))
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

        int DIdxKolom1 (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan indeks baris pertama kali ditemukannya angka 1 di kol acuan, jika tidak ketemu kembaliaannya 0 */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if ((hem[i][ackol].compareTo(BigDecimal.valueOf(1)) == 0 ))
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

        void DOBEtukar (int bartukar, int acbar)
        {
                int j;
                for (j=1;j<=NKolEff+1;j++)
                {
                        BigDecimal temp;
                        temp=hem[(acbar)][(j)];
                        hem[(acbar)][(j)]=hem[(bartukar)][(j)];
                        hem[(bartukar)][(j)]=temp;
                }
        }

        void OBEtukarInverse (int bartukar, int acbar)
        {
                int j;
                for (j=1;j<=NKolEff*2;j++)
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

        void DOBEkurang (int barkurang, int kolkurang, int acbar, int ackol)
        {
                int j;
                BigDecimal ac;
                ac = hem[(barkurang)][(kolkurang)].divide((hem[(acbar)][(ackol)]),5,RoundingMode.HALF_EVEN);
    
                        for (j=1;j<=NKolEff+1;j++)
                        {
                        hem[(barkurang)][(j)]=((hem[(barkurang)][(j)]).subtract(hem[(acbar)][(j)])).multiply(ac); 
                        }
                
        }

        void OBEkurangInverse (int barkurang, int kolkurang, int acbar, int ackol)
        {
                int j;
                float ac;
                ac = (float)mem[(barkurang)][(kolkurang)]/mem[(acbar)][(ackol)];
    
                        for (j=1;j<=NKolEff*2;j++)
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

        void DOBEUtama (int barkurang, int ackol)
        {
                int j,ac1,ac2;
                ac1=barkurang;
                ac2=ackol;
                BigDecimal ac;
                ac=hem[ac1][ac2];
                for (j=1;j<=NKolEff+1;j++)
                {
                       hem[barkurang][j]=(hem[barkurang][j]).divide((ac),5,RoundingMode.HALF_EVEN);
                }
        }

        void OBEUtamaInverse (int barkurang, int ackol)
        {
                int j,ac1,ac2;
                ac1=barkurang;
                ac2=ackol;
                float ac;
                ac=mem[ac1][ac2];
                for (j=1;j<=NKolEff*2;j++)
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
                                                        
                                                        OBEtukar(IdxKolom1(utama,j),utama);
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
                                                                        if ((utama+w)==NBrsEff+1)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,utama);  
                                                                        }
                                                                        
                                                                }
                                                                if (mem[utama][j]!=0 )
                                                                {
                                                                        OBEUtama(utama,j);
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
                TulisMATRIKSAug();
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
                                                        OBEtukar(IdxKolom1(utama,j),utama);
                                                        
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
                                                                        if ((utama+w)==NBrsEff+1)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,utama);  
                                                                        }
                                                                        
                                                                }
                                                                if (mem[utama][j]!=0 )
                                                                {
                                                                        OBEUtama(utama,j);
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

        
        void GaussJordanBigD ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                for (j=1;j<=NKolEff;j++)
                {
                        if (DIsIdxEff(k+1,j))
                        {
                                utama=1+k;
                                for (i=1+k;i<=NBrsEff;i++)
                                {
                                        if (i==utama)
                                        //saat baris ke i mula2
                                        {
                                                keluar=false;
                                                w=0;
                                                if (DIsFound1Kolom(utama,j))
                                                //Kalau dalam baris ke i terdapat 1 maka ditukar dengan baris ke 1+k
                                                {
                                                       DOBEtukar(DIdxKolom1(utama,j),utama);
                                                        
                                                }  
                                                
                                                else
                                                //saat tidak ada 1
                                                {
                                                        if ((hem[utama][j].compareTo(BigDecimal.valueOf(0)) == 0))
                                                        //kalau di baris ke 1+k terdapat 0, maka ditukar sampai bukan 0
                                                        //kalau ternyata 0 semua, maka next langsung ke step berikutnya(tidk dilakukan aksi appun)
                                                        {
                                                                while (((hem[utama][j].compareTo(BigDecimal.valueOf(0)) == 0))&& (!(keluar)))
                                                                {
                                                                        w=w+1;
                                                                        if ((utama+w)==NBrsEff+1)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                DOBEtukar(utama+w,utama);  
                                                                        }
                                                                        
                                                                }
                                                                if ((hem[utama][j].compareTo(BigDecimal.valueOf(0)) != 0))
                                                                {
                                                                        DOBEUtama(utama,j);
                                                                }
                                                        }
                                                        else
                                                        {

                                                                DOBEUtama(utama,j);
                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((hem[i][j].compareTo(BigDecimal.valueOf(0)) != 0))
                                                {
                                                        DOBEkurang(i,j,utama,j);
                                                }
                                                                        
                                        }
                                }

                                if (DIsFound1Kolom(utama,j))
                                {
                                        i=1;
                                        while (i<utama)
                                        {
                                                if ((hem[i][j].compareTo(BigDecimal.valueOf(0)) != 0))
                                                        {
                                                                DOBEkurang(i,j,utama,j);
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

        void GaussJordanInverse ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                BikinIdentitas();
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
                                                        OBEtukarInverse(IdxKolom1(utama,j),utama);
                                                        
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
                                                                                OBEtukarInverse(utama+w,i+k);
                                                                                if(mem[i+k][j]==0)
                                                                                {
                                                                                        OBEtukarInverse(utama+w,i+k);
                                                                                }
                                                                                else
                                                                                {
                                                                                        OBEUtamaInverse(utama,j);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                        else
                                                        {

                                                                OBEUtamaInverse(utama,j);
                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((mem[i][j]!=0 ))
                                                {
                                                        OBEkurangInverse(i,j,utama,j);
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
                                                                OBEkurangInverse(i,j,utama,j);
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

        void CramerSPL(matriks M)
        //MATRIKS Harus SINGULAR (n x n)
        //Matriks Augmentednya harus ( n x n+1 )
        {
                
                int j,i,k;
                float det;
                float[] solSPL= new float[M.NKolEff+1];
                
                matriks a = new matriks();
                a.MakeMATRIKS(M.NBrsEff,M.NKolEff);
                for (i=1;i<=a.NBrsEff;i++)
                {
                        for (k=1;k<=a.NKolEff;k++)
                        {
                                a.mem[i][k]=M.mem[i][k];
                        }
                }
                
                det= a.DeterminanKofaktor(a);
                for (j=1;j<=M.NKolEff;j++)
                {
                       for (i=1;i<=M.NBrsEff;i++)
                       {
                                float temp;
                                temp=M.mem[(i)][(j)];
                                M.mem[(i)][(j)]=M.mem[(i)][(M.NKolEff+1)];
                                M.mem[(i)][(M.NKolEff+1)]=temp;
                       }
                       for (i=1;i<=a.NBrsEff;i++)
                       {
                               for (k=1;k<=a.NKolEff;k++)
                               {
                                       a.mem[i][k]=M.mem[i][k];
                               }
                       }
                        solSPL[j]=(float)(a.DeterminanKofaktor(a))/det;
                        for (i=1;i<=M.NBrsEff;i++)
                       {
                                float temp;
                                temp=M.mem[(i)][(j)];
                                M.mem[(i)][(j)]=M.mem[(i)][(M.NKolEff+1)];
                                M.mem[(i)][(M.NKolEff+1)]=temp;
                       }
                       
                }
                
                System.out.println("Ini hasil SPL Cramer");
                M.SaveString("Ini hasil SPL Cramer");
                for (j=1;j<=M.NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solSPL[j]);
                        M.SaveString("x"+j+"= "+solSPL[j]);
                }

        }


        void InverseSPL (matriks a)
        //MASUKKAN MATRIKS AUGMENTED ((YANG SUDAH DIINVERS))) NAMUN NEFF+1 MASI BERISIKAN SOLUSI SPLNYA
        {
                if (a.NBrsEff!=a.NKolEff)
                {
                        System.out.println("Matriks augmented masukkan harus berisi n x n+1 ya ~~");
                }
                else if (DeterminanKofaktor(a)==0)
                {
                        System.out.println("Maaf ya.. Matriks augmented tidak ada solusi SPLnya karena ngga ada inversnya ~");
                        a.SaveString("Matriks augmented masukkan harus berisi n x n+1 ya ~~");
                }
                else{
                int  i,k;
                matriks M= new matriks ();
                M.MakeMATRIKS(a.NBrsEff,a.NKolEff);
                for (i=1;i<=a.NBrsEff;i++)
                {
                        for (k=1;k<=a.NKolEff;k++)
                        {
                               M.mem[i][k]=a.mem[i][k];
                        }
                }
                M.GaussJordanInverse();
                
                int j;
                float elmt;
                float [] solInvers = new float[NBrsEff+1];
                for (i=1;i<=NBrsEff;i++)
                {
                        j=NKolEff+1;
                        
                        elmt=0;
                        for (k=1;k<=NKolEff;k++)
                        {
                                elmt=elmt+(M.functionTulisGaussJordan2(M)).mem[i][k]*a.mem[k][j];
                        }
                        solInvers[i] = elmt;
                        
                }
                
                System.out.println("Ini hasil SPL Invers");
                a.SaveString("Ini hasil SPL Invers");
                for (j=1;j<=NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solInvers[j]);
                        a.SaveString("x"+j+"= "+solInvers[j]);
                }
        }
        }
        
        void Interpolasi ()
        {
                float input1, input2,x;
                BigDecimal sum;
                sum=BigDecimal.valueOf(0);
                System.out.println("Masukkan banyaknya titik : ");
                NKolEff=sc.nextInt();
                MakeMATRIKS(NKolEff,NKolEff);
                int i,j;
                for (i=1;i<=NBrsEff;i++)
                {
                        input1 = sc.nextFloat();
                        for (j=1;j<=NKolEff;j++)
                        {
                                mem[i][j]=(float)Math.pow(input1,j-1);
                        }
                        input2 = sc.nextFloat();
                        mem[i][NKolEff+1]=input2;
                       
                }
                TulisMATRIKSAug();
                GaussJordan();
                TulisMATRIKSAug();
                System.out.println("Masukkan x : ");
                x=sc.nextFloat();

                for(i=1;i<=NBrsEff;i++)
                {
                        //sum=sum+mem[i][NKolEff+1]*(float)Math.pow(x,i-1);
                        sum = sum.add(BigDecimal.valueOf(mem[i][NKolEff+1]*(float)Math.pow(x,i-1)));
                }
                System.out.print("p(x) = "+mem[1][NKolEff+1]);
                for(i=2;i<=NBrsEff;i++)
                {
                        if (mem[i][NKolEff+1]>=0)
                        {
                        System.out.print("+"+mem[i][NKolEff+1]+"x^"+(i-1));
                }
                        else
                        {
                                System.out.print("+"+mem[i][NKolEff+1]+"x^"+(i-1));       
                        }
                        
                        //sum=sum+mem[i][NKolEff+1]*(float)Math.pow(x,i-1);
                }

                System.out.println();
                System.out.println("Hasil interpolasinya : "+sum);
                SaveString("Hasil interpolasinya : "+sum);
        }

        void InterpolasiBigDecimal ()
        {
                BigDecimal m;
                BigDecimal sum;
                float input1,x,input2;
                sum=BigDecimal.valueOf(0);
                System.out.println("Masukkan banyaknya titik : ");
                NKolEff=sc.nextInt();
                MakeMATRIKS(NKolEff,NKolEff);
                int i,j;
                for (i=1;i<=NBrsEff;i++)
                {
                        input1 = sc.nextFloat();
                        BigDecimal input1d = BigDecimal.valueOf(input1);

                        for (j=1;j<=NKolEff;j++)
                        {
                                hem[i][j]=input1d.pow(j-1);
                        }
                        input2 = sc.nextFloat();
                        
                        BigDecimal input2d = BigDecimal.valueOf(input2);
                        hem[i][NKolEff+1]=input2d;
                       
                }
                GaussJordanBigD();
                TulisMATRIKSAugBigD();
                System.out.println("Masukkan x : ");
                x=sc.nextFloat();
                BigDecimal xy = BigDecimal.valueOf(x);


                for(i=1;i<=NBrsEff;i++)
                {
                        sum= sum.add(hem[i][NKolEff+1].multiply(xy.pow(i-1)));
                }
                System.out.print("p(x) = "+hem[1][NKolEff+1]);
                for(i=2;i<=NBrsEff;i++)
                {
                        if (hem[i][NKolEff+1].compareTo(BigDecimal.valueOf(0)) >= 0)
                        {
                        System.out.print("+"+hem[i][NKolEff+1]+"x^"+(i-1));
                }
                        else
                        {
                                System.out.print("+"+hem[i][NKolEff+1]+"x^"+(i-1));       
                        }
                        
                }

                System.out.println();
                System.out.println("Hasil interpolasinya : "+sum);
                SaveString("Hasil interpolasinya : ");
        }
        

        float DeterminanKofaktor (matriks M) {
                 // kalo ga persegi menghasilkan det undef = -9999 
                int j,k,l,tanda;
                float det;
                // ALGORITMA //
                det = 0;
                        if (M.NBrsEff == 1) {
                                det = (M.mem[1][1]);
                        }
                        else if (M.NBrsEff == 2) {
                                det = (M.mem[1][1]*M.mem[2][2]-M.mem[1][2]*M.mem[2][1]);
                        }
                        else {
                                matriks MKof = new matriks();
                                MKof.MakeMATRIKS(NBrsEff-1, NKolEff-1);
                                tanda = 1;
                                for (j=1; j<=M.NKolEff; j++) {
                                        for (k=2; k<=M.NBrsEff; k++) {
                                                for (l=1; l<=M.NKolEff; l++) {
                                                        if (j!=l) {
                                                                if (l<j) {
                                                                        MKof.mem[k-1][l] = M.mem[k][l];                
                                                                }
                                                                else {
                                                                        MKof.mem[k-1][l-1] = M.mem[k][l];
                                                                }
                                                        }
                                                        
                                                }

                                        }
                                        det += tanda*M.mem[1][j]*MKof.DeterminanKofaktor(MKof);
                                        tanda *= -1;
                                }
                }
                M.SaveString("Determinan : "+det);
                return det;
        }

        BigDecimal DeterminanGauss (matriks M) {
                // KAMUS LOKAL //
                boolean IsFoundNot0;
                int i;
                float temp,sign;
                BigDecimal det; 
                sign = 1;
                i = 1;
                // membuat Elmt(1,1),(2,2),(3,3) dst ngga 0
                for (int j = 1; j<=M.NKolEff; j++) {
                        IsFoundNot0 = false;
                        while (IsFoundNot0 == false && i<=M.NBrsEff) {
                                if (M.mem[i][j]!=0) {
                                        IsFoundNot0 = true;
                                }
                                i += 1;
                        }
                        i-=1;
                        // tukar baris
                        if (IsFoundNot0) {
                                if (i>j) {
                                         for (int k=1;k<=M.NKolEff;k++) {
                                                 temp = M.mem[i][k];
                                                 M.mem[i][k]=M.mem[j][k];
                                                 M.mem[j][k] = temp;
                                         }
                                         sign*=-1;
                                }
                                 }
                         // untuk kolom ke-1 dibuat setelah baris j jd 0 semua
                         for (int l=j+1;l<=M.NBrsEff;l++) {
                                 for (int m=M.NKolEff;m>=1;m--) {
                                         M.mem[l][m] -= (M.mem[l][j]/M.mem[j][j])*M.mem[j][m];
                                 }

                         }
                         i = j+1;
                }
                //det = 1*sign;
                det = (BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(sign));
                for (int n=1;n<=M.NBrsEff;n++) {
                        //det*=M.mem[n][n];
                        det = det.multiply(BigDecimal.valueOf(M.mem[n][n]));
                }
                /*if (det==-0.0) {
                        det*=-1;
                }*/
                M.SaveString("Determinan : "+det);
                return det;
               }
        
       BigDecimal DeterminanGaussJordan (matriks M) {
                boolean IsFoundNot0;
                int i;
                float temp,sign;
                BigDecimal det; 
                sign = 1;
                i = 1;
                // membuat Elmt(1,1),(2,2),(3,3) dst ngga 0
                for (int j = 1; j<=M.NKolEff; j++) {
                        IsFoundNot0 = false;
                        while (IsFoundNot0 == false && i<=M.NBrsEff) {
                                if (M.mem[i][j]!=0) {
                                        IsFoundNot0 = true;
                                }
                                i += 1;
                        }
                        i-=1;
                        // tukar baris
                        if (IsFoundNot0) {
                                if (i>j) {
                                         for (int k=1;k<=M.NKolEff;k++) {
                                                 temp = M.mem[i][k];
                                                 M.mem[i][k]=M.mem[j][k];
                                                 M.mem[j][k] = temp;
                                         }
                                         sign*=-1;
                                }
                                 }
                         // untuk kolom ke-1 dibuat setelah baris j jd 0 semua (Gauss)
                         for (int l=j+1;l<=M.NBrsEff;l++) {
                                        for (int m=M.NKolEff;m>=1;m--) {
                                                M.mem[l][m] -= (M.mem[l][j]/M.mem[j][j])*M.mem[j][m];
                                        }
                                 

                         }
                         // dibuat segitiga 0 di atas
                         for (int n=j-1;n>=1;n--) {
                                 for (int m=M.NKolEff;m>=1;m--) {
                                         if (M.mem[j][j]!=0) {
                                                M.mem[n][m] -= (M.mem[n][j]/M.mem[j][j])*M.mem[j][m];
                                         }
                                 }
                         }
                         i = j+1;
                }
                //det = 1*sign;
                det = (BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(sign));
                for (int n=1;n<=M.NBrsEff;n++) {
                        //det*=M.mem[n][n];
                        det = det.multiply(BigDecimal.valueOf(M.mem[n][n]));
                }
                /*if (det==-0.0) {
                        det*=-1;
                }*/
                M.SaveString("Determinan : "+det);
                return det;
               }
        BigDecimal DeterminanInversnya (matriks M) {
                BigDecimal det;
                M.GaussJordanInverse();        
                //det = 1/(M.DeterminanGauss(M.functionTulisGaussJordan2(M)));
                det = (BigDecimal.valueOf(1)).divide(M.DeterminanGauss(M.functionTulisGaussJordan2(M)),5,RoundingMode.HALF_EVEN);
                M.SaveString("Determinan : "+det);
                return det;
               }

        matriks kofaktor (matriks M)
        {
                int i, j,k,l;
                matriks kof = new matriks ();
                kof.MakeMATRIKS(M.NBrsEff,M.NKolEff);
                int m=1;
                int n=1;
                int sign =0;
                for (i=1;i<=M.NBrsEff;i++)
                {
                        for (j=1;j<=M.NKolEff;j++)
                        {
                                
                                matriks mat = new matriks ();
                                mat.MakeMATRIKS(M.NBrsEff-1,M.NKolEff-1);
                                
                                for (k=1;k<=M.NBrsEff;k++)
                                {
                                        n=1;
                                        for (l=1;l<=M.NKolEff;l++)
                                        {
                                                if ((i!=k)&&(j!=l))
                                                {
                                                        
                                                        mat.mem[m][n]=M.mem[k][l];
                                                        n++;
                                                }
                                        }
                                        if (n>=M.NKolEff-1)
                                        {
                                                m++;
                                        }      
                                }
                                if (m>=M.NBrsEff-1)
                                {
                                        m=1;
                                }   
                                kof.mem[i][j]=((mat.DeterminanGauss(mat)).floatValue())*(float)Math.pow(-1,sign);
                                sign++;
                        }
                }

                return kof;

        }
        
        matriks TransposeMatriks(matriks M) {
                int i, j;
                matriks hasil = new matriks();
                hasil.MakeMATRIKS(M.NKolEff, M.NBrsEff);
                for (i = 1; i <= M.NBrsEff; i++) {
                    for (j = 1; j <= M.NKolEff; j++) {
                        hasil.mem[j][i] = M.mem[i][j];
                    }
                }
                return hasil;
        }
        matriks AdjointMatriks(matriks M) { // Membuat matriks adjoint
                return M.TransposeMatriks(M.kofaktor(M));
            }
        
        matriks KofaktorInverse(matriks M) {
                if (M.DeterminanKofaktor(M) != 0) {
                        return M.KaliKons(M.AdjointMatriks(M), (1 / M.DeterminanKofaktor(M)));
                }
                else {
                        System.out.println("Matriks tidak punya invers");
                        return M;
                }
        }
 
        matriks KaliKons(matriks M, float x) { // Ngaliin matriks dengan konstanta
                int i, j;
                matriks hasil = new matriks();
                hasil.MakeMATRIKS(M.NBrsEff, M.NKolEff);
                for (i = 1; i <= M.NBrsEff; i++) {
                    for (j = 1; j <= M.NKolEff; j++) {
                        hasil.mem[i][j] = M.mem[i][j] * x;
                    }
                }
                return hasil;
            }
        
            void BikinIdentitas()
        {
                int i,j;
                for (i=1;i<=NBrsEff;i++)
                {
                        for (j=NKolEff+1;j<=NKolEff*2;j++)
                        {
                                if(i==(j-NKolEff))
                                {
                                        mem[i][j]=1;
                                }
                                else{
                                        mem[i][j]=0;
                                }
                        }
                }
        }

        matriks functionTulisGaussJordan2(matriks M )
        {
                int i,j;
                
                        matriks akhir = new matriks();
                        akhir.MakeMATRIKS(M.NBrsEff,M.NKolEff);
                        for (i=1;i<=M.NBrsEff;i++)
                        {
                                for (j=M.NKolEff+1;j<=M.NKolEff*2;j++)
                                {
                                                akhir.mem[i][j-M.NBrsEff]=M.mem[i][j];
                                }
                        }
                        return akhir;
                }
        

        void TulisGaussJordan2(matriks M )
        {
                int i,j;
                
                        matriks akhir = new matriks();
                        akhir.MakeMATRIKS(M.NBrsEff,M.NKolEff);
                        for (i=1;i<=M.NBrsEff;i++)
                        {
                                for (j=M.NKolEff+1;j<=M.NKolEff*2;j++)
                                {
                                                akhir.mem[i][j-M.NBrsEff]=M.mem[i][j];
                                }
                        }
                        akhir.TulisMATRIKS();
                }


	float IsNotWithinEpsilon(float x) {
		/* Mastiin bilangan ga di antara epsilon (10^-10) */
                if ((x < 0.0000000001) && (x > -0.0000000001)) {
                        return 0;
                }
                else {
                        return x;
                }
                        }
        
                        void InputFileEksAug (matriks M)
                        {
                                        int brs,kol;
                                        String ad;
                                        Scanner sc = new Scanner(System.in); 
                                        
                                        System.out.println("Masukkan baris dan kolom untuk matriks augmented yang ada di file yaa~");  
                                        System.out.println("Baris :");
                                        brs = sc.nextInt();
                                        System.out.println("Kolom :");
                                        kol = sc.nextInt();
                                         System.out.println("Masukkan alamat :"); 
                                         Scanner ab= new Scanner(System.in); 
                                        ad = ab.nextLine();
                                        M.MakeMATRIKS(brs,kol-1);
                                        int i,j;
                                        
                                        File file = new File(ad);
                                        try
                                        {          
                                                Scanner scan = new Scanner(file);
                                                while(scan.hasNextFloat())
                                                {
                                                        for (i=1;i<=brs;i++)
                                                        {
                                                                for (j=1;j<=kol;j++)
                                                                {
                                                                        float getData = scan.nextFloat();
                                                                        M.mem[i][j]=getData;
                                                                }
                                                        }
                                                }
                                        
                                                scan.close();
                                        }
                                        
                                        catch(FileNotFoundException ex)
                                        {
                                                System.out.println("File Tidak Ditemukan\n"); 
                                        }
                        }
                
                        
                        void InputFileEksNonAug (matriks M)
                        {
                                        int brs,kol;
                                        String ad;
                                        Scanner sc = new Scanner(System.in); 
                                        
                                        System.out.println("Masukkan baris dan kolom  matriks n x n yang ada di file yaa~");  
                                        System.out.println("Baris :");
                                        brs = sc.nextInt();
                                        System.out.println("Kolom :");
                                        kol = sc.nextInt();
                                         System.out.println("Masukkan alamat :"); 
                                         Scanner ab= new Scanner(System.in); 
                                        ad = ab.nextLine();
                                        M.MakeMATRIKS(brs,kol);
                                        int i,j;
                                        
                                        File file = new File(ad);
                                        try
                                        {          
                                                Scanner scan = new Scanner(file);
                                                while(scan.hasNextFloat())
                                                {
                                                        for (i=1;i<=brs;i++)
                                                        {
                                                                for (j=1;j<=kol;j++)
                                                                {
                                                                        float getData = scan.nextFloat();
                                                                        M.mem[i][j]=getData;
                                                                }
                                                        }
                                                }
                                        
                                                scan.close();
                                        }
                                        
                                        catch(FileNotFoundException ex)
                                        {
                                                System.out.println("File Tidak Ditemukan\n"); 
                                        }
                        }
                       
                        void InputUserAug (matriks M)
                        {
                                int brs,kol;
                                Scanner sc = new Scanner(System.in);
                                System.out.println("Masukkan untuk baris dan kolom untuk matriks augmented ya ~");  
                                System.out.println("Baris :");
                                brs = sc.nextInt();
                                System.out.println("Kolom :");
                                kol = sc.nextInt();
                                M.BacaMATRIKSAug(brs,kol);
                        }
                        
                        void InputUserNonAug (matriks M)
                        {
                                int brs,kol;
                                Scanner sc = new Scanner(System.in);
                                System.out.println("Masukkan untuk baris dan kolom matriks n x n ya ~"); 
                                System.out.println("Baris :");
                                brs = sc.nextInt();
                                System.out.println("Kolom :");
                                kol = sc.nextInt();
                                M.BacaMATRIKS(brs,kol);
                        }
                        
                        void SaveString(String j)
                        {
                                try (FileWriter writer = new FileWriter("text.txt");
                                BufferedWriter bw = new BufferedWriter(writer)) {
                   
                               bw.write(j);
                               bw.newLine();
                   
                           } catch (IOException e) {
                               System.err.format("IOException: %s%n", e);
                           }     
                                               
                        }

                        void SaveFloat(float i)
                        {
                                String j = String.valueOf(i);
                                try (FileWriter writer = new FileWriter("text.txt");
                                BufferedWriter bw = new BufferedWriter(writer)) {
                   
                               bw.write(j);
                               bw.newLine();
                   
                           } catch (IOException e) {
                               System.err.format("IOException: %s%n", e);
                           }     
                                               
                        }
                 
                        public static void main (String[] args)
                        {
                                matriks M = new matriks ();
                                matriks P = new matriks ();
                                P.Interpolasi();
                                M.InterpolasiBigDecimal();
                                
                        }
                }

