
package br.com.knight.estoque.servico.excecoes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import br.com.knight.estoque.servico.UsuarioFaultInfo;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.knight.estoque.servico.excecoes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UsuarioNaoAutorizado_QNAME = new QName("http://servico.estoque.knight.com.br/excecoes/", "UsuarioNaoAutorizado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.knight.estoque.servico.excecoes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioFaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/excecoes/", name = "UsuarioNaoAutorizado")
    public JAXBElement<UsuarioFaultInfo> createUsuarioNaoAutorizado(UsuarioFaultInfo value) {
        return new JAXBElement<UsuarioFaultInfo>(_UsuarioNaoAutorizado_QNAME, UsuarioFaultInfo.class, null, value);
    }

}
