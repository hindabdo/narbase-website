
## How to run
- Run server build and client build continuously `./gradlew runDev -t --parallel`

### Build server
- Run continuous build `./gradlew -t :bos-server:build`
- Run project from IDEA


### To deploy
- Ensure web output is File("${projectDir.parent}/public/js/client/") in bos-web build.gradle.kts
- Stop web run -t and execute `./gradlew :bos-web:build`
- In Server, change bos-web.js path to `/public/js/client/bos-web.js`
- In server, disable live.js