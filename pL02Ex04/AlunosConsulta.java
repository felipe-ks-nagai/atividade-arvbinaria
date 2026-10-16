import java.util.Scanner;
import java.util.ArrayList;



public class AlunosConsulta {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Alunos> alunos = new ArrayList<>();
        String string = sc.nextLine();
        int quantidade = Integer.parseInt(string.split(" ")[0]);
        int selecao = Integer.parseInt(string.split(" ")[1]);

        for(int i = 0; i < quantidade; i++){
            String[] aluno = sc.nextLine().split(" ");
            String RA = aluno[0];
            String materia = aluno[1];
            int rendimento = Integer.parseInt(aluno[2]);
            alunos.add(new Alunos(RA, materia, rendimento));
        }
        alunos.sort((a, b) ->  Integer.compare(b.getRendimento(), a.getRendimento()));
        System.out.println("Alunos Selecionados:");
        for(int i = 0; i < selecao; i++){
            System.out.println(alunos.get(i).getRA() + " " + alunos.get(i).getMateria() + " " + alunos.get(i).getRendimento());
        }
        sc.close();
    }
}
