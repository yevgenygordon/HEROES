import java.awt.Choice
import kotlin.random.Random


fun main (){

    start()

}

fun start (){

    var knight: Ritter = Ritter("Ritter Ivengo",100.0,70.0,8,34.0)
    var elfArcher: Ritter = Ritter("Elf Agronom",150.0,40.0,3,26.0)
    var princess: Ritter = Ritter("Prinzesin Amira",90.0,45.0,7,26.0)
    var wizard: Ritter = Ritter("Zauberer Merlin",110.0,32.0,7,26.0)
    var superWoman: Ritter = Ritter("Superwoman Diana",500.0,100.0,10,80.0)

    var badKnight: Witch = Witch("Dark Lord",250.0,50.0,9, 10.0)
    var gin: Witch = Witch("Gini",200.0,120.0,8, 10.0)
    var warlock: Witch = Witch("Elf Tormentor",150.0,45.0,6, 10.0)
    var badWitch: Witch = Witch("Mermaid Witch ",150.0,40.0,5, 10.0)
    var necromanker: Witch = Witch("Dungeon Necromanker",200.0,60.0,10, 10.0)



    var heldenListe: MutableList<Ritter> = mutableListOf(knight, elfArcher, princess, wizard, superWoman)
    var choiceListe: MutableList<Ritter> = mutableListOf()

    var badMagsListe: MutableList<Witch> = mutableListOf(badKnight,gin, warlock, badWitch, necromanker)
    var badChoiceListe: MutableList<Witch> = mutableListOf()

    for (i in 0..2) {
        var choise: Witch = badMagsListe.random()

        badChoiceListe.add(choise)

    }




    print("""
                    <|  |>
.,,.      .,,.      _|__|_        .,,.      .,,.    
        | '|,,,,,,| '|     | |  | |       | '|,,,,,,| '| 
        |' | '__  |' |     |  ||  |       |' | '__  |' | 
        |__._/##\_.__|     |__||__|       |__._/##\_.__|
        
       ----------------------------------------------------
       
      """.trimMargin())

    for (i in 0..2) { println(" Bitte wähle dein ${i + 1} Held: ")

        for (n in heldenListe.indices) {
            print("${n} ${heldenListe[n].name}    ")
        }
        var choice: Int = readln().toInt()
        choiceListe.add(heldenListe[choice])
        heldenListe.removeAt(choice)
    }

    print("""" 
       
   |          
   |          
   + \        
   \\.G_.*=.  
    `(H'/.\|  
     .>' (_--.
  _=/d   ,^\  
 ~~ \)-'   '  
    / |       
   '  '      
      
    """.trimMargin())

println()
    for (n in choiceListe.indices) {
        print(" ${choiceListe[n].name}    \n")
    }

println("\n Gegen dich tretten an:\n")

    println()
    for (n in badChoiceListe.indices) {
        print(" ${badChoiceListe[n].name}    \n")
    }



    print(""" 
       

    
      
    """.trimMargin())


 //   fight(knight,badKnight)
    fightTeam (choiceListe, badChoiceListe)
}




fun fight (gladiator1: Held, gladiator2: Feind) {

    while (!gladiator1.theFin && !gladiator2.theFin) {



        val attackFirst = Random.nextBoolean()

        if (attackFirst) {
            gladiator1.attack(gladiator2)
            println("Restleben ${gladiator2.healthPoints}")
            gladiator2.attack(gladiator1)
            println("Restleben ${gladiator1.healthPoints}")
            println("____________________________________________________")

        } else {
            gladiator2.attack(gladiator1)
            println("Restleben ${gladiator1.healthPoints}")
            gladiator1.attack(gladiator2)
            println("Restleben ${gladiator2.healthPoints}")
            println("____________________________________________________")
        }
    }



}


fun fightTeam (gteam1:MutableList<Ritter>, gteam2:MutableList<Witch>){


}
