package ch.fhnw.afpars.ui.control.editor.shapes

import javafx.geometry.Dimension2D
import javafx.geometry.Point2D
import javafx.scene.canvas.GraphicsContext

/**
 * Created by cansik on 29.01.17.
 */
open class OvalShape() : BaseShape() {
    var center = Point2D.ZERO!!
    var size = Dimension2D(5.0, 5.0)

    constructor(center: Point2D, size: Dimension2D) : this() {
        this.center = center
        this.size = size
    }

    override fun render(gc: GraphicsContext) {
        gc.fillOval(center.x, center.y, size.width, size.height)
        gc.strokeOval(center.x, center.y, size.width, size.height)
    }
}