/**
 * 
 */
package br.com.knight.usuario;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.UndertowFraction;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * @author rogerio
 *
 */
public class Boot {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm(args);		
		swarm.fraction(new UndertowFraction().createDefaultFraction().httpPort(8082));		
		swarm.start();
		
		WARArchive deployment = ShrinkWrap.create(WARArchive.class);
        deployment.staticContent();
        deployment.addPackages(true, Package.getPackage("br.com.knight.usuario"));         
        deployment.addAllDependencies();                
		swarm.deploy(deployment);
	}
}
