struct Fire: Tag {
    var x: Double
    var y: Double
    
    let dimensions = Traits.shared.dimensions
    var size: Double { dimensions.iconSize }
        
    var body: [any Tag] {
        Path()
            .d(FirePathData(x: x, y: y))
            .stroke(width: 1)
            .fill(color: -"fireOuterPartColor")
            .stroke(color: -"fireOuterPartColor")
            .strokeLine(cap: "butt")
            .strokeLine(join: "round")
        Path()
            .d(InnerFirePathData(x: x, y: y))
            .stroke(width: 1)
            .fill(color: -"fireInnerPartColor")
            .stroke(color: -"fireInnerPartColor")
            .strokeLine(cap: "butt")
            .strokeLine(join: "round")
    }
}
