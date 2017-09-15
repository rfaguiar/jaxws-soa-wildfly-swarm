package br.com.knight.estoque;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Boot {

	public static void main(String[] args) throws Exception {
				
		Swarm swarm = new Swarm();
		
		JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
//		ClassLoader classLoader = Boot.class.getClassLoader();
//		deployment.addAsWebInfResource(classLoader.getResource("beans.xml"),"beans.xml");
//		deployment.addAsWebInfResource(classLoader.getResource("persistence.xml"),"classes/META-INF/persistence.xml");
		     
		deployment.addPackages(true, Package.getPackage("br.com.knight.estoque"));
		deployment.addAllDependencies();
		swarm.start();
		swarm.deploy(deployment);
	}
}
