    mvn clean install
    java -jar target/benchmarks.jar ".*StringCodecBenchmark.*" -wi 5 -i 5 -f 1

    [...]

    # Run complete. Total time: 00:00:36

    Benchmark                                              Mode   Samples        Score  Score error    Units
    b.StringCodecBenchmark.testCodecWithStringMethods     thrpt         5  6431692,100   274535,920    ops/s
    b.StringCodecBenchmark.testCodecWithThreadLocal       thrpt         5  4666379,385    89181,320    ops/s
    b.StringCodecBenchmark.testCodecWithoutThreadLocal    thrpt         5  4356621,765   442204,179    ops/s
