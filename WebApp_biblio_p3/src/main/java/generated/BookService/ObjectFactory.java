
package generated.BookService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.BookService package. 
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

    private final static QName _FindBookByAuthor_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByAuthor");
    private final static QName _FindBookByCategoryResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByCategoryResponse");
    private final static QName _DeleteBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBookResponse");
    private final static QName _CreateBook_QNAME = new QName("http://service.biblio.mairie.com/", "createBook");
    private final static QName _DeleteBook_QNAME = new QName("http://service.biblio.mairie.com/", "deleteBook");
    private final static QName _FindBookByAuthorResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByAuthorResponse");
    private final static QName _FindAllBook_QNAME = new QName("http://service.biblio.mairie.com/", "findAllBook");
    private final static QName _FindBookByCategory_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByCategory");
    private final static QName _CreateBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "createBookResponse");
    private final static QName _FindAllBookResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findAllBookResponse");
    private final static QName _FindBookByTitle_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByTitle");
    private final static QName _FindBookByTitleKeywords_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByTitleKeywords");
    private final static QName _FindBookByTitleKeywordsResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByTitleKeywordsResponse");
    private final static QName _FindBookByTitleResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findBookByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.BookService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindBookByTitleKeywords }
     * 
     */
    public FindBookByTitleKeywords createFindBookByTitleKeywords() {
        return new FindBookByTitleKeywords();
    }

    /**
     * Create an instance of {@link FindBookByTitleKeywordsResponse }
     * 
     */
    public FindBookByTitleKeywordsResponse createFindBookByTitleKeywordsResponse() {
        return new FindBookByTitleKeywordsResponse();
    }

    /**
     * Create an instance of {@link FindBookByTitleResponse }
     * 
     */
    public FindBookByTitleResponse createFindBookByTitleResponse() {
        return new FindBookByTitleResponse();
    }

    /**
     * Create an instance of {@link FindAllBookResponse }
     * 
     */
    public FindAllBookResponse createFindAllBookResponse() {
        return new FindAllBookResponse();
    }

    /**
     * Create an instance of {@link FindBookByTitle }
     * 
     */
    public FindBookByTitle createFindBookByTitle() {
        return new FindBookByTitle();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link CreateBook }
     * 
     */
    public CreateBook createCreateBook() {
        return new CreateBook();
    }

    /**
     * Create an instance of {@link DeleteBook }
     * 
     */
    public DeleteBook createDeleteBook() {
        return new DeleteBook();
    }

    /**
     * Create an instance of {@link FindBookByAuthorResponse }
     * 
     */
    public FindBookByAuthorResponse createFindBookByAuthorResponse() {
        return new FindBookByAuthorResponse();
    }

    /**
     * Create an instance of {@link FindBookByCategoryResponse }
     * 
     */
    public FindBookByCategoryResponse createFindBookByCategoryResponse() {
        return new FindBookByCategoryResponse();
    }

    /**
     * Create an instance of {@link DeleteBookResponse }
     * 
     */
    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    /**
     * Create an instance of {@link FindBookByAuthor }
     * 
     */
    public FindBookByAuthor createFindBookByAuthor() {
        return new FindBookByAuthor();
    }

    /**
     * Create an instance of {@link FindBookByCategory }
     * 
     */
    public FindBookByCategory createFindBookByCategory() {
        return new FindBookByCategory();
    }

    /**
     * Create an instance of {@link FindAllBook }
     * 
     */
    public FindAllBook createFindAllBook() {
        return new FindAllBook();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByAuthor")
    public JAXBElement<FindBookByAuthor> createFindBookByAuthor(FindBookByAuthor value) {
        return new JAXBElement<FindBookByAuthor>(_FindBookByAuthor_QNAME, FindBookByAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByCategoryResponse")
    public JAXBElement<FindBookByCategoryResponse> createFindBookByCategoryResponse(FindBookByCategoryResponse value) {
        return new JAXBElement<FindBookByCategoryResponse>(_FindBookByCategoryResponse_QNAME, FindBookByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBookResponse")
    public JAXBElement<DeleteBookResponse> createDeleteBookResponse(DeleteBookResponse value) {
        return new JAXBElement<DeleteBookResponse>(_DeleteBookResponse_QNAME, DeleteBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBook")
    public JAXBElement<CreateBook> createCreateBook(CreateBook value) {
        return new JAXBElement<CreateBook>(_CreateBook_QNAME, CreateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteBook")
    public JAXBElement<DeleteBook> createDeleteBook(DeleteBook value) {
        return new JAXBElement<DeleteBook>(_DeleteBook_QNAME, DeleteBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByAuthorResponse")
    public JAXBElement<FindBookByAuthorResponse> createFindBookByAuthorResponse(FindBookByAuthorResponse value) {
        return new JAXBElement<FindBookByAuthorResponse>(_FindBookByAuthorResponse_QNAME, FindBookByAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findAllBook")
    public JAXBElement<FindAllBook> createFindAllBook(FindAllBook value) {
        return new JAXBElement<FindAllBook>(_FindAllBook_QNAME, FindAllBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByCategory")
    public JAXBElement<FindBookByCategory> createFindBookByCategory(FindBookByCategory value) {
        return new JAXBElement<FindBookByCategory>(_FindBookByCategory_QNAME, FindBookByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createBookResponse")
    public JAXBElement<CreateBookResponse> createCreateBookResponse(CreateBookResponse value) {
        return new JAXBElement<CreateBookResponse>(_CreateBookResponse_QNAME, CreateBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findAllBookResponse")
    public JAXBElement<FindAllBookResponse> createFindAllBookResponse(FindAllBookResponse value) {
        return new JAXBElement<FindAllBookResponse>(_FindAllBookResponse_QNAME, FindAllBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByTitle")
    public JAXBElement<FindBookByTitle> createFindBookByTitle(FindBookByTitle value) {
        return new JAXBElement<FindBookByTitle>(_FindBookByTitle_QNAME, FindBookByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByTitleKeywords }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByTitleKeywords")
    public JAXBElement<FindBookByTitleKeywords> createFindBookByTitleKeywords(FindBookByTitleKeywords value) {
        return new JAXBElement<FindBookByTitleKeywords>(_FindBookByTitleKeywords_QNAME, FindBookByTitleKeywords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByTitleKeywordsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByTitleKeywordsResponse")
    public JAXBElement<FindBookByTitleKeywordsResponse> createFindBookByTitleKeywordsResponse(FindBookByTitleKeywordsResponse value) {
        return new JAXBElement<FindBookByTitleKeywordsResponse>(_FindBookByTitleKeywordsResponse_QNAME, FindBookByTitleKeywordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBookByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findBookByTitleResponse")
    public JAXBElement<FindBookByTitleResponse> createFindBookByTitleResponse(FindBookByTitleResponse value) {
        return new JAXBElement<FindBookByTitleResponse>(_FindBookByTitleResponse_QNAME, FindBookByTitleResponse.class, null, value);
    }

}
