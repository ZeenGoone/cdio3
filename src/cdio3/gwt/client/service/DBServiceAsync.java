package cdio3.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DBServiceAsync {

	@SuppressWarnings("rawtypes")
	void authenticateUser(String username, String password, AsyncCallback callback);
}
