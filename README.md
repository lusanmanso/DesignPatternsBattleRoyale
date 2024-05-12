# DesignPatternsCombatGame
# Design Patterns Combat Game
#####Lucia Sánchez Manso, Olivia Troitiño Frydrych, Claudia Gascó Miranda
##1. Descripción
Este proyecto ha tenido como objetivo desarrollar un videojuego exclusivamente en lenguaje Java, donde un personaje personalizado por el jugador combate con un sistema de turnos en un mundo contra enemigos procedentes de estos. El jugador puede optar después de cada mundo por mejorar su equipamiento o aumentar la cantidad de puntos obtenida. Cuanto mejor sea el puntaje obtenido por el jugador, mejor será el resultado general de la partida.
###1. 2 Mecánicas
Design Patterns Combat Game se explica con el número tres. Tres managers que controlan tres mundos con tres tipos de enemigo que contienen tres características. La partida dispone de tres armas con tres tipos de efectos que afectan a cada una de esas características.
##2. Manual
El input general es por teclado.
###2. 1 Personaje
Empiezas con treinta puntos asignables entre tus distintas habilidades **Ataque**, **Defensa** y **Puntos de Vida**. No puedes tener puntos nulos (en cero) ni negativos. Posteriormente tus estadísticas base podrán ser mejoradas. *En un futuro se podrían hacer personajes preestablecidos, con rasgos únicos.*
###2. 2 Mundos
Existen tres mundos distintos, basados en los elementos naturales: *Jumanji*, *Caribe* y *Mordor*. A medida que los mundos progresan los enemigos se multiplican y se vuelven más fuertes.
###2. 3 Enemigos
Los enemigos tienen estadísiticas base y poder de acuerdo a sus niveles. Las **Brujas** son capaces de hechizarte, los **Trolls** al morderte pueden envenenarte y los **Demonios** más poderosos pueden concentrar su fuerza en los ataques.
##3. Patrones implementados
- Strategy Pattern
- Abstract Factory
- Singleton Pattern
- State Pattern
- State Pattern
- Decorator Pattern
- Facade Method 