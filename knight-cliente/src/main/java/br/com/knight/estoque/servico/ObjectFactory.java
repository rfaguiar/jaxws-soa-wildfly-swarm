
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

    private final static QName _CriarLivro_QNAME = new QName("http://servico.estoque.knight.com.br/", "criarLivro");
    private final static QName _ListarLivros_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarLivros");
    private final static QName _ListarLivrosPaginacaoResponse_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarLivrosPaginacaoResponse");
    private final static QName _Usuario_QNAME = new QName("http://servico.estoque.knight.com.br/", "usuario");
    private final static QName _ListarLivrosPaginacao_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarLivrosPaginacao");
    private final static QName _CriarLivroResponse_QNAME = new QName("http://servico.estoque.knight.com.br/", "criarLivroResponse");
    private final static QName _Livro_QNAME = new QName("http://servico.estoque.knight.com.br/", "livro");
    private final static QName _ListarLivrosResponse_QNAME = new QName("http://servico.estoque.knight.com.br/", "listarLivrosResponse");
    private final static QName _UsuarioNaoAutorizadoException_QNAME = new QName("http://servico.estoque.knight.com.br/", "UsuarioNaoAutorizadoException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.knight.estoque.servico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Livro }
     * 
     */
    public Livro createLivro() {
        return new Livro();
    }

    /**
     * Create an instance of {@link CriarLivroResponse }
     * 
     */
    public CriarLivroResponse createCriarLivroResponse() {
        return new CriarLivroResponse();
    }

    /**
     * Create an instance of {@link ListarLivrosResponse }
     * 
     */
    public ListarLivrosResponse createListarLivrosResponse() {
        return new ListarLivrosResponse();
    }

    /**
     * Create an instance of {@link UsuarioNaoAutorizadoException }
     * 
     */
    public UsuarioNaoAutorizadoException createUsuarioNaoAutorizadoException() {
        return new UsuarioNaoAutorizadoException();
    }

    /**
     * Create an instance of {@link ListarLivros }
     * 
     */
    public ListarLivros createListarLivros() {
        return new ListarLivros();
    }

    /**
     * Create an instance of {@link ListarLivrosPaginacaoResponse }
     * 
     */
    public ListarLivrosPaginacaoResponse createListarLivrosPaginacaoResponse() {
        return new ListarLivrosPaginacaoResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link CriarLivro }
     * 
     */
    public CriarLivro createCriarLivro() {
        return new CriarLivro();
    }

    /**
     * Create an instance of {@link ListarLivrosPaginacao }
     * 
     */
    public ListarLivrosPaginacao createListarLivrosPaginacao() {
        return new ListarLivrosPaginacao();
    }

    /**
     * Create an instance of {@link Livro.Autores }
     * 
     */
    public Livro.Autores createLivroAutores() {
        return new Livro.Autores();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarLivro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "criarLivro")
    public JAXBElement<CriarLivro> createCriarLivro(CriarLivro value) {
        return new JAXBElement<CriarLivro>(_CriarLivro_QNAME, CriarLivro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLivros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarLivros")
    public JAXBElement<ListarLivros> createListarLivros(ListarLivros value) {
        return new JAXBElement<ListarLivros>(_ListarLivros_QNAME, ListarLivros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLivrosPaginacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarLivrosPaginacaoResponse")
    public JAXBElement<ListarLivrosPaginacaoResponse> createListarLivrosPaginacaoResponse(ListarLivrosPaginacaoResponse value) {
        return new JAXBElement<ListarLivrosPaginacaoResponse>(_ListarLivrosPaginacaoResponse_QNAME, ListarLivrosPaginacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLivrosPaginacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarLivrosPaginacao")
    public JAXBElement<ListarLivrosPaginacao> createListarLivrosPaginacao(ListarLivrosPaginacao value) {
        return new JAXBElement<ListarLivrosPaginacao>(_ListarLivrosPaginacao_QNAME, ListarLivrosPaginacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarLivroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "criarLivroResponse")
    public JAXBElement<CriarLivroResponse> createCriarLivroResponse(CriarLivroResponse value) {
        return new JAXBElement<CriarLivroResponse>(_CriarLivroResponse_QNAME, CriarLivroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Livro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "livro")
    public JAXBElement<Livro> createLivro(Livro value) {
        return new JAXBElement<Livro>(_Livro_QNAME, Livro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarLivrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "listarLivrosResponse")
    public JAXBElement<ListarLivrosResponse> createListarLivrosResponse(ListarLivrosResponse value) {
        return new JAXBElement<ListarLivrosResponse>(_ListarLivrosResponse_QNAME, ListarLivrosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNaoAutorizadoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.estoque.knight.com.br/", name = "UsuarioNaoAutorizadoException")
    public JAXBElement<UsuarioNaoAutorizadoException> createUsuarioNaoAutorizadoException(UsuarioNaoAutorizadoException value) {
        return new JAXBElement<UsuarioNaoAutorizadoException>(_UsuarioNaoAutorizadoException_QNAME, UsuarioNaoAutorizadoException.class, null, value);
    }

}
