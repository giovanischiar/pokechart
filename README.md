<h1 align="center">
  <img src="readme-res/ic_launcher.svg" width="100" height="100"><br>
  Pokechart
</h1>

<p align="center">
  <strong>Compare types to check their vulnerabilities, resistances, and more.</strong><br>
  Input the types, and the app will return the combined vulnerabilities and resistances.
</p>

- [Use Cases](#use-cases)
- [Technologies](#technologies)
- [Structure](#structure)
- [Diagrams](#diagrams)
  - [Package `io.schiar.pokechart`](#package-ioschiarpokechart)
- [Future Tasks](#future-tasks)

## Use Case

|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Screenshot&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
|:-:|:-:|
|<img src="readme-res/screenshots/types-screen.png" width="384" height="384">|This is what the app looks like when you open it. To input the types, select them by pressing each one, and then click on the last button at the bottom.|
|<img src="readme-res/screenshots/selecting-single-type.gif" width="384" height="384">|You can select a single type. When only one type is selected, its strengths and weaknesses are also displayed, used for attacks from that type.|
|<img src="readme-res/screenshots/selecting-multiple-types.gif" width="384" height="384">|You can also select more than one type, allowing you to check the resistance and vulnerability types for a Pokémon with 2 types.|

# Technologies
|Technology|Purpose|
|:-:|:-:|
|<img src="https://3.bp.blogspot.com/-VVp3WvJvl84/X0Vu6EjYqDI/AAAAAAAAPjU/ZOMKiUlgfg8ok8DY8Hc-ocOvGdB0z86AgCLcBGAsYHQ/s1600/jetpack%2Bcompose%2Bicon_RGB.png" width="50" height="50"><br>[Jetpack Compose](https://developer.android.com/jetpack/compose)|Design UI|

## Structure
  Please check [my other project](https://github.com/giovanischiar/fridgnet?tab=readme-ov-file#structure) to learn more about the notation I used to create the diagrams in this project.

## Diagrams

### Package `io.schiar.pokechart`
  This diagram shows all the packages the application has, along with their structures. Some packages are simplified, while others are more detailed.
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="./readme-res/diagrams/dark/io-schiar-pokechart-structure-diagram.dark.svg">
    <img alt="Package io.schiar.pokechart Diagram" src="./readme-res/diagrams/io-schiar-pokechart-structure-diagram.light.svg">
  </picture>

## Future Tasks
  - Create an Icon.
  - Change the name.
  - Create a [tile](https://developer.android.com/training/wearables/tiles) to easily  access the application.
  - Publish on the store.

