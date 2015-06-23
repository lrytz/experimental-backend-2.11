Example sbt project for the experimental backend in Scala 2.11.

See https://github.com/scala/make-release-notes/blob/2.11.x/experimental-backend.md

```
➜  experimental-backend-2.11 git:(master) java -version
java version "1.8.0_25"


➜  experimental-backend-2.11 git:(master) cat src/main/scala/Test.scala 
object Test extends App {
  @inline def m = 10

  def g = {
    val f = (x: Int) => x + m
    f(1)
  }

  println(g)
}


➜  experimental-backend-2.11 git:(master) sbt run
[...]
11


➜  experimental-backend-2.11 git:(master) javap -c -classpath target/scala-2.11/classes/ Test\$
[...]
  public int g();
       0: aload_0
       1: invokedynamic #92,  0             // InvokeDynamic #0:apply$mcII$sp:(LTest$;)Lscala/compat/java8/JFunction1$mcII$sp;
       6: checkcast     #94                 // class scala/Function1
       9: astore_1
      10: aload_1
      11: iconst_1
      12: invokeinterface #96,  2           // InterfaceMethod scala/Function1.apply$mcII$sp:(I)I
      17: ireturn

  public final int Test$$$anonfun$1(int);
       0: iload_1
       1: aload_0
       2: astore_2
       3: bipush        10
       5: istore_3
       6: iload_3
       7: iadd
       8: ireturn
```

Note
  - closure created using `invokedynamic`
  - the call to `m` is inlined in the closure body (`bipush 10`)
