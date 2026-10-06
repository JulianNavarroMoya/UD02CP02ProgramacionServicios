# Caso Práctico 2: Programación Multihilo y Memoria Compartida

### ¿Se obtienen los resultados esperados?
* **Con 10 incrementos:** Generalmente **sí**, debido a que el volumen de iteraciones es tan pequeño que cada hebra suele finalizar sin llegar a solaparse con la otra.


* **Aumentando el número de incrementos:** **No se obtienen los resultados esperados.** El valor final casi siempre es inferior al esperado, variando en cada ejecución.


### Justificación del comportamiento observado

1. **Condición de carrera:** Al compartir memoria, ambas hebras intentan leer y modificar la misma variable sin coordinación.


2. **Intercalación del planificador:** Si la `Hebra 1` lee el valor `5` y se produce un cambio de contexto antes de escribir el resultado, la `Hebra 2` puede leer también `5`, incrementarlo a `6` y escribirlo. Cuando la `Hebra 1` retoma su turno, sobreescribe la memoria con su propio `6`, provocando la pérdida de un incremento.