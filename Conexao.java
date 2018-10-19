package com.bd.java;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
import com.bd.java.Pessoa;

public class Conexao 
{
	//DADOS DA CONEXAO
	private final String url = "jdbc:mysql://localhost/nexti?useTimezone=true&serverTimezone=UTC";
	private final String user = "root";
	private final String password = "";
	//DADOS DA CONEXAO
	
	public void inserir() 
	{
		
		Date data = new Date();
		//ID AUTOINCREMENTADO
		
		System.out.println(data.toString());
		String d_data = data.toString();
		Scanner name = new Scanner(System.in);
		
		System.out.println("informe o nome do cliente - SOMENTE LETRAS");/////////////Solicita
		String nome = name.nextLine();
		int app = 1;
		
		System.out.println("Informe o Saldo - SOMENTE NUMEROS");//////////////////////Solicita
		Scanner s_saldo1 = new Scanner(System.in);
		Double saldo1 = s_saldo1.nextDouble();
		
		Connection conn = null; //Preparando a variavel da conexao.
		String nula = "null";
		try 
		{
			
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO cliente2 (nome,saldo,d_data,app) VALUES ('" + nome + "','" + saldo1 + "','"+ d_data +"','" + app +"')";  
			PreparedStatement statement = conn.prepareStatement(sql);  
		  
		    statement.executeUpdate(sql);
		    
		 }catch(SQLException e)
		{
			System.out.println("Erro ao adicionar" + e.getMessage());
			
		}
		System.out.println("Adicionado.");
	}
	
	
public void delete()
{
		try
		{
			Connection delete = null;
			System.out.println("Informe o Numero Identificador do cliente que será excluído da base de dados.");
		    Scanner ref = new Scanner(System.in);
			String reference = ref.nextLine();
		    delete = DriverManager.getConnection("jdbc:mysql://localhost/nexti?useTimezone=true&serverTimezone=UTC", "root", "");
		    String query = "DELETE FROM cliente2 WHERE ID = " + reference +"";
		 	Statement statement = delete.createStatement();
			
			statement.execute(query);
			delete.close();
			
		}catch(Exception e)
		{
			System.out.println("Erro ao excluir" + e.getMessage());
		}
	System.out.println("Deletado!");
	}
public void select() 
{
	String url = "jdbc:mysql://localhost/nexti?useTimezone=true&serverTimezone=UTC";
	try 
	{
		Connection select = null;
		
		System.out.println("Informe o Numero Identificador do Cliente para exibir seus dados.");
		
		Scanner selecionar = new Scanner(System.in);
		String reference = selecionar.nextLine();
		
		
		select = DriverManager.getConnection(url, "root", "");
		
	
			
			String sql = "SELECt * FROM cliente2 WHERE id = "+reference+"";
			Statement statement = select.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) 
			{
				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				float saldo1 = rs.getFloat("saldo");
				String data = rs.getString("d_data");
			
				System.out.println("ID | NOME | SALDO | DATA ");
				System.out.println("===================================================");
				System.out.println("| " +id +" | " + nome+" | " + saldo1 + " |" + data +"|");
				System.out.println("===================================================");
			
			}
			
			rs.close();
	
	}catch(SQLException e) 
	{
		System.out.println(e.getMessage());
		
	}
	
}
public void select2() 
{
	String url = "jdbc:mysql://localhost/nexti?useTimezone=true&serverTimezone=UTC";
	try 
	{
		Connection select = null;
		
		
		select = DriverManager.getConnection(url, "root", "");
		try
		{
			String sql = "SELECt * FROM cliente2";
			Statement statement = select.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("ID , Nome, Saldo, Data\n");
			
			while(rs.next()) 
			{
				System.out.println(rs.getString("id") + "," + rs.getString("nome") +","+ rs.getString("saldo") +","+rs.getString("d_data")+ "\n\n");
				/* int id = rs.getInt("id");
				String nome = rs.getString("nome");
				float saldo1 = rs.getFloat("saldo_minus");
				float saldo2 = rs.getFloat("saldo_max");
				System.out.println("ID | NOME | SALDO NEGATIVO | SALDO POSITIVO");
				System.out.println("==============================================");
				System.out.println("| " +id +" | " + nome+" | -" + saldo1 + " || " + saldo2+". ||");
				System.out.println("==============================================");
				 */
			}
			rs.close();
		}catch(SQLException x)
		{
			System.out.println("Dados nao encontrados "+x.getErrorCode()); 
		}
		
		

		
		
	}catch(SQLException e)
	{
		System.out.println(e.getMessage());
		
	}
}
public void alterar() 
{
	String url = "jdbc:mysql://localhost/nexti?useTimezone=true&serverTimezone=UTC";
	Connection select = null;
	Connection update = null;
	try 
	{
		select = DriverManager.getConnection(url, "root", "");
		update = DriverManager.getConnection(url, "root", "");
		int option = -1;
		while(option != 0) 
		{
			System.out.println("1 - Alterar Nome \n2 - Acrescentar Saldo Positivo \n3 - Acrescentar Saldo Negativo \n0 - Voltar ao menu Anterior");
			Scanner opt = new Scanner(System.in);
			
			option = opt.nextInt();
			if(option == 1) 
			{
				System.out.println("Alterar Nome do Cliente");
				System.out.println("Informe o Numero Identificador do Cliente para prosseguir com a alteração do nome.");
				Scanner s_id = new Scanner(System.in);
				String id = s_id.nextLine();
				String sql = "SELECT * FROM cliente2 WHERE id = "+ id+"";
				Statement stm = select.prepareStatement(sql);
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) 
				{
					
					int id2 = rs.getInt("id");
					String nome2 = rs.getString("nome");
					float saldo1 = rs.getFloat("saldo");
				
					System.out.println("ID | NOME | SALDO ");
					System.out.println("==============================================");
					System.out.println("| " +id2 +" | " + nome2+" | " + saldo1 +" ||");
					System.out.println("==============================================");
				
				}
				System.out.println("Informe o NOVO nome.");
				Scanner s_nome = new Scanner(System.in);
				String nome = s_nome.nextLine();
				String sql2 = "UPDATE cliente2 SET nome = '"+ nome+"' WHERE id = " + id + "";
				
				
				
				
				
				
				PreparedStatement stm2 = update.prepareStatement(sql2);
				int rs2 = stm2.executeUpdate(sql2);
				
				System.out.println("Alterado, confira.");
				
				rs.close();
				
			}else if(option == 2) 
			{
				
				System.out.println("Acrescentar Saldo Positivo");
				System.out.println("Informe o Numero Identificador do Cliente para prosseguir com a alteração do saldo.");
				Scanner s_id = new Scanner(System.in);
				String id = s_id.nextLine();
				String sql = "SELECT * FROM cliente2 WHERE id = "+ id+"";
				Statement stm = select.prepareStatement(sql);
				ResultSet rs = stm.executeQuery(sql);
				
				while(!rs.next()) 
				{
					
					int id2 = rs.getInt("id");
					String nome2 = rs.getString("nome");
					float saldo1 = rs.getFloat("saldo");
				
					System.out.println("ID | NOME | SALDO ");
					System.out.println("==============================================");
					System.out.println("| " +id2 +" | " + nome2+" | " + saldo1 +" ||");
					System.out.println("==============================================");
				
				}
				System.out.println("Informe o saldo a Inserir.");
				Scanner s_saldo = new Scanner(System.in);
				float saldo = s_saldo.nextFloat();
				//float saldo2 = rs.getFloat("saldo_max");
				float saldo2 = saldo + rs.getFloat("saldo");
				
				
				
			
				
				String sql2 = "UPDATE cliente2 SET saldo = '"+ saldo2 +"' WHERE id = " + id + "";
				
				
				PreparedStatement stm2 = update.prepareStatement(sql2);
				float rs3 = stm2.executeUpdate(sql2);
				
				System.out.println("Acrescentado! Confira Abaixo\n\n");
				
				rs.close();
				
			}else
			{
				
				
				
			}
		}
		
		
}catch(SQLException e) {
	System.out.println("Erro " + e.getMessage());
}
}
}
