package com.bwit.service.telefonica;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pe.bwit.tpd.migracion.consultadatoscliente.ejb.sb.DatosClienteEJBRemote;
import pe.bwit.tpd.migracion.consultadatoscliente.ws.types.auditschema.AuditRequest;
import pe.bwit.tpd.migracion.consultadatoscliente.ws.types.schema.ConsultarRequest;
import pe.bwit.tpd.migracion.consultadatoscliente.ws.types.schema.ConsultarResponse;

@SpringBootApplication
public class ProyBwitServiceTelefonicaApplication {

	private static Context ctx;
	// PRIMERA FORMA
	public static void setUp() throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		env.put(Context.PROVIDER_URL, "ejbd://localhost:4201");
		ctx = new InitialContext(env);
	}
	
	public void executeRemoteEJBTest() throws NamingException {
		DatosClienteEJBRemote ejbRemote = (DatosClienteEJBRemote) ctx.lookup("DatosClienteEJBRemote");
		ConsultarRequest request = new ConsultarRequest();
		request.setAuditRequest(new AuditRequest());
		request.setNroDoc("12312312");
		request.setTipoDoc("DNI");
		ConsultarResponse response = ejbRemote.consultarTipoLineaDatosCliente(new ConsultarRequest());
		System.out.println(response);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProyBwitServiceTelefonicaApplication.class, args);
	}
	
	// SEGUNDA FORMA
		@Bean
		public Context context() throws NamingException {
			Properties jndiProps = new Properties();
			jndiProps.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
//	        jndiProps.put("jboss.naming.client.ejb.context", true);
			jndiProps.put("java.naming.provider.url", "t3://127.0.0.1:7003");
			return new InitialContext(jndiProps);
		}

		private String getFullName(Class classType) {
			String moduleName = "spring-ejb-remote/";
			String beanName = classType.getSimpleName();
			String viewClassName = classType.getName();

			return moduleName + beanName + "!" + viewClassName;
		}

//		@Bean
//		public ConsultarResponse consultarTipoLineaDatosCliente(Context context) throws NamingException {
//			return (ConsultarResponse) context.lookup();
//		}

}
