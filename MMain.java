package com.bd.java;
import com.bd.java.Conexao;
import java.util.Scanner;
import java.util.NoSuchElementException;
import com.bd.*;


public class Principal 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Bem vindo.\n Esta aplicação registra débitos particulares.\n Você pode cadastrar clientes com débitos na empresa.");
		
		Scanner s_option = new Scanner(System.in);
		int option=-1;
		Conexao c = new Conexao();
		while(option != 0) 
		{
			System.out.println("Escolha uma opção: \n1 - Cadastrar Cliente\n2 - Alterar Dados do Cliente \n3 - Visualizar Dados de Cliente Especifico \n4 - Ver Todos os Cadastros.\n5 - Deletar Cadastro \n0 - Sair");
			 option = s_option.nextInt();
			if(option == 1) 
			{//
				System.out.println("Adicionar Cadastro do Cliente !! ");
				c.inserir();
			
			}else if(option == 2)
			{//
				System.out.println("Alterar Cadastro do Cliente !! ");
				c.alterar();
				option =-1;
			}else if(option == 3)
			{//
				System.out.println("Visualizar Cadastro do Cliente !! ");
				c.select();
				option =-1;
			}else if(option == 4)
			{//
				System.out.println("Visualizar todos Cadastros de Clientes !!");
				c.select2();
				option =-1;
			}else if(option == 5)
			{//
				System.out.println("Deletar Cadastro de Cliente !!");
				c.delete();
				option =-1;
				
			}else 
			{
				System.out.println("Sessão Finalizada!");
			}
			
			
			}
		
		
		
		//c.connect();
		
	

	}

}
