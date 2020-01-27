
package generated.userService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.userService package. 
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

    private final static QName _FindUserByUserNameResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findUserByUserNameResponse");
    private final static QName _CreateUserResponse_QNAME = new QName("http://service.biblio.mairie.com/", "createUserResponse");
    private final static QName _FindbyId_QNAME = new QName("http://service.biblio.mairie.com/", "findbyId");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.biblio.mairie.com/", "deleteUserResponse");
    private final static QName _FindbyIdResponse_QNAME = new QName("http://service.biblio.mairie.com/", "findbyIdResponse");
    private final static QName _CreateUser_QNAME = new QName("http://service.biblio.mairie.com/", "createUser");
    private final static QName _DeleteUser_QNAME = new QName("http://service.biblio.mairie.com/", "deleteUser");
    private final static QName _FindUserByUserName_QNAME = new QName("http://service.biblio.mairie.com/", "findUserByUserName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.userService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindbyId }
     * 
     */
    public FindbyId createFindbyId() {
        return new FindbyId();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link FindUserByUserNameResponse }
     * 
     */
    public FindUserByUserNameResponse createFindUserByUserNameResponse() {
        return new FindUserByUserNameResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link FindUserByUserName }
     * 
     */
    public FindUserByUserName createFindUserByUserName() {
        return new FindUserByUserName();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link FindbyIdResponse }
     * 
     */
    public FindbyIdResponse createFindbyIdResponse() {
        return new FindbyIdResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByUserNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findUserByUserNameResponse")
    public JAXBElement<FindUserByUserNameResponse> createFindUserByUserNameResponse(FindUserByUserNameResponse value) {
        return new JAXBElement<FindUserByUserNameResponse>(_FindUserByUserNameResponse_QNAME, FindUserByUserNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindbyId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findbyId")
    public JAXBElement<FindbyId> createFindbyId(FindbyId value) {
        return new JAXBElement<FindbyId>(_FindbyId_QNAME, FindbyId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindbyIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findbyIdResponse")
    public JAXBElement<FindbyIdResponse> createFindbyIdResponse(FindbyIdResponse value) {
        return new JAXBElement<FindbyIdResponse>(_FindbyIdResponse_QNAME, FindbyIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByUserName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.biblio.mairie.com/", name = "findUserByUserName")
    public JAXBElement<FindUserByUserName> createFindUserByUserName(FindUserByUserName value) {
        return new JAXBElement<FindUserByUserName>(_FindUserByUserName_QNAME, FindUserByUserName.class, null, value);
    }

}
