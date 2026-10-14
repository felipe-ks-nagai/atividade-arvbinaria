import java.util.Scanner;
import ArvoreHeap.ArvoreHeap;

public class ArvoreConsultaHeap {
    public static void main(String[] args) {
       
   
    Scanner sc = new Scanner(System.in);
    int quantidade = sc.nextInt();
    sc.nextLine();
    String[] resultado = new String[quantidade];
    for (int i = 0; i < quantidade; i++) {
        ArvoreHeap arvore = new ArvoreHeap();
        String valores = sc.nextLine();
        resultado[i] = arvore.insereNos(valores);
    }
    for (String r : resultado) {
        System.out.println(r);
    }
    sc.close();
    }
}
