
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
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
