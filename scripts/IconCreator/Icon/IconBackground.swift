struct IconBackground: Backgroundable {
    let dimensions = Traits.shared.dimensions
    var size: Double { dimensions.iconSize }

    var background: Background {
        Background(size: size).fill(color: -"backgroundColor")
    }
}
