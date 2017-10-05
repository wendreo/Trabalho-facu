package org.salao.beleza.backand.agendamento;

import java.util.List;

import org.salao.beleza.backand.user.UserEntity;
import org.salao.beleza.backand.user.UserRepository;
import org.salao.beleza.backand.z.security.CurrentUser;
import org.salao.beleza.backand.z.utils.GenericService;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path=ServicePath.AGENDAMENTO_PATH)
public class AgendamentoService extends GenericService<Agendamento,Long>{
	
	


	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	
	@Override
	public List<Agendamento> findAll() {
		UserEntity idUser = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.agendamentoRepository.findByIdUser(idUser);
	}

	@Override
	public Agendamento insert(@RequestBody Agendamento agenda) {
		
	 agenda.setIdUser(this.userRepository.findByEmail(currentUser.getActiveUser().getEmail()));

		return super.insert(agenda);
	}

	@Override
	public void update(@RequestBody Agendamento  agenda) {
		validateUserRequest( agenda);

		

		super.update( agenda);
	}

	@Override
	public void delete(@RequestBody Agendamento agenda) {
		
		
		
		
		validateUserRequest( agenda);

		super.delete( agenda);
	}

	private UserEntity validateUserRequest(Agendamento  agenda) {
		UserEntity idUser = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		if ( agenda.getIdUser().getEmail().compareToIgnoreCase(idUser.getEmail()) != 0) {
			throw new SecurityException();
		}

		return idUser;
	}		
		
	



}
