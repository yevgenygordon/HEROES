import kotlin.random.Random


fun main (){

    start()

}

fun start (){


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
 123     
    """.trimMargin())


    var aivengo: Ritter = Ritter("Aivengo")
    var sauron: Magier = Magier("Sauron")
    fight(aivengo,sauron)

}




fun fight (gladiator1: Held, gladiator2: Feind) {

    while (!gladiator1.theFin && !gladiator2.theFin) {

        val attackFirst = Random.nextBoolean()

        if (attackFirst) {
            gladiator1.attack(gladiator2)
            gladiator2.attack(gladiator1)
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



