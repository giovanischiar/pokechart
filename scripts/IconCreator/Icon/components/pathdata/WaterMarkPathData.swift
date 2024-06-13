struct WaterMarkPathData : PathDatable {
    var  commands: [PathDataCommand]
    
    init (x: Double = 0, y: Double = 0, received: Bool = true) {
         commands = "M 21.302145 38.670803 l 0 0 c -2.2261467 -0.34248352 -4.225067 -1.555275 -5.5570173 -3.3715706 c -1.3319521 -1.8162994 -1.8878288 -4.0873203 -1.5453444 -6.313469".commands
         commands.move(x: x, y: y)
    }
}
