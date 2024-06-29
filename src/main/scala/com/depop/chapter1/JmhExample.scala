package com.depop.chapter1

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

/**
 * Explain each annotation in the JMH example.
 *  State: Scope.Thread - the state of the benchmarked object is shared among all threads
 *  OutputTimeUnit: TimeUnit.SECONDS - the time unit for the output
 *  BenchmarkMode: Mode.Throughput - the benchmark mode is throughput
 *  Warmup: iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS - the number of warmup iterations and time
 *  Measurement: iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS - the number of measurement iterations and time
 *  Fork: 1 - the number of forks
 *  Threads: 16 - the number of threads
 *
 * Explain why we need a black hole in the JMH example.
 *  The black hole is used to consume the result of the benchmarked method to prevent the compiler from optimizing it away.
 *  This is necessary because the benchmarked method does not have any side effects, so the compiler can optimize it away.
 *  By consuming the result of the benchmarked method, we ensure that the method is not optimized away.
 */
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Array(Mode.Throughput))
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@Threads(1)
class JmhExample {

  // jmh:run com.depop.intro.JmhExample
  @Benchmark
  def testMethod(blackHole: Blackhole): Unit = {
    List.range(1, Integer.MAX_VALUE).sum
    //blackHole.consume(sum)
  }

  @Benchmark
  def testMethodWithBlackhole(blackHole: Blackhole): Unit = {
    blackHole.consume(List.range(1, Integer.MAX_VALUE).sum)
  }
}
