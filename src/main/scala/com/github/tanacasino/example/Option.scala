package com.github.tanacasino.example

sealed trait Option[+A] {

  def isDefined: Boolean

  def isEmpty: Boolean = !isDefined

  def foreach(f: A => Unit): Unit = {
    map(f).getOrElse(())
  }

  def map[B](f: A => B): Option[B] = this match {
    case None    => None
    case Some(v) => Some(f(v))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case None    => default
    case Some(v) => v
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    map(f) getOrElse None
  }

  def orElse[B >: A](or: => Option[B]): Option[B] = {
    map(Some(_)) getOrElse or
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(v) if f(v) => Some(v)
    case _               => None
  }

  def filterViaFlatMap(f: A => Boolean): Option[A] = {
    flatMap { x =>
      if (f(x)) Some(x) else None
    }
  }

  def fold[B](n: => B, s: A => B): B = {
    map(s).getOrElse(n)
  }

}

case class Some[+A](get: A) extends Option[A] {
  def isDefined: Boolean = true
}

case object None extends Option[Nothing] {
  def isDefined: Boolean = false
}

object Option {

  def none[A]: Option[A] = None

  def apply[A](a: A): Option[A] = if (a != null) Some(a) else None

  def lift[A, B](f: A => B): Option[A] => Option[B] = {
    _ map f
  }

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      av <- a
      bv <- b
    } yield f(av, bv)
  }

  def traverse[A, B](as: List[A])(f: A => Option[B]): Option[List[B]] = {
    as.foldRight(Option(List.empty[B]))((a, b) => map2(f(a), b)(_ :: _))
  }

  def sequence[A](as: List[Option[A]]): Option[List[A]] = {
    traverse(as)(identity)
  }

}
