#Ejemplo 0

1.- Comprobar que tiene instalado el JDK (8 idealmente)

2.- Descargar lucene y descomprimir (directorio generado = LUCENE_HOME)

3.- Abrir una consola y ejecutar (dentro de LUCENE_HOME):
```
> set LUCENE_HOME=(DIRECTORIO DONDE DESCOMPRIMIÓ LUCENE)
> set CLASSPATH=%LUCENE_HOME%\core\lucene-core-{version}.jar;%LUCENE_HOME%\core\lucene-queryparser-{version}.jar;%LUCENE_HOME%\core\lucene-analyzers-common-{version}.jar:.
```

4.- Para indexar:
```
> java -jar %LUCENE_HOME%\lucene-demo-{version}.jar org.apache.lucene.demo.IndexFiles -docs misc\data
```

La carpeta misc\data puede hallarla en el repositorio

5.- Para buscar:
```
> java -jar %LUCENE_HOME%\lucene-demo-{version}.jar org.apache.lucene.demo.SearchFiles
```
