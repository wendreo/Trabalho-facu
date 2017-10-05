package org.salao.beleza.backand.agendamento;

import java.util.List;

import org.salao.beleza.backand.z.utils.ServiceMap;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServicePath.BUSCADATA_PATH )
public class BuscaAgendamentoServiceMap implements ServiceMap {
	
	@Autowired
	AgendamentoRepository agendaRepository;
	
	@RequestMapping(method = {RequestMethod.POST} )	
	@ResponseBody	
	public List<Agendamento> BuscaAgendamentoServiceMap(@RequestBody BuscaAgendamento data){			
		
		return  this.agendaRepository.findByDataContaining(data.getData());		
		
		
	}

}
