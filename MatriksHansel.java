import java.util.*;

class Matriks {
    // Atribut
    float[][] Matrix = new float[100][100];
    int NBrsEff;
    int NKolEff;
    // Method
    // Konstruktor
    Matriks() {
        int i, j;
        for (i = 0; i < 100; i++) {
            for (j = 0; j < 100; j++) {
                this.Matrix[i][j] = 0;
            }
        }
        this.NBrsEff = 0;
        this.NKolEff = 0;
    }
    
    void BacaMatriks() { // Baca matriks (hanya dari input)
        int i, j;
        Scanner in = new Scanner (System.in);
        System.out.println("Masukkan m x n matriks : ");
        System.out.print("m : ");
        int m = in.nextInt();
        this.NBrsEff = m;
        System.out.println();
        System.out.print("n : ");
        int n = in.nextInt();
        this.NKolEff = n;
        System.out.println();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                this.Matrix[i][j] = in.nextInt();
                System.out.println();
            }
        }
    }

    void TulisMatriks() { // Nulis matriks ke layar
        int i, j;
        for (i = 0; i < this.NBrsEff ; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                System.out.print(this.Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void TransposeMatriks() { // Transpose hanya digunakan untuk Matrix Kofaktor
        int i, j;
        float temp;
        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                if (i != j) {
                    temp = this.Matrix[i][j];
                    this.Matrix[i][j] = this.Matrix[j][i];
                    this.Matrix[j][i] = temp;
                }
            }
        }
    }

    void InversMatriks() { // Prekondisi determinan matriks tidak nol, melakukan operasi invers matriks
        int i, j, k, l, o, p, sign;
        float det;
        Matriks Invers = new Matriks();
        Matriks Kofaktor = new Matriks();
        Matriks Inverse = new Matriks();
        Inverse.NBrsEff = this.NBrsEff;
        Inverse.NKolEff = this.NKolEff;
        Invers.NBrsEff = this.NBrsEff;
        Invers.NKolEff = this.NKolEff;
        Kofaktor.NBrsEff = this.NBrsEff;
        Kofaktor.NKolEff = this.NKolEff;
        sign = 1;
        o = 0;
        p = 0;
        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                for (k = 0; k < this.NBrsEff; k++) {
                    for (l = 0; l < this.NKolEff; l++) {
                        if (k != i && l != j) {
                            Kofaktor.Matrix[o][p] = this.Matrix[i][j];
                            o = o + 1;
                            p = p + 1;
                        }
                    }
                }
                Inverse.Matrix[i][j] = Kofaktor.Determinan() * sign;
                sign = sign * -1;
            }
        }
        Inverse.TransposeMatriks();
        det = 1 / this.Determinan();
        Inverse.KaliKons(det);
    }

    void MakeKofaktor() { // Menghasilkan matriks yang isinya determinan kofaktor
        int i, j, k, l, o, p, sign;
        Matriks KofaktorBesar = new Matriks();
        KofaktorBesar.NBrsEff = this.NBrsEff;
        KofaktorBesar.NKolEff = this.NKolEff;
        sign = 1;
        o = 0;
        p = 0;
        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                Matriks Kofaktor = new Matriks();
                for (k = 0; k < this.NBrsEff; k++) {
                    for (l = 0; l < this.NKolEff; l++) {
                        if (k != i && l != j) {
                            Kofaktor.Matrix[o][p] = this.Matrix[i][j];
                            o = o + 1;
                        }
                    }
                    if (o == this.NBrsEff-1) {
                        p = p + 1;
                    }
                }
                KofaktorBesar.Matrix[i][j] = Kofaktor.Determinan() * sign;
                sign = sign * -1;
            }
        }
    }

    void AdjointMatriks(int n) { // Membuat matriks adjoint
        Matriks KofaktorBesar = new Matriks();
        KofaktorBesar.NBrsEff = this.NBrsEff;
        KofaktorBesar.NKolEff = this.NKolEff;
        this.MakeKofaktor();
        KofaktorBesar.TransposeMatriks();
    }

    void KaliKons(float x) { // Ngaliin matriks dengan konstanta
        int i, j;
        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                this.Matrix[i][j] = this.Matrix[i][j] * x;
            }
        }
    }
}