import kotlin.random.Random
import kotlin.random.nextInt

var bildNumber: Anime = Anime(1)
var roundCounter: Int = 1
fun main() {

    start()

}

fun start() {

    var bildNumber: Anime = Anime(1)

    var knight: Ritter = Ritter("Ritter Ivengo", 100.0, 70.0, 8, 0.5)
    var elfArcher: Ritter = Ritter("Elf Agronom", 150.0, 40.0, 3, 0.8)
    var princess: Ritter = Ritter("Prinzesin Amira", 90.0, 45.0, 7, 1.0)
    var wizard: Ritter = Ritter("Zauberer Merlin", 110.0, 32.0, 7, 0.7)
    var superWoman: Ritter = Ritter("Superwoman Diana", 300.0, 100.0, 10, 0.3)

    var badKnight: Witch = Witch("Dark Lord", 250.0, 50.0, 9, 0.7)
    var gin: Witch = Witch("Gini", 200.0, 80.0, 8, 0.6)
    var warlock: Witch = Witch("Elf Tormentor", 150.0, 45.0, 6, 0.7)
    var badWitch: Witch = Witch("Mermaid Witch", 150.0, 40.0, 5, 0.9)
    var necromanker: Witch = Witch("Dungeon Necromanker", 200.0, 60.0, 10, 0.7)

    var diablo: Helper = Helper("Diablo")
    var drache: Helper = Helper("Knochen Drache")
    var elemental: Helper = Helper("Elemental")
    var mermaid: Helper = Helper("Mermaid")

// Listen mit Helden, Magier und Kreaturen

    var heldenListe: MutableList<Ritter> = mutableListOf(knight, elfArcher, princess, wizard, superWoman)
    var choiceListe: MutableList<Ritter> = mutableListOf()

    var badMagsListe: MutableList<Witch> = mutableListOf(badKnight, gin, warlock, badWitch, necromanker)
    var badChoiceListe: MutableList<Witch> = mutableListOf()

    var helperListe: MutableList<Helper> = mutableListOf(diablo, drache, elemental, mermaid)

    // Random für Liste der Bösen Zauberer

    for (i in 0..badMagsListe.size - 1) {

        while (badChoiceListe.size != 3) {

            var choise: Witch = badMagsListe.random()

            badChoiceListe.add(choise)
            badMagsListe.removeAt(badMagsListe.indexOf(choise))

        }
    }


    // Gibt Anime Bild 1 aus
    bildNumber.printBild(1)


    // Spielerauswahl für Liste der Helden

    for (i in 0..2) {
        println(" Bitte wähle dein ${i + 1} Held: ")

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

// Kampffunktion Aufruf



    //   fight(knight,badKnight)

  //  fightTeam(choiceListe, badChoiceListe, choiceListe, badChoiceListe, helperListe)

   mortalKombat(choiceListe, badChoiceListe, choiceListe, badChoiceListe, helperListe)



}


// 1 vs 1 Kampf

fun fight(gladiator1: Held, gladiator2: Feind) {

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

fun fightTeam(
    gteam1: MutableList<Ritter>,
    gteam2: MutableList<Witch>,
    gteam11: MutableList<Ritter>,
    gteam22: MutableList<Witch>,
    hteam: MutableList<Helper>
) {

    var trunk: Boolean = false
    var creature: Boolean = false
    var attackChoice: Int? = null



    while ((gteam11[0].healthPoints > 0 || gteam11[1].healthPoints > 0 || gteam11[2].healthPoints > 0) &&
        (gteam22[0].healthPoints > 0 || gteam22[1].healthPoints > 0 || gteam22[2].healthPoints > 0)
    ) {
        roundCounter++


        // Ausgabe beiden Listen
        bildNumber.printBild(1)

        println()
        for (n in gteam11.indices) { print(" ${gteam11[n].name} ${gteam11[n].healthPoints}  ") }

        for (n in gteam22.indices) {
            print(" ${gteam2[n].name} ${gteam2[n].healthPoints}     ")
        }

        // Kampf Helden Team


        for (n in gteam1.indices) {

            println()

            if (gteam2[0].theFin && gteam2[1].theFin && gteam2[2].theFin) {
                println("Helden haben gewonnen. Finita la Comedia")
                break
            }



            println("Bitte wähle Aktion für dein ${n + 1} Held :")
            println(
                "1. Atacke  | 2. Jemanden Heilen | ${if (!trunk) { "3. Zaubertrunk" } else { "" }} ")
            val action = readln().toInt()

            when (action) {

                1 -> {
                    println("Bitte wähle Angrifziel für dein ${n + 1} Held:")
                    for (gl in gteam2.indices) {
                        if (!gteam2[gl].theFin) {
                            print("${gl + 1} ${gteam2[gl].name}: ${gteam2[gl].healthPoints}    ")
                        }
                    }
                    val attackFirst = readln().toInt()
                    gteam1[n].attack(gteam2[attackFirst - 1])


                }

                2 -> {
                    println("Bitte wähle wenn du Heilen willst:")
                    for (s in gteam1.indices) {
                        print("${s + 1}. ${gteam1[s].name}:  ${gteam1[s].healthPoints}  ")
                    }
                    val cureFirst = readln().toInt()

                    gteam1[cureFirst - 1].cureHeld(gteam1[cureFirst - 1])

                }

                3 -> {
                    gteam1[n].magicTrunk(gteam1[n])
                    trunk = true
                }
            }


        }


        // Kampf Böse Team

        for (n in gteam2.indices) {

            // Test für jede Runde

            if (gteam11[0].theFin && gteam11[1].theFin && gteam11[2].theFin) {
                println("Witches haben gewonnen. Finita la Comedia")
                break
            }
            else if (gteam22[0].theFin && gteam2[1].theFin && gteam22[2].theFin){ println("Heroes haben gewonnen. Finita la Comedia")
                break}
            else {


                var deleteHeld = mutableListOf<Held>()

                var attackFirst: Int = Random.nextInt(0 until gteam1.size)

                if (!creature) {
                    println("kreature")
                    attackChoice = Random.nextInt(range = 0 until 4)

                    when (attackChoice) {
                        0 -> {
                            println("0 ATTAKE")
                        }
                        1 -> {
                            gteam2[n].attack(gteam1[attackFirst])
                        }
                        2 -> {
                            gteam2[n].curseMagic(gteam1[attackFirst])
                        }
                        3 -> {
                            gteam2[n].diversion(gteam1[attackFirst])
                        }
                    }

                    creature = true

                }
                else {
                    attackChoice = Random.nextInt(1,4)

                    when (attackChoice) {
                        0 -> {
                            println("0 ATTAKE")
                        }
                        1 -> {
                            gteam2[n].attack(gteam1[attackFirst])
                        }
                        2 -> {
                            gteam2[n].curseMagic(gteam1[attackFirst])
                        }
                        3 -> {
                            gteam2[n].diversion(gteam1[attackFirst])
                        }
                    }
                }





                // Gefallene Helden aus Liste löschen
                if (gteam1.size == 0) {
                    println("Withes haben gewonnen. Finita la Comedia")
                    break
                }
                else {

                    if (gteam1[attackFirst].healthPoints < 0) {
                        println("${gteam1[attackFirst].name} ist gefallen")
                        deleteHeld.add(gteam1[attackFirst])
                    }



                    gteam1.removeAll(deleteHeld)
                }

            }

            bildNumber.printBild(0)

            trunk = false
            roundCounter++
        }
    }
}


