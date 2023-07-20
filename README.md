# Xefia-Kotlin

Jugando con IA en Kotlin usando Xef.ai

[![Kotlin](https://img.shields.io/badge/Code-Kotlin-blueviolet)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Code-Compose-blue)](https://www.jetbrains.com/es-es/lp/compose-mpp/)
![GitHub](https://img.shields.io/github/last-commit/joseluisgs/xefia-kotlin)
[![LICENSE](https://img.shields.io/badge/Lisence-CC-%23e64545)](https://joseluisgs.github.io/docs/license/)

![imagen](https://xef.ai/img/xef-brand.svg)

- [Xefia-Kotlin](#xefia-kotlin)
  - [Acerca de](#acerca-de)
    - [OpenAI Token](#openai-token)
    - [Uso](#uso)
      - [Consultas tipadas](#consultas-tipadas)
    - [Consultas con solo texto](#consultas-con-solo-texto)
  - [Autor](#autor)
    - [Contacto](#contacto)
  - [Licencia de uso](#licencia-de-uso)


## Acerca de

Este proyecto tiene como objetivo jugar con la IA en Kotlin usando [Xef.ai](https://xef.ai/). 

### OpenAI Token
Lo primero es obtener un token de OpenAI, para ello debemos ir a [OpenAI](https://beta.openai.com/) y registrarnos. Una vez hecho esto, ceamos un token que devemos tener en la variable de entorno `OPENAI_TOKEN`. Para ello, en Linux, podemos hacer lo siguiente:

```bash
export OPENAI_TOKEN=<nuestro token>
```

También podemos hacerlo en la configuración de entorno de ejecución 
![imagen](./images/Screenshot_20230720_140002.png)

### Uso

#### Consultas tipadas
```kotlin
@Serializable
data class Population(val size: Int, val description: String)

@Serializable
data class Image(val description: String, val url: String)

suspend fun main() =
    ai {
        val cazorla: Population = prompt("Population of Cazorla, Spain.")
        val leganes: Population = prompt("Population of Leganés, Spain.")
        println("The population of cazorla is ${cadiz.size} and the population of leganes is ${seattle.size}")
        val img: Image = image("A hybrid city of Leganes, Spain and Cazorla, Spain.")
        println("Image ${img.description} available at ${img.url}")
    }.getOrElse { println(it) }

```

### Consultas con solo texto
```kotlin
suspend fun informacionInstituto(instituto: String) = ai {
    promptMessage("Dame información del instituto $instituto")
}.getOrThrow()

suspend fun main() {
    println("Información sobre el instituto de Leganés IES Luis Vives")
    val luisVives = informacionInstituto("IES Luis Vives de Leganés, Madrid")
    println(luisVives)

}
```


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/JoseLuisGS_)

[![Twitter](https://img.shields.io/twitter/follow/JoseLuisGS_?style=social)](https://twitter.com/JoseLuisGS_)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)
[![GitHub](https://img.shields.io/github/stars/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto

<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.dev" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/JoseLuisGS_" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>  &nbsp;&nbsp;
<a href="https://www.youtube.com/@joseluisgs" target="_blank">
        <img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/e/ef/Youtube_logo.png" 
    height="30">
    </a>  
</p>

## Licencia de uso

Este repositorio y todo su contenido está licenciado bajo licencia **Creative Commons**, si desea saber más, vea
la [LICENSE](https://joseluisgs.dev/docs/license/). Por favor si compartes, usas o modificas este proyecto cita a su
autor, y usa las mismas condiciones para su uso docente, formativo o educativo y no comercial.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">
JoseLuisGS</span>
by <a xmlns:cc="http://creativecommons.org/ns#" href="https://joseluisgs.dev/" property="cc:attributionName" rel="cc:attributionURL">
José Luis González Sánchez</a> is licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons
Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional License</a>.<br />Creado a partir de la obra
en <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/joseluisgs" rel="dct:source">https://github.com/joseluisgs</a>.