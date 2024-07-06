package com.eleodoro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eleodoro.conexao.Conexao;

public class LoginDao {

    /**
     * @param loginPojo
     */
    public void cadastrarLogin(LoginPojo loginPojo) {

        Conexao conexao = new Conexao();

        String sql = "insert into login (nome, senha) values (?, ?)";

        PreparedStatement ps = null;


        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, loginPojo.getNome());
            ps.setString(2, loginPojo.getSenha());

            ps.execute();
            ps.close();

            System.out.println("Dados gravados com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método cadastrar login");
        }
    }

    public void consultarLogin(LoginPojo loginPojo) {

        Conexao conexao = new Conexao();

        String sql = "select * from login where Id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps = setInt(1, loginPojo.getId());


            rs = ps.executeQuery();

            while (rs.next()) {

                loginPojo.setId(rs.getInt(1));
                loginPojo.setNome(rs.getString(2));
                loginPojo.setSenha(rs.getString(3));
            }

            rs.close();
            ps.close();

            System.out.println("Consulta com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo consultar");
        }
    }

    private PreparedStatement setInt(int i, Object id) {
        // TOD0 Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInt'");
    }

    public void incluirLogin(LoginPojo loginPojo) {
        Conexao conexao = new Conexao();

        String sql = "update login set nome = ?, senha = ? where id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, loginPojo.getNome());
            ps.setString(2, loginPojo.getSenha());
            ps.setInt(3, (int) loginPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Inclusão com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo ao atualizar");
        }

    }


    public void excluirLogin(LoginPojo loginPojo) {
        Conexao conexao = new Conexao();

        String sql = "delete from login where id = ?";

        PreparedStatement ps = null;

  
        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, (int) loginPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Exclusão com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método de exclusão");
        }
    }

    public void atualizarLogin(LoginPojo loginPojo) {
        // TOD0 Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarLogin'");
    }
}
    
