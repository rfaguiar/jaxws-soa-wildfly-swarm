
package br.com.knight.estoque.servico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criarLivro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criarLivro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="livro" type="{http://servico.estoque.knight.com.br/}livro" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarLivro", propOrder = {
    "livro"
})
public class CriarLivro {

    protected Livro livro;

    /**
     * Gets the value of the livro property.
     * 
     * @return
     *     possible object is
     *     {@link Livro }
     *     
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Sets the value of the livro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Livro }
     *     
     */
    public void setLivro(Livro value) {
        this.livro = value;
    }

}
