package cdio3.gwt.client.model;

import java.io.Serializable;

/**
 * Operatoer Data Access Objekt
 * 
 * @author Gruppe12
 * @version 1.0
 */

@SuppressWarnings("serial")
public class OperatoerDTO implements Serializable
{
	int oprId;                     
	String oprNavn;                
	String ini;                 
	String cpr;                 
	String password;

	public synchronized int getOprId() { return oprId; }
	public synchronized void setOprId(int oprId) { this.oprId = oprId; }
	public synchronized String getOprNavn() { return oprNavn; }
	public synchronized void setOprNavn(String oprNavn) { this.oprNavn = oprNavn; }
	public synchronized String getIni() { return ini; }
	public synchronized void setIni(String ini) { this.ini = ini; }
	public synchronized String getCpr() { return cpr; }
	public synchronized void setCpr(String cpr) { this.cpr = cpr; }
	public synchronized String getPassword() { return password; }
	public synchronized void setPassword(String password) { this.password = password; }
	public synchronized String toString() { return oprId + "\t" + oprNavn + "\t" + ini + "\t" + cpr + "\t" + password; }
}
