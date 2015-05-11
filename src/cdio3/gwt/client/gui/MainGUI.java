package cdio3.gwt.client.gui;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3.gwt.client.model.OperatoerDTO;
import cdio3.gwt.client.service.DBServiceClientImpl;

public class MainGUI extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();

	private TextBox userNameTxt;
	private TextBox userPwdTxt;
	private TextBox getUserNameTxt;
	private TextBox deleteUserIdTxt;
	
	private TextBox addUserIdTxt;
	private TextBox addUserNameTxt;
	private TextBox addUserIniTxt;
	private TextBox addUserCprTxt;
	private TextBox addUserPwdTxt;
	
	private TextBox upUserIdTxt;
	private TextBox upUserNameTxt;
	private TextBox upUserIniTxt;
	private TextBox upUserCprTxt;
	private TextBox upUserPwdTxt;
	
	
	private DBServiceClientImpl serviceImpl;
	
	public MainGUI(DBServiceClientImpl serviceImpl) {
		initWidget(this.vPanel);
		this.serviceImpl = serviceImpl;
		
		userNameTxt = new TextBox();
		this.vPanel.add(userNameTxt);
		userPwdTxt = new TextBox();
		this.vPanel.add(userPwdTxt);
		
		Button authenticateBtn = new Button("Login");
		authenticateBtn.addClickHandler(new AuthenticationClickHandler());
		this.vPanel.add(authenticateBtn);
		
		getUserNameTxt = new TextBox();
		this.vPanel.add(getUserNameTxt);
		
		Button getUserBtn = new Button("getUser");
		getUserBtn.addClickHandler(new getUserClickHandler());
		this.vPanel.add(getUserBtn);
		
		Button getUserListBtn = new Button("getUserList");
		getUserListBtn.addClickHandler(new getUserListClickHandler());
		this.vPanel.add(getUserListBtn);
		
		deleteUserIdTxt = new TextBox();
		this.vPanel.add(deleteUserIdTxt);
		
		Button deleteUserBtn = new Button("deleteUser");
		deleteUserBtn.addClickHandler(new deleteUserClickHandler());
		this.vPanel.add(deleteUserBtn);
		
		addUserIdTxt = new TextBox();
		this.vPanel.add(addUserIdTxt);
		
		addUserNameTxt = new TextBox();
		this.vPanel.add(addUserNameTxt);
		
		addUserIniTxt = new TextBox();
		this.vPanel.add(addUserIniTxt);
		
		addUserCprTxt = new TextBox();
		this.vPanel.add(addUserCprTxt);
		
		addUserPwdTxt = new TextBox();
		this.vPanel.add(addUserPwdTxt);
		
		Button createUserBtn = new Button("createUser");
		createUserBtn.addClickHandler(new createUserClickHandler());
		this.vPanel.add(createUserBtn);	
		
		upUserIdTxt = new TextBox();
		this.vPanel.add(upUserIdTxt);
		
		upUserNameTxt = new TextBox();
		this.vPanel.add(upUserNameTxt);
		
		upUserIniTxt = new TextBox();
		this.vPanel.add(upUserIniTxt);
		
		upUserCprTxt = new TextBox();
		this.vPanel.add(upUserCprTxt);
		
		upUserPwdTxt = new TextBox();
		this.vPanel.add(upUserPwdTxt);
		
		Button updateUserBtn = new Button("updateUser");
		updateUserBtn.addClickHandler(new updateUserClickHandler());
		this.vPanel.add(updateUserBtn);	

	}
	
	private class AuthenticationClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String username = userNameTxt.getText();
			String pwd = userPwdTxt.getText();
			serviceImpl.authenticateUser(username, pwd);
		}
	}
	
	private class createUserClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			OperatoerDTO opr = new OperatoerDTO();
			opr.setOprId(Integer.parseInt(addUserIdTxt.getText()));
			opr.setOprNavn(addUserNameTxt.getText());
			opr.setIni(addUserIniTxt.getText());
			opr.setCpr(addUserCprTxt.getText());
			opr.setPassword(addUserIdTxt.getText());
			serviceImpl.createUser(opr);
		}
	}
	
	private class updateUserClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			OperatoerDTO opr = new OperatoerDTO();
			opr.setOprId(Integer.parseInt(addUserIdTxt.getText()));
			opr.setOprNavn(addUserNameTxt.getText());
			opr.setIni(addUserIniTxt.getText());
			opr.setCpr(addUserCprTxt.getText());
			opr.setPassword(addUserIdTxt.getText());
			serviceImpl.updateUser(opr);
		}
	}
	
	private class getUserClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			int oprId = Integer.parseInt(getUserNameTxt.getText());
			serviceImpl.getUser(oprId);
		}
	}
	
	private class getUserListClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			serviceImpl.getUserList();
		}
	}
	
	private class deleteUserClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			int oprId = Integer.parseInt(deleteUserIdTxt.getText());
			serviceImpl.deleteUser(oprId);
		}
	}

	public void authenticateOperatoer(boolean result) {
		HTML html = new HTML();
		
		String code = "<b>Svar fra DB:</b> " + result + "</br>";
		
		html.setHTML(code);
		this.vPanel.add(html);
	}
	
	public void deletedOperatoer(boolean result) {
		HTML html = new HTML();
		
		String code = "<b>Bruger slettet:</b> " + result + "</br>";
		
		html.setHTML(code);
		this.vPanel.add(html);
	}
	
	public void displayOperatoer(OperatoerDTO info) {
		HTML html = new HTML();
		
		String code = "<b>ID:</b> " + info.getOprId() + "</br>";
		code = code + "<b>Navn:</b> " + info.getOprNavn() + "</br>";
		code = code + "<b>Ini:</b> " + info.getIni() + "</br>";
		code = code + "<b>Cpr:</b> " + info.getCpr() + "</br>";
		code = code + "<b>Password:</b> " + info.getPassword() + "</br>";
		
		html.setHTML(code);
		this.vPanel.add(html);
	}
	
	public void displayOperatoerListe(ArrayList<OperatoerDTO> oprList){
		for(int i = 0;i < oprList.size();i++){
			HTML html = new HTML();
			
			String code = "<b>ID:</b> " + oprList.get(i).getOprId() + "</br>";
			code = code + "<b>Navn:</b> " + oprList.get(i).getOprNavn() + "</br>";
			code = code + "<b>Ini:</b> " + oprList.get(i).getIni() + "</br>";
			code = code + "<b>Cpr:</b> " + oprList.get(i).getCpr() + "</br>";
			code = code + "<b>Password:</b> " + oprList.get(i).getPassword() + "</br>";
			
			html.setHTML(code);
			this.vPanel.add(html);
		}
	}
}
