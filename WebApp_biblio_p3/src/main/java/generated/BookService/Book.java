
package generated.BookService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateAvalaible" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrBooking" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrDispo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrOfBook" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "author",
    "category",
    "dateAvalaible",
    "description",
    "dispo",
    "id",
    "nbrBooking",
    "nbrDispo",
    "nbrOfBook",
    "reserve",
    "title"
})
public class Book {

    protected String author;
    protected String category;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAvalaible;
    protected String description;
    protected boolean dispo;
    protected int id;
    protected int nbrBooking;
    protected int nbrDispo;
    protected int nbrOfBook;
    protected boolean reserve;
    protected String title;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Définit la valeur de la propriété category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtient la valeur de la propriété dateAvalaible.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAvalaible() {
        return dateAvalaible;
    }

    /**
     * Définit la valeur de la propriété dateAvalaible.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAvalaible(XMLGregorianCalendar value) {
        this.dateAvalaible = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété dispo.
     * 
     */
    public boolean isDispo() {
        return dispo;
    }

    /**
     * Définit la valeur de la propriété dispo.
     * 
     */
    public void setDispo(boolean value) {
        this.dispo = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété nbrBooking.
     * 
     */
    public int getNbrBooking() {
        return nbrBooking;
    }

    /**
     * Définit la valeur de la propriété nbrBooking.
     * 
     */
    public void setNbrBooking(int value) {
        this.nbrBooking = value;
    }

    /**
     * Obtient la valeur de la propriété nbrDispo.
     * 
     */
    public int getNbrDispo() {
        return nbrDispo;
    }

    /**
     * Définit la valeur de la propriété nbrDispo.
     * 
     */
    public void setNbrDispo(int value) {
        this.nbrDispo = value;
    }

    /**
     * Obtient la valeur de la propriété nbrOfBook.
     * 
     */
    public int getNbrOfBook() {
        return nbrOfBook;
    }

    /**
     * Définit la valeur de la propriété nbrOfBook.
     * 
     */
    public void setNbrOfBook(int value) {
        this.nbrOfBook = value;
    }

    /**
     * Obtient la valeur de la propriété reserve.
     * 
     */
    public boolean isReserve() {
        return reserve;
    }

    /**
     * Définit la valeur de la propriété reserve.
     * 
     */
    public void setReserve(boolean value) {
        this.reserve = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
