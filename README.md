# scala-graalvm


### Requisites
- SBT
- GraalVM
- Native image (`gu install native-image`)

Generate the binary with:

```
sbt graalvm-native-image:packageBin
```

And then execute:
```
./target/graalvm-native-image/scala-graalvm
```

Inpired by [@vmencik project](https://github.com/vmencik/akka-graal-native).
