package org.salao.beleza.backand.z.utils;

public final class ServicePath {

	
	//ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";
	public static final String ROOT_PATH = "/api";
	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

	
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////

	
	public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";
	public static final String PERMISSIONCLIENTES_PATH = PUBLIC_ROOT_PATH + "/permissionclientes";	
	
	public static final String EDITUSER_PATH = PRIVATE_ROOT_PATH + "/edituser";
	public static final String USUARIOS_PATH = PRIVATE_ROOT_PATH + "/usuarios";
	public static final String CLIENTES_PATH = PUBLIC_ROOT_PATH + "/clientes";
	
	public static final String FUNCIONARIO_PATH = PRIVATE_ROOT_PATH + "/funcionario";
	public static final String FMAP_PATH = PRIVATE_ROOT_PATH + "/fmap";	
	
	public static final String AGENDAMENTO_PATH = PRIVATE_ROOT_PATH + "/agendamento";
	public static final String VIEWAGENDAMENTO_PATH = PRIVATE_ROOT_PATH + "/mostrarAgendamento";
	public static final String BUSCADATA_PATH = PRIVATE_ROOT_PATH + "/buscadata";	
	
	
	public static final String DIA_PATH = PRIVATE_ROOT_PATH + "/dia";
	public static final String DISPONIBILIDADE_PATH = PRIVATE_ROOT_PATH + "/disponibilidade";
   
    
	
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////

		
	public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";
	public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";
	

}
