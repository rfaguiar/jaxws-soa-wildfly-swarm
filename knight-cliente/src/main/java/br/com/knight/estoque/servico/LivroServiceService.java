
package br.com.knight.estoque.servico;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LivroServiceService", targetNamespace = "http://servico.estoque.knight.com.br/", wsdlLocation = "http://localhost:8080/livros?wsdl")
public class LivroServiceService
    extends Service
{

    private final static URL LIVROSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException LIVROSERVICESERVICE_EXCEPTION;
    private final static QName LIVROSERVICESERVICE_QNAME = new QName("http://servico.estoque.knight.com.br/", "LivroServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/livros?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LIVROSERVICESERVICE_WSDL_LOCATION = url;
        LIVROSERVICESERVICE_EXCEPTION = e;
    }

    public LivroServiceService() {
        super(__getWsdlLocation(), LIVROSERVICESERVICE_QNAME);
    }

    public LivroServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LIVROSERVICESERVICE_QNAME, features);
    }

    public LivroServiceService(URL wsdlLocation) {
        super(wsdlLocation, LIVROSERVICESERVICE_QNAME);
    }

    public LivroServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LIVROSERVICESERVICE_QNAME, features);
    }

    public LivroServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LivroServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Livros
     */
    @WebEndpoint(name = "livrosPort")
    public Livros getLivrosPort() {
        return super.getPort(new QName("http://servico.estoque.knight.com.br/", "livrosPort"), Livros.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Livros
     */
    @WebEndpoint(name = "livrosPort")
    public Livros getLivrosPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servico.estoque.knight.com.br/", "livrosPort"), Livros.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LIVROSERVICESERVICE_EXCEPTION!= null) {
            throw LIVROSERVICESERVICE_EXCEPTION;
        }
        return LIVROSERVICESERVICE_WSDL_LOCATION;
    }

}
