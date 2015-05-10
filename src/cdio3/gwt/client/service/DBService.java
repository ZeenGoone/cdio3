package cdio3.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cdio3.gwt.client.model.OperatoerDTO;

@RemoteServiceRelativePath("dbservice")
public interface DBService extends RemoteService {
	
	Boolean authenticateUser(String username, String password);
}
