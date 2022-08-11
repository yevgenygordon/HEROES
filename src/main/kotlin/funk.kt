import kotlin.random.Random
import kotlin.random.nextInt

fun mortalKombat (gteam1: MutableList<Ritter>,
                  gteam2: MutableList<Witch>,
                  gteam11: MutableList<Ritter>,
                  gteam22: MutableList<Witch>,
                  hteam: MutableList<Helper>){

    var herosTurn:Int = 0
    var trunk: Boolean = false
    var creature: Boolean = false
    var attackChoice: Int? = null
    var neuHeldname:MutableList<String>
    var counterResset:Int



    while ((gteam1[0].healthPoints > 0 || gteam1[1].healthPoints > 0 || gteam1[2].healthPoints > 0) &&
                (gteam2[0].healthPoints > 0 || gteam2[1].healthPoints > 0 || gteam2[2].healthPoints > 0)){



        // Ausgabe beiden Listen
        println("Lebensliste")
        bildNumber.printBild(0)
        for (n in gteam11.indices) { print(" ${gteam1[n].name} ${gteam11[n].healthPoints}    ") }
        print(" ||    ")
        for (n in gteam22.indices) { print(" ${gteam2[n].name} ${gteam2[n].healthPoints}     ") }
        print("\n")
        bildNumber.printBild(0)


// Kampf Helden Team

        var toRemoveF = mutableListOf<Feind>()

        println("Bitte wähle Aktion für dein ${herosTurn + 1} Held ${gteam1[herosTurn].name} :")
        println(
            "1. Atacke  | 2. Jemanden Heilen | ${if (!trunk) { "3. Zaubertrunk" } else { "" }} ")


        val action = readln().toInt()

        when (action) {

            1 -> {
                println("Bitte wähle Angrifziel für dein ${herosTurn + 1} Held:")
                for (gl in gteam2.indices) {
                    if (!gteam2[gl].theFin) {
                        print("${gl + 1} ${gteam2[gl].name}: ${gteam2[gl].healthPoints}    ")
                    }
                }
  // Opfer Auswahl und Prüfung


                val attackFirst = readln().toInt()
                if (attackFirst < 0 || attackFirst > gteam2.size){
                    println("Falsche Eingabe. Zahl zu groß")
                    println("")

                    println("Bitte wähle Angrifziel für dein ${herosTurn + 1} Held:")
                    for (gl in gteam2.indices) {
                        if (!gteam2[gl].theFin) {
                            print("${gl + 1} ${gteam2[gl].name}: ${gteam2[gl].healthPoints}    ")
                        }
                    }

                }


                gteam1[herosTurn].attack(gteam2[attackFirst - 1])


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
                gteam1[herosTurn].magicTrunk(gteam1[herosTurn])
                trunk = true
            }
        }

        for(gladiator in gteam2){
            if(gladiator.healthPoints <= 0){
                println("${gladiator.name} ist gestorben")
                toRemoveF.add(gladiator)
            }
        }
        gteam2.removeAll(toRemoveF)

        if (gteam2.size == 0){
            println("Helden haben gewonnen. Finita la Comedia")
            break}

        herosTurn++








        // Kampf Böse Team


        var toRemoveH = mutableListOf<Held>()


        if (!creature) {

            attackChoice = Random.nextInt(range = 0 until 6)

            when (attackChoice) {
                0 -> {

                    when (gteam2.random().name){
                        "Dark Lord" -> {
                            gteam2.add(hteam[1])
                            println("Dark Lord hat hat Knochen Drachen angelockt. Knochen Drachen wurde Team hinzugefügt") }
                        "Gini" -> {gteam2.add(hteam[2])
                            println("Gini hat ein elemental geschafft. Elemental wurde Team hinzugefügt")}
                        "Elf Tormentor" -> {gteam2.add(hteam[1])
                            println("Elf Tormentor hat Knochen Drachen angelockt. Knochen Drachen wurde Team hinzugefügt")}
                        "Mermaid Witch" -> {gteam2.add(hteam[3])
                            println("Mermaid Witch hat Freundin eingeladen. Mermaid wurde Team hinzugefügt") }
                        "Dungeon Necromanker" -> {gteam2.add(hteam[0])
                            println("Dungeon Necromanker hat zu Diablo aufgerufen. Diablo wurde Team hinzugefügt") }
                    }
                }
                1 -> {
                    gteam2.random().attack(gteam1.random())
                }
                2 -> {
                    gteam2.random().curseMagic(gteam1.random())
                }
                3 -> {
                    gteam2.random().diversion(gteam1.random())
                }

                4 -> {

                    gteam2.random().diversion(gteam1.random())
                }
                5 -> {

                    gteam2.random().changeName(gteam1.random())

                }



            }

            if (attackChoice == 0){creature = true}


        }
        else {
            attackChoice = Random.nextInt(1,5)

            when (attackChoice) {
                1 -> {
                    gteam2.random().attack(gteam1.random())
                }
                2 -> {
                    gteam2.random().curseMagic(gteam1.random())
                }
                3 -> {
                    gteam2.random().diversion(gteam1.random())
                }
                4 -> {

                    gteam2.random().changeName(gteam1.random())

                }
            }
        }



        for(hero in gteam1){

            if(hero.healthPoints <= 0){
                herosTurn--
                println("${hero.name} ist gefallen")
                toRemoveH.add(hero)
            }
        }
        gteam1.removeAll(toRemoveH)

        if (gteam1.size == 0){
            println("Die dunklen Mächte haben gewonnen. Finita la Comedia")
            break}


        if (herosTurn > gteam1.size-1){
            herosTurn = 0
            trunk = false
        }

        roundCounter++

        gteam1[herosTurn].countDown++

        if (gteam1[herosTurn].name != gteam1[herosTurn].nHname && gteam1[herosTurn].cDfunc(gteam1[herosTurn])){
            gteam1[herosTurn].changeNameBack(gteam1[herosTurn])
        }
   // Ende while schleife
    }

    bildNumber.printBild(6)

}