import java.util.ArrayList;
import java.util.Random;

public class Battle {
	
	ArrayList<Pokemon> PokemonList = new ArrayList<Pokemon>();
	ArrayList<Move> MoveList = new ArrayList<Move>();
	
	Pokemon pokemon = new Pokemon();
	Trainer Player = new Trainer();
	Opponent Joey;
	int turnNumber = 0;
	double typeEffectiveness = 1;
	
	int i = 0;
	int j = 0;
	int textSpeed = 35;
	boolean messageDone = false;
	
	public Battle() {
		
		Move Absorb = new Move("Absorb", "Grass", "Special", 20, 100, 25);//User recovers half the HP inflicted on opponent.
		Move Acid = new Move("Acid", "Poison", "Special", 40, 100, 30); //May lower opponent's Special Defense 
		Move AcidArmor = new Move("Acid Armor", "Poison", "Other", 0, 100, 20);//Sharply raises user's Defense.
		Move Agility = new Move("Agility", "Psychic", "Other", 0, 100, 30);//Sharply raises user's Speed.
		Move Amnesia = new Move("Amnesia", "Psychic", "Other", 0, 100, 20);//Sharply raises user's Special Defense.
		Move AuroraBeam = new Move("Aurora Beam", "Ice", "Special", 65, 100, 20);//May lower opponent's Attack.
		Move Barrage = new Move("Barrage", "Normal", "Physical", 15, 85, 20);//Hits 2-5 times in one turn.
		Move Barrier = new Move("Barrier", "Psychic", "Other", 0, 100, 20);//Sharply raises user's Defense.
		Move Bide = new Move("Bide", "Normal", "Physical", 0, 100, 10);//User takes damage for two turns then strikes back double.
		Move Bind = new Move("Bind", "Normal", "Physical", 15, 85, 20);//Traps opponent, damaging them for 4-5 turns.
		Move Bite = new Move("Bite", "Dark", "Physical", 60, 100, 25);//	May cause flinching.
		Move Blizzard = new Move("Blizzard", "Ice", "Special", 110, 70, 5);//May freeze opponent.
		Move BodySlam = new Move("Body Slam", "Normal", "Physical", 85, 100, 15);//May paralyze opponent.
		Move BoneClub = new Move("Bone Club", "Ground", "Physical", 65, 85, 20);//May cause flinching.
		Move Bonemerang = new Move("Bonemerang", "Ground", "Physical", 50, 90, 10);//Hits twice in one turn.
		Move Bubble = new Move("Bubble", "Water", "Special", 40, 100, 30);//May lower opponent's Speed.
		Move Bubblebeam = new Move("Bubblebeam", "Water", "Special", 65, 100, 20);//May lower opponent's Speed.
		Move Clamp = new Move("Clamp", "Water", "Physical", 35, 85, 10);//Traps opponent, damaging them for 4-5 turns.
		Move CometPunch = new Move("Comet Punch", "Normal", "Physical", 10, 85, 15);//Hits 2-5 times in one turn.
		Move ConfuseRay = new Move("Confuse Ray", "Ghost", "Other", 0, 100, 10);//Confuses opponent
		Move Confusion = new Move("Confusion", "Psychic", "Special", 50, 100, 25);//May confuse opponent		
		Move Constrict = new Move("Constrict", "Normal", "Physical", 10, 100, 35);//May lower opponent's speed by one stage
		Move Conversion = new Move("Conversion", "Normal", "Other", 0, 100, 30);//Changes user's type to that of first move
		Move Counter = new Move("Counter", "Fighting", "Physical", 0, 100, 20);//When hit by a Physical Attack, user strikes back with 2x power.
		Move Crabhammer = new Move("Crabhammer", "Water", "Physical", 100, 90, 10);//High critical hit ratio
		Move Cut = new Move("Cut", "Normal","Physical", 50, 95, 30);
		Move DefenseCurl = new Move("Defense Curl", "Normal", "Other", 0, 100, 40);//Raises users defense
		Move Dig = new Move("Dig", "Ground", "Physical", 80, 100, 10);//Digs underground on first turn, attacks on second. Can also escape from caves.
		Move Disable = new Move("Disable", "Normal", "Other", 0, 100, 20);//Opponent can't use its last attack for a few turns.
		Move DizzyPunch = new Move("Dizzy Punch", "Normal", "Physical", 70, 100, 10);//May confuse opponent.
		Move DoubleKick = new Move("Double Kick", "Fighting", "Physical", 30, 100, 30);//Hits twice in one turn
		Move DoubleSlap = new Move("Double Slap", "Normal", "Physical", 15, 85, 10);//Hits 2-5 times in one turn.
		Move DoubleTeam = new Move("Double Team", "Normal", "Other", 0, 100, 15);//Raises user's evasiveness
		Move DoubleEdge = new Move("Double Edge", "Normal", "Physical", 120, 100, 15);//User receives recoil damage
		Move DragonRage = new Move("Dragon Rage", "Dragon", "Special", 0, 100, 10);//Always does 40 damage
		Move DreamEater = new Move("Dream Eater", "Psychic", "Special", 100, 100, 15);//User recovers half the HP inflicted on a sleeping opponent.
		Move DrillPeck = new Move("Drill Peck", "Flying", "Physical", 80, 100, 20);
		Move Earthquake = new Move("Earthquake", "Ground", "Physical", 100, 100, 10);//Power is doubled if opponent is underground from using Dig.
		Move EggBomb = new Move("Egg Move", "Normal", "Physical", 100, 75, 10);
		Move Ember = new Move("Ember", "Fire", "Special", 40, 100, 25);//May burn opponent
		Move Explosion = new Move("Explosion", "Normal", "Physical", 250, 100, 5);//User Faints
		Move FireBlast = new Move("Fire Blast", "Fire", "Special", 110, 85, 5);//May Burn opponent
		Move FirePunch = new Move("Fire Punch", "Fire", "Physical", 75, 100, 15);//May burn opponent
		Move FireSpin = new Move("Fire Spin", "Fire", "Special", 35, 85, 15);//Traps opponent, damaging them for 4-5 turns
		Move Fissure = new Move("Fissure", "Ground", "Physical", 0, 30, 5);//One hit KO if it hits
		Move Flamethrower = new Move("Flamethrower", "Fire", "Special", 90, 100, 15);//May Burn opponent
		Move Flash = new Move("Flash", "Noraml", "Other", 0, 100, 20);//Lowers opponent's accuracy
		Move Fly = new Move("Fly", "Flying", "Physical", 90, 95, 15);//Flies up on first turn, attacks on second turn.
		Move FocusEnergy = new Move("Focus Enery", "Normal", "Other", 0, 100, 30);//Increases critical hit ratio
		Move FuryAttack = new Move("Fury Attack", "Normal", "Physical", 15, 85, 20);//Hits 2-5 times in one turn.
		Move FurySwipes = new Move("Fury Swipes", "Normal", "Physical", 18, 80, 15);//Hits 2-5 times in one turn.
		Move Glare = new Move("Glare", "Normal", "Other", 0, 100, 30);//Paralyze Opponent
		Move Growl = new Move("Growl", "Normal", "Other", 0, 100, 40);//Lowers opponent's attack
		Move Growth = new Move("Growth", "Normal", "Other", 0, 100, 40);//Raises User's Attack & Special Attack
		Move Guillotine = new Move("Guillotne", "Normal", "Physical", 0, 30, 5);//One hit KO if it hits
		Move Gust = new Move("Gust", "Flying", "Special", 40, 100, 35);//Hits pokemon using FLy/Bounce with double power
		Move Harden = new Move("Harden", "Normal", "Other", 0, 100, 30);//Raises user's defense
		Move Haze = new Move("Haze", "Ice", "Other", 0, 100, 30);//Resets all stat changes
		Move Headbutt = new Move("Headbutt", "Normal", "Physical", 70, 100, 15);//May Cause Flinching
		Move HighJumpKick = new Move("High Jump Kick", "Fighting", "Physical", 130, 90, 10);//If it misses it halfs the users HP
		Move HornAttack = new Move("Horn Attack", "Normal", "Physical", 65, 100, 25);
		Move HornDrill = new Move("Horn Drill", "Normal", "Physical", 0, 30, 5);//One Hit KO if it hits
		Move HydroPump = new Move("Hydro Pump", "Water", "Special", 110, 80, 5);
		Move HyperBeam = new Move("Hyper Beam", "Normal", "Specail", 150, 90, 5);//User must recharge next turn
		Move HyperFang = new Move("Hyper Fang", "Normal", "Physical", 80, 90, 15);//May cause Flinching
		Move Hypnosis = new Move("Hypnosis", "Psychic", "Other", 0, 60, 20);//Puts opponent to sleep
		Move IceBeam = new Move("Ice Beam", "Ice", "Special", 90, 100, 10);//May freeze opponent
		Move IcePunch = new Move("Ice Punch", "Ice", "Physical", 75, 100, 15);//May freeze opponent
		Move JumpKick = new Move("Jump Kick", "Fighting", "Physical", 100, 95, 10);//If it misses it halfes the users HP
		Move KarateChop = new Move("Karate Chop", "Fighting", "Physical", 50, 100, 25);//High Crit Ratio
		Move Kinesis = new Move("Kinesis", "Psychic", "Other", 0, 80, 15);//Lowers opponents accuracy
		Move LeechLife = new Move("Leech Life", "Bug", "Special", 10, 90, 10);//Steals HP from opponent
		Move LeechSeed = new Move("Leech Seed", "Grass", "Other", 0, 90, 10);//User Steals HP from opponent each turn
		Move Leer = new Move("Leer", "Normal", "Other", 0, 100, 30);//Lowers opponents defense
		Move Lick = new Move("Lick", "Ghost", "Physical", 30, 100, 30);//May Paralyze opponent
		Move LightScreen = new Move("Light Screen", "Psychic", "Other", 0, 100, 30);//Halves Damage from special attack for 5 turns
		Move LovelyKiss = new Move("Lovely Kiss", "Normal", "Other", 0, 75, 10);//Puts opponent to sleep
		Move LowKick = new Move("Low Kick", "Fighting", "Physical", 0, 100, 20);//Heavier opponent gets more damage
		Move Meditate = new Move("Meditate", "Psychic", "Other", 0, 100, 40);//Raises user's attack
		Move MegaDrain = new Move("Mega Drain", "Grass", "Special", 40, 100, 15);//User recovers half the HP Inflected on the opponent
		Move MegaKick = new Move("Mega Kick", "Normal", "Physical", 120, 75, 5);
		Move MegaPunch = new Move("Mega Punch", "Normal", "Physical", 80, 85, 20);
		Move Metronome = new Move("Metronome", "Normal", "Other", 0, 100, 10);//User performs any move in the game at random
		Move Mimic = new Move("Mimic", "Normal", "Other", 0, 100, 10);//Copies opponent's last move
		Move Minimize = new Move("Minimize", "Normal", "Other", 0, 100, 10);//Sharply raises user's evasiveness
		Move MirrorMove = new Move("Mirror Move", "Flying", "Other", 0, 100, 20);//user performs opponent last move
		Move Mist = new Move("Mist", "Ice", "Other", 0, 100, 30);//users cannot be changed for a time
		Move NightShade = new Move("Night Shde", "Ghost", "Special", 0, 100, 15);//inflicts damage equal to the user's level
		Move PayDay = new Move("Pay Day", "Normal", "Physical", 40, 100, 20);
		Move Peck = new Move("Peck", "Flying", "Physical", 35, 100, 35);
		Move PetalDance = new Move("Petal Dance", "Grass", "Special", 120, 100, 10);//attacks for 2-3 turns, then gives user confusion
		Move PinMissile = new Move("Pin Missile", "Bug", "Physical", 25, 95, 20);//hits 2-5 times per turn
		Move PoisonGas = new Move("Poison Gas", "Poison", "Other", 0, 90, 40);//Poisons opponent
		Move PoisonSting = new Move("Poison Sting", "Poison", "Physical", 15, 100, 35);//May Poison Opponent
		Move Pound = new Move("Pound", "Normal", "Physical", 40, 100, 35);
		Move Psybeam = new Move("Psybeam", "Psychic", "Special", 65, 100, 20);//may confuse opponent
		Move Psychic = new Move("Psychic", "Psychic", "Special", 90, 100, 10);//may lower oppoent spec def
		Move Psywave = new Move("Psywave", "Psychic", "Special", 0, 80, 15);//inflicts 50 - 150% of users level
		Move QuickAttack = new Move("Quick Attack", "Normal", "Physical", 40, 100, 30);
		Move Rage = new Move("Rage", "Normal", "Physical", 20, 100, 20);//raises users attack when hit
		Move RazorLeaf = new Move("Razor Leaf", "Grass", "Physical", 55, 95, 25);//high crit ratio
		Move RazorWind = new Move("Razor Wind", "Normal", "Special", 80, 100, 10);//charges on first turn attacks on second
		Move Recover = new Move("Recover", "Normal", "Other", 0, 100, 10);//user recovers half max hp
		Move Reflect = new Move("Reflect", "Psychic", "Other", 0, 100, 20);//Halfs damage from physical attacks for 5 turns
		Move Rest = new Move("Rest", "Psychic", "Other", 0, 100, 10);//user sleeps for 2 turns but is fully healed
		Move Roar = new Move("Roar", "Normal", "Other", 0, 100, 20);//Opponent switches pkmn randomly
		Move RockSlide = new Move("Rock Slide", "Rock", "Physical", 75, 90, 10);//may cause flinching
		Move RockThrow = new Move("Rock Throw", "Rock", "Physical", 50, 90, 15);
		Move RollingKick = new Move("Rolling Kick", "Fighting", "Physical", 60, 85, 15);//may cause flinching
		Move SandAttack = new Move("Sand Attack", "Ground", "Other", 0, 100, 15);//lowers opponents accuracy
		Move Scratch = new Move("Scratch", "Normal", "Physical", 40, 100, 35);
		Move Screech = new Move("Screech", "Normal", "Other", 0, 85, 40);//Sharply lowers opponent's defense
		Move SeismicToss = new Move("Seismic Toss", "Fighting", "Physical", 0, 100, 20);//Inflicts damage equal to user's level
		Move SelfDestruct = new Move("Self Destruct", "Normal", "Physical", 200, 100, 5);//User Faints
		Move Sharpen = new Move("Sharpen", "Normal", "Other", 0, 100, 30);//raises users attack
		Move Sing = new Move("Sing", "Normal", "Other", 0, 55, 15);//puts opponent to sleep
		
		Move Tackle = new Move("Tackle", "Normal", "Physical", 40, 100, 35);
		
		MoveList.add(Absorb);//0
		MoveList.add(Acid);
		MoveList.add(AcidArmor);
		MoveList.add(Agility);
		MoveList.add(Amnesia);
		MoveList.add(AuroraBeam);//5
		MoveList.add(Barrage);
		MoveList.add(Barrier);
		MoveList.add(Bide);
		MoveList.add(Bind);
		MoveList.add(Bite);//10
		MoveList.add(Blizzard);
		MoveList.add(BodySlam);
		MoveList.add(BoneClub);
		MoveList.add(Bonemerang);
		MoveList.add(Bubble);//15
		MoveList.add(Bubblebeam);
		MoveList.add(Clamp);
		MoveList.add(CometPunch);
		MoveList.add(ConfuseRay);
		MoveList.add(Confusion);//20
		MoveList.add(Constrict);
		MoveList.add(Conversion);
		MoveList.add(Counter);
		MoveList.add(Crabhammer);
		MoveList.add(Cut);//25
		MoveList.add(DefenseCurl);
		MoveList.add(Dig);
		MoveList.add(Disable);
		MoveList.add(DizzyPunch);
		MoveList.add(DoubleKick);//30
		MoveList.add(DoubleSlap);
		MoveList.add(DoubleTeam);
		MoveList.add(DoubleEdge);
		MoveList.add(DragonRage);
		MoveList.add(DreamEater);//35
		MoveList.add(DrillPeck);
		MoveList.add(Earthquake);
		MoveList.add(EggBomb);
		MoveList.add(Ember);
		MoveList.add(Explosion);//40
		MoveList.add(FireBlast);
		MoveList.add(FirePunch);
		MoveList.add(FireSpin);
		MoveList.add(Fissure);
		MoveList.add(Flamethrower);//45
		MoveList.add(Flash);
		MoveList.add(Fly);
		MoveList.add(FocusEnergy);
		MoveList.add(FuryAttack);
		MoveList.add(FurySwipes);//50
		MoveList.add(Glare);
		MoveList.add(Growl);
		MoveList.add(Growth);
		MoveList.add(Guillotine);
		MoveList.add(Gust);//55
		MoveList.add(Harden);
		MoveList.add(Haze);
		MoveList.add(Headbutt);
		MoveList.add(HighJumpKick);
		MoveList.add(HornAttack);//60
		MoveList.add(HornDrill);
		MoveList.add(HydroPump);
		MoveList.add(HyperBeam);
		MoveList.add(HyperFang);
		MoveList.add(Hypnosis);//65
		MoveList.add(IceBeam);
		MoveList.add(IcePunch);
		MoveList.add(JumpKick);
		MoveList.add(KarateChop);
		MoveList.add(Kinesis);//70
		MoveList.add(LeechLife);
		MoveList.add(LeechSeed);
		MoveList.add(Leer);
		MoveList.add(Lick);
		MoveList.add(LightScreen);//75
		MoveList.add(LovelyKiss);
		MoveList.add(LowKick);
		MoveList.add(Meditate);
		MoveList.add(MegaDrain);
		MoveList.add(MegaKick);//80
		MoveList.add(MegaPunch);
		MoveList.add(Metronome);
		MoveList.add(Mimic);
		MoveList.add(Minimize);
		MoveList.add(MirrorMove);//85
		MoveList.add(Mist);
		MoveList.add(NightShade);
		MoveList.add(PayDay);
		MoveList.add(Peck);
		MoveList.add(PetalDance);//90
		MoveList.add(PinMissile);
		MoveList.add(PoisonGas);
		MoveList.add(PoisonSting);
		MoveList.add(Pound);
		MoveList.add(Psybeam);//95
		MoveList.add(Psychic);
		MoveList.add(Psywave);
		MoveList.add(QuickAttack);
		MoveList.add(Rage);
		MoveList.add(RazorLeaf);//100
		MoveList.add(RazorWind);
		MoveList.add(Recover);
		MoveList.add(Reflect);
		MoveList.add(Rest);
		MoveList.add(Roar);//105
		MoveList.add(RockSlide);
		MoveList.add(RockThrow);
		MoveList.add(RollingKick);
		MoveList.add(SandAttack);
		MoveList.add(Scratch);//110
		MoveList.add(Screech);
		MoveList.add(SeismicToss);
		MoveList.add(SelfDestruct);
		MoveList.add(Sharpen);
		MoveList.add(Sing);//115
		
		MoveList.add(Tackle);
		
		//------------------------------------------------------------------------------------------
		
		Pokemon MissingNo = new Pokemon("MissingNo", 100, 170, 170, 170, 170, 170,170, "Normal");
		Pokemon Bulbasaur = new Pokemon("Bulbasaur", 50, 45, 49, 49, 65, 65, 45, "Grass", "Poison");
		Pokemon Ivysaur = new Pokemon("Ivysaur", 50, 60, 62, 63, 80, 80, 60, "Grass", "Poison");
		Pokemon Venusaur = new Pokemon("Venusaur", 50, 80, 82, 83, 100, 100, 80, "Grass", "Poison");
		Pokemon Charmander = new Pokemon("Charmander", 50, 39, 52, 43, 60, 50, 65, "Fire");
		Pokemon Charmeleon = new Pokemon("Charmeleon", 50, 58, 64, 58, 80, 65, 80, "Fire");
		Pokemon Charizard = new Pokemon("Charizard", 50, 78, 84, 78, 109, 85, 100, "Fire", "Flying");
		Pokemon Squirtle = new Pokemon("Squirtle", 50, 44, 48, 65, 50, 64, 43, "Water");
		Pokemon Wartortle = new Pokemon("Wartortle", 50, 59, 63, 80, 65, 80, 58, "Water");
		Pokemon Blastoise = new Pokemon("Blastoise", 50, 79, 83, 100, 85, 105, 78, "Water");
		Pokemon Caterpie = new Pokemon("Caterpie", 50, 45, 30, 35, 20, 20, 45, "Bug");
		Pokemon Metapod = new Pokemon("Metapod", 50, 50, 20, 55, 25, 25, 30, "Bug");
		Pokemon Butterfree = new Pokemon("Butterfree", 50, 60, 45, 50, 90, 80, 70, "Bug", "Flying");
		Pokemon Weedle = new Pokemon("Weedle", 50, 40, 35, 30, 20, 20, 50, "Bug", "Poison");
		Pokemon Kakuna = new Pokemon("Kakuna", 50, 45, 25, 50, 25, 25, 35, "Bug", "Poison");
		Pokemon Beedrill = new Pokemon("Beedrill", 50, 65, 90, 40, 45, 80, 75, "Bug", "Poison");
		Pokemon Pidgey = new Pokemon("Pidgey", 50, 40, 45, 40, 35, 35, 56, "Normal", "Flying");
		Pokemon Pidgeotto = new Pokemon("Pidgeotto", 50, 63, 60, 55, 50, 50, 71, "Normal", "Flying");
		Pokemon Pidgeot = new Pokemon("Pidgeot", 50, 83, 80, 75, 70, 70, 101, "Normal", "Flying");
		Pokemon Rattata = new Pokemon("Rattata", 50, 30, 56, 35, 25, 35, 72, "Normal");
		Pokemon Raticate = new Pokemon("Raticate", 50, 55, 81, 60, 50, 70, 97, "Normal");
		Pokemon Spearow = new Pokemon("Spearow", 50, 40, 60, 30, 31, 31, 70, "Normal", "Flying");
		Pokemon Fearow = new Pokemon("Fearow", 50, 65, 90, 65, 61, 61, 100, "Normal", "Flying");
		Pokemon Ekans = new Pokemon("Ekans", 50, 35, 60, 44, 40, 54, 55, "Poison");
		Pokemon Arbok = new Pokemon("Arbok", 50, 60, 85, 69, 65, 79, 80, "Poison");
		Pokemon Pikachu = new Pokemon("Pikachu", 50, 35, 55, 40, 50, 50, 90, "Electric");
		Pokemon Raichu = new Pokemon("Raichu", 50, 60, 90, 55, 90, 80, 110, "Electric");
		Pokemon Sandshrew = new Pokemon("Sandshrew", 50, 50, 75, 85, 20, 30, 40, "Ground");
		Pokemon Sandslash = new Pokemon("Sandslash", 50, 75, 100, 110, 45, 55, 65, "Ground");
		Pokemon NidoranF = new Pokemon("NidoranF", 50, 55, 47, 52, 40, 40, 41, "Poison");
		Pokemon Nidorina = new Pokemon("Nidorina", 50, 70, 62, 67, 55, 55, 56, "Poison");
		Pokemon Nidoqueen = new Pokemon("Nidoqueen", 50, 90, 92, 87, 75, 85, 76, "Poison", "Ground");
		Pokemon NidoranM = new Pokemon("NidoranM", 50, 46, 57, 40, 40, 40, 50, "Poison");
		Pokemon Nidorino = new Pokemon("Nidorino", 50, 61, 72, 57, 55, 55, 65, "Poison");
		Pokemon Nidoking = new Pokemon("Nidoking", 50, 81, 102, 77, 85, 75, 85, "Poison", "Ground");
		Pokemon Clefairy = new Pokemon("Clefairy", 50, 70, 45, 48, 60, 65, 35, "Normal");
		Pokemon Clefable = new Pokemon("Clefable", 50, 95, 70, 73, 95, 90, 60, "Normal");
		Pokemon Vulpix = new Pokemon("Vulpix", 50, 38, 41, 40, 50, 65, 65, "Fire");
		Pokemon Ninetales = new Pokemon("Ninetales", 50, 73, 76, 75, 81, 100, 100, "Fire");
		Pokemon Jigglypuff = new Pokemon("Jigglypuff", 50, 115, 45, 20, 45, 25, 20, "Normal");
		Pokemon Wigglytuff = new Pokemon("Wigglytuff", 50, 140, 70, 45, 85, 50, 45, "Normal");
		Pokemon Zubat = new Pokemon("Zubat", 50, 40, 45, 35, 30, 40, 55, "Poison", "Flying");
		Pokemon Golbat = new Pokemon("Golbat", 50, 75, 80, 70, 65, 75, 90, "Poison", "Flying");
		Pokemon Oddish = new Pokemon("Oddish", 50, 45, 50, 55, 75, 65, 30, "Grass", "Poison");
		Pokemon Gloom = new Pokemon("Gloom", 50, 60, 65, 70, 85, 75, 40, "Grass", "Poison");
		Pokemon Vileplume = new Pokemon("Vileplume", 50, 75, 80, 85, 110, 90, 50, "Grass", "Poison");
		Pokemon Paras = new Pokemon("Paras", 50, 35, 70, 55, 45, 55, 25, "Bug", "Grass");
		Pokemon Parasect = new Pokemon("Parasect", 50, 60, 95, 80, 60, 80, 30, "Bug", "Grass");
		Pokemon Venonat = new Pokemon("Venonat", 50, 60, 55, 50, 40, 55, 45, "Bug", "Poison");
		Pokemon Venomoth = new Pokemon("Venomoth", 50, 70, 65, 60, 90, 75, 90, "Bug", "Poison");
		Pokemon Diglett = new Pokemon("Diglett", 50, 10, 55, 25, 35, 45, 95, "Ground");
		Pokemon Dugtrio = new Pokemon("Dugtrio", 50, 35, 80, 50, 50, 70, 120, "Ground");
		Pokemon Meowth = new Pokemon("Meowth", 50, 40, 45, 35, 40, 40, 90, "Normal");
		Pokemon Persian = new Pokemon("Persian", 50, 65, 70, 60, 65, 65, 115, "Normal");
		Pokemon Psyduck = new Pokemon("Psyduck", 50, 50, 52, 48, 65, 50, 55, "Water");
		Pokemon Golduck = new Pokemon("Golduck", 50, 80, 82, 78, 95, 80, 85, "Water");
		Pokemon Mankey = new Pokemon("Mankey", 50, 40, 80, 35, 35, 45, 70, "Fighting");
		Pokemon Primeape = new Pokemon("Primeape", 50, 65, 105, 60, 60, 70, 95, "Fighting");
		Pokemon Growlithe = new Pokemon("Growlithe", 50, 55, 70, 45, 70, 50, 60, "Fire");
		Pokemon Arcanine = new Pokemon("Arcanine", 50, 90, 110, 80, 100, 80, 95, "Fire");
		Pokemon Poliwag = new Pokemon("Poliwag", 50, 40, 50, 40, 40, 40, 90, "Water");
		Pokemon Poliwhirl = new Pokemon("Poliwhirl", 50, 65, 65, 65, 50, 50, 90, "Water");
		Pokemon Poliwrath = new Pokemon("Poliwrath", 50, 90, 95, 95, 70, 90, 70, "Water", "Fighting");
		Pokemon Abra = new Pokemon("Abra", 50, 25, 20, 15, 105, 55, 90, "Psychic");
		Pokemon Kadabra = new Pokemon("Kadabra", 50, 40, 35, 30, 120, 70, 105, "Psychic");
		Pokemon Alakazam = new Pokemon("Alakazam", 50, 55, 50, 45, 135, 95, 120, "Psychic");
		Pokemon Machop = new Pokemon("Machop", 50, 70, 80, 50, 35, 35, 35, "Fighting");
		Pokemon Machoke = new Pokemon("Machoke", 50, 80, 100, 70, 50, 60, 45, "Fighting");
		Pokemon Machamp = new Pokemon("Machamp", 50, 90, 130, 80, 65, 85, 55, "Fighting");
		Pokemon Bellsprout = new Pokemon("Bellsprout", 50, 50, 75, 35, 70, 30, 40, "Grass", "Poison");
		Pokemon Weepinbell = new Pokemon("Weepinbell", 50, 65, 90, 50, 85, 45, 55, "Grass", "Poison");
		Pokemon Victreebel = new Pokemon("Victreebel", 50, 80, 105, 65, 100, 70, 70, "Grass", "Poison");
		Pokemon Tentacool = new Pokemon("Tentacool", 50, 40, 40, 35, 50, 100, 70, "Water", "Poison");
		Pokemon Tentacruel = new Pokemon("Tentacruel", 50, 80, 70, 65, 80, 120, 100, "Water", "Poison");
		Pokemon Geodude = new Pokemon("Geodude", 50, 40, 80, 100, 30, 30, 20, "Rock", "Ground");
		Pokemon Graveler = new Pokemon("Graveler", 50, 55, 95, 115, 45, 45, 35, "Rock", "Ground");
		Pokemon Golem = new Pokemon("Golem", 50, 80, 120, 130, 55, 65, 45, "Rock", "Ground");
		Pokemon Ponyta = new Pokemon("Ponyta", 50, 50, 85, 55, 65, 65, 90, "Fire");
		Pokemon Rapidash = new Pokemon("Rapidash", 50, 65, 100, 70, 80, 80, 105, "Fire");
		Pokemon Slowpoke = new Pokemon("Slowpoke", 50, 90, 65, 65, 40, 40, 15, "Water", "Psychic");
		Pokemon Slowbro = new Pokemon("Slowbro", 50, 95, 75, 110, 100, 80, 30, "Water", "Psychic");
		Pokemon Magnemite = new Pokemon("Magnemite", 50, 25, 35, 70, 95, 55, 45, "Electric", "Steel");
		Pokemon Magneton = new Pokemon("Magneton", 50, 50, 60, 95, 120, 70, 70, "Electric", "Steel");
		Pokemon Farfetchd = new Pokemon("Farfetch'd", 50, 52, 65, 55, 58, 62, 60, "Normal", "Flying");
		Pokemon Doduo = new Pokemon("Doduo", 50, 35, 85, 45, 35, 35, 75, "Normal", "Flying");
		Pokemon Dodrio = new Pokemon("Dodrio", 50, 60, 110, 70, 60, 60, 100, "Normal", "Flying");
		Pokemon Seel = new Pokemon("Seel", 50, 65, 45, 55, 45, 70, 45, "Water");
		Pokemon Dewgong = new Pokemon("Dewgong", 50, 90, 70, 80, 70, 95, 70, "Water", "Ice");
		Pokemon Grimer = new Pokemon("Grimer", 50, 80, 80, 50, 40, 50, 25, "Poison");
		Pokemon Muk = new Pokemon("Muk", 50, 105, 105, 75, 65, 100, 50, "Poison");
		Pokemon Shellder = new Pokemon("Shellder", 50, 30, 65, 100, 45, 25, 40, "Water");
		Pokemon Cloyster = new Pokemon("Cloyster", 50, 50, 95, 180, 85, 45, 70, "Water", "Ice");
		Pokemon Gastly = new Pokemon("Gastly", 50, 30, 35, 30, 100, 35, 80, "Ghost", "Poison");
		Pokemon Haunter = new Pokemon("Haunter", 50, 45, 50, 45, 115, 55, 95, "Ghost", "Poison");
		Pokemon Gengar = new Pokemon("Gengar", 50, 60, 65, 60, 130, 75, 110, "Ghost", "Poison");
		Pokemon Onix = new Pokemon("Onix", 50, 35, 45, 160, 30, 45, 70, "Rock", "Ground");
		Pokemon Drowzee = new Pokemon("Drowzee", 50, 60, 48, 45, 43, 90, 42, "Psychic");
		Pokemon Hypno = new Pokemon("Hypno", 50, 85, 73, 70, 73, 115, 67, "Psychic");
		Pokemon Krabby = new Pokemon("Krabby", 50, 30, 105, 90, 25, 25, 50, "Water");
		Pokemon Kingler = new Pokemon("Kingler", 50, 55, 130, 115, 50, 50, 75, "Water");
		Pokemon Voltorb = new Pokemon("Voltorb", 50, 40, 30, 50, 55, 55, 100, "Electric");
		Pokemon Electrode = new Pokemon("Electrode", 50, 60, 50, 70, 80, 80, 140, "Electric");
		Pokemon Exeggcute = new Pokemon("Exeggcute", 50, 60, 40, 80, 60, 45, 40, "Grass", "Psychic");
		Pokemon Exeggutor = new Pokemon("Exeggutor", 50, 95, 95, 85, 125, 65, 55, "Grass", "Psychic");
		Pokemon Cubone = new Pokemon("Cubone", 50, 50, 50, 95, 40, 50, 35, "Ground");
		Pokemon Marowak = new Pokemon("Marowak", 50, 60, 80, 110, 50, 80, 45, "Ground");
		Pokemon Hitmonlee = new Pokemon("Hitmonlee", 50, 50, 120, 53, 35, 110, 87, "Fighting");
		Pokemon Hitmonchan = new Pokemon("Hitmonchan", 50, 50, 105, 79, 35, 110, 76, "Fighting");
		Pokemon Lickitung = new Pokemon("Lickitung", 50, 90, 55, 75, 60, 75, 30, "Normal");
		Pokemon Koffing = new Pokemon("Koffing", 50, 40, 65, 95, 60, 45, 35, "Poison");
		Pokemon Weezing = new Pokemon("Weezing", 50, 65, 90, 120, 85, 70, 60, "Poison");
		Pokemon Rhyhorn = new Pokemon("Rhyhorn", 50, 80, 85, 95, 30, 30, 25, "Rock", "Ground");
		Pokemon Rhydon = new Pokemon("Rhydon", 50, 105, 130, 120, 45, 45, 40, "Rock", "Ground");
		Pokemon Chansey = new Pokemon("Chansey", 50, 250, 5, 5, 35, 105, 50, "Normal");
		Pokemon Tangela = new Pokemon("Tangela", 50, 65, 55, 115, 100, 40, 60, "Grass");
		Pokemon Kangaskhan = new Pokemon("Kangaskhan", 50, 105, 95, 80, 40, 80, 90, "Normal");
		Pokemon Horsea = new Pokemon("Horsea", 50, 30, 40, 70, 70, 25, 60, "Water");
		Pokemon Seadra = new Pokemon("Seadra", 50, 55, 65, 95, 95, 45, 85, "Water");
		Pokemon Goldeen = new Pokemon("Goldeen", 50, 45, 67, 60, 35, 50, 63, "Water");
		Pokemon Seaking = new Pokemon("Seaking", 50, 80, 92, 65, 65, 80, 68, "Water");
		Pokemon Staryu = new Pokemon("Staryu", 50, 30, 45, 55, 70, 55, 85, "Water");
		Pokemon Starmie = new Pokemon("Starmie", 50, 60, 75, 85, 100, 85, 115, "Water", "Psychic");
		Pokemon MrMime = new Pokemon("Mr Mime", 50, 40, 45, 65, 100, 120, 90, "Psychic");
		Pokemon Scyther = new Pokemon("Scyther", 50, 70, 110, 80, 55, 80, 105, "Bug", "Flying");
		Pokemon Jynx = new Pokemon("Jynx", 50, 65, 50, 35, 115, 95, 95, "Ice", "Psychic");
		Pokemon Electabuzz = new Pokemon("Electabuzz", 50, 65, 83, 57, 95, 85, 105, "Electric");
		Pokemon Magmar = new Pokemon("Magmar", 50, 65, 95, 57, 100, 85, 93, "Fire");
		Pokemon Pinsir = new Pokemon("Pinsir", 50, 65, 125, 100, 55, 70, 85, "Bug");
		Pokemon Tauros = new Pokemon("Tauros", 50, 75, 100, 95, 40, 70, 110, "Normal");
		Pokemon Magikarp = new Pokemon("Magikarp", 50, 20, 10, 55, 15, 20, 80, "Water");
		Pokemon Gyarados = new Pokemon("Gyarados", 50, 95, 125, 79, 60, 100, 81, "Water", "Flying");
		Pokemon Lapras = new Pokemon("Lapras", 50, 130, 85, 80, 85, 95, 60, "Water", "Ice");
		Pokemon Ditto = new Pokemon("Ditto", 50, 48, 48, 48, 48, 48, 48, "Normal");
		Pokemon Eevee = new Pokemon("Eevee", 50, 55, 55, 50, 45, 65, 55, "Normal");
		Pokemon Vaporeon = new Pokemon("Vaporeon", 50, 130, 65, 60, 110, 95, 65, "Water");
		Pokemon Jolteon = new Pokemon("Jolteon", 50, 65, 65, 60, 110, 95, 130, "Electric");
		Pokemon Flareon = new Pokemon("Flareon", 50, 65, 130, 60, 95, 110, 65, "Fire");
		Pokemon Porygon = new Pokemon("Porygon", 50, 65, 60, 70, 85, 75, 40, "Normal");
		Pokemon Omanyte = new Pokemon("Omanyte", 50, 35, 40, 100, 90, 55, 35, "Rock", "Water");
		Pokemon Omastar = new Pokemon("Omastar", 50, 70, 60, 125, 115, 70, 55, "Rock", "Water");
		Pokemon Kabuto = new Pokemon("Kabuto", 50, 30, 80, 90, 55, 45, 55, "Rock", "Water");
		Pokemon Kabutops = new Pokemon("Kabutops", 50, 60, 115, 105, 65, 70, 80, "Rock", "Water");
		Pokemon Aerodactyl = new Pokemon("Aerodactyl", 50, 80, 105, 65, 60, 75, 130, "Rock", "Flying");
		Pokemon Snorlax = new Pokemon("Snorlax", 50, 160, 110, 65, 65, 110, 30, "Normal");
		Pokemon Articuno = new Pokemon("Articuno", 50, 90, 85, 100, 95, 125, 85, "Ice", "Flying");
		Pokemon Zapdos = new Pokemon("Zapdos", 50, 90, 90, 85, 125, 90, 100, "Electric", "Flying");
		Pokemon Moltres = new Pokemon("Moltres", 50, 90, 100, 90, 125, 85, 90, "Fire", "Flying");
		Pokemon Dratini = new Pokemon("Dratini", 50, 41, 64, 45, 50, 50, 50, "Dragon");
		Pokemon Dragonair = new Pokemon("Dragonair", 50, 61, 84, 65, 70, 70, 70, "Dragon");
		Pokemon Dragonite = new Pokemon("Dragonite", 50, 91, 134, 95, 100, 100, 80, "Dragon", "Flying");
		Pokemon Mewtwo = new Pokemon("Mewtwo", 50, 106, 110, 90, 154, 90, 130, "Psychic");
		Pokemon Mew = new Pokemon("Mew", 50, 100, 100, 100, 100, 100, 100, "Psychic");
		
		PokemonList.add(MissingNo);
		PokemonList.add(Bulbasaur);
		PokemonList.add(Ivysaur);
		PokemonList.add(Venusaur);
		PokemonList.add(Charmander);
		PokemonList.add(Charmeleon);
		PokemonList.add(Charizard);
		PokemonList.add(Squirtle);
		PokemonList.add(Wartortle);
		PokemonList.add(Blastoise);
		PokemonList.add(Caterpie);
		PokemonList.add(Metapod);
		PokemonList.add(Butterfree);
		PokemonList.add(Weedle);
		PokemonList.add(Kakuna);
		PokemonList.add(Beedrill);
		PokemonList.add(Pidgey);
		PokemonList.add(Pidgeotto);
		PokemonList.add(Pidgeot);
		PokemonList.add(Rattata);
		PokemonList.add(Raticate);
		PokemonList.add(Spearow);
		PokemonList.add(Fearow);
		PokemonList.add(Ekans);
		PokemonList.add(Arbok);
		PokemonList.add(Pikachu);
		PokemonList.add(Raichu);
		PokemonList.add(Sandshrew);
		PokemonList.add(Sandslash);
		PokemonList.add(NidoranF);
		PokemonList.add(Nidorina);
		PokemonList.add(Nidoqueen);
		PokemonList.add(NidoranM);
		PokemonList.add(Nidorino);
		PokemonList.add(Nidoking);
		PokemonList.add(Clefairy);
		PokemonList.add(Clefable);
		PokemonList.add(Vulpix);
		PokemonList.add(Ninetales);
		PokemonList.add(Jigglypuff);
		PokemonList.add(Wigglytuff);
		PokemonList.add(Zubat);
		PokemonList.add(Golbat);
		PokemonList.add(Oddish);
		PokemonList.add(Gloom);
		PokemonList.add(Vileplume);
		PokemonList.add(Paras);
		PokemonList.add(Parasect);
		PokemonList.add(Venonat);
		PokemonList.add(Venomoth);
		PokemonList.add(Diglett);
		PokemonList.add(Dugtrio);
		PokemonList.add(Meowth);
		PokemonList.add(Persian);
		PokemonList.add(Psyduck);
		PokemonList.add(Golduck);
		PokemonList.add(Mankey);
		PokemonList.add(Primeape);
		PokemonList.add(Growlithe);
		PokemonList.add(Arcanine);
		PokemonList.add(Poliwag);
		PokemonList.add(Poliwhirl);
		PokemonList.add(Poliwrath);
		PokemonList.add(Abra);
		PokemonList.add(Kadabra);
		PokemonList.add(Alakazam);
		PokemonList.add(Machop);
		PokemonList.add(Machoke);
		PokemonList.add(Machamp);
		PokemonList.add(Bellsprout);
		PokemonList.add(Weepinbell);
		PokemonList.add(Victreebel);
		PokemonList.add(Tentacool);
		PokemonList.add(Tentacruel);
		PokemonList.add(Geodude);
		PokemonList.add(Graveler);
		PokemonList.add(Golem);
		PokemonList.add(Ponyta);
		PokemonList.add(Rapidash);
		PokemonList.add(Slowpoke);
		PokemonList.add(Slowbro);
		PokemonList.add(Magnemite);
		PokemonList.add(Magneton);
		PokemonList.add(Farfetchd);
		PokemonList.add(Doduo);
		PokemonList.add(Dodrio);
		PokemonList.add(Seel);
		PokemonList.add(Dewgong);
		PokemonList.add(Grimer);
		PokemonList.add(Muk);
		PokemonList.add(Shellder);
		PokemonList.add(Cloyster);
		PokemonList.add(Gastly);
		PokemonList.add(Haunter);
		PokemonList.add(Gengar);
		PokemonList.add(Onix);
		PokemonList.add(Drowzee);
		PokemonList.add(Hypno);
		PokemonList.add(Krabby);
		PokemonList.add(Kingler);
		PokemonList.add(Voltorb);
		PokemonList.add(Electrode);
		PokemonList.add(Exeggcute);
		PokemonList.add(Exeggutor);
		PokemonList.add(Cubone);
		PokemonList.add(Marowak);
		PokemonList.add(Hitmonlee);
		PokemonList.add(Hitmonchan);
		PokemonList.add(Lickitung);
		PokemonList.add(Koffing);
		PokemonList.add(Weezing);
		PokemonList.add(Rhyhorn);
		PokemonList.add(Rhydon);
		PokemonList.add(Chansey);
		PokemonList.add(Tangela);
		PokemonList.add(Kangaskhan);
		PokemonList.add(Horsea);
		PokemonList.add(Seadra);
		PokemonList.add(Goldeen);
		PokemonList.add(Seaking);
		PokemonList.add(Staryu);
		PokemonList.add(Starmie);
		PokemonList.add(MrMime);
		PokemonList.add(Scyther);
		PokemonList.add(Jynx);
		PokemonList.add(Electabuzz);
		PokemonList.add(Magmar);
		PokemonList.add(Pinsir);
		PokemonList.add(Tauros);
		PokemonList.add(Magikarp);
		PokemonList.add(Gyarados);
		PokemonList.add(Lapras);
		PokemonList.add(Ditto);
		PokemonList.add(Eevee);
		PokemonList.add(Vaporeon);
		PokemonList.add(Jolteon);
		PokemonList.add(Flareon);
		PokemonList.add(Porygon);
		PokemonList.add(Omanyte);
		PokemonList.add(Omastar);
		PokemonList.add(Kabuto);
		PokemonList.add(Kabutops);
		PokemonList.add(Aerodactyl);
		PokemonList.add(Snorlax);
		PokemonList.add(Articuno);
		PokemonList.add(Zapdos);
		PokemonList.add(Moltres);
		PokemonList.add(Dratini);
		PokemonList.add(Dragonair);
		PokemonList.add(Dragonite);
		PokemonList.add(Mewtwo);
		PokemonList.add(Mew);
	
		PokemonList.get(1).addMoves(MoveList.get(0), MoveList.get(10), MoveList.get(32), MoveList.get(72));
		PokemonList.get(2).addMoves(MoveList.get(79), MoveList.get(1), MoveList.get(53), MoveList.get(100));
		
		PokemonList.get(4).addMoves(MoveList.get(39), MoveList.get(39), MoveList.get(39), MoveList.get(39));
		PokemonList.get(7).addMoves(MoveList.get(94), MoveList.get(10), MoveList.get(52), MoveList.get(16));
		
		//------------------------------------------------
		ArrayList<Pokemon> joeyParty = new ArrayList();
		joeyParty.add(PokemonList.get(13));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
//		joeyParty.add(PokemonList.get(((int)(Math.random() * 151))+1));
		Joey = new Opponent("Youngster Joey", joeyParty);
	}
	
	public void startBattle() {
		//Setup Player Info & Party
		Player.setPlayerName("Jimmy");
		
		//Setup Opponent Info & Party
		Joey.setOpponentName("Youngster Joey");
		
	}
	
	public void addToPlayerParty(Pokemon pokemon) {
		Player.addPokemonToParty(pokemon);
	}
	
	public Pokemon getFromPlayerParty(int num) {
		return Player.getPokemonFromParty(num);
	}
	
	public boolean partyInitiated() {
		return Player.partyExists();
	}
	
	public int calculateDamage(int level, int attackStat, int opponentDefenseStat, int movePower, String moveType, String playerType, String opponentType, String opponentType2, String status) {
		double burn = 1;
		int critical = 1;
		Random rand = new Random(1);
		Random rand2 = new Random(16);
		double random = rand.nextDouble() + 0.85;
		double stab = 1;
		int crit = rand2.nextInt();
		
		if(moveType.equalsIgnoreCase("Normal")) {
			NormalTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Fire")) {
			FireTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Water")) {
			WaterTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Grass")) {
			GrassTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Electric")) {
			ElectricTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Ice")) {
			IceTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Fighting")) {
			FightingTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Poison")) {
			PoisonTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Ground")) {
			GroundTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Flying")) {
			FlyingTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Psychic")) {
			PsychicTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Bug")) {
			BugTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Rock")) {
			RockTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Ghost")) {
			GhostTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Dragon")) {
			DragonTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Dark")) {
			DarkTypeMatchup(opponentType, opponentType2);
		}
		if(moveType.equalsIgnoreCase("Steel")) {
			SteelTypeMatchup(opponentType, opponentType2);
		}
		
		if(playerType.equals(moveType)) {
			stab = 1.5;
		}
		
		if(crit == 1) {
			critical = 2;
		}
		
		if(status.equalsIgnoreCase("Burn")) {
			burn = 0.5;
		}
		
		double modifier = critical * random * stab * typeEffectiveness * burn;
		
		double damage = (((((2 * level)/5)+2)*movePower*(attackStat/opponentDefenseStat)/50)+2)*modifier;
		
		return (int) damage;
	}
	
	public void subtractEffectiveness() {
		if(typeEffectiveness == 0.5) {
			typeEffectiveness -= 0.25;
		}else {
			typeEffectiveness -= 0.5;
		}
	}
	
	public void addEffectiveness() {
		if(typeEffectiveness == 2) {
			typeEffectiveness += 2;
		}else {
			typeEffectiveness += 1;
		}
	}
	
	public void doesntEffect() {
		typeEffectiveness = 0;
	}
	
	public void NormalTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			doesntEffect();
		}
	}
	
	public void FireTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ice")||opponentType2.equals("Ice")) {
			addEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			addEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			addEffectiveness();
		}
	}
	
	public void WaterTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			addEffectiveness();
		}
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			addEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			subtractEffectiveness();
		}
	}
	
	public void GrassTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			addEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			addEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void ElectricTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			addEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Electric")||opponentType2.equals("Electric")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			doesntEffect();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			subtractEffectiveness();
		}
	}
	
	public void IceTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ice")||opponentType2.equals("Ice")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			addEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void FightingTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Normal")||opponentType2.equals("Normal")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ice")||opponentType2.equals("Ice")) {
			addEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Psychic")||opponentType2.equals("Psychic")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			doesntEffect();
		}
		if(opponentType.equals("Dark")||opponentType2.equals("Dark")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			addEffectiveness();
		}
	}
	
	public void PoisonTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			doesntEffect();
		}
	}
	
	public void GroundTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			addEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Electric")||opponentType2.equals("Electric")) {
			addEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			addEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			doesntEffect();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			addEffectiveness();
		}
	}
	
	public void FlyingTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Electric")||opponentType2.equals("Electric")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Fighting")||opponentType2.equals("Fighting")) {
			addEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			addEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void PsychicTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fighting")||opponentType2.equals("Fighting")) {
			addEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			addEffectiveness();
		}
		if(opponentType.equals("Psychic")||opponentType2.equals("Psychic")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Dark")||opponentType2.equals("Dark")) {
			doesntEffect();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void BugTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Grass")||opponentType2.equals("Grass")) {
			addEffectiveness();
		}
		if(opponentType.equals("Fighting")||opponentType2.equals("Fighting")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Poison")||opponentType2.equals("Poison")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Psychic")||opponentType2.equals("Psychic")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Dark")||opponentType2.equals("Dark")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void RockTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ice")||opponentType2.equals("Ice")) {
			addEffectiveness();
		}
		if(opponentType.equals("Fighting")||opponentType2.equals("Fighting")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ground")||opponentType2.equals("Ground")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Flying")||opponentType2.equals("Flying")) {
			addEffectiveness();
		}
		if(opponentType.equals("Bug")||opponentType2.equals("Bug")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void GhostTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Normal")||opponentType2.equals("Normal")) {
			doesntEffect();
		}
		if(opponentType.equals("Psychic")||opponentType2.equals("Psychic")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dark")||opponentType2.equals("Dark")) {
			subtractEffectiveness();
		}
	}
	
	public void DragonTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Dragon")||opponentType2.equals("Dragon")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public void DarkTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fighting")||opponentType2.equals("Fighting")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Psychic")||opponentType2.equals("Psychic")) {
			addEffectiveness();
		}
		if(opponentType.equals("Ghost")||opponentType2.equals("Ghost")) {
			addEffectiveness();
		}
		if(opponentType.equals("Dark")||opponentType2.equals("Dark")) {
			subtractEffectiveness();
		}
	}
	
	public void SteelTypeMatchup(String opponentType, String opponentType2) {
		if(opponentType.equals("Fire")||opponentType2.equals("Fire")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Water")||opponentType2.equals("Water")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Electric")||opponentType2.equals("Electric")) {
			subtractEffectiveness();
		}
		if(opponentType.equals("Ice")||opponentType2.equals("Ice")) {
			addEffectiveness();
		}
		if(opponentType.equals("Rock")||opponentType2.equals("Rock")) {
			addEffectiveness();
		}
		if(opponentType.equals("Steel")||opponentType2.equals("Steel")) {
			subtractEffectiveness();
		}
	}
	
	public double getTypeEffectiveness() {
		return typeEffectiveness;
	}
	
	public String printMessage(String message) {
		
		int k = j;
		
		String str = message.substring(0,i);
		
		if(i==message.length()) {
			j++;
		}else {
			i++;
			sleep(textSpeed);
		}
		
		if(k!=j) {
			i = 0;
		}
		
		return str;
	}
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//Handles Turns(Check speed stat)
	//Handles Type Matchups
	//Checks if player || enemy HP is 0
}
