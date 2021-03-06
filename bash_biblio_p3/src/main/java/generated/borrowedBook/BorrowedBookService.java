
package generated.borrowedBook;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BorrowedBookService", targetNamespace = "http://service.biblio.mairie.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BorrowedBookService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<generated.borrowedBook.BorrowedBook>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findUserBorrowedBooks", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.FindUserBorrowedBooks")
    @ResponseWrapper(localName = "findUserBorrowedBooksResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.FindUserBorrowedBooksResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/findUserBorrowedBooksRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/findUserBorrowedBooksResponse")
    public List<BorrowedBook> findUserBorrowedBooks(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<generated.borrowedBook.BorrowedBook>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findBorrowedBookNotReturned", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.FindBorrowedBookNotReturned")
    @ResponseWrapper(localName = "findBorrowedBookNotReturnedResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.FindBorrowedBookNotReturnedResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/findBorrowedBookNotReturnedRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/findBorrowedBookNotReturnedResponse")
    public List<BorrowedBook> findBorrowedBookNotReturned();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createBorrowedBook", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.CreateBorrowedBook")
    @ResponseWrapper(localName = "createBorrowedBookResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.CreateBorrowedBookResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/createBorrowedBookRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/createBorrowedBookResponse")
    public int createBorrowedBook(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "checkBooking", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.CheckBooking")
    @ResponseWrapper(localName = "checkBookingResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.CheckBookingResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/checkBookingRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/checkBookingResponse")
    public void checkBooking(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteBorrowedBook", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.DeleteBorrowedBook")
    @ResponseWrapper(localName = "deleteBorrowedBookResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.DeleteBorrowedBookResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/deleteBorrowedBookRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/deleteBorrowedBookResponse")
    public void deleteBorrowedBook(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns javax.xml.datatype.XMLGregorianCalendar
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "extensionDateBorrowing", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.ExtensionDateBorrowing")
    @ResponseWrapper(localName = "extensionDateBorrowingResponse", targetNamespace = "http://service.biblio.mairie.com/", className = "generated.borrowedBook.ExtensionDateBorrowingResponse")
    @Action(input = "http://service.biblio.mairie.com/BorrowedBookService/extensionDateBorrowingRequest", output = "http://service.biblio.mairie.com/BorrowedBookService/extensionDateBorrowingResponse")
    public XMLGregorianCalendar extensionDateBorrowing(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
