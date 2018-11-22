import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

/*---------------------------------------------------------
   -----Created By Jimmy Glasscock - January 2018-----
---------------------------------------------------------*/
public class Main extends BasicGame{
	//-------------TO DO-------------------
	//Add a prompt when the user tries to shift out a fainted pokemon
	//make it so you can win/lose with any party size
	
	
	//enemy AI, (different difficulties of it)
	//Make it so PKMN Stats are generated when you click on the PKMN, not just once at the start
	//Add moves to all pokemon
	//move animations
	//Add different music tracks
	
	Battle battleObj = new Battle();
	
	Font UIFont, UIFont2, UIFont3;
	UnicodeFont uniFont, uniFont2, uniFont3;
	
	String move1, move2, move3, move4, message = "", faintedMessage = "Ligma";
	
	static int screenWidth = 1280, screenHeight = 720;
	
	int trainerNum = 0, listNum = 1, partySize = 0, currentPKMN = 0, currentOpponentPKMN = 0, battleIndex = 1, alpha = 0, q = 0;
	
	int screenIndex = 0, trainerIndex = 0, PlayerHPNum = 192, OpponentHPNum = 192;
	
	double PlayerProportion = 1, OpponentProportion = 1;
	
	int choice = 0, pointerX = 395, pointerY = 267, i = 0, PointX = 910, PointY = 600;
	
	int pkmnX = 180, pkmnY = 315, oppoX = 820, oppoY = 110, tempPKMN = 0, moveMessage = 0;
	
	float scale = 3.5f;
	
	boolean changeHP = true, changeEnemyHP = true, setScale = true, PlayerVictory = false, OpponentVictory = false, backButtonEnabled = true, popupText = false;

	boolean increaseTwo = false, nextScreen = false, previousScreen = false, opponentFaintMessage = false;
	
	Image Title, Victory, Defeat, Trainer, pointer, PartyScreen, TeamBuilder, icon, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, fnt, fnt2, fnt3, fnt4, fnt5, fnt6;
	
	Image slotOne, slotTwo, slotThree, slotFour, slotFive, slotSix, blankRectangle, transition;
	
	Image opponentPokemon, trainerPokemon, trainer, opponent, BGMorning, BGDusk, BGNight, Textbox, OpponentHPBar, HPBar, fightBox, moveMenu, pointer2;
	
	Music battleMusic, gameCorner;
	
	public Main() {
		super("Battle Tower");
	}

	public static void main(String args[]) {
		
		makeWindow();
		Battle battle = new Battle();
		battle.startBattle();	
	}
	
	public static void makeWindow() {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(screenWidth, screenHeight, false);
			app.setShowFPS(false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setFont(uniFont);
		drawTitle(g);
		drawTeamBuilder(g);
		drawBattle(g);
		drawParty(g);
		drawVictory(g);
		drawLoss(g);
		
		//test case
		//g.drawString("battleIndex: " + battleIndex, 10, 10);
		
		//always last (transitions)
		increaseTwoScreenIndex(g);
		increaseScreenIndex(g);
		decreaseScreenIndex(g);
	}

	public void init(GameContainer container) throws SlickException {
		//Messy font stuff, Sorry
				try {
					 UIFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/font/font.ttf"));
					 UIFont = UIFont.deriveFont(java.awt.Font.PLAIN, 24.f);
					 uniFont = new org.newdawn.slick.UnicodeFont(UIFont);
				     uniFont.addAsciiGlyphs();
				     ColorEffect a = new org.newdawn.slick.font.effects.ColorEffect();
				     a.setColor(java.awt.Color.black);
				     uniFont.getEffects().add(a);
				     uniFont.loadGlyphs();
				} catch (FontFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					 UIFont2 = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/font/font.ttf"));
					 UIFont2 = UIFont.deriveFont(java.awt.Font.PLAIN, 24.f);
					 uniFont2 = new org.newdawn.slick.UnicodeFont(UIFont);
				     uniFont2.addAsciiGlyphs();
				     ColorEffect a = new org.newdawn.slick.font.effects.ColorEffect();
				     a.setColor(java.awt.Color.white);
				     uniFont2.getEffects().add(a);
				     uniFont2.loadGlyphs();
				} catch (FontFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					 UIFont3 = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/font/font.ttf"));
					 UIFont3 = UIFont.deriveFont(java.awt.Font.PLAIN, 55.f);
					 uniFont3 = new org.newdawn.slick.UnicodeFont(UIFont);
				     uniFont3.addAsciiGlyphs();
				     ColorEffect a = new org.newdawn.slick.font.effects.ColorEffect();
				     a.setColor(java.awt.Color.black);
				     uniFont3.getEffects().add(a);
				     uniFont3.loadGlyphs();
				} catch (FontFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		//-----------------------------------------------------------//		
				
		//Title and menu images
		Title = new Image("res/BattleTowerTitle.png");
		pointer = new Image("res/pointer.png");
		
		transition = new Image("res/Transition.png");
		
		TeamBuilder = new Image("res/TeamBuilder.png");
		
		Victory = new Image("res/VictoryScreen.png");
		
		Defeat = new Image("res/DefeatScreen.png");
		
		Trainer = new Image("res/Gen4/Trainers/" + trainerNum + ".png");
		
		icon = battleObj.PokemonList.get(listNum).getIcon();
		icon2 = battleObj.PokemonList.get(listNum+1).getIcon();
		icon3 = battleObj.PokemonList.get(listNum+2).getIcon();
		icon4 = battleObj.PokemonList.get(listNum+3).getIcon();
		icon5 = battleObj.PokemonList.get(listNum+4).getIcon();
		icon6 = battleObj.PokemonList.get(listNum+5).getIcon();
		icon7 = battleObj.PokemonList.get(listNum+6).getIcon();
		icon8 = battleObj.PokemonList.get(listNum+7).getIcon();
		icon9 = battleObj.PokemonList.get(listNum+8).getIcon();
		
		slotOne = new Image("res/pokeball.png");
		slotTwo = new Image("res/pokeball.png");
		slotThree = new Image("res/pokeball.png");
		slotFour = new Image("res/pokeball.png");
		slotFive = new Image("res/pokeball.png");
		slotSix = new Image("res/pokeball.png");
		
		fnt = new Image("res/FNT.png");
		fnt2 = new Image("res/FNT.png");
		fnt3 = new Image("res/FNT.png");
		fnt4 = new Image("res/FNT.png");
		fnt5 = new Image("res/FNT.png");
		fnt6 = new Image("res/FNT.png");
		
		
		blankRectangle = new Image("res/blankRectangle.png");
		
		gameCorner = new Music("res/Music/gameCorner.ogg");
		
		gameCorner.loop();
		
		//Battle Graphics
		Textbox = new Image("res/Test.png");
		
		BGMorning = new Image("res/BGMorning.png");
		BGDusk = new Image("res/BGDusk.png");
		BGNight = new Image("res/BGNight.png");
		
		OpponentHPBar = new Image("res/OpponentHPBar.png");
		HPBar = new Image("res/HPBar.png");
		
		//sets default Image
		trainerPokemon = new Image("res/Gen4/Back/Bulbasaur.png");
		opponentPokemon = new Image("res/Gen4/Bulbasaur.png");
		
		fightBox = new Image("res/FightMenu.png");
		moveMenu = new Image("res/FightMenu2.png");
		
		pointer2 = new Image("res/pointer2.png");
		
		//for Drawing player party'
		PartyScreen = new Image("res/PartyScreen.png");
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		titleInstructions(container);
		teamBuilderInstructions(container);
		battleInstructions(container);
		partyScreenInstructions(container);
	}
	
	public void drawTitle(Graphics g) {
		if(screenIndex == 0) {
			Title.draw(0,0);
			pointer.draw(pointerX, pointerY);
		}
	}
	
	public void titleInstructions(GameContainer container) {
		if(screenIndex == 0) {
			Input input = container.getInput();
			if(input.isKeyPressed(Input.KEY_DOWN)) {
				choice++;
				if(choice > 3) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_UP)) {
				choice--;
				if(choice < 0) {
					choice = 3;
				}
			}
			
			if(choice == 0) {
				pointerX = 395;
				pointerY = 267;
			}
			if(choice == 1) {
				pointerX = 395;
				pointerY = 355;
			}
			if(choice == 2) {
				pointerX = 435;
				pointerY = 445;
			}
			if(choice == 3) {
				pointerX = 520;
				pointerY = 530;
			}
			
			if(choice==0 && input.isKeyPressed(Input.KEY_ENTER)) {
				nextScreen = true;
			}
			
			if(choice==3 && input.isKeyPressed(Input.KEY_ENTER)) {
				System.exit(0);
			}
		}
	}
	
	public void drawTeamBuilder(Graphics g) throws SlickException {
		if(screenIndex == 1) {
			TeamBuilder.draw(0,0);
			
			//names
			g.setFont(uniFont2);
			
			g.drawString(battleObj.PokemonList.get(listNum).getName(), 970, 110);
			g.drawString(battleObj.PokemonList.get(listNum + 1).getName(), 970, 180);
			g.drawString(battleObj.PokemonList.get(listNum + 2).getName(), 970, 250);
			g.drawString(battleObj.PokemonList.get(listNum + 3).getName(), 970, 320);
			g.drawString(battleObj.PokemonList.get(listNum + 4).getName(), 970, 390);
			g.drawString(battleObj.PokemonList.get(listNum + 5).getName(), 970, 460);
			g.drawString(battleObj.PokemonList.get(listNum + 6).getName(), 970, 530);
			g.drawString(battleObj.PokemonList.get(listNum + 7).getName(), 970, 600);
			g.drawString(battleObj.PokemonList.get(listNum + 8).getName(), 970, 670);
			
			//icons
			icon.draw(900,90,2);
			icon2.draw(900,160,2);
			icon3.draw(900,230,2);
			icon4.draw(900,300,2);
			icon5.draw(900,370,2);
			icon6.draw(900,440,2);
			icon7.draw(900,510,2);
			icon8.draw(900,580,2);
			icon9.draw(900,650,2);
			
			//sets icons as it scrolls
			icon = battleObj.PokemonList.get(listNum).getIcon();
			icon2 = battleObj.PokemonList.get(listNum+1).getIcon();
			icon3 = battleObj.PokemonList.get(listNum+2).getIcon();
			icon4 = battleObj.PokemonList.get(listNum+3).getIcon();
			icon5 = battleObj.PokemonList.get(listNum+4).getIcon();
			icon6 = battleObj.PokemonList.get(listNum+5).getIcon();
			icon7 = battleObj.PokemonList.get(listNum+6).getIcon();
			icon8 = battleObj.PokemonList.get(listNum+7).getIcon();
			icon9 = battleObj.PokemonList.get(listNum+8).getIcon();
			
			if(!battleObj.Player.partyExists()) {
				blankRectangle.draw(517,627);
			}
			
			
			if(i>0) {
				slotOne = battleObj.getFromPlayerParty(0).getIcon();
				slotOne.draw(30,100,2);
				//moved name left 20, & level right 20
				g.drawString(battleObj.getFromPlayerParty(0).getName(), 100, 130);
				g.drawString("Lv " + battleObj.getFromPlayerParty(0).getLevel(), 240, 130);
				
				//hpbar up 5
				g.drawRect(30, 175, 200, 30);
				g.setColor(Color.green);
				g.fillRect(35, 180, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(0).getHP() + "/" + battleObj.getFromPlayerParty(0).getMaxHP(), 35, 200);
				
			}else {
				slotOne.draw(30,115);
			}
			
			if(i>1) {
				slotTwo = battleObj.getFromPlayerParty(1).getIcon();
				slotTwo.draw(390,100,2);
				g.drawString(battleObj.getFromPlayerParty(1).getName(), 460, 130);
				g.drawString("Lv " + battleObj.getFromPlayerParty(1).getLevel(), 600, 130);
				
				g.drawRect(390, 175, 200, 30);
				g.setColor(Color.green);
				g.fillRect(395, 180, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(1).getHP() + "/" + battleObj.getFromPlayerParty(1).getMaxHP(), 395, 200);
				
			}else {
				slotTwo.draw(390,115);
			}
			
			if(i>2) {
				slotThree = battleObj.getFromPlayerParty(2).getIcon();
				slotThree.draw(30,260,2);
				g.drawString(battleObj.getFromPlayerParty(2).getName(), 100, 290);
				g.drawString("Lv " + battleObj.getFromPlayerParty(2).getLevel(), 240, 290);
				
				g.drawRect(30, 335, 200, 30);
				g.setColor(Color.green);
				g.fillRect(35, 340, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(2).getHP() + "/" + battleObj.getFromPlayerParty(2).getMaxHP(), 35, 360);
				
			}else {
				slotThree.draw(30,275);
			}
			
			if(i>3) {
				slotFour = battleObj.getFromPlayerParty(3).getIcon();
				slotFour.draw(390,260,2);
				g.drawString(battleObj.getFromPlayerParty(3).getName(), 460, 290);
				g.drawString("Lv " + battleObj.getFromPlayerParty(3).getLevel(), 600, 290);
				
				g.drawRect(390, 335, 200, 30);
				g.setColor(Color.green);
				g.fillRect(395, 340, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(3).getHP() + "/" + battleObj.getFromPlayerParty(3).getMaxHP(), 395, 360);
				
			}else {
				slotFour.draw(390,275);
			}
			
			if(i>4) {
				slotFive = battleObj.getFromPlayerParty(4).getIcon();
				slotFive.draw(30,420,2);
				g.drawString(battleObj.getFromPlayerParty(4).getName(), 100, 450);
				g.drawString("Lv " + battleObj.getFromPlayerParty(4).getLevel(), 240, 450);
				
				g.drawRect(30, 495, 200, 30);
				g.setColor(Color.green);
				g.fillRect(35, 500, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(4).getHP() + "/" + battleObj.getFromPlayerParty(4).getMaxHP(), 35, 520);
				
			}else {
				slotFive.draw(30,435);
			}
			
			if(i>5) {
				slotSix = battleObj.getFromPlayerParty(5).getIcon();
				slotSix.draw(390,420,2);
				g.drawString(battleObj.getFromPlayerParty(5).getName(), 460, 450);
				g.drawString("Lv " + battleObj.getFromPlayerParty(5).getLevel(), 600, 450);
				
				g.drawRect(390, 495, 200, 30);
				g.setColor(Color.green);
				g.fillRect(395, 500, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(5).getHP() + "/" + battleObj.getFromPlayerParty(5).getMaxHP(), 395, 520);
				
			}else {
				slotSix.draw(390,435);
			}
		}
	}
	
	public void teamBuilderInstructions(GameContainer container) throws SlickException {
		if(screenIndex == 1) {
			Input input = container.getInput();
			
			int MouseX = input.getMouseX();
			int MouseY = input.getMouseY();
			
			if(i<battleObj.Player.PlayerParty.size()) {
				i++;
			}
			
			if(input.isKeyPressed(Input.KEY_BACK)) {
				previousScreen = true;
			}
			
			if(input.isKeyPressed(Input.KEY_RIGHT)) {
				if(listNum<battleObj.PokemonList.size()-9) {
					listNum += 20;
					if(listNum>battleObj.PokemonList.size()-9) {
						listNum = battleObj.PokemonList.size()-9;
					}
				}
			}
			
			if(input.isKeyPressed(Input.KEY_LEFT)){
				listNum -= 20;
					if(listNum<0) {
						listNum = 0;
				}
			}
			
			if(input.isKeyDown(Input.KEY_DOWN)) {
				if(listNum!=battleObj.PokemonList.size()-9) {
					listNum++;
					try {
						Thread.sleep(90);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(input.isKeyDown(Input.KEY_UP)) {
				listNum--;
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(listNum<0) {
					listNum = 0;
				}
			}
			
				if(battleObj.Player.PlayerParty.size()<6) {
					if(MouseX>891 && MouseY>86 && MouseY<166) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>170 && MouseY<234) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+1));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>240 && MouseY<304) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+2));
						partySize++;
						}
					}
					
					if(MouseX>892 && MouseY>310 && MouseY<374) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+3));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>380 && MouseY<444) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+4));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>450 && MouseY<514) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+5));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>520 && MouseY<584) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+6));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>590 && MouseY<654) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+7));
						partySize++;
						}
					}
					if(MouseX>892 && MouseY>660 && MouseY<724) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
						battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+8));
						partySize++;
						}
					}
				}
				
				if(battleObj.Player.partyExists) {
					if(MouseX>515 && MouseY > 625 && MouseX<793 && MouseY<703) {
						if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
								nextScreen = true;
							}
						}
					}
				}
			
		}
		
	public void drawBattle(Graphics g) throws SlickException {
		if(screenIndex == 2) {
			g.setFont(uniFont3);
			
			//DRAWS BG BASED ON TIME OF DAY
			if(LocalDateTime.now().getHour() < 14) {
				BGMorning.draw(0,0);
			}else if(LocalDateTime.now().getHour() > 19 || LocalDateTime.now().getHour() < 7) {
				BGNight.draw(0,0);
			}else {
				BGDusk.draw(0,0);
			}
			
			Textbox.draw(50, 595);
			
			OpponentHPBar.draw(0,100);
			HPBar.draw(792,400);
			
			//Draw Player HP
			g.setColor(changeColor(PlayerHPNum));
			g.fillRect(1076, 496, PlayerHPNum, 12);
			
			g.setColor(changeColor(OpponentHPNum));
			g.fillRect(144, 192, OpponentHPNum, 12);
			
			//sets image to pokemon in first slot
			trainerPokemon = battleObj.Player.getPokemonFromParty(currentPKMN).getBackSprite();
			trainerPokemon.draw(pkmnX, pkmnY, scale);
			
			opponentPokemon = battleObj.Joey.getPokemonFromParty(currentOpponentPKMN).getFrontSprite();
			opponentPokemon.draw(oppoX, oppoY, scale);
			
			g.setColor(Color.black);
			g.drawString(battleObj.getFromPlayerParty(currentPKMN).getName(), 1000, 438);
			g.drawString("" + battleObj.getFromPlayerParty(currentPKMN).getLevel(), 1220, 440);
			g.drawString("" + battleObj.getFromPlayerParty(currentPKMN).getHP(), 1105, 515);
			g.drawString("" + battleObj.getFromPlayerParty(currentPKMN).getMaxHP(), 1180, 515);
			
			g.setColor(Color.black);
			g.drawString(battleObj.Joey.getPokemonFromParty(currentOpponentPKMN).getName(), 80, 133);
			g.drawString("" + battleObj.Joey.getPokemonFromParty(currentOpponentPKMN).getLevel(), 285, 135);
			
			g.drawString(message, 340, 645);
			
			if(battleIndex == 1) {
				g.setColor(Color.black);
				//message = "What will " + battleObj.Player.PlayerParty.get(currentPKMN).getName() + " Do?";
				
				fightBox.draw(880, 570);
				pointer2.draw(PointX, PointY);
			}
			if(battleIndex == 2) {
				moveMenu.draw(880, 570);
				
				g.setColor(Color.black);
								
				g.drawString(move1, 930, 610);
				g.drawString(move2, 930, 660);
				g.drawString(move3, 1060, 610);
				g.drawString(move4, 1060, 660);
				
				pointer2.draw(PointX, PointY);
			}
			
		}
	}
		
	public void battleInstructions(GameContainer container) {
		if(screenIndex == 2) {
			
			backButtonEnabled = true;
			
			Input input = container.getInput();
			
			//DEBUG FEATURE FOR TESTING HP
			//if(input.isKeyDown(Input.KEY_LEFT)) {
				//int hp = battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP();
				//battleObj.Joey.EnemyParty.get(currentOpponentPKMN).setHP(hp-2);
				//changeHP = true;
			//}
			
			//DEBUG FEATURE FOR TESTING HP
//			if(input.isKeyDown(Input.KEY_RIGHT)) {
//				int hp = battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP();
//				battleObj.Joey.EnemyParty.get(currentOpponentPKMN).setHP(hp+2);
//				changeHP = true;
//			}
			
			//DEBUG FEATURE FOR TESTING HP
			if(input.isKeyDown(Input.KEY_LEFT)) {
				int hp = battleObj.Player.PlayerParty.get(currentPKMN).getHP();
				battleObj.Player.PlayerParty.get(currentPKMN).setHP(hp-2);
				changeHP = true;
			}
			
			//DEBUG FEATURE FOR TESTING HP
			if(input.isKeyDown(Input.KEY_RIGHT)) {
				int hp = battleObj.Player.PlayerParty.get(currentPKMN).getHP();
				battleObj.Player.PlayerParty.get(currentPKMN).setHP(hp+2);
				changeHP = true;
			}
			
			//BROKEN
//			if(opponentFaintMessage) {
//					battleIndex = -1;
//					
//					String str = "Foe " + battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getName() + " Fainted!";
//					message = str.substring(0,i);
//					sleep(30);
//					i++;
//					
//					if(i>str.length()) {
//						currentOpponentPKMN++;
//						battleIndex = 1;
//						opponentFaintMessage = false;
//					}	
//			}
			
			if(battleObj.PokemonList.get(1).getGen().equals("Gen4")) {
				if(setScale) {
					pkmnX = 180;
					pkmnY = 315;
					oppoX = 820;
					oppoY = 110;
					scale = 3.5f;
					setScale = false;
				}
			}
			
			if(battleObj.PokemonList.get(1).getGen().equals("Gen3")) {
				if(setScale) {
					pkmnX = 210;
					pkmnY = 340;
					oppoX = 820;
					oppoY = 140;
					scale = 4.0f;
					setScale = false;
				}
			}
			
			if(battleIndex == -2) {
				String str = "Opponent sent out " + battleObj.Joey.EnemyParty.get(currentOpponentPKMN+1).getName() +"!";
				if(message.length() != str.length()) {
					message = battleObj.printMessage("Opponent sent out " + battleObj.Joey.EnemyParty.get(currentOpponentPKMN+1).getName() +"!");
				}else {
					battleObj.sleep(500);
					currentOpponentPKMN++;
					battleIndex = 1;
				}
			}
			
			if(battleIndex == -1) {
					String str = "Foe " + battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getName() + " Fainted!";
					if(message.length() != str.length()) {
						message = battleObj.printMessage("Foe " + battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getName() + " Fainted!");
					}else{
						//you need to check party size to avoid out of bounds with less than 6
						if((battleObj.Joey.EnemyParty.get(0).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Joey.EnemyParty.get(1).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Joey.EnemyParty.get(2).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Joey.EnemyParty.get(3).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Joey.EnemyParty.get(4).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Joey.EnemyParty.get(5).getStatus().equalsIgnoreCase("Fainted"))) {
							PlayerVictory = true;
							increaseTwo = true;
						}else {
							battleObj.sleep(500);
							battleIndex--;
						}
						
					}					
				}
			
			if(battleIndex == 0) {
				if(moveMessage == 1) {
					String str = battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(0).getName() + "!";
					if(message.length() != str.length()) {
						message = battleObj.printMessage(battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(0).getName() + "!");
					}else {
						battleObj.sleep(500);
						battleIndex = 1;
						moveMessage = 0;
					}
				}
				if(moveMessage == 2) {
					String str = battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(1).getName() + "!";
					if(message.length() != str.length()) {
						message = battleObj.printMessage(battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(1).getName() + "!");
					}else {
						battleObj.sleep(500);
						battleIndex = 1;
						moveMessage = 0;
					}
				}
				if(moveMessage == 3) {
					String str = battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(2).getName() + "!";
					if(message.length() != str.length()) {
						message = battleObj.printMessage(battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(2).getName() + "!");
					}else {
						battleObj.sleep(500);
						battleIndex = 1;
						moveMessage = 0;
					}
				}
				if(moveMessage == 4) {
					String str = battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(3).getName() + "!";
					if(message.length() != str.length()) {
						message = battleObj.printMessage(battleObj.Player.PlayerParty.get(currentPKMN).getName() + " used " + battleObj.getFromPlayerParty(currentPKMN).getMove(3).getName() + "!");
					}else {
						battleObj.sleep(500);
						battleIndex = 1;
						moveMessage = 0;
					}
				}
			}
			
			if(battleIndex == 1) {
				String str = "What will " + battleObj.Player.PlayerParty.get(currentPKMN).getName() + " Do?";
				if(message.length() != str.length()) {
					message = battleObj.printMessage("What will " + battleObj.Player.PlayerParty.get(currentPKMN).getName() + " Do?");
				}
			
			}
			
			//sets hp proportion
			PlayerProportion = (double) battleObj.Player.PlayerParty.get(currentPKMN).getHP() / (double) battleObj.Player.PlayerParty.get(currentPKMN).getMaxHP();
			
			if(PlayerProportion != 1) {
				if(changeHP) {
					int hpleft = (int) (PlayerHPNum * PlayerProportion);
					if(PlayerHPNum != hpleft) {
						PlayerHPNum--;
					}else {
						changeHP = false;
					}
				}
			}
			if(PlayerProportion == 1) {
				PlayerHPNum = 192;
			}
			
			//ADD Opponent Proportion here
			OpponentProportion = (double) battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP() / (double) battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getMaxHP();
			
			if(OpponentProportion != 1) {
				if(changeEnemyHP) {
					OpponentHPNum = 192;
					OpponentHPNum = (int) (OpponentHPNum * OpponentProportion);
					changeEnemyHP = false;
				}
			}
			if(PlayerProportion == 1) {
				PlayerHPNum = 192;
			}
			
			if(OpponentProportion == 1) {
				OpponentHPNum = 192;
			}
			
			//fight menu
			fightMenu(container);
			
			//sets move names
			move1 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(0);
			move2 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(1);
			move3 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(2);
			move4 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(3);
			
			if(battleObj.getFromPlayerParty(currentPKMN).hasMoves) {
				move1 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(0);
				move2 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(1);
				move3 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(2);
				move4 = battleObj.getFromPlayerParty(currentPKMN).getMoveName(3);
			}
			
			//sets status to fainted if HP < 0
			if((battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP()) <= 0) {
				battleObj.Joey.EnemyParty.get(currentOpponentPKMN).setStatus("Fainted");
				if(battleIndex == 0) {
					battleIndex = -1;
				}
			}
			
			if(battleObj.Player.PlayerParty.get(currentPKMN).getHP() <= 0) {
				battleObj.Player.PlayerParty.get(currentPKMN).setStatus("Fainted");
								
				if((battleObj.Player.PlayerParty.get(0).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Player.PlayerParty.get(1).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Player.PlayerParty.get(2).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Player.PlayerParty.get(3).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Player.PlayerParty.get(4).getStatus().equalsIgnoreCase("Fainted"))&&(battleObj.Player.PlayerParty.get(5).getStatus().equalsIgnoreCase("Fainted"))) {
					OpponentVictory = true;
					screenIndex = 5;
				}else {
					backButtonEnabled = false;
					screenIndex = 3;
				}
				
			}
		}
	}
		
	public void fightMenu(GameContainer container) {
		Input input = container.getInput();
		if(battleIndex == 1) {
			if(input.isKeyPressed(Input.KEY_DOWN)) {
				choice++;
				if(choice > 3) {
					choice = 3;
				}
			}
			if(input.isKeyPressed(Input.KEY_UP)) {
				choice--;
				if(choice < 0) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_LEFT)) {
				choice-=2;
				if(choice > 0) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_RIGHT)) {
				choice+=2;
				if(choice > 3) {
					choice = 3;
				}
			}
			if(choice == 0) {
				PointX = 910;
				PointY = 600;
			}
			if(choice == 1) {
				PointX = 910;
				PointY = 650;
			}
			if(choice == 2) {
				PointX = 1105;
				PointY = 600;
			}
			if(choice == 3) {
				PointX = 1105;
				PointY = 650;
			}
			
			//Actual doing stuff
			if(choice == 0 && input.isKeyPressed(Input.KEY_ENTER)) {
				//bring up move list
				battleIndex++;
			}
			
			if(choice == 1 && input.isKeyPressed(Input.KEY_ENTER)) {
				//bring up partyScreen
				nextScreen = true;
			}
		}
		if(battleIndex == 2) {
			if(input.isKeyPressed(Input.KEY_DOWN)) {
				choice++;
				if(choice > 3) {
					choice = 3;
				}
			}
			if(input.isKeyPressed(Input.KEY_UP)) {
				choice--;
				if(choice < 0) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_LEFT)) {
				choice-=2;
				if(choice > 0) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_RIGHT)) {
				choice+=2;
				if(choice > 3) {
					choice = 3;
				}
			}
			if(choice == 0) {
				PointX = 910;
				PointY = 610;
			}
			if(choice == 1) {
				PointX = 910;
				PointY = 660;
			}
			if(choice == 2) {
				PointX = 1030;
				PointY = 610;
			}
			if(choice == 3) {
				PointX = 1030;
				PointY = 660;
			}
			if(input.isKeyPressed(Input.KEY_BACK)) {
				battleIndex --;
				choice = 0;
			}
			if(choice == 0 && input.isKeyPressed(Input.KEY_ENTER)) {
				battleIndex = 0; 
				moveMessage = 1;
				if(battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getMoveType().equalsIgnoreCase("Physical")) {
					int damage = battleObj.calculateDamage(battleObj.Player.PlayerParty.get(currentPKMN).getLevel(), battleObj.Player.PlayerParty.get(currentPKMN).getAttackStat(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getDefenseStat(), battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getBaseDamage(), battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getType(), battleObj.Player.PlayerParty.get(currentPKMN).getTypeOne(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getTypeOne(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getTypeTwo(), battleObj.Player.PlayerParty.get(currentPKMN).getStatus());
					int hp = battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP();
					battleObj.Joey.EnemyParty.get(currentOpponentPKMN).setHP(hp - 200);
					changeEnemyHP = true;
				}
				if(battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getMoveType().equalsIgnoreCase("Special")) {
					int damage = battleObj.calculateDamage(battleObj.Player.PlayerParty.get(currentPKMN).getLevel(), battleObj.Player.PlayerParty.get(currentPKMN).getSpecialAttackStat(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getSpecialDefenseStat(), battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getBaseDamage(), battleObj.Player.PlayerParty.get(currentPKMN).getMove(0).getType(), battleObj.Player.PlayerParty.get(currentPKMN).getTypeOne(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getTypeOne(), battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getTypeTwo(), battleObj.Player.PlayerParty.get(currentPKMN).getStatus());
					int hp = battleObj.Joey.EnemyParty.get(currentOpponentPKMN).getHP();
					battleObj.Joey.EnemyParty.get(currentOpponentPKMN).setHP(hp - 200);
					changeEnemyHP = true;
				}
				
				//Enemy attack function call
				
			}
		}
	}
		
	public void drawParty(Graphics g) {
		if(screenIndex == 3) {
			
			//should be set to unifont2 (white Text)
			g.setFont(uniFont2);
			
			PartyScreen.draw(0,0);
			
			slotOne.draw(100,40,2);
			g.drawString(battleObj.getFromPlayerParty(0).getName(), 170, 75);
			g.drawString("Lv " + battleObj.getFromPlayerParty(0).getLevel(), 310, 75);
			
			g.drawRect(110, 120, 202, 30);
			g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(0).getHP() / (double) battleObj.Player.PlayerParty.get(0).getMaxHP()))));
			g.fillRect(115, 125, (int)(192*((double) battleObj.Player.PlayerParty.get(0).getHP() / (double) battleObj.Player.PlayerParty.get(0).getMaxHP())), 20);
			g.setColor(Color.white);
			
			g.drawString("HP: "+ battleObj.getFromPlayerParty(0).getHP() + "/" + battleObj.getFromPlayerParty(0).getMaxHP(), 320, 130);
			
			if(battleObj.getFromPlayerParty(0).getStatus().equalsIgnoreCase("Fainted")) {
				fnt.draw(420, 75);
				g.drawString("FNT", 430, 70);
			}
			
			if(i > 1) {
				slotTwo.draw(780,40,2);
				g.drawString(battleObj.getFromPlayerParty(1).getName(), 850, 75);
				g.drawString("Lv " + battleObj.getFromPlayerParty(1).getLevel(), 990, 75);
				
				g.drawRect(790, 120, 202, 30);
				g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(1).getHP() / (double) battleObj.Player.PlayerParty.get(1).getMaxHP()))));
				g.fillRect(795, 125, (int)(192*((double) battleObj.Player.PlayerParty.get(1).getHP() / (double) battleObj.Player.PlayerParty.get(1).getMaxHP())), 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(1).getHP() + "/" + battleObj.getFromPlayerParty(1).getMaxHP(), 1000, 130);
				
				if(battleObj.getFromPlayerParty(1).getStatus().equalsIgnoreCase("Fainted")) {
					fnt2.draw(1100, 75);
					g.drawString("FNT", 1110, 70);
				}
				
			}
			
			if(i>2) {
				slotThree.draw(100,260,2);
				g.drawString(battleObj.getFromPlayerParty(2).getName(), 170, 295);
				g.drawString("Lv " + battleObj.getFromPlayerParty(2).getLevel(), 310, 295);
				
				g.drawRect(110, 340, 202, 30);
				g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(2).getHP() / (double) battleObj.Player.PlayerParty.get(2).getMaxHP()))));
				g.fillRect(115, 345, (int)(192*((double) battleObj.Player.PlayerParty.get(2).getHP() / (double) battleObj.Player.PlayerParty.get(2).getMaxHP())), 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(2).getHP() + "/" + battleObj.getFromPlayerParty(2).getMaxHP(), 320, 350);
			
				if(battleObj.getFromPlayerParty(2).getStatus().equalsIgnoreCase("Fainted")) {
					fnt3.draw(420, 295);
					g.drawString("FNT", 430, 290);
				}
			
			}
			
			if(i>3) {
				slotFour.draw(780,260,2);
				g.drawString(battleObj.getFromPlayerParty(3).getName(), 850, 295);
				g.drawString("Lv " + battleObj.getFromPlayerParty(3).getLevel(), 990, 295);
				
				g.drawRect(790, 340, 202, 30);
				g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(3).getHP() / (double) battleObj.Player.PlayerParty.get(3).getMaxHP()))));
				g.fillRect(795, 345, (int)(192*((double) battleObj.Player.PlayerParty.get(3).getHP() / (double) battleObj.Player.PlayerParty.get(3).getMaxHP())), 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(3).getHP() + "/" + battleObj.getFromPlayerParty(3).getMaxHP(), 1000, 350);
			
				if(battleObj.getFromPlayerParty(3).getStatus().equalsIgnoreCase("Fainted")) {
					fnt4.draw(1100, 295);
					g.drawString("FNT", 1110, 290);
				}
				
			}
			
			if(i>4) {
				slotFive.draw(100,470,2);
				g.drawString(battleObj.getFromPlayerParty(4).getName(), 170, 500);
				g.drawString("Lv " + battleObj.getFromPlayerParty(4).getLevel(), 310, 500);
				
				g.drawRect(110, 550, 202, 30);
				g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(4).getHP() / (double) battleObj.Player.PlayerParty.get(4).getMaxHP()))));
				g.fillRect(115, 555, (int)(192*((double) battleObj.Player.PlayerParty.get(4).getHP() / (double) battleObj.Player.PlayerParty.get(4).getMaxHP())), 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(4).getHP() + "/" + battleObj.getFromPlayerParty(4).getMaxHP(), 320, 555);
		
				if(battleObj.getFromPlayerParty(4).getStatus().equalsIgnoreCase("Fainted")) {
					fnt5.draw(420, 500);
					g.drawString("FNT", 430, 495);
				}
				
			}
			
			if(i>5) {
				slotSix.draw(780,470,2);
				g.drawString(battleObj.getFromPlayerParty(5).getName(), 850, 500);
				g.drawString("Lv " + battleObj.getFromPlayerParty(5).getLevel(), 990, 500);
				
				g.drawRect(790, 550, 202, 30);
				g.setColor(changeColor((int)(192*((double) battleObj.Player.PlayerParty.get(5).getHP() / (double) battleObj.Player.PlayerParty.get(5).getMaxHP()))));
				g.fillRect(795, 555, (int)(192*((double) battleObj.Player.PlayerParty.get(5).getHP() / (double) battleObj.Player.PlayerParty.get(5).getMaxHP())), 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(5).getHP() + "/" + battleObj.getFromPlayerParty(5).getMaxHP(), 1000, 555);
			
				if(battleObj.getFromPlayerParty(5).getStatus().equalsIgnoreCase("Fainted")) {
					fnt6.draw(1100, 500);
					g.drawString("FNT", 1110, 495);
				}
			
			}
			
			if(popupText) {
				Textbox.draw(60, 600);
				
				g.drawString(faintedMessage, 300, 650);
			}
			
		}
	}
	

	
	public void partyScreenInstructions(GameContainer container) {
		if(screenIndex == 3) {
			Input input = container.getInput();
			int MouseX = input.getMouseX();
			int MouseY = input.getMouseY();
			
			if(backButtonEnabled) {
				if(input.isKeyPressed(Input.KEY_BACK)) {
					choice = 0;
					previousScreen = true;
				}
			}
			
			if(MouseX > 90 && MouseY > 60 && MouseX < 511 && MouseY < 201) {
				if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
					if(battleObj.Player.PlayerParty.get(0).getStatus().equalsIgnoreCase("Fainted")) {
						//Popup that tells the player that <PKMN NAME> has no energy left to fight
						popupText = true;
						faintedMessage = "ligma";
//						noEnergyToFight(0);
					}else {
						choice = 0;
						currentPKMN = 0;
						previousScreen = true;
					}
				}
			}
			
			if(MouseX > 775 && MouseY > 60 && MouseX < 1196 && MouseY < 201) {
				if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
					if(i>1) {
						if(battleObj.Player.PlayerParty.get(1).getStatus().equalsIgnoreCase("Fainted")) {
							//Popup that tells the player that <PKMN NAME> has no energy left to fight
						}else {
							choice = 0;
							currentPKMN = 1;
							previousScreen = true;
						}
					}
				}
			}
			
			if(MouseX > 90 && MouseY > 270 && MouseX < 511 && MouseY < 413) {
				if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
					if(i>2) {
						if(battleObj.Player.PlayerParty.get(2).getStatus().equalsIgnoreCase("Fainted")) {
							//Popup that tells the player that <PKMN NAME> has no energy left to fight
						}else {
							choice = 0;
							currentPKMN = 2;
							previousScreen = true;
						}
					}
				}
			}
				if(MouseX > 775 && MouseY > 270 && MouseX < 1196 && MouseY < 413) {
					if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
						if(i>3) {
							if(battleObj.Player.PlayerParty.get(3).getStatus().equalsIgnoreCase("Fainted")) {
								//Popup that tells the player that <PKMN NAME> has no energy left to fight
							}else {
								choice = 0;
								currentPKMN = 3;
								previousScreen = true;
							}
						}
					}
				}
				if(MouseX > 90 && MouseY > 480 && MouseX < 511 && MouseY < 621) {
					if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
						if(i>4) {
							if(battleObj.Player.PlayerParty.get(4).getStatus().equalsIgnoreCase("Fainted")) {
								//Popup that tells the player that <PKMN NAME> has no energy left to fight
							}else {
								choice = 0;
								currentPKMN = 4;
								previousScreen = true;
							}
						}
					}
				}
				if(MouseX > 775 && MouseY > 480 && MouseX < 1196 && MouseY < 621) {
					if(input.isMousePressed((Input.MOUSE_LEFT_BUTTON))) {
						if(i>5) {
							if(battleObj.Player.PlayerParty.get(5).getStatus().equalsIgnoreCase("Fainted")) {
								//Popup that tells the player that <PKMN NAME> has no energy left to fight
							}else {
								choice = 0;
								currentPKMN = 5;
								previousScreen = true;
							}
						}
					}
				}
		}
	}
	
	public Color changeColor(int num) {
		Color color;
		
		if(num < 95 && num > 38) {
			color = (Color.yellow);
		}else if(num < 39) {
			color = (Color.red);
		}else {
			color = (Color.green);
		}
		return color;
	}
	
	public void increaseTwoScreenIndex(Graphics g) {
		if(increaseTwo) {
			backButtonEnabled = false;
			transition.draw(0, 0, new Color(255,255,255,alpha));
			if(q == 0) {
				if(alpha<255) {
					alpha+=15;
					if(alpha>254) {
						screenIndex = 4;
						q++;
					}
				}
			}if(q==1) {
				if(alpha>0) {
					alpha-=15;
				}else {
					alpha = 0;
					q=0;
					backButtonEnabled = true;
					increaseTwo = false;
				}
			}
		}
	}
	
	public void increaseScreenIndex(Graphics g) {
		if(nextScreen) {
			backButtonEnabled = false;
			transition.draw(0, 0, new Color(255,255,255,alpha));
			if(q == 0) {
				if(alpha<255) {
					alpha+=15;
					if(alpha>254) {
						screenIndex++;
						q++;
					}
				}
			}if(q==1) {
				if(alpha>0) {
					alpha-=15;
				}else {
					alpha = 0;
					q=0;
					backButtonEnabled = true;
					nextScreen = false;
				}
			}
		}
	}
	
	public void decreaseScreenIndex(Graphics g) {
		if(previousScreen) {
			backButtonEnabled = false;
			transition.draw(0, 0, new Color(255,255,255,alpha));
			if(q == 0) {
				if(alpha<255) {
					alpha+=10;
					if(alpha>254) {
						screenIndex--;
						q++;
					}
				}
			}if(q==1) {
				if(alpha>0) {
					alpha-=10;
				}else {
					alpha = 0;
					q=0;
					backButtonEnabled = true;
					previousScreen = false;
				}
			}
		}
	}
		
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void noEnergyToFight(int num) {
		if(popupText) {
			String str = battleObj.Player.PlayerParty.get(num).getName() + " has no energy left to battle!";
			if(faintedMessage.length() != str.length()) {
				faintedMessage = battleObj.printMessage(battleObj.Player.PlayerParty.get(num).getName() + " has no energy left to battle!");
			}else {
				battleObj.sleep(500);
				popupText = false;
			}
		}
	}
	
	public void drawVictory(Graphics g){
		if(screenIndex == 4) {
			Victory.draw(0,0);
			
			Trainer.draw(100,90, scale);
			
			if(i>0) {
				if(battleObj.Player.PlayerParty.get(0).getStatus().equalsIgnoreCase("Fainted")) {
					try {
						battleObj.Player.getPokemonFromParty(0).getScaledFrontSprite().drawFlash(270, 90, 280, 280, Color.black);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					try {
						battleObj.Player.getPokemonFromParty(0).getFrontSprite().draw(270, 90, scale);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(i>1) {
					if(battleObj.Player.PlayerParty.get(1).getStatus().equalsIgnoreCase("Fainted")) {
						try {
							battleObj.Player.getPokemonFromParty(1).getScaledFrontSprite().drawFlash(550, 90, 280, 280, Color.black);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						try {
							battleObj.Player.getPokemonFromParty(1).getFrontSprite().draw(550, 90, scale);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if(i>2) {
					if(battleObj.Player.PlayerParty.get(2).getStatus().equalsIgnoreCase("Fainted")) {
						try {
							battleObj.Player.getPokemonFromParty(2).getScaledFrontSprite().drawFlash(830, 90, 280, 280, Color.black);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						try {
							battleObj.Player.getPokemonFromParty(2).getFrontSprite().draw(830, 90, scale);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if(i>3) {
					if(battleObj.Player.PlayerParty.get(3).getStatus().equalsIgnoreCase("Fainted")) {
						try {
							battleObj.Player.getPokemonFromParty(3).getScaledFrontSprite().drawFlash(270, 370, 280, 280, Color.black);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						try {
							battleObj.Player.getPokemonFromParty(3).getFrontSprite().draw(270, 370, scale);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if(i>4) {
					if(battleObj.Player.PlayerParty.get(4).getStatus().equalsIgnoreCase("Fainted")) {
						try {
							battleObj.Player.getPokemonFromParty(4).getScaledFrontSprite().drawFlash(550, 370, 280, 280, Color.black);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						try {
							battleObj.Player.getPokemonFromParty(4).getFrontSprite().draw(550, 370, scale);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				if(i>5) {
					if(battleObj.Player.PlayerParty.get(5).getStatus().equalsIgnoreCase("Fainted")) {
						try {
							battleObj.Player.getPokemonFromParty(5).getScaledFrontSprite().drawFlash(830, 370, 280, 280, Color.black);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						try {
							battleObj.Player.getPokemonFromParty(5).getFrontSprite().draw(830, 370, scale);
						} catch (SlickException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public void drawLoss(Graphics g) {
		if(screenIndex == 5) {
			Defeat.draw(0,0);
			
			//FINISH ME
		}
	}
}

