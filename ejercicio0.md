#Ejemplo 0

1.- Comprobar que tiene instalado el JDK (8 idealmente)

2.- Descargar lucene y descomprimir (directorio generado = LUCENE_HOME)

3.- Abrir una consola y ejecutar (dentro de LUCENE_HOME):
```
> set LUCENE_HOME=(DIRECTORIO DONDE DESCOMPRIMIÓ LUCENE)
> set CLASSPATH=%LUCENE_HOME%\core\lucene-core-5.3.1.jar;%LUCENE_HOME%\analysis\common\lucene-analyzers-common-5.3.1.jar;%LUCENE_HOME%\queryparser\lucene-queryparser-5.3.1.jar;%LUCENE_HOME%\demo\lucene-demo-5.3.1.jar;.
```

NOTA: Debe cambiar la variable `5.3.1` por su versión

4.- Para indexar:
```
> java org.apache.lucene.demo.IndexFiles -docs materiales\data1
```

La carpeta `materiales\data1` puede hallarla en el repositorio

5.- Para buscar:
```
> java org.apache.lucene.demo.SearchFiles
```

6.- Analizar los ficheros:
- org\apache\lucene\demo\IndexFiles.java
- org\apache\lucene\demo\SearchFiles.java



