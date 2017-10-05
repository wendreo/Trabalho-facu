package org.salao.beleza.backand.agendamento;

import java.util.List;

import org.salao.beleza.backand.funcionario.Funcionario;
import org.salao.beleza.backand.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{

	public List<Agendamento> findByIdUser(UserEntity idUser);
	
	public List<Agendamento> findByDataContaining(String data);
	
	//public List<Agendamento> findByDataContaining(Date data);
	
}
