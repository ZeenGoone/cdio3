package cdio3.gwt.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cdio3.gwt.client.model.OperatoerDTO;
import cdio3.gwt.client.service.DBService;

@SuppressWarnings("serial")
public class DBServiceImpl extends RemoteServiceServlet implements DBService {

	@SuppressWarnings("static-access")
	@Override
	public Boolean authenticateUser(String username, String password) {
		ResultSet rs = null;
		//OperatoerDTO opr = new OperatoerDTO();
		try {
			Connector conn = new Connector();
			rs = conn.doQuery("SELECT * FROM operatoer WHERE opr_navn = \"" + username + "\" AND password = \"" + password + "\"");
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!rs.first()) return false;

//			opr.setOprId(rs.getInt("opr_id"));
//			opr.setOprNavn(rs.getString("opr_navn"));
//			opr.setIni(rs.getString("ini"));
//			opr.setCpr(rs.getString("cpr"));
//			opr.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
