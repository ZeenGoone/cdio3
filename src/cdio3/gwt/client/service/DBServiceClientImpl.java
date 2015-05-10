package cdio3.gwt.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cdio3.gwt.client.gui.MainGUI;
import cdio3.gwt.client.model.OperatoerDTO;

public class DBServiceClientImpl implements DBServiceClientInt {
	private DBServiceAsync service;
	private MainGUI maingui;
	
	public DBServiceClientImpl(String url) {
		System.out.println(url);
		this.service = GWT.create(DBService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		this.maingui = new MainGUI(this);
	}
	
	@Override
	public void authenticateUser(String username, String password){
		this.service.authenticateUser(username, password, new DefaultCallback());
	}

	public MainGUI getMainGUI(){
		return this.maingui;
	}
	
	@SuppressWarnings("rawtypes")
	private class DefaultCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An Error has occured");
		}

		@Override
		public void onSuccess(Object result) {

			if(result instanceof OperatoerDTO){
				OperatoerDTO opr = (OperatoerDTO) result;
				maingui.displayOperatoer(opr);
			}
			else if(result instanceof Boolean){
				boolean svar = (Boolean) result;
				maingui.authenticateOperatoer(svar);
			}
		}
	
	}
}
