/*
Entrega do Trabalho 3- Algoritmos e Programação II
Eu,
André G. Padovezi
declaro que
todas as respostas são fruto de meu próprio trabalho,
não copiei respostas de colegas externos,
não disponibilizei minhas respostas para colegas externos e
não realizei quaisquer outras atividades desonestas para me beneficiar ou
prejudicar outros.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dicionário {
    public static void main(String[] args) throws IOException {
        //Declaração de variaveis
        String Ls, ls;
        String Dicio[] = new String[1000];
        int Cont = 0;
        int qt = 0;
        //Definição do arquivo a ser lido
        BufferedReader br = new BufferedReader(new FileReader("Livro"));
        //Leitura do arquivo
        while ((Ls = br.readLine()) != null) {
            // Verifica presença do caractere de parada na condição de parada
            if (Ls.length() == 1){
                if (Ls.contains(".")) {
                    break;
                }
            }
            // Caso a linha não esteja em branco adiciona seu conteúdo ao vetor.
            if (Ls.length() > 0) {
                ls = Ls.toLowerCase();
                String Retalho[] = ls.split(" ", -1);
                for (int o = 0; o < Retalho.length; o++) {
                    Dicio[Cont] = Retalho[o];
                    Cont = Cont + 1;
                }

            }
        }
        //Passa o conteúdo preenchido do vetor Dicio para o Vetor que realizará o processamento
        String Processamento[] = new String[Cont];
        for (int g = 0; g < Cont; g++){
            Processamento[g] = Dicio[g];
        }
        //Processamento para ordem Lexicográfica
        //Resposnável por determinar a posição de teste (Ex: Primeira posição)
        for (int i = 0; i < Processamento.length; i++){
            //Responsável por determinar qual valor será testado com a posição de teste
            for (int k = i+1; k< Processamento.length; k++){
                //Strings recebem o valor das posições sendo verificadas
                String Y = Processamento[i];
                String x = Processamento[k];
                // Strings são parocessadas utilizando o metodo compare to
                for (int z = 0; z < Y.length(); z++){
                    int verificar = Y.compareTo(x);
                    //Caso os valores sejam iguais substitui o segundo valor(k) por -1
                    if (verificar == 0){
                        Processamento[k] = "-1";
                    }
                    // Realiza a inversão caso necessário
                    if (verificar > 0){
                        String Temp = Processamento[i];
                        Processamento[i] = Processamento[k];
                        Processamento[k] = Temp;
                        break;
                    }
                    // Caso não seja necessária inversão encerra o loop
                    if (verificar < 0){
                        break;
                    }
                }
            }
        }
        //Saída de Dados
        for (String s : Processamento){
            /*Imprime somente os valores que são diferentes de -1 (palavras repetidas) e realiza a contagem
            de palavras do dicionário*/
                if (s != "-1"){
                    System.out.println(s);
                    qt = qt +1;
                }
        }
        //Saída da contagem de palavras
        System.out.println("total de palavras no dicionario = " + qt);
    }

}
