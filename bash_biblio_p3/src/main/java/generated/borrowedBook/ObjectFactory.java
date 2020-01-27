
package generated.borrowedBook;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.borrowedBook package. 
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

    private final static QName _ExtensionDateBorrowing_QNAME = new QName("http://service.biblio.mairie.com/", "extensionDateBorrowing");
    private final static QName _CheckBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "checkBookingResponse");
    private final static QName _DeleteBorrowedBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBorrowedBookResponse");
    private final static QName _CreateBorrowedBook_QNAME = new QName("http://service.biblio.mairie.com/", "createBorrowedBook");
    private final static QName _FindBorrowedBookNotReturned_QNAME = new QName("http://service.biblio.mairie.com/", "findBorrowedBookNotReturned");
    private final static QName _FindBorrowedBookNotReturnedResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findBorrowedBookNotReturnedResponse");
    private final static QName _CheckBooking_QNAME = new QName("http://service.biblio.mairie.com/", "checkBooking");
    private final static QName _DeleteBorrowedBook_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBorrowedBook");
    private final static QName _FindUserBorrowedBooks_QNAME = new QName("http://service.biblio.mairie.com/", "findUserBorrowedBooks");
    private final static QName _CreateBorrowedBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "createBorrowedBookResponse");
    private final static QName _ExtensionDateBorrowingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "extensionDateBorrowingResponse");
    private final static QName _FindUserBorrowedBooksResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findUserBorrowedBooksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.borrowedBook
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteBorrowedBookResponse }
     * 
     */
    public DeleteBorrowedBookResponse createDeleteBorrowedBookResponse() {
        return new DeleteBorrowedBookResponse();
    }

    /**
     * Create an instance of {@link CheckBookingResponse }
     * 
     */
    public CheckBookingResponse createCheckBookingResponse() {
        return new CheckBookingResponse();
    }

    /**
     * Create an instance of {@link ExtensionDateBorrowing }
     * 
     */
    public ExtensionDateBorrowing createExtensionDateBorrowing() {
        return new ExtensionDateBorrowing();
    }

    /**
     * Create an instance of {@link CreateBorrowedBookResponse }
     * 
     */
    public CreateBorrowedBookResponse createCreateBorrowedBookResponse() {
        return new CreateBorrowedBookResponse();
    }

    /**
     * Create an instance of {@link ExtensionDateBorrowingResponse }
     * 
     */
    public ExtensionDateBorrowingResponse createExtensionDateBorrowingResponse() {
        return new ExtensionDateBorrowingResponse();
    }

    /**
     * Create an instance of {@link FindUserBorrowedBooksResponse }
     * 
     */
    public FindUserBorrowedBooksResponse createFindUserBorrowedBooksResponse() {
        return new FindUserBorrowedBooksResponse();
    }

    /**
     * Create an instance of {@link DeleteBorrowedBook }
     * 
     */
    public DeleteBorrowedBook createDeleteBorrowedBook() {
        return new DeleteBorrowedBook();
    }

    /**
     * Create an instance of {@link FindUserBorrowedBooks }
     * 
     */
    public FindUserBorrowedBooks createFindUserBorrowedBooks() {
        return new FindUserBorrowedBooks();
    }

    /**
     * Create an instance of {@link CheckBooking }
     * 
     */
    public CheckBooking createCheckBooking() {
        return new CheckBooking();
    }

    /**
     * Create an instance of {@link CreateBorrowedBook }
     * 
     */
    public CreateBorrowedBook createCreateBorrowedBook() {
        return new CreateBorrowedBook();
    }

    /**
     * Create an instance of {@link FindBorrowedBookNotReturned }
     * 
     */
    public FindBorrowedBookNotReturned createFindBorrowedBookNotReturned() {
        return new FindBorrowedBookNotReturned();
    }

    /**
     * Create an instance of {@link FindBorrowedBookNotReturnedResponse }
     * 
     */
    public FindBorrowedBookNotReturnedResponse createFindBorrowedBookNotReturnedResponse() {
        return new FindBorrowedBookNotReturnedResponse();
    }

    /**
     * Create an instance of {@link BorrowedBook }
     * 
     */
    public BorrowedBook createBorrowedBook() {
        return new BorrowedBook();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtensionDateBorrowing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "extensionDateBorrowing")
    public JAXBElement<ExtensionDateBorrowing> createExtensionDateBorrowing(ExtensionDateBorrowing value) {
        return new JAXBElement<ExtensionDateBorrowing>(_ExtensionDateBorrowing_QNAME, ExtensionDateBorrowing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "checkBookingResponse")
    public JAXBElement<CheckBookingResponse> createCheckBookingResponse(CheckBookingResponse value) {
        return new JAXBElement<CheckBookingResponse>(_CheckBookingResponse_QNAME, CheckBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBorrowedBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBorrowedBookResponse")
    public JAXBElement<DeleteBorrowedBookResponse> createDeleteBorrowedBookResponse(DeleteBorrowedBookResponse value) {
        return new JAXBElement<DeleteBorrowedBookResponse>(_DeleteBorrowedBookResponse_QNAME, DeleteBorrowedBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBorrowedBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBorrowedBook")
    public JAXBElement<CreateBorrowedBook> createCreateBorrowedBook(CreateBorrowedBook value) {
        return new JAXBElement<CreateBorrowedBook>(_CreateBorrowedBook_QNAME, CreateBorrowedBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBorrowedBookNotReturned }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBorrowedBookNotReturned")
    public JAXBElement<FindBorrowedBookNotReturned> createFindBorrowedBookNotReturned(FindBorrowedBookNotReturned value) {
        return new JAXBElement<FindBorrowedBookNotReturned>(_FindBorrowedBookNotReturned_QNAME, FindBorrowedBookNotReturned.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBorrowedBookNotReturnedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBorrowedBookNotReturnedResponse")
    public JAXBElement<FindBorrowedBookNotReturnedResponse> createFindBorrowedBookNotReturnedResponse(FindBorrowedBookNotReturnedResponse value) {
        return new JAXBElement<FindBorrowedBookNotReturnedResponse>(_FindBorrowedBookNotReturnedResponse_QNAME, FindBorrowedBookNotReturnedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "checkBooking")
    public JAXBElement<CheckBooking> createCheckBooking(CheckBooking value) {
        return new JAXBElement<CheckBooking>(_CheckBooking_QNAME, CheckBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBorrowedBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBorrowedBook")
    public JAXBElement<DeleteBorrowedBook> createDeleteBorrowedBook(DeleteBorrowedBook value) {
        return new JAXBElement<DeleteBorrowedBook>(_DeleteBorrowedBook_QNAME, DeleteBorrowedBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserBorrowedBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findUserBorrowedBooks")
    public JAXBElement<FindUserBorrowedBooks> createFindUserBorrowedBooks(FindUserBorrowedBooks value) {
        return new JAXBElement<FindUserBorrowedBooks>(_FindUserBorrowedBooks_QNAME, FindUserBorrowedBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBorrowedBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBorrowedBookResponse")
    public JAXBElement<CreateBorrowedBookResponse> createCreateBorrowedBookResponse(CreateBorrowedBookResponse value) {
        return new JAXBElement<CreateBorrowedBookResponse>(_CreateBorrowedBookResponse_QNAME, CreateBorrowedBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtensionDateBorrowingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "extensionDateBorrowingResponse")
    public JAXBElement<ExtensionDateBorrowingResponse> createExtensionDateBorrowingResponse(ExtensionDateBorrowingResponse value) {
        return new JAXBElement<ExtensionDateBorrowingResponse>(_ExtensionDateBorrowingResponse_QNAME, ExtensionDateBorrowingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserBorrowedBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findUserBorrowedBooksResponse")
    public JAXBElement<FindUserBorrowedBooksResponse> createFindUserBorrowedBooksResponse(FindUserBorrowedBooksResponse value) {
        return new JAXBElement<FindUserBorrowedBooksResponse>(_FindUserBorrowedBooksResponse_QNAME, FindUserBorrowedBooksResponse.class, null, value);
    }

}
