package org.salao.beleza.backand.funcionario;

import org.salao.beleza.backand.z.utils.GenericService;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.FUNCIONARIO_PATH )
public class FuncionarioService extends GenericService<Funcionario, Long> {
	
	
	
}
