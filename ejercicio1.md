# Ejercicio 1

1.- Implementar un programa en Java que pida por consola una consulta a realizar (formato Lucene) y muestre los resultados en pantalla (nombre del archivo). Debe utilizar el analizador estándar para textos en Español

Debe probar la clase al menos con los siguientes tipos de query:

- De término (Ej. hola)
- De frase (Ej. "hola mundo")
- De frase con slop (Ej. hola hola~1)
- De rango (Ej. [hola TO hola]) - incluyente y excluyente
- Fuzzy (Ej. jola~)
- Boolean (Ej. (hola AND mundo) OR mundo)
- De prefijo con comodines (Ej. h?l? m*)

NOTA: Utilizar los archivos de `materiales/data2`
