struct Water: Tag {
    var x: Double
    var y: Double
    
    let dimensions = Traits.shared.dimensions
    var size: Double { dimensions.iconSize }
        
    var body: [any Tag] {
        Path()
            .d(WaterPathData(x: x, y: y))
            .stroke(width: 1)
            .fill(color: -"waterColor")
            .stroke(color: -"waterColor")
            .strokeLine(cap: "butt")
            .strokeLine(join: "round")
        Path()
            .d(WaterMarkPathData(x: x, y: y))
            .stroke(width: 1)
            .stroke(color: -"waterMarkColor")
    }
}
