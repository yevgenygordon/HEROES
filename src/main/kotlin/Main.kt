import kotlin.random.Random


fun main (){

    start()

}

fun start (){

    var knight: Ritter = Ritter("Ritter Ivengo",100.0,8,34.0)
    var elfArcher: Ritter = Ritter("Elf Agronom",150.0,3,26.0)
    var princess: Ritter = Ritter("Prinzesin Amira",90.0,7,26.0)
    var wizard: Ritter = Ritter("Zauberer Merlin",110.0,7,26.0)
    var superWoman: Ritter = Ritter("Superwoman Diana",500.0,10,80.0)

    var badKnight: Witch = Witch("Dark Lord",10, 10.0)
    var gin: Witch = Witch("Gini",10, 10.0)
    var warlock: Witch = Witch("Elf Tormentor",10, 10.0)
    var badWitch: Witch = Witch("Mermaid Witch ",10, 10.0)
    var necromanker: Witch = Witch("Dungeon Necromanker",10, 10.0)



    var heldenListe: MutableList<Ritter> = mutableListOf(knight, elfArcher, princess, wizard, superWoman)
    var choiceListe: MutableList<Ritter> = mutableListOf()

    var badMagsListe: MutableList<Witch> = mutableListOf(badKnight,gin, warlock, badWitch, necromanker)
    var badChoiceListe: MutableList<Witch> = mutableListOf()

    for (i in 0..2) {
        var choise: Witch = badMagsListe.random()

        badChoiceListe.add(choise)

    }

    println()
    for (n in badChoiceListe.indices) {
        print(" ${badChoiceListe[n].name}    \n")
    }


    print(""""
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

    print(""" 
       

    
      
    """.trimMargin())


    fight(knight,badKnight)

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











    print(
        """" 
     .        
      \       
       G      
      ( ) .,  
     _/Xx/ "\ 
  .+' /   /`" 
 (  |_`_( )   
    |:  | |   
    '   ` '   
      """.trimMargin())
    println("Finita la comedia!")

}



