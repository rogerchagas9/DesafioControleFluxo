
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        //selecaoCandidatos();
        //imprimirSelecionados();
        String [] candidatos = {"MARIA", "JOAO", "CARLOS", "ROGER", "MARCELA"};
        for (String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) 
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");
        }while (continuarTentando && tentativasRealizadas <3);
        
        if(atendeu)
        System.out.println("CONSEGUIMOS CONTATO COM: "+ candidato + " NA " + tentativasRealizadas + " TENTATIVA!");
        else
            System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato + " NUMERO MAXIMO DE TENTATIVAS ATINGIDO: " + tentativasRealizadas);
    }

    //método auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"MARIA", "JOAO", "CARLOS", "ROGER", "MARCELA"};
        System.out.println("Imprimindo a lista de candidatos, informando o indice do elemento");
        for (int indice=0; indice < candidatos.length;indice++){
            System.out.println("O candidato de número: " + indice + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi: " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] canditados = {"MARIA", "JOAO", "CARLOS", "ROGER", "MARCELA", "CARLA", "DANIELA", "PATRICIA", "FELIPE", "JOANA"};
        int candidatosSelecionados = 0;
        int canditadoAtual = 0;
        double salarioBase = 2000.00;

        while(candidatosSelecionados < 5 && canditadoAtual < canditados.length ){
            String canditado = canditados[canditadoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O canditato: " +canditado+" solicitou: "+salarioPretendido);
        
            if (salarioBase >=salarioPretendido) {
                System.out.println("O canditato: "+ canditado + " foi selecionado!");
               candidatosSelecionados++; 
            }
            canditadoAtual++;
        }
    }

    
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2200.00;
        if (salarioBase>salarioPretendido) {
            System.out.println("Ligar para o candidato");
        }else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contraproposta");
        }else{
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
