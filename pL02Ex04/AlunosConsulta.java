package pL02Ex04;

import java.util.Scanner;
import java.util.ArrayList;

import pL02Ex04.AlunosEntity.Alunos;

public class AlunosConsulta {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Alunos> alunos = new ArrayList<>();
        String string = sc.nextLine();
        int quantidade = Integer.parseInt(string.split(" ")[0]);
        int selecao = Integer.parseInt(string.split(" ")[1]);

        for(int i = 0; i < quantidade; i++){
            String aluno = sc.nextLine();
            int RA = Integer.parseInt(aluno.split(" ")[0]);
            String materia = (aluno.split(" ")[1]);
            int rendimento = Integer.parseInt(aluno.split(" ")[2]);
            alunos.add(new AlunosEntity.Alunos(RA, materia, rendimento));
        }

        alunos.sort((a1, a2) -> {
            if(selecao == 1){
                return Integer.compare(a1.RA, a2.RA);
            } else if(selecao == 2){
                return a1.materia.compareTo(a2.materia);
            } else {
                return Integer.compare(a1.rendimento, a2.rendimento);
            }
        });
    }
}
