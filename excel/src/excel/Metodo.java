package excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Metodo {

	public void semTaxa() throws IOException, InterruptedException {

		InputStream is = new FileInputStream("produtos2.csv"); // Lê o byte de um arquivo
		InputStreamReader isr = new InputStreamReader(is); // classe que traduz os bytes em char
		BufferedReader br = new BufferedReader(isr); // classe que concatena os chars e transforma em string através do método readline
		double soma = 0;
		double somaTaxa=0;
		String s = br.readLine();
		s = br.readLine();
		int contador = 0;
		while (s != null) {
			StringTokenizer st = new StringTokenizer(s, ";");
			s = br.readLine();
			String codigo = st.nextToken();
			String nome = st.nextToken();
			Double preco = Double.parseDouble(st.nextToken());
			Double taxa = Double.parseDouble(st.nextToken());
			String tipo = st.nextToken();
			soma += preco;
			double Vtaxa = preco + preco*(taxa/100);
			somaTaxa+= Vtaxa;
			System.out.print("\nCódigo: " +codigo+ " | Nome: " +nome+ " | Taxa: " +taxa+ "% | Tipo: " +tipo+"\n");
			System.out.println("Preço sem Taxa: R$" +preco); 
			System.out.printf( "Preço com Taxa: R$%.2f",Vtaxa);
			System.out.println();
			System.out.println("===============================================================================\n");
			contador++;

		}
		Thread.sleep(3000);
		JOptionPane.showMessageDialog(null,">Quantidade de Produtos: " +contador+ "\n>O valor total dos produtos sem taxa é de R$" +soma+ String.format("\n>O valor total dos produtos com taxa é de R$%.2f", somaTaxa));
		br.close();	

	}	

}
