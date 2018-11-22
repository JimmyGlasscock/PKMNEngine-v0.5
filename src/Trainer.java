import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trainer {
	
	boolean partyExists;
	
	String playerName;
	
	public ArrayList<Pokemon> PlayerParty =  new ArrayList<Pokemon>();
	
	public void setPlayerName(String newName) {
		playerName = newName;
	}
	
	public void addPokemonToParty(Pokemon poke) {
		PlayerParty.add(poke);
		partyExists = true;
	}
	
	public Pokemon getPokemonFromParty(int num) {
		return PlayerParty.get(num);
	}
	
	public boolean partyExists() {
		return partyExists;
	}
}
