# Threads
TIME: 631/20 = 31.55
## DATAGRAMAS (can find it in previus lab :D).

https://github.com/novenix/NetworkClient

(This work was based on httpserver from previus lab)
## ThreadPool (its improved with threadpools from previus lab)

    you can invoke http://localhost:35000/mypage.html to see a beauty image of the universe

this server also is boostraped, you can see the styles in action in:

    http://localhost:35000/album/index.html

to run pls

    java -cp networkClient-1.0-SNAPSHOT.jar edu.escuelaing.edu.co.httpServer.HttpServer
i ran this to get html tests in jmeter:

    jmeter -n -t C:\Users\Acer\Desktop\escuela\inter\LabHilosConcurrentes\NetworkClient\hilosServer\resultadosbien.jmx -l C:\Users\Acer\Desktop\escuela\inter\LabHilosConcurrentes\NetworkClient\hilosServer\resultados\result4.csv -e -o C:\Users\Acer\Desktop\escuela\inter\LabHilosConcurrentes\NetworkClient\hilosServer\htmltests

in html test folder you can find the test concurrency results, the test were created in jmeter
you can find test concurrency in:

    /htmltests
    /resultados (for excel)
    resultadosbien.jmx (jmeter file)

17/June/2021


## License

MIT

**Nicolás Torres Páez**
**colombia school of engineering Julio Garavito**

