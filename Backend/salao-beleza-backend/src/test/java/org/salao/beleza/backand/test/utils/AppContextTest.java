package org.salao.beleza.backand.test.utils;

import org.salao.beleza.backand.z.utils.AppContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackages = { "org.salao.test.salao.beleza" })
public abstract class AppContextTest {

}
