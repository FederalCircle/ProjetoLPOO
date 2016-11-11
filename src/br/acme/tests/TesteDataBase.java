package br.acme.tests;
import java.io.*;
import java.util.Scanner;

public class TesteDataBase {
	
	public static void main(String[] args)throws IOException{
		Scanner ler = new Scanner(System.in);
		FileOutputStream arquivoGrav = new FileOutputStream("files\\Produtos.dat",true);
		int i, n;
		System.out.printf("Informe o número para a tabuada:\n");
		n = ler.nextInt();
		FileWriter arq = new FileWriter("teste");
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("+--Resultado--+%n");
		for (i=1; i<=10; i++) {
		gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
		}
		gravarArq.printf("+-------------+%n");
		arq.close();
		System.out.printf("\nTabuada do %d foi gravada com sucesso em \"d:\\tabuada.txt\".\n", n);
		}
				
	}

