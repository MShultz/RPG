public class World {

	public static void main(String[] args){
		Castle castle = new Castle();
		castle.createAdventurer();
		do{
		castle.getAdventurerCurrentRoom();
		castle.checkUserMovement(castle.moveAdventurer());
		}while(true);
	}
	
	}