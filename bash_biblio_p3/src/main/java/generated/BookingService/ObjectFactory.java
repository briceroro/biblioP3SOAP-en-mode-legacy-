
package generated.BookingService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.BookingService package. 
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

    private final static QName _BookingByBook_QNAME = new QName("http://service.biblio.mairie.com/", "bookingByBook");
    private final static QName _BookingByBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "bookingByBookResponse");
    private final static QName _BookingByUserResponse_QNAME = new QName("http://service.biblio.mairie.com/", "bookingByUserResponse");
    private final static QName _ChangeOrderListBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "changeOrderListBookingResponse");
    private final static QName _CreateBooking_QNAME = new QName("http://service.biblio.mairie.com/", "createBooking");
    private final static QName _AllBooking_QNAME = new QName("http://service.biblio.mairie.com/", "allBooking");
    private final static QName _ChangeOrderListBooking_QNAME = new QName("http://service.biblio.mairie.com/", "changeOrderListBooking");
    private final static QName _DateLimiteBooking_QNAME = new QName("http://service.biblio.mairie.com/", "dateLimiteBooking");
    private final static QName _AllBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "allBookingResponse");
    private final static QName _CreateBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "createBookingResponse");
    private final static QName _DeleteBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBookingResponse");
    private final static QName _DateLimiteBookingResponse_QNAME = new QName("http://service.biblio.mairie.com/", "dateLimiteBookingResponse");
    private final static QName _BookingByUser_QNAME = new QName("http://service.biblio.mairie.com/", "bookingByUser");
    private final static QName _DeleteBooking_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBooking");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.BookingService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateBookingResponse }
     * 
     */
    public CreateBookingResponse createCreateBookingResponse() {
        return new CreateBookingResponse();
    }

    /**
     * Create an instance of {@link DeleteBookingResponse }
     * 
     */
    public DeleteBookingResponse createDeleteBookingResponse() {
        return new DeleteBookingResponse();
    }

    /**
     * Create an instance of {@link DateLimiteBookingResponse }
     * 
     */
    public DateLimiteBookingResponse createDateLimiteBookingResponse() {
        return new DateLimiteBookingResponse();
    }

    /**
     * Create an instance of {@link AllBookingResponse }
     * 
     */
    public AllBookingResponse createAllBookingResponse() {
        return new AllBookingResponse();
    }

    /**
     * Create an instance of {@link DeleteBooking }
     * 
     */
    public DeleteBooking createDeleteBooking() {
        return new DeleteBooking();
    }

    /**
     * Create an instance of {@link BookingByUser }
     * 
     */
    public BookingByUser createBookingByUser() {
        return new BookingByUser();
    }

    /**
     * Create an instance of {@link BookingByBook }
     * 
     */
    public BookingByBook createBookingByBook() {
        return new BookingByBook();
    }

    /**
     * Create an instance of {@link BookingByBookResponse }
     * 
     */
    public BookingByBookResponse createBookingByBookResponse() {
        return new BookingByBookResponse();
    }

    /**
     * Create an instance of {@link BookingByUserResponse }
     * 
     */
    public BookingByUserResponse createBookingByUserResponse() {
        return new BookingByUserResponse();
    }

    /**
     * Create an instance of {@link ChangeOrderListBookingResponse }
     * 
     */
    public ChangeOrderListBookingResponse createChangeOrderListBookingResponse() {
        return new ChangeOrderListBookingResponse();
    }

    /**
     * Create an instance of {@link DateLimiteBooking }
     * 
     */
    public DateLimiteBooking createDateLimiteBooking() {
        return new DateLimiteBooking();
    }

    /**
     * Create an instance of {@link AllBooking }
     * 
     */
    public AllBooking createAllBooking() {
        return new AllBooking();
    }

    /**
     * Create an instance of {@link ChangeOrderListBooking }
     * 
     */
    public ChangeOrderListBooking createChangeOrderListBooking() {
        return new ChangeOrderListBooking();
    }

    /**
     * Create an instance of {@link CreateBooking }
     * 
     */
    public CreateBooking createCreateBooking() {
        return new CreateBooking();
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingByBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "bookingByBook")
    public JAXBElement<BookingByBook> createBookingByBook(BookingByBook value) {
        return new JAXBElement<BookingByBook>(_BookingByBook_QNAME, BookingByBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingByBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "bookingByBookResponse")
    public JAXBElement<BookingByBookResponse> createBookingByBookResponse(BookingByBookResponse value) {
        return new JAXBElement<BookingByBookResponse>(_BookingByBookResponse_QNAME, BookingByBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "bookingByUserResponse")
    public JAXBElement<BookingByUserResponse> createBookingByUserResponse(BookingByUserResponse value) {
        return new JAXBElement<BookingByUserResponse>(_BookingByUserResponse_QNAME, BookingByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrderListBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "changeOrderListBookingResponse")
    public JAXBElement<ChangeOrderListBookingResponse> createChangeOrderListBookingResponse(ChangeOrderListBookingResponse value) {
        return new JAXBElement<ChangeOrderListBookingResponse>(_ChangeOrderListBookingResponse_QNAME, ChangeOrderListBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBooking")
    public JAXBElement<CreateBooking> createCreateBooking(CreateBooking value) {
        return new JAXBElement<CreateBooking>(_CreateBooking_QNAME, CreateBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "allBooking")
    public JAXBElement<AllBooking> createAllBooking(AllBooking value) {
        return new JAXBElement<AllBooking>(_AllBooking_QNAME, AllBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOrderListBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "changeOrderListBooking")
    public JAXBElement<ChangeOrderListBooking> createChangeOrderListBooking(ChangeOrderListBooking value) {
        return new JAXBElement<ChangeOrderListBooking>(_ChangeOrderListBooking_QNAME, ChangeOrderListBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateLimiteBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "dateLimiteBooking")
    public JAXBElement<DateLimiteBooking> createDateLimiteBooking(DateLimiteBooking value) {
        return new JAXBElement<DateLimiteBooking>(_DateLimiteBooking_QNAME, DateLimiteBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "allBookingResponse")
    public JAXBElement<AllBookingResponse> createAllBookingResponse(AllBookingResponse value) {
        return new JAXBElement<AllBookingResponse>(_AllBookingResponse_QNAME, AllBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBookingResponse")
    public JAXBElement<CreateBookingResponse> createCreateBookingResponse(CreateBookingResponse value) {
        return new JAXBElement<CreateBookingResponse>(_CreateBookingResponse_QNAME, CreateBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBookingResponse")
    public JAXBElement<DeleteBookingResponse> createDeleteBookingResponse(DeleteBookingResponse value) {
        return new JAXBElement<DeleteBookingResponse>(_DeleteBookingResponse_QNAME, DeleteBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateLimiteBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "dateLimiteBookingResponse")
    public JAXBElement<DateLimiteBookingResponse> createDateLimiteBookingResponse(DateLimiteBookingResponse value) {
        return new JAXBElement<DateLimiteBookingResponse>(_DateLimiteBookingResponse_QNAME, DateLimiteBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "bookingByUser")
    public JAXBElement<BookingByUser> createBookingByUser(BookingByUser value) {
        return new JAXBElement<BookingByUser>(_BookingByUser_QNAME, BookingByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBooking")
    public JAXBElement<DeleteBooking> createDeleteBooking(DeleteBooking value) {
        return new JAXBElement<DeleteBooking>(_DeleteBooking_QNAME, DeleteBooking.class, null, value);
    }

}
