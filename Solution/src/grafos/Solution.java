package grafos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {
	
    static int diagonalDifference(int[][] arr, int n) {
        int i;
        int j; 
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for( i=0; i<n;i++){
            for(j=0; j<n;j++){
                if(i==j){
                    primaryDiagonalSum += arr[i][j];
                }
            }
        }
        
        for( i=n; i>0;i--){
            for(j=n; j>0;j--){
                if(i == n - 1 - j){
                    secondaryDiagonalSum += arr[i][j];
                }
            }
        }

        int resultado = primaryDiagonalSum - secondaryDiagonalSum;
        if (resultado<0) {
        	resultado = resultado * (-1);
        }
        return resultado;
    }


	public static void main(String [] args) throws IOException {
    	
    	
    	Path path = Paths.get("C:\\Users\\regio\\Workspaces\\testSefaz\\Solution\\src\\grafos\\test.txt");
    	List<String> linhasArquivo = Files.readAllLines(path);
    	
//    	ENTRADA
    	
//    	PRIMEIRA LINHA CARACTER
//    	SEGUNDA LINHA FREQUENCIA
    	
    	
    	
//    	SAIDA
    	
//    	PRIMEIRA LINHA CARACTER
//    	SEGUNDA LINHA CODIGO
    	
    	
//    	ALGORITMO ÁRVOREDEHUFFMAN
//    	PROCEDURE ÁRVOREDEHUFFMAN (VAR L: LISTA DE VÉRTICES);
//    	{CADA VÉRTICE EM L TEM UMA FREQÜÊNCIA ASSOCIADA, E L É ORDENADO PELA SUA FREQÜÊNCIA CRESCENTE; ESTE
//    	PROCEDIMENTO CONSTRÓI A ÁRVORE DE HUFFMAN}
//    	BEGIN
//    	FOR I: = 1 TO M — 1 DO
//    	BEGIN
//    	CRIA O NOVO VÉRTICE Z
//    	SEJAM X, V OS PRIMEIROS DOIS VÉRTICES DE L {VÉRTICES DE MENORES FREQÜÊNCIAS)
//    	F(Z): =F(X)+F(Y);
//    	INSIRA O VÉRTICE Z EM L, MANTENDO A ORDENAÇÃO;
//    	FILHO À ESQUERDA DE Z : = VÉRTICE X;
//    	FILHO À DIREITA DE Z : = VÉRTICE Y;
//    	RETIRE OS VÉRTICES X E Y DE L; {NÃO SÃO MAIS RAÍZES}
//    	END;
//    	END;
    	
    	String nString = linhasArquivo.get(0);
    	int numeroCaracteres = linhasArquivo.get(0).length();
        int n = Integer.parseInt(nString);
        int[][] matriz= new int [n][n];
        
        
        
        for (String linha : linhasArquivo) {
        	String[] numeroArray = linha.split(" ");
        	if(numeroArray.length == n) {
        		for (int i = 1; i < matriz.length - 1; i++) {
            		for (int j = 0; j < numeroArray.length - 1; j++) {
                		matriz[i][j] = Integer.parseInt(numeroArray[i]);
        			}
    			}
        	}
            System.out.println( linha );
        }
        int result = diagonalDifference(matriz, n);
        
        System.out.println("Numero de linhas e colunas = " + n + "\n" + "Diferenca da diagonal = " + result);
    }
}
