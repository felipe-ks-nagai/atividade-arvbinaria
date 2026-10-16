import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class AlunosConsulta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string[] = sc.nextLine().split(" ");
        int quantidade = Integer.parseInt(string[0]);
        int selecao = Integer.parseInt(string[1]);

        PriorityQueue<Alunos> alunos = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.getRendimento(), a.getRendimento())
        );

        for(int i = 0; i < quantidade; i++) {
            String[] aluno = sc.nextLine().split(" ");
            String RA = aluno[0];
            String materia = aluno[1];
            int rendimento = Integer.parseInt(aluno[2]);
            alunos.add(new Alunos(RA, materia, rendimento));
        }
        System.out.println("Alunos selecionados:");
        for(int i = 0; i < selecao; i++) {
            Alunos aluno = alunos.poll();
            System.out.println(aluno.getRA() + " " + aluno.getMateria() + " " + aluno.getRendimento());
        }
        sc.close();
    }
}