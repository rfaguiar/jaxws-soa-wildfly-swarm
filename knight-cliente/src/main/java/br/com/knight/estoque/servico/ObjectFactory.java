
package br.com.knight.estoque.servico;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.knight.estoque.servico package. 
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

    private final static QName _ListarAutoresResponse_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarAutoresResponse");
    private final static QName _ListarAutores_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarAutores");
    private final static QName _Autor_QNAME = new QName("http://servico.estoque.knight.com.br/", "autor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.knight.estoque.servico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Autor }
     * 
     */
    public Autor createAutor() {
        return new Autor();
    }

    /**
     * Create an instance of {@link ListarAutoresResponse }
     * 
     */
    public ListarAutoresResponse createListarAutoresResponse() {
        return new ListarAutoresResponse();
    }

    /**
     * Create an instance of {@link ListarAutores }
     * 
     */
    public ListarAutores createListarAutores() {
        return new ListarAutores();
    }

    /**
     * Create an instance of {@link Autor.Refs }
     * 
     */
    public Autor.Refs createAutorRefs() {
        return new Autor.Refs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAutoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarAutoresResponse")
    public JAXBElement<ListarAutoresResponse> createListarAutoresResponse(ListarAutoresResponse value) {
        return new JAXBElement<ListarAutoresResponse>(_ListarAutoresResponse_QNAME, ListarAutoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAutores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarAutores")
    public JAXBElement<ListarAutores> createListarAutores(ListarAutores value) {
        return new JAXBElement<ListarAutores>(_ListarAutores_QNAME, ListarAutores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "autor")
    public JAXBElement<Autor> createAutor(Autor value) {
        return new JAXBElement<Autor>(_Autor_QNAME, Autor.class, null, value);
    }

}
