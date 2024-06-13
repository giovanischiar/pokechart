struct Explosion: Tag {
    var x: Double
    var y: Double
    
    let dimensions = Traits.shared.dimensions
    var size: Double { dimensions.iconSize }
        
    var body: [any Tag] {
        Path()
            .d(ExplosionPathData(x: x, y: y))
            .stroke(width: 1)
            .fill(color: -"explosionColor")
            .stroke(color: -"explosionColor")
            .strokeLine(cap: "butt")
            .strokeLine(join: "round")
    }
}
