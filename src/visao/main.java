package visao;

public static String menu(){
        return "Digite:\n " +
        "1 - Cadastrar disciplina \n " +
        "2 - Pesquisar disciplina\n "+
        "3 - Listar disciplinas \n "+
        "0 - para sair ";
    }


public static void main(String[] args) {
    ControleDisciplina cd = new ControleDisciplina();
    int op;
    op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
    while (op!=0){
        switch (op){
            case 1:{ 
                try{
                    String nome = JOptionPane.showInputDialog("Informe o nome da disciplina : ");
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o coigo da disciplina : "));
                    int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga Horaria : "));
                    controleDisciplina.cadastrarDisciplina(nome, codigo, cargaHoraria);
                    JOptionPane.showMessageDialog(null,"Nova disciplina cadastrada com sucesso !");

                }catch (FileNotFoundException | IOException | ClassNotFoundException e) {
                    System.out.println("Erro");
                }
            break;
            }
            case 2:{ 
                try{
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o coigo da disciplina : "));
                    Disciplina disciplina = controleDisciplina.pesquisarDisciplina(codigo);
                    if (disciplina == null) {
                        JOptionPane.showMessageDialog(null,"Disciplina não encontrada !");
                    } else {
                        JOptionPane.showMessageDialog(null,"DIsciplina encontrada !");
                    }
                }catch (FileNotFoundException | IOException | ClassNotFoundException e) {
                    System.out.println("Erro");
                }
            break;
            }
            case 3: {
                
                ArrayList<Disciplina> calmaMoreno = controleDisciplina.listarDisciplina();
                String saida = "";
                for(Disciplina d: calmaMoreno){
                    saida += d.imprimir() + "\n";
                }
                JOptionPane.showMessageDialog(null, saida);


            break;
            }
        }
        op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
    }
}
}
