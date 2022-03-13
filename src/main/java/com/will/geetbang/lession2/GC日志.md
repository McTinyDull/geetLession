# 串行GC

## gc日志

```
Java HotSpot(TM) 64-Bit Server VM (25.231-b11) for bsd-amd64 JRE (1.8.0_231-b11), built on Oct  5 2019 03:15:25 by "java_re" with gcc 4.2.1 (Based on Apple Inc. build 5658) (LLVM build 2336.11.00)
Memory: 4k page, physical 16777216k(366092k free)

/proc/meminfo:

CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=4294967296 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseSerialGC 
2022-03-13T18:54:01.087-0800: 0.177: [GC (Allocation Failure) 2022-03-13T18:54:01.087-0800: 0.177: [DefNew: 139582K->17472K(157248K), 0.0286227 secs] 139582K->45514K(506816K), 0.0287543 secs] [Times: user=0.02 sys=0.02, real=0.03 secs] 
2022-03-13T18:54:01.142-0800: 0.232: [GC (Allocation Failure) 2022-03-13T18:54:01.142-0800: 0.232: [DefNew: 157248K->17471K(157248K), 0.0367640 secs] 185290K->91833K(506816K), 0.0368646 secs] [Times: user=0.02 sys=0.02, real=0.03 secs] 
2022-03-13T18:54:01.199-0800: 0.289: [GC (Allocation Failure) 2022-03-13T18:54:01.199-0800: 0.289: [DefNew: 156976K->17467K(157248K), 0.0275470 secs] 231338K->138720K(506816K), 0.0276509 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.249-0800: 0.338: [GC (Allocation Failure) 2022-03-13T18:54:01.249-0800: 0.338: [DefNew: 157243K->17470K(157248K), 0.0273995 secs] 278496K->179608K(506816K), 0.0274863 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.294-0800: 0.384: [GC (Allocation Failure) 2022-03-13T18:54:01.294-0800: 0.384: [DefNew: 157246K->17470K(157248K), 0.0281677 secs] 319384K->221745K(506816K), 0.0282563 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.343-0800: 0.433: [GC (Allocation Failure) 2022-03-13T18:54:01.343-0800: 0.433: [DefNew: 157246K->17471K(157248K), 0.0251545 secs] 361521K->261529K(506816K), 0.0252403 secs] [Times: user=0.01 sys=0.01, real=0.02 secs] 
2022-03-13T18:54:01.386-0800: 0.476: [GC (Allocation Failure) 2022-03-13T18:54:01.386-0800: 0.476: [DefNew: 157247K->17471K(157248K), 0.0279050 secs] 401305K->302314K(506816K), 0.0279894 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.431-0800: 0.521: [GC (Allocation Failure) 2022-03-13T18:54:01.431-0800: 0.521: [DefNew: 157247K->17471K(157248K), 0.0263331 secs] 442090K->342248K(506816K), 0.0264232 secs] [Times: user=0.02 sys=0.01, real=0.02 secs] 
2022-03-13T18:54:01.476-0800: 0.566: [GC (Allocation Failure) 2022-03-13T18:54:01.477-0800: 0.566: [DefNew: 157228K->17469K(157248K), 0.0293239 secs]2022-03-13T18:54:01.506-0800: 0.596: [Tenured: 369960K->271101K(370080K), 0.0565993 secs] 482004K->271101K(527328K), [Metaspace: 2576K->2576K(1056768K)], 0.0861849 secs] [Times: user=0.07 sys=0.01, real=0.09 secs] 
2022-03-13T18:54:01.585-0800: 0.675: [GC (Allocation Failure) 2022-03-13T18:54:01.585-0800: 0.675: [DefNew: 180800K->22591K(203392K), 0.0204679 secs] 451901K->334930K(655228K), 0.0205657 secs] [Times: user=0.01 sys=0.01, real=0.02 secs] 
2022-03-13T18:54:01.629-0800: 0.718: [GC (Allocation Failure) 2022-03-13T18:54:01.629-0800: 0.719: [DefNew: 203335K->22591K(203392K), 0.0233650 secs] 515674K->396870K(655228K), 0.0234400 secs] [Times: user=0.01 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.673-0800: 0.763: [GC (Allocation Failure) 2022-03-13T18:54:01.673-0800: 0.763: [DefNew: 203250K->22591K(203392K), 0.0364002 secs] 577528K->452638K(655228K), 0.0364917 secs] [Times: user=0.02 sys=0.01, real=0.04 secs] 
2022-03-13T18:54:01.732-0800: 0.822: [GC (Allocation Failure) 2022-03-13T18:54:01.732-0800: 0.822: [DefNew: 203391K->22591K(203392K), 0.0363302 secs]2022-03-13T18:54:01.769-0800: 0.858: [Tenured: 487289K->338752K(487384K), 0.0509325 secs] 633438K->338752K(690776K), [Metaspace: 2576K->2576K(1056768K)], 0.0875931 secs] [Times: user=0.07 sys=0.02, real=0.09 secs] 
2022-03-13T18:54:01.846-0800: 0.936: [GC (Allocation Failure) 2022-03-13T18:54:01.847-0800: 0.936: [DefNew: 225856K->28223K(254080K), 0.0229466 secs] 564608K->408747K(818672K), 0.0230994 secs] [Times: user=0.02 sys=0.00, real=0.03 secs] 
2022-03-13T18:54:01.897-0800: 0.986: [GC (Allocation Failure) 2022-03-13T18:54:01.897-0800: 0.986: [DefNew: 254079K->28224K(254080K), 0.0277937 secs] 634603K->474856K(818672K), 0.0279030 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2022-03-13T18:54:01.951-0800: 1.041: [GC (Allocation Failure) 2022-03-13T18:54:01.951-0800: 1.041: [DefNew: 254080K->28223K(254080K), 0.0290032 secs] 700712K->542504K(818672K), 0.0291357 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
Heap
 def new generation   total 254080K, used 145533K [0x00000006c0000000, 0x00000006d13b0000, 0x0000000715550000)
  eden space 225856K,  51% used [0x00000006c0000000, 0x00000006c728f788, 0x00000006cdc90000)
  from space 28224K,  99% used [0x00000006cf820000, 0x00000006d13afeb0, 0x00000006d13b0000)
  to   space 28224K,   0% used [0x00000006cdc90000, 0x00000006cdc90000, 0x00000006cf820000)
 tenured generation   total 564592K, used 514280K [0x0000000715550000, 0x0000000737cac000, 0x00000007c0000000)
   the space 564592K,  91% used [0x0000000715550000, 0x0000000734b8a300, 0x0000000734b8a400, 0x0000000737cac000)
 Metaspace       used 2582K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 278K, capacity 386K, committed 512K, reserved 1048576K
```

## GC日志分析

```
2022-03-13T18:54:01.087-0800: 0.177: [GC (Allocation Failure) 2022-03-13T18:54:01.087-0800: 0.177: [DefNew: 139582K->17472K(157248K), 0.0286227 secs] 139582K->45514K(506816K), 0.0287543 secs] [Times: user=0.02 sys=0.02, real=0.03 secs] 
```

### 内存情况

```
[GC (Allocation Failure) 2022-03-13T18:54:01.087-0800: 0.177: [DefNew: 139582K->17472K(157248K), 0.0286227 secs] 139582K->45514K(506816K), 0.0287543 secs]
```

|        | young区    | young区总大小 | 堆栈           | 堆栈总大小 | old区  |
| ------ | ---------- | ------------- | -------------- | ---------- | ------ |
| 回收前 | 139582K    | 157248K       | 139582K        | 506816K    | 0k     |
| 回收后 | 17472K     | 157248K       | 45514K         | 506816K    | 28042k |
| 共回收 | 122110k    | 157248K       | 98068k         | 506816K    | 0k     |
| 耗时   | 0.0286227s |               | 0.0287543 secs |            |        |

```
[GC (Allocation Failure) 2022-03-13T18:54:01.142-0800: 0.232: [DefNew: 157248K->17471K(157248K), 0.0367640 secs] 185290K->91833K(506816K), 0.0368646 secs]
```

|        | young区    | young区总大小 | 堆栈       | 堆栈总大小 | old区  |
| ------ | ---------- | ------------- | ---------- | ---------- | ------ |
| 回收前 | 157248K    | 157248K       | 185290K    | 506816K    | 28042k |
| 回收后 | 17471K     | 157248K       | 91833k     | 506816K    | 74362k |
| 共回收 | 139777k    | 157248K       | 93457k     | 506816K    | 0k     |
| 耗时   | 0.0367640s |               | 0.0368646s |            |        |

```
[GC (Allocation Failure) 2022-03-13T18:54:01.477-0800: 0.566: [DefNew: 157228K->17469K(157248K), 0.0293239 secs]2022-03-13T18:54:01.506-0800: 0.596: [Tenured: 369960K->271101K(370080K), 0.0565993 secs] 482004K->271101K(527328K), [Metaspace: 2576K->2576K(1056768K)], 0.0861849 secs]
```

|        | young       | young总 | old         | old总   | 堆      | 堆总    | Metaspace | Metaspace总 |
| ------ | ----------- | ------- | ----------- | ------- | ------- | ------- | --------- | ----------- |
| 回收前 | 157228K     | 157248K | 369960K     | 370080K | 482004K | 527328K | 2576K     | 1056768K    |
| 回收后 | 17469K      | 157248K | 271101K     | 370080K | 271101K | 527328K | 2576K     | 1056768K    |
| 共回收 |             | 157248K |             | 370080K |         | 527328K |           | 1056768K    |
| 耗时   | 0.0293239 s |         | 0.0565993 s |         |         |         |           |             |

总耗时：0.0861849 secs

###CPU情况

```
[Times: user=0.02 sys=0.02, real=0.03 secs] 
```

#并行GC

##gc日志

```
Java HotSpot(TM) 64-Bit Server VM (25.231-b11) for bsd-amd64 JRE (1.8.0_231-b11), built on Oct  5 2019 03:15:25 by "java_re" with gcc 4.2.1 (Based on Apple Inc. build 5658) (LLVM build 2336.11.00)
Memory: 4k page, physical 16777216k(561772k free)

/proc/meminfo:

CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=4294967296 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC 
2022-03-13T19:07:08.626-0800: 0.241: [GC (Allocation Failure) [PSYoungGen: 131343K->21491K(153088K)] 131343K->41796K(502784K), 0.0123411 secs] [Times: user=0.02 sys=0.04, real=0.01 secs] 
2022-03-13T19:07:08.661-0800: 0.276: [GC (Allocation Failure) [PSYoungGen: 153075K->21500K(284672K)] 173380K->75203K(634368K), 0.0153479 secs] [Times: user=0.03 sys=0.05, real=0.01 secs] 
2022-03-13T19:07:08.756-0800: 0.371: [GC (Allocation Failure) [PSYoungGen: 284668K->21499K(284672K)] 338371K->150135K(634368K), 0.0243939 secs] [Times: user=0.04 sys=0.10, real=0.03 secs] 
2022-03-13T19:07:08.820-0800: 0.435: [GC (Allocation Failure) [PSYoungGen: 284667K->21489K(547840K)] 413303K->229579K(897536K), 0.0299241 secs] [Times: user=0.04 sys=0.08, real=0.03 secs] 
2022-03-13T19:07:09.030-0800: 0.646: [GC (Allocation Failure) [PSYoungGen: 547825K->21501K(547840K)] 755915K->363778K(897536K), 0.0711421 secs] [Times: user=0.07 sys=0.11, real=0.07 secs] 
2022-03-13T19:07:09.103-0800: 0.719: [Full GC (Ergonomics) [PSYoungGen: 21501K->0K(547840K)] [ParOldGen: 342276K->260554K(558080K)] 363778K->260554K(1105920K), [Metaspace: 2575K->2575K(1056768K)], 0.0318452 secs] [Times: user=0.16 sys=0.01, real=0.03 secs] 
2022-03-13T19:07:09.214-0800: 0.830: [GC (Allocation Failure) [PSYoungGen: 526056K->148765K(1132032K)] 786610K->409320K(1690112K), 0.0559530 secs] [Times: user=0.06 sys=0.11, real=0.06 secs] 
Heap
 PSYoungGen      total 1132032K, used 1025168K [0x000000076ab00000, 0x00000007be600000, 0x00000007c0000000)
  eden space 983040K, 89% used [0x000000076ab00000,0x00000007a02dc9b8,0x00000007a6b00000)
  from space 148992K, 99% used [0x00000007b5480000,0x00000007be5c77d8,0x00000007be600000)
  to   space 189952K, 0% used [0x00000007a7300000,0x00000007a7300000,0x00000007b2c80000)
 ParOldGen       total 558080K, used 260554K [0x00000006c0000000, 0x00000006e2100000, 0x000000076ab00000)
  object space 558080K, 46% used [0x00000006c0000000,0x00000006cfe72870,0x00000006e2100000)
 Metaspace       used 2582K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 278K, capacity 386K, committed 512K, reserved 1048576K
```

## GC日志分析
### 内存情况

- youngGC日志与串行gc基本相同

```
[Full GC (Ergonomics) [PSYoungGen: 21501K->0K(547840K)] [ParOldGen: 342276K->260554K(558080K)] 363778K->260554K(1105920K), [Metaspace: 2575K->2575K(1056768K)], 0.0318452 secs] 
```

|        | young区 | young区总大小 | old区   | old区总大小 | 堆栈    | 堆栈总大小 | Metaspace | Metaspace总大小 |
| ------ | ------- | ------------- | ------- | ----------- | ------- | ---------- | --------- | --------------- |
| 回收前 | 21501K  | 547840K       | 342276K | 558080K     | 363778K | 1105920K   | 2575K     | 1056768K        |
| 回收后 | 0K      | 547840K       | 260554K | 558080K     | 260554K | 1105920K   | 2575K     | 1056768K        |
| 共回收 | 21501K  | 547840K       | 81722k  | 558080K     | 103224k | 1105920K   | 0k        | 1056768K        |

耗时：0.0318452 secs

###CPU情况

```
[Times: user=0.16 sys=0.01, real=0.03 secs] 
```

#CMS GC

## gc日志

```
Java HotSpot(TM) 64-Bit Server VM (25.231-b11) for bsd-amd64 JRE (1.8.0_231-b11), built on Oct  5 2019 03:15:25 by "java_re" with gcc 4.2.1 (Based on Apple Inc. build 5658) (LLVM build 2336.11.00)
Memory: 4k page, physical 16777216k(355152k free)

/proc/meminfo:

CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=4294967296 -XX:MaxNewSize=697933824 -XX:MaxTenuringThreshold=6 -XX:OldPLABSize=16 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:+UseParNewGC 
2022-03-13T21:19:31.784-0800: 0.178: [GC (Allocation Failure) 2022-03-13T21:19:31.784-0800: 0.178: [ParNew: 139776K->17471K(157248K), 0.0128679 secs] 139776K->43752K(506816K), 0.0131016 secs] [Times: user=0.02 sys=0.05, real=0.01 secs] 
2022-03-13T21:19:31.816-0800: 0.210: [GC (Allocation Failure) 2022-03-13T21:19:31.816-0800: 0.210: [ParNew: 156924K->17472K(157248K), 0.0173217 secs] 183204K->93277K(506816K), 0.0174616 secs] [Times: user=0.04 sys=0.05, real=0.02 secs] 
2022-03-13T21:19:31.855-0800: 0.249: [GC (Allocation Failure) 2022-03-13T21:19:31.855-0800: 0.249: [ParNew: 157248K->17471K(157248K), 0.0259575 secs] 233053K->135110K(506816K), 0.0260463 secs] [Times: user=0.15 sys=0.01, real=0.03 secs] 
2022-03-13T21:19:31.898-0800: 0.292: [GC (Allocation Failure) 2022-03-13T21:19:31.898-0800: 0.292: [ParNew: 157247K->17470K(157248K), 0.0240661 secs] 274886K->174346K(506816K), 0.0242557 secs] [Times: user=0.14 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:31.946-0800: 0.340: [GC (Allocation Failure) 2022-03-13T21:19:31.946-0800: 0.340: [ParNew: 157157K->17471K(157248K), 0.0276118 secs] 314032K->215591K(506816K), 0.0277221 secs] [Times: user=0.14 sys=0.01, real=0.03 secs] 
2022-03-13T21:19:31.975-0800: 0.369: [GC (CMS Initial Mark) [1 CMS-initial-mark: 198120K(349568K)] 219141K(506816K), 0.0015367 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2022-03-13T21:19:31.977-0800: 0.371: [CMS-concurrent-mark-start]
2022-03-13T21:19:31.981-0800: 0.374: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2022-03-13T21:19:31.981-0800: 0.374: [CMS-concurrent-preclean-start]
2022-03-13T21:19:31.982-0800: 0.375: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2022-03-13T21:19:31.982-0800: 0.375: [CMS-concurrent-abortable-preclean-start]
2022-03-13T21:19:31.997-0800: 0.391: [GC (Allocation Failure) 2022-03-13T21:19:31.997-0800: 0.391: [ParNew: 157247K->17471K(157248K), 0.0334215 secs] 355367K->264389K(506816K), 0.0336402 secs] [Times: user=0.12 sys=0.02, real=0.04 secs] 
2022-03-13T21:19:32.054-0800: 0.448: [GC (Allocation Failure) 2022-03-13T21:19:32.055-0800: 0.448: [ParNew: 157247K->17471K(157248K), 0.0366183 secs] 404165K->313897K(506816K), 0.0367538 secs] [Times: user=0.12 sys=0.02, real=0.04 secs] 
2022-03-13T21:19:32.117-0800: 0.511: [GC (Allocation Failure) 2022-03-13T21:19:32.117-0800: 0.511: [ParNew: 156979K->17471K(157248K), 0.0311101 secs] 453406K->358567K(506816K), 0.0311990 secs] [Times: user=0.12 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.168-0800: 0.562: [GC (Allocation Failure) 2022-03-13T21:19:32.168-0800: 0.562: [ParNew: 157247K->17470K(157248K), 0.0286028 secs] 498343K->398801K(539264K), 0.0287802 secs] [Times: user=0.09 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.220-0800: 0.614: [GC (Allocation Failure) 2022-03-13T21:19:32.220-0800: 0.614: [ParNew: 157246K->17470K(157248K), 0.0347976 secs] 538577K->444779K(585344K), 0.0355225 secs] [Times: user=0.14 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.279-0800: 0.672: [GC (Allocation Failure) 2022-03-13T21:19:32.279-0800: 0.672: [ParNew: 157246K->17471K(157248K), 0.0322125 secs] 584555K->493912K(634396K), 0.0323570 secs] [Times: user=0.15 sys=0.01, real=0.04 secs] 
2022-03-13T21:19:32.330-0800: 0.724: [GC (Allocation Failure) 2022-03-13T21:19:32.330-0800: 0.724: [ParNew: 157247K->17471K(157248K), 0.0374728 secs] 633688K->542232K(682792K), 0.0376040 secs] [Times: user=0.16 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.391-0800: 0.785: [GC (Allocation Failure) 2022-03-13T21:19:32.391-0800: 0.785: [ParNew: 157247K->17471K(157248K), 0.0315165 secs] 682008K->584915K(725416K), 0.0316192 secs] [Times: user=0.14 sys=0.01, real=0.03 secs] 
2022-03-13T21:19:32.443-0800: 0.837: [GC (Allocation Failure) 2022-03-13T21:19:32.443-0800: 0.837: [ParNew: 157247K->17471K(157248K), 0.0337707 secs] 724691K->631299K(771988K), 0.0339537 secs] [Times: user=0.16 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.495-0800: 0.889: [GC (Allocation Failure) 2022-03-13T21:19:32.495-0800: 0.889: [ParNew: 157247K->17468K(157248K), 0.0383569 secs] 771075K->681924K(822572K), 0.0385132 secs] [Times: user=0.15 sys=0.02, real=0.04 secs] 
2022-03-13T21:19:32.552-0800: 0.946: [GC (Allocation Failure) 2022-03-13T21:19:32.552-0800: 0.946: [ParNew: 157244K->17471K(157248K), 0.0345401 secs] 821700K->729489K(870124K), 0.0347181 secs] [Times: user=0.15 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.606-0800: 1.000: [GC (Allocation Failure) 2022-03-13T21:19:32.606-0800: 1.000: [ParNew: 157247K->17471K(157248K), 0.0316575 secs] 869265K->773743K(914368K), 0.0318144 secs] [Times: user=0.11 sys=0.02, real=0.03 secs] 
2022-03-13T21:19:32.660-0800: 1.054: [GC (Allocation Failure) 2022-03-13T21:19:32.661-0800: 1.054: [ParNew: 157247K->17471K(157248K), 0.0301697 secs] 913519K->816062K(956856K), 0.0302597 secs] [Times: user=0.10 sys=0.02, real=0.03 secs] 
Heap
 par new generation   total 157248K, used 23637K [0x00000006c0000000, 0x00000006caaa0000, 0x00000006e9990000)
  eden space 139776K,   4% used [0x00000006c0000000, 0x00000006c06057d8, 0x00000006c8880000)
  from space 17472K,  99% used [0x00000006c8880000, 0x00000006c998fdc0, 0x00000006c9990000)
  to   space 17472K,   0% used [0x00000006c9990000, 0x00000006c9990000, 0x00000006caaa0000)
 concurrent mark-sweep generation total 799608K, used 798590K [0x00000006e9990000, 0x000000071a66e000, 0x00000007c0000000)
 Metaspace       used 2582K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 278K, capacity 386K, committed 512K, reserved 1048576K
```

## GC日志分析

### 内存情况

- youngGC使用并行GC
```
2022-03-13T21:19:31.977-0800: 0.371: [CMS-concurrent-mark-start]
2022-03-13T21:19:31.981-0800: 0.374: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2022-03-13T21:19:31.981-0800: 0.374: [CMS-concurrent-preclean-start]
2022-03-13T21:19:31.982-0800: 0.375: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2022-03-13T21:19:31.982-0800: 0.375: [CMS-concurrent-abortable-preclean-start]
```

没有完成一次完整的fullGC

# G1 GC

## gc日志

```
Java HotSpot(TM) 64-Bit Server VM (25.231-b11) for bsd-amd64 JRE (1.8.0_231-b11), built on Oct  5 2019 03:15:25 by "java_re" with gcc 4.2.1 (Based on Apple Inc. build 5658) (LLVM build 2336.11.00)
Memory: 4k page, physical 16777216k(929516k free)

/proc/meminfo:

CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=4294967296 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC 
2022-03-13T21:21:44.677-0800: 0.133: [GC pause (G1 Evacuation Pause) (young), 0.0036199 secs]
   [Parallel Time: 3.1 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 133.8, Avg: 133.8, Max: 133.9, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.2, Max: 0.4, Diff: 0.3, Sum: 1.2]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 1.6, Avg: 2.0, Max: 2.3, Diff: 0.7, Sum: 15.6]
      [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 3.6]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 2.5, Avg: 2.6, Max: 2.7, Diff: 0.2, Sum: 20.7]
      [GC Worker End (ms): Min: 136.4, Avg: 136.4, Max: 136.5, Diff: 0.2]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 0.4 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.2 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 25.0M(25.0M)->0.0B(23.0M) Survivors: 0.0B->4096.0K Heap: 28.9M(512.0M)->9513.3K(512.0M)]
 [Times: user=0.01 sys=0.01, real=0.01 secs] 
2022-03-13T21:21:44.694-0800: 0.151: [GC pause (G1 Evacuation Pause) (young), 0.0046833 secs]
   [Parallel Time: 3.4 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 150.9, Avg: 151.0, Max: 151.1, Diff: 0.2]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.4, Diff: 0.4, Sum: 0.9]
      [Update RS (ms): Min: 0.0, Avg: 0.2, Max: 0.6, Diff: 0.6, Sum: 1.3]
         [Processed Buffers: Min: 0, Avg: 0.2, Max: 1, Diff: 1, Sum: 2]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 1.6, Avg: 2.3, Max: 2.9, Diff: 1.3, Sum: 18.6]
      [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.9, Diff: 0.9, Sum: 3.4]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 2.9, Avg: 3.0, Max: 3.3, Diff: 0.5, Sum: 24.3]
      [GC Worker End (ms): Min: 153.9, Avg: 154.0, Max: 154.2, Diff: 0.3]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 1.1 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.8 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 23.0M(23.0M)->0.0B(44.0M) Survivors: 4096.0K->4096.0K Heap: 42.1M(512.0M)->22.1M(512.0M)]
 [Times: user=0.01 sys=0.01, real=0.00 secs] 
2022-03-13T21:21:44.725-0800: 0.182: [GC pause (G1 Evacuation Pause) (young), 0.0061685 secs]
   [Parallel Time: 4.9 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 181.7, Avg: 181.7, Max: 181.9, Diff: 0.2]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.7]
      [Update RS (ms): Min: 0.2, Avg: 0.3, Max: 0.6, Diff: 0.4, Sum: 2.5]
         [Processed Buffers: Min: 1, Avg: 3.9, Max: 5, Diff: 4, Sum: 31]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 3.6, Avg: 3.9, Max: 4.4, Diff: 0.8, Sum: 31.0]
      [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.8, Diff: 0.8, Sum: 4.1]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.1]
      [GC Worker Total (ms): Min: 4.7, Avg: 4.8, Max: 4.9, Diff: 0.2, Sum: 38.4]
      [GC Worker End (ms): Min: 186.5, Avg: 186.6, Max: 186.6, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 1.1 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.7 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.2 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.1 ms]
   [Eden: 44.0M(44.0M)->0.0B(52.0M) Survivors: 4096.0K->6144.0K Heap: 79.9M(512.0M)->40.9M(512.0M)]
 [Times: user=0.02 sys=0.02, real=0.01 secs] 
2022-03-13T21:21:44.749-0800: 0.206: [GC pause (G1 Evacuation Pause) (young), 0.0069834 secs]
   [Parallel Time: 5.4 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 205.8, Avg: 205.9, Max: 205.9, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.8]
      [Update RS (ms): Min: 0.5, Avg: 0.5, Max: 0.6, Diff: 0.2, Sum: 4.1]
         [Processed Buffers: Min: 2, Avg: 7.0, Max: 9, Diff: 7, Sum: 56]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 3.9, Avg: 4.1, Max: 4.6, Diff: 0.7, Sum: 33.0]
      [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 4.1]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 5.2, Avg: 5.2, Max: 5.3, Diff: 0.1, Sum: 42.0]
      [GC Worker End (ms): Min: 211.1, Avg: 211.1, Max: 211.2, Diff: 0.2]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.2 ms]
   [Other: 1.3 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.8 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.0 ms]
   [Eden: 52.0M(52.0M)->0.0B(299.0M) Survivors: 6144.0K->8192.0K Heap: 107.1M(512.0M)->61.7M(512.0M)]
 [Times: user=0.02 sys=0.02, real=0.01 secs] 
2022-03-13T21:21:44.938-0800: 0.394: [GC pause (G1 Evacuation Pause) (young), 0.0267685 secs]
   [Parallel Time: 18.1 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 394.6, Avg: 394.7, Max: 395.0, Diff: 0.4]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.6]
      [Update RS (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.2, Sum: 1.0]
         [Processed Buffers: Min: 0, Avg: 1.6, Max: 4, Diff: 4, Sum: 13]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.3]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 17.1, Avg: 17.4, Max: 17.6, Diff: 0.5, Sum: 138.9]
      [Termination (ms): Min: 0.0, Avg: 0.2, Max: 0.5, Diff: 0.5, Sum: 1.9]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.2]
      [GC Worker Total (ms): Min: 17.6, Avg: 17.9, Max: 18.0, Diff: 0.4, Sum: 143.0]
      [GC Worker End (ms): Min: 412.5, Avg: 412.5, Max: 412.6, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.2 ms]
   [Other: 8.5 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.7 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.5 ms]
      [Free CSet: 0.2 ms]
   [Eden: 299.0M(299.0M)->0.0B(43.0M) Survivors: 8192.0K->39.0M Heap: 448.1M(512.0M)->183.5M(1212.0M)]
 [Times: user=0.05 sys=0.06, real=0.03 secs] 
2022-03-13T21:21:44.987-0800: 0.444: [GC pause (G1 Evacuation Pause) (young), 0.0123293 secs]
   [Parallel Time: 5.5 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 443.8, Avg: 443.9, Max: 444.1, Diff: 0.3]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.7]
      [Update RS (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.2, Sum: 1.0]
         [Processed Buffers: Min: 0, Avg: 1.8, Max: 4, Diff: 4, Sum: 14]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 4.8, Avg: 4.9, Max: 5.1, Diff: 0.3, Sum: 39.0]
      [Termination (ms): Min: 0.0, Avg: 0.3, Max: 0.4, Diff: 0.4, Sum: 2.1]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 5.1, Avg: 5.4, Max: 5.5, Diff: 0.4, Sum: 42.8]
      [GC Worker End (ms): Min: 449.2, Avg: 449.3, Max: 449.3, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 6.7 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.7 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.2 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.1 ms]
   [Eden: 43.0M(43.0M)->0.0B(122.0M) Survivors: 39.0M->11.0M Heap: 235.4M(1212.0M)->192.1M(1789.0M)]
 [Times: user=0.02 sys=0.02, real=0.01 secs] 
2022-03-13T21:21:45.070-0800: 0.526: [GC pause (G1 Evacuation Pause) (young), 0.0106696 secs]
   [Parallel Time: 6.5 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 526.6, Avg: 526.6, Max: 526.7, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.3, Diff: 0.2, Sum: 1.0]
      [Update RS (ms): Min: 0.0, Avg: 0.2, Max: 0.2, Diff: 0.2, Sum: 1.4]
         [Processed Buffers: Min: 0, Avg: 2.5, Max: 4, Diff: 4, Sum: 20]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 5.3, Avg: 5.4, Max: 5.8, Diff: 0.6, Sum: 43.4]
      [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 3.7]
         [Termination Attempts: Min: 1, Avg: 1.8, Max: 3, Diff: 2, Sum: 14]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 6.2, Avg: 6.2, Max: 6.4, Diff: 0.3, Sum: 49.8]
      [GC Worker End (ms): Min: 532.8, Avg: 532.9, Max: 533.0, Diff: 0.2]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.2 ms]
   [Other: 4.0 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.1 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.2 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.1 ms]
   [Eden: 122.0M(122.0M)->0.0B(170.0M) Survivors: 11.0M->17.0M Heap: 349.5M(1789.0M)->238.0M(2251.0M)]
 [Times: user=0.02 sys=0.02, real=0.01 secs] 
2022-03-13T21:21:45.175-0800: 0.632: [GC pause (G1 Evacuation Pause) (young), 0.0173899 secs]
   [Parallel Time: 11.0 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 631.8, Avg: 631.8, Max: 631.9, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.3, Diff: 0.3, Sum: 1.0]
      [Update RS (ms): Min: 0.0, Avg: 0.2, Max: 0.3, Diff: 0.3, Sum: 1.5]
         [Processed Buffers: Min: 0, Avg: 2.6, Max: 4, Diff: 4, Sum: 21]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.2]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 9.9, Avg: 10.1, Max: 10.4, Diff: 0.5, Sum: 80.6]
      [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.7, Diff: 0.7, Sum: 3.4]
         [Termination Attempts: Min: 1, Avg: 1.8, Max: 3, Diff: 2, Sum: 14]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 10.8, Avg: 10.9, Max: 10.9, Diff: 0.1, Sum: 86.9]
      [GC Worker End (ms): Min: 642.7, Avg: 642.7, Max: 642.7, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 6.3 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 1.0 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.2 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.3 ms]
      [Free CSet: 0.4 ms]
   [Eden: 170.0M(170.0M)->0.0B(253.0M) Survivors: 17.0M->24.0M Heap: 458.2M(2251.0M)->303.4M(2620.0M)]
 [Times: user=0.03 sys=0.02, real=0.02 secs] 
2022-03-13T21:21:45.371-0800: 0.827: [GC pause (G1 Evacuation Pause) (young), 0.0216164 secs]
   [Parallel Time: 15.9 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 827.5, Avg: 827.5, Max: 827.6, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.7]
      [Update RS (ms): Min: 0.0, Avg: 0.3, Max: 0.4, Diff: 0.4, Sum: 2.1]
         [Processed Buffers: Min: 0, Avg: 3.4, Max: 5, Diff: 5, Sum: 27]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.2]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 14.3, Avg: 14.7, Max: 15.3, Diff: 1.0, Sum: 117.2]
      [Termination (ms): Min: 0.0, Avg: 0.6, Max: 0.9, Diff: 0.9, Sum: 4.5]
         [Termination Attempts: Min: 1, Avg: 1.8, Max: 3, Diff: 2, Sum: 14]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 15.5, Avg: 15.6, Max: 15.8, Diff: 0.3, Sum: 124.9]
      [GC Worker End (ms): Min: 843.0, Avg: 843.1, Max: 843.3, Diff: 0.3]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.2 ms]
   [Other: 5.5 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 1.0 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.2 ms]
      [Humongous Reclaim: 0.2 ms]
      [Free CSet: 0.1 ms]
   [Eden: 253.0M(253.0M)->0.0B(305.0M) Survivors: 24.0M->35.0M Heap: 626.1M(2620.0M)->380.5M(2916.0M)]
 [Times: user=0.05 sys=0.03, real=0.02 secs] 
2022-03-13T21:21:45.591-0800: 1.048: [GC pause (G1 Evacuation Pause) (young), 0.0150727 secs]
   [Parallel Time: 9.5 ms, GC Workers: 8]
      [GC Worker Start (ms): Min: 1048.3, Avg: 1048.6, Max: 1050.3, Diff: 2.0]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.8]
      [Update RS (ms): Min: 0.0, Avg: 0.3, Max: 0.8, Diff: 0.8, Sum: 2.3]
         [Processed Buffers: Min: 0, Avg: 2.9, Max: 4, Diff: 4, Sum: 23]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.0, Sum: 0.3]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 6.7, Avg: 8.2, Max: 8.9, Diff: 2.2, Sum: 65.5]
      [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 3.8]
         [Termination Attempts: Min: 1, Avg: 1.4, Max: 2, Diff: 1, Sum: 11]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 7.3, Avg: 9.1, Max: 9.5, Diff: 2.1, Sum: 72.7]
      [GC Worker End (ms): Min: 1057.6, Avg: 1057.7, Max: 1057.8, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 5.4 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.8 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.2 ms]
      [Humongous Reclaim: 0.3 ms]
      [Free CSet: 0.2 ms]
   [Eden: 305.0M(305.0M)->0.0B(391.0M) Survivors: 35.0M->43.0M Heap: 780.9M(2916.0M)->461.7M(3152.0M)]
 [Times: user=0.06 sys=0.01, real=0.01 secs] 
Heap
 garbage-first heap   total 3227648K, used 555236K [0x00000006c0000000, 0x00000006c0106280, 0x00000007c0000000)
  region size 1024K, 110 young (112640K), 43 survivors (44032K)
 Metaspace       used 2582K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 278K, capacity 386K, committed 512K, reserved 1048576K
```