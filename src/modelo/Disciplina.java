package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import dados.*;

import dados.DisciplinaDados;

public class Disciplina  {
    private String nome;
    private int codigo;
    private int cargaHoraria;
    
    public Disciplina (){}

    public Disciplina (String nome){
        this.nome=nome;
    }

    public Disciplina (String nome, int codigo, int ch){
        this.nome=nome;
        this.codigo=codigo;
        this.cargaHoraria=ch;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String imprimir(){
        return "Nome: " + this.getNome() + "\nCodigo: " + this.getCodigo() + "\nCarga horaria: " + this.getCargaHoraria();
    }

    public void cadastrarDisciplina(Disciplina d) throws FileNotFoundException, IOException{
        DisciplinaDados discDados = new DisciplinaDados();
        discDados.cadastrarDisciplina(d);
    }

    public ArrayList<Disciplina> listarDisciplina() throws IOException, FileNotFoundException, ClassNotFoundException{
        DisciplinaDados dd = new DisciplinaDados();
        ArrayList <Disciplina> disc = dd.listarDisciplina();
        return disc;
        
        }
}
