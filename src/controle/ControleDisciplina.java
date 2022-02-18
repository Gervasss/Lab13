package controle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import modelo.*;



public class ControleDisciplina {
    
    public void cadastrarDisciplina(Disciplina d) throws FileNotFoundException, IOException{
        Disciplina disc = new Disciplina();
        disc.cadastrarDisciplina(d);
    }

    
    public ArrayList<Disciplina> listarDisciplina() throws FileNotFoundException, ClassNotFoundException, IOException {
        Disciplina disciplina = new Disciplina();
        return disciplina.listarDisciplina();
    }
    

    public Disciplina pesquisarDisciplina (int codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Disciplina> MonkbelAoVivo = this.listarDisciplina();
        Disciplina d=null;
        for (int i=0; i<MonkbelAoVivo.size(); i++){
            if (codigo==MonkbelAoVivo.get(i).getCodigo()){
            d= MonkbelAoVivo.get(i);
            break;
            }
        }
        return d;
    } 

    public String imprimirDisciplina () throws FileNotFoundException, IOException, ClassNotFoundException{
        String res = "";
        ArrayList<Disciplina> disc = listarDisciplina();
        for (int i=0; i<disc.size(); i++){
            res += disc.get(i).imprimir();
        }
        return res;
    }
}
