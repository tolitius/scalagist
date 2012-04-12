#What is Scalagist?

Scalagist started as an initiative to enable you to look at Scala code through a pair of "simplify me" glasses. 
It is especially useful when coming from other "cleaner" languages (e.g. clojure, python, ruby, groovy, etc..) or reading Scala source that was written by other people, or you, but some time ago (which is the same thing usually).

#Why Would Anybody Need Such a Thing?

Let's look at a simple [Monad](http://www.codecommit.com/blog/ruby/monads-are-not-metaphors) (don't worry if it sounds gibberish, just look at it as a simple trait/interface/class, etc..):

```scala
trait Monad[+M[_]] {
  def unit[A](a: A): M[A]
  def bind[A, B](m: M[A])(f: A => M[B]): M[B]
}
```

I did an experiment and surveyed several devs. Here is what I found out. We mentally comprehend the code in several steps:

* it is a "trait"
* named "Monad"
* it has two methods "unit" and "bind"
* "unit" takes an argument and returns "something"
* "bind" takes an argument and a function and returns "something"
* ... now let's figure out what those "constraints" 'M', 'A' and 'B' and apply it to the above digested "trait"

What is interesting that for _every_ step, besides the last one, types (e.g. constraints) absolutely did not matter, and moreover they were _constantly_ on the way to comprehend what the code is about.

Now, given the rich type system and the whole "static typing" mindset that Scala is all about, types in Scala code _are_ important. And of course it means a lot that e.g. "unit" lifts A in M[A], but.. interestingly enough => it is **secondary** to the understanding what the code does from just looking at it.

#So What Can Scalagist Do?

Scalagist takes the above Monad, or any other Scala source, and makes a lot quicker to get the "gist" of what the code does without a visual clutter. Let's look at the Monad one more time:

```bash
$ cat Monad.scala                   
```
```scala
trait Monad[+M[_]] {
  def unit[A](a: A): M[A]
  def bind[A, B](m: M[A])(f: A => M[B]): M[B]
}
```
and now through the **scalagist glasses**:

```bash
$ clj psy-scalagist.clj Monad.scala
```

```scala
trait Monad {
  def unit(a: A): M
  def bind(m: M)(f: A => M): M
}
``` 

A "gistified" code is not runnable, it is not even compilable, however .... it is a lot more readable, and makes it quicker to get that gist.

####_of course the fact that Scalagist is written in a couple of lines of Clojure is an intended pun :)_
