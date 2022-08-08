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

        println("Bitte wähle Aktion für dein ${herosTurn + 1} Held :")
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
                val attackFirst = readln().toInt()
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

        if (herosTurn > gteam1.size-1){
            herosTurn = 0
            trunk = false
        }

        // Kampf Böse Team


        var toRemoveH = mutableListOf<Held>()




        if (!creature) {
            println("kreature")
            attackChoice = Random.nextInt(range = 0 until 4)

            when (attackChoice) {
                0 -> {
                    attackChoice = Random.nextInt(range = 0 until 4)
                    when (){}
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
                    gteam2.random().attack(gteam1.random())
                }
                2 -> {
                    gteam2.random().curseMagic(gteam1.random())
                }
                3 -> {
                    gteam2.random().diversion(gteam1.random())
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
    }

}