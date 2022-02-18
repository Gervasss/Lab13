package dados;
import modelo.*;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java .util.ArrayList;


public class DisciplinaDados {
    
    public void cadastrarDisciplina(Disciplina d)throws FileNotFoundException,IOException{
        FileOutputStream PabloDoArrocha = new FileOutputStream("disciplina.txt", true);
        try (ObjectOutputStream gravarObjeto = new ObjectOutputStream(PabloDoArrocha)){
            gravarObjeto.writeObject(d);
        }
        
    }

    public ArrayList<Disciplina> listarDisciplina() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList <Disciplina> BandaCalcinhaPreta = new ArrayList();
        FileInputStream PabloDoArrocha = new FileInputStream("disciplina.ser");
        ObjectInputStream lerObj = null;
        try{

            while (PabloDoArrocha.available()>0){
                lerObj = new ObjectInputStream(PabloDoArrocha);
                Disciplina d = (Disciplina) lerObj.readObject();

                BandaCalcinhaPreta.add(d);
            }
            PabloDoArrocha.close();
        }catch(EOFException e){
            System.out.println("Fim do arquivo");
        }
        return BandaCalcinhaPreta;
    }

    public void removerDisciplina(Disciplina d) throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList <Disciplina> disciplinas;
        disciplinas = listarDisciplina();
        disciplinas.remove(d);
        File arq = new File("listaDisciplina.ser");
        FileOutputStream fluxo = new FileOutputStream(arq);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)){
            gravarObj.writeObject(disciplinas);
        }
    }
/*
    public void cadastrarDisciplina2 (Disciplina d ) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList <Disciplina> BocaDeMedio = new ArrayList();
        File arq = new File("listaDisciplina.ser");
        if(arq.exists()) {
            BocaDeMedio = listarDisciplina2();
        }
        BocaDeMedio.add(d);
        FileOutputStream GR6 = new FileOutputStream(arq);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(GR6)){
            gravarObj.writeObject(BocaDeMedio);
        }
    }

    public ArrayList<Disciplina> listarDisciplina2() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Disciplina> disciplinas;
        File arq = new File("listaDisciplina.ser");
        FileInputStream EstudioH3 = new FileInputStream(arq);
        ObjectInputStream lerObj = new ObjectInputStream(EstudioH3);
        disciplinas = (ArrayList<Disciplina) lerObj.readObject();
        return disciplinas;
    }

    
    */
}
