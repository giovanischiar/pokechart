struct IconForeground: Foregroundable {
    let dimensions = Traits.shared.dimensions
    var size: Double { dimensions.iconSize }

    var foreground: Foreground {
        Foreground(size: size) {
            Fire(x: -19, y: -30)
            Water(x: -40, y: -19)
            Explosion(x: -1.425, y: -7.18)
        }
    }
}
