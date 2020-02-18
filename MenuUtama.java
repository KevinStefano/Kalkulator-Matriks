import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
class MenuUtama {
    public static void main (String[] args) {
        /**  Ini merupakan menu utama program ini
         * Pertama, akan diset terlebih dahulu variabel exit = false, agar program dapat berjalan terus
         *  (dengan menggunakan while-do loop).
         * Lalu, pilihan menu utama akan ditampilkan. Pengguna dipersilakan untuk memilih.
         * 
        */
        boolean exit,back;
        int i,j,k,l;
        Scanner input = new Scanner(System.in);
        matriks M = new matriks();
        exit = false;
        while (exit == false) {
                back = false;
                while (back == false) {
                    clearScreen();
                System.out.println("MENU");
                System.out.println("1. Sistem Persamaan Linier");
                System.out.println("2. Determinan");
                System.out.println("3. Matriks balikan");
                System.out.println("4. Matriks kofaktor");
                System.out.println("5. Adjoin");
                System.out.println("6. Interpolasi Polinom");
                System.out.println("7. Keluar");
                    i = input.nextInt();
                    while (i<1 || i>7) {
                        System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                        i = input.nextInt();
                    }
                    clearScreen();
                    switch (i) {
                        case 1:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        j = input.nextInt();
                        while (j<1 || j>5) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                M.InputFileEksAug(M);
                                System.out.println("Solusi :");
                                M.GaussSPL();
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserAug(M);
                                System.out.println("Solusi :");
                                M.GaussSPL();
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                M.InputFileEksAug(M);
                                System.out.println("Solusi :");
                                M.GaussJordan();
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserAug(M);
                                System.out.println("Solusi :");
                                M.GaussJordan();
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 3:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                M.InputFileEksAug(M);
                                System.out.println("Solusi :");
                                M.InverseSPL(M);
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserAug(M);
                                System.out.println("Solusi :");
                                M.InverseSPL(M);
                                M.SPLParametrik(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 4:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                M.InputFileEksAug(M);
                                System.out.println("Determinan masing-masing elemen variabel :");
                                M.CramerSPL(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserAug(M);
                                System.out.println("Determinan masing-masing elemen variabel :");
                                M.CramerSPL(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 5:
                            back = true;
                            break;
                            }
                        break;
                        case 2:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        j = input.nextInt();
                        while (j<1 || j>5) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanGauss(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanGauss(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanGaussJordan(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanGaussJordan(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 3:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                M.DeterminanInversnya(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                M.DeterminanInversnya(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 4:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanKofaktor(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Determinan : "+M.DeterminanKofaktor(M));
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 5:
                            back = true;
                            break;
                        }
                        break;
                        case 3:
                        System.out.println("1. Gauss-Jordan");
                        System.out.println("2. Cramer (Kofaktor)");
                        System.out.println("3. Kembali ke menu sebelumnya");
                        j = input.nextInt();
                        while (j<1 || j>3) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Berikut adalah invers matriksnya :");
                                M.GaussJordanInverse();
                                M.TulisGaussJordan2(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Berikut adalah invers matriksnya :");
                                M.GaussJordanInverse();
                                M.TulisGaussJordan2(M);
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Berikut adalah invers matriksnya :");
                                (M.KofaktorInverse(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Berikut adalah invers matriksnya :");
                                (M.KofaktorInverse(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                            break;
                            case 3:
                            back = true;
                            break;
                        }
                        break;
                        case 4:
                        System.out.println("1. Masukan dari file");
                        System.out.println("2. Masukan pengguna");
                        k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Berikut adalah matriks kofaktornya :");
                                (M.kofaktor(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Berikut adalah matriks kofaktornya :");
                                (M.kofaktor(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                        break;
                        case 5:
                        System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.InputFileEksNonAug(M);
                                System.out.println("Berikut adalah matriks adjoinnya :");
                                (M.AdjointMatriks(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                                case 2:
                                M.InputUserNonAug(M);
                                System.out.println("Berikut adalah matriks adjoinnya :");
                                (M.AdjointMatriks(M)).TulisMATRIKS();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                        break;
                        case 6:
                        System.out.println("1. Masukan pengguna");
                            k = input.nextInt();
                            while (k!=1) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                M.Interpolasi();
                                System.out.println("Klik '9' untuk kembali ke menu utama");
                                l = input.nextInt();
                                while (l!=9) {
                                    l = input.nextInt();
                                }
                                back = true;
                                break;
                            }
                        break;
                        case 7:
                        exit = true;
                        back = true;
                        break;
                        }
                }
                
                    }
                }

    public final static void clearScreen()
{
    try
    {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
    catch (Exception E)
    {
        System.out.println(E);
        //  Handle any exceptions.
    }
}
    /*public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

    }*/
}
