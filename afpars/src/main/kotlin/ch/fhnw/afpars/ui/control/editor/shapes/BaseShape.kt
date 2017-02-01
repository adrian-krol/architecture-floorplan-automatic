package ch.fhnw.afpars.ui.control.editor.shapes

import ch.fhnw.afpars.io.opencv.IMatRenderable
import ch.fhnw.afpars.io.svg.ISvgRenderable
import ch.fhnw.afpars.util.toAwtColor
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import org.jfree.graphics2d.svg.SVGGraphics2D
import org.opencv.core.Mat
import java.awt.BasicStroke

/**
 * Created by cansik on 29.01.17.
 */
abstract class BaseShape : ISvgRenderable, IMatRenderable {
    var fill: Paint = Color.WHITE!!
    var stroke: Paint = Color.BLACK!!
    var strokeWeight = 1.0
    var visible = true

    fun noFill() {
        fill = Color.TRANSPARENT
    }

    fun noStroke() {
        stroke = Color.TRANSPARENT
    }

    abstract fun render(gc: GraphicsContext)

    override fun renderToSvg(g: SVGGraphics2D) {
        // prepare drawing
        if (fill is Color && fill != Color.TRANSPARENT) {
            g.paint = fill.toAwtColor()
        }

        if (stroke is Color && stroke != Color.TRANSPARENT) {
            g.paint = fill.toAwtColor()
        }

        g.stroke = BasicStroke(strokeWeight.toFloat(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
    }

    override fun renderToMat(m: Mat) {

    }

    override fun toString(): String {
        return "BaseShape"
    }
}