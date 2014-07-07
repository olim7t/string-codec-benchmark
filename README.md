    mvn clean install
    java -jar target/benchmarks.jar ".*StringCodecBenchmark.*" -wi 5 -i 5 -f 1

    [...]

    # Run complete. Total time: 00:00:36

    Benchmark                                              Mode   Samples
    Score  Score error    Units
    b.StringCodecBenchmark.testCodecWithStringMethods     thrpt         5
    6504075,267  1117357,537    ops/s
    b.StringCodecBenchmark.testCodecWithThreadLocal       thrpt         5
    4521578,262   185150,008    ops/s
    b.StringCodecBenchmark.testCodecWithoutThreadLocal    thrpt         5
    4492657,467   135747,480    ops/s
