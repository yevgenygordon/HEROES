import kotlin.random.Random
import kotlin.random.nextInt

var bildNumber:Anime = Anime(1)
fun main (){

    start()

}

fun start (){

    var bildNumber:Anime = Anime(1)

    var knight: Ritter = Ritter("Ritter Ivengo",100.0,70.0,8,0.5)
    var elfArcher: Ritter = Ritter("Elf Agronom",150.0,40.0,3,0.8)
    var princess: Ritter = Ritter("Prinzesin Amira",90.0,45.0,7,1.0)
    var wizard: Ritter = Ritter("Zauberer Merlin",110.0,32.0,7,0.7)
    var superWoman: Ritter = Ritter("Superwoman Diana",300.0,100.0,10,0.3)

    var badKnight: Witch = Witch("Dark Lord",250.0,50.0,9, 0.7)
    var gin: Witch = Witch("Gini",200.0,120.0,8, 0.6)
    var warlock: Witch = Witch("Elf Tormentor",150.0,45.0,6, 0.7)
    var badWitch: Witch = Witch("Mermaid Witch",150.0,40.0,5, 0.9)
    var necromanker: Witch = Witch("Dungeon Necromanker",200.0,60.0,10, 0.7)

    var diablo: Helper = Helper("Diablo")
    var drache: Helper = Helper("Knochen Drache")
    var elemental: Helper = Helper("Elemental")
    var mermaid: Helper = Helper("Mermaid")

// Listen mit Helden

    var heldenListe: MutableList<Ritter> = mutableListOf(knight, elfArcher, princess, wizard, superWoman)
    var choiceListe: MutableList<Ritter> = mutableListOf()

    var badMagsListe: MutableList<Witch> = mutableListOf(badKnight,gin, warlock, badWitch, necromanker)
    var badChoiceListe: MutableList<Witch> = mutableListOf()

    // Random für Liste der Bösen Zauberer

    for (i in 0..badMagsListe.size-1 ) {

        while (badChoiceListe.size != 3) {

            var choise: Witch = badMagsListe.random()

            badChoiceListe.add(choise)
            badMagsListe.removeAt(badMagsListe.indexOf(choise))

        }
    }


    // Gibt Anime Bild 1 aus
    bildNumber.printBild(1)





    // Spielerauswahl für Liste der Helden

    for (i in 0..2) { println(" Bitte wähle dein ${i + 1} Held: ")

        for (n in heldenListe.indices) {
            print("${n} ${heldenListe[n].name}    ")
        }
        var choice: Int = readln().toInt()
        choiceListe.add(heldenListe[choice])
        heldenListe.removeAt(choice)
    }



    // Ausgabe beiden Listen
    bildNumber.printBild(1)

println()
    for (n in choiceListe.indices) {
        print(" ${choiceListe[n].name}    ")
    }
    println()
println("\n Gegen dich tretten an:")


    for (n in badChoiceListe.indices) {
        print(" ${badChoiceListe[n].name}      ")
    }
    println()

// Gibt Anime Bild 0 aus
    bildNumber.printBild(0)


 //   fight(knight,badKnight)
    fightTeam (choiceListe, badChoiceListe)
}



// 1 vs 1 Kampf

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

// Kampf Team Funktion

fun fightTeam (gteam1:MutableList<Ritter>, gteam2:MutableList<Witch>){


    while ((gteam1[0].healthPoints > 0 || gteam1[1].healthPoints > 0 || gteam1[2].healthPoints > 0) &&
        (gteam2[0].healthPoints > 0 || gteam2[1].healthPoints > 0 || gteam2[2].healthPoints > 0)) {


        // Kampf Helden Team


        for (n in gteam1.indices) {

            println()


            println("Bitte wähle Angrifziel für dein ${n + 1} Held:")
            for (gl in gteam2.indices) {

                print("${gl + 1} ${gteam2[gl].name}: ${gteam2[gl].healthPoints}    ")
            }
            val attackFirst = readln().toInt()
            println("Bitte wähle Aktion für dein ${n + 1} Held :")
            println("")
            val action = readln().toInt()

            gteam1[n].attack(gteam2[attackFirst - 1])
            println("Restleben ${gteam2[attackFirst - 1].healthPoints}")

            bildNumber.printBild(4)


        }


        // Kampf Böse Team

        for (n in gteam2.indices) {

            val attackFirst:Int = Random.nextInt(0..2)
            val attackChoice:Int = Random.nextInt(1..3)
            when (attackChoice){

                1 -> {gteam2[n].attack(gteam1[attackFirst])
                    println("Restleben ${gteam1[attackFirst].healthPoints}")}
                2 -> {gteam2[n].curseMagic(gteam1[attackFirst])
                    println("Restleben ${gteam1[attackFirst].healthPoints}")}



                3 -> {gteam2[n].sideStep(gteam2[attackFirst])
                    println("Restleben ${gteam1[attackFirst].healthPoints}")}
            }



        }

        bildNumber.printBild(0)


    }

}
