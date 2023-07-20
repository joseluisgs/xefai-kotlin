import com.xebia.functional.xef.auto.ai
import com.xebia.functional.xef.auto.llm.openai.getOrThrow
import com.xebia.functional.xef.auto.llm.openai.prompt
import com.xebia.functional.xef.auto.llm.openai.promptMessage
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

// Data class para serializar la respuesta
@Serializable
data class NoticiaSobreElTiempo(val summary: String)

@Serializable
data class InformacionPoblacion(
    val poblacionActual: String,
    val superficie: String,
    val provincia: String,
    val comunidad: String,
    val resumenHistoria: String,
    val resumenGeografia: String,
    val resumenEconomia: String,
    val resumenDemografia: String,
    val resumenClimatologia: String,
    val resumenCultura: String,
    val resumenGastronomia: String,
)

@Serializable
data class Lenguaje(val summary: String)

@Serializable
data class Croqueta(val nombre: String, val receta: String)

@Serializable
data class ListaCroquetas(val croquetas: List<Croqueta>)

@Serializable
data class ListaTenistas(val tenista: List<Tenista>)

@Serializable
data class Tenista(val nombre: String, val descripcion: String)


// podemos crear funciones que nos ayuden a trabajar con la librería
suspend fun libros(topic: String): String = ai {
    promptMessage("Dime una colección de libros sobre: $topic")
}.getOrThrow()

suspend fun peliculasValoradas(actor: String) = ai {
    promptMessage("dime las películas mejor valoradas por $actor")
}.getOrThrow()

suspend fun informacionPoblacion(ciudad: String) = ai {
    promptMessage("Información sobre la población de $ciudad, destacando su provincia, comunidad, población actual, superficie, y haciendo un resumen de su historia, geografía, economía, demografía, climatología, cultura y gastronomía")
}.getOrThrow()

suspend fun informacionInstituto(instituto: String) = ai {
    promptMessage("Dame información del instituto $instituto")
}.getOrThrow()


fun main() = runBlocking {
    println("Jugando con Xef AI y OpenAI")
    println()

    // Ejemplo de uso de la librería
    println("Colección de libros sobre Kotlin")
    val libros = libros("kotlin")
    println(libros)

    // Podemos invocar a la librería de forma directa con ai
    println()
    println("El tiempo en Leganés el 1 de Enero de 2021")
    ai {
        val elTiempo: NoticiaSobreElTiempo =
            prompt("escribe un parrafo de 200 palabras sobre el tiempo en la fecha: 2021-01-01 en la ciudad de: Leganés")
        println(elTiempo.summary)
    }.getOrThrow()

    println()
    println("películas mejor valoradas de Tom Cruise")
    val pelis = peliculasValoradas("Tom Cruise")
    println(pelis)

    /* println()
     println("Información sobre la población de Cazorla (Jaén)")
     ai {
         val info: InformacionPoblacion =
             prompt("Información sobre la población de Cazorla (Jaén), destacando su provincia, comunidad, población actual, superficie, y haciendo un resumen de su historia, geografía, economía, demografía y cultura")
         println("Información sobre la población de Cazorla (Jaén)")
         println(info)
     }.getOrThrow()*/

    println()
    println("Información sobre la población de Cazorla (Jaén)")
    val cazorla = informacionPoblacion("Cazorla (Jaén)")
    println(cazorla)

    println()
    println("Información sobre la mejor croquetas")
    ai {
        val info: Croqueta =
            prompt("Dame información de la mejor croqueta que conozcas, destacando sus ingredientes y receta")
        println(info)
    }.getOrThrow()

    println()
    println("Información sobre el instituto de Leganés IES Luis Vives")
    val luisVives = informacionInstituto("IES Luis Vives de Leganés, Madrid")
    println(luisVives)

    println()
    println("Información sobre el lenguaje Kotlin y por qué es el mejor")
    ai {
        val info: Lenguaje =
            prompt("Dame información relevante sobre el lenguaje Kotlin y justifícame por qué es el mejor de todos")
        println(info)
    }.getOrThrow()

    println()
    println("Lista de las 5 mejores croquetas que conozcas")
    ai {
        val info: ListaCroquetas =
            prompt("Dame una lista de las 5 mejores croquetas que conozcas, destacando sus nombre y receta")
        info.croquetas.forEachIndexed { index, croqueta ->
            println("Croqueta ${index + 1}")
            println("Ingredientes: ${croqueta.nombre}")
            println("Receta: ${croqueta.receta}")
            println()
        }
    }.getOrThrow()

    println()
    println("Lista de los 5 mejores tenistas que conozcas españoles")
    ai {
        val info: ListaTenistas =
            prompt("Dame una lista de los 5 mejores tenistas que conozcas españoles, destacando su nombre y descripción de su juego")
        info.tenista.forEachIndexed { index, tenista ->
            println("Tenista ${index + 1}")
            println("Nombre: ${tenista.nombre}")
            println("Descripción: ${tenista.descripcion}")
            println()
        }
    }.getOrThrow()

}
