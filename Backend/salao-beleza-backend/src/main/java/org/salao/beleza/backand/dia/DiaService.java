package org.salao.beleza.backand.dia;

import org.salao.beleza.backand.z.utils.GenericService;
import org.salao.beleza.backand.z.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.DIA_PATH)
public class DiaService extends GenericService<Dia, Long>{

}
