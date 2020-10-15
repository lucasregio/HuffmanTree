package solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Solution {
	
    static int diagonalDifference(int arr[][], int n) {
        int i,j; 
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


	public static void main(String args[]) throws IOException {
    	
    	
    	Path path = Paths.get("C:\\Users\\regio\\Workspaces\\testSefaz\\Solution\\src\\solution\\test.txt");
    	List<String> linhasArquivo = Files.readAllLines(path);
    	String nString = linhasArquivo.get(0);
        int n = Integer.parseInt(nString);
        int matriz[][]= new int [n][n];
        for (String linha : linhasArquivo) {
        	String numeroArray[] = linha.split(" ");
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
