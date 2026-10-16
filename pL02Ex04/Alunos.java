

public class Alunos {
        String RA;
        String materia;
        int rendimento;
    

    public String getRA() {
            return RA;
        }


        public void setRA(String rA) {
            RA = rA;
        }


        public String getMateria() {
            return materia;
        }


        public void setMateria(String materia) {
            this.materia = materia;
        }


        public int getRendimento() {
            return rendimento;
        }


        public void setRendimento(int rendimento) {
            this.rendimento = rendimento;
        }


    public Alunos(String RA, String materia, int rendimento) {
        this.RA = RA;
        this.materia = materia;
        this.rendimento = rendimento;
    }
}
