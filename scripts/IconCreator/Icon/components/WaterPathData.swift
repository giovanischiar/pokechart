struct WaterPathData : PathDatable {
    var  commands: [PathDataCommand]
    
    init (x: Double = 0, y: Double = 0, received: Bool = true) {
         commands = "M 17.51181 44.692913 l 0 0 c -9.671505 -5.235832 -13.316683 -17.362923 -8.141731 -27.086615 q 5.2853336 -9.931097 8.326878 -21.076906 q 8.677212 7.603409 18.555012 12.950923 l 0 0 c 9.671505 5.235833 13.316685 17.362923 8.141731 27.086613 l 0 0 c -5.1749496 9.72369 -17.210382 13.361816 -26.88189 8.125984 Z".commands
         commands.move(x: x, y: y)
    }
}
