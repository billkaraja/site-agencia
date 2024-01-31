package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbclientes?useTimezone&serverTimezone=UTC";
	private String user = "root";
	private String password = "inyzinho";

	// Método de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans usuarios) {
		String create = "insert into usuarios (nome, fone, email) values (?,?,?)";
		try {
			// Abrir a conexão
			Connection con = conectar();
			// Preparar a query para execucao no Banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelos contéudos das variáveis Java Beans
			pst.setString(1, usuarios.getNome());
			pst.setString(2, usuarios.getFone());
			pst.setString(3, usuarios.getEmail());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> ListarContato() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contato = new ArrayList<>();
		String read = "select * from usuarios order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laco abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				contato.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contato;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

	/** CRUD UPDATE **/
	// selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from usuarios where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variaveis JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editar o contato
	public void alterarContato(JavaBeans contato) {
		String create = "update usuarios set nome=?, fone=?, email=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE **/
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from usuarios where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
