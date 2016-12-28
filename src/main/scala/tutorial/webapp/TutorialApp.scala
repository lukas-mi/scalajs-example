package tutorial.webapp

import scala.scalajs.js.annotation.JSExport
import org.scalajs.jquery.jQuery
import scala.scalajs.js.JSApp


object TutorialApp extends JSApp {

  val body = jQuery("body")

  @JSExport
  override def main(): Unit = jQuery(setupUI _)

  def setupUI(): Unit = {
    jQuery("<p>This is the first paragraph.</p>").appendTo(body)

    jQuery("""<button type="button">Show a link to the tutorial</button>""")
      .one("click", addLink _)
      .appendTo(body)

    jQuery("""<button type="button">Click me</button>""")
      .click(addClickedMessage _)
      .appendTo(body)

    jQuery("""<p id="link"></p>""").appendTo(body)
  }

  def addClickedMessage(): Unit = {
    jQuery("<p>You clicked the button.</p>").css("color", "blue").appendTo(body)
  }

  def addLink(): Unit = {
    jQuery("#link")
      .append("""<a href="https://www.scala-js.org/tutorial/basic/" target="_blank">Basic Scala.js tutorial.</a>""")
  }
}
