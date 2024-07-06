package com.eleodoro;

import com.eleodoro.conexao.Conexao;
import com.eleodoro.dao.LoginDao;
import com.eleodoro.dao.LoginPojo;
import com.eleodoro.login.Login;

public class LoginApplication {

	public static void main(String[] args) {

		Conexao conexao  = new Conexao();
		conexao.getConexao();

		//teste inserir

		Login LoginInserir = new Login();
		LoginInserir.setNome("Vitoria");
		LoginInserir.setSenha("biscoito");

		LoginPojo LoginPojoInserir = new LoginPojo();
		LoginPojoInserir.setNome(LoginInserir.getNome());
		LoginPojoInserir.setSenha(LoginInserir.getSenha());

		LoginDao LoginDaoInserir = new LoginDao();
		LoginDaoInserir.cadastrarLogin(LoginPojoInserir);

		//teste consulta

		Login LoguinConsultar = new Login();
		LoguinConsultar.setId(1);

		LoginPojo LoguinPojoConsultar = new LoginPojo();
		LoguinPojoConsultar.setId(LoguinConsultar.getId());

		LoginDao LoguinDaoConsultar = new LoginDao();
		LoguinDaoConsultar.consultarLogin(LoguinPojoConsultar);

		System.out.println(LoguinPojoConsultar.toString());

		//testar atualização 
		Login LoginAtualizar = new Login();
		LoginAtualizar.setId(1);
		LoginAtualizar.setNome("Vitoria Alves");
		LoginAtualizar.setSenha("bolacha");

		LoginPojo LoginPojoAtualizar = new LoginPojo();
		LoginPojoAtualizar.setId(1);
		LoginPojoAtualizar.setNome(LoginAtualizar.getNome());
		LoginPojoAtualizar.setSenha(LoginAtualizar.getSenha());

		LoginDao LoginDaoAtualizar = new LoginDao();
		LoginDaoAtualizar.atualizarLogin(LoginPojoAtualizar);

		// testar exclusão

		Login LoguinDeletar = new Login();
		LoguinDeletar.setId(1);

		LoginPojo LoguinPojoDeletar = new LoginPojo();
		LoguinPojoDeletar.setId(1);

		LoginDao LoguinDaoDeletar = new LoginDao();
		LoguinDaoDeletar.excluirLogin(LoguinPojoDeletar);
		

	}

}
