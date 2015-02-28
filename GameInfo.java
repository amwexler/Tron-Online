
public class GameInfo {

	String ip;
	String socket;
	int currentPlayers, maxPlayers;
	
	public GameInfo(String ip, String socket, int currentPlayers, int maxPlayers){
		this.ip=ip;
		this.socket=socket;
		this.currentPlayers=currentPlayers;
		this.maxPlayers=maxPlayers;
	}
	
	public String toString(){
		return ("IP: " + ip + ":" + socket + "  ||  Players: " + currentPlayers + " / " + maxPlayers);
	}
	
}
