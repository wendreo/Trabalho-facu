package org.salao.beleza.backand.disponibilidade;


import org.salao.beleza.backand.z.utils.GenericService;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.DISPONIBILIDADE_PATH)
public class DisponibilidadeService extends GenericService<DisponibilidadeEntity, Long>{

}
