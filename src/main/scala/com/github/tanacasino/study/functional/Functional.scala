package com.github.tanacasino.study.functional


// Functor -> Monad
trait Functor[F[_]] {

  def map[A, B](fa: F[A])(f: A => B): F[B]

}

trait Apply[F[_]] extends Functor[F] {

  def ap[A, B](fa: F[A])(f: F[A => B]): F[B]

}

trait Applicative[F[_]] extends Apply[F] {

  def point[A](a: A): F[A]

}

trait Bind[F[_]] extends Apply[F] {

  def bind[A, B](fa: F[A])(f: A => F[B]): F[B]

}

trait Monad[F[_]] extends Applicative[F] with Bind[F]



// Semigroup and Monoid
trait Semigroup[A] {

  def append(a1: A, a2: A): A

}

trait Monoid[A] extends Semigroup[A] {

  def zero: A

}



// ApplicativePlus / MonadPlus

trait Plus[F[_]] {

  def plus[A](fa: F[A], b: => F[A]): F[A]

}

trait PlusEmpty[F[_]] extends Plus[F] {

  def empty[A]: F[A]

}

trait ApplicativePlus[F[_]] extends Applicative[F] with PlusEmpty[F]

trait MonadPlus[F[_]] extends Monad[F] with PlusEmpty[F]


// TODO: Foldable/Traverse

