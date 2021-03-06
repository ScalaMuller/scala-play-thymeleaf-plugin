package com.github.dmitraver.play.thymeleaf.wrappers

import play.api.mvc.Session

/**
 * Session wrapper as a java Map object. It simplifies working with Session
 * inside a template.
 */
class SessionMap(session: Session) extends java.util.HashMap[String, String] {

	override def put(key: String, value: String): String = {
		val previousValue = get(key)
		session + (key, value)
		previousValue
	}

	override def get(key: scala.Any): String = key match {
		case k: String => session.get(k).getOrElse("")
		case _ => ""
	}
}

object SessionMap {

	def apply(session: Session): SessionMap = {
		new SessionMap(session)
	}
}
